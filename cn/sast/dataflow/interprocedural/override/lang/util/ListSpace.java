package cn.sast.dataflow.interprocedural.override.lang.util;

import cn.sast.dataflow.interprocedural.analysis.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ListSpace implements IData<IValue> {
    @NotNull
    private final PersistentList<IHeapValues<IValue>> list;
    @Nullable
    private final IHeapValues<IValue> unreferenced;
    @Nullable
    private Integer hashCode;

    public ListSpace(@NotNull PersistentList<? extends IHeapValues<IValue>> list, 
                     @Nullable IHeapValues<IValue> unreferenced) {
        Objects.requireNonNull(list, "list");
        this.list = list;
        this.unreferenced = unreferenced;
        if (unreferenced != null && unreferenced.isEmpty()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public ListSpace() {
        this(PersistentList.empty(), null);
    }

    @NotNull
    public PersistentList<IHeapValues<IValue>> getList() {
        return list;
    }

    @Nullable
    public IHeapValues<IValue> getUnreferenced() {
        return unreferenced;
    }

    @Override
    public void reference(@NotNull Collection<IValue> res) {
        Objects.requireNonNull(res, "res");
        for (IHeapValues<IValue> e : list) {
            e.reference(res);
        }
    }

    @Override
    @NotNull
    public ListSpaceBuilder builder() {
        return new ListSpaceBuilder(
            list.builder(), 
            unreferenced != null ? unreferenced.builder() : null
        );
    }

    @Override
    public int computeHash() {
        int result = 1;
        result = 31 * result + list.hashCode();
        result = 31 * result + (unreferenced != null ? unreferenced.hashCode() : 0);
        return result + 1231;
    }

    @Override
    public void diff(@NotNull IDiff<IValue> cmp, @NotNull IDiffAble<?> that) {
        Objects.requireNonNull(cmp, "cmp");
        Objects.requireNonNull(that, "that");
        
        if (this == that) return;
        if (!(that instanceof ListSpace)) return;
        
        ListSpace other = (ListSpace) that;
        Iterator<IHeapValues<IValue>> iterator = list.iterator();
        int index = 0;
        
        while (iterator.hasNext()) {
            IHeapValues<IValue> l = iterator.next();
            if (index >= other.list.size()) break;
            l.diff(cmp, other.list.get(index++));
        }
        
        if (other.unreferenced != null && unreferenced != null) {
            unreferenced.diff(cmp, other.unreferenced);
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
        if (this == other) return true;
        if (!(other instanceof ListSpace)) return false;
        
        ListSpace that = (ListSpace) other;
        return hashCode() == that.hashCode() &&
               list.equals(that.list) &&
               Objects.equals(unreferenced, that.unreferenced);
    }

    @NotNull
    public IHeapValues<IValue> getAllElement(@NotNull AbstractHeapFactory<IValue> hf) {
        Objects.requireNonNull(hf, "hf");
        IHeapValues.Builder<IValue> res = hf.emptyBuilder();
        
        for (IHeapValues<IValue> it : list) {
            res.add(it);
        }
        
        if (unreferenced != null) {
            res.add(unreferenced);
        }
        
        return res.build();
    }

    @Nullable
    public IHeapValues<IValue> get(@NotNull AbstractHeapFactory<IValue> hf, @Nullable Integer index) {
        Objects.requireNonNull(hf, "hf");
        if (index == null || unreferenced != null) {
            return getAllElement(hf);
        }
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    @Override
    @NotNull
    public IData<IValue> cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        Objects.requireNonNull(re, "re");
        ListSpaceBuilder b = builder();
        b.cloneAndReNewObjects(re);
        return b.build();
    }

    @NotNull
    public PersistentList<IHeapValues<IValue>> component1() {
        return list;
    }

    @Nullable
    public IHeapValues<IValue> component2() {
        return unreferenced;
    }

    @NotNull
    public ListSpace copy(@NotNull PersistentList<? extends IHeapValues<IValue>> list,
                          @Nullable IHeapValues<IValue> unreferenced) {
        Objects.requireNonNull(list, "list");
        return new ListSpace(list, unreferenced);
    }

    @Override
    public String toString() {
        return "ListSpace(list=" + list + ", unreferenced=" + unreferenced + ")";
    }
}
