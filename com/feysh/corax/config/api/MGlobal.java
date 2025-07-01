package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class MGlobal extends MLocal {
    @NotNull
    public static final MGlobal INSTANCE = new MGlobal();

    private MGlobal() {
        super(null);
    }

    @Override
    @NotNull
    public String toString() {
        return "global";
    }
}