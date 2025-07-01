package cn.sast.dataflow.util;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import soot.Body;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.IdentityRef;
import soot.jimple.IdentityStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.ParameterRef;
import soot.jimple.ThisRef;
import soot.jimple.infoflow.data.SootMethodAndClass;
import soot.jimple.infoflow.util.SootMethodRepresentationParser;

public final class SootUtilsKt {
    @NotNull
    public static SootMethodRef sootSignatureToRef(@NotNull String signature, boolean isStatic) {
        SootMethodAndClass smac = SootMethodRepresentationParser.v().parseSootMethodString(signature);
        SootClass sootClass = Scene.v().getSootClass(smac.getClassName());
        List<Type> parameterTypes = cn.sast.api.util.SootUtils.convertParameterTypes(smac.getParameters());
        Type returnType = Scene.v().getTypeUnsafe(smac.getReturnType(), true);
        return Scene.v().makeMethodRef(sootClass, smac.getMethodName(), parameterTypes, returnType, isStatic);
    }

    @NotNull
    public static Pair<Local, Type> argToOpAndType(@NotNull Body body, int index) {
        if (index == -1) {
            return Pair.of(body.getThisLocal(), body.getMethod().getDeclaringClass().getType());
        }
        if (index >= 0 && index < body.getMethod().getParameterCount()) {
            return Pair.of(body.getParameterLocal(index), body.getMethod().getParameterType(index));
        }
        throw new IllegalStateException(body + " parameterCount: " + body.getMethod().getParameterCount() + ", but index: " + index);
    }

    @NotNull
    public static Pair<Local, RefType> getThisLocalAndType(@NotNull Body body) {
        Pair<Local, Type> pair = argToOpAndType(body, -1);
        return Pair.of(pair.getFirst(), (RefType) pair.getSecond());
    }

    @NotNull
    public static Pair<IdentityRef, Type> argToIdentityRef(@NotNull Body body, int index) {
        if (index == -1) {
            IdentityStmt stmt = (IdentityStmt) body.getThisUnit();
            ThisRef thisRef = (ThisRef) stmt.getRightOp();
            return Pair.of(thisRef, thisRef.getType());
        }
        if (index >= 0 && index < body.getMethod().getParameterCount()) {
            ParameterRef paramRef = (ParameterRef) body.getParameterRefs().get(index);
            return Pair.of(paramRef, paramRef.getType());
        }
        throw new IllegalStateException(body + " parameterCount: " + body.getMethod().getParameterCount() + ", but index: " + index);
    }

    @NotNull
    public static Pair<ThisRef, RefType> getThisIdentityRef(@NotNull Body body) {
        Pair<IdentityRef, Type> pair = argToIdentityRef(body, -1);
        return Pair.of((ThisRef) pair.getFirst(), (RefType) pair.getSecond());
    }

    @NotNull
    public static Pair<Value, Type> argToOpAndType(@NotNull InvokeExpr expr, int index) {
        if (index == -1 && expr instanceof InstanceInvokeExpr) {
            InstanceInvokeExpr instanceExpr = (InstanceInvokeExpr) expr;
            return Pair.of(instanceExpr.getBase(), instanceExpr.getMethodRef().getDeclaringClass().getType());
        }
        if (index >= 0 && index < expr.getArgCount()) {
            return Pair.of(expr.getArg(index), expr.getMethodRef().getParameterType(index));
        }
        throw new IllegalStateException(expr + " parameterCount: " + expr.getMethodRef() + ", but index is: " + index);
    }

    @NotNull
    public static Pair<Value, Type> getThisOpAndType(@NotNull InvokeExpr expr) {
        return argToOpAndType(expr, -1);
    }

    @NotNull
    public static SootField getOrMakeField(@NotNull String sootClass, @NotNull String fieldName, @NotNull Type sootFieldType) {
        SootClass clazz = Scene.v().getSootClass(sootClass);
        if (clazz.declaresFieldByName(fieldName)) {
            return clazz.getFieldByName(fieldName);
        }
        return clazz.getOrAddField(new SootField(fieldName, sootFieldType));
    }
}