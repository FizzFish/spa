package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IHeapKVData<K, V> extends IData<V> {
    @Nullable
    IHeapValues<V> get(@NotNull IHeapValuesFactory<V> hf, @Nullable K key);

    @NotNull
    Builder<K, V> builder();

    interface Builder<K, V> {
    }
}