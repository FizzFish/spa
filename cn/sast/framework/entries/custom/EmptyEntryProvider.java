package cn.sast.framework.entries.custom;

import cn.sast.framework.entries.IEntryPointProvider;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

public final class EmptyEntryProvider implements IEntryPointProvider {
    @NotNull
    public static final EmptyEntryProvider INSTANCE = new EmptyEntryProvider();
    
    @NotNull
    private static final Flow<IEntryPointProvider.AnalyzeTask> iterator = FlowKt.emptyFlow();

    private EmptyEntryProvider() {
    }

    @Override
    @NotNull
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return iterator;
    }

    @Override
    public void startAnalyse() {
        // Default empty implementation
    }

    @Override
    public void endAnalyse() {
        // Default empty implementation
    }
}