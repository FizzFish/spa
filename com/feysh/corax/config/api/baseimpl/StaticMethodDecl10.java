package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public final class StaticMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>
        implements ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>, ISMethodDecl<R> {

    private final @NotNull ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl10(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl10(@NotNull ISMethodDecl<R> base) {
        this(base, 10);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull ISMethodDecl10.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> checkBuilder(
            @NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
    }

    @Override
    public @NotNull ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> model(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function11<? super ISMethodDecl10.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>,
                    ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>,
                    ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, ? super IParameterT<P7>,
                    ? super IParameterT<P8>, ? super IParameterT<P9>, Unit> block) {
        return ISMethodDecl10.super.model(config, block);
    }

    @Override
    public @NotNull ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> modelNoArg(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function1<? super ISMethodDecl10.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>, Unit> block) {
        return ISMethodDecl10.super.modelNoArg(config, block);
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

    private static final class CheckBuilderImpl<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>
            implements ISMethodDecl10.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> {

        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> method;

        CheckBuilderImpl(StaticMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> method,
                        Function1<? super MethodConfig, Unit> config) {
            this.delegate = method.base.checkBuilder(config);
            this.method = method;
        }

        @Override
        public ISMethodDecl10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return ISMethodDecl10.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return ISMethodDecl10.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return ISMethodDecl10.CheckBuilder.super.getP2();
        }

        @Override
        public IParameterT<P3> getP3() {
            return ISMethodDecl10.CheckBuilder.super.getP3();
        }

        @Override
        public IParameterT<P4> getP4() {
            return ISMethodDecl10.CheckBuilder.super.getP4();
        }

        @Override
        public IParameterT<P5> getP5() {
            return ISMethodDecl10.CheckBuilder.super.getP5();
        }

        @Override
        public IParameterT<P6> getP6() {
            return ISMethodDecl10.CheckBuilder.super.getP6();
        }

        @Override
        public IParameterT<P7> getP7() {
            return ISMethodDecl10.CheckBuilder.super.getP7();
        }

        @Override
        public IParameterT<P8> getP8() {
            return ISMethodDecl10.CheckBuilder.super.getP8();
        }

        @Override
        public IParameterT<P9> getP9() {
            return ISMethodDecl10.CheckBuilder.super.getP9();
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
            if ($this$subFields == null) {
                throw new IllegalArgumentException("<this> cannot be null");
            }
            return delegate.getSubFields($this$subFields);
        }

        // Remaining delegate methods follow the same pattern...
        // All delegate method implementations would be included here
        // with appropriate null checks where needed
    }
}
