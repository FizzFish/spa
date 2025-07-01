package cn.sast.dataflow.interprocedural.analysis;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.MutableDirectedGraph;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public final class AIContext extends Context<SootMethod, Unit, IFact<IValue>> {
    public static final class Companion {
        public static void reportByEntry(Set<IPath> notCompleteReport, PathGenerator generator, 
                                       DirectedGraph<IPath> directGraph, Set<IPath> notEntryPaths,
                                       ProgramStateContext ctx, CheckerModeling.Checker definition,
                                       SootInfoCache info, InterproceduralCFG icfg, 
                                       IIPAnalysisResultCollector result) {
            // Implementation would go here
        }
    }

    public static final Companion Companion = new Companion();

    @Nullable
    private final SootInfoCache info;
    @NotNull
    private final InterproceduralCFG icfg;
    @NotNull
    private final IIPAnalysisResultCollector result;
    private Set<EntryPath> entries;
    @NotNull
    private final Set<NotCompleteReport> reports = new LinkedHashSet<>();

    public AIContext(@Nullable SootInfoCache info, @NotNull InterproceduralCFG icfg, 
                    @NotNull IIPAnalysisResultCollector result, @NotNull SootMethod method, 
                    @NotNull DirectedGraph<Unit> cfg, boolean reverse, boolean isAnalyzable) {
        super(method, cfg, reverse, isAnalyzable);
        this.info = info;
        this.icfg = icfg;
        this.result = result;
    }

    @Nullable
    public SootInfoCache getInfo() {
        return info;
    }

    @NotNull
    public InterproceduralCFG getIcfg() {
        return icfg;
    }

    @NotNull
    public IIPAnalysisResultCollector getResult() {
        return result;
    }

    @NotNull
    public Set<EntryPath> getEntries() {
        if (entries == null) {
            throw new IllegalStateException("entries must be initialized");
        }
        return entries;
    }

    public void setEntries(@NotNull Set<EntryPath> entries) {
        this.entries = entries;
    }

    @NotNull
    public Set<NotCompleteReport> getReports() {
        return reports;
    }

    public boolean report(@NotNull IPath paths, @NotNull ProgramStateContext ctx, 
                         @NotNull CheckerModeling.Checker definition) {
        PathGenerator generator = PathGeneratorImpl.Companion.getPathGenerator();
        HashMutableDirectedGraph<IPath> directGraph = new HashMutableDirectedGraph<>();
        Set<IPath> heads = generator.getHeads(paths, directGraph);
        
        Set<IPath> notEntryPaths = new LinkedHashSet<>();
        Set<IPath> notCompleteReport = new LinkedHashSet<>();
        
        for (IPath head : heads) {
            if (head instanceof EntryPath) {
                notCompleteReport.add(head);
            } else {
                notEntryPaths.add(head);
            }
        }

        if (!notCompleteReport.isEmpty()) {
            reports.add(new NotCompleteReport(notCompleteReport, paths, ctx, definition));
        }

        if (!notEntryPaths.isEmpty()) {
            Companion.reportByEntry(notCompleteReport, generator, directGraph, notEntryPaths, 
                                  ctx, definition, info, icfg, result);
            return true;
        }

        if (notCompleteReport.isEmpty()) {
            flushInvalidPathReports(paths, ctx, definition);
        }
        return !notCompleteReport.isEmpty();
    }

    private void flushInvalidPathReports(IPath sink, ProgramStateContext ctx, 
                                       CheckerModeling.Checker definition) {
        PathGenerator generator = PathGeneratorImpl.Companion.getPathGenerator();
        HashMutableDirectedGraph<IPath> directGraph = new HashMutableDirectedGraph<>();
        Set<IPath> heads = generator.getHeads(sink, directGraph);
        Companion.reportByEntry(Set.of(), generator, directGraph, heads, ctx, 
                              definition, info, icfg, result);
    }

    public void activeReport(@NotNull AIContext callee, 
                           @NotNull PointsToGraphBuilder.PathTransfer pathTransfer) {
        for (NotCompleteReport report : callee.reports) {
            InvokeEdgePath p = pathTransfer.transform(report.getSink(), report.getEntries());
            report(p, report.getCtx(), report.getDefine());
        }
    }

    public static final class NotCompleteReport {
        // Implementation would go here
    }
}
