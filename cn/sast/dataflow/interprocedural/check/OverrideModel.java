package cn.sast.dataflow.interprocedural.check;

import org.jetbrains.annotations.NotNull;

public enum OverrideModel {
    HashMap,
    ArrayList;

    @NotNull
    public static OverrideModel[] values() {
        return values();
    }

    @NotNull
    public static OverrideModel valueOf(@NotNull String name) {
        return valueOf(name);
    }
}