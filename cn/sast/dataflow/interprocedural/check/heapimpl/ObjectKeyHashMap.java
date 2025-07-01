package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapValues;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesBuilder;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlinx.collections.immutable.ImmutableCollection;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ObjectKeyHashMap extends ImmutableElementHashMap<IValue, IValue> {
    @NotNull
    private final IHeapValues<IValue> keys;

    public ObjectKeyHashMap(@NotNull IHeapValues<IValue> keys, 
                          @NotNull PersistentMap<IValue, ? extends IHeapValues<IValue>> fields,
                          @Nullable IHeapValues<IValue> unreferenced) {
        super(fields, unreferenced);
        this.keys = keys;
    }

    @NotNull
    public IHeapValues<IValue> getKeys() {
        return keys;
    }

    @NotNull
    public IHeapValues<IValue> getValues() {
        HeapValuesBuilder builder = new HeapValues(null, 1, null).builder();
        for (IHeapValues v : (ImmutableCollection<? extends IHeapValues>) getMap().values()) {
            builder.add(v);
        }
        return builder.build();
    }

    @Override
    public void diff(@NotNull IDiff<IValue> cmp, @NotNull IDiffAble<?> that) {
        if (that instanceof ObjectKeyHashMap) {
            keys.diff(cmp, ((ObjectKeyHashMap) that).keys);
            getValues().diff(cmp, ((ObjectKeyHashMap) that).getValues());
        }
        super.diff(cmp, that);
    }

    @Override
    public int computeHash() {
        int result = 1;
        result = 31 * result + super.computeHash();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        if (!(other instanceof ObjectKeyHashMap)) {
            return false;
        }
        return keys.equals(((ObjectKeyHashMap) other).keys);
    }

    @NotNull
    @Override
    public ImmutableElementHashMapBuilder<IValue, IValue> builder() {
        IHeapValues unreferenced = getUnreferenced();
        return new ObjectKeyHashMapBuilder(
            keys.builder(),
            getMap().builder(),
            unreferenced != null ? unreferenced.builder() : null
        );
    }
}