package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.WStringKt;
import soot.*;
import soot.jimple.*;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.ArrayList;

public final class WNumber implements SummaryHandlePackage<IValue> {
    public static final class Companion {
        private Companion() {}
    }

    public static final Companion Companion = new Companion();

    private void registerToValue(ACheckCallAnalysis analysis, String clzName, PrimType valueFieldType, 
            SootField valueField, PrimType toType) {
        Function1<CalleeCBImpl.EvalCall, Unit> handle = evalCall -> {
            FieldUtil.INSTANCE.getField(evalCall.getOut(), (HeapValuesEnv)evalCall.getEnv(), "value", -1, 
                new JSootFieldType(valueField), false, 16, null);
            IHeapValues value = evalCall.getOut().getTargets("value");
            IHeapValues[] values = {value};
            IOpCalculator valueOp = evalCall.getHf().resolveOp((HeapValuesEnv)evalCall.getEnv(), values);
            
            valueOp.resolve(($this$resolve, res, companionVArray) -> {
                CompanionV cop = companionVArray[0];
                IValue op = (IValue)cop.getValue();
                if (op instanceof ConstVal) {
                    Constant constant = ((ConstVal)op).getV();
                    if (constant instanceof NumericConstant) {
                        NumericConstant nc = (NumericConstant)constant;
                        Constant c = SootUtilsKt.castTo(nc, toType);
                        if (c != null) {
                            res.add(evalCall.getHf().push((HeapValuesEnv)evalCall.getEnv(), 
                                evalCall.getHf().newConstVal(c, toType)).markOfCastTo(toType).pop());
                            return true;
                        }
                    }
                }
                return false;
            });
            
            valueOp.putSummaryIfNotConcrete(toType, evalCall.getHf().getVg().getRETURN_LOCAL());
            evalCall.getOut().assignNewExpr((HeapValuesEnv)evalCall.getEnv(), 
                evalCall.getHf().getVg().getRETURN_LOCAL(), valueOp.getRes().build(), false, 8, null);
            evalCall.getOut().kill("value");
            return Unit.INSTANCE;
        };

        analysis.evalCall("<" + clzName + ": " + toType + " " + toType + "Value()>", handle);
        String typeName = toType.toString();
        analysis.evalCall("<" + clzName + ": " + toType + " to" + 
            typeName.substring(0, 1).toUpperCase() + typeName.substring(1) + "()>", handle);
    }

    @NotNull
    public IOpCalculator<IValue> parseString(@NotNull CalleeCBImpl.EvalCall evalCall, 
            @NotNull String hint, int sIdx, int radixIdx, @NotNull PrimType resType) {
        IHeapValues value = evalCall.arg(sIdx);
        IHeapValues radixParam = evalCall.arg(radixIdx);
        IHeapValues[] values = {value, radixParam};
        IOpCalculator valueOp = evalCall.getHf().resolveOp((HeapValuesEnv)evalCall.getEnv(), values);
        
        valueOp.resolve(($this$resolve, res, companionVArray) -> {
            CompanionV cop = companionVArray[0];
            CompanionV cradix = companionVArray[1];
            IValue str = (IValue)cop.getValue();
            IValue radix = (IValue)cradix.getValue();
            Integer n = FactValuesKt.getIntValue(radix, true);
            if (n == null) return false;
            
            int radixNm = n;
            String sc;
            if (str instanceof ConstVal) {
                Constant constant = ((ConstVal)str).getV();
                if (!(constant instanceof StringConstant)) return false;
                sc = ((StringConstant)constant).value;
                if (sc == null) return false;
            } else {
                byte[] byteArray = WStringKt.getByteArray(evalCall, str);
                if (byteArray == null) return false;
                sc = new String(byteArray);
            }
            
            try {
                NumericConstant num = SootUtilsKt.cvtNumericConstant(sc, radixNm, resType);
                if (num == null) return false;
                res.add(evalCall.getHf().push((HeapValuesEnv)evalCall.getEnv(), 
                    evalCall.getHf().newConstVal(num, resType)).markOfParseString(hint, cop).pop());
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        });
        
        valueOp.putSummaryIfNotConcrete(resType, "return");
        return valueOp;
    }

    @NotNull
    public IOpCalculator<IValue> parseStringFloating(@NotNull CalleeCBImpl.EvalCall evalCall, 
            @NotNull String hint, int sIdx, @NotNull PrimType resType) {
        IHeapValues value = evalCall.arg(sIdx);
        IHeapValues[] values = {value};
        IOpCalculator valueOp = evalCall.getHf().resolveOp((HeapValuesEnv)evalCall.getEnv(), values);
        
        valueOp.resolve(($this$resolve, res, companionVArray) -> {
            CompanionV cop = companionVArray[0];
            IValue str = (IValue)cop.getValue();
            String sc;
            if (str instanceof ConstVal) {
                Constant constant = ((ConstVal)str).getV();
                if (!(constant instanceof StringConstant)) return false;
                sc = ((StringConstant)constant).value;
                if (sc == null) return false;
            } else {
                byte[] byteArray = WStringKt.getByteArray(evalCall, str);
                if (byteArray == null) return false;
                sc = new String(byteArray);
            }
            
            try {
                NumericConstant num = SootUtilsKt.cvtNumericConstant(sc, -1, resType);
                if (num == null) return false;
                res.add(evalCall.getHf().push((HeapValuesEnv)evalCall.getEnv(), 
                    evalCall.getHf().newConstVal(num, resType)).markOfParseString(hint, cop).pop());
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        });
        
        valueOp.putSummaryIfNotConcrete(resType, "return");
        return valueOp;
    }

    public void registerValueOf(@NotNull ACheckCallAnalysis analysis, @NotNull String clzName, @NotNull PrimType valueFieldType) {
        SootField valueField = cn.sast.dataflow.util.SootUtilsKt.getOrMakeField(clzName, "value", valueFieldType);
        NewExpr newExpr = Jimple.v().newNewExpr(RefType.v(clzName));
        
        if (!(valueFieldType instanceof IntegerType || valueFieldType instanceof LongType || 
              valueFieldType instanceof FloatType || valueFieldType instanceof DoubleType)) {
            throw new IllegalStateException("error type of " + valueFieldType);
        }
        
        analysis.evalCall("<" + clzName + ": " + clzName + " valueOf(" + valueFieldType + ")>", evalCall -> {
            AbstractHeapFactory hf = evalCall.getHf();
            IHeapValues returnValue = hf.push((HeapValuesEnv)evalCall.getEnv(), 
                hf.anyNewVal(evalCall.getNewEnv(), newExpr)).markOfNewExpr(newExpr).popHV();
            evalCall.getOut().assignNewExpr((HeapValuesEnv)evalCall.getEnv(), 
                evalCall.getHf().getVg().getRETURN_LOCAL(), returnValue, false, 8, null);
            evalCall.getOut().setField((HeapValuesEnv)evalCall.getEnv(), 
                evalCall.getHf().getVg().getRETURN_LOCAL(), new JSootFieldType(valueField), 0, false, 16, null);
            return Unit.INSTANCE;
        });
        
        analysis.registerWrapper("<" + clzName + ": " + clzName + " valueOf(java.lang.String)>", true);
        String typeName = valueFieldType.toString();
        analysis.registerWrapper("<" + clzName + ": " + valueFieldType + " parse" + 
            typeName.substring(0, 1).toUpperCase() + typeName.substring(1) + "(java.lang.String)>", true);
        
        if (valueFieldType instanceof FloatType || valueFieldType instanceof DoubleType) {
            analysis.evalCall("<" + clzName + ": " + valueFieldType + " parse" + 
                typeName.substring(0, 1).toUpperCase() + typeName.substring(1) + "(java.lang.String)>", 
                evalCall -> {
                    IOpCalculator eval = parseStringFloating(evalCall, clzName, 0, valueFieldType);
                    evalCall.getOut().assignNewExpr((HeapValuesEnv)evalCall.getEnv(), 
                        evalCall.getHf().getVg().getRETURN_LOCAL(), eval.getRes().build(), false, 8, null);
                    return Unit.INSTANCE;
                });
        } else {
            analysis.evalCall("<" + clzName + ": " + valueFieldType + " parse" + 
                typeName.substring(0, 1).toUpperCase() + typeName.substring(1) + "(java.lang.String,int)>", 
                evalCall -> {
                    IOpCalculator eval = parseString(evalCall, clzName, 0, 1, valueFieldType);
                    evalCall.getOut().assignNewExpr((HeapValuesEnv)evalCall.getEnv(), 
                        evalCall.getHf().getVg().getRETURN_LOCAL(), eval.getRes().build(), false, 8, null);
                    return Unit.INSTANCE;
                });
                
            analysis.evalCall("<" + clzName + ": " + clzName + " valueOf(java.lang.String,int)>", 
                evalCall -> {
                    AbstractHeapFactory hf = evalCall.getHf();
                    IHeapValues returnValue = hf.push((HeapValuesEnv)evalCall.getEnv(), 
                        hf.anyNewVal(evalCall.getNewEnv(), newExpr)).markOfNewExpr(newExpr).popHV();
                    evalCall.getOut().assignNewExpr((HeapValuesEnv)evalCall.getEnv(), 
                        evalCall.getHf().getVg().getRETURN_LOCAL(), returnValue, false, 8, null);
                    IOpCalculator eval = parseString(evalCall, clzName, 0, 1, valueFieldType);
                    evalCall.getOut().setFieldNew((HeapValuesEnv)evalCall.getEnv(), 
                        evalCall.getHf().getVg().getRETURN_LOCAL(), new JSootFieldType(valueField), eval.getRes().build());
                    return Unit.INSTANCE;
                });
        }
    }

    public void registerEquals(@NotNull ACheckCallAnalysis analysis, @NotNull String clzName, @NotNull SootField valueField) {
        analysis.registerWrapper("<" + clzName + ": boolean equals(java.lang.Object)>", false);
    }

    public void register(@NotNull ACheckCallAnalysis analysis) {
        List<Pair<String, PrimType>> classes = new ArrayList<>();
        classes.add(new Pair<>("java.lang.Integer", G.v().soot_IntType()));
        classes.add(new Pair<>("java.lang.Long", G.v().soot_LongType()));
        classes.add(new Pair<>("java.lang.Short", G.v().soot_ShortType()));
        classes.add(new Pair<>("java.lang.Byte", G.v().soot_ByteType()));
        classes.add(new Pair<>("java.lang.Float", G.v().soot_FloatType()));
        classes.add(new Pair<>("java.lang.Double", G.v().soot_DoubleType()));

        for (Pair<String, PrimType> pair : classes) {
            String c = pair.getFirst();
            PrimType valueOfType = pair.getSecond();
            analysis.registerClassAllWrapper(c);
            SootField valueField = cn.sast.dataflow.util.SootUtilsKt.getOrMakeField(c, "value", valueOfType);
            
            registerToValue(analysis, c, valueOfType, valueField, G.v().soot_ByteType());
            registerToValue(analysis, c, valueOfType, valueField, G.v().soot_ShortType());
            registerToValue(analysis, c, valueOfType, valueField, G.v().soot_IntType());
            registerToValue(analysis, c, valueOfType, valueField, G.v().soot_LongType());
            registerToValue(analysis, c, valueOfType, valueField, G.v().soot_FloatType());
            registerToValue(analysis, c, valueOfType, valueField, G.v().soot_DoubleType());
            
            registerValueOf(analysis, c, valueOfType);
            registerEquals(analysis, c, valueField);
        }
    }
}
