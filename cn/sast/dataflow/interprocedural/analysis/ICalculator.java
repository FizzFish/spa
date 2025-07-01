package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import soot.Type;

public interface ICalculator<V> {
    @NotNull
    IHeapValues.Builder<V> getRes();

    boolean isFullySimplified();

    void putSummaryValue(@NotNull Type type, @NotNull Object special);

    void putSummaryIfNotConcrete(@NotNull Type type, @NotNull Object special);
}