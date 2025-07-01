package cn.sast.cli.command;

import cn.sast.api.config.MainConfig;
import cn.sast.cli.command.TargetOptions;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.custom.EmptyEntryProvider;
import cn.sast.framework.report.ProjectFileLocator;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.options.Options;
import java.util.Collections;

public final class SrcAnalyzeOptions extends TargetOptions {
    public SrcAnalyzeOptions() {
        super("Src Analyze Options");
    }

    @NotNull
    public IEntryPointProvider getProvider(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator) {
        return EmptyEntryProvider.INSTANCE;
    }

    public void configureMainConfig(@NotNull MainConfig mainConfig) {
        mainConfig.setSkipClass(true);
    }

    public void initSoot(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator) {
        Options options = Options.v();
        options.set_process_dir(Collections.emptyList());
        options.set_src_prec(2);
        options.set_prepend_classpath(true);
        options.set_whole_program(true);
        options.set_no_bodies_for_excluded(true);
        options.set_include_all(false);
        options.set_allow_phantom_refs(true);
        options.set_ignore_resolving_levels(true);
        options.setPhaseOption("cg.spark", "on");
        options.setPhaseOption("cg", "types-for-invoke:true");
        options.setPhaseOption("jb.sils", "enabled:false");
        Scene.v().loadNecessaryClasses();
    }
}