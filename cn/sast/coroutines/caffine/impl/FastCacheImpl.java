/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.coroutines.caffine.impl.FastCacheImpl
 *  cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl
 *  cn.sast.coroutines.caffine.impl.RecCoroutineLoadingCacheImpl
 *  com.feysh.corax.cache.coroutines.Configuration
 *  com.feysh.corax.cache.coroutines.FastCache
 *  com.feysh.corax.cache.coroutines.RecCoroutineCache
 *  com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache
 *  com.feysh.corax.cache.coroutines.XCache
 *  com.github.benmanes.caffeine.cache.stats.ConcurrentStatsCounter
 *  com.github.benmanes.caffeine.cache.stats.StatsCounter
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Deferred
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.coroutines.caffine.impl;

import cn.sast.coroutines.caffine.impl.RecCoroutineCacheImpl;
import cn.sast.coroutines.caffine.impl.RecCoroutineLoadingCacheImpl;
import com.feysh.corax.cache.coroutines.Configuration;
import com.feysh.corax.cache.coroutines.FastCache;
import com.feysh.corax.cache.coroutines.RecCoroutineCache;
import com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache;
import com.feysh.corax.cache.coroutines.XCache;
import com.github.benmanes.caffeine.cache.stats.ConcurrentStatsCounter;
import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u0002H\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\b0\u0007j\b\u0012\u0004\u0012\u0002H\b`\t0\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002JS\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\b0\r\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\b2\u0006\u0010\n\u001a\u00020\u000b2)\u0010\u000e\u001a%\u0012\u0013\u0012\u0011H\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130\u000fH\u0016J\u00a2\u0001\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\b0\u0016\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\b2\u0006\u0010\n\u001a\u00020\u000b2)\u0010\u000e\u001a%\u0012\u0013\u0012\u0011H\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130\u000f2H\u0010\u0017\u001aD\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\b0\u0016\u0012\u0013\u0012\u0011H\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0018\u00a2\u0006\u0002\b\u001bH\u0016\u00a2\u0006\u0002\u0010\u001c\u00a8\u0006\u001d"}, d2={"Lcn/sast/coroutines/caffine/impl/FastCacheImpl;", "Lcom/feysh/corax/cache/coroutines/FastCache;", "<init>", "()V", "newRecXCache", "Lcom/feysh/corax/cache/coroutines/XCache;", "K", "Lkotlinx/coroutines/Deferred;", "V", "Lcn/sast/coroutines/caffine/impl/CacheValue;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "buildRecCoroutineCache", "Lcom/feysh/corax/cache/coroutines/RecCoroutineCache;", "weakKeyAssociateByValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "", "buildRecCoroutineLoadingCache", "Lcom/feysh/corax/cache/coroutines/RecCoroutineLoadingCache;", "mappingFunction", "Lkotlin/Function3;", "key", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Lcom/feysh/corax/cache/coroutines/RecCoroutineLoadingCache;", "corax-api"})
public final class FastCacheImpl
implements FastCache {
    @NotNull
    public static final FastCacheImpl INSTANCE = new FastCacheImpl();

    private FastCacheImpl() {
    }

    private final <K, V> XCache<K, Deferred<V>> newRecXCache(CoroutineScope scope) {
        return XCache.Companion.cacheBuilder(arg_0 -> FastCacheImpl.newRecXCache$lambda$0(scope, arg_0));
    }

    @NotNull
    public <K, V> RecCoroutineCache<K, V> buildRecCoroutineCache(@NotNull CoroutineScope scope, @NotNull Function1<? super V, Object[]> weakKeyAssociateByValue) {
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        Intrinsics.checkNotNullParameter(weakKeyAssociateByValue, (String)"weakKeyAssociateByValue");
        XCache xCache = this.newRecXCache(scope);
        return (RecCoroutineCache)new RecCoroutineCacheImpl(xCache, xCache.build(), weakKeyAssociateByValue);
    }

    @NotNull
    public <K, V> RecCoroutineLoadingCache<K, V> buildRecCoroutineLoadingCache(@NotNull CoroutineScope scope, @NotNull Function1<? super V, Object[]> weakKeyAssociateByValue, @NotNull Function3<? super RecCoroutineLoadingCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> mappingFunction) {
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        Intrinsics.checkNotNullParameter(weakKeyAssociateByValue, (String)"weakKeyAssociateByValue");
        Intrinsics.checkNotNullParameter(mappingFunction, (String)"mappingFunction");
        XCache xCache = this.newRecXCache(scope);
        return (RecCoroutineLoadingCache)new RecCoroutineLoadingCacheImpl(xCache, xCache.build(), weakKeyAssociateByValue, mappingFunction);
    }

    private static final Unit newRecXCache$lambda$0(CoroutineScope $scope, Configuration $this$cacheBuilder) {
        Intrinsics.checkNotNullParameter((Object)$this$cacheBuilder, (String)"$this$cacheBuilder");
        $this$cacheBuilder.setScope($scope);
        $this$cacheBuilder.setWeakKeys(Boolean.valueOf(true));
        $this$cacheBuilder.setWeakValues(Boolean.valueOf(true));
        $this$cacheBuilder.setUseCallingContext(true);
        $this$cacheBuilder.setStatsCounter((StatsCounter)new ConcurrentStatsCounter());
        return Unit.INSTANCE;
    }
}

