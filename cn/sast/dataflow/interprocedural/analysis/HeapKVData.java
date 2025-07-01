package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class HeapKVData<K, V> implements IHeapKVData<K, V> {
    @NotNull
    private final Map<K, IHeapValues<V>> map;
    @Nullable
    private final IHeapValues<V> unreferenced;
    @Nullable
    private Integer hashCode;

    public HeapKVData(@NotNull Map<K, ? extends IHeapValues<V>> map, @Nullable IHeapValues<V> unreferenced) {
        Objects.requireNonNull(map, "map");
        this.map = Map.copyOf(map);
        this.unreferenced = unreferenced;
        if (unreferenced != null) {
            unreferenced.isNotEmpty();
        }
    }

    @NotNull
    public final Map<K, IHeapValues<V>> getMap() {
        return map;
    }

    @Nullable
    public final IHeapValues<V> getUnreferenced() {
        return unreferenced;
    }

    public void reference(@NotNull Collection<V> res) {
        Objects.requireNonNull(res, "res");
        for (IHeapValues<V> value : map.values()) {
            value.reference(res);
        }
        if (unreferenced != null) {
            unreferenced.reference(res);
        }
    }

    public void diff(@NotNull IDiff<V> cmp, @NotNull IDiffAble<?> that) {
        Objects.requireNonNull(cmp, "cmp");
        Objects.requireNonNull(that, "that");
        if (!(that instanceof HeapKVData)) {
            return;
        }
        HeapKVData<?, ?> other = (HeapKVData<?, ?>) that;
        for (K k : map.keySet()) {
            if (other.map.containsKey(k)) {
                IHeapValues<V> v1 = map.get(k);
                IHeapValues<?> v2 = other.map.get(k);
                if (v1 != null && v2 != null) {
                    v1.diff(cmp, v2);
                }
            }
        }
        if (unreferenced != null && other.unreferenced != null) {
            unreferenced.diff(cmp, other.unreferenced);
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeapKVData)) {
            return false;
        }
        HeapKVData<?, ?> that = (HeapKVData<?, ?>) other;
        return hashCode() == that.hashCode() 
            && map.equals(that.map) 
            && Objects.equals(unreferenced, that.unreferenced);
    }

    public int computeHash() {
        int result = map.hashCode();
        result = 31 * result + (unreferenced != null ? unreferenced.hashCode() : 0);
        return result;
    }

    public int hashCode() {
        if (hashCode == null) {
            hashCode = computeHash();
        }
        return hashCode;
    }

    @Nullable
    public abstract Boolean isValidKey(@Nullable K key);

    @NotNull
    public IHeapValues<V> getFromNullKey(@NotNull IHeapValuesFactory<V> hf) {
        Objects.requireNonNull(hf, "hf");
        IHeapValues.Builder<V> b = hf.emptyBuilder();
        for (IHeapValues<V> value : map.values()) {
            b.add(value);
        }
        if (unreferenced != null) {
            b.add(unreferenced);
        }
        return b.build();
    }

    @Nullable
    public IHeapValues<V> getValue(@NotNull IHeapValuesFactory<V> hf, @NotNull K key) {
        Objects.requireNonNull(hf, "hf");
        Objects.requireNonNull(key, "key");
        return map.get(key);
    }

    @Nullable
    public IHeapValues<V> get(@NotNull IHeapValuesFactory<V> hf, @Nullable K key) {
        Objects.requireNonNull(hf, "hf");
        if (key == null) {
            return getFromNullKey(hf);
        }
        IHeapValues<V> exist = getValue(hf, key);
        if (exist != null) {
            return unreferenced != null ? exist.plus(unreferenced) : exist;
        }
        return unreferenced;
    }

    @NotNull
    public String ppKey(@NotNull K key) {
        Objects.requireNonNull(key, "key");
        return key.toString();
    }

    @NotNull
    public String ppValue(@NotNull IHeapValues<V> value) {
        Objects.requireNonNull(value, "value");
        return value.toString();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder(getName()).append(" ");
        for (Map.Entry<K, IHeapValues<V>> entry : map.entrySet()) {
            K k = entry.getKey();
            IHeapValues<V> v = entry.getValue();
            IHeapValues<V> value = unreferenced == null ? v : v.plus(unreferenced);
            sb.append(ppKey(k)).append("->").append(ppValue(value)).append(" ; ");
        }
        if (map.isEmpty()) {
            sb.append("unreferenced: ").append(unreferenced);
        }
        return sb.toString();
    }

    @NotNull
    public abstract String getName();
}
