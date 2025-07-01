package cn.sast.framework.entries.java;

import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UnReachableEntryProvider implements IEntryPointProvider {
    private static final KLogger logger = KotlinLogging.logger(UnReachableEntryProvider.class);
    
    private final SootCtx ctx;
    private final Set<String> exclude;
    
    public UnReachableEntryProvider(@NotNull SootCtx ctx, @NotNull Set<String> exclude) {
        if (ctx == null) throw new IllegalArgumentException("ctx cannot be null");
        if (exclude == null) throw new IllegalArgumentException("exclude cannot be null");
        this.ctx = ctx;
        this.exclude = exclude;
    }

    public UnReachableEntryProvider(@NotNull SootCtx ctx) {
        this(ctx, new LinkedHashSet<>());
    }

    @NotNull
    public Set<String> getExclude() {
        return exclude;
    }

    @NotNull
    @Override
    public Set<SootMethod> getEntryMethods() {
        Scene scene = Scene.v();
        Chain<SootClass> reachClasses = scene.getApplicationClasses();
        logger.info(() -> "reach classes num: " + reachClasses.size());

        List<SootMethod> allMethods = new ArrayList<>();
        for (SootClass sootClass : reachClasses) {
            allMethods.addAll(sootClass.getMethods());
        }

        List<SootMethod> filteredMethods = allMethods.stream()
            .filter(method -> 
                !scene.isExcluded(method.getDeclaringClass().getName()) || 
                scene.isIncluded(method.getDeclaringClass().getName()))
            .collect(Collectors.toList());

        return EntryPointHelper.getEntryPoints(ctx, filteredMethods);
    }

    @NotNull
    @Override
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return Flow.empty(); // Simplified - original flow logic was unavailable
    }

    @Override
    public void startAnalyse() {
        // Default empty implementation
    }

    @Override
    public void endAnalyse() {
        // Default empty implementation
    }

    private static class EntryPointHelper {
        public static Set<SootMethod> getEntryPoints(SootCtx ctx, List<SootMethod> methods) {
            // Implementation would go here
            return new HashSet<>();
        }
    }
}