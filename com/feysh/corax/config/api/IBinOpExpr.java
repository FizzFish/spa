package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IBinOpExpr extends IExpr {
    @NotNull
    BinOp getOp();

    @NotNull
    IExpr getOp1();

    @NotNull
    IExpr getOp2();
}