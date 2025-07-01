package cn.sast.dataflow.infoflow.svfa;

import cn.sast.common.OS;
import cn.sast.dataflow.infoflow.svfa.AP;
import cn.sast.dataflow.infoflow.svfa.ILocalDFA;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.Unit;
import soot.toolkits.graph.UnitGraph;

public final class CacheFlowGuide {
    private final boolean trackControlFlowDependencies;
    private final CacheBuilder<Object, Object> flowCacheBuilder;
    private final LoadingCache<UnitGraph, ILocalDFA> cache;

    public CacheFlowGuide(boolean trackControlFlowDependencies) {
        this.trackControlFlowDependencies = trackControlFlowDependencies;
        this.flowCacheBuilder = CacheBuilder.newBuilder()
                .concurrencyLevel(OS.INSTANCE.getMaxThreadNum())
                .initialCapacity(getInitialCapacity())
                .maximumSize((long) (getInitialCapacity() * 2))
                .softValues();
        this.cache = flowCacheBuilder.build(new CacheLoader<>() {
            @Override
            public ILocalDFA load(UnitGraph graph) {
                return new ILocalDFA(graph, CacheFlowGuide.this.trackControlFlowDependencies);
            }
        });
    }

    public boolean getTrackControlFlowDependencies() {
        return trackControlFlowDependencies;
    }

    private int getInitialCapacity() {
        return Math.max(Scene.v().getClasses().size() * 10, 500);
    }

    @NotNull
    public List<Unit> getSuccess(boolean isForward, @NotNull AP ap, @NotNull Unit unit, @NotNull UnitGraph unitGraph) {
        ILocalDFA lu = cache.getUnchecked(unitGraph);
        return isForward ? lu.getUsesOfAt(ap, unit) : lu.getDefUsesOfAt(ap, unit);
    }
}