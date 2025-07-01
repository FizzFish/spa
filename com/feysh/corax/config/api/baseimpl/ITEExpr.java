package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import com.feysh.corax.config.api.ITriOpExpr;
import com.feysh.corax.config.api.TriOp;
import org.jetbrains.annotations.NotNull;

public final class ITEExpr implements ITriOpExpr {
    @NotNull
    private final IExpr op1;
    @NotNull
    private final IExpr op2;
    @NotNull
    private final IExpr op3;
    @NotNull
    private final TriOp op = TriOp.ITE;

    public ITEExpr(@NotNull IExpr op1, @NotNull IExpr op2, @NotNull IExpr op3) {
        if (op1 == null) throw new IllegalArgumentException("op1 cannot be null");
        if (op2 == null) throw new IllegalArgumentException("op2 cannot be null");
        if (op3 == null) throw new IllegalArgumentException("op3 cannot be null");
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
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
    public @NotNull IExpr getOp3() {
        return op3;
    }

    @Override
    public @NotNull TriOp getOp() {
        return op;
    }

    @Override
    public @NotNull String toString() {
        return "ITE(" + op1 + ", " + op2 + ", " + op3 + ")";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        if (visitor == null) throw new IllegalArgumentException("visitor cannot be null");
        return visitor.visit(this);
    }
}