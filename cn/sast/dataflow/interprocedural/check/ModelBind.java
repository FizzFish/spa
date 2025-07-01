package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.ModelingStmtInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

public final class ModelBind extends IPath {
    @NotNull
    private final Unit node;
    @NotNull
    private final IValue obj;
    @NotNull
    private final Object mt;
    @NotNull
    private final Object data;
    @Nullable
    private final ModelingStmtInfo info;
    @NotNull
    private final IPath prev;
    @Nullable
    private Integer hash;

    ModelBind(@NotNull Unit node, @NotNull IValue obj, @NotNull Object mt, 
             @NotNull Object data, @Nullable ModelingStmtInfo info, @NotNull IPath prev) {
        super(null);
        this.node = node;
        this.obj = obj;
        this.mt = mt;
        this.data = data;
        this.info = info;
        this.prev = prev;
    }

    @Override
    @NotNull
    public Unit getNode() {
        return node;
    }

    @NotNull
    public IValue getObj() {
        return obj;
    }

    @NotNull
    public Object getMt() {
        return mt;
    }

    @NotNull
    public Object getData() {
        return data;
    }

    @Nullable
    public ModelingStmtInfo getInfo() {
        return info;
    }

    @NotNull
    public IPath getPrev() {
        return prev;
    }

    @Override
    public boolean equivTo(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof ModelBind)) return false;
        
        ModelBind that = (ModelBind) other;
        if (this.equivHashCode() != that.equivHashCode()) return false;
        if (!this.node.equals(that.node)) return false;
        if (!this.obj.equals(that.obj)) return false;
        if (!this.mt.equals(that.mt)) return false;
        if (!this.data.equals(that.data)) return false;
        if (this.info != null ? !this.info.equals(that.info) : that.info != null) return false;
        return this.prev.equals(that.prev);
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
            int result = System.identityHashCode(node);
            result = 31 * result + obj.hashCode();
            result = 31 * result + mt.hashCode();
            result = 31 * result + data.hashCode();
            result = 31 * result + (info != null ? info.hashCode() : 0);
            hash = 31 * result + prev.hashCode();
        }
        return hash;
    }
}