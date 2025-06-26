/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.printer.GrimpInlineKt
 *  cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinterKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.SootClass
 *  soot.SootMethodInterface
 *  soot.SootMethodRef
 *  soot.UnitPrinter
 *  soot.Value
 *  soot.jimple.InstanceInvokeExpr
 *  soot.jimple.InvokeExpr
 *  soot.jimple.StaticInvokeExpr
 */
package cn.sast.dataflow.interprocedural.check.printer;

import cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootMethodInterface;
import soot.SootMethodRef;
import soot.UnitPrinter;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.StaticInvokeExpr;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2={"invokeToString", "", "Lsoot/jimple/InvokeExpr;", "up", "Lsoot/UnitPrinter;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nGrimpInline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrimpInline.kt\ncn/sast/dataflow/interprocedural/check/printer/GrimpInlineKt\n+ 2 SimpleUnitPrinter.kt\ncn/sast/dataflow/interprocedural/check/printer/SimpleUnitPrinterKt\n*L\n1#1,312:1\n17#2:313\n*S KotlinDebug\n*F\n+ 1 GrimpInline.kt\ncn/sast/dataflow/interprocedural/check/printer/GrimpInlineKt\n*L\n20#1:313\n*E\n"})
public final class GrimpInlineKt {
    public static final void invokeToString(@NotNull InvokeExpr $this$invokeToString, @NotNull UnitPrinter up) {
        Intrinsics.checkNotNullParameter((Object)$this$invokeToString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)up, (String)"up");
        if ($this$invokeToString instanceof InstanceInvokeExpr) {
            ((InstanceInvokeExpr)$this$invokeToString).getBaseBox().toString(up);
            up.literal(".");
        }
        if ($this$invokeToString instanceof StaticInvokeExpr) {
            up.literal(((StaticInvokeExpr)$this$invokeToString).getMethodRef().getDeclaringClass().getShortName());
            up.literal(".");
        }
        SootMethodRef sootMethodRef = $this$invokeToString.getMethodRef();
        Intrinsics.checkNotNullExpressionValue((Object)sootMethodRef, (String)"getMethodRef(...)");
        SootMethodInterface m$iv = (SootMethodInterface)sootMethodRef;
        boolean $i$f$getPrettyMethodName = false;
        SootClass sootClass = m$iv.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        String string = m$iv.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        up.literal(SimpleUnitPrinterKt.getPrettyMethodName((SootClass)sootClass, (String)string));
        up.literal("(");
        List args = $this$invokeToString.getArgs();
        int e = args.size();
        for (int i = 0; i < e; ++i) {
            if (i != 0) {
                up.literal(", ");
            }
            ((Value)args.get(i)).toString(up);
        }
        up.literal(")");
    }
}

