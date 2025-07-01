package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JOperatorHV<V> extends JOperator<V> {
    @NotNull
    IHeapValues<V> pop();

    @NotNull
    <K> JOperatorHV<V> setKVValue(@NotNull Object mt, @NotNull CompanionV<V> lhs, @Nullable K key);

    @NotNull
    <K> JOperatorHV<V> getKVValue(@NotNull Object mt, @NotNull CompanionV<V> rhs, @Nullable K key);

    @NotNull
    JOperatorHV<V> assignLocal(@NotNull Object lhs, @NotNull IHeapValues<V> rhsValue);

    @NotNull
    JOperatorHV<V> markOfArrayLength(@NotNull CompanionV<V> rhs);

    @NotNull
    JOperatorHV<V> dataElementCopyToSequenceElement(@NotNull IHeapValues<IValue> sourceElement);
}