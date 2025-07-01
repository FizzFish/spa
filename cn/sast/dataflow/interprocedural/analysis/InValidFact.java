package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import java.util.Collections;
import java.util.Set;

public abstract class InValidFact<V> implements IFact<V> {

    @Override
    @NotNull
    public FixPointStatus hasChange(@NotNull Context<SootMethod, Unit, IFact<V>> context, 
                                  @NotNull IProblemIteratorTerminal<V> iProblemIteratorTerminal) {
        return !this.equals(iProblemIteratorTerminal) 
            ? FixPointStatus.HasChange 
            : FixPointStatus.Fixpoint;
    }

    @Override
    @NotNull
    public Set<Object> getSlots() {
        return Collections.emptySet();
    }

    @Override
    @Nullable
    public IHeapValues<V> getTargetsUnsafe(@NotNull Object slot) {
        return null;
    }

    @Override
    @NotNull
    public Set<SootMethod> getCalledMethods() {
        return Set.of();
    }

    @Override
    @Nullable
    public IData<V> getValueData(V v, @NotNull Object mt) {
        return null;
    }

    @Override
    @NotNull
    public CallStackContext getCallStack() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    @NotNull
    public IHeapValues<V> getTargets(@NotNull Object slot) {
        return IFact.super.getTargets(slot);
    }

    @Override
    public boolean isValid() {
        return IFact.super.isValid();
    }

    @Override
    @Nullable
    public IHeapValues<V> getArrayLength(V array) {
        return IFact.super.getArrayLength(array);
    }

    @Override
    @Nullable
    public IArrayHeapKV<Integer, V> getArray(V array) {
        return IFact.super.getArray(array);
    }

    @Override
    @NotNull
    public IHeapValues<V> getOfSootValue(@NotNull HeapValuesEnv env, 
                                        @NotNull Value value, 
                                        @NotNull Type valueType) {
        return IFact.super.getOfSootValue(env, value, valueType);
    }
}