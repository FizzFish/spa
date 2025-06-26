/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.UnknownPath
 *  cn.sast.dataflow.interprocedural.check.UnknownPath$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.UnknownPath;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2={"Lcn/sast/dataflow/interprocedural/check/UnknownPath;", "Lcn/sast/dataflow/interprocedural/check/IPath;", "node", "Lsoot/Unit;", "<init>", "(Lsoot/Unit;)V", "getNode", "()Lsoot/Unit;", "equivTo", "", "other", "", "hash", "", "getHash", "()Ljava/lang/Integer;", "setHash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "equivHashCode", "Companion", "corax-data-flow"})
public final class UnknownPath
extends IPath {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Unit node;
    @Nullable
    private Integer hash;

    private UnknownPath(Unit node) {
        super(null);
        this.node = node;
    }

    @NotNull
    public Unit getNode() {
        return this.node;
    }

    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnknownPath)) {
            return false;
        }
        if (this.equivHashCode() != ((UnknownPath)other).equivHashCode()) {
            return false;
        }
        return this.getNode() == ((UnknownPath)other).getNode();
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
            this.hash = result = Integer.valueOf(System.identityHashCode(this.getNode()));
        }
        return result;
    }

    public /* synthetic */ UnknownPath(Unit node, DefaultConstructorMarker $constructor_marker) {
        this(node);
    }
}

