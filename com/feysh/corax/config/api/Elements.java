package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class Elements extends BuiltInField {
    @NotNull
    public static final Elements INSTANCE = new Elements();

    private Elements() {
        super("elements", null);
    }
}