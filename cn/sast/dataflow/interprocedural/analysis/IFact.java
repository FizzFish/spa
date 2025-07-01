package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;

public interface IFact<V> extends IProblemIteratorTerminal<V>, IIFact<V> {
    @NotNull
    Builder<V> builder();

    void diff(@NotNull IDiff<V> cmp, @NotNull IFact<V> that);

    interface Builder<V> {
    }
}