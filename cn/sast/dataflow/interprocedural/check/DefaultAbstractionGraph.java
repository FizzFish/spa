/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.AbstractionGraph
 *  cn.sast.dataflow.interprocedural.check.AbstractionGraphKt
 *  cn.sast.dataflow.interprocedural.check.DefaultAbstractionGraph
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 *  soot.jimple.Stmt
 *  soot.jimple.infoflow.data.Abstraction
 *  soot.jimple.infoflow.solver.cfg.IInfoflowCFG
 *  soot.util.dot.DotGraph
 *  soot.util.dot.DotGraphEdge
 *  soot.util.dot.DotGraphNode
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.AbstractionGraph;
import cn.sast.dataflow.interprocedural.check.AbstractionGraphKt;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.jimple.Stmt;
import soot.jimple.infoflow.data.Abstraction;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.util.dot.DotGraph;
import soot.util.dot.DotGraphEdge;
import soot.util.dot.DotGraphNode;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"Lcn/sast/dataflow/interprocedural/check/DefaultAbstractionGraph;", "Lcn/sast/dataflow/interprocedural/check/AbstractionGraph;", "sink", "Lsoot/jimple/infoflow/data/Abstraction;", "<init>", "(Lsoot/jimple/infoflow/data/Abstraction;)V", "plot", "Lsoot/util/dot/DotGraph;", "cfg", "Lsoot/jimple/infoflow/solver/cfg/IInfoflowCFG;", "corax-data-flow"})
public final class DefaultAbstractionGraph
extends AbstractionGraph {
    public DefaultAbstractionGraph(@NotNull Abstraction sink) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        super(sink);
        int size = this.getAbsChain().size();
        this.setUnitToSuccs(new IdentityHashMap(size * 2 + 1));
        this.setUnitToPreds(new IdentityHashMap(size * 2 + 1));
        this.buildUnexceptionalEdges(this.getUnitToPreds(), this.getUnitToSuccs());
        this.buildHeadsAndTails();
    }

    @NotNull
    public final DotGraph plot(@NotNull IInfoflowCFG cfg) {
        Intrinsics.checkNotNullParameter((Object)cfg, (String)"cfg");
        DotGraph dot = new DotGraph("AbsGraph");
        dot.setGraphAttribute("style", "filled");
        dot.setGraphAttribute("color", "lightgrey");
        dot.setGraphAttribute("rankdir", "LR");
        dot.setGraphAttribute("ranksep", "8");
        dot.setNodeShape("box");
        Map map = new LinkedHashMap();
        Iterator iterator2 = this.getAbsChain().iterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            DotGraph it;
            DotGraphNode dotGraphNode;
            Object e = iterator3.next();
            Intrinsics.checkNotNullExpressionValue(e, (String)"next(...)");
            Abstraction a = (Abstraction)e;
            String name = String.valueOf(System.identityHashCode(a));
            if (a.getCurrentStmt() == null) {
                DotGraphNode node = dot.drawNode(name);
                node.setHTMLLabel(AbstractionGraphKt.getLabel((Abstraction)a, (IInfoflowCFG)cfg));
                dotGraphNode = node;
            } else {
                SootMethod sm = (SootMethod)cfg.getMethodOf((Object)a.getCurrentStmt());
                SootMethod m = (SootMethod)cfg.getMethodOf((Object)a.getCurrentStmt());
                DotGraph dotGraph = (DotGraph)map.get(m);
                if (dotGraph == null) {
                    DotGraph dotGraph2;
                    DefaultAbstractionGraph it2 = this;
                    boolean bl = false;
                    it = dotGraph2 = dot.createSubGraph("cluster_" + System.identityHashCode(m));
                    boolean bl2 = false;
                    map.put(m, it);
                    it.setGraphLabel(m.toString());
                    it.setGraphAttribute("style", "filled");
                    it.setGraphAttribute("color", "lightgrey");
                    it.setNodeShape("box");
                    dotGraph = dotGraph2;
                }
                DotGraph sub = dotGraph;
                DotGraphNode node = sub.drawNode(name);
                node.setHTMLLabel(AbstractionGraphKt.getLabel((Abstraction)a, (IInfoflowCFG)cfg));
                dotGraphNode = node;
            }
            DotGraphNode from = dotGraphNode;
            for (Abstraction s : this.getSuccsOf(a)) {
                DotGraphNode dotGraphNode2;
                String nameTo = String.valueOf(System.identityHashCode(s));
                if (s.getCurrentStmt() == null) {
                    DotGraphNode nodeTo = dot.drawNode(nameTo);
                    nodeTo.setHTMLLabel(AbstractionGraphKt.getLabel((Abstraction)s, (IInfoflowCFG)cfg));
                    dotGraphNode2 = nodeTo;
                } else {
                    SootMethod m2 = (SootMethod)cfg.getMethodOf((Object)s.getCurrentStmt());
                    DotGraph dotGraph = (DotGraph)map.get(m2);
                    if (dotGraph == null) {
                        DotGraph dotGraph3;
                        it = this;
                        boolean bl = false;
                        DotGraph it3 = dotGraph3 = dot.createSubGraph("cluster_" + System.identityHashCode(m2));
                        boolean bl3 = false;
                        map.put(m2, it3);
                        it3.setGraphLabel(m2.toString());
                        it3.setGraphAttribute("style", "filled");
                        it3.setGraphAttribute("color", "lightgrey");
                        it3.setNodeShape("box");
                        dotGraph = dotGraph3;
                    }
                    DotGraph sub2 = dotGraph;
                    DotGraphNode nodeTo = sub2.drawNode(nameTo);
                    nodeTo.setHTMLLabel(AbstractionGraphKt.getLabel((Abstraction)s, (IInfoflowCFG)cfg));
                    dotGraphNode2 = nodeTo;
                }
                DotGraphNode to = dotGraphNode2;
                DotGraphEdge edge = dot.drawEdge(name, nameTo);
                edge.setAttribute("color", "green");
                if (!Intrinsics.areEqual((Object)s.getCorrespondingCallSite(), (Object)s.getCurrentStmt())) {
                    if (s.getCorrespondingCallSite() != null) {
                        Stmt it4;
                        boolean bl = false;
                        if (Intrinsics.areEqual((Object)it4, (Object)a.getCurrentStmt())) {
                            edge.setAttribute("color", "red");
                        } else {
                            edge.setAttribute("style", "dashed");
                            edge.setAttribute("color", "black");
                        }
                    }
                }
                if (!this.isTail(s)) continue;
                to.setAttribute("color", "red");
            }
            if (!this.isHead(a)) continue;
            from.setAttribute("color", "blue");
        }
        return dot;
    }
}

