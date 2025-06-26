/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.override.lang.util.ListSpace
 *  cn.sast.dataflow.interprocedural.override.lang.util.ListSpaceBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.dataflow.interprocedural.override.lang.util;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.override.lang.util.ListSpaceBuilder;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B7\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0016\u001a\u00020\u000f2\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00182\u0010\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\"\u0010!\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00062\u0010\u0010\"\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030#J6\u0010$\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u00062\u0010\u0010\"\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030#2\b\u0010%\u001a\u0004\u0018\u00010\u0015H\u0086\u0002\u00a2\u0006\u0002\u0010&J$\u0010'\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010(\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030)H\u0016J\u0019\u0010*\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00060\u0005H\u00c6\u0003J\u0015\u0010+\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u0006H\u00c6\u0003J9\u0010,\u001a\u00020\u00002\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u0006H\u00c6\u0001J\t\u0010-\u001a\u00020.H\u00d6\u0001R!\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001d\u00a8\u0006/"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/util/ListSpace;", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "list", "Lkotlinx/collections/immutable/PersistentList;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "<init>", "(Lkotlinx/collections/immutable/PersistentList;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)V", "getList", "()Lkotlinx/collections/immutable/PersistentList;", "getUnreferenced", "()Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "reference", "", "res", "", "builder", "Lcn/sast/dataflow/interprocedural/override/lang/util/ListSpaceBuilder;", "computeHash", "", "diff", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IDiffAble;", "", "hashCode", "Ljava/lang/Integer;", "equals", "", "other", "getAllElement", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "get", "index", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Ljava/lang/Integer;)Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "cloneAndReNewObjects", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "component1", "component2", "copy", "toString", "", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nWArrayList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WArrayList.kt\ncn/sast/dataflow/interprocedural/override/lang/util/ListSpace\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,344:1\n1#2:345\n1863#3,2:346\n*S KotlinDebug\n*F\n+ 1 WArrayList.kt\ncn/sast/dataflow/interprocedural/override/lang/util/ListSpace\n*L\n219#1:346,2\n*E\n"})
public final class ListSpace
implements IData<IValue> {
    @NotNull
    private final PersistentList<IHeapValues<IValue>> list;
    @Nullable
    private final IHeapValues<IValue> unreferenced;
    @Nullable
    private Integer hashCode;

    public ListSpace(@NotNull PersistentList<? extends IHeapValues<IValue>> list, @Nullable IHeapValues<IValue> unreferenced) {
        Intrinsics.checkNotNullParameter(list, (String)"list");
        this.list = list;
        this.unreferenced = unreferenced;
        if (!(this.unreferenced == null || this.unreferenced.isNotEmpty())) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
    }

    public /* synthetic */ ListSpace(PersistentList persistentList, IHeapValues iHeapValues, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            persistentList = ExtensionsKt.persistentListOf();
        }
        if ((n & 2) != 0) {
            iHeapValues = null;
        }
        this(persistentList, iHeapValues);
    }

    @NotNull
    public final PersistentList<IHeapValues<IValue>> getList() {
        return this.list;
    }

    @Nullable
    public final IHeapValues<IValue> getUnreferenced() {
        return this.unreferenced;
    }

    public void reference(@NotNull Collection<IValue> res) {
        Intrinsics.checkNotNullParameter(res, (String)"res");
        for (IHeapValues e : this.list) {
            e.reference(res);
        }
    }

    @NotNull
    public ListSpaceBuilder builder() {
        IHeapValues iHeapValues = this.unreferenced;
        return new ListSpaceBuilder(this.list.builder(), (IHeapValues.Builder)(iHeapValues != null ? iHeapValues.builder() : null));
    }

    public int computeHash() {
        int result = 1;
        result = 31 * result + this.list.hashCode();
        IHeapValues iHeapValues = this.unreferenced;
        result = 31 * result + (iHeapValues != null ? iHeapValues.hashCode() : 0);
        return result + 1231;
    }

    public void diff(@NotNull IDiff<IValue> cmp, @NotNull IDiffAble<? extends Object> that) {
        block4: {
            Intrinsics.checkNotNullParameter(cmp, (String)"cmp");
            Intrinsics.checkNotNullParameter(that, (String)"that");
            if (this == that) {
                return;
            }
            if (!(that instanceof ListSpace)) {
                return;
            }
            Iterator iterator2 = ((Iterable)this.list).iterator();
            int n = 0;
            while (iterator2.hasNext()) {
                int i = n++;
                IHeapValues l = (IHeapValues)iterator2.next();
                if (i >= ((ListSpace)that).list.size()) break;
                l.diff(cmp, (IDiffAble)((ListSpace)that).list.get(i));
            }
            IHeapValues iHeapValues = ((ListSpace)that).unreferenced;
            if (iHeapValues == null) break block4;
            IHeapValues it = iHeapValues;
            boolean bl = false;
            IHeapValues iHeapValues2 = this.unreferenced;
            if (iHeapValues2 != null) {
                iHeapValues2.diff(cmp, (IDiffAble)it);
            }
        }
    }

    public int hashCode() {
        Integer hash = this.hashCode;
        if (hash == null) {
            this.hashCode = hash = Integer.valueOf(this.computeHash());
        }
        return hash;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListSpace)) {
            return false;
        }
        if (this.hashCode() != ((ListSpace)other).hashCode()) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.list, (Object)((ListSpace)other).list) && Intrinsics.areEqual((Object)this.unreferenced, (Object)((ListSpace)other).unreferenced);
    }

    @NotNull
    public final IHeapValues<IValue> getAllElement(@NotNull AbstractHeapFactory<IValue> hf) {
        IHeapValues.Builder res;
        block1: {
            Intrinsics.checkNotNullParameter(hf, (String)"hf");
            res = hf.emptyBuilder();
            Iterable $this$forEach$iv = (Iterable)this.list;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                IHeapValues it = (IHeapValues)element$iv;
                boolean bl = false;
                res.add(it);
            }
            IHeapValues iHeapValues = this.unreferenced;
            if (iHeapValues == null) break block1;
            IHeapValues it = iHeapValues;
            boolean bl = false;
            res.add(it);
        }
        return res.build();
    }

    @Nullable
    public final IHeapValues<IValue> get(@NotNull AbstractHeapFactory<IValue> hf, @Nullable Integer index) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        if (index == null || this.unreferenced != null) {
            return this.getAllElement(hf);
        }
        if (index >= this.list.size() || index < 0) {
            return null;
        }
        return (IHeapValues)this.list.get(index.intValue());
    }

    @NotNull
    public IData<IValue> cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        ListSpaceBuilder b = this.builder();
        b.cloneAndReNewObjects(re);
        return b.build();
    }

    @NotNull
    public final PersistentList<IHeapValues<IValue>> component1() {
        return this.list;
    }

    @Nullable
    public final IHeapValues<IValue> component2() {
        return this.unreferenced;
    }

    @NotNull
    public final ListSpace copy(@NotNull PersistentList<? extends IHeapValues<IValue>> list, @Nullable IHeapValues<IValue> unreferenced) {
        Intrinsics.checkNotNullParameter(list, (String)"list");
        return new ListSpace(list, unreferenced);
    }

    public static /* synthetic */ ListSpace copy$default(ListSpace listSpace, PersistentList persistentList, IHeapValues iHeapValues, int n, Object object) {
        if ((n & 1) != 0) {
            persistentList = listSpace.list;
        }
        if ((n & 2) != 0) {
            iHeapValues = listSpace.unreferenced;
        }
        return listSpace.copy(persistentList, iHeapValues);
    }

    @NotNull
    public String toString() {
        return "ListSpace(list=" + this.list + ", unreferenced=" + this.unreferenced + ")";
    }

    public ListSpace() {
        this(null, null, 3, null);
    }
}

