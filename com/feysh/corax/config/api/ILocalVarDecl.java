/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootField
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IJDecl;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.ILocalVarMatch;
import com.feysh.corax.config.api.IOperatorFactory;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0014\u0015\u0016JN\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001f\u0010\u0004\u001a\u001b\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\n\u00a2\u0006\u0002\b\t2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\b\tH&Ji\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001f\u0010\u0004\u001a\u001b\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\n\u00a2\u0006\u0002\b\t28\u0010\u000b\u001a4\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000e\u00a2\u0006\u0002\b\tH&\u00a8\u0006\u0017"}, d2={"Lcom/feysh/corax/config/api/ILocalVarDecl;", "T", "Lcom/feysh/corax/config/api/IJDecl;", "atGet", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "block", "Lcom/feysh/corax/config/api/ILocalVarDecl$IGet;", "atSet", "Lkotlin/Function2;", "Lcom/feysh/corax/config/api/ILocalVarDecl$ISet;", "Lcom/feysh/corax/config/api/IParameterT;", "Lkotlin/ParameterName;", "name", "value", "IBuilder", "IGet", "ISet", "corax-config-api"})
public interface ILocalVarDecl<T>
extends IJDecl {
    @NotNull
    public ILocalVarDecl<T> atGet(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function1<? super IGet<T>, Unit> var2);

    @NotNull
    public ILocalVarDecl<T> atSet(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function2<? super ISet<T>, ? super IParameterT<T>, Unit> var2);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR+\u0010\u000b\u001a\u001b\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\fj\u0002`\u0011\u00a2\u0006\u0002\b\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;", "T", "Lcom/feysh/corax/config/api/IOperatorFactory;", "decl", "Lcom/feysh/corax/config/api/ILocalVarDecl;", "getDecl", "()Lcom/feysh/corax/config/api/ILocalVarDecl;", "match", "Lcom/feysh/corax/config/api/ILocalVarMatch;", "getMatch", "()Lcom/feysh/corax/config/api/ILocalVarMatch;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "getConfig", "()Lkotlin/jvm/functions/Function1;", "corax-config-api"})
    public static interface IBuilder<T>
    extends IOperatorFactory {
        @NotNull
        public ILocalVarDecl<T> getDecl();

        @NotNull
        public ILocalVarMatch getMatch();

        @NotNull
        public Function1<MethodConfig, Unit> getConfig();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IBuilder<T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.plus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <T> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IBuilder<T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.plus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IBuilder<T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.minus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <T> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IBuilder<T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.minus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <T> IBoolExpr startsWith(@NotNull IBuilder<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <T> IBoolExpr endsWith(@NotNull IBuilder<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <T> IBoolExpr contains(@NotNull IBuilder<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <T> IBoolExpr stringEquals(@NotNull IBuilder<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull IBuilder<T> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IOperatorFactory.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull IBuilder<T> $this) {
                return IOperatorFactory.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <T> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull IBuilder<T> $this) {
                return IOperatorFactory.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <T> IBoolExpr containsAll(@NotNull IBuilder<T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IOperatorFactory.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <T, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull IBuilder<T> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IOperatorFactory.DefaultImpls.anyOr($this, $receiver, second);
            }

            @NotNull
            public static <T_I1, T> IAccessPathT<Object> field(@NotNull IBuilder<T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IOperatorFactory.DefaultImpls.field($this, $receiver, field);
            }

            @NotNull
            public static <T_I1, T, FieldType> IAccessPathT<FieldType> field(@NotNull IBuilder<T_I1> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IOperatorFactory.DefaultImpls.field((IOperatorFactory)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <T_I1, T> IAccessPathT<Object> field(@NotNull IBuilder<T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IOperatorFactory.DefaultImpls.field((IOperatorFactory)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <T> void check(@NotNull IBuilder<T> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IOperatorFactory.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/ILocalVarDecl$IGet;", "T", "Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;", "return", "Lcom/feysh/corax/config/api/IReturnT;", "getReturn", "()Lcom/feysh/corax/config/api/IReturnT;", "corax-config-api"})
    public static interface IGet<T>
    extends IBuilder<T> {
        @NotNull
        public IReturnT<T> getReturn();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IGet<T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.plus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <T> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IGet<T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.plus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IGet<T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.minus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <T> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IGet<T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.minus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <T> IBoolExpr startsWith(@NotNull IGet<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <T> IBoolExpr endsWith(@NotNull IGet<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <T> IBoolExpr contains(@NotNull IGet<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <T> IBoolExpr stringEquals(@NotNull IGet<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull IGet<T> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull IGet<T> $this) {
                return IBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <T> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull IGet<T> $this) {
                return IBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <T> IBoolExpr containsAll(@NotNull IGet<T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <T, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull IGet<T> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IBuilder.DefaultImpls.anyOr($this, $receiver, second);
            }

            @NotNull
            public static <T_I1, T> IAccessPathT<Object> field(@NotNull IGet<T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, field);
            }

            @NotNull
            public static <T_I1, T, FieldType> IAccessPathT<FieldType> field(@NotNull IGet<T_I1> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <T_I1, T> IAccessPathT<Object> field(@NotNull IGet<T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <T> void check(@NotNull IGet<T> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IBuilder.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/ILocalVarDecl$ISet;", "T", "Lcom/feysh/corax/config/api/ILocalVarDecl$IBuilder;", "value", "Lcom/feysh/corax/config/api/IParameterT;", "getValue", "()Lcom/feysh/corax/config/api/IParameterT;", "corax-config-api"})
    public static interface ISet<T>
    extends IBuilder<T> {
        @NotNull
        public IParameterT<T> getValue();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull ISet<T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.plus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <T> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull ISet<T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.plus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull ISet<T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.minus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <T> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull ISet<T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.minus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <T> IBoolExpr startsWith(@NotNull ISet<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <T> IBoolExpr endsWith(@NotNull ISet<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <T> IBoolExpr contains(@NotNull ISet<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <T> IBoolExpr stringEquals(@NotNull ISet<T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull ISet<T> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <T> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull ISet<T> $this) {
                return IBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <T> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull ISet<T> $this) {
                return IBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <T> IBoolExpr containsAll(@NotNull ISet<T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <T, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ISet<T> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IBuilder.DefaultImpls.anyOr($this, $receiver, second);
            }

            @NotNull
            public static <T_I1, T> IAccessPathT<Object> field(@NotNull ISet<T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, field);
            }

            @NotNull
            public static <T_I1, T, FieldType> IAccessPathT<FieldType> field(@NotNull ISet<T_I1> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <T_I1, T> IAccessPathT<Object> field(@NotNull ISet<T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <T> void check(@NotNull ISet<T> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IBuilder.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }
}

