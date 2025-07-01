package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public final class StaticMethodDecl16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        implements ISMethodDecl16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
        ISMethodDecl<R> {

    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl16(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl16(@NotNull ISMethodDecl<R> base) {
        this(base, 16);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public ISMethodDecl16.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> checkBuilder(
            @NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl<>(this, config);
    }

    @Override
    @NotNull
    public ISMethodDecl16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> model(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function17<? super ISMethodDecl16.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
                    ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>,
                    ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, ? super IParameterT<P7>,
                    ? super IParameterT<P8>, ? super IParameterT<P9>, ? super IParameterT<P10>, ? super IParameterT<P11>,
                    ? super IParameterT<P12>, ? super IParameterT<P13>, ? super IParameterT<P14>, ? super IParameterT<P15>,
                    Unit> block) {
        return ISMethodDecl16.super.model(config, block);
    }

    @Override
    @NotNull
    public ISMethodDecl16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> modelNoArg(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function1<? super ISMethodDecl16.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>, Unit> block) {
        return ISMethodDecl16.super.modelNoArg(config, block);
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

    private static final class CheckBuilderImpl<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
            implements ISMethodDecl16.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> {

        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> method;

        CheckBuilderImpl(StaticMethodDecl16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> method,
                        Function1<? super MethodConfig, Unit> config) {
            this.delegate = method.base.checkBuilder(config);
            this.method = method;
        }

        @Override
        public ISMethodDecl16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> getMethod() {
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
        public IParameterT<P9> getP9() {
            return delegate.paramAt(9);
        }

        @Override
        public IParameterT<P10> getP10() {
            return delegate.paramAt(10);
        }

        @Override
        public IParameterT<P11> getP11() {
            return delegate.paramAt(11);
        }

        @Override
        public IParameterT<P12> getP12() {
            return delegate.paramAt(12);
        }

        @Override
        public IParameterT<P13> getP13() {
            return delegate.paramAt(13);
        }

        @Override
        public IParameterT<P14> getP14() {
            return delegate.paramAt(14);
        }

        @Override
        public IParameterT<P15> getP15() {
            return delegate.paramAt(15);
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
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (attribute == null) {
                throw new IllegalArgumentException("attribute cannot be null");
            }
            delegate.setTaint(localT, attribute);
        }

        // Remaining delegate methods follow the same pattern...
        // They delegate to the underlying delegate instance with null checks
    }
}
