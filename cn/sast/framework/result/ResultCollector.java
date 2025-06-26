/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.PreAnalysisCoroutineScope
 *  cn.sast.api.report.BugPathEvent
 *  cn.sast.api.report.IResultCollector
 *  cn.sast.api.report.Report
 *  cn.sast.common.IResDirectory
 *  cn.sast.dataflow.infoflow.provider.BugTypeProvider
 *  cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis
 *  cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector
 *  cn.sast.framework.engine.PreAnalysisReportEnv
 *  cn.sast.framework.metrics.MetricsMonitor
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IReportConsumer
 *  cn.sast.framework.report.PlistDiagnostics
 *  cn.sast.framework.report.ProjectFileLocator
 *  cn.sast.framework.report.ReportConverter
 *  cn.sast.framework.report.SarifDiagnostics
 *  cn.sast.framework.report.SarifDiagnosticsCopySrc
 *  cn.sast.framework.report.SarifDiagnosticsPack
 *  cn.sast.framework.report.SqliteDiagnostics
 *  cn.sast.framework.report.coverage.JacocoCompoundCoverage
 *  cn.sast.framework.result.IBuiltInAnalysisCollector
 *  cn.sast.framework.result.IFlowDroidResultCollector
 *  cn.sast.framework.result.IMissingSummaryReporter
 *  cn.sast.framework.result.IPreAnalysisResultCollector
 *  cn.sast.framework.result.IReportsVisitor
 *  cn.sast.framework.result.IUTBotResultCollector
 *  cn.sast.framework.result.OutputType
 *  cn.sast.framework.result.PurificationReportKey
 *  cn.sast.framework.result.ResultCollector
 *  cn.sast.framework.result.ResultCollector$Companion
 *  cn.sast.framework.result.ResultCollector$WhenMappings
 *  cn.sast.framework.result.ResultCollector$flush$1
 *  cn.sast.framework.result.ResultConverter
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.config.api.CheckType
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.AwaitKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.jimple.infoflow.collect.ConcurrentHashSet
 *  soot.jimple.infoflow.data.AbstractionAtSink
 *  soot.jimple.infoflow.results.DataFlowResult
 *  soot.jimple.infoflow.results.InfoflowResults
 *  soot.jimple.infoflow.solver.cfg.IInfoflowCFG
 */
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
import cn.sast.framework.result.IBuiltInAnalysisCollector;
import cn.sast.framework.result.IFlowDroidResultCollector;
import cn.sast.framework.result.IMissingSummaryReporter;
import cn.sast.framework.result.IPreAnalysisResultCollector;
import cn.sast.framework.result.IReportsVisitor;
import cn.sast.framework.result.IUTBotResultCollector;
import cn.sast.framework.result.OutputType;
import cn.sast.framework.result.PurificationReportKey;
import cn.sast.framework.result.ResultCollector;
import cn.sast.framework.result.ResultConverter;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.CheckType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.jimple.infoflow.collect.ConcurrentHashSet;
import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.results.DataFlowResult;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001cBy\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\f\u00104\u001a\b\u0012\u0004\u0012\u00020/05J\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010\n\u001a\u00020GH\u0016J\u0010\u0010C\u001a\u00020D2\u0006\u0010C\u001a\u00020/H\u0016J\u0016\u0010H\u001a\u00020D2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0IH\u0002J\u0010\u0010H\u001a\u00020D2\u0006\u0010C\u001a\u00020/H\u0002J\u0016\u0010J\u001a\u00020D2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0IH\u0016J\u000e\u0010K\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010LJ\u0010\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020OH\u0016J\u0018\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016J\u0018\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020R2\u0006\u0010W\u001a\u00020XH\u0016J\u0010\u0010Y\u001a\u00020D2\u0006\u0010Z\u001a\u00020[H\u0016J\u0016\u0010\\\u001a\u00020D2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0\u0011H\u0016J\b\u0010]\u001a\u00020DH\u0016J\u001e\u0010_\u001a\u00020D2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@\u00a2\u0006\u0002\u0010`J\b\u0010a\u001a\u00020bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000208X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b?\u0010@R\u000e\u0010^\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006d"}, d2={"Lcn/sast/framework/result/ResultCollector;", "Lcn/sast/framework/result/IFlowDroidResultCollector;", "Lcn/sast/dataflow/interprocedural/check/checker/IIPAnalysisResultCollector;", "Lcn/sast/framework/result/IUTBotResultCollector;", "Lcn/sast/framework/result/IMissingSummaryReporter;", "Lcn/sast/framework/result/IPreAnalysisResultCollector;", "Lcn/sast/framework/result/IBuiltInAnalysisCollector;", "Lcn/sast/framework/result/IReportsVisitor;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "outputDir", "Lcn/sast/common/IResDirectory;", "locator", "Lcn/sast/framework/report/ProjectFileLocator;", "collectors", "", "Lcn/sast/api/report/IResultCollector;", "outputTypes", "Lcn/sast/framework/result/OutputType;", "serializeTaintPath", "", "resultConverter", "Lcn/sast/framework/result/ResultConverter;", "coverage", "Lcn/sast/framework/report/coverage/JacocoCompoundCoverage;", "flushCoverage", "monitor", "Lcn/sast/framework/metrics/MetricsMonitor;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcom/feysh/corax/cache/analysis/SootInfoCache;Lcn/sast/common/IResDirectory;Lcn/sast/framework/report/ProjectFileLocator;Ljava/util/List;Ljava/util/List;ZLcn/sast/framework/result/ResultConverter;Lcn/sast/framework/report/coverage/JacocoCompoundCoverage;ZLcn/sast/framework/metrics/MetricsMonitor;)V", "getCoverage", "()Lcn/sast/framework/report/coverage/JacocoCompoundCoverage;", "getFlushCoverage", "()Z", "getMonitor", "()Lcn/sast/framework/metrics/MetricsMonitor;", "collectorsFlowDroid", "collectorsUTBot", "collectorsDataFlow", "collectorsIFIChecker", "collectorsFlowSensitive", "reportsVisitor", "missingSummaryReporter", "reports", "Lsoot/jimple/infoflow/collect/ConcurrentHashSet;", "Lcn/sast/api/report/Report;", "purificationReports", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcn/sast/framework/result/PurificationReportKey;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getReports", "", "getCollectors", "preAnalysis", "Lcn/sast/api/config/PreAnalysisCoroutineScope;", "getPreAnalysis", "()Lcn/sast/api/config/PreAnalysisCoroutineScope;", "setPreAnalysis", "(Lcn/sast/api/config/PreAnalysisCoroutineScope;)V", "bugTypeProvider", "Lcn/sast/dataflow/infoflow/provider/BugTypeProvider;", "getBugTypeProvider", "()Lcn/sast/dataflow/infoflow/provider/BugTypeProvider;", "bugTypeProvider$delegate", "Lkotlin/Lazy;", "report", "", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "Lcn/sast/framework/engine/PreAnalysisReportEnv;", "addReport", "", "accept", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportMissingMethod", "method", "Lsoot/SootMethod;", "onResultsAvailable", "cfg", "Lsoot/jimple/infoflow/solver/cfg/IInfoflowCFG;", "results", "Lsoot/jimple/infoflow/results/InfoflowResults;", "onResultAvailable", "icfg", "abs", "Lsoot/jimple/infoflow/data/AbstractionAtSink;", "afterAnalyze", "analysis", "Lcn/sast/dataflow/interprocedural/check/InterProceduralValueAnalysis;", "reportDataFlowBug", "addUtState", "flushing", "flushOutputType", "(Lcn/sast/api/config/MainConfig;Lcn/sast/framework/metrics/MetricsMonitor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCoverageReportWriter", "Lcn/sast/framework/report/IReportConsumer;", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nResultCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResultCollector.kt\ncn/sast/framework/result/ResultCollector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n*L\n1#1,284:1\n808#2,11:285\n808#2,11:296\n808#2,11:307\n808#2,11:318\n808#2,11:329\n808#2,11:340\n808#2,11:351\n1863#2,2:362\n1863#2,2:364\n1863#2,2:370\n1557#2:372\n1628#2,3:373\n1863#2,2:376\n1863#2,2:378\n1755#2,3:380\n1863#2,2:383\n1863#2,2:385\n1863#2,2:387\n1557#2:389\n1628#2,3:390\n1#3:366\n1#3:369\n72#4,2:367\n*S KotlinDebug\n*F\n+ 1 ResultCollector.kt\ncn/sast/framework/result/ResultCollector\n*L\n90#1:285,11\n91#1:296,11\n92#1:307,11\n93#1:318,11\n94#1:329,11\n95#1:340,11\n97#1:351,11\n118#1:362,2\n123#1:364,2\n150#1:370,2\n158#1:372\n158#1:373,3\n166#1:376,2\n172#1:378,2\n180#1:380,3\n187#1:383,2\n196#1:385,2\n205#1:387,2\n231#1:389\n231#1:390,3\n132#1:369\n132#1:367,2\n*E\n"})
public final class ResultCollector
implements IFlowDroidResultCollector,
IIPAnalysisResultCollector,
IUTBotResultCollector,
IMissingSummaryReporter,
IPreAnalysisResultCollector,
IBuiltInAnalysisCollector,
IReportsVisitor {
    @NotNull
    public static final Companion Companion = new Companion(null);
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
    @NotNull
    private final List<IFlowDroidResultCollector> collectorsFlowDroid;
    @NotNull
    private final List<IUTBotResultCollector> collectorsUTBot;
    @NotNull
    private final List<IIPAnalysisResultCollector> collectorsDataFlow;
    @NotNull
    private final List<IPreAnalysisResultCollector> collectorsIFIChecker;
    @NotNull
    private final List<IBuiltInAnalysisCollector> collectorsFlowSensitive;
    @NotNull
    private final List<IReportsVisitor> reportsVisitor;
    @NotNull
    private final List<IMissingSummaryReporter> missingSummaryReporter;
    @NotNull
    private final ConcurrentHashSet<Report> reports;
    @NotNull
    private final ConcurrentHashMap<PurificationReportKey, AtomicInteger> purificationReports;
    public PreAnalysisCoroutineScope preAnalysis;
    @NotNull
    private final Lazy bugTypeProvider$delegate;
    private boolean flushing;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ResultCollector::logger$lambda$21);

    public ResultCollector(@NotNull MainConfig mainConfig, @Nullable SootInfoCache info2, @NotNull IResDirectory outputDir, @NotNull ProjectFileLocator locator2, @NotNull List<? extends IResultCollector> collectors, @NotNull List<? extends OutputType> outputTypes, boolean serializeTaintPath, @NotNull ResultConverter resultConverter, @NotNull JacocoCompoundCoverage coverage, boolean flushCoverage2, @NotNull MetricsMonitor monitor) {
        Iterable $this$filterIsInstanceTo$iv$iv;
        Iterable $this$filterIsInstance$iv;
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)outputDir, (String)"outputDir");
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        Intrinsics.checkNotNullParameter(collectors, (String)"collectors");
        Intrinsics.checkNotNullParameter(outputTypes, (String)"outputTypes");
        Intrinsics.checkNotNullParameter((Object)resultConverter, (String)"resultConverter");
        Intrinsics.checkNotNullParameter((Object)coverage, (String)"coverage");
        Intrinsics.checkNotNullParameter((Object)monitor, (String)"monitor");
        this.mainConfig = mainConfig;
        this.info = info2;
        this.outputDir = outputDir;
        this.locator = locator2;
        this.collectors = collectors;
        this.outputTypes = outputTypes;
        this.serializeTaintPath = serializeTaintPath;
        this.resultConverter = resultConverter;
        this.coverage = coverage;
        this.flushCoverage = flushCoverage2;
        this.monitor = monitor;
        Iterable iterable = this.collectors;
        ResultCollector resultCollector = this;
        boolean $i$f$filterIsInstance = false;
        void var14_15 = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof IFlowDroidResultCollector)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        resultCollector.collectorsFlowDroid = (List)destination$iv$iv;
        $this$filterIsInstance$iv = this.collectors;
        resultCollector = this;
        $i$f$filterIsInstance = false;
        $this$filterIsInstanceTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof IUTBotResultCollector)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        resultCollector.collectorsUTBot = (List)destination$iv$iv;
        $this$filterIsInstance$iv = this.collectors;
        resultCollector = this;
        $i$f$filterIsInstance = false;
        $this$filterIsInstanceTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof IIPAnalysisResultCollector)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        resultCollector.collectorsDataFlow = (List)destination$iv$iv;
        $this$filterIsInstance$iv = this.collectors;
        resultCollector = this;
        $i$f$filterIsInstance = false;
        $this$filterIsInstanceTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof IPreAnalysisResultCollector)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        resultCollector.collectorsIFIChecker = (List)destination$iv$iv;
        $this$filterIsInstance$iv = this.collectors;
        resultCollector = this;
        $i$f$filterIsInstance = false;
        $this$filterIsInstanceTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof IBuiltInAnalysisCollector)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        resultCollector.collectorsFlowSensitive = (List)destination$iv$iv;
        $this$filterIsInstance$iv = this.collectors;
        resultCollector = this;
        $i$f$filterIsInstance = false;
        $this$filterIsInstanceTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof IReportsVisitor)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        resultCollector.reportsVisitor = (List)destination$iv$iv;
        $this$filterIsInstance$iv = this.collectors;
        resultCollector = this;
        $i$f$filterIsInstance = false;
        $this$filterIsInstanceTo$iv$iv = $this$filterIsInstance$iv;
        destination$iv$iv = new ArrayList();
        $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof IMissingSummaryReporter)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        resultCollector.missingSummaryReporter = (List)destination$iv$iv;
        this.reports = new ConcurrentHashSet();
        this.purificationReports = new ConcurrentHashMap();
        this.bugTypeProvider$delegate = LazyKt.lazy(() -> ResultCollector.bugTypeProvider_delegate$lambda$2(this));
    }

    public /* synthetic */ ResultCollector(MainConfig mainConfig, SootInfoCache sootInfoCache, IResDirectory iResDirectory, ProjectFileLocator projectFileLocator, List list, List list2, boolean bl, ResultConverter resultConverter, JacocoCompoundCoverage jacocoCompoundCoverage, boolean bl2, MetricsMonitor metricsMonitor, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x10) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((n & 0x20) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 0x40) != 0) {
            bl = true;
        }
        if ((n & 0x80) != 0) {
            resultConverter = new ResultConverter(sootInfoCache);
        }
        if ((n & 0x100) != 0) {
            jacocoCompoundCoverage = new JacocoCompoundCoverage((IProjectFileLocator)projectFileLocator, null, null, false, 14, null);
        }
        if ((n & 0x200) != 0) {
            bl2 = false;
        }
        this(mainConfig, sootInfoCache, iResDirectory, projectFileLocator, list, list2, bl, resultConverter, jacocoCompoundCoverage, bl2, metricsMonitor);
    }

    @NotNull
    public final JacocoCompoundCoverage getCoverage() {
        return this.coverage;
    }

    public final boolean getFlushCoverage() {
        return this.flushCoverage;
    }

    @NotNull
    public final MetricsMonitor getMonitor() {
        return this.monitor;
    }

    @NotNull
    public final Set<Report> getReports() {
        ResultCollector $this$getReports_u24lambda_u240 = this;
        boolean bl = false;
        $this$getReports_u24lambda_u240.flushing = true;
        return (Set)$this$getReports_u24lambda_u240.reports;
    }

    @NotNull
    public final List<IResultCollector> getCollectors() {
        return this.collectors;
    }

    @NotNull
    public final PreAnalysisCoroutineScope getPreAnalysis() {
        PreAnalysisCoroutineScope preAnalysisCoroutineScope = this.preAnalysis;
        if (preAnalysisCoroutineScope != null) {
            return preAnalysisCoroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"preAnalysis");
        return null;
    }

    public final void setPreAnalysis(@NotNull PreAnalysisCoroutineScope preAnalysisCoroutineScope) {
        Intrinsics.checkNotNullParameter((Object)preAnalysisCoroutineScope, (String)"<set-?>");
        this.preAnalysis = preAnalysisCoroutineScope;
    }

    private final BugTypeProvider getBugTypeProvider() {
        Lazy lazy = this.bugTypeProvider$delegate;
        return (BugTypeProvider)lazy.getValue();
    }

    public void report(@NotNull CheckType checkType, @NotNull PreAnalysisReportEnv info2) {
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter((Object)info2, (String)"info");
        Iterable $this$forEach$iv = this.collectorsIFIChecker;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IPreAnalysisResultCollector it = (IPreAnalysisResultCollector)element$iv;
            boolean bl = false;
            it.report(checkType, info2);
        }
        this.addReport(this.resultConverter.getReport(checkType, info2));
    }

    public void report(@NotNull Report report) {
        Intrinsics.checkNotNullParameter((Object)report, (String)"report");
        Iterable $this$forEach$iv = this.collectorsFlowSensitive;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IBuiltInAnalysisCollector it = (IBuiltInAnalysisCollector)element$iv;
            boolean bl = false;
            it.report(report);
        }
        this.addReport(report);
    }

    private final void addReport(Collection<Report> reports) {
        if (!(!this.flushing)) {
            boolean $i$a$-require-ResultCollector$addReport$22 = false;
            String $i$a$-require-ResultCollector$addReport$22 = "internal error: emit bug reports when flush report";
            throw new IllegalArgumentException($i$a$-require-ResultCollector$addReport$22.toString());
        }
        for (Report report : reports) {
            if (!this.mainConfig.isEnable(report.getCheckType())) continue;
            PurificationReportKey key2 = new PurificationReportKey(report.getBugResFile(), report.getRegion().startLine, report.getCheck_name(), (BugPathEvent)CollectionsKt.first((List)report.getPathEvents()));
            ConcurrentMap $this$getOrPut$iv = this.purificationReports;
            boolean $i$f$getOrPut = false;
            Object object = $this$getOrPut$iv.get(key2);
            if (object == null) {
                boolean bl = false;
                AtomicInteger default$iv = new AtomicInteger(0);
                boolean bl2 = false;
                object = $this$getOrPut$iv.putIfAbsent(key2, default$iv);
                if (object == null) {
                    object = default$iv;
                }
            }
            AtomicInteger count = (AtomicInteger)object;
            count.getAndUpdate((IntUnaryOperator)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    private final void addReport(Report report) {
        this.addReport((Collection)CollectionsKt.listOf((Object)report));
    }

    public void accept(@NotNull Collection<Report> reports) {
        Intrinsics.checkNotNullParameter(reports, (String)"reports");
        Iterable $this$forEach$iv = this.reportsVisitor;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IReportsVisitor it = (IReportsVisitor)element$iv;
            boolean bl = false;
            it.accept(reports);
        }
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public Object flush(@NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof flush.1)) ** GOTO lbl-1000
        var18_2 = $completion;
        if ((var18_2.label & -2147483648) != 0) {
            var18_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var19_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                this.monitor.addAnalyzeFinishHook(new Thread((Runnable)new /* Unavailable Anonymous Inner Class!! */));
                it = var3_5 = BuildersKt.launch$default((CoroutineScope)CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)Dispatchers.getDefault())), null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null);
                $i$a$-also-ResultCollector$flush$job1$2 = false;
                it.start();
                job1 = var3_5;
                $this$map$iv = this.collectors;
                $i$f$map = false;
                var6_10 = $this$map$iv;
                destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (T item$iv$iv : $this$mapTo$iv$iv) {
                    var11_16 = (IResultCollector)item$iv$iv;
                    var16_21 = destination$iv$iv;
                    $i$a$-map-ResultCollector$flush$jobs2$1 = false;
                    it = var13_18 = BuildersKt.launch$default((CoroutineScope)CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)Dispatchers.getDefault())), null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null);
                    $i$a$-also-ResultCollector$flush$jobs2$1$2 = false;
                    it.start();
                    var16_21.add(var13_18);
                }
                jobs2 = (List)destination$iv$iv;
                it = var5_8 = BuildersKt.launch$default((CoroutineScope)CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)Dispatchers.getDefault())), null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null);
                $i$a$-also-ResultCollector$flush$job3$2 = false;
                it.start();
                job3 = var5_8;
                $continuation.L$0 = jobs2;
                $continuation.L$1 = job3;
                $continuation.label = 1;
                v0 = job1.join((Continuation)$continuation);
                if (v0 == var19_4) {
                    return var19_4;
                }
                ** GOTO lbl53
            }
            case 1: {
                job3 = (Job)$continuation.L$1;
                jobs2 = (List)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl53:
                // 2 sources

                $continuation.L$0 = job3;
                $continuation.L$1 = null;
                $continuation.label = 2;
                v1 = AwaitKt.joinAll((Collection)jobs2, (Continuation)$continuation);
                if (v1 == var19_4) {
                    return var19_4;
                }
                ** GOTO lbl64
            }
            case 2: {
                job3 = (Job)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl64:
                // 2 sources

                $continuation.L$0 = null;
                $continuation.label = 3;
                v2 = job3.join((Continuation)$continuation);
                if (v2 == var19_4) {
                    return var19_4;
                }
                ** GOTO lbl73
            }
            case 3: {
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl73:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public void reportMissingMethod(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Iterable $this$forEach$iv = this.missingSummaryReporter;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IMissingSummaryReporter it = (IMissingSummaryReporter)element$iv;
            boolean bl = false;
            it.reportMissingMethod(method);
        }
    }

    public void onResultsAvailable(@NotNull IInfoflowCFG cfg, @NotNull InfoflowResults results) {
        Intrinsics.checkNotNullParameter((Object)cfg, (String)"cfg");
        Intrinsics.checkNotNullParameter((Object)results, (String)"results");
        Iterable $this$forEach$iv = this.collectorsFlowDroid;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IFlowDroidResultCollector it = (IFlowDroidResultCollector)element$iv;
            boolean bl = false;
            it.onResultsAvailable(cfg, results);
        }
        Set set = results.getResultSet();
        if (set == null) {
            set = SetsKt.emptySet();
        }
        for (Object e : set) {
            Intrinsics.checkNotNullExpressionValue(e, (String)"next(...)");
            DataFlowResult result = (DataFlowResult)e;
            this.addReport((Collection)this.resultConverter.getReport(cfg, result, this.getBugTypeProvider(), this.serializeTaintPath));
        }
    }

    public boolean onResultAvailable(@NotNull IInfoflowCFG icfg, @NotNull AbstractionAtSink abs) {
        boolean bl;
        block3: {
            Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
            Intrinsics.checkNotNullParameter((Object)abs, (String)"abs");
            Iterable $this$any$iv = this.collectorsFlowDroid;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    IFlowDroidResultCollector it = (IFlowDroidResultCollector)element$iv;
                    boolean bl2 = false;
                    if (!(!it.onResultAvailable(icfg, abs))) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        boolean stop = bl;
        return !stop;
    }

    public void afterAnalyze(@NotNull InterProceduralValueAnalysis analysis2) {
        Intrinsics.checkNotNullParameter((Object)analysis2, (String)"analysis");
        Iterable $this$forEach$iv = this.collectorsDataFlow;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IIPAnalysisResultCollector it = (IIPAnalysisResultCollector)element$iv;
            boolean bl = false;
            it.afterAnalyze(analysis2);
        }
    }

    public void reportDataFlowBug(@NotNull List<Report> reports) {
        Intrinsics.checkNotNullParameter(reports, (String)"reports");
        Iterable $this$forEach$iv = this.collectorsDataFlow;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IIPAnalysisResultCollector it = (IIPAnalysisResultCollector)element$iv;
            boolean bl = false;
            it.reportDataFlowBug(reports);
        }
        this.addReport((Collection)reports);
    }

    public void addUtState() {
        Iterable $this$forEach$iv = this.collectorsUTBot;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IUTBotResultCollector it = (IUTBotResultCollector)element$iv;
            boolean bl = false;
            it.addUtState();
        }
    }

    /*
     * WARNING - void declaration
     */
    private final Object flushOutputType(MainConfig mainConfig, MetricsMonitor monitor, Continuation<? super Unit> $completion) {
        Collection<IReportConsumer> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Set outputTypesLocal = CollectionsKt.toMutableSet((Iterable)this.outputTypes);
        if (outputTypesLocal.isEmpty()) {
            logger.warn(ResultCollector::flushOutputType$lambda$18);
            outputTypesLocal.add(OutputType.PLIST);
            outputTypesLocal.add(OutputType.SARIF);
        }
        if (this.flushCoverage) {
            outputTypesLocal.add(OutputType.Coverage);
        }
        Iterable iterable = outputTypesLocal;
        JacocoCompoundCoverage jacocoCompoundCoverage = this.coverage;
        IProjectFileLocator iProjectFileLocator = (IProjectFileLocator)this.locator;
        MainConfig mainConfig2 = mainConfig;
        ReportConverter reportConverter = new ReportConverter(mainConfig, null, 2, null);
        boolean $i$f$map = false;
        void var7_11 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void type;
            OutputType outputType = (OutputType)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1 -> (IReportConsumer)new PlistDiagnostics(mainConfig, this.info, this.outputDir.resolve(type.getDisplayName()).toDirectory());
                case 2 -> (IReportConsumer)new SarifDiagnostics(this.outputDir.resolve(type.getDisplayName()).toDirectory(), null, 2, null);
                case 3 -> (IReportConsumer)new SarifDiagnosticsPack(this.outputDir.resolve(type.getDisplayName()).toDirectory(), null, null, null, null, 30, null);
                case 4 -> (IReportConsumer)new SarifDiagnosticsCopySrc(this.outputDir.resolve(type.getDisplayName()).toDirectory(), null, null, null, null, 30, null);
                case 5 -> {
                    SqliteDiagnostics var14_18;
                    SqliteDiagnostics it = var14_18 = ResultCollector.flushOutputType$newSqliteDiagnostics((MainConfig)mainConfig, (ResultCollector)this, (MetricsMonitor)monitor);
                    boolean $i$a$-also-ResultCollector$flushOutputType$3$1 = false;
                    monitor.addAnalyzeFinishHook(new Thread((Runnable)new /* Unavailable Anonymous Inner Class!! */));
                    yield (IReportConsumer)var14_18;
                }
                case 6 -> this.getCoverageReportWriter();
                default -> throw new NoWhenBranchMatchedException();
            });
        }
        collection = (List)destination$iv$iv;
        Object object = reportConverter.flush(mainConfig2, iProjectFileLocator, jacocoCompoundCoverage, (List)collection, (Collection)this.getReports(), this.outputDir, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final IReportConsumer getCoverageReportWriter() {
        return (IReportConsumer)new /* Unavailable Anonymous Inner Class!! */;
    }

    private static final BugTypeProvider bugTypeProvider_delegate$lambda$2(ResultCollector this$0) {
        BugTypeProvider bugTypeProvider;
        Thread.interrupted();
        BugTypeProvider $this$bugTypeProvider_delegate_u24lambda_u242_u24lambda_u241 = bugTypeProvider = new BugTypeProvider(this$0.mainConfig, this$0.getPreAnalysis());
        boolean bl = false;
        $this$bugTypeProvider_delegate_u24lambda_u242_u24lambda_u241.init();
        return bugTypeProvider;
    }

    private static final Object flushOutputType$lambda$18() {
        return "not special any output types! Will use PLIST and SARIF formats and SQLITE for generating report";
    }

    private static final SqliteDiagnostics flushOutputType$newSqliteDiagnostics(MainConfig $mainConfig, ResultCollector this$0, MetricsMonitor $monitor) {
        return Companion.newSqliteDiagnostics($mainConfig, this$0.info, this$0.outputDir, $monitor);
    }

    private static final Unit logger$lambda$21() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ ConcurrentHashSet access$getReports$p(ResultCollector $this) {
        return $this.reports;
    }

    public static final /* synthetic */ IResDirectory access$getOutputDir$p(ResultCollector $this) {
        return $this.outputDir;
    }

    public static final /* synthetic */ Object access$flushOutputType(ResultCollector $this, MainConfig mainConfig, MetricsMonitor monitor, Continuation $completion) {
        return $this.flushOutputType(mainConfig, monitor, $completion);
    }

    public static final /* synthetic */ MainConfig access$getMainConfig$p(ResultCollector $this) {
        return $this.mainConfig;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ SqliteDiagnostics access$flushOutputType$newSqliteDiagnostics(MainConfig $mainConfig, ResultCollector this$0, MetricsMonitor $monitor) {
        return ResultCollector.flushOutputType$newSqliteDiagnostics((MainConfig)$mainConfig, (ResultCollector)this$0, (MetricsMonitor)$monitor);
    }
}

