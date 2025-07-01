package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassDecl;
import com.feysh.corax.config.api.IClassMatch;
import org.jetbrains.annotations.NotNull;

public final class BaseClassDecl implements IClassDecl {
    @NotNull
    private final AIAnalysisBaseImpl analyzeConfig;
    @NotNull
    private final IClassMatch match;

    public BaseClassDecl(@NotNull AIAnalysisBaseImpl analyzeConfig, @NotNull IClassMatch match) {
        if (analyzeConfig == null) {
            throw new IllegalArgumentException("analyzeConfig cannot be null");
        }
        if (match == null) {
            throw new IllegalArgumentException("match cannot be null");
        }
        this.analyzeConfig = analyzeConfig;
        this.match = match;
    }

    @NotNull
    public AIAnalysisBaseImpl getAnalyzeConfig() {
        return analyzeConfig;
    }

    @Override
    @NotNull
    public IClassMatch getMatch() {
        return match;
    }

    @Override
    @NotNull
    public String toString() {
        return "class decl: " + getMatch();
    }
}