/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  cn.sast.idfa.analysis.SummaryControlFlowUnitGraph
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.Body
 *  soot.Local
 *  soot.LocalGenerator
 *  soot.RefType
 *  soot.Scene
 *  soot.SootMethod
 *  soot.SootMethodRef
 *  soot.Type
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.Value
 *  soot.jimple.AssignStmt
 *  soot.jimple.InvokeStmt
 *  soot.jimple.Jimple
 *  soot.jimple.JimpleBody
 *  soot.jimple.StringConstant
 *  soot.toolkits.graph.DirectedGraph
 *  soot.toolkits.graph.ExceptionalUnitGraphFactory
 *  soot.toolkits.graph.UnitGraph
 *  soot.util.Chain
 */
package cn.sast.idfa.analysis;

import cn.sast.idfa.analysis.InterproceduralCFG;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.Body;
import soot.Local;
import soot.LocalGenerator;
import soot.RefType;
import soot.Scene;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.StringConstant;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraphFactory;
import soot.toolkits.graph.UnitGraph;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0096\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010#\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006'"}, d2={"Lcn/sast/idfa/analysis/SummaryControlFlowUnitGraph;", "Lsoot/toolkits/graph/DirectedGraph;", "Lsoot/Unit;", "method", "Lsoot/SootMethod;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "<init>", "(Lsoot/SootMethod;Lcn/sast/idfa/analysis/InterproceduralCFG;)V", "getMethod", "()Lsoot/SootMethod;", "getIcfg", "()Lcn/sast/idfa/analysis/InterproceduralCFG;", "jimp", "Lsoot/jimple/Jimple;", "getJimp", "()Lsoot/jimple/Jimple;", "body", "Lsoot/jimple/JimpleBody;", "kotlin.jvm.PlatformType", "getBody", "()Lsoot/jimple/JimpleBody;", "Lsoot/jimple/JimpleBody;", "graph", "Lsoot/toolkits/graph/UnitGraph;", "getGraph", "()Lsoot/toolkits/graph/UnitGraph;", "setGraph", "(Lsoot/toolkits/graph/UnitGraph;)V", "iterator", "", "getHeads", "", "getTails", "getPredsOf", "s", "getSuccsOf", "size", "", "corax-idfa-framework"})
@SourceDebugExtension(value={"SMAP\nSummaryControlFlowUnitGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SummaryControlFlowUnitGraph.kt\ncn/sast/idfa/analysis/SummaryControlFlowUnitGraph\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,77:1\n1863#2,2:78\n*S KotlinDebug\n*F\n+ 1 SummaryControlFlowUnitGraph.kt\ncn/sast/idfa/analysis/SummaryControlFlowUnitGraph\n*L\n45#1:78,2\n*E\n"})
public class SummaryControlFlowUnitGraph
implements DirectedGraph<Unit> {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final InterproceduralCFG icfg;
    @NotNull
    private final Jimple jimp;
    private final JimpleBody body;
    @NotNull
    private UnitGraph graph;

    public SummaryControlFlowUnitGraph(@NotNull SootMethod method, @NotNull InterproceduralCFG icfg) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        this.method = method;
        this.icfg = icfg;
        Jimple jimple = Jimple.v();
        Intrinsics.checkNotNullExpressionValue((Object)jimple, (String)"v(...)");
        this.jimp = jimple;
        this.body = this.jimp.newBody(this.method);
        if (!(!this.method.hasActiveBody())) {
            boolean $i$a$-check-SummaryControlFlowUnitGraph$22 = false;
            String $i$a$-check-SummaryControlFlowUnitGraph$22 = this.method + " hasActiveBody";
            throw new IllegalStateException($i$a$-check-SummaryControlFlowUnitGraph$22.toString());
        }
        UnitPatchingChain units = this.body.getUnits();
        LocalGenerator lg = Scene.v().createLocalGenerator((Body)this.body);
        RefType runtimeExceptionType = RefType.v((String)"java.lang.Error");
        Local exceptionLocal = lg.generateLocal((Type)runtimeExceptionType);
        AssignStmt assignStmt = this.jimp.newAssignStmt((Value)exceptionLocal, (Value)this.jimp.newNewExpr(runtimeExceptionType));
        Intrinsics.checkNotNullExpressionValue((Object)assignStmt, (String)"newAssignStmt(...)");
        AssignStmt assignStmt2 = assignStmt;
        units.add((Unit)assignStmt2);
        SootMethodRef cref = runtimeExceptionType.getSootClass().getMethod("<init>", CollectionsKt.listOf((Object)RefType.v((String)"java.lang.String"))).makeRef();
        InvokeStmt invokeStmt = this.jimp.newInvokeStmt((Value)this.jimp.newSpecialInvokeExpr(exceptionLocal, cref, (Value)StringConstant.v((String)"phantom method body")));
        Intrinsics.checkNotNullExpressionValue((Object)invokeStmt, (String)"newInvokeStmt(...)");
        InvokeStmt initStmt = invokeStmt;
        units.insertAfter((Unit)initStmt, (Unit)assignStmt2);
        units.insertAfter((Unit)this.jimp.newThrowStmt((Value)exceptionLocal), (Unit)initStmt);
        Chain chain = units.getNonPatchingChain();
        Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getNonPatchingChain(...)");
        Iterable $this$forEach$iv = (Iterable)chain;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Unit it = (Unit)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            this.icfg.setOwnerStatement(it, this.method);
        }
        this.graph = (UnitGraph)ExceptionalUnitGraphFactory.createExceptionalUnitGraph((Body)((Body)this.body));
    }

    @NotNull
    public final SootMethod getMethod() {
        return this.method;
    }

    @NotNull
    public final InterproceduralCFG getIcfg() {
        return this.icfg;
    }

    @NotNull
    public final Jimple getJimp() {
        return this.jimp;
    }

    public final JimpleBody getBody() {
        return this.body;
    }

    @NotNull
    public final UnitGraph getGraph() {
        return this.graph;
    }

    public final void setGraph(@NotNull UnitGraph unitGraph) {
        Intrinsics.checkNotNullParameter((Object)unitGraph, (String)"<set-?>");
        this.graph = unitGraph;
    }

    @NotNull
    public Iterator<Unit> iterator() {
        Iterator iterator2 = this.graph.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        return iterator2;
    }

    @NotNull
    public List<Unit> getHeads() {
        List list = this.graph.getHeads();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getHeads(...)");
        return list;
    }

    @NotNull
    public List<Unit> getTails() {
        List list = this.graph.getTails();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getTails(...)");
        return list;
    }

    @NotNull
    public List<Unit> getPredsOf(@NotNull Unit s) {
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        List list = this.graph.getPredsOf(s);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getPredsOf(...)");
        return list;
    }

    @NotNull
    public List<Unit> getSuccsOf(@NotNull Unit s) {
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        List list = this.graph.getSuccsOf(s);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getSuccsOf(...)");
        return list;
    }

    public int size() {
        return this.graph.size();
    }
}

