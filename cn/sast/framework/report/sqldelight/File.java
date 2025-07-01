package cn.sast.framework.report.sqldelight;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class File {
    private final long id;
    @NotNull
    private final String fileRawContentHash;
    @NotNull
    private final String relativePath;
    private final long lines;
    @Nullable
    private final String encoding;
    private final long fileRawContentSize;
    @NotNull
    private final byte[] fileRawContent;

    public File(long id, @NotNull String fileRawContentHash, @NotNull String relativePath, 
                long lines, @Nullable String encoding, long fileRawContentSize, 
                @NotNull byte[] fileRawContent) {
        if (fileRawContentHash == null) {
            throw new IllegalArgumentException("fileRawContentHash cannot be null");
        }
        if (relativePath == null) {
            throw new IllegalArgumentException("relativePath cannot be null");
        }
        if (fileRawContent == null) {
            throw new IllegalArgumentException("fileRawContent cannot be null");
        }
        this.id = id;
        this.fileRawContentHash = fileRawContentHash;
        this.relativePath = relativePath;
        this.lines = lines;
        this.encoding = encoding;
        this.fileRawContentSize = fileRawContentSize;
        this.fileRawContent = fileRawContent;
    }

    public long getId() {
        return id;
    }

    @NotNull
    public String getFileRawContentHash() {
        return fileRawContentHash;
    }

    @NotNull
    public String getRelativePath() {
        return relativePath;
    }

    public long getLines() {
        return lines;
    }

    @Nullable
    public String getEncoding() {
        return encoding;
    }

    public long getFileRawContentSize() {
        return fileRawContentSize;
    }

    @NotNull
    public byte[] getFileRawContent() {
        return fileRawContent;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof File)) return false;
        
        File file = (File) other;
        return id == file.id &&
                lines == file.lines &&
                fileRawContentSize == file.fileRawContentSize &&
                fileRawContentHash.equals(file.fileRawContentHash) &&
                relativePath.equals(file.relativePath) &&
                (encoding == null ? file.encoding == null : encoding.equals(file.encoding)) &&
                Arrays.equals(fileRawContent, file.fileRawContent);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + fileRawContentHash.hashCode();
        result = 31 * result + relativePath.hashCode();
        result = 31 * result + Long.hashCode(lines);
        result = 31 * result + (encoding != null ? encoding.hashCode() : 0);
        result = 31 * result + Long.hashCode(fileRawContentSize);
        result = 31 * result + Arrays.hashCode(fileRawContent);
        return result;
    }

    @Override
    public String toString() {
        return "File(id=" + id + 
               ", fileRawContentHash=" + fileRawContentHash + 
               ", relativePath=" + relativePath + 
               ", lines=" + lines + 
               ", encoding=" + encoding + 
               ", fileRawContentSize=" + fileRawContentSize + 
               ", fileRawContent=" + Arrays.toString(fileRawContent) + ")";
    }

    public File copy(long id, @NotNull String fileRawContentHash, @NotNull String relativePath, 
                     long lines, @Nullable String encoding, long fileRawContentSize, 
                     @NotNull byte[] fileRawContent) {
        return new File(id, fileRawContentHash, relativePath, lines, encoding, fileRawContentSize, fileRawContent);
    }
}