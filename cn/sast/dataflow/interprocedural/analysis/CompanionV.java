package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class CompanionV<V> {
    private final V value;
    @Nullable
    private Integer hashCode;

    public CompanionV(V value) {
        this.value = value;
    }

    public final V getValue() {
        return value;
    }

    @NotNull
    public abstract CompanionV<V> union(@NotNull CompanionV<V> other);

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompanionV)) {
            return false;
        }
        CompanionV<?> that = (CompanionV<?>) other;
        return (value == null) ? (that.value == null) : value.equals(that.value);
    }

    public int computeHash() {
        return (value != null ? value.hashCode() : 0) + 23342879;
    }

    @Override
    public int hashCode() {
        if (hashCode == null) {
            hashCode = computeHash();
        }
        return hashCode;
    }

    @NotNull
    public abstract CompanionV<V> copy(V updateValue);
}