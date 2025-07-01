package cn.sast.framework.report.sqldelight.diagnostic;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class VerifyFile {
    private final long id;
    @Nullable
    private final Long fileId;

    public VerifyFile(long id, @Nullable Long fileId) {
        this.id = id;
        this.fileId = fileId;
    }

    public long getId() {
        return id;
    }

    @Nullable
    public Long getFileId() {
        return fileId;
    }

    @NotNull
    public VerifyFile copy(long id, @Nullable Long fileId) {
        return new VerifyFile(id, fileId);
    }

    @Override
    public String toString() {
        return "VerifyFile(id=" + id + ", fileId=" + fileId + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof VerifyFile)) return false;
        VerifyFile that = (VerifyFile) other;
        return id == that.id && Objects.equals(fileId, that.fileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileId);
    }
}