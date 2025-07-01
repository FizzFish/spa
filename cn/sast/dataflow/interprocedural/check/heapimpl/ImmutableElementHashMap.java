package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ImmutableElementHashMap<K, V> extends HeapKVData<K, V> {

    public ImmutableElementHashMap(@NotNull PersistentMap<K, ? extends IHeapValues<V>> fields) {
        this(fields, null);
    }

    public ImmutableElementHashMap(@NotNull PersistentMap<K, ? extends IHeapValues<V>> fields, 
                                 @Nullable IHeapValues<V> unreferenced) {
        super(fields, unreferenced);
    }

    public ImmutableElementHashMap() {
        this(PersistentMap.empty(), null);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        return other instanceof ImmutableElementHashMap;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    @NotNull
    public String getName() {
        return "ImmHashMap";
    }

    @Override
    @Nullable
    public Boolean isValidKey(@Nullable K key) {
        return true;
    }

    @Override
    @NotNull
    public IData<V> cloneAndReNewObjects(@NotNull IReNew<V> re) {
        ImmutableElementHashMapBuilder<K, V> b = builder();
        b.cloneAndReNewObjects(re);
        return b.build();
    }

    @Override
    @NotNull
    public ImmutableElementHashMapBuilder<K, V> builder() {
        IHeapValues<V> unreferenced = getUnreferenced();
        return new ImmutableElementHashMapBuilder<>(
            getMap().builder(),
            unreferenced != null ? unreferenced.builder() : null
        );
    }
}