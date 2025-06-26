/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.analysis.constant.CPValue
 *  cn.sast.dataflow.analysis.constant.ConstantPropagation
 *  cn.sast.dataflow.analysis.constant.ConstantValues
 *  cn.sast.dataflow.analysis.constant.FlowMap
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Unit
 *  soot.Value
 *  soot.toolkits.graph.DirectedBodyGraph
 *  soot.toolkits.graph.DirectedGraph
 */
package cn.sast.dataflow.analysis.constant;

import cn.sast.dataflow.analysis.constant.CPValue;
import cn.sast.dataflow.analysis.constant.ConstantPropagation;
import cn.sast.dataflow.analysis.constant.FlowMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Unit;
import soot.Value;
import soot.toolkits.graph.DirectedBodyGraph;
import soot.toolkits.graph.DirectedGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lcn/sast/dataflow/analysis/constant/ConstantValues;", "", "graph", "Lsoot/toolkits/graph/DirectedBodyGraph;", "Lsoot/Unit;", "<init>", "(Lsoot/toolkits/graph/DirectedBodyGraph;)V", "analysis", "Lcn/sast/dataflow/analysis/constant/ConstantPropagation;", "getValueAt", "", "v", "Lsoot/Value;", "unit", "(Lsoot/Value;Lsoot/Unit;)Ljava/lang/Integer;", "corax-data-flow"})
public final class ConstantValues {
    @NotNull
    private final ConstantPropagation analysis;

    public ConstantValues(@NotNull DirectedBodyGraph<Unit> graph) {
        Intrinsics.checkNotNullParameter(graph, (String)"graph");
        this.analysis = new ConstantPropagation((DirectedGraph)graph);
        this.analysis.doAnalysis();
    }

    @Nullable
    public final Integer getValueAt(@NotNull Value v, @NotNull Unit unit) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        CPValue cpValue = ((FlowMap)this.analysis.getFlowBefore((Object)unit)).computeValue(v);
        if (cpValue != CPValue.Companion.getUndef() && cpValue != CPValue.Companion.getNac()) {
            return cpValue.value();
        }
        return null;
    }
}

