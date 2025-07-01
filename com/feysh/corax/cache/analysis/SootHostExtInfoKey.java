package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.AnalysisKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.tagkit.Host;

public final class SootHostExtInfoKey extends AnalysisKey<SootHostExtend> {
    @NotNull
    private final Host host;
    @NotNull
    private final AnalysisDataFactory.Key<SootHostExtend> factoryKey;

    public SootHostExtInfoKey(@NotNull Host host, @NotNull AnalysisDataFactory.Key<SootHostExtend> factoryKey) {
        super(factoryKey);
        if (host == null) {
            throw new IllegalArgumentException("host cannot be null");
        }
        if (factoryKey == null) {
            throw new IllegalArgumentException("factoryKey cannot be null");
        }
        this.host = host;
        this.factoryKey = factoryKey;
    }

    @NotNull
    public Host getHost() {
        return host;
    }

    @Override
    @NotNull
    public AnalysisDataFactory.Key<SootHostExtend> getFactoryKey() {
        return factoryKey;
    }

    @NotNull
    public SootHostExtInfoKey copy(@NotNull Host host, @NotNull AnalysisDataFactory.Key<SootHostExtend> factoryKey) {
        if (host == null) {
            throw new IllegalArgumentException("host cannot be null");
        }
        if (factoryKey == null) {
            throw new IllegalArgumentException("factoryKey cannot be null");
        }
        return new SootHostExtInfoKey(host, factoryKey);
    }

    @Override
    public String toString() {
        return "SootHostExtInfoKey(host=" + host + ", factoryKey=" + factoryKey + ")";
    }

    @Override
    public int hashCode() {
        int result = host.hashCode();
        result = 31 * result + factoryKey.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootHostExtInfoKey)) {
            return false;
        }
        SootHostExtInfoKey that = (SootHostExtInfoKey) other;
        return host.equals(that.host) && factoryKey.equals(that.factoryKey);
    }
}