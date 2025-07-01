package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.baseimpl.*;
import java.util.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.*;
import soot.jimple.JimpleBody;

public class MethodDeclBase<R> implements IMethodDecl<R> {
    @NotNull
    private final AIAnalysisBaseImpl analyzeConfig;
    @NotNull
    private final IMethodMatch match;
    @NotNull
    private final AIAnalysisApi.Error error;

    public MethodDeclBase(@NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull IMethodMatch match, @NotNull AIAnalysisApi.Error error) {
        if (analyzeConfig == null) throw new IllegalArgumentException("analyzeConfig cannot be null");
        if (match == null) throw new IllegalArgumentException("match cannot be null");
        if (error == null) throw new IllegalArgumentException("error cannot be null");
        
        this.analyzeConfig = analyzeConfig;
        this.match = match;
        this.error = error;
    }

    public MethodDeclBase(@NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull IMethodMatch match) {
        this(analyzeConfig, match, analyzeConfig.getError());
    }

    @Override
    @NotNull
    public AIAnalysisBaseImpl getAnalyzeConfig() {
        return analyzeConfig;
    }

    @Override
    @NotNull
    public IMethodMatch getMatch() {
        return match;
    }

    @Override
    @NotNull
    public AIAnalysisApi.Error getError() {
        return error;
    }

    @Override
    public void eachLocalVar(@NotNull LocalVarProcessor block) {
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        
        Scene scene = Scene.v();
        for (SootMethod sm : getMatch().matched(scene)) {
            if (!sm.hasActiveBody()) continue;
            
            Body body = sm.getActiveBody();
            if (!(body instanceof JimpleBody)) continue;
            
            JimpleBody jimpleBody = (JimpleBody) body;
            for (Local local : jimpleBody.getLocals()) {
                BaseLocalVarDecl baseLocal = new BaseLocalVarDecl(getAnalyzeConfig(), new ILocalVarMatch() {
                    @Override
                    public List<Local> matched(Scene scene) {
                        return Collections.singletonList(local);
                    }
                });
                BaseSootLocalVarDecl sootLocal = new BaseSootLocalVarDecl(baseLocal, local);
                block.process(sootLocal);
            }
        }
    }

    @Override
    @NotNull
    public CheckBuilder<R> checkBuilder(@NotNull MethodConfigProcessor config) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        return new CheckBuilder<>(config, this);
    }

    @Override
    @NotNull
    public String toString() {
        return "method decl: " + getMatch();
    }

    @Override
    @Nullable
    public Integer getArgumentCnt() {
        return null; // Default implementation
    }

    @Override
    @Nullable
    public KFunctionType getActualType() {
        return null; // Default implementation
    }

    public final class CheckBuilder<R> implements IMethodDecl.CheckBuilder<R>, IBaseOperatorFactory {
        @NotNull
        private final MethodConfigProcessor config;
        @NotNull
        private final IMethodDecl<R> method;
        @NotNull
        private final IReturnT<R> returnT;
        @NotNull
        private final ILocalT<Object> global;

        public CheckBuilder(@NotNull MethodConfigProcessor config, @NotNull IMethodDecl<R> method) {
            if (config == null) throw new IllegalArgumentException("config cannot be null");
            if (method == null) throw new IllegalArgumentException("method cannot be null");
            
            this.config = config;
            this.method = method;
            this.returnT = new Return<>();
            this.global = Global.INSTANCE;
        }

        @Override
        @NotNull
        public MethodConfigProcessor getConfig() {
            return config;
        }

        @Override
        @NotNull
        public IMethodDecl<R> getMethod() {
            return method;
        }

        @Override
        @NotNull
        public <T> IParameterT<T> paramAt(int index) {
            Integer argumentCnt = MethodDeclBase.this.getArgumentCnt();
            if (argumentCnt != null && index >= argumentCnt) {
                MethodDeclBase.this.getError().error("parameter index \"" + index + "\" out of range. argument count is " + argumentCnt + " of method: " + MethodDeclBase.this.getMatch() + ".");
            }
            return new Parameter<>(index);
        }

        @Override
        @NotNull
        public IReturnT<R> getReturn() {
            return returnT;
        }

        @Override
        @NotNull
        public ILocalT<Object> getGlobal() {
            return global;
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            if (stmt == null) throw new IllegalArgumentException("stmt cannot be null");
            MethodDeclBase.this.getAnalyzeConfig().addStmt(MethodDeclBase.this, getConfig(), stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull BugMessageProcessor env) {
            if (expr == null) throw new IllegalArgumentException("expr cannot be null");
            if (checkType == null) throw new IllegalArgumentException("checkType cannot be null");
            if (env == null) throw new IllegalArgumentException("env cannot be null");
            
            MethodDeclBase.this.getAnalyzeConfig().check(MethodDeclBase.this, getConfig(), expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull ResultProcessor result) {
            if (expr == null) throw new IllegalArgumentException("expr cannot be null");
            if (result == null) throw new IllegalArgumentException("result cannot be null");
            
            MethodDeclBase.this.getAnalyzeConfig().eval(MethodDeclBase.this, getConfig(), expr, result);
        }

        // Remaining operator factory methods would follow similar patterns
        // but are omitted for brevity in this example
    }

    @FunctionalInterface
    public interface LocalVarProcessor {
        void process(ISootLocalVarDecl<?> localVariable);
    }

    @FunctionalInterface
    public interface MethodConfigProcessor {
        void process(MethodConfig config);
    }

    @FunctionalInterface
    public interface BugMessageProcessor {
        void process(BugMessage.Env env);
    }

    @FunctionalInterface
    public interface ResultProcessor {
        void process(Object result);
    }
}
