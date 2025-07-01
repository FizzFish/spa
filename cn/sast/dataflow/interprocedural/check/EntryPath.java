package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import cn.sast.dataflow.interprocedural.check.IPath;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;
import java.util.Objects;

public final class EntryPath extends IPath {
    @NotNull
    private final Unit node;
    @NotNull
    private final PersistentList<ReferenceContext> special;
    @Nullable
    private Integer hash;

    private EntryPath(@NotNull PersistentList<? extends ReferenceContext> special, @NotNull Unit node) {
        this.node = node;
        this.special = IPath.specialInterner(special);
    }

    public static EntryPath create(@NotNull PersistentList<? extends ReferenceContext> special, @NotNull Unit node) {
        return new EntryPath(special, node);
    }

    @Override
    @NotNull
    public Unit getNode() {
        return node;
    }

    @NotNull
    public PersistentList<ReferenceContext> getSpecial() {
        return special;
    }

    @Override
    @NotNull
    public String toString() {
        return String.join(":", special) + " " + node;
    }

    @Override
    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntryPath)) {
            return false;
        }
        EntryPath that = (EntryPath) other;
        return equivHashCode() == that.equivHashCode() 
            && node == that.node 
            && special == that.special;
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
            hash = 31 * result + System.identityHashCode(special);
        }
        return hash;
    }
}