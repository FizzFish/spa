package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AttributeName implements IClassField {
    @NotNull
    private final String name;
    @Nullable
    private final IIexConst defaultValue;

    public AttributeName(@NotNull String name, @Nullable IIexConst defaultValue) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public AttributeName(@NotNull String name) {
        this(name, null);
    }

    @NotNull
    public String getName() {
        return name;
    }

    @Nullable
    public IIexConst getDefault() {
        return defaultValue;
    }

    @Override
    @NotNull
    public String toString() {
        return name;
    }
}