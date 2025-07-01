package cn.sast.framework.report;

import cn.sast.common.IResFile;
import org.jetbrains.annotations.NotNull;

public final class FileID {
    private final long id;
    private final @NotNull IResFile associateAbsFile;
    private final @NotNull String fileAbsPath;

    public FileID(long id, @NotNull IResFile associateAbsFile) {
        if (associateAbsFile == null) {
            throw new NullPointerException("associateAbsFile cannot be null");
        }
        this.id = id;
        this.associateAbsFile = associateAbsFile;
        this.fileAbsPath = associateAbsFile.toString();
    }

    public long getId() {
        return id;
    }

    public @NotNull IResFile getAssociateAbsFile() {
        return associateAbsFile;
    }

    public @NotNull String getFileAbsPath() {
        return fileAbsPath;
    }
}