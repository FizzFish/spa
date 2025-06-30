/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.Config
 *  analysis.CreateEdge
 *  analysis.Implement
 *  bean.ConstructorArgBean
 *  mock.GenerateSyntheticClass
 *  mock.GenerateSyntheticClassImpl
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  soot.ArrayType
 *  soot.Body
 *  soot.Local
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.VoidType
 *  soot.jimple.JimpleBody
 *  soot.jimple.VirtualInvokeExpr
 *  soot.jimple.internal.JIdentityStmt
 *  soot.util.Chain
 *  utils.BaseBodyGenerator
 *  utils.BaseBodyGeneratorFactory
 *  utils.JimpleUtils
 */
package mock;

import analysis.Config;
import analysis.CreateEdge;
import analysis.Implement;
import bean.ConstructorArgBean;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import mock.GenerateSyntheticClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.ArrayType;
import soot.Body;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.jimple.JimpleBody;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.internal.JIdentityStmt;
import soot.util.Chain;
import utils.BaseBodyGenerator;
import utils.BaseBodyGeneratorFactory;
import utils.JimpleUtils;

public class GenerateSyntheticClassImpl
implements GenerateSyntheticClass {
    private static final Logger logger = LoggerFactory.getLogger(GenerateSyntheticClassImpl.class);
    private static final Map<String, SootClass> syntheticMethodImpls = new LinkedHashMap();
    private Map<String, Set<String>> classMethodsMap = new LinkedHashMap();

    public SootClass generateJoinPointImpl(SootClass abstractClass) {
        SootClass customImplClass;
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        String implClassName = "synthetic.method." + abstractClass.getShortName() + "Impl";
        if (syntheticMethodImpls.containsKey(implClassName)) {
            customImplClass = (SootClass)syntheticMethodImpls.get(implClassName);
        } else {
            customImplClass = this.createSubClass(implClassName, abstractClass, Scene.v().getObjectType().getSootClass());
            SootClass joinPointSc = Scene.v().getSootClassUnsafe("org.aspectj.lang.JoinPoint");
            if (joinPointSc == null) {
                joinPointSc = Scene.v().makeSootClass("org.aspectj.lang.JoinPoint", 512);
                Scene.v().addClass(joinPointSc);
            }
            customImplClass.addInterface(joinPointSc);
            Scene.v().addClass(customImplClass);
            customImplClass.setApplicationClass();
            SootField field = new SootField("args", (Type)ArrayType.v((Type)RefType.v((String)"java.lang.Object"), (int)1));
            customImplClass.addField(field);
            SootMethod initMethod = jimpleUtils.genDefaultConstructor(customImplClass);
            customImplClass.addMethod(initMethod);
            for (SootClass anInterface : customImplClass.getInterfaces()) {
                this.implCommonMethod(customImplClass, anInterface);
            }
            for (SootClass abstractClassInterface : abstractClass.getInterfaces()) {
                this.implCommonMethod(customImplClass, abstractClassInterface);
            }
            customImplClass.addMethod(jimpleUtils.genCustomMethod(customImplClass, "setArgs_synthetic", Arrays.asList(ArrayType.v((Type)RefType.v((String)"java.lang.Object"), (int)1)), (Type)VoidType.v()));
            syntheticMethodImpls.put(implClassName, customImplClass);
        }
        return customImplClass;
    }

    public SootClass generateMapperImpl(SootClass interfaceClass) {
        SootClass mapperImplClass;
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        String implClassName = "synthetic.method." + interfaceClass.getShortName() + "Impl";
        if (syntheticMethodImpls.containsKey(implClassName)) {
            mapperImplClass = (SootClass)syntheticMethodImpls.get(implClassName);
        } else {
            mapperImplClass = this.createSubClass(implClassName, interfaceClass, Scene.v().getObjectType().getSootClass());
            Scene.v().addClass(mapperImplClass);
            mapperImplClass.setApplicationClass();
            SootMethod initMethod = jimpleUtils.genDefaultConstructor(mapperImplClass);
            mapperImplClass.addMethod(initMethod);
            this.implCommonMethod(mapperImplClass, interfaceClass);
            syntheticMethodImpls.put(implClassName, mapperImplClass);
        }
        return mapperImplClass;
    }

    public SootClass generateProxy(SootClass targetSootClass) {
        SootClass proxyClass;
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        String proxyClassName = targetSootClass.getName() + "$" + Config.PROXY_CLASS_SUFFIX;
        if (syntheticMethodImpls.containsKey(proxyClassName)) {
            proxyClass = (SootClass)syntheticMethodImpls.get(proxyClassName);
        } else {
            boolean isInterface = targetSootClass.isInterface();
            proxyClass = isInterface ? this.createSubClass(proxyClassName, targetSootClass, Scene.v().getObjectType().getSootClass()) : this.createSubClass(proxyClassName, null, targetSootClass);
            Scene.v().addClass(proxyClass);
            SootField field = new SootField("target", (Type)targetSootClass.getType());
            proxyClass.addField(field);
            SootMethod initMethod = CreateEdge.prototypeComponents.contains(proxyClass) ? jimpleUtils.genDefaultConstructor(proxyClass, field, false) : jimpleUtils.genDefaultConstructor(proxyClass, field, true);
            proxyClass.addMethod(initMethod);
            proxyClass.setApplicationClass();
            if (isInterface) {
                this.implCommonMethod(proxyClass, targetSootClass);
            } else {
                this.extendCommonMethod(proxyClass, targetSootClass);
            }
            syntheticMethodImpls.put(proxyClassName, proxyClass);
        }
        return proxyClass;
    }

    public void generateSingletonBeanFactory(Set<SootClass> beans, Map<String, List<ConstructorArgBean>> collect) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        if (collect != null && !collect.isEmpty()) {
            for (String className : collect.keySet()) {
                SootClass collectClass = Scene.v().getSootClassUnsafe(className, true);
                beans.add(collectClass);
            }
        }
        String singletonFactoryName = Config.SINGLETON_FACTORY_CNAME;
        SootClass singletonFactory = this.createSubClass(singletonFactoryName, null, Scene.v().getObjectType().getSootClass());
        Scene.v().addClass(singletonFactory);
        singletonFactory.setApplicationClass();
        LinkedHashSet<SootField> fields = new LinkedHashSet<SootField>();
        for (SootClass bean : beans) {
            if (Config.linkSpringCGLIB_CallEntrySyntheticAndRequestMappingMethods.booleanValue()) {
                SootField field = new SootField(bean.getShortName(), (Type)bean.getType(), 9);
                fields.add(field);
                singletonFactory.addField(field);
                singletonFactory.addMethod(jimpleUtils.genStaticCustomMethod(singletonFactory, "get" + bean.getShortName(), null, (Type)bean.getType(), field));
                continue;
            }
            singletonFactory.addMethod(jimpleUtils.genStaticCustomMethod(singletonFactory, "get" + bean.getShortName(), null, (Type)bean.getType(), bean, collect));
        }
        SootMethod initMethod = jimpleUtils.genDefaultConstructor(singletonFactory, null, false);
        singletonFactory.addMethod(initMethod);
        SootMethod clinitMethod = jimpleUtils.genDefaultClinit(singletonFactory, fields, collect);
        singletonFactory.addMethod(clinitMethod);
    }

    public SootClass generateHttpServlet(SootClass abstractClass) {
        SootClass customImplClass;
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        String implClassName = "synthetic.method." + abstractClass.getShortName() + "Impl";
        if (syntheticMethodImpls.containsKey(implClassName)) {
            customImplClass = (SootClass)syntheticMethodImpls.get(implClassName);
        } else {
            customImplClass = this.createSubClass(implClassName, abstractClass, Scene.v().getObjectType().getSootClass());
            Scene.v().addClass(customImplClass);
            customImplClass.setApplicationClass();
            SootMethod initMethod = jimpleUtils.genDefaultConstructor(customImplClass);
            customImplClass.addMethod(initMethod);
            this.implCommonMethod(customImplClass, abstractClass);
            syntheticMethodImpls.put(implClassName, customImplClass);
        }
        return customImplClass;
    }

    public SootClass createSubClass(String implClassName, SootClass interfaceClass, SootClass superClass) {
        SootClass customImplClass = new SootClass(implClassName);
        customImplClass.setResolvingLevel(3);
        if (interfaceClass != null) {
            interfaceClass.setModifiers(interfaceClass.getModifiers() | 0x200);
            customImplClass.addInterface(interfaceClass);
        }
        customImplClass.setModifiers(1);
        customImplClass.setSuperclass(superClass);
        return customImplClass;
    }

    public void implCommonMethod(SootClass customImplClass, SootClass interfaceClass) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        for (SootMethod method : interfaceClass.getMethods()) {
            if (method.isStatic() || method.isPrivate() || method.isFinal() || method.isConstructor() || method.isStaticInitializer()) continue;
            try {
                customImplClass.getOrAddMethod(jimpleUtils.genCustomMethod(customImplClass, method.getName(), method.getParameterTypes(), method.getReturnType()));
            }
            catch (RuntimeException e) {
                logger.warn("Exception: implCommonMethod customImplClass: {} interfaceClass: {}, e: {}", new Object[]{customImplClass, interfaceClass, e.getMessage()});
            }
        }
        for (SootClass superInterface : interfaceClass.getInterfaces()) {
            this.implCommonMethod(customImplClass, superInterface);
        }
    }

    public void extendCommonMethod(SootClass customSubClass, SootClass superClass) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        for (SootMethod superMethod : superClass.getMethods()) {
            if (superMethod.isStatic() || superMethod.isPrivate() || superMethod.isFinal() || superMethod.isConstructor() || superMethod.isStaticInitializer()) continue;
            SootMethod subMethod = new SootMethod(superMethod.getName(), superMethod.getParameterTypes(), superMethod.getReturnType(), superMethod.getModifiers());
            customSubClass.addMethod(subMethod);
            JimpleBody subMethodBody = (JimpleBody)jimpleUtils.getMethodBody(superMethod).clone();
            Chain locals = subMethodBody.getLocals();
            BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)subMethodBody);
            units.getUnits().removeIf(unit -> !(unit instanceof JIdentityStmt) || !unit.toString().contains("@parameter"));
            subMethodBody.getTraps().clear();
            LinkedHashSet<Local> tmplocal = new LinkedHashSet<Local>();
            if (units.size() == 0) {
                locals.removeIf(Objects::nonNull);
            } else {
                for (Unit unit2 : units.getUnits()) {
                    JIdentityStmt jstmt = (JIdentityStmt)unit2;
                    if (!locals.contains((Object)jstmt.getLeftOpBox().getValue())) continue;
                    tmplocal.add((Local)jstmt.getLeftOpBox().getValue());
                }
                locals.removeIf(local -> !tmplocal.contains(local));
            }
            Local thisRef = jimpleUtils.addLocalVar("this", (Type)customSubClass.getType(), (Body)subMethodBody);
            jimpleUtils.createIdentityStmt((Value)thisRef, (Value)jimpleUtils.createThisRef(customSubClass.getType()), units);
            Local returnRef = null;
            if (!(subMethod.getReturnType() instanceof VoidType)) {
                returnRef = jimpleUtils.addLocalVar("returnRef", subMethod.getReturnType(), (Body)subMethodBody);
            }
            for (SootField field : customSubClass.getFields()) {
                Local tmpRef = jimpleUtils.addLocalVar("localTarget", field.getType(), (Body)subMethodBody);
                jimpleUtils.createAssignStmt((Value)tmpRef, (Value)jimpleUtils.createInstanceFieldRef((Value)thisRef, field.makeRef()), units);
                if (returnRef != null) {
                    VirtualInvokeExpr returnValue = jimpleUtils.createVirtualInvokeExpr(tmpRef, superMethod, subMethodBody.getParameterLocals());
                    jimpleUtils.createAssignStmt((Value)returnRef, (Value)returnValue, units);
                    continue;
                }
                units.add(jimpleUtils.virtualCallStatement(tmpRef, superMethod, subMethodBody.getParameterLocals()));
            }
            if (returnRef != null) {
                jimpleUtils.addCommonReturnStmt((Value)returnRef, units);
            } else {
                jimpleUtils.addVoidReturnStmt(units);
            }
            subMethod.setActiveBody((Body)subMethodBody);
        }
    }

    public static void clear() {
        syntheticMethodImpls.clear();
    }
}

