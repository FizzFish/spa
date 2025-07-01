package cn.sast.dataflow.infoflow.provider;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.PreAnalysisCoroutineScope;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IChecker;
import com.feysh.corax.config.api.baseimpl.AIAnalysisBaseImpl;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.SootMethod;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public final class BugTypeProvider {
    private static final Logger logger = LoggerFactory.getLogger(BugTypeProvider.class);
    
    private final MainConfig config;
    private final PreAnalysisCoroutineScope preAnalysisImpl;
    private Map<SootMethod, Set<CheckType>> methodToCheckType;
    private final AIAnalysisBaseImpl aiCheckerImpl;

    public BugTypeProvider(@NotNull MainConfig config, @NotNull PreAnalysisCoroutineScope preAnalysisImpl) {
        if (config == null) throw new IllegalArgumentException("config cannot be null");
        if (preAnalysisImpl == null) throw new IllegalArgumentException("preAnalysisImpl cannot be null");
        
        this.config = config;
        this.preAnalysisImpl = preAnalysisImpl;
        this.methodToCheckType = new LinkedHashMap<>();
        this.aiCheckerImpl = new AIAnalysisBaseImpl();
    }

    public @NotNull MainConfig getConfig() {
        return config;
    }

    public @NotNull PreAnalysisCoroutineScope getPreAnalysisImpl() {
        return preAnalysisImpl;
    }

    public void init() {
        // Implementation would go here
    }

    public @NotNull Set<IChecker> lookUpChecker(@NotNull SootMethod method) {
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        
        Set<CheckType> checkTypes = lookUpCheckType(method);
        Set<IChecker> checkers = new HashSet<>();
        
        for (CheckType type : checkTypes) {
            checkers.add(type.getChecker());
        }
        
        return checkers.isEmpty() ? Collections.emptySet() : checkers;
    }

    public @NotNull Set<CheckType> lookUpCheckType(@NotNull SootMethod method) {
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        
        return methodToCheckType.getOrDefault(method, Collections.emptySet());
    }
}
