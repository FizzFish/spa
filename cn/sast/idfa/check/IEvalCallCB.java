/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.check.ICallCB
 *  cn.sast.idfa.check.IEvalCB
 *  cn.sast.idfa.check.IEvalCallCB
 *  kotlin.Metadata
 */
package cn.sast.idfa.check;

import cn.sast.idfa.check.ICallCB;
import cn.sast.idfa.check.IEvalCB;
import kotlin.Metadata;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004R\u0018\u0010\u0005\u001a\u00020\u0006X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lcn/sast/idfa/check/IEvalCallCB;", "V", "R", "Lcn/sast/idfa/check/IEvalCB;", "Lcn/sast/idfa/check/ICallCB;", "isEvalAble", "", "()Z", "setEvalAble", "(Z)V", "corax-idfa-framework"})
public interface IEvalCallCB<V, R>
extends IEvalCB,
ICallCB<V, R> {
    public boolean isEvalAble();

    public void setEvalAble(boolean var1);
}

