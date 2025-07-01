package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Unit;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.LocalUses;
import soot.toolkits.scalar.SimpleLocalDefs;
import soot.util.Chain;

public final class LocalUsesAnalysis extends AnalysisKey<LocalUses> {
    @NotNull
    private final DirectedGraph<Unit> graph;
    @NotNull
    private final Set<Local> locals;
    @NotNull
    private final SimpleLocalDefs.FlowAnalysisMode mode;

    public LocalUsesAnalysis(@NotNull DirectedGraph<Unit> graph, @NotNull Set<? extends Local> locals, 
                            @NotNull SimpleLocalDefs.FlowAnalysisMode mode) {
        super(LocalUsesAnalysisFactory.INSTANCE.getKey());
        if (graph == null) throw new IllegalArgumentException("graph cannot be null");
        if (locals == null) throw new IllegalArgumentException("locals cannot be null");
        if (mode == null) throw new IllegalArgumentException("mode cannot be null");
        
        this.graph = graph;
        this.locals = Set.copyOf(locals);
        this.mode = mode;
    }

    public LocalUsesAnalysis(@NotNull UnitGraph graph) {
        this(graph, SimpleLocalDefs.FlowAnalysisMode.Automatic);
    }

    public LocalUsesAnalysis(@NotNull UnitGraph graph, @NotNull SimpleLocalDefs.FlowAnalysisMode mode) {
        this((DirectedGraph<Unit>) graph, Set.copyOf(graph.getBody().getLocals()), mode);
    }

    @NotNull
    public DirectedGraph<Unit> getGraph() {
        return graph;
    }

    @NotNull
    public Set<Local> getLocals() {
        return locals;
    }

    @NotNull
    public SimpleLocalDefs.FlowAnalysisMode getMode() {
        return mode;
    }

    @NotNull
    public LocalUsesAnalysis copy(@NotNull DirectedGraph<Unit> graph, @NotNull Set<? extends Local> locals, 
                                 @NotNull SimpleLocalDefs.FlowAnalysisMode mode) {
        return new LocalUsesAnalysis(graph, locals, mode);
    }

    @Override
    public String toString() {
        return "LocalUsesAnalysis(graph=" + graph + ", locals=" + locals + ", mode=" + mode + ")";
    }

    @Override
    public int hashCode() {
        int result = graph.hashCode();
        result = 31 * result + locals.hashCode();
        result = 31 * result + mode.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof LocalUsesAnalysis)) return false;
        
        LocalUsesAnalysis that = (LocalUsesAnalysis) other;
        return graph.equals(that.graph) 
            && locals.equals(that.locals) 
            && mode.equals(that.mode);
    }
}