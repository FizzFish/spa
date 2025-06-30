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
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/config/api/baseimpl/Attribute;", "K", "Lcom/feysh/corax/config/api/IClassField;", "V", "Lcom/feysh/corax/config/api/IAttribute;", "value", "Lcom/feysh/corax/config/api/IExpr;", "<init>", "(Lcom/feysh/corax/config/api/IExpr;)V", "getValue", "()Lcom/feysh/corax/config/api/IExpr;", "corax-config-api"})
public final class Attribute<K extends IClassField, V>
implements IAttribute<K, V> {
    @NotNull
    private final IExpr value;

    public Attribute(@NotNull IExpr value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.value = value;
    }

    @Override
    @NotNull
    public IExpr getValue() {
        return this.value;
    }
}

