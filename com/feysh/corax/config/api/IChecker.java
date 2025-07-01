package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import java.util.Set;

public interface IChecker {
    @NotNull
    default String getSimpleName() {
        return getClass().getSimpleName();
    }

    @NotNull
    IRule getReport();

    @NotNull
    Set<IRule> getStandards();

    @NotNull
    default String getDesc() {
        return getReport().getDesc();
    }

    default void validate() {
    }
}