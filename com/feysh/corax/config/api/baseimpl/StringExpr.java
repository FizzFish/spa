package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IStringExpr;
import org.jetbrains.annotations.NotNull;

public final class StringExpr implements IStringExpr {
    @NotNull
    private final IExpr expr;

    public StringExpr(@NotNull IExpr expr) {
        if (expr == null) {
            throw new IllegalArgumentException("expr cannot be null");
        }
        this.expr = expr;
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return expr;
    }

    @Override
    @NotNull
    public String toString() {
        return String.valueOf(expr);
    }
}