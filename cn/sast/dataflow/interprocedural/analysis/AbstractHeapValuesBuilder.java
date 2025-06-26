/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapValuesBuilder
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.ReferenceContext$ObjectValues
 *  cn.sast.dataflow.util.Printer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapValues;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.ReferenceContext;
import cn.sast.dataflow.util.Printer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B1\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0001\u001c\u00a8\u0006\u001d"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapValuesBuilder;", "V", "", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues$Builder;", "orig", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapValues;", "map", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapValues;Lkotlinx/collections/immutable/PersistentMap$Builder;)V", "getOrig", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapValues;", "getMap", "()Lkotlinx/collections/immutable/PersistentMap$Builder;", "isNotEmpty", "", "isEmpty", "add", "elements", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "element", "cloneAndReNewObjects", "", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "toString", "", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesBuilder;", "corax-data-flow"})
public abstract class AbstractHeapValuesBuilder<V>
implements IHeapValues.Builder<V> {
    @NotNull
    private final AbstractHeapValues<V> orig;
    @NotNull
    private final PersistentMap.Builder<V, CompanionV<V>> map;

    private AbstractHeapValuesBuilder(AbstractHeapValues<V> orig, PersistentMap.Builder<V, CompanionV<V>> map) {
        this.orig = orig;
        this.map = map;
    }

    @NotNull
    public AbstractHeapValues<V> getOrig() {
        return this.orig;
    }

    @NotNull
    public final PersistentMap.Builder<V, CompanionV<V>> getMap() {
        return this.map;
    }

    public boolean isNotEmpty() {
        return !((Map)this.map).isEmpty();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @NotNull
    public IHeapValues.Builder<V> add(@NotNull IHeapValues<V> elements) {
        Intrinsics.checkNotNullParameter(elements, (String)"elements");
        if (elements instanceof AbstractHeapValues) {
            for (CompanionV e : (AbstractHeapValues)elements) {
                this.add(e);
            }
        }
        return (IHeapValues.Builder)this;
    }

    @NotNull
    public IHeapValues.Builder<V> add(@NotNull CompanionV<V> element) {
        Intrinsics.checkNotNullParameter(element, (String)"element");
        Object k = element.getValue();
        CompanionV existV = (CompanionV)this.map.get(k);
        if (existV == null) {
            ((Map)this.map).put(k, element);
        } else {
            ((Map)this.map).put(k, existV.union(element));
        }
        return (IHeapValues.Builder)this;
    }

    public void cloneAndReNewObjects(@NotNull IReNew<V> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        PersistentMap old = this.map.build();
        for (Map.Entry entry : ((Map)old).entrySet()) {
            CompanionV newValue;
            CompanionV companionV;
            Object newKey;
            Object k = entry.getKey();
            CompanionV v = (CompanionV)entry.getValue();
            Object object = re.checkNeedReplace(k);
            if (object == null) {
                object = newKey = k;
            }
            if ((companionV = re.context((Object)new ReferenceContext.ObjectValues(k)).checkNeedReplace(v)) == null) {
                companionV = newValue = v;
            }
            if (Intrinsics.areEqual(k, (Object)newKey) && newValue == v) continue;
            if (!Intrinsics.areEqual((Object)newValue.getValue(), (Object)newKey)) {
                newValue = newValue.copy(newKey);
            }
            ((Map)this.map).put(newKey, newValue);
            if (Intrinsics.areEqual(k, (Object)newKey)) continue;
            this.map.remove(k);
        }
    }

    @NotNull
    public String toString() {
        return Printer.Companion.nodes2String(this.map.values());
    }

    public /* synthetic */ AbstractHeapValuesBuilder(AbstractHeapValues orig, PersistentMap.Builder map, DefaultConstructorMarker $constructor_marker) {
        this(orig, map);
    }
}

