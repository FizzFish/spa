package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IIstSetField extends IStmt {
    @NotNull
    IExpr getBase();

    @NotNull
    IClassField getField();

    @NotNull
    IExpr getValue();
}