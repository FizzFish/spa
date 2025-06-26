/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.ProjectMetrics
 *  cn.sast.api.util.IMonitor
 *  cn.sast.api.util.Timer
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.util;

import cn.sast.api.report.ProjectMetrics;
import cn.sast.api.util.Timer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\n"}, d2={"Lcn/sast/api/util/IMonitor;", "", "projectMetrics", "Lcn/sast/api/report/ProjectMetrics;", "getProjectMetrics", "()Lcn/sast/api/report/ProjectMetrics;", "timer", "Lcn/sast/api/util/Timer;", "phase", "", "corax-api"})
public interface IMonitor {
    @NotNull
    public ProjectMetrics getProjectMetrics();

    @NotNull
    public Timer timer(@NotNull String var1);
}

