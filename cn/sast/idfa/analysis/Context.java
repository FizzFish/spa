package cn.sast.idfa.analysis;

import soot.Context;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.PseudoTopologicalOrderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Context<M, N, A> implements soot.Context, Comparable<Context<M, N, A>> {
    private static final AtomicInteger count = new AtomicInteger(0);
    
    private boolean isAnalyzable;
    private boolean isAnalysed;
    private boolean skipAnalysis;
    private boolean pathSensitiveEnable = true;
    
    @Nullable
    private Map<N, Integer> iteratorCount = new HashMap<>();
    @Nullable
    private Set<Pair<N, N>> widenNode = new HashSet<>();
    @NotNull
    private DirectedGraph<N> controlFlowGraph;
    
    @Nullable
    private A entryValue;
    @Nullable
    private A exitValue;
    private int id;
    private M method;
    
    @Nullable
    private List<N> orderedNodes;
    @Nullable
    private Map<N, A> inValues;
    @Nullable
    private Map<Pair<N, N>, A> edgeValues;
    @Nullable
    private Map<Triple<N, M, A>, A> callCalleeEdgeValues;
    
    @NotNull
    private NavigableSet<Pair<N, N>> worklist;
    @Nullable
    private N callNode;
    @Nullable
    private A bottomValue;

    public Context(M method, @NotNull DirectedGraph<N> cfg, boolean reverse, boolean isAnalyzable) {
        this.controlFlowGraph = Objects.requireNonNull(cfg, "cfg");
        this.isAnalyzable = isAnalyzable;
        this.id = count.getAndIncrement();
        this.method = method;
        this.controlFlowGraph = cfg;
        this.inValues = new LinkedHashMap<>(cfg.size());
        this.edgeValues = new LinkedHashMap<>(cfg.size() * 2);
        
        this.orderedNodes = new PseudoTopologicalOrderer().newList(cfg, reverse);
        Map<Pair<N, N>, Integer> numbers = new HashMap<>();
        int num = 1;
        
        for (N n : orderedNodes) {
            List<N> succs = cfg.getSuccsOf(n);
            if (succs.isEmpty()) {
                numbers.put(new Pair<>(n, n), num++);
            } else {
                for (N succ : succs) {
                    numbers.put(new Pair<>(n, succ), num++);
                }
            }
        }
        
        Comparator<Pair<N, N>> comparator = (u, v) -> {
            Integer uNum = numbers.get(u);
            Integer vNum = numbers.get(v);
            return uNum.compareTo(vNum);
        };
        
        this.worklist = new TreeSet<>(comparator);
        this.callCalleeEdgeValues = new LinkedHashMap<>(cfg.size() / 2);
    }

    @Override
    public int compareTo(@NotNull Context<M, N, A> other) {
        return other.id - this.id;
    }

    public A getEdgeValue(N node, N succ) {
        Objects.requireNonNull(edgeValues);
        A value = edgeValues.get(new Pair<>(node, succ));
        return value != null ? value : Objects.requireNonNull(bottomValue);
    }

    public void setEdgeValue(N node, N succ, A val) {
        Objects.requireNonNull(edgeValues).put(new Pair<>(node, succ), val);
    }

    @Nullable
    public A getValueBefore(N node) {
        Objects.requireNonNull(inValues);
        return inValues.get(node);
    }

    public void markAnalysed() {
        this.isAnalysed = true;
        this.callCalleeEdgeValues = null;
        this.edgeValues = null;
        this.inValues = null;
        this.iteratorCount = null;
        this.widenNode = null;
    }

    public void setEntryValue(A entryValue) {
        this.entryValue = entryValue;
    }

    public void setExitValue(A exitValue) {
        this.exitValue = exitValue;
    }

    public void setValueBefore(N node, A value) {
        Objects.requireNonNull(inValues).put(node, value);
    }

    @NotNull
    public String toString() {
        return (isAnalyzable ? "" : "NN") + " " + id + " : + " + method;
    }

    public void initworklist() {
        this.isAnalysed = false;
        Objects.requireNonNull(orderedNodes);
        
        for (N node : orderedNodes) {
            List<N> succs = controlFlowGraph.getSuccsOf(node);
            if (succs.isEmpty()) {
                worklist.add(new Pair<>(node, node));
                setEdgeValue(node, node, Objects.requireNonNull(bottomValue));
            } else {
                for (N succ : succs) {
                    worklist.add(new Pair<>(node, succ));
                    setEdgeValue(node, succ, Objects.requireNonNull(bottomValue));
                }
            }
        }
    }

    public void clearWorkList() {
        worklist.clear();
    }

    public void addToWorklist(N node) {
        List<N> succs = controlFlowGraph.getSuccsOf(node);
        if (succs.isEmpty()) {
            worklist.add(new Pair<>(node, node));
        } else {
            for (N succ : succs) {
                worklist.add(new Pair<>(node, succ));
            }
        }
    }

    public void setCallNode(N callNode) {
        this.callNode = callNode;
    }

    @Nullable
    public N getCallNode() {
        return callNode;
    }

    public boolean hasCallNode() {
        return callNode != null;
    }

    @Nullable
    public A getCallEdgeValue(N node, M callee, A entryValue) {
        Objects.requireNonNull(callCalleeEdgeValues);
        return callCalleeEdgeValues.get(new Triple<>(node, callee, entryValue));
    }

    public void setCallEdgeValue(N node, M callee, A entryValue, A out) {
        Objects.requireNonNull(callCalleeEdgeValues)
            .put(new Triple<>(node, callee, entryValue), out);
    }

    // Getters and setters
    public boolean isAnalyzable() { return isAnalyzable; }
    public void setAnalyzable(boolean isAnalyzable) { this.isAnalyzable = isAnalyzable; }
    public boolean isAnalysed() { return isAnalysed; }
    public boolean getSkipAnalysis() { return skipAnalysis; }
    public void setSkipAnalysis(boolean skipAnalysis) { this.skipAnalysis = skipAnalysis; }
    public boolean getPathSensitiveEnable() { return pathSensitiveEnable; }
    public void setPathSensitiveEnable(boolean pathSensitiveEnable) { this.pathSensitiveEnable = pathSensitiveEnable; }
    @Nullable public Map<N, Integer> getIteratorCount() { return iteratorCount; }
    public void setIteratorCount(@Nullable Map<N, Integer> iteratorCount) { this.iteratorCount = iteratorCount; }
    @Nullable public Set<Pair<N, N>> getWidenNode() { return widenNode; }
    public void setWidenNode(@Nullable Set<Pair<N, N>> widenNode) { this.widenNode = widenNode; }
    @NotNull public DirectedGraph<N> getControlFlowGraph() { return controlFlowGraph; }
    @Nullable public A getEntryValue() { return entryValue; }
    @Nullable public A getExitValue() { return exitValue; }
    public int getId() { return id; }
    public M getMethod() { return method; }
    @NotNull public NavigableSet<Pair<N, N>> getWorklist() { return worklist; }
    @Nullable public A getBottomValue() { return bottomValue; }
    public void setBottomValue(@Nullable A bottomValue) { this.bottomValue = bottomValue; }
}
