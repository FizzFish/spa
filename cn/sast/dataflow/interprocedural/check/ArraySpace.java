/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.ArraySpace
 *  cn.sast.dataflow.interprocedural.check.ArraySpace$Companion
 *  cn.sast.dataflow.interprocedural.check.ArraySpaceBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.PersistentMap
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.ArraySpace;
import cn.sast.dataflow.interprocedural.check.ArraySpaceBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.PersistentMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0016\u0018\u0000  2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001 Bs\b\u0000\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\r\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00072\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0015H\u0016J$\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00172\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0019H\u0016J+\u0010\u001a\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u001b2\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001cH\u0016\u00a2\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001cH\u0016\u00a8\u0006!"}, d2={"Lcn/sast/dataflow/interprocedural/check/ArraySpace;", "Lcn/sast/dataflow/interprocedural/analysis/heapimpl/ArrayHeapKV;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "element", "Lkotlinx/collections/immutable/PersistentMap;", "", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "unreferenced", "type", "Lsoot/ArrayType;", "allSize", "size", "initializedValue", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "<init>", "(Lkotlinx/collections/immutable/PersistentMap;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;Lsoot/ArrayType;Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;Ljava/lang/Integer;Lcn/sast/dataflow/interprocedural/analysis/CompanionV;)V", "builder", "Lcn/sast/dataflow/interprocedural/check/ArraySpaceBuilder;", "getElement", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "cloneAndReNewObjects", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "getArray", "", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;)[Lcn/sast/dataflow/interprocedural/analysis/IValue;", "getByteArray", "", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPointsToGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointsToGraph.kt\ncn/sast/dataflow/interprocedural/check/ArraySpace\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,612:1\n1#2:613\n1863#3,2:614\n*S KotlinDebug\n*F\n+ 1 PointsToGraph.kt\ncn/sast/dataflow/interprocedural/check/ArraySpace\n*L\n225#1:614,2\n*E\n"})
public class ArraySpace
extends ArrayHeapKV<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public ArraySpace(@NotNull PersistentMap<Integer, ? extends IHeapValues<IValue>> element, @Nullable IHeapValues<IValue> unreferenced, @NotNull ArrayType type, @NotNull IHeapValues<IValue> allSize, @Nullable Integer size, @Nullable CompanionV<IValue> initializedValue) {
        Intrinsics.checkNotNullParameter(element, (String)"element");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter(allSize, (String)"allSize");
        super(element, unreferenced, allSize, type, size, initializedValue);
    }

    @NotNull
    public ArraySpaceBuilder builder() {
        IHeapValues iHeapValues = this.getUnreferenced();
        return new ArraySpaceBuilder(this, this.getMap().builder(), (IHeapValues.Builder)(iHeapValues != null ? iHeapValues.builder() : null));
    }

    @NotNull
    public IHeapValues<IValue> getElement(@NotNull AbstractHeapFactory<IValue> hf) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        IHeapValues.Builder b = hf.emptyBuilder();
        IHeapValues iHeapValues = this.getUnreferenced();
        if (iHeapValues != null) {
            IHeapValues it = iHeapValues;
            boolean bl = false;
            b.add(it);
        }
        Iterable $this$forEach$iv = this.getMap().values();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IHeapValues it = (IHeapValues)element$iv;
            boolean bl = false;
            b.add(it);
        }
        return b.build();
    }

    @NotNull
    public IData<IValue> cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        ArraySpaceBuilder b = this.builder();
        b.cloneAndReNewObjects(re);
        return b.build();
    }

    @Nullable
    public IValue[] getArray(@NotNull IHeapValuesFactory<IValue> hf) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        if (this.getSize() == null) {
            return null;
        }
        int n = 0;
        Integer n2 = this.getSize();
        IValue[] iValueArray = new IValue[n2.intValue()];
        while (n < n2) {
            IHeapValues exist;
            int n3;
            if (this.get(hf, Integer.valueOf(n3 = n++)) == null) {
                return null;
            }
            if (!exist.isSingle()) {
                return null;
            }
            iValueArray[n3] = exist.getSingle().getValue();
        }
        return iValueArray;
    }

    @Nullable
    public byte[] getByteArray(@NotNull IHeapValuesFactory<IValue> hf) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        IValue[] iValueArray = this.getArray(hf);
        if (iValueArray == null) {
            return null;
        }
        IValue[] arr = iValueArray;
        int n = arr.length;
        byte[] byArray = new byte[n];
        for (int i = 0; i < n; ++i) {
            int n2 = i;
            IValue iValue = arr[n2];
            Object object = iValue instanceof ConstVal ? (ConstVal)iValue : null;
            if (object == null || (object = FactValuesKt.getByteValue((IValue)((IValue)object), (boolean)true)) == null) {
                return null;
            }
            byArray[n2] = (Byte)object;
        }
        return byArray;
    }
}

