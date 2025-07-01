package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IIntExpr extends ITypedExpr {
    @NotNull
    IExpr getExpr();
}