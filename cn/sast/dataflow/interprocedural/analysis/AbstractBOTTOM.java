package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractBOTTOM<V> extends InValidFact<V> {
    @NotNull
    public AbstractHeapFactory<V> getHf() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean isBottom() {
        return true;
    }

    @Override
    public boolean isTop() {
        return false;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    @NotNull
    public String toString() {
        return "IFact: BOTTOM";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IFact)) {
            return false;
        }
        return this.isBottom() && ((IFact<?>) other).isBottom();
    }

    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    @NotNull
    public IHeapValues<V> getOfSlot(@NotNull HeapValuesEnv env, @NotNull Object slot) {
        if (env == null) throw new IllegalArgumentException("env cannot be null");
        if (slot == null) throw new IllegalArgumentException("slot cannot be null");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void diff(@NotNull IDiff<V> cmp, @NotNull IFact<V> that) {
        if (cmp == null) throw new IllegalArgumentException("cmp cannot be null");
        if (that == null) throw new IllegalArgumentException("that cannot be null");
    }

    @Override
    @NotNull
    public IFact.Builder<V> builder() {
        throw new UnsupportedOperationException("Builder not implemented");
    }
}