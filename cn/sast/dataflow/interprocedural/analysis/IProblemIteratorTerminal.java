/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IProblemIteratorTerminal
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.FixPointStatus
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J6\u0010\u0003\u001a\u00020\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&\u00a8\u0006\u000b"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IProblemIteratorTerminal;", "V", "", "hasChange", "Lcn/sast/idfa/analysis/FixPointStatus;", "context", "Lcn/sast/idfa/analysis/Context;", "Lsoot/SootMethod;", "Lsoot/Unit;", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "new", "corax-data-flow"})
public interface IProblemIteratorTerminal<V> {
    @NotNull
    public FixPointStatus hasChange(@NotNull Context<SootMethod, Unit, IFact<V>> var1, @NotNull IProblemIteratorTerminal<V> var2);
}

