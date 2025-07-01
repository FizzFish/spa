package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.AP;
import cn.sast.dataflow.infoflow.svfa.FlowAnalysisOp;
import cn.sast.dataflow.infoflow.svfa.FlowFact;
import cn.sast.dataflow.infoflow.svfa.SparsePropgrateAnalyzeKt;
import cn.sast.dataflow.infoflow.svfa.VFNode;
import cn.sast.dataflow.infoflow.svfa.ValueLocation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import soot.Unit;
import soot.Value;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.Stmt;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.BackwardFlowAnalysis;
import soot.toolkits.scalar.FlowAnalysis;

final class FlowAssignment extends BackwardFlowAnalysis<Unit, FlowFact> {
    @NotNull
    private final Set<Value> paramAndThis;
    @NotNull
    private final Map<Stmt, Set<Pair<AP, ValueLocation>>> unit2locals;

    public FlowAssignment(@NotNull DirectedGraph<Unit> graph, 
                         @NotNull Set<Value> paramAndThis, 
                         @NotNull Map<Stmt, ? extends Set<Pair<AP, ValueLocation>>> unit2locals) {
        super(graph);
        this.paramAndThis = paramAndThis;
        this.unit2locals = unit2locals;
        this.doAnalysis();
    }

    @NotNull
    public final Set<Value> getParamAndThis() {
        return paramAndThis;
    }

    @NotNull
    public final Map<Stmt, Set<Pair<AP, ValueLocation>>> getUnit2locals() {
        return unit2locals;
    }

    protected boolean omissible(@NotNull Unit u) {
        return false;
    }

    protected void flowThrough(@NotNull FlowFact infact, @NotNull Unit unit, @NotNull FlowFact out) {
        copy(infact, out);
        if (!(unit instanceof Stmt)) {
            return;
        }

        Set<Pair<AP, ValueLocation>> locals = unit2locals.get(unit);
        if (locals != null) {
            PersistentMap<Value, PersistentSet<VFNode>> fact = out.getData();
            for (Pair<AP, ValueLocation> pair : locals) {
                AP ap = pair.getFirst();
                ValueLocation loc = pair.getSecond();
                
                if (SparsePropgrateAnalyzeKt.isLeft(loc)) {
                    if (ap.getField() == null) {
                        fact = fact.minus(ap.getValue());
                    } else {
                        VFNode vfNode = new VFNode(ap.getValue(), unit);
                        fact = fact.put(ap.getValue(), ExtensionsKt.persistentHashSetOf(vfNode));
                    }
                } else {
                    VFNode vfNode = new VFNode(ap.getValue(), unit);
                    fact = fact.put(ap.getValue(), ExtensionsKt.persistentHashSetOf(vfNode));
                }
            }
            out.setData(fact);
        }

        if (unit instanceof ReturnVoidStmt || unit instanceof ReturnStmt) {
            PersistentMap<Value, PersistentSet<VFNode>> fact = out.getData();
            Map<Value, PersistentSet<VFNode>> result = new LinkedHashMap<>(Math.max(paramAndThis.size(), 16));
            
            for (Value value : paramAndThis) {
                VFNode vfNode = new VFNode(value, unit);
                result.put(value, ExtensionsKt.persistentHashSetOf(vfNode));
            }
            
            out.setData(fact.putAll(result));
        }
    }

    protected void copy(@NotNull FlowFact source, @NotNull FlowFact dest) {
        if (dest != source) {
            dest.setData(source.getData());
        }
    }

    @NotNull
    protected FlowFact newInitialFlow() {
        return new FlowFact();
    }

    @NotNull
    protected FlowAnalysis.Flow getFlow(@NotNull Unit from, @NotNull Unit to) {
        return FlowAnalysisOp.INSTANCE.getFlow(graph, from, to);
    }

    protected void mergeInto(@NotNull Unit succNode, @NotNull FlowFact inout, @NotNull FlowFact in1) {
        FlowAnalysisOp.INSTANCE.mergeInto(succNode, inout, in1);
    }

    protected void merge(@NotNull FlowFact in1, @NotNull FlowFact in2, @NotNull FlowFact out) {
        throw new UnsupportedOperationException("FlowAssignment.merge should never be called");
    }

    @NotNull
    public final Map<Unit, FlowFact> getBefore() {
        return unitToBeforeFlow;
    }
}
