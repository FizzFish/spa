package cn.sast.framework.report.sqldelight.note;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Verify_file {
    private final long id;
    private final long __file_id;

    public Verify_file(long id, long __file_id) {
        this.id = id;
        this.__file_id = __file_id;
    }

    public long getId() {
        return id;
    }

    public long get__file_id() {
        return __file_id;
    }

    @NotNull
    public Verify_file copy(long id, long __file_id) {
        return new Verify_file(id, __file_id);
    }

    @Override
    public @NotNull String toString() {
        return "Verify_file(id=" + id + ", __file_id=" + __file_id + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Long.hashCode(__file_id);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Verify_file)) return false;
        Verify_file that = (Verify_file) other;
        return id == that.id && __file_id == that.__file_id;
    }
}