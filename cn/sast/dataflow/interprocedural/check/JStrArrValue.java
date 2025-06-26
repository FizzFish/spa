/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IDiffAble
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.JStrArrValue
 *  cn.sast.dataflow.interprocedural.check.JStrArrValue$Companion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 *  soot.ByteType
 *  soot.G
 *  soot.Type
 *  soot.Unit
 *  soot.jimple.Constant
 *  soot.jimple.IntConstant
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IDiffAble;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JOperatorV;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.JStrArrValue;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.ByteType;
import soot.G;
import soot.Type;
import soot.Unit;
import soot.jimple.Constant;
import soot.jimple.IntConstant;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001:\u0001:B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ5\u0010\u001b\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00162\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0010\u0010%\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040&H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J,\u0010(\u001a\u00020$2\u0010\u0010)\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040*2\u0010\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010-H\u0096\u0002J$\u00102\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u0004032\u0010\u00104\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u000405H\u0016J\u0012\u00106\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0016H\u0016J$\u00107\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00162\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\bH\u0016J)\u00108\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00182\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u001cH\u0016\u00a2\u0006\u0002\u00109J\u001a\u0010\u000f\u001a\u00020\n2\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u001cH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00190\u0018X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001a\u00a8\u0006;"}, d2={"Lcn/sast/dataflow/interprocedural/check/JStrArrValue;", "Lcn/sast/dataflow/interprocedural/analysis/heapimpl/IArrayHeapKV;", "", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/check/V;", "node", "Lsoot/Unit;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "byteArray", "", "<init>", "(Lsoot/Unit;Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;[B)V", "getNode", "()Lsoot/Unit;", "getByteArray", "()[B", "type", "Lsoot/ArrayType;", "getType", "()Lsoot/ArrayType;", "arrayLength", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "byteArrayConstVal", "", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "[Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "get", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;", "key", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;Ljava/lang/Integer;)Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "toString", "", "builder", "Lcn/sast/dataflow/interprocedural/analysis/IHeapKVData$Builder;", "reference", "", "res", "", "computeHash", "diff", "cmp", "Lcn/sast/dataflow/interprocedural/analysis/IDiff;", "that", "Lcn/sast/dataflow/interprocedural/analysis/IDiffAble;", "", "hashCode", "equals", "", "other", "cloneAndReNewObjects", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "re", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "getArrayLength", "getElement", "getArray", "(Lcn/sast/dataflow/interprocedural/analysis/IHeapValuesFactory;)[Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nHeapFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeapFactory.kt\ncn/sast/dataflow/interprocedural/check/JStrArrValue\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1430:1\n13409#2,2:1431\n13409#2,2:1433\n*S KotlinDebug\n*F\n+ 1 HeapFactory.kt\ncn/sast/dataflow/interprocedural/check/JStrArrValue\n*L\n92#1:1431,2\n164#1:1433,2\n*E\n"})
public final class JStrArrValue
implements IArrayHeapKV<Integer, IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Unit node;
    @NotNull
    private final byte[] byteArray;
    @NotNull
    private final ArrayType type;
    @NotNull
    private final IHeapValues<IValue> arrayLength;
    @NotNull
    private final CompanionV<IValue>[] byteArrayConstVal;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(JStrArrValue::logger$lambda$4);

    public JStrArrValue(@NotNull Unit node, @NotNull AbstractHeapFactory<IValue> hf, @NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)byteArray, (String)"byteArray");
        this.node = node;
        this.byteArray = byteArray;
        this.type = hf.getVg().getBYTE_ARRAY_TYPE();
        JStrArrValue jStrArrValue = this;
        boolean bl = false;
        IntConstant it = IntConstant.v((int)this.byteArray.length);
        boolean bl2 = false;
        HeapValuesEnv heapValuesEnv = hf.env(this.node);
        Intrinsics.checkNotNull((Object)it);
        jStrArrValue.arrayLength = JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)hf.push(heapValuesEnv, hf.newConstVal((Constant)it, (Type)this.getType())), (Constant)((Constant)it), null, (int)2, null).popHV();
        int n = 0;
        int n2 = this.byteArray.length;
        CompanionV[] companionVArray = new CompanionV[n2];
        jStrArrValue = this;
        while (n < n2) {
            int n3 = n++;
            IntConstant v = IntConstant.v((int)this.byteArray[n3]);
            Intrinsics.checkNotNull((Object)v);
            Constant constant = (Constant)v;
            ByteType byteType = G.v().soot_ByteType();
            Intrinsics.checkNotNullExpressionValue((Object)byteType, (String)"soot_ByteType(...)");
            IValue cv = (IValue)hf.newConstVal(constant, (Type)byteType);
            companionVArray[n3] = JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)hf.push(hf.env(this.node), (Object)cv), (Constant)((Constant)v), null, (int)2, null).pop();
        }
        jStrArrValue.byteArrayConstVal = companionVArray;
    }

    @NotNull
    public final Unit getNode() {
        return this.node;
    }

    @NotNull
    public final byte[] getByteArray() {
        return this.byteArray;
    }

    @NotNull
    public ArrayType getType() {
        return this.type;
    }

    @Nullable
    public IHeapValues<IValue> get(@NotNull IHeapValuesFactory<IValue> hf, @Nullable Integer key2) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        if (key2 != null) {
            if (key2 < 0 || key2 >= this.byteArray.length) {
                return null;
            }
            return hf.single(this.byteArrayConstVal[key2]);
        }
        IHeapValues.Builder b = hf.emptyBuilder();
        CompanionV[] $this$forEach$iv = this.byteArrayConstVal;
        boolean $i$f$forEach = false;
        int n = $this$forEach$iv.length;
        for (int i = 0; i < n; ++i) {
            CompanionV element$iv;
            CompanionV it = element$iv = $this$forEach$iv[i];
            boolean bl = false;
            b.add(it);
        }
        return b.build();
    }

    @NotNull
    public String toString() {
        return "ImByteArray_" + new String(this.byteArray, Charsets.UTF_8);
    }

    @NotNull
    public IHeapKVData.Builder<Integer, IValue> builder() {
        return (IHeapKVData.Builder)new /* Unavailable Anonymous Inner Class!! */;
    }

    public void reference(@NotNull Collection<IValue> res) {
        Intrinsics.checkNotNullParameter(res, (String)"res");
    }

    public int computeHash() {
        return 1138 + Arrays.hashCode(this.byteArray);
    }

    public void diff(@NotNull IDiff<IValue> cmp, @NotNull IDiffAble<? extends Object> that) {
        Intrinsics.checkNotNullParameter(cmp, (String)"cmp");
        Intrinsics.checkNotNullParameter(that, (String)"that");
    }

    public int hashCode() {
        return this.computeHash();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JStrArrValue)) {
            return false;
        }
        if (this.hashCode() != ((JStrArrValue)other).hashCode()) {
            return false;
        }
        return Arrays.equals(this.byteArray, ((JStrArrValue)other).byteArray);
    }

    @NotNull
    public IData<IValue> cloneAndReNewObjects(@NotNull IReNew<IValue> re) {
        Intrinsics.checkNotNullParameter(re, (String)"re");
        return (IData)this;
    }

    @NotNull
    public IHeapValues<IValue> getArrayLength() {
        return this.arrayLength;
    }

    @NotNull
    public IHeapValues<IValue> getElement(@NotNull AbstractHeapFactory<IValue> hf) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        IHeapValues.Builder b = hf.emptyBuilder();
        CompanionV[] $this$forEach$iv = this.byteArrayConstVal;
        boolean $i$f$forEach = false;
        int n = $this$forEach$iv.length;
        for (int i = 0; i < n; ++i) {
            CompanionV element$iv;
            CompanionV it = element$iv = $this$forEach$iv[i];
            boolean bl = false;
            b.add(it);
        }
        return b.build();
    }

    @NotNull
    public IValue[] getArray(@NotNull IHeapValuesFactory<IValue> hf) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        int n = 0;
        int n2 = this.byteArrayConstVal.length;
        IValue[] iValueArray = new IValue[n2];
        while (n < n2) {
            int n3 = n++;
            iValueArray[n3] = this.byteArrayConstVal[n3].getValue();
        }
        return iValueArray;
    }

    @NotNull
    public byte[] getByteArray(@NotNull IHeapValuesFactory<IValue> hf) {
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        return this.byteArray;
    }

    private static final kotlin.Unit logger$lambda$4() {
        return kotlin.Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

