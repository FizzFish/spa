package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import soot.Unit;

public abstract class HeapValuesEnv {
    @NotNull
    private final Unit node;

    public HeapValuesEnv(@NotNull Unit node) {
        if (node == null) {
            throw new IllegalArgumentException("node must not be null");
        }
        this.node = node;
    }

    @NotNull
    public final Unit getNode() {
        return node;
    }

    @NotNull
    @Override
    public String toString() {
        return "Env *" + node.getJavaSourceStartLineNumber() + " " + node;
    }
}