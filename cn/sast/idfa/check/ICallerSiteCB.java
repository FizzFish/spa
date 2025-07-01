package cn.sast.idfa.check;

import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

public interface ICallerSiteCB<V, R> extends IStmtCB, ICallCB<V, R> {
    @NotNull
    SootMethod getCaller();

    interface IPrevCall {}
    interface IEvalCall {}
    interface IPostCall {}
}