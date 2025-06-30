/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlinx.coroutines.CoroutineScope
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.cache.coroutines;

import com.feysh.corax.cache.coroutines.RecCoroutineCache;
import com.feysh.corax.cache.coroutines.RecCoroutineLoadingCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JS\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072)\u0010\b\u001a%\u0012\u0013\u0012\u0011H\u0005\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r0\tH&J\u00a2\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000f\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072)\u0010\b\u001a%\u0012\u0013\u0012\u0011H\u0005\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r0\t2H\u0010\u0010\u001aD\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000f\u0012\u0013\u0012\u0011H\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011\u00a2\u0006\u0002\b\u0014H&\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lcom/feysh/corax/cache/coroutines/FastCache;", "", "buildRecCoroutineCache", "Lcom/feysh/corax/cache/coroutines/RecCoroutineCache;", "K", "V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "weakKeyAssociateByValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "buildRecCoroutineLoadingCache", "Lcom/feysh/corax/cache/coroutines/RecCoroutineLoadingCache;", "mappingFunction", "Lkotlin/Function3;", "key", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Lcom/feysh/corax/cache/coroutines/RecCoroutineLoadingCache;", "corax-config-api"})
public interface FastCache {
    @NotNull
    public <K, V> RecCoroutineCache<K, V> buildRecCoroutineCache(@NotNull CoroutineScope var1, @NotNull Function1<? super V, Object[]> var2);

    @NotNull
    public <K, V> RecCoroutineLoadingCache<K, V> buildRecCoroutineLoadingCache(@NotNull CoroutineScope var1, @NotNull Function1<? super V, Object[]> var2, @NotNull Function3<? super RecCoroutineLoadingCache<K, V>, ? super K, ? super Continuation<? super V>, ? extends Object> var3);
}

