package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class ViaProperty extends BuiltInField {
    @NotNull
    public static final ViaProperty INSTANCE = new ViaProperty();

    private ViaProperty() {
        super("via", null);
    }
}