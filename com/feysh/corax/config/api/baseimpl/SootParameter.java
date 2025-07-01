package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.MGlobal;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import org.jetbrains.annotations.NotNull;
import soot.RefType;
import soot.Scene;
import soot.SootMethod;
import soot.Type;

public final class SootParameter<T> implements IParameterT<T> {
    private final int index;
    private final SootMethod method;
    private final IExpr expr;

    public SootParameter(int index, @NotNull SootMethod method) {
        if (method == null) {
            throw new IllegalArgumentException("method cannot be null");
        }
        this.index = index;
        this.method = method;

        if (index < -2) {
            throw new IllegalStateException("invalid argument index: " + index);
        }
        if (index >= 0 && index >= method.getParameterCount()) {
            throw new ConfigException(this, method);
        }
        if (index == -1 && method.isStatic()) {
            throw new ConfigException(this, method);
        }

        MLocal local = index == -2 ? MGlobal.INSTANCE : new MParameter(index);
        this.expr = new IexLoad(local);
    }

    @Override
    public int getIndex() {
        return index;
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
        if (index == -1) {
            return method.getDeclaringClass().getType();
        } else if (index == -2) {
            return Scene.v().getObjectType();
        } else {
            return method.getParameterType(index);
        }
    }

    @Override
    @NotNull
    public String toString() {
        if (index == -1) {
            return "this";
        } else if (index == -2) {
            return "global";
        } else {
            return "arg" + index;
        }
    }
}
