/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IIexLoad;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import com.feysh.corax.config.api.MLocal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J!\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\u0016\u00a2\u0006\u0002\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2={"Lcom/feysh/corax/config/api/baseimpl/IexLoad;", "Lcom/feysh/corax/config/api/IIexLoad;", "op", "Lcom/feysh/corax/config/api/MLocal;", "<init>", "(Lcom/feysh/corax/config/api/MLocal;)V", "getOp", "()Lcom/feysh/corax/config/api/MLocal;", "toString", "", "accept", "TResult", "visitor", "Lcom/feysh/corax/config/api/IModelExpressionVisitor;", "(Lcom/feysh/corax/config/api/IModelExpressionVisitor;)Ljava/lang/Object;", "corax-config-api"})
public final class IexLoad
implements IIexLoad {
    @NotNull
    private final MLocal op;

    public IexLoad(@NotNull MLocal op) {
        Intrinsics.checkNotNullParameter((Object)op, (String)"op");
        this.op = op;
    }

    @Override
    @NotNull
    public MLocal getOp() {
        return this.op;
    }

    @NotNull
    public String toString() {
        return "load(" + this.getOp() + ")";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        Intrinsics.checkNotNullParameter(visitor, (String)"visitor");
        return visitor.visit(this);
    }
}

