/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.check.ICallCB
 *  cn.sast.idfa.check.ICalleeCB
 *  cn.sast.idfa.check.IStmtCB
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 */
package cn.sast.idfa.check;

import cn.sast.idfa.check.ICallCB;
import cn.sast.idfa.check.IStmtCB;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0003\t\n\u000bR\u0012\u0010\u0005\u001a\u00020\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2={"Lcn/sast/idfa/check/ICalleeCB;", "V", "R", "Lcn/sast/idfa/check/IStmtCB;", "Lcn/sast/idfa/check/ICallCB;", "callee", "Lsoot/SootMethod;", "getCallee", "()Lsoot/SootMethod;", "IPrevCall", "IEvalCall", "IPostCall", "corax-idfa-framework"})
public interface ICalleeCB<V, R>
extends IStmtCB,
ICallCB<V, R> {
    @NotNull
    public SootMethod getCallee();
}

