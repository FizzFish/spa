package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IFieldMatch;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.Type;
import soot.util.Chain;

public final class SootFieldSignatureMatch implements IFieldMatch {
    @NotNull
    private final String declaringClassType;
    @NotNull
    private final String fieldName;
    @Nullable
    private final String fieldType;
    @Nullable
    private final Boolean isStatic;

    public SootFieldSignatureMatch(@NotNull String declaringClassType, @NotNull String fieldName, 
                                 @Nullable String fieldType, @Nullable Boolean isStatic) {
        if (declaringClassType == null) throw new IllegalArgumentException("declaringClassType cannot be null");
        if (fieldName == null) throw new IllegalArgumentException("fieldName cannot be null");
        this.declaringClassType = declaringClassType;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.isStatic = isStatic;
    }

    public SootFieldSignatureMatch(@NotNull SootField sf) {
        if (sf == null) throw new IllegalArgumentException("sf cannot be null");
        String declaringClass = sf.getDeclaringClass().getName();
        String name = sf.getName();
        Type type = sf.getType();
        String typeName = UtilsKt.getTypename(type);
        if (typeName == null) {
            typeName = "unknown";
        }
        this(declaringClass, name, typeName, sf.isStatic());
    }

    public SootFieldSignatureMatch(@NotNull KProperty<?> sf) {
        if (sf == null) throw new IllegalArgumentException("sf cannot be null");
        String declaringClass = UtilsKt.getDeclaringClass(sf).getName();
        this(declaringClass, sf.getName(), UtilsKt.getSootTypeName(sf), null);
    }

    @Override
    @NotNull
    public String getDeclaringClassType() {
        return declaringClassType;
    }

    @Override
    @NotNull
    public String getFieldName() {
        return fieldName;
    }

    @Override
    @Nullable
    public String getFieldType() {
        return fieldType;
    }

    @Override
    @Nullable
    public Boolean isStatic() {
        return isStatic;
    }

    @Override
    @NotNull
    public List<SootField> matched(@NotNull Scene scene) {
        if (scene == null) throw new IllegalArgumentException("scene cannot be null");

        SootClass sootClass = scene.getSootClassUnsafe(getDeclaringClassType(), false);
        if (sootClass == null) {
            return List.of();
        }

        return sootClass.getFields().stream()
                .filter(this::match)
                .collect(Collectors.toList());
    }

    private boolean match(SootField field) {
        if (!fieldName.equals(field.getName())) {
            return false;
        }
        if (!declaringClassType.equals(field.getDeclaringClass().getName())) {
            return false;
        }
        if (isStatic != null && !isStatic.equals(field.isStatic())) {
            return false;
        }
        if (fieldType != null) {
            Type type = field.getType();
            String actualTypeName = UtilsKt.getTypename(type);
            if (!fieldType.equals(actualTypeName)) {
                return false;
            }
        }
        return true;
    }

    @Override
    @NotNull
    public String toString() {
        return "<" + declaringClassType + ": " + fieldType + " " + fieldName + ">";
    }
}
