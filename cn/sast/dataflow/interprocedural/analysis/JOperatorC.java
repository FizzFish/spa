package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;

public interface JOperatorC<V> extends JOperator<V> {
    @NotNull
    JOperatorC<V> markEntry();

    @NotNull
    CompanionV<V> pop();

    @NotNull
    IHeapValues<V> popHV();
}