package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.report.Counter;
import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.check.callback.*;
import cn.sast.dataflow.util.SootUtilsKt;
import cn.sast.idfa.analysis.*;
import cn.sast.idfa.check.CallBackManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.*;
import soot.jimple.*;
import soot.toolkits.graph.*;
import java.util.*;
import java.util.concurrent.CancellationException;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class ACheckCallAnalysis extends AJimpleInterProceduralAnalysis<IValue, AIContext> {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ACheckCallAnalysis.class);
    
    @NotNull
    private final CallBackManager callBackManager;
    @NotNull
    private final List<SummaryHandlePackage<IValue>> summaries;
    @NotNull
    private final Counter<SootMethod> excludeMethods;

    public ACheckCallAnalysis(@NotNull AbstractHeapFactory<IValue> hf, @NotNull InterproceduralCFG icfg) {
        super(hf, icfg);
        this.callBackManager = new CallBackManager();
        this.summaries = new ArrayList<>();
        this.excludeMethods = new Counter<>();
    }

    @NotNull
    public final CallBackManager getCallBackManager() {
        return callBackManager;
    }

    @NotNull
    public final List<SummaryHandlePackage<IValue>> getSummaries() {
        return summaries;
    }

    public final void registerWrapper(@NotNull String smr, boolean isStatic) {
        registerWrapper(SootUtilsKt.sootSignatureToRef(smr, isStatic));
    }

    public final void registerWrapper(@NotNull SootMethodRef smr) {
        try {
            SootMethod sm = smr.resolve();
            Body body = sm.retrieveActiveBody();
            if (body != null) {
                UnitGraph ug = new BriefUnitGraph(body);
                registerJimpleWrapper(sm.getSignature(), ug);
            }
        } catch (Exception ignored) {
        }
    }

    public final void registerClassAllWrapper(@NotNull String sc) {
        SootClass sootClass = Scene.v().getSootClassUnsafe(sc, true);
        registerClassAllWrapper(sootClass);
    }

    public final void registerClassAllWrapper(@NotNull SootClass sc) {
        for (SootMethod sm : sc.getMethods()) {
            if (sm.getSource() == null && !sm.hasActiveBody()) {
                logger.warn(() -> "method source of " + sm + " is null");
                continue;
            }
            Scene.v().forceResolve(sm.getDeclaringClass().getName(), 3);
            if (sm.retrieveActiveBody() != null) {
                UnitGraph ug = new BriefUnitGraph(sm.retrieveActiveBody());
                registerJimpleWrapper(sm.getSignature(), ug);
            }
        }
    }

    public final void evalCallAtCaller(@NotNull String methodSignature, 
            @NotNull Function<CallerSiteCBImpl.EvalCall, Unit> prevCall) {
        SootMethod sm = Scene.v().grabMethod(methodSignature);
        if (sm != null) {
            callBackManager.put(CallerSiteCBImpl.EvalCall.class, sm, 
                (cb, call) -> { prevCall.apply((CallerSiteCBImpl.EvalCall)call); return Unit.INSTANCE; });
        }
    }

    public final void evalCall(@NotNull String methodSignature, 
            @NotNull Function<CalleeCBImpl.EvalCall, Unit> evalCall) {
        SootMethod sm = Scene.v().grabMethod(methodSignature);
        if (sm != null) {
            callBackManager.put(CalleeCBImpl.EvalCall.class, sm,
                (cb, call) -> { evalCall.apply((CalleeCBImpl.EvalCall)call); return Unit.INSTANCE; });
        }
    }

    public final void postCallAtCaller(@NotNull String methodSignature, 
            @NotNull Function<CallerSiteCBImpl.PostCall, Unit> postCall) {
        SootMethod sm = Scene.v().grabMethod(methodSignature);
        if (sm != null) {
            callBackManager.put(CallerSiteCBImpl.PostCall.class, sm,
                (cb, call) -> { postCall.apply((CallerSiteCBImpl.PostCall)call); return Unit.INSTANCE; });
        }
    }

    public final void registerJimpleWrapper(@NotNull String methodSignature, @NotNull UnitGraph jimple) {
        SootMethod sm = Scene.v().grabMethod(methodSignature);
        if (sm != null) {
            callBackManager.putUnitGraphOverride(sm, jimple);
        }
    }

    @Override
    public void doAnalysis(@NotNull Collection<? extends SootMethod> entries) {
        super.doAnalysis(entries);
        excludeMethods.clear();
    }

    @Override
    public void doAnalysis(@NotNull Collection<? extends SootMethod> entries, 
            @NotNull Collection<? extends SootMethod> methodsMustAnalyze) {
        summaries.forEach(summary -> summary.register(this));
        super.doAnalysis(entries, methodsMustAnalyze);
    }

    @Override
    @NotNull
    public DirectedGraph<Unit> getCfg(@NotNull SootMethod method, boolean isAnalyzable) {
        UnitGraph override = callBackManager.getUnitGraphOverride(method);
        return override != null ? override : super.getCfg(method, isAnalyzable);
    }

    public final void returnPhantom(@NotNull HeapValuesEnv env, @NotNull Stmt node, 
            @NotNull IFact.Builder<IValue> builder) {
        if (node.containsInvokeExpr()) {
            InvokeExpr invokeExpr = node.getInvokeExpr();
            if (invokeExpr instanceof InstanceInvokeExpr) {
                Value base = ((InstanceInvokeExpr)invokeExpr).getBase();
                builder.summarizeTargetFields((Local)base);
            }
            for (int i = 0; i < invokeExpr.getArgCount(); i++) {
                Value arg = invokeExpr.getArg(i);
                if (arg instanceof Local) {
                    builder.summarizeTargetFields(arg);
                }
            }
        }
        if (node instanceof DefinitionStmt && ((DefinitionStmt)node).getLeftOp() != null) {
            Value lhs = ((DefinitionStmt)node).getLeftOp();
            if (lhs instanceof Local) {
                AbstractHeapFactory<IValue> hf = getHf();
                Type type = ((DefinitionStmt)node).getRightOp().getType();
                builder.assignNewExpr(env, lhs, 
                    hf.push(env, hf.newSummaryVal(env, type, lhs))
                      .markSummaryReturnValueFailedInHook()
                      .popHV(), 
                    false);
            } else {
                throw new RuntimeException(lhs.toString());
            }
        }
    }

    @Override
    public boolean isAnalyzable(@NotNull SootMethod callee, @NotNull IFact<IValue> in1) {
        if (callBackManager.getUnitGraphOverride(callee) != null) {
            return true;
        }
        if (!super.isAnalyzable(callee, in1)) {
            return false;
        }
        if (ACheckCallAnalysisKt.getExcludeSubSignature().contains(callee.getSubSignature())) {
            return false;
        }
        int hit = excludeMethods.get(callee);
        if (hit > 0) {
            if (callee.getDeclaringClass().isApplicationClass()) {
                if (hit > 2) {
                    return false;
                }
            } else {
                return false;
            }
        }
        DirectedGraph<Unit> cfg = getCfg(callee, true);
        int sizeLimit = ExtSettings.INSTANCE.getDataFlowMethodUnitsSizeLimit();
        return sizeLimit <= 0 || cfg.size() <= sizeLimit;
    }

    @NotNull
    public final Counter<SootMethod> getExcludeMethods() {
        return excludeMethods;
    }

    public void skip(@NotNull SootMethod callee) {
        excludeMethods.count(callee);
    }
}
