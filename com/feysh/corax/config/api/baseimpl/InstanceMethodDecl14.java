package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function15;

public final class InstanceMethodDecl14<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
        implements IIMethodDecl14<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>,
        IIMethodDecl<R, This> {

    private final @NotNull IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl14(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl14(@NotNull IIMethodDecl<R, This> base) {
        this(base, 14);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl14.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> 
            checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
    }

    @Override
    public @NotNull IIMethodDecl14<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> 
            model(@NotNull Function1<? super MethodConfig, Unit> config,
                  @NotNull Function15<? super IIMethodDecl14.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>,
                          ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>,
                          ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, ? super IParameterT<P7>,
                          ? super IParameterT<P8>, ? super IParameterT<P9>, ? super IParameterT<P10>, ? super IParameterT<P11>,
                          ? super IParameterT<P12>, ? super IParameterT<P13>, Unit> block) {
        return IIMethodDecl14.super.model(config, block);
    }

    @Override
    public @NotNull IIMethodDecl14<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> 
            modelNoArg(@NotNull Function1<? super MethodConfig, Unit> config,
                      @NotNull Function1<? super IIMethodDecl14.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>, Unit> block) {
        return IIMethodDecl14.super.modelNoArg(config, block);
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

    private static class CheckBuilderImpl<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
            implements IIMethodDecl14.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> {

        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl14<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> method;

        CheckBuilderImpl(IIMethodDecl14<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> method,
                        Function1<? super MethodConfig, Unit> config) {
            this.method = method;
            this.delegate = ((InstanceMethodDecl14<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>) method).base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl14<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl14.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl14.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return IIMethodDecl14.CheckBuilder.super.getP2();
        }

        @Override
        public IParameterT<P3> getP3() {
            return IIMethodDecl14.CheckBuilder.super.getP3();
        }

        @Override
        public IParameterT<P4> getP4() {
            return IIMethodDecl14.CheckBuilder.super.getP4();
        }

        @Override
        public IParameterT<P5> getP5() {
            return IIMethodDecl14.CheckBuilder.super.getP5();
        }

        @Override
        public IParameterT<P6> getP6() {
            return IIMethodDecl14.CheckBuilder.super.getP6();
        }

        @Override
        public IParameterT<P7> getP7() {
            return IIMethodDecl14.CheckBuilder.super.getP7();
        }

        @Override
        public IParameterT<P8> getP8() {
            return IIMethodDecl14.CheckBuilder.super.getP8();
        }

        @Override
        public IParameterT<P9> getP9() {
            return IIMethodDecl14.CheckBuilder.super.getP9();
        }

        @Override
        public IParameterT<P10> getP10() {
            return IIMethodDecl14.CheckBuilder.super.getP10();
        }

        @Override
        public IParameterT<P11> getP11() {
            return IIMethodDecl14.CheckBuilder.super.getP11();
        }

        @Override
        public IParameterT<P12> getP12() {
            return IIMethodDecl14.CheckBuilder.super.getP12();
        }

        @Override
        public IParameterT<P13> getP13() {
            return IIMethodDecl14.CheckBuilder.super.getP13();
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
                throw new IllegalArgumentException("<this> cannot be null");
            }
            return delegate.getSubFields($this$subFields);
        }

        @Override
        public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> $this$attr) {
            if ($this$attr == null) {
                throw new IllegalArgumentException("<this> cannot be null");
            }
            return delegate.getAttr($this$attr);
        }

        @Override
        public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(ILocalT<T> $this$taint) {
            if ($this$taint == null) {
                throw new IllegalArgumentException("<this> cannot be null");
            }
            return delegate.getTaint($this$taint);
        }

        @Override
        public <T> void setTaint(ILocalT<T> $this$taint, IAttribute<TaintProperty, Set<ITaintType>> iAttribute) {
            if ($this$taint == null || iAttribute == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.setTaint($this$taint, iAttribute);
        }

        // Remaining delegate methods follow the same pattern...
        // For brevity, only showing a subset of the delegated methods
        
        @Override
        public void addStmt(IStmt stmt) {
            if (stmt == null) {
                throw new IllegalArgumentException("stmt cannot be null");
            }
            delegate.addStmt(stmt);
        }

        @Override
        public void check(IBoolExpr expr, CheckType checkType, Function1<? super BugMessage.Env, Unit> env) {
            if (expr == null || checkType == null || env == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.check(expr, checkType, env);
        }

        // Additional delegate methods would be implemented similarly...
    }
}
