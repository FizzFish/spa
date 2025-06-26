/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.AOPParser
 *  analysis.AnnotationAnalysis
 *  analysis.Config
 *  analysis.CreateEdge
 *  analysis.IOCParser
 *  analysis.Implement
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  soot.AmbiguousMethodException
 *  soot.Body
 *  soot.Hierarchy
 *  soot.Local
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootFieldRef
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.Value
 *  soot.VoidType
 *  soot.jimple.JimpleBody
 *  soot.jimple.StaticInvokeExpr
 *  soot.jimple.internal.JReturnStmt
 *  soot.jimple.internal.JReturnVoidStmt
 *  utils.BaseBodyGenerator
 *  utils.BaseBodyGeneratorFactory
 *  utils.JimpleUtils
 */
package analysis;

import analysis.AOPParser;
import analysis.AnnotationAnalysis;
import analysis.Config;
import analysis.CreateEdge;
import analysis.Implement;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.AmbiguousMethodException;
import soot.Body;
import soot.Hierarchy;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.VoidType;
import soot.jimple.JimpleBody;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
import utils.BaseBodyGenerator;
import utils.BaseBodyGeneratorFactory;
import utils.JimpleUtils;

public class IOCParser {
    private static final Logger logger = LoggerFactory.getLogger(IOCParser.class);
    private final Map<SootClass, String> initMap = new LinkedHashMap();
    private final Map<SootClass, SootClass> potentialImpl = new LinkedHashMap();

    public void getIOCObject(SootClass sootClass, Set<SootMethod> allBeans) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        AnnotationAnalysis annotationAnalysis = new AnnotationAnalysis();
        Hierarchy hierarchy = Scene.v().getActiveHierarchy();
        String cName = null;
        String initStr = null;
        SootMethod initMethod = null;
        boolean ambiguous = false;
        try {
            initMethod = sootClass.getMethodByName("<init>");
        }
        catch (AmbiguousMethodException amx) {
            ambiguous = true;
        }
        for (SootMethod method : sootClass.getMethods()) {
            List paramOfAutoWiredMethod = annotationAnalysis.getParamOfAutoWiredMethod(method);
            if (paramOfAutoWiredMethod != null) {
                AnnotationAnalysis.autoMethodParams.addAll(paramOfAutoWiredMethod);
            }
            if (!ambiguous || !method.getName().equals("<init>")) continue;
            initMethod = method;
            break;
        }
        block3: for (SootField classField : sootClass.getFields()) {
            String realType;
            SootField field = annotationAnalysis.getFieldWithSpecialAnnos(classField, initMethod, ambiguous);
            if (field == null) continue;
            SootFieldRef sootFieldRef = field.makeRef();
            cName = field.getDeclaringClass().getName();
            String vtype = field.getType().toString();
            SootClass fieldClass = JimpleUtils.getClassUnsafe((Type)field.getType());
            SootClass aClass = null;
            if (fieldClass != null) {
                aClass = CreateEdge.interfaceToBeans.getOrDefault(fieldClass.getName(), null);
            }
            if (aClass != null && !aClass.isInterface()) {
                SootClass beanClass = AOPParser.proxyMap.getOrDefault(aClass.getName(), aClass);
                realType = beanClass.getType().toString();
                initStr = this.mapInitMethod(beanClass, this.initMap);
                assert (initMethod != null);
                if (beanClass != aClass || CreateEdge.prototypeComponents.contains(aClass)) {
                    this.initIOCObjectByPrototype(sootFieldRef, initMethod, vtype, realType, initStr);
                    continue;
                }
                this.initIOCObjectBySingleton(sootFieldRef, initMethod, vtype, aClass);
                continue;
            }
            assert (initMethod != null);
            if (fieldClass == null) continue;
            if (fieldClass.isPhantom()) {
                logger.warn("can't find this bean: " + fieldClass.getName() + " in " + sootClass);
                continue;
            }
            if (this.filterBaseClass(fieldClass)) continue;
            if (!fieldClass.isInterface() && !fieldClass.isAbstract()) {
                initStr = this.mapInitMethod(fieldClass, this.initMap);
                this.initIOCObjectByPrototype(sootFieldRef, initMethod, vtype, fieldClass.getType().toString(), initStr);
                continue;
            }
            SootClass hierarchyClass = null;
            if (this.potentialImpl.containsKey(fieldClass)) {
                hierarchyClass = (SootClass)this.potentialImpl.get(fieldClass);
            } else {
                List hierarchyClasses;
                List list = hierarchyClasses = fieldClass.isInterface() ? hierarchy.getImplementersOf(fieldClass) : hierarchy.getSubclassesOf(fieldClass);
                if (hierarchyClasses.size() > 0) {
                    hierarchyClass = (SootClass)hierarchyClasses.get(0);
                    this.potentialImpl.put(fieldClass, hierarchyClass);
                }
            }
            if (hierarchyClass != null) {
                initStr = this.mapInitMethod(hierarchyClass, this.initMap);
                this.initIOCObjectByPrototype(sootFieldRef, initMethod, vtype, hierarchyClass.getType().toString(), initStr);
                continue;
            }
            logger.warn("can't find this bean: " + fieldClass.getName() + " in " + sootClass);
            for (SootMethod bean : allBeans) {
                UnitPatchingChain units = jimpleUtils.getMethodBody(bean).getUnits();
                RefType returnType = null;
                SootClass returnClass = null;
                if (bean.getReturnType() instanceof VoidType || !field.getType().equals(bean.getReturnType()) && !((RefType)bean.getReturnType()).getSootClass().getInterfaces().contains((Object)((RefType)bean.getReturnType()).getSootClass())) continue;
                for (Unit unit : units) {
                    if (!(unit instanceof JReturnStmt)) continue;
                    returnType = (RefType)((JReturnStmt)unit).getOpBox().getValue().getType();
                    returnClass = returnType.getSootClass();
                    break;
                }
                assert (initMethod != null);
                if (returnClass == null || returnClass.isInterface() || returnClass.isAbstract() || returnClass.getMethodUnsafe("void <init>()") == null) {
                    initStr = JimpleUtils.getMinConstructorOrCreate((SootClass)bean.getDeclaringClass()).toString();
                    String callStr = bean.toString();
                    this.initIOCObjectByPrototype(sootFieldRef, initMethod, vtype, bean.getDeclaringClass().toString(), initStr, callStr);
                    continue block3;
                }
                initStr = returnClass.getMethodUnsafe("void <init>()").toString();
                realType = returnType.toString();
                this.initIOCObjectByPrototype(sootFieldRef, initMethod, vtype, realType, initStr);
                continue block3;
            }
        }
    }

    private boolean filterBaseClass(SootClass sc) {
        switch (sc.getName()) {
            case "java.lang.String": {
                return true;
            }
        }
        return false;
    }

    private String mapInitMethod(SootClass sootClass, Map<SootClass, String> initMap) {
        String initStr = null;
        if (initMap.containsKey(sootClass)) {
            initStr = initMap.get(sootClass);
        } else {
            initStr = JimpleUtils.getMinConstructorOrCreate((SootClass)sootClass).toString();
            initMap.put(sootClass, initStr);
        }
        return initStr;
    }

    private void initIOCObjectByPrototype(SootFieldRef sootFieldRef, SootMethod initMethod, String vtype, String declType, String initStr, String callStr) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(initMethod);
        Local tmpRef = jimpleUtils.addLocalVar(vtype.substring(vtype.lastIndexOf(".") + 1).toLowerCase(), (Type)RefType.v((String)vtype), (Body)body);
        Local declRef = jimpleUtils.addLocalVar(declType.substring(declType.lastIndexOf(".") + 1).toLowerCase(), (Type)RefType.v((String)declType), (Body)body);
        Local thisRef = body.getThisLocal();
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        units.getUnits().removeIf(unit -> unit instanceof JReturnVoidStmt);
        jimpleUtils.createAssignStmt((Value)declRef, (Value)jimpleUtils.createNewExpr(declType), units);
        units.add(jimpleUtils.specialCallStatement(declRef, initStr, units));
        SootMethod toCall2 = Scene.v().getMethod(callStr);
        jimpleUtils.createAssignStmt((Value)tmpRef, jimpleUtils.createVirtualInvokeExpr(declRef, toCall2, units), units);
        if (!sootFieldRef.isStatic()) {
            jimpleUtils.createAssignStmt((Value)jimpleUtils.createInstanceFieldRef((Value)thisRef, sootFieldRef), (Value)tmpRef, units);
        }
        jimpleUtils.addVoidReturnStmt(units);
    }

    public void initIOCObjectByPrototype(SootFieldRef sootFieldRef, SootMethod initMethod, String vtype, String realType, String initStr) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(initMethod);
        Local thisRef = body.getThisLocal();
        Local tmpRef = jimpleUtils.addLocalVar(vtype.substring(vtype.lastIndexOf(".") + 1).toLowerCase(), vtype, (Body)body);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        units.getUnits().removeIf(unit -> unit instanceof JReturnVoidStmt);
        jimpleUtils.createAssignStmt((Value)tmpRef, (Value)jimpleUtils.createNewExpr(realType), units);
        units.add(jimpleUtils.specialCallStatement(tmpRef, initStr, units));
        if (!sootFieldRef.isStatic()) {
            jimpleUtils.createAssignStmt((Value)jimpleUtils.createInstanceFieldRef((Value)thisRef, sootFieldRef), (Value)tmpRef, units);
            jimpleUtils.addVoidReturnStmt(units);
        }
    }

    public void initIOCObjectBySingleton(SootFieldRef sootFieldRef, SootMethod initMethod, String vtype, SootClass fieldClass) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(initMethod);
        Local thisRef = body.getThisLocal();
        Local tmpRef = jimpleUtils.addLocalVar(vtype.substring(vtype.lastIndexOf(".") + 1).toLowerCase(), vtype, (Body)body);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        units.getUnits().removeIf(unit -> unit instanceof JReturnVoidStmt);
        SootClass singletonFactory = Scene.v().getSootClass(Config.SINGLETON_FACTORY_CNAME);
        StaticInvokeExpr returnValue = jimpleUtils.createStaticInvokeExpr(singletonFactory.getMethod(fieldClass.getName() + " get" + fieldClass.getShortName() + "()"), Collections.emptyList());
        jimpleUtils.createAssignStmt((Value)tmpRef, (Value)returnValue, units);
        try {
            jimpleUtils.createAssignStmt((Value)jimpleUtils.createInstanceFieldRef((Value)thisRef, sootFieldRef), (Value)tmpRef, units);
        }
        catch (Exception exception) {
            // empty catch block
        }
        jimpleUtils.addVoidReturnStmt(units);
    }
}

