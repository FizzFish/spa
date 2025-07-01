package cn.sast.framework.entries.custom;

import cn.sast.framework.entries.IEntryPointProvider;
import java.util.Arrays;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.SootMethod;

public class CustomEntryProvider implements IEntryPointProvider {
    private static final Logger logger = LoggerFactory.getLogger(CustomEntryProvider.class);
    private final Set<SootMethod> entries;
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;

    public CustomEntryProvider(@NotNull Set<? extends SootMethod> entries) {
        if (entries == null) {
            throw new IllegalArgumentException("entries cannot be null");
        }
        this.entries = entries;
        this.iterator = FlowKt.flow((scope, emitter) -> {
            for (SootMethod method : entries) {
                emitter.emit(new IEntryPointProvider.AnalyzeTask(method));
            }
        });
    }

    @NotNull
    public Set<SootMethod> getMethod() {
        if (this.entries.isEmpty()) {
            logger.warn("No entry points");
        }
        logger.info("custom entry methods num :{}", entries.size());
        return this.entries;
    }

    @NotNull
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return iterator;
    }

    @Override
    public void startAnalyse() {
        // Default implementation
    }

    @Override
    public void endAnalyse() {
        // Default implementation
    }
}