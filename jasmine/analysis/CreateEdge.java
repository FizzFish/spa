/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.AOPAnalysis
 *  analysis.AOPParser
 *  analysis.AnnotationAnalysis
 *  analysis.Config
 *  analysis.CreateEdge
 *  analysis.CreateEdge$XmlBeanClazz
 *  analysis.IOCParser
 *  analysis.Implement
 *  analysis.SpringAnnotationTag
 *  bean.AOPTargetModel
 *  bean.AopXMLResultBean
 *  bean.AspectModel
 *  bean.ConstructorArgBean
 *  enums.AdviceEnum
 *  mock.GenerateSyntheticClass
 *  mock.GenerateSyntheticClassImpl
 *  org.dom4j.Document
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  soot.ArrayType
 *  soot.Body
 *  soot.FastHierarchy
 *  soot.Hierarchy
 *  soot.Local
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.VoidType
 *  soot.jimple.Jimple
 *  soot.jimple.JimpleBody
 *  soot.jimple.internal.JReturnVoidStmt
 *  soot.tagkit.AbstractHost
 *  soot.tagkit.AnnotationElem
 *  soot.tagkit.AnnotationStringElem
 *  soot.tagkit.AnnotationTag
 *  soot.tagkit.VisibilityAnnotationTag
 *  soot.util.Chain
 *  utils.BaseBodyGenerator
 *  utils.BaseBodyGeneratorFactory
 *  utils.EnumUtils
 *  utils.JimpleUtils
 *  utils.XMLDocumentHolder
 */
package analysis;

import analysis.AOPAnalysis;
import analysis.AOPParser;
import analysis.AnnotationAnalysis;
import analysis.Config;
import analysis.CreateEdge;
import analysis.IOCParser;
import analysis.Implement;
import analysis.SpringAnnotationTag;
import bean.AOPTargetModel;
import bean.AopXMLResultBean;
import bean.AspectModel;
import bean.ConstructorArgBean;
import enums.AdviceEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import mock.GenerateSyntheticClass;
import mock.GenerateSyntheticClassImpl;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.ArrayType;
import soot.Body;
import soot.FastHierarchy;
import soot.Hierarchy;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.internal.JReturnVoidStmt;
import soot.tagkit.AbstractHost;
import soot.tagkit.AnnotationElem;
import soot.tagkit.AnnotationStringElem;
import soot.tagkit.AnnotationTag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.util.Chain;
import utils.BaseBodyGenerator;
import utils.BaseBodyGeneratorFactory;
import utils.EnumUtils;
import utils.JimpleUtils;
import utils.XMLDocumentHolder;

public class CreateEdge {
    public static final Set<String> componentPackages = new LinkedHashSet();
    private static final Logger log = LoggerFactory.getLogger(CreateEdge.class);
    private final AnnotationAnalysis annotationAnalysis = new AnnotationAnalysis();
    private final IOCParser iocParser = new IOCParser();
    private final AOPAnalysis aopAnalysis = new AOPAnalysis();
    private final Set<SootMethod> allBeans = new LinkedHashSet();
    public static final Set<SootClass> allBeansAndInterfaces = new LinkedHashSet();
    public static final Set<SootClass> singletonComponents = new LinkedHashSet();
    public static final Set<SootClass> prototypeComponents = new LinkedHashSet();
    public static final Map<String, SootClass> interfaceToBeans = new LinkedHashMap();
    public final Chain<SootClass> sootClassChain = Scene.v().getApplicationClasses();
    public static final Map<String, AspectModel> aspectModelMap = new LinkedHashMap();
    protected String dummyClassName = "synthetic.method.dummyMainClass";
    public SootMethod projectMainMethod;

    public void initCallGraph(Config config) {
        this.scanAllBeans(config);
        this.aspectAnalysis(config);
        this.dependencyInjectAnalysis();
        this.generateEntryPoints();
    }

    public void clear() {
        AnnotationAnalysis.clear();
        AOPAnalysis.clear();
        AOPParser.clear();
        GenerateSyntheticClassImpl.clear();
        componentPackages.clear();
        allBeansAndInterfaces.clear();
        singletonComponents.clear();
        prototypeComponents.clear();
        interfaceToBeans.clear();
        aspectModelMap.clear();
    }

    public void scanAllBeans(Config config) {
        Set bean_xml_paths = config.bean_xml_paths;
        if (!bean_xml_paths.isEmpty()) {
            Set xmlBeanSootClazzes = this.getXMLBeanSootClazzes(bean_xml_paths);
            for (XmlBeanClazz xmlBeanSootClazz : xmlBeanSootClazzes) {
                for (SootClass anInterface : xmlBeanSootClazz.getSootClass().getInterfaces()) {
                    interfaceToBeans.put(anInterface.getName(), xmlBeanSootClazz.getSootClass());
                }
                interfaceToBeans.put(xmlBeanSootClazz.getSootClass().getName(), xmlBeanSootClazz.getSootClass());
                if (xmlBeanSootClazz.getScope().equals("singleton")) {
                    singletonComponents.add(xmlBeanSootClazz.getSootClass());
                    continue;
                }
                if (!xmlBeanSootClazz.getScope().equals("prototype")) continue;
                prototypeComponents.add(xmlBeanSootClazz.getSootClass());
            }
        }
        XMLDocumentHolder xmlHolder = this.getXMLHolder(bean_xml_paths);
        Map collect = null;
        if (xmlHolder != null) {
            List argConstructors = xmlHolder.getArgConstructors();
            collect = argConstructors.stream().filter(c -> c.getClazzName() != null).collect(Collectors.groupingBy(ConstructorArgBean::getClazzName, Collectors.toList()));
        }
        GenerateSyntheticClassImpl gsc = new GenerateSyntheticClassImpl();
        Collection elementsUnsorted = this.sootClassChain.getElementsUnsorted().stream().sorted(Comparator.comparing(SootClass::getName)).collect(Collectors.toList());
        Iterator iterator2 = elementsUnsorted.iterator();
        LinkedHashSet<SootClass> prototypeInterfaces = new LinkedHashSet<SootClass>();
        while (iterator2.hasNext()) {
            SootClass sootClass = (SootClass)iterator2.next();
            this.allBeans.addAll(this.annotationAnalysis.getAllBeans(sootClass));
            int annotationTag = this.annotationAnalysis.getAllComponents(sootClass);
            if (SpringAnnotationTag.isBean((int)annotationTag)) {
                SootClass implClass = sootClass;
                allBeansAndInterfaces.add(implClass);
                if (SpringAnnotationTag.isMapper((int)annotationTag)) {
                    implClass = gsc.generateMapperImpl(sootClass);
                }
                this.findAllSuperclass(implClass, implClass);
                interfaceToBeans.put(implClass.getName(), implClass);
                if (SpringAnnotationTag.isPrototype((int)annotationTag)) {
                    prototypeComponents.add(implClass);
                    continue;
                }
                singletonComponents.add(implClass);
                continue;
            }
            if (!SpringAnnotationTag.isPrototype((int)annotationTag)) continue;
            prototypeInterfaces.add(sootClass);
        }
        Iterator iteratorMapper = elementsUnsorted.iterator();
        Hierarchy hierarchy = Scene.v().getActiveHierarchy();
        LinkedHashSet<SootClass> databaseModels = new LinkedHashSet<SootClass>();
        while (iteratorMapper.hasNext()) {
            SootClass sootClass = (SootClass)iteratorMapper.next();
            if (!sootClass.isInterface() || !hierarchy.getImplementersOf(sootClass).isEmpty() || sootClass.isPhantom()) continue;
            boolean impl = false;
            for (String mapperPackage : AnnotationAnalysis.mapperPackages) {
                if (!sootClass.getPackageName().startsWith(mapperPackage)) continue;
                databaseModels.add(sootClass);
                impl = true;
                break;
            }
            if (!impl) {
                for (SootClass anInterface : sootClass.getInterfaces()) {
                    if (!anInterface.getPackageName().startsWith("org.springframework.data") && !anInterface.getName().equals("com.baomidou.mybatisplus.core.mapper.BaseMapper")) continue;
                    databaseModels.add(sootClass);
                    impl = true;
                    break;
                }
            }
            if (impl || !sootClass.getName().toLowerCase().endsWith("dao") && !sootClass.getName().toLowerCase().endsWith("mapper") && !sootClass.getName().toLowerCase().endsWith("repository")) continue;
            databaseModels.add(sootClass);
        }
        for (SootClass databaseModel : databaseModels) {
            this.implMapper((GenerateSyntheticClass)gsc, prototypeInterfaces, databaseModel);
        }
        gsc.generateSingletonBeanFactory(singletonComponents, collect);
    }

    private void implMapper(GenerateSyntheticClass gsc, Set<SootClass> prototypeInterfaces, SootClass sootClass) {
        SootClass mapperImplClass = gsc.generateMapperImpl(sootClass);
        interfaceToBeans.put(sootClass.getName(), mapperImplClass);
        allBeansAndInterfaces.add(sootClass);
        if (prototypeInterfaces.contains(sootClass)) {
            prototypeComponents.add(mapperImplClass);
        } else {
            singletonComponents.add(mapperImplClass);
        }
    }

    private void findAllSuperclass(SootClass superclass, SootClass implClass) {
        FastHierarchy fh = Scene.v().getOrMakeFastHierarchy();
        for (SootClass anInterface : superclass.getInterfaces()) {
            allBeansAndInterfaces.add(anInterface);
            SootClass exists = (SootClass)interfaceToBeans.get(anInterface.getName());
            if (exists == null) {
                interfaceToBeans.put(anInterface.getName(), implClass);
                continue;
            }
            if (!fh.canStoreClass(implClass, exists)) continue;
            interfaceToBeans.put(anInterface.getName(), implClass);
        }
        if (superclass.hasSuperclass() && !superclass.getSuperclass().getName().equals("java.lang.Object")) {
            this.findAllSuperclass(superclass.getSuperclass(), implClass);
        }
    }

    public void dependencyInjectAnalysis() {
        for (SootClass sootClass : allBeansAndInterfaces) {
            if (sootClass.getName().equals(Config.SINGLETON_FACTORY_CNAME) || sootClass.getName().startsWith("synthetic.") || sootClass.isInterface()) continue;
            this.iocParser.getIOCObject(sootClass, this.allBeans);
        }
    }

    public void generateEntryPoints() {
        SootMethod psm = this.findMainMethod();
        if (psm == null) {
            SootClass sClass = new SootClass(this.dummyClassName, 1);
            sClass.setSuperclass(Scene.v().getObjectType().getSootClass());
            Scene.v().addClass(sClass);
            sClass.setApplicationClass();
            SootMethod mainMethod = new SootMethod("main", Arrays.asList(ArrayType.v((Type)RefType.v((String)"java.lang.String"), (int)1)), (Type)VoidType.v(), 9);
            sClass.addMethod(mainMethod);
            JimpleBody jimpleBody = this.createJimpleBody(mainMethod);
            mainMethod.setActiveBody((Body)jimpleBody);
            psm = mainMethod;
        }
        for (SootClass controller : AnnotationAnalysis.controllers) {
            this.linkMainAndController(controller, psm);
        }
        this.projectMainMethod = psm;
    }

    private SootMethod findMainMethod() {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        Collection elementsUnsorted = this.sootClassChain.getElementsUnsorted();
        for (SootClass sootClass : elementsUnsorted) {
            List sootMethods = sootClass.getMethods();
            if (sootMethods.size() <= 1) continue;
            for (SootMethod sootMethod : sootMethods) {
                if (!sootMethod.getSubSignature().contains("void main") || !sootMethod.isStatic()) continue;
                for (Unit unit : jimpleUtils.getMethodBody(sootMethod).getUnits()) {
                    if (!unit.toString().contains("SpringApplication")) continue;
                    return sootMethod;
                }
            }
        }
        return null;
    }

    private JimpleBody createJimpleBody(SootMethod method) {
        JimpleBody body = Jimple.v().newBody(method);
        Local frm1 = Jimple.v().newLocal("frm1", (Type)ArrayType.v((Type)RefType.v((String)"java.lang.String"), (int)1));
        body.getLocals().add((Object)frm1);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        units.add((Unit)Jimple.v().newIdentityStmt((Value)frm1, (Value)Jimple.v().newParameterRef((Type)ArrayType.v((Type)RefType.v((String)"java.lang.String"), (int)1), 0)));
        units.add((Unit)Jimple.v().newReturnVoidStmt());
        return body;
    }

    public void linkMainAndController(SootClass controller, SootMethod psm) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        ArrayList<SootMethod> signatures = new ArrayList<SootMethod>();
        SootClass sootClass = AOPParser.proxyMap.getOrDefault(controller.getName(), controller);
        for (SootMethod method : controller.getMethods()) {
            AnnotationTag requestMapping = this.annotationAnalysis.hasSpecialAnnotation((AbstractHost)method);
            if (requestMapping == null) continue;
            if (sootClass == controller) {
                signatures.add(method);
                continue;
            }
            SootMethod proxyMethod = sootClass.getMethodUnsafe(method.getSubSignature());
            if (proxyMethod != null) {
                signatures.add(proxyMethod);
                continue;
            }
            signatures.add(method);
        }
        if (Config.linkSpringCGLIB_CallEntrySyntheticAndRequestMappingMethods.booleanValue()) {
            SootMethod createMethod = new SootMethod(Config.CALL_ENTRY_NAME, null, (Type)VoidType.v(), 1);
            sootClass.addMethod(createMethod);
            JimpleBody jimpleBody = jimpleUtils.createJimpleBody(createMethod, signatures, sootClass.getName());
            createMethod.setActiveBody((Body)jimpleBody);
            SootMethod constructor = BaseBodyGenerator.getAnyConstructorUnsafe((SootClass)sootClass, (boolean)true);
            if (constructor == null) {
                return;
            }
            if (Config.linkMainAndController.booleanValue()) {
                this.processMain(psm, sootClass.getShortName(), sootClass.getName(), constructor.toString(), createMethod.toString());
            }
        } else {
            int i = 0;
            for (SootMethod signature : signatures) {
                SootMethod createMethod = new SootMethod(String.format("%s_%d_%s", Config.CALL_ENTRY_NAME, i++, signature.getName()), null, (Type)VoidType.v(), 8);
                sootClass.addMethod(createMethod);
                JimpleBody jimpleBody = jimpleUtils.createJimpleBody(createMethod, Collections.singletonList(signature), sootClass.getName());
                createMethod.setActiveBody((Body)jimpleBody);
            }
        }
    }

    public void aspectAnalysis(Config config) {
        AOPParser aopParser = new AOPParser();
        LinkedHashSet allComponents = new LinkedHashSet(interfaceToBeans.values());
        List allAspects = aopParser.getAllAspects(allComponents);
        ArrayList<AspectModel> allAdvices = new ArrayList<AspectModel>();
        for (AspectModel aspect : allAspects) {
            String expression;
            AnnotationStringElem ase;
            VisibilityAnnotationTag annotationTags;
            LinkedHashMap<String, String> pcutmethod = new LinkedHashMap<String, String>();
            for (SootMethod method : aspect.getSootClass().getMethods()) {
                annotationTags = (VisibilityAnnotationTag)method.getTag("VisibilityAnnotationTag");
                if (annotationTags == null || annotationTags.getAnnotations() == null) continue;
                for (AnnotationTag annotation : annotationTags.getAnnotations()) {
                    if (!annotation.getType().contains("Pointcut")) continue;
                    for (AnnotationElem elem : annotation.getElems()) {
                        if (!(elem instanceof AnnotationStringElem)) continue;
                        ase = (AnnotationStringElem)elem;
                        expression = ase.getValue();
                        pcutmethod.put(method.getName(), expression);
                    }
                }
            }
            block4: for (SootMethod aspectMethod : aspect.getSootClass().getMethods()) {
                annotationTags = (VisibilityAnnotationTag)aspectMethod.getTag("VisibilityAnnotationTag");
                if (annotationTags == null) continue;
                for (AnnotationTag annotation : annotationTags.getAnnotations()) {
                    if (!annotation.getType().contains("Lorg/aspectj/lang/annotation/")) continue;
                    if (annotation.getType().contains("Pointcut") || annotation.getType().contains("AfterThrowing")) continue block4;
                    for (AnnotationElem elem : annotation.getElems()) {
                        if (!(elem instanceof AnnotationStringElem) || !(ase = (AnnotationStringElem)elem).getName().equals("value") && !ase.getName().equals("pointcut")) continue;
                        expression = ase.getValue();
                        for (String s : ((HashMap)pcutmethod).keySet()) {
                            if (!expression.contains(s)) continue;
                            expression = expression.replace(s + "()", (CharSequence)((HashMap)pcutmethod).get(s));
                        }
                        if (expression.contains("execution") || expression.contains("within") || expression.contains("args") || expression.contains("@annotation") || expression.contains("@within")) {
                            aopParser.processDiffAopExp(expression, aspectMethod);
                        }
                        if (EnumUtils.getEnumObject((Object)annotation.getType()) == null) continue;
                        AspectModel adviceModel = this.getAspectModelInstance(aspect, expression, annotation, aspectMethod);
                        if (!allAdvices.contains(adviceModel)) {
                            allAdvices.add(adviceModel);
                        }
                        Collections.sort(allAdvices);
                    }
                }
            }
        }
        allAdvices.addAll(this.xmlaspectAnalysis(config, aopParser));
        aopParser.addAdviceToTarget(allAdvices);
        for (AOPTargetModel aopTargetModel : AOPParser.modelMap.values()) {
            this.aopAnalysis.processWeave(aopTargetModel);
        }
    }

    private XMLDocumentHolder getXMLHolder(Set<String> xmlpaths) {
        if (xmlpaths.isEmpty()) {
            return null;
        }
        XMLDocumentHolder holder = new XMLDocumentHolder();
        for (String xmlpath : xmlpaths) {
            Document document = holder.getDocument(xmlpath);
            if (document == null) continue;
            holder.addElements(document);
            holder.hasArgConstructorBean(xmlpath, document);
        }
        return holder;
    }

    public Set<XmlBeanClazz> getXMLBeanSootClazzes(Set<String> xmlpaths) {
        XMLDocumentHolder holder = this.getXMLHolder(xmlpaths);
        if (holder == null) {
            return null;
        }
        Map allClassMap = holder.getAllClassMap();
        LinkedHashSet<XmlBeanClazz> res = new LinkedHashSet<XmlBeanClazz>();
        for (String value : allClassMap.values()) {
            String[] split = value.split(";");
            SootClass xmlsootclass = JimpleUtils.getClassUnsafe((String)split[0]);
            if (xmlsootclass == null) continue;
            XmlBeanClazz xmlBeanClazz = new XmlBeanClazz(xmlsootclass, split[1]);
            res.add(xmlBeanClazz);
        }
        return res;
    }

    private List<AspectModel> xmlaspectAnalysis(Config config, AOPParser aopParser) {
        XMLDocumentHolder holder = new XMLDocumentHolder();
        ArrayList<AspectModel> allAdvices = new ArrayList<AspectModel>();
        Set bean_xml_paths = config.bean_xml_paths;
        if (bean_xml_paths.isEmpty()) {
            return allAdvices;
        }
        for (String bean_xml_path : bean_xml_paths) {
            Document document = holder.getDocument(bean_xml_path);
            if (document == null) continue;
            holder.addElements(document);
            List beanList = holder.processAopElements(document);
            LinkedHashSet<String> aopClasses = new LinkedHashSet<String>();
            for (AopXMLResultBean aopXMLResultBean : beanList) {
                aopClasses.add(aopXMLResultBean.getAopclass());
            }
            for (String aopclass : aopClasses) {
                SootClass sootClass = JimpleUtils.getClassUnsafe((String)aopclass);
                if (sootClass == null) continue;
                for (SootMethod method : sootClass.getMethods()) {
                    for (AopXMLResultBean aopXMLResultBean : beanList) {
                        if (!method.getName().equals(aopXMLResultBean.getAopmethod())) continue;
                        aopParser.processDiffAopExp(aopXMLResultBean.getExper(), method);
                        AspectModel aspectModel = this.copyXmlBeanToAspectModel(aopXMLResultBean, sootClass, method);
                        allAdvices.add(aspectModel);
                        Collections.sort(allAdvices);
                    }
                }
            }
        }
        return allAdvices;
    }

    private AspectModel getAspectModelInstance(AspectModel aspect, String expression, AnnotationTag annotation, SootMethod aspectMethod) {
        AspectModel adviceModel;
        if (aspectModelMap.containsKey(aspectMethod.toString())) {
            adviceModel = (AspectModel)aspectModelMap.get(aspectMethod.toString());
            adviceModel.addPointcutExpressions(expression);
        } else {
            adviceModel = new AspectModel();
            adviceModel.setOrder(aspect.getOrder());
            adviceModel.setSootClass(aspect.getSootClass());
            adviceModel.addPointcutExpressions(expression);
            adviceModel.setSootMethod(aspectMethod);
            adviceModel.setAnnotation(EnumUtils.getEnumObject((Object)annotation.getType()));
            aspectModelMap.put(aspectMethod.toString(), adviceModel);
        }
        return adviceModel;
    }

    private AspectModel copyXmlBeanToAspectModel(AopXMLResultBean aopXMLResultBean, SootClass sootClass, SootMethod sootMethod) {
        AspectModel adviceModel;
        if (aspectModelMap.containsKey(sootMethod.toString())) {
            adviceModel = (AspectModel)aspectModelMap.get(sootMethod.toString());
            adviceModel.addPointcutExpressions(aopXMLResultBean.getExper());
        } else {
            adviceModel = new AspectModel();
            adviceModel.setOrder(aopXMLResultBean.getOrder());
            adviceModel.setSootClass(sootClass);
            adviceModel.addPointcutExpressions(aopXMLResultBean.getExper());
            adviceModel.setSootMethod(sootMethod);
            List collect = Arrays.stream(AdviceEnum.values()).filter(x -> x.getAnnotationClassName().toLowerCase().contains(aopXMLResultBean.getActivetype())).collect(Collectors.toList());
            adviceModel.setAnnotation(collect != null ? (AdviceEnum)collect.get(0) : AdviceEnum.AOP_BEFORE);
            aspectModelMap.put(sootMethod.toString(), adviceModel);
        }
        return adviceModel;
    }

    public void processMain(SootMethod method, String objName, String objType, String initSign, String runSign) {
        JimpleUtils jimpleUtils = Implement.jimpleUtils;
        JimpleBody body = (JimpleBody)jimpleUtils.getMethodBody(method);
        Local localModel = jimpleUtils.addLocalVar(objName, objType, (Body)body);
        BaseBodyGenerator units = BaseBodyGeneratorFactory.get((Body)body);
        units.getUnits().removeIf(unit -> unit instanceof JReturnVoidStmt);
        jimpleUtils.createAssignStmt(localModel, objType, units);
        units.add(jimpleUtils.specialCallStatement(localModel, initSign, units));
        units.add(jimpleUtils.virtualCallStatement(localModel, runSign, units));
        jimpleUtils.addVoidReturnStmt(units);
    }
}

