package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VerifyRuleName {
    private final long id;
    @NotNull
    private final String ruleName;

    public VerifyRuleName(long id, @NotNull String ruleName) {
        if (ruleName == null) {
            throw new IllegalArgumentException("ruleName cannot be null");
        }
        this.id = id;
        this.ruleName = ruleName;
    }

    public long getId() {
        return id;
    }

    @NotNull
    public String getRuleName() {
        return ruleName;
    }

    @NotNull
    public VerifyRuleName copy(long id, @NotNull String ruleName) {
        return new VerifyRuleName(id, ruleName);
    }

    @Override
    public String toString() {
        return "VerifyRuleName(id=" + id + ", ruleName=" + ruleName + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + ruleName.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof VerifyRuleName)) return false;
        VerifyRuleName that = (VerifyRuleName) other;
        return id == that.id && ruleName.equals(that.ruleName);
    }
}