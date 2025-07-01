package cn.sast.api.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ComparatorUtilsKt {
    public static <T> int compareTo(@NotNull Comparator<T> comparator, 
            @NotNull Collection<? extends T> a, @NotNull Collection<? extends T> b) {
        if (comparator == null) throw new NullPointerException("comparator is null");
        if (a == null) throw new NullPointerException("a is null");
        if (b == null) throw new NullPointerException("b is null");

        Iterator<? extends T> bI = b.iterator();
        for (T e : a) {
            if (!bI.hasNext()) {
                return 1;
            }
            int c = comparator.compare(e, bI.next());
            if (c != 0) {
                return c;
            }
        }
        return bI.hasNext() ? -1 : 0;
    }

    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> 
            int compareToMap(@NotNull Comparator<Pair<K, V>> comparator, 
            @NotNull Map<K, ? extends V> a, @NotNull Map<K, ? extends V> b) {
        if (comparator == null) throw new NullPointerException("comparator is null");
        if (a == null) throw new NullPointerException("a is null");
        if (b == null) throw new NullPointerException("b is null");

        int sizeCompare = Integer.compare(a.size(), b.size());
        if (sizeCompare != 0) {
            return sizeCompare;
        }

        List<Pair<K, V>> aSorted = a.entrySet().stream()
                .map(e -> new Pair<>(e.getKey(), e.getValue()))
                .sorted(comparator)
                .toList();
        List<Pair<K, V>> bSorted = b.entrySet().stream()
                .map(e -> new Pair<>(e.getKey(), e.getValue()))
                .sorted(comparator)
                .toList();

        return compareTo(comparator, aSorted, bSorted);
    }

    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> 
            int compareToMap(@NotNull Map<K, ? extends V> map, @NotNull Map<K, ? extends V> other) {
        if (map == null) throw new NullPointerException("map is null");
        if (other == null) throw new NullPointerException("other is null");

        Comparator<Pair<K, V>> comparator = Comparator
                .<Pair<K, V>, K>comparing(Pair::getFirst)
                .thenComparing(Pair::getSecond);
        return compareToMap(comparator, map, other);
    }

    public static <E extends Comparable<? super E>> 
            int compareToCollection(@NotNull Collection<? extends E> collection, 
            @NotNull Collection<? extends E> other) {
        if (collection == null) throw new NullPointerException("collection is null");
        if (other == null) throw new NullPointerException("other is null");

        return compareTo(Comparator.naturalOrder(), collection, other);
    }

    public static <T extends Comparable<? super T>> 
            int compareToNullable(@Nullable T obj, @Nullable T other) {
        if (obj == null && other == null) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (other == null) {
            return -1;
        }
        return obj.compareTo(other);
    }

    public static final class Pair<K, V> {
        private final K first;
        private final V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }
}