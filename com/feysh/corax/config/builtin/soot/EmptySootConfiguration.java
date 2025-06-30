/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.Main
 *  soot.Scene
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.options.Options
 */
package com.feysh.corax.config.builtin.soot;

import com.feysh.corax.config.api.ISootInitializeHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.Main;
import soot.Scene;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.options.Options;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lcom/feysh/corax/config/builtin/soot/EmptySootConfiguration;", "Lcom/feysh/corax/config/api/ISootInitializeHandler;", "<init>", "()V", "corax-config-api"})
public final class EmptySootConfiguration
implements ISootInitializeHandler {
    @NotNull
    public static final EmptySootConfiguration INSTANCE = new EmptySootConfiguration();

    private EmptySootConfiguration() {
    }

    @Override
    public void configure(@NotNull Options options) {
        ISootInitializeHandler.DefaultImpls.configure((ISootInitializeHandler)this, options);
    }

    @Override
    public void configure(@NotNull Scene scene) {
        ISootInitializeHandler.DefaultImpls.configure((ISootInitializeHandler)this, scene);
    }

    @Override
    public void configure(@NotNull Main main) {
        ISootInitializeHandler.DefaultImpls.configure((ISootInitializeHandler)this, main);
    }

    @Override
    public void configureAfterSceneInit(@NotNull Scene scene, @NotNull Options options) {
        ISootInitializeHandler.DefaultImpls.configureAfterSceneInit(this, scene, options);
    }

    @Override
    public void onBeforeCallGraphConstruction(@NotNull Scene scene, @NotNull Options options) {
        ISootInitializeHandler.DefaultImpls.onBeforeCallGraphConstruction(this, scene, options);
    }

    @Override
    public void onAfterCallGraphConstruction(@NotNull CallGraph cg, @NotNull Scene scene, @NotNull Options options) {
        ISootInitializeHandler.DefaultImpls.onAfterCallGraphConstruction(this, cg, scene, options);
    }
}

