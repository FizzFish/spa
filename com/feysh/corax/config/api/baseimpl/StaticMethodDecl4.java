package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public final class StaticMethodDecl4<R, P0, P1, P2, P3> implements ISMethodDecl4<R, P0, P1, P2, P3>, ISMethodDecl<R> {
    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl4(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl4(@NotNull ISMethodDecl<R> base) {
        this(base, 4);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public ISMethodDecl4.CheckBuilder<R, P0, P1, P2, P3> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
    }

    @Override
    @NotNull
    public ISMethodDecl4<R, P0, P1, P2, P3> model(@NotNull Function1<? super MethodConfig, Unit> config, 
            @NotNull Function5<? super ISMethodDecl4.CheckBuilder<R, P0, P1, P2, P3>, ? super IParameterT<P0>, 
            ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>, Unit> block) {
        return ISMethodDecl4.super.model(config, block);
    }

    @Override
    @NotNull
    public ISMethodDecl4<R, P0, P1, P2, P3> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> config, 
            @NotNull Function1<? super ISMethodDecl4.CheckBuilder<R, P0, P1, P2, P3>, Unit> block) {
        return ISMethodDecl4.super.modelNoArg(config, block);
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

    private static final class CheckBuilderImpl<R, P0, P1, P2, P3> implements ISMethodDecl4.CheckBuilder<R, P0, P1, P2, P3> {
        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl4<R, P0, P1, P2, P3> method;

        CheckBuilderImpl(ISMethodDecl4<R, P0, P1, P2, P3> method, Function1<? super MethodConfig, Unit> config) {
            this.method = method;
            this.delegate = ((StaticMethodDecl4<R, P0, P1, P2, P3>)method).base.checkBuilder(config);
        }

        @Override
        public ISMethodDecl4<R, P0, P1, P2, P3> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return ISMethodDecl4.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return ISMethodDecl4.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return ISMethodDecl4.CheckBuilder.super.getP2();
        }

        @Override
        public IParameterT<P3> getP3() {
            return ISMethodDecl4.CheckBuilder.super.getP3();
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

        // ... (rest of delegate methods follow same pattern, delegating to 'delegate' with null checks)
    }
}
