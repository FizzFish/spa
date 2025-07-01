package cn.sast.dataflow.interprocedural.analysis.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;

public abstract class ArrayHeapBuilder<V> extends HeapDataBuilder<Integer, V> {
    @NotNull
    private final ArrayType type;
    @NotNull
    private final IHeapValues.Builder<V> allSize;
    @Nullable
    private final Integer size;
    @Nullable
    private CompanionV<V> initializedValue;

    public ArrayHeapBuilder(
        @NotNull PersistentMap.Builder<Integer, IHeapValues<V>> element,
        @Nullable IHeapValues.Builder<V> unreferenced,
        @NotNull ArrayType type,
        @NotNull IHeapValues.Builder<V> allSize,
        @Nullable Integer size,
        @Nullable CompanionV<V> initializedValue
    ) {
        super(element, unreferenced);
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        if (allSize == null) throw new IllegalArgumentException("allSize cannot be null");
        
        this.type = type;
        this.allSize = allSize;
        this.size = size;
        this.initializedValue = initializedValue;

        if (!this.allSize.isNotEmpty()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @NotNull
    public final ArrayType getType() {
        return type;
    }

    @NotNull
    public final IHeapValues.Builder<V> getAllSize() {
        return allSize;
    }

    @Nullable
    public final Integer getSize() {
        return size;
    }

    @Nullable
    public final CompanionV<V> getInitializedValue() {
        return initializedValue;
    }

    public final void setInitializedValue(@Nullable CompanionV<V> initializedValue) {
        this.initializedValue = initializedValue;
    }

    @Nullable
    public IHeapValues<V> getValue(@NotNull IHeapValuesFactory<V> hf, int key) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        
        IHeapValues<V> existing = super.getValue(hf, key);
        if (existing != null) {
            return existing;
        }

        if (size != null && size == getMap().size()) {
            return null;
        }

        return initializedValue != null ? hf.single(initializedValue) : null;
    }

    public void set(
        @NotNull IHeapValuesFactory<V> hf,
        @NotNull HeapValuesEnv env,
        @Nullable Integer key,
        @Nullable IHeapValues<V> update,
        boolean append
    ) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (env == null) throw new IllegalArgumentException("env cannot be null");
        
        if (!ArrayHeapKVKt.isValidKey(key, size)) {
            return;
        }
        super.set(hf, env, key, update, append);
    }

    public void cloneAndReNewObjects(@NotNull IReNew<V> re) {
        if (re == null) throw new IllegalArgumentException("re cannot be null");
        
        super.cloneAndReNewObjects(re.context(ReferenceContext.ArrayElement.INSTANCE));
        allSize.cloneAndReNewObjects(re.context(ReferenceContext.ArraySize.INSTANCE));

        if (initializedValue != null) {
            Object originalValue = initializedValue.getValue();
            Object newValue = re.checkNeedReplace(originalValue);
            if (newValue == null) {
                newValue = originalValue;
            }

            CompanionV<V> newCompV = re.context(ReferenceContext.ArrayInitialized.INSTANCE)
                .checkNeedReplace(initializedValue);
            if (newCompV == null) {
                newCompV = initializedValue;
            }

            if (!originalValue.equals(newValue) || newCompV != initializedValue) {
                if (!newCompV.getValue().equals(newValue)) {
                    newCompV = newCompV.copy(newValue);
                }
                initializedValue = newCompV;
            }
        }
    }

    public final void clearAllIndex() {
        // No-op implementation
    }
}