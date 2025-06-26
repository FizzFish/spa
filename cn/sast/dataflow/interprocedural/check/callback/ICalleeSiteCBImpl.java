/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl
 *  cn.sast.dataflow.interprocedural.check.callback.ICalleeSiteCBImpl
 *  cn.sast.idfa.check.ICalleeCB
 *  kotlin.Metadata
 */
package cn.sast.dataflow.interprocedural.check.callback;

import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.idfa.check.ICalleeCB;
import kotlin.Metadata;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\"\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u00060\u00012\"\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u00060\u0007\u00a8\u0006\b"}, d2={"Lcn/sast/dataflow/interprocedural/check/callback/ICalleeSiteCBImpl;", "Lcn/sast/idfa/check/ICalleeCB;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/check/callback/V;", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "Lcn/sast/dataflow/interprocedural/check/callback/R;", "Lcn/sast/dataflow/interprocedural/check/callback/ICallCBImpl;", "corax-data-flow"})
public interface ICalleeSiteCBImpl
extends ICalleeCB<IHeapValues<IValue>, IFact.Builder<IValue>>,
ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> {
}

