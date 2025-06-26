/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstractKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010&\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u00f8\u0001\u0000\u001ap\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0002*\u0016\u0012\u0006\b\u0001\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\b2*\u0010\u0004\u001a&\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0005H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\r"}, d2={"foreach", "", "V", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "transform", "Lkotlin/Function1;", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "mapTo", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "K", "", "destination", "", "corax-data-flow"})
public final class PointsToGraphAbstractKt {
    public static final <V> void foreach(@NotNull IHeapValues<V> $this$foreach, @NotNull Function1<? super CompanionV<V>, Unit> transform) {
        Intrinsics.checkNotNullParameter($this$foreach, (String)"<this>");
        Intrinsics.checkNotNullParameter(transform, (String)"transform");
        boolean $i$f$foreach = false;
        for (CompanionV e : $this$foreach) {
            transform.invoke((Object)e);
        }
    }

    @NotNull
    public static final <K, V> IHeapValues.Builder<V> mapTo(@NotNull Map<? extends K, ? extends IHeapValues<V>> $this$mapTo, @NotNull IHeapValues.Builder<V> destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends IHeapValues<V>>, ? extends IHeapValues<V>> transform) {
        Intrinsics.checkNotNullParameter($this$mapTo, (String)"<this>");
        Intrinsics.checkNotNullParameter(destination, (String)"destination");
        Intrinsics.checkNotNullParameter(transform, (String)"transform");
        boolean $i$f$mapTo = false;
        for (Map.Entry<K, IHeapValues<V>> entry : $this$mapTo.entrySet()) {
            destination.add((IHeapValues)transform.invoke(entry));
        }
        return destination;
    }
}

