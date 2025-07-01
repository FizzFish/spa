package cn.sast.dataflow.interprocedural.override.lang.util;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.check.OverrideModel;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import org.jetbrains.annotations.NotNull;
import soot.BooleanType;
import soot.G;
import soot.IntType;
import soot.Type;
import soot.jimple.Constant;
import soot.jimple.IntConstant;
import java.util.Arrays;
import java.util.List;

public final class WArrayList implements SummaryHandlePackage<IValue> {
    public static final class Companion {
        private Companion() {}
    }

    public static final Companion Companion = new Companion();
    private final IntType intType = G.v().soot_IntType();

    public IntType getIntType() {
        return intType;
    }

    public void register(@NotNull ACheckCallAnalysis analysis) {
        if (analysis == null) throw new IllegalArgumentException("Analysis cannot be null");
        
        String constructor1Sig = "<java.util.ArrayList: void <init>()>";
        String constructor2Sig = "<java.util.ArrayList: void <init>(int)>";
        String clearSig = "<java.util.ArrayList: void clear()>";
        String getSig = "<java.util.ArrayList: java.lang.Object get(int)>";
        String addSig = "<java.util.ArrayList: boolean add(java.lang.Object)>";
        String removeSig = "<java.util.ArrayList: java.lang.Object remove(int)>";

        List<String> constructors = Arrays.asList(constructor1Sig, constructor2Sig);
        for (String sig : constructors) {
            analysis.evalCallAtCaller(sig, this::handleConstructor);
        }
        
        analysis.evalCallAtCaller(clearSig, this::handleClear);
        analysis.evalCallAtCaller(getSig, call -> handleGet(analysis, call));
        analysis.evalCall(addSig, this::handleAdd);
        analysis.evalCallAtCaller(removeSig, this::handleRemove);
    }

    private static IHeapValues<IValue> mapGetModel(ACheckCallAnalysis analysis, IData<IValue> mapData, IValue key) {
        if (key.getType().equals(G.v().soot_IntType())) {
            Integer keyIndex = FactValuesKt.getIntValue(key, false);
            if (mapData instanceof ListSpace) {
                return ((ListSpace)mapData).get(analysis.getHf(), keyIndex);
            }
        }
        return null;
    }

    private Unit handleConstructor(CallerSiteCBImpl.EvalCall call) {
        IHeapValues self = call.getThis();
        IHeapValues[] values = {self};
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), values);
        
        calculator.resolve((opCalc, builder, companions) -> {
            CompanionV selfCompanion = companions[0];
            call.getOut().setValueData(
                (HeapValuesEnv)call.getEnv(), 
                selfCompanion.getValue(), 
                OverrideModel.ArrayList, 
                new ListSpace(null, null, 3, null)
            );
            return true;
        });
        return Unit.INSTANCE;
    }

    private Unit handleClear(CallerSiteCBImpl.EvalCall call) {
        IHeapValues self = call.getThis();
        if (!self.isSingle()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        IHeapValues[] values = {self};
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), values);
        
        calculator.resolve((opCalc, builder, companions) -> {
            CompanionV selfCompanion = companions[0];
            call.getOut().setValueData(
                (HeapValuesEnv)call.getEnv(), 
                selfCompanion.getValue(), 
                OverrideModel.ArrayList, 
                new ListSpace(null, null, 3, null)
            );
            return true;
        });
        return Unit.INSTANCE;
    }

    private Unit handleGet(ACheckCallAnalysis analysis, CallerSiteCBImpl.EvalCall call) {
        IHeapValues self = call.getThis();
        IHeapValues key = call.arg(0);
        IHeapValues[] values = {self, key};
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), values);
        
        calculator.resolve((opCalc, builder, companions) -> {
            CompanionV selfCompanion = companions[0];
            CompanionV keyCompanion = companions[1];
            
            IData data = call.getOut().getValueData(selfCompanion.getValue(), OverrideModel.ArrayList);
            if (data == null) return false;
            
            IHeapValues result = mapGetModel(analysis, data, (IValue)keyCompanion.getValue());
            if (result == null) return false;
            
            builder.add(result);
            return true;
        });
        
        if (!calculator.isFullySimplified()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        call.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }

    private Unit handleAdd(CalleeCBImpl.EvalCall call) {
        IHeapValues self = call.getThis();
        IHeapValues value = call.arg(0);
        IHeapValues[] values = {self};
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), values);
        
        calculator.resolve((opCalc, builder, companions) -> {
            CompanionV selfCompanion = companions[0];
            IData data = call.getOut().getValueData(selfCompanion.getValue(), OverrideModel.ArrayList);
            
            if (!(data instanceof ListSpace)) return false;
            ListSpace list = (ListSpace)data;
            
            ListSpaceBuilder builder = list.builder();
            builder.add(value);
            call.getOut().setValueData(
                (HeapValuesEnv)call.getEnv(), 
                selfCompanion.getValue(), 
                OverrideModel.ArrayList, 
                builder.build()
            );
            
            AbstractHeapFactory hf = call.getHf();
            HeapValuesEnv env = (HeapValuesEnv)call.getEnv();
            Constant constant = IntConstant.v(1);
            BooleanType booleanType = G.v().soot_BooleanType();
            builder.add(hf.push(env, hf.newConstVal(constant, booleanType)).popHV());
            return true;
        });
        
        if (!calculator.isFullySimplified()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        BooleanType booleanType = G.v().soot_BooleanType();
        calculator.putSummaryIfNotConcrete(booleanType, "return");
        call.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }

    private Unit handleRemove(CallerSiteCBImpl.EvalCall call) {
        IHeapValues self = call.getThis();
        IHeapValues index = call.arg(0);
        
        if (!self.isSingle()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        IHeapValues[] values = {self, index};
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), values);
        
        calculator.resolve((opCalc, builder, companions) -> {
            CompanionV selfCompanion = companions[0];
            CompanionV indexCompanion = companions[1];
            
            IData data = call.getOut().getValueData(selfCompanion.getValue(), OverrideModel.ArrayList);
            if (!(data instanceof ListSpace)) return false;
            ListSpace list = (ListSpace)data;
            
            Integer indexVal = FactValuesKt.getIntValue((IValue)indexCompanion.getValue(), true);
            ListSpaceBuilder listBuilder = list.builder();
            IHeapValues resValue = listBuilder.remove(call.getHf(), indexVal);
            
            call.getOut().setValueData(
                (HeapValuesEnv)call.getEnv(), 
                selfCompanion.getValue(), 
                OverrideModel.ArrayList, 
                listBuilder.build()
            );
            builder.add(resValue);
            return true;
        });
        
        if (!calculator.isFullySimplified()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        calculator.putSummaryIfNotConcrete(call.getHf().getVg().getOBJECT_TYPE(), "return");
        call.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }
}