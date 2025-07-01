package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import java.util.function.Function;

public final class InstanceMethodDecl3<R, This, P0, P1, P2> implements IIMethodDecl3<R, This, P0, P1, P2>, IIMethodDecl<R, This> {
    private final @NotNull IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl3(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl3(@NotNull IIMethodDecl<R, This> base) {
        this(base, 3);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl3.CheckBuilder<R, This, P0, P1, P2> checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        return new CheckBuilderImpl(this, config);
    }

    @Override
    public @NotNull IIMethodDecl3<R, This, P0, P1, P2> model(
            @NotNull Function<MethodConfig, Void> config,
            @NotNull Function4<IIMethodDecl3.CheckBuilder<R, This, P0, P1, P2>, IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, Void> block) {
        return IIMethodDecl3.super.model(config, block);
    }

    @Override
    public @NotNull IIMethodDecl3<R, This, P0, P1, P2> modelNoArg(
            @NotNull Function<MethodConfig, Void> config,
            @NotNull Function<IIMethodDecl3.CheckBuilder<R, This, P0, P1, P2>, Void> block) {
        return IIMethodDecl3.super.modelNoArg(config, block);
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
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        base.eachLocalVar(block);
    }

    private static final class CheckBuilderImpl<R, This, P0, P1, P2> implements IIMethodDecl3.CheckBuilder<R, This, P0, P1, P2> {
        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl3<R, This, P0, P1, P2> method;

        CheckBuilderImpl(IIMethodDecl3<R, This, P0, P1, P2> method, Function<MethodConfig, Void> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl3<R, This, P0, P1, P2> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl3.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl3.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return IIMethodDecl3.CheckBuilder.super.getP2();
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

        // Delegate all remaining methods to the underlying delegate
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

        // ... (implement all other delegate methods similarly)
    }
}
