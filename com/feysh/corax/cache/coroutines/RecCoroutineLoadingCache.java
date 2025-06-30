/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlinx.coroutines.Deferred
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.coroutines;

import com.feysh.corax.cache.coroutines.RecCoroutineCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003J(\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005j\b\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u00a6@\u00a2\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005j\b\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/cache/coroutines/RecCoroutineLoadingCache;", "K", "V", "Lcom/feysh/corax/cache/coroutines/RecCoroutineCache;", "get", "Lkotlinx/coroutines/Deferred;", "Lcom/feysh/corax/cache/coroutines/RecRes;", "key", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntry", "corax-config-api"})
public interface RecCoroutineLoadingCache<K, V>
extends RecCoroutineCache<K, V> {
    @Nullable
    public Object get(K var1, @NotNull Continuation<? super Deferred<? extends V>> var2);

    @Nullable
    public Object getEntry(K var1, @NotNull Continuation<? super Deferred<? extends V>> var2);
}

