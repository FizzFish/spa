/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.IResultCollector
 *  cn.sast.api.report.Report
 *  cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis
 *  cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.api.report.IResultCollector;
import cn.sast.api.report.Report;
import cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&\u00a8\u0006\n"}, d2={"Lcn/sast/dataflow/interprocedural/check/checker/IIPAnalysisResultCollector;", "Lcn/sast/api/report/IResultCollector;", "afterAnalyze", "", "analysis", "Lcn/sast/dataflow/interprocedural/check/InterProceduralValueAnalysis;", "reportDataFlowBug", "reports", "", "Lcn/sast/api/report/Report;", "corax-data-flow"})
public interface IIPAnalysisResultCollector
extends IResultCollector {
    public void afterAnalyze(@NotNull InterProceduralValueAnalysis var1);

    public void reportDataFlowBug(@NotNull List<Report> var1);
}

