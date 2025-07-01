package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.AP;
import cn.sast.dataflow.infoflow.svfa.FlowAnalysisOp;
import cn.sast.dataflow.infoflow.svfa.FlowFact;
import cn.sast.dataflow.infoflow.svfa.VFNode;
import cn.sast.dataflow.infoflow.svfa.ValueLocation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import soot.Unit;
import soot.Value;
import soot.jimple.Stmt;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.FlowAnalysis;
import soot.toolkits.scalar.ForwardFlowAnalysis;

final class BackAssignment extends ForwardFlowAnalysis<Unit, FlowFact> {
    @NotNull
    private final Set<Value> paramAndThis;
    @NotNull
    private final Map<Stmt, Set<Pair<AP, ValueLocation>>> unit2locals;

    public BackAssignment(@NotNull DirectedGraph<Unit> graph, 
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

    @Override
    @NotNull
    protected FlowFact newInitialFlow() {
        return new FlowFact();
    }

    @Override
    protected boolean omissible(@NotNull Unit u) {
        return false;
    }

    @Override
    protected void copy(@NotNull FlowFact source, @NotNull FlowFact dest) {
        if (dest != source) {
            dest.setData(source.getData());
        }
    }

    @Override
    @NotNull
    protected FlowAnalysis.Flow getFlow(@NotNull Unit from, @NotNull Unit to) {
        return FlowAnalysisOp.INSTANCE.getFlow(graph, from, to);
    }

    @Override
    protected void mergeInto(@NotNull Unit succNode, @NotNull FlowFact inout, @NotNull FlowFact in1) {
        FlowAnalysisOp.INSTANCE.mergeInto(succNode, inout, in1);
    }

    @Override
    protected void merge(@NotNull FlowFact in1, @NotNull FlowFact in2, @NotNull FlowFact out) {
        throw new UnsupportedOperationException("BackAssignment.merge should never be called");
    }

    @Override
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
                VFNode[] nodes = {new VFNode(ap.getValue(), unit)};
                fact = fact.put(ap.getValue(), ExtensionsKt.persistentHashSetOf(nodes));
            }
            out.setData(fact);
        }

        if (graph.getHeads().contains(unit)) {
            PersistentMap<Value, PersistentSet<VFNode>> fact = out.getData();
            Map<Value, PersistentSet<VFNode>> paramMap = new LinkedHashMap<>();
            for (Value param : paramAndThis) {
                VFNode[] nodes = {new VFNode(param, unit)};
                paramMap.put(param, ExtensionsKt.persistentHashSetOf(nodes));
            }
            out.setData(fact.putAll(paramMap));
        }
    }

    @NotNull
    public final Map<Unit, FlowFact> getAfter() {
        return unitToAfterFlow;
    }
}
