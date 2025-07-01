package cn.sast.api.report;

import org.jetbrains.annotations.NotNull;

public interface IReportHashAble {
    @NotNull
    String reportHash(@NotNull IReportHashCalculator calculator);
}