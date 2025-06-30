/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  soot.Unit
 *  soot.jimple.IdentityStmt
 *  soot.jimple.ParameterRef
 *  soot.jimple.ThisRef
 *  soot.util.Chain
 *  utils.BaseBodyGenerator
 *  utils.INewUnits
 *  utils.NewUnitsAtFirstImmediately
 */
package utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import soot.Unit;
import soot.jimple.IdentityStmt;
import soot.jimple.ParameterRef;
import soot.jimple.ThisRef;
import soot.util.Chain;
import utils.BaseBodyGenerator;
import utils.INewUnits;

/*
 * Exception performing whole class analysis ignored.
 */
public class NewUnitsAtFirstImmediately
implements INewUnits {
    BaseBodyGenerator bodyGenerator;
    private Unit afterUnit;

    public NewUnitsAtFirstImmediately(BaseBodyGenerator bodyGenerator) {
        this.bodyGenerator = bodyGenerator;
        this.afterUnit = NewUnitsAtFirstImmediately.getLastParamIdentityStmt((Chain)bodyGenerator.getUnits());
    }

    @Nullable
    public static Unit getLastParamIdentityStmt(Chain<Unit> units) {
        Unit afterUnit = null;
        if (!units.isEmpty()) {
            IdentityStmt identityStmt;
            Unit unit;
            Iterator iterator2 = units.iterator();
            while (iterator2.hasNext() && (unit = (Unit)iterator2.next()) instanceof IdentityStmt && ((identityStmt = (IdentityStmt)unit).getRightOp() instanceof ThisRef || identityStmt.getRightOp() instanceof ParameterRef)) {
                afterUnit = unit;
            }
        }
        return afterUnit;
    }

    public NewUnitsAtFirstImmediately addAll(List<Unit> units) {
        if (units.isEmpty()) {
            return this;
        }
        if (this.afterUnit == null) {
            this.bodyGenerator.addFirst(units);
        } else {
            this.bodyGenerator.insertAfter(units, this.afterUnit);
        }
        this.afterUnit = units.get(units.size() - 1);
        return this;
    }

    public NewUnitsAtFirstImmediately add(Unit unit) {
        return this.addAll(Collections.singletonList(unit));
    }
}

