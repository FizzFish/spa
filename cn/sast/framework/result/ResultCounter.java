package cn.sast.framework.result;

import cn.sast.api.report.Report;
import cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis;
import cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector;
import cn.sast.framework.engine.PreAnalysisReportEnv;
import cn.sast.framework.result.IBuiltInAnalysisCollector;
import cn.sast.framework.result.IFlowDroidResultCollector;
import cn.sast.framework.result.IPreAnalysisResultCollector;
import cn.sast.framework.result.IUTBotResultCollector;
import com.feysh.corax.config.api.CheckType;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ResultCounter implements IFlowDroidResultCollector,
        IUTBotResultCollector,
        IIPAnalysisResultCollector,
        IPreAnalysisResultCollector,
        IBuiltInAnalysisCollector {

    private static final Logger logger = LoggerFactory.getLogger(ResultCounter.class);
    
    private final AtomicInteger infoflowResCount = new AtomicInteger(0);
    private final AtomicInteger infoflowAbsAtSinkCount = new AtomicInteger(0);
    private final AtomicInteger symbolicUTbotCount = new AtomicInteger(0);
    private final AtomicInteger dataFlowCount = new AtomicInteger(0);
    private final AtomicInteger builtInAnalysisCount = new AtomicInteger(0);
    private final AtomicInteger preAnalysisResultCount = new AtomicInteger(0);

    public AtomicInteger getInfoflowResCount() {
        return infoflowResCount;
    }

    public AtomicInteger getInfoflowAbsAtSinkCount() {
        return infoflowAbsAtSinkCount;
    }

    public AtomicInteger getSymbolicUTbotCount() {
        return symbolicUTbotCount;
    }

    public AtomicInteger getDataFlowCount() {
        return dataFlowCount;
    }

    public AtomicInteger getBuiltInAnalysisCount() {
        return builtInAnalysisCount;
    }

    public AtomicInteger getPreAnalysisResultCount() {
        return preAnalysisResultCount;
    }

    @Override
    public void onResultsAvailable(@NotNull IInfoflowCFG cfg, @NotNull InfoflowResults results) {
        infoflowResCount.addAndGet(results.size());
    }

    @Override
    public boolean onResultAvailable(@NotNull IInfoflowCFG icfg, @NotNull AbstractionAtSink abs) {
        infoflowAbsAtSinkCount.incrementAndGet();
        return true;
    }

    @Override
    public void addUtState() {
        symbolicUTbotCount.incrementAndGet();
    }

    @Override
    public void afterAnalyze(@NotNull InterProceduralValueAnalysis analysis) {
        // No action needed
    }

    @Override
    public void reportDataFlowBug(@NotNull List<Report> reports) {
        dataFlowCount.addAndGet(reports.size());
    }

    @Override
    public void report(@NotNull CheckType checkType, @NotNull PreAnalysisReportEnv info) {
        preAnalysisResultCount.incrementAndGet();
    }

    @Override
    public void report(@NotNull Report report) {
        builtInAnalysisCount.incrementAndGet();
    }

    public void flush() {
        logger.info("num of infoflow results: {}", infoflowResCount.get());
        logger.info("num of infoflow abstraction at sink: {}", infoflowAbsAtSinkCount.get());
        logger.info("num of symbolic execution results: {}", symbolicUTbotCount.get());
        logger.info("num of PreAnalysis results: {}", preAnalysisResultCount.get());
        logger.info("num of built-in Analysis results: {}", builtInAnalysisCount.get());
        logger.info("num of AbstractInterpretationAnalysis results: {}", dataFlowCount.get());
    }
}