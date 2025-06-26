/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  cn.sast.cli.command.FlowDroidOptionsKt
 *  cn.sast.cli.command.FlowDroidOptionsKt$WhenMappings
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.infoflow.InfoflowConfiguration$StaticFieldTrackingMode
 */
package cn.sast.cli.command;

import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.cli.command.FlowDroidOptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.InfoflowConfiguration;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"cvt", "Lsoot/jimple/infoflow/InfoflowConfiguration$StaticFieldTrackingMode;", "Lcn/sast/api/config/StaticFieldTrackingMode;", "getCvt", "(Lcn/sast/api/config/StaticFieldTrackingMode;)Lsoot/jimple/infoflow/InfoflowConfiguration$StaticFieldTrackingMode;", "corax-cli"})
public final class FlowDroidOptionsKt {
    @NotNull
    public static final InfoflowConfiguration.StaticFieldTrackingMode getCvt(@NotNull StaticFieldTrackingMode $this$cvt) {
        Intrinsics.checkNotNullParameter((Object)$this$cvt, (String)"<this>");
        return switch (WhenMappings.$EnumSwitchMapping$0[$this$cvt.ordinal()]) {
            case 1 -> InfoflowConfiguration.StaticFieldTrackingMode.ContextFlowSensitive;
            case 2 -> InfoflowConfiguration.StaticFieldTrackingMode.ContextFlowInsensitive;
            case 3 -> InfoflowConfiguration.StaticFieldTrackingMode.None;
            default -> throw new NoWhenBranchMatchedException();
        };
    }
}

