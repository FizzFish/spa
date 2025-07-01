package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.BinOp;
import com.feysh.corax.config.api.IBinOpExpr;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public final class BinOpExpr implements IBinOpExpr {
    @NotNull
    private final BinOp op;
    @NotNull
    private final IExpr op1;
    @NotNull
    private final IExpr op2;

    public BinOpExpr(@NotNull BinOp op, @NotNull IExpr op1, @NotNull IExpr op2) {
        if (op == null) throw new IllegalArgumentException("op cannot be null");
        if (op1 == null) throw new IllegalArgumentException("op1 cannot be null");
        if (op2 == null) throw new IllegalArgumentException("op2 cannot be null");
        this.op = op;
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public @NotNull BinOp getOp() {
        return op;
    }

    @Override
    public @NotNull IExpr getOp1() {
        return op1;
    }

    @Override
    public @NotNull IExpr getOp2() {
        return op2;
    }

    @Override
    public @NotNull String toString() {
        return getOp() + "( " + getOp1() + ", " + getOp2() + " )";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        if (visitor == null) throw new IllegalArgumentException("visitor cannot be null");
        return visitor.visit(this);
    }
}