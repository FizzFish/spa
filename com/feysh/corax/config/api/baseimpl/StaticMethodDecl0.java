package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public final class StaticMethodDecl0<R> implements ISMethodDecl0<R>, ISMethodDecl<R> {
    @NotNull
    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl0(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl0(@NotNull ISMethodDecl<R> base) {
        this(base, 0);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public ISMethodDecl0.CheckBuilder<R> checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderDelegate<>(this, config);
    }

    @Override
    @NotNull
    public ISMethodDecl0<R> model(@NotNull Function<MethodConfig, Void> config, 
                                 @NotNull Function<ISMethodDecl0.CheckBuilder<R>, Void> block) {
        return ISMethodDecl0.super.model(config, block);
    }

    @Override
    @NotNull
    public ISMethodDecl0<R> modelNoArg(@NotNull Function<MethodConfig, Void> config, 
                                      @NotNull Function<ISMethodDecl0.CheckBuilder<R>, Void> block) {
        return ISMethodDecl0.super.modelNoArg(config, block);
    }

    @Override
    @NotNull
    public IMethodMatch getMatch() {
        return base.getMatch();
    }

    @Override
    @NotNull
    public AIAnalysisApi.Error getError() {
        return base.getError();
    }

    @Override
    @Nullable
    public KFunctionType getActualType() {
        return base.getActualType();
    }

    @Override
    public void eachLocalVar(@NotNull Function<ISootLocalVarDecl<Object>, Void> block) {
        if (block == null) {
            throw new IllegalArgumentException("block cannot be null");
        }
        base.eachLocalVar(block);
    }

    private static class CheckBuilderDelegate<R> implements ISMethodDecl0.CheckBuilder<R> {
        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl0<R> method;

        CheckBuilderDelegate(ISMethodDecl0<R> method, Function<MethodConfig, Void> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public ISMethodDecl0<R> getMethod() {
            return method;
        }

        @Override
        public Function<MethodConfig, Void> getConfig() {
            return delegate.getConfig();
        }

        @Override
        public ILocalT<Object> getGlobal() {
            return delegate.getGlobal();
        }

        @Override
        public <T> IParameterT<T> paramAt(int index) {
            return delegate.paramAt(index);
        }

        @Override
        public IReturnT<R> getReturn() {
            return delegate.getReturn();
        }

        // Delegate all other methods to the underlying builder
        @Override
        public IWithSubFieldsT getSubFields(ILocalT<?> localT) {
            return delegate.getSubFields(localT);
        }

        @Override
        public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> localT) {
            return delegate.getAttr(localT);
        }

        @Override
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(ILocalT<T> localT) {
            return delegate.getTaint(localT);
        }

        @Override
        public <T> void setTaint(ILocalT<T> localT, IAttribute<TaintProperty, Set<ITaintType>> attribute) {
            delegate.setTaint(localT, attribute);
        }

        // ... continue with all other delegated methods ...
        // (Remaining delegate methods omitted for brevity - they should follow the same pattern)
    }
}
