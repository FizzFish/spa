package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MethodConfig {
    @NotNull
    private CheckCall at;

    public MethodConfig(@NotNull CheckCall at) {
        if (at == null) {
            throw new IllegalArgumentException("at cannot be null");
        }
        this.at = at;
    }

    @NotNull
    public CheckCall getAt() {
        return at;
    }

    public void setAt(@NotNull CheckCall checkCall) {
        if (checkCall == null) {
            throw new IllegalArgumentException("checkCall cannot be null");
        }
        this.at = checkCall;
    }

    @NotNull
    public MethodConfig copy(@NotNull CheckCall at) {
        if (at == null) {
            throw new IllegalArgumentException("at cannot be null");
        }
        return new MethodConfig(at);
    }

    @Override
    public String toString() {
        return "MethodConfig(at=" + at + ")";
    }

    @Override
    public int hashCode() {
        return at.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MethodConfig)) {
            return false;
        }
        MethodConfig methodConfig = (MethodConfig) other;
        return this.at == methodConfig.at;
    }

    public enum CheckCall {
        PrevCallInCaller,
        EvalCallInCaller,
        PrevCallInCallee,
        EvalCallInCallee,
        PostCallInCallee,
        PostCallInCaller
    }
}