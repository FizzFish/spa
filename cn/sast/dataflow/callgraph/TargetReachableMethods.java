/*
 * Copyright (c) 2023, SAPT
 */
package cn.sast.dataflow.callgraph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import soot.MethodOrMethodContext;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.Filter;
import soot.jimple.toolkits.callgraph.Sources;
import soot.util.queue.ChunkedQueue;
import soot.util.queue.QueueReader;

public class TargetReachableMethods {
    protected final ChunkedQueue<MethodOrMethodContext> reachables = new ChunkedQueue<>();
    protected final Set<MethodOrMethodContext> set = new HashSet<>();
    protected final QueueReader<MethodOrMethodContext> allReachables = reachables.reader();
    protected QueueReader<MethodOrMethodContext> unprocessedMethods;
    protected Iterator<Edge> edgeSource;
    protected CallGraph cg;
    protected Filter filter;

    public TargetReachableMethods(CallGraph graph, Iterator<? extends MethodOrMethodContext> lookupPoint, Filter filter) {
        this.filter = filter;
        this.cg = graph;
        addMethods(lookupPoint);
        unprocessedMethods = reachables.reader();
        edgeSource = filter == null ? graph.listener() : filter.wrap(graph.listener());
    }

    public TargetReachableMethods(CallGraph graph, Iterator<? extends MethodOrMethodContext> lookupPoint) {
        this(graph, lookupPoint, null);
    }

    public TargetReachableMethods(CallGraph graph, Collection<? extends MethodOrMethodContext> lookupPoint) {
        this(graph, lookupPoint.iterator());
    }

    protected void addMethods(Iterator<? extends MethodOrMethodContext> methods) {
        while (methods.hasNext()) {
            addMethod(methods.next());
        }
    }

    protected void addMethod(MethodOrMethodContext m) {
        if (set.add(m)) {
            reachables.add(m);
        }
    }

    public void update() {
        while (edgeSource.hasNext()) {
            Edge e = edgeSource.next();
            if (e == null || e.isInvalid()) continue;
            
            MethodOrMethodContext tgtMethod = e.getTgt();
            if (tgtMethod != null && set.contains(tgtMethod)) {
                addMethod(e.getSrc());
            }
        }

        while (unprocessedMethods.hasNext()) {
            MethodOrMethodContext m = unprocessedMethods.next();
            Iterator<Edge> sources = cg.edgesInto(m);
            if (filter != null) {
                sources = filter.wrap(sources);
            }
            addMethods(new Sources(sources));
        }
    }

    public QueueReader<MethodOrMethodContext> listener() {
        return allReachables.clone();
    }

    public QueueReader<MethodOrMethodContext> newListener() {
        return reachables.reader();
    }

    public boolean contains(MethodOrMethodContext m) {
        return set.contains(m);
    }

    public int size() {
        return set.size();
    }
}