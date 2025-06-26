/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.check.FieldSpace
 *  cn.sast.dataflow.interprocedural.check.FieldSpaceBuilder
 *  cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.RefType
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.check.FieldSpace;
import cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.RefType;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2={"Lcn/sast/dataflow/interprocedural/check/FieldSpaceBuilder;", "V", "Lcn/sast/dataflow/interprocedural/check/heapimpl/FieldHeapBuilder;", "orig", "Lcn/sast/dataflow/interprocedural/check/FieldSpace;", "clz", "Lsoot/RefType;", "fields", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "<init>", "(Lcn/sast/dataflow/interprocedural/check/FieldSpace;Lsoot/RefType;Lkotlinx/collections/immutable/PersistentMap$Builder;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "getOrig", "()Lcn/sast/dataflow/interprocedural/check/FieldSpace;", "build", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "corax-data-flow"})
public final class FieldSpaceBuilder<V>
extends FieldHeapBuilder<V> {
    @NotNull
    private final FieldSpace<V> orig;

    public FieldSpaceBuilder(@NotNull FieldSpace<V> orig, @NotNull RefType clz, @NotNull PersistentMap.Builder<JFieldType, IHeapValues<V>> fields, @Nullable IHeapValues.Builder<V> unreferenced) {
        Intrinsics.checkNotNullParameter(orig, (String)"orig");
        Intrinsics.checkNotNullParameter((Object)clz, (String)"clz");
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        super(clz, fields, unreferenced);
        this.orig = orig;
    }

    @NotNull
    public final FieldSpace<V> getOrig() {
        return this.orig;
    }

    @NotNull
    public IData<V> build() {
        IHeapValues newUn;
        PersistentMap newMap = this.getMap().build();
        IHeapValues.Builder builder2 = this.getUnreferenced();
        Object object = newUn = builder2 != null ? builder2.build() : null;
        if (newMap == this.orig.getMap() && newUn == this.orig.getUnreferenced()) {
            return (IData)this.orig;
        }
        return (IData)new FieldSpace(this.getClz(), newMap, newUn);
    }
}

