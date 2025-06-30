/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.RefType
 *  soot.Scene
 *  soot.SootMethod
 *  soot.Type
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.MGlobal;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import com.feysh.corax.config.api.baseimpl.ConfigException;
import com.feysh.corax.config.api.baseimpl.IexLoad;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.RefType;
import soot.Scene;
import soot.SootMethod;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2={"Lcom/feysh/corax/config/api/baseimpl/SootParameter;", "T", "Lcom/feysh/corax/config/api/IParameterT;", "index", "", "method", "Lsoot/SootMethod;", "<init>", "(ILsoot/SootMethod;)V", "getIndex", "()I", "getMethod", "()Lsoot/SootMethod;", "expr", "Lcom/feysh/corax/config/api/IExpr;", "getExpr", "()Lcom/feysh/corax/config/api/IExpr;", "type", "Lsoot/Type;", "getType", "()Lsoot/Type;", "toString", "", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nAIAnalysisBaseImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnalysisBaseImpl.kt\ncom/feysh/corax/config/api/baseimpl/SootParameter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1477:1\n1#2:1478\n*E\n"})
public final class SootParameter<T>
implements IParameterT<T> {
    private final int index;
    @NotNull
    private final SootMethod method;
    @NotNull
    private final IExpr expr;

    public SootParameter(int index, @NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        this.index = index;
        this.method = method;
        if (!(this.getIndex() >= -2)) {
            boolean bl = false;
            String string = "invalid argument index: " + this.getIndex() + " ";
            throw new IllegalStateException(string.toString());
        }
        if (this.getIndex() >= 0 && this.getIndex() >= this.method.getParameterCount()) {
            throw new ConfigException(TuplesKt.to((Object)this, (Object)this.method));
        }
        if (this.getIndex() == -1 && this.method.isStatic()) {
            throw new ConfigException(TuplesKt.to((Object)this, (Object)this.method));
        }
        this.expr = new IexLoad(this.getIndex() == -2 ? (MLocal)MGlobal.INSTANCE : (MLocal)new MParameter(this.getIndex()));
    }

    @Override
    public int getIndex() {
        return this.index;
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
        Type type;
        if (this.getIndex() == -1) {
            RefType refType = this.method.getDeclaringClass().getType();
            Intrinsics.checkNotNullExpressionValue((Object)refType, (String)"getType(...)");
            type = (Type)refType;
        } else if (this.getIndex() == -2) {
            RefType refType = Scene.v().getObjectType();
            Intrinsics.checkNotNullExpressionValue((Object)refType, (String)"getObjectType(...)");
            type = (Type)refType;
        } else {
            Type type2 = this.method.getParameterType(this.getIndex());
            type = type2;
            Intrinsics.checkNotNullExpressionValue((Object)type2, (String)"getParameterType(...)");
        }
        return type;
    }

    @NotNull
    public String toString() {
        return this.getIndex() == -1 ? "this" : (this.getIndex() == -2 ? "global" : "arg" + this.getIndex());
    }
}

