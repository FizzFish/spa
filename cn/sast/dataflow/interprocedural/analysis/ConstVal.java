/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal$Companion
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.IValue$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IValue$Kind
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Type
 *  soot.jimple.Constant
 *  soot.jimple.NullConstant
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;
import soot.jimple.Constant;
import soot.jimple.NullConstant;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/ConstVal;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "v", "Lsoot/jimple/Constant;", "type", "Lsoot/Type;", "<init>", "(Lsoot/jimple/Constant;Lsoot/Type;)V", "getV", "()Lsoot/jimple/Constant;", "getType", "()Lsoot/Type;", "toString", "", "typeIsConcrete", "", "equals", "other", "", "hash", "", "getHash", "()Ljava/lang/Integer;", "setHash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hashCode", "isNullConstant", "getKind", "Lcn/sast/dataflow/interprocedural/analysis/IValue$Kind;", "Companion", "corax-data-flow"})
public final class ConstVal
implements IValue {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Constant v;
    @NotNull
    private final Type type;
    @Nullable
    private Integer hash;

    private ConstVal(Constant v, Type type) {
        this.v = v;
        this.type = type;
    }

    /* synthetic */ ConstVal(Constant constant, Type type, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            type = constant.getType();
        }
        this(constant, type);
    }

    @NotNull
    public final Constant getV() {
        return this.v;
    }

    @NotNull
    public Type getType() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "const_" + this.getType() + "_" + this.v;
    }

    public boolean typeIsConcrete() {
        return true;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof ConstVal)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.v, (Object)((ConstVal)other).v)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.getType(), (Object)((ConstVal)other).getType());
    }

    @Nullable
    public final Integer getHash() {
        return this.hash;
    }

    public final void setHash(@Nullable Integer n) {
        this.hash = n;
    }

    public int hashCode() {
        Integer result = this.hash;
        if (result == null) {
            result = this.v.hashCode();
            this.hash = result = Integer.valueOf(31 * result + this.getType().hashCode());
        }
        return result;
    }

    public boolean isNullConstant() {
        return this.v instanceof NullConstant;
    }

    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Normal;
    }

    public boolean isNormal() {
        return IValue.DefaultImpls.isNormal((IValue)this);
    }

    @Nullable
    public Boolean objectEqual(@NotNull IValue b) {
        return IValue.DefaultImpls.objectEqual((IValue)this, (IValue)b);
    }

    @NotNull
    public IValue clone() {
        return IValue.DefaultImpls.clone((IValue)this);
    }

    @NotNull
    public IValue copy(@NotNull Type type) {
        return IValue.DefaultImpls.copy((IValue)this, (Type)type);
    }

    public /* synthetic */ ConstVal(Constant v, Type type, DefaultConstructorMarker $constructor_marker) {
        this(v, type);
    }
}

