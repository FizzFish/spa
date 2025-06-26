/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValues
 *  cn.sast.dataflow.interprocedural.analysis.HeapValues$Companion
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesBuilder
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapValues;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValues;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesBuilder;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\u000bB+\u0012\"\b\u0002\u0010\u0004\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/HeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "map", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "<init>", "(Lkotlinx/collections/immutable/PersistentMap;)V", "builder", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesBuilder;", "Companion", "corax-data-flow"})
public final class HeapValues
extends AbstractHeapValues<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public HeapValues(@NotNull PersistentMap<IValue, ? extends CompanionV<IValue>> map) {
        Intrinsics.checkNotNullParameter(map, (String)"map");
        super(map, null);
    }

    public /* synthetic */ HeapValues(PersistentMap persistentMap, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            persistentMap = ExtensionsKt.persistentHashMapOf();
        }
        this(persistentMap);
    }

    @NotNull
    public HeapValuesBuilder builder() {
        return new HeapValuesBuilder(this, null, 2, null);
    }

    public HeapValues() {
        this(null, 1, null);
    }
}

