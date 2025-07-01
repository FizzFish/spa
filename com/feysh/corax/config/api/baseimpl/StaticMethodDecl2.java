package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Set;

public final class StaticMethodDecl2<R, P0, P1> implements ISMethodDecl2<R, P0, P1>, ISMethodDecl<R> {
    @NotNull
    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl2(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl2(@NotNull ISMethodDecl<R> base) {
        this(base, 2);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public ISMethodDecl2.CheckBuilder<R, P0, P1> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
    }

    @Override
    @NotNull
    public ISMethodDecl2<R, P0, P1> model(@NotNull Function1<? super MethodConfig, Unit> config,
                                         @NotNull Function3<? super ISMethodDecl2.CheckBuilder<R, P0, P1>, ? super IParameterT<P0>, ? super IParameterT<P1>, Unit> block) {
        return ISMethodDecl2.DefaultImpls.model(this, config, block);
    }

    @Override
    @NotNull
    public ISMethodDecl2<R, P0, P1> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> config,
                                              @NotNull Function1<? super ISMethodDecl2.CheckBuilder<R, P0, P1>, Unit> block) {
        return ISMethodDecl2.DefaultImpls.modelNoArg(this, config, block);
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
    public void eachLocalVar(@NotNull Function1<? super ISootLocalVarDecl<Object>, Unit> block) {
        if (block == null) {
            throw new IllegalArgumentException("block cannot be null");
        }
        base.eachLocalVar(block);
    }

    private static class CheckBuilderImpl<R, P0, P1> implements ISMethodDecl2.CheckBuilder<R, P0, P1> {
        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl2<R, P0, P1> method;

        CheckBuilderImpl(ISMethodDecl2<R, P0, P1> method, Function1<? super MethodConfig, Unit> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public ISMethodDecl2<R, P0, P1> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return ISMethodDecl2.CheckBuilder.DefaultImpls.getP0(this);
        }

        @Override
        public IParameterT<P1> getP1() {
            return ISMethodDecl2.CheckBuilder.DefaultImpls.getP1(this);
        }

        @Override
        public Function1<MethodConfig, Unit> getConfig() {
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

        @Override
        public IWithSubFieldsT getSubFields(ILocalT<?> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getSubFields(localT);
        }

        // Remaining delegate methods follow same pattern as above
        // Implement all methods from ISMethodDecl.CheckBuilder by delegating to 'delegate'
        // with appropriate null checks where needed
    }
}
