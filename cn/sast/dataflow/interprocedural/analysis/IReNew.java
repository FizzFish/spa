package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IReNew<V> {
    @Nullable
    V checkNeedReplace(V old);

    @Nullable
    CompanionV<V> checkNeedReplace(@NotNull CompanionV<V> c);

    @NotNull
    IReNew<V> context(@NotNull Object value);
}