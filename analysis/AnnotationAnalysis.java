/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.AnnotationAnalysis
 *  analysis.CreateEdge
 *  analysis.SpringAnnotationTag
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.Type
 *  soot.tagkit.AbstractHost
 *  soot.tagkit.AnnotationArrayElem
 *  soot.tagkit.AnnotationElem
 *  soot.tagkit.AnnotationStringElem
 *  soot.tagkit.AnnotationTag
 *  soot.tagkit.Tag
 *  soot.tagkit.VisibilityAnnotationTag
 *  soot.util.Chain
 *  utils.JimpleUtils
 */
package analysis;

import analysis.CreateEdge;
import analysis.SpringAnnotationTag;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.tagkit.AbstractHost;
import soot.tagkit.AnnotationArrayElem;
import soot.tagkit.AnnotationElem;
import soot.tagkit.AnnotationStringElem;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.util.Chain;
import utils.JimpleUtils;

/*
 * Exception performing whole class analysis ignored.
 */
public class AnnotationAnalysis {
    private static volatile AnnotationAnalysis INSTANCE = null;
    public static List<Type> autoMethodParams = new ArrayList();
    public static Set<String> mapperPackages = new LinkedHashSet();
    public static Set<SootClass> controllers = new LinkedHashSet();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AnnotationAnalysis getInstance() {
        if (INSTANCE != null) return INSTANCE;
        Class<AnnotationAnalysis> clazz = AnnotationAnalysis.class;
        synchronized (AnnotationAnalysis.class) {
            if (INSTANCE != null) return INSTANCE;
            INSTANCE = new AnnotationAnalysis();
            // ** MonitorExit[var0] (shouldn't be in output)
            return INSTANCE;
        }
    }

    public Chain<SootField> getClassFields(String className) {
        SootClass sootClass = Scene.v().getSootClass(className);
        return sootClass.getFields();
    }

    public List<Tag> getFieldTags(SootField field) {
        return field.getTags();
    }

    public SootField getFieldWithSpecialAnnos(SootField field, SootMethod initMethod, boolean ambiguous) {
        List fieldTags = this.getFieldTags(field);
        for (Tag fieldTag : fieldTags) {
            String strtag = fieldTag.toString();
            if (!strtag.contains("Autowired") && !strtag.contains("Qualifier") && !strtag.contains("Resource") && !strtag.contains("Inject")) continue;
            return field;
        }
        if (autoMethodParams.contains(field.getType())) {
            return field;
        }
        if (!ambiguous && initMethod.getParameterTypes().contains(field.getType())) {
            return field;
        }
        return null;
    }

    public List<Type> getParamOfAutoWiredMethod(SootMethod method) {
        VisibilityAnnotationTag methodTag = (VisibilityAnnotationTag)method.getTag("VisibilityAnnotationTag");
        List parameterTypes = null;
        if (methodTag != null) {
            for (AnnotationTag annotation : methodTag.getAnnotations()) {
                if (!annotation.getType().contains("Autowired")) continue;
                parameterTypes = method.getParameterTypes();
                break;
            }
        }
        return parameterTypes;
    }

    public void findComponents(SootClass ApplicationClass) {
        AnnotationTag annotationScan = this.hasSpecialAnnotation((AbstractHost)ApplicationClass);
        if (annotationScan != null) {
            for (AnnotationElem elem : annotationScan.getElems()) {
                if (!(elem instanceof AnnotationArrayElem) || !elem.getName().equals("basePackages")) continue;
                AnnotationArrayElem arrayElem = (AnnotationArrayElem)elem;
                for (AnnotationElem value : arrayElem.getValues()) {
                    if (!(value instanceof AnnotationStringElem)) continue;
                    AnnotationStringElem stringElem = (AnnotationStringElem)value;
                    CreateEdge.componentPackages.add(stringElem.getValue());
                }
            }
        }
    }

    public Integer getAllComponents(SootClass sootClass) {
        VisibilityAnnotationTag annotationTags = (VisibilityAnnotationTag)sootClass.getTag("VisibilityAnnotationTag");
        int flag = 0;
        if (annotationTags != null) {
            block20: for (AnnotationTag annotation : annotationTags.getAnnotations()) {
                switch (annotation.getType()) {
                    case "Lorg/springframework/web/bind/annotation/RestController;": 
                    case "Lorg/springframework/web/bind/annotation/Controller;": 
                    case "Lorg/springframework/stereotype/Controller;": {
                        controllers.add(sootClass);
                        if (SpringAnnotationTag.isBean((int)flag)) break;
                        ++flag;
                        break;
                    }
                    case "Lorg/apache/ibatis/annotations/Mapper;": 
                    case "Lorg/beetl/sql/core/annotatoin/SqlResource;": {
                        if (!SpringAnnotationTag.isMapper((int)flag)) {
                            flag += 4;
                        }
                    }
                    case "Lorg/springframework/stereotype/Component;": 
                    case "Lorg/springframework/context/annotation/Configuration;": 
                    case "Lorg/springframework/stereotype/Repository;": 
                    case "Lorg/springframework/stereotype/Service;": {
                        if (SpringAnnotationTag.isBean((int)flag)) break;
                        ++flag;
                        break;
                    }
                    case "Lorg/springframework/context/annotation/Scope;": {
                        for (AnnotationElem elem : annotation.getElems()) {
                            AnnotationStringElem stringElem;
                            if (!(elem instanceof AnnotationStringElem) || !(stringElem = (AnnotationStringElem)elem).getValue().equals("prototype") || SpringAnnotationTag.isPrototype((int)flag)) continue;
                            flag += 2;
                        }
                        continue block20;
                    }
                    case "Lorg/mybatis/spring/annotation/MapperScan;": {
                        for (AnnotationElem elem : annotation.getElems()) {
                            if (!(elem instanceof AnnotationArrayElem)) continue;
                            AnnotationArrayElem arrayElem = (AnnotationArrayElem)elem;
                            for (AnnotationElem value : arrayElem.getValues()) {
                                if (!(value instanceof AnnotationStringElem)) continue;
                                AnnotationStringElem asElem = (AnnotationStringElem)value;
                                mapperPackages.add(asElem.getValue());
                            }
                        }
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public Set<SootMethod> getAllBeans(SootClass sootClass) {
        LinkedHashSet<SootMethod> allBeans = new LinkedHashSet<SootMethod>();
        for (SootMethod method : sootClass.getMethods()) {
            VisibilityAnnotationTag annotationTags = (VisibilityAnnotationTag)method.getTag("VisibilityAnnotationTag");
            if (annotationTags == null) continue;
            for (AnnotationTag annotation : annotationTags.getAnnotations()) {
                if (!annotation.getType().equals("Lorg/springframework/context/annotation/Bean;")) continue;
                allBeans.add(method);
                SootClass bean = JimpleUtils.getClassUnsafe((Type)method.getReturnType());
                if (bean == null || !bean.isApplicationClass()) continue;
                CreateEdge.singletonComponents.add(bean);
                CreateEdge.interfaceToBeans.put(bean.getName(), bean);
            }
        }
        return allBeans;
    }

    public AnnotationTag hasSpecialAnnotation(AbstractHost host) {
        VisibilityAnnotationTag annotationTags = (VisibilityAnnotationTag)host.getTag("VisibilityAnnotationTag");
        if (annotationTags == null) {
            return null;
        }
        for (AnnotationTag annotation : annotationTags.getAnnotations()) {
            if (!AnnotationAnalysis.satisfyAnnotation((String)annotation.getType())) continue;
            return annotation;
        }
        return null;
    }

    private static boolean satisfyAnnotation(String type) {
        switch (type) {
            case "Lorg/springframework/web/bind/annotation/RequestMapping;": 
            case "Lorg/springframework/web/bind/annotation/PostMapping;": 
            case "Lorg/springframework/web/bind/annotation/GetMapping;": 
            case "Lorg/springframework/web/bind/annotation/PatchMapping;": 
            case "Lorg/springframework/web/bind/annotation/DeleteMapping;": 
            case "Lorg/springframework/web/bind/annotation/PutMapping;": 
            case "Lorg/springframework/web/bind/annotation/RestController;": 
            case "Lorg/springframework/web/bind/annotation/Controller;": 
            case "Lorg/springframework/stereotype/Controller;": {
                return true;
            }
        }
        return false;
    }

    public static void clear() {
        INSTANCE = null;
        autoMethodParams.clear();
        mapperPackages.clear();
        controllers.clear();
    }
}

