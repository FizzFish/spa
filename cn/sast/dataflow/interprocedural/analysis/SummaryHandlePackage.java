package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;

/**
 * Interface for handling package summaries in interprocedural analysis.
 * @param <V> the type of values being analyzed
 */
public interface SummaryHandlePackage<V> {
    /**
     * Registers the analysis with this summary handler.
     * @param analysis the check call analysis to register
     */
    void register(@NotNull ACheckCallAnalysis<V> analysis);
}