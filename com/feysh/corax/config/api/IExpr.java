package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IExpr {
    <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor);
}