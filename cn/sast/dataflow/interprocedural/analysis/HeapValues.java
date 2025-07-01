package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapValues;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesBuilder;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;

public final class HeapValues extends AbstractHeapValues<IValue> {
    public static final Companion Companion = new Companion();

    public static final class Companion {
        private Companion() {}
    }

    public HeapValues(@NotNull PersistentMap<IValue, ? extends CompanionV<IValue>> map) {
        super(map, null);
    }

    public HeapValues() {
        this(kotlinx.collections.immutable.ExtensionsKt.persistentHashMapOf());
    }

    @NotNull
    public HeapValuesBuilder builder() {
        return new HeapValuesBuilder(this);
    }
}
