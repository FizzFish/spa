package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VerifyControlFlowPath {
    private final long id;
    private final long controlFlowArrayHashId;

    public VerifyControlFlowPath(long id, long controlFlowArrayHashId) {
        this.id = id;
        this.controlFlowArrayHashId = controlFlowArrayHashId;
    }

    public long getId() {
        return id;
    }

    public long getControlFlowArrayHashId() {
        return controlFlowArrayHashId;
    }

    @NotNull
    public VerifyControlFlowPath copy(long id, long controlFlowArrayHashId) {
        return new VerifyControlFlowPath(id, controlFlowArrayHashId);
    }

    @Override
    public @NotNull String toString() {
        return "VerifyControlFlowPath(id=" + id + ", controlFlowArrayHashId=" + controlFlowArrayHashId + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Long.hashCode(controlFlowArrayHashId);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VerifyControlFlowPath)) {
            return false;
        }
        VerifyControlFlowPath that = (VerifyControlFlowPath) other;
        return id == that.id && controlFlowArrayHashId == that.controlFlowArrayHashId;
    }
}