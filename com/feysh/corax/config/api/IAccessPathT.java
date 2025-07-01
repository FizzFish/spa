package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IAccessPathT<T> extends ILocalT<T> {
    @NotNull
    IExpr getBase();

    @NotNull
    IClassField getField();
}