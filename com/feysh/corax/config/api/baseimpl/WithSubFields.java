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
import com.feysh.corax.config.api.IWithSubFieldsT;
import com.feysh.corax.config.api.SubFields;
import com.feysh.corax.config.api.baseimpl.IexGetFieldExpr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2={"Lcom/feysh/corax/config/api/baseimpl/WithSubFields;", "Lcom/feysh/corax/config/api/IWithSubFieldsT;", "base", "Lcom/feysh/corax/config/api/IExpr;", "<init>", "(Lcom/feysh/corax/config/api/IExpr;)V", "getBase", "()Lcom/feysh/corax/config/api/IExpr;", "expr", "getExpr", "toString", "", "corax-config-api"})
public final class WithSubFields
implements IWithSubFieldsT {
    @NotNull
    private final IExpr base;
    @NotNull
    private final IExpr expr;

    public WithSubFields(@NotNull IExpr base) {
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        this.base = base;
        this.expr = IexGetFieldExpr.Companion.invoke(this.base, SubFields.INSTANCE);
    }

    @NotNull
    public final IExpr getBase() {
        return this.base;
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

