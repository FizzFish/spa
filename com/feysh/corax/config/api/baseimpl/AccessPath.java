/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.baseimpl.IexGetFieldExpr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/config/api/baseimpl/AccessPath;", "T", "Lcom/feysh/corax/config/api/IAccessPathT;", "base", "Lcom/feysh/corax/config/api/IExpr;", "field", "Lcom/feysh/corax/config/api/IClassField;", "<init>", "(Lcom/feysh/corax/config/api/IExpr;Lcom/feysh/corax/config/api/IClassField;)V", "getBase", "()Lcom/feysh/corax/config/api/IExpr;", "getField", "()Lcom/feysh/corax/config/api/IClassField;", "expr", "getExpr", "toString", "", "corax-config-api"})
public final class AccessPath<T>
implements IAccessPathT<T> {
    @NotNull
    private final IExpr base;
    @NotNull
    private final IClassField field;

    public AccessPath(@NotNull IExpr base, @NotNull IClassField field) {
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        this.base = base;
        this.field = field;
    }

    @Override
    @NotNull
    public IExpr getBase() {
        return this.base;
    }

    @Override
    @NotNull
    public IClassField getField() {
        return this.field;
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return IexGetFieldExpr.Companion.invoke(this.getBase(), this.getField());
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.getExpr());
    }
}

