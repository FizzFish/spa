package cn.sast.common;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

public final class TimeUtilsKt {
    private TimeUtilsKt() {}

    @NotNull
    public static String prettyPrintTime(@NotNull LocalDateTime time, @NotNull ChronoUnit unit) {
        if (time == null) throw new NullPointerException("time is null");
        if (unit == null) throw new NullPointerException("unit is null");

        long seconds = unit.between(time, LocalDateTime.now());
        String durationString = formatDuration(seconds);
        String unitName = unit.name().toLowerCase(Locale.ROOT);
        return durationString + " (" + seconds + unitName + ")";
    }

    @NotNull
    public static String prettyPrintTime(@NotNull LocalDateTime time) {
        return prettyPrintTime(time, ChronoUnit.SECONDS);
    }

    private static String formatDuration(long seconds) {
        // Simplified duration formatting (original used Kotlin Duration)
        long absSeconds = Math.abs(seconds);
        if (absSeconds < 60) return absSeconds + "s";
        if (absSeconds < 3600) return absSeconds / 60 + "m";
        if (absSeconds < 86400) return absSeconds / 3600 + "h";
        return absSeconds / 86400 + "d";
    }
}