package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class MParameter extends MLocal {
    private final int index;

    public MParameter(int index) {
        super(null);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @NotNull
    @Override
    public String toString() {
        return index == -1 ? "this" : "p" + index;
    }
}