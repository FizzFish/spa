package cn.sast.dataflow.infoflow.provider;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.jimple.infoflow.data.SootMethodAndClass;
import soot.jimple.infoflow.sourcesSinks.definitions.AccessPathTuple;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinition;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;
import soot.jimple.infoflow.sourcesSinks.definitions.MethodSourceSinkDefinition;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class SourceSinkProvider implements ISourceSinkProvider {
    public static final class Companion {
        private Companion() {}
    }

    public static final Companion Companion = new Companion();

    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final PreAnalysisCoroutineScope preAnalysisImpl;
    @NotNull
    private ConcurrentHashMap<SootMethod, MethodModel> sourceDefinitions = new ConcurrentHashMap<>();
    @NotNull
    private ConcurrentHashMap<SootMethod, MethodModel> sinkDefinitions = new ConcurrentHashMap<>();
    @NotNull
    private final Set<ITaintType> checkTypesInSink = new LinkedHashSet<>();
    @NotNull
    private Set<ISourceSinkDefinition> sourceSet = new LinkedHashSet<>();
    @NotNull
    private Set<ISourceSinkDefinition> sinkSet = new LinkedHashSet<>();
    @NotNull
    private Set<ISourceSinkDefinition> allMethods = new LinkedHashSet<>();
    @NotNull
    private Set<Object> missClass = new LinkedHashSet<>();

    public SourceSinkProvider(@NotNull MainConfig mainConfig, @NotNull PreAnalysisCoroutineScope preAnalysisImpl) {
        if (mainConfig == null) throw new IllegalArgumentException("mainConfig cannot be null");
        if (preAnalysisImpl == null) throw new IllegalArgumentException("preAnalysisImpl cannot be null");
        this.mainConfig = mainConfig;
        this.preAnalysisImpl = preAnalysisImpl;
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @NotNull
    public ConcurrentHashMap<SootMethod, MethodModel> getSourceDefinitions() {
        return sourceDefinitions;
    }

    public void setSourceDefinitions(@NotNull ConcurrentHashMap<SootMethod, MethodModel> sourceDefinitions) {
        if (sourceDefinitions == null) throw new IllegalArgumentException("sourceDefinitions cannot be null");
        this.sourceDefinitions = sourceDefinitions;
    }

    @NotNull
    public ConcurrentHashMap<SootMethod, MethodModel> getSinkDefinitions() {
        return sinkDefinitions;
    }

    public void setSinkDefinitions(@NotNull ConcurrentHashMap<SootMethod, MethodModel> sinkDefinitions) {
        if (sinkDefinitions == null) throw new IllegalArgumentException("sinkDefinitions cannot be null");
        this.sinkDefinitions = sinkDefinitions;
    }

    @NotNull
    public Set<ITaintType> getCheckTypesInSink() {
        return checkTypesInSink;
    }

    @NotNull
    public Set<ISourceSinkDefinition> getSourceSet() {
        return sourceSet;
    }

    public void setSourceSet(@NotNull Set<ISourceSinkDefinition> sourceSet) {
        if (sourceSet == null) throw new IllegalArgumentException("sourceSet cannot be null");
        this.sourceSet = sourceSet;
    }

    @NotNull
    public Set<ISourceSinkDefinition> getSinkSet() {
        return sinkSet;
    }

    public void setSinkSet(@NotNull Set<ISourceSinkDefinition> sinkSet) {
        if (sinkSet == null) throw new IllegalArgumentException("sinkSet cannot be null");
        this.sinkSet = sinkSet;
    }

    @NotNull
    public Set<ISourceSinkDefinition> getAllMethods() {
        return allMethods;
    }

    public void setAllMethods(@NotNull Set<ISourceSinkDefinition> allMethods) {
        if (allMethods == null) throw new IllegalArgumentException("allMethods cannot be null");
        this.allMethods = allMethods;
    }

    @Override
    @NotNull
    public Collection<ISourceSinkDefinition> getSources() {
        return sourceSet;
    }

    @Override
    @NotNull
    public Collection<ISourceSinkDefinition> getSinks() {
        return sinkSet;
    }

    @Override
    @NotNull
    public Collection<ISourceSinkDefinition> getAllMethods() {
        Set<ISourceSinkDefinition> result = new LinkedHashSet<>(sourceSet);
        result.addAll(sinkSet);
        return result;
    }

    private static class MethodModel {
        // Implementation of MethodModel inner class
        // (omitted for brevity, should be implemented with appropriate fields and methods)
    }
}
