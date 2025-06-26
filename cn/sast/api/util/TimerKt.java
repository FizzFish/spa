/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.PhaseIntervalTimer
 *  cn.sast.api.util.PhaseIntervalTimer$Snapshot
 *  cn.sast.api.util.TimerKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.util;

import cn.sast.api.util.PhaseIntervalTimer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0006"}, d2={"bracket", "T", "Lcn/sast/api/util/PhaseIntervalTimer;", "block", "Lkotlin/Function0;", "(Lcn/sast/api/util/PhaseIntervalTimer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "corax-api"})
public final class TimerKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T bracket(@Nullable PhaseIntervalTimer $this$bracket, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        boolean $i$f$bracket = false;
        if ($this$bracket == null) {
            return (T)block.invoke();
        }
        PhaseIntervalTimer.Snapshot s = $this$bracket.start();
        try {
            Object object = block.invoke();
            return (T)object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            $this$bracket.stop(s);
            InlineMarker.finallyEnd((int)1);
        }
    }
}

