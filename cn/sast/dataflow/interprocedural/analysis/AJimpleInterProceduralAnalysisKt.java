/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AJimpleInterProceduralAnalysisKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Body
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.IdentityStmt
 *  soot.jimple.ParameterRef
 *  soot.jimple.ThisRef
 */
package cn.sast.dataflow.interprocedural.analysis;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.Unit;
import soot.Value;
import soot.jimple.IdentityStmt;
import soot.jimple.ParameterRef;
import soot.jimple.ThisRef;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2={"getParameterUnit", "Lsoot/Unit;", "Lsoot/Body;", "i", "", "corax-data-flow"})
public final class AJimpleInterProceduralAnalysisKt {
    @Nullable
    public static final Unit getParameterUnit(@NotNull Body $this$getParameterUnit, int i) {
        Intrinsics.checkNotNullParameter((Object)$this$getParameterUnit, (String)"<this>");
        Iterator iterator2 = $this$getParameterUnit.getUnits().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            Value rightOp;
            Unit s = (Unit)iterator3.next();
            if (!(s instanceof IdentityStmt) || !((rightOp = ((IdentityStmt)s).getRightOp()) instanceof ParameterRef ? ((ParameterRef)rightOp).getIndex() == i : rightOp instanceof ThisRef && -1 == i)) continue;
            return s;
        }
        return null;
    }
}

