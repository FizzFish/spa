package cn.sast.api.util;

import cn.sast.api.report.ProjectMetrics;
import org.jetbrains.annotations.NotNull;

public interface IMonitor {
    @NotNull
    ProjectMetrics getProjectMetrics();

    @NotNull
    Timer timer(@NotNull String phase);
}