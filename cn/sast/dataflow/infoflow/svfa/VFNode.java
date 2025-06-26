/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.VFNode
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Unit
 *  soot.Value
 */
package cn.sast.dataflow.infoflow.svfa;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;
import soot.Value;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2={"Lcn/sast/dataflow/infoflow/svfa/VFNode;", "", "ap", "Lsoot/Value;", "stmt", "Lsoot/Unit;", "<init>", "(Lsoot/Value;Lsoot/Unit;)V", "getAp", "()Lsoot/Value;", "getStmt", "()Lsoot/Unit;", "hashCode", "", "equals", "", "other", "toString", "", "corax-data-flow"})
public final class VFNode {
    @NotNull
    private final Value ap;
    @NotNull
    private final Unit stmt;

    public VFNode(@NotNull Value ap, @NotNull Unit stmt) {
        Intrinsics.checkNotNullParameter((Object)ap, (String)"ap");
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        this.ap = ap;
        this.stmt = stmt;
    }

    @NotNull
    public final Value getAp() {
        return this.ap;
    }

    @NotNull
    public final Unit getStmt() {
        return this.stmt;
    }

    public int hashCode() {
        Object[] objectArray = new Object[]{this.ap, this.stmt};
        return Objects.hash(objectArray);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VFNode)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.ap, (Object)((VFNode)other).ap) && Intrinsics.areEqual((Object)this.stmt, (Object)((VFNode)other).stmt);
    }

    @NotNull
    public String toString() {
        return this.ap + " " + this.stmt;
    }
}

