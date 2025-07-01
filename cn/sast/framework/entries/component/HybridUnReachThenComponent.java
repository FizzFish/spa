package cn.sast.framework.entries.component;

import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.java.UnReachableEntryProvider;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

public final class HybridUnReachThenComponent extends UnReachableEntryProvider {
    @NotNull
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;

    public HybridUnReachThenComponent(@NotNull SootCtx ctx) {
        super(ctx);
        this.iterator = createFlow();
    }

    @NotNull
    @Override
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return iterator;
    }

    private Flow<IEntryPointProvider.AnalyzeTask> createFlow() {
        // Implementation of flow creation would go here
        throw new UnsupportedOperationException("Flow creation not implemented");
    }
}