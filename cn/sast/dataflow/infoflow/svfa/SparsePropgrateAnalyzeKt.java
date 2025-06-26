/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.SparsePropgrateAnalyzeKt
 *  cn.sast.dataflow.infoflow.svfa.ValueLocation
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.ValueLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u00a8\u0006\u0004"}, d2={"isLeft", "", "Lcn/sast/dataflow/infoflow/svfa/ValueLocation;", "isRight", "corax-data-flow"})
public final class SparsePropgrateAnalyzeKt {
    public static final boolean isLeft(@NotNull ValueLocation $this$isLeft) {
        Intrinsics.checkNotNullParameter((Object)$this$isLeft, (String)"<this>");
        return $this$isLeft == ValueLocation.Left;
    }

    public static final boolean isRight(@NotNull ValueLocation $this$isRight) {
        Intrinsics.checkNotNullParameter((Object)$this$isRight, (String)"<this>");
        return $this$isRight != ValueLocation.Left;
    }
}

