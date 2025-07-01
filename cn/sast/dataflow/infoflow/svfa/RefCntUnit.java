package cn.sast.dataflow.infoflow.svfa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefCntUnit<N> {
    private final N u;
    private int cnt;
    @NotNull
    private final Queue<RefCntUnit<N>> ref;

    public RefCntUnit(N u, int cnt) {
        this.u = u;
        this.cnt = cnt;
        this.ref = new LinkedList<>();
    }

    public final N getU() {
        return u;
    }

    public final int getCnt() {
        return cnt;
    }

    public final void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public final void add(@NotNull RefCntUnit<N> prev) {
        Objects.requireNonNull(prev, "prev");
        ref.add(prev);
        prev.cnt++;
    }

    public final void dec() {
        cnt--;
        if (cnt == 0) {
            for (RefCntUnit<N> unit : ref) {
                unit.dec();
            }
        }
        if (cnt < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @Override
    public int hashCode() {
        return u != null ? u.hashCode() : 0;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RefCntUnit)) {
            return false;
        }
        RefCntUnit<?> that = (RefCntUnit<?>) other;
        return Objects.equals(that.u, this.u);
    }

    @Override
    public @NotNull String toString() {
        return u + " " + cnt;
    }
}