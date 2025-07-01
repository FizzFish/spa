package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IIexLoad;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import com.feysh.corax.config.api.MLocal;
import org.jetbrains.annotations.NotNull;

public final class IexLoad implements IIexLoad {
    @NotNull
    private final MLocal op;

    public IexLoad(@NotNull MLocal op) {
        if (op == null) {
            throw new IllegalArgumentException("op must not be null");
        }
        this.op = op;
    }

    @Override
    @NotNull
    public MLocal getOp() {
        return op;
    }

    @Override
    @NotNull
    public String toString() {
        return "load(" + op + ")";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor must not be null");
        }
        return visitor.visit(this);
    }
}