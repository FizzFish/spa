package cn.sast.framework.report.sqldelight.controlFlow;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Verify_file {
    private final long id;
    private final long fileId;

    public Verify_file(long id, long fileId) {
        this.id = id;
        this.fileId = fileId;
    }

    public long getId() {
        return id;
    }

    public long getFileId() {
        return fileId;
    }

    @NotNull
    public Verify_file copy(long id, long fileId) {
        return new Verify_file(id, fileId);
    }

    @Override
    public @NotNull String toString() {
        return "Verify_file(id=" + id + ", fileId=" + fileId + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Long.hashCode(fileId);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Verify_file)) return false;
        Verify_file that = (Verify_file) other;
        return id == that.id && fileId == that.fileId;
    }
}