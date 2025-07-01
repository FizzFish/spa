package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.MGlobal;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import org.jetbrains.annotations.NotNull;

public final class Parameter<T> implements IParameterT<T> {
    private final int index;
    @NotNull
    private final IExpr expr;

    public Parameter(int index) {
        if (index < -2) {
            throw new IllegalStateException("invalid argument index: " + index);
        }
        this.index = index;
        MLocal local = index == -2 ? MGlobal.INSTANCE : new MParameter(index);
        this.expr = new IexLoad(local);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return expr;
    }

    @Override
    @NotNull
    public String toString() {
        if (index == -1) {
            return "this";
        }
        return index == -2 ? "global" : "arg" + index;
    }
}