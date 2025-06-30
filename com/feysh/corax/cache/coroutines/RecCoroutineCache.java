/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function3
 *  kotlinx.coroutines.Deferred
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.coroutines;

import com.feysh.corax.cache.coroutines.CoroutineCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003Jr\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005j\b\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u0007\u001a\u00028\u00002H\u0010\b\u001aD\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\t\u00a2\u0006\u0002\b\u000eH\u00a6@\u00a2\u0006\u0002\u0010\u000fJr\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005j\b\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u0007\u001a\u00028\u00002H\u0010\b\u001aD\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\t\u00a2\u0006\u0002\b\u000eH\u00a6@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0011\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&\u00a8\u0006\u0018"}, d2={"Lcom/feysh/corax/cache/coroutines/RecCoroutineCache;", "K", "V", "Lcom/feysh/corax/cache/coroutines/CoroutineCache;", "get", "Lkotlinx/coroutines/Deferred;", "Lcom/feysh/corax/cache/coroutines/RecRes;", "key", "mappingFunction", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntry", "getPredSize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanUp", "", "validateAfterFinished", "", "corax-config-api"})
public interface RecCoroutineCache<K, V>
extends CoroutineCache {
    @Nullable
    public Object get(K var1, @NotNull Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> var2, @NotNull Continuation<? super Deferred<? extends V>> var3);

    @Nullable
    public Object getEntry(K var1, @NotNull Function3<? super RecCoroutineCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> var2, @NotNull Continuation<? super Deferred<? extends V>> var3);

    @Nullable
    public Object getPredSize(@NotNull Continuation<? super Integer> var1);

    public void cleanUp();

    public boolean validateAfterFinished();
}

