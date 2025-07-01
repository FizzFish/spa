package cn.sast.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.toolkits.graph.MutableDirectedGraph;

public final class HashMutableDirectedGraph<N> implements MutableDirectedGraph<N>, Cloneable {
    private static final Logger logger = LoggerFactory.getLogger(HashMutableDirectedGraph.class);
    
    private final Map<N, Set<N>> nodeToPreds;
    private final Map<N, Set<N>> nodeToSuccs;
    private final Set<N> heads;
    private final Set<N> tails;

    public HashMutableDirectedGraph() {
        this.nodeToPreds = new HashMap<>();
        this.nodeToSuccs = new HashMap<>();
        this.heads = new HashSet<>();
        this.tails = new HashSet<>();
    }

    public HashMutableDirectedGraph(@NotNull HashMutableDirectedGraph<N> orig) {
        this.nodeToPreds = deepCopy(orig.nodeToPreds);
        this.nodeToSuccs = deepCopy(orig.nodeToSuccs);
        this.heads = new HashSet<>(orig.heads);
        this.tails = new HashSet<>(orig.tails);
    }

    @Override
    public Object clone() {
        return new HashMutableDirectedGraph<>(this);
    }

    public void clearAll() {
        nodeToPreds.clear();
        nodeToSuccs.clear();
        heads.clear();
        tails.clear();
    }

    @Override
    public @NotNull List<N> getHeads() {
        return getCopy(heads);
    }

    @Override
    public @NotNull List<N> getTails() {
        return getCopy(tails);
    }

    @Override
    public @NotNull List<N> getPredsOf(N s) {
        Set<N> preds = nodeToPreds.get(s);
        return preds != null ? getCopy(preds) : Collections.emptyList();
    }

    public @NotNull Set<N> getPredsOfAsSet(N s) {
        Set<N> preds = nodeToPreds.get(s);
        return preds != null ? Collections.unmodifiableSet(preds) : Collections.emptySet();
    }

    @Override
    public @NotNull List<N> getSuccsOf(N s) {
        Set<N> succs = nodeToSuccs.get(s);
        return succs != null ? getCopy(succs) : Collections.emptyList();
    }

    public @NotNull Set<N> getSuccsOfAsSet(N s) {
        Set<N> succs = nodeToSuccs.get(s);
        return succs != null ? Collections.unmodifiableSet(succs) : Collections.emptySet();
    }

    @Override
    public int size() {
        return nodeToPreds.size();
    }

    @Override
    public @NotNull Iterator<N> iterator() {
        return nodeToPreds.keySet().iterator();
    }

    @Override
    public void addEdge(N from, N to) {
        if (containsEdge(from, to)) {
            return;
        }

        Set<N> succsList = nodeToSuccs.computeIfAbsent(from, k -> {
            heads.add(from);
            return new LinkedHashSet<>();
        });

        Set<N> predsList = nodeToPreds.computeIfAbsent(to, k -> {
            tails.add(to);
            return new LinkedHashSet<>();
        });

        heads.remove(to);
        tails.remove(from);
        succsList.add(to);
        predsList.add(from);
    }

    @Override
    public void removeEdge(N from, N to) {
        Set<N> succs = nodeToSuccs.get(from);
        if (succs == null || !succs.contains(to)) {
            return;
        }

        Set<N> preds = nodeToPreds.get(to);
        if (preds == null) {
            throw new RuntimeException(to + " not in graph!");
        }

        succs.remove(to);
        preds.remove(from);

        if (succs.isEmpty()) {
            tails.add(from);
            nodeToSuccs.remove(from);
        }
        if (preds.isEmpty()) {
            heads.add(to);
            nodeToPreds.remove(to);
        }

        removeSingle(from);
        removeSingle(to);
    }

    private void removeSingle(N n) {
        Set<N> succs = nodeToSuccs.get(n);
        Set<N> preds = nodeToPreds.get(n);

        if ((succs == null || succs.isEmpty()) && heads.contains(n)) {
            heads.remove(n);
        }
        if ((preds == null || preds.isEmpty()) && tails.contains(n)) {
            tails.remove(n);
        }
    }

    @Override
    public boolean containsEdge(N from, N to) {
        Set<N> succs = nodeToSuccs.get(from);
        return succs != null && succs.contains(to);
    }

    @Override
    public boolean containsNode(N node) {
        return nodeToPreds.containsKey(node);
    }

    @Override
    public @NotNull List<N> getNodes() {
        return getCopy(nodeToPreds.keySet());
    }

    @Override
    public void addNode(N node) {
        if (containsNode(node)) {
            return;
        }

        nodeToSuccs.computeIfAbsent(node, k -> new LinkedHashSet<>());
        nodeToPreds.computeIfAbsent(node, k -> new LinkedHashSet<>());
        heads.add(node);
        tails.add(node);
    }

    @Override
    public void removeNode(N node) {
        Set<N> succs = nodeToSuccs.get(node);
        if (succs != null) {
            new ArrayList<>(succs).forEach(n -> removeEdge(node, n));
        }
        nodeToSuccs.remove(node);

        Set<N> preds = nodeToPreds.get(node);
        if (preds != null) {
            new ArrayList<>(preds).forEach(n -> removeEdge(n, node));
        }
        nodeToPreds.remove(node);

        heads.remove(node);
        tails.remove(node);
    }

    public void printGraph() {
        for (N node : this) {
            logger.debug("Node = {}", node);
            logger.debug("Preds:");
            for (N p : getPredsOf(node)) {
                logger.debug("     {}", p);
            }
            logger.debug("Succs:");
            for (N s : getSuccsOf(node)) {
                logger.debug("     {}", s);
            }
        }
    }

    private static <T> List<T> getCopy(Collection<T> collection) {
        return new ArrayList<>(collection);
    }

    private static <K, V> Map<K, Set<V>> deepCopy(Map<K, Set<V>> original) {
        Map<K, Set<V>> copy = new HashMap<>();
        original.forEach((k, v) -> copy.put(k, new LinkedHashSet<>(v)));
        return copy;
    }
}
