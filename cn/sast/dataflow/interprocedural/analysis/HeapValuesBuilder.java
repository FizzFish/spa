/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapValuesBuilder
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValues
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesBuilder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapValues;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapValuesBuilder;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\b\u0002\u0010\u0006\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/HeapValuesBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapValuesBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "orig", "Lcn/sast/dataflow/interprocedural/analysis/HeapValues;", "map", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValues;Lkotlinx/collections/immutable/PersistentMap$Builder;)V", "getOrig", "()Lcn/sast/dataflow/interprocedural/analysis/HeapValues;", "build", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "corax-data-flow"})
public final class HeapValuesBuilder
extends AbstractHeapValuesBuilder<IValue> {
    @NotNull
    private final HeapValues orig;

    public HeapValuesBuilder(@NotNull HeapValues orig, @NotNull PersistentMap.Builder<IValue, CompanionV<IValue>> map) {
        Intrinsics.checkNotNullParameter((Object)orig, (String)"orig");
        Intrinsics.checkNotNullParameter(map, (String)"map");
        super((AbstractHeapValues)orig, map, null);
        this.orig = orig;
    }

    public /* synthetic */ HeapValuesBuilder(HeapValues heapValues, PersistentMap.Builder builder2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            builder2 = heapValues.getMap().builder();
        }
        this(heapValues, builder2);
    }

    @NotNull
    public HeapValues getOrig() {
        return this.orig;
    }

    @NotNull
    public IHeapValues<IValue> build() {
        PersistentMap newMap = this.getMap().build();
        if (newMap == this.getOrig().getMap()) {
            return (IHeapValues)this.getOrig();
        }
        return (IHeapValues)new HeapValues(this.getMap().build());
    }
}

