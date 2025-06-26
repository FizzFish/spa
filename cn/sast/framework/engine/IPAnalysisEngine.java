/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettings
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.PreAnalysisCoroutineScope
 *  cn.sast.api.config.PreAnalysisCoroutineScopeKt
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.CoverData
 *  cn.sast.api.report.CoverTaint
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.ICoverageCollector
 *  cn.sast.api.util.OthersKt
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.dataflow.infoflow.svfa.AP
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis
 *  cn.sast.dataflow.interprocedural.check.PathCompanionKt
 *  cn.sast.dataflow.interprocedural.check.PointsToGraph
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModeling
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModelingKt
 *  cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValues
 *  cn.sast.dataflow.interprocedural.override.lang.Debug
 *  cn.sast.dataflow.interprocedural.override.lang.WEnum
 *  cn.sast.dataflow.interprocedural.override.lang.WMath
 *  cn.sast.dataflow.interprocedural.override.lang.WNumber
 *  cn.sast.dataflow.interprocedural.override.lang.WObject
 *  cn.sast.dataflow.interprocedural.override.lang.WString
 *  cn.sast.dataflow.interprocedural.override.lang.WStringBuilder
 *  cn.sast.dataflow.interprocedural.override.lang.WStringCoding
 *  cn.sast.dataflow.interprocedural.override.lang.WStringLatin1
 *  cn.sast.dataflow.interprocedural.override.lang.WSystem
 *  cn.sast.dataflow.interprocedural.override.lang.util.WArrayList
 *  cn.sast.dataflow.interprocedural.override.lang.util.WArrays
 *  cn.sast.dataflow.interprocedural.override.lang.util.WHashMap
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.engine.IPAnalysisEngine
 *  cn.sast.framework.engine.IPAnalysisEngine$Companion
 *  cn.sast.framework.engine.IPAnalysisEngine$analyze$1
 *  cn.sast.framework.engine.IPAnalysisEngine$dumpDot$plot$1
 *  cn.sast.framework.engine.IPAnalysisEngine$runAnalysisInScene$1
 *  cn.sast.framework.engine.IPAnalysisEngineKt
 *  cn.sast.framework.engine.PreAnalysisImpl
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.report.IWrapperFileGenerator
 *  cn.sast.framework.report.NullWrapperFileGenerator
 *  cn.sast.framework.report.ProjectFileLocator
 *  cn.sast.framework.result.IMissingSummaryReporter
 *  cn.sast.framework.result.IPreAnalysisResultCollector
 *  cn.sast.framework.result.ResultCollector
 *  cn.sast.graph.GraphPlot
 *  cn.sast.graph.GraphPlotKt
 *  cn.sast.graph.HashMutableDirectedGraph
 *  cn.sast.idfa.analysis.UsefulMetrics
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.config.api.PreAnalysisApi
 *  com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.SerializersKt
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JvmStreamsKt
 *  kotlinx.serialization.modules.SerializersModule
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.LoggerWithLogMethod
 *  org.utbot.common.LoggingKt
 *  org.utbot.common.Maybe
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Unit
 *  soot.Value
 *  soot.ValueBox
 *  soot.jimple.toolkits.callgraph.Edge
 *  soot.util.dot.DotGraph
 */
package cn.sast.framework.engine;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.config.MainConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import cn.sast.api.config.PreAnalysisCoroutineScopeKt;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.CoverData;
import cn.sast.api.report.CoverTaint;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.ICoverageCollector;
import cn.sast.api.util.OthersKt;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.dataflow.infoflow.svfa.AP;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis;
import cn.sast.dataflow.interprocedural.check.PathCompanionKt;
import cn.sast.dataflow.interprocedural.check.PointsToGraph;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModeling;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModelingKt;
import cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet;
import cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValues;
import cn.sast.dataflow.interprocedural.override.lang.Debug;
import cn.sast.dataflow.interprocedural.override.lang.WEnum;
import cn.sast.dataflow.interprocedural.override.lang.WMath;
import cn.sast.dataflow.interprocedural.override.lang.WNumber;
import cn.sast.dataflow.interprocedural.override.lang.WObject;
import cn.sast.dataflow.interprocedural.override.lang.WString;
import cn.sast.dataflow.interprocedural.override.lang.WStringBuilder;
import cn.sast.dataflow.interprocedural.override.lang.WStringCoding;
import cn.sast.dataflow.interprocedural.override.lang.WStringLatin1;
import cn.sast.dataflow.interprocedural.override.lang.WSystem;
import cn.sast.dataflow.interprocedural.override.lang.util.WArrayList;
import cn.sast.dataflow.interprocedural.override.lang.util.WArrays;
import cn.sast.dataflow.interprocedural.override.lang.util.WHashMap;
import cn.sast.framework.SootCtx;
import cn.sast.framework.engine.IPAnalysisEngine;
import cn.sast.framework.engine.IPAnalysisEngineKt;
import cn.sast.framework.engine.PreAnalysisImpl;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.report.IWrapperFileGenerator;
import cn.sast.framework.report.NullWrapperFileGenerator;
import cn.sast.framework.report.ProjectFileLocator;
import cn.sast.framework.result.IMissingSummaryReporter;
import cn.sast.framework.result.IPreAnalysisResultCollector;
import cn.sast.framework.result.ResultCollector;
import cn.sast.graph.GraphPlot;
import cn.sast.graph.GraphPlotKt;
import cn.sast.graph.HashMutableDirectedGraph;
import cn.sast.idfa.analysis.UsefulMetrics;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import java.io.Closeable;
import java.io.OutputStream;
import java.lang.invoke.LambdaMetafactory;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JvmStreamsKt;
import kotlinx.serialization.modules.SerializersModule;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.LoggerWithLogMethod;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.toolkits.callgraph.Edge;
import soot.util.dot.DotGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 @2\u00020\u0001:\u0001@B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00060\u0005\u00a2\u0006\u0004\b\t\u0010\nJh\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u001f2\u0006\u0010 \u001a\u00020!JF\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u001cJf\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110/2\u0006\u00101\u001a\u000202H\u0086@\u00a2\u0006\u0002\u00103J>\u00104\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u00105\u001a\u0002062\u0006\u0010+\u001a\u0002072\u0006\u00101\u001a\u000202H\u0086@\u00a2\u0006\u0002\u00108J\u0018\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010>\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\u000e\u0010?\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2={"Lcn/sast/framework/engine/IPAnalysisEngine;", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "summaries", "", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "(Lcn/sast/api/config/MainConfig;Ljava/util/List;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "getSummaries", "()Ljava/util/List;", "directedGraph", "Lcn/sast/graph/HashMutableDirectedGraph;", "Lsoot/SootMethod;", "coverTaint", "", "Lcn/sast/api/report/ICoverageCollector;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "method", "node", "Lsoot/Unit;", "succ", "out", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "value", "obj", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "visitElement", "", "runAnalysisInScene", "locator", "Lcn/sast/framework/report/ProjectFileLocator;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "soot", "Lcn/sast/framework/SootCtx;", "preAnalysisResult", "Lcn/sast/framework/result/IPreAnalysisResultCollector;", "result", "Lcn/sast/dataflow/interprocedural/check/checker/IIPAnalysisResultCollector;", "coverage", "entries", "", "methodsMustAnalyze", "missWrapper", "Lcn/sast/framework/result/IMissingSummaryReporter;", "(Lcn/sast/framework/report/ProjectFileLocator;Lcom/feysh/corax/cache/analysis/SootInfoCache;Lcn/sast/framework/SootCtx;Lcn/sast/framework/result/IPreAnalysisResultCollector;Lcn/sast/dataflow/interprocedural/check/checker/IIPAnalysisResultCollector;Lcn/sast/api/report/ICoverageCollector;Ljava/util/Collection;Ljava/util/Collection;Lcn/sast/framework/result/IMissingSummaryReporter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyze", "provider", "Lcn/sast/framework/entries/IEntryPointProvider;", "Lcn/sast/framework/result/ResultCollector;", "(Lcn/sast/framework/report/ProjectFileLocator;Lcom/feysh/corax/cache/analysis/SootInfoCache;Lcn/sast/framework/SootCtx;Lcn/sast/framework/entries/IEntryPointProvider;Lcn/sast/framework/result/ResultCollector;Lcn/sast/framework/result/IMissingSummaryReporter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dumpJson", "output", "Lcn/sast/common/IResDirectory;", "name", "", "dumpDot", "dump", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nIPAnalysisEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IPAnalysisEngine.kt\ncn/sast/framework/engine/IPAnalysisEngine\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Logging.kt\norg/utbot/common/LoggingKt\n+ 5 JvmStreams.kt\nkotlinx/serialization/json/JvmStreamsKt\n*L\n1#1,344:1\n1557#2:345\n1628#2,3:346\n1619#2:349\n1863#2:350\n1864#2:352\n1620#2:353\n1863#2,2:354\n1557#2:356\n1628#2,3:357\n774#2:360\n865#2,2:361\n774#2:363\n865#2,2:364\n1557#2:366\n1628#2,3:367\n774#2:370\n865#2,2:371\n774#2:373\n865#2,2:374\n1557#2:376\n1628#2,3:377\n774#2:380\n865#2,2:381\n1557#2:383\n1628#2,3:384\n1#3:351\n49#4,24:387\n42#5:411\n*S KotlinDebug\n*F\n+ 1 IPAnalysisEngine.kt\ncn/sast/framework/engine/IPAnalysisEngine\n*L\n143#1:345\n143#1:346,3\n143#1:349\n143#1:350\n143#1:352\n143#1:353\n245#1:354,2\n259#1:356\n259#1:357,3\n260#1:360\n260#1:361,2\n261#1:363\n261#1:364,2\n262#1:366\n262#1:367,3\n263#1:370\n263#1:371,2\n264#1:373\n264#1:374,2\n265#1:376\n265#1:377,3\n267#1:380\n267#1:381,2\n268#1:383\n268#1:384,3\n143#1:351\n281#1:387,24\n303#1:411\n*E\n"})
public final class IPAnalysisEngine {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final List<SummaryHandlePackage<IValue>> summaries;
    @NotNull
    private final HashMutableDirectedGraph<SootMethod> directedGraph;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(IPAnalysisEngine::logger$lambda$18);

    public IPAnalysisEngine(@NotNull MainConfig mainConfig, @NotNull List<? extends SummaryHandlePackage<IValue>> summaries) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter(summaries, (String)"summaries");
        this.mainConfig = mainConfig;
        this.summaries = summaries;
        this.directedGraph = new HashMutableDirectedGraph();
    }

    public /* synthetic */ IPAnalysisEngine(MainConfig mainConfig, List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            list = new ArrayList();
        }
        this(mainConfig, list);
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final List<SummaryHandlePackage<IValue>> getSummaries() {
        return this.summaries;
    }

    public final void coverTaint(@NotNull ICoverageCollector $this$coverTaint, @NotNull AbstractHeapFactory<IValue> hf, @NotNull SootMethod method, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<IValue> out, @NotNull Object value, @NotNull CompanionV<IValue> obj, boolean visitElement) {
        ImmutableElementSet taintSet;
        Intrinsics.checkNotNullParameter((Object)$this$coverTaint, (String)"<this>");
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        Intrinsics.checkNotNullParameter(out, (String)"out");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Intrinsics.checkNotNullParameter(obj, (String)"obj");
        IValue actual = PathCompanionKt.getBindDelegate(obj);
        IData iData = out.getValueData((Object)actual, CheckerModelingKt.getKeyTaintProperty());
        ImmutableElementSet immutableElementSet = taintSet = iData instanceof ImmutableElementSet ? (ImmutableElementSet)iData : null;
        if (taintSet != null && !taintSet.isEmpty()) {
            $this$coverTaint.cover((CoverData)new CoverTaint(method, node, value));
        }
        if (visitElement) {
            Object object;
            ObjectValues mapValues;
            ObjectValues elements;
            Object e2;
            IArrayHeapKV array;
            IData iData2 = out.getValueData((Object)actual, (Object)BuiltInModelT.Array);
            IArrayHeapKV iArrayHeapKV = array = iData2 instanceof IArrayHeapKV ? (IArrayHeapKV)iData2 : null;
            if (array != null) {
                for (Object e2 : array.getElement(hf)) {
                    this.coverTaint($this$coverTaint, hf, method, node, succ, out, value, (CompanionV)e2, false);
                }
            }
            ObjectValues objectValues = elements = (e2 = out.getValueData((Object)actual, (Object)BuiltInModelT.Element)) instanceof ObjectValues ? (ObjectValues)e2 : null;
            if (elements != null) {
                for (CompanionV e3 : elements.getValues()) {
                    this.coverTaint($this$coverTaint, hf, method, node, succ, out, value, e3, false);
                }
            }
            ObjectValues objectValues2 = mapValues = (object = out.getValueData((Object)actual, (Object)BuiltInModelT.MapValues)) instanceof ObjectValues ? (ObjectValues)object : null;
            if (mapValues != null) {
                for (CompanionV e4 : mapValues.getValues()) {
                    this.coverTaint($this$coverTaint, hf, method, node, succ, out, value, e4, false);
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void coverTaint(@NotNull ICoverageCollector $this$coverTaint, @NotNull AbstractHeapFactory<IValue> hf, @NotNull SootMethod method, @NotNull Unit node, @NotNull Unit succ, @NotNull IFact<IValue> out) {
        void destination$iv;
        void $this$mapNotNullTo$iv;
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$coverTaint, (String)"<this>");
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        Intrinsics.checkNotNullParameter(out, (String)"out");
        if (!out.isValid()) {
            return;
        }
        List list = node.getUseAndDefBoxes();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getUseAndDefBoxes(...)");
        Iterable $this$map$iv = list;
        boolean $i$f$map22 = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ValueBox valueBox = (ValueBox)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getValue());
        }
        $this$map$iv = (List)destination$iv$iv;
        Collection $i$f$map22 = new LinkedHashSet();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv = $this$mapNotNullTo$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv.iterator();
        while (iterator2.hasNext()) {
            AP it$iv;
            Object element$iv$iv;
            Object element$iv = element$iv$iv = iterator2.next();
            boolean bl = false;
            Value it = (Value)element$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull((Object)it);
            if (AP.Companion.get(it) == null) continue;
            boolean bl3 = false;
            destination$iv.add(it$iv);
        }
        Set accessPaths = (Set)destination$iv;
        PointsToGraph cfr_ignored_0 = (PointsToGraph)out;
        for (AP accessPath : accessPaths) {
            if (accessPath.getField() != null) continue;
            IHeapValues objects = ((PointsToGraph)out).getTargets((Object)accessPath.getValue());
            for (CompanionV obj : objects) {
                this.coverTaint($this$coverTaint, hf, method, node, succ, out, (Object)accessPath.getValue(), obj, true);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public final Object runAnalysisInScene(@NotNull ProjectFileLocator var1_1, @NotNull SootInfoCache var2_2, @NotNull SootCtx var3_3, @NotNull IPreAnalysisResultCollector var4_4, @NotNull IIPAnalysisResultCollector var5_5, @Nullable ICoverageCollector var6_6, @NotNull Collection<? extends SootMethod> var7_7, @NotNull Collection<? extends SootMethod> var8_8, @NotNull IMissingSummaryReporter var9_9, @NotNull Continuation<? super kotlin.Unit> $completion) {
        if (!($completion instanceof runAnalysisInScene.1)) ** GOTO lbl-1000
        var32_11 = $completion;
        if ((var32_11.label & -2147483648) != 0) {
            var32_11.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var33_13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                vg = new IVGlobal(null, 1, null);
                analysis = new /* Unavailable Anonymous Inner Class!! */;
                analysis.setDataFlowInterProceduralCalleeTimeOut(ExtSettings.INSTANCE.getDataFlowInterProceduralCalleeTimeOut());
                analysis.setDataFlowInterProceduralCalleeDepChainMaxNum(ExtSettings.INSTANCE.getDataFlowInterProceduralCalleeDepChainMaxNum());
                analysis.setDirectedGraph(this.directedGraph);
                analysis.setNumberThreads(this.mainConfig.getParallelsNum());
                analysis.setStaticFieldTrackingMode(this.mainConfig.getStaticFieldTrackingMode());
                apponly = this.mainConfig.getApponly();
                analysis.setAnalyzeLibraryClasses(apponly == false);
                analysis.setNeedAnalyze((Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, runAnalysisInScene$lambda$2(boolean cn.sast.framework.report.ProjectFileLocator soot.SootMethod ), (Lsoot/SootMethod;)Ljava/lang/Boolean;)((boolean)(apponly != false), (ProjectFileLocator)locator));
                v0 = (IProjectFileLocator)locator;
                v1 = soot.getSootMethodCallGraph();
                var15_17 = Scene.v();
                Intrinsics.checkNotNullExpressionValue((Object)var15_17, (String)"v(...)");
                preAnalysis = new PreAnalysisImpl(this.mainConfig, v0, v1, (SootInfoCache)info, (IPreAnalysisResultCollector)preAnalysisResult, var15_17);
                checker = new CheckerModeling(this.mainConfig, analysis.getIcfg(), (PreAnalysisApi)preAnalysis);
                $continuation.L$0 = this;
                $continuation.L$1 = result;
                $continuation.L$2 = entries;
                $continuation.L$3 = methodsMustAnalyze;
                $continuation.L$4 = missWrapper;
                $continuation.L$5 = analysis;
                $continuation.L$6 = checker;
                $continuation.label = 1;
                v2 = PreAnalysisCoroutineScopeKt.processAIAnalysisUnits((AIAnalysisBaseImpl)((AIAnalysisBaseImpl)checker), (PreAnalysisCoroutineScope)((PreAnalysisCoroutineScope)preAnalysis), (Continuation)$continuation);
                if (v2 == var33_13) {
                    return var33_13;
                }
                ** GOTO lbl50
            }
            case 1: {
                checker = (CheckerModeling)$continuation.L$6;
                analysis = $continuation.L$5;
                missWrapper = (IMissingSummaryReporter)$continuation.L$4;
                methodsMustAnalyze = (Collection)$continuation.L$3;
                entries = (Collection)$continuation.L$2;
                result = (IIPAnalysisResultCollector)$continuation.L$1;
                this = (IPAnalysisEngine)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl50:
                // 2 sources

                var16_19 = new SummaryHandlePackage[]{checker, Debug.Companion.v(), WSystem.Companion.v(), WMath.Companion.v(), WArrays.Companion.v(), WHashMap.Companion.v(), WArrayList.Companion.v(), WString.Companion.v(), WStringLatin1.Companion.v(), WStringCoding.Companion.v(analysis.getHf().getVg()), WNumber.Companion.v(), WStringBuilder.Companion.v(), WObject.Companion.v(), WEnum.Companion.v()};
                $this$forEach$iv = CollectionsKt.listOf((Object[])var16_19);
                var30_20 = this.summaries;
                $i$f$forEach = false;
                for (T element$iv : $this$forEach$iv) {
                    it = (SummaryHandlePackage)element$iv;
                    $i$a$-forEach-IPAnalysisEngine$runAnalysisInScene$3 = false;
                    analysis.getSummaries().add(it);
                }
                CollectionsKt.plus((Collection)var30_20, (Object)kotlin.Unit.INSTANCE);
                UsefulMetrics.Companion.getMetrics().setWarningThreshold(this.mainConfig.getMemoryThreshold());
                entriesVar = this.mainConfig.InterProceduralIncrementalAnalysisFilter(entries);
                methodsMustAnalyzeVar = this.mainConfig.InterProceduralIncrementalAnalysisFilter(methodsMustAnalyze);
                System.gc();
                analysis.doAnalysis(entriesVar, methodsMustAnalyzeVar);
                result.afterAnalyze((InterProceduralValueAnalysis)analysis);
                v3 = this.mainConfig.getMonitor();
                projectMetrics /* !! */  = v3 != null ? v3.getProjectMetrics() : null;
                v4 /* !! */  = projectMetrics /* !! */ ;
                if (v4 /* !! */  != null && (v4 /* !! */  = v4 /* !! */ .getAnalyzedMethodEntries()) != null) {
                    var20_25 = (Collection)v4 /* !! */ ;
                    $this$map$iv = entriesVar;
                    $i$f$map = false;
                    var23_32 = $this$map$iv;
                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    $i$f$mapTo = false;
                    for (T item$iv$iv : $this$mapTo$iv$iv) {
                        var28_37 = (SootMethod)item$iv$iv;
                        var30_20 = destination$iv$iv;
                        $i$a$-map-IPAnalysisEngine$runAnalysisInScene$4 = false;
                        var30_20.add(it.getSignature());
                    }
                    $this$map$iv = (List)destination$iv$iv;
                    CollectionsKt.addAll((Collection)var20_25, (Iterable)$this$map$iv);
                }
                if ((v5 /* !! */  = projectMetrics /* !! */ ) != null && (v5 /* !! */  = v5 /* !! */ .getAnalyzedApplicationMethods()) != null) {
                    var20_25 = (Collection)v5 /* !! */ ;
                    $this$filter$iv = (Iterable)analysis.getReachableMethods();
                    $i$f$filter = false;
                    $this$mapTo$iv$iv = $this$filter$iv;
                    destination$iv$iv = new ArrayList<E>();
                    $i$f$filterTo = false;
                    for (T element$iv$iv : $this$filterTo$iv$iv) {
                        it = (SootMethod)element$iv$iv;
                        $i$a$-filter-IPAnalysisEngine$runAnalysisInScene$5 = false;
                        v6 = it.getDeclaringClass();
                        if (!(v6 != null ? v6.isApplicationClass() : false)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$filter$iv = (List)destination$iv$iv;
                    $i$f$filter = false;
                    $this$filterTo$iv$iv = $this$filter$iv;
                    destination$iv$iv = new ArrayList<E>();
                    $i$f$filterTo = false;
                    for (T element$iv$iv : $this$filterTo$iv$iv) {
                        it = (SootMethod)element$iv$iv;
                        $i$a$-filter-IPAnalysisEngine$runAnalysisInScene$6 = false;
                        v7 = it.getDeclaringClass();
                        Intrinsics.checkNotNullExpressionValue((Object)v7, (String)"getDeclaringClass(...)");
                        if (!(OthersKt.isSyntheticComponent((SootClass)v7) == false && it.isAbstract() == false)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$map$iv = (List)destination$iv$iv;
                    $i$f$map = false;
                    $this$filterTo$iv$iv = $this$map$iv;
                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    $i$f$mapTo = false;
                    for (T item$iv$iv : $this$mapTo$iv$iv) {
                        it = (SootMethod)item$iv$iv;
                        var30_20 = destination$iv$iv;
                        $i$a$-map-IPAnalysisEngine$runAnalysisInScene$7 = false;
                        var30_20.add(it.getSignature());
                    }
                    $this$map$iv = (List)destination$iv$iv;
                    CollectionsKt.addAll((Collection)var20_25, (Iterable)$this$map$iv);
                }
                if ((v8 /* !! */  = projectMetrics /* !! */ ) != null && (v8 /* !! */  = v8 /* !! */ .getAnalyzedLibraryMethods()) != null) {
                    var20_25 = (Collection)v8 /* !! */ ;
                    $this$filter$iv = (Iterable)analysis.getReachableMethods();
                    $i$f$filter = false;
                    $this$mapTo$iv$iv = $this$filter$iv;
                    destination$iv$iv = new ArrayList<E>();
                    $i$f$filterTo = false;
                    for (T element$iv$iv : $this$filterTo$iv$iv) {
                        it = (SootMethod)element$iv$iv;
                        $i$a$-filter-IPAnalysisEngine$runAnalysisInScene$8 = false;
                        v9 = it.getDeclaringClass();
                        if (!(v9 != null ? v9.isLibraryClass() : false)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$filter$iv = (List)destination$iv$iv;
                    $i$f$filter = false;
                    $this$filterTo$iv$iv = $this$filter$iv;
                    destination$iv$iv = new ArrayList<E>();
                    $i$f$filterTo = false;
                    for (T element$iv$iv : $this$filterTo$iv$iv) {
                        it = (SootMethod)element$iv$iv;
                        $i$a$-filter-IPAnalysisEngine$runAnalysisInScene$9 = false;
                        v10 = it.getDeclaringClass();
                        Intrinsics.checkNotNullExpressionValue((Object)v10, (String)"getDeclaringClass(...)");
                        if (!(OthersKt.isSyntheticComponent((SootClass)v10) == false && it.isAbstract() == false)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$map$iv = (List)destination$iv$iv;
                    $i$f$map = false;
                    $this$filterTo$iv$iv = $this$map$iv;
                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    $i$f$mapTo = false;
                    for (T item$iv$iv : $this$mapTo$iv$iv) {
                        it = (SootMethod)item$iv$iv;
                        var30_20 = destination$iv$iv;
                        $i$a$-map-IPAnalysisEngine$runAnalysisInScene$10 = false;
                        var30_20.add(it.getSignature());
                    }
                    $this$map$iv = (List)destination$iv$iv;
                    CollectionsKt.addAll((Collection)var20_25, (Iterable)$this$map$iv);
                }
                if ((v11 /* !! */  = projectMetrics /* !! */ ) != null && (v11 /* !! */  = v11 /* !! */ .getAnalyzedClasses()) != null) {
                    var20_25 = (Collection)v11 /* !! */ ;
                    $this$filter$iv = (Iterable)analysis.getReachableMethods();
                    $i$f$filter = false;
                    $this$mapTo$iv$iv = $this$filter$iv;
                    destination$iv$iv = new ArrayList<E>();
                    $i$f$filterTo = false;
                    for (T element$iv$iv : $this$filterTo$iv$iv) {
                        it = (SootMethod)element$iv$iv;
                        $i$a$-filter-IPAnalysisEngine$runAnalysisInScene$11 = false;
                        v12 = it.getDeclaringClass();
                        Intrinsics.checkNotNullExpressionValue((Object)v12, (String)"getDeclaringClass(...)");
                        if (!(OthersKt.isSyntheticComponent((SootClass)v12) == false && it.isAbstract() == false)) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$map$iv = (List)destination$iv$iv;
                    $i$f$map = false;
                    $this$filterTo$iv$iv = $this$map$iv;
                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    $i$f$mapTo = false;
                    for (T item$iv$iv : $this$mapTo$iv$iv) {
                        it = (SootMethod)item$iv$iv;
                        var30_20 = destination$iv$iv;
                        $i$a$-map-IPAnalysisEngine$runAnalysisInScene$12 = false;
                        var30_20.add(it.getSignature());
                    }
                    var21_30 = (List)destination$iv$iv;
                    CollectionsKt.addAll((Collection)var20_25, (Iterable)var21_30);
                }
                analysis.getCallBackManager().reportMissSummaryMethod((Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, runAnalysisInScene$lambda$13(cn.sast.framework.result.IMissingSummaryReporter soot.SootMethod ), (Lsoot/SootMethod;)Lkotlin/Unit;)((IMissingSummaryReporter)missWrapper));
                return kotlin.Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static /* synthetic */ Object runAnalysisInScene$default(IPAnalysisEngine iPAnalysisEngine, ProjectFileLocator projectFileLocator, SootInfoCache sootInfoCache, SootCtx sootCtx, IPreAnalysisResultCollector iPreAnalysisResultCollector, IIPAnalysisResultCollector iIPAnalysisResultCollector, ICoverageCollector iCoverageCollector, Collection collection, Collection collection2, IMissingSummaryReporter iMissingSummaryReporter, Continuation continuation, int n, Object object) {
        if ((n & 0x20) != 0) {
            iCoverageCollector = null;
        }
        return iPAnalysisEngine.runAnalysisInScene(projectFileLocator, sootInfoCache, sootCtx, iPreAnalysisResultCollector, iIPAnalysisResultCollector, iCoverageCollector, collection, collection2, iMissingSummaryReporter, continuation);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public final Object analyze(@NotNull ProjectFileLocator var1_1, @NotNull SootInfoCache var2_2, @NotNull SootCtx var3_3, @NotNull IEntryPointProvider var4_4, @NotNull ResultCollector var5_5, @NotNull IMissingSummaryReporter var6_6, @NotNull Continuation<? super kotlin.Unit> $completion) {
        if (!($completion instanceof analyze.1)) ** GOTO lbl-1000
        var19_8 = $completion;
        if ((var19_8.label & -2147483648) != 0) {
            var19_8.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var21_10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var8_11 = LoggingKt.info((KLogger)IPAnalysisEngine.logger);
                msg$iv = "Run inter-procedural data flow analysis analysis";
                $i$f$bracket = false;
                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                startTime$iv = LocalDateTime.now();
                alreadyLogged$iv = 0;
                res$iv = new Ref.ObjectRef();
                res$iv.element = Maybe.Companion.empty();
                var17_18 = res$iv;
                $i$a$-bracket$default-IPAnalysisEngine$analyze$2 = false;
                $continuation.L$0 = $this$bracket_u24default$iv;
                $continuation.L$1 = msg$iv;
                $continuation.L$2 = startTime$iv;
                $continuation.L$3 = res$iv;
                $continuation.L$4 = var17_18;
                $continuation.I$0 = alreadyLogged$iv;
                $continuation.label = 1;
                v0 = provider.getIterator().collect((FlowCollector)new /* Unavailable Anonymous Inner Class!! */, (Continuation)$continuation);
                ** if (v0 != var21_10) goto lbl35
lbl34:
                // 1 sources

                return var21_10;
lbl35:
                // 1 sources

                ** GOTO lbl49
            }
            case 1: {
                $i$f$bracket = false;
                $i$a$-bracket$default-IPAnalysisEngine$analyze$2 = false;
                alreadyLogged$iv = $continuation.I$0;
                var17_18 = (Ref.ObjectRef)$continuation.L$4;
                res$iv = (Ref.ObjectRef)$continuation.L$3;
                startTime$iv = (LocalDateTime)$continuation.L$2;
                msg$iv = (String)$continuation.L$1;
                $this$bracket_u24default$iv = (LoggerWithLogMethod)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl49:
                    // 2 sources

                    var20_21 = kotlin.Unit.INSTANCE;
                    var17_18.element = new Maybe((Object)var20_21);
                    var15_22 = ((Maybe)res$iv.element).getOrThrow();
                }
                catch (Throwable t$iv) {
                    try {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                        alreadyLogged$iv = 1;
                        throw t$iv;
                    }
                    catch (Throwable var16_24) {
                        if (alreadyLogged$iv == 0) {
                            if (((Maybe)res$iv.element).getHasValue()) {
                                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                            } else {
                                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                            }
                        }
                        throw var16_24;
                    }
                }
                if (((Maybe)res$iv.element).getHasValue()) {
                    $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                } else {
                    $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                }
                return kotlin.Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private final void dumpJson(IResDirectory output, String name) {
        IResource cgJson = output.resolve(name);
        OpenOption[] openOptionArray = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream(cgJson.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        Closeable closeable = outputStream;
        Throwable throwable = null;
        try {
            OutputStream out = (OutputStream)closeable;
            boolean bl = false;
            try {
                void $this$encodeToStream$iv;
                Json json = IPAnalysisEngineKt.getGraphJson();
                HashMutableDirectedGraph value$iv = this.directedGraph;
                boolean $i$f$encodeToStream = false;
                JvmStreamsKt.encodeToStream((Json)$this$encodeToStream$iv, (SerializationStrategy)((SerializationStrategy)HashMutableDirectedGraph.Companion.serializer(SerializersKt.noCompiledSerializer((SerializersModule)$this$encodeToStream$iv.getSerializersModule(), (KClass)Reflection.getOrCreateKotlinClass(SootMethod.class)))), (Object)value$iv, (OutputStream)out);
                logger.info(() -> IPAnalysisEngine.dumpJson$lambda$16$lambda$15(cgJson));
            }
            catch (Exception e) {
                logger.error("failed to encodeToStream jsonGraph", (Throwable)e);
            }
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }

    private final void dumpDot(IResDirectory output, String name) {
        IResFile cg = output.resolve(name).toFile();
        HashMutableDirectedGraph hashMutableDirectedGraph = this.directedGraph;
        dumpDot.plot.1 plot2 = new /* Unavailable Anonymous Inner Class!! */;
        try {
            GraphPlotKt.dump((DotGraph)GraphPlot.plot$default((GraphPlot)((GraphPlot)plot2), null, (int)1, null), (IResFile)cg);
            logger.info(() -> IPAnalysisEngine.dumpDot$lambda$17(cg));
        }
        catch (Exception e) {
            logger.error("failed to render dotGraph", (Throwable)e);
        }
    }

    public final void dump(@NotNull IResDirectory output) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        String name = "forward_interprocedural_callgraph";
        this.dumpDot(output, name + ".dot");
        this.dumpJson(output, name + ".json");
        Iterator iterator2 = Scene.v().getCallGraph().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            SootMethod tgt;
            SootMethod src;
            Edge edge = (Edge)iterator3.next();
            if (edge.src() == null || edge.tgt() == null) continue;
            this.directedGraph.addEdge((Object)src, (Object)tgt);
        }
        this.dumpJson(output, name + "_complete.json");
        if (ExtSettings.INSTANCE.getDumpCompleteDotCg()) {
            this.dumpDot(output, name + "_complete.dot");
        }
    }

    private static final boolean runAnalysisInScene$lambda$2(boolean $apponly, ProjectFileLocator $locator, SootMethod it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return !$apponly && it.getDeclaringClass().isLibraryClass() ? $locator.get((IBugResInfo)ClassResInfo.Companion.of(it), (IWrapperFileGenerator)NullWrapperFileGenerator.INSTANCE) != null : false;
    }

    private static final kotlin.Unit runAnalysisInScene$lambda$13(IMissingSummaryReporter $missWrapper, SootMethod miss) {
        Intrinsics.checkNotNullParameter((Object)miss, (String)"miss");
        $missWrapper.reportMissingMethod(miss);
        return kotlin.Unit.INSTANCE;
    }

    private static final Object dumpJson$lambda$16$lambda$15(IResource $cgJson) {
        return "json call graph: " + $cgJson;
    }

    private static final Object dumpDot$lambda$17(IResFile $cg) {
        return "dot call graph: " + $cg;
    }

    private static final kotlin.Unit logger$lambda$18() {
        return kotlin.Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

