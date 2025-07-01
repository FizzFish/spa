package cn.sast.dataflow.interprocedural.check;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.MutableDirectedGraph;

public abstract class PathGenerator<P> {
    public abstract boolean getShouldExplore(@NotNull P node);

    @NotNull
    public abstract Collection<P> getPreds(@NotNull P node);

    @NotNull
    public final Map<P, List<P>> flush(@NotNull DirectedGraph<P> graph, @NotNull Set<? extends P> heads) {
        if (graph == null) throw new IllegalArgumentException("graph cannot be null");
        if (heads == null) throw new IllegalArgumentException("heads cannot be null");

        Map<P, List<P>> result = new LinkedHashMap<>(Math.max(heads.size(), 16));
        
        for (P head : heads) {
            LinkedList<P> queue = new LinkedList<>();
            queue.add(head);
            List<P> path = new ArrayList<>();
            Set<P> visited = new LinkedHashSet<>();
            
            while (!queue.isEmpty()) {
                P from = queue.remove(0);
                path.add(from);
                
                for (P to : graph.getSuccsOf(from)) {
                    path.add(to);
                    if (!visited.add(to)) continue;
                    queue.add(to);
                    break;
                }
            }
            
            result.put(head, PathGeneratorKt.getRemoveAdjacentDuplicates(path));
        }
        
        return result;
    }

    @NotNull
    public final Set<P> getHeads(@NotNull P sink, @Nullable MutableDirectedGraph<P> graph) {
        if (sink == null) throw new IllegalArgumentException("sink cannot be null");

        Set<P> heads = new LinkedHashSet<>();
        LinkedList<P> queue = new LinkedList<>();
        queue.add(sink);
        Set<P> visited = new LinkedHashSet<>();
        
        while (!queue.isEmpty()) {
            P node = queue.remove(0);
            if (!getShouldExplore(node)) continue;
            
            if (graph != null && !graph.containsNode(node)) {
                graph.addNode(node);
            }
            
            Collection<P> preds = getPreds(node);
            if (preds.isEmpty()) {
                heads.add(node);
            }
            
            for (P pred : preds) {
                if (!getShouldExplore(pred)) continue;
                
                if (graph != null) {
                    if (!graph.containsNode(pred)) {
                        graph.addNode(pred);
                    }
                    graph.addEdge(pred, node);
                }
                
                if (visited.add(pred)) {
                    queue.add(pred);
                }
            }
        }
        
        return heads;
    }
}
