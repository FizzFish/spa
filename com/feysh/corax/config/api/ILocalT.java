/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IExpr;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b\u00a8\u0006\f"}, d2={"Lcom/feysh/corax/config/api/ILocalT;", "T", "", "expr", "Lcom/feysh/corax/config/api/IExpr;", "getExpr", "()Lcom/feysh/corax/config/api/IExpr;", "Lcom/feysh/corax/config/api/IAccessPathT;", "Lcom/feysh/corax/config/api/IGlobal;", "Lcom/feysh/corax/config/api/IParameterT;", "Lcom/feysh/corax/config/api/IReturnT;", "Lcom/feysh/corax/config/api/IWithSubFieldsT;", "corax-config-api"})
public interface ILocalT<T> {
    @NotNull
    public IExpr getExpr();
}

