/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.MGlobal;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import com.feysh.corax.config.api.baseimpl.IexLoad;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lcom/feysh/corax/config/api/baseimpl/Parameter;", "T", "Lcom/feysh/corax/config/api/IParameterT;", "index", "", "<init>", "(I)V", "getIndex", "()I", "expr", "Lcom/feysh/corax/config/api/IExpr;", "getExpr", "()Lcom/feysh/corax/config/api/IExpr;", "toString", "", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nAIAnalysisBaseImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisBaseImpl.kt\ncom/feysh/corax/config/api/baseimpl/Parameter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1477:1\n1#2:1478\n*E\n"})
public final class Parameter<T>
implements IParameterT<T> {
    private final int index;
    @NotNull
    private final IExpr expr;

    public Parameter(int index) {
        this.index = index;
        if (!(this.getIndex() >= -2)) {
            boolean bl = false;
            String string = "invalid argument index: " + this.getIndex() + " ";
            throw new IllegalStateException(string.toString());
        }
        this.expr = new IexLoad(this.getIndex() == -2 ? (MLocal)MGlobal.INSTANCE : (MLocal)new MParameter(this.getIndex()));
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    @NotNull
    public IExpr getExpr() {
        return this.expr;
    }

    @NotNull
    public String toString() {
        return this.getIndex() == -1 ? "this" : (this.getIndex() == -2 ? "global" : "arg" + this.getIndex());
    }
}

