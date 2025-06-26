/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl
 *  cn.sast.dataflow.interprocedural.override.lang.WStringKt
 *  cn.sast.dataflow.interprocedural.override.lang.WStringLatin1
 *  cn.sast.dataflow.interprocedural.override.lang.WStringLatin1$Companion
 *  cn.sast.dataflow.interprocedural.override.lang.WStringLatin1Kt
 *  cn.sast.dataflow.util.SootUtilsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  org.jetbrains.annotations.NotNull
 *  soot.BooleanType
 *  soot.G
 *  soot.IntType
 *  soot.Type
 *  soot.jimple.Constant
 *  soot.jimple.IntConstant
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.WStringKt;
import cn.sast.dataflow.interprocedural.override.lang.WStringLatin1;
import cn.sast.dataflow.interprocedural.override.lang.WStringLatin1Kt;
import cn.sast.dataflow.util.SootUtilsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import soot.BooleanType;
import soot.G;
import soot.IntType;
import soot.Type;
import soot.jimple.Constant;
import soot.jimple.IntConstant;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u0007*\u00100\bj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\tH\u0016\u00a8\u0006\u000b"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/WStringLatin1;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
public final class WStringLatin1
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        $this$register.registerWrapper(SootUtilsKt.sootSignatureToRef((String)"<java.lang.StringLatin1: char charAt(byte[],int)>", (boolean)true));
        $this$register.registerWrapper(SootUtilsKt.sootSignatureToRef((String)"<java.lang.StringLatin1: char charAt(byte[],int)>", (boolean)true));
        String indexOfSig = "<java.lang.StringLatin1: int indexOf(byte[],int,int)>";
        $this$register.evalCall(indexOfSig, WStringLatin1::register$lambda$1);
        $this$register.registerWrapper(SootUtilsKt.sootSignatureToRef((String)"<java.lang.StringLatin1: java.lang.String newString(byte[],int,int)>", (boolean)true));
        String equalsSigNature = "<java.lang.StringLatin1: boolean equals(byte[],byte[])>";
        $this$register.evalCall(equalsSigNature, WStringLatin1::register$lambda$3);
        $this$register.evalCall("<java.lang.StringLatin1: int hashCode(byte[])>", WStringLatin1::register$lambda$5);
    }

    private static final boolean register$lambda$1$lambda$0(CalleeCBImpl.EvalCall $this_ret, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV value = companionVArray[0];
        CompanionV ch = companionVArray[1];
        CompanionV fromIndex = companionVArray[2];
        Integer n = FactValuesKt.getIntValue((IValue)((IValue)ch.getValue()), (boolean)true);
        if (n == null) {
            return false;
        }
        int chV = n;
        if (!WStringLatin1Kt.canEncode((int)chV)) {
            AbstractHeapFactory abstractHeapFactory = $this_ret.getHf();
            HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_ret.getEnv();
            AbstractHeapFactory abstractHeapFactory2 = $this_ret.getHf();
            IntConstant intConstant = IntConstant.v((int)-1);
            Intrinsics.checkNotNullExpressionValue((Object)intConstant, (String)"v(...)");
            Constant constant = (Constant)intConstant;
            IntType intType = G.v().soot_IntType();
            Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
            res.add(abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.newConstVal(constant, (Type)intType)).markOfReturnValueOfMethod($this_ret).pop());
            return true;
        }
        IData iData = $this_ret.getOut().getValueData(value.getValue(), (Object)BuiltInModelT.Array);
        IArrayHeapKV iArrayHeapKV = iData instanceof IArrayHeapKV ? (IArrayHeapKV)iData : null;
        if (iArrayHeapKV == null) {
            return false;
        }
        IArrayHeapKV arr = iArrayHeapKV;
        IValue[] iValueArray = (IValue[])arr.getArray((IHeapValuesFactory)$this_ret.getHf());
        if (iValueArray == null) {
            return false;
        }
        IValue[] arrRaw = iValueArray;
        int max = arrRaw.length;
        Integer n2 = FactValuesKt.getIntValue((IValue)((IValue)fromIndex.getValue()), (boolean)true);
        if (n2 == null) {
            return false;
        }
        int fromIndexV = n2;
        if (fromIndexV < 0) {
            fromIndexV = 0;
        } else if (fromIndexV >= max) {
            AbstractHeapFactory abstractHeapFactory = $this_ret.getHf();
            HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_ret.getEnv();
            AbstractHeapFactory abstractHeapFactory3 = $this_ret.getHf();
            IntConstant intConstant = IntConstant.v((int)-1);
            Intrinsics.checkNotNullExpressionValue((Object)intConstant, (String)"v(...)");
            Constant constant = (Constant)intConstant;
            IntType intType = G.v().soot_IntType();
            Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
            res.add(abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory3.newConstVal(constant, (Type)intType)).markOfReturnValueOfMethod($this_ret).pop());
            return true;
        }
        if (max - fromIndexV > 100) {
            return false;
        }
        byte c = (byte)chV;
        for (int i = fromIndexV; i < max; ++i) {
            Byte by = FactValuesKt.getByteValue$default((IValue)arrRaw[i], (boolean)false, (int)1, null);
            if (by == null) {
                return false;
            }
            byte ca = by;
            if (ca != c) continue;
            AbstractHeapFactory abstractHeapFactory = $this_ret.getHf();
            HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_ret.getEnv();
            AbstractHeapFactory abstractHeapFactory4 = $this_ret.getHf();
            IntConstant intConstant = IntConstant.v((int)i);
            Intrinsics.checkNotNullExpressionValue((Object)intConstant, (String)"v(...)");
            Constant constant = (Constant)intConstant;
            IntType intType = G.v().soot_IntType();
            Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
            res.add(abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory4.newConstVal(constant, (Type)intType)).markOfReturnValueOfMethod($this_ret).pop());
            return true;
        }
        AbstractHeapFactory abstractHeapFactory = $this_ret.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_ret.getEnv();
        AbstractHeapFactory abstractHeapFactory5 = $this_ret.getHf();
        IntConstant intConstant = IntConstant.v((int)-1);
        Intrinsics.checkNotNullExpressionValue((Object)intConstant, (String)"v(...)");
        Constant constant = (Constant)intConstant;
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        res.add(abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory5.newConstVal(constant, (Type)intType)).markOfReturnValueOfMethod($this_ret).pop());
        return true;
    }

    private static final Unit register$lambda$1(CalleeCBImpl.EvalCall $this$ret) {
        Intrinsics.checkNotNullParameter((Object)$this$ret, (String)"$this$ret");
        IHeapValues valueP = $this$ret.arg(0);
        IHeapValues chP = $this$ret.arg(1);
        IHeapValues fromIndexP = $this$ret.arg(2);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{valueP, chP, fromIndexP};
        IOpCalculator valueObjectOp = $this$ret.getHf().resolveOp((HeapValuesEnv)$this$ret.getEnv(), iHeapValuesArray);
        valueObjectOp.resolve((arg_0, arg_1, arg_2) -> WStringLatin1.register$lambda$1$lambda$0($this$ret, arg_0, arg_1, arg_2));
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        valueObjectOp.putSummaryIfNotConcrete((Type)intType, (Object)"return");
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)$this$ret.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this$ret.getEnv()), (Object)$this$ret.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)valueObjectOp.getRes().build(), (boolean)false, (int)8, null);
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$3$lambda$2(CalleeCBImpl.EvalCall $this_ret, IOpCalculator $this$valueCmp, IHeapValues.Builder ret, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$valueCmp, (String)"$this$valueCmp");
        Intrinsics.checkNotNullParameter((Object)ret, (String)"ret");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV lop = companionVArray[0];
        CompanionV rop = companionVArray[1];
        if (Intrinsics.areEqual((Object)lop.getValue(), (Object)rop.getValue())) {
            $this$valueCmp.getRes().add($this_ret.getHf().push((HeapValuesEnv)$this_ret.getEnv(), $this_ret.getHf().toConstVal((Object)true)).popHV());
            return true;
        }
        byte[] byArray = WStringKt.getByteArray((ICallCBImpl)((ICallCBImpl)$this_ret), (IValue)((IValue)lop.getValue()));
        if (byArray == null) {
            return false;
        }
        byte[] strA = byArray;
        byte[] byArray2 = WStringKt.getByteArray((ICallCBImpl)((ICallCBImpl)$this_ret), (IValue)((IValue)rop.getValue()));
        if (byArray2 == null) {
            return false;
        }
        byte[] strB = byArray2;
        ret.add($this_ret.getHf().push((HeapValuesEnv)$this_ret.getEnv(), $this_ret.getHf().toConstVal((Object)Arrays.equals(strA, strB))).pop());
        return true;
    }

    private static final Unit register$lambda$3(CalleeCBImpl.EvalCall $this$ret) {
        Intrinsics.checkNotNullParameter((Object)$this$ret, (String)"$this$ret");
        IHeapValues valueP = $this$ret.arg(0);
        IHeapValues otherP = $this$ret.arg(1);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{valueP, otherP};
        IOpCalculator equalsOp = $this$ret.getHf().resolveOp((HeapValuesEnv)$this$ret.getEnv(), iHeapValuesArray);
        equalsOp.resolve((arg_0, arg_1, arg_2) -> WStringLatin1.register$lambda$3$lambda$2($this$ret, arg_0, arg_1, arg_2));
        BooleanType booleanType = G.v().soot_BooleanType();
        Intrinsics.checkNotNullExpressionValue((Object)booleanType, (String)"soot_BooleanType(...)");
        equalsOp.putSummaryIfNotConcrete((Type)booleanType, (Object)"return");
        $this$ret.setReturn(equalsOp.getRes().build());
        return Unit.INSTANCE;
    }

    private static final boolean register$lambda$5$lambda$4(CalleeCBImpl.EvalCall $this_ret, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV value = companionVArray[0];
        byte[] byArray = WStringKt.getByteArray((ICallCBImpl)((ICallCBImpl)$this_ret), (IValue)((IValue)value.getValue()));
        if (byArray == null) {
            return false;
        }
        byte[] bArray = byArray;
        int hash = new String(bArray, Charsets.UTF_8).hashCode();
        res.add($this_ret.getHf().push((HeapValuesEnv)$this_ret.getEnv(), $this_ret.getHf().toConstVal((Object)hash)).markOfStringLatin1Hash(value).pop());
        return true;
    }

    private static final Unit register$lambda$5(CalleeCBImpl.EvalCall $this$ret) {
        Intrinsics.checkNotNullParameter((Object)$this$ret, (String)"$this$ret");
        IHeapValues valueP = $this$ret.arg(0);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{valueP};
        IOpCalculator valueOp = $this$ret.getHf().resolveOp((HeapValuesEnv)$this$ret.getEnv(), iHeapValuesArray);
        valueOp.resolve((arg_0, arg_1, arg_2) -> WStringLatin1.register$lambda$5$lambda$4($this$ret, arg_0, arg_1, arg_2));
        valueOp.putSummaryIfNotConcrete((Type)$this$ret.getHf().getVg().getBYTE_ARRAY_TYPE(), (Object)"return");
        $this$ret.setReturn(valueOp.getRes().build());
        return Unit.INSTANCE;
    }
}

