package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public final class StaticMethodDecl14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
        implements ISMethodDecl14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>, ISMethodDecl<R> {

    private final ISMethodDecl<R> base;
    private final int argumentCnt;

    public StaticMethodDecl14(@NotNull ISMethodDecl<R> base, int argumentCnt) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.argumentCnt = argumentCnt;
    }

    public StaticMethodDecl14(@NotNull ISMethodDecl<R> base) {
        this(base, 14);
    }

    @Override
    @NotNull
    public Integer getArgumentCnt() {
        return argumentCnt;
    }

    @Override
    @NotNull
    public ISMethodDecl14.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> checkBuilder(
            @NotNull Function1<? super MethodConfig, Unit> config) {
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

    private static final class CheckBuilderImpl<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
            implements ISMethodDecl14.CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> {

        private final ISMethodDecl.CheckBuilder<R> delegate;
        private final ISMethodDecl14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> method;

        CheckBuilderImpl(StaticMethodDecl14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> method,
                        Function1<? super MethodConfig, Unit> config) {
            this.delegate = method.base.checkBuilder(config);
            this.method = method;
        }

        @Override
        public ISMethodDecl14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> getMethod() {
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

        @Override
        public <T> IAttribute<ViaProperty, Set<IViaType>> getVia(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getVia(localT);
        }

        @Override
        public <T> void setVia(ILocalT<T> localT, IAttribute<ViaProperty, Set<IViaType>> attribute) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (attribute == null) {
                throw new IllegalArgumentException("attribute cannot be null");
            }
            delegate.setVia(localT, attribute);
        }

        @Override
        public <T> ILocalValue<T> getValue(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getValue(localT);
        }

        @Override
        public <T> void setValue(ILocalT<T> localT, ILocalValue<T> localValue) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (localValue == null) {
                throw new IllegalArgumentException("localValue cannot be null");
            }
            delegate.setValue(localT, localValue);
        }

        @Override
        public IStringExpr literal(String string) {
            if (string == null) {
                throw new IllegalArgumentException("string cannot be null");
            }
            return delegate.literal(string);
        }

        @Override
        public IIntExpr literal(int value) {
            return delegate.literal(value);
        }

        @Override
        public ILongExpr literal(long value) {
            return delegate.literal(value);
        }

        @Override
        public IBoolExpr literal(boolean value) {
            return delegate.literal(value);
        }

        @Override
        public <T> IBoolExpr isConstant(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.isConstant(localT);
        }

        @Override
        public IBoolExpr isConstant(ITypedExpr typedExpr) {
            if (typedExpr == null) {
                throw new IllegalArgumentException("typedExpr cannot be null");
            }
            return delegate.isConstant(typedExpr);
        }

        @Override
        public IBoolExpr not(IBoolExpr boolExpr) {
            if (boolExpr == null) {
                throw new IllegalArgumentException("boolExpr cannot be null");
            }
            return delegate.not(boolExpr);
        }

        @Override
        public IBoolExpr or(IBoolExpr left, IBoolExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.or(left, right);
        }

        @Override
        public IIntExpr or(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.or(left, right);
        }

        @Override
        public IBoolExpr and(IBoolExpr left, IBoolExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.and(left, right);
        }

        @Override
        public IIntExpr and(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.and(left, right);
        }

        @Override
        public IBoolExpr lt(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.lt(left, right);
        }

        @Override
        public IBoolExpr le(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.le(left, right);
        }

        @Override
        public IBoolExpr eq(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.eq(left, right);
        }

        @Override
        public IBoolExpr ge(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.ge(left, right);
        }

        @Override
        public IBoolExpr gt(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.gt(left, right);
        }

        @Override
        public IBoolExpr neq(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.neq(left, right);
        }

        @Override
        public IIntExpr xor(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.xor(left, right);
        }

        @Override
        public IIntExpr shl(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.shl(left, right);
        }

        @Override
        public IIntExpr shr(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.shr(left, right);
        }

        @Override
        public IIntExpr lshr(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.lshr(left, right);
        }

        @Override
        public IIntExpr plus(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.plus(left, right);
        }

        @Override
        public <T extends IClassField, V extends Set<?>> IAttribute<T, V> plus(IAttribute<T, V> left, IAttribute<T, V> right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.plus(left, right);
        }

        @Override
        public IAttribute<TaintProperty, Set<ITaintType>> plus(IAttribute<TaintProperty, Set<ITaintType>> attribute, ITaintType taintType) {
            if (attribute == null) {
                throw new IllegalArgumentException("attribute cannot be null");
            }
            if (taintType == null) {
                throw new IllegalArgumentException("taintType cannot be null");
            }
            return delegate.plus(attribute, taintType);
        }

        @Override
        public IAttribute<ViaProperty, Set<IViaType>> plus(IAttribute<ViaProperty, Set<IViaType>> attribute, IViaType viaType) {
            if (attribute == null) {
                throw new IllegalArgumentException("attribute cannot be null");
            }
            if (viaType == null) {
                throw new IllegalArgumentException("viaType cannot be null");
            }
            return delegate.plus(attribute, viaType);
        }

        @Override
        public IIntExpr minus(IIntExpr left, IIntExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.minus(left, right);
        }

        @Override
        public <T extends IClassField, V extends Set<?>> IAttribute<T, V> minus(IAttribute<T, V> left, IAttribute<T, V> right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.minus(left, right);
        }

        @Override
        public IAttribute<TaintProperty, Set<ITaintType>> minus(IAttribute<TaintProperty, Set<ITaintType>> attribute, ITaintType taintType) {
            if (attribute == null) {
                throw new IllegalArgumentException("attribute cannot be null");
            }
            if (taintType == null) {
                throw new IllegalArgumentException("taintType cannot be null");
            }
            return delegate.minus(attribute, taintType);
        }

        @Override
        public IAttribute<ViaProperty, Set<IViaType>> minus(IAttribute<ViaProperty, Set<IViaType>> attribute, IViaType viaType) {
            if (attribute == null) {
                throw new IllegalArgumentException("attribute cannot be null");
            }
            if (viaType == null) {
                throw new IllegalArgumentException("viaType cannot be null");
            }
            return delegate.minus(attribute, viaType);
        }

        @Override
        public <T> IBoolExpr getBoolean(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getBoolean(localT);
        }

        @Override
        public <T> IStringExpr getString(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getString(localT);
        }

        @Override
        public <T> IIntExpr getInt(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getInt(localT);
        }

        @Override
        public <T> ILongExpr getLong(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getLong(localT);
        }

        @Override
        public <T> IStringExpr getEnumName(ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getEnumName(localT);
        }

        @Override
        public <T> IBoolExpr isInstanceOf(ILocalT<T> localT, String parentType) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (parentType == null) {
                throw new IllegalArgumentException("parentType cannot be null");
            }
            return delegate.isInstanceOf(localT, parentType);
        }

        @Override
        public IStringExpr toLowerCase(IStringExpr stringExpr) {
            if (stringExpr == null) {
                throw new IllegalArgumentException("stringExpr cannot be null");
            }
            return delegate.toLowerCase(stringExpr);
        }

        @Override
        public IBoolExpr startsWith(IStringExpr stringExpr, IStringExpr str) {
            if (stringExpr == null) {
                throw new IllegalArgumentException("stringExpr cannot be null");
            }
            if (str == null) {
                throw new IllegalArgumentException("str cannot be null");
            }
            return delegate.startsWith(stringExpr, str);
        }

        @Override
        public IBoolExpr startsWith(IStringExpr stringExpr, String str) {
            if (stringExpr == null) {
                throw new IllegalArgumentException("stringExpr cannot be null");
            }
            if (str == null) {
                throw new IllegalArgumentException("str cannot be null");
            }
            return delegate.startsWith(stringExpr, str);
        }

        @Override
        public IBoolExpr endsWith(IStringExpr stringExpr, IStringExpr str) {
            if (stringExpr == null) {
                throw new IllegalArgumentException("stringExpr cannot be null");
            }
            if (str == null) {
                throw new IllegalArgumentException("str cannot be null");
            }
            return delegate.endsWith(stringExpr, str);
        }

        @Override
        public IBoolExpr endsWith(IStringExpr stringExpr, String str) {
            if (stringExpr == null) {
                throw new IllegalArgumentException("stringExpr cannot be null");
            }
            if (str == null) {
                throw new IllegalArgumentException("str cannot be null");
            }
            return delegate.endsWith(stringExpr, str);
        }

        @Override
        public IBoolExpr contains(IStringExpr stringExpr, IStringExpr str) {
            if (stringExpr == null) {
                throw new IllegalArgumentException("stringExpr cannot be null");
            }
            if (str == null) {
                throw new IllegalArgumentException("str cannot be null");
            }
            return delegate.contains(stringExpr, str);
        }

        @Override
        public IBoolExpr contains(IStringExpr stringExpr, String str) {
            if (stringExpr == null) {
                throw new IllegalArgumentException("stringExpr cannot be null");
            }
            if (str == null) {
                throw new IllegalArgumentException("str cannot be null");
            }
            return delegate.contains(stringExpr, str);
        }

        @Override
        public IBoolExpr contains(IAttribute<TaintProperty, Set<ITaintType>> attribute, ITaintType taintType) {
            if (attribute == null) {
                throw new IllegalArgumentException("attribute cannot be null");
            }
            if (taintType == null) {
                throw new IllegalArgumentException("taintType cannot be null");
            }
            return delegate.contains(attribute, taintType);
        }

        @Override
        public IBoolExpr stringEquals(IStringExpr left, IStringExpr right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.stringEquals(left, right);
        }

        @Override
        public IBoolExpr stringEquals(IStringExpr stringExpr, String str) {
            if (stringExpr == null) {
                throw new IllegalArgumentException("stringExpr cannot be null");
            }
            if (str == null) {
                throw new IllegalArgumentException("str cannot be null");
            }
            return delegate.stringEquals(stringExpr, str);
        }

        @Override
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... types) {
            if (types == null) {
                throw new IllegalArgumentException("types cannot be null");
            }
            return delegate.taintOf(types);
        }

        @Override
        public IAttribute<TaintProperty, Set<ITaintType>> taintOf(Collection<? extends ITaintType> types) {
            if (types == null) {
                throw new IllegalArgumentException("types cannot be null");
            }
            return delegate.taintOf(types);
        }

        @Override
        public IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType... vias) {
            if (vias == null) {
                throw new IllegalArgumentException("vias cannot be null");
            }
            return delegate.viaOf(vias);
        }

        @Override
        public IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return delegate.getEmptyTaint();
        }

        @Override
        public IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return delegate.getEmptyVia();
        }

        @Override
        public <T> ILocalValue<T> anyOf(ILocalT<T>... locals) {
            if (locals == null) {
                throw new IllegalArgumentException("locals cannot be null");
            }
            return delegate.anyOf(locals);
        }

        @Override
        public <T> ILocalValue<T> nullValue() {
            return delegate.nullValue();
        }

        @Override
        public IBoolExpr hasIntersection(IAttribute<TaintProperty, Set<ITaintType>> left, IAttribute<TaintProperty, Set<ITaintType>> right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.hasIntersection(left, right);
        }

        @Override
        public IBoolExpr containsAll(IAttribute<TaintProperty, Set<ITaintType>> attribute, ITaintType taintType) {
            if (attribute == null) {
                throw new IllegalArgumentException("attribute cannot be null");
            }
            if (taintType == null) {
                throw new IllegalArgumentException("taintType cannot be null");
            }
            return delegate.containsAll(attribute, taintType);
        }

        @Override
        public IBoolExpr containsAll(IAttribute<TaintProperty, Set<ITaintType>> left, IAttribute<TaintProperty, Set<ITaintType>> right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.containsAll(left, right);
        }

        @Override
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(ILocalValue<T1> left, ILocalValue<T2> right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.anyOr(left, right);
        }

        @Override
        public <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(ILocalT<T1> left, ILocalT<T2> right) {
            if (left == null) {
                throw new IllegalArgumentException("left cannot be null");
            }
            if (right == null) {
                throw new IllegalArgumentException("right cannot be null");
            }
            return delegate.anyOr(left, right);
        }

        @Override
        public <T> IAccessPathT<Object> field(ILocalT<T> localT, String declaringClass, String fieldName, String fieldType) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (fieldName == null) {
                throw new IllegalArgumentException("fieldName cannot be null");
            }
            return delegate.field(localT, declaringClass, fieldName, fieldType);
        }

        @Override
        public <T> IAccessPathT<Object> field(ILocalT<T> localT, SootField field) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (field == null) {
                throw new IllegalArgumentException("field cannot be null");
            }
            return delegate.field(localT, field);
        }

        @Override
        public <T, FieldType> IAccessPathT<FieldType> field(ILocalT<T> localT, String declaringClass, String fieldName, Class<FieldType> type) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (fieldName == null) {
                throw new IllegalArgumentException("fieldName cannot be null");
            }
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }
            return delegate.field(localT, declaringClass, fieldName, type);
        }

        @Override
        public <T, FieldType> IAccessPathT<FieldType> field(ILocalT<T> localT, Class<?> declaringClass, String fieldName, Class<FieldType> type) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (fieldName == null) {
                throw new IllegalArgumentException("fieldName cannot be null");
            }
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }
            return delegate.field(localT, declaringClass, fieldName, type);
        }

        @Override
        public <T> IAccessPathT<Object> field(ILocalT<T> localT, Class<?> declaringClass, String fieldName, String fieldType) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (declaringClass == null) {
                throw new IllegalArgumentException("declaringClass cannot be null");
            }
            if (fieldName == null) {
                throw new IllegalArgumentException("fieldName cannot be null");
            }
            return delegate.field(localT, declaringClass, fieldName, fieldType);
        }

        @Override
        public <T> IAccessPathT<Object> field(ILocalT<T> localT, IClassField field) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            if (field == null) {
                throw new IllegalArgumentException("field cannot be null");
            }
            return delegate.field(localT, field);
        }

        @Override
        public void addStmt(IStmt stmt) {
            if (stmt == null) {
                throw new IllegalArgumentException("stmt cannot be null");
            }
            delegate.addStmt(stmt);
        }

        @Override
        public void check(IBoolExpr expr, CheckType checkType, Function1<? super BugMessage.Env, Unit> env) {
            if (expr == null) {
                throw new IllegalArgumentException("expr cannot be null");
            }
            if (checkType == null) {
                throw new IllegalArgumentException("checkType cannot be null");
            }
            if (env == null) {
                throw new IllegalArgumentException("env cannot be null");
            }
            delegate.check(expr, checkType, env);
        }

        @Override
        public void check(ILocalT<Boolean> expr, CheckType checkType, Function1<? super BugMessage.Env, Unit> env) {
            if (expr == null) {
                throw new IllegalArgumentException("expr cannot be null");
            }
            if (checkType == null) {
                throw new IllegalArgumentException("checkType cannot be null");
            }
            if (env == null) {
                throw new IllegalArgumentException("env cannot be null");
            }
            delegate.check(expr, checkType, env);
        }

        @Override
        public void eval(IExpr expr, Function1<Object, Unit> result) {
            if (expr == null) {
                throw new IllegalArgumentException("expr cannot be null");
            }
            if (result == null) {
                throw new IllegalArgumentException("result cannot be null");
            }
            delegate.eval(expr, result);
        }

        @Override
        public void eval(IBoolExpr expr, Function1<? super Boolean, Unit> result) {
            if (expr == null) {
                throw new IllegalArgumentException("expr cannot be null");
            }
            if (result == null) {
                throw new IllegalArgumentException("result cannot be null");
            }
            delegate.eval(expr, result);
        }

        @Override
        public void eval(IStringExpr expr, Function1<? super String, Unit> result) {
            if (expr == null) {
                throw new IllegalArgumentException("expr cannot be null");
            }
            if (result == null) {
                throw new IllegalArgumentException("result cannot be null");
            }
            delegate.eval(expr, result);
        }

        @Override
        public void eval(IIntExpr expr, Function1<? super Integer, Unit> result) {
            if (expr == null) {
                throw new IllegalArgumentException("expr cannot be null");
            }
            if (result == null) {
                throw new IllegalArgumentException("result cannot be null");
            }
            delegate.eval(expr, result);
        }
    }
}
