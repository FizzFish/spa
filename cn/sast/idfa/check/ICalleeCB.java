package cn.sast.idfa.check;

import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

public interface ICalleeCB<V, R> extends IStmtCB, ICallCB<V, R> {
    @NotNull
    SootMethod getCallee();
}