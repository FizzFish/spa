/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.analysis.DataFlowSolution
 */
package cn.sast.idfa.analysis;

import java.util.Map;

public class DataFlowSolution<N, A> {
    private Map<N, A> inValues;
    private Map<N, A> outValues;

    public DataFlowSolution(Map<N, A> inValues, Map<N, A> outValues) {
        this.inValues = inValues;
        this.outValues = outValues;
    }

    public A getValueBefore(N node) {
        return (A)this.inValues.get(node);
    }

    public A getValueAfter(N node) {
        return (A)this.outValues.get(node);
    }
}

