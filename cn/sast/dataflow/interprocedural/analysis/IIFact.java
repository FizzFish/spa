package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;
import soot.Value;

public interface IIFact<V> {
    @NotNull
    AbstractHeapFactory<V> getHf();

    @Nullable
    IData<V> getValueData(V v, @NotNull Object mt);

    @NotNull
    IHeapValues<V> getTargets(@NotNull Object slot);

    @Nullable
    IHeapValues<V> getTargetsUnsafe(@NotNull Object slot);

    @NotNull
    Set<Object> getSlots();

    @NotNull
    Set<SootMethod> getCalledMethods();

    boolean isBottom();

    boolean isTop();

    boolean isValid();

    @Nullable
    IHeapValues<V> getOfSlot(@NotNull HeapValuesEnv env, @NotNull Object slot);

    @Nullable
    IHeapValues<V> getArrayLength(V array);

    @Nullable
    IArrayHeapKV<Integer, V> getArray(V array);

    @NotNull
    IHeapValues<V> getOfSootValue(@NotNull HeapValuesEnv env, @NotNull Value value, @NotNull Type valueType);

    @NotNull
    CallStackContext getCallStack();
}