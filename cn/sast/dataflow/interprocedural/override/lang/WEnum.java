package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.AnyNewExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.StringConstant;
import soot.util.Chain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class WEnum implements SummaryHandlePackage<IValue> {
    private static final Logger logger = LoggerFactory.getLogger(WEnum.class);
    private static final Map<Pair<SootClass, String>, Triple<SootClass, String, Integer>> enumInitCache = new HashMap<>();
    
    @Nullable
    private final SootField nameField = Scene.v().grabField("<java.lang.Enum: java.lang.String name>");

    @NotNull
    public Map<Pair<SootClass, String>, Triple<SootClass, String, Integer>> getInvokeEnumInitExpr() {
        if (enumInitCache.isEmpty()) {
            initializeEnumInitCache();
        }
        return enumInitCache;
    }

    @Nullable
    public SootField getNameField() {
        return nameField;
    }

    public void register(@NotNull ACheckCallAnalysis analysis) {
        if (nameField == null) {
            logger.error("<java.lang.Enum: java.lang.String name> not exist");
            return;
        }
        
        analysis.evalCallAtCaller("<java.lang.Enum: java.lang.Enum valueOf(java.lang.Class,java.lang.String)>", 
            evalCall -> handleValueOfCall(evalCall));
        analysis.registerClassAllWrapper("java.lang.Enum");
    }

    private void initializeEnumInitCache() {
        Chain<SootClass> classes = Scene.v().getClasses();
        for (SootClass sootClass : classes) {
            for (SootMethod method : sootClass.getMethods()) {
                if (!method.hasActiveBody()) continue;
                
                for (Unit unit : method.getActiveBody().getUnits()) {
                    if (!(unit instanceof InvokeStmt)) continue;
                    
                    InvokeStmt invoke = (InvokeStmt)unit;
                    if (!invoke.containsInvokeExpr() || 
                        !invoke.getInvokeExpr().getMethod().getDeclaringClass().isEnum() ||
                        !"void <init>(java.lang.String,int)".equals(invoke.getInvokeExpr().getMethod().getSubSignature())) {
                        continue;
                    }
                    
                    List<Value> args = invoke.getInvokeExpr().getArgs();
                    Value enumNameValue = args.get(0);
                    Value idValue = args.get(1);
                    
                    String enumName = enumNameValue instanceof StringConstant ? 
                        ((StringConstant)enumNameValue).value : null;
                    Integer id = idValue instanceof IntConstant ? 
                        ((IntConstant)idValue).value : null;
                    
                    if (enumName != null && id != null) {
                        SootClass declaringClass = invoke.getInvokeExpr().getMethod().getDeclaringClass();
                        enumInitCache.put(
                            new Pair<>(declaringClass, enumName),
                            new Triple<>(declaringClass, enumName, id)
                        );
                    }
                }
            }
        }
    }

    private void handleValueOfCall(CallerSiteCBImpl.EvalCall evalCall) {
        IHeapValues classP = evalCall.arg(0);
        IHeapValues nameP = evalCall.arg(1);
        
        IOpCalculator valueOfOp = evalCall.getHf().resolveOp(
            (HeapValuesEnv)evalCall.getEnv(), 
            new IHeapValues[]{classP}
        );
        
        valueOfOp.resolve((op, ret, companions) -> {
            CompanionV clazzC = companions[0];
            Type type = FactValuesKt.getClassValue(clazzC.getValue(), false);
            
            if (!(type instanceof RefType)) return false;
            RefType clazz = (RefType)type;
            
            NewExpr newExpr = Jimple.v().newNewExpr(clazz);
            AbstractHeapFactory hf = evalCall.getHf();
            HeapValuesEnv env = (HeapValuesEnv)evalCall.getEnv();
            
            IHeapValues enumNew = hf.push(env, hf.anyNewVal(evalCall.getNewEnv(), newExpr)).popHV();
            
            evalCall.getOut().assignNewExpr(env, "@new", enumNew, false);
            evalCall.getOut().setFieldNew(env, "@new", new JSootFieldType(nameField), nameP);
            evalCall.getOut().kill("@new");
            
            op.getRes().add(enumNew);
            return true;
        });
        
        RefType enumType = Scene.v().getRefType("java.lang.Enum");
        valueOfOp.putSummaryIfNotConcrete(enumType, "valueOf");
        evalCall.setReturn(valueOfOp.getRes().build());
    }

    // Simple Pair and Triple implementations for Java
    private static class Pair<A, B> {
        final A first;
        final B second;
        
        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Triple<A, B, C> {
        final A first;
        final B second;
        final C third;
        
        Triple(A first, B second, C third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
