package com.feysh.corax.cache.coroutines;

import com.github.benmanes.caffeine.cache.stats.CacheStats;
import org.jetbrains.annotations.NotNull;

public interface CoroutineCache {
    @NotNull
    CacheStats getCacheStats();

    long getSize();
}