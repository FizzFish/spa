/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.PreAnalysisApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005H\u00a6@R\u00020\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2={"Lcom/feysh/corax/config/api/PreAnalysisUnit;", "Lcom/feysh/corax/config/api/CheckerUnit;", "<init>", "()V", "config", "", "Lcom/feysh/corax/config/api/PreAnalysisApi;", "(Lcom/feysh/corax/config/api/PreAnalysisApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-config-api"})
public abstract class PreAnalysisUnit
extends CheckerUnit {
    @Nullable
    public abstract Object config(@NotNull PreAnalysisApi var1, @NotNull Continuation<? super Unit> var2);
}

