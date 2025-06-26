/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractBOTTOM
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.InValidFact
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.InValidFact;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J$\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006!"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/AbstractBOTTOM;", "V", "Lcn/sast/dataflow/interprocedural/analysis/InValidFact;", "<init>", "()V", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getHf", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "isBottom", "", "isTop", "isValid", "toString", "", "equals", "other", "", "hashCode", "", "getOfSlot", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "slot", "diff", "", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "corax-data-flow"})
public abstract class AbstractBOTTOM<V>
extends InValidFact<V> {
    @NotNull
    public AbstractHeapFactory<V> getHf() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    public boolean isBottom() {
        return true;
    }

    public boolean isTop() {
        return false;
    }

    public boolean isValid() {
        return false;
    }

    @NotNull
    public String toString() {
        return "IFact: BOTTOM";
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IFact)) {
            return false;
        }
        return this.isBottom() && ((IFact)other).isBottom();
    }

    public int hashCode() {
        return 2;
    }

    @NotNull
    public IHeapValues<V> getOfSlot(@NotNull HeapValuesEnv env, @NotNull Object slot) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)slot, (String)"slot");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    public void diff(@NotNull IDiff<V> cmp, @NotNull IFact<V> that) {
        Intrinsics.checkNotNullParameter(cmp, (String)"cmp");
        Intrinsics.checkNotNullParameter(that, (String)"that");
    }

    @NotNull
    public IFact.Builder<V> builder() {
        return (IFact.Builder)new /* Unavailable Anonymous Inner Class!! */;
    }
}

