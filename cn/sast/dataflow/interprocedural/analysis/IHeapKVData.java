/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\rJ-\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH&\u00a8\u0006\u000e"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IHeapKVData;", "K", "", "V", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "get", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "key", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IHeapKVData$Builder;", "Builder", "corax-data-flow"})
public interface IHeapKVData<K, V>
extends IData<V> {
    @Nullable
    public IHeapValues<V> get(@NotNull IHeapValuesFactory<V> var1, @Nullable K var2);

    @NotNull
    public Builder<K, V> builder();
}

