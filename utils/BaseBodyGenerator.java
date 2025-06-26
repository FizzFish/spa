/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.Implement
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  soot.ArrayType
 *  soot.Body
 *  soot.BooleanType
 *  soot.ByteType
 *  soot.CharType
 *  soot.DoubleType
 *  soot.FloatType
 *  soot.IntType
 *  soot.Local
 *  soot.LocalGenerator
 *  soot.LongType
 *  soot.PrimType
 *  soot.RefType
 *  soot.Scene
 *  soot.ShortType
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.Value
 *  soot.jimple.AssignStmt
 *  soot.jimple.DoubleConstant
 *  soot.jimple.EqExpr
 *  soot.jimple.FloatConstant
 *  soot.jimple.IfStmt
 *  soot.jimple.IntConstant
 *  soot.jimple.InvokeExpr
 *  soot.jimple.Jimple
 *  soot.jimple.LongConstant
 *  soot.jimple.NewArrayExpr
 *  soot.jimple.NewExpr
 *  soot.jimple.NullConstant
 *  soot.jimple.SpecialInvokeExpr
 *  soot.jimple.StringConstant
 *  soot.util.Chain
 *  utils.BaseBodyGenerator
 *  utils.INewUnits
 *  utils.JimpleUtils
 *  utils.NewUnits
 *  utils.NewUnits$BeforeUnit
 *  utils.NewUnitsAtFirstImmediately
 */
package utils;

import analysis.Implement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.ArrayType;
import soot.Body;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.IntType;
import soot.Local;
import soot.LocalGenerator;
import soot.LongType;
import soot.PrimType;
import soot.RefType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.DoubleConstant;
import soot.jimple.EqExpr;
import soot.jimple.FloatConstant;
import soot.jimple.IfStmt;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.LongConstant;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NullConstant;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StringConstant;
import soot.util.Chain;
import utils.INewUnits;
import utils.JimpleUtils;
import utils.NewUnits;
import utils.NewUnitsAtFirstImmediately;

/*
 * Exception performing whole class analysis ignored.
 */
public class BaseBodyGenerator {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected boolean excludeSystemComponents = true;
    protected Map<SootClass, Local> localVarsForClasses = new LinkedHashMap();
    protected final Set<SootClass> failedClasses = new LinkedHashSet();
    protected boolean substituteCallParams = false;
    protected List<String> substituteClasses;
    protected boolean allowSelfReferences = false;
    protected boolean ignoreSystemClassParams = true;
    protected boolean allowNonPublicConstructors = false;
    protected final Set<SootMethod> failedMethods = new LinkedHashSet();
    protected String dummyClassName = "dummyMainClass";
    protected String dummyMethodName = "dummyMainMethod";
    protected boolean shallowMode = false;
    protected boolean overwriteDummyMainMethod = false;
    protected boolean warnOnConstructorLoop = false;
    protected Value intCounter;
    protected int conditionCounter;
    protected final Body body;
    protected final LocalGenerator generator;

    public BaseBodyGenerator(Body body) {
        this.body = body;
        this.generator = Scene.v().createLocalGenerator(body);
    }

    public Set<SootClass> getFailedClasses() {
        return new LinkedHashSet<SootClass>(this.failedClasses);
    }

    public Set<SootMethod> getFailedMethods() {
        return new LinkedHashSet<SootMethod>(this.failedMethods);
    }

    public void setSubstituteCallParams(boolean b) {
        this.substituteCallParams = b;
    }

    public void setSubstituteClasses(List<String> l) {
        this.substituteClasses = l;
    }

    protected SootClass getOrCreateDummyMainClass() {
        SootClass mainClass = Scene.v().getSootClassUnsafe(this.dummyClassName);
        if (mainClass == null) {
            mainClass = Scene.v().makeSootClass(this.dummyClassName);
            mainClass.setResolvingLevel(3);
            Scene.v().addClass(mainClass);
        }
        return mainClass;
    }

    protected void createAdditionalFields() {
    }

    protected void createAdditionalMethods() {
    }

    protected String getNonCollidingFieldName(String baseName) {
        String fieldName = baseName;
        int fieldIdx = 0;
        SootClass mainClass = this.getOrCreateDummyMainClass();
        while (mainClass.declaresFieldByName(fieldName)) {
            fieldName = baseName + "_" + fieldIdx++;
        }
        return fieldName;
    }

    protected List<Value> getValueForMethod(NewUnits newUnits, SootMethod methodToCall, Local classLocal) {
        return this.getValueForMethod(newUnits, methodToCall, classLocal, Collections.emptySet());
    }

    protected List<Value> getValueForMethod(NewUnits newUnits, SootMethod methodToCall, Local classLocal, Set<SootClass> parentClasses) {
        if (classLocal == null && !methodToCall.isStatic()) {
            this.logger.warn("Cannot call method {}, because there is no local for base object: {}", (Object)methodToCall, (Object)methodToCall.getDeclaringClass());
            this.failedMethods.add(methodToCall);
            return null;
        }
        LinkedList<Value> args = new LinkedList<Value>();
        if (methodToCall.getParameterCount() > 0) {
            for (Type tp : methodToCall.getParameterTypes()) {
                LinkedHashSet<SootClass> constructionStack = new LinkedHashSet<SootClass>();
                if (!this.allowSelfReferences) {
                    constructionStack.add(methodToCall.getDeclaringClass());
                }
                args.add(this.getValueForType((INewUnits)newUnits, tp, constructionStack, parentClasses));
            }
        }
        return args;
    }

    protected InvokeExpr buildMethodCall(NewUnits newUnits, SootMethod methodToCall, Local classLocal) {
        return this.buildMethodCall(newUnits, methodToCall, classLocal, Collections.emptySet());
    }

    protected InvokeExpr buildMethodCall(NewUnits newUnits, SootMethod methodToCall, Local classLocal, Set<SootClass> parentClasses) {
        List args = this.getValueForMethod(newUnits, methodToCall, classLocal, parentClasses);
        if (args == null) {
            return null;
        }
        InvokeExpr invokeExpr = BaseBodyGenerator.buildMethodCall((SootMethod)methodToCall, (Local)classLocal, (List)args);
        return invokeExpr;
    }

    public static InvokeExpr buildMethodCall(SootMethod methodToCall, Local classLocal, List<Value> args) {
        Object invokeExpr;
        if (methodToCall.getParameterCount() > 0) {
            if (methodToCall.isStatic()) {
                invokeExpr = Jimple.v().newStaticInvokeExpr(methodToCall.makeRef(), args);
            } else {
                assert (classLocal != null) : "Class local method was null for non-static method call";
                invokeExpr = methodToCall.isConstructor() ? Jimple.v().newSpecialInvokeExpr(classLocal, methodToCall.makeRef(), args) : (methodToCall.getDeclaringClass().isInterface() ? Jimple.v().newInterfaceInvokeExpr(classLocal, methodToCall.makeRef(), args) : Jimple.v().newVirtualInvokeExpr(classLocal, methodToCall.makeRef(), args));
            }
        } else if (methodToCall.isStatic()) {
            invokeExpr = Jimple.v().newStaticInvokeExpr(methodToCall.makeRef());
        } else {
            assert (classLocal != null) : "Class local method was null for non-static method call";
            invokeExpr = methodToCall.isConstructor() ? Jimple.v().newSpecialInvokeExpr(classLocal, methodToCall.makeRef()) : (methodToCall.getDeclaringClass().isInterface() ? Jimple.v().newInterfaceInvokeExpr(classLocal, methodToCall.makeRef(), args) : Jimple.v().newVirtualInvokeExpr(classLocal, methodToCall.makeRef()));
        }
        return invokeExpr;
    }

    protected Value getValueForType(INewUnits newUnits, Type tp, Set<SootClass> constructionStack, Set<SootClass> parentClasses) {
        return this.getValueForType(newUnits, tp, constructionStack, parentClasses, null);
    }

    public Value getValueForType(INewUnits newUnits, Type tp) {
        LinkedHashSet constructionStack = new LinkedHashSet();
        return this.getValueForType(newUnits, tp, constructionStack, Collections.emptySet());
    }

    protected Value getValueForType(INewUnits newUnits, Type tp, Set<SootClass> constructionStack, Set<SootClass> parentClasses, Set<Local> generatedLocals) {
        if (BaseBodyGenerator.isSimpleType((Type)tp)) {
            return this.getSimpleDefaultValue(tp);
        }
        if (tp instanceof RefType) {
            SootClass classToType = ((RefType)tp).getSootClass();
            if (classToType != null) {
                for (SootClass parent : parentClasses) {
                    Value val;
                    if (!this.isCompatible(parent, classToType) || (val = (Value)this.localVarsForClasses.get(parent)) == null) continue;
                    return val;
                }
                if (this.ignoreSystemClassParams && this.isClassInSystemPackage(classToType.getName())) {
                    return NullConstant.v();
                }
                Local val = this.generateClassConstructor(newUnits, classToType, constructionStack, parentClasses, generatedLocals);
                if (val == null) {
                    return NullConstant.v();
                }
                if (generatedLocals != null && val instanceof Local) {
                    generatedLocals.add(val);
                }
                return val;
            }
        } else {
            if (tp instanceof ArrayType) {
                Value arrVal = this.buildArrayOfType(newUnits, (ArrayType)tp, constructionStack, parentClasses, generatedLocals);
                if (arrVal == null) {
                    this.logger.warn("Array parameter substituted by null");
                    return NullConstant.v();
                }
                return arrVal;
            }
            this.logger.warn("Unsupported parameter type: {}", (Object)tp.toString());
            return null;
        }
        throw new RuntimeException("Should never see me");
    }

    protected Value buildArrayOfType(INewUnits newUnits, ArrayType tp, Set<SootClass> constructionStack, Set<SootClass> parentClasses, Set<Local> generatedLocals) {
        Value singleElement = this.getValueForType(newUnits, tp.getElementType(), constructionStack, parentClasses);
        Local local = this.generator.generateLocal((Type)tp);
        NewArrayExpr newArrayExpr = Jimple.v().newNewArrayExpr(tp.getElementType(), (Value)IntConstant.v((int)1));
        AssignStmt assignArray = Jimple.v().newAssignStmt((Value)local, (Value)newArrayExpr);
        newUnits.add((Unit)assignArray);
        AssignStmt assign = Jimple.v().newAssignStmt((Value)Jimple.v().newArrayRef((Value)local, (Value)IntConstant.v((int)0)), singleElement);
        newUnits.add((Unit)assign);
        return local;
    }

    protected Local generateClassConstructor(NewUnits newUnits, SootClass createdClass) {
        return this.generateClassConstructor((INewUnits)newUnits, createdClass, new LinkedHashSet(), Collections.emptySet(), null);
    }

    protected Local generateClassConstructor(NewUnits newUnits, SootClass createdClass, Set<SootClass> parentClasses) {
        return this.generateClassConstructor((INewUnits)newUnits, createdClass, new LinkedHashSet(), parentClasses, null);
    }

    protected boolean acceptClass(SootClass clazz) {
        if (clazz.isPhantom() || clazz.isPhantomClass()) {
            this.logger.warn("Cannot generate constructor for phantom class {}", (Object)clazz.getName());
            return false;
        }
        return true;
    }

    @Nonnull
    public static SootMethod getAnyConstructor(SootClass sc, boolean allowNonPublicConstructors) throws RuntimeException {
        SootMethod constructor = BaseBodyGenerator.getAnyConstructorUnsafe((SootClass)sc, (boolean)allowNonPublicConstructors);
        if (constructor == null) {
            throw new RuntimeException("No constructor in class " + sc.getName());
        }
        return constructor;
    }

    @Nullable
    public static SootMethod getAnyConstructorUnsafe(SootClass sc, boolean allowNonPublicConstructors) {
        List constructors = BaseBodyGenerator.getConstructorSorted((SootClass)sc, (boolean)allowNonPublicConstructors);
        if (constructors.isEmpty()) {
            return null;
        }
        return (SootMethod)constructors.get(0);
    }

    public static List<SootMethod> getConstructorSorted(SootClass sc, boolean allowNonPublicConstructors) {
        ArrayList<SootMethod> constructors = new ArrayList<SootMethod>();
        for (SootMethod currentMethod : sc.getMethods()) {
            if (!currentMethod.isConstructor() || !allowNonPublicConstructors && (currentMethod.isPrivate() || currentMethod.isProtected())) continue;
            constructors.add(currentMethod);
        }
        constructors.sort((Comparator<SootMethod>)new /* Unavailable Anonymous Inner Class!! */);
        return constructors;
    }

    protected Local generateClassConstructor(INewUnits newUnits, SootClass createdClass, Set<SootClass> constructionStack, Set<SootClass> parentClasses, Set<Local> tempLocals) {
        SootClass outerClass;
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        if (createdClass == null || this.failedClasses.contains(createdClass)) {
            return null;
        }
        Local existingLocal = (Local)this.localVarsForClasses.get(createdClass);
        if (existingLocal != null) {
            return existingLocal;
        }
        if (!this.acceptClass(createdClass)) {
            this.failedClasses.add(createdClass);
            return null;
        }
        if (BaseBodyGenerator.isSimpleType((Type)createdClass.getType())) {
            Local varLocal = this.generator.generateLocal((Type)createdClass.getType());
            AssignStmt aStmt = Jimple.v().newAssignStmt((Value)varLocal, this.getSimpleDefaultValue((Type)createdClass.getType()));
            newUnits.add((Unit)aStmt);
            return varLocal;
        }
        boolean isInnerClass = createdClass.getName().contains("$");
        SootClass sootClass = outerClass = isInnerClass ? Scene.v().getSootClassUnsafe(createdClass.getName().substring(0, createdClass.getName().lastIndexOf("$"))) : null;
        if (!constructionStack.add(createdClass)) {
            if (this.warnOnConstructorLoop) {
                this.logger.warn("Ran into a constructor generation loop for class " + createdClass + ", substituting with null...");
            }
            Local tempLocal = this.generator.generateLocal((Type)RefType.v((SootClass)createdClass));
            AssignStmt assignStmt = Jimple.v().newAssignStmt((Value)tempLocal, (Value)NullConstant.v());
            newUnits.add((Unit)assignStmt);
            return tempLocal;
        }
        if (createdClass.isInterface() || createdClass.isAbstract()) {
            return this.generateSubstitutedClassConstructor(newUnits, createdClass, constructionStack, parentClasses);
        }
        List constructors = BaseBodyGenerator.getConstructorSorted((SootClass)createdClass, (boolean)this.allowNonPublicConstructors);
        if (!constructors.isEmpty()) {
            SootMethod currentMethod = (SootMethod)constructors.remove(0);
            LinkedList<Object> params = new LinkedList<Object>();
            for (Type type : currentMethod.getParameterTypes()) {
                SootClass typeClass;
                LinkedHashSet<SootClass> newStack = new LinkedHashSet<SootClass>(constructionStack);
                SootClass sootClass2 = typeClass = type instanceof RefType ? ((RefType)type).getSootClass() : null;
                if (typeClass != null && isInnerClass && typeClass == outerClass && this.localVarsForClasses.containsKey(outerClass)) {
                    params.add((Value)this.localVarsForClasses.get(outerClass));
                    continue;
                }
                if (this.shallowMode) {
                    if (BaseBodyGenerator.isSimpleType((Type)type)) {
                        params.add(this.getSimpleDefaultValue(type));
                        continue;
                    }
                    params.add(NullConstant.v());
                    continue;
                }
                Value val = this.getValueForType(newUnits, type, newStack, parentClasses, tempLocals);
                params.add(val);
            }
            NewExpr newExpr2 = Jimple.v().newNewExpr(RefType.v((SootClass)createdClass));
            Local tempLocal = this.generator.generateLocal((Type)RefType.v((SootClass)createdClass));
            AssignStmt assignStmt = Jimple.v().newAssignStmt((Value)tempLocal, (Value)newExpr2);
            newUnits.add((Unit)assignStmt);
            SpecialInvokeExpr vInvokeExpr = params.isEmpty() || params.contains(null) ? Jimple.v().newSpecialInvokeExpr(tempLocal, currentMethod.makeRef()) : Jimple.v().newSpecialInvokeExpr(tempLocal, currentMethod.makeRef(), params);
            newUnits.add((Unit)Jimple.v().newInvokeStmt((Value)vInvokeExpr));
            if (tempLocals != null) {
                tempLocals.add(tempLocal);
            }
            return tempLocal;
        }
        this.failedClasses.add(createdClass);
        return null;
    }

    protected Local generateSubstitutedClassConstructor(INewUnits newUnits, SootClass createdClass, Set<SootClass> constructionStack, Set<SootClass> parentClasses) {
        if (!this.substituteCallParams) {
            this.logger.warn("Cannot create valid constructor for {}, because it is {} and cannot substitute with subclass", (Object)createdClass, (Object)(createdClass.isInterface() ? "an interface" : (createdClass.isAbstract() ? "abstract" : "")));
            this.failedClasses.add(createdClass);
            return null;
        }
        List classes = createdClass.isInterface() ? Scene.v().getActiveHierarchy().getImplementersOf(createdClass) : Scene.v().getActiveHierarchy().getSubclassesOf(createdClass);
        for (SootClass sClass : classes) {
            Local cons;
            if (!this.substituteClasses.contains(sClass.toString()) || (cons = this.generateClassConstructor(newUnits, sClass, constructionStack, parentClasses, null)) == null) continue;
            return cons;
        }
        this.logger.warn("Cannot create valid constructor for {}, because it is {} and cannot substitute with subclass", (Object)createdClass, (Object)(createdClass.isInterface() ? "an interface" : (createdClass.isAbstract() ? "abstract" : "")));
        this.failedClasses.add(createdClass);
        return null;
    }

    protected static boolean isSimpleType(Type t) {
        RefType rt;
        if (t instanceof PrimType) {
            return true;
        }
        return t instanceof RefType && (rt = (RefType)t).getSootClass().getName().equals("java.lang.String");
    }

    protected Value getSimpleDefaultValue(Type t) {
        if (t == RefType.v((String)"java.lang.String")) {
            return StringConstant.v((String)"");
        }
        if (t instanceof CharType) {
            return IntConstant.v((int)0);
        }
        if (t instanceof ByteType) {
            return IntConstant.v((int)0);
        }
        if (t instanceof ShortType) {
            return IntConstant.v((int)0);
        }
        if (t instanceof IntType) {
            return IntConstant.v((int)0);
        }
        if (t instanceof FloatType) {
            return FloatConstant.v((float)0.0f);
        }
        if (t instanceof LongType) {
            return LongConstant.v((long)0L);
        }
        if (t instanceof DoubleType) {
            return DoubleConstant.v((double)0.0);
        }
        if (t instanceof BooleanType) {
            return IntConstant.v((int)0);
        }
        return NullConstant.v();
    }

    protected SootMethod findMethod(SootClass currentClass, String subsignature) {
        SootMethod m = currentClass.getMethodUnsafe(subsignature);
        if (m != null) {
            return m;
        }
        if (currentClass.hasSuperclass()) {
            return this.findMethod(currentClass.getSuperclass(), subsignature);
        }
        return null;
    }

    protected boolean isCompatible(SootClass actual, SootClass expected) {
        return Scene.v().getOrMakeFastHierarchy().canStoreType((Type)actual.getType(), (Type)expected.getType());
    }

    protected void eliminateSelfLoops() {
        Iterator unitIt = this.body.getUnits().iterator();
        while (unitIt.hasNext()) {
            IfStmt ifStmt;
            Unit u = (Unit)unitIt.next();
            if (!(u instanceof IfStmt) || (ifStmt = (IfStmt)u).getTarget() != ifStmt) continue;
            unitIt.remove();
        }
    }

    public void setDummyClassName(String dummyClassName) {
        this.dummyClassName = dummyClassName;
    }

    public void setDummyMethodName(String dummyMethodName) {
        this.dummyMethodName = dummyMethodName;
    }

    public void setAllowSelfReferences(boolean value) {
        this.allowSelfReferences = value;
    }

    public void setShallowMode(boolean shallowMode) {
        this.shallowMode = shallowMode;
    }

    public boolean getShallowMode() {
        return this.shallowMode;
    }

    public void setIgnoreSystemClassParams(boolean ignoreSystemClassParams) {
        this.ignoreSystemClassParams = ignoreSystemClassParams;
    }

    public void setAllowNonPublicConstructors(boolean allowNonPublicConstructors) {
        this.allowNonPublicConstructors = allowNonPublicConstructors;
    }

    public void setOverwriteDummyMainMethod(boolean overwriteDummyMainValue) {
        this.overwriteDummyMainMethod = overwriteDummyMainValue;
    }

    public boolean getOverwriteDummyMainMethod() {
        return this.overwriteDummyMainMethod;
    }

    public void setWarnOnConstructorLoop(boolean warnOnConstructorLoop) {
        this.warnOnConstructorLoop = warnOnConstructorLoop;
    }

    public boolean getWarnOnConstructorLoop() {
        return this.warnOnConstructorLoop;
    }

    protected void reset() {
        this.localVarsForClasses.clear();
        this.conditionCounter = 0;
    }

    protected void createIfStmt(Unit target) {
        if (target == null) {
            return;
        }
        Jimple jimple = Jimple.v();
        EqExpr cond = jimple.newEqExpr(this.intCounter, (Value)IntConstant.v((int)this.conditionCounter++));
        IfStmt ifStmt = jimple.newIfStmt((Value)cond, target);
        this.body.getUnits().add((Unit)ifStmt);
    }

    public boolean isClassInSystemPackage(String className) {
        return (className.startsWith("android.") || className.startsWith("java.") || className.startsWith("javax.") || className.startsWith("sun.") || className.startsWith("org.omg.") || className.startsWith("org.w3c.dom.") || className.startsWith("com.google.") || className.startsWith("com.android.")) && this.excludeSystemComponents;
    }

    public void add(Unit unit) {
        this.body.getUnits().add(unit);
    }

    public void add(Collection<Unit> unit) {
        this.body.getUnits().addAll(unit);
    }

    public void add(NewUnits.BeforeUnit unit) {
        this.body.getUnits().add(unit.getInsertBeforeUnit());
        this.body.getUnits().insertBefore(unit.getInsertBefore().getUnits(), unit.getInsertBeforeUnit());
    }

    public void insertAfter(NewUnits.BeforeUnit unit, Unit point) {
        this.body.getUnits().insertAfter(unit.getInsertBeforeUnit(), point);
        this.body.getUnits().insertBefore(unit.getInsertBefore().getUnits(), unit.getInsertBeforeUnit());
    }

    public void insertAfter(Unit toInsert, Unit point) {
        this.body.getUnits().insertAfter(toInsert, point);
    }

    public void insertAfter(List<Unit> toInsert, Unit point) {
        this.body.getUnits().insertAfter(toInsert, point);
    }

    public void insertBefore(Unit toInsert, Unit point) {
        this.body.getUnits().insertBefore(toInsert, point);
    }

    public void insertBefore(List<Unit> toInsert, Unit point) {
        this.body.getUnits().insertBefore(toInsert, point);
    }

    public void addFirst(List<Unit> toInsert) {
        if (!this.body.getUnits().isEmpty()) {
            Unit lastParamIdentityStmt = NewUnitsAtFirstImmediately.getLastParamIdentityStmt((Chain)this.body.getUnits());
            if (lastParamIdentityStmt != null) {
                this.insertAfter(toInsert, lastParamIdentityStmt);
            } else {
                this.insertBefore(toInsert, this.body.getUnits().getFirst());
            }
        } else {
            this.add(toInsert);
        }
    }

    public UnitPatchingChain getUnits() {
        return this.body.getUnits();
    }

    public int size() {
        return this.body.getUnits().size();
    }

    public LocalGenerator getGenerator() {
        return this.generator;
    }
}

