/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.analysis.IBugReporter
 *  cn.sast.dataflow.analysis.constant.ConstantValues
 *  cn.sast.dataflow.analysis.deadcode.DeadCode
 *  com.feysh.corax.config.api.BugMessage$Env
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.builtin.checkers.DeadCodeChecker$UnreachableBranch
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.Body
 *  soot.SootClass
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.Value
 *  soot.jimple.IfStmt
 *  soot.toolkits.graph.DirectedBodyGraph
 */
package cn.sast.dataflow.analysis.deadcode;

import cn.sast.dataflow.analysis.IBugReporter;
import cn.sast.dataflow.analysis.constant.ConstantValues;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.builtin.checkers.DeadCodeChecker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.Body;
import soot.SootClass;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.jimple.IfStmt;
import soot.toolkits.graph.DirectedBodyGraph;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u000b\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lcn/sast/dataflow/analysis/deadcode/DeadCode;", "", "reporter", "Lcn/sast/dataflow/analysis/IBugReporter;", "<init>", "(Lcn/sast/dataflow/analysis/IBugReporter;)V", "analyze", "", "graph", "Lsoot/toolkits/graph/DirectedBodyGraph;", "Lsoot/Unit;", "findDeadCode", "findUnreachableBranch", "body", "Lsoot/Body;", "constantValues", "Lcn/sast/dataflow/analysis/constant/ConstantValues;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nDeadCode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeadCode.kt\ncn/sast/dataflow/analysis/deadcode/DeadCode\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n808#2,11:41\n1863#2,2:52\n*S KotlinDebug\n*F\n+ 1 DeadCode.kt\ncn/sast/dataflow/analysis/deadcode/DeadCode\n*L\n24#1:41,11\n24#1:52,2\n*E\n"})
public final class DeadCode {
    @NotNull
    private final IBugReporter reporter;

    public DeadCode(@NotNull IBugReporter reporter) {
        Intrinsics.checkNotNullParameter((Object)reporter, (String)"reporter");
        this.reporter = reporter;
    }

    public final void analyze(@NotNull DirectedBodyGraph<Unit> graph) {
        Intrinsics.checkNotNullParameter(graph, (String)"graph");
        this.findDeadCode(graph);
        ConstantValues constantValues = new ConstantValues(graph);
        Body body = graph.getBody();
        Intrinsics.checkNotNullExpressionValue((Object)body, (String)"getBody(...)");
        this.findUnreachableBranch(body, constantValues);
    }

    private final void findDeadCode(DirectedBodyGraph<Unit> graph) {
    }

    /*
     * WARNING - void declaration
     */
    private final void findUnreachableBranch(Body body, ConstantValues constantValues) {
        void $this$filterIsInstanceTo$iv$iv;
        UnitPatchingChain unitPatchingChain = body.getUnits();
        Intrinsics.checkNotNullExpressionValue((Object)unitPatchingChain, (String)"getUnits(...)");
        Iterable $this$filterIsInstance$iv = (Iterable)unitPatchingChain;
        boolean $i$f$filterIsInstance = false;
        Iterable iterable = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof IfStmt)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Unit unreachableBranch;
            Unit unit;
            Object element$iv$iv;
            IfStmt it = (IfStmt)element$iv;
            boolean bl = false;
            Value value = it.getCondition();
            Intrinsics.checkNotNullExpressionValue((Object)value, (String)"getCondition(...)");
            Object t = element$iv$iv = constantValues.getValueAt(value, (Unit)it);
            int n = 1;
            if (t != null && (Integer)t == n) {
                unit = body.getUnits().getSuccOf((Unit)it);
            } else {
                Object t2 = element$iv$iv;
                unit = t2 != null && (Integer)t2 == 0 ? (Unit)it.getTarget() : null;
            }
            if ((unreachableBranch = unit) == null) continue;
            Object guard = Intrinsics.areEqual((Object)unreachableBranch, (Object)it.getTarget()) ? it.getCondition().toString() : "!(" + it.getCondition() + ")";
            CheckType checkType = (CheckType)DeadCodeChecker.UnreachableBranch.INSTANCE;
            SootClass sootClass = body.getMethod().getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
            this.reporter.report(checkType, sootClass, unreachableBranch, arg_0 -> DeadCode.findUnreachableBranch$lambda$1$lambda$0((String)guard, unreachableBranch, arg_0));
        }
    }

    private static final kotlin.Unit findUnreachableBranch$lambda$1$lambda$0(String $guard, Unit $unreachableBranch, BugMessage.Env $this$report) {
        Intrinsics.checkNotNullParameter((Object)$this$report, (String)"$this$report");
        $this$report.getArgs().put("guard", $guard);
        $this$report.getArgs().put("target", $unreachableBranch);
        return kotlin.Unit.INSTANCE;
    }
}

