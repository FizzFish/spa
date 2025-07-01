package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;

public final class JFieldNameType extends JFieldType {
    @NotNull
    private final String fieldName;
    @NotNull
    private final Type type;

    public JFieldNameType(@NotNull String fieldName, @NotNull Type type) {
        if (fieldName == null) {
            throw new IllegalArgumentException("fieldName cannot be null");
        }
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        super(null);
        this.fieldName = fieldName;
        this.type = type;
    }

    @NotNull
    public String getFieldName() {
        return fieldName;
    }

    @Override
    @NotNull
    public Type getType() {
        return type;
    }

    @Override
    @NotNull
    public String getName() {
        return fieldName;
    }

    @Override
    @NotNull
    public String toString() {
        return getName();
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
        JFieldType jFieldType = (JFieldType) other;
        return getName().equals(jFieldType.getName());
    }
}