package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapKV;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.RefType;

public final class FieldSpace<V> extends FieldHeapKV<V> {
    public FieldSpace(@NotNull RefType clz, 
                     @NotNull PersistentMap<JFieldType, ? extends IHeapValues<V>> fields,
                     @Nullable IHeapValues<V> unreferenced) {
        super(clz, fields, unreferenced);
    }

    @Override
    @NotNull
    public IHeapKVData.Builder<JFieldType, V> builder() {
        IHeapValues<V> unreferenced = getUnreferenced();
        return new FieldSpaceBuilder<>(
            this, 
            getClz(), 
            getMap().builder(),
            unreferenced != null ? unreferenced.builder() : null
        );
    }

    @Override
    @NotNull
    public String getName() {
        return "field(" + getClz() + ")";
    }

    @Override
    @NotNull
    public IData<V> cloneAndReNewObjects(@NotNull IReNew<V> re) {
        IHeapKVData.Builder<JFieldType, V> builder = builder();
        builder.cloneAndReNewObjects(re);
        return builder.build();
    }
}