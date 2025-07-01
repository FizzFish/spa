package cn.sast.dataflow.infoflow.svfa;

import org.jetbrains.annotations.NotNull;

public final class SparsePropgrateAnalyzeKt {
    public static boolean isLeft(@NotNull ValueLocation location) {
        if (location == null) {
            throw new NullPointerException("location cannot be null");
        }
        return location == ValueLocation.Left;
    }

    public static boolean isRight(@NotNull ValueLocation location) {
        if (location == null) {
            throw new NullPointerException("location cannot be null");
        }
        return location != ValueLocation.Left;
    }
}