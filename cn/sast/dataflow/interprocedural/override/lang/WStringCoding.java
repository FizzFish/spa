package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.*;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.dataflow.util.SootUtilsKt;
import org.jetbrains.annotations.NotNull;
import soot.*;
import soot.jimple.*;
import java.nio.charset.StandardCharsets;

public final class WStringCoding implements SummaryHandlePackage<IValue> {
    public static final class Companion {
        private Companion() {}
    }

    public static final Companion Companion = new Companion();
    
    private final Local sizeLocal;
    private final NewArrayExpr newValueExpr;
    private final String clzStringCodingResult;
    private final RefType StringCodingResultType;
    private final NewExpr newExprStringCodingResult;
    private final SootField stringCodingResultValueField;
    private final SootField stringCodingResultCoderField;

    public WStringCoding(@NotNull IVGlobal vg) {
        if (vg == null) throw new IllegalArgumentException("vg cannot be null");
        
        this.sizeLocal = Jimple.v().newLocal("size", G.v().soot_IntType());
        this.newValueExpr = Jimple.v().newNewArrayExpr(vg.getBYTE_ARRAY_TYPE(), this.sizeLocal);
        this.clzStringCodingResult = "java.lang.StringCoding$Result";
        this.StringCodingResultType = RefType.v(this.clzStringCodingResult);
        this.newExprStringCodingResult = Jimple.v().newNewExpr(this.StringCodingResultType);
        this.stringCodingResultValueField = SootUtilsKt.getOrMakeField(
            this.clzStringCodingResult, "value", vg.getBYTE_ARRAY_TYPE());
        this.stringCodingResultCoderField = SootUtilsKt.getOrMakeField(
            this.clzStringCodingResult, "coder", G.v().soot_ByteType());
    }

    public Local getSizeLocal() {
        return sizeLocal;
    }

    public NewArrayExpr getNewValueExpr() {
        return newValueExpr;
    }

    @NotNull
    public String getClzStringCodingResult() {
        return clzStringCodingResult;
    }

    public RefType getStringCodingResultType() {
        return StringCodingResultType;
    }

    public NewExpr getNewExprStringCodingResult() {
        return newExprStringCodingResult;
    }

    @NotNull
    public SootField getStringCodingResultValueField() {
        return stringCodingResultValueField;
    }

    @NotNull
    public SootField getStringCodingResultCoderField() {
        return stringCodingResultCoderField;
    }

    @Override
    public void register(@NotNull ACheckCallAnalysis analysis) {
        if (analysis == null) throw new IllegalArgumentException("analysis cannot be null");
        
        analysis.evalCall("<java.lang.StringCoding: byte[] encode(byte,byte[])>", 
            call -> handleEncodeCall(this, call));
        analysis.evalCall("<java.lang.StringCoding: java.lang.StringCoding$Result decode(byte[],int,int)>", 
            call -> handleDecodeCall(this, call));
    }

    private static Unit handleEncodeCall(WStringCoding coding, CalleeCBImpl.EvalCall call) {
        IHeapValues coderP = call.arg(0);
        IHeapValues valP = call.arg(1);
        IHeapValues[] args = {coderP, valP};
        
        IOpCalculator encodeOp = call.getHf().resolveOp((HeapValuesEnv) call.getEnv(), args);
        encodeOp.resolve((op, ret, companions) -> 
            handleEncodeOperation(call, coding, op, ret, companions));
        
        encodeOp.putSummaryIfNotConcrete(call.getHf().getVg().getBYTE_ARRAY_TYPE(), "return");
        call.setReturn(encodeOp.getRes().build());
        return Unit.INSTANCE;
    }

    private static boolean handleEncodeOperation(CalleeCBImpl.EvalCall call, WStringCoding coding, 
            IOpCalculator op, IHeapValues.Builder ret, CompanionV[] companions) {
        CompanionV coder = companions[0];
        CompanionV val = companions[1];
        
        Byte coderByte = FactValuesKt.getByteValue(coder.getValue(), true);
        if (coderByte == null) return false;
        
        byte[] bytes = WStringKt.getByteArray(call, val.getValue());
        if (bytes == null) return false;
        
        IData data = call.getOut().getValueData(val.getValue(), BuiltInModelT.Array);
        IArrayHeapKV arrayData = data instanceof IArrayHeapKV ? (IArrayHeapKV) data : null;
        if (arrayData == null) return false;
        
        byte[] array = arrayData.getByteArray(call.getHf());
        if (array == null) return false;
        
        String str = coderByte == WString.Companion.getLATIN1_BYTE() 
            ? new String(array, StandardCharsets.UTF_8) 
            : new String(array, StandardCharsets.UTF_16);
        byte[] returnArr = str.getBytes(StandardCharsets.UTF_8);
        
        // Create new value
        AbstractHeapFactory hf = call.getHf();
        HeapValuesEnv env = (HeapValuesEnv) call.getEnv();
        AnyNewExprEnv newEnv = call.getNewEnv();
        
        CompanionV newValue = hf.push(env, hf.anyNewVal(newEnv, coding.newValueExpr))
            .markOfNewExpr(coding.newValueExpr)
            .pop();
            
        ret.add(newValue);
        
        IHeapValues arraySize = hf.push(env, hf.toConstVal(returnArr.length))
            .markArraySizeOf(val)
            .popHV();
            
        ArraySpace newArray = ArraySpace.Companion.v(
            hf, env, val, 
            ArraysKt.toTypedArray(returnArr), 
            hf.getVg().getBYTE_ARRAY_TYPE(), 
            arraySize);
            
        call.getOut().setValueData(env, newValue.getValue(), BuiltInModelT.Array, newArray);
        return true;
    }

    private static Unit handleDecodeCall(WStringCoding coding, CalleeCBImpl.EvalCall call) {
        IHeapValues baP = call.arg(0);
        IHeapValues offP = call.arg(1);
        IHeapValues lenP = call.arg(2);
        IHeapValues[] args = {baP, offP, lenP};
        
        IOpCalculator decodeOp = call.getHf().resolveOp((HeapValuesEnv) call.getEnv(), args);
        decodeOp.resolve((op, res, companions) -> 
            handleDecodeOperation(call, coding, op, res, companions));
            
        decodeOp.putSummaryIfNotConcrete(coding.StringCodingResultType, "return");
        call.setReturn(decodeOp.getRes().build());
        return Unit.INSTANCE;
    }

    private static boolean handleDecodeOperation(CalleeCBImpl.EvalCall call, WStringCoding coding, 
            IOpCalculator op, IHeapValues.Builder res, CompanionV[] companions) {
        CompanionV ba = companions[0];
        CompanionV off = companions[1];
        CompanionV len = companions[2];
        
        Integer offInt = FactValuesKt.getIntValue(off.getValue(), true);
        Integer lenInt = FactValuesKt.getIntValue(len.getValue(), true);
        if (offInt == null || lenInt == null) return false;
        
        byte[] bytes = WStringKt.getByteArray(call, ba.getValue());
        if (bytes == null) return false;
        
        byte[] newValueArray;
        try {
            newValueArray = new String(bytes, offInt, lenInt, StandardCharsets.UTF_8)
                .getBytes(StandardCharsets.UTF_8);
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
        
        // Create result object
        AbstractHeapFactory hf = call.getHf();
        HeapValuesEnv env = (HeapValuesEnv) call.getEnv();
        AnyNewExprEnv newEnv = call.getNewEnv();
        
        CompanionV newResult = hf.push(env, hf.anyNewVal(newEnv, coding.newExprStringCodingResult))
            .markOfNewExpr(coding.newExprStringCodingResult)
            .pop();
            
        // Create value array
        CompanionV newValue = hf.push(env, hf.anyNewVal(newEnv, coding.newValueExpr))
            .markOfNewExpr(coding.newValueExpr)
            .pop();
            
        // Create coder constant
        CompanionV newCoder = hf.push(env, hf.newConstVal(WString.Companion.getLATIN1(), G.v().soot_ByteType()))
            .pop();
            
        // Create array space
        IHeapValues arraySize = hf.push(env, hf.toConstVal(newValueArray.length))
            .markArraySizeOf(ba)
            .popHV();
            
        ArraySpace newArray = ArraySpace.Companion.v(
            hf, env, ba, 
            ArraysKt.toTypedArray(newValueArray), 
            hf.getVg().getBYTE_ARRAY_TYPE(), 
            arraySize);
            
        call.getOut().setValueData(env, newValue.getValue(), BuiltInModelT.Array, newArray);
        
        // Assign fields
        PointsToGraphBuilder builder = (PointsToGraphBuilder) call.getOut();
        builder.assignField(env, 
            hf.empty().plus(newResult), 
            new JSootFieldType(coding.stringCodingResultValueField), 
            hf.empty().plus(newValue), 
            false);
            
        builder.assignField(env, 
            hf.empty().plus(newResult), 
            new JSootFieldType(coding.stringCodingResultCoderField), 
            hf.empty().plus(newCoder), 
            false);
            
        res.add(newResult);
        return true;
    }
}
