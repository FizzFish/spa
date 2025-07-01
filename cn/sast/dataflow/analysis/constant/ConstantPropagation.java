package cn.sast.dataflow.analysis.constant;

import org.jetbrains.annotations.NotNull;
import soot.Local;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.ForwardFlowAnalysis;

public final class ConstantPropagation extends ForwardFlowAnalysis<Unit, FlowMap> {

    public ConstantPropagation(@NotNull DirectedGraph<Unit> graph) {
        super(graph);
    }

    @Override
    protected void flowThrough(@NotNull FlowMap in, @NotNull Unit d, @NotNull FlowMap out) {
        out.copyFrom(in);
        
        if (d instanceof AssignStmt) {
            AssignStmt assignStmt = (AssignStmt) d;
            Value leftValue = assignStmt.getLeftOp();
            if (leftValue instanceof Local) {
                Value rightValue = assignStmt.getRightOp();
                CPValue rightCPValue = in.computeValue(rightValue);
                out.put((Local) leftValue, rightCPValue);
            }
        }
    }

    @Override
    @NotNull
    protected FlowMap newInitialFlow() {
        return new FlowMap();
    }

    @Override
    protected void merge(@NotNull FlowMap in1, @NotNull FlowMap in2, @NotNull FlowMap out) {
        FlowMap meet = FlowMap.meet(in1, in2);
        out.copyFrom(meet);
    }

    @Override
    protected void copy(@NotNull FlowMap source, @NotNull FlowMap dest) {
        dest.copyFrom(source);
    }

    @Override
    public void doAnalysis() {
        super.doAnalysis();
    }
}