package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public final class StaticMethodDecl<R> implements IMethodDecl<R>, ISMethodDecl<R> {
    private final IMethodDecl<R> delegate;

    public StaticMethodDecl(@NotNull IMethodDecl<R> delegate) {
        if (delegate == null) {
            throw new NullPointerException("delegate");
        }
        this.delegate = delegate;
    }

    @Override
    public @NotNull ISMethodDecl.CheckBuilder<R> checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) {
            throw new NullPointerException("config");
        }
        return new CheckBuilder<>(delegate.checkBuilder(config));
    }

    @Override
    public @NotNull IMethodMatch getMatch() {
        return delegate.getMatch();
    }

    @Override
    public @NotNull AIAnalysisApi.Error getError() {
        return delegate.getError();
    }

    @Override
    public @Nullable Integer getArgumentCnt() {
        return delegate.getArgumentCnt();
    }

    @Override
    public @Nullable KFunctionType getActualType() {
        return delegate.getActualType();
    }

    @Override
    public void eachLocalVar(@NotNull Function<ISootLocalVarDecl<Object>, Void> block) {
        if (block == null) {
            throw new NullPointerException("block");
        }
        delegate.eachLocalVar(block);
    }

    public static final class CheckBuilder<R> implements ISMethodDecl.CheckBuilder<R>, IMethodDecl.CheckBuilder<R> {
        private final IMethodDecl.CheckBuilder<R> delegate;

        public CheckBuilder(@NotNull IMethodDecl.CheckBuilder<R> delegate) {
            if (delegate == null) {
                throw new NullPointerException("delegate");
            }
            this.delegate = delegate;
        }

        @Override
        public @NotNull IMethodDecl<R> getMethod() {
            return delegate.getMethod();
        }

        @Override
        public @NotNull Function<MethodConfig, Void> getConfig() {
            return delegate.getConfig();
        }

        @Override
        public @NotNull ILocalT<Object> getGlobal() {
            return delegate.getGlobal();
        }

        @Override
        public @NotNull <T> IParameterT<T> paramAt(int index) {
            return delegate.paramAt(index);
        }

        @Override
        public @NotNull IReturnT<R> getReturn() {
            return delegate.getReturn();
        }

        @Override
        public @NotNull IWithSubFieldsT getSubFields(@NotNull ILocalT<?> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getSubFields(localT);
        }

        @Override
        public @NotNull <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getAttr(localT);
        }

        @Override
        public @NotNull <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getTaint(localT);
        }

        @Override
        public <T> void setTaint(@NotNull ILocalT<T> localT, @NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            if (attribute == null) {
                throw new NullPointerException("attribute");
            }
            delegate.setTaint(localT, attribute);
        }

        @Override
        public @NotNull <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getVia(localT);
        }

        @Override
        public <T> void setVia(@NotNull ILocalT<T> localT, @NotNull IAttribute<ViaProperty, Set<IViaType>> attribute) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            if (attribute == null) {
                throw new NullPointerException("attribute");
            }
            delegate.setVia(localT, attribute);
        }

        @Override
        public @NotNull <T> ILocalValue<T> getValue(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getValue(localT);
        }

        @Override
        public <T> void setValue(@NotNull ILocalT<T> localT, @NotNull ILocalValue<T> value) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            if (value == null) {
                throw new NullPointerException("value");
            }
            delegate.setValue(localT, value);
        }

        @Override
        public @NotNull IStringExpr literal(@NotNull String string) {
            if (string == null) {
                throw new NullPointerException("string");
            }
            return delegate.literal(string);
        }

        @Override
        public @NotNull IIntExpr literal(int n) {
            return delegate.literal(n);
        }

        @Override
        public @NotNull ILongExpr literal(long l) {
            return delegate.literal(l);
        }

        @Override
        public @NotNull IBoolExpr literal(boolean bool) {
            return delegate.literal(bool);
        }

        @Override
        public @NotNull <T> IBoolExpr isConstant(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.isConstant(localT);
        }

        @Override
        public @NotNull IBoolExpr isConstant(@NotNull ITypedExpr typedExpr) {
            if (typedExpr == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.isConstant(typedExpr);
        }

        @Override
        public @NotNull IBoolExpr not(@NotNull IBoolExpr boolExpr) {
            if (boolExpr == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.not(boolExpr);
        }

        @Override
        public @NotNull IBoolExpr or(@NotNull IBoolExpr boolExpr, @NotNull IBoolExpr other) {
            if (boolExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (other == null) {
                throw new NullPointerException("other");
            }
            return delegate.or(boolExpr, other);
        }

        @Override
        public @NotNull IIntExpr or(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.or(intExpr, rhs);
        }

        @Override
        public @NotNull IBoolExpr and(@NotNull IBoolExpr boolExpr, @NotNull IBoolExpr other) {
            if (boolExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (other == null) {
                throw new NullPointerException("other");
            }
            return delegate.and(boolExpr, other);
        }

        @Override
        public @NotNull IIntExpr and(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.and(intExpr, rhs);
        }

        @Override
        public @NotNull IBoolExpr lt(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.lt(intExpr, rhs);
        }

        @Override
        public @NotNull IBoolExpr le(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.le(intExpr, rhs);
        }

        @Override
        public @NotNull IBoolExpr eq(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.eq(intExpr, rhs);
        }

        @Override
        public @NotNull IBoolExpr ge(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.ge(intExpr, rhs);
        }

        @Override
        public @NotNull IBoolExpr gt(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.gt(intExpr, rhs);
        }

        @Override
        public @NotNull IBoolExpr neq(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.neq(intExpr, rhs);
        }

        @Override
        public @NotNull IIntExpr xor(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.xor(intExpr, rhs);
        }

        @Override
        public @NotNull IIntExpr shl(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.shl(intExpr, rhs);
        }

        @Override
        public @NotNull IIntExpr shr(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.shr(intExpr, rhs);
        }

        @Override
        public @NotNull IIntExpr lshr(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.lshr(intExpr, rhs);
        }

        @Override
        public @NotNull IIntExpr plus(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.plus(intExpr, rhs);
        }

        @Override
        public @NotNull <T extends IClassField, V extends Set<?>> IAttribute<T, V> plus(@NotNull IAttribute<T, V> attribute, @NotNull IAttribute<T, V> set) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (set == null) {
                throw new NullPointerException("set");
            }
            return delegate.plus(attribute, set);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType single) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (single == null) {
                throw new NullPointerException("single");
            }
            return delegate.plus(attribute, single);
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> attribute, @NotNull IViaType single) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (single == null) {
                throw new NullPointerException("single");
            }
            return delegate.plus(attribute, single);
        }

        @Override
        public @NotNull IIntExpr minus(@NotNull IIntExpr intExpr, @NotNull IIntExpr rhs) {
            if (intExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (rhs == null) {
                throw new NullPointerException("rhs");
            }
            return delegate.minus(intExpr, rhs);
        }

        @Override
        public @NotNull <T extends IClassField, V extends Set<?>> IAttribute<T, V> minus(@NotNull IAttribute<T, V> attribute, @NotNull IAttribute<T, V> set) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (set == null) {
                throw new NullPointerException("set");
            }
            return delegate.minus(attribute, set);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType single) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (single == null) {
                throw new NullPointerException("single");
            }
            return delegate.minus(attribute, single);
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> attribute, @NotNull IViaType single) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (single == null) {
                throw new NullPointerException("single");
            }
            return delegate.minus(attribute, single);
        }

        @Override
        public @NotNull <T> IBoolExpr getBoolean(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getBoolean(localT);
        }

        @Override
        public @NotNull <T> IStringExpr getString(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getString(localT);
        }

        @Override
        public @NotNull <T> IIntExpr getInt(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getInt(localT);
        }

        @Override
        public @NotNull <T> ILongExpr getLong(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getLong(localT);
        }

        @Override
        public @NotNull <T> IStringExpr getEnumName(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.getEnumName(localT);
        }

        @Override
        public @NotNull <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> localT, @NotNull String parentType) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            if (parentType == null) {
                throw new NullPointerException("parentType");
            }
            return delegate.isInstanceOf(localT, parentType);
        }

        @Override
        public @NotNull IStringExpr toLowerCase(@NotNull IStringExpr stringExpr) {
            if (stringExpr == null) {
                throw new NullPointerException("<this>");
            }
            return delegate.toLowerCase(stringExpr);
        }

        @Override
        public @NotNull IBoolExpr startsWith(@NotNull IStringExpr stringExpr, @NotNull IStringExpr str) {
            if (stringExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (str == null) {
                throw new NullPointerException("str");
            }
            return delegate.startsWith(stringExpr, str);
        }

        @Override
        public @NotNull IBoolExpr startsWith(@NotNull IStringExpr stringExpr, @NotNull String str) {
            if (stringExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (str == null) {
                throw new NullPointerException("str");
            }
            return delegate.startsWith(stringExpr, str);
        }

        @Override
        public @NotNull IBoolExpr endsWith(@NotNull IStringExpr stringExpr, @NotNull IStringExpr str) {
            if (stringExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (str == null) {
                throw new NullPointerException("str");
            }
            return delegate.endsWith(stringExpr, str);
        }

        @Override
        public @NotNull IBoolExpr endsWith(@NotNull IStringExpr stringExpr, @NotNull String str) {
            if (stringExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (str == null) {
                throw new NullPointerException("str");
            }
            return delegate.endsWith(stringExpr, str);
        }

        @Override
        public @NotNull IBoolExpr contains(@NotNull IStringExpr stringExpr, @NotNull IStringExpr str) {
            if (stringExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (str == null) {
                throw new NullPointerException("str");
            }
            return delegate.contains(stringExpr, str);
        }

        @Override
        public @NotNull IBoolExpr contains(@NotNull IStringExpr stringExpr, @NotNull String str) {
            if (stringExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (str == null) {
                throw new NullPointerException("str");
            }
            return delegate.contains(stringExpr, str);
        }

        @Override
        public @NotNull IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType taint) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (taint == null) {
                throw new NullPointerException("taint");
            }
            return delegate.contains(attribute, taint);
        }

        @Override
        public @NotNull IBoolExpr stringEquals(@NotNull IStringExpr stringExpr, @NotNull IStringExpr str) {
            if (stringExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (str == null) {
                throw new NullPointerException("str");
            }
            return delegate.stringEquals(stringExpr, str);
        }

        @Override
        public @NotNull IBoolExpr stringEquals(@NotNull IStringExpr stringExpr, @NotNull String str) {
            if (stringExpr == null) {
                throw new NullPointerException("<this>");
            }
            if (str == null) {
                throw new NullPointerException("str");
            }
            return delegate.stringEquals(stringExpr, str);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... type) {
            if (type == null) {
                throw new NullPointerException("type");
            }
            return delegate.taintOf(type);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> types) {
            if (types == null) {
                throw new NullPointerException("types");
            }
            return delegate.taintOf(types);
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType... via) {
            if (via == null) {
                throw new NullPointerException("via");
            }
            return delegate.viaOf(via);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return delegate.getEmptyTaint();
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return delegate.getEmptyVia();
        }

        @Override
        public @NotNull <T> ILocalValue<T> anyOf(ILocalT<T>... local) {
            if (local == null) {
                throw new NullPointerException("local");
            }
            return delegate.anyOf(local);
        }

        @Override
        public @NotNull <T> ILocalValue<T> nullValue() {
            return delegate.nullValue();
        }

        @Override
        public @NotNull IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (taint == null) {
                throw new NullPointerException("taint");
            }
            return delegate.hasIntersection(attribute, taint);
        }

        @Override
        public @NotNull IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType taint) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (taint == null) {
                throw new NullPointerException("taint");
            }
            return delegate.containsAll(attribute, taint);
        }

        @Override
        public @NotNull IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull IAttribute<TaintProperty, Set<ITaintType>> taint) {
            if (attribute == null) {
                throw new NullPointerException("<this>");
            }
            if (taint == null) {
                throw new NullPointerException("taint");
            }
            return delegate.containsAll(attribute, taint);
        }

        @Override
        public @NotNull <T1 extends R, T2 extends R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> localValue, @NotNull ILocalValue<T2> second) {
            if (localValue == null) {
                throw new NullPointerException("<this>");
            }
            if (second == null) {
                throw new NullPointerException("second");
            }
            return delegate.anyOr(localValue, second);
        }

        @Override
        public @NotNull <T1 extends R, T2 extends R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> localT, @NotNull ILocalT<T2> second) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            if (second == null) {
                throw new NullPointerException("second");
            }
            return delegate.anyOr(localT, second);
        }

        @Override
        public @NotNull <T> IAccessPathT<Object> field(@NotNull ILocalT<T> localT, @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            if (fieldName == null) {
                throw new NullPointerException("fieldName");
            }
            return delegate.field(localT, declaringClass, fieldName, fieldType);
        }

        @Override
        public @NotNull <T> IAccessPathT<Object> field(@NotNull ILocalT<T> localT, @NotNull SootField field) {
            if (localT == null) {
                throw new NullPointerException("<this>");
            }
            if (field == null) {
                throw new NullPointerException("field");
            }
            return delegate.field(localT, field);
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            if (stmt == null) {
                throw new NullPointerException("stmt");
            }
            delegate.addStmt(stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function<? super BugMessage.Env, Void> env) {
            if (expr == null) {
                throw new NullPointerException("expr");
            }
            if (checkType == null) {
                throw new NullPointerException("checkType");
            }
            if (env == null) {
                throw new NullPointerException("env");
            }
            delegate.check(expr, checkType, env);
        }

        @Override
        public void check(@NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function<? super BugMessage.Env, Void> env) {
            if (expr == null) {
                throw new NullPointerException("expr");
            }
            if (checkType == null) {
                throw new NullPointerException("checkType");
            }
            if (env == null) {
                throw new NullPointerException("env");
            }
            delegate.check(expr, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Function<Object, Void> result) {
            if (expr == null) {
                throw new NullPointerException("expr");
            }
            if (result == null) {
                throw new NullPointerException("result");
            }
            delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IBoolExpr expr, @NotNull Function<? super Boolean, Void> result) {
            if (expr == null) {
                throw new NullPointerException("expr");
            }
            if (result == null) {
                throw new NullPointerException("result");
            }
            delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IStringExpr expr, @NotNull Function<? super String, Void> result) {
            if (expr == null) {
                throw new NullPointerException("expr");
            }
            if (result == null) {
                throw new NullPointerException("result");
            }
            delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IIntExpr expr, @NotNull Function<? super Integer, Void> result) {
            if (expr == null) {
                throw new NullPointerException("expr");
            }
            if (result == null) {
                throw new NullPointerException("result");
            }
            delegate.eval(expr, result);
        }
    }
}