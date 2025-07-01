package cn.sast.framework.metrics;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public final class MetricsMonitorKt {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public static Long timeSub(Long time, long begin) {
        if (time == null || time < begin) {
            return null;
        }
        return time - begin;
    }

    public static String fmt(Number number, String postfix, int scale) {
        if (number == null) throw new IllegalArgumentException("<this> cannot be null");
        if (postfix == null) throw new IllegalArgumentException("postfix cannot be null");
        
        String format = "%." + scale + "f" + postfix;
        return String.format(format, number.doubleValue());
    }

    public static String fmt(Number number, String postfix) {
        return fmt(number, postfix, 2);
    }

    public static double inMemGB(Number number, int scale) {
        if (number != null) {
            return retainDecimalPlaces(number.doubleValue(), scale);
        }
        return -1.0;
    }

    public static double inMemGB(Number number) {
        return inMemGB(number, 3);
    }

    public static String getDateStringFromMillis(long duration) {
        return getDateStringFromMillis(duration / 1000000);
    }

    public static String getDateStringFromMillisFromNanos(long beginMillis) {
        return dateFormat.format(new Date(beginMillis));
    }

    private static double retainDecimalPlaces(double value, int scale) {
        // Implementation of decimal places retention
        double factor = Math.pow(10, scale);
        return Math.round(value * factor) / factor;
    }
}