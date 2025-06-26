/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.HeapFactoryKt
 *  cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModelingKt
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap
 *  cn.sast.dataflow.interprocedural.override.lang.WString
 *  cn.sast.dataflow.interprocedural.override.lang.WStringKt
 *  cn.sast.dataflow.util.SootUtilsKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 *  soot.ByteType
 *  soot.G
 *  soot.SootField
 *  soot.Type
 *  soot.jimple.Constant
 *  soot.jimple.StringConstant
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.HeapFactoryKt;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModelingKt;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap;
import cn.sast.dataflow.interprocedural.override.lang.WString;
import cn.sast.dataflow.util.SootUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.ByteType;
import soot.G;
import soot.SootField;
import soot.Type;
import soot.jimple.Constant;
import soot.jimple.StringConstant;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000&\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0007\u001a:\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t*\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00022\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00070\u0003\u00a8\u0006\u000b"}, d2={"getByteArray", "", "Lcn/sast/dataflow/interprocedural/check/callback/ICallCBImpl;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "strValueObject", "Lcn/sast/dataflow/interprocedural/analysis/V;", "getStringFromObject", "Lcn/sast/dataflow/interprocedural/analysis/IOpCalculator;", "obj", "corax-data-flow"})
public final class WStringKt {
    @Nullable
    public static final byte[] getByteArray(@NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> $this$getByteArray, @NotNull IValue strValueObject) {
        Intrinsics.checkNotNullParameter($this$getByteArray, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)strValueObject, (String)"strValueObject");
        IData iData = ((IFact.Builder)$this$getByteArray.getOut()).getValueData((Object)strValueObject, (Object)BuiltInModelT.Array);
        IArrayHeapKV iArrayHeapKV = iData instanceof IArrayHeapKV ? (IArrayHeapKV)iData : null;
        return iArrayHeapKV != null ? iArrayHeapKV.getByteArray((IHeapValuesFactory)$this$getByteArray.getHf()) : null;
    }

    @NotNull
    public static final IOpCalculator<IValue> getStringFromObject(@NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> $this$getStringFromObject, @NotNull IHeapValues<IValue> obj) {
        Intrinsics.checkNotNullParameter($this$getStringFromObject, (String)"<this>");
        Intrinsics.checkNotNullParameter(obj, (String)"obj");
        ByteType byteType = G.v().soot_ByteType();
        ArrayType arrayType = ArrayType.v((Type)((Type)byteType), (int)1);
        Intrinsics.checkNotNull((Object)byteType);
        SootField coderField = SootUtilsKt.getOrMakeField((String)"java.lang.String", (String)"coder", (Type)((Type)byteType));
        Intrinsics.checkNotNull((Object)arrayType);
        SootField valueField = SootUtilsKt.getOrMakeField((String)"java.lang.String", (String)"value", (Type)((Type)arrayType));
        IHeapValues bytes = HeapFactoryKt.getValueField($this$getStringFromObject, obj, (SootField)valueField);
        IHeapValues coder = HeapFactoryKt.getValueField($this$getStringFromObject, obj, (SootField)coderField);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{bytes, coder};
        IOpCalculator c = $this$getStringFromObject.getHf().resolveOp((HeapValuesEnv)$this$getStringFromObject.getEnv(), iHeapValuesArray);
        c.resolve((arg_0, arg_1, arg_2) -> WStringKt.getStringFromObject$lambda$0($this$getStringFromObject, arg_0, arg_1, arg_2));
        IHeapValues[] iHeapValuesArray2 = new IHeapValues[]{obj};
        IOpCalculator c2 = $this$getStringFromObject.getHf().resolveOp((HeapValuesEnv)$this$getStringFromObject.getEnv(), iHeapValuesArray2);
        c2.resolve((arg_0, arg_1, arg_2) -> WStringKt.getStringFromObject$lambda$2($this$getStringFromObject, arg_0, arg_1, arg_2));
        c.getRes().add(c2.getRes().build());
        c.getRes().add(obj);
        return c;
    }

    private static final boolean getStringFromObject$lambda$0(ICallCBImpl $this_getStringFromObject, IOpCalculator $this$getStr, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$getStr, (String)"$this$getStr");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV companionV = companionVArray[0];
        CompanionV coder = companionVArray[1];
        Byte by = FactValuesKt.getByteValue((IValue)((IValue)coder.getValue()), (boolean)true);
        if (by == null) {
            return false;
        }
        byte coderInt = by;
        byte[] byArray = WStringKt.getByteArray((ICallCBImpl)$this_getStringFromObject, (IValue)((IValue)companionV.getValue()));
        if (byArray == null) {
            return false;
        }
        byte[] byteArray = byArray;
        String str = coderInt == WString.Companion.getLATIN1_BYTE() ? new String(byteArray, Charsets.UTF_8) : new String(byteArray, Charsets.UTF_16);
        AbstractHeapFactory abstractHeapFactory = $this_getStringFromObject.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_getStringFromObject.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this_getStringFromObject.getHf();
        StringConstant stringConstant = StringConstant.v((String)str);
        Intrinsics.checkNotNullExpressionValue((Object)stringConstant, (String)"v(...)");
        res.add(abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.newConstVal((Constant)stringConstant, (Type)$this_getStringFromObject.getHf().getVg().getSTRING_TYPE())).dataSequenceToSeq(companionV).popHV());
        return true;
    }

    private static final boolean getStringFromObject$lambda$2(ICallCBImpl $this_getStringFromObject, IOpCalculator $this$getStr, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$getStr, (String)"$this$getStr");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV obj = companionVArray[0];
        IData iData = ((IFact.Builder)$this_getStringFromObject.getOut()).getValueData(obj.getValue(), CheckerModelingKt.getKeyAttribute());
        ImmutableElementHashMap attributeMap = iData instanceof ImmutableElementHashMap ? (ImmutableElementHashMap)iData : null;
        IHeapValues.Builder set = $this_getStringFromObject.getHf().emptyBuilder();
        if (attributeMap != null) {
            IHeapValues iHeapValues = attributeMap.get((IHeapValuesFactory)$this_getStringFromObject.getHf(), (Object)"str-fragment");
            if (iHeapValues != null) {
                IHeapValues it = iHeapValues;
                boolean bl = false;
                for (CompanionV v : it) {
                    if (!(v.getValue() instanceof ConstVal)) continue;
                    set.add(it);
                }
            }
        }
        res.add(set.build());
        return true;
    }
}

