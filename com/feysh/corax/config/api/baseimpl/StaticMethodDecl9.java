package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

import java.util.Collection;
import java.util.Set;

public final class StaticMethodDecl9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>
        implements ISMethodDecl9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>, ISMethodDecl<R> {

    @NotNull
    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl9(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl9(@NotNull ISMethodDecl<R> base) {
        this(base, 9);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public ISMethodDecl9.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
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
    public void eachLocalVar(@NotNull Function1<? super ISootLocalVarDecl<Object>, Unit> block) {
        if (block == null) {
            throw new IllegalArgumentException("block cannot be null");
        }
        base.eachLocalVar(block);
    }

    private static final class CheckBuilderImpl<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> 
            implements ISMethodDecl9.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> {
        
        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> method;

        CheckBuilderImpl(StaticMethodDecl9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> method, 
                        Function1<? super MethodConfig, Unit> config) {
            this.delegate = method.base.checkBuilder(config);
            this.method = method;
        }

        @Override
        public ISMethodDecl9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return delegate.paramAt(0);
        }

        @Override
        public IParameterT<P1> getP1() {
            return delegate.paramAt(1);
        }

        @Override
        public IParameterT<P2> getP2() {
            return delegate.paramAt(2);
        }

        @Override
        public IParameterT<P3> getP3() {
            return delegate.paramAt(3);
        }

        @Override
        public IParameterT<P4> getP4() {
            return delegate.paramAt(4);
        }

        @Override
        public IParameterT<P5> getP5() {
            return delegate.paramAt(5);
        }

        @Override
        public IParameterT<P6> getP6() {
            return delegate.paramAt(6);
        }

        @Override
        public IParameterT<P7> getP7() {
            return delegate.paramAt(7);
        }

        @Override
        public IParameterT<P8> getP8() {
            return delegate.paramAt(8);
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
        public IWithSubFieldsT getSubFields(ILocalT<?> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getSubFields(localT);
        }

        @Override
        public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getAttr(localT);
        }

        @Override
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getTaint(localT);
        }

        @Override
        public <T> void setTaint(ILocalT<T> localT, IAttribute<TaintProperty, Set<ITaintType>> attribute) {
            if (localT == null || attribute == null) {
                throw new IllegalArgumentException("Parameters cannot be null");
            }
            delegate.setTaint(localT, attribute);
        }

        // Remaining delegate methods follow the same pattern...
        // Implement all other methods by delegating to the underlying delegate
    }
}
