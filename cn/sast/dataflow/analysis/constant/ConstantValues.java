package cn.sast.dataflow.analysis.constant;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;
import soot.Value;
import soot.toolkits.graph.DirectedBodyGraph;

public final class ConstantValues {
    private final ConstantPropagation analysis;

    public ConstantValues(@NotNull DirectedBodyGraph<Unit> graph) {
        if (graph == null) throw new IllegalArgumentException("graph cannot be null");
        this.analysis = new ConstantPropagation(graph);
        this.analysis.doAnalysis();
    }

    @Nullable
    public Integer getValueAt(@NotNull Value v, @NotNull Unit unit) {
        if (v == null) throw new IllegalArgumentException("v cannot be null");
        if (unit == null) throw new IllegalArgumentException("unit cannot be null");

        CPValue cpValue = analysis.getFlowBefore(unit).computeValue(v);
        if (cpValue != CPValue.UNDEF && cpValue != CPValue.NAC) {
            return cpValue.value();
        }
        return null;
    }
}