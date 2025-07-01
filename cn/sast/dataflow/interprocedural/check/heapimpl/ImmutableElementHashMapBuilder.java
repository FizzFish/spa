package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ImmutableElementHashMapBuilder<K, V> extends HeapDataBuilder<K, V> {

    public ImmutableElementHashMapBuilder(
        @NotNull PersistentMap.Builder<K, IHeapValues<V>> fields,
        @Nullable IHeapValues.Builder<V> unreferenced
    ) {
        super(fields, unreferenced);
        if (fields == null) {
            throw new IllegalArgumentException("fields cannot be null");
        }
    }

    @Override
    @NotNull
    public ImmutableElementHashMap<K, V> build() {
        IHeapValues.Builder<V> builder = getUnreferenced();
        IHeapValues<V> unreferenced = builder != null ? builder.build() : null;
        return new ImmutableElementHashMap<>(getMap().build(), unreferenced);
    }
}