/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectKeyHashMap
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectKeyHashMapBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMapBuilder;
import cn.sast.dataflow.interprocedural.check.heapimpl.ObjectKeyHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001BO\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u0012 \u0010\u0006\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJN\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0012\u0010\u0015\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016JN\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00182\u0012\u0010\u0015\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0017JN\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\b2\u0012\u0010\u0015\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0017J\u001c\u0010\u0019\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001aH\u0016R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/ObjectKeyHashMapBuilder;", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementHashMapBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "keys", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "fields", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;Lkotlinx/collections/immutable/PersistentMap$Builder;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "getKeys", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "set", "", "hf", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "key", "update", "append", "", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "build", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementHashMap;", "corax-data-flow"})
public class ObjectKeyHashMapBuilder
extends ImmutableElementHashMapBuilder<IValue, IValue> {
    @NotNull
    private final IHeapValues.Builder<IValue> keys;

    public ObjectKeyHashMapBuilder(@NotNull IHeapValues.Builder<IValue> keys, @NotNull PersistentMap.Builder<IValue, IHeapValues<IValue>> fields, @Nullable IHeapValues.Builder<IValue> unreferenced) {
        Intrinsics.checkNotNullParameter(keys, (String)"keys");
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        super(fields, unreferenced);
        this.keys = keys;
    }

    @NotNull
    public final IHeapValues.Builder<IValue> getKeys() {
        return this.keys;
    }

    public void set(@NotNull IHeapValuesFactory<IValue> hf, @NotNull HeapValuesEnv env, @Nullable IValue key2, @Nullable IHeapValues<IValue> update2, boolean append) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        throw new IllegalStateException("key must be CompanionV".toString());
    }

    public final void set(@NotNull IHeapValuesFactory<IValue> hf, @NotNull HeapValuesEnv env, @NotNull CompanionV<IValue> key2, @Nullable IHeapValues<IValue> update2, boolean append) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(key2, (String)"key");
        super.set(hf, env, key2.getValue(), update2, append);
        this.keys.add(key2);
    }

    public final void set(@NotNull IHeapValuesFactory<IValue> hf, @NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> key2, @Nullable IHeapValues<IValue> update2, boolean append) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(key2, (String)"key");
        for (CompanionV k : key2) {
            this.set(hf, env, k, update2, append);
        }
    }

    @NotNull
    public ImmutableElementHashMap<IValue, IValue> build() {
        IHeapValues.Builder builder2 = this.getUnreferenced();
        return (ImmutableElementHashMap)new ObjectKeyHashMap(this.keys.build(), this.getMap().build(), (IHeapValues)(builder2 != null ? builder2.build() : null));
    }
}

