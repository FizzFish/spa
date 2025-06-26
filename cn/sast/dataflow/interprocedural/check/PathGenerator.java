/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.PathGenerator
 *  cn.sast.dataflow.interprocedural.check.PathGeneratorKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.MutableDirectedGraph
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.check.PathGeneratorKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.MutableDirectedGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J4\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0015\u001a\u00028\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u0006*\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n*\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2={"Lcn/sast/dataflow/interprocedural/check/PathGenerator;", "P", "", "<init>", "()V", "shouldExplore", "", "getShouldExplore", "(Ljava/lang/Object;)Z", "preds", "", "getPreds", "(Ljava/lang/Object;)Ljava/util/Collection;", "flush", "", "", "g", "Lsoot/toolkits/graph/DirectedGraph;", "heads", "", "getHeads", "sink", "Lsoot/toolkits/graph/MutableDirectedGraph;", "(Ljava/lang/Object;Lsoot/toolkits/graph/MutableDirectedGraph;)Ljava/util/Set;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPathGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathGenerator.kt\ncn/sast/dataflow/interprocedural/check/PathGenerator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,213:1\n1279#2,2:214\n1293#2,4:216\n*S KotlinDebug\n*F\n+ 1 PathGenerator.kt\ncn/sast/dataflow/interprocedural/check/PathGenerator\n*L\n31#1:214,2\n31#1:216,4\n*E\n"})
public abstract class PathGenerator<P> {
    public abstract boolean getShouldExplore(@NotNull P var1);

    @NotNull
    public abstract Collection<P> getPreds(@NotNull P var1);

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Map<P, List<P>> flush(@NotNull DirectedGraph<P> g2, @NotNull Set<? extends P> heads) {
        Intrinsics.checkNotNullParameter(g2, (String)"g");
        Intrinsics.checkNotNullParameter(heads, (String)"heads");
        Iterable $this$associateWith$iv = heads;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        Iterator iterator2 = $this$associateWithTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void head;
            Object element$iv$iv;
            Object t = element$iv$iv = iterator2.next();
            Object t2 = element$iv$iv;
            Map map = result$iv;
            boolean bl = false;
            LinkedList pQueue = new LinkedList();
            pQueue.add(head);
            List event = new ArrayList();
            Set visit2 = new LinkedHashSet();
            block1: while (!pQueue.isEmpty()) {
                Object from;
                Intrinsics.checkNotNullExpressionValue(pQueue.remove(0), (String)"removeAt(...)");
                event.add(from);
                for (Object to : g2.getSuccsOf(from)) {
                    Intrinsics.checkNotNull(to);
                    event.add(to);
                    if (!visit2.add(to)) continue;
                    pQueue.add(to);
                    continue block1;
                }
            }
            List list = PathGeneratorKt.getRemoveAdjacentDuplicates((List)event);
            map.put(t2, list);
        }
        Map r = result$iv;
        return r;
    }

    @NotNull
    public final Set<P> getHeads(@NotNull P sink, @Nullable MutableDirectedGraph<P> g2) {
        Intrinsics.checkNotNullParameter(sink, (String)"sink");
        Set heads = new LinkedHashSet();
        LinkedList<Object> pQueue = new LinkedList<Object>();
        pQueue.add(sink);
        Set visit2 = new LinkedHashSet();
        while (!pQueue.isEmpty()) {
            Collection preds;
            Object node;
            Intrinsics.checkNotNullExpressionValue(pQueue.remove(0), (String)"removeAt(...)");
            if (!this.getShouldExplore(node)) continue;
            if (g2 != null && !g2.containsNode(node)) {
                g2.addNode(node);
            }
            if ((preds = this.getPreds(node)).isEmpty()) {
                ((Collection)heads).add(node);
            }
            for (Object pred : preds) {
                if (!this.getShouldExplore(pred)) continue;
                if (g2 != null) {
                    if (!g2.containsNode(pred)) {
                        g2.addNode(pred);
                    }
                    g2.addEdge(pred, node);
                }
                if (!visit2.add(pred)) continue;
                pQueue.add(pred);
            }
        }
        return heads;
    }

    public static /* synthetic */ Set getHeads$default(PathGenerator pathGenerator, Object object, MutableDirectedGraph mutableDirectedGraph, int n, Object object2) {
        if (object2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHeads");
        }
        if ((n & 2) != 0) {
            mutableDirectedGraph = null;
        }
        return pathGenerator.getHeads(object, mutableDirectedGraph);
    }
}

