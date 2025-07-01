package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.util.Printer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.Constant;
import soot.jimple.IntConstant;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.collections.immutable.PersistentMap;

public abstract class AbstractHeapValues<V> implements IHeapValues<V> {
    @NotNull
    private final PersistentMap<V, CompanionV<V>> map;
    @Nullable
    private Integer hashCode;

    protected AbstractHeapValues(@NotNull PersistentMap<V, CompanionV<V>> map) {
        this.map = map;
    }

    @NotNull
    public final PersistentMap<V, CompanionV<V>> getMap() {
        return map;
    }

    @Nullable
    public final Integer getHashCode() {
        return hashCode;
    }

    public final void setHashCode(@Nullable Integer hashCode) {
        this.hashCode = hashCode;
    }

    public final int computeHash() {
        int result = 1;
        result = 31 * result + map.hashCode();
        return result;
    }

    @Override
    public int hashCode() {
        if (hashCode == null) {
            hashCode = computeHash();
        }
        return hashCode;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbstractHeapValues)) {
            return false;
        }
        AbstractHeapValues<?> that = (AbstractHeapValues<?>) other;
        return hashCode() == that.hashCode() && map.equals(that.map);
    }

    @Override
    public void diff(@NotNull IDiff<V> cmp, @NotNull IDiffAble<?> that) {
        if (!(that instanceof AbstractHeapValues)) {
            return;
        }
        AbstractHeapValues<?> other = (AbstractHeapValues<?>) that;
        for (V k : intersection(map.keySet(), other.map.keySet())) {
            CompanionV<V> v1 = map.get(k);
            CompanionV<V> v2 = other.map.get(k);
            if (v1 != null && v2 != null) {
                cmp.diff(v1, v2);
            }
        }
    }

    private static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new LinkedHashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    @NotNull
    @Override
    public CompanionV<V> getSingle() {
        if (!isSingle()) {
            throw new IllegalArgumentException("error size of " + this);
        }
        return iterator().next();
    }

    @Override
    public int getSize() {
        return map.size();
    }

    @NotNull
    @Override
    public ImmutableSet<V> getValues() {
        return map.keySet();
    }

    @NotNull
    @Override
    public ImmutableSet<CompanionV<V>> getValuesCompanion() {
        Set<CompanionV<V>> result = new LinkedHashSet<>();
        for (CompanionV<V> e : this) {
            result.add(e);
        }
        return ImmutableSet.copyOf(result);
    }

    @Override
    public void reference(@NotNull Collection<V> res) {
        res.addAll(map.keySet());
    }

    @Override
    public boolean isNotEmpty() {
        return !map.isEmpty();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean isSingle() {
        return map.size() == 1;
    }

    @NotNull
    @Override
    public IHeapValues<V> plus(@NotNull IHeapValues<V> rhs) {
        if (rhs.isEmpty()) {
            return this;
        }
        if (isEmpty()) {
            return rhs;
        }
        IHeapValues.Builder<V> builder = builder();
        builder.add(rhs);
        return builder.build();
    }

    @NotNull
    @Override
    public IHeapValues<V> plus(@NotNull CompanionV<V> rhs) {
        IHeapValues.Builder<V> builder = builder();
        builder.add(rhs);
        return builder.build();
    }

    @Override
    public void map(@NotNull IHeapValues.Builder<V> c, @NotNull java.util.function.Function<? super CompanionV<V>, ? extends CompanionV<V>> transform) {
        for (CompanionV<V> e : this) {
            c.add(transform.apply(e));
        }
    }

    @Override
    public void flatMap(@NotNull IHeapValues.Builder<V> c, @NotNull java.util.function.Function<? super CompanionV<V>, ? extends Collection<? extends CompanionV<V>>> transform) {
        for (CompanionV<V> e : this) {
            for (CompanionV<V> t : transform.apply(e)) {
                c.add(t);
            }
        }
    }

    @Nullable
    @Override
    public Set<Integer> getAllIntValue(boolean must) {
        Set<Integer> result = new LinkedHashSet<>();
        for (V key : map.keySet()) {
            Integer value = null;
            if (key instanceof ConstVal) {
                Constant constant = ((ConstVal) key).getV();
                if (constant instanceof IntConstant) {
                    value = ((IntConstant) constant).value;
                }
            }
            if (must && value == null) {
                return null;
            }
            if (value != null) {
                result.add(value);
            }
        }
        return result;
    }

    @NotNull
    @Override
    public Iterator<CompanionV<V>> iterator() {
        return new Iterator<CompanionV<V>>() {
            private final Iterator<Map.Entry<V, CompanionV<V>>> mapIterator = map.entrySet().iterator();

            @Override
            public boolean hasNext() {
                return mapIterator.hasNext();
            }

            @Override
            public CompanionV<V> next() {
                return mapIterator.next().getValue();
            }
        };
    }

    @NotNull
    @Override
    public IHeapValues<V> cloneAndReNewObjects(@NotNull IReNew<V> re) {
        IHeapValues.Builder<V> builder = builder();
        builder.cloneAndReNewObjects(re);
        return builder.build();
    }

    @NotNull
    @Override
    public String toString() {
        return Printer.nodes2String(map.values());
    }
}
