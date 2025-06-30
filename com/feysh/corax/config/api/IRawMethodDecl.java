/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
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
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.baseimpl.ConfigException;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0013J/\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u001f\u0010\u0005\u001a\u001b\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\u000b\u00a2\u0006\u0002\b\nH&Jb\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\b\u0002\u0010\u0005\u001a\u001b\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\u000b\u00a2\u0006\u0002\b\n2/\u0010\r\u001a+\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\u0002\b\nH\u0016JP\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\b\u0002\u0010\u0005\u001a\u001b\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\u000b\u00a2\u0006\u0002\b\n2\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\u0002\b\nH\u0016\u00a8\u0006\u0014"}, d2={"Lcom/feysh/corax/config/api/IRawMethodDecl;", "R", "Lcom/feysh/corax/config/api/IMethodDecl;", "checkBuilder", "Lcom/feysh/corax/config/api/IRawMethodDecl$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "model", "block", "Lkotlin/Function2;", "", "Lcom/feysh/corax/config/api/IParameterT;", "", "modelNoArg", "CheckBuilder", "corax-config-api"})
public interface IRawMethodDecl<R>
extends IMethodDecl<R> {
    @Override
    @NotNull
    public CheckBuilder<R> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> var1);

    @NotNull
    public IRawMethodDecl<R> model(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function2<? super CheckBuilder<R>, ? super IParameterT<Object>[], Unit> var2);

    @NotNull
    public IRawMethodDecl<R> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function1<? super CheckBuilder<R>, Unit> var2);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b$\n\u0002\u0010\b\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010)\u001a\u00020*H\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0007R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u0007R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0007\u00a8\u0006+"}, d2={"Lcom/feysh/corax/config/api/IRawMethodDecl$CheckBuilder;", "R", "Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;", "this", "Lcom/feysh/corax/config/api/IParameterT;", "", "getThis", "()Lcom/feysh/corax/config/api/IParameterT;", "p0", "getP0", "p1", "getP1", "p2", "getP2", "p3", "getP3", "p4", "getP4", "p5", "getP5", "p6", "getP6", "p7", "getP7", "p8", "getP8", "p9", "getP9", "p10", "getP10", "p11", "getP11", "p12", "getP12", "p13", "getP13", "p14", "getP14", "p15", "getP15", "parameter", "index", "", "corax-config-api"})
    public static interface CheckBuilder<R>
    extends IMethodDecl.CheckBuilder<R> {
        @NotNull
        public IParameterT<Object> getThis();

        @NotNull
        public IParameterT<Object> getP0();

        @NotNull
        public IParameterT<Object> getP1();

        @NotNull
        public IParameterT<Object> getP2();

        @NotNull
        public IParameterT<Object> getP3();

        @NotNull
        public IParameterT<Object> getP4();

        @NotNull
        public IParameterT<Object> getP5();

        @NotNull
        public IParameterT<Object> getP6();

        @NotNull
        public IParameterT<Object> getP7();

        @NotNull
        public IParameterT<Object> getP8();

        @NotNull
        public IParameterT<Object> getP9();

        @NotNull
        public IParameterT<Object> getP10();

        @NotNull
        public IParameterT<Object> getP11();

        @NotNull
        public IParameterT<Object> getP12();

        @NotNull
        public IParameterT<Object> getP13();

        @NotNull
        public IParameterT<Object> getP14();

        @NotNull
        public IParameterT<Object> getP15();

        @NotNull
        public IParameterT<Object> parameter(int var1);

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <R> IParameterT<Object> getThis(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(-1);
            }

            @NotNull
            public static <R> IParameterT<Object> getP0(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(0);
            }

            @NotNull
            public static <R> IParameterT<Object> getP1(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(1);
            }

            @NotNull
            public static <R> IParameterT<Object> getP2(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(2);
            }

            @NotNull
            public static <R> IParameterT<Object> getP3(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(3);
            }

            @NotNull
            public static <R> IParameterT<Object> getP4(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(4);
            }

            @NotNull
            public static <R> IParameterT<Object> getP5(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(5);
            }

            @NotNull
            public static <R> IParameterT<Object> getP6(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(6);
            }

            @NotNull
            public static <R> IParameterT<Object> getP7(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(7);
            }

            @NotNull
            public static <R> IParameterT<Object> getP8(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(8);
            }

            @NotNull
            public static <R> IParameterT<Object> getP9(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(9);
            }

            @NotNull
            public static <R> IParameterT<Object> getP10(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(10);
            }

            @NotNull
            public static <R> IParameterT<Object> getP11(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(11);
            }

            @NotNull
            public static <R> IParameterT<Object> getP12(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(12);
            }

            @NotNull
            public static <R> IParameterT<Object> getP13(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(13);
            }

            @NotNull
            public static <R> IParameterT<Object> getP14(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(14);
            }

            @NotNull
            public static <R> IParameterT<Object> getP15(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(15);
            }

            @NotNull
            public static <R> IParameterT<Object> parameter(@NotNull CheckBuilder<R> $this, int index) {
                return $this.paramAt(index);
            }

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
    @SourceDebugExtension(value={"SMAP\nAIAnalysisApi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/IRawMethodDecl$DefaultImpls\n+ 2 AIAnalysisApi.kt\ncom/feysh/corax/config/api/AIAnalysisApiKt\n*L\n1#1,839:1\n34#2,6:840\n34#2,6:846\n*S KotlinDebug\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/IRawMethodDecl$DefaultImpls\n*L\n687#1:840,6\n695#1:846,6\n*E\n"})
    public static final class DefaultImpls {
        @NotNull
        public static <R> IRawMethodDecl<R> model(@NotNull IRawMethodDecl<R> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function2<? super CheckBuilder<R>, ? super IParameterT<Object>[], Unit> block) {
            IRawMethodDecl<R> iRawMethodDecl;
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            Integer cnt = $this.getArgumentCnt();
            if (cnt == null) {
                $this.getError().error("The argumentCnt of this method match: " + $this.getMatch() + " is unknown. Please use \".modelNoArg\". Or implemented argumentCnt method of " + $this.getMatch().getClass());
                iRawMethodDecl = $this;
            } else {
                CheckBuilder<R> $this$tryApply$iv = $this.checkBuilder(config);
                boolean $i$f$tryApply = false;
                try {
                    CheckBuilder<R> $this$model_u24lambda_u241 = $this$tryApply$iv;
                    boolean bl = false;
                    int n = 0;
                    IParameterT[] iParameterTArray = new IParameterT[cnt.intValue()];
                    CheckBuilder<R> checkBuilder2 = $this$model_u24lambda_u241;
                    Function2<? super CheckBuilder<R>, ? super IParameterT<Object>[], Unit> function2 = block;
                    while (n < cnt) {
                        int n2 = n++;
                        iParameterTArray[n2] = $this$model_u24lambda_u241.paramAt(n2);
                    }
                    function2.invoke(checkBuilder2, (Object)iParameterTArray);
                }
                catch (ConfigException ignore$iv) {
                    System.err.println(ignore$iv);
                }
                iRawMethodDecl = $this;
            }
            return iRawMethodDecl;
        }

        public static /* synthetic */ IRawMethodDecl model$default(IRawMethodDecl iRawMethodDecl, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: model");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::model$lambda$0;
            }
            return iRawMethodDecl.model((Function1<MethodConfig, Unit>)function1, function2);
        }

        @NotNull
        public static <R> IRawMethodDecl<R> modelNoArg(@NotNull IRawMethodDecl<R> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super CheckBuilder<R>, Unit> block) {
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            CheckBuilder<R> $this$tryApply$iv = $this.checkBuilder(config);
            boolean $i$f$tryApply = false;
            try {
                CheckBuilder<R> $this$modelNoArg_u24lambda_u243 = $this$tryApply$iv;
                boolean bl = false;
                block.invoke($this$modelNoArg_u24lambda_u243);
            }
            catch (ConfigException ignore$iv) {
                System.err.println(ignore$iv);
            }
            return $this;
        }

        public static /* synthetic */ IRawMethodDecl modelNoArg$default(IRawMethodDecl iRawMethodDecl, Function1 function1, Function1 function12, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modelNoArg");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::modelNoArg$lambda$2;
            }
            return iRawMethodDecl.modelNoArg((Function1<MethodConfig, Unit>)function1, function12);
        }

        @Nullable
        public static <R> Integer getArgumentCnt(@NotNull IRawMethodDecl<R> $this) {
            return IMethodDecl.DefaultImpls.getArgumentCnt($this);
        }

        @Nullable
        public static <R> KFunctionType getActualType(@NotNull IRawMethodDecl<R> $this) {
            return IMethodDecl.DefaultImpls.getActualType($this);
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

