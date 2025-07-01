package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.api.config.MainConfig;
import cn.sast.common.GLB;
import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.callback.*;
import cn.sast.dataflow.interprocedural.check.checker.CheckCallBack;
import cn.sast.dataflow.interprocedural.check.checker.ModelingCallBack;
import cn.sast.dataflow.util.ConfigInfoLogger;
import cn.sast.idfa.analysis.InterproceduralCFG;
import cn.sast.idfa.check.CallBackManager;
import com.feysh.corax.cache.coroutines.FastCache;
import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class CheckerModeling extends AIAnalysisBaseImpl implements SummaryHandlePackage<IValue>, IAnalysisDepends {
    private static final class WhenMappings {
        static final int[] $EnumSwitchMapping$0 = new int[MethodConfig.CheckCall.values().length];
        static {
            $EnumSwitchMapping$0[MethodConfig.CheckCall.PrevCallInCaller.ordinal()] = 1;
            $EnumSwitchMapping$0[MethodConfig.CheckCall.EvalCallInCaller.ordinal()] = 2;
            $EnumSwitchMapping$0[MethodConfig.CheckCall.PostCallInCaller.ordinal()] = 3;
            $EnumSwitchMapping$0[MethodConfig.CheckCall.PrevCallInCallee.ordinal()] = 4;
            $EnumSwitchMapping$0[MethodConfig.CheckCall.EvalCallInCallee.ordinal()] = 5;
            $EnumSwitchMapping$0[MethodConfig.CheckCall.PostCallInCallee.ordinal()] = 6;
        }
    }

    public static final class Checker {
        private final SootMethod atMethod;
        private final Function<MethodConfig, Void> config;
        private final IBoolExpr expr;
        private final CheckType checkType;
        private final Consumer<BugMessage.Env> env;

        public Checker(SootMethod atMethod, Function<MethodConfig, Void> config, 
                      IBoolExpr expr, CheckType checkType, Consumer<BugMessage.Env> env) {
            this.atMethod = atMethod;
            this.config = config;
            this.expr = expr;
            this.checkType = checkType;
            this.env = env;
        }

        public SootMethod getAtMethod() {
            return atMethod;
        }

        public Function<MethodConfig, Void> getConfig() {
            return config;
        }

        public IBoolExpr getExpr() {
            return expr;
        }

        public CheckType getCheckType() {
            return checkType;
        }

        public Consumer<BugMessage.Env> getEnv() {
            return env;
        }
    }

    private final MainConfig mainConfig;
    private final InterproceduralCFG icfg;
    private final PreAnalysisApi preAnalysis;
    private final List<Triple<SootMethod, Function<MethodConfig, Void>, IStmt>> summaries = new ArrayList<>();
    private final List<Checker> checkPoints = new ArrayList<>();
    private final ConfigInfoLogger error = new ConfigInfoLogger();

    public CheckerModeling(@NotNull MainConfig mainConfig, @NotNull InterproceduralCFG icfg, @NotNull PreAnalysisApi preAnalysis) {
        this.mainConfig = mainConfig;
        this.icfg = icfg;
        this.preAnalysis = preAnalysis;
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @NotNull
    public InterproceduralCFG getIcfg() {
        return icfg;
    }

    @Override
    @NotNull
    public PreAnalysisApi getPreAnalysis() {
        return preAnalysis;
    }

    @Override
    @NotNull
    public FastCache getFastCache() {
        return FastCacheImpl.INSTANCE;
    }

    @Override
    public void register(@NotNull ACheckCallAnalysis analysis) {
        getLogger().info(() -> "summaries model size: " + summaries.size());

        for (Triple<SootMethod, Function<MethodConfig, Void>, IStmt> triple : summaries) {
            SootMethod method = triple.getFirst();
            Function<MethodConfig, Void> config = triple.getSecond();
            IStmt stmt = triple.getThird();

            MethodConfig imp = new MethodConfig(MethodConfig.CheckCall.PostCallInCaller);
            config.apply(imp);
            ModelingCallBack cb = new ModelingCallBack(method, stmt);

            CallBackManager manager = analysis.getCallBackManager();
            switch (WhenMappings.$EnumSwitchMapping$0[imp.getAt().ordinal()]) {
                case 1:
                    manager.put(CallerSiteCBImpl.PrevCall.class, method, (caller, args) -> cb.onPrevCall(caller, args));
                    break;
                case 2:
                    manager.put(CallerSiteCBImpl.EvalCall.class, method, (caller, args) -> cb.onEvalCall(caller, args));
                    break;
                case 3:
                    manager.put(CallerSiteCBImpl.PostCall.class, method, (caller, args) -> cb.onPostCall(caller, args));
                    break;
                case 4:
                    manager.put(CalleeCBImpl.PrevCall.class, method, (callee, args) -> cb.onPrevCall(callee, args));
                    break;
                case 5:
                    manager.put(CalleeCBImpl.EvalCall.class, method, (callee, args) -> cb.onEvalCall(callee, args));
                    break;
                case 6:
                    manager.put(CalleeCBImpl.PostCall.class, method, (callee, args) -> cb.onPostCall(callee, args));
                    break;
                default:
                    throw new IllegalStateException("Unexpected check call type");
            }
        }

        getLogger().info(() -> "check-points size: " + checkPoints.size());

        for (Checker checker : checkPoints) {
            MethodConfig imp = new MethodConfig(MethodConfig.CheckCall.PostCallInCaller);
            checker.getConfig().apply(imp);
            CheckCallBack cb = new CheckCallBack(checker.getAtMethod(), checker);

            CallBackManager manager = analysis.getCallBackManager();
            switch (WhenMappings.$EnumSwitchMapping$0[imp.getAt().ordinal()]) {
                case 1:
                    manager.put(CallerSiteCBImpl.PrevCall.class, checker.getAtMethod(), 
                              (caller, args) -> cb.onPrevCall(caller, args));
                    break;
                case 2:
                    manager.put(CallerSiteCBImpl.EvalCall.class, checker.getAtMethod(), 
                              (caller, args) -> cb.onEvalCall(caller, args));
                    break;
                case 3:
                    manager.put(CallerSiteCBImpl.PostCall.class, checker.getAtMethod(), 
                              (caller, args) -> cb.onPostCall(caller, args));
                    break;
                case 4:
                    manager.put(CalleeCBImpl.PrevCall.class, checker.getAtMethod(), 
                              (callee, args) -> cb.onPrevCall(callee, args));
                    break;
                case 5:
                    manager.put(CalleeCBImpl.EvalCall.class, checker.getAtMethod(), 
                              (callee, args) -> cb.onEvalCall(callee, args));
                    break;
                case 6:
                    manager.put(CalleeCBImpl.PostCall.class, checker.getAtMethod(), 
                              (callee, args) -> cb.onPostCall(callee, args));
                    break;
                default:
                    throw new IllegalStateException("Unexpected check call type");
            }
        }
    }

    public void addStmt(@NotNull IJDecl decl, @NotNull Function<MethodConfig, Void> config, @NotNull IStmt stmt) {
        if (decl instanceof IMethodDecl) {
            List<SootMethod> sootMethods = ((IMethodDecl) decl).getMatch().matched(Scene.v());
            synchronized (summaries) {
                for (SootMethod method : sootMethods) {
                    summaries.add(new Triple<>(method, config, stmt));
                }
            }
        } else {
            getLogger().debug(() -> "TODO: decl: " + decl + " not support");
        }
    }

    public void check(@NotNull IJDecl decl, @NotNull Function<MethodConfig, Void> config, 
                     @NotNull IBoolExpr expr, @NotNull CheckType checkType, 
                     @NotNull Consumer<BugMessage.Env> env) {
        GLB.INSTANCE.plusAssign(checkType);
        if (!mainConfig.isEnable(checkType)) {
            return;
        }

        if (decl instanceof IMethodDecl) {
            List<SootMethod> sootMethods = ((IMethodDecl) decl).getMatch().matched(Scene.v());
            synchronized (checkPoints) {
                for (SootMethod method : sootMethods) {
                    checkPoints.add(new Checker(method, config, expr, checkType, env));
                }
            }
        } else {
            getLogger().error(() -> "TODO: decl: " + decl + " not support");
        }
    }

    @Override
    public void eval(@NotNull IJDecl decl, @NotNull Function<MethodConfig, Void> config, 
                    @NotNull IExpr expr, @NotNull Function<Object, Void> accept) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void validate() {
        // No validation needed
    }

    @Override
    @NotNull
    public ConfigInfoLogger getError() {
        return error;
    }

    // Other IAnalysisDepends methods would be implemented similarly
}
