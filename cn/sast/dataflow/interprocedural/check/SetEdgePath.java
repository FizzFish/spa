/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.SetEdgePath
 *  cn.sast.dataflow.interprocedural.check.SetEdgePath$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.SetEdgePath;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(BY\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\n\u0010\b\u001a\u00060\tj\u0002`\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\u0010\f\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010'\u001a\u00020!H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u00060\tj\u0002`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\f\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2={"Lcn/sast/dataflow/interprocedural/check/SetEdgePath;", "Lcn/sast/dataflow/interprocedural/check/IPath;", "node", "Lsoot/Unit;", "heapObject", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "heapObjectPath", "mt", "", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "key", "value", "valuePath", "info", "<init>", "(Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IValue;Lcn/sast/dataflow/interprocedural/check/IPath;Ljava/lang/Object;Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/analysis/IValue;Lcn/sast/dataflow/interprocedural/check/IPath;Ljava/lang/Object;)V", "getNode", "()Lsoot/Unit;", "getHeapObject", "()Lcn/sast/dataflow/interprocedural/analysis/IValue;", "getHeapObjectPath", "()Lcn/sast/dataflow/interprocedural/check/IPath;", "getMt", "()Ljava/lang/Object;", "getKey", "getValue", "getValuePath", "getInfo", "equivTo", "", "other", "hash", "", "getHash", "()Ljava/lang/Integer;", "setHash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "equivHashCode", "Companion", "corax-data-flow"})
public final class SetEdgePath
extends IPath {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Unit node;
    @NotNull
    private final IValue heapObject;
    @NotNull
    private final IPath heapObjectPath;
    @NotNull
    private final Object mt;
    @Nullable
    private final Object key;
    @NotNull
    private final IValue value;
    @NotNull
    private final IPath valuePath;
    @Nullable
    private final Object info;
    @Nullable
    private Integer hash;

    private SetEdgePath(Unit node, IValue heapObject, IPath heapObjectPath, Object mt, Object key2, IValue value, IPath valuePath, Object info2) {
        super(null);
        this.node = node;
        this.heapObject = heapObject;
        this.heapObjectPath = heapObjectPath;
        this.mt = mt;
        this.key = key2;
        this.value = value;
        this.valuePath = valuePath;
        this.info = info2;
    }

    @NotNull
    public Unit getNode() {
        return this.node;
    }

    @NotNull
    public final IValue getHeapObject() {
        return this.heapObject;
    }

    @NotNull
    public final IPath getHeapObjectPath() {
        return this.heapObjectPath;
    }

    @NotNull
    public final Object getMt() {
        return this.mt;
    }

    @Nullable
    public final Object getKey() {
        return this.key;
    }

    @NotNull
    public final IValue getValue() {
        return this.value;
    }

    @NotNull
    public final IPath getValuePath() {
        return this.valuePath;
    }

    @Nullable
    public final Object getInfo() {
        return this.info;
    }

    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetEdgePath)) {
            return false;
        }
        if (this.equivHashCode() != ((SetEdgePath)other).equivHashCode()) {
            return false;
        }
        if (this.getNode() != ((SetEdgePath)other).getNode()) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.heapObject, (Object)((SetEdgePath)other).heapObject)) {
            return false;
        }
        if (this.heapObjectPath != ((SetEdgePath)other).heapObjectPath) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.mt, (Object)((SetEdgePath)other).mt)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.key, (Object)((SetEdgePath)other).key)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.value, (Object)((SetEdgePath)other).value)) {
            return false;
        }
        if (this.valuePath != ((SetEdgePath)other).valuePath) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.info, (Object)((SetEdgePath)other).info);
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
            result = 31 * result + this.heapObject.hashCode();
            result = 31 * result + this.heapObjectPath.hashCode();
            result = 31 * result + this.mt.hashCode();
            Object object = this.key;
            result = 31 * result + (object != null ? object.hashCode() : 0);
            result = 31 * result + this.value.hashCode();
            result = 31 * result + this.valuePath.hashCode();
            Object object2 = this.info;
            this.hash = result = Integer.valueOf(31 * result + (object2 != null ? object2.hashCode() : 0));
        }
        return result;
    }

    public /* synthetic */ SetEdgePath(Unit node, IValue heapObject, IPath heapObjectPath, Object mt, Object key2, IValue value, IPath valuePath, Object info2, DefaultConstructorMarker $constructor_marker) {
        this(node, heapObject, heapObjectPath, mt, key2, value, valuePath, info2);
    }
}

