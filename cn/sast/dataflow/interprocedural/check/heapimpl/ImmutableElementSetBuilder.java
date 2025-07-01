package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ImmutableElementSetBuilder<E> extends ImmutableElementHashMapBuilder<E, IValue> {

    public ImmutableElementSetBuilder(
        @NotNull PersistentMap.Builder<E, IHeapValues<IValue>> fields,
        @Nullable IHeapValues.Builder<IValue> unreferenced
    ) {
        super(fields, unreferenced);
    }

    @Override
    @NotNull
    public ImmutableElementSet<E> build() {
        IHeapValues.Builder<IValue> builder = getUnreferenced();
        IHeapValues<IValue> unreferencedValues = builder != null ? builder.build() : null;
        return new ImmutableElementSet<>(getMap().build(), unreferencedValues);
    }
}