/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ReportKt
 *  cn.sast.common.IResFile
 *  cn.sast.framework.validator.ActualBugAnnotationData
 *  com.feysh.corax.config.api.CheckType
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.validator;

import cn.sast.api.report.ReportKt;
import cn.sast.common.IResFile;
import com.feysh.corax.config.api.CheckType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2={"Lcn/sast/framework/validator/ActualBugAnnotationData;", "", "file", "Lcn/sast/common/IResFile;", "line", "", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "<init>", "(Lcn/sast/common/IResFile;ILcom/feysh/corax/config/api/CheckType;)V", "getFile", "()Lcn/sast/common/IResFile;", "getLine", "()I", "getCheckType", "()Lcom/feysh/corax/config/api/CheckType;", "toString", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "corax-framework"})
public final class ActualBugAnnotationData {
    @NotNull
    private final IResFile file;
    private final int line;
    @NotNull
    private final CheckType checkType;

    public ActualBugAnnotationData(@NotNull IResFile file, int line, @NotNull CheckType checkType) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        this.file = file;
        this.line = line;
        this.checkType = checkType;
    }

    @NotNull
    public final IResFile getFile() {
        return this.file;
    }

    public final int getLine() {
        return this.line;
    }

    @NotNull
    public final CheckType getCheckType() {
        return this.checkType;
    }

    @NotNull
    public String toString() {
        this.checkType.getBugMessage();
        return this.file + ":" + this.line + " report a [" + ReportKt.getPerfectName((CheckType)this.checkType) + "]";
    }

    @NotNull
    public final IResFile component1() {
        return this.file;
    }

    public final int component2() {
        return this.line;
    }

    @NotNull
    public final CheckType component3() {
        return this.checkType;
    }

    @NotNull
    public final ActualBugAnnotationData copy(@NotNull IResFile file, int line, @NotNull CheckType checkType) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        return new ActualBugAnnotationData(file, line, checkType);
    }

    public static /* synthetic */ ActualBugAnnotationData copy$default(ActualBugAnnotationData actualBugAnnotationData, IResFile iResFile, int n, CheckType checkType, int n2, Object object) {
        if ((n2 & 1) != 0) {
            iResFile = actualBugAnnotationData.file;
        }
        if ((n2 & 2) != 0) {
            n = actualBugAnnotationData.line;
        }
        if ((n2 & 4) != 0) {
            checkType = actualBugAnnotationData.checkType;
        }
        return actualBugAnnotationData.copy(iResFile, n, checkType);
    }

    public int hashCode() {
        int result = this.file.hashCode();
        result = result * 31 + Integer.hashCode(this.line);
        result = result * 31 + this.checkType.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActualBugAnnotationData)) {
            return false;
        }
        ActualBugAnnotationData actualBugAnnotationData = (ActualBugAnnotationData)other;
        if (!Intrinsics.areEqual((Object)this.file, (Object)actualBugAnnotationData.file)) {
            return false;
        }
        if (this.line != actualBugAnnotationData.line) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.checkType, (Object)actualBugAnnotationData.checkType);
    }
}

