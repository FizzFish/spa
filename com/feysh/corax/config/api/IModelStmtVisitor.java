package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IModelStmtVisitor<TResult> {
    TResult default(@NotNull IStmt stmt);

    default TResult visit(@NotNull IIstSetField stmt) {
        return default(stmt);
    }

    default TResult visit(@NotNull IIstStoreLocal stmt) {
        return default(stmt);
    }
}