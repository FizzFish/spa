/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.AnalyzerEnv
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles
 *  cn.sast.api.util.IMonitor
 *  cn.sast.api.util.PhaseIntervalTimer
 *  cn.sast.api.util.PhaseIntervalTimer$Snapshot
 *  cn.sast.api.util.Timer
 *  cn.sast.framework.AnalyzeTaskRunner
 *  cn.sast.framework.AnalyzeTaskRunner$Analysis
 *  cn.sast.framework.AnalyzeTaskRunner$Companion
 *  cn.sast.framework.AnalyzeTaskRunner$Env
 *  cn.sast.framework.AnalyzeTaskRunner$run$1
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.entries.IEntryPointProvider
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.AwaitKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.flow.FlowCollector
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework;

import cn.sast.api.AnalyzerEnv;
import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.util.IMonitor;
import cn.sast.api.util.PhaseIntervalTimer;
import cn.sast.api.util.Timer;
import cn.sast.framework.AnalyzeTaskRunner;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0003)*+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0087\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122 \b\u0002\u0010\u001c\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d2&\b\u0002\u0010\u001f\u001a \b\u0001\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010 2 \b\u0002\u0010\"\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d\u00a2\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0086@\u00a2\u0006\u0002\u0010'J\u000e\u0010$\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006,"}, d2={"Lcn/sast/framework/AnalyzeTaskRunner;", "", "numThreads", "", "sootCtx", "Lcn/sast/framework/SootCtx;", "monitor", "Lcn/sast/api/util/IMonitor;", "<init>", "(ILcn/sast/framework/SootCtx;Lcn/sast/api/util/IMonitor;)V", "getNumThreads", "()I", "getSootCtx", "()Lcn/sast/framework/SootCtx;", "getMonitor", "()Lcn/sast/api/util/IMonitor;", "analysisPasses", "", "Lcn/sast/framework/entries/IEntryPointProvider;", "", "Lcn/sast/framework/AnalyzeTaskRunner$Analysis;", "getAnalysisPasses", "()Ljava/util/Map;", "registerAnalysis", "", "phaseName", "", "provider", "before", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "analysis", "Lkotlin/Function2;", "Lcn/sast/framework/AnalyzeTaskRunner$Env;", "after", "(Ljava/lang/String;Lcn/sast/framework/entries/IEntryPointProvider;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "run", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Env", "Analysis", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nAnalyzeTaskRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnalyzeTaskRunner.kt\ncn/sast/framework/AnalyzeTaskRunner\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Timer.kt\ncn/sast/api/util/TimerKt\n*L\n1#1,152:1\n381#2,7:153\n1557#3:160\n1628#3,3:161\n1557#3:172\n1628#3,3:173\n16#4,8:164\n16#4,8:176\n*S KotlinDebug\n*F\n+ 1 AnalyzeTaskRunner.kt\ncn/sast/framework/AnalyzeTaskRunner\n*L\n49#1:153,7\n59#1:160\n59#1:161,3\n106#1:172\n106#1:173,3\n66#1:164,8\n113#1:176,8\n*E\n"})
public final class AnalyzeTaskRunner {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int numThreads;
    @NotNull
    private final SootCtx sootCtx;
    @NotNull
    private final IMonitor monitor;
    @NotNull
    private final Map<IEntryPointProvider, List<Analysis>> analysisPasses;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(AnalyzeTaskRunner::logger$lambda$6);
    public static Class<?> v3r14yJn1Class;
    @NotNull
    private static final Lazy<Integer> mask$delegate;
    public static final int mask1 = 65576;

    public AnalyzeTaskRunner(int numThreads, @NotNull SootCtx sootCtx, @NotNull IMonitor monitor) {
        Intrinsics.checkNotNullParameter((Object)sootCtx, (String)"sootCtx");
        Intrinsics.checkNotNullParameter((Object)monitor, (String)"monitor");
        this.numThreads = numThreads;
        this.sootCtx = sootCtx;
        this.monitor = monitor;
        this.analysisPasses = new LinkedHashMap();
    }

    public final int getNumThreads() {
        return this.numThreads;
    }

    @NotNull
    public final SootCtx getSootCtx() {
        return this.sootCtx;
    }

    @NotNull
    public final IMonitor getMonitor() {
        return this.monitor;
    }

    @NotNull
    public final Map<IEntryPointProvider, List<Analysis>> getAnalysisPasses() {
        return this.analysisPasses;
    }

    public final void registerAnalysis(@NotNull String phaseName, @NotNull IEntryPointProvider provider, @Nullable Function1<? super Continuation<? super Unit>, ? extends Object> before, @Nullable Function2<? super Env, ? super Continuation<? super Unit>, ? extends Object> analysis2, @Nullable Function1<? super Continuation<? super Unit>, ? extends Object> after) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)phaseName, (String)"phaseName");
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        if (AnalyzerEnv.INSTANCE.getShouldV3r14y() && AnalyzerEnv.INSTANCE.getBvs1n3ss().get() != 0 && (Companion.getMask() & 0x10028) != 65576) {
            return;
        }
        Map $this$getOrPut$iv = this.analysisPasses;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(provider);
        if (value$iv == null) {
            boolean bl = false;
            List answer$iv = new ArrayList();
            $this$getOrPut$iv.put(provider, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv;
        }
        ((List)object).add(new Analysis(phaseName, before, analysis2, after));
    }

    public static /* synthetic */ void registerAnalysis$default(AnalyzeTaskRunner analyzeTaskRunner, String string, IEntryPointProvider iEntryPointProvider, Function1 function1, Function2 function2, Function1 function12, int n, Object object) {
        if ((n & 4) != 0) {
            function1 = null;
        }
        if ((n & 8) != 0) {
            function2 = null;
        }
        if ((n & 0x10) != 0) {
            function12 = null;
        }
        analyzeTaskRunner.registerAnalysis(string, iEntryPointProvider, function1, function2, function12);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Nullable
    public final Object run(@NotNull CoroutineScope var1_1, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof run.1)) ** GOTO lbl-1000
        var23_3 = $completion;
        if ((var23_3.label & -2147483648) != 0) {
            var23_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new /* Unavailable Anonymous Inner Class!! */;
        }
        $result = $continuation.result;
        var24_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                preAnalysisTimer = this.monitor.timer("AnalyzeTaskRunner.analysis.pre");
                processAnalysisTimer = this.monitor.timer("AnalyzeTaskRunner.analysis.process");
                afterAnalysisTimer = this.monitor.timer("AnalyzeTaskRunner.analysis.after");
                jobsBefore = new ArrayList<E>();
                allAnalyses = CollectionsKt.flatten((Iterable)this.analysisPasses.values());
                var8_11 = allAnalyses;
                var20_12 = jobsBefore;
                $i$f$map = false;
                var10_15 = $this$map$iv;
                destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (T item$iv$iv : $this$mapTo$iv$iv) {
                    var15_33 = (Analysis)item$iv$iv;
                    var21_38 = destination$iv$iv;
                    $i$a$-map-AnalyzeTaskRunner$run$2 = false;
                    var21_38.add(BuildersKt.async$default((CoroutineScope)scope, null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null));
                }
                var20_12.addAll((List)destination$iv$iv);
                $this$bracket$iv = (PhaseIntervalTimer)preAnalysisTimer;
                $i$f$bracket = false;
                if ($this$bracket$iv != null) ** GOTO lbl60
                $i$a$-bracket-AnalyzeTaskRunner$run$3 = false;
                $continuation.L$0 = this;
                $continuation.L$1 = scope;
                $continuation.L$2 = processAnalysisTimer;
                $continuation.L$3 = afterAnalysisTimer;
                $continuation.L$4 = allAnalyses;
                $continuation.label = 1;
                v0 = AwaitKt.awaitAll((Collection)jobsBefore, (Continuation)$continuation);
                if (v0 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl57
            }
            case 1: {
                $i$f$bracket = false;
                $i$a$-bracket-AnalyzeTaskRunner$run$3 = false;
                allAnalyses = (List)$continuation.L$4;
                afterAnalysisTimer = (Timer)$continuation.L$3;
                processAnalysisTimer = (Timer)$continuation.L$2;
                scope = (CoroutineScope)$continuation.L$1;
                this = (AnalyzeTaskRunner)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl57:
                // 2 sources

                (List)v0;
                ** GOTO lbl99
            }
lbl60:
            // 1 sources

            s$iv = $this$bracket$iv.start();
            $i$a$-bracket-AnalyzeTaskRunner$run$3 = false;
            $continuation.L$0 = this;
            $continuation.L$1 = scope;
            $continuation.L$2 = processAnalysisTimer;
            $continuation.L$3 = afterAnalysisTimer;
            $continuation.L$4 = allAnalyses;
            $continuation.L$5 = $this$bracket$iv;
            $continuation.L$6 = s$iv;
            $continuation.label = 2;
            v1 = AwaitKt.awaitAll((Collection)jobsBefore, (Continuation)$continuation);
            v2 = v1;
            if (v1 == var24_5) {
                return var24_5;
            }
            ** GOTO lbl94
            case 2: {
                $i$f$bracket = false;
                $i$a$-bracket-AnalyzeTaskRunner$run$3 = false;
                s$iv = (PhaseIntervalTimer.Snapshot)$continuation.L$6;
                $this$bracket$iv = (PhaseIntervalTimer)$continuation.L$5;
                allAnalyses = (List)$continuation.L$4;
                afterAnalysisTimer = (Timer)$continuation.L$3;
                processAnalysisTimer = (Timer)$continuation.L$2;
                scope = (CoroutineScope)$continuation.L$1;
                this = (AnalyzeTaskRunner)$continuation.L$0;
                ** try [egrp 1[TRYBLOCK] [1 : 611->624)] { 
lbl91:
                // 1 sources

                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl94:
                // 2 sources

                $i$a$-bracket-AnalyzeTaskRunner$run$3 = (List)v2;
                ** GOTO lbl99
lbl96:
                // 1 sources

                finally {
                    $this$bracket$iv.stop((PhaseIntervalTimer.Snapshot)s$iv);
                }
lbl99:
                // 2 sources

                s1 = processAnalysisTimer.start();
                $i$a$-bracket-AnalyzeTaskRunner$run$3 = this.sootCtx.getMainConfig().getIncrementAnalyze();
                incremental = $i$a$-bracket-AnalyzeTaskRunner$run$3 instanceof IncrementalAnalyzeByChangeFiles != false ? (IncrementalAnalyzeByChangeFiles)$i$a$-bracket-AnalyzeTaskRunner$run$3 : null;
                $i$a$-bracket-AnalyzeTaskRunner$run$3 = this.analysisPasses.entrySet().iterator();
lbl103:
                // 3 sources

                while ($i$a$-bracket-AnalyzeTaskRunner$run$3.hasNext()) {
                    s$iv = (Map.Entry)$i$a$-bracket-AnalyzeTaskRunner$run$3.next();
                    provider = (IEntryPointProvider)s$iv.getKey();
                    analyses = (List)s$iv.getValue();
                    AnalyzeTaskRunner.logger.info((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, run$lambda$3(cn.sast.framework.entries.IEntryPointProvider ), ()Ljava/lang/Object;)((IEntryPointProvider)provider));
                    $continuation.L$0 = this;
                    $continuation.L$1 = scope;
                    $continuation.L$2 = processAnalysisTimer;
                    $continuation.L$3 = afterAnalysisTimer;
                    $continuation.L$4 = allAnalyses;
                    $continuation.L$5 = s1;
                    $continuation.L$6 = incremental;
                    $continuation.L$7 = $i$a$-bracket-AnalyzeTaskRunner$run$3;
                    $continuation.label = 3;
                    v3 = provider.getIterator().collect((FlowCollector)new /* Unavailable Anonymous Inner Class!! */, (Continuation)$continuation);
                    if (v3 != var24_5) continue;
                    return var24_5;
                }
                ** GOTO lbl133
            }
            case 3: {
                $i$a$-bracket-AnalyzeTaskRunner$run$3 = (Iterator<Map.Entry<K, V>>)$continuation.L$7;
                incremental = (IncrementalAnalyzeByChangeFiles)$continuation.L$6;
                s1 = (PhaseIntervalTimer.Snapshot)$continuation.L$5;
                allAnalyses = (List)$continuation.L$4;
                afterAnalysisTimer = (Timer)$continuation.L$3;
                processAnalysisTimer = (Timer)$continuation.L$2;
                scope = (CoroutineScope)$continuation.L$1;
                this = (AnalyzeTaskRunner)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v3 = $result;
                ** GOTO lbl103
            }
lbl133:
            // 1 sources

            processAnalysisTimer.stop(s1);
            jobsAfter = new ArrayList<E>();
            s$iv = allAnalyses;
            var20_12 = jobsAfter;
            $i$f$map = false;
            analyses = $this$map$iv;
            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            $i$f$mapTo = false;
            for (T item$iv$iv : $this$mapTo$iv$iv) {
                var18_40 = (Analysis)item$iv$iv;
                var21_38 = destination$iv$iv;
                $i$a$-map-AnalyzeTaskRunner$run$6 = false;
                var21_38.add(BuildersKt.async$default((CoroutineScope)scope, null, null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)3, null));
            }
            var20_12.addAll((List)destination$iv$iv);
            $this$bracket$iv = (PhaseIntervalTimer)afterAnalysisTimer;
            $i$f$bracket = false;
            if ($this$bracket$iv != null) ** GOTO lbl176
            $i$a$-bracket-AnalyzeTaskRunner$run$7 = false;
            $continuation.L$0 = null;
            $continuation.L$1 = null;
            $continuation.L$2 = null;
            $continuation.L$3 = null;
            $continuation.L$4 = null;
            $continuation.L$5 = null;
            $continuation.L$6 = null;
            $continuation.L$7 = null;
            $continuation.label = 4;
            v4 = AwaitKt.awaitAll((Collection)jobsAfter, (Continuation)$continuation);
            if (v4 == var24_5) {
                return var24_5;
            }
            ** GOTO lbl173
            case 4: {
                $i$f$bracket = false;
                $i$a$-bracket-AnalyzeTaskRunner$run$7 = false;
                ResultKt.throwOnFailure((Object)$result);
                v4 = $result;
lbl173:
                // 2 sources

                (List)v4;
                return Unit.INSTANCE;
            }
lbl176:
            // 1 sources

            s$iv = $this$bracket$iv.start();
            $i$a$-bracket-AnalyzeTaskRunner$run$7 = false;
            $continuation.L$0 = $this$bracket$iv;
            $continuation.L$1 = s$iv;
            $continuation.L$2 = null;
            $continuation.L$3 = null;
            $continuation.L$4 = null;
            $continuation.L$5 = null;
            $continuation.L$6 = null;
            $continuation.L$7 = null;
            $continuation.label = 5;
            v5 = AwaitKt.awaitAll((Collection)jobsAfter, (Continuation)$continuation);
            v6 = v5;
            if (v5 == var24_5) {
                return var24_5;
            }
            ** GOTO lbl206
            case 5: {
                $i$f$bracket = false;
                $i$a$-bracket-AnalyzeTaskRunner$run$7 = false;
                s$iv = (PhaseIntervalTimer.Snapshot)$continuation.L$1;
                $this$bracket$iv = (PhaseIntervalTimer)$continuation.L$0;
                ** try [egrp 3[TRYBLOCK] [4 : 1328->1341)] { 
lbl203:
                // 1 sources

                ResultKt.throwOnFailure((Object)$result);
                v6 = $result;
lbl206:
                // 2 sources

                var13_31 = (List)v6;
                return Unit.INSTANCE;
lbl208:
                // 1 sources

                finally {
                    $this$bracket$iv.stop(s$iv);
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object run(@NotNull Continuation<? super Unit> $completion) {
        Object object = CoroutineScopeKt.coroutineScope((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private static final Object run$lambda$3(IEntryPointProvider $provider) {
        return "do analysis with provider: " + $provider;
    }

    private static final Unit logger$lambda$6() {
        return Unit.INSTANCE;
    }

    private static final int mask_delegate$lambda$7() {
        return ((Number)BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null)).intValue();
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ Lazy access$getMask$delegate$cp() {
        return mask$delegate;
    }

    static {
        mask$delegate = LazyKt.lazy(AnalyzeTaskRunner::mask_delegate$lambda$7);
    }
}

