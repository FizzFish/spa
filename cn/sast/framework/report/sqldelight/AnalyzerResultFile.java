package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnalyzerResultFile {
    @NotNull
    private final String fileName;
    @Nullable
    private final String filePath;
    private final long fileId;

    public AnalyzerResultFile(@NotNull String fileName, @Nullable String filePath, long fileId) {
        if (fileName == null) {
            throw new NullPointerException("fileName");
        }
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileId = fileId;
    }

    @NotNull
    public String getFileName() {
        return fileName;
    }

    @Nullable
    public String getFilePath() {
        return filePath;
    }

    public long getFileId() {
        return fileId;
    }

    @Override
    public String toString() {
        return "AnalyzerResultFile(fileName=" + fileName + 
               ", filePath=" + filePath + 
               ", fileId=" + fileId + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalyzerResultFile)) {
            return false;
        }
        AnalyzerResultFile that = (AnalyzerResultFile) other;
        return fileName.equals(that.fileName) &&
               (filePath == null ? that.filePath == null : filePath.equals(that.filePath)) &&
               fileId == that.fileId;
    }

    @Override
    public int hashCode() {
        int result = fileName.hashCode();
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + Long.hashCode(fileId);
        return result;
    }

    public AnalyzerResultFile copy(@NotNull String fileName, @Nullable String filePath, long fileId) {
        return new AnalyzerResultFile(fileName, filePath, fileId);
    }
}