package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ControlFlowPath {
    private final long __control_flow_array_hash_id;
    private final long control_flow_sequence;
    private final long __control_flow_id;

    public ControlFlowPath(long __control_flow_array_hash_id, long control_flow_sequence, long __control_flow_id) {
        this.__control_flow_array_hash_id = __control_flow_array_hash_id;
        this.control_flow_sequence = control_flow_sequence;
        this.__control_flow_id = __control_flow_id;
    }

    public long get__control_flow_array_hash_id() {
        return __control_flow_array_hash_id;
    }

    public long getControl_flow_sequence() {
        return control_flow_sequence;
    }

    public long get__control_flow_id() {
        return __control_flow_id;
    }

    @NotNull
    public ControlFlowPath copy(long __control_flow_array_hash_id, long control_flow_sequence, long __control_flow_id) {
        return new ControlFlowPath(__control_flow_array_hash_id, control_flow_sequence, __control_flow_id);
    }

    @Override
    public @NotNull String toString() {
        return "ControlFlowPath(__control_flow_array_hash_id=" + __control_flow_array_hash_id + 
               ", control_flow_sequence=" + control_flow_sequence + 
               ", __control_flow_id=" + __control_flow_id + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(__control_flow_array_hash_id);
        result = 31 * result + Long.hashCode(control_flow_sequence);
        result = 31 * result + Long.hashCode(__control_flow_id);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ControlFlowPath)) return false;
        
        ControlFlowPath that = (ControlFlowPath) other;
        return __control_flow_array_hash_id == that.__control_flow_array_hash_id &&
               control_flow_sequence == that.control_flow_sequence &&
               __control_flow_id == that.__control_flow_id;
    }
}