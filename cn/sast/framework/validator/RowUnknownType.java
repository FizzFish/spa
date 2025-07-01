package cn.sast.framework.validator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RowUnknownType extends RowType {
    @NotNull
    private final String type;

    public RowUnknownType(@NotNull String type) {
        super(null);
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        this.type = type;
    }

    @Override
    @NotNull
    public String getType() {
        return type;
    }

    @Override
    @NotNull
    public String toString() {
        return type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RowUnknownType)) {
            return false;
        }
        RowUnknownType that = (RowUnknownType) other;
        return type.equals(that.type);
    }

    @NotNull
    public RowUnknownType copy(@NotNull String type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        return new RowUnknownType(type);
    }
}