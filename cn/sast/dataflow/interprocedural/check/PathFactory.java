package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;

public abstract class PathFactory<V> {
    @NotNull
    public abstract IData<V> setModelData(
        @NotNull HeapValuesEnv env,
        V obj,
        @NotNull Object mt,
        @NotNull IData<V> data
    );

    @NotNull
    public abstract IHeapValues<V> updatePath(
        @NotNull HeapValuesEnv env,
        @NotNull IHeapValues<V> data,
        @NotNull BiFunction<? super V, ? super IPath, ? extends IPath> newPath
    );
}