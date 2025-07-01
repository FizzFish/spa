package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IStmt {
    <TResult> TResult accept(@NotNull IModelStmtVisitor<TResult> visitor);
}