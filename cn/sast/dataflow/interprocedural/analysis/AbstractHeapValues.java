/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.util.Printer
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.ImmutableSet
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.jimple.Constant
 *  soot.jimple.IntConstant
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.util.Printer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.Constant;
import soot.jimple.IntConstant;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\b\u0004\u0012\u001a\b\u0002\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u000bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J(\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0010\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u001bH\u0016J\u0016\u0010(\u001a\u00020\u00172\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0016J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096\u0002J6\u0010\u0003\u001a\u00020\u00172\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u0000012\u001e\u00102\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000503H\u0016J<\u00104\u001a\u00020\u00172\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u0000012$\u00102\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050503H\u0016J\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001072\u0006\u00108\u001a\u00020\u0013H\u0016J\u0015\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050:H\u0096\u0002J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000=H\u0016J\b\u0010>\u001a\u00020?H\u0016R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R \u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010%\u0082\u0001\u0001@\u00a8\u0006A"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapValues;", "V", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "map", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "<init>", "(Lkotlinx/collections/immutable/PersistentMap;)V", "getMap", "()Lkotlinx/collections/immutable/PersistentMap;", "hashCode", "", "getHashCode", "()Ljava/lang/Integer;", "setHashCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "computeHash", "equals", "", "other", "", "diff", "", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IDiffAble;", "single", "getSingle", "()Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "size", "getSize", "()I", "values", "Lkotlinx/collections/immutable/ImmutableSet;", "getValues", "()Lkotlinx/collections/immutable/ImmutableSet;", "valuesCompanion", "getValuesCompanion", "reference", "res", "", "isNotEmpty", "isEmpty", "isSingle", "plus", "rhs", "c", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "transform", "Lkotlin/Function1;", "flatMap", "", "getAllIntValue", "", "must", "iterator", "", "cloneAndReNewObjects", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "toString", "", "Lcn/sast/dataflow/interprocedural/analysis/HeapValues;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPointsToGraphAbstract.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointsToGraphAbstract.kt\ncn/sast/dataflow/interprocedural/analysis/AbstractHeapValues\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1045:1\n1#2:1046\n1#2:1049\n1619#3:1047\n1863#3:1048\n1864#3:1050\n1620#3:1051\n*S KotlinDebug\n*F\n+ 1 PointsToGraphAbstract.kt\ncn/sast/dataflow/interprocedural/analysis/AbstractHeapValues\n*L\n251#1:1049\n251#1:1047\n251#1:1048\n251#1:1050\n251#1:1051\n*E\n"})
public abstract class AbstractHeapValues<V>
implements IHeapValues<V> {
    @NotNull
    private final PersistentMap<V, CompanionV<V>> map;
    @Nullable
    private Integer hashCode;

    private AbstractHeapValues(PersistentMap<V, ? extends CompanionV<V>> map) {
        this.map = map;
    }

    public /* synthetic */ AbstractHeapValues(PersistentMap persistentMap, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            persistentMap = ExtensionsKt.persistentHashMapOf();
        }
        this(persistentMap, null);
    }

    @NotNull
    public final PersistentMap<V, CompanionV<V>> getMap() {
        return this.map;
    }

    @Nullable
    public final Integer getHashCode() {
        return this.hashCode;
    }

    public final void setHashCode(@Nullable Integer n) {
        this.hashCode = n;
    }

    public final int computeHash() {
        int result = 1;
        result = 31 * result + this.map.hashCode();
        return result;
    }

    public int hashCode() {
        Integer h = this.hashCode;
        if (h == null) {
            this.hashCode = h = Integer.valueOf(this.computeHash());
        }
        return h;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbstractHeapValues)) {
            return false;
        }
        if (this.hashCode() != ((AbstractHeapValues)other).hashCode()) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.map, (Object)((AbstractHeapValues)other).map);
    }

    public void diff(@NotNull IDiff<V> cmp, @NotNull IDiffAble<? extends Object> that) {
        Intrinsics.checkNotNullParameter(cmp, (String)"cmp");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (!(that instanceof AbstractHeapValues)) {
            return;
        }
        for (Object k : CollectionsKt.intersect((Iterable)this.map.keySet(), (Iterable)((AbstractHeapValues)that).map.keySet())) {
            Object v = ((Map)this.map).get(k);
            Intrinsics.checkNotNull(v);
            CompanionV companionV = (CompanionV)v;
            Object v2 = ((Map)((AbstractHeapValues)that).map).get(k);
            Intrinsics.checkNotNull(v2);
            cmp.diff(companionV, (CompanionV)v2);
        }
    }

    @NotNull
    public CompanionV<V> getSingle() {
        if (!this.isSingle()) {
            boolean bl = false;
            String string = "error size of " + this;
            throw new IllegalArgumentException(string.toString());
        }
        return (CompanionV)this.iterator().next();
    }

    public int getSize() {
        return this.map.size();
    }

    @NotNull
    public ImmutableSet<V> getValues() {
        return (ImmutableSet)this.map.keySet();
    }

    @NotNull
    public ImmutableSet<CompanionV<V>> getValuesCompanion() {
        Set r = new LinkedHashSet();
        for (CompanionV e : this) {
            r.add(e);
        }
        return ExtensionsKt.toImmutableSet((Iterable)r);
    }

    public void reference(@NotNull Collection<V> res) {
        Intrinsics.checkNotNullParameter(res, (String)"res");
        res.addAll(this.map.keySet());
    }

    public boolean isNotEmpty() {
        return !((Map)this.map).isEmpty();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean isSingle() {
        return this.map.size() == 1;
    }

    @NotNull
    public IHeapValues<V> plus(@NotNull IHeapValues<V> rhs) {
        IHeapValues.Builder builder2;
        Intrinsics.checkNotNullParameter(rhs, (String)"rhs");
        if (rhs.isEmpty()) {
            return (IHeapValues)this;
        }
        if (this.isEmpty()) {
            return rhs;
        }
        IHeapValues.Builder it = builder2 = this.builder();
        boolean bl = false;
        it.add(rhs);
        return builder2.build();
    }

    @NotNull
    public IHeapValues<V> plus(@NotNull CompanionV<V> rhs) {
        IHeapValues.Builder builder2;
        Intrinsics.checkNotNullParameter(rhs, (String)"rhs");
        IHeapValues.Builder it = builder2 = this.builder();
        boolean bl = false;
        it.add(rhs);
        return builder2.build();
    }

    public void map(@NotNull IHeapValues.Builder<V> c, @NotNull Function1<? super CompanionV<V>, ? extends CompanionV<V>> transform) {
        Intrinsics.checkNotNullParameter(c, (String)"c");
        Intrinsics.checkNotNullParameter(transform, (String)"transform");
        for (CompanionV e : this) {
            c.add((CompanionV)transform.invoke((Object)e));
        }
    }

    public void flatMap(@NotNull IHeapValues.Builder<V> c, @NotNull Function1<? super CompanionV<V>, ? extends Collection<? extends CompanionV<V>>> transform) {
        Intrinsics.checkNotNullParameter(c, (String)"c");
        Intrinsics.checkNotNullParameter(transform, (String)"transform");
        for (CompanionV e : this) {
            for (CompanionV t : (Collection)transform.invoke((Object)e)) {
                c.add(t);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public Set<Integer> getAllIntValue(boolean must) {
        void var3_3;
        void $this$mapNotNullTo$iv;
        Iterable iterable = this.map.keySet();
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv = $this$mapNotNullTo$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Integer it$iv;
            Integer num;
            Object element$iv$iv;
            Object element$iv = element$iv$iv = iterator2.next();
            boolean bl = false;
            Object it = element$iv;
            boolean bl2 = false;
            ConstVal constVal = it instanceof ConstVal ? (ConstVal)it : null;
            Constant constant = constVal != null ? constVal.getV() : null;
            IntConstant intConstant = constant instanceof IntConstant ? (IntConstant)constant : null;
            Integer n = num = intConstant != null ? Integer.valueOf(intConstant.value) : null;
            if (must && num == null) {
                return null;
            }
            if (num == null) continue;
            boolean bl3 = false;
            destination$iv.add(it$iv);
        }
        return (Set)var3_3;
    }

    @NotNull
    public Iterator<CompanionV<V>> iterator() {
        Iterator mi = ((Map)this.map).entrySet().iterator();
        return (Iterator)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public IHeapValues<V> cloneAndReNewObjects(@NotNull IReNew<V> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        IHeapValues.Builder b = this.builder();
        b.cloneAndReNewObjects(re);
        return b.build();
    }

    @NotNull
    public String toString() {
        return Printer.Companion.nodes2String(this.map.values());
    }

    @Nullable
    public Integer getMaxInt(boolean must) {
        return IHeapValues.DefaultImpls.getMaxInt((IHeapValues)this, (boolean)must);
    }

    public /* synthetic */ AbstractHeapValues(PersistentMap map, DefaultConstructorMarker $constructor_marker) {
        this(map);
    }
}

