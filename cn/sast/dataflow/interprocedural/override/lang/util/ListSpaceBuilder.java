/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$KVPosition
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$KVUnreferenced
 *  cn.sast.dataflow.interprocedural.override.lang.util.ListSpace
 *  cn.sast.dataflow.interprocedural.override.lang.util.ListSpaceBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.PersistentList
 *  kotlinx.collections.immutable.PersistentList$Builder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.override.lang.util;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import cn.sast.dataflow.interprocedural.override.lang.util.ListSpace;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B3\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ,\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00102\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012H\u0016J$\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00062\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0010H\u0002J\u001a\u0010\u0014\u001a\u00020\u000e2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0016H\u0016J\u0012\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0006J\u0018\u0010\u001a\u001a\u00020\u000e2\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0006J \u0010\u001b\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00102\u0006\u0010\u001c\u001a\u00020\u001dJ1\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00062\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 \u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00060\u0005H\u00c6\u0003J\u0015\u0010#\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\bH\u00c2\u0003J9\u0010$\u001a\u00020\u00002\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\bH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u00d6\u0003J\t\u0010)\u001a\u00020 H\u00d6\u0001J\t\u0010*\u001a\u00020+H\u00d6\u0001R!\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/util/ListSpaceBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/IData$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "list", "Lkotlinx/collections/immutable/PersistentList$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "<init>", "(Lkotlinx/collections/immutable/PersistentList$Builder;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;)V", "getList", "()Lkotlinx/collections/immutable/PersistentList$Builder;", "union", "", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "getAllElement", "cloneAndReNewObjects", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "build", "add", "value", "clear", "addAll", "b", "Lcn/sast/dataflow/interprocedural/override/lang/util/ListSpace;", "remove", "index", "", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Ljava/lang/Integer;)Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nWArrayList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WArrayList.kt\ncn/sast/dataflow/interprocedural/override/lang/util/ListSpaceBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,344:1\n1863#2,2:345\n1#3:347\n*S KotlinDebug\n*F\n+ 1 WArrayList.kt\ncn/sast/dataflow/interprocedural/override/lang/util/ListSpaceBuilder\n*L\n281#1:345,2\n*E\n"})
public final class ListSpaceBuilder
implements IData.Builder<IValue> {
    @NotNull
    private final PersistentList.Builder<IHeapValues<IValue>> list;
    @Nullable
    private IHeapValues.Builder<IValue> unreferenced;

    public ListSpaceBuilder(@NotNull PersistentList.Builder<IHeapValues<IValue>> list, @Nullable IHeapValues.Builder<IValue> unreferenced) {
        Intrinsics.checkNotNullParameter(list, (String)"list");
        this.list = list;
        this.unreferenced = unreferenced;
    }

    @NotNull
    public final PersistentList.Builder<IHeapValues<IValue>> getList() {
        return this.list;
    }

    public void union(@NotNull AbstractHeapFactory<IValue> hf, @NotNull IData<IValue> that) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (!(that instanceof ListSpace)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        if (this.unreferenced != null) {
            if (((ListSpace)that).getUnreferenced() != null) {
                IHeapValues.Builder builder2 = this.unreferenced;
                Intrinsics.checkNotNull((Object)builder2);
                v1 = builder2.add(((ListSpace)that).getUnreferenced());
            } else {
                IHeapValues.Builder builder3 = this.unreferenced;
                Intrinsics.checkNotNull((Object)builder3);
                v1 = builder3.add(((ListSpace)that).getAllElement(hf));
            }
            return;
        }
        if (((ListSpace)that).getUnreferenced() != null) {
            IHeapValues.Builder builder4 = this.unreferenced = ((ListSpace)that).getUnreferenced().builder();
            Intrinsics.checkNotNull((Object)builder4);
            builder4.add(this.getAllElement(hf));
            this.list.clear();
            return;
        }
        if (this.list.size() != ((ListSpace)that).getList().size()) {
            IHeapValues.Builder unreferenced = this.getAllElement(hf).builder();
            unreferenced.add(((ListSpace)that).getAllElement(hf));
            this.unreferenced = unreferenced;
            this.list.clear();
            return;
        }
        Iterator iterator2 = ((Iterable)((ListSpace)that).getList()).iterator();
        int n = 0;
        while (iterator2.hasNext()) {
            int i = n++;
            IHeapValues v = (IHeapValues)iterator2.next();
            IHeapValues e = (IHeapValues)this.list.get(i);
            this.list.set(i, (Object)e.plus(v));
        }
    }

    private final IHeapValues<IValue> getAllElement(AbstractHeapFactory<IValue> hf) {
        IHeapValues.Builder res;
        block1: {
            res = hf.emptyBuilder();
            Iterable $this$forEach$iv = (Iterable)this.list;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                IHeapValues it = (IHeapValues)element$iv;
                boolean bl = false;
                res.add(it);
            }
            IHeapValues.Builder builder2 = this.unreferenced;
            if (builder2 == null) break block1;
            IHeapValues.Builder it = builder2;
            boolean bl = false;
            res.add(it.build());
        }
        return res.build();
    }

    public void cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        block1: {
            Intrinsics.checkNotNullParameter(re, (String)"re");
            PersistentList oldMap = this.list.build();
            Iterator iterator2 = ((Iterable)oldMap).iterator();
            int n = 0;
            while (iterator2.hasNext()) {
                int k = n++;
                IHeapValues v = (IHeapValues)iterator2.next();
                this.list.set(k, (Object)v.cloneAndReNewObjects(re.context((Object)new ReferenceContext.KVPosition((Object)k))));
            }
            IHeapValues.Builder builder2 = this.unreferenced;
            if (builder2 == null) break block1;
            builder2.cloneAndReNewObjects(re.context((Object)ReferenceContext.KVUnreferenced.INSTANCE));
        }
    }

    @NotNull
    public IData<IValue> build() {
        IHeapValues.Builder unreferenced = null;
        IHeapValues.Builder builder2 = unreferenced = this.unreferenced;
        if (builder2 != null) {
            IHeapValues.Builder it = builder2;
            boolean bl = false;
            if (it.isEmpty()) {
                unreferenced = null;
            }
        }
        IHeapValues.Builder builder3 = unreferenced;
        return (IData)new ListSpace(this.list.build(), (IHeapValues)(builder3 != null ? builder3.build() : null));
    }

    public final void add(@NotNull IHeapValues<IValue> value) {
        Intrinsics.checkNotNullParameter(value, (String)"value");
        if (this.unreferenced != null) {
            IHeapValues.Builder builder2 = this.unreferenced;
            Intrinsics.checkNotNull((Object)builder2);
            v1 = builder2.add(value);
        } else {
            v1 = this.list.add(value);
        }
    }

    public final void clear(@NotNull IHeapValues<IValue> value) {
        Intrinsics.checkNotNullParameter(value, (String)"value");
        this.unreferenced = null;
        this.list.clear();
    }

    public final void addAll(@NotNull AbstractHeapFactory<IValue> hf, @NotNull ListSpace b) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        if (this.unreferenced != null || b.getUnreferenced() != null) {
            this.union(hf, (IData)b);
        } else {
            this.list.addAll((Collection)b.getList());
        }
    }

    @NotNull
    public final IHeapValues<IValue> remove(@NotNull AbstractHeapFactory<IValue> hf, @Nullable Integer index) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        if (index == null) {
            if (this.unreferenced == null) {
                this.unreferenced = hf.emptyBuilder();
            }
            IHeapValues.Builder builder2 = this.unreferenced;
            Intrinsics.checkNotNull((Object)builder2);
            builder2.add(this.getAllElement(hf));
            this.list.clear();
            IHeapValues.Builder builder3 = this.unreferenced;
            Intrinsics.checkNotNull((Object)builder3);
            return builder3.build();
        }
        if (this.unreferenced == null) {
            if (index >= this.list.size() || index < 0) {
                return this.getAllElement(hf);
            }
            return (IHeapValues)this.list.remove(index.intValue());
        }
        return this.getAllElement(hf);
    }

    @NotNull
    public final PersistentList.Builder<IHeapValues<IValue>> component1() {
        return this.list;
    }

    private final IHeapValues.Builder<IValue> component2() {
        return this.unreferenced;
    }

    @NotNull
    public final ListSpaceBuilder copy(@NotNull PersistentList.Builder<IHeapValues<IValue>> list, @Nullable IHeapValues.Builder<IValue> unreferenced) {
        Intrinsics.checkNotNullParameter(list, (String)"list");
        return new ListSpaceBuilder(list, unreferenced);
    }

    public static /* synthetic */ ListSpaceBuilder copy$default(ListSpaceBuilder listSpaceBuilder, PersistentList.Builder builder2, IHeapValues.Builder builder3, int n, Object object) {
        if ((n & 1) != 0) {
            builder2 = listSpaceBuilder.list;
        }
        if ((n & 2) != 0) {
            builder3 = listSpaceBuilder.unreferenced;
        }
        return listSpaceBuilder.copy(builder2, builder3);
    }

    @NotNull
    public String toString() {
        return "ListSpaceBuilder(list=" + this.list + ", unreferenced=" + this.unreferenced + ")";
    }

    public int hashCode() {
        int result = this.list.hashCode();
        result = result * 31 + (this.unreferenced == null ? 0 : this.unreferenced.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListSpaceBuilder)) {
            return false;
        }
        ListSpaceBuilder listSpaceBuilder = (ListSpaceBuilder)other;
        if (!Intrinsics.areEqual((Object)this.list, (Object)listSpaceBuilder.list)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.unreferenced, (Object)listSpaceBuilder.unreferenced);
    }
}

