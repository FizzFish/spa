/*
 * Copyright (c) 2023, Feysh LLC. All rights reserved.
 */
package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.jimple.InvokeExpr;

public interface IInvokeCheckPoint extends IClassMemberCheckPoint {
    @NotNull
    SootMethod getContainer();

    @Nullable
    Unit getCallSite();

    @Nullable
    SootMethodRef getInvokeMethodRef();

    @Nullable
    Type getDeclaredReceiverType();

    @NotNull
    SootMethod getCallee();

    @Nullable
    InvokeExpr getInvokeExpr();
}