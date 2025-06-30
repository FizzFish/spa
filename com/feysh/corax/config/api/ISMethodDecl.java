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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\fJ/\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u001f\u0010\u0005\u001a\u001b\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\u000b\u00a2\u0006\u0002\b\nH&\u00a8\u0006\r"}, d2={"Lcom/feysh/corax/config/api/ISMethodDecl;", "R", "Lcom/feysh/corax/config/api/IMethodDecl;", "checkBuilder", "Lcom/feysh/corax/config/api/ISMethodDecl$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "CheckBuilder", "corax-config-api"})
public interface ISMethodDecl<R>
extends IMethodDecl<R> {
    @Override
    @NotNull
    public CheckBuilder<R> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> var1);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002\u00a8\u0006\u0003"}, d2={"Lcom/feysh/corax/config/api/ISMethodDecl$CheckBuilder;", "R", "Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;", "corax-config-api"})
    public static interface CheckBuilder<R>
    extends IMethodDecl.CheckBuilder<R> {

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <R> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IMethodDecl.CheckBuilder.DefaultImpls.plus((IMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IMethodDecl.CheckBuilder.DefaultImpls.plus((IMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IMethodDecl.CheckBuilder.DefaultImpls.minus((IMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IMethodDecl.CheckBuilder.DefaultImpls.minus((IMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R> IBoolExpr startsWith(@NotNull CheckBuilder<R> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IMethodDecl.CheckBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <R> IBoolExpr endsWith(@NotNull CheckBuilder<R> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IMethodDecl.CheckBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <R> IBoolExpr contains(@NotNull CheckBuilder<R> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IMethodDecl.CheckBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <R> IBoolExpr stringEquals(@NotNull CheckBuilder<R> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IMethodDecl.CheckBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <R> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull CheckBuilder<R> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IMethodDecl.CheckBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <R> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull CheckBuilder<R> $this) {
                return IMethodDecl.CheckBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <R> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull CheckBuilder<R> $this) {
                return IMethodDecl.CheckBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <R> IBoolExpr containsAll(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IMethodDecl.CheckBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <R_I1, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull CheckBuilder<R_I1> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IMethodDecl.CheckBuilder.DefaultImpls.anyOr((IMethodDecl.CheckBuilder)$this, $receiver, second);
            }

            @NotNull
            public static <R, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IMethodDecl.CheckBuilder.DefaultImpls.field($this, $receiver, field);
            }

            @NotNull
            public static <R, T, FieldType> IAccessPathT<FieldType> field(@NotNull CheckBuilder<R> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IMethodDecl.CheckBuilder.DefaultImpls.field((IMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <R, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IMethodDecl.CheckBuilder.DefaultImpls.field((IMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <R> void check(@NotNull CheckBuilder<R> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
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
        public static <R> Integer getArgumentCnt(@NotNull ISMethodDecl<R> $this) {
            return IMethodDecl.DefaultImpls.getArgumentCnt($this);
        }

        @Nullable
        public static <R> KFunctionType getActualType(@NotNull ISMethodDecl<R> $this) {
            return IMethodDecl.DefaultImpls.getActualType($this);
        }
    }
}

