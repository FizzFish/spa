/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.AOPAnalysis
 *  analysis.AOPParser
 *  analysis.Config
 *  analysis.CreateEdge
 *  analysis.Implement
 *  bean.AOPTargetModel
 *  bean.AspectModel
 *  bean.InsertMethod
 *  enums.AdviceEnum
 *  mock.GenerateSyntheticClass
 *  mock.GenerateSyntheticClassImpl
 *  org.aspectj.weaver.UnresolvedType
 *  org.aspectj.weaver.patterns.AndPointcut
 *  org.aspectj.weaver.patterns.AnnotationPointcut
 *  org.aspectj.weaver.patterns.AnnotationTypePattern
 *  org.aspectj.weaver.patterns.AnyWithAnnotationTypePattern
 *  org.aspectj.weaver.patterns.ArgsPointcut
 *  org.aspectj.weaver.patterns.ExactAnnotationTypePattern
 *  org.aspectj.weaver.patterns.KindedPointcut
 *  org.aspectj.weaver.patterns.NamePattern
 *  org.aspectj.weaver.patterns.OrPointcut
 *  org.aspectj.weaver.patterns.PatternParser
 *  org.aspectj.weaver.patterns.Pointcut
 *  org.aspectj.weaver.patterns.SignaturePattern
 *  org.aspectj.weaver.patterns.TypePattern
 *  org.aspectj.weaver.patterns.WildAnnotationTypePattern
 *  org.aspectj.weaver.patterns.WildTypePattern
 *  org.aspectj.weaver.patterns.WithinAnnotationPointcut
 *  org.aspectj.weaver.patterns.WithinPointcut
 *  soot.Body
 *  soot.Local
 *  soot.Modifier
 *  soot.RefType
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.Value
 *  soot.VoidType
 *  soot.jimple.Jimple
 *  soot.jimple.JimpleBody
 *  soot.jimple.VirtualInvokeExpr
 *  soot.jimple.internal.JReturnStmt
 *  soot.jimple.internal.JReturnVoidStmt
 *  soot.tagkit.AnnotationElem
 *  soot.tagkit.AnnotationIntElem
 *  soot.tagkit.AnnotationTag
 *  soot.tagkit.VisibilityAnnotationTag
 *  soot.util.Chain
 *  utils.BaseBodyGenerator
 *  utils.BaseBodyGeneratorFactory
 *  utils.INewUnits
 *  utils.JimpleUtils
 *  utils.NewUnits$BeforeUnit
 *  utils.NewUnitsAtFirstImmediately
 *  utils.Ref
 */
package analysis;

import analysis.AOPAnalysis;
import analysis.Config;
import analysis.CreateEdge;
import analysis.Implement;
import bean.AOPTargetModel;
import bean.AspectModel;
import bean.InsertMethod;
import enums.AdviceEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mock.GenerateSyntheticClass;
import mock.GenerateSyntheticClassImpl;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.patterns.AndPointcut;
import org.aspectj.weaver.patterns.AnnotationPointcut;
import org.aspectj.weaver.patterns.AnnotationTypePattern;
import org.aspectj.weaver.patterns.AnyWithAnnotationTypePattern;
import org.aspectj.weaver.patterns.ArgsPointcut;
import org.aspectj.weaver.patterns.ExactAnnotationTypePattern;
import org.aspectj.weaver.patterns.KindedPointcut;
import org.aspectj.weaver.patterns.NamePattern;
import org.aspectj.weaver.patterns.OrPointcut;
import org.aspectj.weaver.patterns.PatternParser;
import org.aspectj.weaver.patterns.Pointcut;
import org.aspectj.weaver.patterns.SignaturePattern;
import org.aspectj.weaver.patterns.TypePattern;
import org.aspectj.weaver.patterns.WildAnnotationTypePattern;
import org.aspectj.weaver.patterns.WildTypePattern;
import org.aspectj.weaver.patterns.WithinAnnotationPointcut;
import org.aspectj.weaver.patterns.WithinPointcut;
import soot.Body;
import soot.Local;
import soot.Modifier;
import soot.RefType;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.VoidType;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JReturnVoidStmt;
import soot.tagkit.AnnotationElem;
import soot.tagkit.AnnotationIntElem;
import soot.tagkit.AnnotationTag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.util.Chain;
import utils.BaseBodyGenerator;
import utils.BaseBodyGeneratorFactory;
import utils.INewUnits;
import utils.JimpleUtils;
import utils.NewUnits;
import utils.NewUnitsAtFirstImmediately;
import utils.Ref;

/*
 * Exception performing whole class analysis ignored.
 */
public class AOPParser {
    public static Map<String, AOPTargetModel> modelMap = new LinkedHashMap();
    public static Map<String, SootClass> proxyMap = new LinkedHashMap();
    public static Map<String, HashSet<String>> TargetToAdv = new LinkedHashMap();
    private GenerateSyntheticClass gsc = new GenerateSyntheticClassImpl();

    public List<AspectModel> getAllAspects(Set<SootClass> sootClasses) {
        LinkedList<AspectModel> allAspects = new LinkedList<AspectModel>();
        for (SootClass sootClass : sootClasses) {
            SootClass aspectClass = null;
            int order = Integer.MAX_VALUE;
            VisibilityAnnotationTag annotationTags = (VisibilityAnnotationTag)sootClass.getTag("VisibilityAnnotationTag");
            if (annotationTags != null && annotationTags.getAnnotations() != null) {
                for (AnnotationTag annotation : annotationTags.getAnnotations()) {
                    if (annotation.getType().equals("Lorg/aspectj/lang/annotation/Aspect;")) {
                        aspectClass = sootClass;
                        continue;
                    }
                    if (!annotation.getType().equals("Lorg/springframework/core/annotation/Order;")) continue;
                    for (AnnotationElem elem : annotation.getElems()) {
                        if (!(elem instanceof AnnotationIntElem)) continue;
                        order = ((AnnotationIntElem)elem).getValue();
                    }
                }
            }
            if (aspectClass == null) continue;
            allAspects.add(new AspectModel(aspectClass, order));
        }
        return allAspects;
    }

    public void processDiffAopExp(String expression, SootMethod aspectMethod) {
        PatternParser parser = new PatternParser(expression);
        Pointcut pointcut = parser.parsePointcut();
        AOPParser aopParser = new AOPParser();
        for (SootClass sootClass : CreateEdge.allBeansAndInterfaces) {
            for (SootMethod targetMethod : sootClass.getMethods()) {
                if (!aopParser.switchPoint(pointcut, aspectMethod, targetMethod)) continue;
                this.savePointMethod(aspectMethod, sootClass, targetMethod);
            }
        }
    }

    public boolean switchPoint(Pointcut pointcut, SootMethod aspectMethod, SootMethod targetMethod) {
        boolean matched = false;
        switch (pointcut.getClass().getSimpleName()) {
            case "WithinPointcut": {
                WithinPointcut withinPointcut = (WithinPointcut)pointcut;
                matched = this.withInProcess(withinPointcut, aspectMethod, targetMethod);
                break;
            }
            case "KindedPointcut": {
                KindedPointcut execPointcut = (KindedPointcut)pointcut;
                matched = this.executionProcess(execPointcut, aspectMethod, targetMethod);
                break;
            }
            case "ArgsPointcut": {
                ArgsPointcut argsPointcut = (ArgsPointcut)pointcut;
                matched = this.ArgsProcess(argsPointcut, aspectMethod, targetMethod);
                break;
            }
            case "AndPointcut": {
                AndPointcut andPointcut = (AndPointcut)pointcut;
                matched = this.andProcess(andPointcut, aspectMethod, targetMethod);
                break;
            }
            case "OrPointcut": {
                OrPointcut orPointcut = (OrPointcut)pointcut;
                matched = this.orProcess(orPointcut, aspectMethod, targetMethod);
                break;
            }
            case "AnnotationPointcut": {
                AnnotationPointcut annotationPointcut = (AnnotationPointcut)pointcut;
                matched = this.AnnoProcess(annotationPointcut, aspectMethod, targetMethod);
                break;
            }
            case "WithinAnnotationPointcut": {
                WithinAnnotationPointcut withinAnnotationPointcut = (WithinAnnotationPointcut)pointcut;
                matched = this.withinAnnoProcess(withinAnnotationPointcut, aspectMethod, targetMethod);
            }
        }
        return matched;
    }

    private boolean withinAnnoProcess(WithinAnnotationPointcut withinAnnotationPointcut, SootMethod aspectMethod, SootMethod targetMethod) {
        VisibilityAnnotationTag classAnnotationTag;
        AnnotationTypePattern typePattern = withinAnnotationPointcut.getAnnotationTypePattern();
        String str = "";
        if (typePattern instanceof ExactAnnotationTypePattern) {
            ExactAnnotationTypePattern ex = (ExactAnnotationTypePattern)typePattern;
            UnresolvedType annotationType = ex.getAnnotationType();
            str = annotationType.getSignature();
        }
        if ((classAnnotationTag = (VisibilityAnnotationTag)targetMethod.getDeclaringClass().getTag("VisibilityAnnotationTag")) != null && classAnnotationTag.getAnnotations() != null) {
            for (AnnotationTag annotation : classAnnotationTag.getAnnotations()) {
                if (!annotation.getType().equals(str)) continue;
                return true;
            }
        }
        return false;
    }

    public boolean withInProcess(WithinPointcut pointcut, SootMethod aspectMethod, SootMethod targetMethod) {
        TypePattern typePattern = pointcut.getTypePattern();
        Map dealWithinPointcut = AOPParser.dealWithinPointcut((TypePattern)typePattern);
        Integer type = (Integer)dealWithinPointcut.get("type");
        if (type != 1) {
            if (type == 3) {
                NamePattern[] namePatterns1 = (NamePattern[])dealWithinPointcut.get("pattern");
                if (!this.clazzIsMatch(namePatterns1, targetMethod.getDeclaringClass().getName())) {
                    return false;
                }
            } else if (type == 2) {
                // empty if block
            }
        }
        return true;
    }

    public boolean ArgsProcess(ArgsPointcut pointcut, SootMethod aspectMethod, SootMethod targetMethod) {
        TypePattern[] typePatterns = pointcut.getArguments().getTypePatterns();
        return this.isMethodParamMatches(typePatterns, targetMethod.getParameterTypes());
    }

    public boolean executionProcess(KindedPointcut pointcut, SootMethod aspectMethod, SootMethod targetMethod) {
        WildTypePattern wildType;
        NamePattern[] namePatterns;
        boolean flag;
        WildTypePattern wildType2;
        NamePattern[] namePatterns2;
        SignaturePattern pattern = pointcut.getSignature();
        String modifier = pattern.getModifiers().toString();
        TypePattern declaringType = pattern.getDeclaringType();
        TypePattern returnType = pattern.getReturnType();
        NamePattern methodName = pattern.getName();
        TypePattern[] typePatterns = pattern.getParameterTypes().getTypePatterns();
        if (declaringType instanceof WildTypePattern && !this.clazzIsMatch(namePatterns2 = (wildType2 = (WildTypePattern)declaringType).getNamePatterns(), targetMethod.getDeclaringClass().getName())) {
            return false;
        }
        int methodModifier = targetMethod.getModifiers();
        switch (modifier) {
            case "public": {
                flag = Modifier.isPublic((int)methodModifier);
                break;
            }
            case "protected": {
                flag = Modifier.isProtected((int)methodModifier);
                break;
            }
            case "private": {
                flag = Modifier.isPrivate((int)methodModifier);
                break;
            }
            default: {
                flag = true;
            }
        }
        if (!flag || !methodName.matches(targetMethod.getName()) || targetMethod.getName().equals("<init>") || targetMethod.getName().equals(Config.CALL_ENTRY_NAME) || targetMethod.getName().equals("<clinit>")) {
            return false;
        }
        if (returnType instanceof WildTypePattern && this.clazzIsMatch(namePatterns = (wildType = (WildTypePattern)returnType).getNamePatterns(), targetMethod.getReturnType().toString())) {
            return false;
        }
        return this.isMethodParamMatches(typePatterns, targetMethod.getParameterTypes());
    }

    public boolean AnnoProcess(AnnotationPointcut pointcut, SootMethod aspectMethod, SootMethod targetMethod) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        String s = pointcut.getAnnotationTypePattern().getAnnotationType().toString();
        String annot = "";
        for (Local local : jimpleUtils.getMethodBody(aspectMethod).getLocals()) {
            if (!local.getName().equals(s)) continue;
            String a = local.getType().toString();
            String[] array = a.split("\\.");
            annot = array[array.length - 1];
            break;
        }
        s = s.substring(s.lastIndexOf(".") + 1);
        boolean isclazzAnnoed = false;
        VisibilityAnnotationTag classAnnotationTag = (VisibilityAnnotationTag)targetMethod.getDeclaringClass().getTag("VisibilityAnnotationTag");
        if (classAnnotationTag != null && classAnnotationTag.getAnnotations() != null) {
            for (AnnotationTag annotation : classAnnotationTag.getAnnotations()) {
                String c = annotation.getType().substring(annotation.getType().lastIndexOf("/") + 1, annotation.getType().length() - 1);
                if (!c.equals(s)) continue;
                isclazzAnnoed = true;
                break;
            }
        }
        if (isclazzAnnoed) {
            return true;
        }
        VisibilityAnnotationTag annotationTags = (VisibilityAnnotationTag)targetMethod.getTag("VisibilityAnnotationTag");
        if (annotationTags != null && annotationTags.getAnnotations() != null) {
            for (AnnotationTag annotation : annotationTags.getAnnotations()) {
                String c = annotation.getType().substring(annotation.getType().lastIndexOf("/") + 1, annotation.getType().length() - 1);
                if (!c.equals(s) && !c.equals(annot)) continue;
                return true;
            }
        }
        return false;
    }

    public boolean orProcess(OrPointcut pointcut, SootMethod aspectMethod, SootMethod targetMethod) {
        Pointcut leftPoint = pointcut.getLeft();
        Pointcut rightPoint = pointcut.getRight();
        return this.switchPoint(leftPoint, aspectMethod, targetMethod) || this.switchPoint(rightPoint, aspectMethod, targetMethod);
    }

    public boolean andProcess(AndPointcut pointcut, SootMethod aspectMethod, SootMethod targetMethod) {
        Pointcut leftPoint = pointcut.getLeft();
        Pointcut rightPoint = pointcut.getRight();
        return this.switchPoint(leftPoint, aspectMethod, targetMethod) && this.switchPoint(rightPoint, aspectMethod, targetMethod);
    }

    public void addAdviceToTarget(List<AspectModel> allAdvices) {
        LinkedHashMap<String, AOPTargetModel> tmp = new LinkedHashMap<String, AOPTargetModel>();
        for (AspectModel adviceModel : allAdvices) {
            for (Map.Entry stringAOPTargetModelEntry : modelMap.entrySet()) {
                SootClass proxyClass;
                AOPTargetModel aopTargetModel = (AOPTargetModel)stringAOPTargetModelEntry.getValue();
                String key2 = (String)stringAOPTargetModelEntry.getKey();
                if (proxyMap.containsKey(aopTargetModel.getClassName())) {
                    proxyClass = (SootClass)proxyMap.get(aopTargetModel.getClassName());
                } else {
                    if (aopTargetModel.getSootClass().isAbstract()) {
                        tmp.put(key2, aopTargetModel);
                        continue;
                    }
                    proxyClass = this.gsc.generateProxy(aopTargetModel.getSootClass());
                    proxyMap.put(aopTargetModel.getClassName(), proxyClass);
                }
                SootMethod superMethod = aopTargetModel.getSootMethod();
                if (superMethod.isStatic() || superMethod.isPrivate() || superMethod.isFinal() || superMethod.isConstructor() || superMethod.isStaticInitializer()) {
                    tmp.put(key2, aopTargetModel);
                    continue;
                }
                SootMethod proxyMethod = proxyClass.getMethod(aopTargetModel.getSootMethod().getSubSignature());
                aopTargetModel.setProxyClass(proxyClass);
                aopTargetModel.setProxyClassName(proxyClass.getName());
                aopTargetModel.setProxyMethod(proxyMethod);
                aopTargetModel.setProxyMethodName(proxyMethod.getSignature());
                if (!TargetToAdv.containsKey(key2) || !((HashSet)TargetToAdv.get(key2)).contains(adviceModel.getSootMethod().getSignature())) continue;
                aopTargetModel.addAdvice(adviceModel);
            }
        }
        for (String s : tmp.keySet()) {
            modelMap.remove(s);
        }
    }

    private AOPTargetModel getAopTargetInstance(SootClass sootClass, SootMethod sootMethod) {
        AOPTargetModel atm = new AOPTargetModel();
        atm.setSootClass(sootClass);
        atm.setClassName(sootClass.getName());
        atm.setSootMethod(sootMethod);
        atm.setMethodName(sootMethod.getSignature());
        return atm;
    }

    private void savePointMethod(SootMethod aspectMethod, SootClass sootClass, SootMethod method) {
        if (method.getName().equals("<init>") || method.getName().equals(Config.CALL_ENTRY_NAME) || method.getName().equals("<clinit>")) {
            return;
        }
        if (sootClass.isInterface()) {
            sootClass = (SootClass)CreateEdge.interfaceToBeans.get(sootClass.getName());
            method = sootClass.getMethodUnsafe(method.getSubSignature());
        }
        if (method == null) {
            return;
        }
        String methodSign = method.getSignature();
        HashSet tmp = TargetToAdv.containsKey(methodSign) ? (HashSet)TargetToAdv.get(methodSign) : new LinkedHashSet();
        tmp.add(aspectMethod.getSignature());
        TargetToAdv.put(methodSign, tmp);
        if (!modelMap.containsKey(methodSign)) {
            AOPTargetModel atm = this.getAopTargetInstance(sootClass, method);
            modelMap.put(methodSign, atm);
        }
    }

    public boolean clazzIsMatch(NamePattern[] namePatterns, String path) {
        Pattern re1 = Pattern.compile("[a-z|A-Z|_]+[0-9]*");
        Pattern re2 = Pattern.compile("\\*");
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        for (NamePattern namePattern : namePatterns) {
            Matcher m1 = re1.matcher(namePattern.toString());
            Matcher m2 = re2.matcher(namePattern.toString());
            if (m1.find()) {
                sb.append(namePattern.toString());
                sb.append("\\.");
                continue;
            }
            if (m2.find()) {
                sb.append("([a-z|A-Z|_]+[0-9]*)\\.");
                continue;
            }
            if (!namePattern.toString().equals("")) continue;
            sb.append("(((\\D+)(\\w*)\\.)+)?");
        }
        String res = sb.toString();
        if (res.lastIndexOf(".") == res.length() - 1) {
            res = res.substring(0, res.lastIndexOf("\\."));
        }
        res = res + "$";
        Pattern compile = Pattern.compile(res);
        Matcher matcher = compile.matcher(path);
        return matcher.find();
    }

    public boolean isMethodParamMatches(TypePattern[] typePatterns, List<Type> parameterTypes) {
        boolean ismatch = false;
        if (parameterTypes.size() >= typePatterns.length) {
            if (parameterTypes.size() == 0) {
                ismatch = true;
            } else {
                for (int i = 0; i < typePatterns.length; ++i) {
                    String tmptype = typePatterns[i].toString();
                    if (i == typePatterns.length - 1 && typePatterns.length == parameterTypes.size() && ("..".equals(tmptype) || parameterTypes.get(i).toString().contains(tmptype))) {
                        ismatch = true;
                    }
                    if ("*".equals(tmptype)) continue;
                    if ("..".equals(tmptype)) {
                        ismatch = true;
                    } else {
                        if (parameterTypes.get(i).toString().contains(tmptype)) continue;
                        ismatch = false;
                    }
                    break;
                }
            }
        } else {
            int i;
            for (i = 0; i < parameterTypes.size(); ++i) {
                String tmptype = typePatterns[i].toString();
                if ("*".equals(tmptype)) continue;
                if ("..".equals(tmptype)) {
                    ismatch = true;
                    break;
                }
                if (!parameterTypes.get(i).toString().contains(tmptype)) break;
            }
            if (typePatterns.length - i == 1 && "..".equals(typePatterns[typePatterns.length - 1].toString())) {
                ismatch = true;
            }
        }
        return ismatch;
    }

    public static Map<String, Object> dealWithinPointcut(TypePattern typePattern) {
        LinkedHashMap<String, Object> res = new LinkedHashMap<String, Object>();
        if (typePattern.isIncludeSubtypes()) {
            WildTypePattern wildTypePattern = (WildTypePattern)typePattern;
            NamePattern[] namePatterns = wildTypePattern.getNamePatterns();
            res.put("pattern", namePatterns);
            res.put("type", 1);
            return res;
        }
        if (typePattern instanceof AnyWithAnnotationTypePattern) {
            AnyWithAnnotationTypePattern awatp = (AnyWithAnnotationTypePattern)typePattern;
            WildAnnotationTypePattern wildAnnotationTypePattern = (WildAnnotationTypePattern)awatp.getAnnotationTypePattern();
            WildTypePattern wildTypePattern = (WildTypePattern)wildAnnotationTypePattern.getTypePattern();
            NamePattern[] namePatterns = wildTypePattern.getNamePatterns();
            res.put("pattern", namePatterns);
            res.put("type", 2);
            return res;
        }
        WildTypePattern wildTypePattern = (WildTypePattern)typePattern;
        NamePattern[] namePatterns = wildTypePattern.getNamePatterns();
        res.put("pattern", namePatterns);
        res.put("type", 3);
        return res;
    }

    protected SootMethod aroundParser(AspectModel aspectModel, SootMethod targetMethod) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        ArrayList<Unit> returnList = new ArrayList<Unit>();
        ArrayList<Unit> insertPointList = new ArrayList<Unit>();
        ArrayList<Unit> pjpList = new ArrayList<Unit>();
        ArrayList<RefType> parameterTypes = new ArrayList<RefType>(aspectModel.getSootMethod().getParameterTypes());
        parameterTypes.addAll(targetMethod.getParameterTypes());
        parameterTypes.add(targetMethod.getDeclaringClass().getType());
        SootMethod newAspectMethod = new SootMethod(aspectModel.getSootMethod().getName() + "_" + targetMethod.getName(), parameterTypes, aspectModel.getSootMethod().getReturnType(), 1);
        aspectModel.getSootClass().getOrAddMethod(newAspectMethod);
        JimpleBody aspectBody = (JimpleBody)jimpleUtils.getMethodBody(aspectModel.getSootMethod()).clone();
        UnitPatchingChain aspectUnits = aspectBody.getUnits();
        Unit paramInsertPoint = null;
        int paramCount = 0;
        for (Unit unit : aspectUnits) {
            if (unit.toString().contains("@parameter")) {
                paramInsertPoint = unit;
                ++paramCount;
                continue;
            }
            if (paramCount == 0) continue;
            break;
        }
        for (int i = parameterTypes.size() - 1; i > paramCount - 1; --i) {
            Local param = jimpleUtils.addLocalVar("param" + i, (Type)parameterTypes.get(i), (Body)aspectBody);
            if (paramInsertPoint != null) {
                aspectUnits.insertAfter(jimpleUtils.createIdentityStmt((Value)param, (Value)jimpleUtils.createParamRef((Type)parameterTypes.get(i), i)), paramInsertPoint);
                continue;
            }
            aspectUnits.addFirst(jimpleUtils.createIdentityStmt((Value)param, (Value)jimpleUtils.createParamRef((Type)parameterTypes.get(i), i)));
        }
        newAspectMethod.setActiveBody((Body)aspectBody);
        for (Unit unit : aspectUnits) {
            if (unit instanceof JReturnVoidStmt || unit instanceof JReturnStmt) {
                returnList.add(unit);
                insertPointList.add(unit);
                continue;
            }
            if (!unit.toString().contains("<org.aspectj.lang.ProceedingJoinPoint: java.lang.Object proceed()>") && !unit.toString().contains("<org.aspectj.lang.ProceedingJoinPoint: java.lang.Object proceed(java.lang.Object[])>")) continue;
            pjpList.add(unit);
        }
        AOPAnalysis.insertMethodMap.put(newAspectMethod.toString(), new InsertMethod(newAspectMethod, returnList, insertPointList, pjpList));
        return newAspectMethod;
    }

    protected void insertAOPTarget(SootMethod currentMethod, SootMethod calleeMethod, AdviceEnum currentEnum) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        int modifyLineNumber = 0;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(currentMethod);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        Local localModel = null;
        if (currentMethod.getDeclaringClass().getSuperclass().equals(calleeMethod.getDeclaringClass())) {
            for (Local local : body.getLocals()) {
                if (!local.getName().equals("localTarget")) continue;
                localModel = local;
                break;
            }
        } else {
            localModel = body.getParameterLocal(body.getParameterLocals().size() - 1);
        }
        int paramCount = currentMethod.getParameterCount() - calleeMethod.getParameterCount() - 1;
        ArrayList paramList = new ArrayList(body.getParameterLocals());
        if (currentEnum != null && currentEnum.name().equals("AOP_AROUND")) {
            if (currentMethod.getParameterCount() != 0) {
                paramList.remove(currentMethod.getParameterCount() - 1);
            }
            if (paramCount > 0) {
                paramList.subList(0, paramCount).clear();
            }
        }
        InsertMethod im = (InsertMethod)AOPAnalysis.insertMethodMap.get(currentMethod.toString());
        List returnList = im.getReturnList();
        List insertPointList = im.getPjpList() == null ? im.getInsertPointList() : im.getPjpList();
        Local returnRef = null;
        for (int i = 0; i < insertPointList.size(); ++i) {
            if (!(currentMethod.getReturnType() instanceof VoidType) && !(calleeMethod.getReturnType() instanceof VoidType)) {
                if (returnRef == null) {
                    String returnRefName = ((Unit)returnList.get(i)).toString().replace("return ", "");
                    for (Local local : body.getLocals()) {
                        if (!local.getName().equals(returnRefName)) continue;
                        returnRef = local;
                        break;
                    }
                    if (returnRef == null) {
                        returnRef = jimpleUtils.addLocalVar(returnRefName, (Type)RefType.v((String)currentMethod.getReturnType().toString()), (Body)body);
                    }
                }
                VirtualInvokeExpr returnValue = jimpleUtils.createVirtualInvokeExpr(localModel, calleeMethod, paramList);
                if (im.getPjpList() != null) {
                    units.insertAfter(jimpleUtils.createAssignStmt(returnRef, (Value)returnValue), (Unit)insertPointList.get(i));
                } else {
                    units.insertBefore(jimpleUtils.createAssignStmt(returnRef, (Value)returnValue), (Unit)insertPointList.get(i));
                }
            } else if (im.getPjpList() != null) {
                units.insertAfter(jimpleUtils.virtualCallStatement(localModel, calleeMethod, paramList), (Unit)insertPointList.get(i));
            } else {
                units.insertBefore(jimpleUtils.virtualCallStatement(localModel, calleeMethod, paramList), (Unit)insertPointList.get(i));
            }
            ++modifyLineNumber;
        }
    }

    protected void insertAOPAround(SootMethod currentMethod, SootMethod calleeMethod) {
        Ref detal;
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        InsertMethod im = (InsertMethod)AOPAnalysis.insertMethodMap.get(currentMethod.getSignature());
        List returnList = im.getReturnList();
        List insertPointList = im.getPjpList() == null ? im.getInsertPointList() : im.getPjpList();
        int modifyLineNumber = 0;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(currentMethod);
        Local localModel = Jimple.v().newLocal(calleeMethod.getDeclaringClass().getShortName().toLowerCase(), (Type)RefType.v((String)calleeMethod.getDeclaringClass().getName()));
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        Local returnLocal = this.initLocalModel(currentMethod, calleeMethod, body, units, localModel, detal = new Ref((Object)0));
        if (returnLocal == localModel) {
            modifyLineNumber += 2 + (Integer)detal.get();
        } else {
            localModel = returnLocal;
        }
        ArrayList<Object> paramList = new ArrayList<Object>();
        int paramCount = calleeMethod.getParameterCount() - currentMethod.getParameterCount();
        if (im.getPjpList() == null) {
            --paramCount;
        }
        NewUnitsAtFirstImmediately insertAtFirst = new NewUnitsAtFirstImmediately(units);
        for (int j = 0; j < paramCount; ++j) {
            if (this.addJoinPointToParam(calleeMethod, j, body, paramList)) continue;
            paramList.add(units.getValueForType((INewUnits)insertAtFirst, calleeMethod.getParameterType(j)));
        }
        paramList.addAll(body.getParameterLocals());
        if (im.getPjpList() == null) {
            for (Local local : body.getLocals()) {
                if (!local.getName().equals("localTarget")) continue;
                paramList.add(local);
            }
        }
        Local returnRef = null;
        for (int i = 0; i < insertPointList.size(); ++i) {
            if (!(currentMethod.getReturnType() instanceof VoidType)) {
                if (returnRef == null) {
                    String returnRefName = ((Unit)returnList.get(i)).toString().replace("return ", "");
                    for (Local local : body.getLocals()) {
                        if (!local.getName().equals(returnRefName)) continue;
                        returnRef = local;
                        break;
                    }
                    if (returnRef == null) {
                        returnRef = jimpleUtils.addLocalVar(returnRefName, currentMethod.getReturnType(), (Body)body);
                    }
                }
                VirtualInvokeExpr returnValue = jimpleUtils.createVirtualInvokeExpr(localModel, calleeMethod, paramList);
                if (im.getPjpList() != null) {
                    units.insertAfter(jimpleUtils.createAssignStmt(returnRef, (Value)returnValue), (Unit)insertPointList.get(i));
                } else {
                    units.insertBefore(jimpleUtils.createAssignStmt(returnRef, (Value)returnValue), (Unit)insertPointList.get(i));
                }
            } else if (im.getPjpList() != null) {
                units.insertAfter(jimpleUtils.virtualCallStatement(localModel, calleeMethod, paramList), (Unit)insertPointList.get(i));
            } else {
                units.insertBefore(jimpleUtils.virtualCallStatement(localModel, calleeMethod, paramList), (Unit)insertPointList.get(i));
            }
            ++modifyLineNumber;
        }
    }

    protected void insertAOPBefore(SootMethod currentMethod, SootMethod calleeMethod) {
        Ref detal;
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        int modifyLineNumber = 0;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(currentMethod);
        Local localModel = Jimple.v().newLocal(calleeMethod.getDeclaringClass().getShortName().toLowerCase(), (Type)RefType.v((String)calleeMethod.getDeclaringClass().getName()));
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        Local returnLocal = this.initLocalModel(currentMethod, calleeMethod, body, units, localModel, detal = new Ref((Object)0));
        if (returnLocal == localModel) {
            modifyLineNumber += 2 + (Integer)detal.get();
        } else {
            localModel = returnLocal;
        }
        NewUnitsAtFirstImmediately insertAtFirst = new NewUnitsAtFirstImmediately(units);
        ArrayList<Value> paramList = new ArrayList<Value>();
        int paramCount = calleeMethod.getParameterCount();
        for (int j = 0; j < paramCount; ++j) {
            if (this.addJoinPointToParam(calleeMethod, j, body, paramList)) continue;
            paramList.add(units.getValueForType((INewUnits)insertAtFirst, calleeMethod.getParameterType(j)));
        }
        InsertMethod im = (InsertMethod)AOPAnalysis.insertMethodMap.get(currentMethod.toString());
        List returnList = im.getReturnList();
        List insertPointList = im.getPjpList() == null ? im.getInsertPointList() : im.getPjpList();
        for (int i = 0; i < insertPointList.size(); ++i) {
            if (localModel != body.getThisLocal()) {
                units.insertBefore(jimpleUtils.virtualCallStatement(localModel, calleeMethod, paramList), (Unit)insertPointList.get(i));
            } else {
                units.insertBefore(jimpleUtils.specialCallStatement(localModel, calleeMethod, paramList), (Unit)insertPointList.get(i));
            }
            ++modifyLineNumber;
        }
    }

    protected void insertAOPAfter(SootMethod currentMethod, SootMethod calleeMethod) {
        Ref detal;
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        int modifyLineNumber = 0;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(currentMethod);
        Local localModel = Jimple.v().newLocal(calleeMethod.getDeclaringClass().getShortName().toLowerCase(), (Type)RefType.v((String)calleeMethod.getDeclaringClass().getName()));
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        Local returnLocal = this.initLocalModel(currentMethod, calleeMethod, body, units, localModel, detal = new Ref((Object)0));
        if (returnLocal == localModel) {
            modifyLineNumber += 2 + (Integer)detal.get();
        } else {
            localModel = returnLocal;
        }
        NewUnitsAtFirstImmediately insertAtFirst = new NewUnitsAtFirstImmediately(units);
        ArrayList<Value> paramList = new ArrayList<Value>();
        int paramCount = calleeMethod.getParameterCount();
        for (int j = 0; j < paramCount; ++j) {
            if (this.addJoinPointToParam(calleeMethod, j, body, paramList)) continue;
            paramList.add(units.getValueForType((INewUnits)insertAtFirst, calleeMethod.getParameterType(j)));
        }
        InsertMethod im = (InsertMethod)AOPAnalysis.insertMethodMap.get(currentMethod.toString());
        List returnList = im.getReturnList();
        List insertPointList = AOPAnalysis.newVersion && im.getPjpList() != null ? im.getPjpList() : im.getInsertPointList();
        for (int i = 0; i < insertPointList.size(); ++i) {
            if (!AOPAnalysis.newVersion) {
                if (localModel != body.getThisLocal()) {
                    units.insertBefore(jimpleUtils.virtualCallStatement(localModel, calleeMethod, paramList), (Unit)insertPointList.get(i));
                } else {
                    units.insertBefore(jimpleUtils.specialCallStatement(localModel, calleeMethod, paramList), (Unit)insertPointList.get(i));
                }
            } else {
                units.insertAfter(jimpleUtils.specialCallStatement(localModel, calleeMethod, paramList), (Unit)insertPointList.get(i));
            }
            ++modifyLineNumber;
        }
    }

    protected void insertAOPAfterReturning(SootMethod currentMethod, SootMethod calleeMethod, List<String> expressionList) {
        Ref detal;
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        int modifyLineNumber = 0;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(currentMethod);
        Local localModel = Jimple.v().newLocal(calleeMethod.getDeclaringClass().getShortName().toLowerCase(), (Type)RefType.v((String)calleeMethod.getDeclaringClass().getName()));
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        Local returnLocal = this.initLocalModel(currentMethod, calleeMethod, body, units, localModel, detal = new Ref((Object)0));
        if (returnLocal == localModel) {
            modifyLineNumber += 2 + (Integer)detal.get();
        } else {
            localModel = returnLocal;
        }
        NewUnitsAtFirstImmediately insertAtFirst = new NewUnitsAtFirstImmediately(units);
        ArrayList<Value> paramList = new ArrayList<Value>();
        int paramCount = calleeMethod.getParameterCount();
        int returnParamIndex = -1;
        for (int j = 0; j < paramCount; ++j) {
            if (((Type)calleeMethod.getParameterTypes().get(j)).toString().equals("java.lang.Object") && expressionList.contains(jimpleUtils.getMethodBody(calleeMethod).getParameterLocal(j).toString())) {
                returnParamIndex = j;
            }
            if (this.addJoinPointToParam(calleeMethod, j, body, paramList)) continue;
            paramList.add(units.getValueForType((INewUnits)insertAtFirst, calleeMethod.getParameterType(j)));
        }
        InsertMethod im = (InsertMethod)AOPAnalysis.insertMethodMap.get(currentMethod.toString());
        List insertPointList = AOPAnalysis.newVersion && im.getPjpList() != null ? im.getPjpList() : im.getInsertPointList();
        Object returnRef = null;
        for (Unit unit : insertPointList) {
            if (!AOPAnalysis.newVersion) {
                if (localModel != body.getThisLocal()) {
                    units.insertBefore(jimpleUtils.virtualCallStatement(localModel, calleeMethod, paramList), unit);
                } else {
                    units.insertBefore(jimpleUtils.specialCallStatement(localModel, calleeMethod, paramList), unit);
                }
            } else {
                units.insertAfter(jimpleUtils.specialCallStatement(localModel, calleeMethod, paramList), unit);
            }
            ++modifyLineNumber;
        }
    }

    private Local initLocalModel(SootMethod currentMethod, SootMethod calleeMethod, JimpleBody body, BaseBodyGenerator units, Local localModel, Ref<Integer> detal) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        Local existLocal = this.isExistLocal(body.getLocals(), localModel);
        if (calleeMethod.getDeclaringClass().getName().equals(currentMethod.getDeclaringClass().getName())) {
            localModel = body.getThisLocal();
        } else if (existLocal == null) {
            body.getLocals().add((Object)localModel);
            Unit localInitAssign = jimpleUtils.createAssignStmt(localModel, calleeMethod.getDeclaringClass().getName());
            units.addFirst(Collections.singletonList(localInitAssign));
            NewUnits.BeforeUnit beforeUnit = jimpleUtils.specialCallStatement(localModel, JimpleUtils.getMinConstructorOrCreate((SootClass)calleeMethod.getDeclaringClass()), units);
            units.insertAfter(beforeUnit, localInitAssign);
            detal.set((Object)beforeUnit.getInsertBefore().getUnits().size());
        } else {
            localModel = existLocal;
        }
        return localModel;
    }

    private boolean addJoinPointToParam(SootMethod calleeMethod, int paramIndex, JimpleBody body, List<Value> paramList) {
        boolean continueFlag = false;
        if (calleeMethod.getParameterType(paramIndex).toString().contains("JoinPoint")) {
            for (Local local : body.getLocals()) {
                if (!local.getType().toString().contains("JoinPoint")) continue;
                paramList.add((Value)local);
                continueFlag = true;
                break;
            }
        }
        return continueFlag;
    }

    private Local isExistLocal(Chain<Local> locals, Local localModel) {
        for (Local local : locals) {
            if (!local.getName().equals(localModel.getName()) || !local.getType().equals(localModel.getType()) || local == localModel) continue;
            return local;
        }
        return null;
    }

    public static void clear() {
        modelMap.clear();
        proxyMap.clear();
        TargetToAdv.clear();
    }
}

