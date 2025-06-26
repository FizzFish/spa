/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.IReportHashAble
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import cn.sast.api.report.IReportHashAble;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\t\b\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\b\u0082\u0001\u0002\u000b\f\u00a8\u0006\r"}, d2={"Lcn/sast/api/report/IBugResInfo;", "", "Lcn/sast/api/report/IReportHashAble;", "<init>", "()V", "reportFileName", "", "getReportFileName", "()Ljava/lang/String;", "path", "getPath", "Lcn/sast/api/report/ClassResInfo;", "Lcn/sast/api/report/FileResInfo;", "corax-api"})
public abstract class IBugResInfo
implements Comparable<IBugResInfo>,
IReportHashAble {
    private IBugResInfo() {
    }

    @Nullable
    public abstract String getReportFileName();

    @NotNull
    public abstract String getPath();

    public /* synthetic */ IBugResInfo(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

