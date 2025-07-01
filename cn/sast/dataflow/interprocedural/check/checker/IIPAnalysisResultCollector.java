package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.api.report.IResultCollector;
import cn.sast.api.report.Report;
import cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface IIPAnalysisResultCollector extends IResultCollector {
    void afterAnalyze(@NotNull InterProceduralValueAnalysis analysis);

    void reportDataFlowBug(@NotNull List<Report> reports);
}