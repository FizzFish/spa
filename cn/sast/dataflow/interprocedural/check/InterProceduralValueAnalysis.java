package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import cn.sast.idfa.analysis.InterproceduralCFG;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.*;
import soot.jimple.*;
import java.util.*;
import java.util.stream.Collectors;

public abstract class InterProceduralValueAnalysis extends ACheckCallAnalysis {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(InterProceduralValueAnalysis.class);
    private final IFact<IValue> bottom;

    public InterProceduralValueAnalysis(@NotNull IVGlobal vg, @NotNull AbstractHeapFactory<IValue> hf, @NotNull InterproceduralCFG icfg) {
        super(hf, icfg);
        NopStmt unit = Jimple.v().newNopStmt();
        SootMethod method = Scene.v().makeSootMethod("initConstantPoolObjectData", Collections.emptyList(), G.v().soot_VoidType());
        CallStackContext callStackContext = new CallStackContext(null, unit, method, 0);
        hf.setConstantPoolObjectData(getTopState(callStackContext).builder());
        this.bottom = createBottomValue();
    }

    private IFact<IValue> createBottomValue() {
        return new IFact<>() {
            @Override public boolean isBottom() { return true; }
            @Override public boolean isTop() { return false; }
            @Override public boolean isValid() { return false; }
            @Override public Builder builder() { throw new UnsupportedOperationException(); }
        };
    }

    private IFact<IValue> getTopState(CallStackContext callStackContext) {
        return new IFact<>() {
            @Override public boolean isBottom() { return false; }
            @Override public boolean isTop() { return true; }
            @Override public boolean isValid() { return true; }
            @Override public Builder builder() { return getHf().createBuilder(); }
        };
    }

    @NotNull
    public IFact<IValue> boundaryValue(@NotNull SootMethod entryPoint) {
        if (!entryPoint.isConcrete() || !entryPoint.hasActiveBody()) {
            return bottom;
        }

        Unit entryUnit = entryPoint.getActiveBody().getUnits().getFirst();
        CallStackContext callStackContext = new CallStackContext(null, entryUnit, entryPoint, 0);
        IFact<IValue> top = getTopState(callStackContext);
        IFact.Builder entryValue = top.builder();

        int paramCount = entryPoint.getParameterCount();
        for (int argIndex = 0; argIndex < paramCount; argIndex++) {
            Body body = entryPoint.getActiveBody();
            Unit unit = AJimpleInterProceduralAnalysisKt.getParameterUnit(body, argIndex);
            if (unit == null) unit = entryUnit;
            
            HeapValuesEnv env = getHf().env(unit);
            entryValue.assignNewExpr(env, argIndex, 
                getHf().push(env, new EntryParam(entryPoint, argIndex))
                    .markOfEntryMethodParam(entryPoint)
                    .popHV(), 
                false);
        }

        if (!entryPoint.isStatic()) {
            Body body = entryPoint.getActiveBody();
            Unit unit = AJimpleInterProceduralAnalysisKt.getParameterUnit(body, -1);
            if (unit == null) unit = entryUnit;
            
            HeapValuesEnv env = getHf().env(unit);
            entryValue.assignNewExpr(env, -1, 
                getHf().push(env, new EntryParam(entryPoint, -1))
                    .markOfEntryMethodParam(entryPoint)
                    .popHV(), 
                false);
        }

        getHf().getVg().setStaticFieldTrackingMode(getStaticFieldTrackingMode());
        if (getStaticFieldTrackingMode() != StaticFieldTrackingMode.None) {
            HeapValuesEnv env = getHf().env(entryUnit);
            entryValue.assignNewExpr(env, getHf().getVg().getGLOBAL_LOCAL(), 
                getHf().push(env, getHf().getVg().getGLOBAL_SITE())
                    .markOfEntryMethodParam(entryPoint)
                    .popHV(), 
                false);
        }

        return entryValue.build();
    }

    @NotNull
    public IFact<IValue> copy(@NotNull IFact<IValue> src) {
        return src;
    }

    @NotNull
    public IFact<IValue> meet(@NotNull IFact<IValue> op1, @NotNull IFact<IValue> op2) {
        if (op1.isBottom()) return op2;
        if (op2.isBottom()) return op1;
        if (op1.isTop()) return op2;
        if (op2.isTop()) return op1;
        if (op1 == op2) return op1;

        IFact.Builder builder = op1.builder();
        builder.union(op2);
        return builder.build();
    }

    @NotNull
    public IFact<IValue> shallowMeet(@NotNull IFact<IValue> op1, @NotNull IFact<IValue> op2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @NotNull
    public IFact<IValue> merge(@NotNull IFact<IValue> local, @NotNull IFact<IValue> ret) {
        return ret;
    }

    @NotNull
    public IFact<IValue> bottomValue() {
        return bottom;
    }

    @NotNull
    public AnyNewExprEnv newExprEnv(@NotNull AIContext context, @NotNull Unit node, @NotNull IFact<IValue> inValue) {
        return new AnyNewExprEnv(context.getMethod(), node);
    }

    public final boolean isRecursive(@NotNull SootMethod callee, @NotNull IFact<IValue> inValue) {
        PointsToGraphAbstract g = (PointsToGraphAbstract) inValue;
        Set<SootMethod> visited = new LinkedHashSet<>();
        for (CallStackContext cur = g.getCallStack(); cur != null; cur = cur.getCaller()) {
            if (!visited.add(cur.getMethod())) {
                return true;
            }
        }
        return false;
    }

    public boolean isAnalyzable(@NotNull SootMethod callee, @NotNull IFact<IValue> in1) {
        return super.isAnalyzable(callee, in1) && !isRecursive(callee, in1);
    }

    @NotNull
    public Set<SootMethod> resolveTargets(@NotNull SootMethod callerMethod, @NotNull InvokeExpr ie, 
            @NotNull Unit node, @NotNull IFact<IValue> inValue) {
        if (ie instanceof StaticInvokeExpr || ie instanceof DynamicInvokeExpr) {
            return Collections.singleton(ie.getMethod());
        }

        Set<SootMethod> targets = new HashSet<>();
        Local receiver = (Local) ((InstanceInvokeExpr) ie).getBase();
        IHeapValues heapNodes = inValue.getTargetsUnsafe(receiver);

        if (heapNodes != null && heapNodes.isNotEmpty()) {
            for (IValue v : heapNodes.getValues()) {
                Type type = v.getType();
                if (!(type instanceof RefLikeType)) continue;

                RefLikeType likeType = v.typeIsConcrete() ? (RefLikeType) type : 
                    (type instanceof RefType ? (RefType) type : Scene.v().getObjectType());

                Iterator<SootMethod> iter = SootUtilsKt.getCallTargets(likeType, callerMethod, ie, false);
                while (iter.hasNext()) {
                    targets.add(iter.next());
                }
            }
        }

        if (targets.isEmpty()) {
            for (SootMethod target : resolveTargets(callerMethod, node)) {
                targets.add(target);
            }
        }

        if (targets.isEmpty()) {
            return Collections.singleton(((InstanceInvokeExpr) ie).getMethod());
        }

        long maxTargets = ExtSettings.INSTANCE.getDataFlowResolveTargetsMaxNum();
        if (maxTargets >= 0 && targets.size() >= maxTargets) {
            logger.debug(() -> String.format("Too many callee at %s. size: %d. in %s line:%d", 
                node, targets.size(), callerMethod, node.getJavaSourceStartLineNumber()));
            return Collections.singleton(((InstanceInvokeExpr) ie).getMethod());
        }

        return targets;
    }

    @NotNull
    public FixPointStatus hasChange(@NotNull AIContext context, @NotNull Unit node, 
            @NotNull Unit succ, @NotNull IFact<IValue> old, @NotNull IFact<IValue> newFact) {
        Map<Unit, Integer> iteratorCount = context.getIteratorCount();
        int count = iteratorCount.getOrDefault(node, 0) + 1;
        iteratorCount.put(node, count);

        if (!newFact.isValid()) {
            return FixPointStatus.HasChange;
        }

        boolean isAppClass = context.getMethod().getDeclaringClass().isApplicationClass();
        int threshold = isAppClass ? 
            ExtSettings.INSTANCE.getDataFlowIteratorCountForAppClasses() : 
            ExtSettings.INSTANCE.getDataFlowIteratorCountForLibClasses();

        if (count < threshold) {
            return old.hasChange(context, newFact);
        }

        Set<Pair<Unit, Unit>> widenNodes = context.getWidenNode();
        if (widenNodes.add(new Pair<>(node, succ))) {
            return FixPointStatus.NeedWideningOperators;
        }

        return FixPointStatus.Fixpoint;
    }
}
