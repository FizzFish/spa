package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.ViaProperty;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class ViaSet implements IAttribute<ViaProperty, Set<? extends IViaType>> {
    @NotNull
    private final IExpr value;

    public ViaSet(@NotNull IExpr value) {
        if (value == null) {
            throw new NullPointerException("value");
        }
        this.value = value;
    }

    @Override
    @NotNull
    public IExpr getValue() {
        return value;
    }

    @Override
    @NotNull
    public String toString() {
        return "GetViaSet( " + getValue() + " )";
    }
}