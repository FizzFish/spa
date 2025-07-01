package cn.sast.api.report;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;

public final class CoverTaint extends CoverSootCode {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final Unit unit;
    @NotNull
    private final Object value;

    public CoverTaint(@NotNull SootMethod method, @NotNull Unit unit, @NotNull Object value) {
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        if (unit == null) throw new IllegalArgumentException("unit cannot be null");
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        
        super(method, unit, null);
        this.method = method;
        this.unit = unit;
        this.value = value;
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
    public Object getValue() {
        return value;
    }

    @NotNull
    public CoverTaint copy(@NotNull SootMethod method, @NotNull Unit unit, @NotNull Object value) {
        return new CoverTaint(method, unit, value);
    }

    @Override
    public String toString() {
        return "CoverTaint(method=" + method + ", unit=" + unit + ", value=" + value + ")";
    }

    @Override
    public int hashCode() {
        int result = method.hashCode();
        result = 31 * result + unit.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof CoverTaint)) return false;
        
        CoverTaint that = (CoverTaint) other;
        return method.equals(that.method) && 
               unit.equals(that.unit) && 
               value.equals(that.value);
    }
}