package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public final class InstanceMethodDecl2<R, This, P0, P1> implements IIMethodDecl2<R, This, P0, P1>, IIMethodDecl<R, This> {
    private final @NotNull IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl2(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl2(@NotNull IIMethodDecl<R, This> base) {
        this(base, 2);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl2.CheckBuilder<R, This, P0, P1> checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        return new CheckBuilderImpl(this, config);
    }

    private static final class CheckBuilderImpl<R, This, P0, P1> implements IIMethodDecl2.CheckBuilder<R, This, P0, P1> {
        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl2<R, This, P0, P1> method;

        CheckBuilderImpl(IIMethodDecl2<R, This, P0, P1> method, Function<MethodConfig, Void> config) {
            this.method = method;
            this.delegate = ((InstanceMethodDecl2<R, This, P0, P1>)method).base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl2<R, This, P0, P1> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl2.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl2.CheckBuilder.super.getP1();
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

        // Delegate all remaining methods to the base CheckBuilder
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

        // ... (remaining delegate methods omitted for brevity)
    }

    @Override
    public @NotNull IIMethodDecl2<R, This, P0, P1> model(
            @NotNull Function<MethodConfig, Void> config, 
            @NotNull TriFunction<IIMethodDecl2.CheckBuilder<R, This, P0, P1>, IParameterT<P0>, IParameterT<P1>, Void> block) {
        return IIMethodDecl2.super.model(config, block);
    }

    @Override
    public @NotNull IIMethodDecl2<R, This, P0, P1> modelNoArg(
            @NotNull Function<MethodConfig, Void> config, 
            @NotNull Function<IIMethodDecl2.CheckBuilder<R, This, P0, P1>, Void> block) {
        return IIMethodDecl2.super.modelNoArg(config, block);
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

    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}
