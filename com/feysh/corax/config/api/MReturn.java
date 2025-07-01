package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class MReturn extends MLocal {
    @NotNull
    public static final MReturn INSTANCE = new MReturn();

    private MReturn() {
        super(null);
    }

    @Override
    @NotNull
    public String toString() {
        return "return";
    }
}