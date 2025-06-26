/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.BugPathEventEnvironment
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.report;

import com.feysh.corax.cache.analysis.SootInfoCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2={"Lcn/sast/api/report/BugPathEventEnvironment;", "", "sootInfoCache", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "<init>", "(Lcom/feysh/corax/cache/analysis/SootInfoCache;)V", "getSootInfoCache", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "corax-api"})
public final class BugPathEventEnvironment {
    @Nullable
    private final SootInfoCache sootInfoCache;

    public BugPathEventEnvironment(@Nullable SootInfoCache sootInfoCache) {
        this.sootInfoCache = sootInfoCache;
    }

    @Nullable
    public final SootInfoCache getSootInfoCache() {
        return this.sootInfoCache;
    }

    @Nullable
    public final SootInfoCache component1() {
        return this.sootInfoCache;
    }

    @NotNull
    public final BugPathEventEnvironment copy(@Nullable SootInfoCache sootInfoCache) {
        return new BugPathEventEnvironment(sootInfoCache);
    }

    public static /* synthetic */ BugPathEventEnvironment copy$default(BugPathEventEnvironment bugPathEventEnvironment, SootInfoCache sootInfoCache, int n, Object object) {
        if ((n & 1) != 0) {
            sootInfoCache = bugPathEventEnvironment.sootInfoCache;
        }
        return bugPathEventEnvironment.copy(sootInfoCache);
    }

    @NotNull
    public String toString() {
        return "BugPathEventEnvironment(sootInfoCache=" + this.sootInfoCache + ")";
    }

    public int hashCode() {
        return this.sootInfoCache == null ? 0 : this.sootInfoCache.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BugPathEventEnvironment)) {
            return false;
        }
        BugPathEventEnvironment bugPathEventEnvironment = (BugPathEventEnvironment)other;
        return Intrinsics.areEqual((Object)this.sootInfoCache, (Object)bugPathEventEnvironment.sootInfoCache);
    }
}

