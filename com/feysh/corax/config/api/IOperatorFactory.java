package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.CustomAttributeID;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIntExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ILongExpr;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.ITypedExpr;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.IWithSubFieldsT;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import soot.Type;

public interface IOperatorFactory {
    @NotNull
    IWithSubFieldsT getSubFields(@NotNull ILocalT<?> var1);

    @NotNull
    <T> IAttributeGetSet getAttr(@NotNull ILocalT<T> var1);

    @NotNull
    <T> IAttribute<TaintProperty, Set<ITaintType>> getTaint(@NotNull ILocalT<T> var1);

    <T> void setTaint(@NotNull ILocalT<T> var1, @NotNull IAttribute<TaintProperty, Set<ITaintType>> var2);

    @NotNull
    <T> IAttribute<ViaProperty, Set<IViaType>> getVia(@NotNull ILocalT<T> var1);

    <T> void setVia(@NotNull ILocalT<T> var1, @NotNull IAttribute<ViaProperty, Set<IViaType>> var2);

    @NotNull
    <T> ILocalValue<T> getValue(@NotNull ILocalT<T> var1);

    <T> void setValue(@NotNull ILocalT<T> var1, @NotNull ILocalValue<T> var2);

    @NotNull
    IStringExpr literal(@NotNull String var1);

    @NotNull
    IIntExpr literal(int var1);

    @NotNull
    ILongExpr literal(long var1);

    @NotNull
    IBoolExpr literal(boolean var1);

    @NotNull
    <T> IBoolExpr isConstant(@NotNull ILocalT<T> var1);

    @NotNull
    IBoolExpr isConstant(@NotNull ITypedExpr var1);

    @NotNull
    IBoolExpr not(@NotNull IBoolExpr var1);

    @NotNull
    IBoolExpr or(@NotNull IBoolExpr var1, @NotNull IBoolExpr var2);

    @NotNull
    IBoolExpr and(@NotNull IBoolExpr var1, @NotNull IBoolExpr var2);

    @NotNull
    IBoolExpr lt(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IBoolExpr le(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IBoolExpr eq(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IBoolExpr ge(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IBoolExpr gt(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IBoolExpr neq(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IIntExpr and(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IIntExpr or(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IIntExpr xor(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IIntExpr shl(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IIntExpr shr(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IIntExpr lshr(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IIntExpr plus(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    IIntExpr minus(@NotNull IIntExpr var1, @NotNull IIntExpr var2);

    @NotNull
    <T> IBoolExpr getBoolean(@NotNull ILocalT<T> var1);

    @NotNull
    <T> IStringExpr getString(@NotNull ILocalT<T> var1);

    @NotNull
    <T> IIntExpr getInt(@NotNull ILocalT<T> var1);

    @NotNull
    <T> ILongExpr getLong(@NotNull ILocalT<T> var1);

    @NotNull
    <T> IStringExpr getEnumName(@NotNull ILocalT<T> var1);

    @NotNull
    <T> IBoolExpr isInstanceOf(@NotNull ILocalT<T> var1, @NotNull String var2);

    @NotNull
    IStringExpr toLowerCase(@NotNull IStringExpr var1);

    @NotNull
    IBoolExpr startsWith(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @NotNull
    IBoolExpr startsWith(@NotNull IStringExpr var1, @NotNull String var2);

    @NotNull
    IBoolExpr endsWith(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @NotNull
    IBoolExpr endsWith(@NotNull IStringExpr var1, @NotNull String var2);

    @NotNull
    IBoolExpr contains(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @NotNull
    IBoolExpr contains(@NotNull IStringExpr var1, @NotNull String var2);

    @NotNull
    IBoolExpr stringEquals(@NotNull IStringExpr var1, @NotNull IStringExpr var2);

    @NotNull
    IBoolExpr stringEquals(@NotNull IStringExpr var1, @NotNull String var2);

    @NotNull
    IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... var1);

    @NotNull
    IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull Collection<? extends ITaintType> var1);

    @NotNull
    IAttribute<ViaProperty, Set<IViaType>> viaOf(IViaType... var1);

    @NotNull
    IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint();

    @NotNull
    IAttribute<ViaProperty, Set<IViaType>> getEmptyVia();

    @NotNull
    <T> ILocalValue<T> anyOf(ILocalT<T>... var1);

    @NotNull
    <T> ILocalValue<T> nullValue();

    @NotNull
    IBoolExpr hasIntersection(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull IAttribute<TaintProperty, Set<ITaintType>> var2);

    @NotNull
    IBoolExpr contains(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull ITaintType var2);

    @NotNull
    IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull ITaintType var2);

    @NotNull
    IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull IAttribute<TaintProperty, Set<ITaintType>> var2);

    @NotNull
    <T extends IClassField, V extends Set<?>> IAttribute<T, V> plus(@NotNull IAttribute<T, V> var1, @NotNull IAttribute<T, V> var2);

    @NotNull
    <T extends IClassField, V extends Set<?>> IAttribute<T, V> minus(@NotNull IAttribute<T, V> var1, @NotNull IAttribute<T, V> var2);

    @NotNull
    IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull ITaintType var2);

    @NotNull
    IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> var1, @NotNull ITaintType var2);

    @NotNull
    IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> var1, @NotNull IViaType var2);

    @NotNull
    IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> var1, @NotNull IViaType var2);

    @NotNull
    <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalValue<T1> var1, @NotNull ILocalValue<T2> var2);

    @NotNull
    <T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> var1, @NotNull ILocalT<T2> var2);

    @NotNull
    <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @Nullable String var2, @NotNull String var3, @Nullable String var4);

    @NotNull
    <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @NotNull SootField var2);

    @NotNull
    <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> var1, @Nullable String var2, @NotNull String var3, @NotNull Class<FieldType> var4);

    @NotNull
    <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> var1, @Nullable Class<?> var2, @NotNull String var3, @NotNull Class<FieldType> var4);

    @NotNull
    <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @NotNull Class<?> var2, @NotNull String var3, @Nullable String var4);

    @NotNull
    <T> IAccessPathT<Object> field(@NotNull ILocalT<T> var1, @NotNull IClassField var2);

    @NotNull
    <T, F> IAccessPathT<F> field(@NotNull ILocalT<T> var1, @NotNull java.lang.reflect.Field var2);

    @NotNull
    <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> var1, @NotNull java.lang.reflect.Field var2, @NotNull Class<FieldType> var3);

    void addStmt(@NotNull IStmt var1);

    void check(@NotNull IBoolExpr var1, @NotNull CheckType var2, @NotNull java.util.function.Consumer<BugMessage.Env> var3);

    void check(@NotNull ILocalT<Boolean> var1, @NotNull CheckType var2, @NotNull java.util.function.Consumer<BugMessage.Env> var3);

    void eval(@NotNull IExpr var1, @NotNull java.util.function.Consumer<Object> var2);

    void eval(@NotNull IBoolExpr var1, @NotNull java.util.function.Consumer<Boolean> var2);

    void eval(@NotNull IStringExpr var1, @NotNull java.util.function.Consumer<String> var2);

    void eval(@NotNull IIntExpr var1, @NotNull java.util.function.Consumer<Integer> var2);

    interface IAttributeGetSet {
        @NotNull
        <T> IAccessPathT<T> get(@NotNull CustomAttributeID<T> var1);

        <T> void set(@NotNull CustomAttributeID<T> var1, @NotNull ILocalValue<T> var2);

        void set(@NotNull CustomAttributeID<Boolean> var1, boolean var2);

        void set(@NotNull CustomAttributeID<Short> var1, short var2);

        void set(@NotNull CustomAttributeID<Integer> var1, int var2);

        void set(@NotNull CustomAttributeID<Long> var1, long var2);

        void set(@NotNull CustomAttributeID<String> var1, @NotNull String var2);

        <T> void set(@NotNull CustomAttributeID<T> var1, @NotNull ITypedExpr var2);
    }
}
