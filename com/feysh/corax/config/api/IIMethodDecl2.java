/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
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
import com.feysh.corax.config.api.IIMethodDecl;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005:\u0001\u0014JA\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00072\u001f\u0010\b\u001a\u001b\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\tj\u0002`\u000e\u00a2\u0006\u0002\b\rH&J\u008c\u0001\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002!\b\u0002\u0010\b\u001a\u001b\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\tj\u0002`\u000e\u00a2\u0006\u0002\b\r2G\u0010\u0010\u001aC\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0012\u0012\u0004\u0012\u00020\f0\u0011\u00a2\u0006\u0002\b\rH\u0016Jt\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002!\b\u0002\u0010\b\u001a\u001b\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\tj\u0002`\u000e\u00a2\u0006\u0002\b\r2/\u0010\u0010\u001a+\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\u0002\b\rH\u0016\u00a8\u0006\u0015"}, d2={"Lcom/feysh/corax/config/api/IIMethodDecl2;", "R", "This", "P0", "P1", "Lcom/feysh/corax/config/api/IIMethodDecl;", "checkBuilder", "Lcom/feysh/corax/config/api/IIMethodDecl2$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "model", "block", "Lkotlin/Function3;", "Lcom/feysh/corax/config/api/IParameterT;", "modelNoArg", "CheckBuilder", "corax-config-api"})
public interface IIMethodDecl2<R, This, P0, P1>
extends IIMethodDecl<R, This> {
    @NotNull
    public CheckBuilder<R, This, P0, P1> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> var1);

    @NotNull
    public IIMethodDecl2<R, This, P0, P1> model(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function3<? super CheckBuilder<R, This, P0, P1>, ? super IParameterT<P0>, ? super IParameterT<P1>, Unit> var2);

    @NotNull
    public IIMethodDecl2<R, This, P0, P1> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function1<? super CheckBuilder<R, This, P0, P1>, Unit> var2);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0004\u0010\u0001*\u0004\b\u0005\u0010\u0002*\u0004\b\u0006\u0010\u0003*\u0004\b\u0007\u0010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005R*\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0010"}, d2={"Lcom/feysh/corax/config/api/IIMethodDecl2$CheckBuilder;", "R", "This", "P0", "P1", "Lcom/feysh/corax/config/api/IIMethodDecl$CheckBuilder;", "method", "Lcom/feysh/corax/config/api/IIMethodDecl2;", "getMethod", "()Lcom/feysh/corax/config/api/IIMethodDecl2;", "p0", "Lcom/feysh/corax/config/api/IParameterT;", "getP0", "()Lcom/feysh/corax/config/api/IParameterT;", "p1", "getP1", "corax-config-api"})
    public static interface CheckBuilder<R, This, P0, P1>
    extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        public IIMethodDecl2<R, This, P0, P1> getMethod();

        @NotNull
        public IParameterT<P0> getP0();

        @NotNull
        public IParameterT<P1> getP1();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <R, This, P0, P1> IParameterT<P0> getP0(@NotNull CheckBuilder<R, This, P0, P1> $this) {
                return $this.paramAt(0);
            }

            @NotNull
            public static <R, This, P0, P1> IParameterT<P1> getP1(@NotNull CheckBuilder<R, This, P0, P1> $this) {
                return $this.paramAt(1);
            }

            @NotNull
            public static <R, This, P0, P1> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IIMethodDecl.CheckBuilder.DefaultImpls.plus((IIMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This, P0, P1> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IIMethodDecl.CheckBuilder.DefaultImpls.plus((IIMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This, P0, P1> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IIMethodDecl.CheckBuilder.DefaultImpls.minus((IIMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This, P0, P1> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IIMethodDecl.CheckBuilder.DefaultImpls.minus((IIMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This, P0, P1> IBoolExpr startsWith(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IIMethodDecl.CheckBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, This, P0, P1> IBoolExpr endsWith(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IIMethodDecl.CheckBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, This, P0, P1> IBoolExpr contains(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IIMethodDecl.CheckBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <R, This, P0, P1> IBoolExpr stringEquals(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IIMethodDecl.CheckBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <R, This, P0, P1> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull CheckBuilder<R, This, P0, P1> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IIMethodDecl.CheckBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <R, This, P0, P1> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull CheckBuilder<R, This, P0, P1> $this) {
                return IIMethodDecl.CheckBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <R, This, P0, P1> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull CheckBuilder<R, This, P0, P1> $this) {
                return IIMethodDecl.CheckBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <R, This, P0, P1> IBoolExpr containsAll(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IIMethodDecl.CheckBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <R_I1, This, P0, P1, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull CheckBuilder<R_I1, This, P0, P1> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IIMethodDecl.CheckBuilder.DefaultImpls.anyOr((IIMethodDecl.CheckBuilder)$this, $receiver, second);
            }

            @NotNull
            public static <R, This, P0, P1, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IIMethodDecl.CheckBuilder.DefaultImpls.field($this, $receiver, field);
            }

            @NotNull
            public static <R, This, P0, P1, T, FieldType> IAccessPathT<FieldType> field(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IIMethodDecl.CheckBuilder.DefaultImpls.field((IIMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <R, This, P0, P1, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IIMethodDecl.CheckBuilder.DefaultImpls.field((IIMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <R, This, P0, P1> void check(@NotNull CheckBuilder<R, This, P0, P1> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IIMethodDecl.CheckBuilder.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    @SourceDebugExtension(value={"SMAP\nInstanceMethodInterface.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InstanceMethodInterface.kt\ncom/feysh/corax/config/api/IIMethodDecl2$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,582:1\n1#2:583\n*E\n"})
    public static final class DefaultImpls {
        @NotNull
        public static <R, This, P0, P1> IIMethodDecl2<R, This, P0, P1> model(@NotNull IIMethodDecl2<R, This, P0, P1> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function3<? super CheckBuilder<R, This, P0, P1>, ? super IParameterT<P0>, ? super IParameterT<P1>, Unit> block) {
            CheckBuilder<R, This, P0, P1> checkBuilder2;
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            CheckBuilder<R, This, P0, P1> $this$model_u24lambda_u241 = checkBuilder2 = $this.checkBuilder(config);
            boolean bl = false;
            block.invoke($this$model_u24lambda_u241, $this$model_u24lambda_u241.getP0(), $this$model_u24lambda_u241.getP1());
            return $this;
        }

        public static /* synthetic */ IIMethodDecl2 model$default(IIMethodDecl2 iIMethodDecl2, Function1 function1, Function3 function3, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: model");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::model$lambda$0;
            }
            return iIMethodDecl2.model((Function1<MethodConfig, Unit>)function1, function3);
        }

        @NotNull
        public static <R, This, P0, P1> IIMethodDecl2<R, This, P0, P1> modelNoArg(@NotNull IIMethodDecl2<R, This, P0, P1> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super CheckBuilder<R, This, P0, P1>, Unit> block) {
            CheckBuilder<R, This, P0, P1> checkBuilder2;
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            CheckBuilder<R, This, P0, P1> $this$modelNoArg_u24lambda_u243 = checkBuilder2 = $this.checkBuilder(config);
            boolean bl = false;
            block.invoke($this$modelNoArg_u24lambda_u243);
            return $this;
        }

        public static /* synthetic */ IIMethodDecl2 modelNoArg$default(IIMethodDecl2 iIMethodDecl2, Function1 function1, Function1 function12, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modelNoArg");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::modelNoArg$lambda$2;
            }
            return iIMethodDecl2.modelNoArg((Function1<MethodConfig, Unit>)function1, function12);
        }

        @Nullable
        public static <R, This, P0, P1> Integer getArgumentCnt(@NotNull IIMethodDecl2<R, This, P0, P1> $this) {
            return IIMethodDecl.DefaultImpls.getArgumentCnt($this);
        }

        @Nullable
        public static <R, This, P0, P1> KFunctionType getActualType(@NotNull IIMethodDecl2<R, This, P0, P1> $this) {
            return IIMethodDecl.DefaultImpls.getActualType($this);
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

