/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.Report
 *  cn.sast.framework.report.IFileReportConsumer
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IReportConsumer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.api.report.Report;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IReportConsumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lcn/sast/framework/report/IFileReportConsumer;", "Lcn/sast/framework/report/IReportConsumer;", "flush", "", "reports", "", "Lcn/sast/api/report/Report;", "filename", "", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "(Ljava/util/List;Ljava/lang/String;Lcn/sast/framework/report/IProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-framework"})
public interface IFileReportConsumer
extends IReportConsumer {
    @Nullable
    public Object flush(@NotNull List<Report> var1, @NotNull String var2, @NotNull IProjectFileLocator var3, @NotNull Continuation<? super Unit> var4);
}

