package cn.sast.cli.command;

import cn.sast.api.config.MainConfig;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.report.ProjectFileLocator;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import org.jetbrains.annotations.NotNull;

public abstract class TargetOptions extends OptionGroup {
    @NotNull
    private final String name;

    public TargetOptions(@NotNull String name) {
        super(name);
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return name;
    }

    @NotNull
    public abstract IEntryPointProvider getProvider(
        @NotNull SootCtx sootCtx,
        @NotNull ProjectFileLocator locator
    );

    public abstract void configureMainConfig(@NotNull MainConfig mainConfig);

    public abstract void initSoot(
        @NotNull SootCtx sootCtx,
        @NotNull ProjectFileLocator locator
    );
}