package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public final class PointsToGraphAbstractKt {
    public static <V> void foreach(@NotNull IHeapValues<V> heapValues, @NotNull Function1<CompanionV<V>, Void> transform) {
        if (heapValues == null) throw new IllegalArgumentException("<this> cannot be null");
        if (transform == null) throw new IllegalArgumentException("transform cannot be null");
        
        for (CompanionV<V> e : heapValues) {
            transform.apply(e);
        }
    }

    @NotNull
    public static <K, V> IHeapValues.Builder<V> mapTo(
            @NotNull Map<? extends K, ? extends IHeapValues<V>> map,
            @NotNull IHeapValues.Builder<V> destination,
            @NotNull Function1<Map.Entry<? extends K, ? extends IHeapValues<V>>, ? extends IHeapValues<V>> transform) {
        if (map == null) throw new IllegalArgumentException("<this> cannot be null");
        if (destination == null) throw new IllegalArgumentException("destination cannot be null");
        if (transform == null) throw new IllegalArgumentException("transform cannot be null");

        for (Map.Entry<? extends K, ? extends IHeapValues<V>> entry : map.entrySet()) {
            destination.add(transform.apply(entry));
        }
        return destination;
    }

    @FunctionalInterface
    public interface Function1<T, R> {
        R apply(T t);
    }
}