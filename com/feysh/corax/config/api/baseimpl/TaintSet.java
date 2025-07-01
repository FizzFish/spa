package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.TaintProperty;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class TaintSet implements IAttribute<TaintProperty, Set<? extends ITaintType>> {
    @NotNull
    private final IExpr value;

    public TaintSet(@NotNull IExpr value) {
        if (value == null) {
            throw new IllegalArgumentException("value must not be null");
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
        return "GetTaintSet( " + getValue() + " )";
    }
}