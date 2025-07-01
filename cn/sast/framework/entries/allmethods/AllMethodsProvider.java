package cn.sast.framework.entries.allmethods;

import cn.sast.framework.entries.IEntryPointProvider;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import kotlinx.coroutines.flow.Flow;

public final class AllMethodsProvider implements IEntryPointProvider {
    @NotNull
    private final Collection<SootClass> classes;
    @NotNull
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;

    public AllMethodsProvider(@NotNull Collection<? extends SootClass> classes) {
        if (classes == null) {
            throw new IllegalArgumentException("classes cannot be null");
        }
        this.classes = classes;
        this.iterator = createIterator();
    }

    public AllMethodsProvider() {
        this(Scene.v().getApplicationClasses());
    }

    private Flow<IEntryPointProvider.AnalyzeTask> createIterator() {
        // Implementation of flow creation would go here
        throw new UnsupportedOperationException("Flow creation not implemented");
    }

    @NotNull
    public Collection<SootClass> getClasses() {
        return classes;
    }

    @NotNull
    @Override
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
