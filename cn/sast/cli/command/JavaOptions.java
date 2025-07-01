package cn.sast.cli.command;

import cn.sast.api.config.MainConfig;
import cn.sast.cli.command.IClassAnalyzeOptionGroup;
import cn.sast.cli.command.TargetOptions;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.component.HybridUnReachThenComponent;
import cn.sast.framework.entries.custom.CustomEntryProvider;
import cn.sast.framework.entries.custom.HybridCustomThenComponent;
import cn.sast.framework.entries.java.UnReachableEntryProvider;
import cn.sast.framework.report.ProjectFileLocator;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.options.FlagOptionKt;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.InfoflowConfiguration;

public final class JavaOptions extends TargetOptions implements IClassAnalyzeOptionGroup {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(JavaOptions.class);
    private final OptionWithValues<String> customEntryPointOption;
    private final OptionWithValues<Boolean> makeComponentDummyMainOption;
    private final OptionWithValues<Boolean> disableJavaEEComponentOption;
    private InfoflowConfiguration infoFlowConfig;

    public JavaOptions() {
        super("Java Target Options");
        this.customEntryPointOption = OptionWithValuesKt.option(
            this, 
            new String[0], 
            null, 
            "method signature, signature file", 
            false, 
            null, 
            null, 
            null, 
            null, 
            false, 
            506, 
            null
        ).multiple().help("Sets the entry point method(s) for analyze.");

        this.makeComponentDummyMainOption = OptionWithValuesKt.option(
            this, 
            new String[0], 
            "Simple entry point creator that builds a sequential list of method invocations. Each method is invoked only once.", 
            null, 
            false, 
            null, 
            null, 
            null, 
            null, 
            false, 
            508, 
            null
        ).flag();

        this.disableJavaEEComponentOption = OptionWithValuesKt.option(
            this, 
            new String[]{"--disable-javaee-component"}, 
            "disable create the JavaEE lifecycle component methods", 
            null, 
            false, 
            null, 
            null, 
            null, 
            null, 
            false, 
            508, 
            null
        ).flag();
    }

    private List<String> getCustomEntryPoint() {
        return customEntryPointOption.getValue();
    }

    @NotNull
    public InfoflowConfiguration getInfoFlowConfig() {
        if (infoFlowConfig == null) {
            infoFlowConfig = new InfoflowConfiguration();
        }
        return infoFlowConfig;
    }

    private boolean getMakeComponentDummyMain() {
        return makeComponentDummyMainOption.getValue();
    }

    private boolean getDisableJavaEEComponent() {
        return disableJavaEEComponentOption.getValue();
    }

    @NotNull
    public IEntryPointProvider getProvider(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator) {
        Set<String> entries = EntryPointCreatorFactory.INSTANCE.getEntryPointFromArgs(getCustomEntryPoint()).invoke();
        
        if (getMakeComponentDummyMain()) {
            return !entries.isEmpty() 
                ? new HybridCustomThenComponent(sootCtx, entries) 
                : new HybridUnReachThenComponent(sootCtx);
        }
        
        return !entries.isEmpty() 
            ? new CustomEntryProvider(entries) 
            : getDisableJavaEEComponent() 
                ? new UnReachableEntryProvider(sootCtx) 
                : EntryPointCreatorFactory.createDefaultEntryProvider(sootCtx);
    }

    public void configureMainConfig(@NotNull MainConfig mainConfig) {
        // Configuration logic if needed
    }

    public void initSoot(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator) {
        sootCtx.configureSoot();
        sootCtx.constructSoot(locator);
    }
}