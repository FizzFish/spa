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
import com.feysh.corax.config.api.IIstStoreLocal;
import com.feysh.corax.config.api.IModelStmtVisitor;
import com.feysh.corax.config.api.MLocal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/config/api/baseimpl/IstStoreLocal;", "Lcom/feysh/corax/config/api/IIstStoreLocal;", "local", "Lcom/feysh/corax/config/api/MLocal;", "value", "Lcom/feysh/corax/config/api/IExpr;", "<init>", "(Lcom/feysh/corax/config/api/MLocal;Lcom/feysh/corax/config/api/IExpr;)V", "getLocal", "()Lcom/feysh/corax/config/api/MLocal;", "getValue", "()Lcom/feysh/corax/config/api/IExpr;", "accept", "TResult", "visitor", "Lcom/feysh/corax/config/api/IModelStmtVisitor;", "(Lcom/feysh/corax/config/api/IModelStmtVisitor;)Ljava/lang/Object;", "toString", "", "corax-config-api"})
public final class IstStoreLocal
implements IIstStoreLocal {
    @NotNull
    private final MLocal local;
    @NotNull
    private final IExpr value;

    public IstStoreLocal(@NotNull MLocal local, @NotNull IExpr value) {
        Intrinsics.checkNotNullParameter((Object)local, (String)"local");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.local = local;
        this.value = value;
    }

    @Override
    @NotNull
    public MLocal getLocal() {
        return this.local;
    }

    @Override
    @NotNull
    public IExpr getValue() {
        return this.value;
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelStmtVisitor<TResult> visitor) {
        Intrinsics.checkNotNullParameter(visitor, (String)"visitor");
        return visitor.visit(this);
    }

    @NotNull
    public String toString() {
        return "assign " + this.getLocal() + " = " + this.getValue();
    }
}

