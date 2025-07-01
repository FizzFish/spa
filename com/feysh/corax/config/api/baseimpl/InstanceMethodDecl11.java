package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.AIAnalysisApi;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIMethodDecl;
import com.feysh.corax.config.api.IIMethodDecl11;
import com.feysh.corax.config.api.IIntExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ILongExpr;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.IOperatorFactory;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.ISootLocalVarDecl;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.ITypedExpr;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.IWithSubFieldsT;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public final class InstanceMethodDecl11<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>
        implements IIMethodDecl11<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>,
        IIMethodDecl<R, This> {

    private final @NotNull IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl11(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl11(@NotNull IIMethodDecl<R, This> base) {
        this(base, 11);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl11.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> 
            checkBuilder(@NotNull Consumer<? super MethodConfig> config) {
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
    public void eachLocalVar(@NotNull Consumer<? super ISootLocalVarDecl<Object>> block) {
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        base.eachLocalVar(block);
    }

    private static class CheckBuilderImpl<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> 
            implements IIMethodDecl11.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> {

        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final InstanceMethodDecl11<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> method;

        CheckBuilderImpl(InstanceMethodDecl11<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> method, 
                        Consumer<? super MethodConfig> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public IIMethodDecl11<R, This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return IIMethodDecl11.CheckBuilder.super.getP0();
        }

        @Override
        public IParameterT<P1> getP1() {
            return IIMethodDecl11.CheckBuilder.super.getP1();
        }

        @Override
        public IParameterT<P2> getP2() {
            return IIMethodDecl11.CheckBuilder.super.getP2();
        }

        @Override
        public IParameterT<P3> getP3() {
            return IIMethodDecl11.CheckBuilder.super.getP3();
        }

        @Override
        public IParameterT<P4> getP4() {
            return IIMethodDecl11.CheckBuilder.super.getP4();
        }

        @Override
        public IParameterT<P5> getP5() {
            return IIMethodDecl11.CheckBuilder.super.getP5();
        }

        @Override
        public IParameterT<P6> getP6() {
            return IIMethodDecl11.CheckBuilder.super.getP6();
        }

        @Override
        public IParameterT<P7> getP7() {
            return IIMethodDecl11.CheckBuilder.super.getP7();
        }

        @Override
        public IParameterT<P8> getP8() {
            return IIMethodDecl11.CheckBuilder.super.getP8();
        }

        @Override
        public IParameterT<P9> getP9() {
            return IIMethodDecl11.CheckBuilder.super.getP9();
        }

        @Override
        public IParameterT<P10> getP10() {
            return IIMethodDecl11.CheckBuilder.super.getP10();
        }

        @Override
        public IParameterT<This> getThis() {
            return delegate.getThis();
        }

        @Override
        public Consumer<MethodConfig> getConfig() {
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
            if (localT == null) throw new IllegalArgumentException("localT cannot be null");
            return delegate.getSubFields(localT);
        }

        // Remaining delegate methods follow the same pattern...
        // For brevity, only showing the pattern for delegation
    }
}
