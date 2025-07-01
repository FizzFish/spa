package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IClassDecl extends IJDecl {
    @NotNull
    IClassMatch getMatch();
}