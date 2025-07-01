/*
 * Decompiled with CFR 0.152.
 */
package cn.sast.idfa.check;

import org.jetbrains.annotations.NotNull;

public interface ICallCB<V, R> {
    V arg(int argIndex);

    @NotNull
    Object argToValue(int argIndex);

    V getGlobal();

    V getReturn();
    void setReturn(V value);

    V getThis();

    R getOut();
    void setOut(R value);
}