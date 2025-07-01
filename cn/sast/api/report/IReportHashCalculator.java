/*
 * Copyright (c) 2022, SAS Institute Inc., Cary, NC, USA. All Rights Reserved.
 */
package cn.sast.api.report;

import cn.sast.common.IResource;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootMethod;

public interface IReportHashCalculator {
    @NotNull
    String from(@NotNull SootClass clazz);

    @NotNull
    String from(@NotNull SootMethod method);

    @NotNull
    String fromAbsPath(@NotNull IResource absolutePath);

    @NotNull
    String fromPath(@NotNull IResource path);
}