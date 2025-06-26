/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.check.printer.GrimpInline
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Unit
 *  soot.UnitBox
 *  soot.Value
 *  soot.grimp.Grimp
 *  soot.grimp.internal.ExprBox
 *  soot.jimple.ArrayRef
 *  soot.jimple.Expr
 *  soot.jimple.InstanceFieldRef
 *  soot.jimple.IntConstant
 *  soot.jimple.Stmt
 *  soot.tagkit.Tag
 *  soot.util.Switch
 */
package cn.sast.dataflow.interprocedural.check.printer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\n"}, d2={"Lcn/sast/dataflow/interprocedural/check/printer/GrimpInline;", "Lsoot/grimp/Grimp;", "<init>", "()V", "newExpr", "Lsoot/Value;", "value", "inline", "Lsoot/Unit;", "u", "corax-data-flow"})
public class GrimpInline
extends Grimp {
    public GrimpInline() {
        super(null);
    }

    @NotNull
    public Value newExpr(@NotNull Value value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        if (value instanceof Expr) {
            ExprBox returnedExpr = new ExprBox((Value)IntConstant.v((int)0));
            value.apply((Switch)new /* Unavailable Anonymous Inner Class!! */);
            Value value2 = returnedExpr.getValue();
            Intrinsics.checkNotNullExpressionValue((Object)value2, (String)"getValue(...)");
            return value2;
        }
        if (value instanceof ArrayRef) {
            Value value3 = ((ArrayRef)value).getBase();
            Value value4 = ((ArrayRef)value).getIndex();
            Intrinsics.checkNotNullExpressionValue((Object)value4, (String)"getIndex(...)");
            ArrayRef arrayRef = this.newArrayRef(value3, this.newExpr(value4));
            Intrinsics.checkNotNullExpressionValue((Object)arrayRef, (String)"newArrayRef(...)");
            return (Value)arrayRef;
        }
        if (value instanceof InstanceFieldRef) {
            Value value5 = ((InstanceFieldRef)value).getBase();
            Intrinsics.checkNotNullExpressionValue((Object)value5, (String)"getBase(...)");
            InstanceFieldRef instanceFieldRef = this.newInstanceFieldRef(this.newExpr(value5), ((InstanceFieldRef)value).getFieldRef());
            Intrinsics.checkNotNullExpressionValue((Object)instanceFieldRef, (String)"newInstanceFieldRef(...)");
            return (Value)instanceFieldRef;
        }
        return value;
    }

    @NotNull
    public final Unit inline(@NotNull Unit u) {
        Tag slpTag;
        Intrinsics.checkNotNullParameter((Object)u, (String)"u");
        GrimpInline grimp = this;
        Unit oldStmt = u;
        UnitBox newStmtBox = grimp.newStmtBox(null);
        oldStmt.apply((Switch)new /* Unavailable Anonymous Inner Class!! */);
        Unit unit = newStmtBox.getUnit();
        Intrinsics.checkNotNull((Object)unit, (String)"null cannot be cast to non-null type soot.jimple.Stmt");
        Stmt newStmt = (Stmt)unit;
        Tag lnTag = oldStmt.getTag("LineNumberTag");
        if (lnTag != null) {
            newStmt.addTag(lnTag);
        }
        if ((slpTag = oldStmt.getTag("SourceLnPosTag")) != null) {
            newStmt.addTag(slpTag);
        }
        return (Unit)newStmt;
    }
}

