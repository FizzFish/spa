/*
 * Copyright (c) 2022, Feysh LLC. All rights reserved.
 */
package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import cn.sast.framework.engine.PreAnalysisReportEnv;
import com.feysh.corax.config.api.CheckType;
import org.jetbrains.annotations.NotNull;

public interface IPreAnalysisResultCollector extends IResultCollector {
    void report(@NotNull CheckType checkType, @NotNull PreAnalysisReportEnv info);
}