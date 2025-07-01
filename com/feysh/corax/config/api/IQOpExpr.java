package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IQOpExpr extends IExpr {
    @NotNull
    TriOp getOp();

    @NotNull
    IExpr getOp1();

    @NotNull
    IExpr getOp2();

    @NotNull
    IExpr getOp3();

    @NotNull
    IExpr getOp4();
}