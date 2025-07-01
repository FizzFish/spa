package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIstStoreLocal;
import com.feysh.corax.config.api.IModelStmtVisitor;
import com.feysh.corax.config.api.MLocal;
import org.jetbrains.annotations.NotNull;

public final class IstStoreLocal implements IIstStoreLocal {
    @NotNull
    private final MLocal local;
    @NotNull
    private final IExpr value;

    public IstStoreLocal(@NotNull MLocal local, @NotNull IExpr value) {
        if (local == null) {
            throw new IllegalArgumentException("local cannot be null");
        }
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        this.local = local;
        this.value = value;
    }

    @Override
    @NotNull
    public MLocal getLocal() {
        return local;
    }

    @Override
    @NotNull
    public IExpr getValue() {
        return value;
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelStmtVisitor<TResult> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor cannot be null");
        }
        return visitor.visit(this);
    }

    @Override
    @NotNull
    public String toString() {
        return "assign " + getLocal() + " = " + getValue();
    }
}