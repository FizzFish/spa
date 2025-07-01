package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import org.jetbrains.annotations.NotNull;

public final class AccessPath<T> implements IAccessPathT<T> {
    @NotNull
    private final IExpr base;
    @NotNull
    private final IClassField field;

    public AccessPath(@NotNull IExpr base, @NotNull IClassField field) {
        if (base == null) {
            throw new IllegalArgumentException("base cannot be null");
        }
        if (field == null) {
            throw new IllegalArgumentException("field cannot be null");
        }
        this.base = base;
        this.field = field;
    }

    @Override
    @NotNull
    public IExpr getBase() {
        return base;
    }

    @Override
    @NotNull
    public IClassField getField() {
        return field;
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return IexGetFieldExpr.create(getBase(), getField());
    }

    @Override
    @NotNull
    public String toString() {
        return String.valueOf(getExpr());
    }
}