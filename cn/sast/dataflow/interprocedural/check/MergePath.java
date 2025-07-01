package cn.sast.dataflow.interprocedural.check;

import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

public final class MergePath extends IPath {
    @NotNull
    private final Unit node;
    @NotNull
    private final PersistentSet<IPath> all;
    @Nullable
    private Integer hash;

    private MergePath(@NotNull Unit node, @NotNull PersistentSet<? extends IPath> all) {
        super(null);
        this.node = node;
        this.all = all;
    }

    @NotNull
    public Unit getNode() {
        return node;
    }

    @NotNull
    public PersistentSet<IPath> getAll() {
        return all;
    }

    @Override
    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MergePath)) {
            return false;
        }
        MergePath that = (MergePath) other;
        return this.equivHashCode() == that.equivHashCode() 
            && this.node == that.node 
            && this.all == that.all;
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
            int result = System.identityHashCode(node);
            hash = 31 * result + System.identityHashCode(all);
        }
        return hash;
    }

    public static final class Companion {
        private Companion() {}
    }
}