/*
 * Copyright (c) 2022, All rights reserved.
 */
package cn.sast.idfa.check;

import org.jetbrains.annotations.NotNull;
import soot.jimple.InvokeExpr;

public interface IInvokeStmtCB<V, R> extends ICallerSiteCB<V, R> {
    @NotNull
    InvokeExpr getInvokeExpr();
}