/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
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
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.ISMethodDecl;
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
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u00062\b\u0012\u0004\u0012\u0002H\u00010\u0007:\u0001\u0016JM\u0010\b\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t2\u001f\u0010\n\u001a\u001b\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`\u0010\u00a2\u0006\u0002\b\u000fH&J\u00c8\u0001\u0010\u0011\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002!\b\u0002\u0010\n\u001a\u001b\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`\u0010\u00a2\u0006\u0002\b\u000f2w\u0010\u0012\u001as\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0014\u0012\u0004\u0012\u00020\u000e0\u0013\u00a2\u0006\u0002\b\u000fH\u0016J\u008c\u0001\u0010\u0015\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002!\b\u0002\u0010\n\u001a\u001b\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`\u0010\u00a2\u0006\u0002\b\u000f2;\u0010\u0012\u001a7\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t\u0012\u0004\u0012\u00020\u000e0\u000b\u00a2\u0006\u0002\b\u000fH\u0016\u00a8\u0006\u0017"}, d2={"Lcom/feysh/corax/config/api/ISMethodDecl5;", "R", "P0", "P1", "P2", "P3", "P4", "Lcom/feysh/corax/config/api/ISMethodDecl;", "checkBuilder", "Lcom/feysh/corax/config/api/ISMethodDecl5$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "model", "block", "Lkotlin/Function6;", "Lcom/feysh/corax/config/api/IParameterT;", "modelNoArg", "CheckBuilder", "corax-config-api"})
public interface ISMethodDecl5<R, P0, P1, P2, P3, P4>
extends ISMethodDecl<R> {
    @NotNull
    public CheckBuilder<R, P0, P1, P2, P3, P4> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> var1);

    @NotNull
    public ISMethodDecl5<R, P0, P1, P2, P3, P4> model(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function6<? super CheckBuilder<R, P0, P1, P2, P3, P4>, ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>, ? super IParameterT<P4>, Unit> var2);

    @NotNull
    public ISMethodDecl5<R, P0, P1, P2, P3, P4> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function1<? super CheckBuilder<R, P0, P1, P2, P3, P4>, Unit> var2);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000*\u0004\b\u0006\u0010\u0001*\u0004\b\u0007\u0010\u0002*\u0004\b\b\u0010\u0003*\u0004\b\t\u0010\u0004*\u0004\b\n\u0010\u0005*\u0004\b\u000b\u0010\u00062\b\u0012\u0004\u0012\u0002H\u00010\u0007R6\u0010\b\u001a&\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b0\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00070\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\b0\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\t0\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\n0\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u000b0\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006\u0018"}, d2={"Lcom/feysh/corax/config/api/ISMethodDecl5$CheckBuilder;", "R", "P0", "P1", "P2", "P3", "P4", "Lcom/feysh/corax/config/api/ISMethodDecl$CheckBuilder;", "method", "Lcom/feysh/corax/config/api/ISMethodDecl5;", "getMethod", "()Lcom/feysh/corax/config/api/ISMethodDecl5;", "p0", "Lcom/feysh/corax/config/api/IParameterT;", "getP0", "()Lcom/feysh/corax/config/api/IParameterT;", "p1", "getP1", "p2", "getP2", "p3", "getP3", "p4", "getP4", "corax-config-api"})
    public static interface CheckBuilder<R, P0, P1, P2, P3, P4>
    extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        public ISMethodDecl5<R, P0, P1, P2, P3, P4> getMethod();

        @NotNull
        public IParameterT<P0> getP0();

        @NotNull
        public IParameterT<P1> getP1();

        @NotNull
        public IParameterT<P2> getP2();

        @NotNull
        public IParameterT<P3> getP3();

        @NotNull
        public IParameterT<P4> getP4();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <R, P0, P1, P2, P3, P4> IParameterT<P0> getP0(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this) {
                return $this.paramAt(0);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IParameterT<P1> getP1(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this) {
                return $this.paramAt(1);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IParameterT<P2> getP2(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this) {
                return $this.paramAt(2);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IParameterT<P3> getP3(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this) {
                return $this.paramAt(3);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IParameterT<P4> getP4(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this) {
                return $this.paramAt(4);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return ISMethodDecl.CheckBuilder.DefaultImpls.plus((ISMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return ISMethodDecl.CheckBuilder.DefaultImpls.plus((ISMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return ISMethodDecl.CheckBuilder.DefaultImpls.minus((ISMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return ISMethodDecl.CheckBuilder.DefaultImpls.minus((ISMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IBoolExpr startsWith(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return ISMethodDecl.CheckBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IBoolExpr endsWith(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return ISMethodDecl.CheckBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IBoolExpr contains(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return ISMethodDecl.CheckBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IBoolExpr stringEquals(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return ISMethodDecl.CheckBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return ISMethodDecl.CheckBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this) {
                return ISMethodDecl.CheckBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this) {
                return ISMethodDecl.CheckBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4> IBoolExpr containsAll(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return ISMethodDecl.CheckBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <R_I1, P0, P1, P2, P3, P4, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull CheckBuilder<R_I1, P0, P1, P2, P3, P4> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return ISMethodDecl.CheckBuilder.DefaultImpls.anyOr((ISMethodDecl.CheckBuilder)$this, $receiver, second);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return ISMethodDecl.CheckBuilder.DefaultImpls.field($this, $receiver, field);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, T, FieldType> IAccessPathT<FieldType> field(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return ISMethodDecl.CheckBuilder.DefaultImpls.field((ISMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return ISMethodDecl.CheckBuilder.DefaultImpls.field((ISMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <R, P0, P1, P2, P3, P4> void check(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                ISMethodDecl.CheckBuilder.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    @SourceDebugExtension(value={"SMAP\nStaticMethodInterface.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaticMethodInterface.kt\ncom/feysh/corax/config/api/ISMethodDecl5$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,577:1\n1#2:578\n*E\n"})
    public static final class DefaultImpls {
        @NotNull
        public static <R, P0, P1, P2, P3, P4> ISMethodDecl5<R, P0, P1, P2, P3, P4> model(@NotNull ISMethodDecl5<R, P0, P1, P2, P3, P4> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function6<? super CheckBuilder<R, P0, P1, P2, P3, P4>, ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>, ? super IParameterT<P4>, Unit> block) {
            CheckBuilder<R, P0, P1, P2, P3, P4> checkBuilder2;
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            CheckBuilder<R, P0, P1, P2, P3, P4> $this$model_u24lambda_u241 = checkBuilder2 = $this.checkBuilder(config);
            boolean bl = false;
            block.invoke($this$model_u24lambda_u241, $this$model_u24lambda_u241.getP0(), $this$model_u24lambda_u241.getP1(), $this$model_u24lambda_u241.getP2(), $this$model_u24lambda_u241.getP3(), $this$model_u24lambda_u241.getP4());
            return $this;
        }

        public static /* synthetic */ ISMethodDecl5 model$default(ISMethodDecl5 iSMethodDecl5, Function1 function1, Function6 function6, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: model");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::model$lambda$0;
            }
            return iSMethodDecl5.model((Function1<MethodConfig, Unit>)function1, function6);
        }

        @NotNull
        public static <R, P0, P1, P2, P3, P4> ISMethodDecl5<R, P0, P1, P2, P3, P4> modelNoArg(@NotNull ISMethodDecl5<R, P0, P1, P2, P3, P4> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super CheckBuilder<R, P0, P1, P2, P3, P4>, Unit> block) {
            CheckBuilder<R, P0, P1, P2, P3, P4> checkBuilder2;
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            CheckBuilder<R, P0, P1, P2, P3, P4> $this$modelNoArg_u24lambda_u243 = checkBuilder2 = $this.checkBuilder(config);
            boolean bl = false;
            block.invoke($this$modelNoArg_u24lambda_u243);
            return $this;
        }

        public static /* synthetic */ ISMethodDecl5 modelNoArg$default(ISMethodDecl5 iSMethodDecl5, Function1 function1, Function1 function12, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modelNoArg");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::modelNoArg$lambda$2;
            }
            return iSMethodDecl5.modelNoArg((Function1<MethodConfig, Unit>)function1, function12);
        }

        @Nullable
        public static <R, P0, P1, P2, P3, P4> Integer getArgumentCnt(@NotNull ISMethodDecl5<R, P0, P1, P2, P3, P4> $this) {
            return ISMethodDecl.DefaultImpls.getArgumentCnt($this);
        }

        @Nullable
        public static <R, P0, P1, P2, P3, P4> KFunctionType getActualType(@NotNull ISMethodDecl5<R, P0, P1, P2, P3, P4> $this) {
            return ISMethodDecl.DefaultImpls.getActualType($this);
        }

        private static Unit model$lambda$0(MethodConfig methodConfig) {
            Intrinsics.checkNotNullParameter((Object)methodConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit modelNoArg$lambda$2(MethodConfig methodConfig) {
            Intrinsics.checkNotNullParameter((Object)methodConfig, (String)"<this>");
            return Unit.INSTANCE;
        }
    }
}

