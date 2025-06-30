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

import com.feysh.corax.cache.AnalysisKey;
import com.feysh.corax.cache.analysis.SootRangeFactory;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0005H\u00c6\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/cache/analysis/SootRangeKey;", "Lcom/feysh/corax/cache/AnalysisKey;", "Lkotlin/Pair;", "", "sootMethod", "Lsoot/SootMethod;", "<init>", "(Lsoot/SootMethod;)V", "getSootMethod", "()Lsoot/SootMethod;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "corax-config-api"})
public final class SootRangeKey
extends AnalysisKey<Pair<? extends Integer, ? extends Integer>> {
    @NotNull
    private final SootMethod sootMethod;

    public SootRangeKey(@NotNull SootMethod sootMethod) {
        Intrinsics.checkNotNullParameter((Object)sootMethod, (String)"sootMethod");
        super(SootRangeFactory.INSTANCE.getKey());
        this.sootMethod = sootMethod;
    }

    @NotNull
    public final SootMethod getSootMethod() {
        return this.sootMethod;
    }

    @NotNull
    public final SootMethod component1() {
        return this.sootMethod;
    }

    @NotNull
    public final SootRangeKey copy(@NotNull SootMethod sootMethod) {
        Intrinsics.checkNotNullParameter((Object)sootMethod, (String)"sootMethod");
        return new SootRangeKey(sootMethod);
    }

    public static /* synthetic */ SootRangeKey copy$default(SootRangeKey sootRangeKey, SootMethod sootMethod, int n, Object object) {
        if ((n & 1) != 0) {
            sootMethod = sootRangeKey.sootMethod;
        }
        return sootRangeKey.copy(sootMethod);
    }

    @NotNull
    public String toString() {
        return "SootRangeKey(sootMethod=" + this.sootMethod + ")";
    }

    @Override
    public int hashCode() {
        return this.sootMethod.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SootRangeKey)) {
            return false;
        }
        SootRangeKey sootRangeKey = (SootRangeKey)other;
        return Intrinsics.areEqual((Object)this.sootMethod, (Object)sootRangeKey.sootMethod);
    }
}

