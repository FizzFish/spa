package cn.sast.dataflow.infoflow.provider;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import cn.sast.api.config.PreAnalysisCoroutineScopeKt;
import com.feysh.corax.config.api.PreAnalysisApi;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.infoflow.methodSummary.data.provider.AbstractMethodSummaryProvider;
import soot.jimple.infoflow.methodSummary.data.summary.ClassMethodSummaries;
import soot.jimple.infoflow.methodSummary.data.summary.ClassSummaries;
import soot.jimple.infoflow.methodSummary.data.summary.MethodSummaries;
import soot.util.MultiMap;

public class MethodSummaryProvider extends AbstractMethodSummaryProvider {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(MethodSummaryProvider.class);
    private final ReentrantLock lock = new ReentrantLock();
    
    private final MainConfig mainConfig;
    private final PreAnalysisCoroutineScope preAnalysisImpl;
    private final Set<String> loadedClasses = new LinkedHashSet<>();
    private final ClassSummaries classSummaries = new ClassSummaries();
    private Set<String> subsigMethodsWithSummaries = new LinkedHashSet<>();
    private final ModelingConfigImpl aiCheckerImpl;

    public MethodSummaryProvider(@NotNull MainConfig mainConfig, @NotNull PreAnalysisCoroutineScope preAnalysisImpl) {
        if (mainConfig == null) throw new IllegalArgumentException("mainConfig cannot be null");
        if (preAnalysisImpl == null) throw new IllegalArgumentException("preAnalysisImpl cannot be null");
        
        this.mainConfig = mainConfig;
        this.preAnalysisImpl = preAnalysisImpl;
        this.aiCheckerImpl = new ModelingConfigImpl(this, preAnalysisImpl);
    }

    public MainConfig getMainConfig() {
        return mainConfig;
    }

    public PreAnalysisCoroutineScope getPreAnalysisImpl() {
        return preAnalysisImpl;
    }

    public ClassSummaries getClassSummaries() {
        return classSummaries;
    }

    public Set<String> getSubsigMethodsWithSummaries() {
        return subsigMethodsWithSummaries;
    }

    public void setSubsigMethodsWithSummaries(@NotNull Set<String> subsigMethodsWithSummaries) {
        if (subsigMethodsWithSummaries == null) throw new IllegalArgumentException("subsigMethodsWithSummaries cannot be null");
        this.subsigMethodsWithSummaries = subsigMethodsWithSummaries;
    }

    @Override
    public Set<String> getSupportedClasses() {
        return loadedClasses;
    }

    @Override
    public Set<String> getAllClassesWithSummaries() {
        return loadedClasses;
    }

    @Override
    public boolean supportsClass(@NotNull String clazz) {
        if (clazz == null) throw new IllegalArgumentException("clazz cannot be null");
        return loadedClasses.contains(clazz);
    }

    @Override
    @Nullable
    public ClassMethodSummaries getMethodFlows(@NotNull String className, @NotNull String methodSignature) {
        if (className == null) throw new IllegalArgumentException("className cannot be null");
        if (methodSignature == null) throw new IllegalArgumentException("methodSignature cannot be null");
        
        ClassMethodSummaries summaries = getClassSummaries(className);
        return summaries != null ? summaries.filterForMethod(methodSignature) : null;
    }

    @Override
    @Nullable
    public ClassSummaries getMethodFlows(@NotNull Set<String> classes, @NotNull String methodSignature) {
        if (classes == null) throw new IllegalArgumentException("classes cannot be null");
        if (methodSignature == null) throw new IllegalArgumentException("methodSignature cannot be null");
        
        return classSummaries.filterForMethod(classes, methodSignature);
    }

    @Override
    @Nullable
    public ClassMethodSummaries getClassFlows(@Nullable String clazz) {
        return classSummaries.getClassSummaries(clazz);
    }

    @Override
    public boolean mayHaveSummaryForMethod(@NotNull String subsig) {
        if (subsig == null) throw new IllegalArgumentException("subsig cannot be null");
        return subsigMethodsWithSummaries.contains(subsig);
    }

    @Override
    public ClassSummaries getSummaries() {
        return classSummaries;
    }

    @Override
    public boolean isMethodExcluded(@Nullable String className, @Nullable String subSignature) {
        ClassMethodSummaries summaries = getClassSummaries(className);
        return summaries != null && summaries.getMethodSummaries().isExcluded(subSignature);
    }

    @Override
    @Nullable
    public ClassMethodSummaries getClassSummaries(@Nullable String className) {
        return classSummaries.getClassSummaries(className);
    }

    @Override
    protected void addSubsigsForMethod(@NotNull MethodSummaries read) {
        if (read == null) throw new IllegalArgumentException("read cannot be null");
        
        MultiMap flows = read.getFlows();
        if (flows != null) {
            subsigMethodsWithSummaries.addAll(flows.keySet());
        }
        
        MultiMap clears = read.getClears();
        if (clears != null) {
            subsigMethodsWithSummaries.addAll(clears.keySet());
        }
    }

    @Override
    public void addMethodSummaries(@NotNull ClassMethodSummaries newSummaries) {
        if (newSummaries == null) throw new IllegalArgumentException("newSummaries cannot be null");
        
        lock.lock();
        try {
            MethodSummaries methodSummaries = newSummaries.getMethodSummaries();
            addSubsigsForMethod(methodSummaries);
            classSummaries.merge(newSummaries);
            loadedClasses.add(newSummaries.getClassName());
        } finally {
            lock.unlock();
        }
    }

    @Nullable
    public Object initialize(@NotNull Continuation<? super Unit> completion) {
        Object result = PreAnalysisCoroutineScopeKt.processAIAnalysisUnits(
            (AIAnalysisBaseImpl) aiCheckerImpl, 
            preAnalysisImpl, 
            completion
        );
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}