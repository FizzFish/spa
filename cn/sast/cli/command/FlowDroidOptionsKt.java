package cn.sast.cli.command;

import cn.sast.api.config.StaticFieldTrackingMode;
import soot.jimple.infoflow.InfoflowConfiguration;
import org.jetbrains.annotations.NotNull;

public final class FlowDroidOptionsKt {
    @NotNull
    public static InfoflowConfiguration.StaticFieldTrackingMode getCvt(@NotNull StaticFieldTrackingMode mode) {
        if (mode == null) {
            throw new IllegalArgumentException("mode cannot be null");
        }
        
        switch (mode) {
            case CONTEXT_FLOW_SENSITIVE:
                return InfoflowConfiguration.StaticFieldTrackingMode.ContextFlowSensitive;
            case CONTEXT_FLOW_INSENSITIVE:
                return InfoflowConfiguration.StaticFieldTrackingMode.ContextFlowInsensitive;
            case NONE:
                return InfoflowConfiguration.StaticFieldTrackingMode.None;
            default:
                throw new IllegalArgumentException("Unknown StaticFieldTrackingMode: " + mode);
        }
    }
}