/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.PreAnalysisCoroutineScope
 *  com.feysh.corax.config.api.PreAnalysisApi
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlinx.coroutines.CoroutineScope
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.MainConfig;
import com.feysh.corax.config.api.PreAnalysisApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH&J\u000e\u0010\u000e\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000fR\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lcn/sast/api/config/PreAnalysisCoroutineScope;", "Lcom/feysh/corax/config/api/PreAnalysisApi;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "uninitializedScope", "", "processPreAnalysisUnits", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-api"})
public interface PreAnalysisCoroutineScope
extends PreAnalysisApi {
    @NotNull
    public MainConfig getMainConfig();

    @NotNull
    public CoroutineScope getScope();

    public void setScope(@NotNull CoroutineScope var1);

    public void uninitializedScope();

    @Nullable
    public Object processPreAnalysisUnits(@NotNull Continuation<? super Unit> var1);
}

