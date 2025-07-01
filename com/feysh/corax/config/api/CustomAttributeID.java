package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CustomAttributeID<T> {
    @NotNull
    private final String name;
    @Nullable
    private final IIexConst defaultValue;
    @NotNull
    private final AttributeName attributeName;

    public CustomAttributeID(@NotNull String name, @Nullable IIexConst defaultValue) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
        this.defaultValue = defaultValue;
        this.attributeName = new AttributeName(this.name, this.defaultValue);
    }

    public CustomAttributeID(@NotNull String name) {
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

    @NotNull
    public AttributeName getAttributeName() {
        return attributeName;
    }
}