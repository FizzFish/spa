/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.validate;

import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IBoolExpr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/config/api/validate/CheckInfo;", "", "checkExpr", "Lcom/feysh/corax/config/api/IBoolExpr;", "check", "Lcom/feysh/corax/config/api/CheckType;", "<init>", "(Lcom/feysh/corax/config/api/IBoolExpr;Lcom/feysh/corax/config/api/CheckType;)V", "getCheckExpr", "()Lcom/feysh/corax/config/api/IBoolExpr;", "getCheck", "()Lcom/feysh/corax/config/api/CheckType;", "toString", "", "corax-config-api"})
public final class CheckInfo {
    @NotNull
    private final IBoolExpr checkExpr;
    @NotNull
    private final CheckType check;

    public CheckInfo(@NotNull IBoolExpr checkExpr, @NotNull CheckType check) {
        Intrinsics.checkNotNullParameter((Object)checkExpr, (String)"checkExpr");
        Intrinsics.checkNotNullParameter((Object)check, (String)"check");
        this.checkExpr = checkExpr;
        this.check = check;
    }

    @NotNull
    public final IBoolExpr getCheckExpr() {
        return this.checkExpr;
    }

    @NotNull
    public final CheckType getCheck() {
        return this.check;
    }

    @NotNull
    public String toString() {
        return "report bug " + this.check + " if " + this.checkExpr;
    }
}

