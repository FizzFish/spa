package cn.sast.dataflow.interprocedural.analysis;

import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;

public final class HeapValuesBuilder extends AbstractHeapValuesBuilder<IValue> {
    @NotNull
    private final HeapValues orig;

    public HeapValuesBuilder(@NotNull HeapValues orig, @NotNull PersistentMap.Builder<IValue, CompanionV<IValue>> map) {
        super(orig, map, null);
        this.orig = orig;
    }

    public HeapValuesBuilder(@NotNull HeapValues orig) {
        this(orig, orig.getMap().builder());
    }

    @NotNull
    public HeapValues getOrig() {
        return this.orig;
    }

    @NotNull
    public IHeapValues<IValue> build() {
        PersistentMap<IValue, CompanionV<IValue>> newMap = getMap().build();
        if (newMap.equals(orig.getMap())) {
            return orig;
        }
        return new HeapValues(newMap);
    }
}