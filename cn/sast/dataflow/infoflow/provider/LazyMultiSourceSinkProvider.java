package cn.sast.dataflow.infoflow.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinition;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;

public final class LazyMultiSourceSinkProvider implements ISourceSinkDefinitionProvider {
    @NotNull
    private final List<Supplier<ISourceSinkDefinitionProvider>> lazyProviders = new ArrayList<>();

    public boolean add(@NotNull Supplier<? extends ISourceSinkDefinitionProvider> provider) {
        if (provider == null) {
            throw new IllegalArgumentException("provider cannot be null");
        }
        return lazyProviders.add(provider);
    }

    @NotNull
    public Collection<? extends ISourceSinkDefinition> getSources() {
        List<ISourceSinkDefinition> result = new ArrayList<>();
        for (Supplier<ISourceSinkDefinitionProvider> provider : lazyProviders) {
            result.addAll(provider.get().getSources());
        }
        return result;
    }

    @NotNull
    public Collection<? extends ISourceSinkDefinition> getSinks() {
        List<ISourceSinkDefinition> result = new ArrayList<>();
        for (Supplier<ISourceSinkDefinitionProvider> provider : lazyProviders) {
            result.addAll(provider.get().getSinks());
        }
        return result;
    }

    @NotNull
    public Collection<? extends ISourceSinkDefinition> getAllMethods() {
        List<ISourceSinkDefinition> result = new ArrayList<>();
        for (Supplier<ISourceSinkDefinitionProvider> provider : lazyProviders) {
            result.addAll(provider.get().getAllMethods());
        }
        return result;
    }

    public int size() {
        return lazyProviders.size();
    }

    public boolean isEmpty() {
        return lazyProviders.isEmpty();
    }

    @NotNull
    public String toString() {
        return "MultiSourceSinkProvider(" + lazyProviders.size() + ")";
    }
}
