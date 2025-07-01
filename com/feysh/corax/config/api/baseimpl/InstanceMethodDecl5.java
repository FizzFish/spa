package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public final class InstanceMethodDecl5<R, This, P0, P1, P2, P3, P4>
        implements IIMethodDecl5<R, This, P0, P1, P2, P3, P4>, IIMethodDecl<R, This> {

    private final @NotNull IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl5(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl5(@NotNull IIMethodDecl<R, This> base) {
        this(base, 5);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl5.CheckBuilder<R, This, P0, P1, P2, P3, P4> checkBuilder(
            @NotNull Function<MethodConfig, Void> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
    }

    @Override
    public @NotNull IIMethodDecl5<R, This, P0, P1, P2, P3, P4> model(
            @NotNull Function<MethodConfig, Void> config,
            @NotNull CheckBuilderFunction<R, This, P0, P1, P2, P3, P4> block) {
        return IIMethodDecl5.super.model(config, block);
    }

    @Override
    public @NotNull IIMethodDecl5<R, This, P0, P1, P2, P3, P4> modelNoArg(
            @NotNull Function<MethodConfig, Void> config,
            @NotNull Function<IIMethodDecl5.CheckBuilder<R, This, P0, P1, P2, P3, P4>, Void> block) {
        return IIMethodDecl5.super.modelNoArg(config, block);
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
    public void eachLocalVar(@NotNull Function<ISootLocalVarDecl<Object>, Void> block) {
        if (block == null) {
            throw new IllegalArgumentException("block cannot be null");
        }
        base.eachLocalVar(block);
    }

    private static final class CheckBuilderImpl<R, This, P0, P1, P2, P3, P4>
            implements IIMethodDecl5.CheckBuilder<R, This, P0, P1, P2, P3, P4> {

        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl5<R, This, P0, P1, P2, P3, P4> method;

        CheckBuilderImpl(IIMethodDecl5<R, This, P0, P1, P2, P3, P4> method, Function<MethodConfig, Void> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl5<R, This, P0, P1, P2, P3, P4> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl5.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl5.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return IIMethodDecl5.CheckBuilder.super.getP2();
        }

        @Override
        public IParameterT<P3> getP3() {
            return IIMethodDecl5.CheckBuilder.super.getP3();
        }

        @Override
        public IParameterT<P4> getP4() {
            return IIMethodDecl5.CheckBuilder.super.getP4();
        }

        @Override
        public IParameterT<This> getThis() {
            return delegate.getThis();
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

        // Delegate all remaining methods to the underlying builder
        @Override
        public IWithSubFieldsT getSubFields(ILocalT<?> localT) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getSubFields(localT);
        }

        @Override
        public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> localT) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getAttr(localT);
        }

        // ... (remaining delegate methods follow the same pattern)
    }
}
