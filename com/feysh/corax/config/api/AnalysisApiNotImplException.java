package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class AnalysisApiNotImplException extends Exception {
    public AnalysisApiNotImplException(@NotNull String msg) {
        super(msg);
    }
}