/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.RefCntUnit
 *  cn.sast.dataflow.infoflow.svfa.SparseInfoflowSolverKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 *  soot.Unit
 *  soot.jimple.infoflow.collect.MyConcurrentHashMap
 *  soot.jimple.infoflow.problems.AbstractInfoflowProblem
 *  soot.jimple.toolkits.ide.icfg.BiDiInterproceduralCFG
 *  soot.util.queue.ChunkedQueue
 *  soot.util.queue.QueueReader
 */
package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.RefCntUnit;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.infoflow.collect.MyConcurrentHashMap;
import soot.jimple.infoflow.problems.AbstractInfoflowProblem;
import soot.jimple.toolkits.ide.icfg.BiDiInterproceduralCFG;
import soot.util.queue.ChunkedQueue;
import soot.util.queue.QueueReader;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u00004\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u00a2\u0006\u0002\u0010\t\u001a(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u000e\u001a\u00020\u000b\"'\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0010*\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"getGoThrough", "", "N", "M", "Lsoot/jimple/toolkits/ide/icfg/BiDiInterproceduralCFG;", "from", "to", "skipNodes", "", "(Lsoot/jimple/toolkits/ide/icfg/BiDiInterproceduralCFG;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Set;)Ljava/util/Set;", "getReachSet", "Lsoot/Unit;", "icfg", "Lsoot/SootMethod;", "target", "activationUnitsToCallSites", "Lsoot/jimple/infoflow/collect/MyConcurrentHashMap;", "Lsoot/jimple/infoflow/problems/AbstractInfoflowProblem;", "getActivationUnitsToCallSites", "(Lsoot/jimple/infoflow/problems/AbstractInfoflowProblem;)Lsoot/jimple/infoflow/collect/MyConcurrentHashMap;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nSparseInfoflowSolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseInfoflowSolver.kt\ncn/sast/dataflow/infoflow/svfa/SparseInfoflowSolverKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,232:1\n381#2,7:233\n774#3:240\n865#3,2:241\n1557#3:243\n1628#3,3:244\n*S KotlinDebug\n*F\n+ 1 SparseInfoflowSolver.kt\ncn/sast/dataflow/infoflow/svfa/SparseInfoflowSolverKt\n*L\n77#1:233,7\n86#1:240\n86#1:241,2\n86#1:243\n86#1:244,3\n*E\n"})
public final class SparseInfoflowSolverKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <M, N> Set<N> getGoThrough(@NotNull BiDiInterproceduralCFG<N, M> $this$getGoThrough, N from, N to, @NotNull Set<? extends N> skipNodes) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$getGoThrough, (String)"<this>");
        Intrinsics.checkNotNullParameter(skipNodes, (String)"skipNodes");
        if (Intrinsics.areEqual(from, to)) {
            Object[] objectArray = new Object[]{from};
            return SetsKt.mutableSetOf((Object[])objectArray);
        }
        Queue workList = new LinkedList();
        RefCntUnit startNode = new RefCntUnit(from, 1);
        workList.add(startNode);
        HashMap set = new HashMap();
        ((Map)set).put(startNode, startNode);
        while (!workList.isEmpty()) {
            RefCntUnit cur = (RefCntUnit)workList.poll();
            Object curNode = cur.getU();
            if (!skipNodes.contains(curNode)) {
                for (Object succ : $this$getGoThrough.getSuccsOf(curNode)) {
                    RefCntUnit next;
                    Object object;
                    RefCntUnit key2 = new RefCntUnit(succ, 1);
                    Map $this$getOrPut$iv = set;
                    boolean $i$f$getOrPut = false;
                    Object value$iv = $this$getOrPut$iv.get(key2);
                    if (value$iv == null) {
                        boolean bl = false;
                        RefCntUnit answer$iv = key2;
                        $this$getOrPut$iv.put(key2, answer$iv);
                        object = answer$iv;
                    } else {
                        object = value$iv;
                    }
                    if ((next = (RefCntUnit)object) == key2 && !Intrinsics.areEqual(succ, to)) {
                        workList.offer(next);
                    }
                    Intrinsics.checkNotNull((Object)cur);
                    next.add(cur);
                }
            }
            cur.dec();
        }
        Collection collection = set.values();
        Intrinsics.checkNotNullExpressionValue(collection, (String)"<get-values>(...)");
        Iterable $this$filter$iv = collection;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            RefCntUnit it = (RefCntUnit)element$iv$iv;
            boolean bl = false;
            if (!(it.getCnt() != 0)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            RefCntUnit it = (RefCntUnit)item$iv$iv;
            Collection collection2 = destination$iv$iv;
            boolean bl = false;
            collection2.add(it.getU());
        }
        return CollectionsKt.toMutableSet((Iterable)((List)destination$iv$iv));
    }

    public static /* synthetic */ Set getGoThrough$default(BiDiInterproceduralCFG biDiInterproceduralCFG, Object object, Object object2, Set set, int n, Object object3) {
        if ((n & 4) != 0) {
            set = SetsKt.emptySet();
        }
        return SparseInfoflowSolverKt.getGoThrough((BiDiInterproceduralCFG)biDiInterproceduralCFG, (Object)object, (Object)object2, (Set)set);
    }

    @NotNull
    public static final Set<Unit> getReachSet(@NotNull BiDiInterproceduralCFG<Unit, SootMethod> icfg, @NotNull Unit target) {
        Intrinsics.checkNotNullParameter(icfg, (String)"icfg");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        ChunkedQueue reaches = new ChunkedQueue();
        HashSet<Unit> reachSet = new HashSet<Unit>();
        reachSet.add(target);
        QueueReader reader = reaches.reader();
        reachSet.forEach((Consumer)new /* Unavailable Anonymous Inner Class!! */);
        while (reader.hasNext()) {
            for (Unit s : icfg.getSuccsOf(reader.next())) {
                if (!reachSet.add(s)) continue;
                reaches.add((Object)s);
            }
        }
        return reachSet;
    }

    @NotNull
    public static final MyConcurrentHashMap<Unit, Set<Unit>> getActivationUnitsToCallSites(@NotNull AbstractInfoflowProblem $this$activationUnitsToCallSites) {
        Intrinsics.checkNotNullParameter((Object)$this$activationUnitsToCallSites, (String)"<this>");
        Field field = AbstractInfoflowProblem.class.getDeclaredField("activationUnitsToCallSites");
        boolean bl = false;
        field.setAccessible(true);
        Object object = field.get($this$activationUnitsToCallSites);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type soot.jimple.infoflow.collect.MyConcurrentHashMap<soot.Unit, kotlin.collections.Set<soot.Unit>>");
        return (MyConcurrentHashMap)object;
    }
}

