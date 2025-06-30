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

import com.feysh.corax.config.api.AIAnalysisApi;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IJDecl;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.IOperatorFactory;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.ISootLocalVarDecl;
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001#J1\u0010\u0013\u001a\u00020\u00142'\u0010\u0015\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00140\u0016H&J/\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u001f\u0010\u001e\u001a\u001b\u0012\b\u0012\u00060\u001fj\u0002` \u0012\u0004\u0012\u00020\u00140\u0016j\u0002`\"\u00a2\u0006\u0002\b!H&R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006$"}, d2={"Lcom/feysh/corax/config/api/IMethodDecl;", "R", "Lcom/feysh/corax/config/api/IJDecl;", "match", "Lcom/feysh/corax/config/api/IMethodMatch;", "getMatch", "()Lcom/feysh/corax/config/api/IMethodMatch;", "error", "Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "getError", "()Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "argumentCnt", "", "getArgumentCnt", "()Ljava/lang/Integer;", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "getActualType", "()Lcom/feysh/corax/config/api/utils/KFunctionType;", "eachLocalVar", "", "block", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/ISootLocalVarDecl;", "", "Lkotlin/ParameterName;", "name", "localVariable", "checkBuilder", "Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;", "config", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "CheckBuilder", "corax-config-api"})
public interface IMethodDecl<R>
extends IJDecl {
    @NotNull
    public IMethodMatch getMatch();

    @NotNull
    public AIAnalysisApi.Error getError();

    @Nullable
    public Integer getArgumentCnt();

    @Nullable
    public KFunctionType getActualType();

    public void eachLocalVar(@NotNull Function1<? super ISootLocalVarDecl<Object>, Unit> var1);

    @NotNull
    public CheckBuilder<R> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> var1);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0002\u0010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u0007\u001a\u001b\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bj\u0002`\r\u00a2\u0006\u0002\b\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2={"Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;", "R", "Lcom/feysh/corax/config/api/IOperatorFactory;", "method", "Lcom/feysh/corax/config/api/IMethodDecl;", "getMethod", "()Lcom/feysh/corax/config/api/IMethodDecl;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "getConfig", "()Lkotlin/jvm/functions/Function1;", "global", "Lcom/feysh/corax/config/api/ILocalT;", "", "getGlobal", "()Lcom/feysh/corax/config/api/ILocalT;", "paramAt", "Lcom/feysh/corax/config/api/IParameterT;", "T", "index", "", "return", "Lcom/feysh/corax/config/api/IReturnT;", "getReturn", "()Lcom/feysh/corax/config/api/IReturnT;", "corax-config-api"})
    public static interface CheckBuilder<R>
    extends IOperatorFactory {
        @NotNull
        public IMethodDecl<R> getMethod();

        @NotNull
        public Function1<MethodConfig, Unit> getConfig();

        @NotNull
        public ILocalT<Object> getGlobal();

        @NotNull
        public <T> IParameterT<T> paramAt(int var1);

        @NotNull
        public IReturnT<R> getReturn();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <R> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.plus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <R> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.plus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <R> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.minus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <R> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.minus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <R> IBoolExpr startsWith(@NotNull CheckBuilder<R> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <R> IBoolExpr endsWith(@NotNull CheckBuilder<R> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <R> IBoolExpr contains(@NotNull CheckBuilder<R> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <R> IBoolExpr stringEquals(@NotNull CheckBuilder<R> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <R> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull CheckBuilder<R> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IOperatorFactory.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <R> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull CheckBuilder<R> $this) {
                return IOperatorFactory.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <R> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull CheckBuilder<R> $this) {
                return IOperatorFactory.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <R> IBoolExpr containsAll(@NotNull CheckBuilder<R> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IOperatorFactory.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <R_I1, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull CheckBuilder<R_I1> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IOperatorFactory.DefaultImpls.anyOr($this, $receiver, second);
            }

            @NotNull
            public static <R, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IOperatorFactory.DefaultImpls.field($this, $receiver, field);
            }

            @NotNull
            public static <R, T, FieldType> IAccessPathT<FieldType> field(@NotNull CheckBuilder<R> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IOperatorFactory.DefaultImpls.field((IOperatorFactory)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <R, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IOperatorFactory.DefaultImpls.field((IOperatorFactory)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <R> void check(@NotNull CheckBuilder<R> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IOperatorFactory.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Nullable
        public static <R> Integer getArgumentCnt(@NotNull IMethodDecl<R> $this) {
            return $this.getMatch().getArgumentCnt();
        }

        @Nullable
        public static <R> KFunctionType getActualType(@NotNull IMethodDecl<R> $this) {
            return $this.getMatch().getActualType();
        }
    }
}

