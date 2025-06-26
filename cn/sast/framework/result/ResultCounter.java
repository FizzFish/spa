/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.Report
 *  cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis
 *  cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector
 *  cn.sast.framework.engine.PreAnalysisReportEnv
 *  cn.sast.framework.result.IBuiltInAnalysisCollector
 *  cn.sast.framework.result.IFlowDroidResultCollector
 *  cn.sast.framework.result.IPreAnalysisResultCollector
 *  cn.sast.framework.result.IUTBotResultCollector
 *  cn.sast.framework.result.ResultCounter
 *  cn.sast.framework.result.ResultCounter$Companion
 *  com.feysh.corax.config.api.CheckType
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.Intrinsics
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.jimple.infoflow.data.AbstractionAtSink
 *  soot.jimple.infoflow.results.InfoflowResults
 *  soot.jimple.infoflow.solver.cfg.IInfoflowCFG
 */
package cn.sast.framework.result;

import cn.sast.api.report.Report;
import cn.sast.dataflow.interprocedural.check.InterProceduralValueAnalysis;
import cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector;
import cn.sast.framework.engine.PreAnalysisReportEnv;
import cn.sast.framework.result.IBuiltInAnalysisCollector;
import cn.sast.framework.result.IFlowDroidResultCollector;
import cn.sast.framework.result.IPreAnalysisResultCollector;
import cn.sast.framework.result.IUTBotResultCollector;
import cn.sast.framework.result.ResultCounter;
import com.feysh.corax.config.api.CheckType;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00010B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\u00020\u00172\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(H\u0016J\u000e\u0010.\u001a\u00020\u0017H\u0096@\u00a2\u0006\u0002\u0010/R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b\u00a8\u00061"}, d2={"Lcn/sast/framework/result/ResultCounter;", "Lcn/sast/framework/result/IFlowDroidResultCollector;", "Lcn/sast/framework/result/IUTBotResultCollector;", "Lcn/sast/dataflow/interprocedural/check/checker/IIPAnalysisResultCollector;", "Lcn/sast/framework/result/IPreAnalysisResultCollector;", "Lcn/sast/framework/result/IBuiltInAnalysisCollector;", "<init>", "()V", "infoflowResCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getInfoflowResCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "infoflowAbsAtSinkCount", "getInfoflowAbsAtSinkCount", "symbolicUTbotCount", "getSymbolicUTbotCount", "dataFlowCount", "getDataFlowCount", "builtInAnalysisCount", "getBuiltInAnalysisCount", "preAnalysisResultCount", "getPreAnalysisResultCount", "onResultsAvailable", "", "cfg", "Lsoot/jimple/infoflow/solver/cfg/IInfoflowCFG;", "results", "Lsoot/jimple/infoflow/results/InfoflowResults;", "onResultAvailable", "", "icfg", "abs", "Lsoot/jimple/infoflow/data/AbstractionAtSink;", "addUtState", "afterAnalyze", "analysis", "Lcn/sast/dataflow/interprocedural/check/InterProceduralValueAnalysis;", "reportDataFlowBug", "reports", "", "Lcn/sast/api/report/Report;", "report", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "info", "Lcn/sast/framework/engine/PreAnalysisReportEnv;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "corax-framework"})
public final class ResultCounter
implements IFlowDroidResultCollector,
IUTBotResultCollector,
IIPAnalysisResultCollector,
IPreAnalysisResultCollector,
IBuiltInAnalysisCollector {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AtomicInteger infoflowResCount = new AtomicInteger(0);
    @NotNull
    private final AtomicInteger infoflowAbsAtSinkCount = new AtomicInteger(0);
    @NotNull
    private final AtomicInteger symbolicUTbotCount = new AtomicInteger(0);
    @NotNull
    private final AtomicInteger dataFlowCount = new AtomicInteger(0);
    @NotNull
    private final AtomicInteger builtInAnalysisCount = new AtomicInteger(0);
    @NotNull
    private final AtomicInteger preAnalysisResultCount = new AtomicInteger(0);
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ResultCounter::logger$lambda$6);

    @NotNull
    public final AtomicInteger getInfoflowResCount() {
        return this.infoflowResCount;
    }

    @NotNull
    public final AtomicInteger getInfoflowAbsAtSinkCount() {
        return this.infoflowAbsAtSinkCount;
    }

    @NotNull
    public final AtomicInteger getSymbolicUTbotCount() {
        return this.symbolicUTbotCount;
    }

    @NotNull
    public final AtomicInteger getDataFlowCount() {
        return this.dataFlowCount;
    }

    @NotNull
    public final AtomicInteger getBuiltInAnalysisCount() {
        return this.builtInAnalysisCount;
    }

    @NotNull
    public final AtomicInteger getPreAnalysisResultCount() {
        return this.preAnalysisResultCount;
    }

    public void onResultsAvailable(@NotNull IInfoflowCFG cfg, @NotNull InfoflowResults results) {
        Intrinsics.checkNotNullParameter((Object)cfg, (String)"cfg");
        Intrinsics.checkNotNullParameter((Object)results, (String)"results");
        this.infoflowResCount.addAndGet(results.size());
    }

    public boolean onResultAvailable(@NotNull IInfoflowCFG icfg, @NotNull AbstractionAtSink abs) {
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        Intrinsics.checkNotNullParameter((Object)abs, (String)"abs");
        this.infoflowAbsAtSinkCount.addAndGet(1);
        return true;
    }

    public void addUtState() {
        this.symbolicUTbotCount.addAndGet(1);
    }

    public void afterAnalyze(@NotNull InterProceduralValueAnalysis analysis2) {
        Intrinsics.checkNotNullParameter((Object)analysis2, (String)"analysis");
    }

    public void reportDataFlowBug(@NotNull List<Report> reports) {
        Intrinsics.checkNotNullParameter(reports, (String)"reports");
        this.dataFlowCount.addAndGet(((Collection)reports).size());
    }

    public void report(@NotNull CheckType checkType, @NotNull PreAnalysisReportEnv info2) {
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter((Object)info2, (String)"info");
        this.preAnalysisResultCount.addAndGet(1);
    }

    public void report(@NotNull Report report) {
        Intrinsics.checkNotNullParameter((Object)report, (String)"report");
        this.builtInAnalysisCount.addAndGet(1);
    }

    @Nullable
    public Object flush(@NotNull Continuation<? super Unit> $completion) {
        logger.info(() -> ResultCounter.flush$lambda$0(this));
        logger.info(() -> ResultCounter.flush$lambda$1(this));
        logger.info(() -> ResultCounter.flush$lambda$2(this));
        logger.info(() -> ResultCounter.flush$lambda$3(this));
        logger.info(() -> ResultCounter.flush$lambda$4(this));
        logger.info(() -> ResultCounter.flush$lambda$5(this));
        return Unit.INSTANCE;
    }

    private static final Object flush$lambda$0(ResultCounter this$0) {
        return "num of infoflow results: " + this$0.infoflowResCount.get();
    }

    private static final Object flush$lambda$1(ResultCounter this$0) {
        return "num of infoflow abstraction at sink: " + this$0.infoflowAbsAtSinkCount.get();
    }

    private static final Object flush$lambda$2(ResultCounter this$0) {
        return "num of symbolic execution results: " + this$0.symbolicUTbotCount.get();
    }

    private static final Object flush$lambda$3(ResultCounter this$0) {
        return "num of PreAnalysis results: " + this$0.preAnalysisResultCount.get();
    }

    private static final Object flush$lambda$4(ResultCounter this$0) {
        return "num of built-in Analysis results: " + this$0.builtInAnalysisCount.get();
    }

    private static final Object flush$lambda$5(ResultCounter this$0) {
        return "num of AbstractInterpretationAnalysis results: " + this$0.dataFlowCount.get();
    }

    private static final Unit logger$lambda$6() {
        return Unit.INSTANCE;
    }
}

