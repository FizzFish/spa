package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IIexConst;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import org.jetbrains.annotations.NotNull;

public final class IexConst implements IIexConst {
    @NotNull
    private final Object constValue;
    @NotNull
    private final IIexConst.Type type;

    public IexConst(@NotNull Object constValue, @NotNull IIexConst.Type type) {
        if (constValue == null) {
            throw new IllegalArgumentException("const cannot be null");
        }
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        this.constValue = constValue;
        this.type = type;
    }

    @Override
    @NotNull
    public Object getConst() {
        return constValue;
    }

    @Override
    @NotNull
    public IIexConst.Type getType() {
        return type;
    }

    @Override
    @NotNull
    public String toString() {
        return "IexConst(" + constValue + ")";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor cannot be null");
        }
        return visitor.visit(this);
    }
}