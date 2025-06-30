/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.ViaProperty;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0002`\u0005B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/config/api/baseimpl/ViaSet;", "Lcom/feysh/corax/config/api/IAttribute;", "Lcom/feysh/corax/config/api/ViaProperty;", "", "Lcom/feysh/corax/config/api/IViaType;", "Lcom/feysh/corax/config/api/IViaSet;", "value", "Lcom/feysh/corax/config/api/IExpr;", "<init>", "(Lcom/feysh/corax/config/api/IExpr;)V", "getValue", "()Lcom/feysh/corax/config/api/IExpr;", "toString", "", "corax-config-api"})
public final class ViaSet
implements IAttribute<ViaProperty, Set<? extends IViaType>> {
    @NotNull
    private final IExpr value;

    public ViaSet(@NotNull IExpr value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.value = value;
    }

    @Override
    @NotNull
    public IExpr getValue() {
        return this.value;
    }

    @NotNull
    public String toString() {
        return "GetViaSet( " + this.getValue() + " )";
    }
}

