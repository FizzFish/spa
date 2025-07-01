package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.PathFactory;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;

public final class PathFactoryImpl extends PathFactory<IValue> {

    @NotNull
    @Override
    public IData<IValue> setModelData(@NotNull HeapValuesEnv env, @NotNull IValue obj, @NotNull Object mt, @NotNull IData<IValue> data) {
        IReNew<IValue> pathReNew = (v, old) -> v;
        return data.cloneAndReNewObjects(pathReNew);
    }

    @NotNull
    @Override
    public IHeapValues<IValue> updatePath(@NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> data, 
            @NotNull BiFunction<? super IValue, ? super IPath, ? extends IPath> newPath) {
        IReNew<IValue> pathReNew = (v, old) -> newPath.apply(v, (IPath) old);
        return data.cloneAndReNewObjects(pathReNew);
    }
}