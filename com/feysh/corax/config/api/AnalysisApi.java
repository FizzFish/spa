/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlinx.coroutines.CoroutineScope
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.cache.coroutines.FastCache;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/config/api/AnalysisApi;", "", "fastCache", "Lcom/feysh/corax/cache/coroutines/FastCache;", "getFastCache", "()Lcom/feysh/corax/cache/coroutines/FastCache;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "corax-config-api"})
public interface AnalysisApi {
    @NotNull
    public FastCache getFastCache();

    @NotNull
    public CoroutineScope getScope();
}

