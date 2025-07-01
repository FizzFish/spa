package com.feysh.corax.config.api;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PreAnalysisUnit extends CheckerUnit {
    @Nullable
    public abstract Object config(@NotNull PreAnalysisApi api, @NotNull Continuation<? super Void> continuation);
}