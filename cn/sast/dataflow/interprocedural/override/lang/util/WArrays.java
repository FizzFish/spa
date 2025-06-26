/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.override.lang.util.WArrays
 *  cn.sast.dataflow.interprocedural.override.lang.util.WArrays$Companion
 *  cn.sast.dataflow.util.SootUtilsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.BooleanType
 *  soot.G
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.override.lang.util;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.util.WArrays;
import cn.sast.dataflow.util.SootUtilsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.BooleanType;
import soot.G;
import soot.Type;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u0007*\u00100\bj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\tH\u0016\u00a8\u0006\u000b"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/util/WArrays;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
public final class WArrays
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        $this$register.evalCall("<java.util.Arrays: boolean equals(byte[],byte[])>", WArrays::register$lambda$1);
        $this$register.registerWrapper(SootUtilsKt.sootSignatureToRef((String)"<java.util.Arrays: byte[] copyOfRange(byte[],int,int)>", (boolean)true));
    }

    private static final Boolean register$lambda$1$contentEqual(CalleeCBImpl.EvalCall $this_evalCall, IArrayHeapKV<Integer, IValue> arrayA, IArrayHeapKV<Integer, IValue> arrayB) {
        byte[] byArray = arrayA.getByteArray((IHeapValuesFactory)$this_evalCall.getHf());
        if (byArray == null) {
            return null;
        }
        byte[] a = byArray;
        byte[] byArray2 = arrayB.getByteArray((IHeapValuesFactory)$this_evalCall.getHf());
        if (byArray2 == null) {
            return null;
        }
        byte[] b = byArray2;
        return Arrays.equals(a, b);
    }

    private static final boolean register$lambda$1$lambda$0(CalleeCBImpl.EvalCall $this_evalCall, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV ca1 = companionVArray[0];
        CompanionV ca2 = companionVArray[1];
        IValue a1 = (IValue)ca1.getValue();
        IValue a2 = (IValue)ca2.getValue();
        if (a1.isNullConstant() || a2.isNullConstant()) {
            res.add($this_evalCall.getHf().push((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().toConstVal((Object)false)).markOfArrayContentEqualsBoolResult().pop());
            return true;
        }
        IArrayHeapKV arrayA1 = $this_evalCall.getOut().getArray((Object)a1);
        IArrayHeapKV arrayA2 = $this_evalCall.getOut().getArray((Object)a2);
        if (arrayA1 == null || arrayA2 == null) {
            return false;
        }
        Boolean bl = WArrays.register$lambda$1$contentEqual((CalleeCBImpl.EvalCall)$this_evalCall, (IArrayHeapKV)arrayA1, (IArrayHeapKV)arrayA2);
        if (bl == null) {
            return false;
        }
        boolean eq = bl;
        res.add($this_evalCall.getHf().push((HeapValuesEnv)$this_evalCall.getEnv(), $this_evalCall.getHf().toConstVal((Object)eq)).markOfArrayContentEqualsBoolResult().pop());
        return true;
    }

    private static final Unit register$lambda$1(CalleeCBImpl.EvalCall $this$evalCall) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCall, (String)"$this$evalCall");
        IHeapValues a1v = $this$evalCall.arg(0);
        IHeapValues a2v = $this$evalCall.arg(1);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{a1v, a2v};
        IOpCalculator binop = $this$evalCall.getHf().resolveOp((HeapValuesEnv)$this$evalCall.getEnv(), iHeapValuesArray);
        binop.resolve((arg_0, arg_1, arg_2) -> WArrays.register$lambda$1$lambda$0($this$evalCall, arg_0, arg_1, arg_2));
        BooleanType booleanType = G.v().soot_BooleanType();
        Intrinsics.checkNotNullExpressionValue((Object)booleanType, (String)"soot_BooleanType(...)");
        binop.putSummaryIfNotConcrete((Type)booleanType, (Object)"return");
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)$this$evalCall.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this$evalCall.getEnv()), (Object)$this$evalCall.getHf().getVg().getRETURN_LOCAL(), (IHeapValues)binop.getRes().build(), (boolean)false, (int)8, null);
        return Unit.INSTANCE;
    }
}

