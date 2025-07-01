package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import soot.Unit;

public final class HookEnv extends HeapValuesEnv {
    @NotNull
    private final AIContext ctx;

    public HookEnv(@NotNull AIContext ctx, @NotNull Unit u) {
        super(u);
        this.ctx = ctx;
    }

    @NotNull
    public AIContext getCtx() {
        return ctx;
    }
}