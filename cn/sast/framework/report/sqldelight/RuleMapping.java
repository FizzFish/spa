package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class RuleMapping {
    @NotNull
    private final String ruleName;
    @Nullable
    private final String standardName;
    @Nullable
    private final String standardRule;

    public RuleMapping(@NotNull String ruleName, @Nullable String standardName, @Nullable String standardRule) {
        Objects.requireNonNull(ruleName, "ruleName must not be null");
        this.ruleName = ruleName;
        this.standardName = standardName;
        this.standardRule = standardRule;
    }

    @NotNull
    public String getRuleName() {
        return ruleName;
    }

    @Nullable
    public String getStandardName() {
        return standardName;
    }

    @Nullable
    public String getStandardRule() {
        return standardRule;
    }

    @NotNull
    public RuleMapping copy(@NotNull String ruleName, @Nullable String standardName, @Nullable String standardRule) {
        Objects.requireNonNull(ruleName, "ruleName must not be null");
        return new RuleMapping(ruleName, standardName, standardRule);
    }

    @Override
    public String toString() {
        return "RuleMapping(ruleName=" + ruleName + 
               ", standardName=" + standardName + 
               ", standardRule=" + standardRule + ")";
    }

    @Override
    public int hashCode() {
        int result = ruleName.hashCode();
        result = 31 * result + (standardName != null ? standardName.hashCode() : 0);
        result = 31 * result + (standardRule != null ? standardRule.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof RuleMapping)) return false;
        RuleMapping that = (RuleMapping) other;
        return ruleName.equals(that.ruleName) &&
               Objects.equals(standardName, that.standardName) &&
               Objects.equals(standardRule, that.standardRule);
    }
}