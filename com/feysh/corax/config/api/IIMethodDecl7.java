/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function8
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
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u0006*\u0004\b\u0006\u0010\u0007*\u0004\b\u0007\u0010\b*\u0004\b\b\u0010\t2\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\n:\u0001\u0019J_\u0010\u000b\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\f2\u001f\u0010\r\u001a\u001b\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000ej\u0002`\u0013\u00a2\u0006\u0002\b\u0012H&J\u0086\u0002\u0010\u0014\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u00002!\b\u0002\u0010\r\u001a\u001b\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000ej\u0002`\u0013\u00a2\u0006\u0002\b\u00122\u00a2\u0001\u0010\u0015\u001a\u009d\u0001\u0012:\u00128\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00060\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00070\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\b0\u0017\u0012\u0004\u0012\u00020\u00110\u0016\u00a2\u0006\u0002\b\u0012H\u0016J\u00b0\u0001\u0010\u0018\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u00002!\b\u0002\u0010\r\u001a\u001b\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000ej\u0002`\u0013\u00a2\u0006\u0002\b\u00122M\u0010\u0015\u001aI\u0012:\u00128\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\f\u0012\u0004\u0012\u00020\u00110\u000e\u00a2\u0006\u0002\b\u0012H\u0016\u00a8\u0006\u001a"}, d2={"Lcom/feysh/corax/config/api/IIMethodDecl7;", "R", "This", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "Lcom/feysh/corax/config/api/IIMethodDecl;", "checkBuilder", "Lcom/feysh/corax/config/api/IIMethodDecl7$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "model", "block", "Lkotlin/Function8;", "Lcom/feysh/corax/config/api/IParameterT;", "modelNoArg", "CheckBuilder", "corax-config-api"})
public interface IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6>
extends IIMethodDecl<R, This> {
    @NotNull
    public CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> var1);

    @NotNull
    public IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> model(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function8<? super CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6>, ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>, ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, Unit> var2);

    @NotNull
    public IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function1<? super CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6>, Unit> var2);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u0000*\u0004\b\t\u0010\u0001*\u0004\b\n\u0010\u0002*\u0004\b\u000b\u0010\u0003*\u0004\b\f\u0010\u0004*\u0004\b\r\u0010\u0005*\u0004\b\u000e\u0010\u0006*\u0004\b\u000f\u0010\u0007*\u0004\b\u0010\u0010\b*\u0004\b\u0011\u0010\t2\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\nRH\u0010\u000b\u001a8\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u00110\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u000b0\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\f0\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\r0\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u000e0\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u000f0\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00100\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00110\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012\u00a8\u0006\u001f"}, d2={"Lcom/feysh/corax/config/api/IIMethodDecl7$CheckBuilder;", "R", "This", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "Lcom/feysh/corax/config/api/IIMethodDecl$CheckBuilder;", "method", "Lcom/feysh/corax/config/api/IIMethodDecl7;", "getMethod", "()Lcom/feysh/corax/config/api/IIMethodDecl7;", "p0", "Lcom/feysh/corax/config/api/IParameterT;", "getP0", "()Lcom/feysh/corax/config/api/IParameterT;", "p1", "getP1", "p2", "getP2", "p3", "getP3", "p4", "getP4", "p5", "getP5", "p6", "getP6", "corax-config-api"})
    public static interface CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6>
    extends IIMethodDecl.CheckBuilder<R, This> {
        @NotNull
        public IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> getMethod();

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

        @NotNull
        public IParameterT<P5> getP5();

        @NotNull
        public IParameterT<P6> getP6();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IParameterT<P0> getP0(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
                return $this.paramAt(0);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IParameterT<P1> getP1(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
                return $this.paramAt(1);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IParameterT<P2> getP2(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
                return $this.paramAt(2);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IParameterT<P3> getP3(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
                return $this.paramAt(3);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IParameterT<P4> getP4(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
                return $this.paramAt(4);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IParameterT<P5> getP5(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
                return $this.paramAt(5);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IParameterT<P6> getP6(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
                return $this.paramAt(6);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IIMethodDecl.CheckBuilder.DefaultImpls.plus((IIMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IIMethodDecl.CheckBuilder.DefaultImpls.plus((IIMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IIMethodDecl.CheckBuilder.DefaultImpls.minus((IIMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return IIMethodDecl.CheckBuilder.DefaultImpls.minus((IIMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IBoolExpr startsWith(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IIMethodDecl.CheckBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IBoolExpr endsWith(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IIMethodDecl.CheckBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IBoolExpr contains(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IIMethodDecl.CheckBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IBoolExpr stringEquals(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return IIMethodDecl.CheckBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return IIMethodDecl.CheckBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
                return IIMethodDecl.CheckBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
                return IIMethodDecl.CheckBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6> IBoolExpr containsAll(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return IIMethodDecl.CheckBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <R_I1, This, P0, P1, P2, P3, P4, P5, P6, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull CheckBuilder<R_I1, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return IIMethodDecl.CheckBuilder.DefaultImpls.anyOr((IIMethodDecl.CheckBuilder)$this, $receiver, second);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return IIMethodDecl.CheckBuilder.DefaultImpls.field($this, $receiver, field);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6, T, FieldType> IAccessPathT<FieldType> field(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return IIMethodDecl.CheckBuilder.DefaultImpls.field((IIMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <R, This, P0, P1, P2, P3, P4, P5, P6, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return IIMethodDecl.CheckBuilder.DefaultImpls.field((IIMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <R, This, P0, P1, P2, P3, P4, P5, P6> void check(@NotNull CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                IIMethodDecl.CheckBuilder.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    @SourceDebugExtension(value={"SMAP\nInstanceMethodInterface.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InstanceMethodInterface.kt\ncom/feysh/corax/config/api/IIMethodDecl7$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,582:1\n1#2:583\n*E\n"})
    public static final class DefaultImpls {
        @NotNull
        public static <R, This, P0, P1, P2, P3, P4, P5, P6> IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> model(@NotNull IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function8<? super CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6>, ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>, ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, Unit> block) {
            CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> checkBuilder2;
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this$model_u24lambda_u241 = checkBuilder2 = $this.checkBuilder(config);
            boolean bl = false;
            block.invoke($this$model_u24lambda_u241, $this$model_u24lambda_u241.getP0(), $this$model_u24lambda_u241.getP1(), $this$model_u24lambda_u241.getP2(), $this$model_u24lambda_u241.getP3(), $this$model_u24lambda_u241.getP4(), $this$model_u24lambda_u241.getP5(), $this$model_u24lambda_u241.getP6());
            return $this;
        }

        public static /* synthetic */ IIMethodDecl7 model$default(IIMethodDecl7 iIMethodDecl7, Function1 function1, Function8 function8, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: model");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::model$lambda$0;
            }
            return iIMethodDecl7.model((Function1<MethodConfig, Unit>)function1, function8);
        }

        @NotNull
        public static <R, This, P0, P1, P2, P3, P4, P5, P6> IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> modelNoArg(@NotNull IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6>, Unit> block) {
            CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> checkBuilder2;
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            CheckBuilder<R, This, P0, P1, P2, P3, P4, P5, P6> $this$modelNoArg_u24lambda_u243 = checkBuilder2 = $this.checkBuilder(config);
            boolean bl = false;
            block.invoke($this$modelNoArg_u24lambda_u243);
            return $this;
        }

        public static /* synthetic */ IIMethodDecl7 modelNoArg$default(IIMethodDecl7 iIMethodDecl7, Function1 function1, Function1 function12, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modelNoArg");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::modelNoArg$lambda$2;
            }
            return iIMethodDecl7.modelNoArg((Function1<MethodConfig, Unit>)function1, function12);
        }

        @Nullable
        public static <R, This, P0, P1, P2, P3, P4, P5, P6> Integer getArgumentCnt(@NotNull IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
            return IIMethodDecl.DefaultImpls.getArgumentCnt($this);
        }

        @Nullable
        public static <R, This, P0, P1, P2, P3, P4, P5, P6> KFunctionType getActualType(@NotNull IIMethodDecl7<R, This, P0, P1, P2, P3, P4, P5, P6> $this) {
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

