package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IGlobal;
import com.feysh.corax.config.api.MGlobal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Global implements IGlobal {
    public static final Global INSTANCE = new Global();
    private static final IExpr expr = new IexLoad(MGlobal.INSTANCE);

    private Global() {
    }

    @Override
    public @NotNull IExpr getExpr() {
        return expr;
    }

    @Override
    public @NotNull String toString() {
        return "Global";
    }

    @Override
    public int hashCode() {
        return 1101842269;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return other instanceof Global;
    }
}