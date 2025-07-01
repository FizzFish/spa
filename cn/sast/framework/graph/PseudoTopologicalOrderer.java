package cn.sast.framework.graph;

import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.Orderer;
import java.util.List;

public class PseudoTopologicalOrderer<N> implements Orderer<N> {
    public static final boolean REVERSE = true;
    private boolean reversed;

    public PseudoTopologicalOrderer() {
    }

    public List<N> newList(DirectedGraph<N> graph, boolean reverse) {
        this.reversed = reverse;
        return new ReverseOrderBuilder<>(graph).computeOrder(!reverse);
    }

    @Deprecated
    public PseudoTopologicalOrderer(boolean reversed) {
        this.reversed = reversed;
    }

    @Deprecated
    public List<N> newList(DirectedGraph<N> graph) {
        return new ReverseOrderBuilder<>(graph).computeOrder(!this.reversed);
    }

    @Deprecated
    public void setReverseOrder(boolean reversed) {
        this.reversed = reversed;
    }

    @Deprecated
    public boolean isReverseOrder() {
        return reversed;
    }
}