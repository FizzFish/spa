package cn.sast.framework.report;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class ValueWithId<T> {
    private final long id;
    private final T value;

    public ValueWithId(long id, T value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public T getValue() {
        return value;
    }

    public long component1() {
        return id;
    }

    public T component2() {
        return value;
    }

    @NotNull
    public ValueWithId<T> copy(long id, T value) {
        return new ValueWithId<>(id, value);
    }

    @Override
    public @NotNull String toString() {
        return "ValueWithId(id=" + id + ", value=" + value + ")";
    }

    @Override
    public int hashCode() {
        return 31 * Long.hashCode(id) + Objects.hashCode(value);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ValueWithId)) return false;
        ValueWithId<?> that = (ValueWithId<?>) other;
        return id == that.id && Objects.equals(value, that.value);
    }
}