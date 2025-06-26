/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewValue
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.IValue$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IValue$Kind
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 *  soot.RefType
 *  soot.Type
 *  soot.Unit
 *  soot.jimple.AnyNewExpr
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.RefType;
import soot.Type;
import soot.Unit;
import soot.jimple.AnyNewExpr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\u0006\u0010%\u001a\u00020\u001fJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006&"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/AnyNewValue;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "u", "Lsoot/Unit;", "method", "", "newExpr", "Lsoot/jimple/AnyNewExpr;", "<init>", "(Lsoot/Unit;Ljava/lang/String;Lsoot/jimple/AnyNewExpr;)V", "getU", "()Lsoot/Unit;", "getMethod", "()Ljava/lang/String;", "getNewExpr", "()Lsoot/jimple/AnyNewExpr;", "clone", "toString", "type", "Lsoot/Type;", "getType", "()Lsoot/Type;", "typeIsConcrete", "", "isNullConstant", "getKind", "Lcn/sast/dataflow/interprocedural/analysis/IValue$Kind;", "equals", "other", "", "hashCode", "", "getHashCode", "()Ljava/lang/Integer;", "setHashCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hash", "corax-data-flow"})
public class AnyNewValue
implements IValue {
    @NotNull
    private final Unit u;
    @NotNull
    private final String method;
    @NotNull
    private final AnyNewExpr newExpr;
    @NotNull
    private final Type type;
    @Nullable
    private Integer hashCode;

    public AnyNewValue(@NotNull Unit u, @NotNull String method, @NotNull AnyNewExpr newExpr2) {
        Intrinsics.checkNotNullParameter((Object)u, (String)"u");
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)newExpr2, (String)"newExpr");
        this.u = u;
        this.method = method;
        this.newExpr = newExpr2;
        if (!(this.newExpr.getType() instanceof RefType) && !(this.newExpr.getType() instanceof ArrayType)) {
            throw new IllegalStateException(String.valueOf(this.newExpr).toString());
        }
        Type type = this.newExpr.getType();
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
        this.type = type;
    }

    @NotNull
    public final Unit getU() {
        return this.u;
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final AnyNewExpr getNewExpr() {
        return this.newExpr;
    }

    @NotNull
    public IValue clone() {
        return (IValue)new AnyNewValue(this.u, this.method, this.newExpr);
    }

    @NotNull
    public String toString() {
        return this.newExpr + " *" + this.u.getJavaSourceStartLineNumber() + " (" + this.hashCode() + ")";
    }

    @NotNull
    public Type getType() {
        return this.type;
    }

    public boolean typeIsConcrete() {
        return true;
    }

    public boolean isNullConstant() {
        return false;
    }

    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Normal;
    }

    public boolean equals(@Nullable Object other) {
        if (!FactValuesKt.getLeastExpr()) {
            return this == other;
        }
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof AnyNewValue)) {
            return false;
        }
        if (this.hashCode != null && ((AnyNewValue)other).hashCode != null && !Intrinsics.areEqual((Object)this.hashCode, (Object)((AnyNewValue)other).hashCode)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.method, (Object)((AnyNewValue)other).method)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.newExpr, (Object)((AnyNewValue)other).newExpr)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.getType(), (Object)((AnyNewValue)other).getType());
    }

    @Nullable
    public final Integer getHashCode() {
        return this.hashCode;
    }

    public final void setHashCode(@Nullable Integer n) {
        this.hashCode = n;
    }

    public final int hash() {
        if (!FactValuesKt.getLeastExpr()) {
            return System.identityHashCode(this);
        }
        int result = 1;
        result = 31 * result + this.method.hashCode();
        result = 31 * result + this.newExpr.hashCode();
        result = 31 * result + this.getType().hashCode();
        return result;
    }

    public int hashCode() {
        Integer h = this.hashCode;
        if (h == null) {
            this.hashCode = h = Integer.valueOf(this.hash());
        }
        return h;
    }

    public boolean isNormal() {
        return IValue.DefaultImpls.isNormal((IValue)this);
    }

    @Nullable
    public Boolean objectEqual(@NotNull IValue b) {
        return IValue.DefaultImpls.objectEqual((IValue)this, (IValue)b);
    }

    @NotNull
    public IValue copy(@NotNull Type type) {
        return IValue.DefaultImpls.copy((IValue)this, (Type)type);
    }
}

