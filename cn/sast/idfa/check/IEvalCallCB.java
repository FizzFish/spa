package cn.sast.idfa.check;

public interface IEvalCallCB<V, R> extends IEvalCB, ICallCB<V, R> {
    boolean isEvalAble();
    void setEvalAble(boolean evalAble);
}