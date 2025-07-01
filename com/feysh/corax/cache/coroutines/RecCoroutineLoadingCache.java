package com.feysh.corax.cache.coroutines;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface RecCoroutineLoadingCache<K, V> extends RecCoroutineCache<K, V> {
    @Nullable
    Object get(K key, @NotNull Continuation<? super Deferred<? extends V>> continuation);

    @Nullable
    Object getEntry(K key, @NotNull Continuation<? super Deferred<? extends V>> continuation);
}