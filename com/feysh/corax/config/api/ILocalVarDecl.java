package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

public interface ILocalVarDecl<T> extends IJDecl {
    @NotNull
    ILocalVarDecl<T> atGet(@NotNull Consumer<MethodConfig> config, @NotNull Consumer<IGet<T>> block);

    @NotNull
    ILocalVarDecl<T> atSet(@NotNull Consumer<MethodConfig> config, @NotNull BiConsumer<ISet<T>, IParameterT<T>> block);

    interface IBuilder<T> extends IOperatorFactory {
        @NotNull
        ILocalVarDecl<T> getDecl();

        @NotNull
        ILocalVarMatch getMatch();

        @NotNull
        Consumer<MethodConfig> getConfig();

        default @NotNull IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType single) {
            return IOperatorFactory.super.plus(receiver, single);
        }

        default @NotNull IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, @NotNull IViaType single) {
            return IOperatorFactory.super.plus(receiver, single);
        }

        default @NotNull IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType single) {
            return IOperatorFactory.super.minus(receiver, single);
        }

        default @NotNull IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, @NotNull IViaType single) {
            return IOperatorFactory.super.minus(receiver, single);
        }

        default @NotNull IBoolExpr startsWith(@NotNull IStringExpr receiver, @NotNull String str) {
            return IOperatorFactory.super.startsWith(receiver, str);
        }

        default @NotNull IBoolExpr endsWith(@NotNull IStringExpr receiver, @NotNull String str) {
            return IOperatorFactory.super.endsWith(receiver, str);
        }

        default @NotNull IBoolExpr contains(@NotNull IStringExpr receiver, @NotNull String str) {
            return IOperatorFactory.super.contains(receiver, str);
        }

        default @NotNull IBoolExpr stringEquals(@NotNull IStringExpr receiver, @NotNull String str) {
            return IOperatorFactory.super.stringEquals(receiver, str);
        }

        default @NotNull IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... type) {
            return IOperatorFactory.super.taintOf(type);
        }

        default @NotNull IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return IOperatorFactory.super.getEmptyTaint();
        }

        default @NotNull IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return IOperatorFactory.super.getEmptyVia();
        }

        default @NotNull IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType taint) {
            return IOperatorFactory.super.containsAll(receiver, taint);
        }

        default <T1 extends R, T2 extends R, R> @NotNull ILocalValue<R> anyOr(@NotNull ILocalT<T1> receiver, @NotNull ILocalT<T2> second) {
            return IOperatorFactory.super.anyOr(receiver, second);
        }

        default <T1> @NotNull IAccessPathT<Object> field(@NotNull ILocalT<T1> receiver, @NotNull SootField field) {
            return IOperatorFactory.super.field(receiver, field);
        }

        default <T1, FieldType> @NotNull IAccessPathT<FieldType> field(@NotNull ILocalT<T1> receiver, @Nullable Class<?> declaringClass, @NotNull String fieldName, @NotNull Class<FieldType> type) {
            return IOperatorFactory.super.field(receiver, declaringClass, fieldName, type);
        }

        default <T1> @NotNull IAccessPathT<Object> field(@NotNull ILocalT<T1> receiver, @NotNull Class<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
            return IOperatorFactory.super.field(receiver, declaringClass, fieldName, fieldType);
        }

        default void check(@NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Consumer<BugMessage.Env> env) {
            IOperatorFactory.super.check(expr, checkType, env);
        }
    }

    interface IGet<T> extends IBuilder<T> {
        @NotNull
        IReturnT<T> getReturn();
    }

    interface ISet<T> extends IBuilder<T> {
        @NotNull
        IParameterT<T> getValue();
    }
}