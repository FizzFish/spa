/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.InfoflowSolverRefCnt
 *  heros.solver.PathEdge
 *  soot.Unit
 *  soot.jimple.infoflow.collect.MyConcurrentHashMap
 *  soot.jimple.infoflow.data.Abstraction
 *  soot.jimple.infoflow.problems.AbstractInfoflowProblem
 *  soot.jimple.infoflow.solver.executors.InterruptableExecutor
 *  soot.jimple.infoflow.solver.fastSolver.InfoflowSolver
 */
package cn.sast.dataflow.infoflow.svfa;

import heros.solver.PathEdge;
import soot.Unit;
import soot.jimple.infoflow.collect.MyConcurrentHashMap;
import soot.jimple.infoflow.data.Abstraction;
import soot.jimple.infoflow.problems.AbstractInfoflowProblem;
import soot.jimple.infoflow.solver.executors.InterruptableExecutor;
import soot.jimple.infoflow.solver.fastSolver.InfoflowSolver;

public class InfoflowSolverRefCnt
extends InfoflowSolver {
    public InfoflowSolverRefCnt(AbstractInfoflowProblem problem, InterruptableExecutor executor) {
        super(problem, executor);
    }

    public void cleanup() {
        this.jumpFunctions = new MyConcurrentHashMap();
        this.incoming.clear();
        this.endSummary.clear();
        if (this.ffCache != null) {
            this.ffCache.invalidate();
        }
    }

    public Abstraction addFunction(PathEdge<Unit, Abstraction> edge) {
        return (Abstraction)this.jumpFunctions.putIfAbsent(edge, (Object)((Abstraction)edge.factAtTarget()));
    }
}

