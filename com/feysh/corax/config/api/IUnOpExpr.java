package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IUnOpExpr extends IExpr {
    @NotNull
    UnOp getOp();

    @NotNull
    IExpr getOp1();
}