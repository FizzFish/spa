package cn.sast.coroutines.caffine.impl;

import cn.sast.api.util.PhaseIntervalTimerKt;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import org.jetbrains.annotations.NotNull;

public final class RecCoroutineCacheImplKt {
    @NotNull
    public static String pp(@NotNull CacheStats stats) {
        if (stats == null) {
            throw new NullPointerException("<this>");
        }
        return "hit:" + formatRate(stats.hitRate()) + 
               " miss:" + formatRate(stats.missRate()) + 
               " penalty:" + formatRate(stats.averageLoadPenalty()) + 
               " failure:" + formatRate(stats.loadFailureRate()) + 
               " " + stats;
    }

    private static double formatRate(double rate) {
        return PhaseIntervalTimerKt.retainDecimalPlaces(rate, 2);
    }
}