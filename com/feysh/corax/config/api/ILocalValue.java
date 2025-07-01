package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface ILocalValue<V> {
    @NotNull
    IExpr getRvalue();
}