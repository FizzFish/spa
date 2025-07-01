package com.feysh.corax.cache.analysis.cpg;

import de.fraunhofer.aisec.cpg.InferenceConfiguration;
import org.jetbrains.annotations.NotNull;

public enum InferenceConfigurationType {
    DEFAULT(InferenceConfiguration.builder().build()),
    DISABLE_ALL(InferenceConfiguration.builder().enabled(false).build()),
    ENABLE_ALL(InferenceConfiguration.builder().build());

    @NotNull
    private final InferenceConfiguration configuration;

    InferenceConfigurationType(@NotNull InferenceConfiguration configuration) {
        this.configuration = configuration;
    }

    @NotNull
    public InferenceConfiguration getConfiguration() {
        return configuration;
    }
}