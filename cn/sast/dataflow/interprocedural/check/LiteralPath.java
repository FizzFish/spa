package cn.sast.dataflow.interprocedural.check;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

public final class LiteralPath extends IPath {
    @NotNull
    private final Unit node;
    @NotNull
    private final Object constValue;
    @Nullable
    private Integer hash;

    private LiteralPath(@NotNull Unit node, @NotNull Object constValue) {
        super(null);
        this.node = node;
        this.constValue = constValue;
    }

    public static LiteralPath create(@NotNull Unit node, @NotNull Object constValue) {
        return new LiteralPath(node, constValue);
    }

    @Override
    @NotNull
    public Unit getNode() {
        return node;
    }

    @NotNull
    public Object getConst() {
        return constValue;
    }

    @Override
    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiteralPath)) {
            return false;
        }
        LiteralPath that = (LiteralPath) other;
        return this.equivHashCode() == that.equivHashCode() 
            && this.getNode() == that.getNode()
            && this.constValue.equals(that.constValue);
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
            hash = 31 * result + constValue.hashCode();
        }
        return hash;
    }
}