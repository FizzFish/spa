package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IStringExpr extends ITypedExpr {
    @NotNull
    IExpr getExpr();
}