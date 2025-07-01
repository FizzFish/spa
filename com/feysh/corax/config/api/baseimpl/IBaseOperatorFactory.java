package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.baseimpl.*;
import com.feysh.corax.config.api.utils.UtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KCallable;
import java.util.Collection;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;

public interface IBaseOperatorFactory extends IOperatorFactory {
    @Override
    @NotNull
    <T> IOperatorFactory.IAttributeGetSet getAttr(@NotNull ILocalT<T> local);

    @Override
    @NotNull
    <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> local);

    @Override
    <T> void setTaint(@NotNull ILocalT<T> local, @NotNull IAttribute<TaintProperty, Set<ITaintType>> value);

    @Override
    @NotNull
    <T> ILocalValue<T> getValue(@NotNull ILocalT<T> local);

    @Override
    <T> void setValue(@NotNull ILocalT<T> local, @NotNull ILocalValue<T> value);

    @Override
    @NotNull
    <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> local);

    @Override
    <T> void setVia(@NotNull ILocalT<T> local, @NotNull IAttribute<ViaProperty, Set<IViaType>> value);

    @Override
    @NotNull
    IWithSubFieldsT getSubFields(@NotNull ILocalT<?> local);

    @Override
    @NotNull
    IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType... via);

    @Override
    @NotNull
    <T> ILocalValue<T> nullValue();

    @Override
    @NotNull
    <T> ILocalValue<T> anyOf(ILocalT<T>... local);

    @Override
    @NotNull
    IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> types);

    @NotNull
    IExpr constant(@NotNull Object value, @NotNull IIexConst.Type type);

    @Override
    @NotNull
    IBoolExpr literal(boolean bool);

    @Override
    @NotNull
    IStringExpr literal(@NotNull String string);

    @Override
    @NotNull
    IIntExpr literal(int value);

    @Override
    @NotNull
    ILongExpr literal(long value);

    @Override
    @NotNull
    <T> IBoolExpr isConstant(@NotNull ILocalT<T> local);

    @Override
    @NotNull
    IBoolExpr isConstant(@NotNull ITypedExpr expr);

    @NotNull
    <T extends IClassField, V extends Set<?>> Attribute<T, V> plus(@NotNull IAttribute<T, V> first, @NotNull IAttribute<T, V> second);

    @NotNull
    <T extends IClassField, V extends Set<?>> Attribute<T, V> minus(@NotNull IAttribute<T, V> first, @NotNull IAttribute<T, V> second);

    @Override
    @NotNull
    <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> first, @NotNull ILocalValue<T2> second);

    @Override
    @NotNull
    IBoolExpr not(@NotNull IBoolExpr expr);

    @Override
    @NotNull
    IBoolExpr or(@NotNull IBoolExpr first, @NotNull IBoolExpr second);

    @Override
    @NotNull
    IBoolExpr and(@NotNull IBoolExpr first, @NotNull IBoolExpr second);

    @NotNull
    IBoolExpr compareBinOp(@NotNull IIntExpr left, @NotNull BinOp op, @NotNull IIntExpr right);

    @NotNull
    IIntExpr arithmeticBinOp(@NotNull IIntExpr left, @NotNull BinOp op, @NotNull IIntExpr right);

    @NotNull
    IIntExpr bitwiseBinOp(@NotNull IIntExpr left, @NotNull BinOp op, @NotNull IIntExpr right);

    @Override
    @NotNull
    IBoolExpr lt(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IBoolExpr le(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IBoolExpr eq(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IBoolExpr ge(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IBoolExpr gt(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IBoolExpr neq(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IIntExpr and(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IIntExpr or(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IIntExpr xor(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IIntExpr shl(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IIntExpr shr(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IIntExpr lshr(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IIntExpr plus(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    IIntExpr minus(@NotNull IIntExpr left, @NotNull IIntExpr right);

    @Override
    @NotNull
    <T> IBoolExpr getBoolean(@NotNull ILocalT<T> local);

    @Override
    @NotNull
    <T> IStringExpr getString(@NotNull ILocalT<T> local);

    @Override
    @NotNull
    <T> IIntExpr getInt(@NotNull ILocalT<T> local);

    @Override
    @NotNull
    <T> ILongExpr getLong(@NotNull ILocalT<T> local);

    @Override
    @NotNull
    <T> IStringExpr getEnumName(@NotNull ILocalT<T> local);

    @Override
    @NotNull
    <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> local, @NotNull String parentType);

    @Override
    @NotNull
    IStringExpr toLowerCase(@NotNull IStringExpr expr);

    @Override
    @NotNull
    IBoolExpr startsWith(@NotNull IStringExpr expr, @NotNull IStringExpr str);

    @Override
    @NotNull
    IBoolExpr endsWith(@NotNull IStringExpr expr, @NotNull IStringExpr str);

    @Override
    @NotNull
    IBoolExpr contains(@NotNull IStringExpr expr, @NotNull IStringExpr str);

    @Override
    @NotNull
    IBoolExpr stringEquals(@NotNull IStringExpr expr, @NotNull IStringExpr str);

    @Override
    @NotNull
    IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> first, @NotNull IAttribute<TaintProperty, Set<ITaintType>> second);

    @Override
    @NotNull
    IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> first, @NotNull IAttribute<TaintProperty, Set<ITaintType>> second);

    @Override
    @NotNull
    IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> set, @NotNull ITaintType taint);

    @Override
    @NotNull
    <T> IAccessPathT<Object> field(@NotNull ILocalT<T> local, @Nullable String declaringClass, @NotNull String fieldName, @Nullable String fieldType);

    @Override
    @NotNull
    <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> local, @Nullable String declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type);

    @Override
    @NotNull
    <T, F> IAccessPathT<F> field(@NotNull ILocalT<T> local, @NotNull KProperty<? extends F> field);

    @Override
    @NotNull
    <T> IAccessPathT<Object> field(@NotNull ILocalT<T> local, @NotNull IClassField field);

    @Override
    @NotNull
    <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> local, @NotNull KProperty<?> field, @NotNull KClass<FieldType> type);

    @Override
    void eval(@NotNull IBoolExpr expr, @NotNull kotlin.jvm.functions.Function1<? super Boolean, kotlin.Unit> result);

    @Override
    void eval(@NotNull IIntExpr expr, @NotNull kotlin.jvm.functions.Function1<? super Integer, kotlin.Unit> result);

    @Override
    void eval(@NotNull IStringExpr expr, @NotNull kotlin.jvm.functions.Function1<? super String, kotlin.Unit> result);
}
