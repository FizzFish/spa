package cn.sast.framework.engine;

import cn.sast.api.config.MainConfig;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.graph.HashMutableDirectedGraph;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.ArrayList;
import soot.SootMethod;

public final class IPAnalysisEngine {
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final List<SummaryHandlePackage<IValue>> summaries;
    @NotNull
    private final HashMutableDirectedGraph<SootMethod> directedGraph;

    public IPAnalysisEngine(@NotNull MainConfig mainConfig, @NotNull List<? extends SummaryHandlePackage<IValue>> summaries) {
        if (mainConfig == null) {
            throw new IllegalArgumentException("mainConfig cannot be null");
        }
        if (summaries == null) {
            throw new IllegalArgumentException("summaries cannot be null");
        }
        this.mainConfig = mainConfig;
        this.summaries = new ArrayList<>(summaries);
        this.directedGraph = new HashMutableDirectedGraph<>();
    }

    public IPAnalysisEngine(@NotNull MainConfig mainConfig) {
        this(mainConfig, new ArrayList<>());
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @NotNull
    public List<SummaryHandlePackage<IValue>> getSummaries() {
        return summaries;
    }
}
