/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.HeapKVData
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.check.heapimpl.HeapCollection
 *  cn.sast.dataflow.interprocedural.check.heapimpl.HeapCollectionBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.check.heapimpl.HeapCollectionBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016\u00a8\u0006\u0016"}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/HeapCollection;", "E", "Lcn/sast/dataflow/interprocedural/analysis/HeapKVData;", "", "element", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "<init>", "(Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "isValidKey", "", "key", "(Ljava/lang/Integer;)Ljava/lang/Boolean;", "getName", "", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IHeapKVData$Builder;", "cloneAndReNewObjects", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "corax-data-flow"})
public final class HeapCollection<E>
extends HeapKVData<Integer, E> {
    public HeapCollection(@NotNull PersistentMap<Integer, ? extends IHeapValues<E>> element, @Nullable IHeapValues<E> unreferenced) {
        Intrinsics.checkNotNullParameter(element, (String)"element");
        super(element, unreferenced);
    }

    @Nullable
    public Boolean isValidKey(@Nullable Integer key2) {
        return true;
    }

    @NotNull
    public String getName() {
        return "Collection";
    }

    @NotNull
    public IHeapKVData.Builder<Integer, E> builder() {
        IHeapValues iHeapValues = this.getUnreferenced();
        return (IHeapKVData.Builder)new HeapCollectionBuilder(this.getMap().builder(), (IHeapValues.Builder)(iHeapValues != null ? iHeapValues.builder() : null));
    }

    @NotNull
    public IData<E> cloneAndReNewObjects(@NotNull IReNew<E> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        IHeapKVData.Builder b = this.builder();
        b.cloneAndReNewObjects(re);
        return b.build();
    }
}

