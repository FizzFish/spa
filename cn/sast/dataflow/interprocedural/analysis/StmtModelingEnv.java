package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.check.ModelingStmtInfo;
import org.jetbrains.annotations.NotNull;
import soot.Unit;

public final class StmtModelingEnv extends HeapValuesEnv {
    @NotNull
    private final ModelingStmtInfo info;

    public StmtModelingEnv(@NotNull Unit u, @NotNull ModelingStmtInfo info) {
        super(u);
        if (u == null) {
            throw new IllegalArgumentException("u cannot be null");
        }
        if (info == null) {
            throw new IllegalArgumentException("info cannot be null");
        }
        this.info = info;
    }

    @NotNull
    public ModelingStmtInfo getInfo() {
        return info;
    }
}