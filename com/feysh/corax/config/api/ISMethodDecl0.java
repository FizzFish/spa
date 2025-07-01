package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ISMethodDecl;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Set;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

public interface ISMethodDecl0<R> extends ISMethodDecl<R> {

    @NotNull
    CheckBuilder<R> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default ISMethodDecl0<R> model(@NotNull Consumer<MethodConfig> config, @NotNull Consumer<CheckBuilder<R>> block) {
        CheckBuilder<R> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    @NotNull
    default ISMethodDecl0<R> modelNoArg(@NotNull Consumer<MethodConfig> config, @NotNull Consumer<CheckBuilder<R>> block) {
        CheckBuilder<R> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R> extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        ISMethodDecl0<R> getMethod();

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType single) {
            return ISMethodDecl.CheckBuilder.super.plus(receiver, single);
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, @NotNull IViaType single) {
            return ISMethodDecl.CheckBuilder.super.plus(receiver, single);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType single) {
            return ISMethodDecl.CheckBuilder.super.minus(receiver, single);
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, @NotNull IViaType single) {
            return ISMethodDecl.CheckBuilder.super.minus(receiver, single);
        }

        @NotNull
        default IBoolExpr startsWith(@NotNull IStringExpr receiver, @NotNull String str) {
            return ISMethodDecl.CheckBuilder.super.startsWith(receiver, str);
        }

        @NotNull
        default IBoolExpr endsWith(@NotNull IStringExpr receiver, @NotNull String str) {
            return ISMethodDecl.CheckBuilder.super.endsWith(receiver, str);
        }

        @NotNull
        default IBoolExpr contains(@NotNull IStringExpr receiver, @NotNull String str) {
            return ISMethodDecl.CheckBuilder.super.contains(receiver, str);
        }

        @NotNull
        default IBoolExpr stringEquals(@NotNull IStringExpr receiver, @NotNull String str) {
            return ISMethodDecl.CheckBuilder.super.stringEquals(receiver, str);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> taintOf(ITaintType... type) {
            return ISMethodDecl.CheckBuilder.super.taintOf(type);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint() {
            return ISMethodDecl.CheckBuilder.super.getEmptyTaint();
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> getEmptyVia() {
            return ISMethodDecl.CheckBuilder.super.getEmptyVia();
        }

        @NotNull
        default IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType taint) {
            return ISMethodDecl.CheckBuilder.super.containsAll(receiver, taint);
        }

        @NotNull
        default <T1 extends R, T2 extends R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> receiver, @NotNull ILocalT<T2> second) {
            return ISMethodDecl.CheckBuilder.super.anyOr(receiver, second);
        }

        @NotNull
        default <T> IAccessPathT<Object> field(@NotNull ILocalT<T> receiver, @NotNull SootField field) {
            return ISMethodDecl.CheckBuilder.super.field(receiver, field);
        }

        @NotNull
        default <T, FieldType> IAccessPathT<FieldType> field(
            @NotNull ILocalT<T> receiver, 
            @Nullable Class<?> declaringClass, 
            @NotNull String fieldName, 
            @NotNull Class<FieldType> type
        ) {
            return ISMethodDecl.CheckBuilder.super.field(receiver, declaringClass, fieldName, type);
        }

        @NotNull
        default <T> IAccessPathT<Object> field(
            @NotNull ILocalT<T> receiver, 
            @NotNull Class<?> declaringClass, 
            @NotNull String fieldName, 
            @Nullable String fieldType
        ) {
            return ISMethodDecl.CheckBuilder.super.field(receiver, declaringClass, fieldName, fieldType);
        }

        default void check(
            @NotNull ILocalT<Boolean> expr, 
            @NotNull CheckType checkType, 
            @NotNull Consumer<BugMessage.Env> env
        ) {
            ISMethodDecl.CheckBuilder.super.check(expr, checkType, env);
        }
    }
}