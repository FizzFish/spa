package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class IexConstFalse implements IIexConst {
    @NotNull
    public static final IexConstFalse INSTANCE = new IexConstFalse();

    private IexConstFalse() {
    }

    @Override
    @NotNull
    public Boolean getConst() {
        return false;
    }

    @Override
    @NotNull
    public IIexConst.Type getType() {
        return IIexConst.Type.Boolean;
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        if (visitor == null) {
            throw new NullPointerException("visitor cannot be null");
        }
        return visitor.visit(this);
    }
}