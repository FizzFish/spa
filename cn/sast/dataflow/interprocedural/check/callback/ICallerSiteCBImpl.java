/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl
 *  cn.sast.dataflow.interprocedural.check.callback.ICallerSiteCBImpl
 *  cn.sast.idfa.check.ICallerSiteCB
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 */
package cn.sast.dataflow.interprocedural.check.callback;

import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.idfa.check.ICallerSiteCB;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\"\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u00060\u00012\"\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u00060\u0007R\u0012\u0010\b\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lcn/sast/dataflow/interprocedural/check/callback/ICallerSiteCBImpl;", "Lcn/sast/idfa/check/ICallerSiteCB;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/check/callback/V;", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "Lcn/sast/dataflow/interprocedural/check/callback/R;", "Lcn/sast/dataflow/interprocedural/check/callback/ICallCBImpl;", "caller", "Lsoot/SootMethod;", "getCaller", "()Lsoot/SootMethod;", "corax-data-flow"})
public interface ICallerSiteCBImpl
extends ICallerSiteCB<IHeapValues<IValue>, IFact.Builder<IValue>>,
ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> {
    @NotNull
    public SootMethod getCaller();
}

