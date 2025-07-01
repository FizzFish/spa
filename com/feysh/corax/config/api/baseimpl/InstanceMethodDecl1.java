package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public final class InstanceMethodDecl1<R, This, P0> implements IIMethodDecl1<R, This, P0>, IIMethodDecl<R, This> {
    private final @NotNull IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl1(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl1(@NotNull IIMethodDecl<R, This> base) {
        this(base, 1);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl1.CheckBuilder<R, This, P0> checkBuilder(@NotNull Consumer<MethodConfig> config) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        return new CheckBuilderImpl(this, config);
    }

    @Override
    public @NotNull IIMethodDecl1<R, This, P0> model(
            @NotNull Consumer<MethodConfig> config,
            @NotNull BiConsumer<IIMethodDecl1.CheckBuilder<R, This, P0>, IParameterT<P0>> block) {
        return IIMethodDecl1.super.model(config, block);
    }

    @Override
    public @NotNull IIMethodDecl1<R, This, P0> modelNoArg(
            @NotNull Consumer<MethodConfig> config,
            @NotNull Consumer<IIMethodDecl1.CheckBuilder<R, This, P0>> block) {
        return IIMethodDecl1.super.modelNoArg(config, block);
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
    public void eachLocalVar(@NotNull Consumer<ISootLocalVarDecl<Object>> block) {
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        base.eachLocalVar(block);
    }

    private static final class CheckBuilderImpl<R, This, P0> implements IIMethodDecl1.CheckBuilder<R, This, P0> {
        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl1<R, This, P0> method;

        CheckBuilderImpl(IIMethodDecl1<R, This, P0> method, Consumer<MethodConfig> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl1<R, This, P0> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl1.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<This> getThis() {
            return delegate.getThis();
        }

        @Override
        public Consumer<MethodConfig> getConfig() {
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
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getSubFields(localT);
        }

        // Delegate all remaining methods to the underlying delegate
        @Override
        public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> localT) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getAttr(localT);
        }

        @Override
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(ILocalT<T> localT) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getTaint(localT);
        }

        @Override
        public <T> void setTaint(ILocalT<T> localT, IAttribute<TaintProperty, Set<ITaintType>> attribute) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            if (attribute == null) throw new IllegalArgumentException("attribute cannot be null");
            delegate.setTaint(localT, attribute);
        }

        // ... (remaining delegate methods follow the same pattern)
    }
}
