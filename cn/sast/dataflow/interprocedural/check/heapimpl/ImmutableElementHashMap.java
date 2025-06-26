/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.HeapKVData
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.HeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B5\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0016\u00a8\u0006\u001b"}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementHashMap;", "K", "", "V", "Lcn/sast/dataflow/interprocedural/analysis/HeapKVData;", "fields", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "<init>", "(Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "equals", "", "other", "hashCode", "", "getName", "", "isValidKey", "key", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "cloneAndReNewObjects", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "builder", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementHashMapBuilder;", "corax-data-flow"})
public class ImmutableElementHashMap<K, V>
extends HeapKVData<K, V> {
    public ImmutableElementHashMap(@NotNull PersistentMap<K, ? extends IHeapValues<V>> fields, @Nullable IHeapValues<V> unreferenced) {
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        super(fields, unreferenced);
    }

    public /* synthetic */ ImmutableElementHashMap(PersistentMap persistentMap, IHeapValues iHeapValues, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            persistentMap = ExtensionsKt.persistentHashMapOf();
        }
        if ((n & 2) != 0) {
            iHeapValues = null;
        }
        this(persistentMap, iHeapValues);
    }

    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        return other instanceof ImmutableElementHashMap;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public String getName() {
        return "ImmHashMap";
    }

    @Nullable
    public Boolean isValidKey(@Nullable K key2) {
        return true;
    }

    @NotNull
    public IData<V> cloneAndReNewObjects(@NotNull IReNew<V> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        ImmutableElementHashMapBuilder b = this.builder();
        b.cloneAndReNewObjects(re);
        return (IData)b.build();
    }

    @NotNull
    public ImmutableElementHashMapBuilder<K, V> builder() {
        IHeapValues iHeapValues = this.getUnreferenced();
        return new ImmutableElementHashMapBuilder(this.getMap().builder(), (IHeapValues.Builder)(iHeapValues != null ? iHeapValues.builder() : null));
    }

    public ImmutableElementHashMap() {
        this(null, null, 3, null);
    }
}

