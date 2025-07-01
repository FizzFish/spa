package com.feysh.corax.config.api;

import com.feysh.corax.config.api.*;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import kotlin.reflect.KClass;

public interface IIMethodDecl1<R, This, P0> extends IIMethodDecl<R, This> {

    @NotNull
    CheckBuilder<R, This, P0> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default IIMethodDecl1<R, This, P0> model(@NotNull Consumer<MethodConfig> config, 
                                           @NotNull BiConsumer<CheckBuilder<R, This, P0>, IParameterT<P0>> block) {
        CheckBuilder<R, This, P0> builder = checkBuilder(config);
        block.accept(builder, builder.getP0());
        return this;
    }

    @NotNull
    default IIMethodDecl1<R, This, P0> modelNoArg(@NotNull Consumer<MethodConfig> config, 
                                                @NotNull Consumer<CheckBuilder<R, This, P0>> block) {
        CheckBuilder<R, This, P0> builder = checkBuilder(config);
        block.accept(builder);
        return this;
    }

    interface CheckBuilder<R, This, P0> extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        IIMethodDecl1<R, This, P0> getMethod();

        @NotNull
        default IParameterT<P0> getP0() {
            return paramAt(0);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType single) {
            return IIMethodDecl.CheckBuilder.super.plus(receiver, single);
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, @NotNull IViaType single) {
            return IIMethodDecl.CheckBuilder.super.plus(receiver, single);
        }

        @NotNull
        default IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType single) {
            return IIMethodDecl.CheckBuilder.super.minus(receiver, single);
        }

        @NotNull
        default IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IAttribute<ViaProperty, Set<IViaType>> receiver, @NotNull IViaType single) {
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
        default IBoolExpr containsAll(@NotNull IAttribute<TaintProperty, Set<ITaintType>> receiver, @NotNull ITaintType taint) {
            return IIMethodDecl.CheckBuilder.super.containsAll(receiver, taint);
        }

        @NotNull
        default <T1 extends R, T2 extends R> ILocalValue<R> anyOr(@NotNull ILocalT<T1> receiver, @NotNull ILocalT<T2> second) {
            return IIMethodDecl.CheckBuilder.super.anyOr(receiver, second);
        }

        @NotNull
        default <T> IAccessPathT<Object> field(@NotNull ILocalT<T> receiver, @NotNull SootField field) {
            return IIMethodDecl.CheckBuilder.super.field(receiver, field);
        }

        @NotNull
        default <T, FieldType> IAccessPathT<FieldType> field(@NotNull ILocalT<T> receiver, 
                                                          @Nullable KClass<?> declaringClass, 
                                                          @NotNull String fieldName, 
                                                          @NotNull KClass<FieldType> type) {
            return IIMethodDecl.CheckBuilder.super.field(receiver, declaringClass, fieldName, type);
        }

        @NotNull
        default <T> IAccessPathT<Object> field(@NotNull ILocalT<T> receiver, 
                                            @NotNull KClass<?> declaringClass, 
                                            @NotNull String fieldName, 
                                            @Nullable String fieldType) {
            return IIMethodDecl.CheckBuilder.super.field(receiver, declaringClass, fieldName, fieldType);
        }

        default void check(@NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Consumer<BugMessage.Env> env) {
            IIMethodDecl.CheckBuilder.super.check(expr, checkType, env);
        }
    }

    @Nullable
    @Override
    default Integer getArgumentCnt() {
        return IIMethodDecl.super.getArgumentCnt();
    }

    @Nullable
    @Override
    default KFunctionType getActualType() {
        return IIMethodDecl.super.getActualType();
    }
}