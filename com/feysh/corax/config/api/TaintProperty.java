package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class TaintProperty extends BuiltInField {
    @NotNull
    public static final TaintProperty INSTANCE = new TaintProperty();

    private TaintProperty() {
        super("taint", null);
    }
}