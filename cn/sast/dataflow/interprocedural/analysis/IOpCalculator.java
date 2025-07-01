package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;

public interface IOpCalculator<V> extends ICalculator<V> {
    @NotNull
    IOpCalculator<V> resolve(@NotNull Resolver<V> resolver);

    @FunctionalInterface
    interface Resolver<V> {
        boolean resolve(IOpCalculator<V> calculator, IHeapValues.Builder<V> builder, CompanionV<V>[] ops);
    }
}