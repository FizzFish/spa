package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.JFieldNameType;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import com.feysh.corax.config.api.ClassField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootField;
import soot.Type;

public final class FieldUtil {
    public static final FieldUtil INSTANCE = new FieldUtil();

    private FieldUtil() {
    }

    @NotNull
    public JSootFieldType of(@NotNull SootField field) {
        if (field == null) {
            throw new NullPointerException("field is null");
        }
        return new JSootFieldType(field);
    }

    @Nullable
    public JFieldNameType of(@NotNull ClassField field) {
        if (field == null) {
            throw new NullPointerException("field is null");
        }

        String fieldType = field.getFieldType();
        Type type = fieldType != null ? Scene.v().getTypeUnsafe(fieldType, true) : null;
        if (type == null) {
            type = Scene.v().getObjectType();
        }

        String fieldName = field.getFieldName();
        return new JFieldNameType(fieldName, type);
    }

    @NotNull
    public Type typeOf(@NotNull JFieldType field) {
        if (field == null) {
            throw new NullPointerException("field is null");
        }
        return field.getType();
    }

    @NotNull
    public String nameOf(@NotNull JFieldType field) {
        if (field == null) {
            throw new NullPointerException("field is null");
        }
        return field.getName();
    }
}