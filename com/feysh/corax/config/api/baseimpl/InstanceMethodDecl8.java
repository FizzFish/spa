package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public final class InstanceMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7>
        implements IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7>, IIMethodDecl<R, This> {

    @NotNull
    private final IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl8(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl8(@NotNull IIMethodDecl<R, This> base) {
        this(base, 8);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public IIMethodDecl8.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
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

    private static final class CheckBuilderImpl<R, This, P0, P1, P2, P3, P4, P5, P6, P7> 
            implements IIMethodDecl8.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7> {
        
        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> method;

        CheckBuilderImpl(IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> method, 
                        Function1<? super MethodConfig, Unit> config) {
            this.delegate = method.base.checkBuilder(config);
            this.method = method;
        }

        @Override
        public IIMethodDecl8<R, This, P0, P1, P2, P3, P4, P5, P6, P7> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl8.CheckBuilder.DefaultImpls.getP0(this);
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl8.CheckBuilder.DefaultImpls.getP1(this);
        }

        @Override
        public IParameterT<P2> getP2() {
            return IIMethodDecl8.CheckBuilder.DefaultImpls.getP2(this);
        }

        @Override
        public IParameterT<P3> getP3() {
            return IIMethodDecl8.CheckBuilder.DefaultImpls.getP3(this);
        }

        @Override
        public IParameterT<P4> getP4() {
            return IIMethodDecl8.CheckBuilder.DefaultImpls.getP4(this);
        }

        @Override
        public IParameterT<P5> getP5() {
            return IIMethodDecl8.CheckBuilder.DefaultImpls.getP5(this);
        }

        @Override
        public IParameterT<P6> getP6() {
            return IIMethodDecl8.CheckBuilder.DefaultImpls.getP6(this);
        }

        @Override
        public IParameterT<P7> getP7() {
            return IIMethodDecl8.CheckBuilder.DefaultImpls.getP7(this);
        }

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

        @Override
        public IWithSubFieldsT getSubFields(ILocalT<?> $this$subFields) {
            if ($this$subFields == null) {
                throw new IllegalArgumentException("subFields cannot be null");
            }
            return delegate.getSubFields($this$subFields);
        }

        @Override
        public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> $this$attr) {
            if ($this$attr == null) {
                throw new IllegalArgumentException("attr cannot be null");
            }
            return delegate.getAttr($this$attr);
        }

        @Override
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(ILocalT<T> $this$taint) {
            if ($this$taint == null) {
                throw new IllegalArgumentException("taint cannot be null");
            }
            return delegate.getTaint($this$taint);
        }

        @Override
        public <T> void setTaint(ILocalT<T> $this$taint, IAttribute<TaintProperty, Set<ITaintType>> iAttribute) {
            if ($this$taint == null) {
                throw new IllegalArgumentException("taint cannot be null");
            }
            if (iAttribute == null) {
                throw new IllegalArgumentException("attribute cannot be null");
            }
            delegate.setTaint($this$taint, iAttribute);
        }

        // Remaining delegate methods follow the same pattern...
        // Only showing a subset for brevity
    }
}
