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

public final class InstanceMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6>
        implements IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6>, IIMethodDecl<R, This> {

    private final @NotNull IIMethodDecl<R, This> base;
    private final int argumentCnt;

    public InstanceMethodDecl7(@NotNull IIMethodDecl<R, This> base, int argumentCnt) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public InstanceMethodDecl7(@NotNull IIMethodDecl<R, This> base) {
        this(base, 7);
    }

    @Override
    public @NotNull Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    public @NotNull IIMethodDecl7.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> checkBuilder(
            @NotNull Consumer<MethodConfig> config) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
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
    public void eachLocalVar(@NotNull Consumer<ISootLocalVarDecl<Object>> block) {
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        base.eachLocalVar(block);
    }

    private static final class CheckBuilderImpl<R, This, P0, P1, P2, P3, P4, P5, P6> 
            implements IIMethodDecl7.CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> {
        
        private final IIMethodDecl.CheckBuilder<R, This> delegate;
        private final IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> method;
        private final Consumer<MethodConfig> config;

        CheckBuilderImpl(InstanceMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> method, 
                        Consumer<MethodConfig> config) {
            this.delegate = method.base.checkBuilder(config);
            this.method = method;
            this.config = config;
        }

        @Override
        public IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> getMethod() {
            return method;
        }

        @Override
        public Consumer<MethodConfig> getConfig() {
            return config;
        }

        @Override
        public IParameterT<This> getThis() {
            return delegate.getThis();
        }

        @Override
        public IReturnT<R> getReturn() {
            return delegate.getReturn();
        }

        @Override
        public <T> IParameterT<T> paramAt(int index) {
            return delegate.paramAt(index);
        }

        @Override
        public void addStmt(IStmt stmt) {
            if (stmt == null) throw new IllegalArgumentException("stmt cannot be null");
            delegate.addStmt(stmt);
        }

        // Delegate all other methods to the underlying builder
        @Override public ILocalT<Object> getGlobal() { return delegate.getGlobal(); }
        @Override public IWithSubFieldsT getSubFields(ILocalT<?> localT) { return delegate.getSubFields(localT); }
        @Override public <T> IOperatorFactory.IAttributeGetSet getAttr(ILocalT<T> localT) { return delegate.getAttr(localT); }
        @Override public <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(ILocalT<T> localT) { return delegate.getTaint(localT); }
        @Override public <T> void setTaint(ILocalT<T> localT, IAttribute<TaintProperty, Set<ITaintType>> attribute) { delegate.setTaint(localT, attribute); }
        @Override public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(ILocalT<T> localT) { return delegate.getVia(localT); }
        @Override public <T> void setVia(ILocalT<T> localT, IAttribute<ViaProperty, Set<IViaType>> attribute) { delegate.setVia(localT, attribute); }
        @Override public <T> ILocalValue<T> getValue(ILocalT<T> localT) { return delegate.getValue(localT); }
        @Override public <T> void setValue(ILocalT<T> localT, ILocalValue<T> value) { delegate.setValue(localT, value); }
        @Override public IStringExpr literal(String string) { return delegate.literal(string); }
        @Override public IIntExpr literal(int value) { return delegate.literal(value); }
        @Override public ILongExpr literal(long value) { return delegate.literal(value); }
        @Override public IBoolExpr literal(boolean value) { return delegate.literal(value); }
        @Override public <T> IBoolExpr isConstant(ILocalT<T> localT) { return delegate.isConstant(localT); }
        @Override public IBoolExpr isConstant(ITypedExpr typedExpr) { return delegate.isConstant(typedExpr); }
        @Override public IBoolExpr not(IBoolExpr boolExpr) { return delegate.not(boolExpr); }
        @Override public IBoolExpr or(IBoolExpr left, IBoolExpr right) { return delegate.or(left, right); }
        @Override public IIntExpr or(IIntExpr left, IIntExpr right) { return delegate.or(left, right); }
        @Override public IBoolExpr and(IBoolExpr left, IBoolExpr right) { return delegate.and(left, right); }
        @Override public IIntExpr and(IIntExpr left, IIntExpr right) { return delegate.and(left, right); }
        @Override public IBoolExpr lt(IIntExpr left, IIntExpr right) { return delegate.lt(left, right); }
        @Override public IBoolExpr le(IIntExpr left, IIntExpr right) { return delegate.le(left, right); }
        @Override public IBoolExpr eq(IIntExpr left, IIntExpr right) { return delegate.eq(left, right); }
        @Override public IBoolExpr ge(IIntExpr left, IIntExpr right) { return delegate.ge(left, right); }
        @Override public IBoolExpr gt(IIntExpr left, IIntExpr right) { return delegate.gt(left, right); }
        @Override public IBoolExpr neq(IIntExpr left, IIntExpr right) { return delegate.neq(left, right); }
        @Override public IIntExpr xor(IIntExpr left, IIntExpr right) { return delegate.xor(left, right); }
        @Override public IIntExpr shl(IIntExpr left, IIntExpr right) { return delegate.shl(left, right); }
        @Override public IIntExpr shr(IIntExpr left, IIntExpr right) { return delegate.shr(left, right); }
        @Override public IIntExpr lshr(IIntExpr left, IIntExpr right) { return delegate.lshr(left, right); }
        @Override public IIntExpr plus(IIntExpr left, IIntExpr right) { return delegate.plus(left, right); }
        @Override public <T extends IClassField, V extends Set<?>> IAttribute<T, V> plus(IAttribute<T, V> left, IAttribute<T, V> right) { return delegate.plus(left, right); }
        @Override public IAttribute<TaintProperty, Set<ITaintType>> plus(IAttribute<TaintProperty, Set<ITaintType>> left, ITaintType right) { return delegate.plus(left, right); }
        @Override public IAttribute<ViaProperty, Set<IViaType>> plus(IAttribute<ViaProperty, Set<IViaType>> left, IViaType right) { return delegate.plus(left, right); }
        @Override public IIntExpr minus(IIntExpr left, IIntExpr right) { return delegate.minus(left, right); }
        @Override public <T extends IClassField, V extends Set<?>> IAttribute<T, V> minus(IAttribute<T, V> left, IAttribute<T, V> right) { return delegate.minus(left, right); }
        @Override public IAttribute<TaintProperty, Set<ITaintType>> minus(IAttribute<TaintProperty, Set<ITaintType>> left, ITaintType right) { return delegate.minus(left, right); }
        @Override public IAttribute<ViaProperty, Set<IViaType>> minus(IAttribute<ViaProperty, Set<IViaType>> left, IViaType right) { return delegate.minus(left, right); }
        @Override public <T> IBoolExpr getBoolean(ILocalT<T> localT) { return delegate.getBoolean(localT); }
        @Override public <T> IStringExpr getString(ILocalT<T> localT) { return delegate.getString(localT); }
        @Override public <T> IIntExpr getInt(ILocalT<T> localT) { return delegate.getInt(localT); }
        @Override public <T> ILongExpr getLong(ILocalT<T> localT) { return delegate.getLong(localT); }
        @Override public <T> IStringExpr getEnumName(ILocalT<T> localT) { return delegate.getEnumName(localT); }
        @Override public <T> IBoolExpr isInstanceOf(ILocalT<T> localT, String parentType) { return delegate.isInstanceOf(localT, parentType); }
        @Override public IStringExpr toLowerCase(IStringExpr stringExpr) { return delegate.toLowerCase(stringExpr); }
        @Override public IBoolExpr startsWith(IStringExpr stringExpr, IStringExpr str) { return delegate.startsWith(stringExpr, str); }
        @Override public IBoolExpr startsWith(IStringExpr stringExpr, String str) { return delegate.startsWith(stringExpr, str); }
        @Override public IBoolExpr endsWith(IStringExpr stringExpr, IStringExpr str) { return delegate.endsWith(stringExpr, str); }
        @Override public IBoolExpr endsWith(IStringExpr stringExpr, String str) { return delegate.endsWith(stringExpr, str); }
        @Override public IBoolExpr contains(IStringExpr stringExpr, IStringExpr str) { return delegate.contains(stringExpr, str); }
        @Override public IBoolExpr contains(IStringExpr stringExpr, String str) { return delegate.contains(stringExpr, str); }
        @Override public IBoolExpr contains(IAttribute<TaintProperty, Set<ITaintType>> attribute, ITaintType taint) { return delegate.contains(attribute, taint); }
        @Override public IBoolExpr stringEquals(IStringExpr stringExpr, IStringExpr str) { return delegate.stringEquals(stringExpr, str); }
        @Override public IBoolExpr stringEquals(IStringExpr stringExpr, String str) { return delegate.stringEquals(stringExpr, str); }
        @Override public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... types) { return delegate.taintOf(types); }
        @Override public IAttribute<TaintProperty, Set<ITaintType>> taintOf(Collection<? extends ITaintType> types) { return delegate.taintOf(types); }
        @Override public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType... vias) { return delegate.viaOf(vias); }
        @Override public IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() { return delegate.getEmptyTaint(); }
        @Override public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() { return delegate.getEmptyVia(); }
        @Override public <T> ILocalValue<T> anyOf(ILocalT<T>... locals) { return delegate.anyOf(locals); }
        @Override public <T> ILocalValue<T> nullValue() { return delegate.nullValue(); }
        @Override public IBoolExpr hasIntersection(IAttribute<TaintProperty, Set<ITaintType>> left, IAttribute<TaintProperty, Set<ITaintType>> right) { return delegate.hasIntersection(left, right); }
        @Override public IBoolExpr containsAll(IAttribute<TaintProperty, Set<ITaintType>> left, ITaintType right) { return delegate.containsAll(left, right); }
        @Override public IBoolExpr containsAll(IAttribute<TaintProperty, Set<ITaintType>> left, IAttribute<TaintProperty, Set<ITaintType>> right) { return delegate.containsAll(left, right); }
        @Override public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(ILocalValue<T1> left, ILocalValue<T2> right) { return delegate.anyOr(left, right); }
        @Override public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(ILocalT<T1> left, ILocalT<T2> right) { return delegate.anyOr(left, right); }
        @Override public <T> IAccessPathT<Object> field(ILocalT<T> localT, String declaringClass, String fieldName, String fieldType) { return delegate.field(localT, declaringClass, fieldName, fieldType); }
        @Override public <T> IAccessPathT<Object> field(ILocalT<T> localT, SootField field) { return delegate.field(localT, field); }
        @Override public <T, FieldType> IAccessPathT<FieldType> field(ILocalT<T> localT, String declaringClass, String fieldName, Class<FieldType> type) { return delegate.field(localT, declaringClass, fieldName, type); }
        @Override public <T, FieldType> IAccessPathT<FieldType> field(ILocalT<T> localT, Class<?> declaringClass, String fieldName, Class<FieldType> type) { return delegate.field(localT, declaringClass, fieldName, type); }
        @Override public <T> IAccessPathT<Object> field(ILocalT<T> localT, Class<?> declaringClass, String fieldName, String fieldType) { return delegate.field(localT, declaringClass, fieldName, fieldType); }
        @Override public <T> IAccessPathT<Object> field(ILocalT<T> localT, IClassField field) { return delegate.field(localT, field); }
        @Override public void check(IBoolExpr expr, CheckType checkType, Consumer<BugMessage.Env> env) { delegate.check(expr, checkType, env); }
        @Override public void check(ILocalT<Boolean> localT, CheckType checkType, Consumer<BugMessage.Env> env) { delegate.check(localT, checkType, env); }
        @Override public void eval(IExpr expr, Consumer<Object> result) { delegate.eval(expr, result); }
        @Override public void eval(IBoolExpr expr, Consumer<Boolean> result) { delegate.eval(expr, result); }
        @Override public void eval(IStringExpr expr, Consumer<String> result) { delegate.eval(expr, result); }
        @Override public void eval(IIntExpr expr, Consumer<Integer> result) { delegate.eval(expr, result); }
    }
}
