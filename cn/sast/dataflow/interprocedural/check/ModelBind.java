/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.ModelBind
 *  cn.sast.dataflow.interprocedural.check.ModelBind$Companion
 *  cn.sast.dataflow.interprocedural.check.ModelingStmtInfo
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.ModelBind;
import cn.sast.dataflow.interprocedural.check.ModelingStmtInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&BC\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010%\u001a\u00020\u001fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0007\u001a\u00060\bj\u0002`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2={"Lcn/sast/dataflow/interprocedural/check/ModelBind;", "Lcn/sast/dataflow/interprocedural/check/IPath;", "node", "Lsoot/Unit;", "obj", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "mt", "", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "data", "info", "Lcn/sast/dataflow/interprocedural/check/ModelingStmtInfo;", "prev", "<init>", "(Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/IValue;Ljava/lang/Object;Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/check/ModelingStmtInfo;Lcn/sast/dataflow/interprocedural/check/IPath;)V", "getNode", "()Lsoot/Unit;", "getObj", "()Lcn/sast/dataflow/interprocedural/analysis/IValue;", "getMt", "()Ljava/lang/Object;", "getData", "getInfo", "()Lcn/sast/dataflow/interprocedural/check/ModelingStmtInfo;", "getPrev", "()Lcn/sast/dataflow/interprocedural/check/IPath;", "equivTo", "", "other", "hash", "", "getHash", "()Ljava/lang/Integer;", "setHash", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "equivHashCode", "Companion", "corax-data-flow"})
public final class ModelBind
extends IPath {
    @NotNull
    public static final Companion Companion = new Companion(null);
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

    private ModelBind(Unit node, IValue obj, Object mt, Object data, ModelingStmtInfo info2, IPath prev) {
        super(null);
        this.node = node;
        this.obj = obj;
        this.mt = mt;
        this.data = data;
        this.info = info2;
        this.prev = prev;
    }

    @NotNull
    public Unit getNode() {
        return this.node;
    }

    @NotNull
    public final IValue getObj() {
        return this.obj;
    }

    @NotNull
    public final Object getMt() {
        return this.mt;
    }

    @NotNull
    public final Object getData() {
        return this.data;
    }

    @Nullable
    public final ModelingStmtInfo getInfo() {
        return this.info;
    }

    @NotNull
    public final IPath getPrev() {
        return this.prev;
    }

    public boolean equivTo(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelBind)) {
            return false;
        }
        if (this.equivHashCode() != ((ModelBind)other).equivHashCode()) {
            return false;
        }
        if (this.getNode() != ((ModelBind)other).getNode()) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.obj, (Object)((ModelBind)other).obj)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.mt, (Object)((ModelBind)other).mt)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.data, (Object)((ModelBind)other).data)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.info, (Object)((ModelBind)other).info)) {
            return false;
        }
        return this.prev == ((ModelBind)other).prev;
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
            result = 31 * result + this.obj.hashCode();
            result = 31 * result + this.mt.hashCode();
            result = 31 * result + this.data.hashCode();
            ModelingStmtInfo modelingStmtInfo = this.info;
            result = 31 * result + (modelingStmtInfo != null ? modelingStmtInfo.hashCode() : 0);
            this.hash = result = Integer.valueOf(31 * result + this.prev.hashCode());
        }
        return result;
    }

    public /* synthetic */ ModelBind(Unit node, IValue obj, Object mt, Object data, ModelingStmtInfo info2, IPath prev, DefaultConstructorMarker $constructor_marker) {
        this(node, obj, mt, data, info2, prev);
    }
}

