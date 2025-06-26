/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.MethodResult
 *  cn.sast.dataflow.interprocedural.analysis.SymbolicFailure
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0013\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J>\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006 "}, d2={"Lcn/sast/dataflow/interprocedural/analysis/SymbolicFailure;", "V", "Lcn/sast/dataflow/interprocedural/analysis/MethodResult;", "symbolic", "concrete", "", "explicit", "", "inNestedMethod", "<init>", "(Ljava/lang/Object;Ljava/lang/Throwable;ZZ)V", "getSymbolic", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getConcrete", "()Ljava/lang/Throwable;", "getExplicit", "()Z", "getInNestedMethod", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/Throwable;ZZ)Lcn/sast/dataflow/interprocedural/analysis/SymbolicFailure;", "equals", "other", "", "hashCode", "", "toString", "", "corax-data-flow"})
public final class SymbolicFailure<V>
extends MethodResult<V> {
    private final V symbolic;
    @Nullable
    private final Throwable concrete;
    private final boolean explicit;
    private final boolean inNestedMethod;

    public SymbolicFailure(V symbolic, @Nullable Throwable concrete, boolean explicit, boolean inNestedMethod) {
        super(null);
        this.symbolic = symbolic;
        this.concrete = concrete;
        this.explicit = explicit;
        this.inNestedMethod = inNestedMethod;
    }

    public final V getSymbolic() {
        return (V)this.symbolic;
    }

    @Nullable
    public final Throwable getConcrete() {
        return this.concrete;
    }

    public final boolean getExplicit() {
        return this.explicit;
    }

    public final boolean getInNestedMethod() {
        return this.inNestedMethod;
    }

    public final V component1() {
        return (V)this.symbolic;
    }

    @Nullable
    public final Throwable component2() {
        return this.concrete;
    }

    public final boolean component3() {
        return this.explicit;
    }

    public final boolean component4() {
        return this.inNestedMethod;
    }

    @NotNull
    public final SymbolicFailure<V> copy(V symbolic, @Nullable Throwable concrete, boolean explicit, boolean inNestedMethod) {
        return new SymbolicFailure(symbolic, concrete, explicit, inNestedMethod);
    }

    public static /* synthetic */ SymbolicFailure copy$default(SymbolicFailure symbolicFailure, Object object, Throwable throwable, boolean bl, boolean bl2, int n, Object object2) {
        if ((n & 1) != 0) {
            object = symbolicFailure.symbolic;
        }
        if ((n & 2) != 0) {
            throwable = symbolicFailure.concrete;
        }
        if ((n & 4) != 0) {
            bl = symbolicFailure.explicit;
        }
        if ((n & 8) != 0) {
            bl2 = symbolicFailure.inNestedMethod;
        }
        return symbolicFailure.copy(object, throwable, bl, bl2);
    }

    @NotNull
    public String toString() {
        return "SymbolicFailure(symbolic=" + this.symbolic + ", concrete=" + this.concrete + ", explicit=" + this.explicit + ", inNestedMethod=" + this.inNestedMethod + ")";
    }

    public int hashCode() {
        int result = this.symbolic == null ? 0 : this.symbolic.hashCode();
        result = result * 31 + (this.concrete == null ? 0 : this.concrete.hashCode());
        result = result * 31 + Boolean.hashCode(this.explicit);
        result = result * 31 + Boolean.hashCode(this.inNestedMethod);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SymbolicFailure)) {
            return false;
        }
        SymbolicFailure symbolicFailure = (SymbolicFailure)other;
        if (!Intrinsics.areEqual((Object)this.symbolic, (Object)symbolicFailure.symbolic)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.concrete, (Object)symbolicFailure.concrete)) {
            return false;
        }
        if (this.explicit != symbolicFailure.explicit) {
            return false;
        }
        return this.inNestedMethod == symbolicFailure.inNestedMethod;
    }
}

