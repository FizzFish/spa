/*
 * Copyright (c) 2022, SAS Institute Inc., Cary, NC, USA. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import cn.sast.api.report.Report;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public interface IReportsVisitor extends IResultCollector {
    void accept(@NotNull Collection<Report> reports);
}