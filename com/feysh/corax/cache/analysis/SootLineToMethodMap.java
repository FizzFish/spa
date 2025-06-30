/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.analysis;

import com.feysh.corax.cache.analysis.SootMethodAndRange;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2={"Lcom/feysh/corax/cache/analysis/SootLineToMethodMap;", "", "map", "Ljava/util/TreeMap;", "", "Lcom/feysh/corax/cache/analysis/SootMethodAndRange;", "<init>", "(Ljava/util/TreeMap;)V", "getMap", "()Ljava/util/TreeMap;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "corax-config-api"})
public final class SootLineToMethodMap {
    @NotNull
    private final TreeMap<Integer, SootMethodAndRange> map;

    public SootLineToMethodMap(@NotNull TreeMap<Integer, SootMethodAndRange> map) {
        Intrinsics.checkNotNullParameter(map, (String)"map");
        this.map = map;
    }

    @NotNull
    public final TreeMap<Integer, SootMethodAndRange> getMap() {
        return this.map;
    }

    @NotNull
    public final TreeMap<Integer, SootMethodAndRange> component1() {
        return this.map;
    }

    @NotNull
    public final SootLineToMethodMap copy(@NotNull TreeMap<Integer, SootMethodAndRange> map) {
        Intrinsics.checkNotNullParameter(map, (String)"map");
        return new SootLineToMethodMap(map);
    }

    public static /* synthetic */ SootLineToMethodMap copy$default(SootLineToMethodMap sootLineToMethodMap, TreeMap treeMap, int n, Object object) {
        if ((n & 1) != 0) {
            treeMap = sootLineToMethodMap.map;
        }
        return sootLineToMethodMap.copy(treeMap);
    }

    @NotNull
    public String toString() {
        return "SootLineToMethodMap(map=" + this.map + ")";
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootLineToMethodMap)) {
            return false;
        }
        SootLineToMethodMap sootLineToMethodMap = (SootLineToMethodMap)other;
        return Intrinsics.areEqual(this.map, sootLineToMethodMap.map);
    }
}

