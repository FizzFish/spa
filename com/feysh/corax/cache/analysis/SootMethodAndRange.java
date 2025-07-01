package com.feysh.corax.cache.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import kotlin.Pair;

public final class SootMethodAndRange {
    @NotNull
    private final SootMethod sm;
    @NotNull
    private final Pair<Integer, Integer> range;

    public SootMethodAndRange(@NotNull SootMethod sm, @NotNull Pair<Integer, Integer> range) {
        if (sm == null) {
            throw new IllegalArgumentException("sm cannot be null");
        }
        if (range == null) {
            throw new IllegalArgumentException("range cannot be null");
        }
        this.sm = sm;
        this.range = range;
    }

    @NotNull
    public SootMethod getSm() {
        return sm;
    }

    @NotNull
    public Pair<Integer, Integer> getRange() {
        return range;
    }

    @NotNull
    public SootMethod component1() {
        return sm;
    }

    @NotNull
    public Pair<Integer, Integer> component2() {
        return range;
    }

    @NotNull
    public SootMethodAndRange copy(@NotNull SootMethod sm, @NotNull Pair<Integer, Integer> range) {
        if (sm == null) {
            throw new IllegalArgumentException("sm cannot be null");
        }
        if (range == null) {
            throw new IllegalArgumentException("range cannot be null");
        }
        return new SootMethodAndRange(sm, range);
    }

    @Override
    public String toString() {
        return "SootMethodAndRange(sm=" + sm + ", range=" + range + ")";
    }

    @Override
    public int hashCode() {
        int result = sm.hashCode();
        result = 31 * result + range.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootMethodAndRange)) {
            return false;
        }
        SootMethodAndRange that = (SootMethodAndRange) other;
        return sm.equals(that.sm) && range.equals(that.range);
    }
}