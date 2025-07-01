package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.RefType;

public abstract class FieldHeapBuilder<V> extends HeapDataBuilder<JFieldType, V> {
    @NotNull
    private final RefType clz;

    public FieldHeapBuilder(@NotNull RefType clz, 
                          @NotNull PersistentMap.Builder<JFieldType, IHeapValues<V>> fields,
                          @Nullable IHeapValues.Builder<V> unreferenced) {
        super(fields, unreferenced);
        if (clz == null) throw new IllegalArgumentException("clz cannot be null");
        if (fields == null) throw new IllegalArgumentException("fields cannot be null");
        this.clz = clz;
    }

    @NotNull
    public final RefType getClz() {
        return clz;
    }
}