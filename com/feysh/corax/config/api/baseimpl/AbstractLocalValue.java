/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.IStmt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2={"Lcom/feysh/corax/config/api/baseimpl/AbstractLocalValue;", "T", "Lcom/feysh/corax/config/api/ILocalValue;", "<init>", "()V", "setValue", "Lcom/feysh/corax/config/api/IStmt;", "value", "Lcom/feysh/corax/config/api/IExpr;", "corax-config-api"})
public abstract class AbstractLocalValue<T>
implements ILocalValue<T> {
    @NotNull
    public abstract IStmt setValue(@NotNull IExpr var1);
}

