package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.function.BiFunction;

public final class StaticMethodDecl1<R, P0> implements ISMethodDecl1<R, P0>, ISMethodDecl<R> {
    @NotNull
    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl1(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl1(@NotNull ISMethodDecl<R> base) {
        this(base, 1);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public ISMethodDecl1.CheckBuilder<R, P0> checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl<>(this, config);
    }

    @Override
    @NotNull
    public ISMethodDecl1<R, P0> model(@NotNull Function<MethodConfig, Void> config, 
                                     @NotNull BiFunction<ISMethodDecl1.CheckBuilder<R, P0>, IParameterT<P0>, Void> block) {
        return ISMethodDecl1.super.model(config, block);
    }

    @Override
    @NotNull
    public ISMethodDecl1<R, P0> modelNoArg(@NotNull Function<MethodConfig, Void> config, 
                                          @NotNull Function<ISMethodDecl1.CheckBuilder<R, P0>, Void> block) {
        return ISMethodDecl1.super.modelNoArg(config, block);
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

    private static final class CheckBuilderImpl<R, P0> implements ISMethodDecl1.CheckBuilder<R, P0> {
        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl1<R, P0> method;

        CheckBuilderImpl(ISMethodDecl1<R, P0> method, Function<MethodConfig, Void> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public ISMethodDecl1<R, P0> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return ISMethodDecl1.CheckBuilder.super.getP0();
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

        // Delegate all other methods to the underlying CheckBuilder
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

        // ... (remaining delegate methods follow the same pattern)
    }
}
