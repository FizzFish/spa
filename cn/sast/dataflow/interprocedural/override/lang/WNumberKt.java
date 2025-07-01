package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.check.callback.ICallCBImpl;
import org.jetbrains.annotations.NotNull;
import soot.G;
import soot.RefType;
import soot.SootField;
import soot.Type;

public final class WNumberKt {
    @NotNull
    public static IOpCalculator<IValue> getValueFromObject(
            @NotNull ICallCBImpl<IHeapValues<IValue>, IFact.Builder<IValue>> callback,
            @NotNull IHeapValues<IValue> obj,
            @NotNull Type type) {
        
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{obj};
        IOpCalculator c = callback.getHf().resolveOp((HeapValuesEnv) callback.getEnv(), iHeapValuesArray);
        c.resolve((opCalc, res, companions) -> handleValueResolution(type, callback, opCalc, res, companions));
        return c;
    }

    private static boolean handleValueResolution(
            Type type,
            ICallCBImpl callback,
            IOpCalculator opCalc,
            IHeapValues.Builder res,
            CompanionV[] companions) {
        
        CompanionV numObj = companions[0];
        Number number = getNumberForType(type, numObj);
        if (number == null) {
            return false;
        }

        if (number instanceof Integer) {
            res.add(numObj);
            return true;
        }

        IFact.Builder out = callback.getOut();
        out.assignNewExpr((HeapValuesEnv) callback.getEnv(), "@num", 
            callback.getHf().empty().plus(numObj), false);

        Type valueType = numObj.getValue().getType();
        if (!(valueType instanceof RefType refType)) {
            return false;
        }

        SootField field = refType.getSootClass().getFieldByNameUnsafe("value");
        if (field == null) {
            return false;
        }

        out.getField((HeapValuesEnv) callback.getEnv(), "@value", "@num", 
            new JSootFieldType(field), false);
        
        IHeapValues value = out.getTargets("@value");
        out.kill("@value");
        out.kill("@num");
        res.add(value);
        return true;
    }

    private static Number getNumberForType(Type type, CompanionV numObj) {
        if (type.equals(G.v().soot_ByteType())) {
            return FactValuesKt.getIntValue(numObj.getValue(), false);
        } else if (type.equals(G.v().soot_CharType())) {
            return FactValuesKt.getIntValue(numObj.getValue(), false);
        } else if (type.equals(G.v().soot_BooleanType())) {
            return FactValuesKt.getIntValue(numObj.getValue(), false);
        } else if (type.equals(G.v().soot_ShortType())) {
            return FactValuesKt.getIntValue(numObj.getValue(), false);
        } else if (type.equals(G.v().soot_IntType())) {
            return FactValuesKt.getIntValue(numObj.getValue(), false);
        } else if (type.equals(G.v().soot_LongType())) {
            return FactValuesKt.getLongValue(numObj.getValue(), false);
        } else if (type.equals(G.v().soot_FloatType())) {
            return FactValuesKt.getFloatValue(numObj.getValue(), false);
        } else if (type.equals(G.v().soot_DoubleType())) {
            return FactValuesKt.getDoubleValue(numObj.getValue(), false);
        }
        return null;
    }
}