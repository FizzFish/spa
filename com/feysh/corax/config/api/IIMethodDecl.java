/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
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
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\rJ5\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u001f\u0010\u0006\u001a\u001b\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n0\u0007j\u0002`\f\u00a2\u0006\u0002\b\u000bH&\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/config/api/IIMethodDecl;", "R", "This", "Lcom/feysh/corax/config/api/IMethodDecl;", "checkBuilder", "Lcom/feysh/corax/config/api/IIMethodDecl$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "CheckBuilder", "corax-config-api"})
public interface IIMethodDecl<R, This>
extends IMethodDecl<R> {
    @NotNull
    public CheckBuilder<R, This> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> var1);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lcom/feysh/corax/config/api/IIMethodDecl$CheckBuilder;", "R", "This", "Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;", "this", "Lcom/feysh/corax/config/api/IParameterT;", "getThis", "()Lcom/feysh/corax/config/api/IParameterT;", "corax-config-api"})
    public static interface CheckBuilder<R, This>
    extends IMethodDecl.CheckBuilder<R> {
        @NotNull
        public IParameterT<This> getThis();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <R, This> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull CheckBuilder<R, This> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IMethodDecl.CheckBuilder.DefaultImpls.plus((IMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull CheckBuilder<R, This> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IMethodDecl.CheckBuilder.DefaultImpls.plus((IMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull CheckBuilder<R, This> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IMethodDecl.CheckBuilder.DefaultImpls.minus((IMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull CheckBuilder<R, This> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IMethodDecl.CheckBuilder.DefaultImpls.minus((IMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This> IBoolExpr startsWith(@NotNull CheckBuilder<R, This> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IMethodDecl.CheckBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, This> IBoolExpr endsWith(@NotNull CheckBuilder<R, This> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IMethodDecl.CheckBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, This> IBoolExpr contains(@NotNull CheckBuilder<R, This> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IMethodDecl.CheckBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <R, This> IBoolExpr stringEquals(@NotNull CheckBuilder<R, This> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IMethodDecl.CheckBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <R, This> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull CheckBuilder<R, This> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IMethodDecl.CheckBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <R, This> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull CheckBuilder<R, This> $this) {
                return IMethodDecl.CheckBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <R, This> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull CheckBuilder<R, This> $this) {
                return IMethodDecl.CheckBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <R, This> IBoolExpr containsAll(@NotNull CheckBuilder<R, This> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IMethodDecl.CheckBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <R_I1, This, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull CheckBuilder<R_I1, This> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IMethodDecl.CheckBuilder.DefaultImpls.anyOr((IMethodDecl.CheckBuilder)$this, $receiver, second);
            }

            @NotNull
            public static <R, This, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, This> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IMethodDecl.CheckBuilder.DefaultImpls.field($this, $receiver, field);
            }

            @NotNull
            public static <R, This, T, FieldType> IAccessPathT<FieldType> field(@NotNull CheckBuilder<R, This> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IMethodDecl.CheckBuilder.DefaultImpls.field((IMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <R, This, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, This> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IMethodDecl.CheckBuilder.DefaultImpls.field((IMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <R, This> void check(@NotNull CheckBuilder<R, This> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IMethodDecl.CheckBuilder.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Nullable
        public static <R, This> Integer getArgumentCnt(@NotNull IIMethodDecl<R, This> $this) {
            return IMethodDecl.DefaultImpls.getArgumentCnt($this);
        }

        @Nullable
        public static <R, This> KFunctionType getActualType(@NotNull IIMethodDecl<R, This> $this) {
            return IMethodDecl.DefaultImpls.getActualType($this);
        }
    }
}

