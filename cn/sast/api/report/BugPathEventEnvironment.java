package cn.sast.api.report;

import com.feysh.corax.cache.analysis.SootInfoCache;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class BugPathEventEnvironment {
    @Nullable
    private final SootInfoCache sootInfoCache;

    public BugPathEventEnvironment(@Nullable SootInfoCache sootInfoCache) {
        this.sootInfoCache = sootInfoCache;
    }

    @Nullable
    public SootInfoCache getSootInfoCache() {
        return sootInfoCache;
    }

    @NotNull
    public BugPathEventEnvironment copy(@Nullable SootInfoCache sootInfoCache) {
        return new BugPathEventEnvironment(sootInfoCache);
    }

    @Override
    public String toString() {
        return "BugPathEventEnvironment(sootInfoCache=" + sootInfoCache + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof BugPathEventEnvironment)) return false;
        BugPathEventEnvironment that = (BugPathEventEnvironment) other;
        return Objects.equals(sootInfoCache, that.sootInfoCache);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sootInfoCache);
    }
}