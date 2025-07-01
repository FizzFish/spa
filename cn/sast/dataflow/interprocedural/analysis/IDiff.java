package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;

public interface IDiff<V> {
    void diff(@NotNull CompanionV<V> left, @NotNull CompanionV<?> right);
}