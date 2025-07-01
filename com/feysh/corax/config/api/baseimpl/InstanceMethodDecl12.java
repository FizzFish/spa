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

public final class InstanceMethodDecl12<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>
        implements IIMethodDecl12<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>,
        IIMethodDecl<R, This> {

    private final IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl12(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl12(@NotNull IIMethodDecl<R, This> base) {
        this(base, 12);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl12.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> 
            checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
    }

    @Override
    public @NotNull IIMethodDecl12<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> 
            model(@NotNull Function1<? super MethodConfig, Unit> config,
                  @NotNull Function13<? super IIMethodDecl12.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>, 
                        ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, 
                        ? super IParameterT<P3>, ? super IParameterT<P4>, ? super IParameterT<P5>, 
                        ? super IParameterT<P6>, ? super IParameterT<P7>, ? super IParameterT<P8>, 
                        ? super IParameterT<P9>, ? super IParameterT<P10>, ? super IParameterT<P11>, Unit> block) {
        return IIMethodDecl12.super.model(config, block);
    }

    @Override
    public @NotNull IIMethodDecl12<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> 
            modelNoArg(@NotNull Function1<? super MethodConfig, Unit> config,
                       @NotNull Function1<? super IIMethodDecl12.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>, Unit> block) {
        return IIMethodDecl12.super.modelNoArg(config, block);
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

    private static final class CheckBuilderImpl<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> 
            implements IIMethodDecl12.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> {
        
        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl12<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> method;

        CheckBuilderImpl(IIMethodDecl12<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> method,
                         Function1<? super MethodConfig, Unit> config) {
            this.method = method;
            this.delegate = ((InstanceMethodDecl12<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>) method).base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl12<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl12.CheckBuilder.DefaultImpls.getP0(this);
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl12.CheckBuilder.DefaultImpls.getP1(this);
        }

        // ... similar implementations for getP2() through getP11()

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

        // ... delegate all other methods to the underlying delegate
    }
}
