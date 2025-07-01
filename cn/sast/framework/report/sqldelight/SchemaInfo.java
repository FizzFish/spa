package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SchemaInfo {
    @NotNull
    private final String key;
    @NotNull
    private final String value;

    public SchemaInfo(@NotNull String key, @NotNull String value) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        this.key = key;
        this.value = value;
    }

    @NotNull
    public String getKey() {
        return key;
    }

    @NotNull
    public String getValue() {
        return value;
    }

    @NotNull
    public SchemaInfo copy(@NotNull String key, @NotNull String value) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        return new SchemaInfo(key, value);
    }

    @Override
    public String toString() {
        return "SchemaInfo(key=" + key + ", value=" + value + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchemaInfo)) {
            return false;
        }
        SchemaInfo that = (SchemaInfo) other;
        return key.equals(that.key) && value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}