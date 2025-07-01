package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapBuilder;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.RefType;

public final class FieldSpaceBuilder<V> extends FieldHeapBuilder<V> {
    @NotNull
    private final FieldSpace<V> orig;

    public FieldSpaceBuilder(@NotNull FieldSpace<V> orig, @NotNull RefType clz, 
            @NotNull PersistentMap.Builder<JFieldType, IHeapValues<V>> fields, 
            @Nullable IHeapValues.Builder<V> unreferenced) {
        super(clz, fields, unreferenced);
        this.orig = orig;
    }

    @NotNull
    public FieldSpace<V> getOrig() {
        return orig;
    }

    @Override
    @NotNull
    public IData<V> build() {
        PersistentMap<JFieldType, IHeapValues<V>> newMap = getMap().build();
        IHeapValues.Builder<V> builder = getUnreferenced();
        IHeapValues<V> newUn = builder != null ? builder.build() : null;

        if (newMap.equals(orig.getMap()) && (newUn == null ? orig.getUnreferenced() == null : newUn.equals(orig.getUnreferenced()))) {
            return orig;
        }
        return new FieldSpace<>(getClz(), newMap, newUn);
    }
}