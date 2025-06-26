/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ExpectBugAnnotationData
 *  cn.sast.api.report.ExpectBugAnnotationData$Kind
 *  cn.sast.common.IResFile
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import cn.sast.api.report.ExpectBugAnnotationData;
import cn.sast.common.IResFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001$B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\u000e\u0010\u001c\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010\u001d\u001a\u00020\nH\u00c6\u0003JF\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010#\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\b\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2={"Lcn/sast/api/report/ExpectBugAnnotationData;", "BugT", "", "file", "Lcn/sast/common/IResFile;", "line", "", "column", "bug", "kind", "Lcn/sast/api/report/ExpectBugAnnotationData$Kind;", "<init>", "(Lcn/sast/common/IResFile;IILjava/lang/Object;Lcn/sast/api/report/ExpectBugAnnotationData$Kind;)V", "getFile", "()Lcn/sast/common/IResFile;", "getLine", "()I", "getColumn", "getBug", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getKind", "()Lcn/sast/api/report/ExpectBugAnnotationData$Kind;", "toString", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcn/sast/common/IResFile;IILjava/lang/Object;Lcn/sast/api/report/ExpectBugAnnotationData$Kind;)Lcn/sast/api/report/ExpectBugAnnotationData;", "equals", "", "other", "hashCode", "Kind", "corax-api"})
public final class ExpectBugAnnotationData<BugT> {
    @NotNull
    private final IResFile file;
    private final int line;
    private final int column;
    private final BugT bug;
    @NotNull
    private final Kind kind;

    public ExpectBugAnnotationData(@NotNull IResFile file, int line, int column, BugT bug, @NotNull Kind kind) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        Intrinsics.checkNotNullParameter((Object)kind, (String)"kind");
        this.file = file;
        this.line = line;
        this.column = column;
        this.bug = bug;
        this.kind = kind;
    }

    @NotNull
    public final IResFile getFile() {
        return this.file;
    }

    public final int getLine() {
        return this.line;
    }

    public final int getColumn() {
        return this.column;
    }

    public final BugT getBug() {
        return (BugT)this.bug;
    }

    @NotNull
    public final Kind getKind() {
        return this.kind;
    }

    @NotNull
    public String toString() {
        return "file: " + this.file + ":" + this.line + ":" + this.column + " kind: " + this.kind + " a bug: " + this.bug;
    }

    @NotNull
    public final IResFile component1() {
        return this.file;
    }

    public final int component2() {
        return this.line;
    }

    public final int component3() {
        return this.column;
    }

    public final BugT component4() {
        return (BugT)this.bug;
    }

    @NotNull
    public final Kind component5() {
        return this.kind;
    }

    @NotNull
    public final ExpectBugAnnotationData<BugT> copy(@NotNull IResFile file, int line, int column, BugT bug, @NotNull Kind kind) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        Intrinsics.checkNotNullParameter((Object)kind, (String)"kind");
        return new ExpectBugAnnotationData(file, line, column, bug, kind);
    }

    public static /* synthetic */ ExpectBugAnnotationData copy$default(ExpectBugAnnotationData expectBugAnnotationData, IResFile iResFile, int n, int n2, Object object, Kind kind, int n3, Object object2) {
        if ((n3 & 1) != 0) {
            iResFile = expectBugAnnotationData.file;
        }
        if ((n3 & 2) != 0) {
            n = expectBugAnnotationData.line;
        }
        if ((n3 & 4) != 0) {
            n2 = expectBugAnnotationData.column;
        }
        if ((n3 & 8) != 0) {
            object = expectBugAnnotationData.bug;
        }
        if ((n3 & 0x10) != 0) {
            kind = expectBugAnnotationData.kind;
        }
        return expectBugAnnotationData.copy(iResFile, n, n2, object, kind);
    }

    public int hashCode() {
        int result = this.file.hashCode();
        result = result * 31 + Integer.hashCode(this.line);
        result = result * 31 + Integer.hashCode(this.column);
        result = result * 31 + (this.bug == null ? 0 : this.bug.hashCode());
        result = result * 31 + this.kind.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpectBugAnnotationData)) {
            return false;
        }
        ExpectBugAnnotationData expectBugAnnotationData = (ExpectBugAnnotationData)other;
        if (!Intrinsics.areEqual((Object)this.file, (Object)expectBugAnnotationData.file)) {
            return false;
        }
        if (this.line != expectBugAnnotationData.line) {
            return false;
        }
        if (this.column != expectBugAnnotationData.column) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.bug, (Object)expectBugAnnotationData.bug)) {
            return false;
        }
        return this.kind == expectBugAnnotationData.kind;
    }
}

