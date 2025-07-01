package cn.sast.dataflow.interprocedural.check;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;

public final class InvokeEdgePath extends IPath {
    @NotNull
    private final Unit node;
    @NotNull
    private final IPath path;
    @NotNull
    private final SootMethod container;
    @NotNull
    private final SootMethod callee;
    @NotNull
    private final Map<IPath, EntryPath> interproceduralPathMap;
    @Nullable
    private Integer hash;

    InvokeEdgePath(@NotNull Unit node, @NotNull Map<IPath, EntryPath> interproceduralPathMap, 
                  @NotNull IPath path, @NotNull SootMethod container, @NotNull SootMethod callee) {
        super(null);
        this.node = node;
        this.path = path;
        this.container = container;
        this.callee = callee;
        this.interproceduralPathMap = PathCompanionKt.getShort(interproceduralPathMap);
    }

    @Override
    @NotNull
    public Unit getNode() {
        return node;
    }

    @NotNull
    public IPath getPath() {
        return path;
    }

    @NotNull
    public SootMethod getContainer() {
        return container;
    }

    @NotNull
    public SootMethod getCallee() {
        return callee;
    }

    @NotNull
    public Map<IPath, EntryPath> getInterproceduralPathMap() {
        return interproceduralPathMap;
    }

    @Override
    @NotNull
    public String toString() {
        return container + " " + getNode();
    }

    @Override
    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvokeEdgePath)) {
            return false;
        }
        InvokeEdgePath that = (InvokeEdgePath) other;
        if (this.equivHashCode() != that.equivHashCode()) {
            return false;
        }
        if (!this.getNode().equals(that.getNode())) {
            return false;
        }
        if (!this.path.equals(that.path)) {
            return false;
        }
        if (!this.container.equals(that.container)) {
            return false;
        }
        return this.callee.equals(that.callee);
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
            result = 31 * result + path.hashCode();
            result = 31 * result + container.hashCode();
            hash = 31 * result + callee.hashCode();
        }
        return hash;
    }
}