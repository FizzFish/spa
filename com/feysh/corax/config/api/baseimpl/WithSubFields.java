package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IWithSubFieldsT;
import com.feysh.corax.config.api.SubFields;
import org.jetbrains.annotations.NotNull;

public final class WithSubFields implements IWithSubFieldsT {
    @NotNull
    private final IExpr base;
    @NotNull
    private final IExpr expr;

    public WithSubFields(@NotNull IExpr base) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        this.base = base;
        this.expr = IexGetFieldExpr.invoke(this.base, SubFields.INSTANCE);
    }

    @NotNull
    public IExpr getBase() {
        return base;
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return expr;
    }

    @Override
    @NotNull
    public String toString() {
        return String.valueOf(getExpr());
    }
}