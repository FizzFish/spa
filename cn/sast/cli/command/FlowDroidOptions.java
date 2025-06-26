/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  cn.sast.cli.command.FlowDroidOptions
 *  cn.sast.cli.command.FlowDroidOptions$special$$inlined$convert$default$1
 *  cn.sast.cli.command.FlowDroidOptions$special$$inlined$convert$default$2
 *  cn.sast.cli.command.FlowDroidOptionsKt
 *  cn.sast.dataflow.infoflow.InfoflowConfigurationExt
 *  com.github.ajalt.clikt.completion.CompletionCandidates
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.parameters.groups.OptionGroup
 *  com.github.ajalt.clikt.parameters.options.FlagOptionKt
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues$DefaultImpls
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  com.github.ajalt.clikt.parameters.types.ChoiceKt
 *  com.github.ajalt.clikt.parameters.types.IntKt
 *  com.github.ajalt.clikt.parameters.types.LongKt
 *  com.github.ajalt.clikt.parameters.types.RangeKt
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.LongRange
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.infoflow.InfoflowConfiguration
 *  soot.jimple.infoflow.InfoflowConfiguration$AccessPathConfiguration
 *  soot.jimple.infoflow.InfoflowConfiguration$AliasingAlgorithm
 *  soot.jimple.infoflow.InfoflowConfiguration$CallgraphAlgorithm
 *  soot.jimple.infoflow.InfoflowConfiguration$CodeEliminationMode
 *  soot.jimple.infoflow.InfoflowConfiguration$DataFlowDirection
 *  soot.jimple.infoflow.InfoflowConfiguration$DataFlowSolver
 *  soot.jimple.infoflow.InfoflowConfiguration$ImplicitFlowMode
 *  soot.jimple.infoflow.InfoflowConfiguration$PathBuildingAlgorithm
 *  soot.jimple.infoflow.InfoflowConfiguration$PathConfiguration
 *  soot.jimple.infoflow.InfoflowConfiguration$PathReconstructionMode
 *  soot.jimple.infoflow.InfoflowConfiguration$SolverConfiguration
 *  soot.jimple.infoflow.InfoflowConfiguration$SootIntegrationMode
 */
package cn.sast.cli.command;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.cli.command.FlowDroidOptions$special$;
import cn.sast.cli.command.FlowDroidOptionsKt;
import cn.sast.dataflow.infoflow.InfoflowConfigurationExt;
import com.github.ajalt.clikt.completion.CompletionCandidates;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.FlagOptionKt;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.ChoiceKt;
import com.github.ajalt.clikt.parameters.types.IntKt;
import com.github.ajalt.clikt.parameters.types.LongKt;
import com.github.ajalt.clikt.parameters.types.RangeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.InfoflowConfiguration;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u00a7\u0001\u001a\u00030\u00a8\u0001H\u0002J\u001c\u0010\u00a9\u0001\u001a\u00030\u00a8\u00012\b\u0010\u00aa\u0001\u001a\u00030\u00ab\u00012\b\u0010\u00ac\u0001\u001a\u00030\u00ad\u0001J\b\u0010\u00ae\u0001\u001a\u00030\u00af\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00038FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u001f\u0010\u0006R\u001b\u0010!\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b\"\u0010\u0006R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\u0006R\u001b\u00101\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010\n\u001a\u0004\b2\u0010\u0006R\u001b\u00104\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b5\u0010\u0006R\u001b\u00107\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010\n\u001a\u0004\b8\u0010\u0006R\u001b\u0010:\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010\n\u001a\u0004\b;\u0010\u0006R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010\n\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010\n\u001a\u0004\bD\u0010ER\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010\n\u001a\u0004\bI\u0010JR\u001b\u0010L\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010\n\u001a\u0004\bM\u0010\u0006R\u001b\u0010O\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010\n\u001a\u0004\bP\u0010\u0006R\u001b\u0010R\u001a\u00020S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010\n\u001a\u0004\bT\u0010UR\u001b\u0010W\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010\n\u001a\u0004\bX\u0010\u0006R\u001b\u0010Z\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010\n\u001a\u0004\b[\u0010\u0006R\u001b\u0010]\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010\n\u001a\u0004\b^\u0010\u0006R\u001b\u0010`\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010\n\u001a\u0004\ba\u0010\u0006R\u001b\u0010c\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010\n\u001a\u0004\bd\u0010\u0006R\u001b\u0010f\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bj\u0010\n\u001a\u0004\bh\u0010iR\u001b\u0010k\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010\n\u001a\u0004\bl\u0010\u0006R\u001b\u0010n\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bp\u0010\n\u001a\u0004\bo\u0010\u0006R\u001b\u0010q\u001a\u00020r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bu\u0010\n\u001a\u0004\bs\u0010tR\u001b\u0010v\u001a\u00020w8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010\n\u001a\u0004\bx\u0010yR\u001b\u0010{\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b}\u0010\n\u001a\u0004\b|\u0010\u001cR\u001c\u0010~\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0005\b\u0080\u0001\u0010\n\u001a\u0004\b\u007f\u0010\u001cR\u001e\u0010\u0081\u0001\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0083\u0001\u0010\n\u001a\u0005\b\u0082\u0001\u0010\u001cR\u001e\u0010\u0084\u0001\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0086\u0001\u0010\n\u001a\u0005\b\u0085\u0001\u0010iR\u001e\u0010\u0087\u0001\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0089\u0001\u0010\n\u001a\u0005\b\u0088\u0001\u0010\u001cR\u001e\u0010\u008a\u0001\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u008c\u0001\u0010\n\u001a\u0005\b\u008b\u0001\u0010\u001cR\u001e\u0010\u008d\u0001\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u008f\u0001\u0010\n\u001a\u0005\b\u008e\u0001\u0010\u0006R\u001e\u0010\u0090\u0001\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0092\u0001\u0010\n\u001a\u0005\b\u0091\u0001\u0010\u0006R\u001e\u0010\u0093\u0001\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0095\u0001\u0010\n\u001a\u0005\b\u0094\u0001\u0010\u0006R\u001e\u0010\u0096\u0001\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0098\u0001\u0010\n\u001a\u0005\b\u0097\u0001\u0010\u0006R\u001e\u0010\u0099\u0001\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u009b\u0001\u0010\n\u001a\u0005\b\u009a\u0001\u0010\u001cR\u001e\u0010\u009c\u0001\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u009e\u0001\u0010\n\u001a\u0005\b\u009d\u0001\u0010\u001cR\u001e\u0010\u009f\u0001\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00a1\u0001\u0010\n\u001a\u0005\b\u00a0\u0001\u0010\u001cR \u0010\u00a2\u0001\u001a\u00030\u00a3\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a6\u0001\u0010\n\u001a\u0006\b\u00a4\u0001\u0010\u00a5\u0001\u00a8\u0006\u00b0\u0001"}, d2={"Lcn/sast/cli/command/FlowDroidOptions;", "Lcom/github/ajalt/clikt/parameters/groups/OptionGroup;", "isHidden", "", "<init>", "(Z)V", "()Z", "enableFlowDroid", "getEnableFlowDroid", "enableFlowDroid$delegate", "Lkotlin/properties/ReadOnlyProperty;", "baseDirectory", "", "getBaseDirectory", "()Ljava/lang/String;", "baseDirectory$delegate", "noPathAgnosticResults", "getNoPathAgnosticResults", "noPathAgnosticResults$delegate", "oneResultPerAccessPath", "getOneResultPerAccessPath", "oneResultPerAccessPath$delegate", "mergeNeighbors", "getMergeNeighbors", "mergeNeighbors$delegate", "stopAfterFirstKFlows", "", "getStopAfterFirstKFlows", "()I", "stopAfterFirstKFlows$delegate", "inspectSources", "getInspectSources", "inspectSources$delegate", "inspectSinks", "getInspectSinks", "inspectSinks$delegate", "implicitFlowMode", "Lsoot/jimple/infoflow/InfoflowConfiguration$ImplicitFlowMode;", "getImplicitFlowMode", "()Lsoot/jimple/infoflow/InfoflowConfiguration$ImplicitFlowMode;", "implicitFlowMode$delegate", "sootIntegrationMode", "Lsoot/jimple/infoflow/InfoflowConfiguration$SootIntegrationMode;", "getSootIntegrationMode", "()Lsoot/jimple/infoflow/InfoflowConfiguration$SootIntegrationMode;", "sootIntegrationMode$delegate", "disableFlowSensitiveAliasing", "getDisableFlowSensitiveAliasing", "disableFlowSensitiveAliasing$delegate", "disableExceptionTracking", "getDisableExceptionTracking", "disableExceptionTracking$delegate", "disableArrayTracking", "getDisableArrayTracking", "disableArrayTracking$delegate", "disableArraySizeTainting", "getDisableArraySizeTainting", "disableArraySizeTainting$delegate", "disableTypeChecking", "getDisableTypeChecking", "disableTypeChecking$delegate", "callgraphAlgorithm", "Lsoot/jimple/infoflow/InfoflowConfiguration$CallgraphAlgorithm;", "getCallgraphAlgorithm", "()Lsoot/jimple/infoflow/InfoflowConfiguration$CallgraphAlgorithm;", "callgraphAlgorithm$delegate", "aliasingAlgorithm", "Lsoot/jimple/infoflow/InfoflowConfiguration$AliasingAlgorithm;", "getAliasingAlgorithm", "()Lsoot/jimple/infoflow/InfoflowConfiguration$AliasingAlgorithm;", "aliasingAlgorithm$delegate", "dataFlowDirection", "Lsoot/jimple/infoflow/InfoflowConfiguration$DataFlowDirection;", "getDataFlowDirection", "()Lsoot/jimple/infoflow/InfoflowConfiguration$DataFlowDirection;", "dataFlowDirection$delegate", "ignoreFlowsInSystemPackages", "getIgnoreFlowsInSystemPackages", "ignoreFlowsInSystemPackages$delegate", "writeOutputFiles", "getWriteOutputFiles", "writeOutputFiles$delegate", "codeEliminationMode", "Lsoot/jimple/infoflow/InfoflowConfiguration$CodeEliminationMode;", "getCodeEliminationMode", "()Lsoot/jimple/infoflow/InfoflowConfiguration$CodeEliminationMode;", "codeEliminationMode$delegate", "disableLogSourcesAndSinks", "getDisableLogSourcesAndSinks", "disableLogSourcesAndSinks$delegate", "enableReflection", "getEnableReflection", "enableReflection$delegate", "disableLineNumbers", "getDisableLineNumbers", "disableLineNumbers$delegate", "disableTaintAnalysis", "getDisableTaintAnalysis", "disableTaintAnalysis$delegate", "incrementalResultReporting", "getIncrementalResultReporting", "incrementalResultReporting$delegate", "dataFlowTimeout", "", "getDataFlowTimeout", "()J", "dataFlowTimeout$delegate", "oneSourceAtATime", "getOneSourceAtATime", "oneSourceAtATime$delegate", "sequentialPathProcessing", "getSequentialPathProcessing", "sequentialPathProcessing$delegate", "pathReconstructionMode", "Lsoot/jimple/infoflow/InfoflowConfiguration$PathReconstructionMode;", "getPathReconstructionMode", "()Lsoot/jimple/infoflow/InfoflowConfiguration$PathReconstructionMode;", "pathReconstructionMode$delegate", "pathBuildingAlgorithm", "Lsoot/jimple/infoflow/InfoflowConfiguration$PathBuildingAlgorithm;", "getPathBuildingAlgorithm", "()Lsoot/jimple/infoflow/InfoflowConfiguration$PathBuildingAlgorithm;", "pathBuildingAlgorithm$delegate", "maxCallStackSize", "getMaxCallStackSize", "maxCallStackSize$delegate", "maxPathLength", "getMaxPathLength", "maxPathLength$delegate", "maxPathsPerAbstraction", "getMaxPathsPerAbstraction", "maxPathsPerAbstraction$delegate", "pathReconstructionTimeout", "getPathReconstructionTimeout", "pathReconstructionTimeout$delegate", "pathReconstructionBatchSize", "getPathReconstructionBatchSize", "pathReconstructionBatchSize$delegate", "accessPathLength", "getAccessPathLength", "accessPathLength$delegate", "useRecursiveAccessPaths", "getUseRecursiveAccessPaths", "useRecursiveAccessPaths$delegate", "useThisChainReduction", "getUseThisChainReduction", "useThisChainReduction$delegate", "useSameFieldReduction", "getUseSameFieldReduction", "useSameFieldReduction$delegate", "disableSparseOpt", "getDisableSparseOpt", "disableSparseOpt$delegate", "maxJoinPointAbstractions", "getMaxJoinPointAbstractions", "maxJoinPointAbstractions$delegate", "maxAbstractionPathLength", "getMaxAbstractionPathLength", "maxAbstractionPathLength$delegate", "maxCalleesPerCallSite", "getMaxCalleesPerCallSite", "maxCalleesPerCallSite$delegate", "dataFlowSolver", "Lsoot/jimple/infoflow/InfoflowConfiguration$DataFlowSolver;", "getDataFlowSolver", "()Lsoot/jimple/infoflow/InfoflowConfiguration$DataFlowSolver;", "dataFlowSolver$delegate", "initializeGlobalStaticCommandLineOptions", "", "configureInfoFlowConfig", "infoFlowConfig", "Lsoot/jimple/infoflow/InfoflowConfiguration;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "getExtInfoFlowConfig", "Lcn/sast/dataflow/infoflow/InfoflowConfigurationExt;", "corax-cli"})
@SourceDebugExtension(value={"SMAP\nFlowDroidOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowDroidOptions.kt\ncn/sast/cli/command/FlowDroidOptions\n+ 2 Convert.kt\ncom/github/ajalt/clikt/parameters/options/OptionWithValuesKt__ConvertKt\n+ 3 enum.kt\ncom/github/ajalt/clikt/parameters/types/EnumKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 enum.kt\ncom/github/ajalt/clikt/parameters/types/EnumKt$enum$3\n*L\n1#1,152:1\n35#2,6:153\n70#2:159\n82#2,4:160\n45#3,5:164\n45#3,5:175\n45#3,5:186\n45#3,5:197\n45#3,5:208\n45#3,5:219\n45#3,5:230\n45#3,5:241\n45#3,5:252\n8541#4,2:169\n8801#4,2:171\n8804#4:174\n8541#4,2:180\n8801#4,2:182\n8804#4:185\n8541#4,2:191\n8801#4,2:193\n8804#4:196\n8541#4,2:202\n8801#4,2:204\n8804#4:207\n8541#4,2:213\n8801#4,2:215\n8804#4:218\n8541#4,2:224\n8801#4,2:226\n8804#4:229\n8541#4,2:235\n8801#4,2:237\n8804#4:240\n8541#4,2:246\n8801#4,2:248\n8804#4:251\n8541#4,2:257\n8801#4,2:259\n8804#4:262\n47#5:173\n47#5:184\n47#5:195\n47#5:206\n47#5:217\n47#5:228\n47#5:239\n47#5:250\n47#5:261\n*S KotlinDebug\n*F\n+ 1 FlowDroidOptions.kt\ncn/sast/cli/command/FlowDroidOptions\n*L\n17#1:153,6\n17#1:159\n17#1:160,4\n28#1:164,5\n30#1:175,5\n37#1:186,5\n39#1:197,5\n41#1:208,5\n44#1:219,5\n56#1:230,5\n58#1:241,5\n77#1:252,5\n28#1:169,2\n28#1:171,2\n28#1:174\n30#1:180,2\n30#1:182,2\n30#1:185\n37#1:191,2\n37#1:193,2\n37#1:196\n39#1:202,2\n39#1:204,2\n39#1:207\n41#1:213,2\n41#1:215,2\n41#1:218\n44#1:224,2\n44#1:226,2\n44#1:229\n56#1:235,2\n56#1:237,2\n56#1:240\n58#1:246,2\n58#1:248,2\n58#1:251\n77#1:257,2\n77#1:259,2\n77#1:262\n28#1:173\n30#1:184\n37#1:195\n39#1:206\n41#1:217\n44#1:228\n56#1:239\n58#1:250\n77#1:261\n*E\n"})
public final class FlowDroidOptions
extends OptionGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final boolean isHidden;
    @NotNull
    private final ReadOnlyProperty enableFlowDroid$delegate;
    @NotNull
    private final ReadOnlyProperty baseDirectory$delegate;
    @NotNull
    private final ReadOnlyProperty noPathAgnosticResults$delegate;
    @NotNull
    private final ReadOnlyProperty oneResultPerAccessPath$delegate;
    @NotNull
    private final ReadOnlyProperty mergeNeighbors$delegate;
    @NotNull
    private final ReadOnlyProperty stopAfterFirstKFlows$delegate;
    @NotNull
    private final ReadOnlyProperty inspectSources$delegate;
    @NotNull
    private final ReadOnlyProperty inspectSinks$delegate;
    @NotNull
    private final ReadOnlyProperty implicitFlowMode$delegate;
    @NotNull
    private final ReadOnlyProperty sootIntegrationMode$delegate;
    @NotNull
    private final ReadOnlyProperty disableFlowSensitiveAliasing$delegate;
    @NotNull
    private final ReadOnlyProperty disableExceptionTracking$delegate;
    @NotNull
    private final ReadOnlyProperty disableArrayTracking$delegate;
    @NotNull
    private final ReadOnlyProperty disableArraySizeTainting$delegate;
    @NotNull
    private final ReadOnlyProperty disableTypeChecking$delegate;
    @NotNull
    private final ReadOnlyProperty callgraphAlgorithm$delegate;
    @NotNull
    private final ReadOnlyProperty aliasingAlgorithm$delegate;
    @NotNull
    private final ReadOnlyProperty dataFlowDirection$delegate;
    @NotNull
    private final ReadOnlyProperty ignoreFlowsInSystemPackages$delegate;
    @NotNull
    private final ReadOnlyProperty writeOutputFiles$delegate;
    @NotNull
    private final ReadOnlyProperty codeEliminationMode$delegate;
    @NotNull
    private final ReadOnlyProperty disableLogSourcesAndSinks$delegate;
    @NotNull
    private final ReadOnlyProperty enableReflection$delegate;
    @NotNull
    private final ReadOnlyProperty disableLineNumbers$delegate;
    @NotNull
    private final ReadOnlyProperty disableTaintAnalysis$delegate;
    @NotNull
    private final ReadOnlyProperty incrementalResultReporting$delegate;
    @NotNull
    private final ReadOnlyProperty dataFlowTimeout$delegate;
    @NotNull
    private final ReadOnlyProperty oneSourceAtATime$delegate;
    @NotNull
    private final ReadOnlyProperty sequentialPathProcessing$delegate;
    @NotNull
    private final ReadOnlyProperty pathReconstructionMode$delegate;
    @NotNull
    private final ReadOnlyProperty pathBuildingAlgorithm$delegate;
    @NotNull
    private final ReadOnlyProperty maxCallStackSize$delegate;
    @NotNull
    private final ReadOnlyProperty maxPathLength$delegate;
    @NotNull
    private final ReadOnlyProperty maxPathsPerAbstraction$delegate;
    @NotNull
    private final ReadOnlyProperty pathReconstructionTimeout$delegate;
    @NotNull
    private final ReadOnlyProperty pathReconstructionBatchSize$delegate;
    @NotNull
    private final ReadOnlyProperty accessPathLength$delegate;
    @NotNull
    private final ReadOnlyProperty useRecursiveAccessPaths$delegate;
    @NotNull
    private final ReadOnlyProperty useThisChainReduction$delegate;
    @NotNull
    private final ReadOnlyProperty useSameFieldReduction$delegate;
    @NotNull
    private final ReadOnlyProperty disableSparseOpt$delegate;
    @NotNull
    private final ReadOnlyProperty maxJoinPointAbstractions$delegate;
    @NotNull
    private final ReadOnlyProperty maxAbstractionPathLength$delegate;
    @NotNull
    private final ReadOnlyProperty maxCalleesPerCallSite$delegate;
    @NotNull
    private final ReadOnlyProperty dataFlowSolver$delegate;

    /*
     * WARNING - void declaration
     */
    public FlowDroidOptions(boolean isHidden) {
        super("FlowDroid Options", null, 2, null);
        void var11_16;
        Enum it;
        boolean bl;
        Enum it$iv;
        boolean bl2;
        Map map;
        InfoflowConfiguration.SootIntegrationMode[] $this$associateByTo$iv$iv$iv;
        InfoflowConfiguration.SootIntegrationMode[] $this$associateBy$iv$iv;
        OptionWithValues $this$enum_u24default$iv;
        CompletionCandidates completionCandidates;
        void $this$convert$iv$iv$iv;
        OptionWithValues $this$convert_u24default$iv;
        this.isHidden = isHidden;
        OptionWithValues optionWithValues = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null);
        String metavar$iv = "BOOL";
        Object completionCandidates$iv = null;
        void $this$convert$iv$iv = $this$convert_u24default$iv;
        boolean $i$f$convert22 = false;
        OptionWithValues optionWithValues2 = $this$convert$iv$iv;
        Function1 metavar$iv$iv$iv = (Function1)new special$$inlined$convert$default$1(metavar$iv);
        boolean $i$f$convert = false;
        Function2 valueTransform$iv$iv$iv = (Function2)new special$$inlined$convert$default$2((OptionWithValues)$this$convert$iv$iv$iv);
        Function2 function2 = OptionWithValuesKt.defaultEachProcessor();
        Function2 function22 = OptionWithValuesKt.defaultAllProcessor();
        Function2 function23 = OptionWithValuesKt.defaultValidator();
        Function1 function1 = $this$convert$iv$iv$iv.getMetavarGetter();
        if (function1 == null) {
            function1 = metavar$iv$iv$iv;
        }
        if ((completionCandidates = $this$convert$iv$iv$iv.getExplicitCompletionCandidates()) == null) {
            completionCandidates = completionCandidates$iv;
        }
        this.enableFlowDroid$delegate = OptionWithValuesKt.help((OptionWithValues)OptionWithValuesKt.required((OptionWithValues)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$convert$iv$iv$iv, (Function2)valueTransform$iv$iv$iv, (Function2)function2, (Function2)function22, (Function2)function23, null, (Function1)function1, null, null, (boolean)false, null, null, null, null, (CompletionCandidates)completionCandidates, null, (boolean)false, (boolean)false, (boolean)false, (int)253904, null)), (String)"Set if the FlowDroid engine shall be enabled").provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
        this.baseDirectory$delegate = OptionWithValuesKt.default$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (Object)"", null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
        this.noPathAgnosticResults$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[2]);
        this.oneResultPerAccessPath$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[3]);
        this.mergeNeighbors$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[4]);
        this.stopAfterFirstKFlows$delegate = OptionWithValuesKt.default$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (Object)0, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[5]);
        this.inspectSources$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[6]);
        this.inspectSinks$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[7]);
        $this$convert_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null);
        FlowDroidOptions flowDroidOptions = this;
        boolean ignoreCase$iv = true;
        boolean $i$f$enum = false;
        InfoflowConfiguration.ImplicitFlowMode[] $i$f$convert22 = InfoflowConfiguration.ImplicitFlowMode.values();
        optionWithValues2 = $this$enum_u24default$iv;
        boolean $i$f$associateBy = false;
        int capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv.length), (int)16);
        valueTransform$iv$iv$iv = $this$associateBy$iv$iv;
        Map destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        boolean $i$f$associateByTo = false;
        for (InfoflowConfiguration.SootIntegrationMode element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Enum enum_ = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            void var19_24 = it$iv;
            bl = false;
            it = var19_24;
            map.put(it.name(), element$iv$iv$iv);
        }
        flowDroidOptions.implicitFlowMode$delegate = OptionWithValuesKt.default$default((OptionWithValues)ChoiceKt.choice$default((OptionWithValues)optionWithValues2, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null), (Object)InfoflowConfiguration.ImplicitFlowMode.ArrayAccesses, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[8]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null);
        flowDroidOptions = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        $this$associateBy$iv$iv = InfoflowConfiguration.SootIntegrationMode.values();
        optionWithValues2 = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (InfoflowConfiguration.SootIntegrationMode element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        flowDroidOptions.sootIntegrationMode$delegate = OptionWithValuesKt.default$default((OptionWithValues)ChoiceKt.choice$default((OptionWithValues)optionWithValues2, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null), (Object)InfoflowConfiguration.SootIntegrationMode.CreateNewInstance, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[9]);
        this.disableFlowSensitiveAliasing$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[10]);
        this.disableExceptionTracking$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[11]);
        this.disableArrayTracking$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[12]);
        this.disableArraySizeTainting$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[13]);
        this.disableTypeChecking$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[14]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null);
        flowDroidOptions = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        $this$associateBy$iv$iv = InfoflowConfiguration.CallgraphAlgorithm.values();
        optionWithValues2 = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (InfoflowConfiguration.SootIntegrationMode element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        flowDroidOptions.callgraphAlgorithm$delegate = OptionWithValuesKt.default$default((OptionWithValues)ChoiceKt.choice$default((OptionWithValues)optionWithValues2, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null), (Object)InfoflowConfiguration.CallgraphAlgorithm.AutomaticSelection, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[15]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null);
        flowDroidOptions = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        $this$associateBy$iv$iv = InfoflowConfiguration.AliasingAlgorithm.values();
        optionWithValues2 = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (InfoflowConfiguration.SootIntegrationMode element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        flowDroidOptions.aliasingAlgorithm$delegate = OptionWithValuesKt.default$default((OptionWithValues)ChoiceKt.choice$default((OptionWithValues)optionWithValues2, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null), (Object)InfoflowConfiguration.AliasingAlgorithm.FlowSensitive, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[16]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null);
        flowDroidOptions = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        $this$associateBy$iv$iv = InfoflowConfiguration.DataFlowDirection.values();
        optionWithValues2 = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (InfoflowConfiguration.SootIntegrationMode element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        flowDroidOptions.dataFlowDirection$delegate = OptionWithValuesKt.default$default((OptionWithValues)ChoiceKt.choice$default((OptionWithValues)optionWithValues2, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null), (Object)InfoflowConfiguration.DataFlowDirection.Forwards, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[17]);
        this.ignoreFlowsInSystemPackages$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[18]);
        this.writeOutputFiles$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[19]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null);
        flowDroidOptions = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        $this$associateBy$iv$iv = InfoflowConfiguration.CodeEliminationMode.values();
        optionWithValues2 = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (InfoflowConfiguration.SootIntegrationMode element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        flowDroidOptions.codeEliminationMode$delegate = OptionWithValuesKt.default$default((OptionWithValues)ChoiceKt.choice$default((OptionWithValues)optionWithValues2, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null), (Object)InfoflowConfiguration.CodeEliminationMode.NoCodeElimination, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[20]);
        this.disableLogSourcesAndSinks$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[21]);
        this.enableReflection$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[22]);
        this.disableLineNumbers$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[23]);
        this.disableTaintAnalysis$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[24]);
        this.incrementalResultReporting$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[25]);
        this.dataFlowTimeout$delegate = OptionWithValuesKt.default$default((OptionWithValues)LongKt.long$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (Object)0L, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[26]);
        this.oneSourceAtATime$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[27]);
        this.sequentialPathProcessing$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[28]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null);
        flowDroidOptions = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        $this$associateBy$iv$iv = InfoflowConfiguration.PathReconstructionMode.values();
        optionWithValues2 = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (InfoflowConfiguration.SootIntegrationMode element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        flowDroidOptions.pathReconstructionMode$delegate = OptionWithValuesKt.default$default((OptionWithValues)ChoiceKt.choice$default((OptionWithValues)optionWithValues2, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null), (Object)InfoflowConfiguration.PathReconstructionMode.Precise, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[29]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null);
        flowDroidOptions = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        $this$associateBy$iv$iv = InfoflowConfiguration.PathBuildingAlgorithm.values();
        optionWithValues2 = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (InfoflowConfiguration.SootIntegrationMode element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        flowDroidOptions.pathBuildingAlgorithm$delegate = OptionWithValuesKt.default$default((OptionWithValues)ChoiceKt.choice$default((OptionWithValues)optionWithValues2, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null), (Object)InfoflowConfiguration.PathBuildingAlgorithm.ContextSensitive, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[30]);
        this.maxCallStackSize$delegate = OptionWithValuesKt.default$default((OptionWithValues)RangeKt.restrictTo$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (ClosedRange)((ClosedRange)new IntRange(-1, Integer.MAX_VALUE)), (boolean)false, (int)2, null), (Object)30, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[31]);
        this.maxPathLength$delegate = OptionWithValuesKt.default$default((OptionWithValues)RangeKt.restrictTo$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (ClosedRange)((ClosedRange)new IntRange(-1, Integer.MAX_VALUE)), (boolean)false, (int)2, null), (Object)75, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[32]);
        this.maxPathsPerAbstraction$delegate = OptionWithValuesKt.default$default((OptionWithValues)RangeKt.restrictTo$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (ClosedRange)((ClosedRange)new IntRange(-1, Integer.MAX_VALUE)), (boolean)false, (int)2, null), (Object)15, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[33]);
        this.pathReconstructionTimeout$delegate = OptionWithValuesKt.default$default((OptionWithValues)RangeKt.restrictTo$default((OptionWithValues)LongKt.long$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (ClosedRange)((ClosedRange)new LongRange((long)-1, Long.MAX_VALUE)), (boolean)false, (int)2, null), (Object)0L, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[34]);
        this.pathReconstructionBatchSize$delegate = OptionWithValuesKt.default$default((OptionWithValues)RangeKt.restrictTo$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (ClosedRange)((ClosedRange)new IntRange(-1, Integer.MAX_VALUE)), (boolean)false, (int)2, null), (Object)5, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[35]);
        this.accessPathLength$delegate = OptionWithValuesKt.default$default((OptionWithValues)RangeKt.restrictTo$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (ClosedRange)((ClosedRange)new IntRange(-1, Integer.MAX_VALUE)), (boolean)false, (int)2, null), (Object)25, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[36]);
        this.useRecursiveAccessPaths$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[37]);
        this.useThisChainReduction$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[38]);
        this.useSameFieldReduction$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[39]);
        this.disableSparseOpt$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[40]);
        this.maxJoinPointAbstractions$delegate = OptionWithValuesKt.default$default((OptionWithValues)RangeKt.restrictTo$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (ClosedRange)((ClosedRange)new IntRange(-1, Integer.MAX_VALUE)), (boolean)false, (int)2, null), (Object)-1, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[41]);
        this.maxAbstractionPathLength$delegate = OptionWithValuesKt.default$default((OptionWithValues)RangeKt.restrictTo$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (ClosedRange)((ClosedRange)new IntRange(-1, Integer.MAX_VALUE)), (boolean)false, (int)2, null), (Object)-1, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[42]);
        this.maxCalleesPerCallSite$delegate = OptionWithValuesKt.default$default((OptionWithValues)RangeKt.restrictTo$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (ClosedRange)((ClosedRange)new IntRange(-1, Integer.MAX_VALUE)), (boolean)false, (int)2, null), (Object)-1, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[43]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)this.isHidden, null, null, null, null, (boolean)false, (int)502, null);
        flowDroidOptions = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        $this$associateBy$iv$iv = InfoflowConfiguration.DataFlowSolver.values();
        optionWithValues2 = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (InfoflowConfiguration.SootIntegrationMode element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        flowDroidOptions.dataFlowSolver$delegate = OptionWithValuesKt.default$default((OptionWithValues)ChoiceKt.choice$default((OptionWithValues)optionWithValues2, (Map)var11_16, null, (boolean)ignoreCase$iv, (int)2, null), (Object)InfoflowConfiguration.DataFlowSolver.ContextFlowSensitive, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[44]);
    }

    public /* synthetic */ FlowDroidOptions(boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = false;
        }
        this(bl);
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public final boolean getEnableFlowDroid() {
        return (Boolean)this.enableFlowDroid$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    private final String getBaseDirectory() {
        return (String)this.baseDirectory$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    private final boolean getNoPathAgnosticResults() {
        return (Boolean)this.noPathAgnosticResults$delegate.getValue((Object)this, $$delegatedProperties[2]);
    }

    private final boolean getOneResultPerAccessPath() {
        return (Boolean)this.oneResultPerAccessPath$delegate.getValue((Object)this, $$delegatedProperties[3]);
    }

    private final boolean getMergeNeighbors() {
        return (Boolean)this.mergeNeighbors$delegate.getValue((Object)this, $$delegatedProperties[4]);
    }

    private final int getStopAfterFirstKFlows() {
        return ((Number)this.stopAfterFirstKFlows$delegate.getValue((Object)this, $$delegatedProperties[5])).intValue();
    }

    private final boolean getInspectSources() {
        return (Boolean)this.inspectSources$delegate.getValue((Object)this, $$delegatedProperties[6]);
    }

    private final boolean getInspectSinks() {
        return (Boolean)this.inspectSinks$delegate.getValue((Object)this, $$delegatedProperties[7]);
    }

    private final InfoflowConfiguration.ImplicitFlowMode getImplicitFlowMode() {
        return (InfoflowConfiguration.ImplicitFlowMode)this.implicitFlowMode$delegate.getValue((Object)this, $$delegatedProperties[8]);
    }

    private final InfoflowConfiguration.SootIntegrationMode getSootIntegrationMode() {
        return (InfoflowConfiguration.SootIntegrationMode)this.sootIntegrationMode$delegate.getValue((Object)this, $$delegatedProperties[9]);
    }

    private final boolean getDisableFlowSensitiveAliasing() {
        return (Boolean)this.disableFlowSensitiveAliasing$delegate.getValue((Object)this, $$delegatedProperties[10]);
    }

    private final boolean getDisableExceptionTracking() {
        return (Boolean)this.disableExceptionTracking$delegate.getValue((Object)this, $$delegatedProperties[11]);
    }

    private final boolean getDisableArrayTracking() {
        return (Boolean)this.disableArrayTracking$delegate.getValue((Object)this, $$delegatedProperties[12]);
    }

    private final boolean getDisableArraySizeTainting() {
        return (Boolean)this.disableArraySizeTainting$delegate.getValue((Object)this, $$delegatedProperties[13]);
    }

    private final boolean getDisableTypeChecking() {
        return (Boolean)this.disableTypeChecking$delegate.getValue((Object)this, $$delegatedProperties[14]);
    }

    private final InfoflowConfiguration.CallgraphAlgorithm getCallgraphAlgorithm() {
        return (InfoflowConfiguration.CallgraphAlgorithm)this.callgraphAlgorithm$delegate.getValue((Object)this, $$delegatedProperties[15]);
    }

    private final InfoflowConfiguration.AliasingAlgorithm getAliasingAlgorithm() {
        return (InfoflowConfiguration.AliasingAlgorithm)this.aliasingAlgorithm$delegate.getValue((Object)this, $$delegatedProperties[16]);
    }

    private final InfoflowConfiguration.DataFlowDirection getDataFlowDirection() {
        return (InfoflowConfiguration.DataFlowDirection)this.dataFlowDirection$delegate.getValue((Object)this, $$delegatedProperties[17]);
    }

    private final boolean getIgnoreFlowsInSystemPackages() {
        return (Boolean)this.ignoreFlowsInSystemPackages$delegate.getValue((Object)this, $$delegatedProperties[18]);
    }

    private final boolean getWriteOutputFiles() {
        return (Boolean)this.writeOutputFiles$delegate.getValue((Object)this, $$delegatedProperties[19]);
    }

    private final InfoflowConfiguration.CodeEliminationMode getCodeEliminationMode() {
        return (InfoflowConfiguration.CodeEliminationMode)this.codeEliminationMode$delegate.getValue((Object)this, $$delegatedProperties[20]);
    }

    private final boolean getDisableLogSourcesAndSinks() {
        return (Boolean)this.disableLogSourcesAndSinks$delegate.getValue((Object)this, $$delegatedProperties[21]);
    }

    private final boolean getEnableReflection() {
        return (Boolean)this.enableReflection$delegate.getValue((Object)this, $$delegatedProperties[22]);
    }

    private final boolean getDisableLineNumbers() {
        return (Boolean)this.disableLineNumbers$delegate.getValue((Object)this, $$delegatedProperties[23]);
    }

    private final boolean getDisableTaintAnalysis() {
        return (Boolean)this.disableTaintAnalysis$delegate.getValue((Object)this, $$delegatedProperties[24]);
    }

    private final boolean getIncrementalResultReporting() {
        return (Boolean)this.incrementalResultReporting$delegate.getValue((Object)this, $$delegatedProperties[25]);
    }

    private final long getDataFlowTimeout() {
        return ((Number)this.dataFlowTimeout$delegate.getValue((Object)this, $$delegatedProperties[26])).longValue();
    }

    private final boolean getOneSourceAtATime() {
        return (Boolean)this.oneSourceAtATime$delegate.getValue((Object)this, $$delegatedProperties[27]);
    }

    private final boolean getSequentialPathProcessing() {
        return (Boolean)this.sequentialPathProcessing$delegate.getValue((Object)this, $$delegatedProperties[28]);
    }

    private final InfoflowConfiguration.PathReconstructionMode getPathReconstructionMode() {
        return (InfoflowConfiguration.PathReconstructionMode)this.pathReconstructionMode$delegate.getValue((Object)this, $$delegatedProperties[29]);
    }

    private final InfoflowConfiguration.PathBuildingAlgorithm getPathBuildingAlgorithm() {
        return (InfoflowConfiguration.PathBuildingAlgorithm)this.pathBuildingAlgorithm$delegate.getValue((Object)this, $$delegatedProperties[30]);
    }

    private final int getMaxCallStackSize() {
        return ((Number)this.maxCallStackSize$delegate.getValue((Object)this, $$delegatedProperties[31])).intValue();
    }

    private final int getMaxPathLength() {
        return ((Number)this.maxPathLength$delegate.getValue((Object)this, $$delegatedProperties[32])).intValue();
    }

    private final int getMaxPathsPerAbstraction() {
        return ((Number)this.maxPathsPerAbstraction$delegate.getValue((Object)this, $$delegatedProperties[33])).intValue();
    }

    private final long getPathReconstructionTimeout() {
        return ((Number)this.pathReconstructionTimeout$delegate.getValue((Object)this, $$delegatedProperties[34])).longValue();
    }

    private final int getPathReconstructionBatchSize() {
        return ((Number)this.pathReconstructionBatchSize$delegate.getValue((Object)this, $$delegatedProperties[35])).intValue();
    }

    private final int getAccessPathLength() {
        return ((Number)this.accessPathLength$delegate.getValue((Object)this, $$delegatedProperties[36])).intValue();
    }

    private final boolean getUseRecursiveAccessPaths() {
        return (Boolean)this.useRecursiveAccessPaths$delegate.getValue((Object)this, $$delegatedProperties[37]);
    }

    private final boolean getUseThisChainReduction() {
        return (Boolean)this.useThisChainReduction$delegate.getValue((Object)this, $$delegatedProperties[38]);
    }

    private final boolean getUseSameFieldReduction() {
        return (Boolean)this.useSameFieldReduction$delegate.getValue((Object)this, $$delegatedProperties[39]);
    }

    private final boolean getDisableSparseOpt() {
        return (Boolean)this.disableSparseOpt$delegate.getValue((Object)this, $$delegatedProperties[40]);
    }

    private final int getMaxJoinPointAbstractions() {
        return ((Number)this.maxJoinPointAbstractions$delegate.getValue((Object)this, $$delegatedProperties[41])).intValue();
    }

    private final int getMaxAbstractionPathLength() {
        return ((Number)this.maxAbstractionPathLength$delegate.getValue((Object)this, $$delegatedProperties[42])).intValue();
    }

    private final int getMaxCalleesPerCallSite() {
        return ((Number)this.maxCalleesPerCallSite$delegate.getValue((Object)this, $$delegatedProperties[43])).intValue();
    }

    private final InfoflowConfiguration.DataFlowSolver getDataFlowSolver() {
        return (InfoflowConfiguration.DataFlowSolver)this.dataFlowSolver$delegate.getValue((Object)this, $$delegatedProperties[44]);
    }

    private final void initializeGlobalStaticCommandLineOptions() {
        InfoflowConfiguration.setBaseDirectory((String)this.getBaseDirectory());
        InfoflowConfiguration.setOneResultPerAccessPath((boolean)this.getOneResultPerAccessPath());
        InfoflowConfiguration.setMergeNeighbors((boolean)this.getMergeNeighbors());
    }

    public final void configureInfoFlowConfig(@NotNull InfoflowConfiguration infoFlowConfig, @NotNull MainConfig mainConfig) {
        Intrinsics.checkNotNullParameter((Object)infoFlowConfig, (String)"infoFlowConfig");
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        this.initializeGlobalStaticCommandLineOptions();
        infoFlowConfig.setOneSourceAtATime(this.getOneSourceAtATime());
        infoFlowConfig.setStopAfterFirstKFlows(this.getStopAfterFirstKFlows());
        infoFlowConfig.setInspectSources(this.getInspectSources());
        infoFlowConfig.setInspectSinks(this.getInspectSinks());
        infoFlowConfig.setImplicitFlowMode(this.getImplicitFlowMode());
        infoFlowConfig.setStaticFieldTrackingMode(FlowDroidOptionsKt.getCvt((StaticFieldTrackingMode)mainConfig.getStaticFieldTrackingMode()));
        infoFlowConfig.setSootIntegrationMode(this.getSootIntegrationMode());
        infoFlowConfig.setFlowSensitiveAliasing(!this.getDisableFlowSensitiveAliasing());
        infoFlowConfig.setEnableExceptionTracking(!this.getDisableExceptionTracking());
        infoFlowConfig.setEnableArrayTracking(!this.getDisableArrayTracking());
        infoFlowConfig.setEnableArraySizeTainting(!this.getDisableArraySizeTainting());
        infoFlowConfig.setCallgraphAlgorithm(this.getCallgraphAlgorithm());
        infoFlowConfig.setAliasingAlgorithm(this.getAliasingAlgorithm());
        infoFlowConfig.setDataFlowDirection(this.getDataFlowDirection());
        infoFlowConfig.setEnableTypeChecking(!this.getDisableTypeChecking());
        infoFlowConfig.setIgnoreFlowsInSystemPackages(this.getIgnoreFlowsInSystemPackages());
        infoFlowConfig.setExcludeSootLibraryClasses(mainConfig.getApponly());
        infoFlowConfig.setMaxThreadNum(mainConfig.getParallelsNum());
        infoFlowConfig.setWriteOutputFiles(this.getWriteOutputFiles());
        infoFlowConfig.setCodeEliminationMode(this.getCodeEliminationMode());
        infoFlowConfig.setLogSourcesAndSinks(!this.getDisableLogSourcesAndSinks());
        infoFlowConfig.setEnableReflection(this.getEnableReflection());
        infoFlowConfig.setEnableLineNumbers(!this.getDisableLineNumbers());
        infoFlowConfig.setEnableOriginalNames(true);
        infoFlowConfig.setTaintAnalysisEnabled(!this.getDisableTaintAnalysis());
        infoFlowConfig.setIncrementalResultReporting(this.getIncrementalResultReporting());
        infoFlowConfig.setDataFlowTimeout(this.getDataFlowTimeout());
        infoFlowConfig.setMemoryThreshold(mainConfig.getMemoryThreshold());
        infoFlowConfig.setPathAgnosticResults(!this.getNoPathAgnosticResults());
        InfoflowConfiguration.PathConfiguration pathConfiguration = infoFlowConfig.getPathConfiguration();
        pathConfiguration.setSequentialPathProcessing(this.getSequentialPathProcessing());
        pathConfiguration.setPathReconstructionMode(this.getPathReconstructionMode());
        pathConfiguration.setPathBuildingAlgorithm(this.getPathBuildingAlgorithm());
        pathConfiguration.setMaxCallStackSize(this.getMaxCallStackSize());
        pathConfiguration.setMaxPathLength(this.getMaxPathLength());
        pathConfiguration.setMaxPathsPerAbstraction(this.getMaxPathsPerAbstraction());
        pathConfiguration.setPathReconstructionTimeout(this.getPathReconstructionTimeout());
        pathConfiguration.setPathReconstructionBatchSize(this.getPathReconstructionBatchSize());
        InfoflowConfiguration.AccessPathConfiguration accessPathConfiguration = infoFlowConfig.getAccessPathConfiguration();
        accessPathConfiguration.setAccessPathLength(this.getAccessPathLength());
        accessPathConfiguration.setUseRecursiveAccessPaths(this.getUseRecursiveAccessPaths());
        accessPathConfiguration.setUseThisChainReduction(this.getUseThisChainReduction());
        accessPathConfiguration.setUseSameFieldReduction(this.getUseSameFieldReduction());
        InfoflowConfiguration.SolverConfiguration solverConfiguration = infoFlowConfig.getSolverConfiguration();
        solverConfiguration.setMaxJoinPointAbstractions(this.getMaxJoinPointAbstractions());
        solverConfiguration.setMaxAbstractionPathLength(this.getMaxAbstractionPathLength());
        solverConfiguration.setMaxCalleesPerCallSite(this.getMaxCalleesPerCallSite());
        solverConfiguration.setDataFlowSolver(this.getDataFlowSolver());
    }

    @NotNull
    public final InfoflowConfigurationExt getExtInfoFlowConfig() {
        InfoflowConfigurationExt infoflowConfigurationExt;
        InfoflowConfigurationExt $this$getExtInfoFlowConfig_u24lambda_u241 = infoflowConfigurationExt = new InfoflowConfigurationExt(false, null, 3, null);
        boolean bl = false;
        $this$getExtInfoFlowConfig_u24lambda_u241.setUseSparseOpt(!this.getDisableSparseOpt());
        return infoflowConfigurationExt;
    }

    public FlowDroidOptions() {
        this(false, 1, null);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "enableFlowDroid", "getEnableFlowDroid()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "baseDirectory", "getBaseDirectory()Ljava/lang/String;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "noPathAgnosticResults", "getNoPathAgnosticResults()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "oneResultPerAccessPath", "getOneResultPerAccessPath()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "mergeNeighbors", "getMergeNeighbors()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "stopAfterFirstKFlows", "getStopAfterFirstKFlows()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "inspectSources", "getInspectSources()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "inspectSinks", "getInspectSinks()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "implicitFlowMode", "getImplicitFlowMode()Lsoot/jimple/infoflow/InfoflowConfiguration$ImplicitFlowMode;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "sootIntegrationMode", "getSootIntegrationMode()Lsoot/jimple/infoflow/InfoflowConfiguration$SootIntegrationMode;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "disableFlowSensitiveAliasing", "getDisableFlowSensitiveAliasing()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "disableExceptionTracking", "getDisableExceptionTracking()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "disableArrayTracking", "getDisableArrayTracking()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "disableArraySizeTainting", "getDisableArraySizeTainting()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "disableTypeChecking", "getDisableTypeChecking()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "callgraphAlgorithm", "getCallgraphAlgorithm()Lsoot/jimple/infoflow/InfoflowConfiguration$CallgraphAlgorithm;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "aliasingAlgorithm", "getAliasingAlgorithm()Lsoot/jimple/infoflow/InfoflowConfiguration$AliasingAlgorithm;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "dataFlowDirection", "getDataFlowDirection()Lsoot/jimple/infoflow/InfoflowConfiguration$DataFlowDirection;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "ignoreFlowsInSystemPackages", "getIgnoreFlowsInSystemPackages()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "writeOutputFiles", "getWriteOutputFiles()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "codeEliminationMode", "getCodeEliminationMode()Lsoot/jimple/infoflow/InfoflowConfiguration$CodeEliminationMode;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "disableLogSourcesAndSinks", "getDisableLogSourcesAndSinks()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "enableReflection", "getEnableReflection()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "disableLineNumbers", "getDisableLineNumbers()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "disableTaintAnalysis", "getDisableTaintAnalysis()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "incrementalResultReporting", "getIncrementalResultReporting()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "dataFlowTimeout", "getDataFlowTimeout()J", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "oneSourceAtATime", "getOneSourceAtATime()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "sequentialPathProcessing", "getSequentialPathProcessing()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "pathReconstructionMode", "getPathReconstructionMode()Lsoot/jimple/infoflow/InfoflowConfiguration$PathReconstructionMode;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "pathBuildingAlgorithm", "getPathBuildingAlgorithm()Lsoot/jimple/infoflow/InfoflowConfiguration$PathBuildingAlgorithm;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "maxCallStackSize", "getMaxCallStackSize()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "maxPathLength", "getMaxPathLength()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "maxPathsPerAbstraction", "getMaxPathsPerAbstraction()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "pathReconstructionTimeout", "getPathReconstructionTimeout()J", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "pathReconstructionBatchSize", "getPathReconstructionBatchSize()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "accessPathLength", "getAccessPathLength()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "useRecursiveAccessPaths", "getUseRecursiveAccessPaths()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "useThisChainReduction", "getUseThisChainReduction()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "useSameFieldReduction", "getUseSameFieldReduction()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "disableSparseOpt", "getDisableSparseOpt()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "maxJoinPointAbstractions", "getMaxJoinPointAbstractions()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "maxAbstractionPathLength", "getMaxAbstractionPathLength()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "maxCalleesPerCallSite", "getMaxCalleesPerCallSite()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidOptions.class, "dataFlowSolver", "getDataFlowSolver()Lsoot/jimple/infoflow/InfoflowConfiguration$DataFlowSolver;", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}

