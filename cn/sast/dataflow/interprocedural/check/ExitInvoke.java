/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.ExitInvoke
 *  cn.sast.dataflow.interprocedural.check.InvokeEdgePath
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.InvokeEdgePath;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2={"Lcn/sast/dataflow/interprocedural/check/ExitInvoke;", "", "invoke", "Lcn/sast/dataflow/interprocedural/check/InvokeEdgePath;", "<init>", "(Lcn/sast/dataflow/interprocedural/check/InvokeEdgePath;)V", "getInvoke", "()Lcn/sast/dataflow/interprocedural/check/InvokeEdgePath;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "corax-data-flow"})
public final class ExitInvoke {
    @NotNull
    private final InvokeEdgePath invoke;

    public ExitInvoke(@NotNull InvokeEdgePath invoke) {
        Intrinsics.checkNotNullParameter((Object)invoke, (String)"invoke");
        this.invoke = invoke;
    }

    @NotNull
    public final InvokeEdgePath getInvoke() {
        return this.invoke;
    }

    @NotNull
    public final InvokeEdgePath component1() {
        return this.invoke;
    }

    @NotNull
    public final ExitInvoke copy(@NotNull InvokeEdgePath invoke) {
        Intrinsics.checkNotNullParameter((Object)invoke, (String)"invoke");
        return new ExitInvoke(invoke);
    }

    public static /* synthetic */ ExitInvoke copy$default(ExitInvoke exitInvoke, InvokeEdgePath invokeEdgePath, int n, Object object) {
        if ((n & 1) != 0) {
            invokeEdgePath = exitInvoke.invoke;
        }
        return exitInvoke.copy(invokeEdgePath);
    }

    @NotNull
    public String toString() {
        return "ExitInvoke(invoke=" + this.invoke + ")";
    }

    public int hashCode() {
        return this.invoke.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExitInvoke)) {
            return false;
        }
        ExitInvoke exitInvoke = (ExitInvoke)other;
        return Intrinsics.areEqual((Object)this.invoke, (Object)exitInvoke.invoke);
    }
}

