package cn.sast.coroutines.caffine.impl;

import com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache;
import com.feysh.corax.cache.coroutines.XCache;
import com.github.benmanes.caffeine.cache.Cache;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.function.Function;
import java.util.function.BiFunction;

public final class RecCoroutineLoadingCacheImpl<K, V> extends RecCoroutineCacheImpl<K, V> implements RecCoroutineLoadingCache<K, V> {
    @NotNull
    private final BiFunction<RecCoroutineLoadingCache<K, V>, K, V> mappingFunction;

    public RecCoroutineLoadingCacheImpl(
            @NotNull XCache<K, Deferred<V>> xCache,
            @NotNull Cache<K, Deferred<V>> cache,
            @NotNull Function<V, Object[]> weakKeyAssociateBy,
            @NotNull BiFunction<RecCoroutineLoadingCache<K, V>, K, V> mappingFunction) {
        super(xCache, cache, weakKeyAssociateBy);
        this.mappingFunction = mappingFunction;
    }

    @Nullable
    public Deferred<V> get(K key) {
        return getEntry(key);
    }

    @Nullable
    public Deferred<V> getEntry(K key) {
        V value = mappingFunction.apply(this, key);
        return value != null ? Deferred.completed(value) : null;
    }
}