/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIstSetField;
import com.feysh.corax.config.api.IModelStmtVisitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0015"}, d2={"Lcom/feysh/corax/config/api/baseimpl/IstSetField;", "Lcom/feysh/corax/config/api/IIstSetField;", "base", "Lcom/feysh/corax/config/api/IExpr;", "field", "Lcom/feysh/corax/config/api/IClassField;", "value", "<init>", "(Lcom/feysh/corax/config/api/IExpr;Lcom/feysh/corax/config/api/IClassField;Lcom/feysh/corax/config/api/IExpr;)V", "getBase", "()Lcom/feysh/corax/config/api/IExpr;", "getField", "()Lcom/feysh/corax/config/api/IClassField;", "getValue", "accept", "TResult", "visitor", "Lcom/feysh/corax/config/api/IModelStmtVisitor;", "(Lcom/feysh/corax/config/api/IModelStmtVisitor;)Ljava/lang/Object;", "toString", "", "corax-config-api"})
public final class IstSetField
implements IIstSetField {
    @NotNull
    private final IExpr base;
    @NotNull
    private final IClassField field;
    @NotNull
    private final IExpr value;

    public IstSetField(@NotNull IExpr base, @NotNull IClassField field, @NotNull IExpr value) {
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.base = base;
        this.field = field;
        this.value = value;
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
        return "assign " + this.getBase() + "." + this.getField() + " = " + this.getValue();
    }
}

