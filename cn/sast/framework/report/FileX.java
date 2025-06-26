/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig$RelativePath
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.FileX
 *  cn.sast.framework.report.FileX$ID
 *  cn.sast.framework.report.sqldelight.AbsoluteFilePath
 *  cn.sast.framework.report.sqldelight.Database
 *  cn.sast.framework.report.sqldelight.File
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report;

import cn.sast.api.config.MainConfig;
import cn.sast.common.IResFile;
import cn.sast.framework.report.FileX;
import cn.sast.framework.report.sqldelight.AbsoluteFilePath;
import cn.sast.framework.report.sqldelight.Database;
import cn.sast.framework.report.sqldelight.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u00060\u0019R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2={"Lcn/sast/framework/report/FileX;", "", "file", "Lcn/sast/framework/report/sqldelight/File;", "relativePath", "Lcn/sast/api/config/MainConfig$RelativePath;", "associateAbsFile", "Lcn/sast/common/IResFile;", "lines", "", "", "<init>", "(Lcn/sast/framework/report/sqldelight/File;Lcn/sast/api/config/MainConfig$RelativePath;Lcn/sast/common/IResFile;Ljava/util/List;)V", "getFile", "()Lcn/sast/framework/report/sqldelight/File;", "getRelativePath", "()Lcn/sast/api/config/MainConfig$RelativePath;", "getAssociateAbsFile", "()Lcn/sast/common/IResFile;", "getLines", "()Ljava/util/List;", "fileAbsPath", "getFileAbsPath", "()Ljava/lang/String;", "withId", "Lcn/sast/framework/report/FileX$ID;", "id", "", "insert", "db", "Lcn/sast/framework/report/sqldelight/Database;", "ID", "corax-framework"})
public final class FileX {
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

    public FileX(@NotNull File file, @NotNull MainConfig.RelativePath relativePath, @NotNull IResFile associateAbsFile, @NotNull List<String> lines2) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        Intrinsics.checkNotNullParameter((Object)relativePath, (String)"relativePath");
        Intrinsics.checkNotNullParameter((Object)associateAbsFile, (String)"associateAbsFile");
        Intrinsics.checkNotNullParameter(lines2, (String)"lines");
        this.file = file;
        this.relativePath = relativePath;
        this.associateAbsFile = associateAbsFile;
        this.lines = lines2;
        this.fileAbsPath = this.associateAbsFile.toString();
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @NotNull
    public final MainConfig.RelativePath getRelativePath() {
        return this.relativePath;
    }

    @NotNull
    public final IResFile getAssociateAbsFile() {
        return this.associateAbsFile;
    }

    @NotNull
    public final List<String> getLines() {
        return this.lines;
    }

    @NotNull
    public final String getFileAbsPath() {
        return this.fileAbsPath;
    }

    @NotNull
    public final ID withId(long id) {
        return new ID(this, id);
    }

    @NotNull
    public final ID insert(@NotNull Database db) {
        Intrinsics.checkNotNullParameter((Object)db, (String)"db");
        db.getFileQueries().insert(this.file.getFile_raw_content_hash(), this.file.getRelative_path(), this.file.getLines(), this.file.getFile_raw_content_size(), this.file.getFile_raw_content());
        long id = ((Number)CollectionsKt.first((List)db.getFileQueries().id(this.file.getFile_raw_content_hash(), this.file.getRelative_path()).executeAsList())).longValue();
        AbsoluteFilePath absFilePath = new AbsoluteFilePath(this.relativePath.getAbsoluteNormalizePath(), id);
        db.getAbsoluteFilePathQueries().insert(absFilePath);
        return new ID(this, id);
    }
}

