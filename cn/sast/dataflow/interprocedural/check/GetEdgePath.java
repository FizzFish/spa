package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.IPath;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

public final class GetEdgePath extends IPath {
    @NotNull
    private final Unit node;
    @NotNull
    private final IValue heapObject;
    @NotNull
    private final IPath heapObjectPath;
    @NotNull
    private final Object mt;
    @Nullable
    private final Object key;
    @NotNull
    private final IValue value;
    @NotNull
    private final IPath valuePath;
    @Nullable
    private final Object info;
    @Nullable
    private Integer hash;

    GetEdgePath(@NotNull Unit node, @NotNull IValue heapObject, @NotNull IPath heapObjectPath, 
               @NotNull Object mt, @Nullable Object key, @NotNull IValue value, 
               @NotNull IPath valuePath, @Nullable Object info) {
        this.node = node;
        this.heapObject = heapObject;
        this.heapObjectPath = heapObjectPath;
        this.mt = mt;
        this.key = key;
        this.value = value;
        this.valuePath = valuePath;
        this.info = info;
    }

    @Override
    @NotNull
    public Unit getNode() {
        return node;
    }

    @NotNull
    public IValue getHeapObject() {
        return heapObject;
    }

    @NotNull
    public IPath getHeapObjectPath() {
        return heapObjectPath;
    }

    @NotNull
    public Object getMt() {
        return mt;
    }

    @Nullable
    public Object getKey() {
        return key;
    }

    @NotNull
    public IValue getValue() {
        return value;
    }

    @NotNull
    public IPath getValuePath() {
        return valuePath;
    }

    @Nullable
    public Object getInfo() {
        return info;
    }

    @Override
    public boolean equivTo(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof GetEdgePath)) return false;
        
        GetEdgePath that = (GetEdgePath) other;
        return equivHashCode() == that.equivHashCode() &&
               getNode() == that.getNode() &&
               heapObject.equals(that.heapObject) &&
               heapObjectPath == that.heapObjectPath &&
               mt.equals(that.mt) &&
               (key == null ? that.key == null : key.equals(that.key)) &&
               value.equals(that.value) &&
               valuePath == that.valuePath &&
               (info == null ? that.info == null : info.equals(that.info));
    }

    @Nullable
    public Integer getHash() {
        return hash;
    }

    public void setHash(@Nullable Integer hash) {
        this.hash = hash;
    }

    @Override
    public int equivHashCode() {
        if (hash == null) {
            int result = System.identityHashCode(getNode());
            result = 31 * result + heapObject.hashCode();
            result = 31 * result + heapObjectPath.hashCode();
            result = 31 * result + mt.hashCode();
            result = 31 * result + (key != null ? key.hashCode() : 0);
            result = 31 * result + value.hashCode();
            result = 31 * result + valuePath.hashCode();
            hash = 31 * result + (info != null ? info.hashCode() : 0);
        }
        return hash;
    }
}