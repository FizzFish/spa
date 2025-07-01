package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;

public interface IValue {
    @NotNull
    Type getType();

    boolean typeIsConcrete();

    boolean isNullConstant();

    @NotNull
    Kind getKind();

    default boolean isNormal() {
        return true;
    }

    @Nullable
    default Boolean objectEqual(@NotNull IValue b) {
        return null;
    }

    @NotNull
    default IValue clone() {
        return this.copy(getType());
    }

    @NotNull
    IValue copy(@NotNull Type type);

    enum Kind {
        NORMAL,
        NULL_CONSTANT,
        UNKNOWN
    }
}