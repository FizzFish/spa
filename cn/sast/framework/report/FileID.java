/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.FileID
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report;

import cn.sast.common.IResFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lcn/sast/framework/report/FileID;", "", "id", "", "associateAbsFile", "Lcn/sast/common/IResFile;", "<init>", "(JLcn/sast/common/IResFile;)V", "getId", "()J", "getAssociateAbsFile", "()Lcn/sast/common/IResFile;", "fileAbsPath", "", "getFileAbsPath", "()Ljava/lang/String;", "corax-framework"})
public final class FileID {
    private final long id;
    @NotNull
    private final IResFile associateAbsFile;
    @NotNull
    private final String fileAbsPath;

    public FileID(long id, @NotNull IResFile associateAbsFile) {
        Intrinsics.checkNotNullParameter((Object)associateAbsFile, (String)"associateAbsFile");
        this.id = id;
        this.associateAbsFile = associateAbsFile;
        this.fileAbsPath = this.associateAbsFile.toString();
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final IResFile getAssociateAbsFile() {
        return this.associateAbsFile;
    }

    @NotNull
    public final String getFileAbsPath() {
        return this.fileAbsPath;
    }
}

