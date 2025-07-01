package cn.sast.framework.report;

import cn.sast.api.config.MainConfig;
import cn.sast.common.IResFile;
import cn.sast.framework.report.sqldelight.AbsoluteFilePath;
import cn.sast.framework.report.sqldelight.Database;
import cn.sast.framework.report.sqldelight.File;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class FileX {
    public static final class ID {
        private final FileX fileX;
        private final long id;

        public ID(FileX fileX, long id) {
            this.fileX = fileX;
            this.id = id;
        }

        public FileX getFileX() {
            return fileX;
        }

        public long getId() {
            return id;
        }
    }

    @NotNull
    private final File file;
    @NotNull
    private final MainConfig.RelativePath relativePath;
    @NotNull
    private final IResFile associateAbsFile;
    @NotNull
    private final List<String> lines;
    @NotNull
    private final String fileAbsPath;

    public FileX(@NotNull File file, 
                 @NotNull MainConfig.RelativePath relativePath,
                 @NotNull IResFile associateAbsFile,
                 @NotNull List<String> lines) {
        if (file == null) throw new IllegalArgumentException("file cannot be null");
        if (relativePath == null) throw new IllegalArgumentException("relativePath cannot be null");
        if (associateAbsFile == null) throw new IllegalArgumentException("associateAbsFile cannot be null");
        if (lines == null) throw new IllegalArgumentException("lines cannot be null");

        this.file = file;
        this.relativePath = relativePath;
        this.associateAbsFile = associateAbsFile;
        this.lines = lines;
        this.fileAbsPath = this.associateAbsFile.toString();
    }

    @NotNull
    public File getFile() {
        return file;
    }

    @NotNull
    public MainConfig.RelativePath getRelativePath() {
        return relativePath;
    }

    @NotNull
    public IResFile getAssociateAbsFile() {
        return associateAbsFile;
    }

    @NotNull
    public List<String> getLines() {
        return lines;
    }

    @NotNull
    public String getFileAbsPath() {
        return fileAbsPath;
    }

    @NotNull
    public ID withId(long id) {
        return new ID(this, id);
    }

    @NotNull
    public ID insert(@NotNull Database db) {
        if (db == null) throw new IllegalArgumentException("db cannot be null");

        db.getFileQueries().insert(
            file.getFile_raw_content_hash(),
            file.getRelative_path(),
            file.getLines(),
            file.getFile_raw_content_size(),
            file.getFile_raw_content()
        );

        long id = db.getFileQueries()
                   .id(file.getFile_raw_content_hash(), file.getRelative_path())
                   .executeAsList()
                   .get(0);

        AbsoluteFilePath absFilePath = new AbsoluteFilePath(
            relativePath.getAbsoluteNormalizePath(),
            id
        );
        db.getAbsoluteFilePathQueries().insert(absFilePath);

        return new ID(this, id);
    }
}