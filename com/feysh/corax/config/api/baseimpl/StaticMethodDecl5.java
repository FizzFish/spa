package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public final class StaticMethodDecl5<R, P0, P1, P2, P3, P4> 
    implements ISMethodDecl5<R, P0, P1, P2, P3, P4>, ISMethodDecl<R> {

    private final @NotNull ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl5(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl5(@NotNull ISMethodDecl<R> base) {
        this(base, 5);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull ISMethodDecl5.CheckBuilder<R, P0, P1, P2, P3, P4> checkBuilder(
            @NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
    }

    @Override
    public @NotNull ISMethodDecl5<R, P0, P1, P2, P3, P4> model(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function6<? super ISMethodDecl5.CheckBuilder<R, P0, P1, P2, P3, P4>, 
                ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, 
                ? super IParameterT<P3>, ? super IParameterT<P4>, Unit> block) {
        return ISMethodDecl5.super.model(config, block);
    }

    @Override
    public @NotNull ISMethodDecl5<R, P0, P1, P2, P3, P4> modelNoArg(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function1<? super ISMethodDecl5.CheckBuilder<R, P0, P1, P2, P3, P4>, Unit> block) {
        return ISMethodDecl5.super.modelNoArg(config, block);
    }

    @Override
    public @NotNull IMethodMatch getMatch() {
        return base.getMatch();
    }

    @Override
    public @NotNull AIAnalysisApi.Error getError() {
        return base.getError();
    }

    @Override
    public @Nullable KFunctionType getActualType() {
        return base.getActualType();
    }

    @Override
    public void eachLocalVar(@NotNull Function1<? super ISootLocalVarDecl<Object>, Unit> block) {
        if (block == null) {
            throw new IllegalArgumentException("block cannot be null");
        }
        base.eachLocalVar(block);
    }

    private static class CheckBuilderImpl<R, P0, P1, P2, P3, P4> 
        implements ISMethodDecl5.CheckBuilder<R, P0, P1, P2, P3, P4> {

        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl5<R, P0, P1, P2, P3, P4> method;

        CheckBuilderImpl(StaticMethodDecl5<R, P0, P1, P2, P3, P4> method, 
                        Function1<? super MethodConfig, Unit> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public ISMethodDecl5<R, P0, P1, P2, P3, P4> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return ISMethodDecl5.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return ISMethodDecl5.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return ISMethodDecl5.CheckBuilder.super.getP2();
        }

        @Override
        public IParameterT<P3> getP3() {
            return ISMethodDecl5.CheckBuilder.super.getP3();
        }

        @Override
        public IParameterT<P4> getP4() {
            return ISMethodDecl5.CheckBuilder.super.getP4();
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

        // Delegate all remaining methods to the underlying delegate
        @Override
        public IWithSubFieldsT getSubFields(ILocalT<?> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getSubFields(localT);
        }

        @Override
        public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getAttr(localT);
        }

        // ... (remaining delegate methods follow the same pattern)
    }
}
