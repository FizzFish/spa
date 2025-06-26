/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapBuilder
 *  cn.sast.dataflow.interprocedural.check.ArraySpace
 *  cn.sast.dataflow.interprocedural.check.ArraySpaceBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapBuilder;
import cn.sast.dataflow.interprocedural.check.ArraySpace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001BC\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lcn/sast/dataflow/interprocedural/check/ArraySpaceBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/heapimpl/ArrayHeapBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "orig", "Lcn/sast/dataflow/interprocedural/check/ArraySpace;", "element", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "<init>", "(Lcn/sast/dataflow/interprocedural/check/ArraySpace;Lkotlinx/collections/immutable/PersistentMap$Builder;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "getOrig", "()Lcn/sast/dataflow/interprocedural/check/ArraySpace;", "build", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "corax-data-flow"})
public class ArraySpaceBuilder
extends ArrayHeapBuilder<IValue> {
    @NotNull
    private final ArraySpace orig;

    public ArraySpaceBuilder(@NotNull ArraySpace orig, @NotNull PersistentMap.Builder<Integer, IHeapValues<IValue>> element, @Nullable IHeapValues.Builder<IValue> unreferenced) {
        Intrinsics.checkNotNullParameter((Object)orig, (String)"orig");
        Intrinsics.checkNotNullParameter(element, (String)"element");
        super(element, unreferenced, orig.getType(), orig.getAllSize().builder(), orig.getSize(), orig.getInitializedValue());
        this.orig = orig;
    }

    @NotNull
    public final ArraySpace getOrig() {
        return this.orig;
    }

    @NotNull
    public IData<IValue> build() {
        PersistentMap newMap = this.getMap().build();
        IHeapValues.Builder builder2 = this.getUnreferenced();
        IHeapValues newUn = builder2 != null ? builder2.build() : null;
        IHeapValues newAllSize = this.getAllSize().build();
        if (newMap == this.orig.getMap() && newUn == this.orig.getUnreferenced() && newAllSize == this.orig.getAllSize() && this.getInitializedValue() == this.orig.getInitializedValue()) {
            return (IData)this.orig;
        }
        return (IData)new ArraySpace(newMap, newUn, this.getType(), newAllSize, this.getSize(), this.getInitializedValue());
    }
}

