/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function14
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
import kotlin.jvm.functions.Function14;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u0006*\u0004\b\u0006\u0010\u0007*\u0004\b\u0007\u0010\b*\u0004\b\b\u0010\t*\u0004\b\t\u0010\n*\u0004\b\n\u0010\u000b*\u0004\b\u000b\u0010\f*\u0004\b\f\u0010\r*\u0004\b\r\u0010\u000e2\b\u0012\u0004\u0012\u0002H\u00010\u000f:\u0001\u001eJ}\u0010\u0010\u001aV\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r0\u00112\u001f\u0010\u0012\u001a\u001b\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u00160\u0013j\u0002`\u0018\u00a2\u0006\u0002\b\u0017H&J\u008a\u0003\u0010\u0019\u001aV\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r0\u00002!\b\u0002\u0010\u0012\u001a\u001b\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u00160\u0013j\u0002`\u0018\u00a2\u0006\u0002\b\u00172\u0088\u0002\u0010\u001a\u001a\u0083\u0002\u0012X\u0012V\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r0\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00060\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00070\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\b0\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\t0\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\n0\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000b0\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\f0\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\r0\u001c\u0012\u0004\u0012\u00020\u00160\u001b\u00a2\u0006\u0002\b\u0017H\u0016J\u00ec\u0001\u0010\u001d\u001aV\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r0\u00002!\b\u0002\u0010\u0012\u001a\u001b\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u00160\u0013j\u0002`\u0018\u00a2\u0006\u0002\b\u00172k\u0010\u001a\u001ag\u0012X\u0012V\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r0\u0011\u0012\u0004\u0012\u00020\u00160\u0013\u00a2\u0006\u0002\b\u0017H\u0016\u00a8\u0006\u001f"}, d2={"Lcom/feysh/corax/config/api/ISMethodDecl13;", "R", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "Lcom/feysh/corax/config/api/ISMethodDecl;", "checkBuilder", "Lcom/feysh/corax/config/api/ISMethodDecl13$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "model", "block", "Lkotlin/Function14;", "Lcom/feysh/corax/config/api/IParameterT;", "modelNoArg", "CheckBuilder", "corax-config-api"})
public interface ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
extends ISMethodDecl<R> {
    @NotNull
    public CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> var1);

    @NotNull
    public ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> model(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function14<? super CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>, ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, ? super IParameterT<P7>, ? super IParameterT<P8>, ? super IParameterT<P9>, ? super IParameterT<P10>, ? super IParameterT<P11>, ? super IParameterT<P12>, Unit> var2);

    @NotNull
    public ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function1<? super CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, Unit> var2);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\bf\u0018\u0000*\u0004\b\u000e\u0010\u0001*\u0004\b\u000f\u0010\u0002*\u0004\b\u0010\u0010\u0003*\u0004\b\u0011\u0010\u0004*\u0004\b\u0012\u0010\u0005*\u0004\b\u0013\u0010\u0006*\u0004\b\u0014\u0010\u0007*\u0004\b\u0015\u0010\b*\u0004\b\u0016\u0010\t*\u0004\b\u0017\u0010\n*\u0004\b\u0018\u0010\u000b*\u0004\b\u0019\u0010\f*\u0004\b\u001a\u0010\r*\u0004\b\u001b\u0010\u000e2\b\u0012\u0004\u0012\u0002H\u00010\u000fRf\u0010\u0010\u001aV\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u0015\u0012\u0004\u0012\u00028\u0016\u0012\u0004\u0012\u00028\u0017\u0012\u0004\u0012\u00028\u0018\u0012\u0004\u0012\u00028\u0019\u0012\u0004\u0012\u00028\u001a\u0012\u0004\u0012\u00028\u001b0\u0011X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u000f0\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00100\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00110\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00120\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00130\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00140\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0017R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00150\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00160\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u0017R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00170\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0017R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00180\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00190\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010\u0017R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00028\u001a0\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010\u0017R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u001b0\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u0017\u00a8\u00060"}, d2={"Lcom/feysh/corax/config/api/ISMethodDecl13$CheckBuilder;", "R", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "Lcom/feysh/corax/config/api/ISMethodDecl$CheckBuilder;", "method", "Lcom/feysh/corax/config/api/ISMethodDecl13;", "getMethod", "()Lcom/feysh/corax/config/api/ISMethodDecl13;", "p0", "Lcom/feysh/corax/config/api/IParameterT;", "getP0", "()Lcom/feysh/corax/config/api/IParameterT;", "p1", "getP1", "p2", "getP2", "p3", "getP3", "p4", "getP4", "p5", "getP5", "p6", "getP6", "p7", "getP7", "p8", "getP8", "p9", "getP9", "p10", "getP10", "p11", "getP11", "p12", "getP12", "corax-config-api"})
    public static interface CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
    extends ISMethodDecl.CheckBuilder<R> {
        @NotNull
        public ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> getMethod();

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

        @NotNull
        public IParameterT<P7> getP7();

        @NotNull
        public IParameterT<P8> getP8();

        @NotNull
        public IParameterT<P9> getP9();

        @NotNull
        public IParameterT<P10> getP10();

        @NotNull
        public IParameterT<P11> getP11();

        @NotNull
        public IParameterT<P12> getP12();

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P0> getP0(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(0);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P1> getP1(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(1);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P2> getP2(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(2);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P3> getP3(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(3);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P4> getP4(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(4);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P5> getP5(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(5);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P6> getP6(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(6);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P7> getP7(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(7);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P8> getP8(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(8);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P9> getP9(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(9);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P10> getP10(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(10);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P11> getP11(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(11);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IParameterT<P12> getP12(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return $this.paramAt(12);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IAttribute<TaintProperty, Set<ITaintType>> plus(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return ISMethodDecl.CheckBuilder.DefaultImpls.plus((ISMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IAttribute<ViaProperty, Set<IViaType>> plus(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return ISMethodDecl.CheckBuilder.DefaultImpls.plus((ISMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IAttribute<TaintProperty, Set<ITaintType>> minus(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return ISMethodDecl.CheckBuilder.DefaultImpls.minus((ISMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IAttribute<ViaProperty, Set<IViaType>> minus(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull IAttribute<ViaProperty, Set<IViaType>> $receiver, @NotNull IViaType single) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)single, (String)"single");
                return ISMethodDecl.CheckBuilder.DefaultImpls.minus((ISMethodDecl.CheckBuilder)$this, $receiver, single);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IBoolExpr startsWith(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return ISMethodDecl.CheckBuilder.DefaultImpls.startsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IBoolExpr endsWith(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return ISMethodDecl.CheckBuilder.DefaultImpls.endsWith($this, $receiver, str);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IBoolExpr contains(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return ISMethodDecl.CheckBuilder.DefaultImpls.contains($this, $receiver, str);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IBoolExpr stringEquals(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull IStringExpr $receiver, @NotNull String str) {
                Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                return ISMethodDecl.CheckBuilder.DefaultImpls.stringEquals($this, $receiver, str);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IAttribute<TaintProperty, Set<ITaintType>> taintOf(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, ITaintType ... type) {
                Intrinsics.checkNotNullParameter((Object)type, (String)"type");
                return ISMethodDecl.CheckBuilder.DefaultImpls.taintOf($this, type);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IAttribute<TaintProperty, Set<ITaintType>> getEmptyTaint(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return ISMethodDecl.CheckBuilder.DefaultImpls.getEmptyTaint($this);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IAttribute<ViaProperty, Set<IViaType>> getEmptyVia(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
                return ISMethodDecl.CheckBuilder.DefaultImpls.getEmptyVia($this);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> IBoolExpr containsAll(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull IAttribute<TaintProperty, Set<ITaintType>> $receiver, @NotNull ITaintType taint) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)taint, (String)"taint");
                return ISMethodDecl.CheckBuilder.DefaultImpls.containsAll($this, $receiver, taint);
            }

            @NotNull
            public static <R_I1, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, T1 extends R, T2 extends R, R> ILocalValue<R> anyOr(@NotNull CheckBuilder<R_I1, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull ILocalT<T1> $receiver, @NotNull ILocalT<T2> second) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(second, (String)"second");
                return ISMethodDecl.CheckBuilder.DefaultImpls.anyOr((ISMethodDecl.CheckBuilder)$this, $receiver, second);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull ILocalT<T> $receiver, @NotNull SootField field) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)field, (String)"field");
                return ISMethodDecl.CheckBuilder.DefaultImpls.field($this, $receiver, field);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, T, FieldType> IAccessPathT<FieldType> field(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull ILocalT<T> $receiver, @Nullable KClass<?> declaringClass, @NotNull String fieldName, @NotNull KClass<FieldType> type) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                Intrinsics.checkNotNullParameter(type, (String)"type");
                return ISMethodDecl.CheckBuilder.DefaultImpls.field((ISMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, type);
            }

            @NotNull
            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, T> IAccessPathT<Object> field(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull ILocalT<T> $receiver, @NotNull KClass<?> declaringClass, @NotNull String fieldName, @Nullable String fieldType) {
                Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
                Intrinsics.checkNotNullParameter(declaringClass, (String)"declaringClass");
                Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
                return ISMethodDecl.CheckBuilder.DefaultImpls.field((ISMethodDecl.CheckBuilder)$this, $receiver, declaringClass, fieldName, fieldType);
            }

            public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> void check(@NotNull CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull ILocalT<Boolean> expr, @NotNull CheckType checkType, @NotNull Function1<? super BugMessage.Env, Unit> env) {
                Intrinsics.checkNotNullParameter(expr, (String)"expr");
                Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
                Intrinsics.checkNotNullParameter(env, (String)"env");
                ISMethodDecl.CheckBuilder.DefaultImpls.check($this, expr, checkType, env);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    @SourceDebugExtension(value={"SMAP\nStaticMethodInterface.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaticMethodInterface.kt\ncom/feysh/corax/config/api/ISMethodDecl13$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,577:1\n1#2:578\n*E\n"})
    public static final class DefaultImpls {
        @NotNull
        public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> model(@NotNull ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function14<? super CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, ? super IParameterT<P0>, ? super IParameterT<P1>, ? super IParameterT<P2>, ? super IParameterT<P3>, ? super IParameterT<P4>, ? super IParameterT<P5>, ? super IParameterT<P6>, ? super IParameterT<P7>, ? super IParameterT<P8>, ? super IParameterT<P9>, ? super IParameterT<P10>, ? super IParameterT<P11>, ? super IParameterT<P12>, Unit> block) {
            CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> checkBuilder2;
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this$model_u24lambda_u241 = checkBuilder2 = $this.checkBuilder(config);
            boolean bl = false;
            block.invoke($this$model_u24lambda_u241, $this$model_u24lambda_u241.getP0(), $this$model_u24lambda_u241.getP1(), $this$model_u24lambda_u241.getP2(), $this$model_u24lambda_u241.getP3(), $this$model_u24lambda_u241.getP4(), $this$model_u24lambda_u241.getP5(), $this$model_u24lambda_u241.getP6(), $this$model_u24lambda_u241.getP7(), $this$model_u24lambda_u241.getP8(), $this$model_u24lambda_u241.getP9(), $this$model_u24lambda_u241.getP10(), $this$model_u24lambda_u241.getP11(), $this$model_u24lambda_u241.getP12());
            return $this;
        }

        public static /* synthetic */ ISMethodDecl13 model$default(ISMethodDecl13 iSMethodDecl13, Function1 function1, Function14 function14, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: model");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::model$lambda$0;
            }
            return iSMethodDecl13.model((Function1<MethodConfig, Unit>)function1, function14);
        }

        @NotNull
        public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> modelNoArg(@NotNull ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>, Unit> block) {
            CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> checkBuilder2;
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            CheckBuilder<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this$modelNoArg_u24lambda_u243 = checkBuilder2 = $this.checkBuilder(config);
            boolean bl = false;
            block.invoke($this$modelNoArg_u24lambda_u243);
            return $this;
        }

        public static /* synthetic */ ISMethodDecl13 modelNoArg$default(ISMethodDecl13 iSMethodDecl13, Function1 function1, Function1 function12, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modelNoArg");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::modelNoArg$lambda$2;
            }
            return iSMethodDecl13.modelNoArg((Function1<MethodConfig, Unit>)function1, function12);
        }

        @Nullable
        public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> Integer getArgumentCnt(@NotNull ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
            return ISMethodDecl.DefaultImpls.getArgumentCnt($this);
        }

        @Nullable
        public static <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> KFunctionType getActualType(@NotNull ISMethodDecl13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> $this) {
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

