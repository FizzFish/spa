package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.AbstractionGraph;
import cn.sast.dataflow.interprocedural.check.AbstractionGraphKt;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.jimple.Stmt;
import soot.jimple.infoflow.data.Abstraction;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.util.dot.DotGraph;
import soot.util.dot.DotGraphEdge;
import soot.util.dot.DotGraphNode;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class DefaultAbstractionGraph extends AbstractionGraph {
    public DefaultAbstractionGraph(@NotNull Abstraction sink) {
        super(sink);
        int size = getAbsChain().size();
        setUnitToSuccs(new IdentityHashMap<>(size * 2 + 1));
        setUnitToPreds(new IdentityHashMap<>(size * 2 + 1));
        buildUnexceptionalEdges(getUnitToPreds(), getUnitToSuccs());
        buildHeadsAndTails();
    }

    @NotNull
    public DotGraph plot(@NotNull IInfoflowCFG cfg) {
        DotGraph dot = new DotGraph("AbsGraph");
        dot.setGraphAttribute("style", "filled");
        dot.setGraphAttribute("color", "lightgrey");
        dot.setGraphAttribute("rankdir", "LR");
        dot.setGraphAttribute("ranksep", "8");
        dot.setNodeShape("box");

        Map<SootMethod, DotGraph> methodSubgraphs = new LinkedHashMap<>();

        for (Abstraction a : getAbsChain()) {
            String name = String.valueOf(System.identityHashCode(a));
            DotGraphNode fromNode;

            if (a.getCurrentStmt() == null) {
                fromNode = dot.drawNode(name);
                fromNode.setHTMLLabel(AbstractionGraphKt.getLabel(a, cfg));
            } else {
                SootMethod method = cfg.getMethodOf(a.getCurrentStmt());
                DotGraph subgraph = methodSubgraphs.computeIfAbsent(method, m -> {
                    DotGraph sg = dot.createSubGraph("cluster_" + System.identityHashCode(m));
                    sg.setGraphLabel(m.toString());
                    sg.setGraphAttribute("style", "filled");
                    sg.setGraphAttribute("color", "lightgrey");
                    sg.setNodeShape("box");
                    return sg;
                });
                fromNode = subgraph.drawNode(name);
                fromNode.setHTMLLabel(AbstractionGraphKt.getLabel(a, cfg));
            }

            if (isHead(a)) {
                fromNode.setAttribute("color", "blue");
            }

            for (Abstraction successor : getSuccsOf(a)) {
                String successorName = String.valueOf(System.identityHashCode(successor));
                DotGraphNode toNode;

                if (successor.getCurrentStmt() == null) {
                    toNode = dot.drawNode(successorName);
                    toNode.setHTMLLabel(AbstractionGraphKt.getLabel(successor, cfg));
                } else {
                    SootMethod successorMethod = cfg.getMethodOf(successor.getCurrentStmt());
                    DotGraph successorSubgraph = methodSubgraphs.computeIfAbsent(successorMethod, m -> {
                        DotGraph sg = dot.createSubGraph("cluster_" + System.identityHashCode(m));
                        sg.setGraphLabel(m.toString());
                        sg.setGraphAttribute("style", "filled");
                        sg.setGraphAttribute("color", "lightgrey");
                        sg.setNodeShape("box");
                        return sg;
                    });
                    toNode = successorSubgraph.drawNode(successorName);
                    toNode.setHTMLLabel(AbstractionGraphKt.getLabel(successor, cfg));
                }

                DotGraphEdge edge = dot.drawEdge(name, successorName);
                edge.setAttribute("color", "green");

                if (!successor.getCorrespondingCallSite().equals(successor.getCurrentStmt())) {
                    if (successor.getCorrespondingCallSite() != null) {
                        if (successor.getCorrespondingCallSite().equals(a.getCurrentStmt())) {
                            edge.setAttribute("color", "red");
                        } else {
                            edge.setAttribute("style", "dashed");
                            edge.setAttribute("color", "black");
                        }
                    }
                }

                if (isTail(successor)) {
                    toNode.setAttribute("color", "red");
                }
            }
        }

        return dot;
    }
}
