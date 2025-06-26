/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.analysis.Context
 *  cn.sast.idfa.analysis.Context$Companion
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Triple
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Context
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.PseudoTopologicalOrderer
 */
package cn.sast.idfa.analysis;

import cn.sast.idfa.analysis.Context;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.PseudoTopologicalOrderer;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u0000 b*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u00042\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00000\u0005:\u0001bB/\b\u0016\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ#\u0010C\u001a\u00020\u001b2\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000H\u0096\u0002J\u001b\u0010E\u001a\u00028\u00022\u0006\u0010F\u001a\u00028\u00012\u0006\u0010G\u001a\u00028\u0001\u00a2\u0006\u0002\u0010HJ#\u0010I\u001a\u00020J2\u0006\u0010F\u001a\u00028\u00012\u0006\u0010G\u001a\u00028\u00012\u0006\u0010K\u001a\u00028\u0002\u00a2\u0006\u0002\u0010LJ\u0015\u0010M\u001a\u0004\u0018\u00018\u00022\u0006\u0010F\u001a\u00028\u0001\u00a2\u0006\u0002\u0010NJ\u0006\u0010O\u001a\u00020JJ\u0013\u0010P\u001a\u00020J2\u0006\u0010*\u001a\u00028\u0002\u00a2\u0006\u0002\u0010BJ\u0013\u0010Q\u001a\u00020J2\u0006\u0010.\u001a\u00028\u0002\u00a2\u0006\u0002\u0010BJ\u001b\u0010R\u001a\u00020J2\u0006\u0010F\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u0002\u00a2\u0006\u0002\u0010SJ\b\u0010T\u001a\u00020UH\u0016J\u0006\u0010V\u001a\u00020JJ\u0006\u0010W\u001a\u00020JJ\u0013\u0010X\u001a\u00020J2\u0006\u0010F\u001a\u00028\u0001\u00a2\u0006\u0002\u0010BJ\u0013\u0010Y\u001a\u00020J2\u0006\u0010>\u001a\u00028\u0001\u00a2\u0006\u0002\u0010BJ\r\u0010Z\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010,J\u0006\u0010[\u001a\u00020\nJ%\u0010\\\u001a\u0004\u0018\u00018\u00022\u0006\u0010F\u001a\u00028\u00012\u0006\u0010]\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0002\u00a2\u0006\u0002\u0010^J+\u0010_\u001a\u00020J2\u0006\u0010F\u001a\u00028\u00012\u0006\u0010]\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u00022\u0006\u0010`\u001a\u00028\u0002\u00a2\u0006\u0002\u0010aR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010 \u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\"\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00018\u00022\b\u0010\u0011\u001a\u0004\u0018\u00018\u0002@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00018\u00022\b\u0010\u0011\u001a\u0004\u0018\u00018\u0002@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b/\u0010,R\u001e\u00100\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u001b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R \u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0000@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b3\u0010,R\u0016\u00104\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000105X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u00107\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\"\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u00108\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000209\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000RB\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\"0:2\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\"0:@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0012\u0010>\u001a\u0004\u0018\u00018\u0001X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010-R\u001e\u0010?\u001a\u0004\u0018\u00018\u0002X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\b@\u0010,\"\u0004\bA\u0010B\u00a8\u0006c"}, d2={"Lcn/sast/idfa/analysis/Context;", "M", "N", "A", "Lsoot/Context;", "", "method", "cfg", "Lsoot/toolkits/graph/DirectedGraph;", "reverse", "", "isAnalyzable", "<init>", "(Ljava/lang/Object;Lsoot/toolkits/graph/DirectedGraph;ZZ)V", "()Z", "setAnalyzable", "(Z)V", "value", "isAnalysed", "skipAnalysis", "getSkipAnalysis", "setSkipAnalysis", "pathSensitiveEnable", "getPathSensitiveEnable", "setPathSensitiveEnable", "iteratorCount", "", "", "getIteratorCount", "()Ljava/util/Map;", "setIteratorCount", "(Ljava/util/Map;)V", "widenNode", "", "Lkotlin/Pair;", "getWidenNode", "()Ljava/util/Set;", "setWidenNode", "(Ljava/util/Set;)V", "controlFlowGraph", "getControlFlowGraph", "()Lsoot/toolkits/graph/DirectedGraph;", "entryValue", "getEntryValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "exitValue", "getExitValue", "id", "getId", "()I", "getMethod", "orderedNodes", "", "inValues", "edgeValues", "callCalleeEdgeValues", "Lkotlin/Triple;", "Ljava/util/NavigableSet;", "worklist", "getWorklist", "()Ljava/util/NavigableSet;", "callNode", "bottomValue", "getBottomValue", "setBottomValue", "(Ljava/lang/Object;)V", "compareTo", "other", "getEdgeValue", "node", "succ", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "setEdgeValue", "", "val", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getValueBefore", "(Ljava/lang/Object;)Ljava/lang/Object;", "markAnalysed", "setEntryValue", "setExitValue", "setValueBefore", "(Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "", "initworklist", "clearWorkList", "addToWorklist", "setCallNode", "getCallNode", "hasCallNode", "getCallEdgeValue", "callee", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "setCallEdgeValue", "out", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Companion", "corax-idfa-framework"})
public class Context<M, N, A>
implements soot.Context,
Comparable<Context<M, N, A>> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean isAnalyzable;
    private boolean isAnalysed;
    private boolean skipAnalysis;
    private boolean pathSensitiveEnable;
    @Nullable
    private Map<N, Integer> iteratorCount;
    @Nullable
    private Set<Pair<N, N>> widenNode;
    @NotNull
    private DirectedGraph<N> controlFlowGraph;
    @Nullable
    private A entryValue;
    @Nullable
    private A exitValue;
    private int id;
    private M method;
    @Nullable
    private List<? extends N> orderedNodes;
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
    @NotNull
    private static final AtomicInteger count = new AtomicInteger(0);

    public final boolean isAnalyzable() {
        return this.isAnalyzable;
    }

    public final void setAnalyzable(boolean bl) {
        this.isAnalyzable = bl;
    }

    public final boolean isAnalysed() {
        return this.isAnalysed;
    }

    public final boolean getSkipAnalysis() {
        return this.skipAnalysis;
    }

    public final void setSkipAnalysis(boolean bl) {
        this.skipAnalysis = bl;
    }

    public final boolean getPathSensitiveEnable() {
        return this.pathSensitiveEnable;
    }

    public final void setPathSensitiveEnable(boolean bl) {
        this.pathSensitiveEnable = bl;
    }

    @Nullable
    public final Map<N, Integer> getIteratorCount() {
        return this.iteratorCount;
    }

    public final void setIteratorCount(@Nullable Map<N, Integer> map) {
        this.iteratorCount = map;
    }

    @Nullable
    public final Set<Pair<N, N>> getWidenNode() {
        return this.widenNode;
    }

    public final void setWidenNode(@Nullable Set<Pair<N, N>> set) {
        this.widenNode = set;
    }

    @NotNull
    public final DirectedGraph<N> getControlFlowGraph() {
        return this.controlFlowGraph;
    }

    @Nullable
    public final A getEntryValue() {
        return (A)this.entryValue;
    }

    @Nullable
    public final A getExitValue() {
        return (A)this.exitValue;
    }

    public final int getId() {
        return this.id;
    }

    public final M getMethod() {
        return (M)this.method;
    }

    @NotNull
    public final NavigableSet<Pair<N, N>> getWorklist() {
        return this.worklist;
    }

    @Nullable
    public final A getBottomValue() {
        return (A)this.bottomValue;
    }

    public final void setBottomValue(@Nullable A a) {
        this.bottomValue = a;
    }

    /*
     * WARNING - void declaration
     */
    public Context(M method, @NotNull DirectedGraph<N> cfg, boolean reverse, boolean isAnalyzable) {
        void it;
        List list;
        Intrinsics.checkNotNullParameter(cfg, (String)"cfg");
        this.pathSensitiveEnable = true;
        this.iteratorCount = new HashMap();
        this.widenNode = new HashSet();
        this.isAnalyzable = isAnalyzable;
        this.id = count.getAndIncrement();
        this.method = method;
        this.isAnalysed = false;
        this.controlFlowGraph = cfg;
        this.inValues = new LinkedHashMap(cfg.size());
        this.edgeValues = new LinkedHashMap(cfg.size() * 2);
        List list2 = list = new PseudoTopologicalOrderer().newList(this.controlFlowGraph, reverse);
        Context context = this;
        boolean bl = false;
        Map numbers = new HashMap();
        int num = 1;
        for (Object n : it) {
            List succs = cfg.getSuccsOf(n);
            if (succs.isEmpty()) {
                Integer n2 = num;
                numbers.put(new Pair(n, n), n2);
                ++num;
                continue;
            }
            for (Object succ : cfg.getSuccsOf(n)) {
                Integer n3 = num;
                numbers.put(new Pair(n, succ), n3);
                ++num;
            }
        }
        Function2 function2 = (arg_0, arg_1) -> Context._init_$lambda$1$lambda$0(numbers, arg_0, arg_1);
        this.worklist = new TreeSet((Comparator)new /* Unavailable Anonymous Inner Class!! */);
        context.orderedNodes = list;
        this.callCalleeEdgeValues = new LinkedHashMap(cfg.size() / 2);
    }

    @Override
    public int compareTo(@NotNull Context<M, N, A> other) {
        Intrinsics.checkNotNullParameter(other, (String)"other");
        return other.id - this.id;
    }

    public final A getEdgeValue(N node, N succ) {
        Map map = this.edgeValues;
        Intrinsics.checkNotNull((Object)map);
        Object object = map.get(new Pair(node, succ));
        if (object == null) {
            Object object2 = this.bottomValue;
            object = object2;
            Intrinsics.checkNotNull((Object)object2);
        }
        return (A)object;
    }

    public final void setEdgeValue(N node, N succ, A val) {
        Map map = this.edgeValues;
        Intrinsics.checkNotNull((Object)map);
        map.put(new Pair(node, succ), val);
    }

    @Nullable
    public final A getValueBefore(N node) {
        Map map = this.inValues;
        Intrinsics.checkNotNull((Object)map);
        return (A)map.get(node);
    }

    public final void markAnalysed() {
        this.isAnalysed = true;
        this.callCalleeEdgeValues = null;
        this.edgeValues = null;
        this.inValues = null;
        this.iteratorCount = null;
        this.widenNode = null;
    }

    public final void setEntryValue(A entryValue) {
        this.entryValue = entryValue;
    }

    public final void setExitValue(A exitValue) {
        this.exitValue = exitValue;
    }

    public final void setValueBefore(N node, A value) {
        Map map = this.inValues;
        Intrinsics.checkNotNull((Object)map);
        map.put(node, value);
    }

    @NotNull
    public String toString() {
        return (this.isAnalyzable ? "" : "NN") + " " + this.id + " : + " + this.method;
    }

    public final void initworklist() {
        this.isAnalysed = false;
        List list = this.orderedNodes;
        Intrinsics.checkNotNull((Object)list);
        for (Object node : list) {
            List succs = this.controlFlowGraph.getSuccsOf(node);
            if (succs.isEmpty()) {
                this.worklist.add(new Pair(node, node));
                Object object = this.bottomValue;
                Intrinsics.checkNotNull((Object)object);
                this.setEdgeValue(node, node, object);
                continue;
            }
            for (Object succ : succs) {
                this.worklist.add(new Pair(node, succ));
                Object object = this.bottomValue;
                Intrinsics.checkNotNull((Object)object);
                this.setEdgeValue(node, succ, object);
            }
        }
    }

    public final void clearWorkList() {
        this.worklist.clear();
    }

    public final void addToWorklist(N node) {
        List succs = this.controlFlowGraph.getSuccsOf(node);
        if (succs.isEmpty()) {
            this.worklist.add(new Pair(node, node));
        } else {
            for (Object succ : succs) {
                this.worklist.add(new Pair(node, succ));
            }
        }
    }

    public final void setCallNode(N callNode) {
        this.callNode = callNode;
    }

    @Nullable
    public final N getCallNode() {
        return (N)this.callNode;
    }

    public final boolean hasCallNode() {
        return this.callNode != null;
    }

    @Nullable
    public final A getCallEdgeValue(N node, M callee, A entryValue) {
        Map map = this.callCalleeEdgeValues;
        Intrinsics.checkNotNull((Object)map);
        return (A)map.get(new Triple(node, callee, entryValue));
    }

    public final void setCallEdgeValue(N node, M callee, A entryValue, A out) {
        Map map = this.callCalleeEdgeValues;
        Intrinsics.checkNotNull((Object)map);
        map.put(new Triple(node, callee, entryValue), out);
    }

    private static final int _init_$lambda$1$lambda$0(Map $numbers, Pair u, Pair v) {
        Object v2 = $numbers.get(u);
        Intrinsics.checkNotNull(v2);
        int n = ((Number)v2).intValue();
        Object v3 = $numbers.get(v);
        Intrinsics.checkNotNull(v3);
        return n - ((Number)v3).intValue();
    }

    public static final /* synthetic */ AtomicInteger access$getCount$cp() {
        return count;
    }
}

