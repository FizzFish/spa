package com.feysh.corax.cache.coroutines;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.future.FutureKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LoadingCache<K, V> {
    private final CoroutineScope defaultScope;
    private final boolean useCallingContext;
    private final AsyncLoadingCache<K, V> cache;

    public LoadingCache(@NotNull CoroutineScope defaultScope, boolean useCallingContext, @NotNull AsyncLoadingCache<K, V> cache) {
        this.defaultScope = defaultScope;
        this.useCallingContext = useCallingContext;
        this.cache = cache;
    }

    @NotNull
    public final AsyncLoadingCache<K, V> underlying() {
        return cache;
    }

    @Nullable
    public final Object contains(K key, @NotNull Continuation<? super Boolean> $completion) {
        CompletableFuture<V> future = cache.getIfPresent(key);
        if (future != null) {
            Object result = FutureKt.await(future, $completion);
            return result != IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result != null : result;
        }
        return false;
    }

    @Nullable
    public final Object getIfPresent(K key, @NotNull Continuation<? super V> $completion) {
        CompletableFuture<V> future = cache.getIfPresent(key);
        return future != null ? FutureKt.await(future, $completion) : null;
    }

    @Nullable
    public final Object get(K key, @NotNull Continuation<? super V> $completion) {
        CompletableFuture<V> future = cache.get(key);
        return FutureKt.await(future, $completion);
    }

    @Nullable
    public final Object getAsync(K key, @NotNull Continuation<? super CompletableFuture<V>> $completion) {
        return cache.get(key);
    }

    @Nullable
    public final Object getAll(@NotNull Collection<? extends K> keys, @NotNull Continuation<? super Map<K, ? extends V>> $completion) {
        CompletableFuture<Map<K, V>> future = cache.getAll(keys);
        return FutureKt.await(future, $completion);
    }

    @Nullable
    public final Object getAll(@NotNull Collection<? extends K> keys, 
                             @NotNull Function2<? super Set<? extends K>, ? super Continuation<? super Map<K, ? extends V>>, ? extends Object> compute,
                             @NotNull Continuation<? super Map<K, ? extends V>> $completion) {
        CoroutineScope scope = useCallingContext ? CoroutineScopeKt.CoroutineScope($completion.getContext()) : defaultScope;
        BiFunction<Set<? extends K>, Executor, CompletableFuture<Map<K, V>>> mappingFunction = 
            (k, executor) -> FutureKt.asCompletableFuture(
                BuildersKt.async$default(scope, null, null, 
                    (scope2, continuation) -> compute.invoke(CollectionsKt.toSet(k), continuation), 3, null));
        CompletableFuture<Map<K, V>> future = cache.getAll(keys, mappingFunction);
        return FutureKt.await(future, $completion);
    }

    @Nullable
    public final Object get(K key, 
                          @NotNull Function2<? super K, ? super Continuation<? super V>, ? extends Object> compute,
                          @NotNull Continuation<? super V> $completion) {
        CoroutineScope scope = useCallingContext ? CoroutineScopeKt.CoroutineScope($completion.getContext()) : defaultScope;
        BiFunction<K, Executor, CompletableFuture<V>> mappingFunction = 
            (k, executor) -> FutureKt.asCompletableFuture(
                BuildersKt.async$default(scope, null, null, 
                    (scope2, continuation) -> compute.invoke(k, continuation), 3, null));
        CompletableFuture<V> future = cache.get(key, mappingFunction);
        return FutureKt.await(future, $completion);
    }

    @Nullable
    public final Object getOrNull(K key, 
                                @NotNull Function2<? super K, ? super Continuation<? super V>, ? extends Object> compute,
                                @NotNull Continuation<? super V> $completion) {
        return get(key, compute, $completion);
    }

    @Deprecated(message="Use get", replaceWith=@ReplaceWith(expression="get(key, compute)", imports={}))
    @Nullable
    public final Object getOrPut(K key, 
                               @NotNull Function2<? super K, ? super Continuation<? super V>, ? extends Object> compute,
                               @NotNull Continuation<? super V> $completion) {
        return get(key, compute, $completion);
    }

    @Nullable
    public final Object put(K key, 
                          @NotNull Function1<? super Continuation<? super V>, ? extends Object> compute,
                          @NotNull Continuation<? super Unit> $completion) {
        CoroutineScope scope = useCallingContext ? CoroutineScopeKt.CoroutineScope($completion.getContext()) : defaultScope;
        CompletableFuture<V> future = FutureKt.asCompletableFuture(
            BuildersKt.async$default(scope, null, null, 
                (scope2, continuation) -> compute.invoke(continuation), 3, null));
        cache.put(key, future);
        return Unit.INSTANCE;
    }

    public final void put(K key, V value) {
        cache.put(key, CompletableFuture.completedFuture(value));
    }

    public final void set(K key, V value) {
        put(key, value);
    }

    @Nullable
    public final Object asMap(@NotNull Continuation<? super Map<K, ? extends V>> $completion) {
        ConcurrentMap<K, CompletableFuture<V>> map = cache.asMap();
        Map<K, V> result = new LinkedHashMap<>(map.size());
        for (Map.Entry<K, CompletableFuture<V>> entry : map.entrySet()) {
            Object value = FutureKt.await(entry.getValue(), $completion);
            if (value == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            result.put(entry.getKey(), (V) value);
        }
        return result;
    }

    @NotNull
    public final Map<K, Deferred<V>> asDeferredMap() {
        ConcurrentMap<K, CompletableFuture<V>> map = cache.asMap();
        Map<K, Deferred<V>> result = new LinkedHashMap<>(map.size());
        for (Map.Entry<K, CompletableFuture<V>> entry : map.entrySet()) {
            result.put(entry.getKey(), FutureKt.asDeferred(entry.getValue()));
        }
        return result;
    }

    public final void invalidate(K key) {
        cache.synchronous().invalidate(key);
    }

    public final void invalidateAll() {
        cache.synchronous().invalidateAll();
    }

    private Object scope(Continuation<? super CoroutineScope> $completion) {
        return useCallingContext ? CoroutineScopeKt.CoroutineScope($completion.getContext()) : defaultScope;
    }
}
