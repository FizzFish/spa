package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.KFunctionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public final class InstanceMethodDecl<R, This> implements IMethodDecl<R>, IIMethodDecl<R, This> {
    private final IMethodDecl<R> delegate;

    public InstanceMethodDecl(@NotNull IMethodDecl<R> delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("delegate cannot be null");
        }
        this.delegate = delegate;
    }

    @Override
    public @NotNull IIMethodDecl.CheckBuilder<R, This> checkBuilder(@NotNull Function<MethodConfig, Void> config) {
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
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
            throw new IllegalArgumentException("block cannot be null");
        }
        delegate.eachLocalVar(block);
    }

    public static final class CheckBuilder<R, This> implements IIMethodDecl.CheckBuilder<R, This>, IMethodDecl.CheckBuilder<R> {
        private final IMethodDecl.CheckBuilder<R> delegate;
        private final IParameterT<This> thisParam;

        public CheckBuilder(@NotNull IMethodDecl.CheckBuilder<R> delegate) {
            if (delegate == null) {
                throw new IllegalArgumentException("delegate cannot be null");
            }
            this.delegate = delegate;
            this.thisParam = delegate.paramAt(-1);
        }

        @Override
        public @NotNull IParameterT<This> getThis() {
            return thisParam;
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
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getSubFields(localT);
        }

        @Override
        public @NotNull <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getAttr(localT);
        }

        @Override
        public @NotNull <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getTaint(localT);
        }

        @Override
        public <T> void setTaint(@NotNull ILocalT<T> localT, @NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute) {
            if (localT == null || attribute == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.setTaint(localT, attribute);
        }

        @Override
        public @NotNull <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getVia(localT);
        }

        @Override
        public <T> void setVia(@NotNull ILocalT<T> localT, @NotNull IAttribute<ViaProperty, Set<IViaType>> attribute) {
            if (localT == null || attribute == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.setVia(localT, attribute);
        }

        @Override
        public @NotNull <T> ILocalValue<T> getValue(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getValue(localT);
        }

        @Override
        public <T> void setValue(@NotNull ILocalT<T> localT, @NotNull ILocalValue<T> value) {
            if (localT == null || value == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.setValue(localT, value);
        }

        @Override
        public @NotNull IStringExpr literal(@NotNull String string) {
            if (string == null) {
                throw new IllegalArgumentException("string cannot be null");
            }
            return delegate.literal(string);
        }

        @Override
        public @NotNull IIntExpr literal(int value) {
            return delegate.literal(value);
        }

        @Override
        public @NotNull ILongExpr literal(long value) {
            return delegate.literal(value);
        }

        @Override
        public @NotNull IBoolExpr literal(boolean value) {
            return delegate.literal(value);
        }

        @Override
        public @NotNull <T> IBoolExpr isConstant(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.isConstant(localT);
        }

        @Override
        public @NotNull IBoolExpr isConstant(@NotNull ITypedExpr typedExpr) {
            if (typedExpr == null) {
                throw new IllegalArgumentException("typedExpr cannot be null");
            }
            return delegate.isConstant(typedExpr);
        }

        @Override
        public @NotNull IBoolExpr not(@NotNull IBoolExpr boolExpr) {
            if (boolExpr == null) {
                throw new IllegalArgumentException("boolExpr cannot be null");
            }
            return delegate.not(boolExpr);
        }

        @Override
        public @NotNull IBoolExpr or(@NotNull IBoolExpr first, @NotNull IBoolExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.or(first, second);
        }

        @Override
        public @NotNull IIntExpr or(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.or(first, second);
        }

        @Override
        public @NotNull IBoolExpr and(@NotNull IBoolExpr first, @NotNull IBoolExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.and(first, second);
        }

        @Override
        public @NotNull IIntExpr and(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.and(first, second);
        }

        @Override
        public @NotNull IBoolExpr lt(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.lt(first, second);
        }

        @Override
        public @NotNull IBoolExpr le(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.le(first, second);
        }

        @Override
        public @NotNull IBoolExpr eq(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.eq(first, second);
        }

        @Override
        public @NotNull IBoolExpr ge(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.ge(first, second);
        }

        @Override
        public @NotNull IBoolExpr gt(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.gt(first, second);
        }

        @Override
        public @NotNull IBoolExpr neq(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.neq(first, second);
        }

        @Override
        public @NotNull IIntExpr xor(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.xor(first, second);
        }

        @Override
        public @NotNull IIntExpr shl(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.shl(first, second);
        }

        @Override
        public @NotNull IIntExpr shr(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.shr(first, second);
        }

        @Override
        public @NotNull IIntExpr lshr(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.lshr(first, second);
        }

        @Override
        public @NotNull IIntExpr plus(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.plus(first, second);
        }

        @Override
        public @NotNull <T extends IClassField, V extends Set<?>> IAttribute<T, V> plus(@NotNull IAttribute<T, V> first, @NotNull IAttribute<T, V> second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.plus(first, second);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType taintType) {
            if (attribute == null || taintType == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.plus(attribute, taintType);
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> attribute, @NotNull IViaType viaType) {
            if (attribute == null || viaType == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.plus(attribute, viaType);
        }

        @Override
        public @NotNull IIntExpr minus(@NotNull IIntExpr first, @NotNull IIntExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.minus(first, second);
        }

        @Override
        public @NotNull <T extends IClassField, V extends Set<?>> IAttribute<T, V> minus(@NotNull IAttribute<T, V> first, @NotNull IAttribute<T, V> second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.minus(first, second);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType taintType) {
            if (attribute == null || taintType == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.minus(attribute, taintType);
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> attribute, @NotNull IViaType viaType) {
            if (attribute == null || viaType == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.minus(attribute, viaType);
        }

        @Override
        public @NotNull <T> IBoolExpr getBoolean(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getBoolean(localT);
        }

        @Override
        public @NotNull <T> IStringExpr getString(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getString(localT);
        }

        @Override
        public @NotNull <T> IIntExpr getInt(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getInt(localT);
        }

        @Override
        public @NotNull <T> ILongExpr getLong(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getLong(localT);
        }

        @Override
        public @NotNull <T> IStringExpr getEnumName(@NotNull ILocalT<T> localT) {
            if (localT == null) {
                throw new IllegalArgumentException("localT cannot be null");
            }
            return delegate.getEnumName(localT);
        }

        @Override
        public @NotNull <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> localT, @NotNull String parentType) {
            if (localT == null || parentType == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.isInstanceOf(localT, parentType);
        }

        @Override
        public @NotNull IStringExpr toLowerCase(@NotNull IStringExpr stringExpr) {
            if (stringExpr == null) {
                throw new IllegalArgumentException("stringExpr cannot be null");
            }
            return delegate.toLowerCase(stringExpr);
        }

        @Override
        public @NotNull IBoolExpr startsWith(@NotNull IStringExpr stringExpr, @NotNull IStringExpr prefix) {
            if (stringExpr == null || prefix == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.startsWith(stringExpr, prefix);
        }

        @Override
        public @NotNull IBoolExpr startsWith(@NotNull IStringExpr stringExpr, @NotNull String prefix) {
            if (stringExpr == null || prefix == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.startsWith(stringExpr, prefix);
        }

        @Override
        public @NotNull IBoolExpr endsWith(@NotNull IStringExpr stringExpr, @NotNull IStringExpr suffix) {
            if (stringExpr == null || suffix == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.endsWith(stringExpr, suffix);
        }

        @Override
        public @NotNull IBoolExpr endsWith(@NotNull IStringExpr stringExpr, @NotNull String suffix) {
            if (stringExpr == null || suffix == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.endsWith(stringExpr, suffix);
        }

        @Override
        public @NotNull IBoolExpr contains(@NotNull IStringExpr stringExpr, @NotNull IStringExpr substring) {
            if (stringExpr == null || substring == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.contains(stringExpr, substring);
        }

        @Override
        public @NotNull IBoolExpr contains(@NotNull IStringExpr stringExpr, @NotNull String substring) {
            if (stringExpr == null || substring == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.contains(stringExpr, substring);
        }

        @Override
        public @NotNull IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType taintType) {
            if (attribute == null || taintType == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.contains(attribute, taintType);
        }

        @Override
        public @NotNull IBoolExpr stringEquals(@NotNull IStringExpr first, @NotNull IStringExpr second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.stringEquals(first, second);
        }

        @Override
        public @NotNull IBoolExpr stringEquals(@NotNull IStringExpr stringExpr, @NotNull String string) {
            if (stringExpr == null || string == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.stringEquals(stringExpr, string);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... types) {
            if (types == null) {
                throw new IllegalArgumentException("types cannot be null");
            }
            return delegate.taintOf(types);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> types) {
            if (types == null) {
                throw new IllegalArgumentException("types cannot be null");
            }
            return delegate.taintOf(types);
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType... viaTypes) {
            if (viaTypes == null) {
                throw new IllegalArgumentException("viaTypes cannot be null");
            }
            return delegate.viaOf(viaTypes);
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
        public @NotNull <T> ILocalValue<T> anyOf(ILocalT<T>... locals) {
            if (locals == null) {
                throw new IllegalArgumentException("locals cannot be null");
            }
            return delegate.anyOf(locals);
        }

        @Override
        public @NotNull <T> ILocalValue<T> nullValue() {
            return delegate.nullValue();
        }

        @Override
        public @NotNull IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> first, @NotNull IAttribute<TaintProperty, Set<ITaintType>> second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.hasIntersection(first, second);
        }

        @Override
        public @NotNull IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType taintType) {
            if (attribute == null || taintType == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.containsAll(attribute, taintType);
        }

        @Override
        public @NotNull IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> first, @NotNull IAttribute<TaintProperty, Set<ITaintType>> second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.containsAll(first, second);
        }

        @Override
        public @NotNull <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> first, @NotNull ILocalValue<T2> second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.anyOr(first, second);
        }

        @Override
        public @NotNull <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> first, @NotNull ILocalT<T2> second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.anyOr(first, second);
        }

        @Override
        public @NotNull <T> IAccessPathT<Object> field(@NotNull ILocalT<T> localT, @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            if (localT == null || fieldName == null) {
                throw new IllegalArgumentException("Required arguments cannot be null");
            }
            return delegate.field(localT, declaringClass, fieldName, fieldType);
        }

        @Override
        public @NotNull <T> IAccessPathT<Object> field(@NotNull ILocalT<T> localT, @NotNull SootField field) {
            if (localT == null || field == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            return delegate.field(localT, field);
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            if (stmt == null) {
                throw new IllegalArgumentException("stmt cannot be null");
            }
            delegate.addStmt(stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, @NotNull Function<BugMessage.Env, Void> env) {
            if (expr == null || checkType == null || env == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.check(expr, checkType, env);
        }

        @Override
        public void check(@NotNull ILocalT<Boolean> localT, @NotNull CheckType checkType, @NotNull Function<BugMessage.Env, Void> env) {
            if (localT == null || checkType == null || env == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.check(localT, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Function<Object, Void> result) {
            if (expr == null || result == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IBoolExpr expr, @NotNull Function<Boolean, Void> result) {
            if (expr == null || result == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IStringExpr expr, @NotNull Function<String, Void> result) {
            if (expr == null || result == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IIntExpr expr, @NotNull Function<Integer, Void> result) {
            if (expr == null || result == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            delegate.eval(expr, result);
        }
    }
}
