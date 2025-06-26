/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.graph.HashMutableDirectedGraph
 *  cn.sast.graph.NoBackEdgeDirectGraph
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0013J\u0006\u0010\u001b\u001a\u00020\u0012R,\u0010\u0005\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006 "}, d2={"Lcn/sast/graph/NoBackEdgeDirectGraph;", "N", "", "<init>", "()V", "predView", "", "", "directedGraph", "Lcn/sast/graph/HashMutableDirectedGraph;", "getPredsTaskOf", "from", "(Ljava/lang/Object;)Ljava/util/Set;", "addEdge", "", "to", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeEdge", "", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getPredSize", "", "(Ljava/lang/Object;)I", "addEdgeSynchronized", "removeEdgeSynchronized", "isComplete", "()Z", "cleanUp", "heads", "", "getHeads", "()Ljava/util/List;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nNoBackEdgeDirectGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoBackEdgeDirectGraph.kt\ncn/sast/graph/NoBackEdgeDirectGraph\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1#2:112\n*E\n"})
public final class NoBackEdgeDirectGraph<N> {
    @NotNull
    private Map<N, Map<N, Set<N>>> predView = new HashMap();
    @NotNull
    private HashMutableDirectedGraph<N> directedGraph = new HashMutableDirectedGraph();

    @NotNull
    public final Set<N> getPredsTaskOf(N from) {
        Set predTaskOfFrom = new LinkedHashSet();
        for (Object pred : this.directedGraph.getPredsOfAsSet(from)) {
            Object object = (Map)this.predView.get(pred);
            if (object == null || (object = (Set)object.get(from)) == null) continue;
            Object predOfFrom = object;
            predTaskOfFrom.addAll((Collection)predOfFrom);
        }
        return predTaskOfFrom;
    }

    public final boolean addEdge(N from, N to) {
        if (Intrinsics.areEqual(from, to)) {
            return false;
        }
        Set predTaskOfFrom = this.getPredsTaskOf(from);
        if (predTaskOfFrom.contains(to)) {
            return false;
        }
        predTaskOfFrom.add(from);
        this.directedGraph.addEdge(from, to);
        Queue workList = new LinkedList();
        workList.add(from);
        HashSet<Object> set = new HashSet<Object>();
        set.add(from);
        while (!workList.isEmpty()) {
            Object cur = workList.poll();
            Set succ = this.directedGraph.getSuccsOfAsSet(cur);
            for (Object next : succ) {
                Set predTaskOfCur;
                Map curView = (Map)this.predView.get(cur);
                if (curView == null) {
                    curView = new HashMap();
                    this.predView.put(cur, curView);
                }
                if ((predTaskOfCur = (Set)curView.get(next)) == null) {
                    predTaskOfCur = new HashSet();
                    curView.put(next, predTaskOfCur);
                }
                if (predTaskOfCur.containsAll(predTaskOfFrom)) continue;
                if (set.add(next)) {
                    workList.add(next);
                }
                predTaskOfCur.addAll(predTaskOfFrom);
            }
        }
        return true;
    }

    public final void removeEdge(N from, N to) {
        Map predOfFrom;
        Map map;
        this.directedGraph.removeEdge(from, to);
        Map map2 = (Map)this.predView.get(from);
        if (map2 != null) {
            Map map3;
            Map it = map3 = map2;
            boolean bl = false;
            it.remove(to);
            map = map3;
        } else {
            map = null;
        }
        Map map4 = predOfFrom = map;
        boolean bl = map4 != null ? map4.isEmpty() : false;
        if (bl) {
            this.predView.remove(from);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final int getPredSize(N from) {
        NoBackEdgeDirectGraph noBackEdgeDirectGraph = this;
        synchronized (noBackEdgeDirectGraph) {
            boolean bl = false;
            Set predTaskOfFrom = this.getPredsTaskOf(from);
            int n = predTaskOfFrom.size();
            return n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean addEdgeSynchronized(N from, N to) {
        NoBackEdgeDirectGraph noBackEdgeDirectGraph = this;
        synchronized (noBackEdgeDirectGraph) {
            boolean bl = false;
            boolean bl2 = this.addEdge(from, to);
            return bl2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void removeEdgeSynchronized(N from, N to) {
        NoBackEdgeDirectGraph noBackEdgeDirectGraph = this;
        synchronized (noBackEdgeDirectGraph) {
            boolean bl = false;
            this.removeEdge(from, to);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean isComplete() {
        return this.predView.isEmpty() && this.directedGraph.size() == 0 && this.directedGraph.getHeads().isEmpty() && this.directedGraph.getTails().isEmpty();
    }

    public final void cleanUp() {
        this.predView.clear();
        this.directedGraph.clearAll();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final List<N> getHeads() {
        List list;
        NoBackEdgeDirectGraph noBackEdgeDirectGraph = this;
        synchronized (noBackEdgeDirectGraph) {
            boolean bl = false;
            list = this.directedGraph.getHeads();
        }
        return list;
    }
}

