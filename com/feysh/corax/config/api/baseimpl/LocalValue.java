/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IGlobal;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.IWithSubFieldsT;
import com.feysh.corax.config.api.MParameter;
import com.feysh.corax.config.api.MReturn;
import com.feysh.corax.config.api.SubFields;
import com.feysh.corax.config.api.baseimpl.AbstractLocalValue;
import com.feysh.corax.config.api.baseimpl.IstSetField;
import com.feysh.corax.config.api.baseimpl.IstStoreLocal;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lcom/feysh/corax/config/api/baseimpl/LocalValue;", "T", "Lcom/feysh/corax/config/api/baseimpl/AbstractLocalValue;", "iLocalT", "Lcom/feysh/corax/config/api/ILocalT;", "<init>", "(Lcom/feysh/corax/config/api/ILocalT;)V", "getILocalT", "()Lcom/feysh/corax/config/api/ILocalT;", "setValue", "Lcom/feysh/corax/config/api/IStmt;", "value", "Lcom/feysh/corax/config/api/IExpr;", "rvalue", "getRvalue", "()Lcom/feysh/corax/config/api/IExpr;", "toString", "", "corax-config-api"})
public final class LocalValue<T>
extends AbstractLocalValue<T> {
    @NotNull
    private final ILocalT<T> iLocalT;

    public LocalValue(@NotNull ILocalT<T> iLocalT) {
        Intrinsics.checkNotNullParameter(iLocalT, (String)"iLocalT");
        this.iLocalT = iLocalT;
    }

    @NotNull
    public final ILocalT<T> getILocalT() {
        return this.iLocalT;
    }

    @Override
    @NotNull
    public IStmt setValue(@NotNull IExpr value) {
        IStmt iStmt;
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        ILocalT<T> iLocalT = this.iLocalT;
        if (iLocalT instanceof IParameterT) {
            if (((IParameterT)this.iLocalT).getIndex() == -2) {
                throw new IllegalStateException("Global instance can't be store!!!".toString());
            }
            iStmt = new IstStoreLocal(new MParameter(((IParameterT)this.iLocalT).getIndex()), value);
        } else if (iLocalT instanceof IReturnT) {
            iStmt = new IstStoreLocal(MReturn.INSTANCE, value);
        } else if (iLocalT instanceof IWithSubFieldsT) {
            iStmt = new IstSetField(((IWithSubFieldsT)this.iLocalT).getExpr(), SubFields.INSTANCE, value);
        } else if (iLocalT instanceof IAccessPathT) {
            iStmt = new IstSetField(((IAccessPathT)this.iLocalT).getBase(), ((IAccessPathT)this.iLocalT).getField(), value);
        } else {
            if (iLocalT instanceof IGlobal) {
                throw new IllegalStateException("not support store global static variable!".toString());
            }
            throw new NoWhenBranchMatchedException();
        }
        return iStmt;
    }

    @Override
    @NotNull
    public IExpr getRvalue() {
        return this.iLocalT.getExpr();
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.iLocalT);
    }
}

