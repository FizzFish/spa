/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.AnalyzerEnv
 *  cn.sast.api.config.BuiltinAnalysisConfig
 *  cn.sast.api.config.CheckerInfoGenResult
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.ProjectConfig
 *  cn.sast.api.config.SaConfig
 *  cn.sast.api.config.ScanFilter
 *  cn.sast.api.config.SrcPrecedence
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  cn.sast.api.incremental.IncrementalAnalyze
 *  cn.sast.api.report.CheckType2StringKind
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.IResultCollector
 *  cn.sast.api.report.Report
 *  cn.sast.api.util.IMonitor
 *  cn.sast.api.util.PhaseIntervalTimer
 *  cn.sast.api.util.PhaseIntervalTimer$Snapshot
 *  cn.sast.cli.ApplicationKt
 *  cn.sast.cli.command.AndroidOptions
 *  cn.sast.cli.command.DataFlowOptions
 *  cn.sast.cli.command.FlowDroidOptions
 *  cn.sast.cli.command.FySastCli
 *  cn.sast.cli.command.FySastCli$Companion
 *  cn.sast.cli.command.FySastCli$ResultType
 *  cn.sast.cli.command.FySastCli$WhenMappings
 *  cn.sast.cli.command.FySastCli$getFilteredJavaSourceFiles$1
 *  cn.sast.cli.command.FySastCli$main2$2
 *  cn.sast.cli.command.FySastCli$runAnalyze$1
 *  cn.sast.cli.command.FySastCli$runCodeMetrics$1
 *  cn.sast.cli.command.FySastCli$special$$inlined$check$default$1
 *  cn.sast.cli.command.FySastCli$special$$inlined$check$default$4
 *  cn.sast.cli.command.FySastCli$special$$inlined$check$default$5
 *  cn.sast.cli.command.FySastCli$special$$inlined$convert$default$8
 *  cn.sast.cli.command.FySastCli$special$$inlined$convert$default$9
 *  cn.sast.cli.command.FySastCliKt
 *  cn.sast.cli.command.IClassAnalyzeOptionGroup
 *  cn.sast.cli.command.JavaOptions
 *  cn.sast.cli.command.SrcAnalyzeOptions
 *  cn.sast.cli.command.TargetOptions
 *  cn.sast.cli.command.UtAnalyzeOptions
 *  cn.sast.cli.command.tools.CheckerInfoCompareOptions
 *  cn.sast.cli.command.tools.CheckerInfoGenerator
 *  cn.sast.cli.command.tools.CheckerInfoGenerator$Companion
 *  cn.sast.cli.command.tools.CheckerInfoGeneratorOptions
 *  cn.sast.cli.command.tools.SubToolsOptions
 *  cn.sast.common.CustomRepeatingTimer
 *  cn.sast.common.FileSystemLocator
 *  cn.sast.common.FileSystemLocator$TraverseMode
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResDirectory$DefaultImpls
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.OS
 *  cn.sast.common.PathExtensionsKt
 *  cn.sast.common.Resource
 *  cn.sast.common.ResourceImplKt
 *  cn.sast.common.ResourceKt
 *  cn.sast.common.TimeUtilsKt
 *  cn.sast.framework.AnalyzeTaskRunner
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.engine.BuiltinAnalysis
 *  cn.sast.framework.engine.BuiltinAnalysis$CHA-AllMethodsProvider
 *  cn.sast.framework.engine.FlowDroidEngine
 *  cn.sast.framework.engine.IPAnalysisEngine
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.incremental.IncrementalAnalyzeImplByChangeFiles
 *  cn.sast.framework.metrics.MetricsMonitor
 *  cn.sast.framework.plugin.CheckerFilterByName
 *  cn.sast.framework.plugin.ConfigPluginLoader
 *  cn.sast.framework.report.AbstractFileIndexer
 *  cn.sast.framework.report.AbstractFileIndexer$CompareMode
 *  cn.sast.framework.report.FileSystemCacheLocator
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  cn.sast.framework.report.NullWrapperFileGenerator
 *  cn.sast.framework.report.ProjectFileLocator
 *  cn.sast.framework.report.SqliteDiagnostics
 *  cn.sast.framework.report.coverage.JacocoCompoundCoverage
 *  cn.sast.framework.result.MissingSummaryReporter
 *  cn.sast.framework.result.OutputType
 *  cn.sast.framework.result.ResultCollector
 *  cn.sast.framework.result.ResultCounter
 *  cn.sast.framework.rewrite.IdentityStmt2MethodParamRegion
 *  cn.sast.framework.util.SAXReaderBugTest
 *  cn.sast.framework.util.SootUtils
 *  cn.sast.framework.validator.AccuracyValidator
 *  cn.sast.framework.validator.AccuracyValidator$Result
 *  cn.sast.idfa.analysis.ProcessInfoView
 *  cn.sast.idfa.analysis.UsefulMetrics
 *  com.feysh.corax.cache.AnalysisCache$G
 *  com.feysh.corax.cache.analysis.CompilationUnitOfSCFactory
 *  com.feysh.corax.cache.analysis.SootHostExtInfoFactory
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.Language
 *  com.feysh.corax.config.api.rules.ProcessRule$ScanAction
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  com.feysh.corax.config.builtin.checkers.DefineUnusedChecker$UnusedMethod
 *  com.github.ajalt.clikt.completion.CompletionCandidates
 *  com.github.ajalt.clikt.core.BadParameterValue
 *  com.github.ajalt.clikt.core.CliktCommand
 *  com.github.ajalt.clikt.core.CliktCommandKt
 *  com.github.ajalt.clikt.core.Context
 *  com.github.ajalt.clikt.core.Context$Builder
 *  com.github.ajalt.clikt.core.ContextKt
 *  com.github.ajalt.clikt.core.GroupableOption
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.output.MordantHelpFormatter
 *  com.github.ajalt.clikt.parameters.groups.ChoiceGroupKt
 *  com.github.ajalt.clikt.parameters.groups.CoOccurringOptionGroupKt
 *  com.github.ajalt.clikt.parameters.groups.OptionGroup
 *  com.github.ajalt.clikt.parameters.groups.ParameterGroup
 *  com.github.ajalt.clikt.parameters.options.EagerOptionKt
 *  com.github.ajalt.clikt.parameters.options.FlagOptionKt
 *  com.github.ajalt.clikt.parameters.options.Option
 *  com.github.ajalt.clikt.parameters.options.OptionDelegate
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues$DefaultImpls
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  com.github.ajalt.clikt.parameters.types.ChoiceKt
 *  com.github.ajalt.clikt.parameters.types.DoubleKt
 *  com.github.ajalt.clikt.parameters.types.FileKt
 *  com.github.ajalt.clikt.parameters.types.IntKt
 *  com.github.ajalt.mordant.rendering.TextStyle
 *  com.github.ajalt.mordant.rendering.Theme
 *  com.google.gson.Gson
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.NotImplementedError
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.FilesKt
 *  kotlin.io.path.PathsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.SpreadBuilder
 *  kotlin.math.MathKt
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentSet$Builder
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineDispatcher
 *  kotlinx.coroutines.CoroutineName
 *  kotlinx.coroutines.Dispatchers
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.apache.logging.log4j.core.config.Configurator
 *  org.apache.logging.slf4j.Log4jLogger
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.slf4j.event.Level
 *  soot.PackManager
 *  soot.SootClass
 *  soot.Transform
 *  soot.Transformer
 *  soot.options.Options
 */
package cn.sast.cli.command;

import cn.sast.api.AnalyzerEnv;
import cn.sast.api.config.BuiltinAnalysisConfig;
import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.MainConfig;
import cn.sast.api.config.ProjectConfig;
import cn.sast.api.config.SaConfig;
import cn.sast.api.config.ScanFilter;
import cn.sast.api.config.SrcPrecedence;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.api.incremental.IncrementalAnalyze;
import cn.sast.api.report.CheckType2StringKind;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.IResultCollector;
import cn.sast.api.report.Report;
import cn.sast.api.util.IMonitor;
import cn.sast.api.util.PhaseIntervalTimer;
import cn.sast.cli.ApplicationKt;
import cn.sast.cli.command.AndroidOptions;
import cn.sast.cli.command.DataFlowOptions;
import cn.sast.cli.command.FlowDroidOptions;
import cn.sast.cli.command.FySastCli;
import cn.sast.cli.command.FySastCli$special$;
import cn.sast.cli.command.FySastCliKt;
import cn.sast.cli.command.IClassAnalyzeOptionGroup;
import cn.sast.cli.command.JavaOptions;
import cn.sast.cli.command.SrcAnalyzeOptions;
import cn.sast.cli.command.TargetOptions;
import cn.sast.cli.command.UtAnalyzeOptions;
import cn.sast.cli.command.tools.CheckerInfoCompareOptions;
import cn.sast.cli.command.tools.CheckerInfoGenerator;
import cn.sast.cli.command.tools.CheckerInfoGeneratorOptions;
import cn.sast.cli.command.tools.SubToolsOptions;
import cn.sast.common.CustomRepeatingTimer;
import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.OS;
import cn.sast.common.PathExtensionsKt;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import cn.sast.common.ResourceKt;
import cn.sast.common.TimeUtilsKt;
import cn.sast.framework.AnalyzeTaskRunner;
import cn.sast.framework.SootCtx;
import cn.sast.framework.engine.BuiltinAnalysis;
import cn.sast.framework.engine.FlowDroidEngine;
import cn.sast.framework.engine.IPAnalysisEngine;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.incremental.IncrementalAnalyzeImplByChangeFiles;
import cn.sast.framework.metrics.MetricsMonitor;
import cn.sast.framework.plugin.CheckerFilterByName;
import cn.sast.framework.plugin.ConfigPluginLoader;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.FileSystemCacheLocator;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IWrapperFileGenerator;
import cn.sast.framework.report.NullWrapperFileGenerator;
import cn.sast.framework.report.ProjectFileLocator;
import cn.sast.framework.report.SqliteDiagnostics;
import cn.sast.framework.report.coverage.JacocoCompoundCoverage;
import cn.sast.framework.result.MissingSummaryReporter;
import cn.sast.framework.result.OutputType;
import cn.sast.framework.result.ResultCollector;
import cn.sast.framework.result.ResultCounter;
import cn.sast.framework.rewrite.IdentityStmt2MethodParamRegion;
import cn.sast.framework.util.SAXReaderBugTest;
import cn.sast.framework.util.SootUtils;
import cn.sast.framework.validator.AccuracyValidator;
import cn.sast.idfa.analysis.ProcessInfoView;
import cn.sast.idfa.analysis.UsefulMetrics;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.analysis.CompilationUnitOfSCFactory;
import com.feysh.corax.cache.analysis.SootHostExtInfoFactory;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.rules.ProcessRule;
import com.feysh.corax.config.api.utils.UtilsKt;
import com.feysh.corax.config.builtin.checkers.DefineUnusedChecker;
import com.github.ajalt.clikt.completion.CompletionCandidates;
import com.github.ajalt.clikt.core.BadParameterValue;
import com.github.ajalt.clikt.core.CliktCommand;
import com.github.ajalt.clikt.core.CliktCommandKt;
import com.github.ajalt.clikt.core.Context;
import com.github.ajalt.clikt.core.ContextKt;
import com.github.ajalt.clikt.core.GroupableOption;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.output.MordantHelpFormatter;
import com.github.ajalt.clikt.parameters.groups.ChoiceGroupKt;
import com.github.ajalt.clikt.parameters.groups.CoOccurringOptionGroupKt;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.groups.ParameterGroup;
import com.github.ajalt.clikt.parameters.options.EagerOptionKt;
import com.github.ajalt.clikt.parameters.options.FlagOptionKt;
import com.github.ajalt.clikt.parameters.options.Option;
import com.github.ajalt.clikt.parameters.options.OptionDelegate;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.ChoiceKt;
import com.github.ajalt.clikt.parameters.types.DoubleKt;
import com.github.ajalt.clikt.parameters.types.FileKt;
import com.github.ajalt.clikt.parameters.types.IntKt;
import com.github.ajalt.mordant.rendering.TextStyle;
import com.github.ajalt.mordant.rendering.Theme;
import com.google.gson.Gson;
import java.io.Closeable;
import java.io.File;
import java.io.OutputStreamWriter;
import java.lang.invoke.LambdaMetafactory;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.math.MathKt;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentSet;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Dispatchers;
import mu.KLogger;
import mu.KotlinLogging;
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

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00a8\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 \u009d\u00022\u00020\u0001:\u0004\u009c\u0002\u009d\u0002B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u00e0\u0001\u001a\u00030\u00e1\u0001H\u0002J\n\u0010\u00e2\u0001\u001a\u00030\u00e1\u0001H\u0002J\u0019\u0010\u00e3\u0001\u001a\u00030\u00e4\u00012\r\u0010\u00e5\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0#H\u0002J,\u0010\u00e6\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u00e8\u0001\u0012\u0005\u0012\u00030\u00e9\u00010\u00e7\u00012\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u00ea\u0001\u001a\u0005\u0018\u00010\u00e4\u0001H\u0002J&\u0010\u00eb\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u00e8\u0001\u0012\u0005\u0012\u00030\u00e9\u0001\u0018\u00010\u00e7\u00012\n\u0010\u00ea\u0001\u001a\u0005\u0018\u00010\u00e4\u0001H\u0002J\n\u0010\u00ec\u0001\u001a\u00030\u00e1\u0001H\u0002J\n\u0010\u00ed\u0001\u001a\u00030\u00e1\u0001H\u0016J\u0010\u0010\u00ee\u0001\u001a\u00030\u00e1\u00012\u0006\u0010\u0004\u001a\u00020\u0005J2\u0010\u00f4\u0001\u001a\u00030\u00f5\u00012\b\u0010\u00f6\u0001\u001a\u00030\u00f7\u00012\b\u0010\u00f8\u0001\u001a\u00030\u00f9\u00012\b\u0010\u00fa\u0001\u001a\u00030\u00fb\u00012\b\u0010\u00fc\u0001\u001a\u00030\u00fd\u0001H\u0002J$\u0010\u00fe\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u00e8\u0001\u0012\u0005\u0012\u00030\u00e9\u00010\u00e7\u00012\n\u0010\u00ea\u0001\u001a\u0005\u0018\u00010\u00e4\u0001H\u0002J\u001e\u0010\u00ff\u0001\u001a\u00030\u00e1\u00012\b\u0010\u00fa\u0001\u001a\u00030\u00fb\u00012\b\u0010\u00fc\u0001\u001a\u00030\u00fd\u0001H\u0002J\n\u0010\u0080\u0002\u001a\u00030\u00e1\u0001H\u0002J\n\u0010\u0083\u0002\u001a\u00030\u00e1\u0001H\u0002J\n\u0010\u0084\u0002\u001a\u00030\u00e1\u0001H\u0002J\u0014\u0010\u0085\u0002\u001a\u00030\u00e1\u00012\b\u0010\u00f8\u0001\u001a\u00030\u00f9\u0001H\u0002J+\u0010\u0086\u0002\u001a\t\u0012\u0005\u0012\u00030\u0082\u00020#2\b\u0010\u00fa\u0001\u001a\u00030\u00fb\u00012\b\u0010\u00f8\u0001\u001a\u00030\u00f9\u0001H\u0082@\u00a2\u0006\u0003\u0010\u0087\u0002J.\u0010\u0088\u0002\u001a\u00030\u00e1\u00012\b\u0010\u00fa\u0001\u001a\u00030\u00fb\u00012\b\u0010\u0089\u0002\u001a\u00030\u0082\u00022\u000e\u0010\u008a\u0002\u001a\t\u0012\u0005\u0012\u00030\u0082\u00020#H\u0002J$\u0010\u008b\u0002\u001a\u00030\u00e1\u00012\b\u0010\u00fa\u0001\u001a\u00030\u00fb\u00012\u000e\u0010\u008c\u0002\u001a\t\u0012\u0005\u0012\u00030\u0082\u00020#H\u0002J+\u0010\u008d\u0002\u001a\u00030\u00e1\u00012\b\u0010\u00fa\u0001\u001a\u00030\u00fb\u00012\u000e\u0010\u008a\u0002\u001a\t\u0012\u0005\u0012\u00030\u0082\u00020#H\u0082@\u00a2\u0006\u0003\u0010\u008e\u0002J\u0014\u0010\u008f\u0002\u001a\u00030\u00e1\u00012\b\u0010\u00fc\u0001\u001a\u00030\u00fd\u0001H\u0002J#\u0010\u0093\u0002\u001a\u00030\u00e1\u00012\u0006\u00103\u001a\u0002042\b\u0010\u00fc\u0001\u001a\u00030\u00fd\u0001H\u0082@\u00a2\u0006\u0003\u0010\u0094\u0002J%\u0010\u0095\u0002\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00102\b\u0010\u0096\u0002\u001a\u00030\u0082\u00022\b\u0010\u0097\u0002\u001a\u00030\u0082\u0002H\u0002J\u0017\u0010\u0098\u0002\u001a\u00030\u00e1\u00012\r\u0010\u0099\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010J\u001e\u0010\u0098\u0002\u001a\u00030\u00e1\u00012\u000e\u0010\u0099\u0002\u001a\t\u0012\u0004\u0012\u00020\u000b0\u009a\u0002\u00a2\u0006\u0003\u0010\u009b\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR#\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001b\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\u001f\u0010 R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R!\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b*\u0010\u0012R\u000e\u0010,\u001a\u00020\u001eX\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010\t\u001a\u0004\b.\u0010 R\u001d\u00100\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b1\u0010\rR\u001d\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\t\u001a\u0004\b5\u00106R!\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010\t\u001a\u0004\b9\u0010\u0012R!\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010\t\u001a\u0004\b<\u0010\u0012R!\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010\t\u001a\u0004\b?\u0010\u0012R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u0010 R\u001b\u0010I\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bJ\u0010 R!\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00150#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010\t\u001a\u0004\bM\u0010&R'\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108BX\u0082\u0084\u0002\u00a2\u0006\u0012\n\u0004\bR\u0010\t\u0012\u0004\bP\u0010\u0003\u001a\u0004\bQ\u0010\u0012R\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bU\u0010VR!\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010\t\u001a\u0004\bY\u0010\u0012R\u001b\u0010[\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010\t\u001a\u0004\b\\\u0010 R\u001b\u0010^\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b`\u0010\t\u001a\u0004\b_\u0010\rR\u001b\u0010a\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010\t\u001a\u0004\bb\u0010\rR#\u0010d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bf\u0010\t\u001a\u0004\be\u0010\u0012R\u001b\u0010g\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010\t\u001a\u0004\bh\u0010 R\u001b\u0010j\u001a\u00020k8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010\t\u001a\u0004\bl\u0010mR\u001b\u0010o\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bq\u0010\t\u001a\u0004\bp\u0010 R\u001b\u0010r\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bt\u0010\t\u001a\u0004\bs\u0010DR\u001d\u0010u\u001a\u0004\u0018\u00010v8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\by\u0010\t\u001a\u0004\bw\u0010xR\u001b\u0010z\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b|\u0010\t\u001a\u0004\b{\u0010 R\u001b\u0010}\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u007f\u0010\t\u001a\u0004\b~\u0010 R\u001e\u0010\u0080\u0001\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0082\u0001\u0010\t\u001a\u0005\b\u0081\u0001\u0010 R\u001e\u0010\u0083\u0001\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0085\u0001\u0010\t\u001a\u0005\b\u0084\u0001\u0010 R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008a\u0001\u0010\t\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008f\u0001\u0010\t\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0094\u0001\u0010\t\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\"\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0099\u0001\u0010\t\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\"\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u009e\u0001\u0010\t\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\"\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u00a0\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a3\u0001\u0010\t\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u001e\u0010\u00a4\u0001\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00a6\u0001\u0010\t\u001a\u0005\b\u00a5\u0001\u0010 R\u001e\u0010\u00a7\u0001\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00a9\u0001\u0010\t\u001a\u0005\b\u00a8\u0001\u0010 R \u0010\u00aa\u0001\u001a\u00030\u00ab\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00ae\u0001\u0010\t\u001a\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u001e\u0010\u00af\u0001\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00b1\u0001\u0010\t\u001a\u0005\b\u00b0\u0001\u0010\rR\u001e\u0010\u00b2\u0001\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00b4\u0001\u0010\t\u001a\u0005\b\u00b3\u0001\u0010\rR\u001e\u0010\u00b5\u0001\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00b7\u0001\u0010\t\u001a\u0005\b\u00b6\u0001\u0010 R \u0010\u00b8\u0001\u001a\u00030\u00b9\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00bc\u0001\u0010\t\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001R \u0010\u00bd\u0001\u001a\u00030\u00be\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00c1\u0001\u0010\t\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u001e\u0010\u00c2\u0001\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00c4\u0001\u0010\t\u001a\u0005\b\u00c3\u0001\u0010 R\u001e\u0010\u00c5\u0001\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00c7\u0001\u0010\t\u001a\u0005\b\u00c6\u0001\u0010 R,\u0010\u00c8\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00c9\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00cc\u0001\u0010\t\u001a\u0006\b\u00ca\u0001\u0010\u00cb\u0001R&\u0010\u00cd\u0001\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00cf\u0001\u0010\t\u001a\u0005\b\u00ce\u0001\u0010\u0012R\"\u0010\u00d0\u0001\u001a\u0005\u0018\u00010\u00b9\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00d3\u0001\u0010\t\u001a\u0006\b\u00d1\u0001\u0010\u00d2\u0001R*\u0010\u00d4\u0001\u001a\r \u00d6\u0001*\u0005\u0018\u00010\u00d5\u00010\u00d5\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00d9\u0001\u0010\t\u001a\u0006\b\u00d7\u0001\u0010\u00d8\u0001R\u001e\u0010\u00da\u0001\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00dc\u0001\u0010\t\u001a\u0005\b\u00db\u0001\u0010 R \u0010\u00dd\u0001\u001a\u00030\u00b9\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00df\u0001\u0010\t\u001a\u0006\b\u00de\u0001\u0010\u00bb\u0001R%\u0010\u00ef\u0001\u001a\t\u0012\u0005\u0012\u00030\u00f0\u00010\u0010X\u0086\u000e\u00a2\u0006\u0011\n\u0000\u001a\u0005\b\u00f1\u0001\u0010\u0012\"\u0006\b\u00f2\u0001\u0010\u00f3\u0001R\u0012\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0090\u0002\u001a\u00030\u00f5\u0001X\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0091\u0002\u001a\n\u0012\u0005\u0012\u00030\u0082\u00020\u0092\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u009e\u0002"}, d2={"Lcn/sast/cli/command/FySastCli;", "Lcom/github/ajalt/clikt/core/CliktCommand;", "<init>", "()V", "verbosity", "Lorg/slf4j/event/Level;", "getVerbosity", "()Lorg/slf4j/event/Level;", "verbosity$delegate", "Lkotlin/properties/ReadOnlyProperty;", "config", "", "getConfig", "()Ljava/lang/String;", "config$delegate", "rules", "", "getRules", "()Ljava/util/List;", "rules$delegate", "defaultOutput", "Lcn/sast/common/IResDirectory;", "getDefaultOutput", "()Lcn/sast/common/IResDirectory;", "defaultOutput$delegate", "Lkotlin/Lazy;", "output", "getOutput", "output$delegate", "dumpSootScene", "", "getDumpSootScene", "()Z", "dumpSootScene$delegate", "resultType", "", "Lcn/sast/cli/command/FySastCli$ResultType;", "getResultType", "()Ljava/util/Set;", "resultType$delegate", "preferredLanguages", "Lcom/feysh/corax/config/api/Language;", "getPreferredLanguages", "preferredLanguages$delegate", "enableDecompile", "enableCodeMetrics", "getEnableCodeMetrics", "enableCodeMetrics$delegate", "dumpSrcFileList", "getDumpSrcFileList", "dumpSrcFileList$delegate", "target", "Lcn/sast/cli/command/TargetOptions;", "getTarget", "()Lcn/sast/cli/command/TargetOptions;", "target$delegate", "process", "getProcess", "process$delegate", "classPath", "getClassPath", "classPath$delegate", "autoAppClasses", "getAutoAppClasses", "autoAppClasses$delegate", "autoAppTraverseMode", "Lcn/sast/common/FileSystemLocator$TraverseMode;", "getAutoAppTraverseMode", "()Lcn/sast/common/FileSystemLocator$TraverseMode;", "autoAppTraverseMode$delegate", "autoAppSrcOnlyFileScheme", "getAutoAppSrcOnlyFileScheme", "autoAppSrcOnlyFileScheme$delegate", "disableDefaultJavaClassPath", "getDisableDefaultJavaClassPath", "disableDefaultJavaClassPath$delegate", "sourcePath", "getSourcePath", "sourcePath$delegate", "projectRoot", "getProjectRoot$annotations", "getProjectRoot", "projectRoot$delegate", "srcPrecedence", "Lcn/sast/api/config/SrcPrecedence;", "getSrcPrecedence", "()Lcn/sast/api/config/SrcPrecedence;", "srcPrecedence$delegate", "incrementalScanOf", "getIncrementalScanOf", "incrementalScanOf$delegate", "disableMappingDiffInArchive", "getDisableMappingDiffInArchive", "disableMappingDiffInArchive$delegate", "sunBootClassPath", "getSunBootClassPath", "sunBootClassPath$delegate", "javaExtDirs", "getJavaExtDirs", "javaExtDirs$delegate", "ecjOptions", "getEcjOptions", "ecjOptions$delegate", "serializeCG", "getSerializeCG", "serializeCG$delegate", "c2sMode", "Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;", "getC2sMode", "()Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;", "c2sMode$delegate", "hideNoSource", "getHideNoSource", "hideNoSource$delegate", "traverseMode", "getTraverseMode", "traverseMode$delegate", "projectScanConfig", "Ljava/io/File;", "getProjectScanConfig", "()Ljava/io/File;", "projectScanConfig$delegate", "disableWrapper", "getDisableWrapper", "disableWrapper$delegate", "apponly", "getApponly", "apponly$delegate", "disablePreAnalysis", "getDisablePreAnalysis", "disablePreAnalysis$delegate", "disableBuiltInAnalysis", "getDisableBuiltInAnalysis", "disableBuiltInAnalysis$delegate", "dataFlowOptions", "Lcn/sast/cli/command/DataFlowOptions;", "getDataFlowOptions", "()Lcn/sast/cli/command/DataFlowOptions;", "dataFlowOptions$delegate", "checkerInfoGeneratorOptions", "Lcn/sast/cli/command/tools/CheckerInfoGeneratorOptions;", "getCheckerInfoGeneratorOptions", "()Lcn/sast/cli/command/tools/CheckerInfoGeneratorOptions;", "checkerInfoGeneratorOptions$delegate", "checkerInfoCompareOptions", "Lcn/sast/cli/command/tools/CheckerInfoCompareOptions;", "getCheckerInfoCompareOptions", "()Lcn/sast/cli/command/tools/CheckerInfoCompareOptions;", "checkerInfoCompareOptions$delegate", "subtoolsOptions", "Lcn/sast/cli/command/tools/SubToolsOptions;", "getSubtoolsOptions", "()Lcn/sast/cli/command/tools/SubToolsOptions;", "subtoolsOptions$delegate", "flowDroidOptions", "Lcn/sast/cli/command/FlowDroidOptions;", "getFlowDroidOptions", "()Lcn/sast/cli/command/FlowDroidOptions;", "flowDroidOptions$delegate", "utAnalyzeOptions", "Lcn/sast/cli/command/UtAnalyzeOptions;", "getUtAnalyzeOptions", "()Lcn/sast/cli/command/UtAnalyzeOptions;", "utAnalyzeOptions$delegate", "enableStructureAnalysis", "getEnableStructureAnalysis", "enableStructureAnalysis$delegate", "enableOriginalNames", "getEnableOriginalNames", "enableOriginalNames$delegate", "staticFieldTrackingMode", "Lcn/sast/api/config/StaticFieldTrackingMode;", "getStaticFieldTrackingMode", "()Lcn/sast/api/config/StaticFieldTrackingMode;", "staticFieldTrackingMode$delegate", "callGraphAlgorithm", "getCallGraphAlgorithm", "callGraphAlgorithm$delegate", "callGraphAlgorithmBuiltIn", "getCallGraphAlgorithmBuiltIn", "callGraphAlgorithmBuiltIn$delegate", "disableReflection", "getDisableReflection", "disableReflection$delegate", "maxThreadNum", "", "getMaxThreadNum", "()I", "maxThreadNum$delegate", "memoryThreshold", "", "getMemoryThreshold", "()D", "memoryThreshold$delegate", "disableTop", "getDisableTop", "disableTop$delegate", "strict", "getStrict", "strict$delegate", "zipFSEnv", "", "getZipFSEnv", "()Ljava/util/Map;", "zipFSEnv$delegate", "zipFSEncodings", "getZipFSEncodings", "zipFSEncodings$delegate", "hashVersion", "getHashVersion", "()Ljava/lang/Integer;", "hashVersion$delegate", "sourceEncoding", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "getSourceEncoding", "()Ljava/nio/charset/Charset;", "sourceEncoding$delegate", "makeScorecard", "getMakeScorecard", "makeScorecard$delegate", "timeout", "getTimeout", "timeout$delegate", "postCheck", "", "printOptions", "compatibleOldCheckerNames", "Lcn/sast/framework/plugin/CheckerFilterByName;", "enableCheckers", "parseConfig", "Lkotlin/Pair;", "Lcn/sast/framework/plugin/ConfigPluginLoader;", "Lcn/sast/api/config/SaConfig;", "checkerFilter", "defaultConfig", "setTimeOut", "run", "setVerbosity", "collectors", "Lcn/sast/api/report/IResultCollector;", "getCollectors", "setCollectors", "(Ljava/util/List;)V", "getResultCollector", "Lcn/sast/framework/result/ResultCollector;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "locator", "Lcn/sast/framework/report/ProjectFileLocator;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "monitor", "Lcn/sast/framework/metrics/MetricsMonitor;", "loadSAConfig", "configureMainConfig", "showMetrics", "anchorPointFile", "Lcn/sast/common/IResFile;", "createAnchorPointFile", "checkOutputDir", "checkEnv", "getFilteredJavaSourceFiles", "(Lcn/sast/api/config/MainConfig;Lcn/sast/framework/report/ProjectFileLocator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSourceFileListForProbe", "out", "srcFiles", "addFilesToDataBase", "files", "runCodeMetrics", "(Lcn/sast/api/config/MainConfig;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "top", "lastResult", "sqliteFileIndexes", "", "runAnalyze", "(Lcn/sast/cli/command/TargetOptions;Lcn/sast/framework/metrics/MetricsMonitor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "constructPmdAnalyzerCmd", "fileList", "csvResultPath", "main2", "argv", "", "([Ljava/lang/String;)V", "ResultType", "Companion", "corax-cli"})
@SourceDebugExtension(value={"SMAP\nFySastCli.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FySastCli.kt\ncn/sast/cli/command/FySastCli\n+ 2 EagerOption.kt\ncom/github/ajalt/clikt/parameters/options/EagerOptionKt\n+ 3 enum.kt\ncom/github/ajalt/clikt/parameters/types/EnumKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 enum.kt\ncom/github/ajalt/clikt/parameters/types/EnumKt$enum$3\n+ 6 Convert.kt\ncom/github/ajalt/clikt/parameters/options/OptionWithValuesKt__ConvertKt\n+ 7 Validate.kt\ncom/github/ajalt/clikt/parameters/options/ValidateKt\n+ 8 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 9 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 10 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 11 Timer.kt\ncn/sast/api/util/TimerKt\n+ 12 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,1247:1\n65#2,10:1248\n45#3,5:1258\n45#3,5:1293\n45#3,5:1304\n45#3,5:1333\n45#3,5:1355\n45#3,5:1377\n45#3,5:1388\n45#3,5:1399\n8541#4,2:1263\n8801#4,2:1265\n8804#4:1268\n8541#4,2:1298\n8801#4,2:1300\n8804#4:1303\n8541#4,2:1309\n8801#4,2:1311\n8804#4:1314\n8541#4,2:1338\n8801#4,2:1340\n8804#4:1343\n8541#4,2:1360\n8801#4,2:1362\n8804#4:1365\n8541#4,2:1382\n8801#4,2:1384\n8804#4:1387\n8541#4,2:1393\n8801#4,2:1395\n8804#4:1398\n8541#4,2:1404\n8801#4,2:1406\n8804#4:1409\n47#5:1267\n47#5:1302\n47#5:1313\n47#5:1342\n47#5:1364\n47#5:1386\n47#5:1397\n47#5:1408\n35#6,6:1269\n70#6:1275\n82#6,4:1276\n35#6,6:1280\n70#6:1286\n82#6,4:1287\n35#6,6:1344\n70#6:1350\n82#6,4:1351\n35#6,6:1366\n70#6:1372\n82#6,4:1373\n65#6,6:1422\n82#6,4:1428\n69#7:1291\n25#7:1292\n65#7,5:1315\n25#7:1320\n65#7,5:1321\n25#7:1326\n65#7,5:1327\n25#7:1332\n65#7,5:1410\n25#7:1415\n65#7,5:1416\n25#7:1421\n1#8:1432\n1485#9:1433\n1510#9,3:1434\n1513#9,3:1444\n1557#9:1447\n1628#9,3:1448\n1368#9:1451\n1454#9,2:1452\n774#9:1454\n865#9,2:1455\n1456#9,3:1457\n1797#9,3:1460\n1454#9,5:1463\n1368#9:1476\n1454#9,5:1477\n1454#9,5:1482\n1368#9:1487\n1454#9,5:1488\n1863#9,2:1493\n1755#9,3:1495\n1454#9,5:1498\n1863#9,2:1503\n1469#9,5:1505\n1557#9:1510\n1628#9,3:1511\n1557#9:1518\n1628#9,3:1519\n381#10,7:1437\n16#11,8:1468\n37#12,2:1514\n37#12,2:1516\n*S KotlinDebug\n*F\n+ 1 FySastCli.kt\ncn/sast/cli/command/FySastCli\n*L\n92#1:1248,10\n101#1:1258,5\n149#1:1293,5\n152#1:1304,5\n215#1:1333,5\n251#1:1355,5\n290#1:1377,5\n301#1:1388,5\n355#1:1399,5\n101#1:1263,2\n101#1:1265,2\n101#1:1268\n149#1:1298,2\n149#1:1300,2\n149#1:1303\n152#1:1309,2\n152#1:1311,2\n152#1:1314\n215#1:1338,2\n215#1:1340,2\n215#1:1343\n251#1:1360,2\n251#1:1362,2\n251#1:1365\n290#1:1382,2\n290#1:1384,2\n290#1:1387\n301#1:1393,2\n301#1:1395,2\n301#1:1398\n355#1:1404,2\n355#1:1406,2\n355#1:1409\n101#1:1267\n149#1:1302\n152#1:1313\n215#1:1342\n251#1:1364\n290#1:1386\n301#1:1397\n355#1:1408\n117#1:1269,6\n117#1:1275\n117#1:1276,4\n132#1:1280,6\n132#1:1286\n132#1:1287,4\n237#1:1344,6\n237#1:1350\n237#1:1351,4\n277#1:1366,6\n277#1:1372\n277#1:1373,4\n385#1:1422,6\n385#1:1428,4\n132#1:1291\n132#1:1292\n195#1:1315,5\n195#1:1320\n204#1:1321,5\n204#1:1326\n211#1:1327,5\n211#1:1332\n369#1:1410,5\n369#1:1415\n381#1:1416,5\n381#1:1421\n437#1:1433\n437#1:1434,3\n437#1:1444,3\n517#1:1447\n517#1:1448,3\n524#1:1451\n524#1:1452,2\n524#1:1454\n524#1:1455,2\n524#1:1457,3\n660#1:1460,3\n685#1:1463,5\n714#1:1476\n714#1:1477,5\n720#1:1482,5\n726#1:1487\n726#1:1488,5\n728#1:1493,2\n734#1:1495,3\n735#1:1498,5\n836#1:1503,2\n855#1:1505,5\n993#1:1510\n993#1:1511,3\n531#1:1518\n531#1:1519,3\n437#1:1437,7\n699#1:1468,8\n1212#1:1514,2\n1234#1:1516,2\n*E\n"})
public final class FySastCli
extends CliktCommand {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty verbosity$delegate;
    @NotNull
    private final ReadOnlyProperty config$delegate;
    @NotNull
    private final ReadOnlyProperty rules$delegate;
    @NotNull
    private final Lazy defaultOutput$delegate;
    @NotNull
    private final ReadOnlyProperty output$delegate;
    @NotNull
    private final ReadOnlyProperty dumpSootScene$delegate;
    @NotNull
    private final ReadOnlyProperty resultType$delegate;
    @NotNull
    private final ReadOnlyProperty preferredLanguages$delegate;
    private final boolean enableDecompile;
    @NotNull
    private final ReadOnlyProperty enableCodeMetrics$delegate;
    @NotNull
    private final ReadOnlyProperty dumpSrcFileList$delegate;
    @NotNull
    private final ReadOnlyProperty target$delegate;
    @NotNull
    private final ReadOnlyProperty process$delegate;
    @NotNull
    private final ReadOnlyProperty classPath$delegate;
    @NotNull
    private final ReadOnlyProperty autoAppClasses$delegate;
    @NotNull
    private final ReadOnlyProperty autoAppTraverseMode$delegate;
    @NotNull
    private final ReadOnlyProperty autoAppSrcOnlyFileScheme$delegate;
    @NotNull
    private final ReadOnlyProperty disableDefaultJavaClassPath$delegate;
    @NotNull
    private final ReadOnlyProperty sourcePath$delegate;
    @NotNull
    private final ReadOnlyProperty projectRoot$delegate;
    @NotNull
    private final ReadOnlyProperty srcPrecedence$delegate;
    @NotNull
    private final ReadOnlyProperty incrementalScanOf$delegate;
    @NotNull
    private final ReadOnlyProperty disableMappingDiffInArchive$delegate;
    @NotNull
    private final ReadOnlyProperty sunBootClassPath$delegate;
    @NotNull
    private final ReadOnlyProperty javaExtDirs$delegate;
    @NotNull
    private final ReadOnlyProperty ecjOptions$delegate;
    @NotNull
    private final ReadOnlyProperty serializeCG$delegate;
    @NotNull
    private final ReadOnlyProperty c2sMode$delegate;
    @NotNull
    private final ReadOnlyProperty hideNoSource$delegate;
    @NotNull
    private final ReadOnlyProperty traverseMode$delegate;
    @NotNull
    private final ReadOnlyProperty projectScanConfig$delegate;
    @NotNull
    private final ReadOnlyProperty disableWrapper$delegate;
    @NotNull
    private final ReadOnlyProperty apponly$delegate;
    @NotNull
    private final ReadOnlyProperty disablePreAnalysis$delegate;
    @NotNull
    private final ReadOnlyProperty disableBuiltInAnalysis$delegate;
    @NotNull
    private final ReadOnlyProperty dataFlowOptions$delegate;
    @NotNull
    private final ReadOnlyProperty checkerInfoGeneratorOptions$delegate;
    @NotNull
    private final ReadOnlyProperty checkerInfoCompareOptions$delegate;
    @NotNull
    private final ReadOnlyProperty subtoolsOptions$delegate;
    @NotNull
    private final ReadOnlyProperty flowDroidOptions$delegate;
    @NotNull
    private final ReadOnlyProperty utAnalyzeOptions$delegate;
    @NotNull
    private final ReadOnlyProperty enableStructureAnalysis$delegate;
    @NotNull
    private final ReadOnlyProperty enableOriginalNames$delegate;
    @NotNull
    private final ReadOnlyProperty staticFieldTrackingMode$delegate;
    @NotNull
    private final ReadOnlyProperty callGraphAlgorithm$delegate;
    @NotNull
    private final ReadOnlyProperty callGraphAlgorithmBuiltIn$delegate;
    @NotNull
    private final ReadOnlyProperty disableReflection$delegate;
    @NotNull
    private final ReadOnlyProperty maxThreadNum$delegate;
    @NotNull
    private final ReadOnlyProperty memoryThreshold$delegate;
    @NotNull
    private final ReadOnlyProperty disableTop$delegate;
    @NotNull
    private final ReadOnlyProperty strict$delegate;
    @NotNull
    private final ReadOnlyProperty zipFSEnv$delegate;
    @NotNull
    private final ReadOnlyProperty zipFSEncodings$delegate;
    @NotNull
    private final ReadOnlyProperty hashVersion$delegate;
    @NotNull
    private final ReadOnlyProperty sourceEncoding$delegate;
    @NotNull
    private final ReadOnlyProperty makeScorecard$delegate;
    @NotNull
    private final ReadOnlyProperty timeout$delegate;
    @NotNull
    private List<? extends IResultCollector> collectors;
    @Nullable
    private IResFile anchorPointFile;
    private ResultCollector lastResult;
    @NotNull
    private final Set<IResFile> sqliteFileIndexes;
    @NotNull
    private static final KLogger logger;

    /*
     * WARNING - void declaration
     */
    public FySastCli() {
        super(null, null, "CoraxJava", false, false, null, null, false, false, false, 1019, null);
        CompletionCandidates completionCandidates;
        void var10_51;
        CompletionCandidates completionCandidates2;
        CompletionCandidates completionCandidates3;
        CompletionCandidates completionCandidates4;
        CompletionCandidates completionCandidates5;
        OptionWithValues $this$convert$iv$iv$iv;
        OptionWithValues $this$convert_u24default$iv;
        Enum it;
        boolean bl;
        Enum it$iv;
        boolean bl2;
        Map map;
        Language[] $this$associateByTo$iv$iv$iv;
        void $this$associateBy$iv$iv;
        Object $this$enum_u24default$iv;
        OptionWithValues $this$versionOption_u24default$iv;
        SAXReaderBugTest.INSTANCE.test();
        CliktCommand cliktCommand = (CliktCommand)this;
        String version$iv = ApplicationKt.getVersion();
        String help$iv = "Show the version and exit";
        Set names$iv = SetsKt.setOf((Object)"--version");
        void var6_27 = $this$versionOption_u24default$iv;
        boolean $i$f$versionOption = false;
        EagerOptionKt.eagerOption$default((CliktCommand)$this$versionOption_u24default$iv, (Collection)names$iv, (String)help$iv, (boolean)false, null, null, (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */), (int)28, null);
        CliktCommandKt.context((CliktCommand)((CliktCommand)this), FySastCli::_init_$lambda$1);
        $this$versionOption_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Sets verbosity level of command line interface", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        FySastCli fySastCli = this;
        boolean ignoreCase$iv = true;
        boolean $i$f$enum = false;
        Level[] levelArray = Level.values();
        var6_27 = $this$enum_u24default$iv;
        boolean $i$f$associateBy = false;
        int capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)((void)$this$associateBy$iv$iv).length), (int)16);
        void var9_50 = $this$associateBy$iv$iv;
        Map destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        boolean $i$f$associateByTo = false;
        for (Language element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Enum enum_ = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            void var18_59 = it$iv;
            bl = false;
            it = var18_59;
            map.put(it.name(), element$iv$iv$iv);
        }
        OptionWithValues optionWithValues = ChoiceKt.choice$default((OptionWithValues)var6_27, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null);
        fySastCli.verbosity$delegate = OptionWithValuesKt.default$default((OptionWithValues)optionWithValues, (Object)Level.INFO, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
        this.config$delegate = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Specify the configuration jar and portal name which will be used as the analysis configuration. eg: \"default-config.yml@{path to analysis-config}\"\nThe environment variable: CORAX_CONFIG_DEFAULT_DIR", (String)"(custom-config.yml@)?{configPath}[{pathSeparator}{configPath}]*", (boolean)false, null, null, null, null, (boolean)false, (int)504, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
        $this$enum_u24default$iv = new String[]{"--rules", "--enable-checkers"};
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, (String)"A way to directly control the checker switch through this parameter (whitelist).", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        String metavar$iv = "(JSON_FILE|CHECKER_TYPE,...)";
        Object completionCandidates$iv = null;
        OptionWithValues $this$convert$iv$iv = $this$convert_u24default$iv;
        boolean $i$f$convert = false;
        var6_27 = $this$convert$iv$iv;
        Function1 metavar$iv$iv$iv = (Function1)new /* Unavailable Anonymous Inner Class!! */;
        boolean $i$f$convert2 = false;
        Function2 valueTransform$iv$iv$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
        Function2 function2 = OptionWithValuesKt.defaultEachProcessor();
        Function2 function22 = OptionWithValuesKt.defaultAllProcessor();
        Function2 function23 = OptionWithValuesKt.defaultValidator();
        Function1 function1 = $this$convert$iv$iv$iv.getMetavarGetter();
        if (function1 == null) {
            function1 = metavar$iv$iv$iv;
        }
        if ((completionCandidates5 = $this$convert$iv$iv$iv.getExplicitCompletionCandidates()) == null) {
            completionCandidates5 = completionCandidates$iv;
        }
        this.rules$delegate = OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$convert$iv$iv$iv, (Function2)valueTransform$iv$iv$iv, (Function2)function2, (Function2)function22, (Function2)function23, null, (Function1)function1, null, null, (boolean)false, null, null, null, null, (CompletionCandidates)completionCandidates5, null, (boolean)false, (boolean)false, (boolean)false, (int)253904, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[2]);
        this.defaultOutput$delegate = LazyKt.lazy(FySastCli::defaultOutput_delegate$lambda$7);
        $this$convert_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Sets output directory of analysis result and metadata", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        metavar$iv = "directory";
        completionCandidates$iv = null;
        $this$convert$iv$iv = $this$convert_u24default$iv;
        $i$f$convert = false;
        $this$convert$iv$iv$iv = $this$convert$iv$iv;
        metavar$iv$iv$iv = (Function1)new /* Unavailable Anonymous Inner Class!! */;
        $i$f$convert2 = false;
        valueTransform$iv$iv$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
        Function2 function24 = OptionWithValuesKt.defaultEachProcessor();
        Function2 function25 = OptionWithValuesKt.defaultAllProcessor();
        Function2 function26 = OptionWithValuesKt.defaultValidator();
        Function1 function12 = $this$convert$iv$iv$iv.getMetavarGetter();
        if (function12 == null) {
            function12 = metavar$iv$iv$iv;
        }
        if ((completionCandidates4 = $this$convert$iv$iv$iv.getExplicitCompletionCandidates()) == null) {
            completionCandidates4 = completionCandidates$iv;
        }
        OptionWithValues $this$check$iv = OptionWithValuesKt.default$default((OptionWithValues)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$convert$iv$iv$iv, (Function2)valueTransform$iv$iv$iv, (Function2)function24, (Function2)function25, (Function2)function26, null, (Function1)function12, null, null, (boolean)false, null, null, null, null, (CompletionCandidates)completionCandidates4, null, (boolean)false, (boolean)false, (boolean)false, (int)253904, null), (Object)this.getDefaultOutput(), null, (int)2, null);
        boolean $i$f$check = false;
        OptionWithValues $this$validate$iv$iv = $this$check$iv;
        boolean $i$f$validate = false;
        this.output$delegate = ((OptionDelegate)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$validate$iv$iv, (Function2)$this$validate$iv$iv.getTransformValue(), (Function2)$this$validate$iv$iv.getTransformEach(), (Function2)$this$validate$iv$iv.getTransformAll(), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), null, null, null, null, (boolean)false, null, null, null, null, null, null, (boolean)false, (boolean)false, (boolean)false, (int)262128, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[3]);
        this.dumpSootScene$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"dump soot scene", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[4]);
        $this$check$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Sets output format of analysis result. \nThis can be set multiple times, then different format of output will be given simultaneously.\nEg: --result-type sqlite --result-type sarif", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        fySastCli = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        ResultType[] $i$f$convert22 = ResultType.values();
        $this$convert$iv$iv$iv = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv2.length), (int)16);
        valueTransform$iv$iv$iv = $this$associateBy$iv$iv2;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (Language element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        optionWithValues = ChoiceKt.choice$default((OptionWithValues)$this$convert$iv$iv$iv, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null);
        fySastCli.resultType$delegate = OptionWithValuesKt.unique((OptionWithValues)OptionWithValuesKt.multiple$default((OptionWithValues)optionWithValues, null, (boolean)false, (int)3, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[5]);
        $this$enum_u24default$iv = new String[]{"--preferred-lang", "--preferred-language"};
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, (String)"Preferred reporting language", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        fySastCli = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        Language[] $this$associateBy$iv$iv2 = Language.values();
        $this$convert$iv$iv$iv = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv2.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv2;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (Language element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        optionWithValues = ChoiceKt.choice$default((OptionWithValues)$this$convert$iv$iv$iv, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null);
        $this$enum_u24default$iv = new Language[]{Language.ZH, Language.EN};
        fySastCli.preferredLanguages$delegate = OptionWithValuesKt.multiple$default((OptionWithValues)optionWithValues, (List)CollectionsKt.listOf((Object[])$this$enum_u24default$iv), (boolean)false, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[6]);
        $this$enum_u24default$iv = new String[]{"--enable-code-metrics"};
        OptionWithValues optionWithValues2 = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, (String)"enable code metrics for the project", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        $this$enum_u24default$iv = new String[]{"--disable-code-metrics"};
        this.enableCodeMetrics$delegate = FlagOptionKt.flag((OptionWithValues)optionWithValues2, (String[])$this$enum_u24default$iv, (boolean)false, (String)"enable").provideDelegate((ParameterHolder)this, $$delegatedProperties[7]);
        $this$enum_u24default$iv = new String[]{"--dump-src-files"};
        this.dumpSrcFileList$delegate = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, (String)"Write source file list with \\n separator", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[8]);
        $this$enum_u24default$iv = new Pair[]{TuplesKt.to((Object)"java", (Object)new JavaOptions()), TuplesKt.to((Object)"android", (Object)new AndroidOptions()), TuplesKt.to((Object)"src-only", (Object)new SrcAnalyzeOptions())};
        this.target$delegate = ChoiceGroupKt.groupChoice((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Specify the analyze target. [src-only: analyze resources without class files]\nWarning: Only corresponding target options are valid and others are ignored.", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (Pair[])$this$enum_u24default$iv).provideDelegate((CliktCommand)this, $$delegatedProperties[9]);
        String[] $this$check_u24default$iv = OptionWithValuesKt.multiple$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Specify the classes that shall be processed(analyzed).", (String)"class dir, [dir of] jar|war|apk|dex, glob pattern, inside zip", (boolean)false, null, null, null, null, (boolean)false, (int)504, null), null, (boolean)false, (int)1, null);
        boolean $i$f$check2 = false;
        String[] $this$validate$iv$iv2 = $this$check_u24default$iv;
        boolean $i$f$validate2 = false;
        this.process$delegate = ((OptionDelegate)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$validate$iv$iv2, (Function2)$this$validate$iv$iv2.getTransformValue(), (Function2)$this$validate$iv$iv2.getTransformEach(), (Function2)$this$validate$iv$iv2.getTransformAll(), (Function2)((Function2)new special$$inlined$check$default$1()), null, null, null, null, (boolean)false, null, null, null, null, null, null, (boolean)false, (boolean)false, (boolean)false, (int)262128, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[10]);
        $this$check_u24default$iv = OptionWithValuesKt.multiple$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Specify the [JAR/CLASS/SOURCE] paths.\nHint: There are library classes and system classes in a project.\nSpecify the \"--process\" with application classes to exclude them.", (String)"class dir, [dir of] jar|dex, glob pattern, inside zip", (boolean)false, null, null, null, null, (boolean)false, (int)504, null), null, (boolean)false, (int)1, null);
        $i$f$check2 = false;
        $this$validate$iv$iv2 = $this$check_u24default$iv;
        $i$f$validate2 = false;
        this.classPath$delegate = ((OptionDelegate)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$validate$iv$iv2, (Function2)$this$validate$iv$iv2.getTransformValue(), (Function2)$this$validate$iv$iv2.getTransformEach(), (Function2)$this$validate$iv$iv2.getTransformAll(), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), null, null, null, null, (boolean)false, null, null, null, null, null, null, (boolean)false, (boolean)false, (boolean)false, (int)262128, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[11]);
        $this$check_u24default$iv = OptionWithValuesKt.multiple$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"The automatically classified classes from the specified paths", (String)"target project root dir (Contains both binary and corresponding complete project source code)", (boolean)false, null, null, null, null, (boolean)false, (int)504, null), null, (boolean)false, (int)1, null);
        $i$f$check2 = false;
        $this$validate$iv$iv2 = $this$check_u24default$iv;
        $i$f$validate2 = false;
        this.autoAppClasses$delegate = ((OptionDelegate)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$validate$iv$iv2, (Function2)$this$validate$iv$iv2.getTransformValue(), (Function2)$this$validate$iv$iv2.getTransformEach(), (Function2)$this$validate$iv$iv2.getTransformAll(), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), null, null, null, null, (boolean)false, null, null, null, null, null, null, (boolean)false, (boolean)false, (boolean)false, (int)262128, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[12]);
        $this$check_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Set the locator mode for automatically loading project resources. ", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        fySastCli = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        FileSystemLocator.TraverseMode[] $i$f$validate22 = FileSystemLocator.TraverseMode.values();
        $this$convert$iv$iv$iv = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)((void)$this$associateBy$iv$iv).length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (Language element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        optionWithValues = ChoiceKt.choice$default((OptionWithValues)$this$convert$iv$iv$iv, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null);
        fySastCli.autoAppTraverseMode$delegate = OptionWithValuesKt.default$default((OptionWithValues)optionWithValues, (Object)FileSystemLocator.TraverseMode.RecursivelyIndexArchive, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[13]);
        $this$enum_u24default$iv = new String[]{"--auto-app-src-only-file-scheme"};
        OptionWithValues optionWithValues3 = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, (String)"If true, the Java source file which including the ZIP is judged to not be the application class.", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        $this$enum_u24default$iv = new String[]{"--disable-auto-app-src-only-file-scheme"};
        this.autoAppSrcOnlyFileScheme$delegate = FlagOptionKt.flag((OptionWithValues)optionWithValues3, (String[])$this$enum_u24default$iv, (boolean)true, (String)"enable").provideDelegate((ParameterHolder)this, $$delegatedProperties[14]);
        this.disableDefaultJavaClassPath$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Disable the default jdk/jre path for class path.\nThen a custom java class path should be given by \"--class-path\".", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[15]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Specify the source file path with source directory root or source.jar file", (String)"source file dir or any parent dir", (boolean)false, null, null, null, null, (boolean)false, (int)504, null);
        metavar$iv = "PATH";
        completionCandidates$iv = null;
        $this$convert$iv$iv = $this$convert_u24default$iv;
        $i$f$convert3 = false;
        $this$convert$iv$iv$iv = $this$convert$iv$iv;
        metavar$iv$iv$iv = (Function1)new /* Unavailable Anonymous Inner Class!! */;
        $i$f$convert2 = false;
        valueTransform$iv$iv$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
        Function2 function27 = OptionWithValuesKt.defaultEachProcessor();
        Function2 function28 = OptionWithValuesKt.defaultAllProcessor();
        Function2 function29 = OptionWithValuesKt.defaultValidator();
        Function1 function13 = $this$convert$iv$iv$iv.getMetavarGetter();
        if (function13 == null) {
            function13 = metavar$iv$iv$iv;
        }
        if ((completionCandidates3 = $this$convert$iv$iv$iv.getExplicitCompletionCandidates()) == null) {
            completionCandidates3 = completionCandidates$iv;
        }
        this.sourcePath$delegate = OptionWithValuesKt.unique((OptionWithValues)OptionWithValuesKt.multiple$default((OptionWithValues)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$convert$iv$iv$iv, (Function2)valueTransform$iv$iv$iv, (Function2)function27, (Function2)function28, (Function2)function29, null, (Function1)function13, null, null, (boolean)false, null, null, null, null, (CompletionCandidates)completionCandidates3, null, (boolean)false, (boolean)false, (boolean)false, (int)253904, null), null, (boolean)false, (int)3, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[16]);
        this.projectRoot$delegate = OptionWithValuesKt.multiple$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Specify the project root directory", (String)"dir", (boolean)false, null, null, null, null, (boolean)false, (int)504, null), null, (boolean)false, (int)3, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[17]);
        $this$convert_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Sets the source precedence type of analysis targets", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        fySastCli = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        SrcPrecedence[] $i$f$convert3 = SrcPrecedence.values();
        $this$convert$iv$iv$iv = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)((void)$this$associateBy$iv$iv).length), (int)16);
        valueTransform$iv$iv$iv = $this$associateBy$iv$iv;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (Language element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        optionWithValues = ChoiceKt.choice$default((OptionWithValues)$this$convert$iv$iv$iv, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null);
        fySastCli.srcPrecedence$delegate = OptionWithValuesKt.default$default((OptionWithValues)optionWithValues, (Object)SrcPrecedence.prec_apk_class_jimple, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[18]);
        $this$enum_u24default$iv = new String[]{"-i", "--incremental", "--incremental-base"};
        this.incrementalScanOf$delegate = OptionWithValuesKt.multiple$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, (String)"Specify the git .diff/.patch file or a list of change file for incremental analysis", (String)".diff/.patch/.txt", (boolean)false, null, null, null, null, (boolean)false, (int)504, null), null, (boolean)false, (int)3, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[19]);
        this.disableMappingDiffInArchive$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"In incremental analysis, is the process of mapping diff paths to the corresponding files within compressed archives?.", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[20]);
        OptionWithValues optionWithValues4 = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)true, null, null, null, null, (boolean)false, (int)502, null);
        $this$enum_u24default$iv = System.getProperty("sun.boot.class.path");
        String[] stringArray = $this$enum_u24default$iv;
        if (stringArray == null) {
            stringArray = "";
        }
        this.sunBootClassPath$delegate = OptionWithValuesKt.default$default((OptionWithValues)optionWithValues4, (Object)stringArray, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[21]);
        OptionWithValues optionWithValues5 = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)true, null, null, null, null, (boolean)false, (int)502, null);
        $this$enum_u24default$iv = System.getProperty("java.ext.dirs");
        Object object = $this$enum_u24default$iv;
        if (object == null) {
            object = "";
        }
        this.javaExtDirs$delegate = OptionWithValuesKt.default$default((OptionWithValues)optionWithValues5, (Object)object, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[22]);
        $this$enum_u24default$iv = FileKt.file$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Sets custom ecj options file", (String)"file path", (boolean)false, null, null, null, null, (boolean)false, (int)504, null), (boolean)true, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (int)58, null);
        metavar$iv = "JSON_FILE";
        completionCandidates$iv = null;
        $this$convert$iv$iv = $this$convert_u24default$iv;
        $i$f$convert4 = false;
        $this$convert$iv$iv$iv = $this$convert$iv$iv;
        metavar$iv$iv$iv = (Function1)new /* Unavailable Anonymous Inner Class!! */;
        $i$f$convert2 = false;
        valueTransform$iv$iv$iv = (Function2)new special$$inlined$convert$default$8($this$convert$iv$iv$iv);
        Function2 function210 = OptionWithValuesKt.defaultEachProcessor();
        Function2 function211 = OptionWithValuesKt.defaultAllProcessor();
        Function2 function212 = OptionWithValuesKt.defaultValidator();
        Function1 function14 = $this$convert$iv$iv$iv.getMetavarGetter();
        if (function14 == null) {
            function14 = metavar$iv$iv$iv;
        }
        if ((completionCandidates2 = $this$convert$iv$iv$iv.getExplicitCompletionCandidates()) == null) {
            completionCandidates2 = completionCandidates$iv;
        }
        this.ecjOptions$delegate = OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$convert$iv$iv$iv, (Function2)valueTransform$iv$iv$iv, (Function2)function210, (Function2)function211, (Function2)function212, null, (Function1)function14, null, null, (boolean)false, null, null, null, null, (CompletionCandidates)completionCandidates2, null, (boolean)false, (boolean)false, (boolean)false, (int)253904, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[23]);
        this.serializeCG$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Serialize the on-the-fly call graph. (dot/json)", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[24]);
        $this$convert_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Sets the mode for how to search source code based on class name", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        fySastCli = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        AbstractFileIndexer.CompareMode[] $i$f$convert4 = AbstractFileIndexer.CompareMode.values();
        $this$convert$iv$iv$iv = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv3.length), (int)16);
        valueTransform$iv$iv$iv = $this$associateBy$iv$iv3;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (Language element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        optionWithValues = ChoiceKt.choice$default((OptionWithValues)$this$convert$iv$iv$iv, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null);
        fySastCli.c2sMode$delegate = OptionWithValuesKt.default$default((OptionWithValues)optionWithValues, (Object)AbstractFileIndexer.CompareMode.Class, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[25]);
        this.hideNoSource$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Set if problems found shall be hidden in the final report when source code is not available", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[26]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Set whether to find the source code file from the compressed package", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        fySastCli = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        FileSystemLocator.TraverseMode[] $this$associateBy$iv$iv3 = FileSystemLocator.TraverseMode.values();
        $this$convert$iv$iv$iv = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv3.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv3;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (Language element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        optionWithValues = ChoiceKt.choice$default((OptionWithValues)$this$convert$iv$iv$iv, (Map)destination$iv$iv$iv, null, (boolean)ignoreCase$iv, (int)2, null);
        fySastCli.traverseMode$delegate = OptionWithValuesKt.default$default((OptionWithValues)optionWithValues, (Object)FileSystemLocator.TraverseMode.RecursivelyIndexArchive, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[27]);
        $this$enum_u24default$iv = new String[]{"--project-config", "--project-scan-config"};
        this.projectScanConfig$delegate = FileKt.file$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, (String)"Specify the path of project scan config file", (String)"file path", (boolean)false, null, null, null, null, (boolean)false, (int)504, null), (boolean)true, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (int)58, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[28]);
        this.disableWrapper$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Analyze the full frameworks together with the app without any optimizations", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, (String)"Use summary modeling (taint wrapper, ...)", (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[29]);
        $this$enum_u24default$iv = new String[]{"--app-only", "--apponly"};
        this.apponly$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, (String)"Sets whether classes that are declared library classes in Soot shall be excluded from the analysis,\n i.e., no flows shall be tracked through them", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[30]);
        this.disablePreAnalysis$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Skip the pre analysis phase. This will disable some checkers.", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[31]);
        this.disableBuiltInAnalysis$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Skip the flow built-in analysis phase. This will disable some checkers. ", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[32]);
        this.dataFlowOptions$delegate = CoOccurringOptionGroupKt.cooccurring((OptionGroup)((OptionGroup)new DataFlowOptions())).provideDelegate((CliktCommand)this, $$delegatedProperties[33]);
        this.checkerInfoGeneratorOptions$delegate = CoOccurringOptionGroupKt.cooccurring((OptionGroup)((OptionGroup)new CheckerInfoGeneratorOptions())).provideDelegate((CliktCommand)this, $$delegatedProperties[34]);
        this.checkerInfoCompareOptions$delegate = CoOccurringOptionGroupKt.cooccurring((OptionGroup)((OptionGroup)new CheckerInfoCompareOptions())).provideDelegate((CliktCommand)this, $$delegatedProperties[35]);
        this.subtoolsOptions$delegate = CoOccurringOptionGroupKt.cooccurring((OptionGroup)((OptionGroup)new SubToolsOptions())).provideDelegate((CliktCommand)this, $$delegatedProperties[36]);
        this.flowDroidOptions$delegate = CoOccurringOptionGroupKt.cooccurring((OptionGroup)((OptionGroup)new FlowDroidOptions(false, 1, null))).provideDelegate((CliktCommand)this, $$delegatedProperties[37]);
        this.utAnalyzeOptions$delegate = CoOccurringOptionGroupKt.cooccurring((OptionGroup)((OptionGroup)new UtAnalyzeOptions())).provideDelegate((CliktCommand)this, $$delegatedProperties[38]);
        this.enableStructureAnalysis$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[39]);
        $this$enum_u24default$iv = new String[]{"--enable-original-names"};
        OptionWithValues optionWithValues6 = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, (String)"enable original names for stack local variables. ", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null);
        $this$enum_u24default$iv = new String[]{"--disable-original-names"};
        this.enableOriginalNames$delegate = FlagOptionKt.flag((OptionWithValues)optionWithValues6, (String[])$this$enum_u24default$iv, (boolean)true, (String)"enable").provideDelegate((ParameterHolder)this, $$delegatedProperties[40]);
        $this$enum_u24default$iv = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)502, null);
        fySastCli = this;
        ignoreCase$iv = true;
        $i$f$enum = false;
        $this$associateBy$iv$iv3 = StaticFieldTrackingMode.values();
        $this$convert$iv$iv$iv = $this$enum_u24default$iv;
        $i$f$associateBy = false;
        capacity$iv$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)$this$associateBy$iv$iv3.length), (int)16);
        $this$associateByTo$iv$iv$iv = $this$associateBy$iv$iv3;
        destination$iv$iv$iv = new LinkedHashMap(capacity$iv$iv);
        $i$f$associateByTo = false;
        for (Language element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            it$iv = (Enum)element$iv$iv$iv;
            map = destination$iv$iv$iv;
            bl2 = false;
            it = it$iv;
            bl = false;
            map.put(it.name(), element$iv$iv$iv);
        }
        optionWithValues = ChoiceKt.choice$default((OptionWithValues)$this$convert$iv$iv$iv, (Map)var10_51, null, (boolean)ignoreCase$iv, (int)2, null);
        fySastCli.staticFieldTrackingMode$delegate = OptionWithValuesKt.default$default((OptionWithValues)optionWithValues, (Object)StaticFieldTrackingMode.ContextFlowInsensitive, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[41]);
        this.callGraphAlgorithm$delegate = OptionWithValuesKt.default$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)502, null), (Object)"insens", null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[42]);
        this.callGraphAlgorithmBuiltIn$delegate = OptionWithValuesKt.default$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)502, null), (Object)"cha", null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[43]);
        this.disableReflection$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"True if reflective method calls shall be not supported, otherwise false", null, (boolean)false, null, null, null, null, (boolean)false, (int)500, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[44]);
        $this$enum_u24default$iv = new String[]{"--max-thread-num", "--thread-num", "--thread", "-j"};
        $this$check_u24default$iv = OptionWithValuesKt.default$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$enum_u24default$iv, null, null, (boolean)false, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null), (Object)Math.max(Runtime.getRuntime().availableProcessors() - 1, 1), null, (int)2, null);
        $i$f$check = false;
        $this$validate$iv$iv = $this$check_u24default$iv;
        $i$f$validate = false;
        this.maxThreadNum$delegate = ((OptionDelegate)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$validate$iv$iv, (Function2)$this$validate$iv$iv.getTransformValue(), (Function2)$this$validate$iv$iv.getTransformEach(), (Function2)$this$validate$iv$iv.getTransformAll(), (Function2)((Function2)new special$$inlined$check$default$4()), null, null, null, null, (boolean)false, null, null, null, null, null, null, (boolean)false, (boolean)false, (boolean)false, (int)262128, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[45]);
        this.memoryThreshold$delegate = OptionWithValuesKt.default$default((OptionWithValues)DoubleKt.double((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Memory threshold percentage. Negative numbers turn it off.", null, (boolean)false, null, null, null, null, (boolean)false, (int)500, null)), (Object)0.9, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[46]);
        String[] ignoreCase$iv2 = new String[]{"--disable-top"};
        $this$check_u24default$iv = ignoreCase$iv2;
        this.disableTop$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$check_u24default$iv, (String)"interactive process viewer", null, (boolean)false, null, null, null, null, (boolean)false, (int)500, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[47]);
        $this$check_u24default$iv = new String[]{"--strict"};
        this.strict$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$check_u24default$iv, (String)"Disable all the limits (eg: timeout and memory threshold)", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[48]);
        $this$check_u24default$iv = new String[]{"--zipfs-env"};
        this.zipFSEnv$delegate = OptionWithValuesKt.associate$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$check_u24default$iv, null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null), null, (int)1, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[49]);
        $this$check_u24default$iv = new String[]{"--zipfs-encodings"};
        this.zipFSEncodings$delegate = OptionWithValuesKt.multiple$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])$this$check_u24default$iv, null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null), (List)Resource.INSTANCE.getFileSystemEncodings(), (boolean)false, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[50]);
        $this$check_u24default$iv = IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)true, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null);
        $i$f$check = false;
        $this$validate$iv$iv = $this$check_u24default$iv;
        $i$f$validate = false;
        this.hashVersion$delegate = ((OptionDelegate)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$validate$iv$iv, (Function2)$this$validate$iv$iv.getTransformValue(), (Function2)$this$validate$iv$iv.getTransformEach(), (Function2)$this$validate$iv$iv.getTransformAll(), (Function2)((Function2)new special$$inlined$check$default$5()), null, null, null, null, (boolean)false, null, null, null, null, null, null, (boolean)false, (boolean)false, (boolean)false, (int)262128, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[51]);
        $this$convert_u24default$iv = OptionWithValuesKt.help((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null), (String)"The encoding of source files");
        Function1 metavar$iv2 = (Function1)special$$inlined$convert$default$9.INSTANCE;
        completionCandidates$iv = null;
        $this$validate$iv$iv = $this$convert_u24default$iv;
        Function1 metavar$iv$iv = metavar$iv2;
        boolean $i$f$convert5 = false;
        Function2 valueTransform$iv$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
        Function2 function213 = OptionWithValuesKt.defaultEachProcessor();
        Function2 function214 = OptionWithValuesKt.defaultAllProcessor();
        Function2 function215 = OptionWithValuesKt.defaultValidator();
        Function1 function15 = $this$convert$iv$iv.getMetavarGetter();
        if (function15 == null) {
            function15 = metavar$iv$iv;
        }
        if ((completionCandidates = $this$convert$iv$iv.getExplicitCompletionCandidates()) == null) {
            completionCandidates = completionCandidates$iv;
        }
        this.sourceEncoding$delegate = OptionWithValuesKt.default$default((OptionWithValues)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$convert$iv$iv, (Function2)valueTransform$iv$iv, (Function2)function213, (Function2)function214, (Function2)function215, null, (Function1)function15, null, null, (boolean)false, null, null, null, null, (CompletionCandidates)completionCandidates, null, (boolean)false, (boolean)false, (boolean)false, (int)253904, null), (Object)Charsets.UTF_8, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[52]);
        this.makeScorecard$delegate = FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"auto make scores for reports. ", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (String[])new String[0], (boolean)false, null, (int)6, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[53]);
        this.timeout$delegate = OptionWithValuesKt.default$default((OptionWithValues)IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Set the analysis to stop after a certain number of seconds", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (boolean)false, (int)1, null), (Object)0, null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[54]);
        this.collectors = CollectionsKt.emptyList();
        this.sqliteFileIndexes = new LinkedHashSet();
    }

    private final Level getVerbosity() {
        return (Level)this.verbosity$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    private final String getConfig() {
        return (String)this.config$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    private final List<String> getRules() {
        return (List)this.rules$delegate.getValue((Object)this, $$delegatedProperties[2]);
    }

    private final IResDirectory getDefaultOutput() {
        Lazy lazy = this.defaultOutput$delegate;
        return (IResDirectory)lazy.getValue();
    }

    private final IResDirectory getOutput() {
        return (IResDirectory)this.output$delegate.getValue((Object)this, $$delegatedProperties[3]);
    }

    private final boolean getDumpSootScene() {
        return (Boolean)this.dumpSootScene$delegate.getValue((Object)this, $$delegatedProperties[4]);
    }

    private final Set<ResultType> getResultType() {
        return (Set)this.resultType$delegate.getValue((Object)this, $$delegatedProperties[5]);
    }

    private final List<Language> getPreferredLanguages() {
        return (List)this.preferredLanguages$delegate.getValue((Object)this, $$delegatedProperties[6]);
    }

    private final boolean getEnableCodeMetrics() {
        return (Boolean)this.enableCodeMetrics$delegate.getValue((Object)this, $$delegatedProperties[7]);
    }

    private final String getDumpSrcFileList() {
        return (String)this.dumpSrcFileList$delegate.getValue((Object)this, $$delegatedProperties[8]);
    }

    private final TargetOptions getTarget() {
        return (TargetOptions)this.target$delegate.getValue((Object)this, $$delegatedProperties[9]);
    }

    private final List<String> getProcess() {
        return (List)this.process$delegate.getValue((Object)this, $$delegatedProperties[10]);
    }

    private final List<String> getClassPath() {
        return (List)this.classPath$delegate.getValue((Object)this, $$delegatedProperties[11]);
    }

    private final List<String> getAutoAppClasses() {
        return (List)this.autoAppClasses$delegate.getValue((Object)this, $$delegatedProperties[12]);
    }

    private final FileSystemLocator.TraverseMode getAutoAppTraverseMode() {
        return (FileSystemLocator.TraverseMode)this.autoAppTraverseMode$delegate.getValue((Object)this, $$delegatedProperties[13]);
    }

    private final boolean getAutoAppSrcOnlyFileScheme() {
        return (Boolean)this.autoAppSrcOnlyFileScheme$delegate.getValue((Object)this, $$delegatedProperties[14]);
    }

    private final boolean getDisableDefaultJavaClassPath() {
        return (Boolean)this.disableDefaultJavaClassPath$delegate.getValue((Object)this, $$delegatedProperties[15]);
    }

    private final Set<IResDirectory> getSourcePath() {
        return (Set)this.sourcePath$delegate.getValue((Object)this, $$delegatedProperties[16]);
    }

    private final List<String> getProjectRoot() {
        return (List)this.projectRoot$delegate.getValue((Object)this, $$delegatedProperties[17]);
    }

    private static /* synthetic */ void getProjectRoot$annotations() {
    }

    private final SrcPrecedence getSrcPrecedence() {
        return (SrcPrecedence)this.srcPrecedence$delegate.getValue((Object)this, $$delegatedProperties[18]);
    }

    private final List<String> getIncrementalScanOf() {
        return (List)this.incrementalScanOf$delegate.getValue((Object)this, $$delegatedProperties[19]);
    }

    private final boolean getDisableMappingDiffInArchive() {
        return (Boolean)this.disableMappingDiffInArchive$delegate.getValue((Object)this, $$delegatedProperties[20]);
    }

    private final String getSunBootClassPath() {
        return (String)this.sunBootClassPath$delegate.getValue((Object)this, $$delegatedProperties[21]);
    }

    private final String getJavaExtDirs() {
        return (String)this.javaExtDirs$delegate.getValue((Object)this, $$delegatedProperties[22]);
    }

    private final List<String> getEcjOptions() {
        return (List)this.ecjOptions$delegate.getValue((Object)this, $$delegatedProperties[23]);
    }

    private final boolean getSerializeCG() {
        return (Boolean)this.serializeCG$delegate.getValue((Object)this, $$delegatedProperties[24]);
    }

    private final AbstractFileIndexer.CompareMode getC2sMode() {
        return (AbstractFileIndexer.CompareMode)this.c2sMode$delegate.getValue((Object)this, $$delegatedProperties[25]);
    }

    private final boolean getHideNoSource() {
        return (Boolean)this.hideNoSource$delegate.getValue((Object)this, $$delegatedProperties[26]);
    }

    private final FileSystemLocator.TraverseMode getTraverseMode() {
        return (FileSystemLocator.TraverseMode)this.traverseMode$delegate.getValue((Object)this, $$delegatedProperties[27]);
    }

    private final File getProjectScanConfig() {
        return (File)this.projectScanConfig$delegate.getValue((Object)this, $$delegatedProperties[28]);
    }

    private final boolean getDisableWrapper() {
        return (Boolean)this.disableWrapper$delegate.getValue((Object)this, $$delegatedProperties[29]);
    }

    private final boolean getApponly() {
        return (Boolean)this.apponly$delegate.getValue((Object)this, $$delegatedProperties[30]);
    }

    private final boolean getDisablePreAnalysis() {
        return (Boolean)this.disablePreAnalysis$delegate.getValue((Object)this, $$delegatedProperties[31]);
    }

    private final boolean getDisableBuiltInAnalysis() {
        return (Boolean)this.disableBuiltInAnalysis$delegate.getValue((Object)this, $$delegatedProperties[32]);
    }

    private final DataFlowOptions getDataFlowOptions() {
        return (DataFlowOptions)this.dataFlowOptions$delegate.getValue((Object)this, $$delegatedProperties[33]);
    }

    private final CheckerInfoGeneratorOptions getCheckerInfoGeneratorOptions() {
        return (CheckerInfoGeneratorOptions)this.checkerInfoGeneratorOptions$delegate.getValue((Object)this, $$delegatedProperties[34]);
    }

    private final CheckerInfoCompareOptions getCheckerInfoCompareOptions() {
        return (CheckerInfoCompareOptions)this.checkerInfoCompareOptions$delegate.getValue((Object)this, $$delegatedProperties[35]);
    }

    private final SubToolsOptions getSubtoolsOptions() {
        return (SubToolsOptions)this.subtoolsOptions$delegate.getValue((Object)this, $$delegatedProperties[36]);
    }

    private final FlowDroidOptions getFlowDroidOptions() {
        return (FlowDroidOptions)this.flowDroidOptions$delegate.getValue((Object)this, $$delegatedProperties[37]);
    }

    private final UtAnalyzeOptions getUtAnalyzeOptions() {
        return (UtAnalyzeOptions)this.utAnalyzeOptions$delegate.getValue((Object)this, $$delegatedProperties[38]);
    }

    private final boolean getEnableStructureAnalysis() {
        return (Boolean)this.enableStructureAnalysis$delegate.getValue((Object)this, $$delegatedProperties[39]);
    }

    private final boolean getEnableOriginalNames() {
        return (Boolean)this.enableOriginalNames$delegate.getValue((Object)this, $$delegatedProperties[40]);
    }

    private final StaticFieldTrackingMode getStaticFieldTrackingMode() {
        return (StaticFieldTrackingMode)this.staticFieldTrackingMode$delegate.getValue((Object)this, $$delegatedProperties[41]);
    }

    private final String getCallGraphAlgorithm() {
        return (String)this.callGraphAlgorithm$delegate.getValue((Object)this, $$delegatedProperties[42]);
    }

    private final String getCallGraphAlgorithmBuiltIn() {
        return (String)this.callGraphAlgorithmBuiltIn$delegate.getValue((Object)this, $$delegatedProperties[43]);
    }

    private final boolean getDisableReflection() {
        return (Boolean)this.disableReflection$delegate.getValue((Object)this, $$delegatedProperties[44]);
    }

    private final int getMaxThreadNum() {
        return ((Number)this.maxThreadNum$delegate.getValue((Object)this, $$delegatedProperties[45])).intValue();
    }

    private final double getMemoryThreshold() {
        return ((Number)this.memoryThreshold$delegate.getValue((Object)this, $$delegatedProperties[46])).doubleValue();
    }

    private final boolean getDisableTop() {
        return (Boolean)this.disableTop$delegate.getValue((Object)this, $$delegatedProperties[47]);
    }

    private final boolean getStrict() {
        return (Boolean)this.strict$delegate.getValue((Object)this, $$delegatedProperties[48]);
    }

    private final Map<String, String> getZipFSEnv() {
        return (Map)this.zipFSEnv$delegate.getValue((Object)this, $$delegatedProperties[49]);
    }

    private final List<String> getZipFSEncodings() {
        return (List)this.zipFSEncodings$delegate.getValue((Object)this, $$delegatedProperties[50]);
    }

    private final Integer getHashVersion() {
        return (Integer)this.hashVersion$delegate.getValue((Object)this, $$delegatedProperties[51]);
    }

    public final Charset getSourceEncoding() {
        return (Charset)this.sourceEncoding$delegate.getValue((Object)this, $$delegatedProperties[52]);
    }

    private final boolean getMakeScorecard() {
        return (Boolean)this.makeScorecard$delegate.getValue((Object)this, $$delegatedProperties[53]);
    }

    private final int getTimeout() {
        return ((Number)this.timeout$delegate.getValue((Object)this, $$delegatedProperties[54])).intValue();
    }

    private final void postCheck() {
        Integer n = this.getHashVersion();
        if (n != null) {
            int it = ((Number)n).intValue();
            boolean bl = false;
            ExtSettings.INSTANCE.setHashVersion(it);
            Report.Companion.setHashVersion(it);
        }
        if (this.getCheckerInfoGeneratorOptions() != null || this.getSubtoolsOptions() != null) {
            Set rules2;
            ConfigPluginLoader pl = (ConfigPluginLoader)this.loadSAConfig(null).component1();
            Collection collection = this.getRules();
            if (collection != null && (collection = CollectionsKt.toSet((Iterable)collection)) != null) {
                Collection it = collection;
                boolean bl = false;
                v2 = this.compatibleOldCheckerNames((Set)it).getEnables();
            } else {
                v2 = rules2 = null;
            }
            if (this.getCheckerInfoGeneratorOptions() != null) {
                CheckerInfoGeneratorOptions checkerInfoGeneratorOptions = this.getCheckerInfoGeneratorOptions();
                Intrinsics.checkNotNull((Object)checkerInfoGeneratorOptions);
                checkerInfoGeneratorOptions.run(pl, rules2);
            }
            if (this.getSubtoolsOptions() != null) {
                SubToolsOptions subToolsOptions = this.getSubtoolsOptions();
                Intrinsics.checkNotNull((Object)subToolsOptions);
                subToolsOptions.run(pl, rules2);
            }
        }
        if (this.getCheckerInfoCompareOptions() != null) {
            CheckerInfoCompareOptions checkerInfoCompareOptions = this.getCheckerInfoCompareOptions();
            Intrinsics.checkNotNull((Object)checkerInfoCompareOptions);
            checkerInfoCompareOptions.run();
        }
        if (this.getTarget() == null) {
            throw new BadParameterValue("\"--target\" option is required");
        }
        if (this.getFlowDroidOptions() == null && this.getDataFlowOptions() == null && this.getUtAnalyzeOptions() == null && this.getDisableBuiltInAnalysis()) {
            throw new BadParameterValue("No analyze engine is enabled");
        }
        if (this.getDisableDefaultJavaClassPath() && this.getClassPath().isEmpty()) {
            throw new BadParameterValue("\"--class-path\" is required when \"--disable-default-java-class-path\" is given");
        }
        if (this.getSrcPrecedence().isSootJavaSourcePrec()) {
            String string;
            String msg = "System property \"%s\" or option \"%s\" should be provided when \"--src-precedence=prec_java_soot\"";
            if (((CharSequence)this.getSunBootClassPath()).length() == 0) {
                string = msg;
                Object[] objectArray = new Object[]{"sun.boot.class.path", "--sun-boot-class-path"};
                String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
                throw new BadParameterValue(string2);
            }
            if (((CharSequence)this.getJavaExtDirs()).length() == 0) {
                string = msg;
                Object[] objectArray = new Object[]{"java.ext.dirs", "--java-ext-dirs"};
                String string3 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"format(...)");
                throw new BadParameterValue(string3);
            }
        }
    }

    private final void printOptions() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object it;
        List $this$groupByTo$iv$iv;
        Theme theme = ContextKt.getTheme((Context)this.getCurrentContext());
        Iterable $this$groupBy$iv = this.registeredOptions();
        boolean $i$f$groupBy = false;
        Iterable iterable = $this$groupBy$iv;
        Map entry = new LinkedHashMap();
        boolean $i$f$groupByTo = false;
        Iterator iterator2 = $this$groupByTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object object6;
            Object element$iv$iv = iterator2.next();
            Option it2 = (Option)element$iv$iv;
            boolean bl = false;
            GroupableOption groupableOption = it2 instanceof GroupableOption ? (GroupableOption)it2 : null;
            ParameterGroup key$iv$iv = groupableOption != null ? groupableOption.getParameterGroup() : null;
            Map $this$getOrPut$iv$iv$iv = entry;
            boolean $i$f$getOrPut = false;
            Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                boolean bl2 = false;
                List answer$iv$iv$iv = new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object6 = answer$iv$iv$iv;
            } else {
                object6 = value$iv$iv$iv;
            }
            List list$iv$iv = (List)object6;
            list$iv$iv.add(element$iv$iv);
        }
        Map groupToOptions = entry;
        StringBuilder text2 = new StringBuilder();
        $this$groupByTo$iv$iv = new ArrayList();
        List list = $this$groupByTo$iv$iv;
        boolean bl = false;
        Object object7 = this.getDataFlowOptions();
        if (object7 != null && (object7 = object7.getGroupName()) != null) {
            it = object7;
            boolean bl3 = false;
            list.add(it);
        }
        if ((object5 = this.getFlowDroidOptions()) != null && (object5 = object5.getGroupName()) != null) {
            it = object5;
            boolean bl4 = false;
            list.add(it);
        }
        if ((object4 = this.getUtAnalyzeOptions()) != null && (object4 = object4.getGroupName()) != null) {
            it = object4;
            boolean bl5 = false;
            list.add(it);
        }
        if ((object3 = this.getCheckerInfoGeneratorOptions()) != null && (object3 = object3.getGroupName()) != null) {
            it = object3;
            boolean bl6 = false;
            list.add(it);
        }
        if ((object2 = this.getCheckerInfoCompareOptions()) != null && (object2 = object2.getGroupName()) != null) {
            it = object2;
            boolean bl7 = false;
            list.add(it);
        }
        if ((object = this.getSubtoolsOptions()) != null && (object = object.getGroupName()) != null) {
            it = object;
            boolean bl8 = false;
            list.add(it);
        }
        List existsGroups = $this$groupByTo$iv$iv;
        for (Map.Entry entry2 : groupToOptions.entrySet()) {
            Object object8;
            List opt;
            ParameterGroup group;
            block18: {
                block17: {
                    group = (ParameterGroup)entry2.getKey();
                    opt = (List)entry2.getValue();
                    object8 = group;
                    if (object8 == null) break block17;
                    ParameterGroup it3 = object8;
                    boolean bl9 = false;
                    Object object9 = it3.getGroupName();
                    if (object9 == null) {
                        object9 = it3.getClass().getSimpleName() + "@" + System.identityHashCode(it3);
                    }
                    object8 = object9;
                    if (object9 != null) break block18;
                }
                object8 = this.getCommandName();
            }
            Object prefix = object8;
            ParameterGroup parameterGroup = group;
            if ((parameterGroup != null ? parameterGroup.getGroupName() : null) != null && !CollectionsKt.contains((Iterable)existsGroups, (Object)group.getGroupName())) {
                v11 = text2.append(theme.getSuccess().invoke((String)prefix) + " [off]");
            } else {
                String string = theme.getSuccess().invoke((String)prefix) + "\n\t";
                String optText = CollectionsKt.joinToString$default((Iterable)opt, (CharSequence)"\n\t", (CharSequence)string, null, (int)0, null, arg_0 -> FySastCli.printOptions$lambda$33(theme, arg_0), (int)28, null);
                v11 = text2.append(optText);
            }
            text2.append("\n");
        }
        String string = text2.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String info2 = string;
        logger.info(FySastCli::printOptions$lambda$34);
        logger.info(FySastCli::printOptions$lambda$35);
        logger.info(FySastCli::printOptions$lambda$36);
        logger.info(() -> FySastCli.printOptions$lambda$37(info2));
        this.getOutput().mkdirs();
        ResourceKt.writeText$default((IResFile)this.getOutput().resolve("command.txt").toFile(), (String)info2, null, (int)2, null);
        logger.info(() -> FySastCli.printOptions$lambda$38(theme));
    }

    private final CheckerFilterByName compatibleOldCheckerNames(Set<String> enableCheckers) {
        CheckerFilterByName all = new CheckerFilterByName(enableCheckers, MapsKt.emptyMap());
        try {
            URL uRL = OS.INSTANCE.getBinaryUrl();
            if (uRL == null) {
                return all;
            }
            URL coraxExe = uRL;
            IResource iResource = Resource.INSTANCE.of(coraxExe).getParent();
            if (iResource == null || (iResource = iResource.resolve("checker_name_mapping.json")) == null) {
                return all;
            }
            IResource nameMapping = iResource;
            if (!nameMapping.getExists() || !nameMapping.isFile()) {
                return all;
            }
            Object object = new Gson().fromJson(PathsKt.readText((Path)nameMapping.getPath(), (Charset)Charsets.UTF_8), new /* Unavailable Anonymous Inner Class!! */.getType());
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromJson(...)");
            Map renameMap2 = (Map)object;
            ArrayDeque<String> worklist = new ArrayDeque<String>(enableCheckers.size());
            worklist.addAll((Collection)enableCheckers);
            Set visited = new LinkedHashSet();
            while (!((Collection)worklist).isEmpty()) {
                String it;
                String cur;
                if ((String)worklist.removeLast() == null || !visited.add(cur)) continue;
                if ((String)renameMap2.get(cur) == null) continue;
                boolean bl = false;
                worklist.add(it);
            }
            return new CheckerFilterByName(visited, renameMap2);
        }
        catch (Exception e) {
            logger.error((Throwable)e, () -> FySastCli.compatibleOldCheckerNames$lambda$40(e));
            return all;
        }
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<ConfigPluginLoader, SaConfig> parseConfig(String config, CheckerFilterByName checkerFilter) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Pair pair;
        if (StringsKt.contains$default((CharSequence)config, (CharSequence)"@", (boolean)false, (int)2, null)) {
            String configEntry = StringsKt.substringBefore$default((String)config, (String)"@", null, (int)2, null);
            String configPluginsDir = StringsKt.substringAfter$default((String)config, (String)"@", null, (int)2, null);
            pair = TuplesKt.to((Object)configPluginsDir, (Object)configEntry);
        } else {
            pair = TuplesKt.to((Object)config, (Object)"default-config.yml");
        }
        Pair pair2 = pair;
        String configDirPaths = (String)pair2.component1();
        String name = (String)pair2.component2();
        Pair pair3 = StringsKt.contains$default((CharSequence)configDirPaths, (CharSequence)"#", (boolean)false, (int)2, null) ? TuplesKt.to((Object)StringsKt.substringBefore$default((String)configDirPaths, (String)"#", null, (int)2, null), (Object)StringsKt.substringAfter$default((String)configDirPaths, (String)"#", null, (int)2, null)) : TuplesKt.to((Object)configDirPaths, null);
        String configPathFixed = (String)pair3.component1();
        String pluginId = (String)pair3.component2();
        if (((CharSequence)configPathFixed).length() == 0) {
            throw new IllegalStateException("pluginsPath is empty!".toString());
        }
        List list = ResourceImplKt.globPaths((String)configPathFixed);
        if (list == null) {
            throw new IllegalStateException((configPathFixed + " not exists").toString());
        }
        List configDirs = list;
        Iterable iterable = configDirs;
        List list2 = configDirs;
        boolean $i$f$map = false;
        void var13_14 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo2 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            IResource iResource = (IResource)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.resolve("plugins").toDirectory());
        }
        List list3 = (List)destination$iv$iv;
        List list4 = list2;
        ConfigPluginLoader pl = new ConfigPluginLoader(list4, list3);
        if (StringsKt.endsWith$default((String)name, (String)".yml", (boolean)false, (int)2, null)) {
            IResFile iResFile;
            List list5;
            IResFile mayBeFile;
            IResFile it = $i$f$map = Resource.INSTANCE.fileOf(name);
            boolean bl = false;
            Object object = mayBeFile = it.getExists() && it.isFile() ? $i$f$map : null;
            if (mayBeFile != null) {
                list5 = CollectionsKt.listOf((Object)mayBeFile.getPath());
            } else {
                void $this$flatMapTo$iv$iv;
                Iterable $this$flatMap$iv = configDirs;
                boolean $i$f$flatMap = false;
                Iterable $i$f$mapTo2 = $this$flatMap$iv;
                Collection destination$iv$iv2 = new ArrayList();
                boolean $i$f$flatMapTo = false;
                for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                    void $this$filterTo$iv$iv;
                    IResource p = (IResource)element$iv$iv;
                    boolean bl2 = false;
                    Iterable $this$filter$iv = PathExtensionsKt.getFiles((Path)p.getPath());
                    boolean $i$f$filter = false;
                    Iterable iterable2 = $this$filter$iv;
                    Collection destination$iv$iv3 = new ArrayList();
                    boolean $i$f$filterTo = false;
                    for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
                        Path it2 = (Path)element$iv$iv2;
                        boolean bl3 = false;
                        if (!Intrinsics.areEqual((Object)PathsKt.getName((Path)it2), (Object)name)) continue;
                        destination$iv$iv3.add(element$iv$iv2);
                    }
                    Iterable list$iv$iv = (List)destination$iv$iv3;
                    CollectionsKt.addAll((Collection)destination$iv$iv2, (Iterable)list$iv$iv);
                }
                list5 = (List)destination$iv$iv2;
            }
            List ymlOptionFiles = list5;
            if (ymlOptionFiles.isEmpty()) {
                IResource tempFileDir = (IResource)CollectionsKt.first((List)configDirs);
                IResFile tempFile = tempFileDir.resolve(name).getAbsolute().getNormalize().toFile();
                pl.makeTemplateYml(tempFile);
                logger.warn(() -> FySastCli.parseConfig$lambda$46(name, configDirs, tempFile, tempFileDir));
                iResFile = tempFile;
            } else {
                if (ymlOptionFiles.size() != 1) {
                    throw new IllegalStateException(("multiple files: " + name + ": " + ymlOptionFiles + " were found in: " + CollectionsKt.joinToString$default((Iterable)configDirs, (CharSequence)"\n", null, null, (int)0, null, null, (int)62, null)).toString());
                }
                iResFile = Resource.INSTANCE.fileOf((Path)CollectionsKt.first((List)ymlOptionFiles));
            }
            IResFile ymlConfig = iResFile;
            logger.info(() -> FySastCli.parseConfig$lambda$47(ymlConfig));
            return TuplesKt.to((Object)pl, (Object)pl.searchCheckerUnits(ymlConfig, checkerFilter));
        }
        return TuplesKt.to((Object)pl, (Object)pl.loadFromName(pluginId, name));
    }

    private final Pair<ConfigPluginLoader, SaConfig> defaultConfig(CheckerFilterByName checkerFilter) {
        logger.info(FySastCli::defaultConfig$lambda$48);
        String configFromEnv = FySastCliKt.getDefaultConfigDir();
        if (configFromEnv == null) {
            logger.info(FySastCli::defaultConfig$lambda$49);
            return null;
        }
        return this.parseConfig("default-config.yml@" + configFromEnv, checkerFilter);
    }

    private final void setTimeOut() {
        if (this.getTimeout() >= 1) {
            CustomRepeatingTimer customRepeatingTimer;
            CustomRepeatingTimer $this$setTimeOut_u24lambda_u2452 = customRepeatingTimer = new CustomRepeatingTimer((long)this.getTimeout() * 1000L, () -> FySastCli.setTimeOut$lambda$51(this));
            boolean bl = false;
            $this$setTimeOut_u24lambda_u2452.setRepeats(false);
            $this$setTimeOut_u24lambda_u2452.start();
        }
    }

    public void run() {
        this.setTimeOut();
        AbstractFileIndexer.Companion.setDefaultClassCompareMode(this.getC2sMode());
        this.checkOutputDir();
        MainConfig.Companion.setPreferredLanguages(this.getPreferredLanguages());
        OS.INSTANCE.setMaxThreadNum(this.getMaxThreadNum());
        Object object = new MetricsMonitor();
        MetricsMonitor it = object;
        boolean bl = false;
        it.start();
        MetricsMonitor monitor = object;
        CheckType2StringKind.Companion.getCheckType2StringKind();
        this.postCheck();
        this.createAnchorPointFile();
        this.printOptions();
        Resource.INSTANCE.setZipExtractOutputDir(this.getOutput().getPath());
        if (!this.getZipFSEnv().isEmpty()) {
            Resource.INSTANCE.setNewFileSystemEnv(this.getZipFSEnv());
        }
        if (!((object = (Collection)this.getZipFSEncodings()) == null || object.isEmpty())) {
            List list = this.getZipFSEncodings();
            Intrinsics.checkNotNull((Object)list);
            Resource.INSTANCE.setFileSystemEncodings(list);
        }
        LocalDateTime startTime = LocalDateTime.now();
        try {
            CoroutineContext coroutineCtx = new CoroutineName("sast-main" + this.getMaxThreadNum()).plus((CoroutineContext)CoroutineDispatcher.limitedParallelism$default((CoroutineDispatcher)Dispatchers.getDefault(), (int)this.getMaxThreadNum(), null, (int)2, null));
            BuildersKt.runBlocking((CoroutineContext)coroutineCtx, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
            monitor.runAnalyzeFinishHook();
            logger.info(() -> FySastCli.run$lambda$54(this));
            logger.info(() -> FySastCli.run$lambda$55(startTime));
        }
        catch (Throwable t) {
            logger.info(() -> FySastCli.run$lambda$56(this));
            logger.info(() -> FySastCli.run$lambda$57(startTime));
            throw t;
        }
    }

    public final void setVerbosity(@NotNull Level verbosity) {
        Field actualLogger;
        Field field;
        Field field2;
        org.apache.logging.log4j.Logger apacheLog4j;
        Intrinsics.checkNotNullParameter((Object)verbosity, (String)"verbosity");
        System.out.println((Object)("Log Level changed to [" + verbosity + "]"));
        org.apache.logging.log4j.Logger $this$setVerbosity_u24lambda_u2458 = apacheLog4j = LogManager.getRootLogger();
        boolean bl = false;
        Configurator.setAllLevels((String)$this$setVerbosity_u24lambda_u2458.getName(), (org.apache.logging.log4j.Level)UtilsKt.level((Level)verbosity));
        System.out.println((Object)("apache log4j2 root logger: isTraceEnabled: " + $this$setVerbosity_u24lambda_u2458.isTraceEnabled() + ", isDebugEnabled: " + $this$setVerbosity_u24lambda_u2458.isDebugEnabled() + ", isInfoEnabled: " + $this$setVerbosity_u24lambda_u2458.isInfoEnabled() + ", isWarnEnabled: " + $this$setVerbosity_u24lambda_u2458.isWarnEnabled() + ", isErrorEnabled: " + $this$setVerbosity_u24lambda_u2458.isErrorEnabled()));
        Logger logger = LoggerFactory.getLogger((String)"ROOT");
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        Logger slf4jLogger = logger;
        try {
            field2 = Log4jLogger.class.getDeclaredField("logger");
            field2.setAccessible(true);
            Object object = field2.get(slf4jLogger);
            field2 = object instanceof org.apache.logging.log4j.Logger ? (org.apache.logging.log4j.Logger)object : null;
        }
        catch (NoSuchFieldException ignore) {
            field2 = null;
        }
        if ((field = field2) == null) {
            field = actualLogger = slf4jLogger;
        }
        if (!Intrinsics.areEqual(apacheLog4j.getClass(), actualLogger.getClass())) {
            Logger $this$setVerbosity_u24lambda_u2459 = slf4jLogger;
            boolean bl2 = false;
            System.out.println((Object)("org.slf4j root logger:" + $this$setVerbosity_u24lambda_u2459.getClass().getSimpleName() + " isTraceEnabled: " + $this$setVerbosity_u24lambda_u2459.isTraceEnabled() + ", isDebugEnabled: " + $this$setVerbosity_u24lambda_u2459.isDebugEnabled() + ", isInfoEnabled: " + $this$setVerbosity_u24lambda_u2459.isInfoEnabled() + ", isWarnEnabled: " + $this$setVerbosity_u24lambda_u2459.isWarnEnabled() + ", isErrorEnabled: " + $this$setVerbosity_u24lambda_u2459.isErrorEnabled()));
            throw new IllegalStateException(("invalid logger: " + apacheLog4j.getClass() + " != " + actualLogger + ", \u4e0d\u4f7f\u7528 apache log4j2 \u53ef\u80fd\u4f1a\u5bfc\u81f4\u5206\u6790\u6548\u7387\u51cf\u5c11\u4e00\u500d").toString());
        }
    }

    @NotNull
    public final List<IResultCollector> getCollectors() {
        return this.collectors;
    }

    public final void setCollectors(@NotNull List<? extends IResultCollector> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.collectors = list;
    }

    /*
     * WARNING - void declaration
     */
    private final ResultCollector getResultCollector(SootInfoCache info2, ProjectFileLocator locator2, MainConfig mainConfig, MetricsMonitor monitor) {
        void $this$fold$iv;
        Collection collection;
        Collection collection2 = this.getResultType();
        if (collection2.isEmpty()) {
            boolean bl = false;
            collection = SetsKt.setOf((Object)ResultType.SARIF);
        } else {
            collection = collection2;
        }
        Set resultTypes = (Set)collection;
        if (resultTypes.contains(ResultType.COUNTER)) {
            this.collectors = CollectionsKt.plus((Collection)this.collectors, (Object)new ResultCounter());
        }
        MissingSummaryReporter methodSummariesMissing = new MissingSummaryReporter(mainConfig.getOutput_dir().resolve("undefined_summary_methods.txt").toFile());
        ResultCounter counter = new ResultCounter();
        DataFlowOptions dataFlowOptions = this.getDataFlowOptions();
        JacocoCompoundCoverage coverage = new JacocoCompoundCoverage((IProjectFileLocator)locator2, null, null, dataFlowOptions != null ? dataFlowOptions.getEnableCoverage() : false, 6, null);
        List list = CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)this.collectors, (Object)methodSummariesMissing), (Object)counter);
        IResDirectory iResDirectory = mainConfig.getOutput_dir();
        Iterable iterable = resultTypes;
        List initial$iv = CollectionsKt.emptyList();
        boolean $i$f$fold = false;
        List accumulator$iv = initial$iv;
        for (Object element$iv : $this$fold$iv) {
            void type;
            ResultType resultType = (ResultType)element$iv;
            List acc = accumulator$iv;
            boolean bl = false;
            accumulator$iv = switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1 -> CollectionsKt.plus((Collection)acc, (Object)OutputType.PLIST);
                case 2 -> CollectionsKt.plus((Collection)acc, (Object)OutputType.SARIF);
                case 3 -> acc;
                case 4 -> CollectionsKt.plus((Collection)acc, (Object)OutputType.SarifPackSrc);
                case 5 -> CollectionsKt.plus((Collection)acc, (Object)OutputType.SarifCopySrc);
                case 6 -> acc;
                default -> throw new NoWhenBranchMatchedException();
            };
        }
        List list2 = accumulator$iv;
        DataFlowOptions dataFlowOptions2 = this.getDataFlowOptions();
        boolean bl = dataFlowOptions2 != null ? dataFlowOptions2.getEnableCoverage() : false;
        return new ResultCollector(mainConfig, info2, iResDirectory, locator2, list, list2, false, null, coverage, bl, monitor, 192, null);
    }

    private final Pair<ConfigPluginLoader, SaConfig> loadSAConfig(CheckerFilterByName checkerFilter) {
        String string;
        block5: {
            block4: {
                string = this.getConfig();
                if (string == null) break block4;
                String it = string;
                boolean bl = false;
                Pair pair = this.parseConfig(it, checkerFilter);
                string = pair;
                if (pair != null) break block5;
            }
            if ((string = this.defaultConfig(checkerFilter)) == null) {
                throw new IllegalStateException("SA-Config is required.".toString());
            }
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private final void configureMainConfig(MainConfig mainConfig, MetricsMonitor monitor) {
        void destination$iv;
        boolean bl;
        Iterable $this$any$iv;
        IncrementalAnalyzeImplByChangeFiles $this$flatMapTo$iv;
        Object it;
        MainConfig mainConfig2;
        block33: {
            IncrementalAnalyzeImplByChangeFiles destination$iv2;
            Iterable pathSeparatorSplit;
            Object list$iv$iv;
            SaConfig saConfig;
            Object gen2;
            void $this$bracket$iv;
            CheckerFilterByName checkerFilterByName;
            PhaseIntervalTimer destination$iv3;
            void $this$flatMapTo$iv2;
            mainConfig.setAndroidScene(Boolean.valueOf(this.getTarget() instanceof AndroidOptions));
            mainConfig.setCallGraphAlgorithm(this.getCallGraphAlgorithm());
            mainConfig.setCallGraphAlgorithmBuiltIn(this.getCallGraphAlgorithmBuiltIn());
            mainConfig.setEnableOriginalNames(this.getEnableOriginalNames());
            Iterable iterable = this.getAutoAppClasses();
            Collection collection = (Collection)ExtensionsKt.persistentSetOf().builder();
            mainConfig2 = mainConfig;
            boolean $i$f$flatMapTo = false;
            for (Object element$iv : $this$flatMapTo$iv2) {
                String it2 = (String)element$iv;
                boolean bl2 = false;
                List list = ResourceImplKt.globPaths((String)it2);
                if (list == null) {
                    boolean bl3 = false;
                    throw new IllegalStateException(("autoAppClasses option: \"" + it2 + "\" is invalid or target not exists").toString());
                }
                Iterable list$iv = list;
                CollectionsKt.addAll((Collection)destination$iv3, (Iterable)list$iv);
            }
            mainConfig2.setAutoAppClasses(((PersistentSet.Builder)destination$iv3).build());
            mainConfig.setAutoAppTraverseMode(this.getAutoAppTraverseMode());
            mainConfig.setAutoAppSrcInZipScheme(!this.getAutoAppSrcOnlyFileScheme());
            mainConfig.setStaticFieldTrackingMode(this.getStaticFieldTrackingMode());
            mainConfig.setEnableReflection(!this.getDisableReflection());
            mainConfig.setParallelsNum(this.getMaxThreadNum());
            mainConfig.setMemoryThreshold(this.getMemoryThreshold());
            mainConfig.setOutput_dir(this.getOutput());
            mainConfig.setDumpSootScene(this.getDumpSootScene());
            Collection collection2 = this.getRules();
            if (collection2 != null && (collection2 = CollectionsKt.toSet((Iterable)collection2)) != null) {
                it = collection2;
                boolean bl4 = false;
                checkerFilterByName = this.compatibleOldCheckerNames((Set)it);
            } else {
                checkerFilterByName = null;
            }
            CheckerFilterByName checkerFilter = checkerFilterByName;
            destination$iv3 = (PhaseIntervalTimer)monitor.timer("plugins.load");
            mainConfig2 = mainConfig;
            boolean $i$f$bracket = false;
            if ($this$bracket$iv == null) {
                $i$a$-bracket-FySastCli$configureMainConfig$2 = false;
                it = this.loadSAConfig(checkerFilter);
                pl = (ConfigPluginLoader)it.component1();
                saConfig = (SaConfig)it.component2();
                CollectionsKt.addAll((Collection)mainConfig.getConfigDirs(), (Iterable)pl.getConfigDirs());
                gen2 = CheckerInfoGenerator.Companion.createCheckerInfoGenerator$default((CheckerInfoGenerator.Companion)CheckerInfoGenerator.Companion, (ConfigPluginLoader)pl, null, (boolean)false, (int)2, null);
                mainConfig.setCheckerInfo(LazyKt.lazy(() -> FySastCli.configureMainConfig$lambda$67$lambda$66((CheckerInfoGenerator)gen2)));
                saConfig = saConfig;
            } else {
                PhaseIntervalTimer.Snapshot s$iv = $this$bracket$iv.start();
                try {
                    $i$a$-bracket-FySastCli$configureMainConfig$2 = false;
                    it = this.loadSAConfig(checkerFilter);
                    pl = (ConfigPluginLoader)it.component1();
                    saConfig = (SaConfig)it.component2();
                    CollectionsKt.addAll((Collection)mainConfig.getConfigDirs(), (Iterable)pl.getConfigDirs());
                    gen2 = CheckerInfoGenerator.Companion.createCheckerInfoGenerator$default((CheckerInfoGenerator.Companion)CheckerInfoGenerator.Companion, (ConfigPluginLoader)pl, null, (boolean)false, (int)2, null);
                    mainConfig.setCheckerInfo(LazyKt.lazy(() -> FySastCli.configureMainConfig$lambda$67$lambda$66((CheckerInfoGenerator)gen2)));
                    SaConfig saConfig2 = saConfig;
                    saConfig = saConfig2;
                }
                finally {
                    $this$bracket$iv.stop(s$iv);
                }
            }
            mainConfig2.setSaConfig(saConfig);
            mainConfig.setVersion(ApplicationKt.getVersion());
            if (this.getSrcPrecedence() != SrcPrecedence.prec_java) {
                Iterator $this$flatMapTo$iv$iv;
                Iterable $this$flatMap$iv = this.getClassPath();
                boolean $i$f$flatMap = false;
                it = $this$flatMap$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$flatMapTo2 = false;
                gen2 = $this$flatMapTo$iv$iv.iterator();
                while (gen2.hasNext()) {
                    List list;
                    Object element$iv$iv = gen2.next();
                    String it3 = (String)element$iv$iv;
                    boolean bl5 = false;
                    CharSequence charSequence = it3;
                    String string = File.pathSeparator;
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"pathSeparator");
                    if (StringsKt.contains$default((CharSequence)charSequence, (CharSequence)string, (boolean)false, (int)2, null)) {
                        String[] stringArray = new String[]{File.pathSeparator};
                        list = StringsKt.split$default((CharSequence)it3, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
                    } else {
                        list = CollectionsKt.listOf((Object)it3);
                    }
                    list$iv$iv = list;
                    CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
                }
                pathSeparatorSplit = (List)destination$iv$iv;
                mainConfig.setClasspath(ExtensionsKt.toPersistentSet((Iterable)pathSeparatorSplit));
            } else {
                mainConfig.setClasspath(ExtensionsKt.toPersistentSet((Iterable)this.getClassPath()));
            }
            pathSeparatorSplit = this.getProjectRoot();
            Collection $this$flatMap$iv = (Collection)ExtensionsKt.persistentSetOf().builder();
            mainConfig2 = mainConfig;
            boolean $i$f$flatMapTo3 = false;
            for (Object element$iv : $this$flatMapTo$iv) {
                String it4 = (String)element$iv;
                boolean bl6 = false;
                List list = ResourceImplKt.globPaths((String)it4);
                if (list == null) {
                    throw new IllegalStateException(("option: --project-root \"" + it4 + "\" is invalid or path not exists").toString());
                }
                Iterable list$iv = list;
                CollectionsKt.addAll((Collection)destination$iv2, (Iterable)list$iv);
            }
            mainConfig2.setProjectRoot(((PersistentSet.Builder)destination$iv2).build());
            if (!((Collection)this.getIncrementalScanOf()).isEmpty()) {
                void $this$forEach$iv;
                Iterator $this$flatMapTo$iv$iv;
                destination$iv2 = $this$flatMapTo$iv = new IncrementalAnalyzeImplByChangeFiles(mainConfig, !this.getDisableMappingDiffInArchive(), null, null, null, 28, null);
                mainConfig2 = mainConfig;
                boolean bl7 = false;
                Iterable $this$flatMap$iv2 = this.getIncrementalScanOf();
                boolean $i$f$flatMap = false;
                Iterable list$iv = $this$flatMap$iv2;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$flatMapTo4 = false;
                list$iv$iv = $this$flatMapTo$iv$iv.iterator();
                while (list$iv$iv.hasNext()) {
                    Object element$iv$iv = list$iv$iv.next();
                    String it5 = (String)element$iv$iv;
                    boolean bl8 = false;
                    List list = ResourceImplKt.globPaths((String)it5);
                    if (list == null) {
                        throw new IllegalStateException(("option: --incremental-base \"" + it5 + "\" is invalid or target not exists").toString());
                    }
                    Iterable list$iv$iv2 = list;
                    CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv2);
                }
                $this$flatMap$iv2 = (List)destination$iv$iv;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    void ia;
                    IResource it6 = (IResource)element$iv;
                    boolean bl9 = false;
                    ia.parseIncrementBaseFile(it6);
                }
                mainConfig2.setIncrementAnalyze((IncrementalAnalyze)$this$flatMapTo$iv);
            }
            $this$any$iv = this.getProcess();
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    String it7 = (String)element$iv;
                    boolean bl10 = false;
                    boolean bl11 = ((CharSequence)it7).length() == 0;
                    if (!bl11) continue;
                    bl = true;
                    break block33;
                }
                bl = false;
            }
        }
        if (!(!bl)) {
            boolean $i$a$-check-FySastCli$configureMainConfig$72 = false;
            String $i$a$-check-FySastCli$configureMainConfig$72 = "process has empty string";
            throw new IllegalStateException($i$a$-check-FySastCli$configureMainConfig$72.toString());
        }
        $this$any$iv = this.getProcess();
        Collection $i$a$-check-FySastCli$configureMainConfig$72 = (Collection)ExtensionsKt.persistentSetOf().builder();
        mainConfig2 = mainConfig;
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            String it8 = (String)element$iv;
            boolean bl12 = false;
            List list = ResourceImplKt.globPaths((String)it8);
            if (list == null) {
                throw new IllegalStateException(("option: --process \"" + it8 + "\" is invalid or target not exists").toString());
            }
            Iterable list$iv = list;
            CollectionsKt.addAll((Collection)destination$iv, (Iterable)list$iv);
        }
        mainConfig2.setProcessDir(((PersistentSet.Builder)destination$iv).build());
        mainConfig.setSourcePath(ExtensionsKt.toPersistentSet((Iterable)this.getSourcePath()));
        mainConfig.setHideNoSource(this.getHideNoSource());
        mainConfig.setTraverseMode(this.getTraverseMode());
        mainConfig.setSrc_precedence(this.getSrcPrecedence());
        mainConfig.setSunBootClassPath(this.getSunBootClassPath());
        mainConfig.setJavaExtDirs(this.getJavaExtDirs());
        mainConfig.setUseDefaultJavaClassPath(!this.getDisableDefaultJavaClassPath());
        mainConfig.setDeCompileIfNotExists(this.enableDecompile);
        mainConfig.setEnableCodeMetrics(this.getEnableCodeMetrics());
        List ecjOptionsFile = this.getEcjOptions();
        if (ecjOptionsFile != null) {
            mainConfig.setEcj_options(ecjOptionsFile);
        }
        File file = this.getProjectScanConfig();
        if (file != null) {
            it = file;
            boolean bl13 = false;
            File file2 = this.getProjectScanConfig();
            Intrinsics.checkNotNull((Object)file2);
            ProjectConfig projectScanConfigParsed = ProjectConfig.Companion.load(file2);
            mainConfig.setProjectConfig(projectScanConfigParsed);
        }
        mainConfig.setUse_wrapper(!this.getDisableWrapper());
        mainConfig.setApponly(this.getApponly());
        Object object = this.getDataFlowOptions();
        if (object != null && (object = object.getFactor1()) != null) {
            int it9 = ((Number)object).intValue();
            boolean bl14 = false;
            ExtSettings.INSTANCE.setCalleeDepChainMaxNumForLibClassesInInterProceduraldataFlow(it9);
        }
        if (this.getStrict()) {
            ExtSettings.INSTANCE.setDataFlowInterProceduralCalleeTimeOut(-1);
        } else {
            Object object2 = this.getDataFlowOptions();
            if (object2 != null && (object2 = object2.getDataFlowInterProceduralCalleeTimeOut()) != null) {
                int it10 = ((Number)object2).intValue();
                boolean bl15 = false;
                ExtSettings.INSTANCE.setDataFlowInterProceduralCalleeTimeOut(it10);
            }
        }
        mainConfig.setRootPathsForConvertRelativePath(CollectionsKt.toList((Iterable)SetsKt.plus((Set)SetsKt.plus((Set)SetsKt.plus((Set)SetsKt.plus((Set)((Set)mainConfig.getProjectRoot()), (Iterable)((Iterable)mainConfig.getSourcePath())), (Iterable)((Iterable)mainConfig.getAutoAppClasses())), (Iterable)((Iterable)mainConfig.getProcessDir())), (Object)mainConfig.getOutput_dir())));
    }

    /*
     * Unable to fully structure code
     */
    private final void showMetrics() {
        theme = ContextKt.getTheme((Context)this.getCurrentContext());
        $this$showMetrics_u24lambda_u2483 = UsefulMetrics.Companion.getMetrics();
        $i$a$-with-FySastCli$showMetrics$1 = false;
        v0 = $this$showMetrics_u24lambda_u2483.getJvmMemoryMax();
        if (v0 != null) {
            (Long)v0.getValue();
        }
        v1 = $this$showMetrics_u24lambda_u2483.getFreePhysicalSize();
        if (v1 != null) {
            (Long)v1.getValue();
        }
        v2 = xmx = (v3 = $this$showMetrics_u24lambda_u2483.getJvmMemoryMax()) != null && (v3 = (Long)v3.getValue()) != null ? v3.longValue() : -1L;
        v4 = $this$showMetrics_u24lambda_u2483.getFreePhysicalSize();
        if (v4 == null || (v4 = (Long)v4.getValue()) == null) ** GOTO lbl-1000
        var6_5 = v4;
        it = ((Number)var6_5).longValue();
        $i$a$-takeIf-FySastCli$showMetrics$1$phy$1 = false;
        v4 = it >= 0L != false ? var6_5 : null;
        if (v4 != null) {
            v5 = v4.longValue();
        } else lbl-1000:
        // 2 sources

        {
            v5 = -1L;
        }
        phy = v5;
        redundancy = 0x19000000;
        xmxInfo = null;
        xmxExpect = -1.0;
        roundedNumber = (Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, showMetrics$lambda$83$lambda$80(double ), (Ljava/lang/Double;)Ljava/lang/Double;)();
        if (xmx <= 0L || phy <= 0L) {
            xmxInfo = theme.getDanger().invoke("Xmx:" + $this$showMetrics_u24lambda_u2483.getMemFmt($this$showMetrics_u24lambda_u2483.getJvmMemoryMax()) + " ");
        } else if (xmx > phy + (long)redundancy) {
            xmxInfo = theme.getWarning().invoke("Xmx:" + $this$showMetrics_u24lambda_u2483.getMemFmt($this$showMetrics_u24lambda_u2483.getJvmMemoryMax()) + " (warning: Greater than remaining virtual memory!)");
            xmxExpect = (double)(phy + (long)redundancy) * 0.9;
        } else if ((double)xmx < (double)phy * 0.74) {
            xmxInfo = theme.getWarning().invoke("Xmx:" + $this$showMetrics_u24lambda_u2483.getMemFmt($this$showMetrics_u24lambda_u2483.getJvmMemoryMax()) + " (warning: The memory restriction is excessively stringent!)");
            xmxExpect = (double)(phy + (long)redundancy) * 0.9;
        } else {
            xmxInfo = theme.getInfo().invoke("Xmx:" + $this$showMetrics_u24lambda_u2483.getMemFmt($this$showMetrics_u24lambda_u2483.getJvmMemoryMax()));
        }
        info = theme.getInfo().invoke("Remaining memory:" + $this$showMetrics_u24lambda_u2483.getMemFmt($this$showMetrics_u24lambda_u2483.getFreePhysicalSize()) + " Core:" + Runtime.getRuntime().availableProcessors() + " Threads: " + OS.INSTANCE.getMaxThreadNum());
        FySastCli.logger.info((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, showMetrics$lambda$83$lambda$81(java.lang.String java.lang.String ), ()Ljava/lang/Object;)((String)xmxInfo, (String)info));
        if (xmxExpect > 1.0) {
            decimalFormat = new DecimalFormat("#.#");
            decimalFormat.setDecimalSeparatorAlwaysShown(false);
            xmxHint = (OS.INSTANCE.isWindows() != false ? "set" : "export") + " _JAVA_OPTIONS=\"-Xmx" + decimalFormat.format(((Number)roundedNumber.invoke((Object)(xmxExpect / 1024.0 / (double)1024 / (double)1024))).doubleValue()) + "g\"";
            FySastCli.logger.warn((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, showMetrics$lambda$83$lambda$82(java.lang.String ), ()Ljava/lang/Object;)((String)xmxHint));
        }
    }

    private final void createAnchorPointFile() {
        block0: {
            IResFile iResFile;
            IResFile iResFile2 = this.anchorPointFile;
            if (iResFile2 == null) break block0;
            IResFile f = iResFile = iResFile2;
            boolean bl = false;
            f.mkdirs();
            PathsKt.writeText$default((Path)f.getPath(), (CharSequence)"nothing", null, (OpenOption[])new OpenOption[0], (int)2, null);
        }
    }

    private final void checkOutputDir() {
        if (this.getCheckerInfoCompareOptions() != null) {
            return;
        }
        IResFile anchorPointFile = this.getOutput().resolve(FySastCliKt.getANCHOR_POINT_FILE()).toFile();
        if (!anchorPointFile.getExists()) {
            if (!((Collection)IResDirectory.DefaultImpls.listPathEntries$default((IResDirectory)this.getOutput(), null, (int)1, null)).isEmpty()) {
                throw new IllegalArgumentException("The output directory (" + this.getOutput() + ") is not empty. To avoid disrupting your environment with overwritten files, please check this parameter or clear the output folder.");
            }
            this.anchorPointFile = anchorPointFile;
        }
    }

    private final void checkEnv(ProjectFileLocator locator2) {
        this.getOutput().mkdirs();
        FySastCli $this$checkEnv_u24lambda_u2487 = this;
        boolean bl = false;
        Iterable $this$forEach$iv = locator2.getSourceDir();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IResource it = (IResource)element$iv;
            boolean bl2 = false;
            if (!it.isFileScheme()) continue;
            Path path = $this$checkEnv_u24lambda_u2487.getOutput().getPath().toAbsolutePath();
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"toAbsolutePath(...)");
            Path path2 = path.normalize();
            Path path3 = it.getPath().toAbsolutePath();
            Intrinsics.checkNotNullExpressionValue((Object)path3, (String)"toAbsolutePath(...)");
            if (!path2.startsWith(path3.normalize())) continue;
            throw new IllegalArgumentException("The output (" + $this$checkEnv_u24lambda_u2487.getOutput() + ") directory cannot be pointed to within the resources (" + it + ") that will be scanned.");
        }
        String[] stringArray = new String[]{File.separator};
        List exists = SequencesKt.toList((Sequence)SequencesKt.map((Sequence)locator2.findFromFileIndexMap(StringsKt.split$default((CharSequence)FySastCliKt.getANCHOR_POINT_FILE(), (String[])stringArray, (boolean)false, (int)0, (int)6, null), AbstractFileIndexer.CompareMode.Path), FySastCli::checkEnv$lambda$87$lambda$86));
        if (!((Collection)exists).isEmpty()) {
            throw new IllegalArgumentException("The corax output directory (" + exists + ") has been detected as being included in the paths " + locator2.getSourceDir() + " to be scanned. Please move all the output directories to another location or delete them.");
        }
    }

    /*
     * Unable to fully structure code
     */
    private final Object getFilteredJavaSourceFiles(MainConfig var1_1, ProjectFileLocator var2_2, Continuation<? super Set<? extends IResFile>> $completion) {
        if (!($completion instanceof getFilteredJavaSourceFiles.1)) ** GOTO lbl-1000
        var12_4 = $completion;
        if ((var12_4.label & -2147483648) != 0) {
            var12_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var13_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var4_7 = ResourceKt.getJavaExtensions();
                destination$iv = new LinkedHashSet<E>();
                $i$f$flatMapSequenceTo = false;
                var7_10 = $this$flatMapTo$iv.iterator();
lbl16:
                // 2 sources

                while (var7_10.hasNext()) {
                    element$iv = var7_10.next();
                    javaExtension = (String)element$iv;
                    $i$a$-flatMapSequenceTo-FySastCli$getFilteredJavaSourceFiles$2 = false;
                    $continuation.L$0 = mainConfig;
                    $continuation.L$1 = locator;
                    $continuation.L$2 = destination$iv;
                    $continuation.L$3 = var7_10;
                    $continuation.label = 1;
                    v0 = locator.getByFileExtension(javaExtension, (Continuation)$continuation);
                    if (v0 == var13_6) {
                        return var13_6;
                    }
                    ** GOTO lbl40
                }
                break;
            }
            case 1: {
                $i$f$flatMapSequenceTo = false;
                $i$a$-flatMapSequenceTo-FySastCli$getFilteredJavaSourceFiles$2 = false;
                var7_10 = (Iterator<T>)$continuation.L$3;
                destination$iv = (Collection)$continuation.L$2;
                locator = (ProjectFileLocator)$continuation.L$1;
                mainConfig = (MainConfig)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl40:
                // 2 sources

                list$iv = SequencesKt.filter((Sequence)((Sequence)v0), (Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, getFilteredJavaSourceFiles$lambda$89$lambda$88(cn.sast.api.config.MainConfig cn.sast.common.IResFile ), (Lcn/sast/common/IResFile;)Ljava/lang/Boolean;)((MainConfig)mainConfig));
                CollectionsKt.addAll((Collection)destination$iv, (Sequence)list$iv);
                ** GOTO lbl16
            }
        }
        return destination$iv;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void writeSourceFileListForProbe(MainConfig mainConfig, IResFile out, Set<? extends IResFile> srcFiles) {
        out.mkdirs();
        Object object = out.getPath();
        Object object2 = Charsets.UTF_8;
        Unit unit = new Unit[]{};
        object = new OutputStreamWriter(Files.newOutputStream((Path)object, Arrays.copyOf(unit, ((OpenOption[])unit).length)), (Charset)object2);
        object2 = null;
        try {
            OutputStreamWriter it = (OutputStreamWriter)object;
            boolean bl = false;
            for (IResFile iResFile : srcFiles) {
                IResFile e = iResFile.expandRes(mainConfig.getOutput_dir());
                it.write(e + "\n");
                ((Collection)this.sqliteFileIndexes).add(e);
            }
            unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object2 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void addFilesToDataBase(MainConfig mainConfig, Set<? extends IResFile> files2) {
        Closeable closeable = (Closeable)ResultCollector.Companion.newSqliteDiagnostics(mainConfig, null, mainConfig.getOutput_dir(), null);
        Throwable throwable = null;
        try {
            SqliteDiagnostics it = (SqliteDiagnostics)closeable;
            boolean bl = false;
            SqliteDiagnostics.open$default((SqliteDiagnostics)it, null, (int)1, null);
            for (IResFile iResFile : files2) {
                it.createFileXCachedFromFile(iResFile);
            }
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    private final Object runCodeMetrics(MainConfig var1_1, Set<? extends IResFile> var2_2, Continuation<? super Unit> $completion) {
        if (!($completion instanceof runCodeMetrics.1)) ** GOTO lbl-1000
        var13_4 = $completion;
        if ((var13_4.label & -2147483648) != 0) {
            var13_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var14_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                listFile = mainConfig.getOutput_dir().resolve("tmp/code-metrics-file-list.txt").toFile();
                listFile.mkdirs();
                var5_9 = listFile.getPath();
                var6_10 = Charsets.UTF_8;
                var7_11 = new OpenOption[]{};
                var5_9 = new OutputStreamWriter(Files.newOutputStream((Path)var5_9, Arrays.copyOf(var7_11, var7_11.length)), (Charset)var6_10);
                var6_10 = null;
                try {
                    it = (OutputStreamWriter)var5_9;
                    $i$a$-use-FySastCli$runCodeMetrics$2 = false;
                    for (IResFile f : srcFiles) {
                        if (!Intrinsics.areEqual((Object)f.getExtension(), (Object)"java")) continue;
                        e = f.expandRes(mainConfig.getOutput_dir());
                        it.write(e + "\n");
                        ((Collection)this.sqliteFileIndexes).add(e);
                    }
                    it = Unit.INSTANCE;
                }
                catch (Throwable it) {
                    var6_10 = it;
                    throw it;
                }
                finally {
                    CloseableKt.closeFinally((Closeable)var5_9, (Throwable)var6_10);
                }
                v0 = this.constructPmdAnalyzerCmd(listFile, mainConfig.getOutput_dir().resolve("metrics/metrics.csv").toFile());
                if (v0 == null) {
                    return Unit.INSTANCE;
                }
                pmdAnalyzerCmd = v0;
                pb = new Ref.ObjectRef();
                pb.element = new ProcessBuilder(new String[0]);
                dir = new File(".").getAbsoluteFile();
                pb.element = ((ProcessBuilder)pb.element).directory(dir);
                pb.element = ((ProcessBuilder)pb.element).command(pmdAnalyzerCmd);
                FySastCli.logger.debug((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, runCodeMetrics$lambda$93(kotlin.jvm.internal.Ref$ObjectRef ), ()Ljava/lang/Object;)((Ref.ObjectRef)pb));
                pb.element = ((ProcessBuilder)pb.element).redirectErrorStream(true);
                $continuation.label = 1;
                v1 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (Continuation)$continuation);
                ** if (v1 != var14_6) goto lbl55
lbl54:
                // 1 sources

                return var14_6;
lbl55:
                // 1 sources

                ** GOTO lbl64
            }
            case 1: {
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
                }
                catch (Exception e) {
                    FySastCli.logger.error((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, runCodeMetrics$lambda$94(java.lang.Exception ), ()Ljava/lang/Object;)((Exception)e));
                }
lbl64:
                // 3 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private final void top(MetricsMonitor monitor) {
        Path path = this.getOutput().resolve("top.log").getPath();
        OpenOption[] openOptionArray = new OpenOption[]{StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE};
        Charset charset = Charsets.UTF_8;
        OutputStreamWriter io = new OutputStreamWriter(Files.newOutputStream(path, Arrays.copyOf(openOptionArray, openOptionArray.length)), charset);
        io.write(LocalDateTime.now() + ": --------------------start--------------------");
        io.write(LocalDateTime.now() + ": PID: " + ProcessHandle.current().pid());
        charset = () -> FySastCli.top$lambda$96(io);
        Charset $this$top_u24lambda_u2497 = charset = new /* Unavailable Anonymous Inner Class!! */;
        boolean bl = false;
        $this$top_u24lambda_u2497.setRepeats(true);
        $this$top_u24lambda_u2497.start();
        Charset topLogWriter2 = charset;
        monitor.addAnalyzeFinishHook(new Thread((Runnable)new /* Unavailable Anonymous Inner Class!! */));
    }

    /*
     * Unable to fully structure code
     */
    private final Object runAnalyze(TargetOptions var1_1, MetricsMonitor var2_2, Continuation<? super Unit> $completion) {
        block21: {
            if (!($completion instanceof runAnalyze.1)) ** GOTO lbl-1000
            var26_4 = $completion;
            if ((var26_4.label & -2147483648) != 0) {
                var26_4.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new /* Unavailable Anonymous Inner Class!! */;
            }
            $result = $continuation.result;
            var27_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    AnalysisCache.G.INSTANCE.clear();
                    Resource.INSTANCE.clean();
                    FileSystemCacheLocator.INSTANCE.clear();
                    SootUtils.INSTANCE.cleanUp();
                    FileSystemLocator.Companion.clear();
                    if (!this.getDisableTop()) {
                        this.top(monitor);
                    }
                    this.setVerbosity(this.getVerbosity());
                    this.showMetrics();
                    System.setProperty("ENABLE_STRUCTURE_ANALYSIS", this.getEnableStructureAnalysis() != false ? "true" : "false");
                    v0 = this.getSourceEncoding();
                    Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"<get-sourceEncoding>(...)");
                    var5_7 = v0;
                    mainConfig = new MainConfig(var5_7, (IMonitor)monitor, null, null, false, null, false, false, null, false, null, null, null, null, null, null, false, false, null, false, false, 0, 0, false, null, null, null, null, null, false, false, false, false, false, false, false, false, null, null, null, 0.0, -4, 511, null);
                    Runtime.getRuntime().addShutdownHook(new Thread((Runnable)new /* Unavailable Anonymous Inner Class!! */));
                    monitor.addAnalyzeFinishHook(new Thread((Runnable)new /* Unavailable Anonymous Inner Class!! */));
                    this.configureMainConfig(mainConfig, monitor);
                    target.configureMainConfig(mainConfig);
                    flowDroidOptions = this.getFlowDroidOptions();
                    dataFlowOptions = this.getDataFlowOptions();
                    utAnalyzeOptions = this.getUtAnalyzeOptions();
                    $i$a$-run-FySastCli$runAnalyze$locator$1 = false;
                    fileWrapperOutPutDir = mainConfig.getHideNoSource() == false ? mainConfig.getOutput_dir().resolve("source").toDirectory() : null;
                    sourceDir = SetsKt.plus((Set)SetsKt.plus((Set)SetsKt.plus((Set)SetsKt.plus((Set)((Set)mainConfig.getProjectRoot()), (Iterable)((Iterable)mainConfig.getSourcePath())), (Iterable)((Iterable)mainConfig.getProcessDir())), (Iterable)((Iterable)mainConfig.getAutoAppClasses())), (Iterable)mainConfig.get_expand_class_path());
                    var12_15 = monitor.getProjectMetrics().getPaths();
                    $this$map$iv = sourceDir;
                    $i$f$map = false;
                    var15_19 = $this$map$iv;
                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    $i$f$mapTo = false;
                    for (T item$iv$iv : $this$mapTo$iv$iv) {
                        var20_29 = (IResource)item$iv$iv;
                        var21_30 = destination$iv$iv;
                        $i$a$-map-FySastCli$runAnalyze$locator$1$1 = false;
                        var21_30.add(it.toString());
                    }
                    $this$map$iv = (List)destination$iv$iv;
                    CollectionsKt.addAll((Collection)var12_15, (Iterable)$this$map$iv);
                    locator = new ProjectFileLocator((IMonitor)monitor, sourceDir, fileWrapperOutPutDir, mainConfig.getTraverseMode(), false, 16, null);
                    locator.update();
                    monitor.getProjectMetrics().setTotalFileNum(locator.totalFiles());
                    totalAnySourceFileNum = locator.totalJavaSrcFiles();
                    monitor.getProjectMetrics().setTotalAnySourceFileNum(totalAnySourceFileNum);
                    FySastCli.logger.info((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, runAnalyze$lambda$100$lambda$99(long ), ()Ljava/lang/Object;)((long)totalAnySourceFileNum));
                    locator = locator;
                    this.checkEnv(locator);
                    sootCtx = new SootCtx(mainConfig);
                    f0 = new CompilationUnitOfSCFactory((Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, runAnalyze$lambda$101(cn.sast.framework.report.ProjectFileLocator soot.SootClass ), (Lsoot/SootClass;)Ljava/nio/file/Path;)((ProjectFileLocator)locator));
                    f1 = new SootHostExtInfoFactory(f0);
                    AnalysisCache.G.INSTANCE.setCompilationUnitOfSCFactory(f0);
                    AnalysisCache.G.INSTANCE.setSootHostExtInfoFactory(f1);
                    target.initSoot(sootCtx, locator);
                    info = new /* Unavailable Anonymous Inner Class!! */;
                    PackManager.v().getPack("jb").add(new Transform("jb.identityStmt2MethodParamRegion", (Transformer)new IdentityStmt2MethodParamRegion((SootInfoCache)info)));
                    it = $i$f$map = this.getResultCollector((SootInfoCache)info, locator, mainConfig, monitor);
                    $i$a$-also-FySastCli$runAnalyze$result$1 = false;
                    this.lastResult = it;
                    result = $i$f$map;
                    runner = new AnalyzeTaskRunner(mainConfig.getParallelsNum(), sootCtx, (IMonitor)monitor);
                    enableBuiltInAnalysis = this.getDisableBuiltInAnalysis() == false && (AnalyzerEnv.INSTANCE.getShouldV3r14y() == false || AnalyzerEnv.INSTANCE.getBvs1n3ss().get() != 0);
                    builtinAnalysis = enableBuiltInAnalysis != false ? new BuiltinAnalysis(mainConfig, (SootInfoCache)info) : null;
                    $i$a$-run-FySastCli$runAnalyze$4 = false;
                    if (builtinAnalysis != null) {
                        v1 = mainConfig.getSaConfig();
                        if (v1 == null || (v1 = v1.getBuiltinAnalysisConfig()) == null) {
                            v1 = builtinAnalysisConfig = new BuiltinAnalysisConfig(null, null, 0, 0, 15, null);
                        }
                        if (!mainConfig.getSkipClass() && BuiltinAnalysis.Companion.isEnableAllMethodsAnalyzeInScene(mainConfig) && mainConfig.isEnable((CheckType)DefineUnusedChecker.UnusedMethod.INSTANCE)) {
                            allMethodsProvider = new BuiltinAnalysis.CHA-AllMethodsProvider(null, 1, null);
                            AnalyzeTaskRunner.registerAnalysis$default((AnalyzeTaskRunner)runner, (String)"BuiltinAnalysis.allMethodsAnalyzeInScene", (IEntryPointProvider)((IEntryPointProvider)allMethodsProvider), null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), null, (int)20, null);
                        }
                    }
                    $i$a$-run-FySastCli$runAnalyze$5 = false;
                    provider = target.getProvider(sootCtx, locator);
                    if (builtinAnalysis != null) {
                        AnalyzeTaskRunner.registerAnalysis$default((AnalyzeTaskRunner)runner, (String)"BuiltinAnalysis.analyzeInScene", (IEntryPointProvider)provider, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), null, (int)20, null);
                    }
                    v2 = dataFlowOptions;
                    v3 = v2 != null ? v2.getEnableDataFlow() : false;
                    if (v3 || target instanceof SrcAnalyzeOptions || !this.getDisablePreAnalysis()) {
                        analyzer = new IPAnalysisEngine(mainConfig, null, 2, null);
                        AnalyzeTaskRunner.registerAnalysis$default((AnalyzeTaskRunner)runner, (String)"dataFlow", (IEntryPointProvider)provider, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */), (int)4, null);
                    }
                    if (flowDroidOptions != null && flowDroidOptions.getEnableFlowDroid()) {
                        Intrinsics.checkNotNull((Object)target, (String)"null cannot be cast to non-null type cn.sast.cli.command.IClassAnalyzeOptionGroup");
                        infoFlowConfig = ((IClassAnalyzeOptionGroup)target).getInfoFlowConfig();
                        flowDroidOptions.configureInfoFlowConfig(infoFlowConfig, mainConfig);
                        flowEngine = new FlowDroidEngine(mainConfig, infoFlowConfig, flowDroidOptions.getExtInfoFlowConfig());
                        cfgFactory = null;
                        AnalyzeTaskRunner.registerAnalysis$default((AnalyzeTaskRunner)runner, (String)"flowDroid", (IEntryPointProvider)provider, (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */), (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), null, (int)16, null);
                    }
                    if (utAnalyzeOptions != null && utAnalyzeOptions.getEnableUtAnalyze()) {
                        throw new NotImplementedError(null, 1, null);
                    }
                    $continuation.L$0 = this;
                    $continuation.L$1 = monitor;
                    $continuation.L$2 = mainConfig;
                    $continuation.L$3 = locator;
                    $continuation.L$4 = result;
                    $continuation.label = 1;
                    v4 = runner.run((Continuation)$continuation);
                    if (v4 == var27_6) {
                        return var27_6;
                    }
                    ** GOTO lbl124
                }
                case 1: {
                    result = (ResultCollector)$continuation.L$4;
                    locator = (ProjectFileLocator)$continuation.L$3;
                    mainConfig = (MainConfig)$continuation.L$2;
                    monitor = (MetricsMonitor)$continuation.L$1;
                    this = (FySastCli)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v4 = $result;
lbl124:
                    // 2 sources

                    if (!this.getMakeScorecard()) ** GOTO lbl145
                    $continuation.L$0 = this;
                    $continuation.L$1 = monitor;
                    $continuation.L$2 = mainConfig;
                    $continuation.L$3 = locator;
                    $continuation.L$4 = result;
                    $continuation.label = 2;
                    v5 = new AccuracyValidator(mainConfig).makeScore(result, (IProjectFileLocator)locator, (Continuation)$continuation);
                    if (v5 == var27_6) {
                        return var27_6;
                    }
                    ** GOTO lbl143
                }
                case 2: {
                    result = (ResultCollector)$continuation.L$4;
                    locator = (ProjectFileLocator)$continuation.L$3;
                    mainConfig = (MainConfig)$continuation.L$2;
                    monitor = (MetricsMonitor)$continuation.L$1;
                    this = (FySastCli)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl143:
                    // 2 sources

                    res = (AccuracyValidator.Result)v5;
                    FySastCli.logger.warn((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, runAnalyze$lambda$105(cn.sast.framework.validator.AccuracyValidator$Result ), ()Ljava/lang/Object;)((AccuracyValidator.Result)res));
lbl145:
                    // 2 sources

                    v6 = this.getDumpSrcFileList();
                    if (v6 == null) break;
                    out = v6;
                    $i$a$-let-FySastCli$runAnalyze$srcFiles$1 = false;
                    $continuation.L$0 = this;
                    $continuation.L$1 = monitor;
                    $continuation.L$2 = mainConfig;
                    $continuation.L$3 = locator;
                    $continuation.L$4 = result;
                    $continuation.L$5 = out;
                    $continuation.label = 3;
                    v7 = this.getFilteredJavaSourceFiles(mainConfig, locator, (Continuation)$continuation);
                    if (v7 == var27_6) {
                        return var27_6;
                    }
                    ** GOTO lbl170
                }
                case 3: {
                    $i$a$-let-FySastCli$runAnalyze$srcFiles$1 = false;
                    out = (String)$continuation.L$5;
                    result = (ResultCollector)$continuation.L$4;
                    locator = (ProjectFileLocator)$continuation.L$3;
                    mainConfig = (MainConfig)$continuation.L$2;
                    monitor = (MetricsMonitor)$continuation.L$1;
                    this = (FySastCli)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v7 = $result;
lbl170:
                    // 2 sources

                    var22_33 = v7;
                    it = (Set)var22_33;
                    $i$a$-also-FySastCli$runAnalyze$srcFiles$1$1 = false;
                    this.writeSourceFileListForProbe(mainConfig, Resource.INSTANCE.fileOf(out), it);
                    v8 = (Set)var22_33;
                    break block21;
                }
            }
            v8 = null;
        }
        srcFiles = v8;
        BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
        if (!Options.v().oaat() && mainConfig.getDumpSootScene()) {
            FySastCli.logger.info((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, runAnalyze$lambda$108(), ()Ljava/lang/Object;)());
            PackManager.v().writeOutput();
        }
        this.addFilesToDataBase(mainConfig, this.sqliteFileIndexes);
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private final List<String> constructPmdAnalyzerCmd(IResFile fileList, IResFile csvResultPath) {
        Path pmdDist;
        Path path;
        String javaExe = OS.INSTANCE.getJavaExecutableFilePath();
        if (javaExe == null) {
            logger.warn(FySastCli::constructPmdAnalyzerCmd$lambda$109);
            return null;
        }
        IResource outputDir = csvResultPath.getParent();
        if (outputDir != null && !outputDir.getExists()) {
            outputDir.mkdirs();
        }
        Path path2 = (path = OS.INSTANCE.getJarBinPath()) != null && (path = path.getParent()) != null && (path = path.getParent()) != null ? path.resolve("pmd") : (pmdDist = null);
        if (pmdDist == null) {
            logger.warn(FySastCli::constructPmdAnalyzerCmd$lambda$110);
            return null;
        }
        LinkOption[] linkOptionArray = new LinkOption[]{};
        if (!Files.exists(pmdDist, Arrays.copyOf(linkOptionArray, linkOptionArray.length)) || !PathExtensionsKt.isDirectory((Path)pmdDist)) {
            logger.debug(FySastCli::constructPmdAnalyzerCmd$lambda$111);
            return null;
        }
        Path rule = pmdDist.resolve("conf/corax-rule.xml");
        String[] stringArray = new String[]{"check", "--no-cache", "--threads", "8", "-R", ((Object)rule).toString(), "-f", "coraxcsv", "-r", csvResultPath.toString(), "--file-list", fileList.toString()};
        String[] pmdArgs = stringArray;
        List<String> list = ManagementFactory.getRuntimeMXBean().getInputArguments();
        Intrinsics.checkNotNullExpressionValue(list, (String)"getInputArguments(...)");
        Collection $this$toTypedArray$iv = list;
        boolean $i$f$toTypedArray22 = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        String[] vmOptions = thisCollection$iv.toArray(new String[0]);
        Object[] $i$f$toTypedArray22 = new String[]{((Object)pmdDist.resolve("conf")).toString(), pmdDist.resolve("lib") + File.separator + "*"};
        List pmdClasspath = CollectionsKt.listOf((Object[])$i$f$toTypedArray22);
        String pmdMainClass = "net.sourceforge.pmd.cli.PmdCli";
        Iterable iterable = pmdClasspath;
        String string = File.pathSeparator;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"pathSeparator");
        String pmdClasspathArg = CollectionsKt.joinToString$default((Iterable)iterable, (CharSequence)string, null, null, (int)0, null, null, (int)62, null);
        SpreadBuilder spreadBuilder = new SpreadBuilder(6);
        spreadBuilder.add((Object)javaExe);
        spreadBuilder.addSpread((Object)vmOptions);
        spreadBuilder.add((Object)"-classpath");
        spreadBuilder.add((Object)pmdClasspathArg);
        spreadBuilder.add((Object)pmdMainClass);
        spreadBuilder.addSpread((Object)pmdArgs);
        List pmdAnalyzerCmd = CollectionsKt.mutableListOf((Object[])spreadBuilder.toArray((Object[])new String[spreadBuilder.size()]));
        logger.debug(() -> FySastCli.constructPmdAnalyzerCmd$lambda$112(pmdAnalyzerCmd));
        return pmdAnalyzerCmd;
    }

    public final void main2(@NotNull List<String> argv) {
        Intrinsics.checkNotNullParameter(argv, (String)"argv");
        logger.info(() -> FySastCli.main2$lambda$113(argv));
        Collection $this$toTypedArray$iv = argv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        OS.INSTANCE.setArgs(thisCollection$iv.toArray(new String[0]));
        Runtime.getRuntime().addShutdownHook(new Thread((Runnable)main2.2.INSTANCE));
        this.main(argv);
    }

    public final void main2(@NotNull String[] argv) {
        Intrinsics.checkNotNullParameter((Object)argv, (String)"argv");
        this.main2(ArraysKt.toList((Object[])argv));
    }

    private static final MordantHelpFormatter lambda$1$lambda$0(Context it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new MordantHelpFormatter(it, null, true, true, 2, null);
    }

    private static final Unit _init_$lambda$1(Context.Builder $this$context) {
        Intrinsics.checkNotNullParameter((Object)$this$context, (String)"$this$context");
        $this$context.setHelpFormatter(FySastCli::lambda$1$lambda$0);
        return Unit.INSTANCE;
    }

    private static final IResDirectory defaultOutput_delegate$lambda$7() {
        return Resource.INSTANCE.dirOf(System.getProperty("user.dir") + File.separator + "output");
    }

    private static final CharSequence printOptions$lambda$33(Theme $theme, Option it) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (it instanceof OptionWithValues) {
            Object object;
            try {
                object = ((OptionWithValues)it).getValue();
            }
            catch (IllegalStateException e) {
                object = null;
            }
            Object value = object;
            String string = $theme.getInfo().invoke(it.getNames().toString());
            TextStyle textStyle = $theme.getWarning();
            String string2 = Objects.toString(value);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
            charSequence = string + " \"" + textStyle.invoke(string2) + "\"";
        } else {
            charSequence = it.getNames().toString();
        }
        return charSequence;
    }

    private static final Object printOptions$lambda$34() {
        return Theme.Companion.getDefault().getInfo().invoke("Current work directory: " + FilesKt.normalize((File)new File(".")).getAbsolutePath());
    }

    private static final Object printOptions$lambda$35() {
        return Theme.Companion.getDefault().getInfo().invoke("PID: " + ProcessHandle.current().pid());
    }

    private static final Object printOptions$lambda$36() {
        return "log files: " + AnalyzerEnv.INSTANCE.getLastLogFile().getParent();
    }

    private static final Object printOptions$lambda$37(String $info) {
        return "\n" + $info;
    }

    private static final Object printOptions$lambda$38(Theme $theme) {
        URL uRL = OS.INSTANCE.getBinaryUrl();
        return "corax " + $theme.getSuccess().invoke(ApplicationKt.getVersion()) + ": " + (uRL != null ? uRL.getPath() : null) + "}";
    }

    private static final Object compatibleOldCheckerNames$lambda$40(Exception $e) {
        return $e.getMessage();
    }

    /*
     * WARNING - void declaration
     */
    private static final Object parseConfig$lambda$46(String $name, List $configDirs, IResFile $tempFile, IResource $tempFileDir) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Iterable iterable = $configDirs;
        String string = $name;
        boolean $i$f$map = false;
        void var6_7 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            IResource iResource = (IResource)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getAbsolute().getNormalize());
        }
        return "\n\n\nfile: " + string + " is not exists in plugin directories: [" + CollectionsKt.joinToString$default((Iterable)((List)destination$iv$iv), (CharSequence)"\n\t", null, null, (int)0, null, null, (int)62, null) + "].\nA template SA-configuration file has been generated for you. Please edit it then run it again.\n-> " + $tempFile + "\n-> args: --config " + $name + "@" + $tempFileDir + "\n\n\n";
    }

    private static final Object parseConfig$lambda$47(IResFile $ymlConfig) {
        return "Use SA-Configuration yml file: " + $ymlConfig;
    }

    private static final Object defaultConfig$lambda$48() {
        return "Try find config from local env: CORAX_CONFIG_DEFAULT_DIR";
    }

    private static final Object defaultConfig$lambda$49() {
        return "No config exists in the local env: CORAX_CONFIG_DEFAULT_DIR";
    }

    private static final Object setTimeOut$lambda$51$lambda$50(FySastCli this$0) {
        return "Custom analysis shutdown timer has been exceeded in " + this$0.getTimeout() + " seconds";
    }

    private static final Unit setTimeOut$lambda$51(FySastCli this$0) {
        logger.warn(() -> FySastCli.setTimeOut$lambda$51$lambda$50(this$0));
        System.exit(700);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private static final Object run$lambda$54(FySastCli this$0) {
        return "Output: " + this$0.getOutput().getAbsolute().getNormalize();
    }

    private static final Object run$lambda$55(LocalDateTime $startTime) {
        Intrinsics.checkNotNull((Object)$startTime);
        return "Analysis was completed in " + TimeUtilsKt.prettyPrintTime$default((LocalDateTime)$startTime, null, (int)1, null);
    }

    private static final Object run$lambda$56(FySastCli this$0) {
        return "Output: " + this$0.getOutput().getAbsolute().getNormalize();
    }

    private static final Object run$lambda$57(LocalDateTime $startTime) {
        Intrinsics.checkNotNull((Object)$startTime);
        return "Analysis was terminated after " + TimeUtilsKt.prettyPrintTime$default((LocalDateTime)$startTime, null, (int)1, null);
    }

    private static final CheckerInfoGenResult configureMainConfig$lambda$67$lambda$66(CheckerInfoGenerator $gen) {
        CheckerInfoGenerator checkerInfoGenerator = $gen;
        return checkerInfoGenerator != null ? checkerInfoGenerator.getCheckerInfo(false) : null;
    }

    private static final double showMetrics$lambda$83$lambda$80(double number) {
        return (double)MathKt.roundToLong((double)(number / 0.5)) * 0.5;
    }

    private static final Object showMetrics$lambda$83$lambda$81(String $xmxInfo, String $info) {
        return "Hardware Info: " + $xmxInfo + " " + $info;
    }

    private static final Object showMetrics$lambda$83$lambda$82(String $xmxHint) {
        return "\nYou can add the following command before run analysis to fully utilize the machine's performance:\n\t > " + Theme.Companion.getDefault().getWarning().invoke($xmxHint) + "\n";
    }

    private static final IResource checkEnv$lambda$87$lambda$86(IResFile it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        IResource iResource = it.getParent();
        return iResource != null ? iResource.getParent() : null;
    }

    private static final boolean getFilteredJavaSourceFiles$lambda$89$lambda$88(MainConfig $mainConfig, IResFile it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (!$mainConfig.getAutoAppSrcInZipScheme() && !it.isFileScheme()) {
            return false;
        }
        return ScanFilter.getActionOf$default((ScanFilter)$mainConfig.getScanFilter(), null, (Path)it.getPath(), null, (int)4, null) != ProcessRule.ScanAction.Skip;
    }

    private static final Object runCodeMetrics$lambda$93(Ref.ObjectRef $pb) {
        List<String> list = ((ProcessBuilder)$pb.element).command();
        Intrinsics.checkNotNullExpressionValue(list, (String)"command(...)");
        return "PMD command line: " + CollectionsKt.joinToString$default((Iterable)list, (CharSequence)" ", null, null, (int)0, null, null, (int)62, null);
    }

    private static final Object runCodeMetrics$lambda$94(Exception $e) {
        return "There are some errors when running code metrics analysis of pmd: " + $e.getMessage();
    }

    private static final Unit top$lambda$96(OutputStreamWriter $io) {
        ProcessInfoView $this$top_u24lambda_u2496_u24lambda_u2495 = ProcessInfoView.Companion.getGlobalProcessInfo();
        boolean bl = false;
        $io.write(LocalDateTime.now() + ": " + $this$top_u24lambda_u2496_u24lambda_u2495.getProcessInfoText() + " " + $this$top_u24lambda_u2496_u24lambda_u2495.getCpuLoadText() + "\n");
        $io.flush();
        return Unit.INSTANCE;
    }

    private static final Object runAnalyze$lambda$100$lambda$99(long $totalAnySourceFileNum) {
        return "Total java source files: " + $totalAnySourceFileNum;
    }

    private static final Path runAnalyze$lambda$101(ProjectFileLocator $locator, SootClass sc) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        IResFile iResFile = $locator.get((IBugResInfo)new ClassResInfo(sc), (IWrapperFileGenerator)NullWrapperFileGenerator.INSTANCE);
        return iResFile != null ? iResFile.getPath() : null;
    }

    private static final Object runAnalyze$lambda$105(AccuracyValidator.Result $res) {
        return $res;
    }

    private static final Object runAnalyze$lambda$108() {
        return "dump soot scene ...";
    }

    private static final Object constructPmdAnalyzerCmd$lambda$109() {
        return "Java executable path is null";
    }

    private static final Object constructPmdAnalyzerCmd$lambda$110() {
        return "Executable main jar path is null";
    }

    private static final Object constructPmdAnalyzerCmd$lambda$111() {
        return "PMD dir does not exist or is not a directory";
    }

    private static final Object constructPmdAnalyzerCmd$lambda$112(List $pmdAnalyzerCmd) {
        return "The command of PMD is: " + $pmdAnalyzerCmd;
    }

    private static final Object main2$lambda$113(List $argv) {
        return "argv is " + CollectionsKt.joinToString$default((Iterable)$argv, (CharSequence)" ", null, null, (int)0, null, null, (int)62, null);
    }

    private static final Unit logger$lambda$114() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$runAnalyze(FySastCli $this, TargetOptions target, MetricsMonitor monitor, Continuation $completion) {
        return $this.runAnalyze(target, monitor, $completion);
    }

    public static final /* synthetic */ TargetOptions access$getTarget(FySastCli $this) {
        return $this.getTarget();
    }

    public static final /* synthetic */ Object access$getFilteredJavaSourceFiles(FySastCli $this, MainConfig mainConfig, ProjectFileLocator locator2, Continuation $completion) {
        return $this.getFilteredJavaSourceFiles(mainConfig, locator2, $completion);
    }

    public static final /* synthetic */ Object access$runCodeMetrics(FySastCli $this, MainConfig mainConfig, Set srcFiles, Continuation $completion) {
        return $this.runCodeMetrics(mainConfig, srcFiles, $completion);
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ boolean access$getEnableCodeMetrics(FySastCli $this) {
        return $this.getEnableCodeMetrics();
    }

    public static final /* synthetic */ boolean access$getDisablePreAnalysis(FySastCli $this) {
        return $this.getDisablePreAnalysis();
    }

    public static final /* synthetic */ boolean access$getSerializeCG(FySastCli $this) {
        return $this.getSerializeCG();
    }

    public static final /* synthetic */ IResDirectory access$getOutput(FySastCli $this) {
        return $this.getOutput();
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "verbosity", "getVerbosity()Lorg/slf4j/event/Level;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "config", "getConfig()Ljava/lang/String;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "rules", "getRules()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "output", "getOutput()Lcn/sast/common/IResDirectory;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "dumpSootScene", "getDumpSootScene()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "resultType", "getResultType()Ljava/util/Set;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "preferredLanguages", "getPreferredLanguages()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "enableCodeMetrics", "getEnableCodeMetrics()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "dumpSrcFileList", "getDumpSrcFileList()Ljava/lang/String;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "target", "getTarget()Lcn/sast/cli/command/TargetOptions;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "process", "getProcess()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "classPath", "getClassPath()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "autoAppClasses", "getAutoAppClasses()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "autoAppTraverseMode", "getAutoAppTraverseMode()Lcn/sast/common/FileSystemLocator$TraverseMode;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "autoAppSrcOnlyFileScheme", "getAutoAppSrcOnlyFileScheme()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "disableDefaultJavaClassPath", "getDisableDefaultJavaClassPath()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "sourcePath", "getSourcePath()Ljava/util/Set;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "projectRoot", "getProjectRoot()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "srcPrecedence", "getSrcPrecedence()Lcn/sast/api/config/SrcPrecedence;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "incrementalScanOf", "getIncrementalScanOf()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "disableMappingDiffInArchive", "getDisableMappingDiffInArchive()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "sunBootClassPath", "getSunBootClassPath()Ljava/lang/String;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "javaExtDirs", "getJavaExtDirs()Ljava/lang/String;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "ecjOptions", "getEcjOptions()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "serializeCG", "getSerializeCG()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "c2sMode", "getC2sMode()Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "hideNoSource", "getHideNoSource()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "traverseMode", "getTraverseMode()Lcn/sast/common/FileSystemLocator$TraverseMode;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "projectScanConfig", "getProjectScanConfig()Ljava/io/File;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "disableWrapper", "getDisableWrapper()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "apponly", "getApponly()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "disablePreAnalysis", "getDisablePreAnalysis()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "disableBuiltInAnalysis", "getDisableBuiltInAnalysis()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "dataFlowOptions", "getDataFlowOptions()Lcn/sast/cli/command/DataFlowOptions;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "checkerInfoGeneratorOptions", "getCheckerInfoGeneratorOptions()Lcn/sast/cli/command/tools/CheckerInfoGeneratorOptions;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "checkerInfoCompareOptions", "getCheckerInfoCompareOptions()Lcn/sast/cli/command/tools/CheckerInfoCompareOptions;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "subtoolsOptions", "getSubtoolsOptions()Lcn/sast/cli/command/tools/SubToolsOptions;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "flowDroidOptions", "getFlowDroidOptions()Lcn/sast/cli/command/FlowDroidOptions;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "utAnalyzeOptions", "getUtAnalyzeOptions()Lcn/sast/cli/command/UtAnalyzeOptions;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "enableStructureAnalysis", "getEnableStructureAnalysis()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "enableOriginalNames", "getEnableOriginalNames()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "staticFieldTrackingMode", "getStaticFieldTrackingMode()Lcn/sast/api/config/StaticFieldTrackingMode;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "callGraphAlgorithm", "getCallGraphAlgorithm()Ljava/lang/String;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "callGraphAlgorithmBuiltIn", "getCallGraphAlgorithmBuiltIn()Ljava/lang/String;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "disableReflection", "getDisableReflection()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "maxThreadNum", "getMaxThreadNum()I", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "memoryThreshold", "getMemoryThreshold()D", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "disableTop", "getDisableTop()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "strict", "getStrict()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "zipFSEnv", "getZipFSEnv()Ljava/util/Map;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "zipFSEncodings", "getZipFSEncodings()Ljava/util/List;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "hashVersion", "getHashVersion()Ljava/lang/Integer;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "sourceEncoding", "getSourceEncoding()Ljava/nio/charset/Charset;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "makeScorecard", "getMakeScorecard()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FySastCli.class, "timeout", "getTimeout()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        logger = KotlinLogging.INSTANCE.logger(FySastCli::logger$lambda$114);
    }
}

