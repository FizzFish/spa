package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbsoluteFilePath {
    @NotNull
    private final String fileAbsPath;
    private final long fileId;

    public AbsoluteFilePath(@NotNull String fileAbsPath, long fileId) {
        if (fileAbsPath == null) {
            throw new IllegalArgumentException("fileAbsPath cannot be null");
        }
        this.fileAbsPath = fileAbsPath;
        this.fileId = fileId;
    }

    @NotNull
    public String getFileAbsPath() {
        return fileAbsPath;
    }

    public long getFileId() {
        return fileId;
    }

    @NotNull
    public AbsoluteFilePath copy(@NotNull String fileAbsPath, long fileId) {
        if (fileAbsPath == null) {
            throw new IllegalArgumentException("fileAbsPath cannot be null");
        }
        return new AbsoluteFilePath(fileAbsPath, fileId);
    }

    @Override
    public String toString() {
        return "AbsoluteFilePath(fileAbsPath=" + fileAbsPath + ", fileId=" + fileId + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof AbsoluteFilePath)) return false;
        AbsoluteFilePath that = (AbsoluteFilePath) other;
        return fileId == that.fileId && fileAbsPath.equals(that.fileAbsPath);
    }

    @Override
    public int hashCode() {
        int result = fileAbsPath.hashCode();
        result = 31 * result + Long.hashCode(fileId);
        return result;
    }
}