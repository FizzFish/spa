/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.callgraph.TargetReachableMethods
 *  soot.MethodOrMethodContext
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.jimple.toolkits.callgraph.Edge
 *  soot.jimple.toolkits.callgraph.Filter
 *  soot.jimple.toolkits.callgraph.Sources
 *  soot.util.queue.ChunkedQueue
 *  soot.util.queue.QueueReader
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
    protected final ChunkedQueue<MethodOrMethodContext> reachables = new ChunkedQueue();
    protected final Set<MethodOrMethodContext> set = new HashSet();
    protected final QueueReader<MethodOrMethodContext> allReachables = this.reachables.reader();
    protected QueueReader<MethodOrMethodContext> unprocessedMethods;
    protected Iterator<Edge> edgeSource;
    protected CallGraph cg;
    protected Filter filter;

    public TargetReachableMethods(CallGraph graph, Iterator<? extends MethodOrMethodContext> lookupPoint, Filter filter2) {
        this.filter = filter2;
        this.cg = graph;
        this.addMethods(lookupPoint);
        this.unprocessedMethods = this.reachables.reader();
        this.edgeSource = filter2 == null ? graph.listener() : filter2.wrap((Iterator)graph.listener());
    }

    public TargetReachableMethods(CallGraph graph, Iterator<? extends MethodOrMethodContext> lookupPoint) {
        this(graph, lookupPoint, null);
    }

    public TargetReachableMethods(CallGraph graph, Collection<? extends MethodOrMethodContext> lookupPoint) {
        this(graph, lookupPoint.iterator());
    }

    protected void addMethods(Iterator<? extends MethodOrMethodContext> methods) {
        while (methods.hasNext()) {
            this.addMethod(methods.next());
        }
    }

    protected void addMethod(MethodOrMethodContext m) {
        if (this.set.add(m)) {
            this.reachables.add((Object)m);
        }
    }

    public void update() {
        while (this.edgeSource.hasNext()) {
            MethodOrMethodContext tgtMethod;
            Edge e = (Edge)this.edgeSource.next();
            if (e == null || (tgtMethod = e.getTgt()) == null || e.isInvalid() || !this.set.contains(tgtMethod)) continue;
            this.addMethod(e.getSrc());
        }
        while (this.unprocessedMethods.hasNext()) {
            MethodOrMethodContext m = (MethodOrMethodContext)this.unprocessedMethods.next();
            Iterator sources = this.cg.edgesInto(m);
            if (this.filter != null) {
                sources = this.filter.wrap(sources);
            }
            this.addMethods((Iterator)new Sources(sources));
        }
    }

    public QueueReader<MethodOrMethodContext> listener() {
        return this.allReachables.clone();
    }

    public QueueReader<MethodOrMethodContext> newListener() {
        return this.reachables.reader();
    }

    public boolean contains(MethodOrMethodContext m) {
        return this.set.contains(m);
    }

    public int size() {
        return this.set.size();
    }
}

