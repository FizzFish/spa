/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.AOPAnalysis
 *  analysis.AOPAnalysis$1
 *  analysis.AOPParser
 *  analysis.Implement
 *  bean.AOPTargetModel
 *  bean.AspectModel
 *  bean.InsertMethod
 *  enums.AdviceEnum
 *  mock.MockObject
 *  soot.Body
 *  soot.Local
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.VoidType
 *  soot.jimple.JimpleBody
 *  soot.jimple.internal.JIdentityStmt
 *  utils.BaseBodyGenerator
 *  utils.BaseBodyGeneratorFactory
 *  utils.JimpleUtils
 */
package analysis;

import analysis.AOPAnalysis;
import analysis.AOPParser;
import analysis.Implement;
import bean.AOPTargetModel;
import bean.AspectModel;
import bean.InsertMethod;
import enums.AdviceEnum;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import mock.MockObject;
import soot.Body;
import soot.Local;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.VoidType;
import soot.jimple.JimpleBody;
import soot.jimple.internal.JIdentityStmt;
import utils.BaseBodyGenerator;
import utils.BaseBodyGeneratorFactory;
import utils.JimpleUtils;

public class AOPAnalysis {
    public static Map<String, InsertMethod> insertMethodMap = new LinkedHashMap();
    public static boolean newVersion = false;

    public void processWeave(AOPTargetModel targetModel) {
        AOPParser ap = new AOPParser();
        SootMethod targetMethod = targetModel.getSootMethod();
        SootMethod proxyMethod = targetModel.getProxyMethod();
        this.modifyJimpleBody(proxyMethod);
        SootMethod currentMethod = proxyMethod;
        SootMethod preMethod = proxyMethod;
        AdviceEnum currentEnum = null;
        for (AspectModel aspectModel : targetModel.getAdvices()) {
            switch (1.$SwitchMap$enums$AdviceEnum[aspectModel.getAnnotation().ordinal()]) {
                case 1: {
                    preMethod = currentMethod;
                    SootMethod aroundMethod = ap.aroundParser(aspectModel, targetMethod);
                    ap.insertAOPAround(currentMethod, aroundMethod);
                    currentMethod = aroundMethod;
                    currentEnum = AdviceEnum.AOP_AROUND;
                    break;
                }
                case 2: {
                    ap.insertAOPBefore(currentMethod, aspectModel.getSootMethod());
                    break;
                }
                case 3: {
                    SootMethod insertTargetMethod = newVersion ? currentMethod : preMethod;
                    ap.insertAOPAfter(insertTargetMethod, aspectModel.getSootMethod());
                    break;
                }
                case 4: {
                    SootMethod insertTargetMethod = newVersion ? currentMethod : preMethod;
                    ap.insertAOPAfterReturning(insertTargetMethod, aspectModel.getSootMethod(), aspectModel.getPointcutExpressions());
                    break;
                }
            }
        }
        ap.insertAOPTarget(currentMethod, targetMethod, currentEnum);
    }

    public void modifyJimpleBody(SootMethod method) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        MockObject mockObject = Implement.mockObject;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(method);
        ArrayList<Unit> returnList = new ArrayList<Unit>();
        ArrayList<Unit> insertPointList = new ArrayList<Unit>();
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        units.getUnits().removeIf(unit -> !(unit instanceof JIdentityStmt) && !unit.toString().contains("localTarget = "));
        mockObject.mockJoinPoint(body, units);
        Type returnType = method.getReturnType();
        if (returnType instanceof VoidType) {
            jimpleUtils.addVoidReturnStmt(units);
        } else {
            Local returnRef = null;
            for (Local local : body.getLocals()) {
                if (!local.getName().equals("returnRef")) continue;
                returnRef = local;
                break;
            }
            if (returnRef == null) {
                returnRef = jimpleUtils.addLocalVar("returnRef", returnType, (Body)body);
            }
            jimpleUtils.addCommonReturnStmt(returnRef, units);
        }
        returnList.add(units.getUnits().getLast());
        insertPointList.add(units.getUnits().getLast());
        insertMethodMap.put(method.toString(), new InsertMethod(method, returnList, insertPointList));
    }

    public static void clear() {
        insertMethodMap.clear();
    }
}

