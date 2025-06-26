/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.HeapKVData
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B1\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0016J(\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010!J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010$H\u0016J+\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010$2\u0006\u0010 \u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010&J-\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010$2\b\u0010 \u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010&J\u0015\u0010(\u001a\u00020)2\u0006\u0010 \u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\b\u0010-\u001a\u00020)H\u0016J\b\u0010.\u001a\u00020)H&R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011\u00a8\u0006/"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/HeapKVData;", "K", "", "V", "Lcn/sast/dataflow/interprocedural/analysis/IHeapKVData;", "map", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "<init>", "(Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "getMap", "()Lkotlinx/collections/immutable/PersistentMap;", "getUnreferenced", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "hashCode", "", "Ljava/lang/Integer;", "reference", "", "res", "", "diff", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IDiffAble;", "equals", "", "other", "computeHash", "isValidKey", "key", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "getFromNullKey", "hf", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "getValue", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "get", "ppKey", "", "(Ljava/lang/Object;)Ljava/lang/String;", "ppValue", "value", "toString", "getName", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nHeapKVData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeapKVData.kt\ncn/sast/dataflow/interprocedural/analysis/HeapKVData\n+ 2 PointsToGraphAbstract.kt\ncn/sast/dataflow/interprocedural/analysis/PointsToGraphAbstractKt\n*L\n1#1,248:1\n380#2,3:249\n*S KotlinDebug\n*F\n+ 1 HeapKVData.kt\ncn/sast/dataflow/interprocedural/analysis/HeapKVData\n*L\n111#1:249,3\n*E\n"})
public abstract class HeapKVData<K, V>
implements IHeapKVData<K, V> {
    @NotNull
    private final PersistentMap<K, IHeapValues<V>> map;
    @Nullable
    private final IHeapValues<V> unreferenced;
    @Nullable
    private Integer hashCode;

    public HeapKVData(@NotNull PersistentMap<K, ? extends IHeapValues<V>> map, @Nullable IHeapValues<V> unreferenced) {
        block0: {
            Intrinsics.checkNotNullParameter(map, (String)"map");
            this.map = map;
            this.unreferenced = unreferenced;
            IHeapValues iHeapValues = this.unreferenced;
            if (iHeapValues == null) break block0;
            iHeapValues.isNotEmpty();
        }
    }

    @NotNull
    public final PersistentMap<K, IHeapValues<V>> getMap() {
        return this.map;
    }

    @Nullable
    public final IHeapValues<V> getUnreferenced() {
        return this.unreferenced;
    }

    public void reference(@NotNull Collection<V> res) {
        block1: {
            Intrinsics.checkNotNullParameter(res, (String)"res");
            for (Map.Entry f : ((Map)this.map).entrySet()) {
                ((IHeapValues)f.getValue()).reference(res);
            }
            IHeapValues iHeapValues = this.unreferenced;
            if (iHeapValues == null) break block1;
            iHeapValues.reference(res);
        }
    }

    public void diff(@NotNull IDiff<V> cmp, @NotNull IDiffAble<? extends Object> that) {
        Intrinsics.checkNotNullParameter(cmp, (String)"cmp");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (!(that instanceof HeapKVData)) {
            return;
        }
        for (Object k : CollectionsKt.intersect((Iterable)this.map.keySet(), (Iterable)((HeapKVData)that).map.keySet())) {
            Object v = ((Map)this.map).get(k);
            Intrinsics.checkNotNull(v);
            IHeapValues iHeapValues = (IHeapValues)v;
            Object v2 = ((Map)((HeapKVData)that).map).get(k);
            Intrinsics.checkNotNull(v2);
            iHeapValues.diff(cmp, (IDiffAble)v2);
        }
        if (this.unreferenced != null && ((HeapKVData)that).unreferenced != null) {
            this.unreferenced.diff(cmp, (IDiffAble)((HeapKVData)that).unreferenced);
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeapKVData)) {
            return false;
        }
        if (this.hashCode() != ((HeapKVData)other).hashCode()) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.map, (Object)((HeapKVData)other).map) && Intrinsics.areEqual((Object)this.unreferenced, (Object)((HeapKVData)other).unreferenced);
    }

    public int computeHash() {
        int result = 1;
        result = 31 * result + this.map.hashCode();
        IHeapValues iHeapValues = this.unreferenced;
        result = 31 * result + (iHeapValues != null ? iHeapValues.hashCode() : 0);
        return result;
    }

    public int hashCode() {
        Integer hash = this.hashCode;
        if (hash == null) {
            this.hashCode = hash = Integer.valueOf(this.computeHash());
        }
        return hash;
    }

    @Nullable
    public abstract Boolean isValidKey(@Nullable K var1);

    /*
     * WARNING - void declaration
     */
    @NotNull
    public IHeapValues<V> getFromNullKey(@NotNull IHeapValuesFactory<V> hf) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        IHeapValues.Builder b = hf.emptyBuilder();
        Map $this$mapTo$iv = (Map)this.map;
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            void it;
            Map.Entry item$iv;
            Map.Entry entry = item$iv = iterator2.next();
            IHeapValues.Builder builder2 = b;
            boolean bl = false;
            builder2.add((IHeapValues)it.getValue());
        }
        if (this.unreferenced != null) {
            b.add(this.unreferenced);
        }
        return b.build();
    }

    @Nullable
    public IHeapValues<V> getValue(@NotNull IHeapValuesFactory<V> hf, @NotNull K key2) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter(key2, (String)"key");
        return (IHeapValues)this.map.get(key2);
    }

    @Nullable
    public IHeapValues<V> get(@NotNull IHeapValuesFactory<V> hf, @Nullable K key2) {
        IHeapValues exist;
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        return key2 != null ? ((exist = this.getValue(hf, key2)) != null ? (this.unreferenced != null ? exist.plus(this.unreferenced) : exist) : this.unreferenced) : this.getFromNullKey(hf);
    }

    @NotNull
    public String ppKey(@NotNull K key2) {
        Intrinsics.checkNotNullParameter(key2, (String)"key");
        return key2.toString();
    }

    @NotNull
    public String ppValue(@NotNull IHeapValues<V> value) {
        Intrinsics.checkNotNullParameter(value, (String)"value");
        return value.toString();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getName()).append(" ");
        for (Map.Entry entry : ((Map)this.map).entrySet()) {
            Object k = entry.getKey();
            IHeapValues v = (IHeapValues)entry.getValue();
            IHeapValues value = this.unreferenced == null ? v : v.plus(this.unreferenced);
            sb.append(this.ppKey(k)).append("->").append(this.ppValue(value)).append(" ; ");
        }
        if (this.map.isEmpty()) {
            sb.append("unreferenced: " + this.unreferenced);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    @NotNull
    public abstract String getName();
}

