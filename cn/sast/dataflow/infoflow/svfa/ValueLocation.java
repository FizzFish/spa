package cn.sast.dataflow.infoflow.svfa;

import org.jetbrains.annotations.NotNull;

public enum ValueLocation {
    ParamAndThis,
    Left,
    Right,
    Arg;

    @NotNull
    public static ValueLocation[] getEntries() {
        return values();
    }
}