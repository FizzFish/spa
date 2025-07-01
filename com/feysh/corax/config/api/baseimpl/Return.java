package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.MReturn;
import org.jetbrains.annotations.NotNull;

public final class Return<T> implements IReturnT<T> {
    @NotNull
    private final IExpr expr = new IexLoad(MReturn.INSTANCE);

    @Override
    @NotNull
    public IExpr getExpr() {
        return expr;
    }

    @Override
    @NotNull
    public String toString() {
        return "Return";
    }
}