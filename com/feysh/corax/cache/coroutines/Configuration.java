/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.Expiry
 *  com.github.benmanes.caffeine.cache.RemovalCause
 *  com.github.benmanes.caffeine.cache.Scheduler
 *  com.github.benmanes.caffeine.cache.stats.StatsCounter
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.time.Duration
 *  kotlinx.coroutines.CoroutineScope
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.coroutines;

import com.feysh.corax.cache.coroutines.Scheduler;
import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bc\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u00e7\u0002\b\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017\u00126\b\u0002\u0010\u0018\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0019\u00126\b\u0002\u0010\u001d\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001f\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b&\u0010'J\t\u0010l\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\boJ\u0010\u0010p\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\bqJ\u0010\u0010r\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\bsJ\u0010\u0010t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u00109J\u0010\u0010u\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u00109J\u0010\u0010v\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u00109J\u0010\u0010w\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010BJ\u0010\u0010x\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010BJ\u000b\u0010y\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\u0017\u0010z\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0015H\u00c6\u0003J\u0011\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017H\u00c6\u0003J<\u0010|\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0019H\u00c6\u0003\u00a2\u0006\u0002\u0010UJ<\u0010}\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0019H\u00c6\u0003\u00a2\u0006\u0002\u0010UJ\u0010\u0010~\u001a\u0004\u0018\u00010\u001fH\u00c6\u0003\u00a2\u0006\u0002\u0010\\J\u001d\u0010\u007f\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001f\u0018\u00010!H\u00c6\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010#H\u00c6\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010%H\u00c6\u0003J\u00fd\u0002\u0010\u0082\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001726\b\u0002\u0010\u0018\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001926\b\u0002\u0010\u001d\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00192\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001f\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u00c6\u0001\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0015\u0010\u0085\u0001\u001a\u00020\u00052\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003H\u00d6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u001fH\u00d6\u0001J\u000b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010<\u001a\u0004\b?\u00109\"\u0004\b@\u0010;R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010E\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SRJ\u0010\u0018\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010X\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WRJ\u0010\u001d\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010X\u001a\u0004\bY\u0010U\"\u0004\bZ\u0010WR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010_\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R.\u0010 \u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001f\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k\u00a8\u0006\u008a\u0001"}, d2={"Lcom/feysh/corax/cache/coroutines/Configuration;", "K", "V", "", "useCallingContext", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "refreshAfterWrite", "Lkotlin/time/Duration;", "expireAfterAccess", "expireAfterWrite", "weakKeys", "weakValues", "softValues", "maximumWeight", "", "maximumSize", "statsCounter", "Lcom/github/benmanes/caffeine/cache/stats/StatsCounter;", "expireAfter", "Lcom/github/benmanes/caffeine/cache/Expiry;", "ticker", "Lkotlin/Function0;", "evictionListener", "Lkotlin/Function4;", "Lcom/github/benmanes/caffeine/cache/RemovalCause;", "Lkotlin/coroutines/Continuation;", "", "removalListener", "initialCapacity", "", "weigher", "Lkotlin/Function2;", "caffeineScheduler", "Lcom/github/benmanes/caffeine/cache/Scheduler;", "scheduler", "Lcom/feysh/corax/cache/coroutines/Scheduler;", "<init>", "(ZLkotlinx/coroutines/CoroutineScope;Lkotlin/time/Duration;Lkotlin/time/Duration;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Lcom/github/benmanes/caffeine/cache/stats/StatsCounter;Lcom/github/benmanes/caffeine/cache/Expiry;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;Lcom/github/benmanes/caffeine/cache/Scheduler;Lcom/feysh/corax/cache/coroutines/Scheduler;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUseCallingContext", "()Z", "setUseCallingContext", "(Z)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "getRefreshAfterWrite-FghU774", "()Lkotlin/time/Duration;", "setRefreshAfterWrite-BwNAW2A", "(Lkotlin/time/Duration;)V", "getExpireAfterAccess-FghU774", "setExpireAfterAccess-BwNAW2A", "getExpireAfterWrite-FghU774", "setExpireAfterWrite-BwNAW2A", "getWeakKeys", "()Ljava/lang/Boolean;", "setWeakKeys", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getWeakValues", "setWeakValues", "getSoftValues", "setSoftValues", "getMaximumWeight", "()Ljava/lang/Long;", "setMaximumWeight", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaximumSize", "setMaximumSize", "getStatsCounter", "()Lcom/github/benmanes/caffeine/cache/stats/StatsCounter;", "setStatsCounter", "(Lcom/github/benmanes/caffeine/cache/stats/StatsCounter;)V", "getExpireAfter", "()Lcom/github/benmanes/caffeine/cache/Expiry;", "setExpireAfter", "(Lcom/github/benmanes/caffeine/cache/Expiry;)V", "getTicker", "()Lkotlin/jvm/functions/Function0;", "setTicker", "(Lkotlin/jvm/functions/Function0;)V", "getEvictionListener", "()Lkotlin/jvm/functions/Function4;", "setEvictionListener", "(Lkotlin/jvm/functions/Function4;)V", "Lkotlin/jvm/functions/Function4;", "getRemovalListener", "setRemovalListener", "getInitialCapacity", "()Ljava/lang/Integer;", "setInitialCapacity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getWeigher", "()Lkotlin/jvm/functions/Function2;", "setWeigher", "(Lkotlin/jvm/functions/Function2;)V", "getCaffeineScheduler", "()Lcom/github/benmanes/caffeine/cache/Scheduler;", "setCaffeineScheduler", "(Lcom/github/benmanes/caffeine/cache/Scheduler;)V", "getScheduler", "()Lcom/feysh/corax/cache/coroutines/Scheduler;", "setScheduler", "(Lcom/feysh/corax/cache/coroutines/Scheduler;)V", "component1", "component2", "component3", "component3-FghU774", "component4", "component4-FghU774", "component5", "component5-FghU774", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "copy-T_gFj0o", "(ZLkotlinx/coroutines/CoroutineScope;Lkotlin/time/Duration;Lkotlin/time/Duration;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Lcom/github/benmanes/caffeine/cache/stats/StatsCounter;Lcom/github/benmanes/caffeine/cache/Expiry;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;Lcom/github/benmanes/caffeine/cache/Scheduler;Lcom/feysh/corax/cache/coroutines/Scheduler;)Lcom/feysh/corax/cache/coroutines/Configuration;", "equals", "other", "hashCode", "toString", "", "corax-config-api"})
public final class Configuration<K, V> {
    private boolean useCallingContext;
    @Nullable
    private CoroutineScope scope;
    @Nullable
    private Duration refreshAfterWrite;
    @Nullable
    private Duration expireAfterAccess;
    @Nullable
    private Duration expireAfterWrite;
    @Nullable
    private Boolean weakKeys;
    @Nullable
    private Boolean weakValues;
    @Nullable
    private Boolean softValues;
    @Nullable
    private Long maximumWeight;
    @Nullable
    private Long maximumSize;
    @Nullable
    private StatsCounter statsCounter;
    @Nullable
    private Expiry<K, V> expireAfter;
    @Nullable
    private Function0<Long> ticker;
    @Nullable
    private Function4<? super K, ? super V, ? super RemovalCause, ? super Continuation<? super Unit>, ? extends Object> evictionListener;
    @Nullable
    private Function4<? super K, ? super V, ? super RemovalCause, ? super Continuation<? super Unit>, ? extends Object> removalListener;
    @Nullable
    private Integer initialCapacity;
    @Nullable
    private Function2<? super K, ? super V, Integer> weigher;
    @Nullable
    private com.github.benmanes.caffeine.cache.Scheduler caffeineScheduler;
    @Nullable
    private Scheduler scheduler;

    private Configuration(boolean useCallingContext, CoroutineScope scope, Duration refreshAfterWrite, Duration expireAfterAccess, Duration expireAfterWrite, Boolean weakKeys, Boolean weakValues, Boolean softValues, Long maximumWeight, Long maximumSize, StatsCounter statsCounter, Expiry<K, V> expireAfter, Function0<Long> ticker, Function4<? super K, ? super V, ? super RemovalCause, ? super Continuation<? super Unit>, ? extends Object> evictionListener, Function4<? super K, ? super V, ? super RemovalCause, ? super Continuation<? super Unit>, ? extends Object> removalListener, Integer initialCapacity, Function2<? super K, ? super V, Integer> weigher, com.github.benmanes.caffeine.cache.Scheduler caffeineScheduler, Scheduler scheduler) {
        this.useCallingContext = useCallingContext;
        this.scope = scope;
        this.refreshAfterWrite = refreshAfterWrite;
        this.expireAfterAccess = expireAfterAccess;
        this.expireAfterWrite = expireAfterWrite;
        this.weakKeys = weakKeys;
        this.weakValues = weakValues;
        this.softValues = softValues;
        this.maximumWeight = maximumWeight;
        this.maximumSize = maximumSize;
        this.statsCounter = statsCounter;
        this.expireAfter = expireAfter;
        this.ticker = ticker;
        this.evictionListener = evictionListener;
        this.removalListener = removalListener;
        this.initialCapacity = initialCapacity;
        this.weigher = weigher;
        this.caffeineScheduler = caffeineScheduler;
        this.scheduler = scheduler;
    }

    public /* synthetic */ Configuration(boolean bl, CoroutineScope coroutineScope, Duration duration, Duration duration2, Duration duration3, Boolean bl2, Boolean bl3, Boolean bl4, Long l, Long l2, StatsCounter statsCounter, Expiry expiry, Function0 function0, Function4 function4, Function4 function42, Integer n, Function2 function2, com.github.benmanes.caffeine.cache.Scheduler scheduler, Scheduler scheduler2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl = true;
        }
        if ((n2 & 2) != 0) {
            coroutineScope = null;
        }
        if ((n2 & 4) != 0) {
            duration = null;
        }
        if ((n2 & 8) != 0) {
            duration2 = null;
        }
        if ((n2 & 0x10) != 0) {
            duration3 = null;
        }
        if ((n2 & 0x20) != 0) {
            bl2 = null;
        }
        if ((n2 & 0x40) != 0) {
            bl3 = null;
        }
        if ((n2 & 0x80) != 0) {
            bl4 = null;
        }
        if ((n2 & 0x100) != 0) {
            l = null;
        }
        if ((n2 & 0x200) != 0) {
            l2 = null;
        }
        if ((n2 & 0x400) != 0) {
            statsCounter = null;
        }
        if ((n2 & 0x800) != 0) {
            expiry = null;
        }
        if ((n2 & 0x1000) != 0) {
            function0 = null;
        }
        if ((n2 & 0x2000) != 0) {
            function4 = null;
        }
        if ((n2 & 0x4000) != 0) {
            function42 = null;
        }
        if ((n2 & 0x8000) != 0) {
            n = null;
        }
        if ((n2 & 0x10000) != 0) {
            function2 = null;
        }
        if ((n2 & 0x20000) != 0) {
            scheduler = null;
        }
        if ((n2 & 0x40000) != 0) {
            scheduler2 = null;
        }
        this(bl, coroutineScope, duration, duration2, duration3, bl2, bl3, bl4, l, l2, statsCounter, expiry, function0, function4, function42, n, function2, scheduler, scheduler2, null);
    }

    public final boolean getUseCallingContext() {
        return this.useCallingContext;
    }

    public final void setUseCallingContext(boolean bl) {
        this.useCallingContext = bl;
    }

    @Nullable
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void setScope(@Nullable CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }

    @Nullable
    public final Duration getRefreshAfterWrite-FghU774() {
        return this.refreshAfterWrite;
    }

    public final void setRefreshAfterWrite-BwNAW2A(@Nullable Duration duration) {
        this.refreshAfterWrite = duration;
    }

    @Nullable
    public final Duration getExpireAfterAccess-FghU774() {
        return this.expireAfterAccess;
    }

    public final void setExpireAfterAccess-BwNAW2A(@Nullable Duration duration) {
        this.expireAfterAccess = duration;
    }

    @Nullable
    public final Duration getExpireAfterWrite-FghU774() {
        return this.expireAfterWrite;
    }

    public final void setExpireAfterWrite-BwNAW2A(@Nullable Duration duration) {
        this.expireAfterWrite = duration;
    }

    @Nullable
    public final Boolean getWeakKeys() {
        return this.weakKeys;
    }

    public final void setWeakKeys(@Nullable Boolean bl) {
        this.weakKeys = bl;
    }

    @Nullable
    public final Boolean getWeakValues() {
        return this.weakValues;
    }

    public final void setWeakValues(@Nullable Boolean bl) {
        this.weakValues = bl;
    }

    @Nullable
    public final Boolean getSoftValues() {
        return this.softValues;
    }

    public final void setSoftValues(@Nullable Boolean bl) {
        this.softValues = bl;
    }

    @Nullable
    public final Long getMaximumWeight() {
        return this.maximumWeight;
    }

    public final void setMaximumWeight(@Nullable Long l) {
        this.maximumWeight = l;
    }

    @Nullable
    public final Long getMaximumSize() {
        return this.maximumSize;
    }

    public final void setMaximumSize(@Nullable Long l) {
        this.maximumSize = l;
    }

    @Nullable
    public final StatsCounter getStatsCounter() {
        return this.statsCounter;
    }

    public final void setStatsCounter(@Nullable StatsCounter statsCounter) {
        this.statsCounter = statsCounter;
    }

    @Nullable
    public final Expiry<K, V> getExpireAfter() {
        return this.expireAfter;
    }

    public final void setExpireAfter(@Nullable Expiry<K, V> expiry) {
        this.expireAfter = expiry;
    }

    @Nullable
    public final Function0<Long> getTicker() {
        return this.ticker;
    }

    public final void setTicker(@Nullable Function0<Long> function0) {
        this.ticker = function0;
    }

    @Nullable
    public final Function4<K, V, RemovalCause, Continuation<? super Unit>, Object> getEvictionListener() {
        return this.evictionListener;
    }

    public final void setEvictionListener(@Nullable Function4<? super K, ? super V, ? super RemovalCause, ? super Continuation<? super Unit>, ? extends Object> function4) {
        this.evictionListener = function4;
    }

    @Nullable
    public final Function4<K, V, RemovalCause, Continuation<? super Unit>, Object> getRemovalListener() {
        return this.removalListener;
    }

    public final void setRemovalListener(@Nullable Function4<? super K, ? super V, ? super RemovalCause, ? super Continuation<? super Unit>, ? extends Object> function4) {
        this.removalListener = function4;
    }

    @Nullable
    public final Integer getInitialCapacity() {
        return this.initialCapacity;
    }

    public final void setInitialCapacity(@Nullable Integer n) {
        this.initialCapacity = n;
    }

    @Nullable
    public final Function2<K, V, Integer> getWeigher() {
        return this.weigher;
    }

    public final void setWeigher(@Nullable Function2<? super K, ? super V, Integer> function2) {
        this.weigher = function2;
    }

    @Nullable
    public final com.github.benmanes.caffeine.cache.Scheduler getCaffeineScheduler() {
        return this.caffeineScheduler;
    }

    public final void setCaffeineScheduler(@Nullable com.github.benmanes.caffeine.cache.Scheduler scheduler) {
        this.caffeineScheduler = scheduler;
    }

    @Nullable
    public final Scheduler getScheduler() {
        return this.scheduler;
    }

    public final void setScheduler(@Nullable Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public final boolean component1() {
        return this.useCallingContext;
    }

    @Nullable
    public final CoroutineScope component2() {
        return this.scope;
    }

    @Nullable
    public final Duration component3-FghU774() {
        return this.refreshAfterWrite;
    }

    @Nullable
    public final Duration component4-FghU774() {
        return this.expireAfterAccess;
    }

    @Nullable
    public final Duration component5-FghU774() {
        return this.expireAfterWrite;
    }

    @Nullable
    public final Boolean component6() {
        return this.weakKeys;
    }

    @Nullable
    public final Boolean component7() {
        return this.weakValues;
    }

    @Nullable
    public final Boolean component8() {
        return this.softValues;
    }

    @Nullable
    public final Long component9() {
        return this.maximumWeight;
    }

    @Nullable
    public final Long component10() {
        return this.maximumSize;
    }

    @Nullable
    public final StatsCounter component11() {
        return this.statsCounter;
    }

    @Nullable
    public final Expiry<K, V> component12() {
        return this.expireAfter;
    }

    @Nullable
    public final Function0<Long> component13() {
        return this.ticker;
    }

    @Nullable
    public final Function4<K, V, RemovalCause, Continuation<? super Unit>, Object> component14() {
        return this.evictionListener;
    }

    @Nullable
    public final Function4<K, V, RemovalCause, Continuation<? super Unit>, Object> component15() {
        return this.removalListener;
    }

    @Nullable
    public final Integer component16() {
        return this.initialCapacity;
    }

    @Nullable
    public final Function2<K, V, Integer> component17() {
        return this.weigher;
    }

    @Nullable
    public final com.github.benmanes.caffeine.cache.Scheduler component18() {
        return this.caffeineScheduler;
    }

    @Nullable
    public final Scheduler component19() {
        return this.scheduler;
    }

    @NotNull
    public final Configuration<K, V> copy-T_gFj0o(boolean useCallingContext, @Nullable CoroutineScope scope, @Nullable Duration refreshAfterWrite, @Nullable Duration expireAfterAccess, @Nullable Duration expireAfterWrite, @Nullable Boolean weakKeys, @Nullable Boolean weakValues, @Nullable Boolean softValues, @Nullable Long maximumWeight, @Nullable Long maximumSize, @Nullable StatsCounter statsCounter, @Nullable Expiry<K, V> expireAfter, @Nullable Function0<Long> ticker, @Nullable Function4<? super K, ? super V, ? super RemovalCause, ? super Continuation<? super Unit>, ? extends Object> evictionListener, @Nullable Function4<? super K, ? super V, ? super RemovalCause, ? super Continuation<? super Unit>, ? extends Object> removalListener, @Nullable Integer initialCapacity, @Nullable Function2<? super K, ? super V, Integer> weigher, @Nullable com.github.benmanes.caffeine.cache.Scheduler caffeineScheduler, @Nullable Scheduler scheduler) {
        return new Configuration<K, V>(useCallingContext, scope, refreshAfterWrite, expireAfterAccess, expireAfterWrite, weakKeys, weakValues, softValues, maximumWeight, maximumSize, statsCounter, expireAfter, ticker, evictionListener, removalListener, initialCapacity, weigher, caffeineScheduler, scheduler, null);
    }

    public static /* synthetic */ Configuration copy-T_gFj0o$default(Configuration configuration, boolean bl, CoroutineScope coroutineScope, Duration duration, Duration duration2, Duration duration3, Boolean bl2, Boolean bl3, Boolean bl4, Long l, Long l2, StatsCounter statsCounter, Expiry expiry, Function0 function0, Function4 function4, Function4 function42, Integer n, Function2 function2, com.github.benmanes.caffeine.cache.Scheduler scheduler, Scheduler scheduler2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = configuration.useCallingContext;
        }
        if ((n2 & 2) != 0) {
            coroutineScope = configuration.scope;
        }
        if ((n2 & 4) != 0) {
            duration = configuration.refreshAfterWrite;
        }
        if ((n2 & 8) != 0) {
            duration2 = configuration.expireAfterAccess;
        }
        if ((n2 & 0x10) != 0) {
            duration3 = configuration.expireAfterWrite;
        }
        if ((n2 & 0x20) != 0) {
            bl2 = configuration.weakKeys;
        }
        if ((n2 & 0x40) != 0) {
            bl3 = configuration.weakValues;
        }
        if ((n2 & 0x80) != 0) {
            bl4 = configuration.softValues;
        }
        if ((n2 & 0x100) != 0) {
            l = configuration.maximumWeight;
        }
        if ((n2 & 0x200) != 0) {
            l2 = configuration.maximumSize;
        }
        if ((n2 & 0x400) != 0) {
            statsCounter = configuration.statsCounter;
        }
        if ((n2 & 0x800) != 0) {
            expiry = configuration.expireAfter;
        }
        if ((n2 & 0x1000) != 0) {
            function0 = configuration.ticker;
        }
        if ((n2 & 0x2000) != 0) {
            function4 = configuration.evictionListener;
        }
        if ((n2 & 0x4000) != 0) {
            function42 = configuration.removalListener;
        }
        if ((n2 & 0x8000) != 0) {
            n = configuration.initialCapacity;
        }
        if ((n2 & 0x10000) != 0) {
            function2 = configuration.weigher;
        }
        if ((n2 & 0x20000) != 0) {
            scheduler = configuration.caffeineScheduler;
        }
        if ((n2 & 0x40000) != 0) {
            scheduler2 = configuration.scheduler;
        }
        return configuration.copy-T_gFj0o(bl, coroutineScope, duration, duration2, duration3, bl2, bl3, bl4, l, l2, statsCounter, expiry, function0, function4, function42, n, function2, scheduler, scheduler2);
    }

    @NotNull
    public String toString() {
        return "Configuration(useCallingContext=" + this.useCallingContext + ", scope=" + this.scope + ", refreshAfterWrite=" + this.refreshAfterWrite + ", expireAfterAccess=" + this.expireAfterAccess + ", expireAfterWrite=" + this.expireAfterWrite + ", weakKeys=" + this.weakKeys + ", weakValues=" + this.weakValues + ", softValues=" + this.softValues + ", maximumWeight=" + this.maximumWeight + ", maximumSize=" + this.maximumSize + ", statsCounter=" + this.statsCounter + ", expireAfter=" + this.expireAfter + ", ticker=" + this.ticker + ", evictionListener=" + this.evictionListener + ", removalListener=" + this.removalListener + ", initialCapacity=" + this.initialCapacity + ", weigher=" + this.weigher + ", caffeineScheduler=" + this.caffeineScheduler + ", scheduler=" + this.scheduler + ")";
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.useCallingContext);
        result = result * 31 + (this.scope == null ? 0 : this.scope.hashCode());
        result = result * 31 + (this.refreshAfterWrite == null ? 0 : Duration.hashCode-impl((long)this.refreshAfterWrite.unbox-impl()));
        result = result * 31 + (this.expireAfterAccess == null ? 0 : Duration.hashCode-impl((long)this.expireAfterAccess.unbox-impl()));
        result = result * 31 + (this.expireAfterWrite == null ? 0 : Duration.hashCode-impl((long)this.expireAfterWrite.unbox-impl()));
        result = result * 31 + (this.weakKeys == null ? 0 : ((Object)this.weakKeys).hashCode());
        result = result * 31 + (this.weakValues == null ? 0 : ((Object)this.weakValues).hashCode());
        result = result * 31 + (this.softValues == null ? 0 : ((Object)this.softValues).hashCode());
        result = result * 31 + (this.maximumWeight == null ? 0 : ((Object)this.maximumWeight).hashCode());
        result = result * 31 + (this.maximumSize == null ? 0 : ((Object)this.maximumSize).hashCode());
        result = result * 31 + (this.statsCounter == null ? 0 : this.statsCounter.hashCode());
        result = result * 31 + (this.expireAfter == null ? 0 : this.expireAfter.hashCode());
        result = result * 31 + (this.ticker == null ? 0 : this.ticker.hashCode());
        result = result * 31 + (this.evictionListener == null ? 0 : this.evictionListener.hashCode());
        result = result * 31 + (this.removalListener == null ? 0 : this.removalListener.hashCode());
        result = result * 31 + (this.initialCapacity == null ? 0 : ((Object)this.initialCapacity).hashCode());
        result = result * 31 + (this.weigher == null ? 0 : this.weigher.hashCode());
        result = result * 31 + (this.caffeineScheduler == null ? 0 : this.caffeineScheduler.hashCode());
        result = result * 31 + (this.scheduler == null ? 0 : this.scheduler.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration)other;
        if (this.useCallingContext != configuration.useCallingContext) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.scope, (Object)configuration.scope)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.refreshAfterWrite, (Object)configuration.refreshAfterWrite)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.expireAfterAccess, (Object)configuration.expireAfterAccess)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.expireAfterWrite, (Object)configuration.expireAfterWrite)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.weakKeys, (Object)configuration.weakKeys)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.weakValues, (Object)configuration.weakValues)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.softValues, (Object)configuration.softValues)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maximumWeight, (Object)configuration.maximumWeight)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maximumSize, (Object)configuration.maximumSize)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.statsCounter, (Object)configuration.statsCounter)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.expireAfter, configuration.expireAfter)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.ticker, configuration.ticker)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.evictionListener, configuration.evictionListener)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.removalListener, configuration.removalListener)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.initialCapacity, (Object)configuration.initialCapacity)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.weigher, configuration.weigher)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.caffeineScheduler, (Object)configuration.caffeineScheduler)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.scheduler, (Object)configuration.scheduler);
    }

    public /* synthetic */ Configuration(boolean useCallingContext, CoroutineScope scope, Duration refreshAfterWrite, Duration expireAfterAccess, Duration expireAfterWrite, Boolean weakKeys, Boolean weakValues, Boolean softValues, Long maximumWeight, Long maximumSize, StatsCounter statsCounter, Expiry expireAfter, Function0 ticker, Function4 evictionListener, Function4 removalListener, Integer initialCapacity, Function2 weigher, com.github.benmanes.caffeine.cache.Scheduler caffeineScheduler, Scheduler scheduler, DefaultConstructorMarker $constructor_marker) {
        this(useCallingContext, scope, refreshAfterWrite, expireAfterAccess, expireAfterWrite, weakKeys, weakValues, softValues, maximumWeight, maximumSize, statsCounter, expireAfter, (Function0<Long>)ticker, evictionListener, removalListener, initialCapacity, weigher, caffeineScheduler, scheduler);
    }
}

