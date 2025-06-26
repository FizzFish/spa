/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.PhaseIntervalTimerKt
 *  cn.sast.api.util.SimpleTimer
 *  cn.sast.api.util.SimpleTimer$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.util;

import cn.sast.api.util.PhaseIntervalTimerKt;
import cn.sast.api.util.SimpleTimer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b\u00a8\u0006\u0017"}, d2={"Lcn/sast/api/util/SimpleTimer;", "", "<init>", "()V", "value", "", "elapsedTime", "getElapsedTime", "()J", "start", "getStart", "startTime", "end", "getEnd", "", "stop", "currentElapsedTime", "inSecond", "", "clear", "toString", "", "Companion", "corax-api"})
public final class SimpleTimer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private long elapsedTime;
    private long start;
    private long startTime;
    private long end;
    private static final Logger logger = LogManager.getLogger(SimpleTimer.class);

    public final long getElapsedTime() {
        return this.elapsedTime;
    }

    public final long getStart() {
        return this.start;
    }

    public final long getEnd() {
        return this.end;
    }

    public final void start() {
        this.startTime = PhaseIntervalTimerKt.currentNanoTime();
        if (this.start == 0L) {
            this.start = this.startTime;
        }
    }

    public final void stop() {
        long cur = PhaseIntervalTimerKt.currentNanoTime();
        this.elapsedTime += cur - this.startTime;
        this.startTime = 0L;
        this.end = cur;
    }

    public final long currentElapsedTime() {
        return this.elapsedTime + (PhaseIntervalTimerKt.currentNanoTime() - this.startTime);
    }

    public final float inSecond() {
        return (float)this.elapsedTime / 1000.0f;
    }

    public final void clear() {
        this.elapsedTime = 0L;
    }

    @NotNull
    public String toString() {
        String string = "elapsed time: %.2fs";
        Object[] objectArray = new Object[]{Float.valueOf(this.inSecond())};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }

    public static final /* synthetic */ Logger access$getLogger$cp() {
        return logger;
    }
}

