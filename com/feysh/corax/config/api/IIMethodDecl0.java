package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IIMethodDecl;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public interface IIMethodDecl0<R, This> extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> config);

    @NotNull
    default IIMethodDecl0<R, This> model(@NotNull Function1<? super MethodConfig, Unit> config, 
            @NotNull Function1<? super CheckBuilder<R, This>, Unit> block) {
        CheckBuilder<R, This> builder = checkBuilder(config);
        block.invoke(builder);
        return this;
    }

    @NotNull
    default IIMethodDecl0<R, This> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> config, 
            @NotNull Function1<? super CheckBuilder<R, This>, Unit> block) {
        CheckBuilder<R, This> builder = checkBuilder(config);
        block.invoke(builder);
        return this;
    }

    interface CheckBuilder<R, This> extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        IIMethodDecl0<R, This> getMethod();

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, 
                @NotNull ITaintType single) {
            return IIMethodDecl.CheckBuilder.super.plus(receiver, single);
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, 
                @NotNull IViaType single) {
            return IIMethodDecl.CheckBuilder.super.plus(receiver, single);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, 
                @NotNull ITaintType single) {
            return IIMethodDecl.CheckBuilder.super.minus(receiver, single);
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, 
                @NotNull IViaType single) {
            return IIMethodDecl.CheckBuilder.super.minus(receiver, single);
        }

        @NotNull
        default IBoolExpr startsWith(@NotNull IStringExpr receiver, @NotNull String str) {
            return IIMethodDecl.CheckBuilder.super.startsWith(receiver, str);
        }

        @NotNull
        default IBoolExpr endsWith(@NotNull IStringExpr receiver, @NotNull String str) {
            return IIMethodDecl.CheckBuilder.super.endsWith(receiver, str);
        }

        @NotNull
        default IBoolExpr contains(@NotNull IStringExpr receiver, @NotNull String str) {
            return IIMethodDecl.CheckBuilder.super.contains(receiver, str);
        }

        @NotNull
        default IBoolExpr stringEquals(@NotNull IStringExpr receiver, @NotNull String str) {
            return IIMethodDecl.CheckBuilder.super.stringEquals(receiver, str);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... type) {
            return IIMethodDecl.CheckBuilder.super.taintOf(type);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return IIMethodDecl.CheckBuilder.super.getEmptyTaint();
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return IIMethodDecl.CheckBuilder.super.getEmptyVia();
        }

        @NotNull
        default IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, 
                @NotNull ITaintType taint) {
            return IIMethodDecl.CheckBuilder.super.containsAll(receiver, taint);
        }

        @NotNull
        default <T1 extends R, T2 extends R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> receiver, 
                @NotNull ILocalT<T2> second) {
            return IIMethodDecl.CheckBuilder.super.anyOr(receiver, second);
        }

        @NotNull
        default <T> IAccessPathT<Object> field(@NotNull ILocalT<T> receiver, @NotNull SootField field) {
            return IIMethodDecl.CheckBuilder.super.field(receiver, field);
        }

        @NotNull
        default <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> receiver, 
                @Nullable Class<?> declaringClass, @NotNull String fieldName, @NotNull Class<FieldType> type) {
            return IIMethodDecl.CheckBuilder.super.field(receiver, declaringClass, fieldName, type);
        }

        @NotNull
        default <T> IAccessPathT<Object> field(@NotNull ILocalT<T> receiver, @NotNull Class<?> declaringClass, 
                @NotNull String fieldName, @Nullable String fieldType) {
            return IIMethodDecl.CheckBuilder.super.field(receiver, declaringClass, fieldName, fieldType);
        }

        default void check(@NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, 
                @NotNull Function1<? super BugMessage.Env, Unit> env) {
            IIMethodDecl.CheckBuilder.super.check(expr, checkType, env);
        }
    }
}