package cn.sast.framework.entries.component;

import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Scene;
import soot.SootMethod;

public final class ComponentEntryProvider implements IEntryPointProvider {
    private static final Logger logger = LoggerFactory.getLogger(ComponentEntryProvider.class);
    
    @NotNull
    private final SootCtx ctx;
    @NotNull
    private final Collection<String> entries;
    @NotNull
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;

    public ComponentEntryProvider(@NotNull SootCtx ctx, @NotNull Collection<String> entries) {
        if (ctx == null) throw new IllegalArgumentException("ctx cannot be null");
        if (entries == null) throw new IllegalArgumentException("entries cannot be null");
        
        this.ctx = ctx;
        this.entries = entries;
        this.iterator = Flow.empty(); // Simplified - original flow logic not available
    }

    @NotNull
    public Set<SootMethod> getMethod() {
        ComponentEntryPointCreator entryPointCreator = new ComponentEntryPointCreator(this.entries);
        SootMethod dummyMainMethod = entryPointCreator.createDummyMain();
        
        if (!dummyMainMethod.getDeclaringClass().isInScene()) {
            Scene.v().addClass(dummyMainMethod.getDeclaringClass());
        }
        dummyMainMethod.getDeclaringClass().setApplicationClass();
        return Collections.singleton(dummyMainMethod);
    }

    @Override
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
