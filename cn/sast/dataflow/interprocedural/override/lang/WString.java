package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.check.ArraySpace;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.callback.*;
import cn.sast.dataflow.util.SootUtilsKt;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import soot.*;
import soot.jimple.*;

import java.util.function.Function;

public final class WString implements SummaryHandlePackage<IValue> {
    public static final Companion Companion = new Companion();
    private static final byte LATIN1_BYTE = 0;
    private static final byte UTF16_BYTE = 1;
    private static final IntConstant LATIN1 = IntConstant.v(0);
    private static final IntConstant UTF16 = IntConstant.v(1);

    private final RefType classType = RefType.v("java.lang.String");
    private final ByteType byteType = G.v().soot_ByteType();
    private final ArrayType arrayType;
    private final SootField valueField;
    private final SootField coderField;
    private final SootField hashField;
    private final Local sizeLocal;
    private final NewArrayExpr newValueExpr;
    private final NewArrayExpr newStringExpr;

    public WString() {
        this.arrayType = ArrayType.v(byteType, 1);
        this.valueField = SootUtilsKt.getOrMakeField("java.lang.String", "value", arrayType);
        this.coderField = SootUtilsKt.getOrMakeField("java.lang.String", "coder", byteType);
        this.hashField = SootUtilsKt.getOrMakeField("java.lang.String", "hash", G.v().soot_IntType());
        this.sizeLocal = Jimple.v().newLocal("size", G.v().soot_IntType());
        this.newValueExpr = Jimple.v().newNewArrayExpr(arrayType, sizeLocal);
        this.newStringExpr = Jimple.v().newNewArrayExpr(arrayType, sizeLocal);
    }

    public RefType getClassType() {
        return classType;
    }

    public ByteType getByteType() {
        return byteType;
    }

    public ArrayType getArrayType() {
        return arrayType;
    }

    @NotNull
    public SootField getValueField() {
        return valueField;
    }

    @NotNull
    public SootField getCoderField() {
        return coderField;
    }

    @NotNull
    public SootField getHashField() {
        return hashField;
    }

    public Local getSizeLocal() {
        return sizeLocal;
    }

    public NewArrayExpr getNewValueExpr() {
        return newValueExpr;
    }

    public NewArrayExpr getNewStringExpr() {
        return newStringExpr;
    }

    public void register(@NotNull ACheckCallAnalysis analysis) {
        analysis.evalCall(UtilsKt.getSootSignature(Companion.getRegisterSignature()), this::handleRegister);
        analysis.postCallAtCaller("<java.lang.String: byte[] getBytes()", createValueElementHandler(arrayType));
        analysis.postCallAtCaller("<java.lang.String: byte[] getBytes(java.lang.String)", createValueElementHandler(arrayType));
        analysis.registerWrapper(SootUtilsKt.sootSignatureToRef("<java.lang.String: boolean equals(java.lang.Object)>", false));
        analysis.registerWrapper(SootUtilsKt.sootSignatureToRef("<java.lang.String: char charAt(int)>", false));
        analysis.evalCall("<java.lang.String: boolean isLatin1()>", this::handleIsLatin1);
        analysis.evalCall("<java.lang.String: byte coder()>", this::handleCoder);
    }

    private Unit handleRegister(CalleeCBImpl.EvalCall evalCall) {
        IHeapValues th1sOp = evalCall.arg(-1);
        IOpCalculator c = WStringKt.getStringFromObject(evalCall, th1sOp);
        c.putSummaryIfNotConcrete(evalCall.getHf().getVg().getSTRING_TYPE(), "return");
        
        IHeapValues[] values = {c.getRes().build()};
        IOpCalculator strOp = evalCall.getHf().resolveOp(evalCall.getEnv(), values);
        strOp.resolve((op, res, companions) -> handleRegisterLambda(evalCall, op, res, companions));
        
        evalCall.getOut().assignNewExpr(evalCall.getEnv(), evalCall.getHf().getVg().getRETURN_LOCAL(), 
            strOp.getRes().build(), false);
        return Unit.INSTANCE;
    }

    private boolean handleRegisterLambda(CalleeCBImpl.EvalCall evalCall, IOpCalculator op, 
                                      IHeapValues.Builder res, CompanionV[] companions) {
        CompanionV str = companions[0];
        Object value = str.getValue();
        if (!(value instanceof ConstVal)) {
            return false;
        }
        
        String stringValue = FactValuesKt.getStringValue((IValue) value, true);
        if (stringValue == null) {
            return false;
        }
        
        AbstractHeapFactory hf = evalCall.getHf();
        IntConstant hashConstant = IntConstant.v(stringValue.hashCode());
        IValue r = hf.newConstVal(hashConstant, G.v().soot_IntType());
        res.add(hf.push(evalCall.getEnv(), r).markOfReturnValueOfMethod(evalCall).pop());
        return true;
    }

    private Function<CallerSiteCBImpl.PostCall, Unit> createValueElementHandler(ArrayType returnType) {
        return postCall -> handleValueElement(this, returnType, postCall);
    }

    private Unit handleValueElement(WString wString, ArrayType returnType, CallerSiteCBImpl.PostCall postCall) {
        IHeapValues th1sOp = postCall.getThis();
        IHeapValues[] values = {th1sOp};
        IOpCalculator strObjectOp = postCall.getHf().resolveOp(postCall.getEnv(), values);
        
        strObjectOp.resolve((op, res, companions) -> 
            handleValueElementLambda(postCall, wString, returnType, op, res, companions));
        
        postCall.setReturn(postCall.getReturn().plus(strObjectOp.getRes().build()));
        return Unit.INSTANCE;
    }

    private boolean handleValueElementLambda(CallerSiteCBImpl.PostCall postCall, WString wString, 
                                          ArrayType returnType, IOpCalculator op, 
                                          IHeapValues.Builder res, CompanionV[] companions) {
        CompanionV th1s = companions[0];
        AbstractHeapFactory hf = postCall.getHf();
        AnyNewExprEnv newEnv = postCall.getNewEnv();
        IValue newValue = hf.anyNewVal(newEnv, wString.newValueExpr);
        res.add(hf.push(postCall.getEnv(), newValue).dataSequenceToSeq(th1s).pop());
        
        if (th1s.getValue() instanceof ConstVal) {
            String stringValue = FactValuesKt.getStringValue((IValue) th1s.getValue(), false);
            if (stringValue != null) {
                byte[] bytes = stringValue.getBytes(Charsets.UTF_8);
                IHeapValues len = hf.push(postCall.getEnv(), hf.toConstVal(bytes.length)).popHV();
                postCall.getOut().setValueData(postCall.getEnv(), newValue, BuiltInModelT.Array, 
                    ArraySpace.Companion.v(hf, postCall.getEnv(), th1s, bytes, returnType, len));
                return true;
            }
        }
        
        IData strArray = postCall.getOut().getValueData(th1s.getValue(), BuiltInModelT.Array);
        postCall.getOut().setValueData(postCall.getEnv(), newValue, BuiltInModelT.Array, strArray);
        return true;
    }

    private Unit handleIsLatin1(CalleeCBImpl.EvalCall evalCall) {
        IValue r = evalCall.getHf().toConstVal(true);
        evalCall.getOut().assignNewExpr(evalCall.getEnv(), evalCall.getHf().getVg().getRETURN_LOCAL(), 
            evalCall.getHf().push(evalCall.getEnv(), r).markOfReturnValueOfMethod(evalCall).popHV(), false);
        evalCall.getOut().build();
        return Unit.INSTANCE;
    }

    private Unit handleCoder(CalleeCBImpl.EvalCall evalCall) {
        evalCall.getOut().assignNewExpr(evalCall.getEnv(), evalCall.getHf().getVg().getRETURN_LOCAL(),
            evalCall.getHf().push(evalCall.getEnv(), 
                evalCall.getHf().newConstVal(LATIN1, G.v().soot_ByteType()))
                .markOfReturnValueOfMethod(evalCall).popHV(), false);
        return Unit.INSTANCE;
    }

    public static class Companion {
        private Companion() {}

        public KCallable getRegisterSignature() {
            // Implementation would return the appropriate KCallable
            return null;
        }
    }
}
