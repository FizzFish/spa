package cn.sast.dataflow.interprocedural.check;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

public final class AssignLocalPath extends IPath {
    @NotNull
    private final Unit node;
    @NotNull
    private final Object lhs;
    @NotNull
    private final String rhsValue;
    @NotNull
    private final IPath rhsValePath;
    @Nullable
    private Integer hash;

    private AssignLocalPath(@NotNull Unit node, @NotNull Object lhs, @NotNull String rhsValue, @NotNull IPath rhsValePath) {
        super();
        this.node = node;
        this.lhs = lhs;
        this.rhsValue = rhsValue;
        this.rhsValePath = rhsValePath;
    }

    @NotNull
    public static AssignLocalPath create(@NotNull Unit node, @NotNull Object lhs, @NotNull String rhsValue, @NotNull IPath rhsValePath) {
        return new AssignLocalPath(node, lhs, rhsValue, rhsValePath);
    }

    @Override
    @NotNull
    public Unit getNode() {
        return node;
    }

    @NotNull
    public Object getLhs() {
        return lhs;
    }

    @NotNull
    public String getRhsValue() {
        return rhsValue;
    }

    @NotNull
    public IPath getRhsValePath() {
        return rhsValePath;
    }

    @Override
    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssignLocalPath)) {
            return false;
        }
        AssignLocalPath that = (AssignLocalPath) other;
        return equivHashCode() == that.equivHashCode() &&
               getNode() == that.getNode() &&
               lhs.equals(that.lhs) &&
               rhsValue.equals(that.rhsValue) &&
               rhsValePath == that.rhsValePath;
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
            int result = System.identityHashCode(getNode());
            result = 31 * result + lhs.hashCode();
            result = 31 * result + rhsValue.hashCode();
            result = 31 * result + rhsValePath.hashCode();
            hash = result;
        }
        return hash;
    }
}