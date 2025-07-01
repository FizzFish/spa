package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import soot.SootField;

public final class InstanceMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        implements IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
                   IIMethodDecl<R, This> {

    private final @NotNull IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl16(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl16(@NotNull IIMethodDecl<R, This> base) {
        this(base, 16);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl16.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> 
            checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl<>(this, config);
    }

    @Override
    public @NotNull IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> 
            model(@NotNull Function<MethodConfig, Void> config,
                  @NotNull Function17<IIMethodDecl16.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>, 
                                      IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, IParameterT<P3>, IParameterT<P4>, 
                                      IParameterT<P5>, IParameterT<P6>, IParameterT<P7>, IParameterT<P8>, IParameterT<P9>, 
                                      IParameterT<P10>, IParameterT<P11>, IParameterT<P12>, IParameterT<P13>, IParameterT<P14>, 
                                      IParameterT<P15>, Void> block) {
        return IIMethodDecl16.super.model(config, block);
    }

    @Override
    public @NotNull IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> 
            modelNoArg(@NotNull Function<MethodConfig, Void> config,
                       @NotNull Function<IIMethodDecl16.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>, Void> block) {
        return IIMethodDecl16.super.modelNoArg(config, block);
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

    private static final class CheckBuilderImpl<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> 
            implements IIMethodDecl16.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> {

        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> method;

        CheckBuilderImpl(IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> method,
                         Function<MethodConfig, Void> config) {
            this.method = method;
            this.delegate = ((InstanceMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>) method).base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl16<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl16.CheckBuilder.super.getP0();
        }

        // Implement all other parameter getters similarly
        // ...

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

        // Delegate all other methods to the underlying delegate
        // ...
    }
}
