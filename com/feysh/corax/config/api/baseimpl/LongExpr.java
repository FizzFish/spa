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
import com.feysh.corax.config.api.ILongExpr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/config/api/baseimpl/LongExpr;", "Lcom/feysh/corax/config/api/ILongExpr;", "expr", "Lcom/feysh/corax/config/api/IExpr;", "<init>", "(Lcom/feysh/corax/config/api/IExpr;)V", "getExpr", "()Lcom/feysh/corax/config/api/IExpr;", "toString", "", "corax-config-api"})
public final class LongExpr
implements ILongExpr {
    @NotNull
    private final IExpr expr;

    public LongExpr(@NotNull IExpr expr) {
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        this.expr = expr;
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return this.expr;
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.getExpr());
    }
}

