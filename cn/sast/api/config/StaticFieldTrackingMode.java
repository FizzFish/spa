package cn.sast.api.config;

import org.jetbrains.annotations.NotNull;

public enum StaticFieldTrackingMode {
    ContextFlowSensitive,
    ContextFlowInsensitive,
    None;

    @NotNull
    public static StaticFieldTrackingMode[] getEntries() {
        return values();
    }
}