package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIntExpr;
import org.jetbrains.annotations.NotNull;

public final class IntExpr implements IIntExpr {
    @NotNull
    private final IExpr expr;

    public IntExpr(@NotNull IExpr expr) {
        if (expr == null) {
            throw new IllegalArgumentException("expr must not be null");
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