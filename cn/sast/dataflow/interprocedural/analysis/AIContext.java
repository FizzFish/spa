/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AIContext
 *  cn.sast.dataflow.interprocedural.analysis.AIContext$Companion
 *  cn.sast.dataflow.interprocedural.analysis.AIContext$NotCompleteReport
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.EntryPath
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.InvokeEdgePath
 *  cn.sast.dataflow.interprocedural.check.PathGenerator
 *  cn.sast.dataflow.interprocedural.check.PathGeneratorImpl
 *  cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder$PathTransfer
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModeling$Checker
 *  cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector
 *  cn.sast.dataflow.interprocedural.check.checker.ProgramStateContext
 *  cn.sast.graph.HashMutableDirectedGraph
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Unit
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.MutableDirectedGraph
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AIContext;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.EntryPath;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.InvokeEdgePath;
import cn.sast.dataflow.interprocedural.check.PathGenerator;
import cn.sast.dataflow.interprocedural.check.PathGeneratorImpl;
import cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModeling;
import cn.sast.dataflow.interprocedural.check.checker.IIPAnalysisResultCollector;
import cn.sast.dataflow.interprocedural.check.checker.ProgramStateContext;
import cn.sast.graph.HashMutableDirectedGraph;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.InterproceduralCFG;
import com.feysh.corax.cache.analysis.SootInfoCache;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.MutableDirectedGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00040\u0001:\u000245BG\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J \u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0016\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u000203R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001f\u00a8\u00066"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/AIContext;", "Lcn/sast/idfa/analysis/Context;", "Lsoot/SootMethod;", "Lsoot/Unit;", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "result", "Lcn/sast/dataflow/interprocedural/check/checker/IIPAnalysisResultCollector;", "method", "cfg", "Lsoot/toolkits/graph/DirectedGraph;", "reverse", "", "isAnalyzable", "<init>", "(Lcom/feysh/corax/cache/analysis/SootInfoCache;Lcn/sast/idfa/analysis/InterproceduralCFG;Lcn/sast/dataflow/interprocedural/check/checker/IIPAnalysisResultCollector;Lsoot/SootMethod;Lsoot/toolkits/graph/DirectedGraph;ZZ)V", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "getIcfg", "()Lcn/sast/idfa/analysis/InterproceduralCFG;", "getResult", "()Lcn/sast/dataflow/interprocedural/check/checker/IIPAnalysisResultCollector;", "entries", "", "Lcn/sast/dataflow/interprocedural/check/EntryPath;", "getEntries", "()Ljava/util/Set;", "setEntries", "(Ljava/util/Set;)V", "reports", "", "Lcn/sast/dataflow/interprocedural/analysis/AIContext$NotCompleteReport;", "getReports", "report", "paths", "Lcn/sast/dataflow/interprocedural/check/IPath;", "ctx", "Lcn/sast/dataflow/interprocedural/check/checker/ProgramStateContext;", "definition", "Lcn/sast/dataflow/interprocedural/check/checker/CheckerModeling$Checker;", "flushInvalidPathReports", "", "sink", "activeReport", "callee", "pathTransfer", "Lcn/sast/dataflow/interprocedural/check/PointsToGraphBuilder$PathTransfer;", "NotCompleteReport", "Companion", "corax-data-flow"})
public final class AIContext
extends Context<SootMethod, Unit, IFact<IValue>> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final SootInfoCache info;
    @NotNull
    private final InterproceduralCFG icfg;
    @NotNull
    private final IIPAnalysisResultCollector result;
    public Set<EntryPath> entries;
    @NotNull
    private final Set<NotCompleteReport> reports;

    public AIContext(@Nullable SootInfoCache info2, @NotNull InterproceduralCFG icfg, @NotNull IIPAnalysisResultCollector result, @NotNull SootMethod method, @NotNull DirectedGraph<Unit> cfg, boolean reverse, boolean isAnalyzable) {
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter(cfg, (String)"cfg");
        super((Object)method, cfg, reverse, isAnalyzable);
        this.info = info2;
        this.icfg = icfg;
        this.result = result;
        this.reports = new LinkedHashSet();
    }

    @Nullable
    public final SootInfoCache getInfo() {
        return this.info;
    }

    @NotNull
    public final InterproceduralCFG getIcfg() {
        return this.icfg;
    }

    @NotNull
    public final IIPAnalysisResultCollector getResult() {
        return this.result;
    }

    @NotNull
    public final Set<EntryPath> getEntries() {
        Set set = this.entries;
        if (set != null) {
            return set;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"entries");
        return null;
    }

    public final void setEntries(@NotNull Set<EntryPath> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.entries = set;
    }

    @NotNull
    public final Set<NotCompleteReport> getReports() {
        return this.reports;
    }

    public final boolean report(@NotNull IPath paths, @NotNull ProgramStateContext ctx2, @NotNull CheckerModeling.Checker definition) {
        Intrinsics.checkNotNullParameter((Object)paths, (String)"paths");
        Intrinsics.checkNotNullParameter((Object)ctx2, (String)"ctx");
        Intrinsics.checkNotNullParameter((Object)definition, (String)"definition");
        PathGenerator generator = PathGeneratorImpl.Companion.getPathGenerator();
        HashMutableDirectedGraph directGraph = new HashMutableDirectedGraph();
        Set heads = generator.getHeads((Object)paths, (MutableDirectedGraph)directGraph);
        Set notEntryPaths = new LinkedHashSet();
        Set notCompleteReport = new LinkedHashSet();
        for (IPath head : heads) {
            boolean bl = head instanceof EntryPath ? notCompleteReport.add(head) : notEntryPaths.add(head);
        }
        if (!((Collection)notCompleteReport).isEmpty()) {
            this.reports.add(new NotCompleteReport(notCompleteReport, paths, ctx2, definition));
        }
        if (!((Collection)notEntryPaths).isEmpty()) {
            Companion.reportByEntry(notCompleteReport, generator, (DirectedGraph)directGraph, notEntryPaths, ctx2, definition, this.info, this.icfg, this.result);
            return true;
        }
        if (notCompleteReport.isEmpty()) {
            this.flushInvalidPathReports(paths, ctx2, definition);
        }
        return !((Collection)notCompleteReport).isEmpty();
    }

    private final void flushInvalidPathReports(IPath sink, ProgramStateContext ctx2, CheckerModeling.Checker definition) {
        PathGenerator generator = PathGeneratorImpl.Companion.getPathGenerator();
        HashMutableDirectedGraph directGraph = new HashMutableDirectedGraph();
        Set heads = generator.getHeads((Object)sink, (MutableDirectedGraph)directGraph);
        Companion.reportByEntry(SetsKt.emptySet(), generator, (DirectedGraph)directGraph, heads, ctx2, definition, this.info, this.icfg, this.result);
    }

    public final void activeReport(@NotNull AIContext callee, @NotNull PointsToGraphBuilder.PathTransfer pathTransfer) {
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter((Object)pathTransfer, (String)"pathTransfer");
        for (NotCompleteReport report : callee.reports) {
            InvokeEdgePath p;
            Intrinsics.checkNotNull((Object)pathTransfer.transform(report.getSink(), report.getEntries()));
            this.report((IPath)p, report.getCtx(), report.getDefine());
        }
    }
}

