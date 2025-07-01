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

public final class InstanceMethodDecl6<R, This, P0, P1, P2, P3, P4, P5> 
    implements IIMethodDecl6<R, This, P0, P1, P2, P3, P4, P5>, IIMethodDecl<R, This> {

    @NotNull
    private final IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl6(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl6(@NotNull IIMethodDecl<R, This> base) {
        this(base, 6);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public IIMethodDecl6.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5> checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
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
    public void eachLocalVar(@NotNull Function<ISootLocalVarDecl<Object>, Void> block) {
        if (block == null) {
            throw new IllegalArgumentException("block cannot be null");
        }
        base.eachLocalVar(block);
    }

    private static class CheckBuilderImpl<R, This, P0, P1, P2, P3, P4, P5> 
        implements IIMethodDecl6.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5> {

        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl6<R, This, P0, P1, P2, P3, P4, P5> method;
        private final Function<MethodConfig, Void> config;

        CheckBuilderImpl(IIMethodDecl6<R, This, P0, P1, P2, P3, P4, P5> method, Function<MethodConfig, Void> config) {
            this.method = method;
            this.config = config;
            this.delegate = ((InstanceMethodDecl6<R, This, P0, P1, P2, P3, P4, P5>)method).base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl6<R, This, P0, P1, P2, P3, P4, P5> getMethod() {
            return method;
        }

        @Override
        public Function<MethodConfig, Void> getConfig() {
            return config;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl6.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl6.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return IIMethodDecl6.CheckBuilder.super.getP2();
        }

        @Override
        public IParameterT<P3> getP3() {
            return IIMethodDecl6.CheckBuilder.super.getP3();
        }

        @Override
        public IParameterT<P4> getP4() {
            return IIMethodDecl6.CheckBuilder.super.getP4();
        }

        @Override
        public IParameterT<P5> getP5() {
            return IIMethodDecl6.CheckBuilder.super.getP5();
        }

        @Override
        public IParameterT<This> getThis() {
            return delegate.getThis();
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
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getSubFields(localT);
        }

        // Remaining delegate methods follow same pattern as above
        // Implement all required methods by delegating to 'delegate'
        // Include null checks where parameters are marked @NotNull
    }
}
