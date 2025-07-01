package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class MapKeys extends BuiltInField {
    @NotNull
    public static final MapKeys INSTANCE = new MapKeys();

    private MapKeys() {
        super("mapKeys", null);
    }
}