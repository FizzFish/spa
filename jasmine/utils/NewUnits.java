/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  soot.Unit
 *  soot.Value
 *  utils.INewUnits
 *  utils.NewUnits
 *  utils.NewUnits$BeforeRhs
 *  utils.NewUnits$BeforeUnit
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import soot.Unit;
import soot.Value;
import utils.INewUnits;
import utils.NewUnits;

public class NewUnits
implements INewUnits {
    private final List<Unit> units = new ArrayList();

    private NewUnits() {
    }

    public static NewUnits alloc() {
        return new NewUnits();
    }

    public List<Unit> getUnits() {
        return this.units;
    }

    public NewUnits addAll(List<Unit> units) {
        this.units.addAll(units);
        return this;
    }

    public NewUnits addAll(NewUnits units) {
        this.units.addAll(units.units);
        return this;
    }

    public NewUnits add(Unit unit) {
        this.units.add(unit);
        return this;
    }

    public BeforeUnit before(Unit unit) {
        return new BeforeUnit(this, unit);
    }

    public BeforeRhs before(Value rhs) {
        return new BeforeRhs(this, rhs);
    }
}

