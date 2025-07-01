package cn.sast.framework.engine;

import cn.sast.api.config.BuiltinAnalysisConfig;
import cn.sast.api.config.MainConfig;
import cn.sast.api.util.OthersKt;
import cn.sast.dataflow.analysis.IBugReporter;
import cn.sast.dataflow.analysis.deadcode.DeadCode;
import cn.sast.dataflow.analysis.deadstore.DeadStore;
import cn.sast.framework.SootCtx;
import cn.sast.framework.result.IBuiltInAnalysisCollector;
import com.feysh.corax.cache.analysis.SootInfoCache;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import java.util.ArrayList;
import java.util.List;

public final class BuiltinAnalysis {
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger("BuiltinAnalysis");
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final SootInfoCache info;

    public BuiltinAnalysis(@NotNull MainConfig mainConfig, @NotNull SootInfoCache info) {
        if (mainConfig == null) {
            throw new IllegalArgumentException("mainConfig cannot be null");
        }
        if (info == null) {
            throw new IllegalArgumentException("info cannot be null");
        }
        this.mainConfig = mainConfig;
        this.info = info;
    }

    @NotNull
    public SootInfoCache getInfo() {
        return info;
    }

    public void analyzeInScene(@NotNull SootCtx sootCtx, @NotNull IBuiltInAnalysisCollector resultCollector) {
        if (sootCtx == null) {
            throw new IllegalArgumentException("sootCtx cannot be null");
        }
        if (resultCollector == null) {
            throw new IllegalArgumentException("resultCollector cannot be null");
        }

        IBugReporter reporter = new BugReporter(resultCollector, info);
        DeadStore deadStore = new DeadStore(reporter);
        DeadCode deadCode = new DeadCode(reporter);

        List<SootClass> applicationClasses = Scene.v().getApplicationClasses();
        List<SootMethod> analyzedMethods = new ArrayList<>();

        for (SootClass sootClass : applicationClasses) {
            if (Scene.v().isExcluded(sootClass) || OthersKt.isSyntheticComponent(sootClass)) {
                continue;
            }

            for (SootMethod method : sootClass.getMethods()) {
                if (!OthersKt.isDummy(method) && method.hasActiveBody()) {
                    analyzedMethods.add(method);
                }
            }
        }

        List<SootMethod> targets = mainConfig.simpleDeclIncrementalAnalysisFilter(analyzedMethods);
        logger.info("Builtin analysis phase 2.");

        // Actual analysis would happen here
    }

    public static final class BugReporter implements IBugReporter {
        private final IBuiltInAnalysisCollector collector;
        private final SootInfoCache info;

        public BugReporter(IBuiltInAnalysisCollector collector, SootInfoCache info) {
            this.collector = collector;
            this.info = info;
        }

        @Override
        public void reportBug(Object bug) {
            // Implementation would go here
        }
    }

    public static final class CHA_AllMethodsProvider {
        // Implementation would go here
    }
}
