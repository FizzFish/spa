package cn.sast.dataflow.infoflow.svfa;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.NullType;
import soot.SootField;
import soot.Type;
import soot.Value;
import soot.jimple.internal.JimpleLocal;

public final class AP {
    @NotNull
    private final Value value;
    @Nullable
    private final SootField field;
    private static final Value staticValue = new JimpleLocal("staticValueFake", NullType.v());

    public AP(@NotNull Value value, @Nullable SootField field) {
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        this.value = value;
        this.field = field;
    }

    public AP(@NotNull Value value) {
        this(value, null);
    }

    @NotNull
    public Value getValue() {
        return value;
    }

    @Nullable
    public SootField getField() {
        return field;
    }

    @NotNull
    public AP base() {
        return field == null ? this : new AP(value);
    }

    @Override
    public String toString() {
        return field != null ? value + "." + field.getName() : String.valueOf(value);
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (field != null ? field.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof AP)) return false;
        AP ap = (AP) other;
        return value.equals(ap.value) && 
               (field == null ? ap.field == null : field.equals(ap.field));
    }

    public static Value getStaticValue() {
        return staticValue;
    }
}