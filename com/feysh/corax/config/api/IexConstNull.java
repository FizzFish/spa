package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public final class IexConstNull implements IIexConst {
    @NotNull
    public static final IexConstNull INSTANCE = new IexConstNull();

    private IexConstNull() {
    }

    @Override
    @NotNull
    public Object getConst() {
        return NULL.INSTANCE;
    }

    @Override
    @NotNull
    public IIexConst.Type getType() {
        return IIexConst.Type.NULL;
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor cannot be null");
        }
        return visitor.visit(this);
    }

    public static final class NULL {
        @NotNull
        public static final NULL INSTANCE = new NULL();

        private NULL() {
        }
    }
}