package cn.sast.dataflow.infoflow.svfa;

import soot.SootMethod;
import soot.Unit;
import soot.jimple.infoflow.collect.MyConcurrentHashMap;
import soot.jimple.infoflow.problems.AbstractInfoflowProblem;
import soot.jimple.toolkits.ide.icfg.BiDiInterproceduralCFG;
import soot.util.queue.ChunkedQueue;
import soot.util.queue.QueueReader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public final class SparseInfoflowSolverKt {

    @NotNull
    public static <M, N> Set<N> getGoThrough(
            @NotNull BiDiInterproceduralCFG<N, M> cfg, 
            N from, 
            N to, 
            @NotNull Set<? extends N> skipNodes) {
        
        if (from.equals(to)) {
            return Set.of(from);
        }

        Queue<RefCntUnit> workList = new LinkedList<>();
        RefCntUnit startNode = new RefCntUnit(from, 1);
        workList.add(startNode);
        
        Map<RefCntUnit, RefCntUnit> set = new HashMap<>();
        set.put(startNode, startNode);

        while (!workList.isEmpty()) {
            RefCntUnit cur = workList.poll();
            N curNode = cur.getU();
            
            if (!skipNodes.contains(curNode)) {
                for (N succ : cfg.getSuccsOf(curNode)) {
                    RefCntUnit key = new RefCntUnit(succ, 1);
                    RefCntUnit next = set.computeIfAbsent(key, k -> k);
                    
                    if (next == key && !succ.equals(to)) {
                        workList.offer(next);
                    }
                    next.add(cur);
                }
            }
            cur.dec();
        }

        List<N> result = new ArrayList<>();
        for (RefCntUnit unit : set.values()) {
            if (unit.getCnt() != 0) {
                result.add(unit.getU());
            }
        }
        return new HashSet<>(result);
    }

    @NotNull
    public static Set<Unit> getReachSet(
            @NotNull BiDiInterproceduralCFG<Unit, SootMethod> icfg, 
            @NotNull Unit target) {
        
        ChunkedQueue reaches = new ChunkedQueue();
        Set<Unit> reachSet = new HashSet<>();
        reachSet.add(target);
        
        QueueReader reader = reaches.reader();
        reachSet.forEach(u -> reaches.add(u));
        
        while (reader.hasNext()) {
            for (Unit s : icfg.getSuccsOf(reader.next())) {
                if (reachSet.add(s)) {
                    reaches.add(s);
                }
            }
        }
        return reachSet;
    }

    @NotNull
    public static MyConcurrentHashMap<Unit, Set<Unit>> getActivationUnitsToCallSites(
            @NotNull AbstractInfoflowProblem problem) throws NoSuchFieldException, IllegalAccessException {
        
        Field field = AbstractInfoflowProblem.class.getDeclaredField("activationUnitsToCallSites");
        field.setAccessible(true);
        return (MyConcurrentHashMap<Unit, Set<Unit>>) field.get(problem);
    }
}
