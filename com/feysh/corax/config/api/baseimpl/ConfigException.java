package com.feysh.corax.config.api.baseimpl;

import org.jetbrains.annotations.NotNull;

public final class ConfigException extends Exception {
    @NotNull
    private final Object value;

    public ConfigException(@NotNull Object value) {
        if (value == null) {
            throw new IllegalArgumentException("value must not be null");
        }
        this.value = value;
    }

    @NotNull
    public Object getValue() {
        return value;
    }

    @Override
    @NotNull
    public String toString() {
        StackTraceElement[] stackTrace = getStackTrace();
        StackTraceElement firstElement = stackTrace.length > 0 ? stackTrace[0] : null;
        return (firstElement != null ? firstElement.toString() : "") + " `" + value + "` is incorrect";
    }
}