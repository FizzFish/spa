/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSetBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0012\u0012\u0004\u0012\u0002H\u0001\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003B9\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016\u00a8\u0006\u000f"}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSetBuilder;", "E", "", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementHashMapBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "fields", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "<init>", "(Lkotlinx/collections/immutable/PersistentMap$Builder;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "build", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet;", "corax-data-flow"})
public final class ImmutableElementSetBuilder<E>
extends ImmutableElementHashMapBuilder<E, IValue> {
    public ImmutableElementSetBuilder(@NotNull PersistentMap.Builder<E, IHeapValues<IValue>> fields, @Nullable IHeapValues.Builder<IValue> unreferenced) {
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        super(fields, unreferenced);
    }

    @NotNull
    public ImmutableElementSet<E> build() {
        IHeapValues.Builder builder2 = this.getUnreferenced();
        return new ImmutableElementSet(this.getMap().build(), (IHeapValues)(builder2 != null ? builder2.build() : null));
    }
}

