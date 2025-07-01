package cn.sast.dataflow.interprocedural.override.lang.util;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Iterator;

public final class ListSpaceBuilder implements IData.Builder<IValue> {
    @NotNull
    private final PersistentList.Builder<IHeapValues<IValue>> list;
    @Nullable
    private IHeapValues.Builder<IValue> unreferenced;

    public ListSpaceBuilder(@NotNull PersistentList.Builder<IHeapValues<IValue>> list, 
                           @Nullable IHeapValues.Builder<IValue> unreferenced) {
        if (list == null) throw new IllegalArgumentException("list cannot be null");
        this.list = list;
        this.unreferenced = unreferenced;
    }

    @NotNull
    public PersistentList.Builder<IHeapValues<IValue>> getList() {
        return list;
    }

    @Override
    public void union(@NotNull AbstractHeapFactory<IValue> hf, @NotNull IData<IValue> that) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (that == null) throw new IllegalArgumentException("that cannot be null");
        if (!(that instanceof ListSpace)) {
            throw new IllegalArgumentException("Failed requirement.");
        }

        ListSpace other = (ListSpace) that;
        if (unreferenced != null) {
            IHeapValues.Builder builder = unreferenced;
            if (other.getUnreferenced() != null) {
                builder.add(other.getUnreferenced());
            } else {
                builder.add(other.getAllElement(hf));
            }
            return;
        }

        if (other.getUnreferenced() != null) {
            unreferenced = other.getUnreferenced().builder();
            unreferenced.add(getAllElement(hf));
            list.clear();
            return;
        }

        if (list.size() != other.getList().size()) {
            IHeapValues.Builder newUnreferenced = getAllElement(hf).builder();
            newUnreferenced.add(other.getAllElement(hf));
            unreferenced = newUnreferenced;
            list.clear();
            return;
        }

        Iterator<IHeapValues<IValue>> iterator = other.getList().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            IHeapValues<IValue> value = iterator.next();
            IHeapValues<IValue> existing = list.get(index);
            list.set(index, existing.plus(value));
            index++;
        }
    }

    private IHeapValues<IValue> getAllElement(AbstractHeapFactory<IValue> hf) {
        IHeapValues.Builder<IValue> res = hf.emptyBuilder();
        for (IHeapValues<IValue> element : list) {
            res.add(element);
        }
        if (unreferenced != null) {
            res.add(unreferenced.build());
        }
        return res.build();
    }

    @Override
    public void cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        if (re == null) throw new IllegalArgumentException("re cannot be null");

        PersistentList<IHeapValues<IValue>> oldMap = list.build();
        int index = 0;
        for (IHeapValues<IValue> value : oldMap) {
            list.set(index, value.cloneAndReNewObjects(re.context(new ReferenceContext.KVPosition(index)));
            index++;
        }

        if (unreferenced != null) {
            unreferenced.cloneAndReNewObjects(re.context(ReferenceContext.KVUnreferenced.INSTANCE));
        }
    }

    @Override
    @NotNull
    public IData<IValue> build() {
        IHeapValues<IValue> builtUnreferenced = null;
        if (unreferenced != null && !unreferenced.isEmpty()) {
            builtUnreferenced = unreferenced.build();
        }
        return new ListSpace(list.build(), builtUnreferenced);
    }

    public void add(@NotNull IHeapValues<IValue> value) {
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        if (unreferenced != null) {
            unreferenced.add(value);
        } else {
            list.add(value);
        }
    }

    public void clear(@NotNull IHeapValues<IValue> value) {
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        unreferenced = null;
        list.clear();
    }

    public void addAll(@NotNull AbstractHeapFactory<IValue> hf, @NotNull ListSpace b) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (b == null) throw new IllegalArgumentException("b cannot be null");
        if (unreferenced != null || b.getUnreferenced() != null) {
            union(hf, b);
        } else {
            list.addAll(b.getList());
        }
    }

    @NotNull
    public IHeapValues<IValue> remove(@NotNull AbstractHeapFactory<IValue> hf, @Nullable Integer index) {
        if (hf == null) throw new IllegalArgumentException("hf cannot be null");
        if (index == null) {
            if (unreferenced == null) {
                unreferenced = hf.emptyBuilder();
            }
            unreferenced.add(getAllElement(hf));
            list.clear();
            return unreferenced.build();
        }

        if (unreferenced == null) {
            if (index < 0 || index >= list.size()) {
                return getAllElement(hf);
            }
            return list.remove(index.intValue());
        }
        return getAllElement(hf);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ListSpaceBuilder)) return false;
        ListSpaceBuilder that = (ListSpaceBuilder) other;
        return list.equals(that.list) && 
               (unreferenced == null ? that.unreferenced == null : unreferenced.equals(that.unreferenced));
    }

    @Override
    public int hashCode() {
        int result = list.hashCode();
        result = 31 * result + (unreferenced != null ? unreferenced.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListSpaceBuilder(list=" + list + ", unreferenced=" + unreferenced + ")";
    }
}