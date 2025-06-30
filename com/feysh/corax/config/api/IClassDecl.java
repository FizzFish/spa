/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.IJDecl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lcom/feysh/corax/config/api/IClassDecl;", "Lcom/feysh/corax/config/api/IJDecl;", "match", "Lcom/feysh/corax/config/api/IClassMatch;", "getMatch", "()Lcom/feysh/corax/config/api/IClassMatch;", "corax-config-api"})
public interface IClassDecl
extends IJDecl {
    @NotNull
    public IClassMatch getMatch();
}

