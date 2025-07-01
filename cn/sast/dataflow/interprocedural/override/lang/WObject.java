package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import com.feysh.corax.config.api.utils.UtilsKt;
import org.jetbrains.annotations.NotNull;
import soot.ArrayType;
import soot.G;
import soot.IntType;
import soot.PrimType;
import soot.RefType;
import soot.Type;
import soot.jimple.ClassConstant;
import soot.jimple.Constant;

public final class WObject implements SummaryHandlePackage<IValue> {
    public static final Companion Companion = new Companion();
    private final RefType jClassType = RefType.v("java.lang.Class");

    public RefType getJClassType() {
        return jClassType;
    }

    public void register(@NotNull ACheckCallAnalysis analysis) {
        if (analysis == null) throw new NullPointerException("analysis is null");
        
        analysis.evalCall(UtilsKt.getSootSignature(register.1.INSTANCE), 
            evalCall -> register$lambda$1(this, evalCall));
        analysis.evalCall(UtilsKt.getSootSignature(register.3.INSTANCE), 
            WObject::register$lambda$3);
        String hashCodeSignature = UtilsKt.getSootSignature(register.hashCodeSignature.1.INSTANCE);
        analysis.evalCall(hashCodeSignature, WObject::register$lambda$5);
    }

    private static boolean register$lambda$1$lambda$0(CalleeCBImpl.EvalCall evalCall, WObject thisObj, 
            IOpCalculator resolver, IHeapValues.Builder res, CompanionV[] companionVArray) {
        if (resolver == null || res == null || companionVArray == null) return false;
        
        CompanionV cop = companionVArray[0];
        IValue op = (IValue) cop.getValue();
        if (!op.typeIsConcrete()) return false;

        Type type = op.getType();
        Object object = (type instanceof RefType || type instanceof ArrayType || type instanceof PrimType) 
            ? ClassConstant.fromType(type) : null;
        if (object == null) return false;

        ClassConstant c = (ClassConstant) object;
        AbstractHeapFactory hf = evalCall.getHf();
        HeapValuesEnv env = (HeapValuesEnv) evalCall.getEnv();
        RefType jClassType = thisObj.jClassType;
        
        res.add(hf.push(env, hf.newConstVal(c, jClassType))
            .markOfGetClass(cop)
            .pop());
        return true;
    }

    private static void register$lambda$1(WObject thisObj, CalleeCBImpl.EvalCall evalCall) {
        if (evalCall == null) return;
        
        IHeapValues obj = evalCall.arg(-1);
        IHeapValues[] args = new IHeapValues[]{obj};
        IOpCalculator unop = evalCall.getHf().resolveOp((HeapValuesEnv) evalCall.getEnv(), args);
        
        unop.resolve((resolver, res, companionVArray) -> 
            register$lambda$1$lambda$0(evalCall, thisObj, resolver, res, companionVArray));
        
        unop.putSummaryIfNotConcrete(thisObj.jClassType, "return");
        evalCall.setReturn(unop.getRes().build());
    }

    private static boolean register$lambda$3$lambda$2(CalleeCBImpl.EvalCall evalCall, 
            IOpCalculator resolver, IHeapValues.Builder res, CompanionV[] companionVArray) {
        if (resolver == null || res == null || companionVArray == null) return false;
        
        CompanionV th1s = companionVArray[0];
        CompanionV that = companionVArray[1];
        
        if (((IValue) that.getValue()).isNullConstant()) {
            res.add(evalCall.getHf().push((HeapValuesEnv) evalCall.getEnv(), 
                evalCall.getHf().toConstVal(false))
                .markOfObjectEqualsResult(th1s, that)
                .pop());
        } else {
            boolean eq = th1s.getValue().equals(that.getValue());
            res.add(evalCall.getHf().push((HeapValuesEnv) evalCall.getEnv(), 
                evalCall.getHf().toConstVal(eq))
                .markOfObjectEqualsResult(th1s, that)
                .pop());
        }
        return true;
    }

    private static void register$lambda$3(CalleeCBImpl.EvalCall evalCall) {
        if (evalCall == null) return;
        
        IHeapValues selfO = evalCall.arg(-1);
        IHeapValues thatO = evalCall.arg(0);
        IHeapValues[] args = new IHeapValues[]{selfO, thatO};
        
        IOpCalculator strObjectOp = evalCall.getHf().resolveOp((HeapValuesEnv) evalCall.getEnv(), args);
        strObjectOp.resolve((resolver, res, companionVArray) -> 
            register$lambda$3$lambda$2(evalCall, resolver, res, companionVArray));
        
        evalCall.setReturn(strObjectOp.getRes().build());
    }

    private static boolean register$lambda$5$lambda$4(CalleeCBImpl.EvalCall evalCall, 
            IOpCalculator resolver, IHeapValues.Builder res, CompanionV[] companionVArray) {
        if (resolver == null || res == null || companionVArray == null) return false;
        
        CompanionV instance = companionVArray[0];
        res.add(evalCall.getHf().push((HeapValuesEnv) evalCall.getEnv(), 
            evalCall.getHf().toConstVal(instance.hashCode()))
            .markOfReturnValueOfMethod(evalCall)
            .pop());
        return true;
    }

    private static void register$lambda$5(CalleeCBImpl.EvalCall evalCall) {
        if (evalCall == null) return;
        
        IHeapValues obj = evalCall.arg(0);
        IHeapValues[] args = new IHeapValues[]{obj};
        IOpCalculator unop = evalCall.getHf().resolveOp((HeapValuesEnv) evalCall.getEnv(), args);
        
        unop.resolve((resolver, res, companionVArray) -> 
            register$lambda$5$lambda$4(evalCall, resolver, res, companionVArray));
        
        unop.putSummaryIfNotConcrete(G.v().soot_IntType(), "return");
        evalCall.setReturn(unop.getRes().build());
    }

    public static final class Companion {
        private Companion() {}
    }
}
