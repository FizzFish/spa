/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.FileResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.IReportHashCalculator
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.IReportHashCalculator;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\u0011\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f\u00a8\u0006\u001d"}, d2={"Lcn/sast/api/report/FileResInfo;", "Lcn/sast/api/report/IBugResInfo;", "sourcePath", "Lcn/sast/common/IResFile;", "<init>", "(Lcn/sast/common/IResFile;)V", "getSourcePath", "()Lcn/sast/common/IResFile;", "abs", "getAbs", "abs$delegate", "Lkotlin/Lazy;", "reportFileName", "", "getReportFileName", "()Ljava/lang/String;", "reportHash", "c", "Lcn/sast/api/report/IReportHashCalculator;", "hashCode", "", "equals", "", "other", "", "path", "getPath", "compareTo", "toString", "corax-api"})
@SourceDebugExtension(value={"SMAP\nReport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Report.kt\ncn/sast/api/report/FileResInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,451:1\n1#2:452\n*E\n"})
public final class FileResInfo
extends IBugResInfo {
    @NotNull
    private final IResFile sourcePath;
    @NotNull
    private final Lazy abs$delegate;

    public FileResInfo(@NotNull IResFile sourcePath) {
        Intrinsics.checkNotNullParameter((Object)sourcePath, (String)"sourcePath");
        super(null);
        this.sourcePath = sourcePath;
        this.abs$delegate = LazyKt.lazy(() -> FileResInfo.abs_delegate$lambda$0(this));
    }

    @NotNull
    public final IResFile getSourcePath() {
        return this.sourcePath;
    }

    @NotNull
    public final IResFile getAbs() {
        Lazy lazy = this.abs$delegate;
        return (IResFile)lazy.getValue();
    }

    @NotNull
    public String getReportFileName() {
        return this.sourcePath.getName();
    }

    @NotNull
    public String reportHash(@NotNull IReportHashCalculator c) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        return c.fromAbsPath((IResource)this.getAbs());
    }

    public int hashCode() {
        return this.getAbs().toString().hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FileResInfo)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.getAbs().toString(), (Object)((FileResInfo)other).getAbs().toString());
    }

    @NotNull
    public String getPath() {
        return StringsKt.replace$default((String)this.getAbs().toString(), (String)":", (String)"-", (boolean)false, (int)4, null);
    }

    public int compareTo(@NotNull IBugResInfo other) {
        Integer n;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        if (!(other instanceof FileResInfo)) {
            String string = this.getClass().getSimpleName();
            String string2 = other.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getSimpleName(...)");
            return string.compareTo(string2);
        }
        Integer n2 = this.sourcePath.compareTo((Object)((FileResInfo)other).sourcePath);
        int it = ((Number)n2).intValue();
        boolean bl = false;
        Integer n3 = n = it != 0 ? n2 : null;
        if (n != null) {
            it = ((Number)n).intValue();
            boolean bl2 = false;
            return it;
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "FileResInfo(file=" + this.getAbs() + ")";
    }

    private static final IResFile abs_delegate$lambda$0(FileResInfo this$0) {
        return this$0.sourcePath.getAbsolute().getNormalize();
    }
}

