package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.AP;
import cn.sast.dataflow.infoflow.svfa.CacheFlowGuide;
import cn.sast.dataflow.infoflow.svfa.SparseInfoflowSolverKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.IfStmt;
import soot.jimple.infoflow.data.Abstraction;
import soot.jimple.infoflow.problems.AbstractInfoflowProblem;
import soot.jimple.infoflow.solver.cfg.BackwardsInfoflowCFG;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.infoflow.solver.executors.InterruptableExecutor;
import soot.jimple.infoflow.solver.fastSolver.FastSolverLinkedNode;
import soot.jimple.infoflow.solver.fastSolver.IFDSSolver;
import soot.jimple.infoflow.solver.fastSolver.InfoflowSolver;
import soot.jimple.toolkits.ide.icfg.BiDiInterproceduralCFG;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.UnitGraph;

public class SparseInfoFlowSolver extends InfoflowSolver {
    private final CacheFlowGuide sparseCache;

    public SparseInfoFlowSolver(@NotNull AbstractInfoflowProblem problem, @Nullable InterruptableExecutor executor) {
        super(problem, executor);
        this.sparseCache = new CacheFlowGuide(
            problem.getManager().getConfig().getImplicitFlowMode().trackControlFlowDependencies()
        );
    }

    private CacheFlowGuide getSparseCache() {
        return sparseCache;
    }

    private boolean isForward() {
        return !(this.icfg instanceof BackwardsInfoflowCFG);
    }

    private boolean isBackward() {
        return this.icfg instanceof BackwardsInfoflowCFG;
    }

    @Override
    protected void propagate(
        @NotNull Abstraction sourceVal,
        @NotNull Unit target,
        @NotNull Abstraction targetVal,
        @Nullable Unit relatedCallSite,
        boolean isUnbalancedReturn,
        @NotNull IFDSSolver.ScheduleTarget scheduleTarget
    ) {
        if (targetVal.getAccessPath().getPlainValue() == null || 
            targetVal.getAccessPath().equals(((Abstraction)this.zeroValue).getAccessPath())) {
            super.propagate(sourceVal, target, targetVal, relatedCallSite, isUnbalancedReturn, scheduleTarget);
            return;
        }

        SootMethod method = this.icfg.getMethodOf(target);
        DirectedGraph graph = this.icfg.getOrCreateUnitGraph(method);
        UnitGraph unitGraph = (UnitGraph) graph;
        AP ap = AP.Companion.get(targetVal);
        
        Set<Unit> uses = Set.copyOf(this.isBackward() 
            ? getSparseCache().getSuccess(false, ap, target, unitGraph)
            : getSparseCache().getSuccess(true, ap, target, unitGraph));

        List<Pair<Unit, Abstraction>> propagates = new ArrayList<>();
        for (Unit use : uses) {
            Abstraction toVal = targetVal;
            
            if (!targetVal.isAbstractionActive() && isForward()) {
                Set<Unit> throughUnits = SparseInfoflowSolverKt.getGoThrough(icfg, target, use, null);
                throughUnits.remove(use);
                
                if (throughUnits.contains(targetVal.getActivationUnit())) {
                    toVal = targetVal.getActiveCopy();
                }
                
                Set<Unit> callSites = SparseInfoflowSolverKt.getActivationUnitsToCallSites(getTabulationProblem())
                    .get(targetVal.getActivationUnit());
                
                if (callSites != null && callSites.stream().anyMatch(throughUnits::contains)) {
                    toVal = targetVal.getActiveCopy();
                }
            }
            propagates.add(new Pair<>(use, toVal));
        }

        for (Pair<Unit, Abstraction> pair : propagates) {
            Unit useUnit = pair.getFirst();
            Abstraction toVal = pair.getSecond();
            Unit turnUnit = toVal.getTurnUnit();
            
            if (turnUnit != null) {
                Set<Unit> throughUnits = SparseInfoflowSolverKt.getGoThrough(
                    icfg, target, useUnit, Set.of(turnUnit)
                );
                if (!throughUnits.contains(useUnit) && 
                    (!icfg.isCallStmt(useUnit) || !sourceVal.equals(targetVal))) {
                    continue;
                }
            }

            if (isBackward()) {
                IInfoflowCFG.UnitContainer dominator = getTabulationProblem()
                    .getManager().getICFG().getDominatorOf(useUnit);
                if (dominator.getUnit() != null && dominator.getUnit() instanceof IfStmt) {
                    Abstraction newAbs = toVal.deriveNewAbstractionWithDominator(dominator.getUnit());
                    super.propagate(sourceVal, useUnit, newAbs, relatedCallSite, isUnbalancedReturn, scheduleTarget);
                }
            }
            super.propagate(sourceVal, useUnit, toVal, relatedCallSite, isUnbalancedReturn, scheduleTarget);
        }
    }

    @Override
    public @NotNull String toString() {
        return isForward() ? "forward" : "backward";
    }
}
