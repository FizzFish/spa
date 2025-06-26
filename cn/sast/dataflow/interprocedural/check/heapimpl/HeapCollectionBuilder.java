/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.check.heapimpl.HeapCollection
 *  cn.sast.dataflow.interprocedural.check.heapimpl.HeapCollectionBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.check.heapimpl.HeapCollection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016\u00a8\u0006\r"}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/HeapCollectionBuilder;", "E", "Lcn/sast/dataflow/interprocedural/analysis/HeapDataBuilder;", "", "fields", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "<init>", "(Lkotlinx/collections/immutable/PersistentMap$Builder;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "build", "Lcn/sast/dataflow/interprocedural/check/heapimpl/HeapCollection;", "corax-data-flow"})
public final class HeapCollectionBuilder<E>
extends HeapDataBuilder<Integer, E> {
    public HeapCollectionBuilder(@NotNull PersistentMap.Builder<Integer, IHeapValues<E>> fields, @Nullable IHeapValues.Builder<E> unreferenced) {
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        super(fields, unreferenced);
    }

    @NotNull
    public HeapCollection<E> build() {
        IHeapValues.Builder builder2 = this.getUnreferenced();
        return new HeapCollection(this.getMap().build(), (IHeapValues)(builder2 != null ? builder2.build() : null));
    }
}

