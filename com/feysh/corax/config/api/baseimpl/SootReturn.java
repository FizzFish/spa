package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.MReturn;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.Type;

public final class SootReturn<T> implements IReturnT<T> {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final IExpr expr;
    @NotNull
    private final Type type;

    public SootReturn(@NotNull SootMethod method) {
        if (method == null) {
            throw new IllegalArgumentException("method cannot be null");
        }
        this.method = method;
        this.expr = new IexLoad(MReturn.INSTANCE);
        Type returnType = this.method.getReturnType();
        if (returnType == null) {
            throw new IllegalStateException("Method return type cannot be null");
        }
        this.type = returnType;
    }

    @NotNull
    public SootMethod getMethod() {
        return method;
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return expr;
    }

    @NotNull
    public Type getType() {
        return type;
    }

    @Override
    @NotNull
    public String toString() {
        return "Return";
    }
}