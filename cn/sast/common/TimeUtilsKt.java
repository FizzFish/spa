/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.TimeUtilsKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.time.Duration
 *  kotlin.time.DurationKt
 *  kotlin.time.DurationUnit
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2={"prettyPrintTime", "", "Ljava/time/LocalDateTime;", "c", "Ljava/time/temporal/ChronoUnit;", "corax-api"})
public final class TimeUtilsKt {
    @NotNull
    public static final String prettyPrintTime(@NotNull LocalDateTime $this$prettyPrintTime, @NotNull ChronoUnit c) {
        Intrinsics.checkNotNullParameter((Object)$this$prettyPrintTime, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        long duration = DurationKt.toDuration((long)c.between($this$prettyPrintTime, LocalDateTime.now()), (DurationUnit)DurationUnit.SECONDS);
        String string = Duration.toString-impl((long)duration);
        long l = Duration.getInWholeSeconds-impl((long)duration);
        String string2 = c.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        return string + " (" + l + string2 + ")";
    }

    public static /* synthetic */ String prettyPrintTime$default(LocalDateTime localDateTime, ChronoUnit chronoUnit, int n, Object object) {
        if ((n & 1) != 0) {
            chronoUnit = ChronoUnit.SECONDS;
        }
        return TimeUtilsKt.prettyPrintTime((LocalDateTime)localDateTime, (ChronoUnit)chronoUnit);
    }
}

