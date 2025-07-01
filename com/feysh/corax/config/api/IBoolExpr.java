package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IBoolExpr extends ITypedExpr {
    @NotNull
    IExpr getExpr();
}