/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.MethodResult
 *  cn.sast.dataflow.interprocedural.analysis.SymbolicSuccess
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.MethodResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000H\u00c6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/SymbolicSuccess;", "V", "Lcn/sast/dataflow/interprocedural/analysis/MethodResult;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/SymbolicSuccess;", "equals", "", "other", "", "hashCode", "", "toString", "", "corax-data-flow"})
public final class SymbolicSuccess<V>
extends MethodResult<V> {
    private final V value;

    public SymbolicSuccess(V value) {
        super(null);
        this.value = value;
    }

    public final V getValue() {
        return (V)this.value;
    }

    public final V component1() {
        return (V)this.value;
    }

    @NotNull
    public final SymbolicSuccess<V> copy(V value) {
        return new SymbolicSuccess(value);
    }

    public static /* synthetic */ SymbolicSuccess copy$default(SymbolicSuccess symbolicSuccess, Object object, int n, Object object2) {
        if ((n & 1) != 0) {
            object = symbolicSuccess.value;
        }
        return symbolicSuccess.copy(object);
    }

    @NotNull
    public String toString() {
        return "SymbolicSuccess(value=" + this.value + ")";
    }

    public int hashCode() {
        return this.value == null ? 0 : this.value.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SymbolicSuccess)) {
            return false;
        }
        SymbolicSuccess symbolicSuccess = (SymbolicSuccess)other;
        return Intrinsics.areEqual((Object)this.value, (Object)symbolicSuccess.value);
    }
}

