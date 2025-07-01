package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IStmt;
import org.jetbrains.annotations.NotNull;

public final class RValue<T> extends AbstractLocalValue<T> {
    @NotNull
    private final IExpr rvalue;

    public RValue(@NotNull IExpr rvalue) {
        if (rvalue == null) {
            throw new IllegalArgumentException("rvalue cannot be null");
        }
        this.rvalue = rvalue;
    }

    @Override
    @NotNull
    public IExpr getRvalue() {
        return rvalue;
    }

    @Override
    @NotNull
    public String toString() {
        return String.valueOf(rvalue);
    }

    @Override
    @NotNull
    public IStmt setValue(@NotNull IExpr value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        throw new IllegalStateException("store " + this + " is undefined behavior");
    }
}