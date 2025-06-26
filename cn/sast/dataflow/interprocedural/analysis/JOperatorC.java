/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.JOperator
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorC
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.JOperator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&\u00a8\u0006\b"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/JOperatorC;", "V", "Lcn/sast/dataflow/interprocedural/analysis/JOperator;", "markEntry", "pop", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "popHV", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "corax-data-flow"})
public interface JOperatorC<V>
extends JOperator<V> {
    @NotNull
    public JOperatorC<V> markEntry();

    @NotNull
    public CompanionV<V> pop();

    @NotNull
    public IHeapValues<V> popHV();
}

