package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class IexConstTrue implements IIexConst {
    @NotNull
    public static final IexConstTrue INSTANCE = new IexConstTrue();

    private IexConstTrue() {
    }

    @Override
    @NotNull
    public Boolean getConst() {
        return true;
    }

    @Override
    @NotNull
    public IIexConst.Type getType() {
        return IIexConst.Type.Boolean;
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor cannot be null");
        }
        return visitor.visit(this);
    }
}