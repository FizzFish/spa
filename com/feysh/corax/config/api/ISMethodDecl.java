package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Set;
import java.util.function.Consumer;

public interface ISMethodDecl<R> extends IMethodDecl<R> {
    @NotNull
    CheckBuilder<R> checkBuilder(@NotNull Consumer<MethodConfig> config);

    interface CheckBuilder<R> extends IMethodDecl.CheckBuilder<R> {
        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType single) {
            return IMethodDecl.CheckBuilder.super.plus(receiver, single);
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, @NotNull IViaType single) {
            return IMethodDecl.CheckBuilder.super.plus(receiver, single);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType single) {
            return IMethodDecl.CheckBuilder.super.minus(receiver, single);
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, @NotNull IViaType single) {
            return IMethodDecl.CheckBuilder.super.minus(receiver, single);
        }

        @NotNull
        default IBoolExpr startsWith(@NotNull IStringExpr receiver, @NotNull String str) {
            return IMethodDecl.CheckBuilder.super.startsWith(receiver, str);
        }

        @NotNull
        default IBoolExpr endsWith(@NotNull IStringExpr receiver, @NotNull String str) {
            return IMethodDecl.CheckBuilder.super.endsWith(receiver, str);
        }

        @NotNull
        default IBoolExpr contains(@NotNull IStringExpr receiver, @NotNull String str) {
            return IMethodDecl.CheckBuilder.super.contains(receiver, str);
        }

        @NotNull
        default IBoolExpr stringEquals(@NotNull IStringExpr receiver, @NotNull String str) {
            return IMethodDecl.CheckBuilder.super.stringEquals(receiver, str);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... type) {
            return IMethodDecl.CheckBuilder.super.taintOf(type);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return IMethodDecl.CheckBuilder.super.getEmptyTaint();
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return IMethodDecl.CheckBuilder.super.getEmptyVia();
        }

        @NotNull
        default IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType taint) {
            return IMethodDecl.CheckBuilder.super.containsAll(receiver, taint);
        }

        @NotNull
        default <T1 extends R, T2 extends R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> receiver, @NotNull ILocalT<T2> second) {
            return IMethodDecl.CheckBuilder.super.anyOr(receiver, second);
        }

        @NotNull
        default <T> IAccessPathT<Object> field(@NotNull ILocalT<T> receiver, @NotNull SootField field) {
            return IMethodDecl.CheckBuilder.super.field(receiver, field);
        }

        @NotNull
        default <T, FieldType> IAccessPathT<FieldType> field(
                @NotNull ILocalT<T> receiver,
                @Nullable Class<?> declaringClass,
                @NotNull String fieldName,
                @NotNull Class<FieldType> type) {
            return IMethodDecl.CheckBuilder.super.field(receiver, declaringClass, fieldName, type);
        }

        @NotNull
        default <T> IAccessPathT<Object> field(
                @NotNull ILocalT<T> receiver,
                @NotNull Class<?> declaringClass,
                @NotNull String fieldName,
                @Nullable String fieldType) {
            return IMethodDecl.CheckBuilder.super.field(receiver, declaringClass, fieldName, fieldType);
        }

        default void check(
                @NotNull ILocalT<Boolean> expr,
                @NotNull CheckType checkType,
                @NotNull Consumer<BugMessage.Env> env) {
            IMethodDecl.CheckBuilder.super.check(expr, checkType, env);
        }
    }

    @Nullable
    default Integer getArgumentCnt() {
        return IMethodDecl.super.getArgumentCnt();
    }

    @Nullable
    default KFunctionType getActualType() {
        return IMethodDecl.super.getActualType();
    }
}