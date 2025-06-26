/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.PhaseIntervalTimer
 *  cn.sast.api.util.PhaseIntervalTimer$Companion
 *  cn.sast.api.util.PhaseIntervalTimer$Snapshot
 *  cn.sast.api.util.PhaseIntervalTimerKt
 *  cn.sast.api.util.TimeRange
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.atomicfu.AtomicFU
 *  kotlinx.atomicfu.AtomicInt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.util;

import cn.sast.api.util.PhaseIntervalTimer;
import cn.sast.api.util.PhaseIntervalTimerKt;
import cn.sast.api.util.TimeRange;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010$\u001a\u00020#J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020#J\b\u0010(\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0014\u0010\nR\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2={"Lcn/sast/api/util/PhaseIntervalTimer;", "", "<init>", "()V", "id", "Lkotlinx/atomicfu/AtomicInt;", "value", "", "startTime", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "endTime", "getEndTime", "_elapsedTime", "prefix", "", "getPrefix", "()Ljava/lang/String;", "elapsedTime", "getElapsedTime", "phaseTimerActiveCount", "phaseStartCount", "getPhaseStartCount", "()Lkotlinx/atomicfu/AtomicInt;", "phaseAverageElapsedTime", "", "getPhaseAverageElapsedTime", "()Ljava/lang/Double;", "ranges", "", "Lcn/sast/api/util/TimeRange;", "queue", "Ljava/util/TreeMap;", "", "Lcn/sast/api/util/PhaseIntervalTimer$Snapshot;", "start", "stop", "", "snapshot", "toString", "Snapshot", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nPhaseIntervalTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhaseIntervalTimer.kt\ncn/sast/api/util/PhaseIntervalTimer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
public class PhaseIntervalTimer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AtomicInt id = AtomicFU.atomic((int)0);
    @Nullable
    private Long startTime;
    @Nullable
    private Long endTime;
    @Nullable
    private volatile Long _elapsedTime;
    @Nullable
    private Long elapsedTime;
    @NotNull
    private AtomicInt phaseTimerActiveCount = AtomicFU.atomic((int)0);
    @NotNull
    private AtomicInt phaseStartCount = AtomicFU.atomic((int)0);
    @NotNull
    private List<TimeRange> ranges = new LinkedList();
    @NotNull
    private TreeMap<Integer, Snapshot> queue = new TreeMap();
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(PhaseIntervalTimer::logger$lambda$9);

    @Nullable
    public final Long getStartTime() {
        return this.startTime;
    }

    @Nullable
    public final Long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public String getPrefix() {
        return "";
    }

    @Nullable
    public final Long getElapsedTime() {
        if (this.phaseTimerActiveCount.getValue() != 0) {
            logger.error(() -> PhaseIntervalTimer._get_elapsedTime_$lambda$0(this));
        }
        if (this.ranges.size() != 0) {
            logger.error(() -> PhaseIntervalTimer._get_elapsedTime_$lambda$1(this));
        }
        if (this.queue.size() != 0) {
            logger.error(() -> PhaseIntervalTimer._get_elapsedTime_$lambda$2(this));
        }
        return this._elapsedTime;
    }

    @NotNull
    public final AtomicInt getPhaseStartCount() {
        return this.phaseStartCount;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public final Double getPhaseAverageElapsedTime() {
        Integer n = this.phaseStartCount.getValue();
        int it = ((Number)n).intValue();
        boolean bl = false;
        if (it <= 0) return null;
        boolean bl2 = true;
        if (!bl2) return null;
        Integer n2 = n;
        if (n2 == null) return null;
        int c = ((Number)n2).intValue();
        boolean bl3 = false;
        Long l = this.getElapsedTime();
        Number number = l;
        if (l == null) return null;
        Double d = (Long)number;
        double it2 = ((Number)d).doubleValue();
        boolean bl4 = false;
        double d2 = it2;
        if (Double.isInfinite(d2)) return null;
        if (Double.isNaN(d2)) return null;
        boolean bl5 = true;
        if (!bl5) return null;
        Double d3 = d;
        number = d3;
        if (d3 == null) return null;
        Double d4 = (Double)number / (double)c;
        return d4;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final Snapshot start() {
        Snapshot result = new Snapshot(PhaseIntervalTimerKt.currentNanoTime(), this.id.getAndIncrement());
        if (this.startTime == null) {
            this.startTime = result.getStartTime();
        }
        TreeMap treeMap = this.queue;
        synchronized (treeMap) {
            boolean bl = false;
            ((Map)this.queue).put(result.getId$corax_api(), result);
            int n = this.phaseTimerActiveCount.getAndIncrement();
        }
        this.phaseStartCount.getAndIncrement();
        return result;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void stop(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter((Object)snapshot, (String)"snapshot");
        TimeRange timeRange = new TimeRange(snapshot.getStartTime(), PhaseIntervalTimerKt.currentNanoTime());
        Long l = this.endTime;
        long l2 = l != null ? l.longValue() : timeRange.getMax();
        long l3 = timeRange.getMax();
        this.endTime = Math.max(l2, l3);
        TreeMap treeMap = this.queue;
        synchronized (treeMap) {
            Object object;
            boolean bl = false;
            int cur = this.phaseTimerActiveCount.decrementAndGet();
            this.ranges.add(timeRange);
            this.ranges = TimeRange.Companion.sortAndMerge(this.ranges);
            if (cur >= 0) {
                Integer lower = this.queue.lowerKey(snapshot.getId$corax_api());
                if (lower == null) {
                    long noSnapshotBefore;
                    Long l4 = this._elapsedTime;
                    long elapsedTime = l4 != null ? l4 : 0L;
                    Map.Entry higher = this.queue.higherEntry(snapshot.getId$corax_api());
                    long l5 = higher == null ? ((TimeRange)CollectionsKt.last((List)this.ranges)).getMax() : (noSnapshotBefore = timeRange.getMax() <= ((Snapshot)higher.getValue()).getStartTime() ? timeRange.getMax() : timeRange.getMin());
                    for (int i = 0; i < this.ranges.size() && ((TimeRange)this.ranges.get(i)).getMax() <= noSnapshotBefore; ++i) {
                        TimeRange e = (TimeRange)this.ranges.remove(i--);
                        elapsedTime += e.getMax() - e.getMin();
                    }
                    this._elapsedTime = elapsedTime;
                }
                object = this.queue.remove(snapshot.getId$corax_api());
            } else {
                logger.error(PhaseIntervalTimer::stop$lambda$8$lambda$7);
                object = Unit.INSTANCE;
            }
            Unit unit = object;
        }
    }

    @NotNull
    public String toString() {
        String string = "elapsed time: %.2fs";
        Object[] objectArray = new Object[]{PhaseIntervalTimerKt.nanoTimeInSeconds$default((Number)this._elapsedTime, (int)0, (int)1, null)};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }

    private static final Object _get_elapsedTime_$lambda$0(PhaseIntervalTimer this$0) {
        return this$0.getPrefix() + "internal error: phaseTimerCount is not zero";
    }

    private static final Object _get_elapsedTime_$lambda$1(PhaseIntervalTimer this$0) {
        return this$0.getPrefix() + "internal error: ranges is not empty";
    }

    private static final Object _get_elapsedTime_$lambda$2(PhaseIntervalTimer this$0) {
        return this$0.getPrefix() + "internal error: queue is not empty";
    }

    private static final Object stop$lambda$8$lambda$7() {
        return "internal error: phaseTimerCount is negative";
    }

    private static final Unit logger$lambda$9() {
        return Unit.INSTANCE;
    }
}

