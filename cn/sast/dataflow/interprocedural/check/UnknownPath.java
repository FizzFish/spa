package cn.sast.dataflow.interprocedural.check;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

public final class UnknownPath extends IPath {
    @NotNull
    private final Unit node;
    @Nullable
    private Integer hash;

    private UnknownPath(@NotNull Unit node) {
        super(null);
        this.node = node;
    }

    public static UnknownPath create(@NotNull Unit node) {
        return new UnknownPath(node);
    }

    @Override
    @NotNull
    public Unit getNode() {
        return node;
    }

    @Override
    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnknownPath)) {
            return false;
        }
        UnknownPath that = (UnknownPath) other;
        return this.equivHashCode() == that.equivHashCode() 
            && this.getNode() == that.getNode();
    }

    @Nullable
    public Integer getHash() {
        return hash;
    }

    public void setHash(@Nullable Integer hash) {
        this.hash = hash;
    }

    @Override
    public int equivHashCode() {
        if (hash == null) {
            hash = System.identityHashCode(getNode());
        }
        return hash;
    }
}