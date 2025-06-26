/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.HeapValues
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesBuilder
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectKeyHashMap
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectKeyHashMapBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.ImmutableCollection
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapValues;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesBuilder;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder;
import cn.sast.dataflow.interprocedural.check.heapimpl.ObjectKeyHashMapBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableCollection;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001BO\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u0012 \u0010\u0006\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00050\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u0005\u00a2\u0006\u0004\b\t\u0010\nJ,\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00122\u0010\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u001c\u0010\u001c\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001dH\u0016R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001e"}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/ObjectKeyHashMap;", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementHashMap;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "keys", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "fields", "Lkotlinx/collections/immutable/PersistentMap;", "unreferenced", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "getKeys", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "values", "getValues", "diff", "", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IDiffAble;", "", "computeHash", "", "hashCode", "equals", "", "other", "builder", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementHashMapBuilder;", "corax-data-flow"})
public final class ObjectKeyHashMap
extends ImmutableElementHashMap<IValue, IValue> {
    @NotNull
    private final IHeapValues<IValue> keys;

    public ObjectKeyHashMap(@NotNull IHeapValues<IValue> keys, @NotNull PersistentMap<IValue, ? extends IHeapValues<IValue>> fields, @Nullable IHeapValues<IValue> unreferenced) {
        Intrinsics.checkNotNullParameter(keys, (String)"keys");
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        super(fields, unreferenced);
        this.keys = keys;
    }

    @NotNull
    public final IHeapValues<IValue> getKeys() {
        return this.keys;
    }

    @NotNull
    public final IHeapValues<IValue> getValues() {
        HeapValuesBuilder heapValuesBuilder;
        boolean bl = false;
        HeapValuesBuilder it = heapValuesBuilder = new HeapValues(null, 1, null).builder();
        boolean bl2 = false;
        for (IHeapValues v : (ImmutableCollection)this.getMap().values()) {
            it.add(v);
        }
        return heapValuesBuilder.build();
    }

    public void diff(@NotNull IDiff<IValue> cmp, @NotNull IDiffAble<? extends Object> that) {
        Intrinsics.checkNotNullParameter(cmp, (String)"cmp");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (that instanceof ObjectKeyHashMap) {
            this.keys.diff(cmp, (IDiffAble)((ObjectKeyHashMap)that).keys);
            this.getValues().diff(cmp, (IDiffAble)((ObjectKeyHashMap)that).getValues());
        }
        super.diff(cmp, that);
    }

    public int computeHash() {
        int result = 1;
        result = 31 * result + super.computeHash();
        return result;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        if (!(other instanceof ObjectKeyHashMap)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.keys, (Object)((ObjectKeyHashMap)other).keys);
    }

    @NotNull
    public ImmutableElementHashMapBuilder<IValue, IValue> builder() {
        IHeapValues iHeapValues = this.getUnreferenced();
        return (ImmutableElementHashMapBuilder)new ObjectKeyHashMapBuilder(this.keys.builder(), this.getMap().builder(), (IHeapValues.Builder)(iHeapValues != null ? iHeapValues.builder() : null));
    }
}

