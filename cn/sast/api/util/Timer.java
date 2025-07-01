package cn.sast.api.util;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class Timer extends PhaseIntervalTimer {
    @NotNull
    private final String name;

    public Timer(@NotNull String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    @Override
    public String getPrefix() {
        return "timer: " + this.name + " ";
    }

    @NotNull
    @Override
    public String toString() {
        return String.format(
            "[%s] elapsed time: %.2fs",
            this.name,
            PhaseIntervalTimerKt.nanoTimeInSeconds(this.getElapsedTime())
        );
    }
}