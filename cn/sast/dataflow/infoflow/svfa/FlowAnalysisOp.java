/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.FlowAnalysisOp
 *  cn.sast.dataflow.infoflow.svfa.FlowFact
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentSet
 *  org.jetbrains.annotations.NotNull
 *  soot.IdentityUnit
 *  soot.Trap
 *  soot.Unit
 *  soot.Value
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.ExceptionalGraph
 *  soot.toolkits.graph.ExceptionalGraph$ExceptionDest
 *  soot.toolkits.scalar.FlowAnalysis$Flow
 */
package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.FlowFact;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import soot.IdentityUnit;
import soot.Trap;
import soot.Unit;
import soot.Value;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalGraph;
import soot.toolkits.scalar.FlowAnalysis;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ$\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007\u00a8\u0006\u0011"}, d2={"Lcn/sast/dataflow/infoflow/svfa/FlowAnalysisOp;", "", "<init>", "()V", "mergeInto", "", "succNode", "Lsoot/Unit;", "inout", "Lcn/sast/dataflow/infoflow/svfa/FlowFact;", "in1", "getFlow", "Lsoot/toolkits/scalar/FlowAnalysis$Flow;", "graph", "Lsoot/toolkits/graph/DirectedGraph;", "from", "to", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nSparsePropgrateAnalyze.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparsePropgrateAnalyze.kt\ncn/sast/dataflow/infoflow/svfa/FlowAnalysisOp\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,420:1\n1863#2,2:421\n1863#2,2:423\n*S KotlinDebug\n*F\n+ 1 SparsePropgrateAnalyze.kt\ncn/sast/dataflow/infoflow/svfa/FlowAnalysisOp\n*L\n130#1:421,2\n133#1:423,2\n*E\n"})
public final class FlowAnalysisOp {
    @NotNull
    public static final FlowAnalysisOp INSTANCE = new FlowAnalysisOp();

    private FlowAnalysisOp() {
    }

    public final void mergeInto(@NotNull Unit succNode, @NotNull FlowFact inout, @NotNull FlowFact in1) {
        Value it;
        Intrinsics.checkNotNullParameter((Object)succNode, (String)"succNode");
        Intrinsics.checkNotNullParameter((Object)inout, (String)"inout");
        Intrinsics.checkNotNullParameter((Object)in1, (String)"in1");
        Function1 fx = arg_0 -> FlowAnalysisOp.mergeInto$lambda$0(inout, in1, arg_0);
        Iterable $this$forEach$iv = inout.getData().keySet();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (Value)element$iv;
            boolean bl = false;
            fx.invoke((Object)it);
        }
        $this$forEach$iv = in1.getData().keySet();
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (Value)element$iv;
            boolean bl = false;
            fx.invoke((Object)it);
        }
    }

    @NotNull
    public final FlowAnalysis.Flow getFlow(@NotNull DirectedGraph<Unit> graph, @NotNull Unit from, @NotNull Unit to) {
        Intrinsics.checkNotNullParameter(graph, (String)"graph");
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        if (to instanceof IdentityUnit && graph instanceof ExceptionalGraph) {
            ExceptionalGraph g2 = (ExceptionalGraph)graph;
            List list = g2.getExceptionalPredsOf((Object)to);
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getExceptionalPredsOf(...)");
            if (!((Collection)list).isEmpty()) {
                for (ExceptionalGraph.ExceptionDest exd : g2.getExceptionDests((Object)from)) {
                    Trap trap = exd.getTrap();
                    if (trap == null || trap.getHandlerUnit() != to) continue;
                    return FlowAnalysis.Flow.IN;
                }
            }
        }
        return FlowAnalysis.Flow.OUT;
    }

    private static final kotlin.Unit mergeInto$lambda$0(FlowFact $inout, FlowFact $in1, Value k) {
        Intrinsics.checkNotNullParameter((Object)k, (String)"k");
        PersistentSet persistentSet = (PersistentSet)$inout.getData().get((Object)k);
        if (persistentSet == null) {
            persistentSet = ExtensionsKt.persistentHashSetOf();
        }
        PersistentSet u = persistentSet;
        PersistentSet persistentSet2 = (PersistentSet)$in1.getData().get((Object)k);
        PersistentSet set = ExtensionsKt.plus((PersistentSet)u, (Iterable)(persistentSet2 != null ? (Iterable)persistentSet2 : (Iterable)ExtensionsKt.persistentHashSetOf()));
        $inout.setData($inout.getData().put((Object)k, (Object)set));
        return kotlin.Unit.INSTANCE;
    }
}

