/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext
 *  cn.sast.dataflow.interprocedural.check.EntryPath
 *  cn.sast.dataflow.interprocedural.check.EntryPath$Companion
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlinx.collections.immutable.PersistentList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import cn.sast.dataflow.interprocedural.check.EntryPath;
import cn.sast.dataflow.interprocedural.check.IPath;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2={"Lcn/sast/dataflow/interprocedural/check/EntryPath;", "Lcn/sast/dataflow/interprocedural/check/IPath;", "special", "Lkotlinx/collections/immutable/PersistentList;", "Lcn/sast/dataflow/interprocedural/analysis/ReferenceContext;", "node", "Lsoot/Unit;", "<init>", "(Lkotlinx/collections/immutable/PersistentList;Lsoot/Unit;)V", "getNode", "()Lsoot/Unit;", "getSpecial", "()Lkotlinx/collections/immutable/PersistentList;", "toString", "", "equivTo", "", "other", "", "hash", "", "getHash", "()Ljava/lang/Integer;", "setHash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "equivHashCode", "Companion", "corax-data-flow"})
public final class EntryPath
extends IPath {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Unit node;
    @NotNull
    private final PersistentList<ReferenceContext> special;
    @Nullable
    private Integer hash;

    private EntryPath(PersistentList<? extends ReferenceContext> special, Unit node) {
        super(null);
        this.node = node;
        this.special = (PersistentList)IPath.Companion.specialInterner(special);
    }

    @NotNull
    public Unit getNode() {
        return this.node;
    }

    @NotNull
    public final PersistentList<ReferenceContext> getSpecial() {
        return this.special;
    }

    @NotNull
    public String toString() {
        return CollectionsKt.joinToString$default((Iterable)((Iterable)this.special), (CharSequence)":", null, null, (int)0, null, null, (int)62, null) + " " + this.getNode();
    }

    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntryPath)) {
            return false;
        }
        if (this.equivHashCode() != ((EntryPath)other).equivHashCode()) {
            return false;
        }
        if (this.getNode() != ((EntryPath)other).getNode()) {
            return false;
        }
        return this.special == ((EntryPath)other).special;
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
            this.hash = result = Integer.valueOf(31 * result + System.identityHashCode(this.special));
        }
        return result;
    }

    public /* synthetic */ EntryPath(PersistentList special, Unit node, DefaultConstructorMarker $constructor_marker) {
        this(special, node);
    }
}

