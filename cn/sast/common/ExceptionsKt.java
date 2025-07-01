package cn.sast.common;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public final class ExceptionsKt {
    public static void checkCritical(@NotNull Throwable throwable) {
        if (throwable == null) {
            throw new NullPointerException("<this>");
        }

        if (throwable instanceof IOException) {
            String message = throwable.getMessage();
            if (message != null && message.toLowerCase().contains("no space left")) {
                handleCriticalError(throwable, 2);
            }
        } else if (throwable instanceof OutOfMemoryError) {
            handleCriticalError(throwable, 10);
        }
    }

    private static void handleCriticalError(Throwable throwable, int exitCode) {
        throwable.printStackTrace(System.err);
        System.exit(exitCode);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}