/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.AP
 *  cn.sast.dataflow.infoflow.svfa.CacheFlowGuide
 *  cn.sast.dataflow.infoflow.svfa.SparseInfoFlowSolver
 *  cn.sast.dataflow.infoflow.svfa.SparseInfoflowSolverKt
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootMethod
 *  soot.Unit
 *  soot.jimple.IfStmt
 *  soot.jimple.infoflow.data.Abstraction
 *  soot.jimple.infoflow.problems.AbstractInfoflowProblem
 *  soot.jimple.infoflow.solver.cfg.BackwardsInfoflowCFG
 *  soot.jimple.infoflow.solver.cfg.IInfoflowCFG$UnitContainer
 *  soot.jimple.infoflow.solver.executors.InterruptableExecutor
 *  soot.jimple.infoflow.solver.fastSolver.FastSolverLinkedNode
 *  soot.jimple.infoflow.solver.fastSolver.IFDSSolver$ScheduleTarget
 *  soot.jimple.infoflow.solver.fastSolver.InfoflowSolver
 *  soot.jimple.toolkits.ide.icfg.BiDiInterproceduralCFG
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.UnitGraph
 */
package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.AP;
import cn.sast.dataflow.infoflow.svfa.CacheFlowGuide;
import cn.sast.dataflow.infoflow.svfa.SparseInfoflowSolverKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J:\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010\u00a8\u0006\u001f"}, d2={"Lcn/sast/dataflow/infoflow/svfa/SparseInfoFlowSolver;", "Lsoot/jimple/infoflow/solver/fastSolver/InfoflowSolver;", "problem", "Lsoot/jimple/infoflow/problems/AbstractInfoflowProblem;", "executor", "Lsoot/jimple/infoflow/solver/executors/InterruptableExecutor;", "<init>", "(Lsoot/jimple/infoflow/problems/AbstractInfoflowProblem;Lsoot/jimple/infoflow/solver/executors/InterruptableExecutor;)V", "sparseCache", "Lcn/sast/dataflow/infoflow/svfa/CacheFlowGuide;", "getSparseCache", "()Lcn/sast/dataflow/infoflow/svfa/CacheFlowGuide;", "sparseCache$delegate", "Lkotlin/Lazy;", "isForward", "", "()Z", "isBackward", "propagate", "", "sourceVal", "Lsoot/jimple/infoflow/data/Abstraction;", "target", "Lsoot/Unit;", "targetVal", "relatedCallSite", "isUnbalancedReturn", "scheduleTarget", "Lsoot/jimple/infoflow/solver/fastSolver/IFDSSolver$ScheduleTarget;", "toString", "", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nSparseInfoflowSolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseInfoflowSolver.kt\ncn/sast/dataflow/infoflow/svfa/SparseInfoFlowSolver\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,232:1\n1557#2:233\n1628#2,2:234\n1755#2,3:236\n1630#2:239\n1557#2:240\n1628#2,3:241\n1557#2:244\n1628#2,3:245\n*S KotlinDebug\n*F\n+ 1 SparseInfoflowSolver.kt\ncn/sast/dataflow/infoflow/svfa/SparseInfoFlowSolver\n*L\n184#1:233\n184#1:234,2\n192#1:236,3\n184#1:239\n200#1:240\n200#1:241,3\n203#1:244\n203#1:245,3\n*E\n"})
public class SparseInfoFlowSolver
extends InfoflowSolver {
    @NotNull
    private final Lazy sparseCache$delegate;

    public SparseInfoFlowSolver(@NotNull AbstractInfoflowProblem problem, @Nullable InterruptableExecutor executor) {
        Intrinsics.checkNotNullParameter((Object)problem, (String)"problem");
        super(problem, executor);
        this.sparseCache$delegate = LazyKt.lazy(() -> SparseInfoFlowSolver.sparseCache_delegate$lambda$0(this));
    }

    private final CacheFlowGuide getSparseCache() {
        Lazy lazy = this.sparseCache$delegate;
        return (CacheFlowGuide)lazy.getValue();
    }

    private final boolean isForward() {
        return !(this.icfg instanceof BackwardsInfoflowCFG);
    }

    private final boolean isBackward() {
        return this.icfg instanceof BackwardsInfoflowCFG;
    }

    protected void propagate(@NotNull Abstraction sourceVal, @NotNull Unit target, @NotNull Abstraction targetVal, @Nullable Unit relatedCallSite, boolean isUnbalancedReturn, @NotNull IFDSSolver.ScheduleTarget scheduleTarget) {
        List list;
        Intrinsics.checkNotNullParameter((Object)sourceVal, (String)"sourceVal");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        Intrinsics.checkNotNullParameter((Object)targetVal, (String)"targetVal");
        Intrinsics.checkNotNullParameter((Object)scheduleTarget, (String)"scheduleTarget");
        if (targetVal.getAccessPath().getPlainValue() == null || Intrinsics.areEqual((Object)targetVal.getAccessPath(), (Object)((Abstraction)this.zeroValue).getAccessPath())) {
            super.propagate((FastSolverLinkedNode)sourceVal, (Object)target, (FastSolverLinkedNode)targetVal, (Object)relatedCallSite, isUnbalancedReturn, scheduleTarget);
            return;
        }
        SootMethod method = (SootMethod)this.icfg.getMethodOf((Object)target);
        DirectedGraph directedGraph = this.icfg.getOrCreateUnitGraph((Object)method);
        Intrinsics.checkNotNull((Object)directedGraph, (String)"null cannot be cast to non-null type soot.toolkits.graph.UnitGraph");
        UnitGraph unitGraph = (UnitGraph)directedGraph;
        AP ap = AP.Companion.get(targetVal);
        Set uses = CollectionsKt.toSet((Iterable)(this.icfg instanceof BackwardsInfoflowCFG ? this.getSparseCache().getSuccess(false, ap, target, unitGraph) : this.getSparseCache().getSuccess(true, ap, target, unitGraph)));
        if (!targetVal.isAbstractionActive()) {
            if (this.isForward()) {
                $this$map$iv = uses;
                $i$f$map = false;
                Iterable iterable = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    boolean bl;
                    Set callSites;
                    Unit unit = (Unit)item$iv$iv;
                    var30_31 = destination$iv$iv;
                    boolean bl2 = false;
                    Abstraction toVal = targetVal;
                    BiDiInterproceduralCFG biDiInterproceduralCFG = this.icfg;
                    Intrinsics.checkNotNullExpressionValue((Object)biDiInterproceduralCFG, (String)"icfg");
                    Set throughUnits = SparseInfoflowSolverKt.getGoThrough$default((BiDiInterproceduralCFG)biDiInterproceduralCFG, (Object)target, (Object)use, null, (int)4, null);
                    throughUnits.remove(use);
                    if (throughUnits.contains(targetVal.getActivationUnit())) {
                        toVal = targetVal.getActiveCopy();
                    }
                    AbstractInfoflowProblem abstractInfoflowProblem = this.getTabulationProblem();
                    Intrinsics.checkNotNullExpressionValue((Object)abstractInfoflowProblem, (String)"getTabulationProblem(...)");
                    Set set = callSites = (Set)SparseInfoflowSolverKt.getActivationUnitsToCallSites((AbstractInfoflowProblem)abstractInfoflowProblem).get((Object)targetVal.getActivationUnit());
                    if (set != null) {
                        boolean bl3;
                        block19: {
                            Iterable $this$any$iv = set;
                            boolean $i$f$any = false;
                            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                bl3 = false;
                            } else {
                                for (Object element$iv : $this$any$iv) {
                                    Unit it = (Unit)element$iv;
                                    boolean bl4 = false;
                                    if (!throughUnits.contains(it)) continue;
                                    bl3 = true;
                                    break block19;
                                }
                                bl3 = false;
                            }
                        }
                        bl = bl3;
                    } else {
                        bl = false;
                    }
                    if (bl) {
                        toVal = targetVal.getActiveCopy();
                    }
                    var30_31.add(TuplesKt.to((Object)use, (Object)toVal));
                }
                list = (List)destination$iv$iv;
            } else {
                $this$map$iv = uses;
                $i$f$map = false;
                $this$mapTo$iv$iv = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    use = (Unit)item$iv$iv;
                    var30_31 = destination$iv$iv;
                    boolean bl = false;
                    var30_31.add(TuplesKt.to((Object)it, (Object)targetVal));
                }
                list = (List)destination$iv$iv;
            }
        } else {
            $this$map$iv = uses;
            $i$f$map = false;
            $this$mapTo$iv$iv = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                it = (Unit)item$iv$iv;
                var30_31 = destination$iv$iv;
                boolean bl = false;
                var30_31.add(TuplesKt.to((Object)it, (Object)targetVal));
            }
            list = (List)destination$iv$iv;
        }
        List propagates = list;
        for (Pair pair : propagates) {
            Unit useUnit = (Unit)pair.component1();
            Abstraction toVal = (Abstraction)pair.component2();
            Unit turnUnit = toVal.getTurnUnit();
            if (turnUnit != null) {
                BiDiInterproceduralCFG biDiInterproceduralCFG = this.icfg;
                Intrinsics.checkNotNullExpressionValue((Object)biDiInterproceduralCFG, (String)"icfg");
                Set throughUnits = SparseInfoflowSolverKt.getGoThrough((BiDiInterproceduralCFG)biDiInterproceduralCFG, (Object)target, (Object)useUnit, (Set)SetsKt.setOf((Object)turnUnit));
                if (!throughUnits.contains(useUnit) && (!this.icfg.isCallStmt((Object)useUnit) || !Intrinsics.areEqual((Object)sourceVal, (Object)targetVal))) continue;
            }
            if (this.isBackward()) {
                IInfoflowCFG.UnitContainer dominator;
                Intrinsics.checkNotNullExpressionValue((Object)this.getTabulationProblem().getManager().getICFG().getDominatorOf(useUnit), (String)"getDominatorOf(...)");
                if (dominator.getUnit() != null && dominator.getUnit() instanceof IfStmt) {
                    Abstraction newAbs = toVal.deriveNewAbstractionWithDominator(dominator.getUnit());
                    super.propagate((FastSolverLinkedNode)sourceVal, (Object)useUnit, (FastSolverLinkedNode)newAbs, (Object)relatedCallSite, isUnbalancedReturn, scheduleTarget);
                }
            }
            super.propagate((FastSolverLinkedNode)sourceVal, (Object)useUnit, (FastSolverLinkedNode)toVal, (Object)relatedCallSite, isUnbalancedReturn, scheduleTarget);
        }
    }

    @NotNull
    public String toString() {
        return this.isForward() ? "forward" : "backward";
    }

    private static final CacheFlowGuide sparseCache_delegate$lambda$0(SparseInfoFlowSolver this$0) {
        boolean trackControlFlowDependencies = this$0.getTabulationProblem().getManager().getConfig().getImplicitFlowMode().trackControlFlowDependencies();
        return new CacheFlowGuide(trackControlFlowDependencies);
    }
}

