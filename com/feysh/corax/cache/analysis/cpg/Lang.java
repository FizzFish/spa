package com.feysh.corax.cache.analysis.cpg;

import de.fraunhofer.aisec.cpg.frontends.Language;
import de.fraunhofer.aisec.cpg.frontends.java.JavaLanguage;
import org.jetbrains.annotations.NotNull;

public enum Lang {
    JAVA(new JavaLanguage());

    @NotNull
    private final Language<?> language;

    Lang(@NotNull Language<?> language) {
        this.language = language;
    }

    @NotNull
    public Language<?> getLanguage() {
        return language;
    }
}