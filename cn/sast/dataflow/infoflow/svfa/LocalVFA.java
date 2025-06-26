/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.AP
 *  cn.sast.dataflow.infoflow.svfa.BackAssignment
 *  cn.sast.dataflow.infoflow.svfa.FlowAssignment
 *  cn.sast.dataflow.infoflow.svfa.FlowFact
 *  cn.sast.dataflow.infoflow.svfa.ILocalDFA
 *  cn.sast.dataflow.infoflow.svfa.LocalVFA
 *  cn.sast.dataflow.infoflow.svfa.LocalVFA$Companion
 *  cn.sast.dataflow.infoflow.svfa.VFNode
 *  cn.sast.dataflow.infoflow.svfa.ValueLocation
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentSet
 *  org.jetbrains.annotations.NotNull
 *  soot.NullType
 *  soot.Timers
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.ArrayRef
 *  soot.jimple.AssignStmt
 *  soot.jimple.BinopExpr
 *  soot.jimple.Expr
 *  soot.jimple.IdentityStmt
 *  soot.jimple.IfStmt
 *  soot.jimple.InstanceInvokeExpr
 *  soot.jimple.InvokeExpr
 *  soot.jimple.InvokeStmt
 *  soot.jimple.ParameterRef
 *  soot.jimple.ReturnStmt
 *  soot.jimple.ReturnVoidStmt
 *  soot.jimple.Stmt
 *  soot.jimple.ThisRef
 *  soot.jimple.infoflow.util.BaseSelector
 *  soot.jimple.internal.JimpleLocal
 *  soot.options.Options
 *  soot.toolkits.graph.DirectedGraph
 */
package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.AP;
import cn.sast.dataflow.infoflow.svfa.BackAssignment;
import cn.sast.dataflow.infoflow.svfa.FlowAssignment;
import cn.sast.dataflow.infoflow.svfa.FlowFact;
import cn.sast.dataflow.infoflow.svfa.ILocalDFA;
import cn.sast.dataflow.infoflow.svfa.LocalVFA;
import cn.sast.dataflow.infoflow.svfa.VFNode;
import cn.sast.dataflow.infoflow.svfa.ValueLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import soot.NullType;
import soot.Timers;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.ArrayRef;
import soot.jimple.AssignStmt;
import soot.jimple.BinopExpr;
import soot.jimple.Expr;
import soot.jimple.IdentityStmt;
import soot.jimple.IfStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.ParameterRef;
import soot.jimple.ReturnStmt;
import soot.jimple.ReturnVoidStmt;
import soot.jimple.Stmt;
import soot.jimple.ThisRef;
import soot.jimple.infoflow.util.BaseSelector;
import soot.jimple.internal.JimpleLocal;
import soot.options.Options;
import soot.toolkits.graph.DirectedGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\u00020\u000eH\u0002JN\u0010\u000f\u001a\u00020\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0010\u001a\u00020\u001126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\r0\u0013H\u0002J:\u0010\u001a\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lcn/sast/dataflow/infoflow/svfa/LocalVFA;", "Lcn/sast/dataflow/infoflow/svfa/ILocalDFA;", "graph", "Lsoot/toolkits/graph/DirectedGraph;", "Lsoot/Unit;", "trackControlFlowDependencies", "", "<init>", "(Lsoot/toolkits/graph/DirectedGraph;Z)V", "getTrackControlFlowDependencies", "()Z", "traverse", "", "R", "Lsoot/jimple/Expr;", "collectStmtInfo", "stmt", "Lsoot/jimple/Stmt;", "addValueToInfoMap", "Lkotlin/Function2;", "Lsoot/Value;", "Lkotlin/ParameterName;", "name", "v", "Lcn/sast/dataflow/infoflow/svfa/ValueLocation;", "loc", "init", "Lkotlin/Pair;", "", "Lcn/sast/dataflow/infoflow/svfa/FlowFact;", "getDefUsesOfAt", "", "ap", "Lcn/sast/dataflow/infoflow/svfa/AP;", "getUsesOfAt", "uses", "defuses", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nSparsePropgrateAnalyze.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparsePropgrateAnalyze.kt\ncn/sast/dataflow/infoflow/svfa/LocalVFA\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,420:1\n13409#2,2:421\n808#3,11:423\n1279#3,2:434\n1293#3,4:436\n1557#3:440\n1628#3,3:441\n1557#3:444\n1628#3,3:445\n*S KotlinDebug\n*F\n+ 1 SparsePropgrateAnalyze.kt\ncn/sast/dataflow/infoflow/svfa/LocalVFA\n*L\n313#1:421,2\n372#1:423,11\n372#1:434,2\n372#1:436,4\n392#1:440\n392#1:441,3\n398#1:444\n398#1:445,3\n*E\n"})
public final class LocalVFA
implements ILocalDFA {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean trackControlFlowDependencies;
    @NotNull
    private final Map<Unit, FlowFact> uses;
    @NotNull
    private final Map<Unit, FlowFact> defuses;
    @NotNull
    private static final Value returnVoidFake = (Value)new JimpleLocal("returnVoidFake", (Type)NullType.v());
    @NotNull
    private static final Value entryFake = (Value)new JimpleLocal("entryFake", (Type)NullType.v());

    public LocalVFA(@NotNull DirectedGraph<Unit> graph, boolean trackControlFlowDependencies) {
        Intrinsics.checkNotNullParameter(graph, (String)"graph");
        this.trackControlFlowDependencies = trackControlFlowDependencies;
        boolean time = Options.v().time();
        if (time) {
            Timers.v().defsTimer.start();
        }
        Pair pair = this.init(graph);
        Map uses = (Map)pair.component1();
        Map defuses = (Map)pair.component2();
        this.uses = uses;
        this.defuses = defuses;
        if (time) {
            Timers.v().defsTimer.end();
        }
    }

    public final boolean getTrackControlFlowDependencies() {
        return this.trackControlFlowDependencies;
    }

    private final <R> void traverse(Expr $this$traverse) {
    }

    private final <R> void collectStmtInfo(Stmt stmt, Function2<? super Value, ? super ValueLocation, ? extends R> addValueToInfoMap) {
        InvokeExpr ie;
        Stmt stmt2 = stmt;
        if (stmt2 instanceof AssignStmt) {
            left = ((AssignStmt)stmt).getLeftOp();
            Value right = ((AssignStmt)stmt).getRightOp();
            Value[] rightValues = BaseSelector.selectBaseList((Value)right, (boolean)true);
            if (left instanceof ArrayRef) {
                Value value = ((ArrayRef)left).getBase();
                Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getBase(...)");
                v1 = addValueToInfoMap.invoke((Object)value, (Object)ValueLocation.Right);
            } else {
                Intrinsics.checkNotNull((Object)left);
                v1 = addValueToInfoMap.invoke((Object)left, (Object)ValueLocation.Left);
            }
            Intrinsics.checkNotNull((Object)rightValues);
            Value[] $this$forEach$iv = rightValues;
            boolean $i$f$forEach = false;
            int n = $this$forEach$iv.length;
            for (int i = 0; i < n; ++i) {
                Value element$iv;
                Value it = element$iv = $this$forEach$iv[i];
                boolean bl = false;
                Intrinsics.checkNotNull((Object)it);
                addValueToInfoMap.invoke((Object)it, (Object)ValueLocation.Right);
            }
        } else if (stmt2 instanceof IdentityStmt) {
            left = ((IdentityStmt)stmt).getRightOp();
            if (left instanceof ParameterRef) {
                Value value = ((IdentityStmt)stmt).getLeftOp();
                Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getLeftOp(...)");
                addValueToInfoMap.invoke((Object)value, (Object)ValueLocation.ParamAndThis);
            } else if (left instanceof ThisRef) {
                Value value = ((IdentityStmt)stmt).getLeftOp();
                Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getLeftOp(...)");
                addValueToInfoMap.invoke((Object)value, (Object)ValueLocation.ParamAndThis);
            }
        } else if (!(stmt2 instanceof InvokeStmt)) {
            if (stmt2 instanceof IfStmt) {
                if (this.trackControlFlowDependencies) {
                    Value value = ((IfStmt)stmt).getCondition();
                    Intrinsics.checkNotNull((Object)value, (String)"null cannot be cast to non-null type soot.jimple.BinopExpr");
                    BinopExpr cond = (BinopExpr)value;
                    Value value2 = cond.getOp1();
                    Intrinsics.checkNotNullExpressionValue((Object)value2, (String)"getOp1(...)");
                    addValueToInfoMap.invoke((Object)value2, (Object)ValueLocation.Right);
                    Value value3 = cond.getOp2();
                    Intrinsics.checkNotNullExpressionValue((Object)value3, (String)"getOp2(...)");
                    addValueToInfoMap.invoke((Object)value3, (Object)ValueLocation.Right);
                }
                return;
            }
            if (stmt2 instanceof ReturnStmt) {
                Value value = ((ReturnStmt)stmt).getOp();
                Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getOp(...)");
                addValueToInfoMap.invoke((Object)value, (Object)ValueLocation.Right);
                return;
            }
            if (stmt2 instanceof ReturnVoidStmt) {
                addValueToInfoMap.invoke((Object)returnVoidFake, (Object)ValueLocation.Right);
                return;
            }
        }
        InvokeExpr invokeExpr = ie = stmt.containsInvokeExpr() ? stmt.getInvokeExpr() : null;
        if (ie != null) {
            if (ie instanceof InstanceInvokeExpr) {
                Value value = ((InstanceInvokeExpr)ie).getBase();
                Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getBase(...)");
                addValueToInfoMap.invoke((Object)value, (Object)ValueLocation.Arg);
            }
            int n = ie.getArgCount();
            for (int i = 0; i < n; ++i) {
                Value value = ie.getArg(i);
                Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getArg(...)");
                addValueToInfoMap.invoke((Object)value, (Object)ValueLocation.Arg);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<Map<Unit, FlowFact>, Map<Unit, FlowFact>> init(DirectedGraph<Unit> graph) {
        void $this$associateWith$iv;
        void $this$filterIsInstanceTo$iv$iv;
        Set paramAndThis = new LinkedHashSet();
        Iterable $this$filterIsInstance$iv = (Iterable)graph;
        boolean $i$f$filterIsInstance = false;
        Iterable iterable = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof Stmt)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filterIsInstance$iv = (List)destination$iv$iv;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        void $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
            void stmt;
            Stmt stmt2 = (Stmt)element$iv$iv;
            Object t = element$iv$iv;
            Map map = result$iv;
            boolean bl = false;
            Set apAndLoc = new LinkedHashSet();
            this.collectStmtInfo((Stmt)stmt, (arg_0, arg_1) -> LocalVFA.init$lambda$2$lambda$1(paramAndThis, apAndLoc, arg_0, arg_1));
            Set set = apAndLoc;
            map.put(t, set);
        }
        Map unit2locals = result$iv;
        return TuplesKt.to((Object)new FlowAssignment(graph, paramAndThis, unit2locals).getBefore(), (Object)new BackAssignment(graph, paramAndThis, unit2locals).getAfter());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<Unit> getDefUsesOfAt(@NotNull AP ap, @NotNull Unit stmt) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)ap, (String)"ap");
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        FlowFact flowFact = (FlowFact)this.defuses.get(stmt);
        if (flowFact == null) {
            return CollectionsKt.emptyList();
        }
        FlowFact fact = flowFact;
        PersistentSet persistentSet = (PersistentSet)fact.getData().get((Object)ap.getValue());
        if (persistentSet == null) {
            persistentSet = ExtensionsKt.persistentHashSetOf();
        }
        PersistentSet use = persistentSet;
        Iterable $this$map$iv = (Iterable)use;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            VFNode vFNode = (VFNode)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getStmt());
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<Unit> getUsesOfAt(@NotNull AP ap, @NotNull Unit stmt) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)ap, (String)"ap");
        Intrinsics.checkNotNullParameter((Object)stmt, (String)"stmt");
        FlowFact flowFact = (FlowFact)this.uses.get(stmt);
        if (flowFact == null) {
            return CollectionsKt.emptyList();
        }
        FlowFact fact = flowFact;
        PersistentSet persistentSet = (PersistentSet)fact.getData().get((Object)ap.getValue());
        if (persistentSet == null) {
            persistentSet = ExtensionsKt.persistentHashSetOf();
        }
        PersistentSet use = persistentSet;
        Iterable $this$map$iv = (Iterable)use;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            VFNode vFNode = (VFNode)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getStmt());
        }
        return (List)destination$iv$iv;
    }

    private static final kotlin.Unit init$lambda$2$lambda$1(Set $paramAndThis, Set $apAndLoc, Value value, ValueLocation valueLocation) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Intrinsics.checkNotNullParameter((Object)valueLocation, (String)"valueLocation");
        AP ap = AP.Companion.get(value);
        if (ap != null) {
            if (valueLocation == ValueLocation.ParamAndThis) {
                $paramAndThis.add(ap.getValue());
            }
            $apAndLoc.add(TuplesKt.to((Object)ap, (Object)valueLocation));
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final /* synthetic */ Value access$getReturnVoidFake$cp() {
        return returnVoidFake;
    }

    public static final /* synthetic */ Value access$getEntryFake$cp() {
        return entryFake;
    }
}

