/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValues
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValuesBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0007\u00a2\u0006\u0004\b\b\u0010\tJ,\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\r2\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001a"}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/ObjectValuesBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/IData$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "orig", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ObjectValues;", "values", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "<init>", "(Lcn/sast/dataflow/interprocedural/check/heapimpl/ObjectValues;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "getValues", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "union", "", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "cloneAndReNewObjects", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "addAll", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "build", "toString", "", "corax-data-flow"})
public final class ObjectValuesBuilder
implements IData.Builder<IValue> {
    @NotNull
    private final ObjectValues orig;
    @NotNull
    private final IHeapValues.Builder<IValue> values;

    public ObjectValuesBuilder(@NotNull ObjectValues orig, @NotNull IHeapValues.Builder<IValue> values) {
        Intrinsics.checkNotNullParameter((Object)orig, (String)"orig");
        Intrinsics.checkNotNullParameter(values, (String)"values");
        this.orig = orig;
        this.values = values;
    }

    @NotNull
    public final IHeapValues.Builder<IValue> getValues() {
        return this.values;
    }

    public void union(@NotNull AbstractHeapFactory<IValue> hf, @NotNull IData<IValue> that) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (!(that instanceof ObjectValues)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        this.values.add(((ObjectValues)that).getValues());
    }

    public void cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        this.values.cloneAndReNewObjects(re);
    }

    public final void addAll(@NotNull IHeapValues<IValue> values) {
        Intrinsics.checkNotNullParameter(values, (String)"values");
        this.values.add(values);
    }

    @NotNull
    public ObjectValues build() {
        IHeapValues iHeapValues = this.values.build();
        if (Intrinsics.areEqual((Object)this.orig.getValues(), (Object)iHeapValues)) {
            return this.orig;
        }
        return new ObjectValues(iHeapValues);
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.values);
    }
}

