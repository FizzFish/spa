/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.PhaseIntervalTimerKt
 *  cn.sast.coroutines.caffine.impl.RecCoroutineCacheImplKt
 *  com.github.benmanes.caffeine.cache.stats.CacheStats
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.coroutines.caffine.impl;

import cn.sast.api.util.PhaseIntervalTimerKt;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002*\u001c\u0010\u0003\u001a\u0004\b\u0000\u0010\u0004\"\b\u0012\u0004\u0012\u0002H\u00040\u00052\b\u0012\u0004\u0012\u0002H\u00040\u0005*&\u0010\u0006\u001a\u0004\b\u0000\u0010\u0004\"\b\u0012\u0004\u0012\u0002H\u0004`\u00072\u0012\u0012\u0004\u0012\u0002H\u00040\u0005j\b\u0012\u0004\u0012\u0002H\u0004`\u0007\u00a8\u0006\b"}, d2={"pp", "", "Lcom/github/benmanes/caffeine/cache/stats/CacheStats;", "RecCoroutineCacheValue", "V", "Lkotlinx/coroutines/Deferred;", "CacheValue", "Lcn/sast/coroutines/caffine/impl/RecCoroutineCacheValue;", "corax-api"})
public final class RecCoroutineCacheImplKt {
    @NotNull
    public static final String pp(@NotNull CacheStats $this$pp) {
        Intrinsics.checkNotNullParameter((Object)$this$pp, (String)"<this>");
        return "hit:" + RecCoroutineCacheImplKt.pp$n((double)$this$pp.hitRate()) + " miss:" + RecCoroutineCacheImplKt.pp$n((double)$this$pp.missRate()) + " penalty:" + RecCoroutineCacheImplKt.pp$n((double)$this$pp.averageLoadPenalty()) + " failure:" + RecCoroutineCacheImplKt.pp$n((double)$this$pp.loadFailureRate()) + " " + $this$pp;
    }

    private static final double pp$n(double $this$pp_u24n) {
        return PhaseIntervalTimerKt.retainDecimalPlaces$default((double)$this$pp_u24n, (int)2, null, (int)4, null);
    }
}

