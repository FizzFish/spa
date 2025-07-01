package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.IExpr;
import org.jetbrains.annotations.NotNull;

public final class BoolExpr implements IBoolExpr {
    @NotNull
    private final IExpr expr;

    public BoolExpr(@NotNull IExpr expr) {
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