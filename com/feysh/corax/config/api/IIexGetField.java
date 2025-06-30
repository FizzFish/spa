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
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0001X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/config/api/IIexGetField;", "Lcom/feysh/corax/config/api/IExpr;", "base", "getBase", "()Lcom/feysh/corax/config/api/IExpr;", "accessPath", "", "Lcom/feysh/corax/config/api/IClassField;", "getAccessPath", "()Ljava/util/List;", "corax-config-api"})
public interface IIexGetField
extends IExpr {
    @NotNull
    public IExpr getBase();

    @NotNull
    public List<IClassField> getAccessPath();
}

