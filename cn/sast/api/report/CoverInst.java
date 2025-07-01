package cn.sast.api.report;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;

public final class CoverInst extends CoverSootCode {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final Unit unit;

    public CoverInst(@NotNull SootMethod method, @NotNull Unit unit) {
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        if (unit == null) throw new IllegalArgumentException("unit cannot be null");
        super(method, unit, null);
        this.method = method;
        this.unit = unit;
    }

    @Override
    @NotNull
    public SootMethod getMethod() {
        return method;
    }

    @Override
    @NotNull
    public Unit getUnit() {
        return unit;
    }

    @NotNull
    public CoverInst copy(@NotNull SootMethod method, @NotNull Unit unit) {
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        if (unit == null) throw new IllegalArgumentException("unit cannot be null");
        return new CoverInst(method, unit);
    }

    @Override
    public String toString() {
        return "CoverInst(method=" + method + ", unit=" + unit + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof CoverInst)) return false;
        CoverInst coverInst = (CoverInst) other;
        return method.equals(coverInst.method) && unit.equals(coverInst.unit);
    }

    @Override
    public int hashCode() {
        int result = method.hashCode();
        result = 31 * result + unit.hashCode();
        return result;
    }
}