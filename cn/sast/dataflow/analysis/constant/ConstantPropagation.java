/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.analysis.constant.CPValue
 *  cn.sast.dataflow.analysis.constant.ConstantPropagation
 *  cn.sast.dataflow.analysis.constant.FlowMap
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Local
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.AssignStmt
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.scalar.ForwardFlowAnalysis
 */
package cn.sast.dataflow.analysis.constant;

import cn.sast.dataflow.analysis.constant.CPValue;
import cn.sast.dataflow.analysis.constant.FlowMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.Local;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.ForwardFlowAnalysis;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0014J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0014J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0014J\b\u0010\u0014\u001a\u00020\tH\u0016\u00a8\u0006\u0015"}, d2={"Lcn/sast/dataflow/analysis/constant/ConstantPropagation;", "Lsoot/toolkits/scalar/ForwardFlowAnalysis;", "Lsoot/Unit;", "Lcn/sast/dataflow/analysis/constant/FlowMap;", "graph", "Lsoot/toolkits/graph/DirectedGraph;", "<init>", "(Lsoot/toolkits/graph/DirectedGraph;)V", "flowThrough", "", "in", "d", "out", "newInitialFlow", "merge", "in1", "in2", "copy", "source", "dest", "doAnalysis", "corax-data-flow"})
public final class ConstantPropagation
extends ForwardFlowAnalysis<Unit, FlowMap> {
    public ConstantPropagation(@NotNull DirectedGraph<Unit> graph) {
        Intrinsics.checkNotNullParameter(graph, (String)"graph");
        super(graph);
    }

    protected void flowThrough(@NotNull FlowMap in, @NotNull Unit d, @NotNull FlowMap out) {
        Unit ass;
        Value lVal;
        Intrinsics.checkNotNullParameter((Object)in, (String)"in");
        Intrinsics.checkNotNullParameter((Object)d, (String)"d");
        Intrinsics.checkNotNullParameter((Object)out, (String)"out");
        this.copy(in, out);
        if (d instanceof AssignStmt && (lVal = ((AssignStmt)(ass = d)).getLeftOp()) instanceof Local) {
            Value rightVal = ((AssignStmt)ass).getRightOp();
            Intrinsics.checkNotNull((Object)rightVal);
            CPValue rightCPValue = in.computeValue(rightVal);
            out.put((Local)lVal, rightCPValue);
        }
    }

    @NotNull
    protected FlowMap newInitialFlow() {
        return new FlowMap(null, 1, null);
    }

    protected void merge(@NotNull FlowMap in1, @NotNull FlowMap in2, @NotNull FlowMap out) {
        Intrinsics.checkNotNullParameter((Object)in1, (String)"in1");
        Intrinsics.checkNotNullParameter((Object)in2, (String)"in2");
        Intrinsics.checkNotNullParameter((Object)out, (String)"out");
        FlowMap meet = FlowMap.Companion.meet(in1, in2);
        this.copy(meet, out);
    }

    protected void copy(@NotNull FlowMap source, @NotNull FlowMap dest) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        dest.copyFrom(source);
    }

    public void doAnalysis() {
        super.doAnalysis();
    }
}

