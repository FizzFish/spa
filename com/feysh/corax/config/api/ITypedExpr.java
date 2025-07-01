package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface ITypedExpr {
    @NotNull
    IExpr getExpr();
}