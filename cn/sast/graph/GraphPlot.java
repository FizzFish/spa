/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.graph.GraphPlot
 *  cn.sast.graph.GraphPlot$Companion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.toolkits.graph.DirectedGraph
 *  soot.util.dot.DotGraph
 *  soot.util.dot.DotGraphEdge
 *  soot.util.dot.DotGraphNode
 */
package cn.sast.graph;

import cn.sast.graph.GraphPlot;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.toolkits.graph.DirectedGraph;
import soot.util.dot.DotGraph;
import soot.util.dot.DotGraphEdge;
import soot.util.dot.DotGraphNode;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0012B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ\u0011\u0010\u000e\u001a\u00020\r*\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00028\u0000*\u00028\u0001H&\u00a2\u0006\u0002\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2={"Lcn/sast/graph/GraphPlot;", "C", "N", "", "cfg", "Lsoot/toolkits/graph/DirectedGraph;", "<init>", "(Lsoot/toolkits/graph/DirectedGraph;)V", "getCfg", "()Lsoot/toolkits/graph/DirectedGraph;", "plot", "Lsoot/util/dot/DotGraph;", "graphName", "", "getLabel", "(Ljava/lang/Object;)Ljava/lang/String;", "getNodeContainer", "(Ljava/lang/Object;)Ljava/lang/Object;", "Companion", "corax-api"})
public abstract class GraphPlot<C, N> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final DirectedGraph<N> cfg;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(GraphPlot::logger$lambda$5);

    public GraphPlot(@NotNull DirectedGraph<N> cfg) {
        Intrinsics.checkNotNullParameter(cfg, (String)"cfg");
        this.cfg = cfg;
    }

    @NotNull
    public final DirectedGraph<N> getCfg() {
        return this.cfg;
    }

    @NotNull
    public final DotGraph plot(@NotNull String graphName) {
        Intrinsics.checkNotNullParameter((Object)graphName, (String)"graphName");
        DotGraph dot = new DotGraph(graphName);
        dot.setGraphAttribute("style", "filled");
        dot.setGraphAttribute("color", "lightgrey");
        dot.setGraphAttribute("rankdir", "LR");
        dot.setGraphAttribute("ranksep", "8");
        dot.setNodeShape("box");
        Map map = new LinkedHashMap();
        Object object = dot.createSubGraph("cluster_start");
        DotGraph it = object;
        boolean bl = false;
        it.setGraphLabel("START");
        it.setGraphAttribute("style", "filled");
        it.setGraphAttribute("color", "lightgrey");
        it.setNodeShape("box");
        DotGraph start2 = object;
        Iterator iterator2 = this.cfg.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        object = iterator2;
        while (object.hasNext()) {
            Object node = object.next();
            String nodeName = String.valueOf(node);
            Object nodeContainer = this.getNodeContainer(node);
            DotGraph dotGraph = (DotGraph)map.get(nodeContainer);
            if (dotGraph == null) {
                DotGraph dotGraph2;
                GraphPlot it2 = this;
                boolean bl2 = false;
                DotGraph it3 = dotGraph2 = dot.createSubGraph("cluster_" + nodeContainer);
                boolean bl3 = false;
                map.put(nodeContainer, it3);
                it3.setGraphLabel(String.valueOf(nodeContainer));
                it3.setGraphAttribute("style", "filled");
                it3.setGraphAttribute("color", "lightgrey");
                it3.setGraphAttribute("labeljust", "l");
                it3.setNodeShape("box");
                dotGraph = dotGraph2;
            }
            DotGraph sub = dotGraph;
            DotGraphNode fromNode = sub.drawNode(nodeName);
            fromNode.setHTMLLabel(this.getLabel(node));
            if (this.cfg.getHeads().contains(node)) {
                fromNode.setAttribute("color", "blue");
                DotGraphEdge startEdge = dot.drawEdge(start2.getLabel(), nodeName);
                startEdge.setAttribute("color", "green");
            }
            for (Object succ : this.cfg.getSuccsOf(node)) {
                String succName = String.valueOf(succ);
                Object succNodeContainer = this.getNodeContainer(succ);
                DotGraph dotGraph3 = (DotGraph)map.get(succNodeContainer);
                if (dotGraph3 == null) {
                    DotGraph dotGraph4;
                    GraphPlot it4 = this;
                    boolean bl4 = false;
                    DotGraph it5 = dotGraph4 = dot.createSubGraph("cluster_" + succNodeContainer);
                    boolean bl5 = false;
                    map.put(succNodeContainer, it5);
                    it5.setGraphLabel(String.valueOf(succNodeContainer));
                    it5.setGraphAttribute("style", "filled");
                    it5.setGraphAttribute("color", "lightgrey");
                    it5.setGraphAttribute("labeljust", "l");
                    it5.setNodeShape("box");
                    dotGraph3 = dotGraph4;
                }
                DotGraph sub2 = dotGraph3;
                DotGraphNode nodeTo = sub2.drawNode(succName);
                nodeTo.setHTMLLabel(this.getLabel(succ));
                DotGraphEdge edge = dot.drawEdge(nodeName, succName);
                edge.setAttribute("color", "blue");
                if (!Intrinsics.areEqual((Object)nodeContainer, (Object)succNodeContainer)) continue;
                edge.setAttribute("style", "dashed");
            }
        }
        return dot;
    }

    public static /* synthetic */ DotGraph plot$default(GraphPlot graphPlot, String string, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: plot");
        }
        if ((n & 1) != 0) {
            string = "DirectedGraph";
        }
        return graphPlot.plot(string);
    }

    @NotNull
    public String getLabel(N $this$getLabel) {
        return String.valueOf($this$getLabel);
    }

    public abstract C getNodeContainer(N var1);

    private static final Unit logger$lambda$5() {
        return Unit.INSTANCE;
    }
}

