/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.MReturn;
import com.feysh.corax.config.api.baseimpl.IexLoad;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/config/api/baseimpl/Return;", "T", "Lcom/feysh/corax/config/api/IReturnT;", "<init>", "()V", "expr", "Lcom/feysh/corax/config/api/IExpr;", "getExpr", "()Lcom/feysh/corax/config/api/IExpr;", "toString", "", "corax-config-api"})
public final class Return<T>
implements IReturnT<T> {
    @NotNull
    private final IExpr expr = new IexLoad(MReturn.INSTANCE);

    @Override
    @NotNull
    public IExpr getExpr() {
        return this.expr;
    }

    @NotNull
    public String toString() {
        return "Return";
    }
}

