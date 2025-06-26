/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl
 *  cn.sast.coroutines.caffine.impl.RecCoroutineLoadingCacheImpl
 *  com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache
 *  com.feysh.corax.cache.coroutines.XCache
 *  com.github.benmanes.caffeine.cache.Cache
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.Deferred
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.coroutines.caffine.impl;

import cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl;
import com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache;
import com.feysh.corax.cache.coroutines.XCache;
import com.github.benmanes.caffeine.cache.Cache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u00c4\u0001\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\b0\u0006\u0012\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\b0\n\u0012)\u0010\u000b\u001a%\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\f\u0012H\u0010\u0012\u001aD\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013\u00a2\u0006\u0002\b\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u001b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0096@\u00a2\u0006\u0002\u0010\u001cJ(\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u001b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0096@\u00a2\u0006\u0002\u0010\u001cRR\u0010\u0012\u001aD\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013\u00a2\u0006\u0002\b\u0016X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019\u00a8\u0006\u001e"}, d2={"Lcn/sast/coroutines/caffine/impl/RecCoroutineLoadingCacheImpl;", "K", "V", "Lcn/sast/coroutines/caffine/impl/RecCoroutineCacheImpl;", "Lcom/feysh/corax/cache/coroutines/RecCoroutineLoadingCache;", "xCache", "Lcom/feysh/corax/cache/coroutines/XCache;", "Lkotlinx/coroutines/Deferred;", "Lcn/sast/coroutines/caffine/impl/CacheValue;", "cache", "Lcom/github/benmanes/caffeine/cache/Cache;", "weakKeyAssociateBy", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "", "mappingFunction", "Lkotlin/Function3;", "key", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lcom/feysh/corax/cache/coroutines/XCache;Lcom/github/benmanes/caffeine/cache/Cache;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "get", "Lcom/feysh/corax/cache/coroutines/RecRes;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntry", "corax-api"})
public final class RecCoroutineLoadingCacheImpl<K, V>
extends RecCoroutineCacheImpl<K, V>
implements RecCoroutineLoadingCache<K, V> {
    @NotNull
    private final Function3<RecCoroutineLoadingCache<K, V>, K, Continuation<? super V>, Object> mappingFunction;

    public RecCoroutineLoadingCacheImpl(@NotNull XCache<K, Deferred<V>> xCache, @NotNull Cache<K, Deferred<V>> cache2, @NotNull Function1<? super V, Object[]> weakKeyAssociateBy, @NotNull Function3<? super RecCoroutineLoadingCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> mappingFunction) {
        Intrinsics.checkNotNullParameter(xCache, (String)"xCache");
        Intrinsics.checkNotNullParameter(cache2, (String)"cache");
        Intrinsics.checkNotNullParameter(weakKeyAssociateBy, (String)"weakKeyAssociateBy");
        Intrinsics.checkNotNullParameter(mappingFunction, (String)"mappingFunction");
        super(xCache, cache2, weakKeyAssociateBy);
        this.mappingFunction = mappingFunction;
    }

    @Nullable
    public Object get(K key2, @NotNull Continuation<? super Deferred<? extends V>> $completion) {
        return this.get(key2, (Function3)new /* Unavailable Anonymous Inner Class!! */, $completion);
    }

    @Nullable
    public Object getEntry(K key2, @NotNull Continuation<? super Deferred<? extends V>> $completion) {
        return this.getEntry(key2, (Function3)new /* Unavailable Anonymous Inner Class!! */, $completion);
    }

    public static final /* synthetic */ Function3 access$getMappingFunction$p(RecCoroutineLoadingCacheImpl $this) {
        return $this.mappingFunction;
    }
}

