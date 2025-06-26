/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.check.ICallerSiteCB
 *  cn.sast.idfa.check.IInvokeStmtCB
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.InvokeExpr
 */
package cn.sast.idfa.check;

import cn.sast.idfa.check.ICallerSiteCB;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import soot.jimple.InvokeExpr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lcn/sast/idfa/check/IInvokeStmtCB;", "V", "R", "Lcn/sast/idfa/check/ICallerSiteCB;", "invokeExpr", "Lsoot/jimple/InvokeExpr;", "getInvokeExpr", "()Lsoot/jimple/InvokeExpr;", "corax-idfa-framework"})
public interface IInvokeStmtCB<V, R>
extends ICallerSiteCB<V, R> {
    @NotNull
    public InvokeExpr getInvokeExpr();
}

