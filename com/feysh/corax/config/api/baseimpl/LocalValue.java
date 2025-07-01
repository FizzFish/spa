package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.*;
import org.jetbrains.annotations.NotNull;

public final class LocalValue<T> extends AbstractLocalValue<T> {
    @NotNull
    private final ILocalT<T> iLocalT;

    public LocalValue(@NotNull ILocalT<T> iLocalT) {
        if (iLocalT == null) {
            throw new IllegalArgumentException("iLocalT cannot be null");
        }
        this.iLocalT = iLocalT;
    }

    @NotNull
    public ILocalT<T> getILocalT() {
        return iLocalT;
    }

    @Override
    @NotNull
    public IStmt setValue(@NotNull IExpr value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }

        if (iLocalT instanceof IParameterT parameterT) {
            if (parameterT.getIndex() == -2) {
                throw new IllegalStateException("Global instance can't be store!!!");
            }
            return new IstStoreLocal(new MParameter(parameterT.getIndex()), value);
        } else if (iLocalT instanceof IReturnT) {
            return new IstStoreLocal(MReturn.INSTANCE, value);
        } else if (iLocalT instanceof IWithSubFieldsT withSubFieldsT) {
            return new IstSetField(withSubFieldsT.getExpr(), SubFields.INSTANCE, value);
        } else if (iLocalT instanceof IAccessPathT accessPathT) {
            return new IstSetField(accessPathT.getBase(), accessPathT.getField(), value);
        } else if (iLocalT instanceof IGlobal) {
            throw new IllegalStateException("not support store global static variable!");
        } else {
            throw new IllegalStateException("Unsupported ILocalT type");
        }
    }

    @Override
    @NotNull
    public IExpr getRvalue() {
        return iLocalT.getExpr();
    }

    @Override
    @NotNull
    public String toString() {
        return iLocalT.toString();
    }
}