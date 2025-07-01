package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CompanionValueOfConst extends CompanionV<IValue> implements PathCompanionV {
    @NotNull
    private final IPath path;
    @NotNull
    private final IValue attr;

    public CompanionValueOfConst(@NotNull IValue value, @NotNull IPath path, @NotNull IValue attr) {
        super(value);
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        if (path == null) throw new IllegalArgumentException("path cannot be null");
        if (attr == null) throw new IllegalArgumentException("attr cannot be null");
        if (!(value instanceof ConstVal)) {
            throw new IllegalStateException(String.valueOf(value));
        }
        this.path = path;
        this.attr = attr;
    }

    @Override
    @NotNull
    public IPath getPath() {
        return path;
    }

    @NotNull
    public IValue getAttr() {
        return attr;
    }

    @Override
    @NotNull
    public CompanionV<IValue> copy(@NotNull IValue updateValue) {
        if (updateValue == null) throw new IllegalArgumentException("updateValue cannot be null");
        return new CompanionValueOfConst(updateValue, path, attr);
    }

    @Override
    @NotNull
    public CompanionV<IValue> union(@NotNull CompanionV<IValue> other) {
        if (other == null) throw new IllegalArgumentException("other cannot be null");
        if (!getValue().equals(other.getValue())) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        IPath mergedPath = MergePath.Companion.v(new HeapValuesEnvImpl(getPath()), getPath(), ((PathCompanionV)other).getPath());
        return new CompanionValueOfConst(getValue(), mergedPath, attr);
    }

    @Override
    @NotNull
    public String toString() {
        return "<v=" + getValue() + ", attr=" + attr + ">";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        if (!(other instanceof CompanionValueOfConst)) {
            return false;
        }
        return attr.equals(((CompanionValueOfConst)other).attr);
    }

    @Override
    public int computeHash() {
        int result = super.computeHash();
        result = 31 * result + attr.hashCode();
        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}