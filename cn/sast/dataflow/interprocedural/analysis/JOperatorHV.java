/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JOperator
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorHV
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JOperator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&J=\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0001\u0010\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\u0006H&\u00a2\u0006\u0002\u0010\rJ=\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0001\u0010\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\u0006H&\u00a2\u0006\u0002\u0010\rJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\n\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004H&\u00a8\u0006\u0016"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/JOperatorHV;", "V", "Lcn/sast/dataflow/interprocedural/analysis/JOperator;", "pop", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "setKVValue", "K", "mt", "", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "lhs", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "key", "(Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/analysis/CompanionV;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/JOperatorHV;", "getKVValue", "rhs", "assignLocal", "rhsValue", "markOfArrayLength", "dataElementCopyToSequenceElement", "sourceElement", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "corax-data-flow"})
public interface JOperatorHV<V>
extends JOperator<V> {
    @NotNull
    public IHeapValues<V> pop();

    @NotNull
    public <K> JOperatorHV<V> setKVValue(@NotNull Object var1, @NotNull CompanionV<V> var2, @Nullable K var3);

    @NotNull
    public <K> JOperatorHV<V> getKVValue(@NotNull Object var1, @NotNull CompanionV<V> var2, @Nullable K var3);

    @NotNull
    public JOperatorHV<V> assignLocal(@NotNull Object var1, @NotNull IHeapValues<V> var2);

    @NotNull
    public JOperatorHV<V> markOfArrayLength(@NotNull CompanionV<V> var1);

    @NotNull
    public JOperatorHV<V> dataElementCopyToSequenceElement(@NotNull IHeapValues<IValue> var1);
}

