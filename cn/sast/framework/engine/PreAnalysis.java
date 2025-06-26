/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.engine.PreAnalysis
 *  cn.sast.framework.engine.PreAnalysis$Companion
 *  cn.sast.framework.engine.PreAnalysis$analyzeInScene$1
 *  cn.sast.framework.engine.PreAnalysisImpl
 *  cn.sast.framework.metrics.MetricsMonitor
 *  cn.sast.framework.report.IProjectFileLocator
 *  cn.sast.framework.result.IPreAnalysisResultCollector
 *  cn.sast.idfa.analysis.ProcessInfoView
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.LoggerWithLogMethod
 *  org.utbot.common.LoggingKt
 *  org.utbot.common.Maybe
 *  soot.Scene
 *  soot.SootClass
 */
package cn.sast.framework.engine;

import cn.sast.api.config.MainConfig;
import cn.sast.framework.SootCtx;
import cn.sast.framework.engine.PreAnalysis;
import cn.sast.framework.engine.PreAnalysisImpl;
import cn.sast.framework.metrics.MetricsMonitor;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.result.IPreAnalysisResultCollector;
import cn.sast.idfa.analysis.ProcessInfoView;
import com.feysh.corax.cache.analysis.SootInfoCache;
import java.lang.invoke.LambdaMetafactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.LoggerWithLogMethod;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;
import soot.Scene;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0016"}, d2={"Lcn/sast/framework/engine/PreAnalysis;", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "<init>", "(Lcn/sast/api/config/MainConfig;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "analyzeInScene", "", "soot", "Lcn/sast/framework/SootCtx;", "locator", "Lcn/sast/framework/report/IProjectFileLocator;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "resultCollector", "Lcn/sast/framework/result/IPreAnalysisResultCollector;", "monitor", "Lcn/sast/framework/metrics/MetricsMonitor;", "(Lcn/sast/framework/SootCtx;Lcn/sast/framework/report/IProjectFileLocator;Lcom/feysh/corax/cache/analysis/SootInfoCache;Lcn/sast/framework/result/IPreAnalysisResultCollector;Lcn/sast/framework/metrics/MetricsMonitor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nPreAnalysis.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreAnalysis.kt\ncn/sast/framework/engine/PreAnalysis\n+ 2 Logging.kt\norg/utbot/common/LoggingKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n49#2,13:37\n62#2,11:54\n1557#3:50\n1628#3,3:51\n*S KotlinDebug\n*F\n+ 1 PreAnalysis.kt\ncn/sast/framework/engine/PreAnalysis\n*L\n28#1:37,13\n28#1:54,11\n31#1:50\n31#1:51,3\n*E\n"})
public final class PreAnalysis {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(PreAnalysis::logger$lambda$4);

    public PreAnalysis(@NotNull MainConfig mainConfig) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        this.mainConfig = mainConfig;
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public final Object analyzeInScene(@NotNull SootCtx var1_1, @NotNull IProjectFileLocator var2_2, @NotNull SootInfoCache var3_3, @NotNull IPreAnalysisResultCollector var4_4, @NotNull MetricsMonitor var5_5, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof analyzeInScene.1)) ** GOTO lbl-1000
        var31_7 = $completion;
        if ((var31_7.label & -2147483648) != 0) {
            var31_7.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var33_9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                scene = Scene.v();
                PreAnalysis.logger.info((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, analyzeInScene$lambda$0(), ()Ljava/lang/Object;)());
                var8_11 = LoggingKt.info((KLogger)PreAnalysis.logger);
                msg$iv = "PreAnalysis";
                $i$f$bracket = false;
                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                startTime$iv = LocalDateTime.now();
                alreadyLogged$iv = 0;
                res$iv = new Ref.ObjectRef();
                res$iv.element = Maybe.Companion.empty();
                var29_17 = res$iv;
                $i$a$-bracket$default-PreAnalysis$analyzeInScene$3 = false;
                v0 = soot.getSootMethodCallGraph();
                Intrinsics.checkNotNull((Object)scene);
                analysisImpl = new PreAnalysisImpl(this.mainConfig, (IProjectFileLocator)locator, v0, (SootInfoCache)info, (IPreAnalysisResultCollector)resultCollector, scene);
                $continuation.L$0 = monitor;
                $continuation.L$1 = $this$bracket_u24default$iv;
                $continuation.L$2 = msg$iv;
                $continuation.L$3 = startTime$iv;
                $continuation.L$4 = res$iv;
                $continuation.L$5 = analysisImpl;
                $continuation.L$6 = var29_17;
                $continuation.I$0 = alreadyLogged$iv;
                $continuation.label = 1;
                v1 = analysisImpl.processPreAnalysisUnits((Continuation)$continuation);
                ** if (v1 != var33_9) goto lbl42
lbl41:
                // 1 sources

                return var33_9;
lbl42:
                // 1 sources

                ** GOTO lbl58
            }
            case 1: {
                $i$f$bracket = false;
                $i$a$-bracket$default-PreAnalysis$analyzeInScene$3 = false;
                alreadyLogged$iv = $continuation.I$0;
                var29_17 = (Ref.ObjectRef)$continuation.L$6;
                analysisImpl = (PreAnalysisImpl)$continuation.L$5;
                res$iv = (Ref.ObjectRef)$continuation.L$4;
                startTime$iv = (LocalDateTime)$continuation.L$3;
                msg$iv = (String)$continuation.L$2;
                $this$bracket_u24default$iv = (LoggerWithLogMethod)$continuation.L$1;
                monitor = (MetricsMonitor)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl58:
                    // 2 sources

                    var16_20 = monitor.getProjectMetrics().getAnalyzedClasses();
                    $this$map$iv = analysisImpl.getAnalyzedClasses();
                    $i$f$map = false;
                    var19_23 = $this$map$iv;
                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    $i$f$mapTo = false;
                    for (T item$iv$iv : $this$mapTo$iv$iv) {
                        var24_28 = (SootClass)item$iv$iv;
                        var25_29 = destination$iv$iv;
                        $i$a$-map-PreAnalysis$analyzeInScene$3$1 = false;
                        var25_29.add(it.getName());
                    }
                    var17_21 = (List)destination$iv$iv;
                    CollectionsKt.addAll((Collection)var16_20, (Iterable)var17_21);
                    monitor.getProjectMetrics().setAnalyzedFiles(((Collection)analysisImpl.getAnalyzedSourceFiles()).size());
                    var32_31 = Unit.INSTANCE;
                    var29_17.element = new Maybe((Object)var32_31);
                    var27_32 = ((Maybe)res$iv.element).getOrThrow();
                }
                catch (Throwable t$iv) {
                    try {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                        alreadyLogged$iv = 1;
                        throw t$iv;
                    }
                    catch (Throwable var28_34) {
                        if (alreadyLogged$iv == 0) {
                            if (((Maybe)res$iv.element).getHasValue()) {
                                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                            } else {
                                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                            }
                        }
                        throw var28_34;
                    }
                }
                if (((Maybe)res$iv.element).getHasValue()) {
                    $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                } else {
                    $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                }
                PreAnalysis.logger.info((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, analyzeInScene$lambda$3(), ()Ljava/lang/Object;)());
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private static final Object analyzeInScene$lambda$0() {
        return "Before PreAnalysis: Process information: " + ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText();
    }

    private static final Object analyzeInScene$lambda$3() {
        return "After PreAnalysis: Process information: " + ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText();
    }

    private static final Unit logger$lambda$4() {
        return Unit.INSTANCE;
    }
}

