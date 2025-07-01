package com.feysh.corax.config.builtin.soot;

import com.feysh.corax.config.api.ISootInitializeHandler;
import com.feysh.corax.config.api.SAOptions;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import soot.Main;
import soot.Scene;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.options.Options;

public final class DefaultSootConfiguration implements ISootInitializeHandler {
    public static final DefaultSootConfiguration INSTANCE = new DefaultSootConfiguration();
    private static CustomOptions options = new CustomOptions();

    private DefaultSootConfiguration() {
    }

    public CustomOptions getOptions() {
        return options;
    }

    public void setOptions(@NotNull CustomOptions customOptions) {
        if (customOptions == null) {
            throw new IllegalArgumentException("customOptions cannot be null");
        }
        options = customOptions;
    }

    @Override
    public void configure(@NotNull Options options) {
        if (options == null) {
            throw new IllegalArgumentException("options cannot be null");
        }
        List<String> excludeList = new LinkedList<>();
        excludeList.addAll(DefaultSootConfiguration.options.getExcludeList());
        options.set_exclude(excludeList);
        
        for (Map.Entry<String, String> entry : DefaultSootConfiguration.options.getSootPhaseNameToOption().entrySet()) {
            options.setPhaseOption(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void configure(@NotNull Scene scene) {
        // Default implementation
    }

    @Override
    public void configure(@NotNull Main main) {
        // Default implementation
    }

    @Override
    public void configureAfterSceneInit(@NotNull Scene scene, @NotNull Options options) {
        // Default implementation
    }

    @Override
    public void onBeforeCallGraphConstruction(@NotNull Scene scene, @NotNull Options options) {
        // Default implementation
    }

    @Override
    public void onAfterCallGraphConstruction(@NotNull CallGraph cg, @NotNull Scene scene, @NotNull Options options) {
        // Default implementation
    }

    public static final class CustomOptions implements SAOptions {
        private final List<String> excludeList;
        private final Map<String, String> sootPhaseNameToOption;

        public CustomOptions() {
            this.excludeList = List.of(
                "java.*", "javax.*", "jdk.*", "com.apple.*", "apple.awt.*", 
                "org.w3c.*", "org.xml.*", "com.sun.*", "sun.*", "android.*", 
                "androidx.*", "org.slf4j.*", "org.apache.log4j.*", "org.apache.logging.*", 
                "java.util.logging.*", "ch.qos.logback.*", "com.mysql.*", "org.eclipse.*", "soot.*"
            );
            this.sootPhaseNameToOption = Map.of(
                "jb.sils", "enabled:false",
                "jb.tr", "ignore-nullpointer-dereferences:true"
            );
        }

        public List<String> getExcludeList() {
            return excludeList;
        }

        public Map<String, String> getSootPhaseNameToOption() {
            return sootPhaseNameToOption;
        }
    }
}
