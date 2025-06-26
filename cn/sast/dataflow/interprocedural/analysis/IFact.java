/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IIFact
 *  cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IIFact;
import cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&\u00a8\u0006\f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IFact;", "V", "Lcn/sast/dataflow/interprocedural/analysis/IProblemIteratorTerminal;", "Lcn/sast/dataflow/interprocedural/analysis/IIFact;", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "diff", "", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "Builder", "corax-data-flow"})
public interface IFact<V>
extends IProblemIteratorTerminal<V>,
IIFact<V> {
    @NotNull
    public Builder<V> builder();

    public void diff(@NotNull IDiff<V> var1, @NotNull IFact<V> var2);
}

