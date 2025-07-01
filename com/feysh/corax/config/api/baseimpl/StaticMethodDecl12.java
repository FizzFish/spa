package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public final class StaticMethodDecl12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>
        implements ISMethodDecl12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>, ISMethodDecl<R> {

    @NotNull
    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl12(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl12(@NotNull ISMethodDecl<R> base) {
        this(base, 12);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public ISMethodDecl12.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
    }

    @Override
    @NotNull
    public ISMethodDecl12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> model(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function13<? super ISMethodDecl12.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>,
                    ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>,
                    ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, ? super IParameterT<P7>,
                    ? super IParameterT<P8>, ? super IParameterT<P9>, ? super IParameterT<P10>, ? super IParameterT<P11>,
                    Unit> block) {
        return ISMethodDecl12.DefaultImpls.model(this, config, block);
    }

    @Override
    @NotNull
    public ISMethodDecl12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> modelNoArg(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function1<? super ISMethodDecl12.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>, Unit> block) {
        return ISMethodDecl12.DefaultImpls.modelNoArg(this, config, block);
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

    private static final class CheckBuilderImpl<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>
            implements ISMethodDecl12.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> {

        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> method;

        CheckBuilderImpl(StaticMethodDecl12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> method,
                         Function1<? super MethodConfig, Unit> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public ISMethodDecl12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return ISMethodDecl12.CheckBuilder.DefaultImpls.getP0(this);
        }

        @Override
        public IParameterT<P1> getP1() {
            return ISMethodDecl12.CheckBuilder.DefaultImpls.getP1(this);
        }

        // Remaining parameter getters and delegate methods follow same pattern
        // Implementation omitted for brevity but would delegate all calls to the underlying delegate
    }
}
