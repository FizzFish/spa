package cn.sast.cli.command;

import cn.sast.api.config.MainConfig;
import cn.sast.cli.command.IClassAnalyzeOptionGroup;
import cn.sast.cli.command.TargetOptions;
import cn.sast.common.IResource;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.apk.ApkLifeCycleComponent;
import cn.sast.framework.report.ProjectFileLocator;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.options.OptionDelegate;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.required;
import com.github.ajalt.clikt.parameters.options.flag;
import com.github.ajalt.clikt.parameters.options.help;
import com.github.ajalt.clikt.parameters.types.file;
import java.io.File;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration.AnalysisFileConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration.CallbackAnalyzer;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration.CallbackConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration.IccConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration.SourceSinkConfiguration;

public final class AndroidOptions extends TargetOptions implements IClassAnalyzeOptionGroup {
    private final OptionDelegate<File> androidPlatformDirDelegate;
    private final OptionDelegate<Boolean> oneComponentAtATimeDelegate;
    private final InfoflowAndroidConfiguration infoFlowConfig;

    public AndroidOptions() {
        super("Android Target Options");
        this.androidPlatformDirDelegate = file()
            .required()
            .help("Sets the android platform directory or path of android.jar. \nThe value of environment variable \"ANDROID_JARS\" is also accepted.")
            .delegate();
        this.oneComponentAtATimeDelegate = flag()
            .help("Set if analysis shall be performed on one entry of (Android component/Web application) at a time")
            .delegate();
        this.infoFlowConfig = createInfoFlowConfig();
    }

    private File getAndroidPlatformDir() {
        return androidPlatformDirDelegate.getValue();
    }

    private boolean getOneComponentAtATime() {
        return oneComponentAtATimeDelegate.getValue();
    }

    @NotNull
    public InfoflowAndroidConfiguration getInfoFlowConfig() {
        return infoFlowConfig;
    }

    @NotNull
    public IEntryPointProvider getProvider(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator) {
        Objects.requireNonNull(sootCtx, "sootCtx");
        Objects.requireNonNull(locator, "locator");
        MainConfig mainConfig = sootCtx.getMainConfig();
        String targetApkFile = getTargetApkFile(mainConfig);
        return new ApkLifeCycleComponent(getInfoFlowConfig(), mainConfig, targetApkFile);
    }

    public void configureMainConfig(@NotNull MainConfig mainConfig) {
        Objects.requireNonNull(mainConfig, "mainConfig");
        mainConfig.setAndroidPlatformDir(getAndroidPlatformDir().getAbsolutePath());
    }

    private String getTargetApkFile(MainConfig mainConfig) {
        var processDir = mainConfig.getProcessDir();
        if (processDir.size() != 1) {
            throw new IllegalStateException("process: " + processDir + " must be a single apk file");
        }
        return processDir.iterator().next().getAbsolutePath();
    }

    public void initSoot(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator) {
        Objects.requireNonNull(sootCtx, "sootCtx");
        Objects.requireNonNull(locator, "locator");
        MainConfig mainConfig = sootCtx.getMainConfig();
        String targetApkFile = getTargetApkFile(mainConfig);
        String androidJar = mainConfig.getAndroidJarClasspath(targetApkFile);
        if (androidJar == null) {
            throw new IllegalStateException("could not find android jar in androidPlatformDir: " + 
                mainConfig.getAndroidPlatformDir() + " with apk: " + targetApkFile);
        }
        mainConfig.setClasspath(mainConfig.getClasspath().add(androidJar));
        sootCtx.configureSoot();
        sootCtx.constructSoot(locator);
    }

    private InfoflowAndroidConfiguration createInfoFlowConfig() {
        InfoflowAndroidConfiguration config = new InfoflowAndroidConfiguration();
        
        AnalysisFileConfiguration fileConfig = config.getAnalysisFileConfig();
        fileConfig.setTargetAPKFile("unused");
        fileConfig.setSourceSinkFile("unused");
        fileConfig.setAndroidPlatformDir("unused");
        fileConfig.setAdditionalClasspath("unused");
        fileConfig.setOutputFile("unused");
        
        CallbackConfiguration callbackConfig = config.getCallbackConfig();
        callbackConfig.setEnableCallbacks(true);
        callbackConfig.setCallbackAnalyzer(CallbackAnalyzer.Default);
        callbackConfig.setFilterThreadCallbacks(true);
        callbackConfig.setMaxCallbacksPerComponent(100);
        callbackConfig.setCallbackAnalysisTimeout(0);
        callbackConfig.setMaxAnalysisCallbackDepth(-1);
        callbackConfig.setSerializeCallbacks(false);
        callbackConfig.setCallbacksFile("");
        
        config.getIccConfig().setIccModel(null);
        config.getIccConfig().setIccResultsPurify(true);
        
        config.setOneComponentAtATime(getOneComponentAtATime());
        return config;
    }
}
