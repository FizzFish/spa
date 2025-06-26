/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IReportHashCalculator
 *  cn.sast.common.IResource
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootMethod
 */
package cn.sast.api.report;

import cn.sast.common.IResource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2={"Lcn/sast/api/report/IReportHashCalculator;", "", "from", "", "clazz", "Lsoot/SootClass;", "method", "Lsoot/SootMethod;", "fromAbsPath", "absolutePath", "Lcn/sast/common/IResource;", "fromPath", "path", "corax-api"})
public interface IReportHashCalculator {
    @NotNull
    public String from(@NotNull SootClass var1);

    @NotNull
    public String from(@NotNull SootMethod var1);

    @NotNull
    public String fromAbsPath(@NotNull IResource var1);

    @NotNull
    public String fromPath(@NotNull IResource var1);
}

