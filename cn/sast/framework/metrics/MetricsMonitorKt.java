/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.PhaseIntervalTimerKt
 *  cn.sast.framework.metrics.MetricsMonitorKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.time.Duration
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.metrics;

import cn.sast.api.util.PhaseIntervalTimerKt;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u00004\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u00a2\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0000\u001a\u0018\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0000\u001a\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0001\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"timeSub", "", "time", "begin", "(Ljava/lang/Long;J)Ljava/lang/Long;", "fmt", "", "", "postfix", "scale", "", "inMemGB", "", "getDateStringFromMillis", "duration", "Lkotlin/time/Duration;", "getDateStringFromMillis-LRDsOJo", "(J)Ljava/lang/String;", "dateFormat", "Ljava/text/SimpleDateFormat;", "beginMillis", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nMetricsMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MetricsMonitor.kt\ncn/sast/framework/metrics/MetricsMonitorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,249:1\n1#2:250\n*E\n"})
public final class MetricsMonitorKt {
    @NotNull
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public static final Long timeSub(@Nullable Long time, long begin) {
        Long l = time;
        Long l2 = l;
        if (l == null) return null;
        Long l3 = l2;
        long it = ((Number)l3).longValue();
        boolean bl = false;
        if (it < begin) return null;
        boolean bl2 = true;
        if (!bl2) return null;
        Long l4 = l3;
        l2 = l4;
        if (l4 == null) return null;
        it = ((Number)l2).longValue();
        boolean bl3 = false;
        Long l5 = it - begin;
        return l5;
    }

    @NotNull
    public static final String fmt(@NotNull Number $this$fmt, @NotNull String postfix, int scale) {
        Intrinsics.checkNotNullParameter((Object)$this$fmt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)postfix, (String)"postfix");
        String string = "%." + scale + "f" + postfix;
        Object[] objectArray = new Object[]{$this$fmt.doubleValue()};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }

    public static /* synthetic */ String fmt$default(Number number, String string, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 2;
        }
        return MetricsMonitorKt.fmt((Number)number, (String)string, (int)n);
    }

    public static final double inMemGB(@Nullable Number $this$inMemGB, int scale) {
        double d;
        Number number = $this$inMemGB;
        if (number != null) {
            Number it = number;
            boolean bl = false;
            d = PhaseIntervalTimerKt.retainDecimalPlaces$default((double)it.doubleValue(), (int)scale, null, (int)4, null);
        } else {
            d = -1.0;
        }
        return d;
    }

    public static /* synthetic */ double inMemGB$default(Number number, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 3;
        }
        return MetricsMonitorKt.inMemGB((Number)number, (int)n);
    }

    @NotNull
    public static final String getDateStringFromMillis-LRDsOJo(long duration) {
        return MetricsMonitorKt.getDateStringFromMillis((long)Duration.getInWholeMilliseconds-impl((long)duration));
    }

    @NotNull
    public static final String getDateStringFromMillis(long beginMillis) {
        Date date = new Date(beginMillis);
        String string = dateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"format(...)");
        return string;
    }
}

