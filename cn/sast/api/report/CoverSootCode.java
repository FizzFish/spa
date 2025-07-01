package cn.sast.api.report;

import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;

public abstract class CoverSootCode extends CoverData {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final Unit unit;

    protected CoverSootCode(@NotNull SootMethod method, @NotNull Unit unit) {
        super(null);
        this.method = method;
        this.unit = unit;
    }

    @NotNull
    public SootMethod getMethod() {
        return method;
    }

    @NotNull
    public Unit getUnit() {
        return unit;
    }

    @NotNull
    public final SootClass getClazz() {
        return method.getDeclaringClass();
    }

    @NotNull
    public final String getClassName() {
        return getClazz().getName();
    }

    public final int getLineNumber() {
        return unit.getJavaSourceStartLineNumber();
    }
}