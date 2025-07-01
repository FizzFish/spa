package cn.sast.dataflow.interprocedural.analysis;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IHeapValues<V> extends IDiffAble<V>, Iterable<CompanionV<V>> {
    void reference(@NotNull Collection<V> res);

    @NotNull
    IHeapValues<V> plus(@NotNull IHeapValues<V> rhs);

    @NotNull
    IHeapValues<V> plus(@NotNull CompanionV<V> rhs);

    int getSize();

    @NotNull
    ImmutableSet<V> getValues();

    @NotNull
    ImmutableSet<CompanionV<V>> getValuesCompanion();

    default boolean isNotEmpty() {
        return !isEmpty();
    }

    boolean isEmpty();

    @NotNull
    Builder<V> builder();

    void map(@NotNull Builder<V> c, @NotNull Function1<? super CompanionV<V>, ? extends CompanionV<V>> transform);

    void flatMap(@NotNull Builder<V> c, @NotNull Function1<? super CompanionV<V>, ? extends Collection<? extends CompanionV<V>>> transform);

    boolean isSingle();

    @NotNull
    CompanionV<V> getSingle();

    @Nullable
    Set<Integer> getAllIntValue(boolean must);

    @Nullable
    default Integer getMaxInt(boolean must) {
        Set<Integer> values = getAllIntValue(must);
        return values == null || values.isEmpty() ? null : values.stream().max(Integer::compare).orElse(null);
    }

    @NotNull
    @Override
    Iterator<CompanionV<V>> iterator();

    @NotNull
    IHeapValues<V> cloneAndReNewObjects(@NotNull IReNew<V> re);

    interface Builder<V> {
    }
}