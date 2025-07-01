package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class SubFields implements IClassField {
    @NotNull
    public static final SubFields INSTANCE = new SubFields();

    private SubFields() {
    }

    @Override
    @NotNull
    public String toString() {
        return "**(SubFields)";
    }
}