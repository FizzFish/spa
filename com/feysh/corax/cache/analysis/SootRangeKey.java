package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.AnalysisKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import java.util.Objects;
import kotlin.Pair;

public final class SootRangeKey extends AnalysisKey<Pair<Integer, Integer>> {
    @NotNull
    private final SootMethod sootMethod;

    public SootRangeKey(@NotNull SootMethod sootMethod) {
        super(SootRangeFactory.INSTANCE.getKey());
        this.sootMethod = Objects.requireNonNull(sootMethod, "sootMethod");
    }

    @NotNull
    public SootMethod getSootMethod() {
        return sootMethod;
    }

    @NotNull
    public SootRangeKey copy(@NotNull SootMethod sootMethod) {
        return new SootRangeKey(Objects.requireNonNull(sootMethod, "sootMethod"));
    }

    @Override
    public String toString() {
        return "SootRangeKey(sootMethod=" + sootMethod + ")";
    }

    @Override
    public int hashCode() {
        return sootMethod.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootRangeKey)) {
            return false;
        }
        SootRangeKey that = (SootRangeKey) other;
        return sootMethod.equals(that.sootMethod);
    }
}