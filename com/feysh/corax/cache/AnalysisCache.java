/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.Cache
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Dispatchers
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.tagkit.Host
 */
package com.feysh.corax.cache;

import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.XOptional;
import com.feysh.corax.cache.analysis.CompilationUnitOfSCFactory;
import com.feysh.corax.cache.analysis.CompilationUnitOfSCKey;
import com.feysh.corax.cache.analysis.SootHostExtInfoFactory;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootHostExtendKt;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J,\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b\u00a2\u0006\u0002\u0010\u0010J2\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\t\"\u000e\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00130\u0007H\u0016J\u0006\u0010\u0015\u001a\u00020\u0012R&\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lcom/feysh/corax/cache/AnalysisCache;", "", "<init>", "()V", "factoryMap", "", "Lcom/feysh/corax/cache/AnalysisDataFactory$Key;", "Lcom/feysh/corax/cache/AnalysisDataFactory;", "getAsync", "T", "key", "Lcom/feysh/corax/cache/AnalysisKey;", "ctx", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/feysh/corax/cache/AnalysisKey;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "(Lcom/feysh/corax/cache/AnalysisKey;)Ljava/lang/Object;", "registerFactory", "", "K", "factory", "clear", "Companion", "GlobalAnalysisCache", "G", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nAnalysisCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnalysisCache.kt\ncom/feysh/corax/cache/AnalysisCache\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,94:1\n216#2,2:95\n*S KotlinDebug\n*F\n+ 1 AnalysisCache.kt\ncom/feysh/corax/cache/AnalysisCache\n*L\n77#1:95,2\n*E\n"})
public class AnalysisCache {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Map<AnalysisDataFactory.Key<?>, AnalysisDataFactory<?, ?>> factoryMap = new LinkedHashMap();
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(AnalysisCache::logger$lambda$2);

    @Nullable
    public final <T> Object getAsync(@NotNull AnalysisKey<T> key2, @NotNull CoroutineContext ctx, @NotNull Continuation<? super T> $completion) {
        return BuildersKt.withContext((CoroutineContext)ctx, (Function2)new Function2<CoroutineScope, Continuation<? super T>, Object>(this, key2, null){
            int label;
            final /* synthetic */ AnalysisCache this$0;
            final /* synthetic */ AnalysisKey<T> $key;
            {
                this.this$0 = $receiver;
                this.$key = $key;
                super(2, $completion);
            }

            public final Object invokeSuspend(Object object) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        return this.this$0.get(this.$key);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super T> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, $completion);
    }

    public static /* synthetic */ Object getAsync$default(AnalysisCache analysisCache, AnalysisKey analysisKey, CoroutineContext coroutineContext, Continuation continuation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAsync");
        }
        if ((n & 2) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getDefault();
        }
        return analysisCache.getAsync(analysisKey, coroutineContext, continuation);
    }

    public final <T> T get(@NotNull AnalysisKey<T> key2) {
        Intrinsics.checkNotNullParameter(key2, (String)"key");
        AnalysisDataFactory<?, ?> analysisDataFactory = this.factoryMap.get(key2.getFactoryKey());
        AnalysisDataFactory<?, ?> analysisDataFactory2 = analysisDataFactory instanceof AnalysisDataFactory ? analysisDataFactory : null;
        if (analysisDataFactory2 == null) {
            throw new IllegalStateException(((Function0)() -> AnalysisCache.get$lambda$0(key2)).toString());
        }
        AnalysisDataFactory<?, ?> factory = analysisDataFactory2;
        return ((XOptional)factory.getCache().get(key2)).getValue();
    }

    public <T, K extends AnalysisKey<T>> void registerFactory(@NotNull AnalysisDataFactory<T, K> factory) {
        Intrinsics.checkNotNullParameter(factory, (String)"factory");
        this.factoryMap.put(factory.getKey(), factory);
    }

    public final void clear() {
        Map<AnalysisDataFactory.Key<?>, AnalysisDataFactory<?, ?>> $this$forEach$iv = this.factoryMap;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<AnalysisDataFactory.Key<?>, AnalysisDataFactory<?, ?>>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<AnalysisDataFactory.Key<?>, AnalysisDataFactory<?, ?>> element$iv;
            Map.Entry<AnalysisDataFactory.Key<?>, AnalysisDataFactory<?, ?>> entry = element$iv = iterator.next();
            boolean bl = false;
            AnalysisDataFactory<?, ?> u = entry.getValue();
            u.getCache().cleanUp();
        }
    }

    private static final String get$lambda$0(AnalysisKey $key) {
        return "Did you forget to call registerFactory(" + $key.getFactoryKey() + ")?";
    }

    private static final Unit logger$lambda$2() {
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lcom/feysh/corax/cache/AnalysisCache$Companion;", "", "<init>", "()V", "logger", "Lmu/KLogger;", "corax-config-api"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lcom/feysh/corax/cache/AnalysisCache$G;", "Lcom/feysh/corax/cache/AnalysisCache$GlobalAnalysisCache;", "<init>", "()V", "corax-config-api"})
    public static final class G
    extends GlobalAnalysisCache {
        @NotNull
        public static final G INSTANCE = new G();

        private G() {
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRS\u0010\u001a\u001aB\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c \u001d* \u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c\u0018\u00010\u001b0\u001b\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006!"}, d2={"Lcom/feysh/corax/cache/AnalysisCache$GlobalAnalysisCache;", "Lcom/feysh/corax/cache/AnalysisCache;", "<init>", "()V", "compilationUnitOfSCFactory", "Lcom/feysh/corax/cache/analysis/CompilationUnitOfSCFactory;", "getCompilationUnitOfSCFactory", "()Lcom/feysh/corax/cache/analysis/CompilationUnitOfSCFactory;", "setCompilationUnitOfSCFactory", "(Lcom/feysh/corax/cache/analysis/CompilationUnitOfSCFactory;)V", "sootHostExtInfoFactory", "Lcom/feysh/corax/cache/analysis/SootHostExtInfoFactory;", "getSootHostExtInfoFactory", "()Lcom/feysh/corax/cache/analysis/SootHostExtInfoFactory;", "setSootHostExtInfoFactory", "(Lcom/feysh/corax/cache/analysis/SootHostExtInfoFactory;)V", "class2CompilationUnit", "Lcom/feysh/corax/cache/analysis/CompilationUnitOfSCKey;", "sc", "Lsoot/SootClass;", "class2SourceFile", "Ljava/nio/file/Path;", "sootHost2decl", "Lcom/feysh/corax/cache/analysis/SootHostExtend;", "host", "Lsoot/tagkit/Host;", "analysisCache", "Lcom/github/benmanes/caffeine/cache/Cache;", "", "kotlin.jvm.PlatformType", "getAnalysisCache", "()Lcom/github/benmanes/caffeine/cache/Cache;", "Lcom/github/benmanes/caffeine/cache/Cache;", "corax-config-api"})
    public static class GlobalAnalysisCache
    extends AnalysisCache {
        public CompilationUnitOfSCFactory compilationUnitOfSCFactory;
        public SootHostExtInfoFactory sootHostExtInfoFactory;
        private final Cache<Object, Object> analysisCache = Caffeine.newBuilder().build();

        @NotNull
        public CompilationUnitOfSCFactory getCompilationUnitOfSCFactory() {
            CompilationUnitOfSCFactory compilationUnitOfSCFactory = this.compilationUnitOfSCFactory;
            if (compilationUnitOfSCFactory != null) {
                return compilationUnitOfSCFactory;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"compilationUnitOfSCFactory");
            return null;
        }

        public void setCompilationUnitOfSCFactory(@NotNull CompilationUnitOfSCFactory compilationUnitOfSCFactory) {
            Intrinsics.checkNotNullParameter((Object)compilationUnitOfSCFactory, (String)"<set-?>");
            this.compilationUnitOfSCFactory = compilationUnitOfSCFactory;
        }

        @NotNull
        public SootHostExtInfoFactory getSootHostExtInfoFactory() {
            SootHostExtInfoFactory sootHostExtInfoFactory = this.sootHostExtInfoFactory;
            if (sootHostExtInfoFactory != null) {
                return sootHostExtInfoFactory;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"sootHostExtInfoFactory");
            return null;
        }

        public void setSootHostExtInfoFactory(@NotNull SootHostExtInfoFactory sootHostExtInfoFactory) {
            Intrinsics.checkNotNullParameter((Object)sootHostExtInfoFactory, (String)"<set-?>");
            this.sootHostExtInfoFactory = sootHostExtInfoFactory;
        }

        @NotNull
        public final CompilationUnitOfSCKey class2CompilationUnit(@NotNull SootClass sc) {
            Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
            return new CompilationUnitOfSCKey(sc, this.getCompilationUnitOfSCFactory().getKey());
        }

        @Nullable
        public final Path class2SourceFile(@NotNull SootClass sc) {
            Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
            return (Path)this.getCompilationUnitOfSCFactory().getLocator().invoke((Object)sc);
        }

        @Nullable
        public final SootHostExtend sootHost2decl(@NotNull Host host) {
            Intrinsics.checkNotNullParameter((Object)host, (String)"host");
            return SootHostExtendKt.ext(host, G.INSTANCE, this.getSootHostExtInfoFactory().getKey());
        }

        public final Cache<Object, Object> getAnalysisCache() {
            return this.analysisCache;
        }
    }
}

