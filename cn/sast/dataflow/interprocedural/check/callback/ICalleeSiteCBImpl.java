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
 */
package cn.sast.dataflow.interprocedural.check.callback;

import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.idfa.check.ICalleeCB;

public interface ICalleeSiteCBImpl extends ICalleeCB<IHeapValues<IValue>, IFact.Builder<IValue>>,
    ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> {
}