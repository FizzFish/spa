package cn.sast.framework.report.sarif;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Description {
    @NotNull
    private final String text;

    public Description(@NotNull String text) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        this.text = text;
    }

    @NotNull
    public String getText() {
        return text;
    }

    @NotNull
    public Description copy(@NotNull String text) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        return new Description(text);
    }

    @Override
    public String toString() {
        return "Description(text=" + text + ")";
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Description)) {
            return false;
        }
        Description description = (Description) other;
        return text.equals(description.text);
    }
}
