package cn.sast.graph;

import cn.sast.graph.HashMutableDirectedGraph;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class NoBackEdgeDirectGraph<N> {
    @NotNull
    private Map<N, Map<N, Set<N>>> predView = new HashMap<>();
    @NotNull
    private HashMutableDirectedGraph<N> directedGraph = new HashMutableDirectedGraph<>();

    @NotNull
    public Set<N> getPredsTaskOf(N from) {
        Set<N> predTaskOfFrom = new LinkedHashSet<>();
        for (N pred : this.directedGraph.getPredsOfAsSet(from)) {
            Map<N, Set<N>> predMap = this.predView.get(pred);
            if (predMap != null) {
                Set<N> predSet = predMap.get(from);
                if (predSet != null) {
                    predTaskOfFrom.addAll(predSet);
                }
            }
        }
        return predTaskOfFrom;
    }

    public boolean addEdge(N from, N to) {
        if (from.equals(to)) {
            return false;
        }
        Set<N> predTaskOfFrom = this.getPredsTaskOf(from);
        if (predTaskOfFrom.contains(to)) {
            return false;
        }
        predTaskOfFrom.add(from);
        this.directedGraph.addEdge(from, to);
        
        Queue<N> workList = new LinkedList<>();
        workList.add(from);
        Set<N> visited = new HashSet<>();
        visited.add(from);
        
        while (!workList.isEmpty()) {
            N cur = workList.poll();
            Set<N> succ = this.directedGraph.getSuccsOfAsSet(cur);
            for (N next : succ) {
                Map<N, Set<N>> curView = this.predView.computeIfAbsent(cur, k -> new HashMap<>());
                Set<N> predTaskOfCur = curView.computeIfAbsent(next, k -> new HashSet<>());
                
                if (!predTaskOfCur.containsAll(predTaskOfFrom)) {
                    if (visited.add(next)) {
                        workList.add(next);
                    }
                    predTaskOfCur.addAll(predTaskOfFrom);
                }
            }
        }
        return true;
    }

    public void removeEdge(N from, N to) {
        this.directedGraph.removeEdge(from, to);
        Map<N, Set<N>> fromView = this.predView.get(from);
        if (fromView != null) {
            fromView.remove(to);
            if (fromView.isEmpty()) {
                this.predView.remove(from);
            }
        }
    }

    public synchronized int getPredSize(N from) {
        return this.getPredsTaskOf(from).size();
    }

    public synchronized boolean addEdgeSynchronized(N from, N to) {
        return this.addEdge(from, to);
    }

    public synchronized void removeEdgeSynchronized(N from, N to) {
        this.removeEdge(from, to);
    }

    public boolean isComplete() {
        return this.predView.isEmpty() 
            && this.directedGraph.size() == 0 
            && this.directedGraph.getHeads().isEmpty() 
            && this.directedGraph.getTails().isEmpty();
    }

    public void cleanUp() {
        this.predView.clear();
        this.directedGraph.clearAll();
    }

    @NotNull
    public synchronized List<N> getHeads() {
        return this.directedGraph.getHeads();
    }
}