/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IResultCollector
 *  cn.sast.api.report.Report
 *  cn.sast.framework.result.IBuiltInAnalysisCollector
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.result;

import cn.sast.api.report.IResultCollector;
import cn.sast.api.report.Report;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2={"Lcn/sast/framework/result/IBuiltInAnalysisCollector;", "Lcn/sast/api/report/IResultCollector;", "report", "", "Lcn/sast/api/report/Report;", "corax-framework"})
public interface IBuiltInAnalysisCollector
extends IResultCollector {
    public void report(@NotNull Report var1);
}

