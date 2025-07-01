package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;
import soot.jimple.Constant;
import soot.jimple.NullConstant;

public final class ConstVal implements IValue {
    @NotNull
    private final Constant v;
    @NotNull
    private final Type type;
    @Nullable
    private Integer hash;

    private ConstVal(@NotNull Constant v, @NotNull Type type) {
        this.v = v;
        this.type = type;
    }

    public static ConstVal create(@NotNull Constant v) {
        return new ConstVal(v, v.getType());
    }

    public static ConstVal create(@NotNull Constant v, @NotNull Type type) {
        return new ConstVal(v, type);
    }

    @NotNull
    public Constant getV() {
        return v;
    }

    @Override
    @NotNull
    public Type getType() {
        return type;
    }

    @Override
    @NotNull
    public String toString() {
        return "const_" + getType() + "_" + v;
    }

    @Override
    public boolean typeIsConcrete() {
        return true;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ConstVal)) return false;
        ConstVal that = (ConstVal) other;
        return v.equals(that.v) && type.equals(that.type);
    }

    @Nullable
    public Integer getHash() {
        return hash;
    }

    public void setHash(@Nullable Integer hash) {
        this.hash = hash;
    }

    @Override
    public int hashCode() {
        if (hash == null) {
            int result = v.hashCode();
            hash = 31 * result + type.hashCode();
        }
        return hash;
    }

    @Override
    public boolean isNullConstant() {
        return v instanceof NullConstant;
    }

    @Override
    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Normal;
    }

    @Override
    public boolean isNormal() {
        return true;
    }
}