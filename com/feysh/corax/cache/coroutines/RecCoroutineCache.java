package com.feysh.corax.cache.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface RecCoroutineCache<K, V> extends CoroutineCache {
    @Nullable
    Object get(K key, 
              @NotNull Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> mappingFunction,
              @NotNull Continuation<? super Deferred<? extends V>> continuation);

    @Nullable
    Object getEntry(K key,
                   @NotNull Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> mappingFunction,
                   @NotNull Continuation<? super Deferred<? extends V>> continuation);

    @Nullable
    Object getPredSize(@NotNull Continuation<? super Integer> continuation);

    void cleanUp();

    boolean validateAfterFinished();
}