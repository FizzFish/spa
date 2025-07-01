package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;
import soot.Value;

import java.util.Map;
import java.util.Set;

public abstract class PointsToGraphAbstract<V> implements IFact<V> {
    @NotNull
    private final AbstractHeapFactory<V> hf;
    @NotNull
    private final IVGlobal vg;
    @NotNull
    private final CallStackContext callStack;
    @NotNull
    private final PersistentMap<Object, IHeapValues<V>> slots;
    @NotNull
    private final PersistentMap<V, PersistentMap<Object, IData<V>>> heap;
    @NotNull
    private final PersistentSet<SootMethod> calledMethods;
    @Nullable
    private Integer hashCode;

    public PointsToGraphAbstract(@NotNull AbstractHeapFactory<V> hf, 
                               @NotNull IVGlobal vg, 
                               @NotNull CallStackContext callStack, 
                               @NotNull PersistentMap<Object, ? extends IHeapValues<V>> slots, 
                               @NotNull PersistentMap<V, ? extends PersistentMap<Object, ? extends IData<V>>> heap, 
                               @NotNull PersistentSet<? extends SootMethod> calledMethods) {
        this.hf = hf;
        this.vg = vg;
        this.callStack = callStack;
        this.slots = slots;
        this.heap = heap;
        this.calledMethods = calledMethods;
    }

    @NotNull
    public AbstractHeapFactory<V> getHf() {
        return hf;
    }

    @NotNull
    public final IVGlobal getVg() {
        return vg;
    }

    @NotNull
    public CallStackContext getCallStack() {
        return callStack;
    }

    @NotNull
    public final PersistentMap<Object, IHeapValues<V>> getSlots() {
        return slots;
    }

    @NotNull
    public final PersistentMap<V, PersistentMap<Object, IData<V>>> getHeap() {
        return heap;
    }

    @NotNull
    public final PersistentSet<SootMethod> getCalledMethods() {
        return calledMethods;
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
        result = 31 * result + slots.hashCode();
        result = 31 * result + heap.hashCode();
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
        if (!(other instanceof PointsToGraphAbstract)) {
            return false;
        }
        PointsToGraphAbstract<?> that = (PointsToGraphAbstract<?>) other;
        if (hashCode() != that.hashCode()) {
            return false;
        }
        return slots.equals(that.slots) && heap.equals(that.heap);
    }

    @NotNull
    @Override
    public String toString() {
        return builder().toString();
    }

    @Nullable
    @Override
    public IData<V> getValueData(V v, @NotNull Object mt) {
        PersistentMap<Object, IData<V>> map = heap.get(v);
        return map != null ? map.get(mt) : null;
    }

    @Nullable
    @Override
    public IHeapValues<V> getTargetsUnsafe(@NotNull Object slot) {
        return slots.get(slot);
    }

    @NotNull
    @Override
    public Set<Object> getSlots() {
        return slots.keySet();
    }

    @NotNull
    @Override
    public ImmutableSet<SootMethod> getCalledMethods() {
        return (ImmutableSet<SootMethod>) calledMethods;
    }

    @Override
    public boolean isBottom() {
        return false;
    }

    @Override
    public boolean isTop() {
        return false;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Nullable
    @Override
    public IHeapValues<V> getOfSlot(@NotNull HeapValuesEnv env, @NotNull Object slot) {
        return getTargets(slot);
    }

    @Override
    public void diff(@NotNull IDiff<V> cmp, @NotNull IFact<V> that) {
        if (!(that instanceof PointsToGraphAbstract)) {
            throw new IllegalArgumentException("union error of fact type: " + that.getClass() + " \n" + that);
        }
        PointsToGraphAbstract<V> other = (PointsToGraphAbstract<V>) that;

        for (Map.Entry<Object, IHeapValues<V>> entry : other.slots.entrySet()) {
            IHeapValues<V> values = slots.get(entry.getKey());
            if (values != null) {
                values.diff(cmp, entry.getValue());
            }
        }

        for (Map.Entry<V, PersistentMap<Object, IData<V>>> entry : other.heap.entrySet()) {
            PersistentMap<Object, IData<V>> thisData = heap.get(entry.getKey());
            if (thisData == null) {
                continue;
            }
            for (Map.Entry<Object, IData<V>> dataEntry : entry.getValue().entrySet()) {
                IData<V> thisValues = thisData.get(dataEntry.getKey());
                if (thisValues != null && thisValues != dataEntry.getValue()) {
                    thisValues.diff(cmp, dataEntry.getValue());
                }
            }
        }
    }

    @NotNull
    @Override
    public IHeapValues<V> getTargets(@NotNull Object slot) {
        return IFact.super.getTargets(slot);
    }

    @Nullable
    @Override
    public IHeapValues<V> getArrayLength(V array) {
        return IFact.super.getArrayLength(array);
    }

    @Nullable
    @Override
    public IArrayHeapKV<Integer, V> getArray(V array) {
        return IFact.super.getArray(array);
    }

    @NotNull
    @Override
    public IHeapValues<V> getOfSootValue(@NotNull HeapValuesEnv env, @NotNull Value value, @NotNull Type valueType) {
        return IFact.super.getOfSootValue(env, value, valueType);
    }
}
