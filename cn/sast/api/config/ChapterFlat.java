package cn.sast.api.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class ChapterFlat {
    @NotNull
    private final String category;
    @NotNull
    private final String severity;
    @NotNull
    private final String ruleId;

    public ChapterFlat(@NotNull String category, @NotNull String severity, @NotNull String ruleId) {
        this.category = Objects.requireNonNull(category, "category");
        this.severity = Objects.requireNonNull(severity, "severity");
        this.ruleId = Objects.requireNonNull(ruleId, "ruleId");
    }

    @NotNull
    public String getCategory() {
        return category;
    }

    @NotNull
    public String getSeverity() {
        return severity;
    }

    @NotNull
    public String getRuleId() {
        return ruleId;
    }

    @NotNull
    public ChapterFlat copy(@NotNull String category, @NotNull String severity, @NotNull String ruleId) {
        return new ChapterFlat(
            Objects.requireNonNull(category, "category"),
            Objects.requireNonNull(severity, "severity"),
            Objects.requireNonNull(ruleId, "ruleId")
        );
    }

    @Override
    public String toString() {
        return "ChapterFlat(category=" + category + ", severity=" + severity + ", ruleId=" + ruleId + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ChapterFlat)) return false;
        ChapterFlat that = (ChapterFlat) other;
        return category.equals(that.category) &&
            severity.equals(that.severity) &&
            ruleId.equals(that.ruleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, severity, ruleId);
    }
}