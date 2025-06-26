/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.graph.PseudoTopologicalOrderer
 *  cn.sast.framework.graph.PseudoTopologicalOrderer$ReverseOrderBuilder
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.Orderer
 */
package cn.sast.framework.graph;

import cn.sast.framework.graph.PseudoTopologicalOrderer;
import java.util.List;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.Orderer;

public class PseudoTopologicalOrderer<N>
implements Orderer<N> {
    public static final boolean REVERSE = true;
    private boolean mIsReversed = false;

    public PseudoTopologicalOrderer() {
    }

    public List<N> newList(DirectedGraph<N> g2, boolean reverse) {
        this.mIsReversed = reverse;
        return new ReverseOrderBuilder(g2).computeOrder(!reverse);
    }

    @Deprecated
    public PseudoTopologicalOrderer(boolean isReversed) {
        this.mIsReversed = isReversed;
    }

    @Deprecated
    public List<N> newList(DirectedGraph<N> g2) {
        return new ReverseOrderBuilder(g2).computeOrder(!this.mIsReversed);
    }

    @Deprecated
    public void setReverseOrder(boolean isReversed) {
        this.mIsReversed = isReversed;
    }

    @Deprecated
    public boolean isReverseOrder() {
        return this.mIsReversed;
    }
}

