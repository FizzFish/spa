package cn.sast.dataflow.analysis.deadstore;

import cn.sast.dataflow.analysis.IBugReporter;
import org.jetbrains.annotations.NotNull;
import soot.Unit;
import soot.toolkits.graph.DirectedBodyGraph;

public final class DeadStore {
    @NotNull
    private final IBugReporter reporter;

    public DeadStore(@NotNull IBugReporter reporter) {
        if (reporter == null) {
            throw new IllegalArgumentException("reporter cannot be null");
        }
        this.reporter = reporter;
    }

    public void analyze(@NotNull DirectedBodyGraph<Unit> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("graph cannot be null");
        }
        // Analysis implementation would go here
    }
}