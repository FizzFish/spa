/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.Config
 *  analysis.Implement
 *  bean.ConstructorArgBean
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  mock.MockObject
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  soot.ArrayType
 *  soot.Body
 *  soot.BooleanType
 *  soot.DoubleType
 *  soot.FloatType
 *  soot.IntType
 *  soot.Local
 *  soot.LongType
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.Value
 *  soot.VoidType
 *  soot.dexpler.Util
 *  soot.jimple.Constant
 *  soot.jimple.DoubleConstant
 *  soot.jimple.FloatConstant
 *  soot.jimple.IntConstant
 *  soot.jimple.Jimple
 *  soot.jimple.JimpleBody
 *  soot.jimple.LongConstant
 *  soot.jimple.NullConstant
 *  soot.jimple.ParameterRef
 *  soot.jimple.SpecialInvokeExpr
 *  soot.jimple.StaticInvokeExpr
 *  soot.jimple.StringConstant
 *  soot.jimple.internal.JIdentityStmt
 *  soot.jimple.internal.JimpleLocal
 *  utils.BaseBodyGenerator
 *  utils.BaseBodyGeneratorFactory
 *  utils.BaseJimpleUtils
 *  utils.INewUnits
 *  utils.JimpleUtils
 *  utils.NewUnitsAtFirstImmediately
 */
package utils;

import analysis.Config;
import analysis.Implement;
import bean.ConstructorArgBean;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mock.MockObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.ArrayType;
import soot.Body;
import soot.BooleanType;
import soot.DoubleType;
import soot.FloatType;
import soot.IntType;
import soot.Local;
import soot.LongType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.VoidType;
import soot.dexpler.Util;
import soot.jimple.Constant;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.IntConstant;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.ParameterRef;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.StringConstant;
import soot.jimple.internal.JIdentityStmt;
import soot.jimple.internal.JimpleLocal;
import utils.BaseBodyGenerator;
import utils.BaseBodyGeneratorFactory;
import utils.BaseJimpleUtils;
import utils.INewUnits;
import utils.NewUnitsAtFirstImmediately;

/*
 * Exception performing whole class analysis ignored.
 */
public class JimpleUtils
extends BaseJimpleUtils {
    private static final Logger log = LoggerFactory.getLogger(JimpleUtils.class);
    final Map<SootMethod, Body> methodToBody = new HashMap();

    public Map<Type, Type> getImplType() {
        LinkedHashMap<Type, Type> map = new LinkedHashMap<Type, Type>();
        map.put((Type)RefType.v((String)"java.util.List"), (Type)RefType.v((String)"java.util.ArrayList"));
        map.put((Type)RefType.v((String)"java.util.Map"), (Type)RefType.v((String)"java.util.HashMap"));
        map.put((Type)RefType.v((String)"java.util.Set"), (Type)RefType.v((String)"java.util.HashSet"));
        return map;
    }

    public SootMethod genDefaultConstructor(SootClass customImplClass) {
        return this.genDefaultConstructor(customImplClass, null, false);
    }

    public SootMethod genDefaultConstructor(SootClass customImplClass, SootField field, boolean singleton) {
        SootMethod initMethod = new SootMethod("<init>", null, (Type)VoidType.v(), 1);
        SootMethod signature = customImplClass.getSuperclass().getMethodUnsafe("void <init>()");
        if (signature == null) {
            for (SootMethod method : customImplClass.getSuperclass().getMethods()) {
                if (!method.isConstructor()) continue;
                signature = method;
                break;
            }
        }
        if (signature != null) {
            JimpleBody initBody = this.createInitJimpleBody(initMethod, signature, customImplClass.getName(), field, singleton);
            initMethod.setActiveBody((Body)initBody);
        }
        return initMethod;
    }

    public SootMethod genDefaultClinit(SootClass customImplClass, Set<SootField> fields, Map<String, List<ConstructorArgBean>> collect) {
        SootMethod initMethod = new SootMethod("<clinit>", null, (Type)VoidType.v(), 8);
        JimpleBody initBody = this.createClinitJimpleBody(initMethod, customImplClass.getName(), fields, collect);
        initMethod.setActiveBody((Body)initBody);
        return initMethod;
    }

    public SootMethod genStaticCustomMethod(SootClass customImplClass, String methodName, List<Type> parameterTypes, Type returnType, SootField field) {
        SootMethod implMethod = new SootMethod(methodName, parameterTypes, returnType, 9);
        JimpleBody body = this.createNewJimpleStaticBody(implMethod, customImplClass.getName(), field);
        implMethod.setActiveBody((Body)body);
        return implMethod;
    }

    public SootMethod genStaticCustomMethod(SootClass customImplClass, String methodName, List<Type> parameterTypes, Type returnType, SootClass bean, Map<String, List<ConstructorArgBean>> collect) {
        SootMethod implMethod = new SootMethod(methodName, parameterTypes, returnType, 9);
        JimpleBody body = this.createNewJimpleStaticBody(implMethod, customImplClass.getName(), bean, collect);
        implMethod.setActiveBody((Body)body);
        return implMethod;
    }

    public SootMethod genCustomMethod(SootClass customImplClass, String methodName, List<Type> parameterTypes, Type returnType) {
        SootMethod implMethod = new SootMethod(methodName, parameterTypes, returnType, 1);
        JimpleBody body = this.createNewJimpleBody(implMethod, new ArrayList(), customImplClass.getName());
        implMethod.setActiveBody((Body)body);
        return implMethod;
    }

    public JimpleBody createInitJimpleBody(SootMethod method, SootMethod signature, String cName, SootField field, boolean singleton) {
        JimpleBody body = this.newMethodBody(method);
        Local thisRef = this.addLocalVar("this", cName, (Body)body);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        this.createIdentityStmt((Value)thisRef, (Value)this.createThisRef(cName), units);
        SootMethod toCall = Scene.v().getMethod(signature.getSignature());
        units.add(this.specialCallStatement(thisRef, toCall, units));
        if (field != null) {
            String vtype = field.getType().toString();
            Local tmpRef = this.addLocalVar(vtype.substring(vtype.lastIndexOf(".") + 1).toLowerCase(), vtype, (Body)body);
            if (!singleton && field.getType() instanceof RefType && !((RefType)field.getType()).getSootClass().isAbstract()) {
                this.createAssignStmt((Value)tmpRef, (Value)this.createNewExpr(field.getType().toString()), units);
                units.add(this.specialCallStatement(tmpRef, JimpleUtils.getMinConstructorOrCreate((SootClass)((RefType)field.getType()).getSootClass()).toString(), units));
            } else {
                SootClass singletonFactory = Scene.v().getSootClass(Config.SINGLETON_FACTORY_CNAME);
                StaticInvokeExpr returnValue = this.createStaticInvokeExpr(singletonFactory.getMethod(((RefType)field.getType()).getSootClass().getName() + " get" + ((RefType)field.getType()).getSootClass().getShortName() + "()"), Collections.emptyList());
                this.createAssignStmt((Value)tmpRef, (Value)returnValue, units);
            }
            this.createAssignStmt((Value)this.createInstanceFieldRef((Value)thisRef, field.makeRef()), (Value)tmpRef, units);
        }
        this.addVoidReturnStmt(units);
        return body;
    }

    public Map.Entry<SootMethod, List<Value>> initArgBeans(SootClass argClazz, List<ConstructorArgBean> constructorArgBeans, Function<Type, Value> mismatchParam) {
        for (SootMethod argClazzMethod : argClazz.getMethods()) {
            if (!argClazzMethod.isConstructor() || argClazzMethod.getParameterCount() != constructorArgBeans.size()) continue;
            UnitPatchingChain argmethodunit = this.getMethodBody(argClazzMethod).getUnits();
            LinkedList argunitlist = new LinkedList(argmethodunit);
            LinkedHashMap<String, String> parammap = new LinkedHashMap<String, String>();
            for (int i = 1; i <= argClazzMethod.getParameterCount(); ++i) {
                if (!(argunitlist.get(i) instanceof JIdentityStmt)) continue;
                JIdentityStmt stmt = (JIdentityStmt)argunitlist.get(i);
                JimpleLocal leftval = (JimpleLocal)stmt.getLeftOpBox().getValue();
                String key2 = leftval.getName();
                ParameterRef rightref = (ParameterRef)stmt.getRightOpBox().getValue();
                String val = rightref.getType().toString();
                parammap.put(key2, val);
            }
            int index = 0;
            ArrayList<Object> parmas = new ArrayList<Object>();
            while (index < constructorArgBeans.size()) {
                Constant c;
                Type parameterType = argClazzMethod.getParameterType(index);
                ConstructorArgBean argBean = constructorArgBeans.get(index);
                if (argBean.getArgType() != null) {
                    if (parameterType.toString().equals(argBean.getArgType()) && (c = this.getConstant(argBean.getArgType(), argBean.getArgValue(), false)) != null) {
                        parmas.add(c);
                    }
                } else if (argBean.getArgName() != null) {
                    if (parammap.containsKey(argBean.getArgName()) && (c = this.getConstant((String)parammap.get(argBean.getArgName()), argBean.getArgValue(), false)) != null) {
                        parmas.add(c);
                    }
                } else if (argBean.getRefType() != null && parammap.containsKey(argBean.getRefType()) && (c = this.getConstant("", "", true)) != null) {
                    parmas.add(c);
                }
                if (parmas.size() == ++index) continue;
                Value parameter = mismatchParam.apply(parameterType);
                parmas.add(parameter);
            }
            List arguments = parmas.stream().filter(Objects::nonNull).collect(Collectors.toList());
            if (arguments.size() != argClazzMethod.getParameterCount()) continue;
            return new AbstractMap.SimpleEntry<SootMethod, List<Value>>(argClazzMethod, arguments);
        }
        return null;
    }

    public Value newBeanObjectAndReturn(BaseBodyGenerator units, SootClass bean, Map<String, List<ConstructorArgBean>> collect) {
        Local tmpRef;
        block8: {
            boolean hasConstructorFlag;
            String vtype;
            block7: {
                List<ConstructorArgBean> constructorArgBeans;
                Map.Entry arguments;
                Value beanObject;
                boolean hasargFlag = false;
                if (collect != null && collect.size() > 0) {
                    hasargFlag = true;
                }
                RefType beanType = bean.getType();
                vtype = beanType.toString();
                Body body = units.body;
                NewUnitsAtFirstImmediately insertAtFirst = new NewUnitsAtFirstImmediately(units);
                hasConstructorFlag = false;
                if (bean.isConcrete()) {
                    beanObject = this.createNewExpr(bean.getType().toString());
                } else {
                    beanObject = units.getValueForType((INewUnits)insertAtFirst, (Type)beanType);
                    hasConstructorFlag = true;
                }
                tmpRef = this.addLocalVar(vtype.substring(vtype.lastIndexOf(".") + 1).toLowerCase(), vtype, body);
                this.createAssignStmt((Value)tmpRef, beanObject, units);
                if (!hasargFlag || !collect.containsKey(vtype)) break block7;
                SootClass argClazz = JimpleUtils.getClassUnsafe((String)vtype);
                if (argClazz == null) {
                    argClazz = beanType.getSootClass();
                }
                if ((arguments = this.initArgBeans(argClazz, constructorArgBeans = collect.get(vtype), parameterType -> null)) != null) {
                    arguments = this.initArgBeans(argClazz, constructorArgBeans, parameterType -> units.getValueForType((INewUnits)insertAtFirst, parameterType));
                }
                if (arguments == null) break block8;
                units.add(this.specialCallStatement(tmpRef, ((SootMethod)arguments.getKey()).toString(), (List)arguments.getValue()));
                break block8;
            }
            if (!hasConstructorFlag) {
                for (SootMethod sootMethod : Scene.v().getSootClass(vtype).getMethods()) {
                    if (!sootMethod.isConstructor()) continue;
                    units.add(this.specialCallStatement(tmpRef, sootMethod, units));
                    break;
                }
            }
        }
        return tmpRef;
    }

    public JimpleBody createClinitJimpleBody(SootMethod method, String cName, Set<SootField> fields, Map<String, List<ConstructorArgBean>> collect) {
        JimpleBody body = this.newMethodBody(method);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        if (Config.linkSpringCGLIB_CallEntrySyntheticAndRequestMappingMethods.booleanValue()) {
            HashMap<SootClass, Value> exists = new HashMap<SootClass, Value>(fields.size());
            for (SootField field : fields) {
                Value tmpRef;
                if (!(field.getType() instanceof RefType)) continue;
                SootClass fieldTypeClass = ((RefType)field.getType()).getSootClass();
                if (exists.containsKey(fieldTypeClass)) {
                    tmpRef = (Value)exists.get(fieldTypeClass);
                } else {
                    tmpRef = this.newBeanObjectAndReturn(units, ((RefType)field.getType()).getSootClass(), collect);
                    exists.put(fieldTypeClass, tmpRef);
                }
                this.createAssignStmt((Value)this.createStaticFieldRef(field.makeRef()), tmpRef, units);
            }
        }
        this.addVoidReturnStmt(units);
        return body;
    }

    private Constant getConstant(String typesign, String value, boolean isclazz) {
        String s = typesign.toLowerCase();
        if (isclazz) {
            return NullConstant.v();
        }
        if (value == null) {
            return null;
        }
        if (s.contains("string")) {
            return StringConstant.v((String)value);
        }
        if (s.contains("int")) {
            return IntConstant.v((int)Integer.parseInt(value));
        }
        if (s.contains("double")) {
            return DoubleConstant.v((double)Double.parseDouble(value));
        }
        if (s.contains("float")) {
            return FloatConstant.v((float)Float.parseFloat(value));
        }
        if (s.contains("long")) {
            return LongConstant.v((long)Long.parseLong(value));
        }
        return null;
    }

    public JimpleBody createNewJimpleBody(SootMethod method, List<SootMethod> signatures, String cName) {
        ArrayList<Local> parameterValues = new ArrayList<Local>();
        JimpleBody body = this.newMethodBody(method);
        Local thisRef = this.addLocalVar("this", cName, (Body)body);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        this.createIdentityStmt((Value)thisRef, (Value)this.createThisRef(cName), units);
        for (int i = 0; i < method.getParameterCount(); ++i) {
            Type parameterType = method.getParameterType(i);
            Local param = this.addLocalVar("param" + i, parameterType, (Body)body);
            this.createIdentityStmt((Value)param, (Value)this.createParamRef(parameterType, i), units);
            parameterValues.add(param);
        }
        if (method.getName().equals("setArgs_synthetic")) {
            SootField sootField = Scene.v().getSootClass(cName).getFieldByName("args");
            Local param = body.getParameterLocal(0);
            this.createAssignStmt((Value)this.createInstanceFieldRef((Value)thisRef, sootField.makeRef()), (Value)param, units);
        }
        NewUnitsAtFirstImmediately insertAtFirst = new NewUnitsAtFirstImmediately(units);
        for (int i = 0; i < signatures.size(); ++i) {
            SootMethod toCall = Scene.v().getMethod(signatures.get(i).toString());
            int parameterCount = toCall.getParameterCount();
            ArrayList<Object> paramList = new ArrayList<Object>();
            for (int j = 0; j < parameterCount - parameterValues.size(); ++j) {
                Type parameterTy = toCall.getParameterType(j);
                Value p = units.getValueForType((INewUnits)insertAtFirst, parameterTy);
                paramList.add(p);
            }
            paramList.addAll(parameterValues);
            String declaringClassName = signatures.get(i).getDeclaringClass().getName();
            if (!(declaringClassName.equals(cName) || declaringClassName.equals("java.lang.Object") || signatures.get(i).getReturnType() instanceof VoidType)) {
                Local virtualRef = this.addLocalVar("virtual" + i, declaringClassName, (Body)body);
                this.createAssignStmt(virtualRef, declaringClassName, units);
                units.add(this.specialCallStatement(virtualRef, signatures.get(i).getDeclaringClass().getMethod("void <init>()").toString(), Collections.emptyList()));
                continue;
            }
            if (!(signatures.get(i).getReturnType() instanceof VoidType) && !method.getName().startsWith(Config.CALL_ENTRY_NAME)) continue;
            units.add(this.specialCallStatement(thisRef, toCall.toString(), paramList));
        }
        Type returnType = method.getReturnType();
        Supplier<Value> ret = () -> units.getValueForType((INewUnits)insertAtFirst, returnType);
        if (returnType instanceof RefType) {
            this.addCommonReturnStmt(ret.get(), units);
        } else if (returnType instanceof VoidType) {
            this.addVoidReturnStmt(units);
        } else if (returnType instanceof BooleanType) {
            this.addCommonReturnStmt(ret.get(), units);
        } else if (returnType instanceof IntType) {
            this.addCommonReturnStmt(ret.get(), units);
        } else if (returnType instanceof LongType) {
            this.addCommonReturnStmt(ret.get(), units);
        } else if (returnType instanceof DoubleType) {
            this.addCommonReturnStmt(ret.get(), units);
        } else if (returnType instanceof ArrayType) {
            if (Scene.v().getSootClass(cName).getFields().size() > 0) {
                SootField sootField = Scene.v().getSootClass(cName).getFieldByName("args");
                if (sootField != null && sootField.getType().equals(returnType) && method.getName().contains("getArgs")) {
                    Local returnRef = this.addLocalVar("returnRef", returnType, (Body)body);
                    this.createAssignStmt((Value)returnRef, (Value)this.createInstanceFieldRef((Value)thisRef, sootField.makeRef()), units);
                    this.addCommonReturnStmt((Value)returnRef, units);
                }
            } else {
                this.addCommonReturnStmt(ret.get(), units);
            }
        }
        return body;
    }

    public JimpleBody createNewJimpleStaticBody(SootMethod method, String cName, SootField field) {
        JimpleBody body = this.newMethodBody(method);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        Local localRef = null;
        if (method.getName().equals("get" + field.getName())) {
            localRef = this.addLocalVar(field.getName().toLowerCase(), field.getType(), (Body)body);
            this.createAssignStmt((Value)localRef, (Value)this.createStaticFieldRef(field.makeRef()), units);
        }
        NewUnitsAtFirstImmediately insertAtFirst = new NewUnitsAtFirstImmediately(units);
        Type returnType = method.getReturnType();
        if (returnType instanceof RefType) {
            if (localRef != null) {
                this.addCommonReturnStmt((Value)localRef, units);
            } else {
                Value ret = units.getValueForType((INewUnits)insertAtFirst, returnType);
                this.addCommonReturnStmt(ret, units);
            }
        }
        return body;
    }

    public JimpleBody createNewJimpleStaticBody(SootMethod method, String cName, SootClass bean, Map<String, List<ConstructorArgBean>> collect) {
        JimpleBody body = this.newMethodBody(method);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        Local localRef = null;
        if (method.getName().equals("get" + bean.getShortName())) {
            localRef = this.addLocalVar(bean.getShortName().toLowerCase(), (Type)bean.getType(), (Body)body);
            Value tmpRef = this.newBeanObjectAndReturn(units, bean, collect);
            this.createAssignStmt((Value)localRef, tmpRef, units);
        }
        NewUnitsAtFirstImmediately insertAtFirst = new NewUnitsAtFirstImmediately(units);
        Type returnType = method.getReturnType();
        if (returnType instanceof RefType) {
            if (localRef != null) {
                this.addCommonReturnStmt((Value)localRef, units);
            } else {
                Value ret = units.getValueForType((INewUnits)insertAtFirst, returnType);
                this.addCommonReturnStmt(ret, units);
            }
        }
        return body;
    }

    @Nonnull
    public Body getMethodBody(@Nonnull SootMethod m) {
        if (m.hasActiveBody()) {
            return m.getActiveBody();
        }
        Body body = (Body)this.methodToBody.get(m);
        if (body != null) {
            return body;
        }
        SootClass declaringClass = m.getDeclaringClass();
        if (declaringClass != null && !declaringClass.isPhantomClass() && m.isConcrete() && m.getSource() != null) {
            body = m.retrieveActiveBody();
        }
        if (body == null) {
            JimpleBody jimpleBody = Jimple.v().newBody(m);
            jimpleBody.insertIdentityStmts();
            Util.emptyBody((Body)jimpleBody);
            if (m.isConcrete()) {
                m.setActiveBody((Body)jimpleBody);
            }
            body = jimpleBody;
        }
        this.methodToBody.putIfAbsent(m, body);
        return body;
    }

    public JimpleBody createJimpleBody(SootMethod method, List<SootMethod> signatures, String cName) {
        Local thisRef;
        MockObject mockObject = Implement.mockObject;
        SpecialInvokeExpr virtualCallWithReturn = null;
        JimpleBody body = this.newMethodBody(method);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        if (method.isStatic()) {
            thisRef = this.addLocalVar("instance", cName, (Body)body);
            Unit localInitAssign = this.createAssignStmt(thisRef, cName);
            units.getUnits().addFirst(localInitAssign);
            units.insertAfter(this.specialCallStatement(thisRef, JimpleUtils.getMinConstructorOrCreate((SootClass)method.getDeclaringClass()).toString(), units), localInitAssign);
        } else {
            thisRef = this.addLocalVar("this", cName, (Body)body);
            this.createIdentityStmt((Value)thisRef, (Value)this.createThisRef(cName), units);
        }
        NewUnitsAtFirstImmediately insertAtFirst = new NewUnitsAtFirstImmediately(units);
        for (int i = 0; i < signatures.size(); ++i) {
            SootMethod toCall = Scene.v().getMethod(signatures.get(i).toString());
            int parameterCount = toCall.getParameterCount();
            ArrayList<Object> paramList = new ArrayList<Object>();
            for (int j = 0; j < parameterCount; ++j) {
                Type parameterTy = toCall.getParameterType(j);
                if (this.isBaseTypes(parameterTy)) {
                    Value p = units.getValueForType((INewUnits)insertAtFirst, parameterTy);
                    paramList.add(p);
                    continue;
                }
                Type t = Scene.v().getTypeUnsafe(parameterTy.toQuotedString(), true);
                if (t instanceof RefType) {
                    Local paramRef;
                    SootClass sootClass = ((RefType)t).getSootClass();
                    if (sootClass != null && !sootClass.isPhantom() && sootClass.isConcrete() && !sootClass.isJavaLibraryClass() && !sootClass.getMethods().isEmpty()) {
                        try {
                            paramRef = mockObject.mockBean(body, units, sootClass, toCall);
                            paramList.add(paramRef);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Value p = units.getValueForType((INewUnits)insertAtFirst, parameterTy);
                            paramList.add(p);
                        }
                        continue;
                    }
                    if (sootClass != null && sootClass.getName().contains("HttpServlet")) {
                        paramRef = mockObject.mockHttpServlet(body, units, sootClass, toCall);
                        paramList.add(paramRef);
                        continue;
                    }
                    if (sootClass != null && sootClass.getName().equals("java.lang.String")) {
                        Value str = units.getValueForType((INewUnits)insertAtFirst, parameterTy);
                        paramList.add(str);
                        continue;
                    }
                    Value p = units.getValueForType((INewUnits)insertAtFirst, parameterTy);
                    paramList.add(p);
                    continue;
                }
                LinkedHashSet constructionStack = new LinkedHashSet();
                paramList.add(units.getValueForType((INewUnits)insertAtFirst, t, constructionStack, Collections.emptySet()));
            }
            String declaringClassName = signatures.get(i).getDeclaringClass().getName();
            if (!(declaringClassName.equals(cName) || declaringClassName.equals("java.lang.Object") || signatures.get(i).getReturnType() instanceof VoidType)) {
                Local virtualRef = this.addLocalVar("virtual" + i, declaringClassName, (Body)body);
                this.createAssignStmt(virtualRef, declaringClassName, units);
                units.add(this.specialCallStatement(virtualRef, signatures.get(i).getDeclaringClass().getMethod("void <init>()").toString(), Collections.emptyList()));
                virtualCallWithReturn = this.createVirtualInvokeExpr(virtualRef, toCall, paramList);
                continue;
            }
            if (!(signatures.get(i).getReturnType() instanceof VoidType) && !method.getName().startsWith(Config.CALL_ENTRY_NAME)) {
                virtualCallWithReturn = this.createSpecialInvokeExpr(thisRef, toCall, paramList);
                continue;
            }
            units.add(this.buildCallStatement(thisRef, toCall, paramList));
        }
        Type returnType = method.getReturnType();
        if (returnType instanceof RefType) {
            Local returnRef = this.addLocalVar("returnRef", returnType, (Body)body);
            if (((RefType)returnType).getSootClass().isInterface()) {
                returnType = (Type)this.getImplType().get(returnType);
            }
            if (virtualCallWithReturn != null) {
                this.createAssignStmt((Value)returnRef, virtualCallWithReturn, units);
            } else {
                this.createAssignStmt((Value)returnRef, (Value)this.createNewExpr((RefType)returnType), units);
                units.add(this.specialCallStatement(returnRef, ((RefType)returnType).getSootClass().getMethod("void <init>()"), Collections.emptyList()));
            }
            this.addCommonReturnStmt((Value)returnRef, units);
        } else if (returnType instanceof VoidType) {
            this.addVoidReturnStmt(units);
        } else if (returnType instanceof IntType) {
            this.addCommonReturnStmt((Value)IntConstant.v((int)0), units);
        } else if (returnType instanceof LongType) {
            this.addCommonReturnStmt((Value)LongConstant.v((long)0L), units);
        } else if (returnType instanceof DoubleType) {
            this.addCommonReturnStmt((Value)DoubleConstant.v((double)0.0), units);
        }
        return body;
    }

    private boolean isBaseTypes(Type target) {
        return target instanceof LongType || target instanceof IntType || target instanceof DoubleType || target instanceof FloatType || target instanceof ArrayType || target instanceof BooleanType;
    }

    @Nullable
    public static SootClass getClassUnsafe(Type t) {
        if (t instanceof RefType) {
            return ((RefType)t).getSootClass();
        }
        return null;
    }

    @Nullable
    public static SootClass getClassUnsafe(String type) {
        return JimpleUtils.getClassUnsafe((Type)Scene.v().getTypeUnsafe(type, true));
    }

    @Nullable
    public static SootMethod getMinConstructor(SootClass sootClass) {
        SootMethod defaultInit = sootClass.getMethodUnsafe("void <init>()");
        if (defaultInit != null) {
            return defaultInit;
        }
        Optional<SootMethod> first = sootClass.getMethods().stream().filter(SootMethod::isConstructor).sorted(Comparator.comparing(SootMethod::getSubSignature)).min(Comparator.comparingInt(SootMethod::getParameterCount));
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }

    public static SootMethod getMinConstructorOrCreate(SootClass sootClass) {
        SootMethod constructor = JimpleUtils.getMinConstructor((SootClass)sootClass);
        if (constructor == null) {
            SootMethod createMethod = new SootMethod("<init>", null, (Type)VoidType.v(), 1);
            sootClass.addMethod(createMethod);
            constructor = createMethod;
        }
        return constructor;
    }
}

