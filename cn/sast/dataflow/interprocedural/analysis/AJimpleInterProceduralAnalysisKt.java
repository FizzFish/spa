package cn.sast.dataflow.interprocedural.analysis;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.Unit;
import soot.Value;
import soot.jimple.IdentityStmt;
import soot.jimple.ParameterRef;
import soot.jimple.ThisRef;

public final class AJimpleInterProceduralAnalysisKt {

    @Nullable
    public static Unit getParameterUnit(@NotNull Body body, int index) {
        if (body == null) {
            throw new NullPointerException("body cannot be null");
        }

        Iterator<Unit> iterator = body.getUnits().iterator();
        while (iterator.hasNext()) {
            Unit unit = iterator.next();
            if (!(unit instanceof IdentityStmt)) {
                continue;
            }

            Value rightOp = ((IdentityStmt) unit).getRightOp();
            if (rightOp instanceof ParameterRef) {
                if (((ParameterRef) rightOp).getIndex() == index) {
                    return unit;
                }
            } else if (rightOp instanceof ThisRef && index == -1) {
                return unit;
            }
        }
        return null;
    }
}