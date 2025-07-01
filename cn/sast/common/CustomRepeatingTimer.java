package cn.sast.common;

import java.util.Timer;
import java.util.TimerTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomRepeatingTimer {
    private final long interval;
    @NotNull
    private final Runnable action;
    @Nullable
    private Timer timer;
    private boolean isRepeats;

    public CustomRepeatingTimer(long interval, @NotNull Runnable action) {
        if (action == null) {
            throw new IllegalArgumentException("action must not be null");
        }
        this.interval = interval;
        this.action = action;
        this.isRepeats = true;
    }

    public final boolean isRepeats() {
        return this.isRepeats;
    }

    public final void setRepeats(boolean repeats) {
        this.isRepeats = repeats;
    }

    public final void start() {
        Timer newTimer = new Timer();
        newTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                action.run();
                if (!isRepeats) {
                    stop();
                }
            }
        }, interval, interval);
        this.timer = newTimer;
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }
}