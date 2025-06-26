/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CallStackContext
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstract
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.ImmutableSet
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentSet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Type
 *  soot.Value
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;
import soot.Value;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002Bw\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\n\u0012(\u0010\r\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u000bj\u0002`\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\n0\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010'\u001a\u00020!J\b\u0010 \u001a\u00020!H\u0016J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010+\u001a\u00020,H\u0016J)\u0010-\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f2\u0006\u0010.\u001a\u00028\u00002\n\u0010/\u001a\u00060\u000bj\u0002`\u000eH\u0016\u00a2\u0006\u0002\u00100J\u0018\u00101\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0006\u00102\u001a\u00020\u000bH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b03H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001204H\u0016J\b\u00105\u001a\u00020)H\u0016J\b\u00106\u001a\u00020)H\u0016J\b\u00107\u001a\u00020)H\u0016J \u00108\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0006\u00109\u001a\u00020:2\u0006\u00102\u001a\u00020\u000bH\u0016J$\u0010;\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR#\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR3\u0010\r\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u000bj\u0002`\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006@"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/PointsToGraphAbstract;", "V", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "vg", "Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "callStack", "Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "slots", "Lkotlinx/collections/immutable/PersistentMap;", "", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "heap", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "calledMethods", "Lkotlinx/collections/immutable/PersistentSet;", "Lsoot/SootMethod;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;Lkotlinx/collections/immutable/PersistentMap;Lkotlinx/collections/immutable/PersistentMap;Lkotlinx/collections/immutable/PersistentSet;)V", "getHf", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getVg", "()Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "getCallStack", "()Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "getSlots", "()Lkotlinx/collections/immutable/PersistentMap;", "getHeap", "getCalledMethods", "()Lkotlinx/collections/immutable/PersistentSet;", "hashCode", "", "getHashCode", "()Ljava/lang/Integer;", "setHashCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "computeHash", "equals", "", "other", "toString", "", "getValueData", "v", "mt", "(Ljava/lang/Object;Ljava/lang/Object;)Lcn/sast/dataflow/interprocedural/analysis/IData;", "getTargetsUnsafe", "slot", "", "Lkotlinx/collections/immutable/ImmutableSet;", "isBottom", "isTop", "isValid", "getOfSlot", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "diff", "", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "corax-data-flow"})
public abstract class PointsToGraphAbstract<V>
implements IFact<V> {
    @NotNull
    private final AbstractHeapFactory<V> hf;
    @NotNull
    private final IVGlobal vg;
    @NotNull
    private final CallStackContext callStack;
    @NotNull
    private final PersistentMap<Object, IHeapValues<V>> slots;
    @NotNull
    private final PersistentMap<V, PersistentMap<Object, IData<V>>> heap;
    @NotNull
    private final PersistentSet<SootMethod> calledMethods;
    @Nullable
    private Integer hashCode;

    public PointsToGraphAbstract(@NotNull AbstractHeapFactory<V> hf, @NotNull IVGlobal vg, @NotNull CallStackContext callStack, @NotNull PersistentMap<Object, ? extends IHeapValues<V>> slots, @NotNull PersistentMap<V, ? extends PersistentMap<Object, ? extends IData<V>>> heap, @NotNull PersistentSet<? extends SootMethod> calledMethods) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)vg, (String)"vg");
        Intrinsics.checkNotNullParameter((Object)callStack, (String)"callStack");
        Intrinsics.checkNotNullParameter(slots, (String)"slots");
        Intrinsics.checkNotNullParameter(heap, (String)"heap");
        Intrinsics.checkNotNullParameter(calledMethods, (String)"calledMethods");
        this.hf = hf;
        this.vg = vg;
        this.callStack = callStack;
        this.slots = slots;
        this.heap = heap;
        this.calledMethods = calledMethods;
    }

    @NotNull
    public AbstractHeapFactory<V> getHf() {
        return this.hf;
    }

    @NotNull
    public final IVGlobal getVg() {
        return this.vg;
    }

    @NotNull
    public CallStackContext getCallStack() {
        return this.callStack;
    }

    @NotNull
    public final PersistentMap<Object, IHeapValues<V>> getSlots() {
        return this.slots;
    }

    @NotNull
    public final PersistentMap<V, PersistentMap<Object, IData<V>>> getHeap() {
        return this.heap;
    }

    @NotNull
    public final PersistentSet<SootMethod> getCalledMethods() {
        return this.calledMethods;
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
        result = 31 * result + this.slots.hashCode();
        result = 31 * result + this.heap.hashCode();
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
        if (!(other instanceof PointsToGraphAbstract)) {
            return false;
        }
        if (this.hashCode() != ((PointsToGraphAbstract)other).hashCode()) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.slots, (Object)((PointsToGraphAbstract)other).slots)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.heap, (Object)((PointsToGraphAbstract)other).heap);
    }

    @NotNull
    public String toString() {
        return this.builder().toString();
    }

    @Nullable
    public IData<V> getValueData(V v, @NotNull Object mt) {
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        PersistentMap persistentMap = (PersistentMap)this.heap.get(v);
        return persistentMap != null ? (IData)persistentMap.get(mt) : null;
    }

    @Nullable
    public IHeapValues<V> getTargetsUnsafe(@NotNull Object slot) {
        Intrinsics.checkNotNullParameter((Object)slot, (String)"slot");
        return (IHeapValues)this.slots.get(slot);
    }

    @NotNull
    public Set<Object> getSlots() {
        return this.slots.keySet();
    }

    @NotNull
    public ImmutableSet<SootMethod> getCalledMethods() {
        return (ImmutableSet)this.calledMethods;
    }

    public boolean isBottom() {
        return false;
    }

    public boolean isTop() {
        return false;
    }

    public boolean isValid() {
        return true;
    }

    @Nullable
    public IHeapValues<V> getOfSlot(@NotNull HeapValuesEnv env, @NotNull Object slot) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)slot, (String)"slot");
        return this.getTargets(slot);
    }

    public void diff(@NotNull IDiff<V> cmp, @NotNull IFact<V> that) {
        Intrinsics.checkNotNullParameter(cmp, (String)"cmp");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        if (!(that instanceof PointsToGraphAbstract)) {
            throw new IllegalArgumentException("union error of fact type: " + that.getClass() + " \n" + that);
        }
        for (Map.Entry entry : ((Map)((PointsToGraphAbstract)that).slots).entrySet()) {
            Object k = entry.getKey();
            IHeapValues v = (IHeapValues)entry.getValue();
            IHeapValues iHeapValues = (IHeapValues)this.slots.get(k);
            if (iHeapValues == null) continue;
            iHeapValues.diff(cmp, (IDiffAble)v);
        }
        for (Map.Entry entry : ((Map)((PointsToGraphAbstract)that).heap).entrySet()) {
            Object thatSource = entry.getKey();
            PersistentMap thatData = (PersistentMap)entry.getValue();
            PersistentMap persistentMap = (PersistentMap)this.heap.get(thatSource);
            if (persistentMap == null) {
                persistentMap = ExtensionsKt.persistentHashMapOf();
            }
            PersistentMap pack = persistentMap;
            for (Map.Entry entry2 : ((Map)thatData).entrySet()) {
                Object kind = entry2.getKey();
                IData valuesR = (IData)entry2.getValue();
                IData valuesL = (IData)pack.get(kind);
                if (valuesL == null || valuesL == valuesR) continue;
                valuesL.diff(cmp, (IDiffAble)valuesR);
            }
        }
    }

    @NotNull
    public IHeapValues<V> getTargets(@NotNull Object slot) {
        return IFact.DefaultImpls.getTargets((IFact)this, (Object)slot);
    }

    @Nullable
    public IHeapValues<V> getArrayLength(V array) {
        return IFact.DefaultImpls.getArrayLength((IFact)this, array);
    }

    @Nullable
    public IArrayHeapKV<Integer, V> getArray(V array) {
        return IFact.DefaultImpls.getArray((IFact)this, array);
    }

    @NotNull
    public IHeapValues<V> getOfSootValue(@NotNull HeapValuesEnv env, @NotNull Value value, @NotNull Type valueType) {
        return IFact.DefaultImpls.getOfSootValue((IFact)this, (HeapValuesEnv)env, (Value)value, (Type)valueType);
    }
}

