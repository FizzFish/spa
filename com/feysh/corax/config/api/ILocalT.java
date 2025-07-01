package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface ILocalT<T> {
    @NotNull
    IExpr getExpr();
}