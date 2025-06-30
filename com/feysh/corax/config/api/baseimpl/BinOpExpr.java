/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.BinOp;
import com.feysh.corax.config.api.IBinOpExpr;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J!\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0016\u00a2\u0006\u0002\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0015"}, d2={"Lcom/feysh/corax/config/api/baseimpl/BinOpExpr;", "Lcom/feysh/corax/config/api/IBinOpExpr;", "op", "Lcom/feysh/corax/config/api/BinOp;", "op1", "Lcom/feysh/corax/config/api/IExpr;", "op2", "<init>", "(Lcom/feysh/corax/config/api/BinOp;Lcom/feysh/corax/config/api/IExpr;Lcom/feysh/corax/config/api/IExpr;)V", "getOp", "()Lcom/feysh/corax/config/api/BinOp;", "getOp1", "()Lcom/feysh/corax/config/api/IExpr;", "getOp2", "toString", "", "accept", "TResult", "visitor", "Lcom/feysh/corax/config/api/IModelExpressionVisitor;", "(Lcom/feysh/corax/config/api/IModelExpressionVisitor;)Ljava/lang/Object;", "corax-config-api"})
public final class BinOpExpr
implements IBinOpExpr {
    @NotNull
    private final BinOp op;
    @NotNull
    private final IExpr op1;
    @NotNull
    private final IExpr op2;

    public BinOpExpr(@NotNull BinOp op, @NotNull IExpr op1, @NotNull IExpr op2) {
        Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
        Intrinsics.checkNotNullParameter((Object)op1, (String)"op1");
        Intrinsics.checkNotNullParameter((Object)op2, (String)"op2");
        this.op = op;
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    @NotNull
    public BinOp getOp() {
        return this.op;
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

    @NotNull
    public String toString() {
        return this.getOp() + "( " + this.getOp1() + ", " + this.getOp2() + " )";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        Intrinsics.checkNotNullParameter(visitor, (String)"visitor");
        return visitor.visit(this);
    }
}

