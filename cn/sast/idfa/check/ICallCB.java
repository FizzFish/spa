/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.check.ICallCB
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.idfa.check;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&R\u0012\u0010\t\u001a\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00028\u0000X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0018\u0010\u0012\u001a\u00028\u0001X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0015"}, d2={"Lcn/sast/idfa/check/ICallCB;", "V", "R", "", "arg", "argIndex", "", "(I)Ljava/lang/Object;", "argToValue", "global", "getGlobal", "()Ljava/lang/Object;", "return", "getReturn", "setReturn", "(Ljava/lang/Object;)V", "this", "getThis", "out", "getOut", "setOut", "corax-idfa-framework"})
public interface ICallCB<V, R> {
    public V arg(int var1);

    @NotNull
    public Object argToValue(int var1);

    public V getGlobal();

    public V getReturn();

    public void setReturn(V var1);

    public V getThis();

    public R getOut();

    public void setOut(R var1);
}

