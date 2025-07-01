package cn.sast.dataflow.infoflow.svfa;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;
import soot.Value;

public final class VFNode {
    @NotNull
    private final Value ap;
    @NotNull
    private final Unit stmt;

    public VFNode(@NotNull Value ap, @NotNull Unit stmt) {
        if (ap == null) throw new NullPointerException("ap");
        if (stmt == null) throw new NullPointerException("stmt");
        this.ap = ap;
        this.stmt = stmt;
    }

    @NotNull
    public Value getAp() {
        return ap;
    }

    @NotNull
    public Unit getStmt() {
        return stmt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ap, stmt);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof VFNode)) return false;
        VFNode that = (VFNode) other;
        return Objects.equals(ap, that.ap) && Objects.equals(stmt, that.stmt);
    }

    @Override
    @NotNull
    public String toString() {
        return ap + " " + stmt;
    }
}