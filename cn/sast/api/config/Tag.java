package cn.sast.api.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Tag {
    @NotNull
    private final String standard;
    @NotNull
    private final String rule;

    public Tag(@NotNull String standard, @NotNull String rule) {
        if (standard == null) {
            throw new IllegalArgumentException("standard cannot be null");
        }
        if (rule == null) {
            throw new IllegalArgumentException("rule cannot be null");
        }
        this.standard = standard;
        this.rule = rule;
    }

    @NotNull
    public String getStandard() {
        return standard;
    }

    @NotNull
    public String getRule() {
        return rule;
    }

    @NotNull
    public Tag copy(@NotNull String standard, @NotNull String rule) {
        if (standard == null) {
            throw new IllegalArgumentException("standard cannot be null");
        }
        if (rule == null) {
            throw new IllegalArgumentException("rule cannot be null");
        }
        return new Tag(standard, rule);
    }

    @Override
    public String toString() {
        return "Tag(standard=" + standard + ", rule=" + rule + ")";
    }

    @Override
    public int hashCode() {
        int result = standard.hashCode();
        result = 31 * result + rule.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) other;
        return standard.equals(tag.standard) && rule.equals(tag.rule);
    }
}