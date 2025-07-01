package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.WStringKt;
import cn.sast.dataflow.interprocedural.override.lang.WStringLatin1Kt;
import cn.sast.dataflow.util.SootUtilsKt;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import soot.BooleanType;
import soot.G;
import soot.IntType;
import soot.Type;
import soot.jimple.Constant;
import soot.jimple.IntConstant;

public final class WStringLatin1 implements SummaryHandlePackage<IValue> {
    public static final Companion Companion = new Companion();

    public void register(@NotNull ACheckCallAnalysis analysis) {
        if (analysis == null) throw new IllegalArgumentException("Analysis cannot be null");
        
        analysis.registerWrapper(SootUtilsKt.sootSignatureToRef("<java.lang.StringLatin1: char charAt(byte[],int)>", true));
        analysis.registerWrapper(SootUtilsKt.sootSignatureToRef("<java.lang.StringLatin1: char charAt(byte[],int)>", true));
        
        String indexOfSig = "<java.lang.StringLatin1: int indexOf(byte[],int,int)>";
        analysis.evalCall(indexOfSig, this::handleIndexOf);
        
        analysis.registerWrapper(SootUtilsKt.sootSignatureToRef(
            "<java.lang.StringLatin1: java.lang.String newString(byte[],int,int)>", true));
            
        String equalsSigNature = "<java.lang.StringLatin1: boolean equals(byte[],byte[])>";
        analysis.evalCall(equalsSigNature, this::handleEquals);
        
        analysis.evalCall("<java.lang.StringLatin1: int hashCode(byte[])>", this::handleHashCode);
    }

    private Object handleIndexOf(CalleeCBImpl.EvalCall evalCall) {
        IHeapValues valueP = evalCall.arg(0);
        IHeapValues chP = evalCall.arg(1);
        IHeapValues fromIndexP = evalCall.arg(2);
        
        IHeapValues[] args = {valueP, chP, fromIndexP};
        IOpCalculator op = evalCall.getHf().resolveOp((HeapValuesEnv) evalCall.getEnv(), args);
        
        op.resolve(($this, res, companionVArray) -> {
            CompanionV value = companionVArray[0];
            CompanionV ch = companionVArray[1];
            CompanionV fromIndex = companionVArray[2];
            
            Integer n = FactValuesKt.getIntValue((IValue) ch.getValue(), true);
            if (n == null) return false;
            
            int chV = n;
            if (!WStringLatin1Kt.canEncode(chV)) {
                AbstractHeapFactory hf = evalCall.getHf();
                HeapValuesEnv env = (HeapValuesEnv) evalCall.getEnv();
                IntConstant constant = IntConstant.v(-1);
                res.add(hf.push(env, hf.newConstVal(constant, G.v().soot_IntType()))
                    .markOfReturnValueOfMethod(evalCall).pop());
                return true;
            }
            
            IData iData = evalCall.getOut().getValueData(value.getValue(), BuiltInModelT.Array);
            if (!(iData instanceof IArrayHeapKV arr)) return false;
            
            IValue[] arrRaw = arr.getArray(evalCall.getHf());
            if (arrRaw == null) return false;
            
            int max = arrRaw.length;
            Integer fromIndexVal = FactValuesKt.getIntValue((IValue) fromIndex.getValue(), true);
            if (fromIndexVal == null) return false;
            
            int fromIndexV = fromIndexVal;
            if (fromIndexV < 0) {
                fromIndexV = 0;
            } else if (fromIndexV >= max) {
                AbstractHeapFactory hf = evalCall.getHf();
                HeapValuesEnv env = (HeapValuesEnv) evalCall.getEnv();
                IntConstant constant = IntConstant.v(-1);
                res.add(hf.push(env, hf.newConstVal(constant, G.v().soot_IntType()))
                    .markOfReturnValueOfMethod(evalCall).pop());
                return true;
            }
            
            if (max - fromIndexV > 100) return false;
            
            byte c = (byte) chV;
            for (int i = fromIndexV; i < max; ++i) {
                Byte by = FactValuesKt.getByteValue(arrRaw[i], false);
                if (by == null) return false;
                
                if (by == c) {
                    AbstractHeapFactory hf = evalCall.getHf();
                    HeapValuesEnv env = (HeapValuesEnv) evalCall.getEnv();
                    IntConstant constant = IntConstant.v(i);
                    res.add(hf.push(env, hf.newConstVal(constant, G.v().soot_IntType()))
                        .markOfReturnValueOfMethod(evalCall).pop());
                    return true;
                }
            }
            
            AbstractHeapFactory hf = evalCall.getHf();
            HeapValuesEnv env = (HeapValuesEnv) evalCall.getEnv();
            IntConstant constant = IntConstant.v(-1);
            res.add(hf.push(env, hf.newConstVal(constant, G.v().soot_IntType()))
                .markOfReturnValueOfMethod(evalCall).pop());
            return true;
        });
        
        op.putSummaryIfNotConcrete(G.v().soot_IntType(), "return");
        evalCall.getOut().assignNewExpr((HeapValuesEnv) evalCall.getEnv(), 
            evalCall.getHf().getVg().getRETURN_LOCAL(), op.getRes().build());
        return null;
    }

    private Object handleEquals(CalleeCBImpl.EvalCall evalCall) {
        IHeapValues valueP = evalCall.arg(0);
        IHeapValues otherP = evalCall.arg(1);
        
        IHeapValues[] args = {valueP, otherP};
        IOpCalculator op = evalCall.getHf().resolveOp((HeapValuesEnv) evalCall.getEnv(), args);
        
        op.resolve(($this, ret, companionVArray) -> {
            CompanionV lop = companionVArray[0];
            CompanionV rop = companionVArray[1];
            
            if (lop.getValue().equals(rop.getValue())) {
                $this.getRes().add(evalCall.getHf().push(
                    (HeapValuesEnv) evalCall.getEnv(), 
                    evalCall.getHf().toConstVal(true)).popHV());
                return true;
            }
            
            byte[] strA = WStringKt.getByteArray(evalCall, (IValue) lop.getValue());
            if (strA == null) return false;
            
            byte[] strB = WStringKt.getByteArray(evalCall, (IValue) rop.getValue());
            if (strB == null) return false;
            
            ret.add(evalCall.getHf().push((HeapValuesEnv) evalCall.getEnv(), 
                evalCall.getHf().toConstVal(Arrays.equals(strA, strB))).pop());
            return true;
        });
        
        op.putSummaryIfNotConcrete(G.v().soot_BooleanType(), "return");
        evalCall.setReturn(op.getRes().build());
        return null;
    }

    private Object handleHashCode(CalleeCBImpl.EvalCall evalCall) {
        IHeapValues valueP = evalCall.arg(0);
        IHeapValues[] args = {valueP};
        IOpCalculator op = evalCall.getHf().resolveOp((HeapValuesEnv) evalCall.getEnv(), args);
        
        op.resolve(($this, res, companionVArray) -> {
            CompanionV value = companionVArray[0];
            byte[] bArray = WStringKt.getByteArray(evalCall, (IValue) value.getValue());
            if (bArray == null) return false;
            
            int hash = new String(bArray, java.nio.charset.StandardCharsets.UTF_8).hashCode();
            res.add(evalCall.getHf().push((HeapValuesEnv) evalCall.getEnv(), 
                evalCall.getHf().toConstVal(hash)).markOfStringLatin1Hash(value).pop());
            return true;
        });
        
        op.putSummaryIfNotConcrete(evalCall.getHf().getVg().getBYTE_ARRAY_TYPE(), "return");
        evalCall.setReturn(op.getRes().build());
        return null;
    }

    public static final class Companion {
        private Companion() {}
    }
}
