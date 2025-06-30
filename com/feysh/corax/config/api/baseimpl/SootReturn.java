/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 *  soot.Type
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IReturnT;
import com.feysh.corax.config.api.MReturn;
import com.feysh.corax.config.api.baseimpl.IexLoad;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/config/api/baseimpl/SootReturn;", "T", "Lcom/feysh/corax/config/api/IReturnT;", "method", "Lsoot/SootMethod;", "<init>", "(Lsoot/SootMethod;)V", "getMethod", "()Lsoot/SootMethod;", "expr", "Lcom/feysh/corax/config/api/IExpr;", "getExpr", "()Lcom/feysh/corax/config/api/IExpr;", "type", "Lsoot/Type;", "getType", "()Lsoot/Type;", "toString", "", "corax-config-api"})
public final class SootReturn<T>
implements IReturnT<T> {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final IExpr expr;
    @NotNull
    private final Type type;

    public SootReturn(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        this.method = method;
        this.expr = new IexLoad(MReturn.INSTANCE);
        Type type = this.method.getReturnType();
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getReturnType(...)");
        this.type = type;
    }

    @NotNull
    public final SootMethod getMethod() {
        return this.method;
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return this.expr;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "Return";
    }
}

