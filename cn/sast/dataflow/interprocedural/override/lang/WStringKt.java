package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.IArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.HeapFactoryKt;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModelingKt;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementHashMap;
import cn.sast.dataflow.util.SootUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.ByteType;
import soot.G;
import soot.SootField;
import soot.Type;
import soot.jimple.Constant;
import soot.jimple.StringConstant;

import java.nio.charset.StandardCharsets;

public final class WStringKt {
    @Nullable
    public static byte[] getByteArray(@NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> callback, 
                                     @NotNull IValue strValueObject) {
        IData iData = callback.getOut().getValueData(strValueObject, BuiltInModelT.Array);
        if (iData instanceof IArrayHeapKV) {
            return ((IArrayHeapKV) iData).getByteArray(callback.getHf());
        }
        return null;
    }

    @NotNull
    public static IOpCalculator<IValue> getStringFromObject(
            @NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> callback,
            @NotNull IHeapValues<IValue> obj) {
        
        ByteType byteType = G.v().soot_ByteType();
        ArrayType arrayType = ArrayType.v(byteType, 1);
        SootField coderField = SootUtilsKt.getOrMakeField("java.lang.String", "coder", byteType);
        SootField valueField = SootUtilsKt.getOrMakeField("java.lang.String", "value", arrayType);

        IHeapValues bytes = HeapFactoryKt.getValueField(callback, obj, valueField);
        IHeapValues coder = HeapFactoryKt.getValueField(callback, obj, coderField);

        IOpCalculator calculator = callback.getHf().resolveOp(callback.getEnv(), new IHeapValues[]{bytes, coder});
        calculator.resolve((opCalc, res, companions) -> {
            CompanionV bytesCompanion = companions[0];
            CompanionV coderCompanion = companions[1];
            
            Byte coderByte = FactValuesKt.getByteValue(coderCompanion.getValue(), true);
            if (coderByte == null) {
                return false;
            }
            
            byte[] byteArray = getByteArray(callback, bytesCompanion.getValue());
            if (byteArray == null) {
                return false;
            }
            
            String str = coderByte == WString.LATIN1_BYTE 
                ? new String(byteArray, StandardCharsets.UTF_8) 
                : new String(byteArray, StandardCharsets.UTF_16);
            
            StringConstant constant = StringConstant.v(str);
            res.add(callback.getHf().push(
                callback.getEnv(),
                callback.getHf().newConstVal(constant, callback.getHf().getVg().getSTRING_TYPE())
            ).dataSequenceToSeq(bytesCompanion).popHV());
            
            return true;
        });

        IOpCalculator objCalculator = callback.getHf().resolveOp(callback.getEnv(), new IHeapValues[]{obj});
        objCalculator.resolve((opCalc, res, companions) -> {
            CompanionV objCompanion = companions[0];
            IData iData = callback.getOut().getValueData(objCompanion.getValue(), CheckerModelingKt.getKeyAttribute());
            
            IHeapValues.Builder set = callback.getHf().emptyBuilder();
            if (iData instanceof ImmutableElementHashMap) {
                IHeapValues strFragment = ((ImmutableElementHashMap) iData).get(callback.getHf(), "str-fragment");
                if (strFragment != null) {
                    for (CompanionV v : strFragment) {
                        if (v.getValue() instanceof ConstVal) {
                            set.add(strFragment);
                        }
                    }
                }
            }
            res.add(set.build());
            return true;
        });

        calculator.getRes().add(objCalculator.getRes().build());
        calculator.getRes().add(obj);
        return calculator;
    }
}