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
import com.feysh.corax.config.api.IFieldMatch;
import com.feysh.corax.config.api.IJDecl;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0003\u0015\u0016\u0017J\\\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002!\b\u0002\u0010\u0005\u001a\u001b\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\u000b\u00a2\u0006\u0002\b\n2#\u0010\f\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\u0002\b\nH&Jw\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002!\b\u0002\u0010\u0005\u001a\u001b\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006j\u0002`\u000b\u00a2\u0006\u0002\b\n2>\u0010\f\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00010\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t0\u000f\u00a2\u0006\u0002\b\nH&\u00a8\u0006\u0018"}, d2={"Lcom/feysh/corax/config/api/IFieldDecl;", "This", "T", "Lcom/feysh/corax/config/api/IJDecl;", "atGet", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "block", "Lcom/feysh/corax/config/api/IFieldDecl$IGet;", "atSet", "Lkotlin/Function2;", "Lcom/feysh/corax/config/api/IFieldDecl$ISet;", "Lcom/feysh/corax/config/api/IParameterT;", "Lkotlin/ParameterName;", "name", "value", "IBuilder", "IGet", "ISet", "corax-config-api"})
public interface IFieldDecl<This, T>
extends IJDecl {
    @NotNull
    public IFieldDecl<This, T> atGet(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function1<? super IGet<This, T>, Unit> var2);

    @NotNull
    public IFieldDecl<This, T> atSet(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function2<? super ISet<This, T>, ? super IParameterT<T>, Unit> var2);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static /* synthetic */ IFieldDecl atGet$default(IFieldDecl iFieldDecl, Function1 function1, Function1 function12, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atGet");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::atGet$lambda$0;
            }
            return iFieldDecl.atGet((Function1<MethodConfig, Unit>)function1, function12);
        }

        public static /* synthetic */ IFieldDecl atSet$default(IFieldDecl iFieldDecl, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atSet");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::atSet$lambda$1;
            }
            return iFieldDecl.atSet((Function1<MethodConfig, Unit>)function1, function2);
        }

        private static Unit atGet$lambda$0(MethodConfig methodConfig) {
            Intrinsics.checkNotNullParameter((Object)methodConfig, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static Unit atSet$lambda$1(MethodConfig methodConfig) {
            Intrinsics.checkNotNullParameter((Object)methodConfig, (String)"<this>");
            return Unit.INSTANCE;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003R\u001e\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00030\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0014\u001a\u001b\u0012\b\u0012\u00060\u0016j\u0002`\u0017\u0012\u0004\u0012\u00020\u00180\u0015j\u0002`\u001a\u00a2\u0006\u0002\b\u0019X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2={"Lcom/feysh/corax/config/api/IFieldDecl$IBuilder;", "This", "T", "Lcom/feysh/corax/config/api/IOperatorFactory;", "decl", "Lcom/feysh/corax/config/api/IFieldDecl;", "getDecl", "()Lcom/feysh/corax/config/api/IFieldDecl;", "this", "Lcom/feysh/corax/config/api/IParameterT;", "getThis", "()Lcom/feysh/corax/config/api/IParameterT;", "field", "Lcom/feysh/corax/config/api/IAccessPathT;", "getField", "()Lcom/feysh/corax/config/api/IAccessPathT;", "match", "Lcom/feysh/corax/config/api/IFieldMatch;", "getMatch", "()Lcom/feysh/corax/config/api/IFieldMatch;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "getConfig", "()Lkotlin/jvm/functions/Function1;", "corax-config-api"})
    public static interface IBuilder<This, T>
    extends IOperatorFactory {
        @NotNull
        public IFieldDecl<This, T> getDecl();

        @NotNull
        public IParameterT<This> getThis();

        @NotNull
        public IAccessPathT<T> getField();

        @NotNull
        public IFieldMatch getMatch();

        @NotNull
        public Function1<MethodConfig, Unit> getConfig();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IBuilder<This, T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.plus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IBuilder<This, T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.plus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IBuilder<This, T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.minus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IBuilder<This, T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IOperatorFactory.DefaultImpls.minus((IOperatorFactory)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IBoolExpr startsWith(@NotNull IBuilder<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IBoolExpr endsWith(@NotNull IBuilder<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IBoolExpr contains(@NotNull IBuilder<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IBoolExpr stringEquals(@NotNull IBuilder<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IOperatorFactory.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull IBuilder<This, T> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IOperatorFactory.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull IBuilder<This, T> $this) {
                return IOperatorFactory.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <This, T> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull IBuilder<This, T> $this) {
                return IOperatorFactory.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <This, T> IBoolExpr containsAll(@NotNull IBuilder<This, T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IOperatorFactory.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <This, T, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull IBuilder<This, T> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IOperatorFactory.DefaultImpls.anyOr($this, $receiver, second);
            }

            @NotNull
            public static <This, T_I1, T> IAccessPathT<Object> field(@NotNull IBuilder<This, T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IOperatorFactory.DefaultImpls.field($this, $receiver, field);
            }

            @NotNull
            public static <This, T_I1, T, FieldType> IAccessPathT<FieldType> field(@NotNull IBuilder<This, T_I1> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IOperatorFactory.DefaultImpls.field((IOperatorFactory)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <This, T_I1, T> IAccessPathT<Object> field(@NotNull IBuilder<This, T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IOperatorFactory.DefaultImpls.field((IOperatorFactory)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <This, T> void check(@NotNull IBuilder<This, T> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IOperatorFactory.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lcom/feysh/corax/config/api/IFieldDecl$IGet;", "This", "T", "Lcom/feysh/corax/config/api/IFieldDecl$IBuilder;", "return", "Lcom/feysh/corax/config/api/IReturnT;", "getReturn", "()Lcom/feysh/corax/config/api/IReturnT;", "corax-config-api"})
    public static interface IGet<This, T>
    extends IBuilder<This, T> {
        @NotNull
        public IReturnT<T> getReturn();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <This, T_I1, T> IAccessPathT<Object> field(@NotNull IGet<This, T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, field);
            }

            @NotNull
            public static <This, T_I1, T, FieldType> IAccessPathT<FieldType> field(@NotNull IGet<This, T_I1> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <This, T_I1, T> IAccessPathT<Object> field(@NotNull IGet<This, T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull IGet<This, T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.plus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull IGet<This, T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.plus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull IGet<This, T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.minus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull IGet<This, T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.minus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IBoolExpr startsWith(@NotNull IGet<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IBoolExpr endsWith(@NotNull IGet<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IBoolExpr contains(@NotNull IGet<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IBoolExpr stringEquals(@NotNull IGet<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull IGet<This, T> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull IGet<This, T> $this) {
                return IBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <This, T> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull IGet<This, T> $this) {
                return IBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <This, T> IBoolExpr containsAll(@NotNull IGet<This, T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <This, T, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull IGet<This, T> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IBuilder.DefaultImpls.anyOr($this, $receiver, second);
            }

            public static <This, T> void check(@NotNull IGet<This, T> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IBuilder.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lcom/feysh/corax/config/api/IFieldDecl$ISet;", "This", "T", "Lcom/feysh/corax/config/api/IFieldDecl$IBuilder;", "value", "Lcom/feysh/corax/config/api/IParameterT;", "getValue", "()Lcom/feysh/corax/config/api/IParameterT;", "corax-config-api"})
    public static interface ISet<This, T>
    extends IBuilder<This, T> {
        @NotNull
        public IParameterT<T> getValue();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <This, T_I1, T> IAccessPathT<Object> field(@NotNull ISet<This, T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, field);
            }

            @NotNull
            public static <This, T_I1, T, FieldType> IAccessPathT<FieldType> field(@NotNull ISet<This, T_I1> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <This, T_I1, T> IAccessPathT<Object> field(@NotNull ISet<This, T_I1> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IBuilder.DefaultImpls.field((IBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull ISet<This, T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.plus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull ISet<This, T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.plus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull ISet<This, T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.minus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull ISet<This, T> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IBuilder.DefaultImpls.minus((IBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <This, T> IBoolExpr startsWith(@NotNull ISet<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IBoolExpr endsWith(@NotNull ISet<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IBoolExpr contains(@NotNull ISet<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IBoolExpr stringEquals(@NotNull ISet<This, T> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull ISet<This, T> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <This, T> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull ISet<This, T> $this) {
                return IBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <This, T> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull ISet<This, T> $this) {
                return IBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <This, T> IBoolExpr containsAll(@NotNull ISet<This, T> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <This, T, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull ISet<This, T> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IBuilder.DefaultImpls.anyOr($this, $receiver, second);
            }

            public static <This, T> void check(@NotNull ISet<This, T> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IBuilder.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }
}

