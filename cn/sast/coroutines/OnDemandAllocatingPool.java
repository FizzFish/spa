/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.coroutines.OnDemandAllocatingPool
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlinx.atomicfu.AtomicArray
 *  kotlinx.atomicfu.AtomicFU
 *  kotlinx.atomicfu.AtomicFU_commonKt
 *  kotlinx.atomicfu.AtomicInt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.coroutines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.atomicfu.AtomicArray;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicFU_commonKt;
import kotlinx.atomicfu.AtomicInt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004H\u0082\bJ\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0004H\u0082\bJ\u0006\u0010\u0010\u001a\u00020\u000fJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\r\u0010\u0013\u001a\u00020\u0014H\u0000\u00a2\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lcn/sast/coroutines/OnDemandAllocatingPool;", "T", "", "maxCapacity", "", "create", "Lkotlin/Function1;", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "controlState", "Lkotlinx/atomicfu/AtomicInt;", "elements", "Lkotlinx/atomicfu/AtomicArray;", "tryForbidNewElements", "isClosed", "", "allocate", "close", "", "stateRepresentation", "", "stateRepresentation$corax_api", "toString", "corax-api"})
@SourceDebugExtension(value={"SMAP\nOnDemandAllocatingPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnDemandAllocatingPool.kt\ncn/sast/coroutines/OnDemandAllocatingPool\n+ 2 AtomicFU.common.kt\nkotlinx/atomicfu/AtomicFU_commonKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 OnDemandAllocatingPool.kt\ncn/sast/coroutines/OnDemandAllocatingPoolKt\n*L\n1#1,108:1\n43#1:111\n43#1:114\n36#1:115\n37#1,7:118\n43#1:135\n350#2,2:109\n350#2,2:112\n350#2,2:116\n1557#3:125\n1628#3,2:126\n1630#3:130\n1557#3:131\n1628#3,3:132\n103#4,2:128\n*S KotlinDebug\n*F\n+ 1 OnDemandAllocatingPool.kt\ncn/sast/coroutines/OnDemandAllocatingPool\n*L\n37#1:111\n56#1:114\n78#1:115\n78#1:118,7\n94#1:135\n36#1:109,2\n55#1:112,2\n78#1:116,2\n79#1:125\n79#1:126,2\n79#1:130\n93#1:131\n93#1:132,3\n81#1:128,2\n*E\n"})
public final class OnDemandAllocatingPool<T> {
    private final int maxCapacity;
    @NotNull
    private final Function1<Integer, T> create;
    @NotNull
    private final AtomicInt controlState;
    @NotNull
    private final AtomicArray<T> elements;

    public OnDemandAllocatingPool(int maxCapacity, @NotNull Function1<? super Integer, ? extends T> create) {
        Intrinsics.checkNotNullParameter(create, (String)"create");
        this.maxCapacity = maxCapacity;
        this.create = create;
        this.controlState = AtomicFU.atomic((int)0);
        this.elements = AtomicFU_commonKt.atomicArrayOfNulls((int)this.maxCapacity);
    }

    private final int tryForbidNewElements() {
        int it;
        boolean $i$f$tryForbidNewElements = false;
        AtomicInt $this$loop$iv = this.controlState;
        boolean $i$f$loop = false;
        do {
            it = $this$loop$iv.getValue();
            boolean bl = false;
            OnDemandAllocatingPool onDemandAllocatingPool = this;
            int $this$isClosed$iv = it;
            boolean $i$f$isClosed = false;
            if (!(($this$isClosed$iv & Integer.MIN_VALUE) != 0)) continue;
            return 0;
        } while (!this.controlState.compareAndSet(it, it | Integer.MIN_VALUE));
        return it;
    }

    private final boolean isClosed(int $this$isClosed) {
        boolean $i$f$isClosed = false;
        return ($this$isClosed & Integer.MIN_VALUE) != 0;
    }

    public final boolean allocate() {
        int ctl;
        AtomicInt $this$loop$iv = this.controlState;
        boolean $i$f$loop = false;
        do {
            ctl = $this$loop$iv.getValue();
            boolean bl = false;
            OnDemandAllocatingPool onDemandAllocatingPool = this;
            int $this$isClosed$iv = ctl;
            boolean $i$f$isClosed = false;
            if (($this$isClosed$iv & Integer.MIN_VALUE) != 0) {
                return false;
            }
            if (ctl < this.maxCapacity) continue;
            return true;
        } while (!this.controlState.compareAndSet(ctl, ctl + 1));
        this.elements.get(ctl).setValue(this.create.invoke((Object)ctl));
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<T> close() {
        void $this$mapTo$iv$iv;
        int n;
        int $this$isClosed$iv$iv;
        Object $this$loop$iv$iv;
        block3: {
            int it$iv;
            OnDemandAllocatingPool this_$iv = this;
            boolean $i$f$tryForbidNewElements = false;
            $this$loop$iv$iv = this_$iv.controlState;
            boolean $i$f$loop = false;
            do {
                it$iv = $this$loop$iv$iv.getValue();
                boolean bl = false;
                OnDemandAllocatingPool onDemandAllocatingPool = this_$iv;
                $this$isClosed$iv$iv = it$iv;
                boolean $i$f$isClosed = false;
                if (!(($this$isClosed$iv$iv & Integer.MIN_VALUE) != 0)) continue;
                n = 0;
                break block3;
            } while (!this_$iv.controlState.compareAndSet(it$iv, it$iv | Integer.MIN_VALUE));
            n = it$iv;
        }
        int elementsExisting = n;
        Iterable $this$map$iv = (Iterable)RangesKt.until((int)0, (int)elementsExisting);
        boolean $i$f$map = false;
        $this$loop$iv$iv = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void i;
            Object element;
            int item$iv$iv;
            $this$isClosed$iv$iv = item$iv$iv = ((IntIterator)iterator2).nextInt();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            boolean $i$f$loop = false;
            do {
                boolean bl2 = false;
            } while ((element = this.elements.get((int)i).getAndSet(null)) == null);
            collection.add(element);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final String stateRepresentation$corax_api() {
        void $this$mapTo$iv$iv;
        int ctl = this.controlState.getValue();
        Iterable $this$map$iv = (Iterable)RangesKt.until((int)0, (int)(ctl & Integer.MAX_VALUE));
        boolean $i$f$map22 = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void it;
            int item$iv$iv;
            int n = item$iv$iv = ((IntIterator)iterator2).nextInt();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(this.elements.get((int)it).getValue());
        }
        String elementsStr = ((List)destination$iv$iv).toString();
        OnDemandAllocatingPool $i$f$map22 = this;
        int $this$isClosed$iv = ctl;
        boolean $i$f$isClosed = false;
        String closedStr = ($this$isClosed$iv & Integer.MIN_VALUE) != 0 ? "[closed]" : "";
        return elementsStr + closedStr;
    }

    @NotNull
    public String toString() {
        return "OnDemandAllocatingPool(" + this.stateRepresentation$corax_api() + ")";
    }
}

