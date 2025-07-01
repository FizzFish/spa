package cn.sast.dataflow.infoflow.svfa;

import soot.IdentityUnit;
import soot.Trap;
import soot.Unit;
import soot.Value;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalGraph;
import soot.toolkits.scalar.FlowAnalysis;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlinx.collections.immutable.PersistentSet;
import kotlinx.collections.immutable.ExtensionsKt;

public final class FlowAnalysisOp {
    public static final FlowAnalysisOp INSTANCE = new FlowAnalysisOp();

    private FlowAnalysisOp() {
    }

    public void mergeInto(@NotNull Unit succNode, @NotNull FlowFact inout, @NotNull FlowFact in1) {
        if (succNode == null) throw new IllegalArgumentException("succNode cannot be null");
        if (inout == null) throw new IllegalArgumentException("inout cannot be null");
        if (in1 == null) throw new IllegalArgumentException("in1 cannot be null");

        Map<Value, PersistentSet<Unit>> inoutData = inout.getData();
        Map<Value, PersistentSet<Unit>> in1Data = in1.getData();

        for (Value key : inoutData.keySet()) {
            mergeValue(key, inout, in1);
        }
        for (Value key : in1Data.keySet()) {
            mergeValue(key, inout, in1);
        }
    }

    private void mergeValue(Value key, FlowFact inout, FlowFact in1) {
        PersistentSet<Unit> inoutSet = inout.getData().getOrDefault(key, ExtensionsKt.persistentHashSetOf());
        PersistentSet<Unit> in1Set = in1.getData().getOrDefault(key, ExtensionsKt.persistentHashSetOf());
        PersistentSet<Unit> mergedSet = ExtensionsKt.plus(inoutSet, in1Set);
        inout.getData().put(key, mergedSet);
    }

    @NotNull
    public FlowAnalysis.Flow getFlow(@NotNull DirectedGraph<Unit> graph, @NotNull Unit from, @NotNull Unit to) {
        if (graph == null) throw new IllegalArgumentException("graph cannot be null");
        if (from == null) throw new IllegalArgumentException("from cannot be null");
        if (to == null) throw new IllegalArgumentException("to cannot be null");

        if (to instanceof IdentityUnit && graph instanceof ExceptionalGraph) {
            ExceptionalGraph g2 = (ExceptionalGraph) graph;
            List<Unit> exceptionalPreds = g2.getExceptionalPredsOf(to);
            if (!exceptionalPreds.isEmpty()) {
                for (ExceptionalGraph.ExceptionDest exd : g2.getExceptionDests(from)) {
                    Trap trap = exd.getTrap();
                    if (trap != null && trap.getHandlerUnit() == to) {
                        return FlowAnalysis.Flow.IN;
                    }
                }
            }
        }
        return FlowAnalysis.Flow.OUT;
    }
}