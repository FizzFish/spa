/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder
 *  cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder$Companion
 *  cn.sast.dataflow.interprocedural.analysis.HeapKVData
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$KVPosition
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$KVUnreferenced
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder;
import cn.sast.dataflow.interprocedural.analysis.HeapKVData;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 )*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001)B1\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t\u00a2\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016JE\u0010\u0017\u001a\u00020\u00182\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016\u00a2\u0006\u0002\u0010\u001eJ$\u0010\u001f\u001a\u00020\u00182\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0016J\"\u0010#\u001a\u00020\u00182\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"J\b\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\u00020\u00182\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010(H\u0016R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006*"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/HeapDataBuilder;", "K", "", "V", "Lcn/sast/dataflow/interprocedural/analysis/IHeapKVData$Builder;", "map", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "<init>", "(Lkotlinx/collections/immutable/PersistentMap$Builder;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "getMap", "()Lkotlinx/collections/immutable/PersistentMap$Builder;", "getUnreferenced", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "setUnreferenced", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "getValue", "hf", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "key", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "set", "", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "update", "append", "", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;Z)V", "union", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "updateFrom", "toString", "", "cloneAndReNewObjects", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "Companion", "corax-data-flow"})
public abstract class HeapDataBuilder<K, V>
implements IHeapKVData.Builder<K, V> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final PersistentMap.Builder<K, IHeapValues<V>> map;
    @Nullable
    private IHeapValues.Builder<V> unreferenced;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(HeapDataBuilder::logger$lambda$1);

    public HeapDataBuilder(@NotNull PersistentMap.Builder<K, IHeapValues<V>> map, @Nullable IHeapValues.Builder<V> unreferenced) {
        Intrinsics.checkNotNullParameter(map, (String)"map");
        this.map = map;
        this.unreferenced = unreferenced;
    }

    @NotNull
    public final PersistentMap.Builder<K, IHeapValues<V>> getMap() {
        return this.map;
    }

    @Nullable
    public final IHeapValues.Builder<V> getUnreferenced() {
        return this.unreferenced;
    }

    public final void setUnreferenced(@Nullable IHeapValues.Builder<V> builder2) {
        this.unreferenced = builder2;
    }

    @Nullable
    public IHeapValues<V> getValue(@NotNull IHeapValuesFactory<V> hf, @NotNull K key2) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter(key2, (String)"key");
        return (IHeapValues)this.map.get(key2);
    }

    public void set(@NotNull IHeapValuesFactory<V> hf, @NotNull HeapValuesEnv env, @Nullable K key2, @Nullable IHeapValues<V> update2, boolean append) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        if (update2 == null || update2.isEmpty()) {
            logger.debug(() -> HeapDataBuilder.set$lambda$0(update2));
            return;
        }
        if (key2 == null) {
            if (this.unreferenced != null) {
                IHeapValues.Builder builder2 = this.unreferenced;
                Intrinsics.checkNotNull((Object)builder2);
                builder2.add(update2);
            } else {
                this.unreferenced = update2.builder();
            }
        } else {
            IHeapValues exist = this.getValue(hf, key2);
            IHeapValues iHeapValues = append && exist != null ? update2.plus(exist) : update2;
            ((Map)this.map).put(key2, iHeapValues);
        }
    }

    public void union(@NotNull AbstractHeapFactory<V> hf, @NotNull IData<V> that) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (!(that instanceof HeapKVData)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        if (this.unreferenced == null) {
            if (((HeapKVData)that).getUnreferenced() != null) {
                IHeapValues iHeapValues = ((HeapKVData)that).getUnreferenced();
                Intrinsics.checkNotNull((Object)iHeapValues, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.analysis.IHeapValues<V of cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder>");
                this.unreferenced = iHeapValues.builder();
            }
        } else if (((HeapKVData)that).getUnreferenced() != null) {
            IHeapValues.Builder builder2 = this.unreferenced;
            Intrinsics.checkNotNull((Object)builder2);
            IHeapValues iHeapValues = ((HeapKVData)that).getUnreferenced();
            Intrinsics.checkNotNull((Object)iHeapValues, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.analysis.IHeapValues<V of cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder>");
            builder2.add(iHeapValues);
        }
        if (this.map != ((HeapKVData)that).getMap()) {
            PersistentMap persistentMap = ((HeapKVData)that).getMap();
            Intrinsics.checkNotNull((Object)persistentMap, (String)"null cannot be cast to non-null type kotlinx.collections.immutable.PersistentMap<K of cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder, cn.sast.dataflow.interprocedural.analysis.IHeapValues<V of cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder>>");
            for (Map.Entry entry : ((Map)persistentMap).entrySet()) {
                Object k = entry.getKey();
                IHeapValues v = (IHeapValues)entry.getValue();
                IHeapValues exist = (IHeapValues)this.map.get(k);
                if (exist == null) {
                    ((Map)this.map).put(k, v);
                    continue;
                }
                ((Map)this.map).put(k, v.plus(exist));
            }
        }
    }

    public final void updateFrom(@NotNull AbstractHeapFactory<V> hf, @NotNull IData<V> that) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (!(that instanceof HeapKVData)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        if (this.unreferenced == null) {
            if (((HeapKVData)that).getUnreferenced() != null) {
                IHeapValues iHeapValues = ((HeapKVData)that).getUnreferenced();
                Intrinsics.checkNotNull((Object)iHeapValues, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.analysis.IHeapValues<V of cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder>");
                this.unreferenced = iHeapValues.builder();
            }
        } else if (((HeapKVData)that).getUnreferenced() != null) {
            IHeapValues.Builder builder2 = this.unreferenced;
            Intrinsics.checkNotNull((Object)builder2);
            IHeapValues iHeapValues = ((HeapKVData)that).getUnreferenced();
            Intrinsics.checkNotNull((Object)iHeapValues, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.analysis.IHeapValues<V of cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder>");
            builder2.add(iHeapValues);
        }
        if (this.map != ((HeapKVData)that).getMap()) {
            PersistentMap persistentMap = ((HeapKVData)that).getMap();
            Intrinsics.checkNotNull((Object)persistentMap, (String)"null cannot be cast to non-null type kotlinx.collections.immutable.PersistentMap<K of cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder, cn.sast.dataflow.interprocedural.analysis.IHeapValues<V of cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder>>");
            for (Map.Entry entry : ((Map)persistentMap).entrySet()) {
                Object k = entry.getKey();
                IHeapValues v = (IHeapValues)entry.getValue();
                ((Map)this.map).put(k, v);
            }
        }
    }

    @NotNull
    public String toString() {
        return this.build().toString();
    }

    public void cloneAndReNewObjects(@NotNull IReNew<V> re) {
        block1: {
            Intrinsics.checkNotNullParameter(re, (String)"re");
            PersistentMap oldMap = this.map.build();
            for (Map.Entry entry : ((Map)oldMap).entrySet()) {
                Object k = entry.getKey();
                IHeapValues v = (IHeapValues)entry.getValue();
                ((Map)this.map).put(k, v.cloneAndReNewObjects(re.context((Object)new ReferenceContext.KVPosition(k))));
            }
            IHeapValues.Builder builder2 = this.unreferenced;
            if (builder2 == null) break block1;
            builder2.cloneAndReNewObjects(re.context((Object)ReferenceContext.KVUnreferenced.INSTANCE));
        }
    }

    private static final Object set$lambda$0(IHeapValues $update) {
        return "ignore update is " + $update;
    }

    private static final Unit logger$lambda$1() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

