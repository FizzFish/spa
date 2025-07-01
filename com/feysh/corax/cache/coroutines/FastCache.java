package com.feysh.corax.cache.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

public interface FastCache {
    @NotNull
    <K, V> RecCoroutineCache<K, V> buildRecCoroutineCache(
        @NotNull CoroutineScope scope,
        @NotNull Function1<? super V, Object[]> weakKeyAssociateByValue
    );

    @NotNull
    <K, V> RecCoroutineLoadingCache<K, V> buildRecCoroutineLoadingCache(
        @NotNull CoroutineScope scope,
        @NotNull Function1<? super V, Object[]> weakKeyAssociateByValue,
        @NotNull Function3<? super RecCoroutineLoadingCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> mappingFunction
    );
}