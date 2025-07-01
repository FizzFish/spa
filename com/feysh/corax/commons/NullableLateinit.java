package com.feysh.corax.commons;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NullableLateinit<T> {
    @NotNull
    private final String errorMessage;
    @Nullable
    private Object value;
    private static final Object UNINITIALIZED = new Object();

    public NullableLateinit(@NotNull String errorMessage) {
        if (errorMessage == null) {
            throw new IllegalArgumentException("errorMessage cannot be null");
        }
        this.errorMessage = errorMessage;
        this.value = UNINITIALIZED;
    }

    public T getValue(@NotNull Object thisRef, @NotNull Object property) {
        if (thisRef == null) {
            throw new IllegalArgumentException("thisRef cannot be null");
        }
        if (property == null) {
            throw new IllegalArgumentException("property cannot be null");
        }
        if (this.value == UNINITIALIZED) {
            throw new IllegalStateException(this.errorMessage);
        }
        try {
            @SuppressWarnings("unchecked")
            T result = (T) this.value;
            return result;
        } catch (ClassCastException e) {
            throw new IllegalStateException(this.errorMessage);
        }
    }

    public void setValue(@NotNull Object thisRef, @NotNull Object property, T value) {
        if (thisRef == null) {
            throw new IllegalArgumentException("thisRef cannot be null");
        }
        if (property == null) {
            throw new IllegalArgumentException("property cannot be null");
        }
        this.value = value;
    }

    public void uninitialized() {
        this.value = UNINITIALIZED;
    }

    public boolean isUninitialized() {
        return this.value == UNINITIALIZED;
    }
}