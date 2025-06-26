/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.cli.command.SrcAnalyzeOptions
 *  cn.sast.cli.command.TargetOptions
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.custom.EmptyEntryProvider
 *  cn.sast.framework.report.ProjectFileLocator
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.options.Options
 */
package cn.sast.cli.command;

import cn.sast.api.config.MainConfig;
import cn.sast.cli.command.TargetOptions;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.custom.EmptyEntryProvider;
import cn.sast.framework.report.ProjectFileLocator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.options.Options;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2={"Lcn/sast/cli/command/SrcAnalyzeOptions;", "Lcn/sast/cli/command/TargetOptions;", "<init>", "()V", "getProvider", "Lcn/sast/framework/entries/IEntryPointProvider;", "sootCtx", "Lcn/sast/framework/SootCtx;", "locator", "Lcn/sast/framework/report/ProjectFileLocator;", "configureMainConfig", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "initSoot", "corax-cli"})
public final class SrcAnalyzeOptions
extends TargetOptions {
    public SrcAnalyzeOptions() {
        super("Src Analyze Options");
    }

    @NotNull
    public IEntryPointProvider getProvider(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator2) {
        Intrinsics.checkNotNullParameter((Object)sootCtx, (String)"sootCtx");
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        return (IEntryPointProvider)EmptyEntryProvider.INSTANCE;
    }

    public void configureMainConfig(@NotNull MainConfig mainConfig) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        mainConfig.setSkipClass(true);
    }

    public void initSoot(@NotNull SootCtx sootCtx, @NotNull ProjectFileLocator locator2) {
        Options options;
        Intrinsics.checkNotNullParameter((Object)sootCtx, (String)"sootCtx");
        Intrinsics.checkNotNullParameter((Object)locator2, (String)"locator");
        Options $this$initSoot_u24lambda_u240 = options = Options.v();
        boolean bl = false;
        $this$initSoot_u24lambda_u240.set_process_dir(CollectionsKt.emptyList());
        $this$initSoot_u24lambda_u240.set_src_prec(2);
        $this$initSoot_u24lambda_u240.set_prepend_classpath(true);
        $this$initSoot_u24lambda_u240.set_whole_program(true);
        $this$initSoot_u24lambda_u240.set_no_bodies_for_excluded(true);
        $this$initSoot_u24lambda_u240.set_include_all(false);
        $this$initSoot_u24lambda_u240.set_allow_phantom_refs(true);
        $this$initSoot_u24lambda_u240.set_ignore_resolving_levels(true);
        $this$initSoot_u24lambda_u240.setPhaseOption("cg.spark", "on");
        $this$initSoot_u24lambda_u240.setPhaseOption("cg", "types-for-invoke:true");
        $this$initSoot_u24lambda_u240.setPhaseOption("jb.sils", "enabled:false");
        Scene.v().loadNecessaryClasses();
    }
}

