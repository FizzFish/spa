/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.MergePath
 *  cn.sast.dataflow.interprocedural.check.MergePath$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlinx.collections.immutable.PersistentSet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.MergePath;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2={"Lcn/sast/dataflow/interprocedural/check/MergePath;", "Lcn/sast/dataflow/interprocedural/check/IPath;", "node", "Lsoot/Unit;", "all", "Lkotlinx/collections/immutable/PersistentSet;", "<init>", "(Lsoot/Unit;Lkotlinx/collections/immutable/PersistentSet;)V", "getNode", "()Lsoot/Unit;", "getAll", "()Lkotlinx/collections/immutable/PersistentSet;", "equivTo", "", "other", "", "hash", "", "getHash", "()Ljava/lang/Integer;", "setHash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "equivHashCode", "Companion", "corax-data-flow"})
public final class MergePath
extends IPath {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Unit node;
    @NotNull
    private final PersistentSet<IPath> all;
    @Nullable
    private Integer hash;

    private MergePath(Unit node, PersistentSet<? extends IPath> all) {
        super(null);
        this.node = node;
        this.all = all;
    }

    @NotNull
    public Unit getNode() {
        return this.node;
    }

    @NotNull
    public final PersistentSet<IPath> getAll() {
        return this.all;
    }

    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MergePath)) {
            return false;
        }
        if (this.equivHashCode() != ((MergePath)other).equivHashCode()) {
            return false;
        }
        if (this.getNode() != ((MergePath)other).getNode()) {
            return false;
        }
        return this.all == ((MergePath)other).all;
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
            this.hash = result = Integer.valueOf(31 * result + System.identityHashCode(this.all));
        }
        return result;
    }

    public /* synthetic */ MergePath(Unit node, PersistentSet all, DefaultConstructorMarker $constructor_marker) {
        this(node, all);
    }
}

