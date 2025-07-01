package cn.sast.framework.validator;

import java.util.Arrays;

public final class PrecisionMeasurementKt {
    public static String getFm(float value) {
        return String.format("%.2f", value);
    }
}