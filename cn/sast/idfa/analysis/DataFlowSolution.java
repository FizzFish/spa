/*
 * Copyright (c) 2022, SAP SE. All rights reserved.
 */
package cn.sast.idfa.analysis;

import java.util.Map;

public class DataFlowSolution<N, A> {
    private final Map<N, A> inValues;
    private final Map<N, A> outValues;

    public DataFlowSolution(Map<N, A> inValues, Map<N, A> outValues) {
        this.inValues = inValues;
        this.outValues = outValues;
    }

    public A getValueBefore(N node) {
        return inValues.get(node);
    }

    public A getValueAfter(N node) {
        return outValues.get(node);
    }
}