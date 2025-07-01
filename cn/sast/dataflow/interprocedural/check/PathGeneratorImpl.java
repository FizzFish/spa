package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.config.ExtSettings;
import org.jetbrains.annotations.NotNull;

public final class PathGeneratorImpl {
    private static final boolean dataFlowResultPathOnlyStmt = ExtSettings.INSTANCE.getDataFlowResultPathOnlyStmt();

    public static boolean getDataFlowResultPathOnlyStmt() {
        return dataFlowResultPathOnlyStmt;
    }

    private PathGeneratorImpl() {
    }

    public static final class Companion {
        private Companion() {
        }
    }
}