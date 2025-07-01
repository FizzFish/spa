package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.RefType;

public abstract class FieldHeapKV<V> extends HeapKVData<JFieldType, V> {
    @NotNull
    private final RefType clz;

    public FieldHeapKV(@NotNull RefType clz, @NotNull PersistentMap<JFieldType, ? extends IHeapValues<V>> fields, 
                       @Nullable IHeapValues<V> unreferenced) {
        super(fields, unreferenced);
        this.clz = clz;
    }

    @NotNull
    public final RefType getClz() {
        return clz;
    }

    @Nullable
    public Boolean isValidKey(@Nullable JFieldType key) {
        return true;
    }

    @Nullable
    public IHeapValues<V> get(@NotNull IHeapValuesFactory<V> hf, @Nullable JFieldType key) {
        if (key != null) {
            return getMap().get(key);
        }
        return getFromNullKey(hf);
    }

    @NotNull
    public String ppKey(@NotNull JFieldType key) {
        return key.getName();
    }

    @Override
    public int computeHash() {
        int result = super.computeHash();
        result = 31 * result + clz.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        if (!(other instanceof FieldHeapKV)) {
            return false;
        }
        FieldHeapKV<?> that = (FieldHeapKV<?>) other;
        return clz.equals(that.clz);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}