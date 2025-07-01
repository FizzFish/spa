package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IIexConst extends IExpr {
    @NotNull
    Object getConst();

    @NotNull
    Type getType();

    enum Type {
        NULL,
        Boolean,
        Short,
        Int,
        Long,
        Float,
        Double,
        Class,
        String,
        TaintSet,
        ViaSet,
        EmptyElement
    }
}