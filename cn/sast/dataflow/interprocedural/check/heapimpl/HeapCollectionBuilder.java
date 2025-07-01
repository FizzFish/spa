package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HeapCollectionBuilder<E> extends HeapDataBuilder<Integer, E> {

    public HeapCollectionBuilder(@NotNull PersistentMap.Builder<Integer, IHeapValues<E>> fields, 
                                @Nullable IHeapValues.Builder<E> unreferenced) {
        super(fields, unreferenced);
    }

    @Override
    @NotNull
    public HeapCollection<E> build() {
        IHeapValues.Builder<E> builder = getUnreferenced();
        IHeapValues<E> unreferenced = builder != null ? builder.build() : null;
        return new HeapCollection<>(getMap().build(), unreferenced);
    }
}