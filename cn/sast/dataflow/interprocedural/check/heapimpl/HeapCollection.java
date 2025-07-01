package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HeapCollection<E> extends HeapKVData<Integer, E> {

    public HeapCollection(@NotNull PersistentMap<Integer, ? extends IHeapValues<E>> element, 
                          @Nullable IHeapValues<E> unreferenced) {
        super(element, unreferenced);
    }

    @Nullable
    public Boolean isValidKey(@Nullable Integer key) {
        return true;
    }

    @NotNull
    public String getName() {
        return "Collection";
    }

    @NotNull
    public IHeapKVData.Builder<Integer, E> builder() {
        IHeapValues<E> unreferenced = getUnreferenced();
        IHeapValues.Builder<E> unreferencedBuilder = unreferenced != null ? unreferenced.builder() : null;
        return new HeapCollectionBuilder<>(getMap().builder(), unreferencedBuilder);
    }

    @NotNull
    public IData<E> cloneAndReNewObjects(@NotNull IReNew<E> re) {
        IHeapKVData.Builder<Integer, E> builder = builder();
        builder.cloneAndReNewObjects(re);
        return builder.build();
    }
}