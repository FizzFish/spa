/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Local
 *  soot.Unit
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.UnitGraph
 *  soot.toolkits.scalar.LocalUses
 *  soot.toolkits.scalar.SimpleLocalDefs$FlowAnalysisMode
 *  soot.util.Chain
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.analysis.LocalUsesAnalysisFactory;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Unit;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.LocalUses;
import soot.toolkits.scalar.SimpleLocalDefs;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\r\u00a2\u0006\u0004\b\u000b\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\u000fJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00c6\u0003J3\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020!H\u00d6\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2={"Lcom/feysh/corax/cache/analysis/LocalUsesAnalysis;", "Lcom/feysh/corax/cache/AnalysisKey;", "Lsoot/toolkits/scalar/LocalUses;", "graph", "Lsoot/toolkits/graph/DirectedGraph;", "Lsoot/Unit;", "locals", "", "Lsoot/Local;", "mode", "Lsoot/toolkits/scalar/SimpleLocalDefs$FlowAnalysisMode;", "<init>", "(Lsoot/toolkits/graph/DirectedGraph;Ljava/util/Set;Lsoot/toolkits/scalar/SimpleLocalDefs$FlowAnalysisMode;)V", "Lsoot/toolkits/graph/UnitGraph;", "(Lsoot/toolkits/graph/UnitGraph;)V", "(Lsoot/toolkits/graph/UnitGraph;Lsoot/toolkits/scalar/SimpleLocalDefs$FlowAnalysisMode;)V", "getGraph", "()Lsoot/toolkits/graph/DirectedGraph;", "getLocals", "()Ljava/util/Set;", "getMode", "()Lsoot/toolkits/scalar/SimpleLocalDefs$FlowAnalysisMode;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-config-api"})
public final class LocalUsesAnalysis
extends AnalysisKey<LocalUses> {
    @NotNull
    private final DirectedGraph<Unit> graph;
    @NotNull
    private final Set<Local> locals;
    @NotNull
    private final SimpleLocalDefs.FlowAnalysisMode mode;

    public LocalUsesAnalysis(@NotNull DirectedGraph<Unit> graph, @NotNull Set<? extends Local> locals, @NotNull SimpleLocalDefs.FlowAnalysisMode mode) {
        Intrinsics.checkNotNullParameter(graph, (String)"graph");
        Intrinsics.checkNotNullParameter(locals, (String)"locals");
        Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
        super(LocalUsesAnalysisFactory.INSTANCE.getKey());
        this.graph = graph;
        this.locals = locals;
        this.mode = mode;
    }

    @NotNull
    public final DirectedGraph<Unit> getGraph() {
        return this.graph;
    }

    @NotNull
    public final Set<Local> getLocals() {
        return this.locals;
    }

    @NotNull
    public final SimpleLocalDefs.FlowAnalysisMode getMode() {
        return this.mode;
    }

    public LocalUsesAnalysis(@NotNull UnitGraph graph) {
        Intrinsics.checkNotNullParameter((Object)graph, (String)"graph");
        this(graph, SimpleLocalDefs.FlowAnalysisMode.Automatic);
    }

    public LocalUsesAnalysis(@NotNull UnitGraph graph, @NotNull SimpleLocalDefs.FlowAnalysisMode mode) {
        Intrinsics.checkNotNullParameter((Object)graph, (String)"graph");
        Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
        DirectedGraph directedGraph = (DirectedGraph)graph;
        Chain chain = graph.getBody().getLocals();
        Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getLocals(...)");
        this((DirectedGraph<Unit>)directedGraph, CollectionsKt.toSet((Iterable)((Iterable)chain)), mode);
    }

    @NotNull
    public final DirectedGraph<Unit> component1() {
        return this.graph;
    }

    @NotNull
    public final Set<Local> component2() {
        return this.locals;
    }

    @NotNull
    public final SimpleLocalDefs.FlowAnalysisMode component3() {
        return this.mode;
    }

    @NotNull
    public final LocalUsesAnalysis copy(@NotNull DirectedGraph<Unit> graph, @NotNull Set<? extends Local> locals, @NotNull SimpleLocalDefs.FlowAnalysisMode mode) {
        Intrinsics.checkNotNullParameter(graph, (String)"graph");
        Intrinsics.checkNotNullParameter(locals, (String)"locals");
        Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
        return new LocalUsesAnalysis(graph, locals, mode);
    }

    public static /* synthetic */ LocalUsesAnalysis copy$default(LocalUsesAnalysis localUsesAnalysis, DirectedGraph directedGraph, Set set, SimpleLocalDefs.FlowAnalysisMode flowAnalysisMode, int n, Object object) {
        if ((n & 1) != 0) {
            directedGraph = localUsesAnalysis.graph;
        }
        if ((n & 2) != 0) {
            set = localUsesAnalysis.locals;
        }
        if ((n & 4) != 0) {
            flowAnalysisMode = localUsesAnalysis.mode;
        }
        return localUsesAnalysis.copy(directedGraph, set, flowAnalysisMode);
    }

    @NotNull
    public String toString() {
        return "LocalUsesAnalysis(graph=" + this.graph + ", locals=" + this.locals + ", mode=" + this.mode + ")";
    }

    @Override
    public int hashCode() {
        int result = this.graph.hashCode();
        result = result * 31 + ((Object)this.locals).hashCode();
        result = result * 31 + this.mode.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalUsesAnalysis)) {
            return false;
        }
        LocalUsesAnalysis localUsesAnalysis = (LocalUsesAnalysis)other;
        if (!Intrinsics.areEqual(this.graph, localUsesAnalysis.graph)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.locals, localUsesAnalysis.locals)) {
            return false;
        }
        return this.mode == localUsesAnalysis.mode;
    }
}

