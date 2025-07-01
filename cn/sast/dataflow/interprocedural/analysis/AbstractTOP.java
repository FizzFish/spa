package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTOP<V> extends InValidFact<V> {
    @NotNull
    private final AbstractHeapFactory<V> hf;

    public AbstractTOP(@NotNull AbstractHeapFactory<V> hf) {
        if (hf == null) {
            throw new IllegalArgumentException("hf cannot be null");
        }
        this.hf = hf;
    }

    @NotNull
    public AbstractHeapFactory<V> getHf() {
        return hf;
    }

    @Override
    public boolean isBottom() {
        return false;
    }

    @Override
    public boolean isTop() {
        return true;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    @NotNull
    public String toString() {
        return "IFact: TOP";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IFact)) {
            return false;
        }
        return isTop() && ((IFact<?>) other).isTop();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    @NotNull
    public IHeapValues<V> getOfSlot(@NotNull HeapValuesEnv env, @NotNull Object slot) {
        if (env == null) {
            throw new IllegalArgumentException("env cannot be null");
        }
        if (slot == null) {
            throw new IllegalArgumentException("slot cannot be null");
        }
        return hf.empty();
    }

    @Override
    public void diff(@NotNull IDiff<V> cmp, @NotNull IFact<V> that) {
        if (cmp == null) {
            throw new IllegalArgumentException("cmp cannot be null");
        }
        if (that == null) {
            throw new IllegalArgumentException("that cannot be null");
        }
    }
}