package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public abstract class BuiltInField implements IClassField {
    @NotNull
    private final String name;

    protected BuiltInField(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return name;
    }

    @Override
    @NotNull
    public String toString() {
        return name;
    }
}