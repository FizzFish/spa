/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&\u00a8\u0006\n"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "V", "", "empty", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "emptyBuilder", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "single", "v", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "corax-data-flow"})
public interface IHeapValuesFactory<V> {
    @NotNull
    public IHeapValues<V> empty();

    @NotNull
    public IHeapValues.Builder<V> emptyBuilder();

    @NotNull
    public IHeapValues<V> single(@NotNull CompanionV<V> var1);
}

