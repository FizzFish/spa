package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.idfa.analysis.Context;
import cn.sast.idfa.analysis.InterproceduralCFG;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.DefinitionStmt;
import soot.jimple.infoflow.data.AccessPath;
import soot.jimple.spark.pag.PAG;
import soot.jimple.spark.sets.PointsToSetInternal;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class DemandPTA<V, CTX extends Context<SootMethod, Unit, IFact<V>>> 
    extends AJimpleInterProceduralAnalysis<V, CTX> {

    private static final KLogger logger = KotlinLogging.logger(DemandPTA.class);

    @NotNull
    private final PointsToAnalysis pta;
    @Nullable
    private PointsToSetInternal associationPTS;
    @Nullable
    private PointsToSetInternal associationInstance;
    @NotNull
    private Set<Unit> associationStmt;

    public DemandPTA(@NotNull PointsToAnalysis pta, @NotNull AbstractHeapFactory<V> hf, @NotNull InterproceduralCFG icfg) {
        super(hf, icfg);
        this.pta = Objects.requireNonNull(pta, "pta");
        this.associationStmt = new LinkedHashSet<>();
    }

    public DemandPTA(@NotNull AbstractHeapFactory<V> hf, @NotNull InterproceduralCFG icfg) {
        this(Scene.v().getPointsToAnalysis(), hf, icfg);
    }

    @NotNull
    public final PointsToAnalysis getPta() {
        return pta;
    }

    @NotNull
    public abstract Set<Map.Entry<Unit, AccessPath>> getLocals();

    @Nullable
    public final PointsToSetInternal getAssociationPTS() {
        return associationPTS;
    }

    public final void setAssociationPTS(@Nullable PointsToSetInternal associationPTS) {
        this.associationPTS = associationPTS;
    }

    @Nullable
    public final PointsToSetInternal getAssociationInstance() {
        return associationInstance;
    }

    public final void setAssociationInstance(@Nullable PointsToSetInternal associationInstance) {
        this.associationInstance = associationInstance;
    }

    @NotNull
    public final Set<Unit> getAssociationStmt() {
        return associationStmt;
    }

    public final void setAssociationStmt(@NotNull Set<Unit> associationStmt) {
        this.associationStmt = Objects.requireNonNull(associationStmt);
    }

    @Override
    public void doAnalysis(@NotNull Collection<? extends SootMethod> entries) {
        Objects.requireNonNull(entries, "entries");
        
        if (pta instanceof PAG) {
            PAG pag = (PAG) pta;
            PointsToSetInternal associationInstance = pag.getSetFactory().newSet(null, pag);
            PointsToSetInternal associationPTS = pag.getSetFactory().newSet(null, pag);

            for (Map.Entry<Unit, AccessPath> entry : getLocals()) {
                Unit u = entry.getKey();
                AccessPath accessPath = entry.getValue();

                if (u != null) {
                    associationStmt.add(u);
                }

                if (accessPath.getFirstFragment() != null) {
                    PointsToSet instance = pag.reachingObjects(accessPath.getPlainValue());
                    if (instance instanceof PointsToSetInternal) {
                        associationInstance.addAll((PointsToSetInternal) instance, null);
                    }
                    PointsToSet pts = pag.reachingObjects(accessPath.getPlainValue(), accessPath.getFirstFragment().getField());
                    if (pts instanceof PointsToSetInternal) {
                        associationPTS.addAll((PointsToSetInternal) pts, null);
                    }
                } else {
                    PointsToSet pts = pag.reachingObjects(accessPath.getPlainValue());
                    if (pts instanceof PointsToSetInternal) {
                        associationPTS.addAll((PointsToSetInternal) pts, null);
                    }
                }
            }

            this.associationInstance = associationInstance;
            this.associationPTS = associationPTS;
        } else {
            logger.error("error pta type: {}", pta.getClass());
        }
        super.doAnalysis(entries);
    }

    public final boolean isAssociation(@NotNull Local l) {
        Objects.requireNonNull(l, "l");
        PointsToSet ptsL = pta.reachingObjects(l);
        return associationPTS == null || associationPTS.hasNonEmptyIntersection(ptsL);
    }

    public final boolean isAssociationInstance(@NotNull Local l) {
        Objects.requireNonNull(l, "l");
        PointsToSet ptsL = pta.reachingObjects(l);
        return associationInstance == null || associationInstance.hasNonEmptyIntersection(ptsL);
    }

    @Nullable
    @Override
    public IFact<V> normalFlowFunction(
        @NotNull CTX context, 
        @NotNull Unit node, 
        @NotNull Unit succ, 
        @NotNull IFact<V> inValue, 
        @NotNull AtomicBoolean isNegativeBranch
    ) {
        List<Value> values = new ArrayList<>();
        for (ValueBox box : node.getUseAndDefBoxes()) {
            values.add(box.getValue());
        }

        List<Local> locals = new ArrayList<>();
        for (Value value : values) {
            if (value instanceof Local) {
                locals.add((Local) value);
            }
        }

        if (!(node instanceof DefinitionStmt)) {
            return inValue;
        }

        DefinitionStmt defStmt = (DefinitionStmt) node;
        Value lhsOp = defStmt.getLeftOp();
        Value rhsOp = defStmt.getRightOp();

        return super.normalFlowFunction(context, node, succ, inValue, isNegativeBranch);
    }
}
