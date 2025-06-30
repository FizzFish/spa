/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import com.feysh.corax.config.api.IUnOpExpr;
import com.feysh.corax.config.api.UnOp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/config/api/baseimpl/UnOpExpr;", "Lcom/feysh/corax/config/api/IUnOpExpr;", "op", "Lcom/feysh/corax/config/api/UnOp;", "op1", "Lcom/feysh/corax/config/api/IExpr;", "<init>", "(Lcom/feysh/corax/config/api/UnOp;Lcom/feysh/corax/config/api/IExpr;)V", "getOp", "()Lcom/feysh/corax/config/api/UnOp;", "getOp1", "()Lcom/feysh/corax/config/api/IExpr;", "toString", "", "accept", "TResult", "visitor", "Lcom/feysh/corax/config/api/IModelExpressionVisitor;", "(Lcom/feysh/corax/config/api/IModelExpressionVisitor;)Ljava/lang/Object;", "corax-config-api"})
public final class UnOpExpr
implements IUnOpExpr {
    @NotNull
    private final UnOp op;
    @NotNull
    private final IExpr op1;

    public UnOpExpr(@NotNull UnOp op, @NotNull IExpr op1) {
        Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
        Intrinsics.checkNotNullParameter((Object)op1, (String)"op1");
        this.op = op;
        this.op1 = op1;
    }

    @Override
    @NotNull
    public UnOp getOp() {
        return this.op;
    }

    @Override
    @NotNull
    public IExpr getOp1() {
        return this.op1;
    }

    @NotNull
    public String toString() {
        return this.getOp() + "( " + this.getOp1() + " )";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        Intrinsics.checkNotNullParameter(visitor, (String)"visitor");
        return visitor.visit(this);
    }
}

