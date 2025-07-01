package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Set;

public final class ImmutableElementSet<E> extends ImmutableElementHashMap<E, IValue> {

    public ImmutableElementSet(@NotNull PersistentMap<E, ? extends IHeapValues<IValue>> fields, 
                              @Nullable IHeapValues<IValue> unreferenced) {
        super(fields, unreferenced);
    }

    public ImmutableElementSet() {
        this(PersistentMap.empty(), null);
    }

    @NotNull
    public String getName() {
        return "ImmHashSet";
    }

    @NotNull
    public Set<E> getElement() {
        return getMap().keySet();
    }

    public boolean isEmpty() {
        if (!getMap().isEmpty()) {
            return false;
        }
        IHeapValues<IValue> unreferenced = getUnreferenced();
        return unreferenced == null || unreferenced.isEmpty();
    }

    public boolean containsAll(@NotNull ImmutableElementSet<?> rhs) {
        return getMap().keySet().containsAll(rhs.getMap().keySet());
    }

    @NotNull
    public ImmutableElementSet<E> intersect(@NotNull AbstractHeapFactory<IValue> hf, 
                                          @NotNull HeapValuesEnv env, 
                                          @NotNull ImmutableElementSet<E> rhs) {
        if (rhs.isEmpty()) {
            return rhs;
        }
        if (isEmpty()) {
            return this;
        }

        Set<E> intersection = Set.copyOf(getMap().keySet());
        intersection.retainAll(rhs.getMap().keySet());

        ImmutableElementSetBuilder<E> builder = builder();
        for (E e : intersection) {
            IHeapValues<IValue> thisValue = get(hf, e);
            if (thisValue != null) {
                builder.set(hf, env, e, thisValue, true);
            }
            IHeapValues<IValue> rhsValue = rhs.get(hf, e);
            if (rhsValue != null) {
                builder.set(hf, env, e, rhsValue, true);
            }
        }
        return builder.build();
    }

    @NotNull
    public ImmutableElementSet<E> plus(@NotNull AbstractHeapFactory<IValue> hf, 
                                      @NotNull HeapValuesEnv env, 
                                      @NotNull ImmutableElementSet<E> rhs) {
        if (isEmpty()) {
            return rhs;
        }
        if (rhs.isEmpty()) {
            return this;
        }

        Set<E> union = Set.copyOf(getMap().keySet());
        union.addAll(rhs.getMap().keySet());

        ImmutableElementSetBuilder<E> builder = builder();
        for (E e : union) {
            IHeapValues<IValue> thisValue = get(hf, e);
            if (thisValue != null) {
                builder.set(hf, env, e, thisValue, true);
            }
            IHeapValues<IValue> rhsValue = rhs.get(hf, e);
            if (rhsValue != null) {
                builder.set(hf, env, e, rhsValue, true);
            }
        }
        return builder.build();
    }

    @NotNull
    public ImmutableElementSet<E> minus(@NotNull AbstractHeapFactory<IValue> hf, 
                                       @NotNull HeapValuesEnv env, 
                                       @NotNull ImmutableElementSet<E> rhs) {
        if (isEmpty() || rhs.isEmpty()) {
            return this;
        }

        ImmutableElementSetBuilder<E> builder = builder();
        for (E e : rhs.getElement()) {
            IHeapValues<IValue> value = get(hf, e);
            if (value != null && value.isSingle()) {
                builder.getMap().remove(e);
            }
        }
        return builder.build();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        return super.equals(other) && other instanceof ImmutableElementSet;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public ImmutableElementSetBuilder<E> builder() {
        IHeapValues<IValue> unreferenced = getUnreferenced();
        return new ImmutableElementSetBuilder<>(
            getMap().builder(),
            unreferenced != null ? unreferenced.builder() : null
        );
    }
}