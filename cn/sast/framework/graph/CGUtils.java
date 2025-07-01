package cn.sast.framework.graph;

import cn.sast.api.config.ExtSettings;
import cn.sast.api.report.Counter;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.util.Chain;
import soot.util.queue.QueueReader;

import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public final class CGUtils {
    public static final CGUtils INSTANCE = new CGUtils();
    private static final Counter<SootClass> missClasses = new Counter<>();
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CGUtils.class);

    private CGUtils() {
    }

    public Counter<SootClass> getMissClasses() {
        return missClasses;
    }

    public void rewriteJimpleBodyAfterCG() {
        Iterator<SootClass> all = Scene.v().getClasses().snapshotIterator();
        // Original Kotlin coroutine logic removed - needs manual reimplementation
    }

    public void makeSpuriousMethodFromInvokeExpr() {
        Chain<SootClass> chain = Scene.v().getApplicationClasses();
        List<SootClass> app = List.copyOf(chain);
        
        for (SootClass appSc : app) {
            if (appSc.isPhantom()) continue;
            
            List<SootMethod> methods = List.copyOf(appSc.getMethods());
            for (SootMethod sm : methods) {
                if (!sm.isConcrete() || sm.getSource() == null) continue;
                
                try {
                    Body body = sm.retrieveActiveBody();
                    if (body == null) continue;
                    
                    for (Unit u : body.getUnits()) {
                        if (!(u instanceof Stmt stmt)) continue;
                        
                        if (stmt.containsInvokeExpr()) {
                            SootMethod method = stmt.getInvokeExpr().getMethod();
                            // Original processing logic here
                        }
                        
                        if (stmt.containsFieldRef()) {
                            // Original field processing logic here
                        }
                    }
                } catch (RuntimeException ignored) {
                }
            }
        }
    }

    private void forceAddCgEdge(CallGraph callGraph, SootMethod src, Stmt srcUnit, InvokeExpr ie) {
        if (srcUnit.getInvokeExpr() instanceof DynamicInvokeExpr) {
            return;
        }
        SootMethod tgt = ie.getMethod();
        callGraph.addEdge(new Edge(src, srcUnit, tgt));
    }

    public void addCallEdgeForPhantomMethods() {
        Scene scene = Scene.v();
        CallGraph cg = scene.getCallGraph();
        ReachableMethods reachableMethods = scene.getReachableMethods();
        reachableMethods.update();
        
        QueueReader<Edge> queueReader = reachableMethods.listener();
        while (queueReader.hasNext()) {
            SootMethod src = queueReader.next().method();
            if (!src.hasActiveBody()) continue;
            
            for (Unit u : src.getActiveBody().getUnits()) {
                Stmt srcUnit = (Stmt) u;
                if (!srcUnit.containsInvokeExpr()) continue;
                
                InvokeExpr ie = srcUnit.getInvokeExpr();
                if (cg.edgesOutOf(u).hasNext()) continue;
                
                SootClass tgtClass = ie.getMethodRef().getDeclaringClass();
                if (tgtClass != null && tgtClass.isPhantom() && !scene.isExcluded(tgtClass)) {
                    if (!tgtClass.getName().startsWith("soot.dummy")) {
                        missClasses.count(tgtClass);
                    }
                }
                forceAddCgEdge(cg, src, srcUnit, ie);
            }
        }
    }

    public void flushMissedClasses(@NotNull IResDirectory outputDir) {
        IResFile out = outputDir.resolve("phantom_dependence_classes.txt").toFile();
        if (missClasses.isNotEmpty()) {
            logger.warn(() -> "Incomplete analysis! The num of " + missClasses.size() + 
                " dependent classes cannot be found here. check: " + out.getAbsolute().getNormalize());
            missClasses.writeResults(out);
        } else {
            Files.deleteIfExists(out.getPath());
        }
    }

    public void removeInvalidMethodBody(@NotNull Scene scene) {
        for (SootClass sc : scene.getClasses()) {
            for (SootMethod sm : sc.getMethods()) {
                if (!sm.hasActiveBody()) continue;
                Body body = sm.getActiveBody();
                if (!body.getUnits().isEmpty()) continue;
                sm.setActiveBody(null);
                sm.setPhantom(true);
            }
        }
    }

    public void fixInvalidInterface(@NotNull Scene scene) {
        for (SootClass sc : scene.getClasses()) {
            for (SootClass i : List.copyOf(sc.getInterfaces())) {
                if (i.isInterface()) continue;
                logger.warn(() -> i + " is not a interface. but contains in interfaces of " + sc);
                try {
                    sc.removeInterface(i);
                } catch (Exception e) {
                    logger.warn(e, () -> "remove interface " + i + " from " + sc + " failed");
                }
            }
        }
    }

    public void removeLargeClasses(@NotNull Scene scene) {
        int skipClassByMaximumMethods = ExtSettings.INSTANCE.getSkip_large_class_by_maximum_methods();
        int skipClassByMaximumFields = ExtSettings.INSTANCE.getSkip_large_class_by_maximum_fields();
        
        if (skipClassByMaximumMethods <= 0 && skipClassByMaximumFields <= 0) return;
        
        for (SootClass sc : List.copyOf(scene.getClasses())) {
            boolean removeIt = false;
            
            if (skipClassByMaximumMethods > 0 && sc.getMethodCount() > skipClassByMaximumMethods) {
                removeIt = true;
                logger.warn(() -> "Remove large class: " + sc + 
                    " which is too large. Limit the class methods count should less than " + skipClassByMaximumMethods);
            }
            
            if (skipClassByMaximumFields > 0 && sc.getFieldCount() > skipClassByMaximumFields) {
                removeIt = true;
                logger.warn(() -> "Remove big class: " + sc + 
                    " which is too large. Limit the class fields count should less than " + skipClassByMaximumFields);
            }
            
            if (removeIt) {
                scene.removeClass(sc);
            }
        }
    }

    public void fixScene(@NotNull Scene scene) {
        removeInvalidMethodBody(scene);
        fixInvalidInterface(scene);
    }

    public SootMethod createSootMethod(@NotNull String name, @NotNull List<? extends Type> argsTypes, 
            @NotNull Type returnType, @NotNull SootClass declaringClass, 
            @NotNull JimpleBody graphBody, boolean isStatic) {
        SootMethod sootMethod = new SootMethod(name, argsTypes, returnType, isStatic ? 8 : 0);
        declaringClass.addMethod(sootMethod);
        sootMethod.setActiveBody(graphBody);
        return sootMethod;
    }

    public SootClass getOrCreateClass(@NotNull Scene scene, @NotNull String className) {
        SootClass mainClass = scene.getSootClassUnsafe(className, false);
        if (mainClass == null) {
            mainClass = scene.makeSootClass(className);
            mainClass.setResolvingLevel(3);
            scene.addClass(mainClass);
        }
        return mainClass;
    }

    public SootClass createDummyMain(@NotNull Scene scene, @NotNull String dummyClassName, @NotNull String methodName) {
        Jimple jimple = Jimple.v();
        SootClass dummyClass = getOrCreateClass(scene, dummyClassName);
        dummyClass.setApplicationClass();
        
        JimpleBody body = jimple.newBody();
        body.getUnits().add(jimple.newNopStmt());
        
        createSootMethod(methodName, List.of(), VoidType.v(), dummyClass, body, false);
        return dummyClass;
    }
}
