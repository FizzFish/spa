package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IAttribute<K extends IClassField, V> {
    @NotNull
    IExpr getValue();
}