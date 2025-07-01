package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;

public interface IRule {
    @NotNull
    String getRealName();

    @NotNull
    String getDesc();

    @NotNull
    IStandard getStandard();
}