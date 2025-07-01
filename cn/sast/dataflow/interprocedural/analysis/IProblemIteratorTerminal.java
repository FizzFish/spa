package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.FixPointStatus;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.Unit;

public interface IProblemIteratorTerminal<V> {
    @NotNull
    FixPointStatus hasChange(@NotNull Context<SootMethod, Unit, IFact<V>> context, 
                            @NotNull IProblemIteratorTerminal<V> newTerminal);
}