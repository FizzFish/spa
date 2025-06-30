/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IIexConst;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/config/api/IexConstTrue;", "Lcom/feysh/corax/config/api/IIexConst;", "<init>", "()V", "const", "", "getConst", "()Ljava/lang/Boolean;", "type", "Lcom/feysh/corax/config/api/IIexConst$Type;", "getType", "()Lcom/feysh/corax/config/api/IIexConst$Type;", "accept", "TResult", "visitor", "Lcom/feysh/corax/config/api/IModelExpressionVisitor;", "(Lcom/feysh/corax/config/api/IModelExpressionVisitor;)Ljava/lang/Object;", "corax-config-api"})
public final class IexConstTrue
implements IIexConst {
    @NotNull
    public static final IexConstTrue INSTANCE = new IexConstTrue();

    private IexConstTrue() {
    }

    @Override
    @NotNull
    public Boolean getConst() {
        return true;
    }

    @Override
    @NotNull
    public IIexConst.Type getType() {
        return IIexConst.Type.Boolean;
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        Intrinsics.checkNotNullParameter(visitor, (String)"visitor");
        return visitor.visit(this);
    }
}

