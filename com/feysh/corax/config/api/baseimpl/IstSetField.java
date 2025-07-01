package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIstSetField;
import com.feysh.corax.config.api.IModelStmtVisitor;
import org.jetbrains.annotations.NotNull;

public final class IstSetField implements IIstSetField {
    @NotNull
    private final IExpr base;
    @NotNull
    private final IClassField field;
    @NotNull
    private final IExpr value;

    public IstSetField(@NotNull IExpr base, @NotNull IClassField field, @NotNull IExpr value) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        if (field == null) throw new IllegalArgumentException("field cannot be null");
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        this.base = base;
        this.field = field;
        this.value = value;
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
    public IExpr getValue() {
        return value;
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelStmtVisitor<TResult> visitor) {
        if (visitor == null) throw new IllegalArgumentException("visitor cannot be null");
        return visitor.visit(this);
    }

    @Override
    @NotNull
    public String toString() {
        return "assign " + getBase() + "." + getField() + " = " + getValue();
    }
}