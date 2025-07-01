package cn.sast.framework.engine;

import java.lang.reflect.Method;
import java.util.Set;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.infoflow.AbstractInfoflow;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.sourcesSinks.manager.ISourceSinkManager;

public final class FlowDroidEngineKt {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(InfoflowConfiguration.class.getName());

    public static void fix(@NotNull InfoflowConfiguration config) {
        if (config == null) {
            throw new NullPointerException("config is null");
        }
        
        if (config instanceof InfoflowAndroidConfiguration) {
            InfoflowAndroidConfiguration androidConfig = (InfoflowAndroidConfiguration) config;
            if (androidConfig.getSourceSinkConfig().getEnableLifecycleSources() 
                    && androidConfig.getIccConfig().isIccEnabled()) {
                logger.warn("ICC model specified, automatically disabling lifecycle sources");
                androidConfig.getSourceSinkConfig().setEnableLifecycleSources(false);
            }
        }
    }

    public static void runAnalysisReflect(
            @NotNull AbstractInfoflow infoflow, 
            @NotNull ISourceSinkManager sourcesSinks, 
            @Nullable Set<String> additionalSeeds) throws Exception {
        if (infoflow == null) {
            throw new NullPointerException("infoflow is null");
        }
        if (sourcesSinks == null) {
            throw new NullPointerException("sourcesSinks is null");
        }

        Method method = AbstractInfoflow.class.getDeclaredMethod(
            "runAnalysis", 
            ISourceSinkManager.class, 
            Set.class
        );
        method.setAccessible(true);
        method.invoke(infoflow, sourcesSinks, additionalSeeds);
    }
}