package cn.sast.dataflow.interprocedural.check;

import org.jetbrains.annotations.NotNull;

public enum BuiltInModelT {
    Field,
    Array,
    Element,
    MapKeys,
    MapValues;

    @NotNull
    public static BuiltInModelT[] getEntries() {
        return values();
    }
}