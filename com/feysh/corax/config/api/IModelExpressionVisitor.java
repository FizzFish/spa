package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IModelExpressionVisitor<TResult> {
    TResult defaultValue(@NotNull IExpr expr);

    default TResult visit(@NotNull IIexLoad expr) {
        return defaultValue(expr);
    }

    default TResult visit(@NotNull IIexGetField expr) {
        return defaultValue(expr);
    }

    default TResult visit(@NotNull IUnOpExpr expr) {
        return defaultValue(expr);
    }

    default TResult visit(@NotNull IBinOpExpr expr) {
        return defaultValue(expr);
    }

    default TResult visit(@NotNull ITriOpExpr expr) {
        return defaultValue(expr);
    }

    default TResult visit(@NotNull IQOpExpr expr) {
        return defaultValue(expr);
    }

    default TResult visit(@NotNull IIexConst expr) {
        return defaultValue(expr);
    }
}