package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public final class StaticMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>
        implements ISMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>, ISMethodDecl<R> {

    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl11(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl11(@NotNull ISMethodDecl<R> base) {
        this(base, 11);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull ISMethodDecl11.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> checkBuilder(
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

    private static final class CheckBuilderImpl<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> 
            implements ISMethodDecl11.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> {

        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> method;

        CheckBuilderImpl(StaticMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> method, 
                       Function<MethodConfig, Void> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public ISMethodDecl11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> getMethod() {
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
        // Implement all other delegate methods with proper null checks
    }
}
