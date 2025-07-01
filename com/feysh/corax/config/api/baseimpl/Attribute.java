package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import org.jetbrains.annotations.NotNull;

public final class Attribute<K extends IClassField, V> implements IAttribute<K, V> {
    @NotNull
    private final IExpr value;

    public Attribute(@NotNull IExpr value) {
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
}