/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.EntryPath
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.InvokeEdgePath
 *  cn.sast.dataflow.interprocedural.check.InvokeEdgePath$Companion
 *  cn.sast.dataflow.interprocedural.check.PathCompanionKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.EntryPath;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.InvokeEdgePath;
import cn.sast.dataflow.interprocedural.check.PathCompanionKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B=\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2={"Lcn/sast/dataflow/interprocedural/check/InvokeEdgePath;", "Lcn/sast/dataflow/interprocedural/check/IPath;", "node", "Lsoot/Unit;", "interproceduralPathMap", "", "Lcn/sast/dataflow/interprocedural/check/EntryPath;", "path", "container", "Lsoot/SootMethod;", "callee", "<init>", "(Lsoot/Unit;Ljava/util/Map;Lcn/sast/dataflow/interprocedural/check/IPath;Lsoot/SootMethod;Lsoot/SootMethod;)V", "getNode", "()Lsoot/Unit;", "getPath", "()Lcn/sast/dataflow/interprocedural/check/IPath;", "getContainer", "()Lsoot/SootMethod;", "getCallee", "getInterproceduralPathMap", "()Ljava/util/Map;", "toString", "", "equivTo", "", "other", "", "hash", "", "getHash", "()Ljava/lang/Integer;", "setHash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "equivHashCode", "Companion", "corax-data-flow"})
public final class InvokeEdgePath
extends IPath {
    @NotNull
    public static final Companion Companion = new Companion(null);
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

    private InvokeEdgePath(Unit node, Map<IPath, EntryPath> interproceduralPathMap, IPath path, SootMethod container, SootMethod callee) {
        super(null);
        this.node = node;
        this.path = path;
        this.container = container;
        this.callee = callee;
        this.interproceduralPathMap = PathCompanionKt.access$getShort(interproceduralPathMap);
    }

    @NotNull
    public Unit getNode() {
        return this.node;
    }

    @NotNull
    public final IPath getPath() {
        return this.path;
    }

    @NotNull
    public final SootMethod getContainer() {
        return this.container;
    }

    @NotNull
    public final SootMethod getCallee() {
        return this.callee;
    }

    @NotNull
    public final Map<IPath, EntryPath> getInterproceduralPathMap() {
        return this.interproceduralPathMap;
    }

    @NotNull
    public String toString() {
        return this.container + " " + this.getNode();
    }

    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvokeEdgePath)) {
            return false;
        }
        if (this.equivHashCode() != ((InvokeEdgePath)other).equivHashCode()) {
            return false;
        }
        if (this.getNode() != ((InvokeEdgePath)other).getNode()) {
            return false;
        }
        if (this.path != ((InvokeEdgePath)other).path) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.container, (Object)((InvokeEdgePath)other).container)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.callee, (Object)((InvokeEdgePath)other).callee);
    }

    @Nullable
    public final Integer getHash() {
        return this.hash;
    }

    public final void setHash(@Nullable Integer n) {
        this.hash = n;
    }

    public int equivHashCode() {
        Integer result = this.hash;
        if (result == null) {
            result = System.identityHashCode(this.getNode());
            result = 31 * result + this.path.hashCode();
            result = 31 * result + this.container.hashCode();
            this.hash = result = Integer.valueOf(31 * result + this.callee.hashCode());
        }
        return result;
    }

    public /* synthetic */ InvokeEdgePath(Unit node, Map interproceduralPathMap, IPath path, SootMethod container, SootMethod callee, DefaultConstructorMarker $constructor_marker) {
        this(node, interproceduralPathMap, path, container, callee);
    }
}

