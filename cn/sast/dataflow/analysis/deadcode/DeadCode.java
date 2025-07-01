package cn.sast.dataflow.analysis.deadcode;

import cn.sast.dataflow.analysis.IBugReporter;
import cn.sast.dataflow.analysis.constant.ConstantValues;
import cn.sast.dataflow.interprocedural.check.PointsToGraphKt;
import cn.sast.framework.graph.PseudoTopologicalOrderer;
import com.feysh.corax.config.api.BugMessage;
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
import soot.Value;
import soot.jimple.IfStmt;
import soot.toolkits.graph.DirectedBodyGraph;

public final class DeadCode {

    @NotNull
    private final IBugReporter reporter;

    public DeadCode(@NotNull IBugReporter reporter) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.reporter = reporter;
    }

    public final void analyze(@NotNull DirectedBodyGraph<Unit> directedBodyGraph) {
        Intrinsics.checkNotNullParameter(directedBodyGraph, "graph");
        findDeadCode(directedBodyGraph);
        ConstantValues constantValues = new ConstantValues(directedBodyGraph);
        Body body = directedBodyGraph.getBody();
        Intrinsics.checkNotNullExpressionValue(body, "getBody(...)");
        findUnreachableBranch(body, constantValues);
    }

    private final void findDeadCode(DirectedBodyGraph<Unit> directedBodyGraph) {
    }

    private final void findUnreachableBranch(Body body, ConstantValues constantValues) {
        Unit succOf;
        Iterable units = body.getUnits();
        Intrinsics.checkNotNullExpressionValue(units, "getUnits(...)");
        Iterable $this$filterIsInstance$iv = units;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof IfStmt) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            Unit unit = (IfStmt) element$iv;
            Value condition = unit.getCondition();
            Intrinsics.checkNotNullExpressionValue(condition, "getCondition(...)");
            Integer valueAt = constantValues.getValueAt(condition, unit);
            if (valueAt != null && valueAt.intValue() == 1) {
                succOf = body.getUnits().getSuccOf(unit);
            } else {
                succOf = (valueAt != null && valueAt.intValue() == 0) ? (Unit) unit.getTarget() : null;
            }
            Unit unreachableBranch = succOf;
            if (unreachableBranch != null) {
                String guard = Intrinsics.areEqual(unreachableBranch, unit.getTarget()) ? unit.getCondition().toString() : "!(" + unit.getCondition() + ")";
                IBugReporter iBugReporter = this.reporter;
                DeadCodeChecker.UnreachableBranch unreachableBranch2 = DeadCodeChecker.UnreachableBranch.INSTANCE;
                SootClass declaringClass = body.getMethod().getDeclaringClass();
                Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
                iBugReporter.report(unreachableBranch2, declaringClass, unreachableBranch, (v2) -> {
                    return findUnreachableBranch$lambda$1$lambda$0(r4, r5, v2);
                });
            }
        }
    }

    private static final kotlin.Unit findUnreachableBranch$lambda$1$lambda$0(String $guard, Unit $unreachableBranch, BugMessage.Env $this$report) {
        Intrinsics.checkNotNullParameter($this$report, "$this$report");
        $this$report.getArgs().put("guard", $guard);
        $this$report.getArgs().put("target", $unreachableBranch);
        return kotlin.Unit.INSTANCE;
    }
}