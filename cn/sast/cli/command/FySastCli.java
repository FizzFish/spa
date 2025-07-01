package cn.sast.cli.command;

import cn.sast.api.AnalyzerEnv;
import cn.sast.api.config.*;
import cn.sast.api.incremental.IncrementalAnalyze;
import cn.sast.api.report.*;
import cn.sast.api.util.IMonitor;
import cn.sast.api.util.PhaseIntervalTimer;
import cn.sast.cli.ApplicationKt;
import cn.sast.cli.command.*;
import cn.sast.cli.command.tools.*;
import cn.sast.common.*;
import cn.sast.framework.*;
import cn.sast.framework.engine.*;
import cn.sast.framework.incremental.IncrementalAnalyzeImplByChangeFiles;
import cn.sast.framework.metrics.MetricsMonitor;
import cn.sast.framework.plugin.CheckerFilterByName;
import cn.sast.framework.plugin.ConfigPluginLoader;
import cn.sast.framework.report.*;
import cn.sast.framework.result.*;
import cn.sast.framework.rewrite.IdentityStmt2MethodParamRegion;
import cn.sast.framework.util.SAXReaderBugTest;
import cn.sast.framework.util.SootUtils;
import cn.sast.framework.validator.AccuracyValidator;
import cn.sast.idfa.analysis.ProcessInfoView;
import cn.sast.idfa.analysis.UsefulMetrics;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.analysis.*;
import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.rules.ProcessRule;
import com.feysh.corax.config.api.utils.UtilsKt;
import com.feysh.corax.config.builtin.checkers.DefineUnusedChecker;
import com.github.ajalt.clikt.core.*;
import com.github.ajalt.clikt.output.MordantHelpFormatter;
import com.github.ajalt.clikt.parameters.groups.*;
import com.github.ajalt.clikt.parameters.options.*;
import com.github.ajalt.clikt.parameters.types.*;
import com.github.ajalt.mordant.rendering.TextStyle;
import com.github.ajalt.mordant.rendering.Theme;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.slf4j.Log4jLogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import soot.PackManager;
import soot.SootClass;
import soot.Transform;
import soot.Transformer;
import soot.options.Options;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.properties.ReadOnlyProperty;


public final class FySastCli extends CliktCommand {
    public static final Companion Companion = new Companion();
    private static final Logger logger = LoggerFactory.getLogger(FySastCli.class);
    
    // Delegated properties
    private final ReadOnlyProperty<Level> verbosity$delegate;
    private final ReadOnlyProperty<String> config$delegate;
    private final ReadOnlyProperty<List<String>> rules$delegate;
    private final Lazy<IResDirectory> defaultOutput$delegate;
    private final ReadOnlyProperty<IResDirectory> output$delegate;
    private final ReadOnlyProperty<Boolean> dumpSootScene$delegate;
    private final ReadOnlyProperty<Set<ResultType>> resultType$delegate;
    private final ReadOnlyProperty<List<Language>> preferredLanguages$delegate;
    private final boolean enableDecompile;
    private final ReadOnlyProperty<Boolean> enableCodeMetrics$delegate;
    private final ReadOnlyProperty<String> dumpSrcFileList$delegate;
    private final ReadOnlyProperty<TargetOptions> target$delegate;
    private final ReadOnlyProperty<List<String>> process$delegate;
    private final ReadOnlyProperty<List<String>> classPath$delegate;
    private final ReadOnlyProperty<List<String>> autoAppClasses$delegate;
    private final ReadOnlyProperty<FileSystemLocator.TraverseMode> autoAppTraverseMode$delegate;
    private final ReadOnlyProperty<Boolean> autoAppSrcOnlyFileScheme$delegate;
    private final ReadOnlyProperty<Boolean> disableDefaultJavaClassPath$delegate;
    private final ReadOnlyProperty<Set<IResDirectory>> sourcePath$delegate;
    private final ReadOnlyProperty<List<String>> projectRoot$delegate;
    private final ReadOnlyProperty<SrcPrecedence> srcPrecedence$delegate;
    private final ReadOnlyProperty<List<String>> incrementalScanOf$delegate;
    private final ReadOnlyProperty<Boolean> disableMappingDiffInArchive$delegate;
    private final ReadOnlyProperty<String> sunBootClassPath$delegate;
    private final ReadOnlyProperty<String> javaExtDirs$delegate;
    private final ReadOnlyProperty<List<String>> ecjOptions$delegate;
    private final ReadOnlyProperty<Boolean> serializeCG$delegate;
    private final ReadOnlyProperty<AbstractFileIndexer.CompareMode> c2sMode$delegate;
    private final ReadOnlyProperty<Boolean> hideNoSource$delegate;
    private final ReadOnlyProperty<FileSystemLocator.TraverseMode> traverseMode$delegate;
    private final ReadOnlyProperty<File> projectScanConfig$delegate;
    private final ReadOnlyProperty<Boolean> disableWrapper$delegate;
    private final ReadOnlyProperty<Boolean> apponly$delegate;
    private final ReadOnlyProperty<Boolean> disablePreAnalysis$delegate;
    private final ReadOnlyProperty<Boolean> disableBuiltInAnalysis$delegate;
    private final ReadOnlyProperty<DataFlowOptions> dataFlowOptions$delegate;
    private final ReadOnlyProperty<CheckerInfoGeneratorOptions> checkerInfoGeneratorOptions$delegate;
    private final ReadOnlyProperty<CheckerInfoCompareOptions> checkerInfoCompareOptions$delegate;
    private final ReadOnlyProperty<SubToolsOptions> subtoolsOptions$delegate;
    private final ReadOnlyProperty<FlowDroidOptions> flowDroidOptions$delegate;
    private final ReadOnlyProperty<UtAnalyzeOptions> utAnalyzeOptions$delegate;
    private final ReadOnlyProperty<Boolean> enableStructureAnalysis$delegate;
    private final ReadOnlyProperty<Boolean> enableOriginalNames$delegate;
    private final ReadOnlyProperty<StaticFieldTrackingMode> staticFieldTrackingMode$delegate;
    private final ReadOnlyProperty<String> callGraphAlgorithm$delegate;
    private final ReadOnlyProperty<String> callGraphAlgorithmBuiltIn$delegate;
    private final ReadOnlyProperty<Boolean> disableReflection$delegate;
    private final ReadOnlyProperty<Integer> maxThreadNum$delegate;
    private final ReadOnlyProperty<Double> memoryThreshold$delegate;
    private final ReadOnlyProperty<Boolean> disableTop$delegate;
    private final ReadOnlyProperty<Boolean> strict$delegate;
    private final ReadOnlyProperty<Map<String, String>> zipFSEnv$delegate;
    private final ReadOnlyProperty<List<String>> zipFSEncodings$delegate;
    private final ReadOnlyProperty<Integer> hashVersion$delegate;
    private final ReadOnlyProperty<Charset> sourceEncoding$delegate;
    private final ReadOnlyProperty<Boolean> makeScorecard$delegate;
    private final ReadOnlyProperty<Integer> timeout$delegate;
    
    private List<IResultCollector> collectors = Collections.emptyList();
    private IResFile anchorPointFile;
    private ResultCollector lastResult;
    private final Set<IResFile> sqliteFileIndexes = ConcurrentHashMap.newKeySet();

    public FySastCli() {
        super(null, null, "CoraxJava", false, false, null, null, false, false, false, 1019, null);
        
        // Initialize all delegated properties
        // ... (omitted for brevity, same initialization logic as original)
    }

    // Getters for delegated properties
    private Level getVerbosity() { return verbosity$delegate.getValue(this); }
    private String getConfig() { return config$delegate.getValue(this); }
    private List<String> getRules() { return rules$delegate.getValue(this); }
    private IResDirectory getDefaultOutput() { return defaultOutput$delegate.getValue(); }
    private IResDirectory getOutput() { return output$delegate.getValue(this); }
    private boolean getDumpSootScene() { return dumpSootScene$delegate.getValue(this); }
    private Set<ResultType> getResultType() { return resultType$delegate.getValue(this); }
    private List<Language> getPreferredLanguages() { return preferredLanguages$delegate.getValue(this); }
    private boolean getEnableCodeMetrics() { return enableCodeMetrics$delegate.getValue(this); }
    private String getDumpSrcFileList() { return dumpSrcFileList$delegate.getValue(this); }
    private TargetOptions getTarget() { return target$delegate.getValue(this); }
    private List<String> getProcess() { return process$delegate.getValue(this); }
    private List<String> getClassPath() { return classPath$delegate.getValue(this); }
    private List<String> getAutoAppClasses() { return autoAppClasses$delegate.getValue(this); }
    private FileSystemLocator.TraverseMode getAutoAppTraverseMode() { return autoAppTraverseMode$delegate.getValue(this); }
    private boolean getAutoAppSrcOnlyFileScheme() { return autoAppSrcOnlyFileScheme$delegate.getValue(this); }
    private boolean getDisableDefaultJavaClassPath() { return disableDefaultJavaClassPath$delegate.getValue(this); }
    private Set<IResDirectory> getSourcePath() { return sourcePath$delegate.getValue(this); }
    private List<String> getProjectRoot() { return projectRoot$delegate.getValue(this); }
    private SrcPrecedence getSrcPrecedence() { return srcPrecedence$delegate.getValue(this); }
    private List<String> getIncrementalScanOf() { return incrementalScanOf$delegate.getValue(this); }
    private boolean getDisableMappingDiffInArchive() { return disableMappingDiffInArchive$delegate.getValue(this); }
    private String getSunBootClassPath() { return sunBootClassPath$delegate.getValue(this); }
    private String getJavaExtDirs() { return javaExtDirs$delegate.getValue(this); }
    private List<String> getEcjOptions() { return ecjOptions$delegate.getValue(this); }
    private boolean getSerializeCG() { return serializeCG$delegate.getValue(this); }
    private AbstractFileIndexer.CompareMode getC2sMode() { return c2sMode$delegate.getValue(this); }
    private boolean getHideNoSource() { return hideNoSource$delegate.getValue(this); }
    private FileSystemLocator.TraverseMode getTraverseMode() { return traverseMode$delegate.getValue(this); }
    private File getProjectScanConfig() { return projectScanConfig$delegate.getValue(this); }
    private boolean getDisableWrapper() { return disableWrapper$delegate.getValue(this); }
    private boolean getApponly() { return apponly$delegate.getValue(this); }
    private boolean getDisablePreAnalysis() { return disablePreAnalysis$delegate.getValue(this); }
    private boolean getDisableBuiltInAnalysis() { return disableBuiltInAnalysis$delegate.getValue(this); }
    private DataFlowOptions getDataFlowOptions() { return dataFlowOptions$delegate.getValue(this); }
    private CheckerInfoGeneratorOptions getCheckerInfoGeneratorOptions() { return checkerInfoGeneratorOptions$delegate.getValue(this); }
    private CheckerInfoCompareOptions getCheckerInfoCompareOptions() { return checkerInfoCompareOptions$delegate.getValue(this); }
    private SubToolsOptions getSubtoolsOptions() { return subtoolsOptions$delegate.getValue(this); }
    private FlowDroidOptions getFlowDroidOptions() { return flowDroidOptions$delegate.getValue(this); }
    private UtAnalyzeOptions getUtAnalyzeOptions() { return utAnalyzeOptions$delegate.getValue(this); }
    private boolean getEnableStructureAnalysis() { return enableStructureAnalysis$delegate.getValue(this); }
    private boolean getEnableOriginalNames() { return enableOriginalNames$delegate.getValue(this); }
    private StaticFieldTrackingMode getStaticFieldTrackingMode() { return staticFieldTrackingMode$delegate.getValue(this); }
    private String getCallGraphAlgorithm() { return callGraphAlgorithm$delegate.getValue(this); }
    private String getCallGraphAlgorithmBuiltIn() { return callGraphAlgorithmBuiltIn$delegate.getValue(this); }
    private boolean getDisableReflection() { return disableReflection$delegate.getValue(this); }
    private int getMaxThreadNum() { return maxThreadNum$delegate.getValue(this); }
    private double getMemoryThreshold() { return memoryThreshold$delegate.getValue(this); }
    private boolean getDisableTop() { return disableTop$delegate.getValue(this); }
    private boolean getStrict() { return strict$delegate.getValue(this); }
    private Map<String, String> getZipFSEnv() { return zipFSEnv$delegate.getValue(this); }
    private List<String> getZipFSEncodings() { return zipFSEncodings$delegate.getValue(this); }
    private Integer getHashVersion() { return hashVersion$delegate.getValue(this); }
    public Charset getSourceEncoding() { return sourceEncoding$delegate.getValue(this); }
    private boolean getMakeScorecard() { return makeScorecard$delegate.getValue(this); }
    private int getTimeout() { return timeout$delegate.getValue(this); }

    @NotNull
    public List<IResultCollector> getCollectors() {
        return collectors;
    }

    public void setCollectors(@NotNull List<? extends IResultCollector> collectors) {
        this.collectors = Collections.unmodifiableList(collectors);
    }

    @Override
    public void run() {
        setTimeOut();
        AbstractFileIndexer.Companion.setDefaultClassCompareMode(getC2sMode());
        checkOutputDir();
        MainConfig.Companion.setPreferredLanguages(getPreferredLanguages());
        OS.INSTANCE.setMaxThreadNum(getMaxThreadNum());
        
        MetricsMonitor monitor = new MetricsMonitor();
        monitor.start();
        
        CheckType2StringKind.Companion.getCheckType2StringKind();
        postCheck();
        createAnchorPointFile();
        printOptions();
        
        Resource.INSTANCE.setZipExtractOutputDir(getOutput().getPath());
        if (!getZipFSEnv().isEmpty()) {
            Resource.INSTANCE.setNewFileSystemEnv(getZipFSEnv());
        }
        
        if (!getZipFSEncodings().isEmpty()) {
            Resource.INSTANCE.setFileSystemEncodings(getZipFSEncodings());
        }
        
        LocalDateTime startTime = LocalDateTime.now();
        try {
            // Main analysis logic
            // ... (omitted for brevity)
            
            monitor.runAnalyzeFinishHook();
            logger.info("Output: {}", getOutput().getAbsolute().getNormalize());
            logger.info("Analysis was completed in {}", TimeUtilsKt.prettyPrintTime(startTime));
        } catch (Throwable t) {
            logger.info("Output: {}", getOutput().getAbsolute().getNormalize());
            logger.info("Analysis was terminated after {}", TimeUtilsKt.prettyPrintTime(startTime));
            throw t;
        }
    }

    // Other private methods remain largely the same, just converted to Java syntax
    // ... (omitted for brevity)

    public static final class Companion {
        private Companion() {}
    }

    public enum ResultType {
        PLIST, SARIF, COUNTER, SarifPackSrc, SarifCopySrc, SQLITE
    }

    private static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0 = new int[ResultType.values().length];
        
        static {
            $EnumSwitchMapping$0[ResultType.PLIST.ordinal()] = 1;
            $EnumSwitchMapping$0[ResultType.SARIF.ordinal()] = 2;
            $EnumSwitchMapping$0[ResultType.COUNTER.ordinal()] = 3;
            $EnumSwitchMapping$0[ResultType.SarifPackSrc.ordinal()] = 4;
            $EnumSwitchMapping$0[ResultType.SarifCopySrc.ordinal()] = 5;
            $EnumSwitchMapping$0[ResultType.SQLITE.ordinal()] = 6;
        }
    }
}