package cn.sast.dataflow.interprocedural.check.printer;

import org.jetbrains.annotations.NotNull;
import soot.Unit;
import soot.UnitBox;
import soot.Value;
import soot.grimp.Grimp;
import soot.grimp.internal.ExprBox;
import soot.jimple.ArrayRef;
import soot.jimple.Expr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.IntConstant;
import soot.jimple.Stmt;
import soot.tagkit.Tag;
import soot.util.Switch;

public class GrimpInline extends Grimp {

    public GrimpInline() {
        super(null);
    }

    @NotNull
    public Value newExpr(@NotNull Value value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }

        if (value instanceof Expr) {
            ExprBox returnedExpr = new ExprBox(IntConstant.v(0));
            value.apply(new Switch() {
                @Override
                public void caseExpr(Expr expr) {
                    returnedExpr.setValue(expr);
                }
            });
            return returnedExpr.getValue();
        }

        if (value instanceof ArrayRef) {
            ArrayRef arrayRef = (ArrayRef) value;
            Value base = arrayRef.getBase();
            Value index = arrayRef.getIndex();
            return newArrayRef(base, newExpr(index));
        }

        if (value instanceof InstanceFieldRef) {
            InstanceFieldRef fieldRef = (InstanceFieldRef) value;
            Value base = fieldRef.getBase();
            return newInstanceFieldRef(newExpr(base), fieldRef.getFieldRef());
        }

        return value;
    }

    @NotNull
    public Unit inline(@NotNull Unit u) {
        if (u == null) {
            throw new IllegalArgumentException("u cannot be null");
        }

        UnitBox newStmtBox = newStmtBox(null);
        u.apply(new Switch() {
            @Override
            public void caseStmt(Stmt stmt) {
                newStmtBox.setUnit(stmt);
            }
        });

        Stmt newStmt = (Stmt) newStmtBox.getUnit();
        if (newStmt == null) {
            throw new IllegalStateException("Generated statement cannot be null");
        }

        Tag lnTag = u.getTag("LineNumberTag");
        if (lnTag != null) {
            newStmt.addTag(lnTag);
        }

        Tag slpTag = u.getTag("SourceLnPosTag");
        if (slpTag != null) {
            newStmt.addTag(slpTag);
        }

        return newStmt;
    }
}