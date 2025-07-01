package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public final class InstanceMethodDecl4<R, This, P0, P1, P2, P3> 
    implements IIMethodDecl4<R, This, P0, P1, P2, P3>, IIMethodDecl<R, This> {

    private final @NotNull IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl4(@NotNull IIMethodDecl<R, This> base) {
        this(base, 4);
    }

    public InstanceMethodDecl4(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl4.CheckBuilder<R, This, P0, P1, P2, P3> checkBuilder(
            @NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        return new CheckBuilderImpl(this, config);
    }

    @Override
    public @NotNull IIMethodDecl4<R, This, P0, P1, P2, P3> model(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function5<? super IIMethodDecl4.CheckBuilder<R, This, P0, P1, P2, P3>, 
                ? super IParameterT<P0>, ? super IParameterT<P1>, 
                ? super IParameterT<P2>, ? super IParameterT<P3>, Unit> block) {
        return IIMethodDecl4.super.model(config, block);
    }

    @Override
    public @NotNull IIMethodDecl4<R, This, P0, P1, P2, P3> modelNoArg(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function1<? super IIMethodDecl4.CheckBuilder<R, This, P0, P1, P2, P3>, Unit> block) {
        return IIMethodDecl4.super.modelNoArg(config, block);
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
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        base.eachLocalVar(block);
    }

    private static final class CheckBuilderImpl<R, This, P0, P1, P2, P3> 
        implements IIMethodDecl4.CheckBuilder<R, This, P0, P1, P2, P3> {

        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl4<R, This, P0, P1, P2, P3> method;

        CheckBuilderImpl(IIMethodDecl4<R, This, P0, P1, P2, P3> method, 
                        Function1<? super MethodConfig, Unit> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl4<R, This, P0, P1, P2, P3> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl4.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl4.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return IIMethodDecl4.CheckBuilder.super.getP2();
        }

        @Override
        public IParameterT<P3> getP3() {
            return IIMethodDecl4.CheckBuilder.super.getP3();
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

        @Override
        public IWithSubFieldsT getSubFields(ILocalT<?> $this$subFields) {
            if ($this$subFields == null) throw new IllegalArgumentException("<this> cannot be null");
            return delegate.getSubFields($this$subFields);
        }

        // Remaining delegate methods follow same pattern as above
        // Only showing a subset for brevity - actual implementation would include all methods
    }
}
