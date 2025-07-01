package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

public final class SetEdgePath extends IPath {
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

    SetEdgePath(@NotNull Unit node, @NotNull IValue heapObject, @NotNull IPath heapObjectPath, 
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
    public final IValue getHeapObject() {
        return heapObject;
    }

    @NotNull
    public final IPath getHeapObjectPath() {
        return heapObjectPath;
    }

    @NotNull
    public final Object getMt() {
        return mt;
    }

    @Nullable
    public final Object getKey() {
        return key;
    }

    @NotNull
    public final IValue getValue() {
        return value;
    }

    @NotNull
    public final IPath getValuePath() {
        return valuePath;
    }

    @Nullable
    public final Object getInfo() {
        return info;
    }

    @Override
    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetEdgePath)) {
            return false;
        }
        SetEdgePath that = (SetEdgePath) other;
        if (this.equivHashCode() != that.equivHashCode()) {
            return false;
        }
        if (this.getNode() != that.getNode()) {
            return false;
        }
        if (!this.heapObject.equals(that.heapObject)) {
            return false;
        }
        if (this.heapObjectPath != that.heapObjectPath) {
            return false;
        }
        if (!this.mt.equals(that.mt)) {
            return false;
        }
        if (this.key != null ? !this.key.equals(that.key) : that.key != null) {
            return false;
        }
        if (!this.value.equals(that.value)) {
            return false;
        }
        if (this.valuePath != that.valuePath) {
            return false;
        }
        return this.info != null ? this.info.equals(that.info) : that.info == null;
    }

    @Nullable
    public final Integer getHash() {
        return hash;
    }

    public final void setHash(@Nullable Integer hash) {
        this.hash = hash;
    }

    @Override
    public int equivHashCode() {
        if (hash == null) {
            int result = System.identityHashCode(node);
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