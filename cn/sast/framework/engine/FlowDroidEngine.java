/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.PreAnalysisCoroutineScope
 *  cn.sast.dataflow.infoflow.FlowDroidFactory
 *  cn.sast.dataflow.infoflow.InfoflowConfigurationExt
 *  cn.sast.dataflow.infoflow.provider.MethodSummaryProvider
 *  cn.sast.dataflow.infoflow.provider.MissingSummaryWrapper
 *  cn.sast.dataflow.infoflow.provider.SourceSinkProvider
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.engine.FlowDroidEngine
 *  cn.sast.framework.engine.FlowDroidEngine$Companion
 *  cn.sast.framework.engine.FlowDroidEngine$analyzeInScene$1
 *  cn.sast.framework.engine.FlowDroidEngineKt
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.IEntryPointProvider$AnalyzeTask
 *  cn.sast.framework.entries.apk.ApkLifeCycleComponent
 *  cn.sast.framework.result.IFlowDroidResultCollector
 *  cn.sast.framework.result.IMissingSummaryReporter
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.flow.FlowCollector
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.LoggingKt
 *  org.utbot.common.Maybe
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.jimple.infoflow.AbstractInfoflow
 *  soot.jimple.infoflow.InfoflowConfiguration
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration
 *  soot.jimple.infoflow.android.source.AccessPathBasedSourceSinkManager
 *  soot.jimple.infoflow.cfg.BiDirICFGFactory
 *  soot.jimple.infoflow.cfg.DefaultBiDiICFGFactory
 *  soot.jimple.infoflow.handlers.ResultsAvailableHandler
 *  soot.jimple.infoflow.methodSummary.data.provider.IMethodSummaryProvider
 *  soot.jimple.infoflow.methodSummary.taintWrappers.SummaryTaintWrapper
 *  soot.jimple.infoflow.problems.TaintPropagationResults$OnTaintPropagationResultAdded
 *  soot.jimple.infoflow.solver.memory.IMemoryManagerFactory
 *  soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider
 *  soot.jimple.infoflow.sourcesSinks.manager.ISourceSinkManager
 *  soot.jimple.infoflow.taintWrappers.ITaintPropagationWrapper
 *  soot.jimple.toolkits.callgraph.ReachableMethods
 */
package cn.sast.framework.engine;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import cn.sast.dataflow.infoflow.FlowDroidFactory;
import cn.sast.dataflow.infoflow.InfoflowConfigurationExt;
import cn.sast.dataflow.infoflow.provider.MethodSummaryProvider;
import cn.sast.dataflow.infoflow.provider.MissingSummaryWrapper;
import cn.sast.dataflow.infoflow.provider.SourceSinkProvider;
import cn.sast.framework.SootCtx;
import cn.sast.framework.engine.FlowDroidEngine;
import cn.sast.framework.engine.FlowDroidEngineKt;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.apk.ApkLifeCycleComponent;
import cn.sast.framework.result.IFlowDroidResultCollector;
import cn.sast.framework.result.IMissingSummaryReporter;
import java.lang.invoke.LambdaMetafactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.infoflow.AbstractInfoflow;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.android.source.AccessPathBasedSourceSinkManager;
import soot.jimple.infoflow.cfg.BiDirICFGFactory;
import soot.jimple.infoflow.cfg.DefaultBiDiICFGFactory;
import soot.jimple.infoflow.handlers.ResultsAvailableHandler;
import soot.jimple.infoflow.methodSummary.data.provider.IMethodSummaryProvider;
import soot.jimple.infoflow.methodSummary.taintWrappers.SummaryTaintWrapper;
import soot.jimple.infoflow.problems.TaintPropagationResults;
import soot.jimple.infoflow.solver.memory.IMemoryManagerFactory;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;
import soot.jimple.infoflow.sourcesSinks.manager.ISourceSinkManager;
import soot.jimple.infoflow.taintWrappers.ITaintPropagationWrapper;
import soot.jimple.toolkits.callgraph.ReachableMethods;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J:\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0012\u0010\"\u001a\u00020\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ^\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0'2\u0006\u0010+\u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010,JV\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0'2\u0006\u0010+\u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010-J\u0018\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u0002002\u0006\u0010$\u001a\u00020%H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u00062"}, d2={"Lcn/sast/framework/engine/FlowDroidEngine;", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "infoFlowConfig", "Lsoot/jimple/infoflow/InfoflowConfiguration;", "extInfoFlowConfig", "Lcn/sast/dataflow/infoflow/InfoflowConfigurationExt;", "<init>", "(Lcn/sast/api/config/MainConfig;Lsoot/jimple/infoflow/InfoflowConfiguration;Lcn/sast/dataflow/infoflow/InfoflowConfigurationExt;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "getInfoFlowConfig", "()Lsoot/jimple/infoflow/InfoflowConfiguration;", "getExtInfoFlowConfig", "()Lcn/sast/dataflow/infoflow/InfoflowConfigurationExt;", "sourceSinkManager", "Lsoot/jimple/infoflow/sourcesSinks/manager/ISourceSinkManager;", "sourceSinkProvider", "Lsoot/jimple/infoflow/sourcesSinks/definitions/ISourceSinkDefinitionProvider;", "analyze", "", "preAnalysis", "Lcn/sast/api/config/PreAnalysisCoroutineScope;", "soot", "Lcn/sast/framework/SootCtx;", "provider", "Lcn/sast/framework/entries/IEntryPointProvider;", "cfgFactory", "Lsoot/jimple/infoflow/cfg/BiDirICFGFactory;", "result", "Lcn/sast/framework/result/IFlowDroidResultCollector;", "missWrapper", "Lcn/sast/framework/result/IMissingSummaryReporter;", "beforeAnalyze", "analyzeInScene", "task", "Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;", "resultAddedHandlers", "", "Lsoot/jimple/infoflow/problems/TaintPropagationResults$OnTaintPropagationResultAdded;", "onResultsAvailable", "Lsoot/jimple/infoflow/handlers/ResultsAvailableHandler;", "methodSummariesMissing", "(Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;Lcn/sast/framework/entries/IEntryPointProvider;Lcn/sast/framework/SootCtx;Lcn/sast/api/config/PreAnalysisCoroutineScope;Lsoot/jimple/infoflow/cfg/BiDirICFGFactory;Ljava/util/Set;Ljava/util/Set;Lcn/sast/framework/result/IMissingSummaryReporter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcn/sast/api/config/PreAnalysisCoroutineScope;Lcn/sast/framework/SootCtx;Lcn/sast/framework/entries/IEntryPointProvider;Lsoot/jimple/infoflow/cfg/BiDirICFGFactory;Ljava/util/Set;Ljava/util/Set;Lcn/sast/framework/result/IMissingSummaryReporter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureInfoFlow", "infoflow", "Lsoot/jimple/infoflow/AbstractInfoflow;", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nFlowDroidEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowDroidEngine.kt\ncn/sast/framework/engine/FlowDroidEngine\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Logging.kt\norg/utbot/common/LoggingKt\n*L\n1#1,235:1\n1863#2,2:236\n1628#2,3:251\n49#3,13:238\n62#3,11:254\n*S KotlinDebug\n*F\n+ 1 FlowDroidEngine.kt\ncn/sast/framework/engine/FlowDroidEngine\n*L\n177#1:236,2\n184#1:251,3\n183#1:238,13\n183#1:254,11\n*E\n"})
public final class FlowDroidEngine {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final InfoflowConfiguration infoFlowConfig;
    @NotNull
    private final InfoflowConfigurationExt extInfoFlowConfig;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(FlowDroidEngine::logger$lambda$5);

    public FlowDroidEngine(@NotNull MainConfig mainConfig, @NotNull InfoflowConfiguration infoFlowConfig, @NotNull InfoflowConfigurationExt extInfoFlowConfig) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)infoFlowConfig, (String)"infoFlowConfig");
        Intrinsics.checkNotNullParameter((Object)extInfoFlowConfig, (String)"extInfoFlowConfig");
        this.mainConfig = mainConfig;
        this.infoFlowConfig = infoFlowConfig;
        this.extInfoFlowConfig = extInfoFlowConfig;
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final InfoflowConfiguration getInfoFlowConfig() {
        return this.infoFlowConfig;
    }

    @NotNull
    public final InfoflowConfigurationExt getExtInfoFlowConfig() {
        return this.extInfoFlowConfig;
    }

    @NotNull
    public final ISourceSinkManager sourceSinkManager(@NotNull ISourceSinkDefinitionProvider sourceSinkProvider) {
        Intrinsics.checkNotNullParameter((Object)sourceSinkProvider, (String)"sourceSinkProvider");
        InfoflowAndroidConfiguration config = new InfoflowAndroidConfiguration();
        config.getSourceSinkConfig().merge(this.infoFlowConfig.getSourceSinkConfig());
        return (ISourceSinkManager)new AccessPathBasedSourceSinkManager(sourceSinkProvider.getSources(), sourceSinkProvider.getSinks(), config);
    }

    public final void analyze(@NotNull PreAnalysisCoroutineScope preAnalysis, @NotNull SootCtx soot, @NotNull IEntryPointProvider provider, @Nullable BiDirICFGFactory cfgFactory, @NotNull IFlowDroidResultCollector result, @NotNull IMissingSummaryReporter missWrapper) {
        Intrinsics.checkNotNullParameter((Object)preAnalysis, (String)"preAnalysis");
        Intrinsics.checkNotNullParameter((Object)soot, (String)"soot");
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        Intrinsics.checkNotNullParameter((Object)missWrapper, (String)"missWrapper");
        BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
    }

    public static /* synthetic */ void analyze$default(FlowDroidEngine flowDroidEngine, PreAnalysisCoroutineScope preAnalysisCoroutineScope, SootCtx sootCtx, IEntryPointProvider iEntryPointProvider, BiDirICFGFactory biDirICFGFactory, IFlowDroidResultCollector iFlowDroidResultCollector, IMissingSummaryReporter iMissingSummaryReporter, int n, Object object) {
        if ((n & 8) != 0) {
            biDirICFGFactory = null;
        }
        flowDroidEngine.analyze(preAnalysisCoroutineScope, sootCtx, iEntryPointProvider, biDirICFGFactory, iFlowDroidResultCollector, iMissingSummaryReporter);
    }

    public final void beforeAnalyze(@Nullable BiDirICFGFactory cfgFactory) {
        this.infoFlowConfig.setWriteOutputFiles(false);
        if (cfgFactory != null && this.infoFlowConfig instanceof InfoflowAndroidConfiguration) {
            String androidPath = this.mainConfig.getAndroidPlatformDir();
            if (cfgFactory instanceof DefaultBiDiICFGFactory) {
                ((DefaultBiDiICFGFactory)cfgFactory).setIsAndroid(androidPath != null);
            }
        }
        if (this.infoFlowConfig instanceof InfoflowAndroidConfiguration) {
            if (!Intrinsics.areEqual((Object)((InfoflowAndroidConfiguration)this.infoFlowConfig).getAnalysisFileConfig().getAndroidPlatformDir(), (Object)"unused")) {
                String string = "Check failed.";
                throw new IllegalStateException(string.toString());
            }
            if (!Intrinsics.areEqual((Object)((InfoflowAndroidConfiguration)this.infoFlowConfig).getAnalysisFileConfig().getTargetAPKFile(), (Object)"unused")) {
                String string = "Check failed.";
                throw new IllegalStateException(string.toString());
            }
        }
        FlowDroidEngineKt.fix((InfoflowConfiguration)this.infoFlowConfig);
    }

    public static /* synthetic */ void beforeAnalyze$default(FlowDroidEngine flowDroidEngine, BiDirICFGFactory biDirICFGFactory, int n, Object object) {
        if ((n & 1) != 0) {
            biDirICFGFactory = null;
        }
        flowDroidEngine.beforeAnalyze(biDirICFGFactory);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public final Object analyzeInScene(@NotNull IEntryPointProvider.AnalyzeTask var1_1, @NotNull IEntryPointProvider var2_2, @NotNull SootCtx var3_3, @NotNull PreAnalysisCoroutineScope var4_4, @Nullable BiDirICFGFactory var5_5, @NotNull Set<? extends TaintPropagationResults.OnTaintPropagationResultAdded> var6_6, @NotNull Set<? extends ResultsAvailableHandler> var7_7, @NotNull IMissingSummaryReporter var8_8, @NotNull Continuation<? super Unit> $completion) {
        block23: {
            if (!($completion instanceof analyzeInScene.1)) ** GOTO lbl-1000
            var35_10 = $completion;
            if ((var35_10.label & -2147483648) != 0) {
                var35_10.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new /* Unavailable Anonymous Inner Class!! */;
            }
            $result = $continuation.result;
            var37_12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    cg = soot.getSootMethodCallGraph();
                    Scene.v().setCallGraph(cg);
                    Scene.v().setReachableMethods(new ReachableMethods(cg, (Collection)new ArrayList<E>(task.getEntries())));
                    v0 = Scene.v().getClasses().iterator();
                    Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"iterator(...)");
                    var11_14 = v0;
                    while (var11_14.hasNext()) {
                        clazz = (SootClass)var11_14.next();
                        for (SootMethod sm : clazz.getMethods()) {
                            if (!sm.isConcrete() || sm.hasActiveBody()) continue;
                            sm.setPhantom(true);
                        }
                    }
                    sourceSinkProviderInstance = new SourceSinkProvider(this.mainConfig, preAnalysis);
                    $continuation.L$0 = this;
                    $continuation.L$1 = task;
                    $continuation.L$2 = provider;
                    $continuation.L$3 = soot;
                    $continuation.L$4 = preAnalysis;
                    $continuation.L$5 = cfgFactory;
                    $continuation.L$6 = resultAddedHandlers;
                    $continuation.L$7 = onResultsAvailable;
                    $continuation.L$8 = methodSummariesMissing;
                    $continuation.L$9 = sourceSinkProviderInstance;
                    $continuation.label = 1;
                    v1 = sourceSinkProviderInstance.initialize((Continuation)$continuation);
                    if (v1 == var37_12) {
                        return var37_12;
                    }
                    ** GOTO lbl54
                }
                case 1: {
                    sourceSinkProviderInstance = (SourceSinkProvider)$continuation.L$9;
                    methodSummariesMissing = (IMissingSummaryReporter)$continuation.L$8;
                    onResultsAvailable = (Set)$continuation.L$7;
                    resultAddedHandlers = (Set)$continuation.L$6;
                    cfgFactory = (BiDirICFGFactory)$continuation.L$5;
                    preAnalysis = (PreAnalysisCoroutineScope)$continuation.L$4;
                    soot = (SootCtx)$continuation.L$3;
                    provider = (IEntryPointProvider)$continuation.L$2;
                    task = (IEntryPointProvider.AnalyzeTask)$continuation.L$1;
                    this = (FlowDroidEngine)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl54:
                    // 2 sources

                    if (!this.mainConfig.getUse_wrapper()) break;
                    wrapper = new MethodSummaryProvider(this.mainConfig, preAnalysis);
                    $continuation.L$0 = this;
                    $continuation.L$1 = task;
                    $continuation.L$2 = provider;
                    $continuation.L$3 = soot;
                    $continuation.L$4 = cfgFactory;
                    $continuation.L$5 = resultAddedHandlers;
                    $continuation.L$6 = onResultsAvailable;
                    $continuation.L$7 = methodSummariesMissing;
                    $continuation.L$8 = sourceSinkProviderInstance;
                    $continuation.L$9 = wrapper;
                    $continuation.label = 2;
                    v2 = wrapper.initialize((Continuation)$continuation);
                    if (v2 == var37_12) {
                        return var37_12;
                    }
                    ** GOTO lbl84
                }
                case 2: {
                    wrapper = (MethodSummaryProvider)$continuation.L$9;
                    sourceSinkProviderInstance = (SourceSinkProvider)$continuation.L$8;
                    methodSummariesMissing = (IMissingSummaryReporter)$continuation.L$7;
                    onResultsAvailable = (Set)$continuation.L$6;
                    resultAddedHandlers = (Set)$continuation.L$5;
                    cfgFactory = (BiDirICFGFactory)$continuation.L$4;
                    soot = (SootCtx)$continuation.L$3;
                    provider = (IEntryPointProvider)$continuation.L$2;
                    task = (IEntryPointProvider.AnalyzeTask)$continuation.L$1;
                    this = (FlowDroidEngine)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v2 = $result;
lbl84:
                    // 2 sources

                    FlowDroidEngine.logger.info((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, analyzeInScene$lambda$0(cn.sast.dataflow.infoflow.provider.MethodSummaryProvider ), ()Ljava/lang/Object;)((MethodSummaryProvider)wrapper));
                    v3 = new MissingSummaryWrapper((IMethodSummaryProvider)wrapper, (Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, analyzeInScene$lambda$1(cn.sast.framework.result.IMissingSummaryReporter soot.SootMethod ), (Lsoot/SootMethod;)Lkotlin/Unit;)((IMissingSummaryReporter)methodSummariesMissing));
                    break block23;
                }
            }
            v3 = taintWrapperInstance = null;
        }
        if (provider instanceof ApkLifeCycleComponent) {
            ((ApkLifeCycleComponent)provider).setTaintWrapper((SummaryTaintWrapper)taintWrapperInstance);
        }
        v4 = this.infoFlowConfig.getDataFlowDirection();
        Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"getDataFlowDirection(...)");
        infoflow = FlowDroidFactory.INSTANCE.createInfoFlow(v4, this.mainConfig.getAndroidPlatformDir(), this.mainConfig.getForceAndroidJar(), null, cfgFactory, this.extInfoFlowConfig.getUseSparseOpt(), resultAddedHandlers);
        this.configureInfoFlow(infoflow, task);
        infoflow.setConfig(this.infoFlowConfig);
        infoflow.setSootConfig(null);
        infoflow.setTaintWrapper((ITaintPropagationWrapper)taintWrapperInstance);
        $this$forEach$iv = onResultsAvailable;
        $i$f$forEach = false;
        for (T element$iv : $this$forEach$iv) {
            it = (ResultsAvailableHandler)element$iv;
            $i$a$-forEach-FlowDroidEngine$analyzeInScene$2 = false;
            infoflow.addResultsAvailableHandler(it);
        }
        sourceSinkManager = this.sourceSinkManager((ISourceSinkDefinitionProvider)sourceSinkProviderInstance);
        $i$f$forEach = LoggingKt.info((KLogger)FlowDroidEngine.logger);
        msg$iv = "Run IFDS analysis for task: " + task.getName();
        $i$f$bracket = false;
        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        startTime$iv = LocalDateTime.now();
        alreadyLogged$iv = false;
        res$iv = new Ref.ObjectRef();
        res$iv.element = Maybe.Companion.empty();
        try {
            var33_28 = res$iv;
            $i$a$-bracket$default-FlowDroidEngine$analyzeInScene$3 = false;
            var23_31 = soot.getEntryPoints();
            destination$iv = new LinkedHashSet<E>();
            var25_35 = sourceSinkManager;
            var26_36 = infoflow;
            $i$f$mapTo = false;
            for (T item$iv : $this$mapTo$iv) {
                var30_40 = (SootMethod)item$iv;
                var31_41 = destination$iv;
                $i$a$-mapTo-FlowDroidEngine$analyzeInScene$3$1 = false;
                var31_41.add(it.getSignature());
            }
            var31_41 = destination$iv;
            FlowDroidEngineKt.runAnalysisReflect((AbstractInfoflow)var26_36, (ISourceSinkManager)var25_35, (Set)((Set)var31_41));
            var36_43 = Unit.INSTANCE;
            var33_28.element = new Maybe((Object)var36_43);
            var22_30 = ((Maybe)res$iv.element).getOrThrow();
        }
        catch (Throwable t$iv) {
            try {
                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                alreadyLogged$iv = true;
                throw t$iv;
            }
            catch (Throwable var23_33) {
                if (!alreadyLogged$iv) {
                    if (((Maybe)res$iv.element).getHasValue()) {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    } else {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    }
                }
                throw var23_33;
            }
        }
        if (((Maybe)res$iv.element).getHasValue()) {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static /* synthetic */ Object analyzeInScene$default(FlowDroidEngine flowDroidEngine, IEntryPointProvider.AnalyzeTask analyzeTask, IEntryPointProvider iEntryPointProvider, SootCtx sootCtx, PreAnalysisCoroutineScope preAnalysisCoroutineScope, BiDirICFGFactory biDirICFGFactory, Set set, Set set2, IMissingSummaryReporter iMissingSummaryReporter, Continuation continuation, int n, Object object) {
        if ((n & 0x10) != 0) {
            biDirICFGFactory = null;
        }
        return flowDroidEngine.analyzeInScene(analyzeTask, iEntryPointProvider, sootCtx, preAnalysisCoroutineScope, biDirICFGFactory, set, set2, iMissingSummaryReporter, continuation);
    }

    @Nullable
    public final Object analyze(@NotNull PreAnalysisCoroutineScope preAnalysis, @NotNull SootCtx soot, @NotNull IEntryPointProvider provider, @Nullable BiDirICFGFactory cfgFactory, @NotNull Set<? extends TaintPropagationResults.OnTaintPropagationResultAdded> resultAddedHandlers, @NotNull Set<? extends ResultsAvailableHandler> onResultsAvailable, @NotNull IMissingSummaryReporter methodSummariesMissing, @NotNull Continuation<? super Unit> $completion) {
        this.beforeAnalyze(cfgFactory);
        Object object = provider.getIterator().collect((FlowCollector)new /* Unavailable Anonymous Inner Class!! */, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object analyze$default(FlowDroidEngine flowDroidEngine, PreAnalysisCoroutineScope preAnalysisCoroutineScope, SootCtx sootCtx, IEntryPointProvider iEntryPointProvider, BiDirICFGFactory biDirICFGFactory, Set set, Set set2, IMissingSummaryReporter iMissingSummaryReporter, Continuation continuation, int n, Object object) {
        if ((n & 8) != 0) {
            biDirICFGFactory = null;
        }
        return flowDroidEngine.analyze(preAnalysisCoroutineScope, sootCtx, iEntryPointProvider, biDirICFGFactory, set, set2, iMissingSummaryReporter, continuation);
    }

    private final void configureInfoFlow(AbstractInfoflow infoflow, IEntryPointProvider.AnalyzeTask task2) {
        infoflow.setMemoryManagerFactory((IMemoryManagerFactory)new /* Unavailable Anonymous Inner Class!! */);
        infoflow.setMemoryManagerFactory(null);
        infoflow.setPostProcessors((Collection)SetsKt.setOf((Object)new /* Unavailable Anonymous Inner Class!! */));
    }

    private static final Object analyzeInScene$lambda$0(MethodSummaryProvider $wrapper) {
        return "taint wrapper size: " + $wrapper.getClassSummaries().getAllSummaries().size();
    }

    private static final Unit analyzeInScene$lambda$1(IMissingSummaryReporter $methodSummariesMissing, SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        $methodSummariesMissing.reportMissingMethod(method);
        return Unit.INSTANCE;
    }

    private static final Unit logger$lambda$5() {
        return Unit.INSTANCE;
    }
}

