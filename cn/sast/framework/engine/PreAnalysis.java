package cn.sast.framework.engine;

import cn.sast.api.config.MainConfig;
import cn.sast.framework.SootCtx;
import cn.sast.framework.metrics.MetricsMonitor;
import cn.sast.framework.report.IProjectFileLocator;
import cn.sast.framework.result.IPreAnalysisResultCollector;
import cn.sast.idfa.analysis.ProcessInfoView;
import com.feysh.corax.cache.analysis.SootInfoCache;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class PreAnalysis {
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(PreAnalysis.class);
    @NotNull
    private final MainConfig mainConfig;

    public PreAnalysis(@NotNull MainConfig mainConfig) {
        if (mainConfig == null) {
            throw new IllegalArgumentException("mainConfig cannot be null");
        }
        this.mainConfig = mainConfig;
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    @Nullable
    public Object analyzeInScene(
            @NotNull SootCtx soot,
            @NotNull IProjectFileLocator locator,
            @NotNull SootInfoCache info,
            @NotNull IPreAnalysisResultCollector resultCollector,
            @NotNull MetricsMonitor monitor) {
        
        if (soot == null) throw new IllegalArgumentException("soot cannot be null");
        if (locator == null) throw new IllegalArgumentException("locator cannot be null");
        if (info == null) throw new IllegalArgumentException("info cannot be null");
        if (resultCollector == null) throw new IllegalArgumentException("resultCollector cannot be null");
        if (monitor == null) throw new IllegalArgumentException("monitor cannot be null");

        logger.info(() -> "Before PreAnalysis: Process information: " + 
            ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText());

        LocalDateTime startTime = LocalDateTime.now();
        try {
            Scene scene = Scene.v();
            var callGraph = soot.getSootMethodCallGraph();
            PreAnalysisImpl analysisImpl = new PreAnalysisImpl(
                mainConfig, locator, callGraph, info, resultCollector, scene);

            analysisImpl.processPreAnalysisUnits();

            List<String> analyzedClassNames = new ArrayList<>();
            for (SootClass clazz : analysisImpl.getAnalyzedClasses()) {
                analyzedClassNames.add(clazz.getName());
            }
            monitor.getProjectMetrics().getAnalyzedClasses().addAll(analyzedClassNames);
            monitor.getProjectMetrics().setAnalyzedFiles(
                analysisImpl.getAnalyzedSourceFiles().size());

            logger.info(() -> "After PreAnalysis: Process information: " + 
                ProcessInfoView.Companion.getGlobalProcessInfo().getProcessInfoText());
            
            return null; // Unit equivalent
        } catch (Exception e) {
            logger.error(() -> "PreAnalysis failed after " + 
                java.time.Duration.between(startTime, LocalDateTime.now()), e);
            throw e;
        }
    }
}
