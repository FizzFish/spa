package cn.sast.api.report;

import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class FileResInfo extends IBugResInfo {
    @NotNull
    private final IResFile sourcePath;
    private final IResFile abs;

    public FileResInfo(@NotNull IResFile sourcePath) {
        super(null);
        this.sourcePath = Objects.requireNonNull(sourcePath, "sourcePath");
        this.abs = sourcePath.getAbsolute().getNormalize();
    }

    @NotNull
    public IResFile getSourcePath() {
        return sourcePath;
    }

    @NotNull
    public IResFile getAbs() {
        return abs;
    }

    @NotNull
    public String getReportFileName() {
        return sourcePath.getName();
    }

    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        Objects.requireNonNull(c, "c");
        return c.fromAbsPath(getAbs());
    }

    @Override
    public int hashCode() {
        return getAbs().toString().hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FileResInfo)) {
            return false;
        }
        FileResInfo that = (FileResInfo) other;
        return getAbs().toString().equals(that.getAbs().toString());
    }

    @NotNull
    public String getPath() {
        return getAbs().toString().replace(":", "-");
    }

    @Override
    public int compareTo(@NotNull IBugResInfo other) {
        Objects.requireNonNull(other, "other");
        if (!(other instanceof FileResInfo)) {
            return getClass().getSimpleName().compareTo(other.getClass().getSimpleName());
        }
        FileResInfo that = (FileResInfo) other;
        int cmp = sourcePath.compareTo(that.sourcePath);
        return cmp != 0 ? cmp : 0;
    }

    @Override
    @NotNull
    public String toString() {
        return "FileResInfo(file=" + getAbs() + ")";
    }
}