package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import com.feysh.corax.config.api.utils.UtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.tagkit.VisibilityParameterAnnotationTag;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public final class BaseSootMethodDecl<R> implements ISootMethodDecl<R>, IMethodDecl<R> {
    @NotNull
    private final IMethodDecl<R> delegate;
    @NotNull
    private final ISootClassDecl clazz;
    @NotNull
    private final SootMethod sootMethod;

    public BaseSootMethodDecl(@NotNull IMethodDecl<R> delegate, @NotNull ISootClassDecl clazz, @NotNull SootMethod sootMethod) {
        if (delegate == null) throw new IllegalArgumentException("delegate cannot be null");
        if (clazz == null) throw new IllegalArgumentException("clazz cannot be null");
        if (sootMethod == null) throw new IllegalArgumentException("sootMethod cannot be null");
        
        this.delegate = delegate;
        this.clazz = clazz;
        this.sootMethod = sootMethod;
    }

    @NotNull
    public IMethodDecl<R> getDelegate() {
        return delegate;
    }

    @Override
    @NotNull
    public ISootClassDecl getClazz() {
        return clazz;
    }

    @Override
    @NotNull
    public SootMethod getSootMethod() {
        return sootMethod;
    }

    @Override
    @NotNull
    public KFunctionType getActualType() {
        return UtilsKt.getFunctionType(getSootMethod());
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return getSootMethod().getParameterCount();
    }

    @Override
    @NotNull
    public String toString() {
        return "soot decl: " + getSootMethod();
    }

    @Override
    @NotNull
    public CheckBuilder<R> checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        return new CheckBuilder<>(this, delegate.checkBuilder(config));
    }

    @Override
    @NotNull
    public SootClass getSootClass() {
        return ISootMethodDecl.super.getSootClass();
    }

    @Override
    @Nullable
    public VisibilityParameterAnnotationTag getParameterAnnotationTag() {
        return ISootMethodDecl.super.getParameterAnnotationTag();
    }

    @Override
    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag(@NotNull IParameterT<?> parameter) {
        return ISootMethodDecl.super.getVisibilityAnnotationTag(parameter);
    }

    @Override
    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag() {
        return ISootMethodDecl.super.getVisibilityAnnotationTag();
    }

    @Override
    @NotNull
    public List<AnnotationTag> getAnnotationTag(@NotNull IParameterT<?> parameter) {
        return ISootMethodDecl.super.getAnnotationTag(parameter);
    }

    @Override
    @Nullable
    public AnnotationTag getAnnotationTag() {
        return ISootMethodDecl.super.getAnnotationTag();
    }

    @Override
    @NotNull
    public List<Tag> getTags() {
        return ISootMethodDecl.super.getTags();
    }

    @Override
    @NotNull
    public IMethodMatch getMatch() {
        return delegate.getMatch();
    }

    @Override
    @NotNull
    public AIAnalysisApi.Error getError() {
        return delegate.getError();
    }

    @Override
    public void eachLocalVar(@NotNull Function<ISootLocalVarDecl<Object>, Void> block) {
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        delegate.eachLocalVar(block);
    }

    public final class CheckBuilder<R> implements ISootMethodDecl.CheckBuilder<R>, IMethodDecl.CheckBuilder<R> {
        private final IMethodDecl.CheckBuilder<R> delegate;
        @NotNull
        private final ISootMethodDecl<R> method;
        @NotNull
        private final SootReturn<R> returnValue;

        public CheckBuilder(@NotNull ISootMethodDecl<R> method, IMethodDecl.CheckBuilder<R> delegate) {
            if (method == null) throw new IllegalArgumentException("method cannot be null");
            if (delegate == null) throw new IllegalArgumentException("delegate cannot be null");
            
            this.delegate = delegate;
            this.method = method;
            this.returnValue = new SootReturn<>(BaseSootMethodDecl.this.getSootMethod());
        }

        @Override
        @NotNull
        public ISootMethodDecl<R> getMethod() {
            return method;
        }

        @Override
        @NotNull
        public <T> SootParameter<T> paramAt(int index) {
            int argumentCnt = BaseSootMethodDecl.this.getArgumentCnt();
            if (index >= argumentCnt) {
                BaseSootMethodDecl.this.getError().error("parameter index \"" + index + "\" out of range. argument count is " + argumentCnt + " of method: " + BaseSootMethodDecl.this.getSootMethod() + ".");
            }
            return new SootParameter<>(index, BaseSootMethodDecl.this.getSootMethod());
        }

        @Override
        @NotNull
        public SootReturn<R> getReturn() {
            return returnValue;
        }

        // Delegate methods
        @Override
        public void addStmt(@NotNull IStmt stmt) {
            delegate.addStmt(stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function<BugMessage.Env, Void> env) {
            delegate.check(expr, checkType, env);
        }

        // Other delegate methods omitted for brevity...
        // They would follow the same pattern of delegating to the underlying delegate object
    }
}
