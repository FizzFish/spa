package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Type;

public interface ISootLocalVarDecl<T> extends ILocalVarDecl<T> {
    @NotNull
    Local getLocal();

    @Nullable
    default String getName() {
        return getLocal().getName();
    }

    @NotNull
    default Type getType() {
        return getLocal().getType();
    }
}