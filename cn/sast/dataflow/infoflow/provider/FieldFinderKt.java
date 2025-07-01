package cn.sast.dataflow.infoflow.provider;

import com.feysh.corax.config.api.ClassField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.Type;

public final class FieldFinderKt {
    @Nullable
    public static SootField getSootField(@NotNull ClassField classField) {
        if (classField == null) {
            throw new NullPointerException("classField is null");
        }

        String declaringClassType = classField.getDeclaringClassType();
        if (declaringClassType == null) {
            return null;
        }

        SootClass sootClass = Scene.v().getSootClassUnsafe(declaringClassType, false);
        if (sootClass == null) {
            return null;
        }

        if (classField.getFieldType() == null) {
            return sootClass.getFieldByNameUnsafe(classField.getFieldName());
        }

        Type type = Scene.v().getTypeUnsafe(classField.getFieldType());
        if (type == null) {
            return sootClass.getFieldByNameUnsafe(classField.getFieldName());
        }

        return sootClass.getFieldUnsafe(classField.getFieldName(), type);
    }
}