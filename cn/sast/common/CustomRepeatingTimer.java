/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.CustomRepeatingTimer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.common;

import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lcn/sast/common/CustomRepeatingTimer;", "", "interval", "", "action", "Lkotlin/Function0;", "", "<init>", "(JLkotlin/jvm/functions/Function0;)V", "timer", "Ljava/util/Timer;", "isRepeats", "", "()Z", "setRepeats", "(Z)V", "start", "stop", "corax-api"})
public class CustomRepeatingTimer {
    private final long interval;
    @NotNull
    private final Function0<Unit> action;
    @Nullable
    private Timer timer;
    private boolean isRepeats;

    public CustomRepeatingTimer(long interval, @NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, (String)"action");
        this.interval = interval;
        this.action = action;
        this.isRepeats = true;
    }

    public final boolean isRepeats() {
        return this.isRepeats;
    }

    public final void setRepeats(boolean bl) {
        this.isRepeats = bl;
    }

    /*
     * WARNING - void declaration
     */
    public final void start() {
        void $this$start_u24lambda_u240;
        Timer timer;
        Timer timer2 = timer = new Timer();
        CustomRepeatingTimer customRepeatingTimer = this;
        boolean bl = false;
        $this$start_u24lambda_u240.scheduleAtFixedRate((TimerTask)new /* Unavailable Anonymous Inner Class!! */, this.interval, this.interval);
        customRepeatingTimer.timer = timer;
    }

    public void stop() {
        block0: {
            Timer timer = this.timer;
            if (timer == null) break block0;
            Timer it = timer;
            boolean bl = false;
            it.cancel();
            it.purge();
            this.timer = null;
        }
    }

    public static final /* synthetic */ Function0 access$getAction$p(CustomRepeatingTimer $this) {
        return $this.action;
    }
}

