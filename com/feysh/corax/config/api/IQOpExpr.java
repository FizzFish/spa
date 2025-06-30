/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.TriOp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0001X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0001X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0012\u0010\u000b\u001a\u00020\u0001X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0012\u0010\r\u001a\u00020\u0001X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2={"Lcom/feysh/corax/config/api/IQOpExpr;", "Lcom/feysh/corax/config/api/IExpr;", "op", "Lcom/feysh/corax/config/api/TriOp;", "getOp", "()Lcom/feysh/corax/config/api/TriOp;", "op1", "getOp1", "()Lcom/feysh/corax/config/api/IExpr;", "op2", "getOp2", "op3", "getOp3", "op4", "getOp4", "corax-config-api"})
public interface IQOpExpr
extends IExpr {
    @NotNull
    public TriOp getOp();

    @NotNull
    public IExpr getOp1();

    @NotNull
    public IExpr getOp2();

    @NotNull
    public IExpr getOp3();

    @NotNull
    public IExpr getOp4();
}

