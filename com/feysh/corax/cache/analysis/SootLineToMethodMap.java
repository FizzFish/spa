package com.feysh.corax.cache.analysis;

import java.util.TreeMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SootLineToMethodMap {
    @NotNull
    private final TreeMap<Integer, SootMethodAndRange> map;

    public SootLineToMethodMap(@NotNull TreeMap<Integer, SootMethodAndRange> map) {
        if (map == null) {
            throw new IllegalArgumentException("map cannot be null");
        }
        this.map = map;
    }

    @NotNull
    public TreeMap<Integer, SootMethodAndRange> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "SootLineToMethodMap(map=" + map + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootLineToMethodMap)) {
            return false;
        }
        SootLineToMethodMap that = (SootLineToMethodMap) other;
        return map.equals(that.map);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }
}