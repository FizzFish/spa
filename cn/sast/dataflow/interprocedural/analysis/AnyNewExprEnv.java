package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.Unit;

public final class AnyNewExprEnv extends HeapValuesEnv {
    @NotNull
    private final SootMethod method;

    public AnyNewExprEnv(@NotNull SootMethod method, @NotNull Unit u) {
        super(u);
        if (method == null) throw new NullPointerException("method");
        if (u == null) throw new NullPointerException("u");
        this.method = method;
    }

    @NotNull
    public SootMethod getMethod() {
        return method;
    }
}