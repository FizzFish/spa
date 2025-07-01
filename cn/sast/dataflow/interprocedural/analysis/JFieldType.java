package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import soot.Type;

public abstract class JFieldType {
    protected JFieldType() {
    }

    @NotNull
    public abstract Type getType();

    @NotNull
    public abstract String getName();
}