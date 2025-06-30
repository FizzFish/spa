/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IModelStmtVisitor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/IStmt;", "", "accept", "TResult", "visitor", "Lcom/feysh/corax/config/api/IModelStmtVisitor;", "(Lcom/feysh/corax/config/api/IModelStmtVisitor;)Ljava/lang/Object;", "corax-config-api"})
public interface IStmt {
    public <TResult> TResult accept(@NotNull IModelStmtVisitor<TResult> var1);
}

