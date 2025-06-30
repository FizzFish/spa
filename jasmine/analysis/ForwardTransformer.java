/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  analysis.ForwardTransformer
 *  com.alibaba.fastjson.JSONObject
 *  soot.Local
 *  soot.MethodOrMethodContext
 *  soot.PointsToAnalysis
 *  soot.Scene
 *  soot.SceneTransformer
 *  soot.SootMethod
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.jimple.toolkits.callgraph.Edge
 *  soot.jimple.toolkits.callgraph.ReachableMethods
 *  soot.util.queue.QueueReader
 */
package analysis;

import com.alibaba.fastjson.JSONObject;
import java.util.LinkedHashSet;
import java.util.Map;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.PointsToAnalysis;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.util.queue.QueueReader;

public class ForwardTransformer
extends SceneTransformer {
    public static String jarLoc = null;
    public static CallGraph cg = null;

    public ForwardTransformer(String jarLoc) {
        ForwardTransformer.jarLoc = jarLoc;
    }

    protected void internalTransform(String phaseName, Map<String, String> map) {
        cg = Scene.v().getCallGraph();
        int count = 0;
        int clintnum = 0;
        QueueReader iterator2 = cg.listener();
        while (iterator2.hasNext()) {
            Edge edge = (Edge)iterator2.next();
            JSONObject jsonObject = new JSONObject();
            try {
                if (!edge.getSrc().method().toString().contains("com.example") && !edge.getTgt().method().toString().contains("com.example") && !edge.getTgt().method().toString().contains("synthetic.method") && !edge.getSrc().method().toString().contains("synthetic.method")) continue;
                jsonObject.put("srcMethod", (Object)edge.getSrc().method().toString());
                jsonObject.put("tgtMethod", (Object)edge.getTgt().method().toString());
                System.out.println(jsonObject);
                ++count;
                if (!edge.getSrc().method().toString().contains("<clinit>") && !edge.getTgt().method().toString().contains("<clinit>")) continue;
                ++clintnum;
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        for (SootMethod modelFourServiceImpl : Scene.v().getSootClass("FieldFlow").getMethods()) {
            if (!modelFourServiceImpl.hasActiveBody()) continue;
            for (Local local : modelFourServiceImpl.getActiveBody().getLocals()) {
                System.out.println(local);
                PointsToAnalysis points = Scene.v().getPointsToAnalysis();
                System.out.println(points.reachingObjects(local));
            }
        }
        JSONObject jsonObject = new JSONObject();
        ReachableMethods reachableMethods = Scene.v().getReachableMethods();
        System.out.println("total reachableMethods : " + reachableMethods.size());
        QueueReader methodIterator = reachableMethods.listener();
        LinkedHashSet<String> methods = new LinkedHashSet<String>();
        while (methodIterator.hasNext()) {
            MethodOrMethodContext methodOrMethodContext = (MethodOrMethodContext)methodIterator.next();
            if (!methodOrMethodContext.method().toString().contains("com.example") || methodOrMethodContext.method().getName().contains("synthetic")) continue;
            methods.add(methodOrMethodContext.method().toString());
        }
        System.out.println("real CG edge: " + count);
        System.out.println("clint edge: " + clintnum);
        jsonObject.put("ReachableMethods", methods);
        System.out.println("reachable Method : " + methods.size());
        System.out.println("cg size:" + cg.size());
    }
}

