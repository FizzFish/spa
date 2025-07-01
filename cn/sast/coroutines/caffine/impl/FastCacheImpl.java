package cn.sast.coroutines.caffine.impl;

import com.feysh.corax.cache.coroutines.Configuration;
import com.feysh.corax.cache.coroutines.FastCache;
import com.feysh.corax.cache.coroutines.RecCoroutineCache;
import com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache;
import com.feysh.corax.cache.coroutines.XCache;
import com.github.benmanes.caffeine.cache.stats.ConcurrentStatsCounter;
import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import java.util.function.Function;
import java.util.function.BiFunction;

public final class FastCacheImpl implements FastCache {
    public static final FastCacheImpl INSTANCE = new FastCacheImpl();

    private FastCacheImpl() {
    }

    private <K, V> XCache<K, Deferred<V>> newRecXCache(CoroutineScope scope) {
        return XCache.Companion.cacheBuilder(config -> configureCache(scope, config));
    }

    @NotNull
    @Override
    public <K, V> RecCoroutineCache<K, V> buildRecCoroutineCache(
            @NotNull CoroutineScope scope,
            @NotNull Function<V, Object[]> weakKeyAssociateByValue) {
        if (scope == null) throw new NullPointerException("scope");
        if (weakKeyAssociateByValue == null) throw new NullPointerException("weakKeyAssociateByValue");
        
        XCache<K, Deferred<V>> xCache = newRecXCache(scope);
        return new RecCoroutineCacheImpl<>(xCache, xCache.build(), weakKeyAssociateByValue);
    }

    @NotNull
    @Override
    public <K, V> RecCoroutineLoadingCache<K, V> buildRecCoroutineLoadingCache(
            @NotNull CoroutineScope scope,
            @NotNull Function<V, Object[]> weakKeyAssociateByValue,
            @NotNull BiFunction<RecCoroutineLoadingCache<K, V>, K, Deferred<V>> mappingFunction) {
        if (scope == null) throw new NullPointerException("scope");
        if (weakKeyAssociateByValue == null) throw new NullPointerException("weakKeyAssociateByValue");
        if (mappingFunction == null) throw new NullPointerException("mappingFunction");
        
        XCache<K, Deferred<V>> xCache = newRecXCache(scope);
        return new RecCoroutineLoadingCacheImpl<>(xCache, xCache.build(), weakKeyAssociateByValue, mappingFunction);
    }

    private static void configureCache(CoroutineScope scope, Configuration config) {
        if (config == null) throw new NullPointerException("config");
        
        config.setScope(scope);
        config.setWeakKeys(true);
        config.setWeakValues(true);
        config.setUseCallingContext(true);
        config.setStatsCounter(new ConcurrentStatsCounter());
    }
}
