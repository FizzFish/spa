/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl
 *  cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl$Companion
 *  cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl$EntryRecID
 *  cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl$RecID
 *  cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl$RecursiveContext
 *  cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl$get$1
 *  cn.sast.coroutines.caffine.impl.WeakEntryHolder
 *  cn.sast.graph.NoBackEdgeDirectGraph
 *  com.feysh.corax.cache.coroutines.RecCoroutineCache
 *  com.feysh.corax.cache.coroutines.XCache
 *  com.github.benmanes.caffeine.cache.Cache
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.Interner
 *  com.github.benmanes.caffeine.cache.stats.CacheStats
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineStart
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.JobKt
 *  kotlinx.coroutines.YieldKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.coroutines.caffine.impl;

import cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl;
import cn.sast.coroutines.caffine.impl.WeakEntryHolder;
import cn.sast.graph.NoBackEdgeDirectGraph;
import com.feysh.corax.cache.coroutines.RecCoroutineCache;
import com.feysh.corax.cache.coroutines.XCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Interner;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.YieldKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000 B*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0004?@ABBz\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00070\u0005\u0012\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00070\t\u0012)\u0010\n\u001a%\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\f\u0010$\u001a\u00020\u0010*\u00020%H\u0002Jr\u0010(\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`)2\u0006\u0010*\u001a\u00028\u00002H\u0010+\u001aD\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(*\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010-\u0012\u0006\u0012\u0004\u0018\u00010\u00100,\u00a2\u0006\u0002\b.H\u0096@\u00a2\u0006\u0002\u0010/J\u0081\u0001\u0010(\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`)2\u0006\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u0002022\u0006\u0010*\u001a\u00028\u00002H\u0010+\u001aD\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(*\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010-\u0012\u0006\u0012\u0004\u0018\u00010\u00100,\u00a2\u0006\u0002\b.H\u0002\u00a2\u0006\u0002\u00103Jr\u00104\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`)2\u0006\u0010*\u001a\u00028\u00002H\u0010+\u001aD\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(*\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010-\u0012\u0006\u0012\u0004\u0018\u00010\u00100,\u00a2\u0006\u0002\b.H\u0096@\u00a2\u0006\u0002\u0010/J\b\u00105\u001a\u000206H\u0016J\b\u0010;\u001a\u00020<H\u0016J\u000e\u0010=\u001a\u00020'H\u0096@\u00a2\u0006\u0002\u0010>R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R1\u0010\n\u001a%\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dX\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0002088VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:\u00a8\u0006C"}, d2={"Lcn/sast/coroutines/caffine/impl/RecCoroutineCacheImpl;", "K", "V", "Lcom/feysh/corax/cache/coroutines/RecCoroutineCache;", "xCache", "Lcom/feysh/corax/cache/coroutines/XCache;", "Lkotlinx/coroutines/Deferred;", "Lcn/sast/coroutines/caffine/impl/CacheValue;", "cache", "Lcom/github/benmanes/caffeine/cache/Cache;", "weakKeyAssociateByValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "", "<init>", "(Lcom/feysh/corax/cache/coroutines/XCache;Lcom/github/benmanes/caffeine/cache/Cache;Lkotlin/jvm/functions/Function1;)V", "lruCache", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "cacheStats", "Lcom/github/benmanes/caffeine/cache/stats/CacheStats;", "getCacheStats", "()Lcom/github/benmanes/caffeine/cache/stats/CacheStats;", "interner", "Lcom/github/benmanes/caffeine/cache/Interner;", "getInterner$annotations", "()V", "noBackEdgeDirectGraph", "Lcn/sast/graph/NoBackEdgeDirectGraph;", "weakHolder", "Lcn/sast/coroutines/caffine/impl/WeakEntryHolder;", "recursiveId", "Lkotlin/coroutines/CoroutineContext;", "_x", "", "get", "Lcom/feysh/corax/cache/coroutines/RecRes;", "key", "mappingFunction", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "src", "parentJob", "Lkotlinx/coroutines/Job;", "(Ljava/lang/Object;Lkotlinx/coroutines/Job;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/Deferred;", "getEntry", "validateAfterFinished", "", "size", "", "getSize", "()J", "cleanUp", "", "getPredSize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RecursiveContext", "RecID", "EntryRecID", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nRecCoroutineCacheImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecCoroutineCacheImpl.kt\ncn/sast/coroutines/caffine/impl/RecCoroutineCacheImpl\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,181:1\n326#2:182\n*S KotlinDebug\n*F\n+ 1 RecCoroutineCacheImpl.kt\ncn/sast/coroutines/caffine/impl/RecCoroutineCacheImpl\n*L\n154#1:182\n*E\n"})
public class RecCoroutineCacheImpl<K, V>
implements RecCoroutineCache<K, V> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final XCache<K, Deferred<V>> xCache;
    @NotNull
    private final Cache<K, Deferred<V>> cache;
    @NotNull
    private final Function1<V, Object[]> weakKeyAssociateByValue;
    @NotNull
    private final Cache<K, Deferred<V>> lruCache;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final Interner<K> interner;
    @NotNull
    private final NoBackEdgeDirectGraph<Object> noBackEdgeDirectGraph;
    @NotNull
    private final WeakEntryHolder<K, Object> weakHolder;
    private int _x;
    @NotNull
    private static KLogger logger = KotlinLogging.INSTANCE.logger(RecCoroutineCacheImpl::logger$lambda$4);

    public RecCoroutineCacheImpl(@NotNull XCache<K, Deferred<V>> xCache, @NotNull Cache<K, Deferred<V>> cache2, @NotNull Function1<? super V, Object[]> weakKeyAssociateByValue) {
        Intrinsics.checkNotNullParameter(xCache, (String)"xCache");
        Intrinsics.checkNotNullParameter(cache2, (String)"cache");
        Intrinsics.checkNotNullParameter(weakKeyAssociateByValue, (String)"weakKeyAssociateByValue");
        this.xCache = xCache;
        this.cache = cache2;
        this.weakKeyAssociateByValue = weakKeyAssociateByValue;
        Caffeine caffeine = Caffeine.newBuilder();
        this.lruCache = caffeine.initialCapacity(2000).maximumSize(10000L).build();
        this.scope = (CoroutineScope)this.xCache.getDefaultScope().getValue();
        Interner interner = Interner.newWeakInterner();
        Intrinsics.checkNotNullExpressionValue((Object)interner, (String)"newWeakInterner(...)");
        this.interner = interner;
        this.noBackEdgeDirectGraph = new NoBackEdgeDirectGraph();
        this.weakHolder = new WeakEntryHolder();
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
    }

    @NotNull
    public CacheStats getCacheStats() {
        CacheStats cacheStats = this.cache.stats();
        Intrinsics.checkNotNullExpressionValue((Object)cacheStats, (String)"stats(...)");
        return cacheStats;
    }

    private static /* synthetic */ void getInterner$annotations() {
    }

    private final Object recursiveId(CoroutineContext $this$recursiveId) {
        Object object = (RecursiveContext)$this$recursiveId.get((CoroutineContext.Key)RecursiveContext.Key);
        if (object == null || (object = object.getId()) == null) {
            throw new IllegalStateException("current coroutine context has no RecursiveContext".toString());
        }
        return object;
    }

    @Nullable
    public Object get(K key2, @NotNull Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> mappingFunction, @NotNull Continuation<? super Deferred<? extends V>> $completion) {
        return RecCoroutineCacheImpl.get$suspendImpl((RecCoroutineCacheImpl)this, key2, mappingFunction, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ <K, V> Object get$suspendImpl(RecCoroutineCacheImpl<K, V> var0, K var1_1, Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> var2_2, Continuation<? super Deferred<? extends V>> $completion) {
        if (!($completion instanceof get.1)) ** GOTO lbl-1000
        var8_4 = $completion;
        if ((var8_4.label & -2147483648) != 0) {
            var8_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var9_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                ctx = $continuation.getContext();
                parentJob = JobKt.getJob((CoroutineContext)ctx);
                src = super.recursiveId(ctx);
                $continuation.L$0 = $this;
                $continuation.L$1 = key;
                $continuation.L$2 = mappingFunction;
                $continuation.L$3 = parentJob;
                $continuation.L$4 = src;
                $continuation.label = 1;
                v0 = YieldKt.yield((Continuation)$continuation);
                if (v0 == var9_6) {
                    return var9_6;
                }
                ** GOTO lbl33
            }
            case 1: {
                src = $continuation.L$4;
                parentJob = (Job)$continuation.L$3;
                mappingFunction = (Function3)$continuation.L$2;
                key = $continuation.L$1;
                $this = (RecCoroutineCacheImpl)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl33:
                // 2 sources

                return $this.get(src, parentJob, key, mappingFunction);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private final Deferred<V> get(Object src, Job parentJob, K key2, Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> mappingFunction) {
        Function1 function1;
        Deferred ignore;
        Object canonicalKey = this.interner.intern(key2);
        Ref.BooleanRef mapped = new Ref.BooleanRef();
        Function1 mapping2 = arg_0 -> RecCoroutineCacheImpl.get$lambda$0(mapped, this, src, parentJob, mappingFunction, arg_0);
        Ref.ObjectRef deferred = new Ref.ObjectRef();
        Function1 function12 = mapping2;
        deferred.element = this.cache.get(canonicalKey, (Function)new /* Unavailable Anonymous Inner Class!! */);
        if (((Deferred)deferred.element).isCancelled() && !parentJob.isCancelled()) {
            ignore = (Deferred)this.cache.asMap().remove(canonicalKey);
            mapped.element = false;
            function1 = mapping2;
            deferred.element = this.cache.get(canonicalKey, (Function)new /* Unavailable Anonymous Inner Class!! */);
        }
        function1 = arg_0 -> RecCoroutineCacheImpl.get$lambda$1(deferred, arg_0);
        ignore = (Deferred)this.lruCache.get(canonicalKey, (Function)new /* Unavailable Anonymous Inner Class!! */);
        Object object = deferred.element;
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.CoroutineScope");
        Object tgt = this.recursiveId(((CoroutineScope)object).getCoroutineContext());
        if (!mapped.element) {
            if (((Job)deferred.element).isCompleted()) {
                return (Deferred)deferred.element;
            }
            if (!this.noBackEdgeDirectGraph.addEdgeSynchronized(src, tgt)) {
                return null;
            }
        }
        Function1 completionHandler = arg_0 -> RecCoroutineCacheImpl.get$lambda$2(this, deferred, canonicalKey, src, tgt, arg_0);
        ((Job)deferred.element).invokeOnCompletion(completionHandler);
        return (Deferred)deferred.element;
    }

    @Nullable
    public Object getEntry(K key2, @NotNull Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> mappingFunction, @NotNull Continuation<? super Deferred<? extends V>> $completion) {
        return RecCoroutineCacheImpl.getEntry$suspendImpl((RecCoroutineCacheImpl)this, key2, mappingFunction, $completion);
    }

    static /* synthetic */ <K, V> Object getEntry$suspendImpl(RecCoroutineCacheImpl<K, V> $this, K key2, Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> mappingFunction, Continuation<? super Deferred<? extends V>> $completion) {
        return super.get((Object)new EntryRecID(), JobKt.getJob((CoroutineContext)$completion.getContext()), key2, mappingFunction);
    }

    public boolean validateAfterFinished() {
        if (!this.noBackEdgeDirectGraph.isComplete()) {
            logger.error(() -> RecCoroutineCacheImpl.validateAfterFinished$lambda$3(this));
            return false;
        }
        return true;
    }

    public long getSize() {
        return this.cache.estimatedSize();
    }

    public void cleanUp() {
        this.cache.cleanUp();
        this.noBackEdgeDirectGraph.cleanUp();
        this.weakHolder.clean();
        this.lruCache.cleanUp();
    }

    @Nullable
    public Object getPredSize(@NotNull Continuation<? super Integer> $completion) {
        return RecCoroutineCacheImpl.getPredSize$suspendImpl((RecCoroutineCacheImpl)this, $completion);
    }

    static /* synthetic */ <K, V> Object getPredSize$suspendImpl(RecCoroutineCacheImpl<K, V> $this, Continuation<? super Integer> $completion) {
        boolean $i$f$currentCoroutineContext = false;
        Object src = super.recursiveId($completion.getContext());
        return Boxing.boxInt((int)$this.noBackEdgeDirectGraph.getPredSize(src));
    }

    private static final Deferred get$lambda$0(Ref.BooleanRef $mapped, RecCoroutineCacheImpl this$0, Object $src, Job $parentJob, Function3 $mappingFunction, Object k) {
        if (!(!$mapped.element)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        $mapped.element = true;
        RecID id = new RecID();
        if (!this$0.noBackEdgeDirectGraph.addEdgeSynchronized($src, (Object)id)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        return BuildersKt.async((CoroutineScope)this$0.scope, (CoroutineContext)new RecursiveContext((Object)id).plus((CoroutineContext)$parentJob), (CoroutineStart)CoroutineStart.DEFAULT, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    private static final Deferred get$lambda$1(Ref.ObjectRef $deferred, Object it) {
        return (Deferred)$deferred.element;
    }

    private static final Unit get$lambda$2(RecCoroutineCacheImpl this$0, Ref.ObjectRef $deferred, Object $canonicalKey, Object $src, Object $tgt, Throwable cause) {
        this$0._x += System.identityHashCode($deferred.element) + System.identityHashCode($canonicalKey);
        this$0.noBackEdgeDirectGraph.removeEdgeSynchronized($src, $tgt);
        return Unit.INSTANCE;
    }

    private static final Object validateAfterFinished$lambda$3(RecCoroutineCacheImpl this$0) {
        return this$0.noBackEdgeDirectGraph + " is not complete";
    }

    private static final Unit logger$lambda$4() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$recursiveId(RecCoroutineCacheImpl $this, CoroutineContext $receiver) {
        return $this.recursiveId($receiver);
    }

    public static final /* synthetic */ Function1 access$getWeakKeyAssociateByValue$p(RecCoroutineCacheImpl $this) {
        return $this.weakKeyAssociateByValue;
    }

    public static final /* synthetic */ WeakEntryHolder access$getWeakHolder$p(RecCoroutineCacheImpl $this) {
        return $this.weakHolder;
    }
}

