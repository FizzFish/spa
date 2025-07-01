package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface ILongExpr extends ITypedExpr {
    @NotNull
    IExpr getExpr();
}