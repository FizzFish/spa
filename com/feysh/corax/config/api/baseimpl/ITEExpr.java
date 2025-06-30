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
import com.feysh.corax.config.api.ITriOpExpr;
import com.feysh.corax.config.api.TriOp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J!\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H\u0016\u00a2\u0006\u0002\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2={"Lcom/feysh/corax/config/api/baseimpl/ITEExpr;", "Lcom/feysh/corax/config/api/ITriOpExpr;", "op1", "Lcom/feysh/corax/config/api/IExpr;", "op2", "op3", "<init>", "(Lcom/feysh/corax/config/api/IExpr;Lcom/feysh/corax/config/api/IExpr;Lcom/feysh/corax/config/api/IExpr;)V", "getOp1", "()Lcom/feysh/corax/config/api/IExpr;", "getOp2", "getOp3", "op", "Lcom/feysh/corax/config/api/TriOp;", "getOp", "()Lcom/feysh/corax/config/api/TriOp;", "toString", "", "accept", "TResult", "visitor", "Lcom/feysh/corax/config/api/IModelExpressionVisitor;", "(Lcom/feysh/corax/config/api/IModelExpressionVisitor;)Ljava/lang/Object;", "corax-config-api"})
public final class ITEExpr
implements ITriOpExpr {
    @NotNull
    private final IExpr op1;
    @NotNull
    private final IExpr op2;
    @NotNull
    private final IExpr op3;
    @NotNull
    private final TriOp op;

    public ITEExpr(@NotNull IExpr op1, @NotNull IExpr op2, @NotNull IExpr op3) {
        Intrinsics.checkNotNullParameter((Object)op1, (String)"op1");
        Intrinsics.checkNotNullParameter((Object)op2, (String)"op2");
        Intrinsics.checkNotNullParameter((Object)op3, (String)"op3");
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op = TriOp.ITE;
    }

    @Override
    @NotNull
    public IExpr getOp1() {
        return this.op1;
    }

    @Override
    @NotNull
    public IExpr getOp2() {
        return this.op2;
    }

    @Override
    @NotNull
    public IExpr getOp3() {
        return this.op3;
    }

    @Override
    @NotNull
    public TriOp getOp() {
        return this.op;
    }

    @NotNull
    public String toString() {
        return "ITE(" + this.getOp1() + ", " + this.getOp2() + ", " + this.getOp3() + ")";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        Intrinsics.checkNotNullParameter(visitor, (String)"visitor");
        return visitor.visit(this);
    }
}

