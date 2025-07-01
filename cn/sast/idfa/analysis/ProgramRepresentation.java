package cn.sast.idfa.analysis;

import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.toolkits.graph.DirectedGraph;

public interface ProgramRepresentation<M, N> {
    @Nullable
    DirectedGraph<N> getControlFlowGraph(M method);

    @Nullable
    DirectedGraph<N> getSummaryControlFlowGraph(M method);

    boolean isCall(N node);

    boolean isAnalyzable(M method);

    @NotNull
    Set<M> getCalleesOfCallAt(M callerMethod, N callNode);

    boolean isSkipCall(N node);

    void setOwnerStatement(N u, M owner);

    void setOwnerStatement(@NotNull Iterable<? extends N> g, M owner);
}