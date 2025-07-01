package cn.sast.api.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public final class SimpleTimer {
    private static final Logger logger = LogManager.getLogger(SimpleTimer.class);
    private long elapsedTime;
    private long start;
    private long startTime;
    private long end;

    public long getElapsedTime() {
        return elapsedTime;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public void start() {
        startTime = PhaseIntervalTimerKt.currentNanoTime();
        if (start == 0L) {
            start = startTime;
        }
    }

    public void stop() {
        long cur = PhaseIntervalTimerKt.currentNanoTime();
        elapsedTime += cur - startTime;
        startTime = 0L;
        end = cur;
    }

    public long currentElapsedTime() {
        return elapsedTime + (PhaseIntervalTimerKt.currentNanoTime() - startTime);
    }

    public float inSecond() {
        return (float) elapsedTime / 1000.0f;
    }

    public void clear() {
        elapsedTime = 0L;
    }

    @NotNull
    public String toString() {
        return String.format("elapsed time: %.2fs", inSecond());
    }
}