package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import soot.Main;
import soot.Scene;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.options.Options;

public interface ISootInitializeHandler {
    default void configure(@NotNull Options options) {
    }

    default void configure(@NotNull Scene scene) {
    }

    default void configureAfterSceneInit(@NotNull Scene scene, @NotNull Options options) {
    }

    default void configure(@NotNull Main main) {
    }

    default void onBeforeCallGraphConstruction(@NotNull Scene scene, @NotNull Options options) {
    }

    default void onAfterCallGraphConstruction(@NotNull CallGraph cg, @NotNull Scene scene, @NotNull Options options) {
    }
}