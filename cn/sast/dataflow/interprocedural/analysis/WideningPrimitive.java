package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;

public final class WideningPrimitive {
    @NotNull
    public static final WideningPrimitive INSTANCE = new WideningPrimitive();

    private WideningPrimitive() {
    }
}