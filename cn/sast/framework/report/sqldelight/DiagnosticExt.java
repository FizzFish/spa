package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DiagnosticExt {
    private final long __diagnostic_id;
    @NotNull
    private final String attr_name;
    @NotNull
    private final String attr_value;

    public DiagnosticExt(long __diagnostic_id, @NotNull String attr_name, @NotNull String attr_value) {
        if (attr_name == null) {
            throw new IllegalArgumentException("attr_name must not be null");
        }
        if (attr_value == null) {
            throw new IllegalArgumentException("attr_value must not be null");
        }
        this.__diagnostic_id = __diagnostic_id;
        this.attr_name = attr_name;
        this.attr_value = attr_value;
    }

    public long get__diagnostic_id() {
        return __diagnostic_id;
    }

    @NotNull
    public String getAttr_name() {
        return attr_name;
    }

    @NotNull
    public String getAttr_value() {
        return attr_value;
    }

    @NotNull
    public DiagnosticExt copy(long __diagnostic_id, @NotNull String attr_name, @NotNull String attr_value) {
        if (attr_name == null) {
            throw new IllegalArgumentException("attr_name must not be null");
        }
        if (attr_value == null) {
            throw new IllegalArgumentException("attr_value must not be null");
        }
        return new DiagnosticExt(__diagnostic_id, attr_name, attr_value);
    }

    @Override
    public String toString() {
        return "DiagnosticExt(__diagnostic_id=" + __diagnostic_id + 
               ", attr_name=" + attr_name + 
               ", attr_value=" + attr_value + ")";
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(__diagnostic_id);
        result = 31 * result + attr_name.hashCode();
        result = 31 * result + attr_value.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiagnosticExt)) {
            return false;
        }
        DiagnosticExt that = (DiagnosticExt) other;
        return __diagnostic_id == that.__diagnostic_id &&
               attr_name.equals(that.attr_name) &&
               attr_value.equals(that.attr_value);
    }
}