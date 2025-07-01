package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class MapValues extends BuiltInField {
    @NotNull
    public static final MapValues INSTANCE = new MapValues();

    private MapValues() {
        super("mapValues", null);
    }
}