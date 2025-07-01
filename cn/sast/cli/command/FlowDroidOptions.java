package cn.sast.cli.command;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.dataflow.infoflow.InfoflowConfigurationExt;
import com.github.ajalt.clikt.completion.CompletionCandidates;
import com.github.ajalt.clikt.core.Context;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.core.UsageError;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.FlagOptionKt;
import com.github.ajalt.clikt.parameters.options.OptionCallTransformContext;
import com.github.ajalt.clikt.parameters.options.OptionKt;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.ChoiceKt;
import com.github.ajalt.clikt.parameters.types.IntKt;
import com.github.ajalt.clikt.parameters.types.LongKt;
import com.github.ajalt.clikt.parameters.types.RangeKt;

import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.InfoflowConfiguration.*;

import java.util.LinkedHashMap;
import java.util.Map;

public final class FlowDroidOptions extends OptionGroup {
    private final boolean isHidden;
    private final boolean enableFlowDroid;
    private final String baseDirectory;
    private final boolean noPathAgnosticResults;
    private final boolean oneResultPerAccessPath;
    private final boolean mergeNeighbors;
    private final int stopAfterFirstKFlows;
    private final boolean inspectSources;
    private final boolean inspectSinks;
    private final ImplicitFlowMode implicitFlowMode;
    private final SootIntegrationMode sootIntegrationMode;
    private final boolean disableFlowSensitiveAliasing;
    private final boolean disableExceptionTracking;
    private final boolean disableArrayTracking;
    private final boolean disableArraySizeTainting;
    private final boolean disableTypeChecking;
    private final CallgraphAlgorithm callgraphAlgorithm;
    private final AliasingAlgorithm aliasingAlgorithm;
    private final DataFlowDirection dataFlowDirection;
    private final boolean ignoreFlowsInSystemPackages;
    private final boolean writeOutputFiles;
    private final CodeEliminationMode codeEliminationMode;
    private final boolean disableLogSourcesAndSinks;
    private final boolean enableReflection;
    private final boolean disableLineNumbers;
    private final boolean disableTaintAnalysis;
    private final boolean incrementalResultReporting;
    private final long dataFlowTimeout;
    private final boolean oneSourceAtATime;
    private final boolean sequentialPathProcessing;
    private final PathReconstructionMode pathReconstructionMode;
    private final PathBuildingAlgorithm pathBuildingAlgorithm;
    private final int maxCallStackSize;
    private final int maxPathLength;
    private final int maxPathsPerAbstraction;
    private final long pathReconstructionTimeout;
    private final int pathReconstructionBatchSize;
    private final int accessPathLength;
    private final boolean useRecursiveAccessPaths;
    private final boolean useThisChainReduction;
    private final boolean useSameFieldReduction;
    private final boolean disableSparseOpt;
    private final int maxJoinPointAbstractions;
    private final int maxAbstractionPathLength;
    private final int maxCalleesPerCallSite;
    private final DataFlowSolver dataFlowSolver;

    public FlowDroidOptions(boolean isHidden) {
        super("FlowDroid Options");
        this.isHidden = isHidden;

        this.enableFlowDroid = option().required().help("Set if the FlowDroid engine shall be enabled").boolean();
        this.baseDirectory = option().default("").hidden(isHidden).string();
        this.noPathAgnosticResults = flag().hidden(isHidden).boolean();
        this.oneResultPerAccessPath = flag().hidden(isHidden).boolean();
        this.mergeNeighbors = flag().hidden(isHidden).boolean();
        this.stopAfterFirstKFlows = option().int().default(0).hidden(isHidden).int();
        this.inspectSources = flag().hidden(isHidden).boolean();
        this.inspectSinks = flag().hidden(isHidden).boolean();
        
        this.implicitFlowMode = option()
            .choice(createEnumMap(ImplicitFlowMode.values()))
            .default(ImplicitFlowMode.ArrayAccesses)
            .hidden(isHidden)
            .enumType(ImplicitFlowMode.class);
            
        this.sootIntegrationMode = option()
            .choice(createEnumMap(SootIntegrationMode.values()))
            .default(SootIntegrationMode.CreateNewInstance)
            .hidden(isHidden)
            .enumType(SootIntegrationMode.class);
            
        this.disableFlowSensitiveAliasing = flag().hidden(isHidden).boolean();
        this.disableExceptionTracking = flag().hidden(isHidden).boolean();
        this.disableArrayTracking = flag().hidden(isHidden).boolean();
        this.disableArraySizeTainting = flag().hidden(isHidden).boolean();
        this.disableTypeChecking = flag().hidden(isHidden).boolean();
        
        this.callgraphAlgorithm = option()
            .choice(createEnumMap(CallgraphAlgorithm.values()))
            .default(CallgraphAlgorithm.AutomaticSelection)
            .hidden(isHidden)
            .enumType(CallgraphAlgorithm.class);
            
        this.aliasingAlgorithm = option()
            .choice(createEnumMap(AliasingAlgorithm.values()))
            .default(AliasingAlgorithm.FlowSensitive)
            .hidden(isHidden)
            .enumType(AliasingAlgorithm.class);
            
        this.dataFlowDirection = option()
            .choice(createEnumMap(DataFlowDirection.values()))
            .default(DataFlowDirection.Forwards)
            .hidden(isHidden)
            .enumType(DataFlowDirection.class);
            
        this.ignoreFlowsInSystemPackages = flag().hidden(isHidden).boolean();
        this.writeOutputFiles = flag().hidden(isHidden).boolean();
        
        this.codeEliminationMode = option()
            .choice(createEnumMap(CodeEliminationMode.values()))
            .default(CodeEliminationMode.NoCodeElimination)
            .hidden(isHidden)
            .enumType(CodeEliminationMode.class);
            
        this.disableLogSourcesAndSinks = flag().hidden(isHidden).boolean();
        this.enableReflection = flag().hidden(isHidden).boolean();
        this.disableLineNumbers = flag().hidden(isHidden).boolean();
        this.disableTaintAnalysis = flag().hidden(isHidden).boolean();
        this.incrementalResultReporting = flag().hidden(isHidden).boolean();
        this.dataFlowTimeout = option().long().default(0L).hidden(isHidden).long();
        this.oneSourceAtATime = flag().hidden(isHidden).boolean();
        this.sequentialPathProcessing = flag().hidden(isHidden).boolean();
        
        this.pathReconstructionMode = option()
            .choice(createEnumMap(PathReconstructionMode.values()))
            .default(PathReconstructionMode.Precise)
            .hidden(isHidden)
            .enumType(PathReconstructionMode.class);
            
        this.pathBuildingAlgorithm = option()
            .choice(createEnumMap(PathBuildingAlgorithm.values()))
            .default(PathBuildingAlgorithm.ContextSensitive)
            .hidden(isHidden)
            .enumType(PathBuildingAlgorithm.class);
            
        this.maxCallStackSize = option().int().range(-1, Integer.MAX_VALUE).default(30).hidden(isHidden).int();
        this.maxPathLength = option().int().range(-1, Integer.MAX_VALUE).default(75).hidden(isHidden).int();
        this.maxPathsPerAbstraction = option().int().range(-1, Integer.MAX_VALUE).default(15).hidden(isHidden).int();
        this.pathReconstructionTimeout = option().long().range(-1, Long.MAX_VALUE).default(0L).hidden(isHidden).long();
        this.pathReconstructionBatchSize = option().int().range(-1, Integer.MAX_VALUE).default(5).hidden(isHidden).int();
        this.accessPathLength = option().int().range(-1, Integer.MAX_VALUE).default(25).hidden(isHidden).int();
        this.useRecursiveAccessPaths = flag().hidden(isHidden).boolean();
        this.useThisChainReduction = flag().hidden(isHidden).boolean();
        this.useSameFieldReduction = flag().hidden(isHidden).boolean();
        this.disableSparseOpt = flag().hidden(isHidden).boolean();
        this.maxJoinPointAbstractions = option().int().range(-1, Integer.MAX_VALUE).default(-1).hidden(isHidden).int();
        this.maxAbstractionPathLength = option().int().range(-1, Integer.MAX_VALUE).default(-1).hidden(isHidden).int();
        this.maxCalleesPerCallSite = option().int().range(-1, Integer.MAX_VALUE).default(-1).hidden(isHidden).int();
        
        this.dataFlowSolver = option()
            .choice(createEnumMap(DataFlowSolver.values()))
            .default(DataFlowSolver.ContextFlowSensitive)
            .hidden(isHidden)
            .enumType(DataFlowSolver.class);
    }

    public FlowDroidOptions() {
        this(false);
    }

    public boolean isHidden() {
        return isHidden;
    }

    public boolean getEnableFlowDroid() {
        return enableFlowDroid;
    }

    private String getBaseDirectory() {
        return baseDirectory;
    }

    private boolean getNoPathAgnosticResults() {
        return noPathAgnosticResults;
    }

    private boolean getOneResultPerAccessPath() {
        return oneResultPerAccessPath;
    }

    private boolean getMergeNeighbors() {
        return mergeNeighbors;
    }

    private int getStopAfterFirstKFlows() {
        return stopAfterFirstKFlows;
    }

    private boolean getInspectSources() {
        return inspectSources;
    }

    private boolean getInspectSinks() {
        return inspectSinks;
    }

    private ImplicitFlowMode getImplicitFlowMode() {
        return implicitFlowMode;
    }

    private SootIntegrationMode getSootIntegrationMode() {
        return sootIntegrationMode;
    }

    private boolean getDisableFlowSensitiveAliasing() {
        return disableFlowSensitiveAliasing;
    }

    private boolean getDisableExceptionTracking() {
        return disableExceptionTracking;
    }

    private boolean getDisableArrayTracking() {
        return disableArrayTracking;
    }

    private boolean getDisableArraySizeTainting() {
        return disableArraySizeTainting;
    }

    private boolean getDisableTypeChecking() {
        return disableTypeChecking;
    }

    private CallgraphAlgorithm getCallgraphAlgorithm() {
        return callgraphAlgorithm;
    }

    private AliasingAlgorithm getAliasingAlgorithm() {
        return aliasingAlgorithm;
    }

    private DataFlowDirection getDataFlowDirection() {
        return dataFlowDirection;
    }

    private boolean getIgnoreFlowsInSystemPackages() {
        return ignoreFlowsInSystemPackages;
    }

    private boolean getWriteOutputFiles() {
        return writeOutputFiles;
    }

    private CodeEliminationMode getCodeEliminationMode() {
        return codeEliminationMode;
    }

    private boolean getDisableLogSourcesAndSinks() {
        return disableLogSourcesAndSinks;
    }

    private boolean getEnableReflection() {
        return enableReflection;
    }

    private boolean getDisableLineNumbers() {
        return disableLineNumbers;
    }

    private boolean getDisableTaintAnalysis() {
        return disableTaintAnalysis;
    }

    private boolean getIncrementalResultReporting() {
        return incrementalResultReporting;
    }

    private long getDataFlowTimeout() {
        return dataFlowTimeout;
    }

    private boolean getOneSourceAtATime() {
        return oneSourceAtATime;
    }

    private boolean getSequentialPathProcessing() {
        return sequentialPathProcessing;
    }

    private PathReconstructionMode getPathReconstructionMode() {
        return pathReconstructionMode;
    }

    private PathBuildingAlgorithm getPathBuildingAlgorithm() {
        return pathBuildingAlgorithm;
    }

    private int getMaxCallStackSize() {
        return maxCallStackSize;
    }

    private int getMaxPathLength() {
        return maxPathLength;
    }

    private int getMaxPathsPerAbstraction() {
        return maxPathsPerAbstraction;
    }

    private long getPathReconstructionTimeout() {
        return pathReconstructionTimeout;
    }

    private int getPathReconstructionBatchSize() {
        return pathReconstructionBatchSize;
    }

    private int getAccessPathLength() {
        return accessPathLength;
    }

    private boolean getUseRecursiveAccessPaths() {
        return useRecursiveAccessPaths;
    }

    private boolean getUseThisChainReduction() {
        return useThisChainReduction;
    }

    private boolean getUseSameFieldReduction() {
        return useSameFieldReduction;
    }

    private boolean getDisableSparseOpt() {
        return disableSparseOpt;
    }

    private int getMaxJoinPointAbstractions() {
        return maxJoinPointAbstractions;
    }

    private int getMaxAbstractionPathLength() {
        return maxAbstractionPathLength;
    }

    private int getMaxCalleesPerCallSite() {
        return maxCalleesPerCallSite;
    }

    private DataFlowSolver getDataFlowSolver() {
        return dataFlowSolver;
    }

    private void initializeGlobalStaticCommandLineOptions() {
        InfoflowConfiguration.setBaseDirectory(getBaseDirectory());
        InfoflowConfiguration.setOneResultPerAccessPath(getOneResultPerAccessPath());
        InfoflowConfiguration.setMergeNeighbors(getMergeNeighbors());
    }

    public void configureInfoFlowConfig(@NotNull InfoflowConfiguration infoFlowConfig, @NotNull MainConfig mainConfig) {
        if (infoFlowConfig == null) throw new NullPointerException("infoFlowConfig is null");
        if (mainConfig == null) throw new NullPointerException("mainConfig is null");
        
        initializeGlobalStaticCommandLineOptions();
        
        infoFlowConfig.setOneSourceAtATime(oneSourceAtATime);
        infoFlowConfig.setStopAfterFirstKFlows(stopAfterFirstKFlows);
        infoFlowConfig.setInspectSources(inspectSources);
        infoFlowConfig.setInspectSinks(inspectSinks);
        infoFlowConfig.setImplicitFlowMode(implicitFlowMode);
        infoFlowConfig.setStaticFieldTrackingMode(FlowDroidOptionsKt.getCvt(mainConfig.getStaticFieldTrackingMode()));
        infoFlowConfig.setSootIntegrationMode(sootIntegrationMode);
        infoFlowConfig.setFlowSensitiveAliasing(!disableFlowSensitiveAliasing);
        infoFlowConfig.setEnableExceptionTracking(!disableExceptionTracking);
        infoFlowConfig.setEnableArrayTracking(!disableArrayTracking);
        infoFlowConfig.setEnableArraySizeTainting(!disableArraySizeTainting);
        infoFlowConfig.setCallgraphAlgorithm(callgraphAlgorithm);
        infoFlowConfig.setAliasingAlgorithm(aliasingAlgorithm);
        infoFlowConfig.setDataFlowDirection(dataFlowDirection);
        infoFlowConfig.setEnableTypeChecking(!disableTypeChecking);
        infoFlowConfig.setIgnoreFlowsInSystemPackages(ignoreFlowsInSystemPackages);
        infoFlowConfig.setExcludeSootLibraryClasses(mainConfig.getApponly());
        infoFlowConfig.setMaxThreadNum(mainConfig.getParallelsNum());
        infoFlowConfig.setWriteOutputFiles(writeOutputFiles);
        infoFlowConfig.setCodeEliminationMode(codeEliminationMode);
        infoFlowConfig.setLogSourcesAndSinks(!disableLogSourcesAndSinks);
        infoFlowConfig.setEnableReflection(enableReflection);
        infoFlowConfig.setEnableLineNumbers(!disableLineNumbers);
        infoFlowConfig.setEnableOriginalNames(true);
        infoFlowConfig.setTaintAnalysisEnabled(!disableTaintAnalysis);
        infoFlowConfig.setIncrementalResultReporting(incrementalResultReporting);
        infoFlowConfig.setDataFlowTimeout(dataFlowTimeout);
        infoFlowConfig.setMemoryThreshold(mainConfig.getMemoryThreshold());
        infoFlowConfig.setPathAgnosticResults(!noPathAgnosticResults);
        
        PathConfiguration pathConfiguration = infoFlowConfig.getPathConfiguration();
        pathConfiguration.setSequentialPathProcessing(sequentialPathProcessing);
        pathConfiguration.setPathReconstructionMode(pathReconstructionMode);
        pathConfiguration.setPathBuildingAlgorithm(pathBuildingAlgorithm);
        pathConfiguration.setMaxCallStackSize(maxCallStackSize);
        pathConfiguration.setMaxPathLength(maxPathLength);
        pathConfiguration.setMaxPathsPerAbstraction(maxPathsPerAbstraction);
        pathConfiguration.setPathReconstructionTimeout(pathReconstructionTimeout);
        pathConfiguration.setPathReconstructionBatchSize(pathReconstructionBatchSize);
        
        AccessPathConfiguration accessPathConfiguration = infoFlowConfig.getAccessPathConfiguration();
        accessPathConfiguration.setAccessPathLength(accessPathLength);
        accessPathConfiguration.setUseRecursiveAccessPaths(useRecursiveAccessPaths);
        accessPathConfiguration.setUseThisChainReduction(useThisChainReduction);
        accessPathConfiguration.setUseSameFieldReduction(useSameFieldReduction);
        
        SolverConfiguration solverConfiguration = infoFlowConfig.getSolverConfiguration();
        solverConfiguration.setMaxJoinPointAbstractions(maxJoinPointAbstractions);
        solverConfiguration.setMaxAbstractionPathLength(maxAbstractionPathLength);
        solverConfiguration.setMaxCalleesPerCallSite(maxCalleesPerCallSite);
        solverConfiguration.setDataFlowSolver(dataFlowSolver);
    }

    @NotNull
    public InfoflowConfigurationExt getExtInfoFlowConfig() {
        InfoflowConfigurationExt config = new InfoflowConfigurationExt();
        config.setUseSparseOpt(!disableSparseOpt);
        return config;
    }

    private static <T extends Enum<T>> Map<String, T> createEnumMap(T[] values) {
        Map<String, T> map = new LinkedHashMap<>();
        for (T value : values) {
            map.put(value.name(), value);
        }
        return map;
    }
}
