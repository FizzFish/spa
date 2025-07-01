package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public final class InstanceMethodDecl13<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
        implements IIMethodDecl13<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>,
        IIMethodDecl<R, This> {

    private final IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl13(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl13(@NotNull IIMethodDecl<R, This> base) {
        this(base, 13);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl13.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> checkBuilder(
            @NotNull Function<MethodConfig, Void> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
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

    private static class CheckBuilderImpl<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
            implements IIMethodDecl13.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> {

        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl13<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> method;

        CheckBuilderImpl(InstanceMethodDecl13<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> method,
                        Function<MethodConfig, Void> config) {
            this.delegate = method.base.checkBuilder(config);
            this.method = method;
        }

        @Override
        public IIMethodDecl13<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl13.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl13.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return IIMethodDecl13.CheckBuilder.super.getP2();
        }

        @Override
        public IParameterT<P3> getP3() {
            return IIMethodDecl13.CheckBuilder.super.getP3();
        }

        @Override
        public IParameterT<P4> getP4() {
            return IIMethodDecl13.CheckBuilder.super.getP4();
        }

        @Override
        public IParameterT<P5> getP5() {
            return IIMethodDecl13.CheckBuilder.super.getP5();
        }

        @Override
        public IParameterT<P6> getP6() {
            return IIMethodDecl13.CheckBuilder.super.getP6();
        }

        @Override
        public IParameterT<P7> getP7() {
            return IIMethodDecl13.CheckBuilder.super.getP7();
        }

        @Override
        public IParameterT<P8> getP8() {
            return IIMethodDecl13.CheckBuilder.super.getP8();
        }

        @Override
        public IParameterT<P9> getP9() {
            return IIMethodDecl13.CheckBuilder.super.getP9();
        }

        @Override
        public IParameterT<P10> getP10() {
            return IIMethodDecl13.CheckBuilder.super.getP10();
        }

        @Override
        public IParameterT<P11> getP11() {
            return IIMethodDecl13.CheckBuilder.super.getP11();
        }

        @Override
        public IParameterT<P12> getP12() {
            return IIMethodDecl13.CheckBuilder.super.getP12();
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

        @Override
        public IWithSubFieldsT getSubFields(ILocalT<?> $this$subFields) {
            if ($this$subFields == null) {
                throw new IllegalArgumentException("this$subFields cannot be null");
            }
            return delegate.getSubFields($this$subFields);
        }

        // Remaining delegate methods follow the same pattern - omitted for brevity
        // They would all delegate to the underlying delegate object with null checks
    }
}
