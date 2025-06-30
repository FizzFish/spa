/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Main
 *  soot.Scene
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.options.Options
 */
package com.feysh.corax.config.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.Main;
import soot.Scene;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.options.Options;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u000f"}, d2={"Lcom/feysh/corax/config/api/ISootInitializeHandler;", "", "configure", "", "options", "Lsoot/options/Options;", "scene", "Lsoot/Scene;", "configureAfterSceneInit", "main", "Lsoot/Main;", "onBeforeCallGraphConstruction", "onAfterCallGraphConstruction", "cg", "Lsoot/jimple/toolkits/callgraph/CallGraph;", "corax-config-api"})
public interface ISootInitializeHandler {
    public void configure(@NotNull Options var1);

    public void configure(@NotNull Scene var1);

    public void configureAfterSceneInit(@NotNull Scene var1, @NotNull Options var2);

    public void configure(@NotNull Main var1);

    public void onBeforeCallGraphConstruction(@NotNull Scene var1, @NotNull Options var2);

    public void onAfterCallGraphConstruction(@NotNull CallGraph var1, @NotNull Scene var2, @NotNull Options var3);

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static void configure(@NotNull ISootInitializeHandler $this, @NotNull Options options) {
            Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        }

        public static void configure(@NotNull ISootInitializeHandler $this, @NotNull Scene scene) {
            Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        }

        public static void configureAfterSceneInit(@NotNull ISootInitializeHandler $this, @NotNull Scene scene, @NotNull Options options) {
            Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
            Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        }

        public static void configure(@NotNull ISootInitializeHandler $this, @NotNull Main main) {
            Intrinsics.checkNotNullParameter((Object)main, (String)"main");
        }

        public static void onBeforeCallGraphConstruction(@NotNull ISootInitializeHandler $this, @NotNull Scene scene, @NotNull Options options) {
            Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
            Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        }

        public static void onAfterCallGraphConstruction(@NotNull ISootInitializeHandler $this, @NotNull CallGraph cg, @NotNull Scene scene, @NotNull Options options) {
            Intrinsics.checkNotNullParameter((Object)cg, (String)"cg");
            Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
            Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        }
    }
}

