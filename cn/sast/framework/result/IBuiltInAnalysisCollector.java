package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import cn.sast.api.report.Report;
import org.jetbrains.annotations.NotNull;

public interface IBuiltInAnalysisCollector extends IResultCollector {
    void report(@NotNull Report report);
}