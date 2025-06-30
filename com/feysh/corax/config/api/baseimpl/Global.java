/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IGlobal;
import com.feysh.corax.config.api.MGlobal;
import com.feysh.corax.config.api.baseimpl.IexLoad;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2={"Lcom/feysh/corax/config/api/baseimpl/Global;", "Lcom/feysh/corax/config/api/IGlobal;", "<init>", "()V", "expr", "Lcom/feysh/corax/config/api/IExpr;", "getExpr", "()Lcom/feysh/corax/config/api/IExpr;", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-config-api"})
public final class Global
implements IGlobal {
    @NotNull
    public static final Global INSTANCE = new Global();
    @NotNull
    private static final IExpr expr = new IexLoad(MGlobal.INSTANCE);

    private Global() {
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return expr;
    }

    @NotNull
    public String toString() {
        return "Global";
    }

    public int hashCode() {
        return 1101842269;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Global)) {
            return false;
        }
        Global cfr_ignored_0 = (Global)other;
        return true;
    }
}

