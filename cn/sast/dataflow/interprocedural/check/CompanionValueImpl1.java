package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import org.jetbrains.annotations.NotNull;

public final class CompanionValueImpl1 extends CompanionV<IValue> implements PathCompanionV {
    @NotNull
    private final IPath path;

    public CompanionValueImpl1(@NotNull IValue value, @NotNull IPath path) {
        super(value);
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        if (path == null) throw new IllegalArgumentException("path cannot be null");
        this.path = path;
    }

    @Override
    @NotNull
    public IPath getPath() {
        return path;
    }

    @Override
    @NotNull
    public CompanionV<IValue> union(@NotNull CompanionV<IValue> other) {
        if (other == null) throw new IllegalArgumentException("other cannot be null");
        if (!getValue().equals(other.getValue())) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        IPath mergedPath = MergePath.Companion.v(new HeapValuesEnvImpl(getPath()), getPath(), ((PathCompanionV)other).getPath());
        return new CompanionValueImpl1(getValue(), mergedPath);
    }

    @Override
    @NotNull
    public String toString() {
        return "<" + getValue() + ">";
    }

    @Override
    @NotNull
    public CompanionV<IValue> copy(@NotNull IValue updateValue) {
        if (updateValue == null) throw new IllegalArgumentException("updateValue cannot be null");
        return new CompanionValueImpl1(updateValue, getPath());
    }
}