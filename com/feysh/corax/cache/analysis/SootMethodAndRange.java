/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 */
package com.feysh.corax.cache.analysis;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2={"Lcom/feysh/corax/cache/analysis/SootMethodAndRange;", "", "sm", "Lsoot/SootMethod;", "range", "Lkotlin/Pair;", "", "<init>", "(Lsoot/SootMethod;Lkotlin/Pair;)V", "getSm", "()Lsoot/SootMethod;", "getRange", "()Lkotlin/Pair;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "corax-config-api"})
public final class SootMethodAndRange {
    @NotNull
    private final SootMethod sm;
    @NotNull
    private final Pair<Integer, Integer> range;

    public SootMethodAndRange(@NotNull SootMethod sm, @NotNull Pair<Integer, Integer> range) {
        Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
        Intrinsics.checkNotNullParameter(range, (String)"range");
        this.sm = sm;
        this.range = range;
    }

    @NotNull
    public final SootMethod getSm() {
        return this.sm;
    }

    @NotNull
    public final Pair<Integer, Integer> getRange() {
        return this.range;
    }

    @NotNull
    public final SootMethod component1() {
        return this.sm;
    }

    @NotNull
    public final Pair<Integer, Integer> component2() {
        return this.range;
    }

    @NotNull
    public final SootMethodAndRange copy(@NotNull SootMethod sm, @NotNull Pair<Integer, Integer> range) {
        Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
        Intrinsics.checkNotNullParameter(range, (String)"range");
        return new SootMethodAndRange(sm, range);
    }

    public static /* synthetic */ SootMethodAndRange copy$default(SootMethodAndRange sootMethodAndRange, SootMethod sootMethod, Pair pair, int n, Object object) {
        if ((n & 1) != 0) {
            sootMethod = sootMethodAndRange.sm;
        }
        if ((n & 2) != 0) {
            pair = sootMethodAndRange.range;
        }
        return sootMethodAndRange.copy(sootMethod, pair);
    }

    @NotNull
    public String toString() {
        return "SootMethodAndRange(sm=" + this.sm + ", range=" + this.range + ")";
    }

    public int hashCode() {
        int result = this.sm.hashCode();
        result = result * 31 + this.range.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootMethodAndRange)) {
            return false;
        }
        SootMethodAndRange sootMethodAndRange = (SootMethodAndRange)other;
        if (!Intrinsics.areEqual((Object)this.sm, (Object)sootMethodAndRange.sm)) {
            return false;
        }
        return Intrinsics.areEqual(this.range, sootMethodAndRange.range);
    }
}

