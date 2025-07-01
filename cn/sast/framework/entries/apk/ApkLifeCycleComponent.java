package cn.sast.framework.entries.apk;

import cn.sast.api.config.MainConfig;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.apk.CallbackAnalyzerType;
import java.util.Arrays;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.SootMethod;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.handlers.PreAnalysisHandler;
import soot.jimple.infoflow.methodSummary.data.provider.IMethodSummaryProvider;
import soot.jimple.infoflow.methodSummary.taintWrappers.SummaryTaintWrapper;

public final class ApkLifeCycleComponent implements IEntryPointProvider {
    private static final Logger logger = LoggerFactory.getLogger(ApkLifeCycleComponent.class);
    
    @NotNull
    private String targetAPKFile;
    @NotNull
    private String androidPlatformDir;
    private final boolean oneComponentAtATime;
    private boolean ignoreFlowsInSystemPackages;
    private final boolean enableCallbacks;
    @NotNull
    private final String callbacksFile;
    @NotNull
    private CallbackAnalyzerType callbackAnalyzer;
    private boolean filterThreadCallbacks;
    private final int maxCallbacksPerComponent;
    private final int callbackAnalysisTimeout;
    private final int maxCallbackAnalysisDepth;
    private final boolean serializeCallbacks;
    @Nullable
    private String iccModel;
    private final boolean iccResultsPurify;
    @Nullable
    private SummaryTaintWrapper taintWrapper;
    
    private final InfoflowAndroidConfiguration config;
    private final WSetupApplication delegateSetupApplication;

    public ApkLifeCycleComponent(@NotNull String targetAPKFile, @NotNull String androidPlatformDir, 
            boolean oneComponentAtATime, boolean ignoreFlowsInSystemPackages, boolean enableCallbacks,
            @NotNull String callbacksFile, @NotNull CallbackAnalyzerType callbackAnalyzer, 
            boolean filterThreadCallbacks, int maxCallbacksPerComponent, int callbackAnalysisTimeout,
            int maxCallbackAnalysisDepth, boolean serializeCallbacks, @Nullable String iccModel, 
            boolean iccResultsPurify) {
        if (targetAPKFile == null) throw new IllegalArgumentException("targetAPKFile cannot be null");
        if (androidPlatformDir == null) throw new IllegalArgumentException("androidPlatformDir cannot be null");
        if (callbacksFile == null) throw new IllegalArgumentException("callbacksFile cannot be null");
        if (callbackAnalyzer == null) throw new IllegalArgumentException("callbackAnalyzer cannot be null");

        this.targetAPKFile = targetAPKFile;
        this.androidPlatformDir = androidPlatformDir;
        this.oneComponentAtATime = oneComponentAtATime;
        this.ignoreFlowsInSystemPackages = ignoreFlowsInSystemPackages;
        this.enableCallbacks = enableCallbacks;
        this.callbacksFile = callbacksFile;
        this.callbackAnalyzer = callbackAnalyzer;
        this.filterThreadCallbacks = filterThreadCallbacks;
        this.maxCallbacksPerComponent = maxCallbacksPerComponent;
        this.callbackAnalysisTimeout = callbackAnalysisTimeout;
        this.maxCallbackAnalysisDepth = maxCallbackAnalysisDepth;
        this.serializeCallbacks = serializeCallbacks;
        this.iccModel = iccModel;
        this.iccResultsPurify = iccResultsPurify;
        
        this.config = createConfig();
        this.delegateSetupApplication = createDelegateSetupApplication();
    }

    public ApkLifeCycleComponent(@NotNull InfoflowAndroidConfiguration c, @NotNull MainConfig mainConfig, 
            @NotNull String targetAPKFile) {
        if (c == null) throw new IllegalArgumentException("config cannot be null");
        if (mainConfig == null) throw new IllegalArgumentException("mainConfig cannot be null");
        if (targetAPKFile == null) throw new IllegalArgumentException("targetAPKFile cannot be null");

        String platformDir = mainConfig.getAndroidPlatformDir();
        if (platformDir == null) throw new IllegalStateException("Android platform dir cannot be null");
        
        this.targetAPKFile = targetAPKFile;
        this.androidPlatformDir = platformDir;
        this.oneComponentAtATime = c.getOneComponentAtATime();
        this.ignoreFlowsInSystemPackages = c.getIgnoreFlowsInSystemPackages();
        this.enableCallbacks = c.getCallbackConfig().getEnableCallbacks();
        this.callbacksFile = c.getCallbackConfig().getCallbacksFile();
        this.callbackAnalyzer = ApkLifeCycleComponentKt.getConvert(c.getCallbackConfig().getCallbackAnalyzer());
        this.filterThreadCallbacks = c.getCallbackConfig().getFilterThreadCallbacks();
        this.maxCallbacksPerComponent = c.getCallbackConfig().getMaxCallbacksPerComponent();
        this.callbackAnalysisTimeout = c.getCallbackConfig().getCallbackAnalysisTimeout();
        this.maxCallbackAnalysisDepth = c.getCallbackConfig().getMaxAnalysisCallbackDepth();
        this.serializeCallbacks = c.getCallbackConfig().isSerializeCallbacks();
        this.iccModel = c.getIccConfig().getIccModel();
        this.iccResultsPurify = c.getIccConfig().isIccResultsPurifyEnabled();
        
        this.config = createConfig();
        this.delegateSetupApplication = createDelegateSetupApplication();
    }

    private InfoflowAndroidConfiguration createConfig() {
        InfoflowAndroidConfiguration config = new InfoflowAndroidConfiguration();
        config.setIgnoreFlowsInSystemPackages(this.ignoreFlowsInSystemPackages);
        config.setSootIntegrationMode(InfoflowConfiguration.SootIntegrationMode.CreateNewInstance);
        config.setCallgraphAlgorithm(null);
        
        InfoflowAndroidConfiguration.IccConfiguration iccConfig = config.getIccConfig();
        iccConfig.setIccModel(this.iccModel);
        iccConfig.setIccResultsPurify(this.iccResultsPurify);
        
        InfoflowAndroidConfiguration.AnalysisFileConfiguration analysisFileConfig = config.getAnalysisFileConfig();
        analysisFileConfig.setTargetAPKFile(this.targetAPKFile);
        
        InfoflowAndroidConfiguration.CallbackConfiguration callbackConfig = config.getCallbackConfig();
        callbackConfig.setEnableCallbacks(this.enableCallbacks);
        callbackConfig.setCallbacksFile(this.callbacksFile);
        callbackConfig.setCallbackAnalyzer(ApkLifeCycleComponentKt.getConvert(this.callbackAnalyzer));
        callbackConfig.setFilterThreadCallbacks(this.filterThreadCallbacks);
        callbackConfig.setMaxCallbacksPerComponent(this.maxCallbacksPerComponent);
        callbackConfig.setCallbackAnalysisTimeout(this.callbackAnalysisTimeout);
        callbackConfig.setMaxAnalysisCallbackDepth(this.maxCallbackAnalysisDepth);
        callbackConfig.setSerializeCallbacks(this.serializeCallbacks);
        
        IResource targetFile = Resource.INSTANCE.of(this.targetAPKFile);
        if (!targetFile.getExists()) {
            String errorMsg = String.format("Target APK file %s does not exist", targetFile.getAbsolutePath());
            throw new IllegalStateException(errorMsg);
        }
        
        return config;
    }

    private WSetupApplication createDelegateSetupApplication() {
        this.config.getAnalysisFileConfig().setAndroidPlatformDir(this.androidPlatformDir);
        WSetupApplication app = new WSetupApplication(this, this.config);
        this.config.getAnalysisFileConfig().setAndroidPlatformDir("unused");
        return app;
    }

    // Getters and setters
    @NotNull
    public String getTargetAPKFile() {
        return targetAPKFile;
    }

    public void setTargetAPKFile(@NotNull String targetAPKFile) {
        if (targetAPKFile == null) throw new IllegalArgumentException("targetAPKFile cannot be null");
        this.targetAPKFile = targetAPKFile;
    }

    @NotNull
    public String getAndroidPlatformDir() {
        return androidPlatformDir;
    }

    public void setAndroidPlatformDir(@NotNull String androidPlatformDir) {
        if (androidPlatformDir == null) throw new IllegalArgumentException("androidPlatformDir cannot be null");
        this.androidPlatformDir = androidPlatformDir;
    }

    public boolean getOneComponentAtATime() {
        return oneComponentAtATime;
    }

    public boolean getIgnoreFlowsInSystemPackages() {
        return ignoreFlowsInSystemPackages;
    }

    public void setIgnoreFlowsInSystemPackages(boolean ignoreFlowsInSystemPackages) {
        this.ignoreFlowsInSystemPackages = ignoreFlowsInSystemPackages;
    }

    public boolean getEnableCallbacks() {
        return enableCallbacks;
    }

    @NotNull
    public String getCallbacksFile() {
        return callbacksFile;
    }

    @NotNull
    public CallbackAnalyzerType getCallbackAnalyzer() {
        return callbackAnalyzer;
    }

    public void setCallbackAnalyzer(@NotNull CallbackAnalyzerType callbackAnalyzer) {
        if (callbackAnalyzer == null) throw new IllegalArgumentException("callbackAnalyzer cannot be null");
        this.callbackAnalyzer = callbackAnalyzer;
    }

    public boolean getFilterThreadCallbacks() {
        return filterThreadCallbacks;
    }

    public void setFilterThreadCallbacks(boolean filterThreadCallbacks) {
        this.filterThreadCallbacks = filterThreadCallbacks;
    }

    public int getMaxCallbacksPerComponent() {
        return maxCallbacksPerComponent;
    }

    public int getCallbackAnalysisTimeout() {
        return callbackAnalysisTimeout;
    }

    public int getMaxCallbackAnalysisDepth() {
        return maxCallbackAnalysisDepth;
    }

    public boolean getSerializeCallbacks() {
        return serializeCallbacks;
    }

    @Nullable
    public String getIccModel() {
        return iccModel;
    }

    public void setIccModel(@Nullable String iccModel) {
        this.iccModel = iccModel;
    }

    public boolean getIccResultsPurify() {
        return iccResultsPurify;
    }

    @Nullable
    public SummaryTaintWrapper getTaintWrapper() {
        return taintWrapper;
    }

    public void setTaintWrapper(@Nullable SummaryTaintWrapper taintWrapper) {
        this.taintWrapper = taintWrapper;
    }

    @NotNull
    public InfoflowAndroidConfiguration getConfig() {
        return config;
    }

    private WSetupApplication getDelegateSetupApplication() {
        return delegateSetupApplication;
    }

    public void injectStubDroidHierarchy(@NotNull WSetupApplication analyzer) {
        if (analyzer == null) throw new IllegalArgumentException("analyzer cannot be null");
        if (taintWrapper != null) {
            IMethodSummaryProvider provider = taintWrapper.getProvider();
            analyzer.addPreprocessor(new PreAnalysisHandler() {
                // Implementation of preprocessor
            });
        }
    }

    public static class WSetupApplication {
        // Implementation of WSetupApplication
    }
}
