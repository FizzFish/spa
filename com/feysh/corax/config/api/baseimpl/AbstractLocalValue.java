package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.IStmt;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractLocalValue<T> implements ILocalValue<T> {
    @NotNull
    public abstract IStmt setValue(@NotNull IExpr value);
}