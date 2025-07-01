package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IRelativePath {
    @NotNull
    String getPrefix();

    @NotNull
    String getRelativePath();
}