package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.*;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public abstract class HeapDataBuilder<K, V> implements IHeapKVData.Builder<K, V> {
    private static final Logger logger = LoggerFactory.getLogger(HeapDataBuilder.class);

    @NotNull
    private final PersistentMap.Builder<K, IHeapValues<V>> map;
    @Nullable
    private IHeapValues.Builder<V> unreferenced;

    public HeapDataBuilder(@NotNull PersistentMap.Builder<K, IHeapValues<V>> map, 
                          @Nullable IHeapValues.Builder<V> unreferenced) {
        if (map == null) throw new IllegalArgumentException("map cannot be null");
        this.map = map;
        this.unreferenced = unreferenced;
    }

    @NotNull
    public final PersistentMap.Builder<K, IHeapValues<V>> getMap() {
        return map;
    }

    @Nullable
    public final IHeapValues.Builder<V> getUnreferenced() {
        return unreferenced;
    }

    public final void setUnreferenced(@Nullable IHeapValues.Builder<V> builder) {
        this.unreferenced = builder;
    }

    @Override
    @Nullable
    public IHeapValues<V> getValue(@NotNull IHeapValuesFactory<V> hf, @NotNull K key) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        return map.get(key);
    }

    @Override
    public void set(@NotNull IHeapValuesFactory<V> hf, 
                   @NotNull HeapValuesEnv env, 
                   @Nullable K key, 
                   @Nullable IHeapValues<V> update, 
                   boolean append) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (env == null) throw new IllegalArgumentException("env cannot be null");

        if (update == null || update.isEmpty()) {
            logger.debug("ignore update is {}", update);
            return;
        }

        if (key == null) {
            if (unreferenced != null) {
                unreferenced.add(update);
            } else {
                unreferenced = update.builder();
            }
        } else {
            IHeapValues<V> exist = getValue(hf, key);
            IHeapValues<V> newValue = append && exist != null ? update.plus(exist) : update;
            map.put(key, newValue);
        }
    }

    @Override
    public void union(@NotNull AbstractHeapFactory<V> hf, @NotNull IData<V> that) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (that == null) throw new IllegalArgumentException("that cannot be null");
        if (!(that instanceof HeapKVData)) {
            throw new IllegalArgumentException("Failed requirement.");
        }

        HeapKVData<K, V> other = (HeapKVData<K, V>) that;
        handleUnreferencedUnion(other);
        handleMapUnion(other);
    }

    private void handleUnreferencedUnion(HeapKVData<K, V> other) {
        if (unreferenced == null) {
            if (other.getUnreferenced() != null) {
                unreferenced = other.getUnreferenced().builder();
            }
        } else if (other.getUnreferenced() != null) {
            unreferenced.add(other.getUnreferenced());
        }
    }

    private void handleMapUnion(HeapKVData<K, V> other) {
        if (!map.equals(other.getMap())) {
            for (Map.Entry<K, IHeapValues<V>> entry : other.getMap().entrySet()) {
                K k = entry.getKey();
                IHeapValues<V> v = entry.getValue();
                IHeapValues<V> exist = map.get(k);
                map.put(k, exist != null ? v.plus(exist) : v);
            }
        }
    }

    public final void updateFrom(@NotNull AbstractHeapFactory<V> hf, @NotNull IData<V> that) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (that == null) throw new IllegalArgumentException("that cannot be null");
        if (!(that instanceof HeapKVData)) {
            throw new IllegalArgumentException("Failed requirement.");
        }

        HeapKVData<K, V> other = (HeapKVData<K, V>) that;
        handleUnreferencedUnion(other);
        handleMapUpdate(other);
    }

    private void handleMapUpdate(HeapKVData<K, V> other) {
        if (!map.equals(other.getMap())) {
            for (Map.Entry<K, IHeapValues<V>> entry : other.getMap().entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    @NotNull
    public String toString() {
        return build().toString();
    }

    @Override
    public void cloneAndReNewObjects(@NotNull IReNew<V> re) {
        if (re == null) throw new IllegalArgumentException("re cannot be null");

        PersistentMap<K, IHeapValues<V>> oldMap = map.build();
        for (Map.Entry<K, IHeapValues<V>> entry : oldMap.entrySet()) {
            K k = entry.getKey();
            IHeapValues<V> v = entry.getValue();
            map.put(k, v.cloneAndReNewObjects(re.context(new ReferenceContext.KVPosition(k))));
        }

        if (unreferenced != null) {
            unreferenced.cloneAndReNewObjects(re.context(ReferenceContext.KVUnreferenced.INSTANCE));
        }
    }
}
