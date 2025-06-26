/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.Implement
 *  mock.GenerateSyntheticClass
 *  mock.GenerateSyntheticClassImpl
 *  mock.MockObject
 *  mock.MockObjectImpl
 *  soot.ArrayType
 *  soot.Body
 *  soot.Local
 *  soot.PrimType
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SootMethodRef
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.Jimple
 *  soot.jimple.JimpleBody
 *  utils.BaseBodyGenerator
 *  utils.JimpleUtils
 *  utils.NewUnits$BeforeUnit
 */
package mock;

import analysis.Implement;
import java.util.Collections;
import java.util.List;
import mock.GenerateSyntheticClass;
import mock.GenerateSyntheticClassImpl;
import mock.MockObject;
import soot.ArrayType;
import soot.Body;
import soot.Local;
import soot.PrimType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import utils.BaseBodyGenerator;
import utils.JimpleUtils;
import utils.NewUnits;

public class MockObjectImpl
implements MockObject {
    GenerateSyntheticClass gsc = new GenerateSyntheticClassImpl();

    public void mockJoinPoint(JimpleBody body, BaseBodyGenerator units) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        SootClass abstractClass = Scene.v().getSootClass("org.aspectj.lang.ProceedingJoinPoint");
        SootClass joinPointImpl = this.gsc.generateJoinPointImpl(abstractClass);
        Local joinPointLocal = jimpleUtils.addLocalVar(joinPointImpl.getShortName(), joinPointImpl.getName(), (Body)body);
        Local paramArray = jimpleUtils.addLocalVar("paramArray", (Type)ArrayType.v((Type)RefType.v((String)"java.lang.Object"), (int)1), (Body)body);
        int paramSize = body.getParameterLocals().size();
        jimpleUtils.createAssignStmt(joinPointLocal, joinPointImpl.getName(), units);
        NewUnits.BeforeUnit specialInit = jimpleUtils.specialCallStatement(joinPointLocal, JimpleUtils.getMinConstructorOrCreate((SootClass)joinPointImpl).toString(), units);
        units.add(specialInit);
        jimpleUtils.createAssignStmt((Value)paramArray, (Value)jimpleUtils.createNewArrayExpr("java.lang.Object", paramSize), units);
        for (int i = 0; i < paramSize; ++i) {
            Local paramLocalConverted;
            Local paramLocal = body.getParameterLocal(i);
            if (paramLocal.getType() instanceof PrimType) {
                RefType boxedType = ((PrimType)paramLocal.getType()).boxedType();
                SootMethodRef ref = Scene.v().makeMethodRef(boxedType.getSootClass(), "valueOf", Collections.singletonList(paramLocal.getType()), (Type)boxedType, true);
                paramLocalConverted = jimpleUtils.addLocalVar("primTypeParam" + i, (Type)boxedType, (Body)body);
                jimpleUtils.createAssignStmt((Value)paramLocalConverted, (Value)Jimple.v().newStaticInvokeExpr(ref, (Value)paramLocal), units);
            } else {
                paramLocalConverted = paramLocal;
            }
            jimpleUtils.createAssignStmt((Value)jimpleUtils.createArrayRef((Value)paramArray, i), (Value)paramLocalConverted, units);
        }
        units.add(jimpleUtils.virtualCallStatement(joinPointLocal, joinPointImpl.getMethodByName("setArgs_synthetic").toString(), Collections.singletonList(paramArray)));
    }

    public Local mockBean(JimpleBody body, BaseBodyGenerator units, SootClass sootClass, SootMethod toCall) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        Local paramRef = jimpleUtils.addLocalVar(toCall.getName() + sootClass.getShortName(), sootClass.getName(), (Body)body);
        jimpleUtils.createAssignStmt(paramRef, sootClass.getName(), units);
        SootMethod init2 = JimpleUtils.getMinConstructor((SootClass)sootClass);
        if (init2 != null) {
            NewUnits.BeforeUnit specialInit = jimpleUtils.specialCallStatement(paramRef, init2, units);
            units.add(specialInit);
        }
        List classes = sootClass.isInterface() ? Collections.emptyList() : Scene.v().getActiveHierarchy().getSuperclassesOfIncluding(sootClass);
        for (SootClass sc : classes) {
            for (SootMethod beanMethod : sc.getMethods()) {
                if (!beanMethod.getName().startsWith("set") || beanMethod.getParameterTypes().isEmpty()) continue;
                units.add(jimpleUtils.buildCallStatement(paramRef, beanMethod, units));
            }
        }
        return paramRef;
    }

    public Local mockHttpServlet(JimpleBody body, BaseBodyGenerator units, SootClass sootClass, SootMethod toCall) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        Local paramRef = jimpleUtils.addLocalVar(toCall.getName() + sootClass.getShortName(), sootClass.getName(), (Body)body);
        SootClass HttpServletImpl = this.gsc.generateHttpServlet(sootClass);
        jimpleUtils.createAssignStmt(paramRef, HttpServletImpl.getName(), units);
        Unit specialInit = jimpleUtils.specialCallStatement(paramRef, HttpServletImpl.getMethod("void <init>()").toString(), Collections.emptyList());
        units.add(specialInit);
        return paramRef;
    }
}

