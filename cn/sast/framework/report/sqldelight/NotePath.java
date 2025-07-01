package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class NotePath {
    private final long __note_array_hash_id;
    private final long note_sequence;
    @Nullable
    private final Long note_stack_depth;
    @Nullable
    private final Long note_is_key_event;
    private final long __note_id;

    public NotePath(long __note_array_hash_id, long note_sequence, @Nullable Long note_stack_depth, 
                   @Nullable Long note_is_key_event, long __note_id) {
        this.__note_array_hash_id = __note_array_hash_id;
        this.note_sequence = note_sequence;
        this.note_stack_depth = note_stack_depth;
        this.note_is_key_event = note_is_key_event;
        this.__note_id = __note_id;
    }

    public long get__note_array_hash_id() {
        return __note_array_hash_id;
    }

    public long getNote_sequence() {
        return note_sequence;
    }

    @Nullable
    public Long getNote_stack_depth() {
        return note_stack_depth;
    }

    @Nullable
    public Long getNote_is_key_event() {
        return note_is_key_event;
    }

    public long get__note_id() {
        return __note_id;
    }

    @NotNull
    public NotePath copy(long __note_array_hash_id, long note_sequence, @Nullable Long note_stack_depth, 
                         @Nullable Long note_is_key_event, long __note_id) {
        return new NotePath(__note_array_hash_id, note_sequence, note_stack_depth, note_is_key_event, __note_id);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof NotePath)) return false;
        NotePath notePath = (NotePath) other;
        return __note_array_hash_id == notePath.__note_array_hash_id &&
               note_sequence == notePath.note_sequence &&
               __note_id == notePath.__note_id &&
               Objects.equals(note_stack_depth, notePath.note_stack_depth) &&
               Objects.equals(note_is_key_event, notePath.note_is_key_event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(__note_array_hash_id, note_sequence, note_stack_depth, note_is_key_event, __note_id);
    }

    @Override
    public String toString() {
        return "NotePath(__note_array_hash_id=" + __note_array_hash_id + 
               ", note_sequence=" + note_sequence + 
               ", note_stack_depth=" + note_stack_depth + 
               ", note_is_key_event=" + note_is_key_event + 
               ", __note_id=" + __note_id + ")";
    }
}