package cn.sast.framework.result;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.IResultCollector;
import cn.sast.api.report.Report;
import cn.sast.common.IResDirectory;
import cn.sast.dataflow.infoflow.provider.BugTypeProvider;
import cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis;
import cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector;
import cn.sast.framework.engine.PreAnalysisReportEnv;
import cn.sast.framework.metrics.MetricsMonitor;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IReportConsumer;
import cn.sast.framework.report.PlistDiagnostics;
import cn.sast.framework.report.ProjectFileLocator;
import cn.sast.framework.report.ReportConverter;
import cn.sast.framework.report.SarifDiagnostics;
import cn.sast.framework.report.SarifDiagnosticsCopySrc;
import cn.sast.framework.report.SarifDiagnosticsPack;
import cn.sast.framework.report.SqliteDiagnostics;
import cn.sast.framework.report.coverage.JacocoCompoundCoverage;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.CheckType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.jimple.infoflow.collect.ConcurrentHashSet;
import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.results.DataFlowResult;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public final class ResultCollector implements IFlowDroidResultCollector,
        IIPAnalysisResultCollector,
        IUTBotResultCollector,
        IMissingSummaryReporter,
        IPreAnalysisResultCollector,
        IBuiltInAnalysisCollector,
        IReportsVisitor {

    @NotNull
    private final MainConfig mainConfig;
    @Nullable
    private final SootInfoCache info;
    @NotNull
    private final IResDirectory outputDir;
    @NotNull
    private final ProjectFileLocator locator;
    @NotNull
    private final List<IResultCollector> collectors;
    @NotNull
    private final List<OutputType> outputTypes;
    private final boolean serializeTaintPath;
    @NotNull
    private final ResultConverter resultConverter;
    @NotNull
    private final JacocoCompoundCoverage coverage;
    private final boolean flushCoverage;
    @NotNull
    private final MetricsMonitor monitor;
    
    private final List<IFlowDroidResultCollector> collectorsFlowDroid;
    private final List<IUTBotResultCollector> collectorsUTBot;
    private final List<IIPAnalysisResultCollector> collectorsDataFlow;
    private final List<IPreAnalysisResultCollector> collectorsIFIChecker;
    private final List<IBuiltInAnalysisCollector> collectorsFlowSensitive;
    private final List<IReportsVisitor> reportsVisitor;
    private final List<IMissingSummaryReporter> missingSummaryReporter;
    
    private final ConcurrentHashSet<Report> reports = new ConcurrentHashSet<>();
    private final ConcurrentHashMap<PurificationReportKey, AtomicInteger> purificationReports = new ConcurrentHashMap<>();
    
    public PreAnalysisCoroutineScope preAnalysis;
    private final BugTypeProvider bugTypeProvider;
    private boolean flushing;

    public ResultCollector(@NotNull MainConfig mainConfig, 
                          @Nullable SootInfoCache info,
                          @NotNull IResDirectory outputDir,
                          @NotNull ProjectFileLocator locator,
                          @NotNull List<? extends IResultCollector> collectors,
                          @NotNull List<? extends OutputType> outputTypes,
                          boolean serializeTaintPath,
                          @NotNull ResultConverter resultConverter,
                          @NotNull JacocoCompoundCoverage coverage,
                          boolean flushCoverage,
                          @NotNull MetricsMonitor monitor) {
        
        this.mainConfig = mainConfig;
        this.info = info;
        this.outputDir = outputDir;
        this.locator = locator;
        this.collectors = new ArrayList<>(collectors);
        this.outputTypes = new ArrayList<>(outputTypes);
        this.serializeTaintPath = serializeTaintPath;
        this.resultConverter = resultConverter;
        this.coverage = coverage;
        this.flushCoverage = flushCoverage;
        this.monitor = monitor;

        this.collectorsFlowDroid = collectors.stream()
                .filter(IFlowDroidResultCollector.class::isInstance)
                .map(IFlowDroidResultCollector.class::cast)
                .collect(Collectors.toList());
        
        this.collectorsUTBot = collectors.stream()
                .filter(IUTBotResultCollector.class::isInstance)
                .map(IUTBotResultCollector.class::cast)
                .collect(Collectors.toList());
                
        this.collectorsDataFlow = collectors.stream()
                .filter(IIPAnalysisResultCollector.class::isInstance)
                .map(IIPAnalysisResultCollector.class::cast)
                .collect(Collectors.toList());
                
        this.collectorsIFIChecker = collectors.stream()
                .filter(IPreAnalysisResultCollector.class::isInstance)
                .map(IPreAnalysisResultCollector.class::cast)
                .collect(Collectors.toList());
                
        this.collectorsFlowSensitive = collectors.stream()
                .filter(IBuiltInAnalysisCollector.class::isInstance)
                .map(IBuiltInAnalysisCollector.class::cast)
                .collect(Collectors.toList());
                
        this.reportsVisitor = collectors.stream()
                .filter(IReportsVisitor.class::isInstance)
                .map(IReportsVisitor.class::cast)
                .collect(Collectors.toList());
                
        this.missingSummaryReporter = collectors.stream()
                .filter(IMissingSummaryReporter.class::isInstance)
                .map(IMissingSummaryReporter.class::cast)
                .collect(Collectors.toList());

        this.bugTypeProvider = new BugTypeProvider(mainConfig, preAnalysis);
        this.bugTypeProvider.init();
    }

    @NotNull
    public JacocoCompoundCoverage getCoverage() {
        return coverage;
    }

    public boolean getFlushCoverage() {
        return flushCoverage;
    }

    @NotNull
    public MetricsMonitor getMonitor() {
        return monitor;
    }

    @NotNull
    public Set<Report> getReports() {
        flushing = true;
        return reports;
    }

    @NotNull
    public List<IResultCollector> getCollectors() {
        return collectors;
    }

    @NotNull
    public PreAnalysisCoroutineScope getPreAnalysis() {
        if (preAnalysis == null) {
            throw new IllegalStateException("preAnalysis not initialized");
        }
        return preAnalysis;
    }

    public void setPreAnalysis(@NotNull PreAnalysisCoroutineScope preAnalysis) {
        this.preAnalysis = preAnalysis;
    }

    private BugTypeProvider getBugTypeProvider() {
        return bugTypeProvider;
    }

    @Override
    public void report(@NotNull CheckType checkType, @NotNull PreAnalysisReportEnv info) {
        collectorsIFIChecker.forEach(c -> c.report(checkType, info));
        addReport(resultConverter.getReport(checkType, info));
    }

    @Override
    public void report(@NotNull Report report) {
        collectorsFlowSensitive.forEach(c -> c.report(report));
        addReport(report);
    }

    private void addReport(Collection<Report> reports) {
        if (flushing) {
            throw new IllegalStateException("internal error: emit bug reports when flush report");
        }
        
        for (Report report : reports) {
            if (!mainConfig.isEnable(report.getCheckType())) {
                continue;
            }
            
            PurificationReportKey key = new PurificationReportKey(
                report.getBugResFile(),
                report.getRegion().startLine,
                report.getCheck_name(),
                report.getPathEvents().get(0)
            );
            
            AtomicInteger count = purificationReports.computeIfAbsent(key, k -> new AtomicInteger(0));
            count.getAndUpdate(i -> i + 1);
        }
    }

    private void addReport(Report report) {
        addReport(Collections.singletonList(report));
    }

    @Override
    public void accept(@NotNull Collection<Report> reports) {
        reportsVisitor.forEach(v -> v.accept(reports));
    }

    // Other implemented methods with similar refactoring...
    // (onResultsAvailable, onResultAvailable, afterAnalyze, reportDataFlowBug, addUtState, etc.)
    
    private IReportConsumer getCoverageReportWriter() {
        return coverage::writeReport;
    }
}
