package cn.sast.dataflow.interprocedural.check.callback;

import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.idfa.check.ICallerSiteCB;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

public interface ICallerSiteCBImpl 
    extends ICallerSiteCB<IHeapValues<IValue>, IFact.Builder<IValue>>,
            ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> {

    @NotNull
    SootMethod getCaller();
}