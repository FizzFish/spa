/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.tagkit.AnnotationTag
 *  soot.tagkit.Tag
 *  soot.tagkit.VisibilityAnnotationTag
 *  soot.tagkit.VisibilityParameterAnnotationTag
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
import com.feysh.corax.config.api.ISootClassDecl;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.baseimpl.ConfigException;
import com.feysh.corax.config.api.baseimpl.SootParameter;
import com.feysh.corax.config.api.baseimpl.SootReturn;
import com.feysh.corax.config.api.utils.KFunctionType;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.tagkit.VisibilityParameterAnnotationTag;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001:J/\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000,2\u001f\u0010-\u001a\u001b\u0012\b\u0012\u00060/j\u0002`0\u0012\u0004\u0012\u0002010.j\u0002`3\u00a2\u0006\u0002\b2H&Jb\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\b\u0002\u0010-\u001a\u001b\u0012\b\u0012\u00060/j\u0002`0\u0012\u0004\u0012\u0002010.j\u0002`3\u00a2\u0006\u0002\b22/\u00105\u001a+\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u001d07\u0012\u0004\u0012\u00020106\u00a2\u0006\u0002\b2H\u0016JP\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\b\u0002\u0010-\u001a\u001b\u0012\b\u0012\u00060/j\u0002`0\u0012\u0004\u0012\u0002010.j\u0002`3\u00a2\u0006\u0002\b22\u001d\u00105\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,\u0012\u0004\u0012\u0002010.\u00a2\u0006\u0002\b2H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!*\u0006\u0012\u0002\b\u00030\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020&0!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010 \u001a\u0004\u0018\u00010\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010)R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010*\u00a8\u0006;"}, d2={"Lcom/feysh/corax/config/api/ISootMethodDecl;", "R", "Lcom/feysh/corax/config/api/IMethodDecl;", "clazz", "Lcom/feysh/corax/config/api/ISootClassDecl;", "getClazz", "()Lcom/feysh/corax/config/api/ISootClassDecl;", "sootMethod", "Lsoot/SootMethod;", "getSootMethod", "()Lsoot/SootMethod;", "sootClass", "Lsoot/SootClass;", "getSootClass", "()Lsoot/SootClass;", "argumentCnt", "", "getArgumentCnt", "()Ljava/lang/Integer;", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "getActualType", "()Lcom/feysh/corax/config/api/utils/KFunctionType;", "parameterAnnotationTag", "Lsoot/tagkit/VisibilityParameterAnnotationTag;", "getParameterAnnotationTag", "()Lsoot/tagkit/VisibilityParameterAnnotationTag;", "visibilityAnnotationTag", "Lsoot/tagkit/VisibilityAnnotationTag;", "Lcom/feysh/corax/config/api/IParameterT;", "getVisibilityAnnotationTag", "(Lcom/feysh/corax/config/api/IParameterT;)Lsoot/tagkit/VisibilityAnnotationTag;", "annotationTag", "", "Lsoot/tagkit/AnnotationTag;", "getAnnotationTag", "(Lcom/feysh/corax/config/api/IParameterT;)Ljava/util/List;", "tags", "Lsoot/tagkit/Tag;", "getTags", "()Ljava/util/List;", "()Lsoot/tagkit/AnnotationTag;", "()Lsoot/tagkit/VisibilityAnnotationTag;", "checkBuilder", "Lcom/feysh/corax/config/api/ISootMethodDecl$CheckBuilder;", "config", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/MethodConfig;", "Lcom/feysh/corax/config/api/MethodConfigType;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/feysh/corax/config/api/MethodConfigBlockType;", "model", "block", "Lkotlin/Function2;", "", "", "modelNoArg", "CheckBuilder", "corax-config-api"})
public interface ISootMethodDecl<R>
extends IMethodDecl<R> {
    @NotNull
    public ISootClassDecl getClazz();

    @NotNull
    public SootMethod getSootMethod();

    @NotNull
    public SootClass getSootClass();

    @Override
    @NotNull
    public Integer getArgumentCnt();

    @Override
    @NotNull
    public KFunctionType getActualType();

    @Nullable
    public VisibilityParameterAnnotationTag getParameterAnnotationTag();

    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag(@NotNull IParameterT<?> var1);

    @NotNull
    public List<AnnotationTag> getAnnotationTag(@NotNull IParameterT<?> var1);

    @NotNull
    public List<Tag> getTags();

    @Nullable
    public AnnotationTag getAnnotationTag();

    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag();

    @Override
    @NotNull
    public CheckBuilder<R> checkBuilder(@NotNull Function1<? super MethodConfig, Unit> var1);

    @NotNull
    public ISootMethodDecl<R> model(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function2<? super CheckBuilder<R>, ? super IParameterT<Object>[], Unit> var2);

    @NotNull
    public ISootMethodDecl<R> modelNoArg(@NotNull Function1<? super MethodConfig, Unit> var1, @NotNull Function1<? super CheckBuilder<R>, Unit> var2);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u0002H-0\b\"\u0004\b\u0002\u0010-2\u0006\u0010.\u001a\u00020/H&J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010.\u001a\u00020/H\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u000bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u000bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u000bR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u000bR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u000bR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u000bR\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010\u000bR\u0018\u00100\u001a\b\u0012\u0004\u0012\u00028\u000101X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103\u00a8\u00065"}, d2={"Lcom/feysh/corax/config/api/ISootMethodDecl$CheckBuilder;", "R", "Lcom/feysh/corax/config/api/IMethodDecl$CheckBuilder;", "method", "Lcom/feysh/corax/config/api/ISootMethodDecl;", "getMethod", "()Lcom/feysh/corax/config/api/ISootMethodDecl;", "this", "Lcom/feysh/corax/config/api/baseimpl/SootParameter;", "", "getThis", "()Lcom/feysh/corax/config/api/baseimpl/SootParameter;", "p0", "getP0", "p1", "getP1", "p2", "getP2", "p3", "getP3", "p4", "getP4", "p5", "getP5", "p6", "getP6", "p7", "getP7", "p8", "getP8", "p9", "getP9", "p10", "getP10", "p11", "getP11", "p12", "getP12", "p13", "getP13", "p14", "getP14", "p15", "getP15", "paramAt", "T", "index", "", "return", "Lcom/feysh/corax/config/api/baseimpl/SootReturn;", "getReturn", "()Lcom/feysh/corax/config/api/baseimpl/SootReturn;", "parameter", "corax-config-api"})
    public static interface CheckBuilder<R>
    extends IMethodDecl.CheckBuilder<R> {
        @Override
        @NotNull
        public ISootMethodDecl<R> getMethod();

        @NotNull
        public SootParameter<Object> getThis();

        @NotNull
        public SootParameter<Object> getP0();

        @NotNull
        public SootParameter<Object> getP1();

        @NotNull
        public SootParameter<Object> getP2();

        @NotNull
        public SootParameter<Object> getP3();

        @NotNull
        public SootParameter<Object> getP4();

        @NotNull
        public SootParameter<Object> getP5();

        @NotNull
        public SootParameter<Object> getP6();

        @NotNull
        public SootParameter<Object> getP7();

        @NotNull
        public SootParameter<Object> getP8();

        @NotNull
        public SootParameter<Object> getP9();

        @NotNull
        public SootParameter<Object> getP10();

        @NotNull
        public SootParameter<Object> getP11();

        @NotNull
        public SootParameter<Object> getP12();

        @NotNull
        public SootParameter<Object> getP13();

        @NotNull
        public SootParameter<Object> getP14();

        @NotNull
        public SootParameter<Object> getP15();

        @Override
        @NotNull
        public <T> SootParameter<T> paramAt(int var1);

        @Override
        @NotNull
        public SootReturn<R> getReturn();

        @NotNull
        public SootParameter<Object> parameter(int var1);

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @NotNull
            public static <R> SootParameter<Object> getThis(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(-1);
            }

            @NotNull
            public static <R> SootParameter<Object> getP0(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(0);
            }

            @NotNull
            public static <R> SootParameter<Object> getP1(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(1);
            }

            @NotNull
            public static <R> SootParameter<Object> getP2(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(2);
            }

            @NotNull
            public static <R> SootParameter<Object> getP3(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(3);
            }

            @NotNull
            public static <R> SootParameter<Object> getP4(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(4);
            }

            @NotNull
            public static <R> SootParameter<Object> getP5(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(5);
            }

            @NotNull
            public static <R> SootParameter<Object> getP6(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(6);
            }

            @NotNull
            public static <R> SootParameter<Object> getP7(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(7);
            }

            @NotNull
            public static <R> SootParameter<Object> getP8(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(8);
            }

            @NotNull
            public static <R> SootParameter<Object> getP9(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(9);
            }

            @NotNull
            public static <R> SootParameter<Object> getP10(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(10);
            }

            @NotNull
            public static <R> SootParameter<Object> getP11(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(11);
            }

            @NotNull
            public static <R> SootParameter<Object> getP12(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(12);
            }

            @NotNull
            public static <R> SootParameter<Object> getP13(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(13);
            }

            @NotNull
            public static <R> SootParameter<Object> getP14(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(14);
            }

            @NotNull
            public static <R> SootParameter<Object> getP15(@NotNull CheckBuilder<R> $this) {
                return $this.paramAt(15);
            }

            @NotNull
            public static <R> SootParameter<Object> parameter(@NotNull CheckBuilder<R> $this, int index) {
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
    @SourceDebugExtension(value={"SMAP\nAIAnalysisApi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/ISootMethodDecl$DefaultImpls\n+ 2 AIAnalysisApi.kt\ncom/feysh/corax/config/api/AIAnalysisApiKt\n*L\n1#1,839:1\n34#2,6:840\n34#2,6:846\n*S KotlinDebug\n*F\n+ 1 AIAnalysisApi.kt\ncom/feysh/corax/config/api/ISootMethodDecl$DefaultImpls\n*L\n590#1:840,6\n597#1:846,6\n*E\n"})
    public static final class DefaultImpls {
        @NotNull
        public static <R> SootClass getSootClass(@NotNull ISootMethodDecl<R> $this) {
            SootClass sootClass = $this.getSootMethod().getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
            return sootClass;
        }

        @NotNull
        public static <R> Integer getArgumentCnt(@NotNull ISootMethodDecl<R> $this) {
            return $this.getSootMethod().getParameterCount();
        }

        @NotNull
        public static <R> KFunctionType getActualType(@NotNull ISootMethodDecl<R> $this) {
            return UtilsKt.getFunctionType($this.getSootMethod());
        }

        @Nullable
        public static <R> VisibilityParameterAnnotationTag getParameterAnnotationTag(@NotNull ISootMethodDecl<R> $this) {
            return (VisibilityParameterAnnotationTag)$this.getSootMethod().getTag("VisibilityParameterAnnotationTag");
        }

        @Nullable
        public static <R> VisibilityAnnotationTag getVisibilityAnnotationTag(@NotNull ISootMethodDecl<R> $this, @NotNull IParameterT<?> $receiver) {
            Object object;
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            return $receiver.getIndex() >= 0 ? ((object = $this.getParameterAnnotationTag()) != null && (object = object.getVisibilityAnnotations()) != null ? (VisibilityAnnotationTag)((ArrayList)object).get($receiver.getIndex()) : null) : null;
        }

        @NotNull
        public static <R> List<AnnotationTag> getAnnotationTag(@NotNull ISootMethodDecl<R> $this, @NotNull IParameterT<?> $receiver) {
            Intrinsics.checkNotNullParameter($receiver, (String)"$receiver");
            Object object = $this.getVisibilityAnnotationTag($receiver);
            return object != null && (object = object.getAnnotations()) != null ? (List)object : CollectionsKt.emptyList();
        }

        @NotNull
        public static <R> List<Tag> getTags(@NotNull ISootMethodDecl<R> $this) {
            List list = $this.getSootMethod().getTags();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getTags(...)");
            return list;
        }

        @Nullable
        public static <R> AnnotationTag getAnnotationTag(@NotNull ISootMethodDecl<R> $this) {
            return (AnnotationTag)$this.getSootMethod().getTag("AnnotationTag");
        }

        @Nullable
        public static <R> VisibilityAnnotationTag getVisibilityAnnotationTag(@NotNull ISootMethodDecl<R> $this) {
            return UtilsKt.getVisibilityAnnotationTag($this.getSootMethod());
        }

        @NotNull
        public static <R> ISootMethodDecl<R> model(@NotNull ISootMethodDecl<R> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function2<? super CheckBuilder<R>, ? super IParameterT<Object>[], Unit> block) {
            Intrinsics.checkNotNullParameter(config, (String)"config");
            Intrinsics.checkNotNullParameter(block, (String)"block");
            int cnt = $this.getArgumentCnt();
            CheckBuilder<R> $this$tryApply$iv = $this.checkBuilder(config);
            boolean $i$f$tryApply = false;
            try {
                CheckBuilder<R> $this$model_u24lambda_u241 = $this$tryApply$iv;
                boolean bl = false;
                int n = 0;
                IParameterT[] iParameterTArray = new IParameterT[cnt];
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
            return $this;
        }

        public static /* synthetic */ ISootMethodDecl model$default(ISootMethodDecl iSootMethodDecl, Function1 function1, Function2 function2, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: model");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::model$lambda$0;
            }
            return iSootMethodDecl.model((Function1<MethodConfig, Unit>)function1, function2);
        }

        @NotNull
        public static <R> ISootMethodDecl<R> modelNoArg(@NotNull ISootMethodDecl<R> $this, @NotNull Function1<? super MethodConfig, Unit> config, @NotNull Function1<? super CheckBuilder<R>, Unit> block) {
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

        public static /* synthetic */ ISootMethodDecl modelNoArg$default(ISootMethodDecl iSootMethodDecl, Function1 function1, Function1 function12, int n, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modelNoArg");
            }
            if ((n & 1) != 0) {
                function1 = DefaultImpls::modelNoArg$lambda$2;
            }
            return iSootMethodDecl.modelNoArg((Function1<MethodConfig, Unit>)function1, function12);
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

