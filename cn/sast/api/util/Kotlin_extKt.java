package cn.sast.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public final class Kotlin_extKt {
    @NotNull
    public static <K, V> Map<K, V> nonNullValue(@NotNull Map<K, ? extends V> map) {
        if (map == null) {
            throw new IllegalArgumentException("<this> must not be null");
        }

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            V value = entry.getValue();
            if (value != null) {
                result.put(entry.getKey(), value);
            }
        }
        return result;
    }

    @NotNull
    public static <E> Set<E> concurrentHashSetOf(E... elements) {
        if (elements == null) {
            throw new IllegalArgumentException("elements must not be null");
        }

        Map<E, Boolean> map = new LinkedHashMap<>(Math.max(elements.length, 16));
        for (E element : elements) {
            map.put(element, Boolean.TRUE);
        }
        return Collections.newSetFromMap(new ConcurrentHashMap<>(map));
    }

    @NotNull
    public static <E> Set<E> concurrentHashSetOf() {
        return Collections.newSetFromMap(new ConcurrentHashMap<>());
    }
}