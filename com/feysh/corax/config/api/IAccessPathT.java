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
import com.feysh.corax.config.api.ILocalT;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/config/api/IAccessPathT;", "T", "Lcom/feysh/corax/config/api/ILocalT;", "base", "Lcom/feysh/corax/config/api/IExpr;", "getBase", "()Lcom/feysh/corax/config/api/IExpr;", "field", "Lcom/feysh/corax/config/api/IClassField;", "getField", "()Lcom/feysh/corax/config/api/IClassField;", "corax-config-api"})
public interface IAccessPathT<T>
extends ILocalT<T> {
    @NotNull
    public IExpr getBase();

    @NotNull
    public IClassField getField();
}

