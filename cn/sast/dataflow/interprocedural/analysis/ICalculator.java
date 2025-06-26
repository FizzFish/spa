/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ICalculator
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H&J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/ICalculator;", "V", "", "res", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "getRes", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "isFullySimplified", "", "putSummaryValue", "", "type", "Lsoot/Type;", "special", "putSummaryIfNotConcrete", "corax-data-flow"})
public interface ICalculator<V> {
    @NotNull
    public IHeapValues.Builder<V> getRes();

    public boolean isFullySimplified();

    public void putSummaryValue(@NotNull Type var1, @NotNull Object var2);

    public void putSummaryIfNotConcrete(@NotNull Type var1, @NotNull Object var2);
}

