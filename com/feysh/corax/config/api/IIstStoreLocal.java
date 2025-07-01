/*
 * Copyright (c) 2023 Feysh LLC
 */
package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IIstStoreLocal extends IStmt {
    @NotNull
    MLocal getLocal();

    @NotNull
    IExpr getValue();
}