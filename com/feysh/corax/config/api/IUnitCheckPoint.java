/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  org.jetbrains.annotations.NotNull
 *  soot.Unit
 *  soot.jimple.Expr
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassMemberCheckPoint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import soot.jimple.Expr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/config/api/IUnitCheckPoint;", "Lcom/feysh/corax/config/api/IClassMemberCheckPoint;", "unit", "Lsoot/Unit;", "getUnit", "()Lsoot/Unit;", "eachExpr", "", "block", "Lkotlin/Function1;", "Lsoot/jimple/Expr;", "corax-config-api"})
public interface IUnitCheckPoint
extends IClassMemberCheckPoint {
    @NotNull
    public soot.Unit getUnit();

    public void eachExpr(@NotNull Function1<? super Expr, Unit> var1);
}

