package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import org.jetbrains.annotations.NotNull;
import soot.Unit;
import soot.jimple.internal.JNopStmt;

public final class HeapValuesEnvImpl extends HeapValuesEnv {
    private static final JNopStmt phantomUnit = new JNopStmt();

    public HeapValuesEnvImpl(@NotNull Unit node) {
        super(node);
    }

    public HeapValuesEnvImpl(@NotNull IPath p) {
        this(p.getNode());
    }

    public static JNopStmt getPhantomUnit() {
        return phantomUnit;
    }
}