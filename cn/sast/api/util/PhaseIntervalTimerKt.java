package cn.sast.api.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.jetbrains.annotations.NotNull;

public final class PhaseIntervalTimerKt {
    public static final double CONVERT_TO_SECONDS = 1.0E9;

    public static double retainDecimalPlaces(double value, int scale, @NotNull RoundingMode roundingMode) {
        if (roundingMode == null) {
            throw new IllegalArgumentException("roundingMode must not be null");
        }
        
        if (Double.isInfinite(value) || Double.isNaN(value)) {
            return value;
        }
        return new BigDecimal(value).setScale(scale, roundingMode).doubleValue();
    }

    public static double retainDecimalPlaces(double value, int scale) {
        return retainDecimalPlaces(value, scale, RoundingMode.HALF_EVEN);
    }

    public static double nanoTimeInSeconds(Number nanoTime, int scale) {
        if (nanoTime == null) {
            return -1.0;
        }
        
        double time = nanoTime.doubleValue();
        if (Double.isInfinite(time) || Double.isNaN(time)) {
            return -1.0;
        }
        
        double seconds = time / CONVERT_TO_SECONDS;
        return retainDecimalPlaces(seconds, scale);
    }

    public static double nanoTimeInSeconds(Number nanoTime) {
        return nanoTimeInSeconds(nanoTime, 3);
    }

    public static long currentNanoTime() {
        return System.nanoTime();
    }
}