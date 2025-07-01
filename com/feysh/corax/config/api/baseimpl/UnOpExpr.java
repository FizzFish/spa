package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import com.feysh.corax.config.api.IUnOpExpr;
import com.feysh.corax.config.api.UnOp;
import org.jetbrains.annotations.NotNull;

public final class UnOpExpr implements IUnOpExpr {
    @NotNull
    private final UnOp op;
    @NotNull
    private final IExpr op1;

    public UnOpExpr(@NotNull UnOp op, @NotNull IExpr op1) {
        if (op == null) {
            throw new IllegalArgumentException("op cannot be null");
        }
        if (op1 == null) {
            throw new IllegalArgumentException("op1 cannot be null");
        }
        this.op = op;
        this.op1 = op1;
    }

    @Override
    @NotNull
    public UnOp getOp() {
        return op;
    }

    @Override
    @NotNull
    public IExpr getOp1() {
        return op1;
    }

    @Override
    @NotNull
    public String toString() {
        return op + "( " + op1 + " )";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor cannot be null");
        }
        return visitor.visit(this);
    }
}