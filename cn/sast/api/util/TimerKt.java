package cn.sast.api.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TimerKt {
    public static <T> T bracket(@Nullable PhaseIntervalTimer timer, @NotNull Function0<? extends T> block) {
        if (block == null) {
            throw new NullPointerException("block must not be null");
        }
        
        if (timer == null) {
            return block.invoke();
        }
        
        PhaseIntervalTimer.Snapshot snapshot = timer.start();
        try {
            return block.invoke();
        } finally {
            timer.stop(snapshot);
        }
    }
    
    @FunctionalInterface
    public interface Function0<R> {
        R invoke();
    }
}