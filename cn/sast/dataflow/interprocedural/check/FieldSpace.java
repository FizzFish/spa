/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.check.FieldSpace
 *  cn.sast.dataflow.interprocedural.check.FieldSpaceBuilder
 *  cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapKV
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.RefType
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.check.FieldSpaceBuilder;
import cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.RefType;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016\u00a8\u0006\u0014"}, d2={"Lcn/sast/dataflow/interprocedural/check/FieldSpace;", "V", "Lcn/sast/dataflow/interprocedural/check/heapimpl/FieldHeapKV;", "clz", "Lsoot/RefType;", "fields", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "<init>", "(Lsoot/RefType;Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IHeapKVData$Builder;", "getName", "", "cloneAndReNewObjects", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "corax-data-flow"})
public final class FieldSpace<V>
extends FieldHeapKV<V> {
    public FieldSpace(@NotNull RefType clz, @NotNull PersistentMap<JFieldType, ? extends IHeapValues<V>> fields, @Nullable IHeapValues<V> unreferenced) {
        Intrinsics.checkNotNullParameter((Object)clz, (String)"clz");
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        super(clz, fields, unreferenced);
    }

    @NotNull
    public IHeapKVData.Builder<JFieldType, V> builder() {
        IHeapValues iHeapValues = this.getUnreferenced();
        return (IHeapKVData.Builder)new FieldSpaceBuilder(this, this.getClz(), this.getMap().builder(), (IHeapValues.Builder)(iHeapValues != null ? iHeapValues.builder() : null));
    }

    @NotNull
    public String getName() {
        return "field(" + this.getClz() + ")";
    }

    @NotNull
    public IData<V> cloneAndReNewObjects(@NotNull IReNew<V> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        IHeapKVData.Builder b = this.builder();
        b.cloneAndReNewObjects(re);
        return b.build();
    }
}

