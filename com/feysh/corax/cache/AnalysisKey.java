package com.feysh.corax.cache;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AnalysisKey<T> {
    @NotNull
    private final AnalysisDataFactory.Key<T> factoryKey;

    public AnalysisKey(@NotNull AnalysisDataFactory.Key<T> factoryKey) {
        this.factoryKey = factoryKey;
    }

    @NotNull
    public AnalysisDataFactory.Key<T> getFactoryKey() {
        return factoryKey;
    }

    @Override
    public int hashCode() {
        throw new IllegalStateException("Did you forget to override hashCode()?");
    }

    @Override
    public boolean equals(@Nullable Object other) {
        throw new IllegalStateException("Did you forget to override equals()?");
    }
}