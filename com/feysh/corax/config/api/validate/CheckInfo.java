package com.feysh.corax.config.api.validate;

import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IBoolExpr;
import org.jetbrains.annotations.NotNull;

public final class CheckInfo {
    @NotNull
    private final IBoolExpr checkExpr;
    @NotNull
    private final CheckType check;

    public CheckInfo(@NotNull IBoolExpr checkExpr, @NotNull CheckType check) {
        if (checkExpr == null) {
            throw new IllegalArgumentException("checkExpr must not be null");
        }
        if (check == null) {
            throw new IllegalArgumentException("check must not be null");
        }
        this.checkExpr = checkExpr;
        this.check = check;
    }

    @NotNull
    public IBoolExpr getCheckExpr() {
        return checkExpr;
    }

    @NotNull
    public CheckType getCheck() {
        return check;
    }

    @Override
    public @NotNull String toString() {
        return "report bug " + check + " if " + checkExpr;
    }
}