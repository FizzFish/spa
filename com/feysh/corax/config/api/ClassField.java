package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import kotlin.reflect.KProperty;
import kotlin.reflect.KCallable;
import com.feysh.corax.config.api.utils.UtilsKt;

public final class ClassField implements IClassField {
    @Nullable
    private final String declaringClassType;
    @NotNull
    private final String fieldName;
    @Nullable
    private final String fieldType;

    public ClassField(@Nullable String declaringClassType, @NotNull String fieldName, @Nullable String fieldType) {
        if (fieldName == null) {
            throw new IllegalArgumentException("fieldName must not be null");
        }
        this.declaringClassType = declaringClassType;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public ClassField(@NotNull KProperty<?> field) {
        if (field == null) {
            throw new IllegalArgumentException("field must not be null");
        }
        this(UtilsKt.getDeclaringClassName((KCallable)field), field.getName(), UtilsKt.getSootTypeName(field));
    }

    @Nullable
    public String getDeclaringClassType() {
        return declaringClassType;
    }

    @NotNull
    public String getFieldName() {
        return fieldName;
    }

    @Nullable
    public String getFieldType() {
        return fieldType;
    }

    @NotNull
    public String toString() {
        String classType = declaringClassType != null ? declaringClassType : "*";
        return "<" + classType + ": " + fieldType + " " + fieldName + ">";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ClassField)) return false;
        
        ClassField that = (ClassField) other;
        if (declaringClassType != null ? !declaringClassType.equals(that.declaringClassType) : that.declaringClassType != null) {
            return false;
        }
        if (!fieldName.equals(that.fieldName)) {
            return false;
        }
        return fieldType != null ? fieldType.equals(that.fieldType) : that.fieldType == null;
    }

    @Override
    public int hashCode() {
        int result = declaringClassType != null ? declaringClassType.hashCode() : 0;
        result = 31 * result + fieldName.hashCode();
        result = 31 * result + (fieldType != null ? fieldType.hashCode() : 0);
        return result;
    }

    @Nullable
    public String component1() {
        return declaringClassType;
    }

    @NotNull
    public String component2() {
        return fieldName;
    }

    @Nullable
    public String component3() {
        return fieldType;
    }

    @NotNull
    public ClassField copy(@Nullable String declaringClassType, @NotNull String fieldName, @Nullable String fieldType) {
        if (fieldName == null) {
            throw new IllegalArgumentException("fieldName must not be null");
        }
        return new ClassField(declaringClassType, fieldName, fieldType);
    }
}