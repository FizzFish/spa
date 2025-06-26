/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.PhaseIntervalTimerKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0006\u0010\t\u001a\u00020\n\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"retainDecimalPlaces", "", "value", "scale", "", "roundingMode", "Ljava/math/RoundingMode;", "nanoTimeInSeconds", "", "currentNanoTime", "", "CONVERT_TO_SECONDS", "corax-api"})
@SourceDebugExtension(value={"SMAP\nPhaseIntervalTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhaseIntervalTimer.kt\ncn/sast/api/util/PhaseIntervalTimerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
public final class PhaseIntervalTimerKt {
    public static final double CONVERT_TO_SECONDS = 1.0E9;

    public static final double retainDecimalPlaces(double value, int scale, @NotNull RoundingMode roundingMode) {
        Intrinsics.checkNotNullParameter((Object)((Object)roundingMode), (String)"roundingMode");
        double d = value;
        if (!(!Double.isInfinite(d) && !Double.isNaN(d))) {
            return value;
        }
        return new BigDecimal(value).setScale(scale, roundingMode).doubleValue();
    }

    public static /* synthetic */ double retainDecimalPlaces$default(double d, int n, RoundingMode roundingMode, int n2, Object object) {
        if ((n2 & 4) != 0) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return PhaseIntervalTimerKt.retainDecimalPlaces((double)d, (int)n, (RoundingMode)roundingMode);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final double nanoTimeInSeconds(@Nullable Number $this$nanoTimeInSeconds, int scale) {
        Number number = $this$nanoTimeInSeconds;
        Number number2 = number;
        if (number == null) return -1.0;
        Double d = number2.doubleValue();
        double it = ((Number)d).doubleValue();
        boolean bl = false;
        double d2 = it;
        if (Double.isInfinite(d2)) return -1.0;
        if (Double.isNaN(d2)) return -1.0;
        boolean bl2 = true;
        if (!bl2) return -1.0;
        Double d3 = d;
        number2 = d3;
        if (d3 == null) return -1.0;
        double it2 = (Double)number2 / 1.0E9;
        boolean bl3 = false;
        double d4 = PhaseIntervalTimerKt.retainDecimalPlaces$default((double)it2, (int)scale, null, (int)4, null);
        return d4;
    }

    public static /* synthetic */ double nanoTimeInSeconds$default(Number number, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 3;
        }
        return PhaseIntervalTimerKt.nanoTimeInSeconds((Number)number, (int)n);
    }

    public static final long currentNanoTime() {
        return System.nanoTime();
    }
}

