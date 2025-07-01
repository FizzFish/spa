package cn.sast.dataflow.interprocedural.check;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExitInvoke {
    @NotNull
    private final InvokeEdgePath invoke;

    public ExitInvoke(@NotNull InvokeEdgePath invoke) {
        if (invoke == null) {
            throw new IllegalArgumentException("invoke cannot be null");
        }
        this.invoke = invoke;
    }

    @NotNull
    public InvokeEdgePath getInvoke() {
        return invoke;
    }

    @NotNull
    public ExitInvoke copy(@NotNull InvokeEdgePath invoke) {
        if (invoke == null) {
            throw new IllegalArgumentException("invoke cannot be null");
        }
        return new ExitInvoke(invoke);
    }

    @Override
    public String toString() {
        return "ExitInvoke(invoke=" + invoke + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ExitInvoke)) return false;
        ExitInvoke that = (ExitInvoke) other;
        return invoke.equals(that.invoke);
    }

    @Override
    public int hashCode() {
        return invoke.hashCode();
    }
}