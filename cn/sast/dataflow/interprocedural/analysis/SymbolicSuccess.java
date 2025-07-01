package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public final class SymbolicSuccess<V> extends MethodResult<V> {
    private final V value;

    public SymbolicSuccess(V value) {
        super(null);
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public V component1() {
        return value;
    }

    @NotNull
    public SymbolicSuccess<V> copy(V value) {
        return new SymbolicSuccess<>(value);
    }

    @Override
    public @NotNull String toString() {
        return "SymbolicSuccess(value=" + value + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof SymbolicSuccess)) return false;
        SymbolicSuccess<?> that = (SymbolicSuccess<?>) other;
        return Objects.equals(value, that.value);
    }
}