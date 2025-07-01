package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;

public interface IHeapValuesFactory<V> {
    @NotNull
    IHeapValues<V> empty();

    @NotNull
    default IHeapValues.Builder<V> emptyBuilder() {
        return empty().builder();
    }

    @NotNull
    IHeapValues<V> single(@NotNull CompanionV<V> v);
}