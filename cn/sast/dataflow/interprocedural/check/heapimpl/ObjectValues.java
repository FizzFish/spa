package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ObjectValues implements IData<IValue> {
    @NotNull
    private final IHeapValues<IValue> values;
    @Nullable
    private Integer hashCode;

    public ObjectValues(@NotNull IHeapValues<IValue> values) {
        if (values == null) {
            throw new IllegalArgumentException("values must not be null");
        }
        this.values = values;
    }

    @NotNull
    public IHeapValues<IValue> getValues() {
        return values;
    }

    public void reference(@NotNull Collection<IValue> res) {
        if (res == null) {
            throw new IllegalArgumentException("res must not be null");
        }
        values.reference(res);
    }

    @NotNull
    public ObjectValuesBuilder builder() {
        return new ObjectValuesBuilder(this, values.builder());
    }

    public int computeHash() {
        return values.hashCode();
    }

    public void diff(@NotNull IDiff<IValue> cmp, @NotNull IDiffAble<?> that) {
        if (cmp == null) {
            throw new IllegalArgumentException("cmp must not be null");
        }
        if (that == null) {
            throw new IllegalArgumentException("that must not be null");
        }
        if (that instanceof ObjectValues) {
            values.diff(cmp, ((ObjectValues) that).values);
        }
    }

    @Override
    public int hashCode() {
        if (hashCode == null) {
            hashCode = computeHash();
        }
        return hashCode;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ObjectValues)) {
            return false;
        }
        ObjectValues that = (ObjectValues) other;
        return hashCode() == that.hashCode() && values.equals(that.values);
    }

    @NotNull
    public IData<IValue> cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        if (re == null) {
            throw new IllegalArgumentException("re must not be null");
        }
        ObjectValuesBuilder b = builder();
        b.cloneAndReNewObjects(re);
        return b.build();
    }

    @Override
    @NotNull
    public String toString() {
        return values.toString();
    }
}