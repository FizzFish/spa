/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValues
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValuesBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValuesBuilder;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0019\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J,\u0010\u0014\u001a\u00020\u000e2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00162\u0010\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J$\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006\""}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/ObjectValues;", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "values", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "getValues", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "hashCode", "", "Ljava/lang/Integer;", "reference", "", "res", "", "builder", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ObjectValuesBuilder;", "computeHash", "diff", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IDiffAble;", "", "equals", "", "other", "cloneAndReNewObjects", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "toString", "", "corax-data-flow"})
public final class ObjectValues
implements IData<IValue> {
    @NotNull
    private final IHeapValues<IValue> values;
    @Nullable
    private Integer hashCode;

    public ObjectValues(@NotNull IHeapValues<IValue> values) {
        Intrinsics.checkNotNullParameter(values, (String)"values");
        this.values = values;
    }

    @NotNull
    public final IHeapValues<IValue> getValues() {
        return this.values;
    }

    public void reference(@NotNull Collection<IValue> res) {
        Intrinsics.checkNotNullParameter(res, (String)"res");
        this.values.reference(res);
    }

    @NotNull
    public ObjectValuesBuilder builder() {
        return new ObjectValuesBuilder(this, this.values.builder());
    }

    public int computeHash() {
        return this.values.hashCode();
    }

    public void diff(@NotNull IDiff<IValue> cmp, @NotNull IDiffAble<? extends Object> that) {
        Intrinsics.checkNotNullParameter(cmp, (String)"cmp");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (!(that instanceof ObjectValues)) {
            return;
        }
        this.values.diff(cmp, (IDiffAble)((ObjectValues)that).values);
    }

    public int hashCode() {
        Integer hash = this.hashCode;
        if (hash == null) {
            this.hashCode = hash = Integer.valueOf(this.computeHash());
        }
        return hash;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ObjectValues)) {
            return false;
        }
        if (this.hashCode() != ((ObjectValues)other).hashCode()) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.values, (Object)((ObjectValues)other).values);
    }

    @NotNull
    public IData<IValue> cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        ObjectValuesBuilder b = this.builder();
        b.cloneAndReNewObjects(re);
        return (IData)b.build();
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.values);
    }
}

