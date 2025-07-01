package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public final class StaticMethodDecl3<R, P0, P1, P2> implements ISMethodDecl3<R, P0, P1, P2>, ISMethodDecl<R> {
    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl3(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl3(@NotNull ISMethodDecl<R> base) {
        this(base, 3);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull ISMethodDecl3.CheckBuilder<R, P0, P1, P2> checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        return new CheckBuilderImpl(this, config);
    }

    @Override
    public @NotNull ISMethodDecl3<R, P0, P1, P2> model(
            @NotNull Function<MethodConfig, Void> config,
            @NotNull Function4<ISMethodDecl3.CheckBuilder<R, P0, P1, P2>, IParameterT<P0>, IParameterT<P1>, IParameterT<P2>, Void> block) {
        return ISMethodDecl3.DefaultImpls.model(this, config, block);
    }

    @Override
    public @NotNull ISMethodDecl3<R, P0, P1, P2> modelNoArg(
            @NotNull Function<MethodConfig, Void> config,
            @NotNull Function<ISMethodDecl3.CheckBuilder<R, P0, P1, P2>, Void> block) {
        return ISMethodDecl3.DefaultImpls.modelNoArg(this, config, block);
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

    private static final class CheckBuilderImpl<R, P0, P1, P2> implements ISMethodDecl3.CheckBuilder<R, P0, P1, P2> {
        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl3<R, P0, P1, P2> method;

        CheckBuilderImpl(StaticMethodDecl3<R, P0, P1, P2> method, Function<MethodConfig, Void> config) {
            this.method = method;
            this.delegate = method.base.checkBuilder(config);
        }

        @Override
        public ISMethodDecl3<R, P0, P1, P2> getMethod() {
            return method;
        }

        @Override
        public IParameterT<P0> getP0() {
            return ISMethodDecl3.CheckBuilder.DefaultImpls.getP0(this);
        }

        @Override
        public IParameterT<P1> getP1() {
            return ISMethodDecl3.CheckBuilder.DefaultImpls.getP1(this);
        }

        @Override
        public IParameterT<P2> getP2() {
            return ISMethodDecl3.CheckBuilder.DefaultImpls.getP2(this);
        }

        // Delegate all other methods to the underlying CheckBuilder
        @Override public Function<MethodConfig, Void> getConfig() { return delegate.getConfig(); }
        @Override public ILocalT<Object> getGlobal() { return delegate.getGlobal(); }
        @Override public <T> IParameterT<T> paramAt(int index) { return delegate.paramAt(index); }
        @Override public IReturnT<R> getReturn() { return delegate.getReturn(); }
        @Override public IWithSubFieldsT getSubFields(ILocalT<?> localT) { return delegate.getSubFields(localT); }
        @Override public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> localT) { return delegate.getAttr(localT); }
        @Override public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(ILocalT<T> localT) { return delegate.getTaint(localT); }
        @Override public <T> void setTaint(ILocalT<T> localT, IAttribute<TaintProperty, Set<ITaintType>> attribute) { delegate.setTaint(localT, attribute); }
        @Override public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(ILocalT<T> localT) { return delegate.getVia(localT); }
        @Override public <T> void setVia(ILocalT<T> localT, IAttribute<ViaProperty, Set<IViaType>> attribute) { delegate.setVia(localT, attribute); }
        @Override public <T> ILocalValue<T> getValue(ILocalT<T> localT) { return delegate.getValue(localT); }
        @Override public <T> void setValue(ILocalT<T> localT, ILocalValue<T> localValue) { delegate.setValue(localT, localValue); }
        
        // ... (all other delegated methods follow the same pattern)
    }
}
