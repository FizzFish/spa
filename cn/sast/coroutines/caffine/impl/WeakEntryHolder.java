package cn.sast.coroutines.caffine.impl;

import com.google.common.collect.Maps;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.jetbrains.annotations.NotNull;

public final class WeakEntryHolder<K, V> {
    @NotNull
    private final ReferenceQueue<V> referenceQueue = new ReferenceQueue<>();
    @NotNull
    private final Map<Reference<? extends V>, K> backingMap;

    public WeakEntryHolder() {
        this.backingMap = Maps.newConcurrentMap();
    }

    public void put(K key, V value) {
        clean();
        WeakReference<V> reference = new WeakReference<>(value, referenceQueue);
        backingMap.put(reference, key);
    }

    public void clean() {
        Reference<?> ref;
        while ((ref = referenceQueue.poll()) != null) {
            backingMap.remove(ref);
        }
    }
}