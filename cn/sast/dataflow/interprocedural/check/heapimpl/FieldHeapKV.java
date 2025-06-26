/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.HeapKVData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapKV
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.RefType
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.RefType;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001d"}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/FieldHeapKV;", "V", "Lcn/sast/dataflow/interprocedural/analysis/HeapKVData;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "clz", "Lsoot/RefType;", "fields", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "<init>", "(Lsoot/RefType;Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "getClz", "()Lsoot/RefType;", "isValidKey", "", "key", "(Lcn/sast/dataflow/interprocedural/analysis/JFieldType;)Ljava/lang/Boolean;", "get", "hf", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "ppKey", "", "computeHash", "", "equals", "other", "", "hashCode", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nFIeldHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FIeldHeap.kt\ncn/sast/dataflow/interprocedural/check/heapimpl/FieldHeapKV\n+ 2 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n*L\n1#1,56:1\n50#2:57\n*S KotlinDebug\n*F\n+ 1 FIeldHeap.kt\ncn/sast/dataflow/interprocedural/check/heapimpl/FieldHeapKV\n*L\n27#1:57\n*E\n"})
public abstract class FieldHeapKV<V>
extends HeapKVData<JFieldType, V> {
    @NotNull
    private final RefType clz;

    public FieldHeapKV(@NotNull RefType clz, @NotNull PersistentMap<JFieldType, ? extends IHeapValues<V>> fields, @Nullable IHeapValues<V> unreferenced) {
        Intrinsics.checkNotNullParameter((Object)clz, (String)"clz");
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        super(fields, unreferenced);
        this.clz = clz;
    }

    @NotNull
    public final RefType getClz() {
        return this.clz;
    }

    @Nullable
    public Boolean isValidKey(@Nullable JFieldType key2) {
        return true;
    }

    @Nullable
    public IHeapValues<V> get(@NotNull IHeapValuesFactory<V> hf, @Nullable JFieldType key2) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        if (key2 != null) {
            return (IHeapValues)this.getMap().get((Object)key2);
        }
        return this.getFromNullKey(hf);
    }

    @NotNull
    public String ppKey(@NotNull JFieldType key2) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        FieldUtil this_$iv = FieldUtil.INSTANCE;
        boolean $i$f$nameOf = false;
        return key2.getName();
    }

    public int computeHash() {
        int result = super.computeHash();
        result = 31 * result + this.clz.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        if (!(other instanceof FieldHeapKV)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.clz, (Object)((FieldHeapKV)other).clz);
    }

    public int hashCode() {
        return super.hashCode();
    }
}

