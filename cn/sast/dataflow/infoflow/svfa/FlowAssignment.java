/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.AP
 *  cn.sast.dataflow.infoflow.svfa.FlowAnalysisOp
 *  cn.sast.dataflow.infoflow.svfa.FlowAssignment
 *  cn.sast.dataflow.infoflow.svfa.FlowFact
 *  cn.sast.dataflow.infoflow.svfa.SparsePropgrateAnalyzeKt
 *  cn.sast.dataflow.infoflow.svfa.VFNode
 *  cn.sast.dataflow.infoflow.svfa.ValueLocation
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentSet
 *  org.jetbrains.annotations.NotNull
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.ReturnStmt
 *  soot.jimple.ReturnVoidStmt
 *  soot.jimple.Stmt
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.scalar.BackwardFlowAnalysis
 *  soot.toolkits.scalar.FlowAnalysis$Flow
 */
package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.AP;
import cn.sast.dataflow.infoflow.svfa.FlowAnalysisOp;
import cn.sast.dataflow.infoflow.svfa.FlowFact;
import cn.sast.dataflow.infoflow.svfa.SparsePropgrateAnalyzeKt;
import cn.sast.dataflow.infoflow.svfa.VFNode;
import cn.sast.dataflow.infoflow.svfa.ValueLocation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import soot.Unit;
import soot.Value;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.Stmt;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.BackwardFlowAnalysis;
import soot.toolkits.scalar.FlowAnalysis;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BI\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012$\u0010\t\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u00070\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0003H\u0014J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0014J\b\u0010 \u001a\u00020\u0003H\u0014J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002H\u0014J \u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0014J \u0010)\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0014J\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R/\u0010\t\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006,"}, d2={"Lcn/sast/dataflow/infoflow/svfa/FlowAssignment;", "Lsoot/toolkits/scalar/BackwardFlowAnalysis;", "Lsoot/Unit;", "Lcn/sast/dataflow/infoflow/svfa/FlowFact;", "graph", "Lsoot/toolkits/graph/DirectedGraph;", "paramAndThis", "", "Lsoot/Value;", "unit2locals", "", "Lsoot/jimple/Stmt;", "Lkotlin/Pair;", "Lcn/sast/dataflow/infoflow/svfa/AP;", "Lcn/sast/dataflow/infoflow/svfa/ValueLocation;", "<init>", "(Lsoot/toolkits/graph/DirectedGraph;Ljava/util/Set;Ljava/util/Map;)V", "getParamAndThis", "()Ljava/util/Set;", "getUnit2locals", "()Ljava/util/Map;", "omissible", "", "u", "flowThrough", "", "infact", "unit", "out", "copy", "source", "dest", "newInitialFlow", "getFlow", "Lsoot/toolkits/scalar/FlowAnalysis$Flow;", "from", "to", "mergeInto", "succNode", "inout", "in1", "merge", "in2", "getBefore", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nSparsePropgrateAnalyze.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparsePropgrateAnalyze.kt\ncn/sast/dataflow/infoflow/svfa/FlowAssignment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 extensions.kt\nkotlinx/collections/immutable/ExtensionsKt\n*L\n1#1,420:1\n1863#2:421\n1864#2:424\n1279#2,2:425\n1293#2,4:427\n327#3:422\n327#3:423\n362#3:431\n*S KotlinDebug\n*F\n+ 1 SparsePropgrateAnalyze.kt\ncn/sast/dataflow/infoflow/svfa/FlowAssignment\n*L\n173#1:421\n173#1:424\n187#1:425,2\n187#1:427,4\n178#1:422\n181#1:423\n187#1:431\n*E\n"})
final class FlowAssignment
extends BackwardFlowAnalysis<Unit, FlowFact> {
    @NotNull
    private final Set<Value> paramAndThis;
    @NotNull
    private final Map<Stmt, Set<Pair<AP, ValueLocation>>> unit2locals;

    public FlowAssignment(@NotNull DirectedGraph<Unit> graph, @NotNull Set<Value> paramAndThis, @NotNull Map<Stmt, ? extends Set<Pair<AP, ValueLocation>>> unit2locals) {
        Intrinsics.checkNotNullParameter(graph, (String)"graph");
        Intrinsics.checkNotNullParameter(paramAndThis, (String)"paramAndThis");
        Intrinsics.checkNotNullParameter(unit2locals, (String)"unit2locals");
        super(graph);
        this.paramAndThis = paramAndThis;
        this.unit2locals = unit2locals;
        this.doAnalysis();
    }

    @NotNull
    public final Set<Value> getParamAndThis() {
        return this.paramAndThis;
    }

    @NotNull
    public final Map<Stmt, Set<Pair<AP, ValueLocation>>> getUnit2locals() {
        return this.unit2locals;
    }

    protected boolean omissible(@NotNull Unit u) {
        Intrinsics.checkNotNullParameter((Object)u, (String)"u");
        return false;
    }

    /*
     * WARNING - void declaration
     */
    protected void flowThrough(@NotNull FlowFact infact, @NotNull Unit unit, @NotNull FlowFact out) {
        Object[] objectArray;
        ValueLocation loc;
        Iterable $this$forEach$iv;
        PersistentMap fact;
        Intrinsics.checkNotNullParameter((Object)infact, (String)"infact");
        Intrinsics.checkNotNullParameter((Object)unit, (String)"unit");
        Intrinsics.checkNotNullParameter((Object)out, (String)"out");
        this.copy(infact, out);
        if (!(unit instanceof Stmt)) {
            return;
        }
        Set locals = (Set)this.unit2locals.get(unit);
        if (locals != null) {
            fact = null;
            fact = out.getData();
            $this$forEach$iv = locals;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                PersistentMap $this$plus$iv;
                boolean $i$f$plus;
                VFNode[] pair$iv;
                Pair pair = (Pair)element$iv;
                boolean bl = false;
                AP ap = (AP)pair.component1();
                loc = (ValueLocation)pair.component2();
                if (SparsePropgrateAnalyzeKt.isLeft((ValueLocation)loc)) {
                    if (ap.getField() == null) {
                        fact = ExtensionsKt.minus((PersistentMap)fact, (Object)ap.getValue());
                        continue;
                    }
                    PersistentMap persistentMap = fact;
                    objectArray = new VFNode[]{new VFNode(ap.getValue(), unit)};
                    pair$iv = TuplesKt.to((Object)ap.getValue(), (Object)ExtensionsKt.persistentHashSetOf((Object[])objectArray));
                    $i$f$plus = false;
                    fact = $this$plus$iv.put(pair$iv.getFirst(), pair$iv.getSecond());
                    continue;
                }
                $this$plus$iv = fact;
                pair$iv = new VFNode[]{new VFNode(ap.getValue(), unit)};
                pair$iv = TuplesKt.to((Object)ap.getValue(), (Object)ExtensionsKt.persistentHashSetOf((Object[])pair$iv));
                $i$f$plus = false;
                fact = $this$plus$iv.put(pair$iv.getFirst(), pair$iv.getSecond());
            }
            out.setData(fact);
        }
        if (unit instanceof ReturnVoidStmt || unit instanceof ReturnStmt) {
            void $this$plus$iv;
            void $this$associateWith$iv;
            fact = out.getData();
            $this$forEach$iv = this.paramAndThis;
            FlowFact flowFact = out;
            boolean $i$f$associateWith = false;
            LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
            void $this$associateWithTo$iv$iv = $this$associateWith$iv;
            boolean $i$f$associateWithTo = false;
            for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
                void it;
                loc = (Value)element$iv$iv;
                Object t = element$iv$iv;
                Map map = result$iv;
                boolean bl = false;
                objectArray = new VFNode[]{new VFNode((Value)it, unit)};
                PersistentSet persistentSet = ExtensionsKt.persistentHashSetOf((Object[])objectArray);
                map.put(t, persistentSet);
            }
            Map map$iv = (Map)ExtensionsKt.toPersistentMap((Map)result$iv);
            boolean $i$f$plus = false;
            flowFact.setData(ExtensionsKt.putAll((PersistentMap)$this$plus$iv, (Map)map$iv));
        }
    }

    protected void copy(@NotNull FlowFact source, @NotNull FlowFact dest) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        if (dest != source) {
            dest.setData(source.getData());
        }
    }

    @NotNull
    protected FlowFact newInitialFlow() {
        return new FlowFact();
    }

    @NotNull
    protected FlowAnalysis.Flow getFlow(@NotNull Unit from, @NotNull Unit to) {
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        DirectedGraph directedGraph = this.graph;
        Intrinsics.checkNotNullExpressionValue((Object)directedGraph, (String)"graph");
        return FlowAnalysisOp.INSTANCE.getFlow(directedGraph, from, to);
    }

    protected void mergeInto(@NotNull Unit succNode, @NotNull FlowFact inout, @NotNull FlowFact in1) {
        Intrinsics.checkNotNullParameter((Object)succNode, (String)"succNode");
        Intrinsics.checkNotNullParameter((Object)inout, (String)"inout");
        Intrinsics.checkNotNullParameter((Object)in1, (String)"in1");
        FlowAnalysisOp.INSTANCE.mergeInto(succNode, inout, in1);
    }

    protected void merge(@NotNull FlowFact in1, @NotNull FlowFact in2, @NotNull FlowFact out) {
        Intrinsics.checkNotNullParameter((Object)in1, (String)"in1");
        Intrinsics.checkNotNullParameter((Object)in2, (String)"in2");
        Intrinsics.checkNotNullParameter((Object)out, (String)"out");
        throw new UnsupportedOperationException("FlowAssignment.merge should never be called");
    }

    @NotNull
    public final Map<Unit, FlowFact> getBefore() {
        Map map = this.unitToBeforeFlow;
        Intrinsics.checkNotNullExpressionValue((Object)map, (String)"unitToBeforeFlow");
        return map;
    }
}

