package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import soot.Unit;
import soot.jimple.Expr;

public interface IUnitCheckPoint extends IClassMemberCheckPoint {
    @NotNull
    Unit getUnit();

    void eachExpr(@NotNull ExprConsumer block);

    @FunctionalInterface
    interface ExprConsumer {
        void accept(Expr expr);
    }
}