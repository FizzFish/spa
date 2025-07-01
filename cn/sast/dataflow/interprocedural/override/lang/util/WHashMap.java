package cn.sast.dataflow.interprocedural.override.lang.util;

import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.check.*;
import cn.sast.dataflow.interprocedural.check.callback.*;
import org.jetbrains.annotations.NotNull;
import soot.G;
import soot.IntType;
import soot.Type;
import java.util.List;

public final class WHashMap implements SummaryHandlePackage<IValue> {
    public static final Companion Companion = new Companion();

    public static final class Companion {
        private Companion() {}
    }

    @Override
    public void register(@NotNull ACheckCallAnalysis analysis) {
        if (analysis == null) throw new IllegalArgumentException("<this> cannot be null");

        List<String> constructors = List.of(
            "<java.util.HashMap: void <init>()>",
            "<java.util.HashMap: void <init>(int)>",
            "<java.util.HashMap: void <init>(int, float)>"
        );

        String clearSig = "<java.util.HashMap: void clear()>";
        String getSig = "<java.util.HashMap: java.lang.Object get(java.lang.Object)>";
        String getOrDefaultSig = "<java.util.HashMap: java.lang.Object getOrDefault(java.lang.Object,java.lang.Object)>";
        String putSig = "<java.util.HashMap: java.lang.Object put(java.lang.Object,java.lang.Object)>";

        constructors.forEach(sig -> 
            analysis.evalCallAtCaller(sig, WHashMap::handleConstructor)
        );

        analysis.evalCallAtCaller(clearSig, WHashMap::handleClear);
        analysis.evalCallAtCaller(getSig, call -> handleGet(analysis, call));
        analysis.evalCallAtCaller(getOrDefaultSig, call -> handleGetOrDefault(analysis, call));
        analysis.evalCall(putSig, WHashMap::handlePut);
    }

    private static IHeapValues<IValue> mapGetModel(ACheckCallAnalysis analysis, IData<IValue> mapData, IValue key) {
        if (key.getType().equals(analysis.getHf().getVg().getSTRING_TYPE())) {
            String keyStr = FactValuesKt.getStringValue(key, false);
            if (keyStr == null) return null;
            return ((ArraySpace)mapData).get(analysis.getHf(), Math.abs(keyStr.hashCode()));
        }
        return null;
    }

    private static Unit handleConstructor(CallerSiteCBImpl.EvalCall call) {
        if (call == null) throw new IllegalArgumentException("Call cannot be null");
        
        IHeapValues self = call.arg(-1);
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), new IHeapValues[]{self});
        calculator.resolve((op, builder, companions) -> {
            CompanionV selfV = companions[0];
            AbstractHeapFactory hf = call.getHf();
            HeapValuesEnv env = (HeapValuesEnv)call.getEnv();
            
            IHeapValues length = hf.push(env, hf.newSummaryVal(env, G.v().soot_IntType(), "mapSize")).popHV();
            ArraySpace map = ArraySpace.Companion.v(
                hf, env, 
                ExtensionsKt.persistentHashMapOf(), 
                hf.empty(), 
                hf.getVg().getOBJ_ARRAY_TYPE(), 
                length
            );
            call.getOut().setValueData(env, selfV.getValue(), OverrideModel.HashMap, map);
            return true;
        });
        return Unit.INSTANCE;
    }

    private static Unit handleClear(CallerSiteCBImpl.EvalCall call) {
        if (call == null) throw new IllegalArgumentException("Call cannot be null");
        
        IHeapValues self = call.getThis();
        if (!self.isSingle()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), new IHeapValues[]{self});
        calculator.resolve((op, builder, companions) -> {
            CompanionV selfV = companions[0];
            AbstractHeapFactory hf = call.getHf();
            HeapValuesEnv env = (HeapValuesEnv)call.getEnv();
            
            IHeapValues length = hf.push(env, hf.newSummaryVal(env, G.v().soot_IntType(), "mapSize")).popHV();
            ArraySpace map = ArraySpace.Companion.v(
                hf, env, 
                ExtensionsKt.persistentHashMapOf(), 
                hf.empty(), 
                hf.getVg().getOBJ_ARRAY_TYPE(), 
                length
            );
            call.getOut().setValueData(env, selfV.getValue(), OverrideModel.HashMap, map);
            return true;
        });
        return Unit.INSTANCE;
    }

    private static Unit handleGet(ACheckCallAnalysis analysis, CallerSiteCBImpl.EvalCall call) {
        if (call == null) throw new IllegalArgumentException("Call cannot be null");
        
        IHeapValues map = call.getThis();
        IHeapValues key = call.arg(0);
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), new IHeapValues[]{map, key});
        
        if (!map.isSingle()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        calculator.resolve((op, res, companions) -> {
            CompanionV mapV = companions[0];
            CompanionV keyV = companions[1];
            
            IData mapData = call.getOut().getValueData(mapV.getValue(), OverrideModel.HashMap);
            if (mapData == null) return false;
            
            IHeapValues result = mapGetModel(analysis, mapData, (IValue)keyV.getValue());
            if (result == null) return false;
            
            res.add(result);
            return true;
        });
        
        if (!calculator.isFullySimplified() || calculator.getRes().isEmpty()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        call.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }

    private static Unit handleGetOrDefault(ACheckCallAnalysis analysis, CallerSiteCBImpl.EvalCall call) {
        if (call == null) throw new IllegalArgumentException("Call cannot be null");
        
        IHeapValues map = call.getThis();
        if (!map.isSingle()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        IHeapValues key = call.arg(0);
        IHeapValues defaultValue = call.arg(1);
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), new IHeapValues[]{map, key, defaultValue});
        
        calculator.resolve((op, res, companions) -> {
            CompanionV mapV = companions[0];
            CompanionV keyV = companions[1];
            CompanionV defaultV = companions[2];
            
            IData mapData = call.getOut().getValueData(mapV.getValue(), OverrideModel.HashMap);
            if (mapData == null) return false;
            
            IHeapValues result = mapGetModel(analysis, mapData, (IValue)keyV.getValue());
            res.add(result != null ? result : call.getHf().single(defaultV));
            return true;
        });
        
        if (!calculator.isFullySimplified() || calculator.getRes().isEmpty()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        call.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }

    private static Unit handlePut(CalleeCBImpl.EvalCall call) {
        if (call == null) throw new IllegalArgumentException("Call cannot be null");
        
        IHeapValues map = call.getThis();
        if (!map.isSingle()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        IHeapValues key = call.arg(0);
        IHeapValues value = call.arg(1);
        IOpCalculator calculator = call.getHf().resolveOp((HeapValuesEnv)call.getEnv(), new IHeapValues[]{map, key});
        
        calculator.resolve((op, res, companions) -> {
            CompanionV mapV = companions[0];
            CompanionV keyV = companions[1];
            
            IData mapData = call.getOut().getValueData(mapV.getValue(), OverrideModel.HashMap);
            if (mapData == null) return false;
            
            ArraySpaceBuilder builder = ((ArraySpace)mapData).builder();
            if (((IValue)keyV.getValue()).getType().equals(call.getHf().getVg().getSTRING_TYPE())) {
                String keyStr = FactValuesKt.getStringValue((IValue)keyV.getValue(), false);
                if (keyStr == null) {
                    builder.set(call.getHf(), (HeapValuesEnv)call.getEnv(), null, value, true);
                } else {
                    builder.set(call.getHf(), (HeapValuesEnv)call.getEnv(), Math.abs(keyStr.hashCode()), value, true);
                }
            } else {
                builder.set(call.getHf(), (HeapValuesEnv)call.getEnv(), null, value, true);
            }
            
            call.getOut().setValueData((HeapValuesEnv)call.getEnv(), mapV.getValue(), OverrideModel.HashMap, builder.build());
            res.add(((ArraySpace)mapData).getElement(call.getHf()));
            return true;
        });
        
        if (!calculator.isFullySimplified()) {
            call.setEvalAble(false);
            return Unit.INSTANCE;
        }
        
        call.setReturn(calculator.getRes().build());
        return Unit.INSTANCE;
    }
}
