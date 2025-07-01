package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function14;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

import java.util.Collection;
import java.util.Set;

public final class StaticMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
        implements ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, ISMethodDecl<R> {

    @NotNull
    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl13(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl13(@NotNull ISMethodDecl<R> base) {
        this(base, 13);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public ISMethodDecl13.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        return new CheckBuilderImpl(this, config);
    }

    @Override
    @NotNull
    public ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> model(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function14<? super ISMethodDecl13.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, 
                    ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>, 
                    ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, ? super IParameterT<P7>, 
                    ? super IParameterT<P8>, ? super IParameterT<P9>, ? super IParameterT<P10>, ? super IParameterT<P11>, 
                    ? super IParameterT<P12>, Unit> block) {
        ISMethodDecl13.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> builder = checkBuilder(config);
        block.invoke(builder, 
                builder.getP0(), builder.getP1(), builder.getP2(), builder.getP3(), 
                builder.getP4(), builder.getP5(), builder.getP6(), builder.getP7(), 
                builder.getP8(), builder.getP9(), builder.getP10(), builder.getP11(), 
                builder.getP12());
        return this;
    }

    @Override
    @NotNull
    public ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> modelNoArg(
            @NotNull Function1<? super MethodConfig, Unit> config,
            @NotNull Function1<? super ISMethodDecl13.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, Unit> block) {
        block.invoke(checkBuilder(config));
        return this;
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

    private static class CheckBuilderImpl<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> 
            implements ISMethodDecl13.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> {

        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> method;

        CheckBuilderImpl(StaticMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> method, 
                        Function1<? super MethodConfig, Unit> config) {
            this.delegate = method.base.checkBuilder(config);
            this.method = method;
        }

        @Override
        public ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> getMethod() {
            return method;
        }

        @Override
        public Function1<MethodConfig, Unit> getConfig() {
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

        // Delegate all other methods to the underlying CheckBuilder
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
        @Override public IStringExpr literal(String string) { return delegate.literal(string); }
        @Override public IIntExpr literal(int n) { return delegate.literal(n); }
        @Override public ILongExpr literal(long l) { return delegate.literal(l); }
        @Override public IBoolExpr literal(boolean bool) { return delegate.literal(bool); }
        @Override public <T> IBoolExpr isConstant(ILocalT<T> localT) { return delegate.isConstant(localT); }
        @Override public IBoolExpr isConstant(ITypedExpr typedExpr) { return delegate.isConstant(typedExpr); }
        @Override public IBoolExpr not(IBoolExpr boolExpr) { return delegate.not(boolExpr); }
        @Override public IBoolExpr or(IBoolExpr boolExpr, IBoolExpr other) { return delegate.or(boolExpr, other); }
        @Override public IIntExpr or(IIntExpr intExpr, IIntExpr rhs) { return delegate.or(intExpr, rhs); }
        @Override public IBoolExpr and(IBoolExpr boolExpr, IBoolExpr other) { return delegate.and(boolExpr, other); }
        @Override public IIntExpr and(IIntExpr intExpr, IIntExpr rhs) { return delegate.and(intExpr, rhs); }
        @Override public IBoolExpr lt(IIntExpr intExpr, IIntExpr rhs) { return delegate.lt(intExpr, rhs); }
        @Override public IBoolExpr le(IIntExpr intExpr, IIntExpr rhs) { return delegate.le(intExpr, rhs); }
        @Override public IBoolExpr eq(IIntExpr intExpr, IIntExpr rhs) { return delegate.eq(intExpr, rhs); }
        @Override public IBoolExpr ge(IIntExpr intExpr, IIntExpr rhs) { return delegate.ge(intExpr, rhs); }
        @Override public IBoolExpr gt(IIntExpr intExpr, IIntExpr rhs) { return delegate.gt(intExpr, rhs); }
        @Override public IBoolExpr neq(IIntExpr intExpr, IIntExpr rhs) { return delegate.neq(intExpr, rhs); }
        @Override public IIntExpr xor(IIntExpr intExpr, IIntExpr rhs) { return delegate.xor(intExpr, rhs); }
        @Override public IIntExpr shl(IIntExpr intExpr, IIntExpr rhs) { return delegate.shl(intExpr, rhs); }
        @Override public IIntExpr shr(IIntExpr intExpr, IIntExpr rhs) { return delegate.shr(intExpr, rhs); }
        @Override public IIntExpr lshr(IIntExpr intExpr, IIntExpr rhs) { return delegate.lshr(intExpr, rhs); }
        @Override public IIntExpr plus(IIntExpr intExpr, IIntExpr rhs) { return delegate.plus(intExpr, rhs); }
        @Override public <T extends IClassField, V extends Set<?>> IAttribute<T, V> plus(IAttribute<T, V> attribute, IAttribute<T, V> set) { return delegate.plus(attribute, set); }
        @Override public IAttribute<TaintProperty, Set<ITaintType>> plus(IAttribute<TaintProperty, Set<ITaintType>> attribute, ITaintType single) { return delegate.plus(attribute, single); }
        @Override public IAttribute<ViaProperty, Set<IViaType>> plus(IAttribute<ViaProperty, Set<IViaType>> attribute, IViaType single) { return delegate.plus(attribute, single); }
        @Override public IIntExpr minus(IIntExpr intExpr, IIntExpr rhs) { return delegate.minus(intExpr, rhs); }
        @Override public <T extends IClassField, V extends Set<?>> IAttribute<T, V> minus(IAttribute<T, V> attribute, IAttribute<T, V> set) { return delegate.minus(attribute, set); }
        @Override public IAttribute<TaintProperty, Set<ITaintType>> minus(IAttribute<TaintProperty, Set<ITaintType>> attribute, ITaintType single) { return delegate.minus(attribute, single); }
        @Override public IAttribute<ViaProperty, Set<IViaType>> minus(IAttribute<ViaProperty, Set<IViaType>> attribute, IViaType single) { return delegate.minus(attribute, single); }
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
        @Override public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... type) { return delegate.taintOf(type); }
        @Override public IAttribute<TaintProperty, Set<ITaintType>> taintOf(Collection<? extends ITaintType> types) { return delegate.taintOf(types); }
        @Override public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType... via) { return delegate.viaOf(via); }
        @Override public IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() { return delegate.getEmptyTaint(); }
        @Override public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() { return delegate.getEmptyVia(); }
        @Override public <T> ILocalValue<T> anyOf(ILocalT<T>... local) { return delegate.anyOf(local); }
        @Override public <T> ILocalValue<T> nullValue() { return delegate.nullValue(); }
        @Override public IBoolExpr hasIntersection(IAttribute<TaintProperty, Set<ITaintType>> attribute, IAttribute<TaintProperty, Set<ITaintType>> taint) { return delegate.hasIntersection(attribute, taint); }
        @Override public IBoolExpr containsAll(IAttribute<TaintProperty, Set<ITaintType>> attribute, ITaintType taint) { return delegate.containsAll(attribute, taint); }
        @Override public IBoolExpr containsAll(IAttribute<TaintProperty, Set<ITaintType>> attribute, IAttribute<TaintProperty, Set<ITaintType>> taint) { return delegate.containsAll(attribute, taint); }
        @Override public <T1 extends R, T2 extends R, R1> ILocalValue<R1> anyOr(ILocalValue<T1> localValue, ILocalValue<T2> second) { return delegate.anyOr(localValue, second); }
        @Override public <T1 extends R, T2 extends R, R1> ILocalValue<R1> anyOr(ILocalT<T1> localT, ILocalT<T2> second) { return delegate.anyOr(localT, second); }
        @Override public <T> IAccessPathT<Object> field(ILocalT<T> localT, String declaringClass, String fieldName, String fieldType) { return delegate.field(localT, declaringClass, fieldName, fieldType); }
        @Override public <T> IAccessPathT<Object> field(ILocalT<T> localT, SootField field) { return delegate.field(localT, field); }
        @Override public <T, FieldType> IAccessPathT<FieldType> field(ILocalT<T> localT, String declaringClass, String fieldName, Class<FieldType> type) { return delegate.field(localT, declaringClass, fieldName, type); }
        @Override public <T, FieldType> IAccessPathT<FieldType> field(ILocalT<T> localT, Class<?> declaringClass, String fieldName, Class<FieldType> type) { return delegate.field(localT, declaringClass, fieldName, type); }
        @Override public <T> IAccessPathT<Object> field(ILocalT<T> localT, Class<?> declaringClass, String fieldName, String fieldType) { return delegate.field(localT, declaringClass, fieldName, fieldType); }
        @Override public <T> IAccessPathT<Object> field(ILocalT<T> localT, IClassField field) { return delegate.field(localT, field); }
        @Override public void addStmt(IStmt stmt) { delegate.addStmt(stmt); }
        @Override public void check(IBoolExpr expr, CheckType checkType, Function1<? super BugMessage.Env, Unit> env) { delegate.check(expr, checkType, env); }
        @Override public void check(ILocalT<Boolean> localT, CheckType checkType, Function1<? super BugMessage.Env, Unit> env) { delegate.check(localT, checkType, env); }
        @Override public void eval(IExpr expr, Function1<Object, Unit> result) { delegate.eval(expr, result); }
        @Override public void eval(IBoolExpr expr, Function1<? super Boolean, Unit> result) { delegate.eval(expr, result); }
        @Override public void eval(IStringExpr expr, Function1<? super String, Unit> result) { delegate.eval(expr, result); }
        @Override public void eval(IIntExpr expr, Function1<? super Integer, Unit> result) { delegate.eval(expr, result); }
    }
}
