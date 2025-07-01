package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

import java.util.Collection;
import java.util.Set;

public final class InstanceMethodDecl0<R, This> implements IIMethodDecl0<R, This>, IIMethodDecl<R, This> {
    private final IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl0(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl0(@NotNull IIMethodDecl<R, This> base) {
        this(base, 0);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl0.CheckBuilder<R, This> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderDelegate<>(this, config);
    }

    @Override
    public @NotNull IIMethodDecl0<R, This> model(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function1<? super IIMethodDecl0.CheckBuilder<R, This>, Unit> block) {
        return IIMethodDecl0.super.model(config, block);
    }

    @Override
    public @NotNull IIMethodDecl0<R, This> modelNoArg(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function1<? super IIMethodDecl0.CheckBuilder<R, This>, Unit> block) {
        return IIMethodDecl0.super.modelNoArg(config, block);
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

    private static class CheckBuilderDelegate<R, This> implements IIMethodDecl0.CheckBuilder<R, This> {
        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl0<R, This> method;

        CheckBuilderDelegate(IIMethodDecl0<R, This> method, Function1<? super MethodConfig, Unit> config) {
            this.method = method;
            this.delegate = ((InstanceMethodDecl0<R, This>)method).base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl0<R, This> getMethod() {
            return method;
        }

        @Override
        public IParameterT<This> getThis() {
            return delegate.getThis();
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

        // Delegate all other methods to the underlying CheckBuilder
        @Override
        public IWithSubFieldsT getSubFields(ILocalT<?> $this$subFields) {
            if ($this$subFields == null) {
                throw new IllegalArgumentException("<this> cannot be null");
            }
            return delegate.getSubFields($this$subFields);
        }

        @Override
        public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> $this$attr) {
            if ($this$attr == null) {
                throw new IllegalArgumentException("<this> cannot be null");
            }
            return delegate.getAttr($this$attr);
        }

        // ... (remaining delegate methods follow the same pattern)
        // Note: For brevity, not all delegate methods are shown here
    }
}
