package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ObjectKeyHashMapBuilder extends ImmutableElementHashMapBuilder<IValue, IValue> {
    @NotNull
    private final IHeapValues.Builder<IValue> keys;

    public ObjectKeyHashMapBuilder(@NotNull IHeapValues.Builder<IValue> keys, 
                                 @NotNull PersistentMap.Builder<IValue, IHeapValues<IValue>> fields, 
                                 @Nullable IHeapValues.Builder<IValue> unreferenced) {
        super(fields, unreferenced);
        this.keys = keys;
    }

    @NotNull
    public final IHeapValues.Builder<IValue> getKeys() {
        return keys;
    }

    @Override
    public void set(@NotNull IHeapValuesFactory<IValue> hf, 
                   @NotNull HeapValuesEnv env, 
                   @Nullable IValue key, 
                   @Nullable IHeapValues<IValue> update, 
                   boolean append) {
        throw new IllegalStateException("key must be CompanionV");
    }

    public final void set(@NotNull IHeapValuesFactory<IValue> hf, 
                         @NotNull HeapValuesEnv env, 
                         @NotNull CompanionV<IValue> key, 
                         @Nullable IHeapValues<IValue> update, 
                         boolean append) {
        super.set(hf, env, key.getValue(), update, append);
        keys.add(key);
    }

    public final void set(@NotNull IHeapValuesFactory<IValue> hf, 
                         @NotNull HeapValuesEnv env, 
                         @NotNull IHeapValues<IValue> key, 
                         @Nullable IHeapValues<IValue> update, 
                         boolean append) {
        for (CompanionV<IValue> k : key) {
            set(hf, env, k, update, append);
        }
    }

    @Override
    @NotNull
    public ImmutableElementHashMap<IValue, IValue> build() {
        IHeapValues.Builder<IValue> builder = getUnreferenced();
        return new ObjectKeyHashMap(
            keys.build(), 
            getMap().build(), 
            builder != null ? builder.build() : null
        );
    }
}