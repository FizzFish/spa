/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.PhaseIntervalTimer
 *  cn.sast.api.util.PhaseIntervalTimerKt
 *  cn.sast.api.util.Timer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.util;

import cn.sast.api.util.PhaseIntervalTimer;
import cn.sast.api.util.PhaseIntervalTimerKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u000b"}, d2={"Lcn/sast/api/util/Timer;", "Lcn/sast/api/util/PhaseIntervalTimer;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "prefix", "getPrefix", "toString", "corax-api"})
public final class Timer
extends PhaseIntervalTimer {
    @NotNull
    private final String name;

    public Timer(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public String getPrefix() {
        return "timer: " + this.name + " ";
    }

    @NotNull
    public String toString() {
        String string = "[%s] elapsed time: %.2fs";
        Object[] objectArray = new Object[]{this.name, PhaseIntervalTimerKt.nanoTimeInSeconds$default((Number)this.getElapsedTime(), (int)0, (int)1, null)};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }
}

