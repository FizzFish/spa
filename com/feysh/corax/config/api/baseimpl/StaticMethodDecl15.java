package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public final class StaticMethodDecl15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
        implements ISMethodDecl15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>,
        ISMethodDecl<R> {

    private final @NotNull ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl15(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl15(@NotNull ISMethodDecl<R> base) {
        this(base, 15);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull ISMethodDecl15.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> 
            checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        return new CheckBuilderImpl<>(this, config);
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
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        base.eachLocalVar(block);
    }

    private static final class CheckBuilderImpl<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
            implements ISMethodDecl15.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> {

        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> method;

        CheckBuilderImpl(StaticMethodDecl15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> method, 
                        Function<MethodConfig, Void> config) {
            this.delegate = method.base.checkBuilder(config);
            this.method = method;
        }

        @Override
        public ISMethodDecl15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> getMethod() {
            return method;
        }

        @Override
        public Function<MethodConfig, Void> getConfig() {
            return delegate.getConfig();
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
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getSubFields(localT);
        }

        @Override
        public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> localT) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getAttr(localT);
        }

        @Override
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(ILocalT<T> localT) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getTaint(localT);
        }

        @Override
        public <T> void setTaint(ILocalT<T> localT, IAttribute<TaintProperty, Set<ITaintType>> attribute) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            if (attribute == null) throw new IllegalArgumentException("attribute cannot be null");
            delegate.setTaint(localT, attribute);
        }

        @Override
        public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(ILocalT<T> localT) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getVia(localT);
        }

        @Override
        public <T> void setVia(ILocalT<T> localT, IAttribute<ViaProperty, Set<IViaType>> attribute) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            if (attribute == null) throw new IllegalArgumentException("attribute cannot be null");
            delegate.setVia(localT, attribute);
        }

        @Override
        public <T> ILocalValue<T> getValue(ILocalT<T> localT) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getValue(localT);
        }

        @Override
        public <T> void setValue(ILocalT<T> localT, ILocalValue<T> localValue) {
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            if (localValue == null) throw new IllegalArgumentException("localValue cannot be null");
            delegate.setValue(localT, localValue);
        }

        // Remaining delegate methods follow same pattern...
        // Implement all other delegate methods with null checks and delegation
    }
}
