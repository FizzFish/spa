/*
 * Copyright (c) 2022, SAP SE. All rights reserved.
 */
package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

public interface IMissingSummaryReporter extends IResultCollector {
    void reportMissingMethod(@NotNull SootMethod method);
}