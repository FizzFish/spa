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
import cn.sast.dataflow.util.SootUtilsKt;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import soot.BooleanType;
import soot.G;
import soot.Type;

public final class WArrays implements SummaryHandlePackage<IValue> {
    public static final Companion Companion = new Companion();

    public void register(@NotNull ACheckCallAnalysis analysis) {
        if (analysis == null) {
            throw new IllegalArgumentException("Analysis cannot be null");
        }
        analysis.evalCall("<java.util.Arrays: boolean equals(byte[],byte[])>", this::handleEquals);
        analysis.registerWrapper(SootUtilsKt.sootSignatureToRef("<java.util.Arrays: byte[] copyOfRange(byte[],int,int)>", true));
    }

    private Boolean contentEqual(CalleeCBImpl.EvalCall evalCall, IArrayHeapKV<Integer, IValue> arrayA, IArrayHeapKV<Integer, IValue> arrayB) {
        byte[] a = arrayA.getByteArray(evalCall.getHf());
        if (a == null) {
            return null;
        }
        byte[] b = arrayB.getByteArray(evalCall.getHf());
        if (b == null) {
            return null;
        }
        return Arrays.equals(a, b);
    }

    private boolean resolveEquals(CalleeCBImpl.EvalCall evalCall, IOpCalculator calculator, IHeapValues.Builder res, CompanionV[] companionVArray) {
        if (calculator == null || res == null || companionVArray == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        CompanionV ca1 = companionVArray[0];
        CompanionV ca2 = companionVArray[1];
        IValue a1 = ca1.getValue();
        IValue a2 = ca2.getValue();

        if (a1.isNullConstant() || a2.isNullConstant()) {
            res.add(evalCall.getHf().push(evalCall.getEnv(), evalCall.getHf().toConstVal(false)).markOfArrayContentEqualsBoolResult().pop());
            return true;
        }

        IArrayHeapKV arrayA1 = evalCall.getOut().getArray(a1);
        IArrayHeapKV arrayA2 = evalCall.getOut().getArray(a2);
        if (arrayA1 == null || arrayA2 == null) {
            return false;
        }

        Boolean result = contentEqual(evalCall, arrayA1, arrayA2);
        if (result == null) {
            return false;
        }

        res.add(evalCall.getHf().push(evalCall.getEnv(), evalCall.getHf().toConstVal(result)).markOfArrayContentEqualsBoolResult().pop());
        return true;
    }

    private void handleEquals(CalleeCBImpl.EvalCall evalCall) {
        if (evalCall == null) {
            throw new IllegalArgumentException("EvalCall cannot be null");
        }

        IHeapValues a1v = evalCall.arg(0);
        IHeapValues a2v = evalCall.arg(1);
        IHeapValues[] values = new IHeapValues[]{a1v, a2v};

        IOpCalculator binop = evalCall.getHf().resolveOp(evalCall.getEnv(), values);
        binop.resolve((calc, res, companions) -> resolveEquals(evalCall, calc, res, companions));

        BooleanType booleanType = G.v().soot_BooleanType();
        binop.putSummaryIfNotConcrete(booleanType, "return");

        evalCall.getOut().assignNewExpr(evalCall.getEnv(), evalCall.getHf().getVg().getRETURN_LOCAL(), binop.getRes().build(), false);
    }

    public static final class Companion {
        private Companion() {}
    }
}
