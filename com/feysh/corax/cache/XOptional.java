package com.feysh.corax.cache;

import org.jetbrains.annotations.NotNull;

public final class XOptional<T> {
    private final T value;

    private XOptional(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @NotNull
    public static <T> XOptional<T> of(T value) {
        return new XOptional<>(value);
    }
}