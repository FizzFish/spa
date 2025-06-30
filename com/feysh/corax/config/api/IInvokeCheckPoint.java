/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.SootMethodRef
 *  soot.Type
 *  soot.Unit
 *  soot.jimple.InvokeExpr
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassMemberCheckPoint;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.jimple.InvokeExpr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2={"Lcom/feysh/corax/config/api/IInvokeCheckPoint;", "Lcom/feysh/corax/config/api/IClassMemberCheckPoint;", "container", "Lsoot/SootMethod;", "getContainer", "()Lsoot/SootMethod;", "callSite", "Lsoot/Unit;", "getCallSite", "()Lsoot/Unit;", "invokeMethodRef", "Lsoot/SootMethodRef;", "getInvokeMethodRef", "()Lsoot/SootMethodRef;", "declaredReceiverType", "Lsoot/Type;", "getDeclaredReceiverType", "()Lsoot/Type;", "callee", "getCallee", "invokeExpr", "Lsoot/jimple/InvokeExpr;", "getInvokeExpr", "()Lsoot/jimple/InvokeExpr;", "corax-config-api"})
public interface IInvokeCheckPoint
extends IClassMemberCheckPoint {
    @NotNull
    public SootMethod getContainer();

    @Nullable
    public Unit getCallSite();

    @Nullable
    public SootMethodRef getInvokeMethodRef();

    @Nullable
    public Type getDeclaredReceiverType();

    @NotNull
    public SootMethod getCallee();

    @Nullable
    public InvokeExpr getInvokeExpr();
}

