package cn.sast.graph;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import soot.toolkits.graph.DirectedGraph;
import soot.util.dot.DotGraph;
import soot.util.dot.DotGraphEdge;
import soot.util.dot.DotGraphNode;

public abstract class GraphPlot<C, N> {
    private static final mu.KLogger logger = mu.KotlinLogging.INSTANCE.logger("GraphPlot");
    
    @NotNull
    private final DirectedGraph<N> cfg;

    public GraphPlot(@NotNull DirectedGraph<N> cfg) {
        if (cfg == null) {
            throw new IllegalArgumentException("cfg cannot be null");
        }
        this.cfg = cfg;
    }

    @NotNull
    public final DirectedGraph<N> getCfg() {
        return cfg;
    }

    @NotNull
    public final DotGraph plot(@NotNull String graphName) {
        if (graphName == null) {
            throw new IllegalArgumentException("graphName cannot be null");
        }

        DotGraph dot = new DotGraph(graphName);
        dot.setGraphAttribute("style", "filled");
        dot.setGraphAttribute("color", "lightgrey");
        dot.setGraphAttribute("rankdir", "LR");
        dot.setGraphAttribute("ranksep", "8");
        dot.setNodeShape("box");

        Map<Object, DotGraph> map = new LinkedHashMap<>();
        
        DotGraph startCluster = dot.createSubGraph("cluster_start");
        startCluster.setGraphLabel("START");
        startCluster.setGraphAttribute("style", "filled");
        startCluster.setGraphAttribute("color", "lightgrey");
        startCluster.setNodeShape("box");

        for (N node : cfg) {
            String nodeName = String.valueOf(node);
            C nodeContainer = getNodeContainer(node);
            
            DotGraph sub = map.computeIfAbsent(nodeContainer, k -> {
                DotGraph cluster = dot.createSubGraph("cluster_" + k);
                cluster.setGraphLabel(String.valueOf(k));
                cluster.setGraphAttribute("style", "filled");
                cluster.setGraphAttribute("color", "lightgrey");
                cluster.setGraphAttribute("labeljust", "l");
                cluster.setNodeShape("box");
                return cluster;
            });

            DotGraphNode fromNode = sub.drawNode(nodeName);
            fromNode.setHTMLLabel(getLabel(node));

            if (cfg.getHeads().contains(node)) {
                fromNode.setAttribute("color", "blue");
                DotGraphEdge startEdge = dot.drawEdge(startCluster.getLabel(), nodeName);
                startEdge.setAttribute("color", "green");
            }

            for (N succ : cfg.getSuccsOf(node)) {
                String succName = String.valueOf(succ);
                C succNodeContainer = getNodeContainer(succ);
                
                DotGraph succSub = map.computeIfAbsent(succNodeContainer, k -> {
                    DotGraph cluster = dot.createSubGraph("cluster_" + k);
                    cluster.setGraphLabel(String.valueOf(k));
                    cluster.setGraphAttribute("style", "filled");
                    cluster.setGraphAttribute("color", "lightgrey");
                    cluster.setGraphAttribute("labeljust", "l");
                    cluster.setNodeShape("box");
                    return cluster;
                });

                DotGraphNode nodeTo = succSub.drawNode(succName);
                nodeTo.setHTMLLabel(getLabel(succ));
                
                DotGraphEdge edge = dot.drawEdge(nodeName, succName);
                edge.setAttribute("color", "blue");
                
                if (nodeContainer.equals(succNodeContainer)) {
                    edge.setAttribute("style", "dashed");
                }
            }
        }
        return dot;
    }

    @NotNull
    public String getLabel(N node) {
        return String.valueOf(node);
    }

    public abstract C getNodeContainer(N node);
}