package cn.sast.dataflow.interprocedural.check.printer;

import soot.SootClass;
import soot.SootMethodInterface;
import soot.SootMethodRef;
import soot.UnitPrinter;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.StaticInvokeExpr;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public final class GrimpInlineKt {
    public static void invokeToString(@NotNull InvokeExpr expr, @NotNull UnitPrinter up) {
        if (expr == null) throw new NullPointerException("expr is null");
        if (up == null) throw new NullPointerException("up is null");

        if (expr instanceof InstanceInvokeExpr) {
            ((InstanceInvokeExpr) expr).getBaseBox().toString(up);
            up.literal(".");
        }

        if (expr instanceof StaticInvokeExpr) {
            up.literal(((StaticInvokeExpr) expr).getMethodRef().getDeclaringClass().getShortName());
            up.literal(".");
        }

        SootMethodRef methodRef = expr.getMethodRef();
        SootMethodInterface method = methodRef;
        SootClass declaringClass = method.getDeclaringClass();
        String methodName = method.getName();

        up.literal(SimpleUnitPrinterKt.getPrettyMethodName(declaringClass, methodName));
        up.literal("(");

        List<Value> args = expr.getArgs();
        int argCount = args.size();
        for (int i = 0; i < argCount; ++i) {
            if (i != 0) {
                up.literal(", ");
            }
            args.get(i).toString(up);
        }

        up.literal(")");
    }
}