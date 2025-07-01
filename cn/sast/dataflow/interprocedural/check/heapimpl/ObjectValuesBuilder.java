package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import org.jetbrains.annotations.NotNull;

public final class ObjectValuesBuilder implements IData.Builder<IValue> {
    @NotNull
    private final ObjectValues orig;
    @NotNull
    private final IHeapValues.Builder<IValue> values;

    public ObjectValuesBuilder(@NotNull ObjectValues orig, @NotNull IHeapValues.Builder<IValue> values) {
        if (orig == null) throw new IllegalArgumentException("orig cannot be null");
        if (values == null) throw new IllegalArgumentException("values cannot be null");
        this.orig = orig;
        this.values = values;
    }

    @NotNull
    public IHeapValues.Builder<IValue> getValues() {
        return values;
    }

    @Override
    public void union(@NotNull AbstractHeapFactory<IValue> hf, @NotNull IData<IValue> that) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (that == null) throw new IllegalArgumentException("that cannot be null");
        if (!(that instanceof ObjectValues)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        values.add(((ObjectValues) that).getValues());
    }

    @Override
    public void cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        if (re == null) throw new IllegalArgumentException("re cannot be null");
        values.cloneAndReNewObjects(re);
    }

    public void addAll(@NotNull IHeapValues<IValue> values) {
        if (values == null) throw new IllegalArgumentException("values cannot be null");
        this.values.add(values);
    }

    @Override
    @NotNull
    public ObjectValues build() {
        IHeapValues<IValue> builtValues = values.build();
        if (orig.getValues().equals(builtValues)) {
            return orig;
        }
        return new ObjectValues(builtValues);
    }

    @Override
    @NotNull
    public String toString() {
        return values.toString();
    }
}