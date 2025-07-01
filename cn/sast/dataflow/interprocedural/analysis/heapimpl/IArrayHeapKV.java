package cn.sast.dataflow.interprocedural.analysis.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;

public interface IArrayHeapKV<K, V> extends IHeapKVData<K, V> {
    @NotNull
    ArrayType getType();

    @NotNull
    IHeapValues<V> getArrayLength();

    @NotNull
    IHeapValues<V> getElement(@NotNull AbstractHeapFactory<V> hf);

    @Nullable
    V[] getArray(@NotNull IHeapValuesFactory<V> hf);

    @Nullable
    byte[] getByteArray(@NotNull IHeapValuesFactory<V> hf);
}