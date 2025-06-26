/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSetBuilder
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.check.heapimpl;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSetBuilder;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0012\u0012\u0004\u0012\u0002H\u0001\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003B=\u0012\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\b0\u0007\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00132\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0000J4\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J4\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J4\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0013\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006#"}, d2={"Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet;", "E", "", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementHashMap;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "fields", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "<init>", "(Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "getName", "", "element", "", "getElement", "()Ljava/util/Set;", "isEmpty", "", "containsAll", "rhs", "intersect", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "plus", "minus", "equals", "other", "hashCode", "", "builder", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSetBuilder;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nImmutableCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImmutableCollections.kt\ncn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,314:1\n1#2:315\n*E\n"})
public final class ImmutableElementSet<E>
extends ImmutableElementHashMap<E, IValue> {
    public ImmutableElementSet(@NotNull PersistentMap<E, ? extends IHeapValues<IValue>> fields, @Nullable IHeapValues<IValue> unreferenced) {
        Intrinsics.checkNotNullParameter(fields, (String)"fields");
        super(fields, unreferenced);
    }

    public /* synthetic */ ImmutableElementSet(PersistentMap persistentMap, IHeapValues iHeapValues, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            persistentMap = ExtensionsKt.persistentHashMapOf();
        }
        if ((n & 2) != 0) {
            iHeapValues = null;
        }
        this(persistentMap, iHeapValues);
    }

    @NotNull
    public String getName() {
        return "ImmHashSet";
    }

    @NotNull
    public final Set<E> getElement() {
        return this.getMap().keySet();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isEmpty() {
        if (!this.getMap().isEmpty()) return false;
        IHeapValues iHeapValues = this.getUnreferenced();
        if (iHeapValues == null) return true;
        boolean bl = iHeapValues.isEmpty();
        if (!bl) return false;
        return true;
    }

    public final boolean containsAll(@NotNull ImmutableElementSet<?> rhs) {
        Intrinsics.checkNotNullParameter(rhs, (String)"rhs");
        return ((Collection)this.getMap().keySet()).containsAll(rhs.getMap().keySet());
    }

    @NotNull
    public final ImmutableElementSet<E> intersect(@NotNull AbstractHeapFactory<IValue> hf, @NotNull HeapValuesEnv env, @NotNull ImmutableElementSet<E> rhs) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(rhs, (String)"rhs");
        if (rhs.isEmpty()) {
            return rhs;
        }
        if (this.isEmpty()) {
            return this;
        }
        Set set = CollectionsKt.intersect((Iterable)this.getMap().keySet(), (Iterable)rhs.getMap().keySet());
        ImmutableElementSetBuilder r = new ImmutableElementSet(null, null, 3, null).builder();
        for (Object e : set) {
            IHeapValues it;
            IHeapValues iHeapValues;
            if (this.get((IHeapValuesFactory)hf, e instanceof Object ? e : null) != null) {
                it = iHeapValues;
                boolean bl = false;
                r.set((IHeapValuesFactory)hf, env, e, it, true);
            }
            if (rhs.get((IHeapValuesFactory)hf, e) == null) continue;
            it = iHeapValues;
            boolean bl = false;
            r.set((IHeapValuesFactory)hf, env, e, it, true);
        }
        return r.build();
    }

    @NotNull
    public final ImmutableElementSet<E> plus(@NotNull AbstractHeapFactory<IValue> hf, @NotNull HeapValuesEnv env, @NotNull ImmutableElementSet<E> rhs) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(rhs, (String)"rhs");
        if (this.isEmpty()) {
            return rhs;
        }
        if (rhs.isEmpty()) {
            return this;
        }
        Set set = SetsKt.plus((Set)this.getMap().keySet(), (Iterable)rhs.getMap().keySet());
        ImmutableElementSetBuilder r = new ImmutableElementSet(null, null, 3, null).builder();
        for (Object e : set) {
            IHeapValues it;
            IHeapValues iHeapValues;
            if (this.get((IHeapValuesFactory)hf, e instanceof Object ? e : null) != null) {
                it = iHeapValues;
                boolean bl = false;
                r.set((IHeapValuesFactory)hf, env, e, it, true);
            }
            if (rhs.get((IHeapValuesFactory)hf, e) == null) continue;
            it = iHeapValues;
            boolean bl = false;
            r.set((IHeapValuesFactory)hf, env, e, it, true);
        }
        return r.build();
    }

    @NotNull
    public final ImmutableElementSet<E> minus(@NotNull AbstractHeapFactory<IValue> hf, @NotNull HeapValuesEnv env, @NotNull ImmutableElementSet<E> rhs) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(rhs, (String)"rhs");
        if (this.isEmpty()) {
            return this;
        }
        if (rhs.isEmpty()) {
            return this;
        }
        ImmutableElementSetBuilder r = this.builder();
        for (Object e : rhs.getElement()) {
            IHeapValues v;
            if (this.get((IHeapValuesFactory)hf, e) == null || !v.isSingle()) continue;
            r.getMap().remove(e);
        }
        return r.build();
    }

    public boolean equals(@Nullable Object other) {
        if (!super.equals(other)) {
            return false;
        }
        return other instanceof ImmutableElementSet;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public ImmutableElementSetBuilder<E> builder() {
        IHeapValues iHeapValues = this.getUnreferenced();
        return new ImmutableElementSetBuilder(this.getMap().builder(), (IHeapValues.Builder)(iHeapValues != null ? iHeapValues.builder() : null));
    }

    public ImmutableElementSet() {
        this(null, null, 3, null);
    }
}

