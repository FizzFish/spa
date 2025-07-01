package cn.sast.api.config;

import com.feysh.corax.config.api.PreAnalysisApi;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PreAnalysisCoroutineScope extends PreAnalysisApi {
    @NotNull
    MainConfig getMainConfig();

    @NotNull
    CoroutineScope getScope();

    void setScope(@NotNull CoroutineScope scope);

    void uninitializedScope();

    @Nullable
    Object processPreAnalysisUnits(@NotNull Continuation<? super Void> continuation);
}