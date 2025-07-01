package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface ITriOpExpr extends IExpr {
    @NotNull
    TriOp getOp();

    @NotNull
    IExpr getOp1();

    @NotNull
    IExpr getOp2();

    @NotNull
    IExpr getOp3();
}