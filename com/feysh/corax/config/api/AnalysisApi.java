package com.feysh.corax.config.api;

import com.feysh.corax.cache.coroutines.FastCache;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

public interface AnalysisApi {
    @NotNull
    FastCache getFastCache();

    @NotNull
    CoroutineScope getScope();
}