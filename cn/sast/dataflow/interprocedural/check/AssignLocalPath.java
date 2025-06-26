/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.AssignLocalPath
 *  cn.sast.dataflow.interprocedural.check.AssignLocalPath$Companion
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.AssignLocalPath;
import cn.sast.dataflow.interprocedural.check.IPath;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2={"Lcn/sast/dataflow/interprocedural/check/AssignLocalPath;", "Lcn/sast/dataflow/interprocedural/check/IPath;", "node", "Lsoot/Unit;", "lhs", "", "rhsValue", "", "rhsValePath", "<init>", "(Lsoot/Unit;Ljava/lang/Object;Ljava/lang/String;Lcn/sast/dataflow/interprocedural/check/IPath;)V", "getNode", "()Lsoot/Unit;", "getLhs", "()Ljava/lang/Object;", "getRhsValue", "()Ljava/lang/String;", "getRhsValePath", "()Lcn/sast/dataflow/interprocedural/check/IPath;", "equivTo", "", "other", "hash", "", "getHash", "()Ljava/lang/Integer;", "setHash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "equivHashCode", "Companion", "corax-data-flow"})
public final class AssignLocalPath
extends IPath {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Unit node;
    @NotNull
    private final Object lhs;
    @NotNull
    private final String rhsValue;
    @NotNull
    private final IPath rhsValePath;
    @Nullable
    private Integer hash;

    private AssignLocalPath(Unit node, Object lhs, String rhsValue, IPath rhsValePath) {
        super(null);
        this.node = node;
        this.lhs = lhs;
        this.rhsValue = rhsValue;
        this.rhsValePath = rhsValePath;
    }

    @NotNull
    public Unit getNode() {
        return this.node;
    }

    @NotNull
    public final Object getLhs() {
        return this.lhs;
    }

    @NotNull
    public final String getRhsValue() {
        return this.rhsValue;
    }

    @NotNull
    public final IPath getRhsValePath() {
        return this.rhsValePath;
    }

    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssignLocalPath)) {
            return false;
        }
        if (this.equivHashCode() != ((AssignLocalPath)other).equivHashCode()) {
            return false;
        }
        if (this.getNode() != ((AssignLocalPath)other).getNode()) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.lhs, (Object)((AssignLocalPath)other).lhs)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.rhsValue, (Object)((AssignLocalPath)other).rhsValue)) {
            return false;
        }
        return this.rhsValePath == ((AssignLocalPath)other).rhsValePath;
    }

    @Nullable
    public final Integer getHash() {
        return this.hash;
    }

    public final void setHash(@Nullable Integer n) {
        this.hash = n;
    }

    public int equivHashCode() {
        Integer result = this.hash;
        if (result == null) {
            result = System.identityHashCode(this.getNode());
            result = 31 * result + this.lhs.hashCode();
            result = 31 * result + this.rhsValue.hashCode();
            result = 31 * result + this.rhsValePath.hashCode();
        }
        return result;
    }

    public /* synthetic */ AssignLocalPath(Unit node, Object lhs, String rhsValue, IPath rhsValePath, DefaultConstructorMarker $constructor_marker) {
        this(node, lhs, rhsValue, rhsValePath);
    }
}

