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

public final class RawMethodDecl implements IRawMethodDecl<Object>, IMethodDecl<Object> {
    private final IMethodDecl<Object> delegate;

    public RawMethodDecl(@NotNull IMethodDecl<Object> delegate) {
        if (delegate == null) throw new NullPointerException("delegate");
        this.delegate = delegate;
    }

    @Override
    public @NotNull IRawMethodDecl.CheckBuilder<Object> checkBuilder(@NotNull Consumer<MethodConfig> config) {
        if (config == null) throw new NullPointerException("config");
        return new CheckBuilder(delegate.checkBuilder(config));
    }

    @Override
    public @NotNull String toString() {
        return delegate.toString();
    }

    @Override
    public @NotNull IRawMethodDecl<Object> model(@NotNull Consumer<MethodConfig> config, 
            @NotNull BiConsumer<IRawMethodDecl.CheckBuilder<Object>, IParameterT<Object>[]> block) {
        return IRawMethodDecl.super.model(config, block);
    }

    @Override
    public @NotNull IRawMethodDecl<Object> modelNoArg(@NotNull Consumer<MethodConfig> config, 
            @NotNull Consumer<IRawMethodDecl.CheckBuilder<Object>> block) {
        return IRawMethodDecl.super.modelNoArg(config, block);
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
    public void eachLocalVar(@NotNull Consumer<ISootLocalVarDecl<Object>> block) {
        if (block == null) throw new NullPointerException("block");
        delegate.eachLocalVar(block);
    }

    public static final class CheckBuilder implements IRawMethodDecl.CheckBuilder<Object>, IMethodDecl.CheckBuilder<Object> {
        private final IMethodDecl.CheckBuilder<Object> delegate;

        public CheckBuilder(@NotNull IMethodDecl.CheckBuilder<Object> delegate) {
            if (delegate == null) throw new NullPointerException("delegate");
            this.delegate = delegate;
        }

        @Override
        public @NotNull IMethodDecl<Object> getMethod() {
            return delegate.getMethod();
        }

        @Override
        public @NotNull Consumer<MethodConfig> getConfig() {
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
        public @NotNull IReturnT<Object> getReturn() {
            return delegate.getReturn();
        }

        @Override
        public @NotNull IWithSubFieldsT getSubFields(@NotNull ILocalT<?> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getSubFields(localT);
        }

        @Override
        public @NotNull <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull ILocalT<T> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getAttr(localT);
        }

        @Override
        public @NotNull <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getTaint(localT);
        }

        @Override
        public <T> void setTaint(@NotNull ILocalT<T> localT, @NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute) {
            if (localT == null) throw new NullPointerException("localT");
            if (attribute == null) throw new NullPointerException("attribute");
            delegate.setTaint(localT, attribute);
        }

        @Override
        public @NotNull <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getVia(localT);
        }

        @Override
        public <T> void setVia(@NotNull ILocalT<T> localT, @NotNull IAttribute<ViaProperty, Set<IViaType>> attribute) {
            if (localT == null) throw new NullPointerException("localT");
            if (attribute == null) throw new NullPointerException("attribute");
            delegate.setVia(localT, attribute);
        }

        @Override
        public @NotNull <T> ILocalValue<T> getValue(@NotNull ILocalT<T> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getValue(localT);
        }

        @Override
        public <T> void setValue(@NotNull ILocalT<T> localT, @NotNull ILocalValue<T> localValue) {
            if (localT == null) throw new NullPointerException("localT");
            if (localValue == null) throw new NullPointerException("localValue");
            delegate.setValue(localT, localValue);
        }

        @Override
        public @NotNull IStringExpr literal(@NotNull String string) {
            if (string == null) throw new NullPointerException("string");
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
            if (localT == null) throw new NullPointerException("localT");
            return delegate.isConstant(localT);
        }

        @Override
        public @NotNull IBoolExpr isConstant(@NotNull ITypedExpr typedExpr) {
            if (typedExpr == null) throw new NullPointerException("typedExpr");
            return delegate.isConstant(typedExpr);
        }

        @Override
        public @NotNull IBoolExpr not(@NotNull IBoolExpr boolExpr) {
            if (boolExpr == null) throw new NullPointerException("boolExpr");
            return delegate.not(boolExpr);
        }

        @Override
        public @NotNull IBoolExpr or(@NotNull IBoolExpr left, @NotNull IBoolExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.or(left, right);
        }

        @Override
        public @NotNull IIntExpr or(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.or(left, right);
        }

        @Override
        public @NotNull IBoolExpr and(@NotNull IBoolExpr left, @NotNull IBoolExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.and(left, right);
        }

        @Override
        public @NotNull IIntExpr and(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.and(left, right);
        }

        @Override
        public @NotNull IBoolExpr lt(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.lt(left, right);
        }

        @Override
        public @NotNull IBoolExpr le(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.le(left, right);
        }

        @Override
        public @NotNull IBoolExpr eq(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.eq(left, right);
        }

        @Override
        public @NotNull IBoolExpr ge(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.ge(left, right);
        }

        @Override
        public @NotNull IBoolExpr gt(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.gt(left, right);
        }

        @Override
        public @NotNull IBoolExpr neq(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.neq(left, right);
        }

        @Override
        public @NotNull IIntExpr xor(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.xor(left, right);
        }

        @Override
        public @NotNull IIntExpr shl(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.shl(left, right);
        }

        @Override
        public @NotNull IIntExpr shr(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.shr(left, right);
        }

        @Override
        public @NotNull IIntExpr lshr(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.lshr(left, right);
        }

        @Override
        public @NotNull IIntExpr plus(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.plus(left, right);
        }

        @Override
        public @NotNull <T extends IClassField, V extends Set<?>> IAttribute<T, V> plus(
                @NotNull IAttribute<T, V> left, @NotNull IAttribute<T, V> right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.plus(left, right);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> plus(
                @NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType taintType) {
            if (attribute == null) throw new NullPointerException("attribute");
            if (taintType == null) throw new NullPointerException("taintType");
            return delegate.plus(attribute, taintType);
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> plus(
                @NotNull IAttribute<ViaProperty, Set<IViaType>> attribute, @NotNull IViaType viaType) {
            if (attribute == null) throw new NullPointerException("attribute");
            if (viaType == null) throw new NullPointerException("viaType");
            return delegate.plus(attribute, viaType);
        }

        @Override
        public @NotNull IIntExpr minus(@NotNull IIntExpr left, @NotNull IIntExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.minus(left, right);
        }

        @Override
        public @NotNull <T extends IClassField, V extends Set<?>> IAttribute<T, V> minus(
                @NotNull IAttribute<T, V> left, @NotNull IAttribute<T, V> right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.minus(left, right);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> minus(
                @NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, @NotNull ITaintType taintType) {
            if (attribute == null) throw new NullPointerException("attribute");
            if (taintType == null) throw new NullPointerException("taintType");
            return delegate.minus(attribute, taintType);
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> minus(
                @NotNull IAttribute<ViaProperty, Set<IViaType>> attribute, @NotNull IViaType viaType) {
            if (attribute == null) throw new NullPointerException("attribute");
            if (viaType == null) throw new NullPointerException("viaType");
            return delegate.minus(attribute, viaType);
        }

        @Override
        public @NotNull <T> IBoolExpr getBoolean(@NotNull ILocalT<T> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getBoolean(localT);
        }

        @Override
        public @NotNull <T> IStringExpr getString(@NotNull ILocalT<T> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getString(localT);
        }

        @Override
        public @NotNull <T> IIntExpr getInt(@NotNull ILocalT<T> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getInt(localT);
        }

        @Override
        public @NotNull <T> ILongExpr getLong(@NotNull ILocalT<T> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getLong(localT);
        }

        @Override
        public @NotNull <T> IStringExpr getEnumName(@NotNull ILocalT<T> localT) {
            if (localT == null) throw new NullPointerException("localT");
            return delegate.getEnumName(localT);
        }

        @Override
        public @NotNull <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> localT, @NotNull String parentType) {
            if (localT == null) throw new NullPointerException("localT");
            if (parentType == null) throw new NullPointerException("parentType");
            return delegate.isInstanceOf(localT, parentType);
        }

        @Override
        public @NotNull IStringExpr toLowerCase(@NotNull IStringExpr stringExpr) {
            if (stringExpr == null) throw new NullPointerException("stringExpr");
            return delegate.toLowerCase(stringExpr);
        }

        @Override
        public @NotNull IBoolExpr startsWith(@NotNull IStringExpr stringExpr, @NotNull IStringExpr prefix) {
            if (stringExpr == null) throw new NullPointerException("stringExpr");
            if (prefix == null) throw new NullPointerException("prefix");
            return delegate.startsWith(stringExpr, prefix);
        }

        @Override
        public @NotNull IBoolExpr startsWith(@NotNull IStringExpr stringExpr, @NotNull String prefix) {
            if (stringExpr == null) throw new NullPointerException("stringExpr");
            if (prefix == null) throw new NullPointerException("prefix");
            return delegate.startsWith(stringExpr, prefix);
        }

        @Override
        public @NotNull IBoolExpr endsWith(@NotNull IStringExpr stringExpr, @NotNull IStringExpr suffix) {
            if (stringExpr == null) throw new NullPointerException("stringExpr");
            if (suffix == null) throw new NullPointerException("suffix");
            return delegate.endsWith(stringExpr, suffix);
        }

        @Override
        public @NotNull IBoolExpr endsWith(@NotNull IStringExpr stringExpr, @NotNull String suffix) {
            if (stringExpr == null) throw new NullPointerException("stringExpr");
            if (suffix == null) throw new NullPointerException("suffix");
            return delegate.endsWith(stringExpr, suffix);
        }

        @Override
        public @NotNull IBoolExpr contains(@NotNull IStringExpr stringExpr, @NotNull IStringExpr substring) {
            if (stringExpr == null) throw new NullPointerException("stringExpr");
            if (substring == null) throw new NullPointerException("substring");
            return delegate.contains(stringExpr, substring);
        }

        @Override
        public @NotNull IBoolExpr contains(@NotNull IStringExpr stringExpr, @NotNull String substring) {
            if (stringExpr == null) throw new NullPointerException("stringExpr");
            if (substring == null) throw new NullPointerException("substring");
            return delegate.contains(stringExpr, substring);
        }

        @Override
        public @NotNull IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, 
                @NotNull ITaintType taintType) {
            if (attribute == null) throw new NullPointerException("attribute");
            if (taintType == null) throw new NullPointerException("taintType");
            return delegate.contains(attribute, taintType);
        }

        @Override
        public @NotNull IBoolExpr stringEquals(@NotNull IStringExpr left, @NotNull IStringExpr right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.stringEquals(left, right);
        }

        @Override
        public @NotNull IBoolExpr stringEquals(@NotNull IStringExpr stringExpr, @NotNull String string) {
            if (stringExpr == null) throw new NullPointerException("stringExpr");
            if (string == null) throw new NullPointerException("string");
            return delegate.stringEquals(stringExpr, string);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull ITaintType... types) {
            if (types == null) throw new NullPointerException("types");
            return delegate.taintOf(types);
        }

        @Override
        public @NotNull IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> types) {
            if (types == null) throw new NullPointerException("types");
            return delegate.taintOf(types);
        }

        @Override
        public @NotNull IAttribute<ViaProperty, Set<IViaType>> viaOf(@NotNull IViaType... viaTypes) {
            if (viaTypes == null) throw new NullPointerException("viaTypes");
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
        public @NotNull <T> ILocalValue<T> anyOf(@NotNull ILocalT<T>... locals) {
            if (locals == null) throw new NullPointerException("locals");
            return delegate.anyOf(locals);
        }

        @Override
        public @NotNull <T> ILocalValue<T> nullValue() {
            return delegate.nullValue();
        }

        @Override
        public @NotNull IBoolExpr hasIntersection(
                @NotNull IAttribute<TaintProperty, Set<ITaintType>> left, 
                @NotNull IAttribute<TaintProperty, Set<ITaintType>> right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.hasIntersection(left, right);
        }

        @Override
        public @NotNull IBoolExpr containsAll(
                @NotNull IAttribute<TaintProperty, Set<ITaintType>> attribute, 
                @NotNull ITaintType taintType) {
            if (attribute == null) throw new NullPointerException("attribute");
            if (taintType == null) throw new NullPointerException("taintType");
            return delegate.containsAll(attribute, taintType);
        }

        @Override
        public @NotNull IBoolExpr containsAll(
                @NotNull IAttribute<TaintProperty, Set<ITaintType>> left, 
                @NotNull IAttribute<TaintProperty, Set<ITaintType>> right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.containsAll(left, right);
        }

        @Override
        public @NotNull <T1, T2, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> left, @NotNull ILocalValue<T2> right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.anyOr(left, right);
        }

        @Override
        public @NotNull <T1, T2, R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> left, @NotNull ILocalT<T2> right) {
            if (left == null) throw new NullPointerException("left");
            if (right == null) throw new NullPointerException("right");
            return delegate.anyOr(left, right);
        }

        @Override
        public @NotNull <T> IAccessPathT<Object> field(@NotNull ILocalT<T> localT, 
                @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            if (localT == null) throw new NullPointerException("localT");
            if (fieldName == null) throw new NullPointerException("fieldName");
            return delegate.field(localT, declaringClass, fieldName, fieldType);
        }

        @Override
        public @NotNull <T> IAccessPathT<Object> field(@NotNull ILocalT<T> localT, @NotNull SootField field) {
            if (localT == null) throw new NullPointerException("localT");
            if (field == null) throw new NullPointerException("field");
            return delegate.field(localT, field);
        }

        @Override
        public void addStmt(@NotNull IStmt stmt) {
            if (stmt == null) throw new NullPointerException("stmt");
            delegate.addStmt(stmt);
        }

        @Override
        public void check(@NotNull IBoolExpr expr, @NotNull CheckType checkType, 
                @NotNull Consumer<BugMessage.Env> env) {
            if (expr == null) throw new NullPointerException("expr");
            if (checkType == null) throw new NullPointerException("checkType");
            if (env == null) throw new NullPointerException("env");
            delegate.check(expr, checkType, env);
        }

        @Override
        public void check(@NotNull ILocalT<Boolean> localT, @NotNull CheckType checkType, 
                @NotNull Consumer<BugMessage.Env> env) {
            if (localT == null) throw new NullPointerException("localT");
            if (checkType == null) throw new NullPointerException("checkType");
            if (env == null) throw new NullPointerException("env");
            delegate.check(localT, checkType, env);
        }

        @Override
        public void eval(@NotNull IExpr expr, @NotNull Consumer<Object> result) {
            if (expr == null) throw new NullPointerException("expr");
            if (result == null) throw new NullPointerException("result");
            delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IBoolExpr expr, @NotNull Consumer<Boolean> result) {
            if (expr == null) throw new NullPointerException("expr");
            if (result == null) throw new NullPointerException("result");
            delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IStringExpr expr, @NotNull Consumer<String> result) {
            if (expr == null) throw new NullPointerException("expr");
            if (result == null) throw new NullPointerException("result");
            delegate.eval(expr, result);
        }

        @Override
        public void eval(@NotNull IIntExpr expr, @NotNull Consumer<Integer> result) {
            if (expr == null) throw new NullPointerException("expr");
            if (result == null) throw new NullPointerException("result");
            delegate.eval(expr, result);
        }
    }
}
