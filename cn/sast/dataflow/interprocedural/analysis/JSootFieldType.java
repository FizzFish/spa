package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import soot.Type;

public final class JSootFieldType extends JFieldType {
    @NotNull
    private final SootField sootField;

    public JSootFieldType(@NotNull SootField sootField) {
        if (sootField == null) {
            throw new IllegalArgumentException("sootField cannot be null");
        }
        super(null);
        this.sootField = sootField;
    }

    @NotNull
    public SootField getSootField() {
        return sootField;
    }

    @Override
    @NotNull
    public Type getType() {
        return sootField.getType();
    }

    @Override
    @NotNull
    public String getName() {
        return sootField.getName();
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!(other instanceof JFieldType)) {
            return false;
        }
        return getName().equals(((JFieldType) other).getName());
    }

    @Override
    @NotNull
    public String toString() {
        return getName();
    }
}