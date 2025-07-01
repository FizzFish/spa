package com.feysh.corax.config.builtin.soot;

import com.feysh.corax.config.api.ISootInitializeHandler;
import org.jetbrains.annotations.NotNull;
import soot.Main;
import soot.Scene;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.options.Options;

public final class EmptySootConfiguration implements ISootInitializeHandler {
    public static final EmptySootConfiguration INSTANCE = new EmptySootConfiguration();

    private EmptySootConfiguration() {
    }

    @Override
    public void configure(@NotNull Options options) {
    }

    @Override
    public void configure(@NotNull Scene scene) {
    }

    @Override
    public void configure(@NotNull Main main) {
    }

    @Override
    public void configureAfterSceneInit(@NotNull Scene scene, @NotNull Options options) {
    }

    @Override
    public void onBeforeCallGraphConstruction(@NotNull Scene scene, @NotNull Options options) {
    }

    @Override
    public void onAfterCallGraphConstruction(@NotNull CallGraph cg, @NotNull Scene scene, @NotNull Options options) {
    }
}