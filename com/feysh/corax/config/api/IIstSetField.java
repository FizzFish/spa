/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IStmt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005\u00a8\u0006\f"}, d2={"Lcom/feysh/corax/config/api/IIstSetField;", "Lcom/feysh/corax/config/api/IStmt;", "base", "Lcom/feysh/corax/config/api/IExpr;", "getBase", "()Lcom/feysh/corax/config/api/IExpr;", "field", "Lcom/feysh/corax/config/api/IClassField;", "getField", "()Lcom/feysh/corax/config/api/IClassField;", "value", "getValue", "corax-config-api"})
public interface IIstSetField
extends IStmt {
    @NotNull
    public IExpr getBase();

    @NotNull
    public IClassField getField();

    @NotNull
    public IExpr getValue();
}

