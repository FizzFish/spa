package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;

public final class SootLineToMethodMapKey extends AnalysisKey<SootLineToMethodMap> {
    @NotNull
    private final SootClass sc;

    public SootLineToMethodMapKey(@NotNull SootClass sc) {
        super(SootLineToMethodMapFactory.INSTANCE.getKey());
        this.sc = sc;
    }

    @NotNull
    public SootClass getSc() {
        return sc;
    }

    @NotNull
    public SootLineToMethodMapKey copy(@NotNull SootClass sc) {
        if (sc == null) {
            throw new NullPointerException("sc");
        }
        return new SootLineToMethodMapKey(sc);
    }

    @Override
    public String toString() {
        return "SootLineToMethodMapKey(sc=" + sc + ")";
    }

    @Override
    public int hashCode() {
        return sc.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootLineToMethodMapKey)) {
            return false;
        }
        SootLineToMethodMapKey that = (SootLineToMethodMapKey) other;
        return sc.equals(that.sc);
    }
}